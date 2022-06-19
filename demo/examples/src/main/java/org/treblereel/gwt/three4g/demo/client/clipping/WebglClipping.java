package org.treblereel.gwt.three4g.demo.client.clipping;

import elemental2.core.JsArray;
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
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Page(path = "webgl_clipping")
public class WebglClipping implements IsElement<HTMLDivElement> {

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

    @PostConstruct
    public void init(){
        camera = new PerspectiveCamera( 36, DomGlobal.window.innerWidth * 0.8/ DomGlobal.window.innerHeight* 0.8, 0.25, 16 );
        camera.position.set( 0, 1.3, 3 );
        scene = new Scene();

        // Lights

        scene.add( new AmbientLight( 0x505050 ) );

        SpotLight spotLight = new SpotLight( 0xffffff );
        spotLight.angle = Math.PI / 5;
        spotLight.penumbra = 0.2;
        spotLight.position.set( 2, 3, 3 );
        spotLight.castShadow = true;
        spotLight.shadow.camera.near = 3;
        spotLight.shadow.camera.far = 10;
        spotLight.shadow.mapSize.width = 1024;
        spotLight.shadow.mapSize.height = 1024;
        scene.add( spotLight );

        DirectionalLight dirLight = new DirectionalLight( 0x55505a, 1 );
        dirLight.position.set( 0, 3, 0 );
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

        // ***** Clipping planes: *****

        Plane localPlane = new Plane( new Vector3( 0, - 1, 0 ), 0.8 );
        Plane globalPlane = new Plane( new Vector3( - 1, 0, 0 ), 0.1 );

        // Geometry

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setColor(0x80ee10);
        meshPhongMaterialParameters.setShininess(100);
        meshPhongMaterialParameters.setSide(THREE.DoubleSide);
        meshPhongMaterialParameters.setClippingPlanes(new Plane[] {localPlane});
        meshPhongMaterialParameters.setClipShadows(true);

        MeshPhongMaterial material = new MeshPhongMaterial(meshPhongMaterialParameters);

        TorusKnotGeometry geometry = new TorusKnotGeometry( 0.4, 0.08, 95, 20 );

        mesh = new Mesh( geometry, material );
        mesh.castShadow = true;
        scene.add( mesh );

        MeshPhongMaterialParameters meshPhongMaterialParameters1 = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters1.setColor(0xa0adaf);
        meshPhongMaterialParameters1.setShininess(150);

        Mesh ground = new Mesh(
                new PlaneGeometry( 9, 9, 1, 1 ),
                new MeshPhongMaterial(meshPhongMaterialParameters1));

        ground.rotation.x = - Math.PI / 2; // rotates X/Y to X/Z
        ground.receiveShadow = true;
        scene.add( ground );

        // Stats

        stats = new Stats();
        root.appendChild( stats.dom );

        // Renderer

        renderer = new WebGLRenderer();
        renderer.shadowMap.enabled = true;
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight  * 0.8);
        root.appendChild(renderer.domElement);

        // ***** Clipping setup (renderer): *****
        JsArray<Plane> globalPlanes = new JsArray<>();
        globalPlanes.push(globalPlane);

        JsArray<JsObject> Empty = JsObject.freeze(new JsArray<>());

        renderer.clippingPlanes = Js.uncheckedCast(Empty); // GUI sets it to globalPlanes
        renderer.localClippingEnabled = true;

        // Controls

        OrbitControls controls = new OrbitControls( camera, renderer.domElement );
        controls.target.set( 0, 1, 0 );
        controls.update();
        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

        startTime = DomGlobal.performance.now();

        JsPropertyMap propsLocal = JsPropertyMap.of();
        propsLocal.set("Enabled", true);
        propsLocal.set("Shadows", true);
        propsLocal.set("Plane", localPlane.constant);

        JsPropertyMap propsGlobal = JsPropertyMap.of();
        propsGlobal.set("Enabled", true);
        propsGlobal.set("Plane", globalPlane.constant);

        GUI gui = new GUI();
        GUI folderLocal = gui.addFolder( "Local Clipping" );
        folderLocal.addBoolean( propsLocal, "Enabled" ).onChange(result -> renderer.localClippingEnabled = result);
        folderLocal.addBoolean( propsLocal, "Shadows" ).onChange(result -> material.clipShadows = result);
        folderLocal.addNumber( propsLocal, "Plane", 0.3, 1.25 ).onChange(result -> localPlane.constant = result.doubleValue());
        GUI folderGlobal = gui.addFolder( "Global Clipping");

        folderGlobal.addBoolean( propsGlobal, "Enabled" ).onChange(v -> {
            renderer.clippingPlanes = v ? Js.uncheckedCast(globalPlanes) : new JsArray<>();
        });
        folderGlobal.addNumber( propsGlobal, "Plane", - 0.4, 3 ).onChange(result -> globalPlane.constant = result.doubleValue());

        root.appendChild(gui.getDomElement());

        ready = true;
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void  onWindowResize() {
        camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize( DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8 );

    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            double currentTime = DomGlobal.performance.now();
            double time = (currentTime - startTime) / 1000;

            mesh.position.y = 0.8;
            mesh.rotation.x = time * 0.5;
            mesh.rotation.y = time * 0.2;
            mesh.scale.setScalar(Math.cos(time) * 0.125 + 0.875);

            stats.begin();
            renderer.render(scene, camera);
            stats.end();
        }
    }

    @PageHiding
    private void onHide() {
        run = false;
    }

    @PageShown
    private void onShow() {
        run = true;
        animate();

    }

}
