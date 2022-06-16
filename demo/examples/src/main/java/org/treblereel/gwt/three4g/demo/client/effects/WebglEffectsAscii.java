package org.treblereel.gwt.three4g.demo.client.effects;

import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.TrackballControls;
import org.treblereel.gwt.three4g.effects.AsciiEffect;
import org.treblereel.gwt.three4g.effects.AsciiEffectOptions;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Page(path = "webgl_effects_ascii")
public class WebglEffectsAscii implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private AsciiEffect effect;

    private Mesh sphere, plane;


    private TrackballControls controls;

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera( 70, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000 );
        camera.position.y = 150;
        camera.position.z = 500;

        scene = new Scene();
        scene.setBackground(new Color( 0, 0, 0 ));

        PointLight pointLight1 = new PointLight( 0xffffff );
        pointLight1.position.set( 500, 500, 500 );
        scene.add( pointLight1 );

        PointLight pointLight2 = new PointLight( 0xffffff, 0.25 );
        pointLight2.position.set( - 500, - 500, - 500 );
        scene.add( pointLight2 );

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setFlatShading(true);

        sphere = new Mesh( new SphereGeometry( 200, 20, 10 ), new MeshPhongMaterial(meshPhongMaterialParameters) );
        scene.add( sphere );

        // Plane
        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor(0xe0e0e0);
        plane = new Mesh( new PlaneGeometry( 400, 400 ), new MeshBasicMaterial( meshBasicMaterialParameters) );
        plane.position.y = - 200;
        plane.rotation.x = - Math.PI / 2;
        scene.add( plane );

        renderer = new WebGLRenderer();
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

        AsciiEffectOptions asciiEffectOptions = AsciiEffectOptions.create();
        asciiEffectOptions.setInvert(true);

        effect = new AsciiEffect( renderer, " .:-+*=%@#", asciiEffectOptions);
        effect.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        effect.domElement.style.color = "white";
        effect.domElement.style.backgroundColor = "black";

        // Special case: append effect.domElement, instead of renderer.domElement.
        // AsciiEffect creates a custom domElement (a div container) where the ASCII elements are placed.

        root.appendChild( effect.domElement );

        controls = new TrackballControls( camera, DomGlobal.document.body );

        //


        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
            effect.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

        }
    }

    private double start = JsDate.now();


    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            double timer = JsDate.now() - start;

            sphere.position.y = Math.abs( Math.sin( timer * 0.002 ) ) * 150;
            sphere.rotation.x = timer * 0.0003;
            sphere.rotation.z = timer * 0.0002;

            controls.update();

            effect.render( scene, camera );
        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - effects - ascii";

        run = true;
        animate();
    }
}
