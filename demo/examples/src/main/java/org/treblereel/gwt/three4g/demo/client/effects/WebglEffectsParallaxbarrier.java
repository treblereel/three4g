package org.treblereel.gwt.three4g.demo.client.effects;

import elemental2.core.JsArray;
import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.effects.ParallaxBarrierEffect;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_effects_parallaxbarrier")
public class WebglEffectsParallaxbarrier implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private JsArray<Mesh> spheres = new JsArray<>();

    private ParallaxBarrierEffect effect;

    private double mouseX = 0;
    private double mouseY = 0;

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera(60, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 0.01, 100);
        camera.position.z = 3;
        camera.setFocalLength(3);

        String path = "textures/cube/pisa/";
        String format = ".png";
        String[] urls = new String[]{
                path + "px" + format, path + "nx" + format,
                path + "py" + format, path + "ny" + format,
                path + "pz" + format, path + "nz" + format
        };

        CubeTexture textureCube = new CubeTextureLoader().load(urls);

        scene = new Scene();
        scene.setBackground(textureCube);

        SphereGeometry geometry = new SphereGeometry(0.1, 32, 16);

        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor(0xffffff);
        meshBasicMaterialParameters.setEnvMap(textureCube);

        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        for (int i = 0; i < 500; i++) {

            Mesh mesh = new Mesh(geometry, material);

            mesh.position.x = Math.random() * 10 - 5;
            mesh.position.y = Math.random() * 10 - 5;
            mesh.position.z = Math.random() * 10 - 5;

            double val = Math.random() * 3 + 1;

            mesh.scale.x = val;
            mesh.scale.y = val;
            mesh.scale.z = val;

            scene.add(mesh);

            spheres.push(mesh);

        }

        //

        renderer = new WebGLRenderer();
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        root.appendChild(renderer.domElement);

        double width = DomGlobal.window.innerWidth;
        double height = DomGlobal.window.innerHeight;

        effect = new ParallaxBarrierEffect(renderer);
        effect.setSize(width, height);

        root.appendChild(stats.dom);

        DomGlobal.window.addEventListener("resize", e -> onWindowResize());
        DomGlobal.document.addEventListener("mousemove", e -> onDocumentMouseMove(e));

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

    private void onDocumentMouseMove(Event e) {
        MouseEvent event = (MouseEvent) e;

        mouseX = (event.clientX - root.clientWidth / 2) / 100;
        mouseY = (event.clientY - root.clientHeight / 2) / 100;

    }

    private double start = JsDate.now();

    private Stats stats = new Stats();

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            double timer = JsDate.now() * 0.0001 ;
            stats.update();

            camera.position.x += (mouseX - camera.position.x) * 0.05;
            camera.position.y += (-mouseY - camera.position.y) * 0.05;

            camera.lookAt(scene.position);

            for (int i = 0, il = spheres.length; i < il; i++) {

                Mesh sphere = spheres.getAt(i);
                sphere.position.x = 5 * Math.cos( timer + i );
                sphere.position.y = 5 * Math.sin( timer + i * 1.1 );

            }

            effect.render(scene, camera);
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - effects - parallax barrier<br/>\n" +
                "\t\t\tskybox by <a href=\"https://www.pauldebevec.com/\" target=\"_blank\" rel=\"noopener\">Paul Debevec</a>";

        run = true;
        animate();
    }
}

