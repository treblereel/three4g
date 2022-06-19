package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.curves.GrannyKnot;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.parametric.*;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometries_parametric")
public class WebglGeometriesParametric implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Stats stats = new Stats();

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera(45, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 2000);
        camera.position.y = 400;

        scene = new Scene();

        AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4);
        scene.add(ambientLight);

        AmbientLight pointLight = new AmbientLight(0xffffff, 0.8);
        camera.add(pointLight);
        scene.add(camera);

        //

        Texture map = new TextureLoader().load("textures/uv_grid_opengl.jpg");
        map.wrapS = map.wrapT = THREE.RepeatWrapping;
        map.anisotropy = 16;

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setMap(map);
        meshPhongMaterialParameters.setSide(THREE.DoubleSide);

        MeshPhongMaterial material = new MeshPhongMaterial(meshPhongMaterialParameters);

        //
        ParametricGeometry geometry = new ParametricGeometry(ParametricGeometries.plane(100, 100), 10, 10);
        geometry.center();
        Mesh object = new Mesh(geometry, material);
        object.position.set(-200, 0, 200);
        scene.add(object);

        geometry = new ParametricGeometry(ParametricGeometries.klein, 20, 20);
        object = new Mesh(geometry, material);
        object.position.set(0, 0, 200);
        object.scale.multiplyScalar(5);
        scene.add(object);

        geometry = new ParametricGeometry(ParametricGeometries.mobius, 20, 20);
        object = new Mesh(geometry, material);
        object.position.set(200, 0, 200);
        object.scale.multiplyScalar(30);
        scene.add(object);

        //

        GrannyKnot grannyKnot = new GrannyKnot();

        TorusKnotGeometry torus = new TorusKnotGeometry(50, 10, 50, 20, 2, 3);
        SphereGeometry sphere = new SphereGeometry(50, 20, 10);
        TubeGeometry tube = new TubeGeometry(grannyKnot, 100, 3, 8, true);

        object = new Mesh(torus, material);
        object.position.set(-200, 0, -200);
        scene.add(object);

        object = new Mesh(sphere, material);
        object.position.set(0, 0, -200);
        scene.add(object);

        object = new Mesh(tube, material);
        object.position.set(200, 0, -200);
        object.scale.multiplyScalar(2);
        scene.add(object);

        //
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        stats = new Stats();
        root.appendChild(stats.dom);
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

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            double timer = JsDate.now() * 0.0001;

            camera.position.x = Math.cos(timer) * 800;
            camera.position.z = Math.sin(timer) * 800;

            camera.lookAt(scene.position);

            scene.traverse(object -> {
                if (object instanceof Mesh) {

                    object.rotation.x = timer * 5;
                    object.rotation.y = timer * 2.5;

                }
                return null;
            });
            renderer.render(scene, camera);
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> webgl - geometries";

        run = true;
        animate();
    }
}


