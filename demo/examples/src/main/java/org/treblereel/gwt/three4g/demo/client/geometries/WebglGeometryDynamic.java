package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.FirstPersonControls;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.FogExp2;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_dynamic")
public class WebglGeometryDynamic implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Clock clock;

    private double worldWidth = 128, worldDepth = 128;

    private PlaneGeometry geometry;

    private MeshBasicMaterial material;

    private Mesh mesh;
    private FirstPersonControls controls;
    private Stats stats;


    @PostConstruct
    public void init() {

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        camera = new PerspectiveCamera(60, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 20000);
        camera.position.y = 200;

        clock = new Clock();

        scene = new Scene();
        scene.setBackground(new Color(0xaaccff));
        scene.setFog(new FogExp2(0xaaccff, 0.0007));

        geometry = new PlaneGeometry(20000, 20000, worldWidth - 1, worldDepth - 1);
        geometry.rotateX(-Math.PI / 2);

        BufferAttribute position = geometry.attributes.get("position").asBufferAttribute();
        position.usage = THREE.DynamicDrawUsage;

        for (int i = 0; i < position.count; i++) {

            double y = 35 * Math.sin(i / 2);
            position.setY(i, y);

        }

        Texture texture = new TextureLoader().load("textures/water.jpg");
        texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
        texture.repeat.set(5, 5);

        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor(0x0044ff);
        meshBasicMaterialParameters.setMap(texture);

        material = new MeshBasicMaterial(meshBasicMaterialParameters);

        mesh = new Mesh(geometry, material);
        scene.add(mesh);

        controls = new FirstPersonControls(camera, DomGlobal.document.body);

        controls.movementSpeed = 500;
        controls.lookSpeed = 0.1;

        stats = new Stats();
        root.appendChild(stats.dom);


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

            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);

            controls.handleResize();

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            double delta = clock.getDelta();
            double time = clock.getElapsedTime() * 10;

            BufferAttribute position = geometry.attributes.get("position").asBufferAttribute();

            for (int i = 0; i < position.count; i++) {

                double y = 35 * Math.sin(i / 5 + (time + i) / 7);
                position.setY(i, y);

            }

            position.needsUpdate = true;

            controls.update(delta);
            renderer.render(scene, camera);
            stats.update();
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - dynamic geometry";

        run = true;
        animate();
    }
}
