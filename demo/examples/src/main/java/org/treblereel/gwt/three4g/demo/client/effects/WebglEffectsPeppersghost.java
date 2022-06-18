package org.treblereel.gwt.three4g.demo.client.effects;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.bufferattribute.Float32BufferAttribute;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.effects.PeppersGhostEffect;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_effects_peppersghost")
public class WebglEffectsPeppersghost implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private PeppersGhostEffect effect;

    private Group group;

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera( 60, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 100000 );

        scene = new Scene();

        group = new Group();
        scene.add( group );

        // Cube

        BufferGeometry geometry = new BoxGeometry().toNonIndexed(); // ensure unique vertices for each triangle

        BufferAttribute position = geometry.attributes.get("position").asBufferAttribute();
        JsArray<Double> colors = new JsArray<>();
        Color color = new Color();

        // generate for each side of the cube a different color

        for ( int i = 0; i < position.count; i += 6 ) {

            color.setHex( Math.random() * 0xffffff );

            // first face

            colors.push( color.r, color.g, color.b );
            colors.push( color.r, color.g, color.b );
            colors.push( color.r, color.g, color.b );

            // second face

            colors.push( color.r, color.g, color.b );
            colors.push( color.r, color.g, color.b );
            colors.push( color.r, color.g, color.b );

        }

        geometry.setAttribute( "color", new Float32BufferAttribute( colors, 3 ) );
        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setVertexColors(true);
        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        for ( int i = 0; i < 10; i ++ ) {

            Mesh cube = new Mesh( geometry, material );
            cube.position.x = Math.random() * 2 - 1;
            cube.position.y = Math.random() * 2 - 1;
            cube.position.z = Math.random() * 2 - 1;
            cube.scale.multiplyScalar( Math.random() + 0.5 );
            group.add( cube );

        }

        renderer = new WebGLRenderer();
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        root.appendChild( renderer.domElement );

        effect = new PeppersGhostEffect( renderer );
        effect.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        effect.cameraDistance = 5;

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

            effect.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            group.rotation.y += 0.01;

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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - <a href=\"https://en.wikipedia.org/wiki/Pepper%27s_ghost\">peppers ghost effect</a> demo <br />\n" +
                "\t\t\t<a href=\"http://www.instructables.com/id/Reflective-Prism/?ALLSTEPS\" target=\"_blank\" rel=\"noopener\">how to build the reflective prism</a>";

        run = true;
        animate();
    }
}
