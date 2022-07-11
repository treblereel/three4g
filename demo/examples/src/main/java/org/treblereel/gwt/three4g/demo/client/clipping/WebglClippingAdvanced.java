package org.treblereel.gwt.three4g.demo.client.clipping;

import elemental2.core.JsArray;
import elemental2.core.JsMath;
import elemental2.core.JsObject;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_clipping_advanced")
public class WebglClippingAdvanced implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private PerspectiveCamera camera;
    private Scene scene;
    private Mesh mesh;
    private WebGLRenderer renderer;

    private Stats stats;

    private boolean run;

    private double startTime;

    private boolean ready;

    private MeshPhongMaterial clipMaterial;

    private Vector3[] Vertices = new Vector3[] {
            new Vector3( + 1, 0, + JsMath.SQRT1_2),
            new Vector3( - 1, 0, + JsMath.SQRT1_2),
            new Vector3( 0, + 1, - JsMath.SQRT1_2),
            new Vector3( 0, - 1, - JsMath.SQRT1_2),
    };

    private int[] Indices = new int[] {0, 1, 2,	   0, 2, 3,  	0, 3, 1,	1, 3, 2};

    private Plane[] Planes = planesFromMesh( Vertices, Indices );


    JsArray.MapCallbackFn<Matrix4, Plane> func = (plane, p1, p2) -> {
        Vector3 xAxis = new Vector3(),
                yAxis = new Vector3(),
                trans = new Vector3();

        Vector3 zAxis = plane.normal;
        Matrix4 matrix = new Matrix4();

        // Hughes & Moeller '99
        // "Building an Orthonormal Basis from a Unit Vector."

        if ( Math.abs( zAxis.x ) > Math.abs( zAxis.z ) ) {

            yAxis.set( - zAxis.y, zAxis.x, 0 );

        } else {

            yAxis.set( 0, - zAxis.z, zAxis.y );

        }

        xAxis.crossVectors( yAxis.normalize(), zAxis );

        plane.coplanarPoint( trans );
        return matrix.set(
                xAxis.x, yAxis.x, zAxis.x, trans.x,
                xAxis.y, yAxis.y, zAxis.y, trans.y,
                xAxis.z, yAxis.z, zAxis.z, trans.z,
                0,	 0, 0, 1 );
    };

    private JsArray<Matrix4> PlaneMatrices = JsArray.asJsArray(Planes).map(func);

    private Plane[] GlobalClippingPlanes = cylindricalPlanes( 5, 2.5 );

    private Plane[] globalClippingPlanes;

    private Group object, volumeVisualization;

    private GUI gui;

    @PostConstruct
    public void init(){
        camera = new PerspectiveCamera(
                36, DomGlobal.window.innerWidth/ DomGlobal.window.innerHeight, 0.25, 16 );

        camera.position.set( 0, 1.5, 3 );



        scene = new Scene();

        // Lights

        scene.add( new AmbientLight( 0xffffff, 0.3 ) );

        SpotLight spotLight = new SpotLight( 0xffffff, 0.5 );
        spotLight.angle = Math.PI / 5;
        spotLight.penumbra = 0.2;
        spotLight.position.set( 2, 3, 3 );
        spotLight.castShadow = true;
        spotLight.shadow.camera.near = 3;
        spotLight.shadow.camera.far = 10;
        spotLight.shadow.mapSize.width = 1024;
        spotLight.shadow.mapSize.height = 1024;
        scene.add( spotLight );

        DirectionalLight dirLight = new DirectionalLight( 0xffffff, 0.5 );
        dirLight.position.set( 0, 2, 0 );
        dirLight.castShadow = true;
        dirLight.shadow.camera.near = 1;
        dirLight.shadow.camera.far = 10;

        dirLight.shadow.camera.right = 1;
        dirLight.shadow.camera.left = - 1;
        dirLight.shadow.camera.top	= 1;
        dirLight.shadow.camera.bottom = - 1;

        dirLight.shadow.mapSize.width = 1024;
        dirLight.shadow.mapSize.height = 1024;
        scene.add( dirLight );

        // Geometry

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setColor(0xee0a10);
        meshPhongMaterialParameters.setShininess(100);
        meshPhongMaterialParameters.setSide(THREE.DoubleSide);
        meshPhongMaterialParameters.setClippingPlanes(createPlanes(Planes.length));
        meshPhongMaterialParameters.setClipShadows(true);

        clipMaterial = new MeshPhongMaterial(meshPhongMaterialParameters);

        object = new Group();

        BoxGeometry geometry = new BoxGeometry( 0.18, 0.18, 0.18 );

        for ( int z = - 2; z <= 2; ++ z )
            for ( int y = - 2; y <= 2; ++ y )
                for ( int x = - 2; x <= 2; ++ x ) {

                    Mesh mesh = new Mesh( geometry, clipMaterial );
                    mesh.position.set( (double) x / 5, (double) y / 5, (double) z / 5 );
                    mesh.castShadow = true;
                    object.add( mesh );

                }

        scene.add( object );


        PlaneGeometry planeGeometry = new PlaneGeometry( 3, 3, 1, 1 );

        Color color = new Color();

        volumeVisualization = new Group();
        volumeVisualization.visible = false;

        for ( int i = 0, n = Planes.length; i != n; ++ i ) {
            MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
            meshBasicMaterialParameters.setColor(color.setHSL( i / n, 0.5, 0.5 ).getHex());
            meshBasicMaterialParameters.setSide(THREE.DoubleSide);
            meshBasicMaterialParameters.setOpacity(0.2);
            meshBasicMaterialParameters.setTransparent(true);

            int _i = i;
            // no need to enable shadow clipping - the plane
            // visualization does not cast shadows
            meshBasicMaterialParameters.setClippingPlanes(JsArray.asJsArray(clipMaterial.clippingPlanes).filter((Plane p0, int j, JsArray<Plane> p2) -> _i != j));

            MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

            Mesh mesh = new Mesh( planeGeometry, material );
            mesh.matrixAutoUpdate = false;

            volumeVisualization.add( mesh );

        }

        scene.add( volumeVisualization );

        MeshPhongMaterialParameters meshPhongMaterialParameters1 = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters1.setColor(0xa0adaf);
        meshPhongMaterialParameters1.setShininess(10);

        Mesh ground = new Mesh( planeGeometry,
                new MeshPhongMaterial(meshPhongMaterialParameters1));
        ground.rotation.x = - Math.PI / 2;
        ground.scale.multiplyScalar( 3 );
        ground.receiveShadow = true;
        scene.add( ground );

        // Renderer

        renderer = new WebGLRenderer();
        renderer.shadowMap.enabled = true;
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

        root.appendChild( renderer.domElement );
        // Clipping setup:
        globalClippingPlanes = createPlanes( GlobalClippingPlanes.length );

        JsArray<JsObject> Empty = JsObject.freeze(new JsArray<>());

        renderer.clippingPlanes = Js.uncheckedCast(Empty);
        renderer.localClippingEnabled = true;

        // Stats

        stats = new Stats();
        root.appendChild( stats.dom );

        // Controls

        OrbitControls controls = new OrbitControls( camera, renderer.domElement );
        controls.minDistance = 1;
        controls.maxDistance = 8;
        controls.target.set( 0, 1, 0 );
        controls.update();

        JsPropertyMap props = JsPropertyMap.of();
        props.set("Enabled", true);


        props.set("Shadows", true);
        props.set("Visualize", false);

        JsPropertyMap propsGlobal = JsPropertyMap.of();

        propsGlobal.set("Enabled", false);


        gui = new GUI();
        GUI folderLocal = gui.addFolder( "Local Clipping" );
        folderLocal.addBoolean( props, "Enabled" ).onChange(v -> {
            renderer.localClippingEnabled = v;
            if ( ! v ) volumeVisualization.visible = false;
        });
        folderLocal.addBoolean( props, "Shadows" ).onChange(result -> clipMaterial.clipShadows = result);
        folderLocal.addBoolean( props, "Visualize" ).onChange(v -> {
            if ( renderer.localClippingEnabled )
                volumeVisualization.visible = v;

        }).listen();
        gui.addFolder( "Global Clipping" )
                .addBoolean( propsGlobal, "Enabled" ).onChange(v -> {
                    renderer.clippingPlanes = v ?
                            JsArray.asJsArray(Js.uncheckedCast(globalClippingPlanes)) : Empty;
        });


        root.appendChild(gui.getDomElement());

        ready = true;
    }

    private Plane[] planesFromMesh(Vector3[] vertices, int[] indices ) {

        // creates a clipping volume from a convex triangular mesh
        // specified by the arrays 'vertices' and 'indices'

		int n = indices.length / 3;
        Plane[] result = new Plane[n];

        for ( int i = 0, j = 0; i < n; ++ i, j += 3 ) {

            Vector3 a = vertices[ indices[ j ] ],
                    b = vertices[ indices[ j + 1 ] ],
                    c = vertices[ indices[ j + 2 ] ];

            result[ i ] = new Plane().
                    setFromCoplanarPoints( a, b, c );

        }

        return result;

    }

    public Plane[] createPlanes(int n ) {

        // creates an array of n uninitialized plane objects

        Plane[] result = new Plane[n];

        for ( int i = 0; i != n; ++ i )
            result[ i ] = new Plane();

        return result;

    }

    public void assignTransformedPlanes(Plane[] planesOut, Plane[] planesIn, Matrix4 matrix ) {

        // sets an array of existing planes to transformed 'planesIn'

        for ( int i = 0, n = planesIn.length; i != n; ++ i )
            planesOut[ i ].copy( planesIn[ i ] ).applyMatrix4( matrix );

    }

    private Plane[] cylindricalPlanes(int n, double innerRadius ) {

        Plane[] result = createPlanes( n );

        for ( int i = 0; i != n; ++ i ) {

            Plane plane = result[ i ];
            double angle = i * Math.PI * 2 / n;

            plane.normal.set(
                    Math.cos( angle ), 0, Math.sin( angle ) );

            plane.constant = innerRadius;

        }

        return result;

    }


    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

    }

    private void  setObjectWorldMatrix(Object3D object, Matrix4 matrix ) {

        // set the orientation of an object based on a world matrix

        Object3D parent = object.parent;
        scene.updateMatrixWorld();
        object.matrix.copy( parent.matrixWorld ).invert();
        object.applyMatrix4( matrix );

    }

    private Matrix4 transform = new Matrix4();
    private Matrix4 tmpMatrix = new Matrix4();

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            double currentTime = DomGlobal.performance.now();
            double time = (currentTime - startTime) / 1000;

            object.position.y = 1;
            object.rotation.x = time * 0.5;
            object.rotation.y = time * 0.2;

            object.updateMatrix();
            transform.copy( object.matrix );

            double bouncy = Math.cos( time * .5 ) * 0.5 + 0.7;
            transform.multiply(
                    tmpMatrix.makeScale( bouncy, bouncy, bouncy ) );

            assignTransformedPlanes(
                    clipMaterial.clippingPlanes, Planes, transform );

            JsArray<Object3D> planeMeshes = volumeVisualization.children;

            for ( int i = 0, n = planeMeshes.length; i != n; ++ i ) {

                tmpMatrix.multiplyMatrices( transform, PlaneMatrices.getAt(i));
                setObjectWorldMatrix( planeMeshes.getAt(i), tmpMatrix );

            }

            transform.makeRotationY( time * 0.1 );

            assignTransformedPlanes( globalClippingPlanes, GlobalClippingPlanes, transform );

            stats.begin();
            renderer.render( scene, camera );
            stats.end();
        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        gui.hide();
    }

    @PageShown
    private void onShow() {
        run = true;
        animate();

    }

}
