package org.treblereel.gwt.three4g.demo.client.clipping;

import elemental2.core.JsArray;
import elemental2.core.JsBoolean;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.lilgui4g.OnChange;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.helpers.PlaneHelper;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
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
@Page(path = "webgl_clipping_intersection")
public class WebglClippingIntersection implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private PerspectiveCamera camera;
    private Scene scene;
    private WebGLRenderer renderer;

    private boolean run;

    private boolean ready;

    private Plane[] clipPlanes = new Plane[] {
            new Plane(new Vector3( 1, 0, 0 ), 0 ),
            new Plane(new Vector3( 0, - 1, 0 ), 0 ),
            new Plane(new Vector3( 0, 0, - 1 ), 0),
    };

    private JsPropertyMap params = JsPropertyMap.of();

    private GUI gui;

    @PostConstruct
    public void init(){

        scene = new Scene();

        camera = new PerspectiveCamera(
                40, DomGlobal.window.innerWidth/ DomGlobal.window.innerHeight, 1, 200 );
        camera.position.set( - 1.5, 2.5, 3.0 );

        params.set("clipIntersection", true);
        params.set("planeConstant", 0);
        params.set("showHelpers", false);

        // Renderer

        renderer = new WebGLRenderer();
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        renderer.localClippingEnabled = true;


        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

        OrbitControls controls = new OrbitControls( camera, renderer.domElement );
        controls.addEventListener( "change", (event) -> render() ); // use only if there is no animation loop
        controls.minDistance = 1;
        controls.maxDistance = 10;
        controls.enablePan = false;


        HemisphereLight light = new HemisphereLight( 0xffffff, 0x080808, 1.5 );
        light.position.set( - 1.25, 1, 1.25 );
        scene.add( light );

        // const helper = new THREE.CameraHelper( light.shadow.camera );
        // scene.add( helper );
        //
        Group group = new Group();
        for ( int i = 1; i <= 30; i += 2 ) {
            SphereGeometry geometry = new SphereGeometry( (double) i / 30, 48, 24 );

            MeshLambertMaterialParameters meshLambertMaterialParameters = MeshLambertMaterialParameters.create();
            meshLambertMaterialParameters.setColor(new Color().setHSL( Math.random(), 0.5, 0.5 ));
            meshLambertMaterialParameters.setSide(THREE.DoubleSide);
            meshLambertMaterialParameters.setClippingPlanes(clipPlanes);
            meshLambertMaterialParameters.setClipIntersection(new JsBoolean(params.get("clipIntersection")).valueOf());
            group.add( new Mesh( geometry, new MeshLambertMaterial(meshLambertMaterialParameters) ));
        }
        scene.add( group );

        // helpers
        Group helpers = new Group();
        helpers.add( new PlaneHelper( clipPlanes[ 0 ], 2, 0xff0000 ) );
        helpers.add( new PlaneHelper( clipPlanes[ 1 ], 2, 0x00ff00 ) );

        helpers.add( new PlaneHelper( clipPlanes[ 2 ], 2, 0x0000ff ) );
        helpers.visible = false;
        scene.add( helpers );

        JsPropertyMap props = JsPropertyMap.of();
        props.set("clipIntersection", true);
        props.set("planeConstant", 0);
        props.set("showHelpers", false);

        gui = new GUI();
        gui.addBoolean( params, "clipIntersection" ).name( "clip intersection" ).onChange(result -> {
            JsArray<Object3D> children = group.children;
            for ( int i = 0; i < children.length; i ++ ) {
                ((Mesh)children.getAt(i)).material.clipIntersection = result;
            }
            render();
        });
        gui.addNumber( params, "planeConstant", - 1, 1 ).setStep( 0.01 ).name( "plane constant" ).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                for ( int j = 0; j < clipPlanes.length; j ++ ) {
                    clipPlanes[ j ].constant = result.doubleValue();
                }
                render();
            }
        });

        gui.addBoolean( params, "showHelpers" ).name( "show helpers" ).onChange( result -> {
            helpers.visible = result;
            render();

        } );

        root.appendChild( renderer.domElement );
        root.appendChild(gui.getDomElement());
        ready = true;
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        render();
    }

    private void render() {
        if (run && ready) {
            renderer.render( scene, camera );
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
        render();
    }

}

