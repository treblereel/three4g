package org.treblereel.gwt.three4g.demo.client.camera;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.cameras.ArrayCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.geometries.CylinderGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Page(path = "webgl_camera_array")
public class WebglCameraArray implements IsElement<HTMLDivElement> {

    double SCREEN_WIDTH = DomGlobal.window.innerWidth * 0.8;
    double SCREEN_HEIGHT = DomGlobal.window.innerHeight * 0.8;
    double aspect = SCREEN_WIDTH / SCREEN_HEIGHT;

    int AMOUNT = 6;

    double WIDTH = (SCREEN_WIDTH / AMOUNT) * DomGlobal.window.devicePixelRatio;
    double HEIGHT = (SCREEN_HEIGHT / AMOUNT) * DomGlobal.window.devicePixelRatio;

    @Inject
    private HTMLDivElement root;

    private ArrayCamera camera;

    private WebGLRenderer renderer;

    Mesh mesh;

    private Scene scene;

    private boolean run, ready;


    @PostConstruct
    public void init() {

        scene = new Scene();

        JsArray<PerspectiveCamera> cameras = new JsArray<>();

        for (int y = 0; y < AMOUNT; y++) {

            for (int x = 0; x < AMOUNT; x++) {

                PerspectiveCamera subcamera = new PerspectiveCamera(40, aspect, 0.1, 10);
                subcamera.viewport = new Vector4(Math.floor(x * WIDTH), Math.floor(y * HEIGHT), Math.ceil(WIDTH), Math.ceil(HEIGHT));
                subcamera.position.x = (x / AMOUNT) - 0.5;
                subcamera.position.y = 0.5 - (y / AMOUNT);
                subcamera.position.z = 1.5;
                subcamera.position.multiplyScalar(2);
                subcamera.lookAt(0, 0, 0);
                subcamera.updateMatrixWorld();
                cameras.push(subcamera);

            }

        }


        camera = new ArrayCamera(cameras);
        camera.position.z = 3;

        scene = new Scene();

        scene.add(new AmbientLight(0x222244));

        DirectionalLight light = new DirectionalLight();
        light.position.set(0.5, 0.5, 1);
        light.castShadow = true;
        light.shadow.camera.zoom = 4; // tighter shadow map
        scene.add(light);

        PlaneGeometry geometryBackground = new PlaneGeometry(100, 100);

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setColor(0x000066);

        MeshPhongMaterial materialBackground = new MeshPhongMaterial(meshPhongMaterialParameters);

        Mesh background = new Mesh(geometryBackground, materialBackground);
        background.receiveShadow = true;
        background.position.set(0, 0, -1);
        scene.add(background);

        CylinderGeometry geometryCylinder = new CylinderGeometry(0.5, 0.5, 1, 32);

        MeshPhongMaterialParameters meshPhongMaterialParameters2 = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters2.setColor(0xff0000);

        MeshPhongMaterial materialCylinder = new MeshPhongMaterial(meshPhongMaterialParameters2);

        mesh = new Mesh(geometryCylinder, materialCylinder);
        mesh.castShadow = true;
        mesh.receiveShadow = true;
        scene.add(mesh);

        renderer = new WebGLRenderer();
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        root.appendChild(renderer.domElement);
        renderer.shadowMap.enabled = true;

        ready = true;

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {

            double ASPECT_RATIO = DomGlobal.window.innerWidth * 0.8 / DomGlobal.window.innerHeight * 0.8;
            double WIDTH = (DomGlobal.window.innerWidth * 0.8 / AMOUNT) * DomGlobal.window.devicePixelRatio;
            double HEIGHT = (DomGlobal.window.innerHeight * 0.8 / AMOUNT) * DomGlobal.window.devicePixelRatio;

            camera.aspect = ASPECT_RATIO;
            camera.updateProjectionMatrix();

            for (int y = 0; y < AMOUNT; y++) {

                for (int x = 0; x < AMOUNT; x++) {

                    PerspectiveCamera subcamera = camera.cameras.getAt(AMOUNT * y + x);

                    subcamera.viewport.set(
                            Math.floor(x * WIDTH),
                            Math.floor(y * HEIGHT),
                            Math.ceil(WIDTH),
                            Math.ceil(HEIGHT));

                    subcamera.aspect = ASPECT_RATIO;
                    subcamera.updateProjectionMatrix();

                }

            }

            renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            mesh.rotation.x += 0.005;
            mesh.rotation.z += 0.01;

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
        run = true;
        animate();
    }


}
