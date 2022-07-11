package org.treblereel.gwt.three4g.demo.client.camera;

import elemental2.core.JsArray;
import elemental2.core.JsNumber;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.three4g.cameras.CinematicCamera;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.MathUtils;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.raycaster.Intersection;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Page(path = "webgl_camera_cinematic")
public class WebglCameraCinematic implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private CinematicCamera camera;

    private Scene scene;

    private Raycaster raycaster;

    private boolean run, ready;

    private double theta = 0;

    private double radius = 100;

    private JsPropertyMap effectController;

    private GUI gui;

    @PostConstruct
    public void init() {
        camera = new CinematicCamera( 60, ( ((double) DomGlobal.window.innerWidth) / ((double) DomGlobal.window.innerHeight)), 1, 1000 );
        camera.setLens( 5 );
        camera.position.set( 2, 1, 500 );

        scene = new Scene();
        scene.setBackground(new Color( 0xf0f0f0 ));

        scene.add( new AmbientLight( 0xffffff, 0.3 ) );

        DirectionalLight light = new DirectionalLight( 0xffffff, 0.35 );
        light.position.set( 1, 1, 1 ).normalize();
        scene.add( light );

        BoxGeometry geometry = new BoxGeometry( 20, 20, 20 );

        for ( int i = 0; i < 1500; i ++ ) {

            MeshLambertMaterialParameters parameters = MeshLambertMaterialParameters.create();
            parameters.setColor(new Color(Math.random() * 0xffffff));

            Mesh object = new Mesh(geometry, new MeshLambertMaterial(parameters));

            object.position.x = Math.random() * 800 - 400;
            object.position.y = Math.random() * 800 - 400;
            object.position.z = Math.random() * 800 - 400;

            scene.add( object );

        }

        raycaster = new Raycaster();

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);

        root.appendChild(renderer.domElement);

        effectController = JsPropertyMap.of();
        effectController.set("focalLength", 15);
        effectController.set("fstop", 2.8);
        effectController.set("showFocus", false);
        effectController.set("focalDepth", 3);

        //

        gui = new GUI();

        gui.addNumber( effectController, "focalLength", 1, 135, 0.01 ).onChange(e -> {
            matChanger();
        });
        gui.addNumber( effectController, "fstop", 1.8, 22, 0.01 ).onChange(e -> {
            matChanger();

        });
        gui.addNumber( effectController, "focalDepth", 0.1, 100, 0.001 ).onChange(e -> {
            matChanger();

        } );
        gui.addBoolean( effectController, "showFocus").onChange(e -> {
            matChanger();

        } );

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
        DomGlobal.document.addEventListener( "mousemove", evt -> onDocumentMouseMove(evt) );


        ready = true;
    }

    private void matChanger() {
        JsPropertyMap bokeh_uniforms = Js.uncheckedCast(camera.postprocessing.get("bokeh_uniforms"));

        effectController.forEach(key -> {
            if(bokeh_uniforms.has(key)) {
                JsPropertyMap value = JsPropertyMap.of();
                value.set("value", effectController.get(key));
                bokeh_uniforms.set(key, value);
            }
        });


        JsPropertyMap znear = JsPropertyMap.of();
        znear.set("value", camera.near);
        bokeh_uniforms.set("znear", znear);

        JsPropertyMap zfar = JsPropertyMap.of();
        zfar.set("value", camera.near);
        bokeh_uniforms.set("zfar", zfar);

        int focalLength = (int) new JsNumber(effectController.get("focalLength")).valueOf();
        double fstop = new JsNumber(Js.asPropertyMap(effectController).get("fstop")).valueOf();
        double focalDepth = new JsNumber(Js.asPropertyMap(bokeh_uniforms.get("focalDepth")).get("value")).valueOf();

        camera.setLens(focalLength, 35, fstop , camera.coc );
        effectController.set("'focalDepth'", focalDepth);
    }

    Vector2 mouse = new Vector2();

    private void onDocumentMouseMove(Event e ) {
        MouseEvent event = (MouseEvent) e;

        event.preventDefault();

        mouse.x = ( event.clientX / DomGlobal.window.innerWidth ) * 2 - 1;
        mouse.y = - ( event.clientY / DomGlobal.window.innerHeight ) * 2 + 1;
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if(camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            render();
            stats.update();
        }
    }

    private Mesh INTERSECTED;
    private void render() {

        theta += 0.1;

        camera.position.x = radius * Math.sin( MathUtils.degToRad( theta ) );
        camera.position.y = radius * Math.sin( MathUtils.degToRad( theta ) );
        camera.position.z = radius * Math.cos( MathUtils.degToRad( theta ) );
        camera.lookAt( scene.position );


        camera.updateMatrixWorld();

        // find intersections

        raycaster.setFromCamera( mouse, camera );
        JsArray<Intersection<Mesh>> intersects = raycaster.intersectObjects( scene.children, false );
        if ( intersects.length > 0 ) {
            double targetDistance = intersects.getAt(0).getDistance();
            camera.focusAt( targetDistance );
            // using Cinematic camera focusAt method
            if ( INTERSECTED != intersects.getAt(0).getObject() ) {
                if ( INTERSECTED != null) {
                    double hex = new JsNumber(Js.asPropertyMap(INTERSECTED).get("currentHex")).valueOf();
                    Js.<MeshLambertMaterial>uncheckedCast(INTERSECTED.material).emissive.setHex(hex);
                }
                INTERSECTED = intersects.getAt(0).getObject();
                double hex = Js.<MeshLambertMaterial>uncheckedCast(INTERSECTED.material).emissive.getHex();
                Js.asPropertyMap(INTERSECTED).set("currentHex", hex);
                Js.<MeshLambertMaterial>uncheckedCast(INTERSECTED.material).emissive.setHex(0xff0000);
            }

        } else {

            if ( INTERSECTED != null) {
                double hex = new JsNumber(Js.asPropertyMap(INTERSECTED).get("currentHex")).valueOf();
                Js.<MeshLambertMaterial>uncheckedCast(INTERSECTED.material).emissive.setHex(hex);
                INTERSECTED = null;
            }

        }
        //

        if ( camera.postprocessing.has("enabled") ) {

            camera.renderCinematic( scene, renderer );

        } else {

            scene.setOverrideMaterial(null);

            renderer.clear();
            renderer.render( scene, camera );

        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
        gui.hide();
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<div style=\"color:yellowgreen\"><a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> webgl - interactive cubes</div>";

        run = true;
        animate();
    }
}

