package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import com.google.gwt.core.client.ScriptInjector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.api.MarchingCubes;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.extensions.vr.vive.ViveController;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/5/18.
 */
@InjectJavaScriptFor(elements = {ViveController.class, OBJLoader.class, WebVR.class})
public class ViveSculpt extends Attachable {

    public static final String name = "vive / sculpt";

    private ViveController controller1, controller2;
    private Random rand = new Random();
    private boolean ready = false;
    private List<Points> points;
    private MarchingCubes blob;


    public ViveSculpt() {

        ScriptInjector.fromString(JavascriptTextResource.IMPL.getMarchingCubes().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

        scene = new Scene();
        scene.background = new Color(0x222222);
        camera = new PerspectiveCamera(70, aspect, 0.1f, 10);

        BoxBufferGeometry geometry = new BoxBufferGeometry(0.5f, 0.8f, 0.5f);
        MeshStandardMaterial meshStandardMaterial = new MeshStandardMaterial();
        meshStandardMaterial.color = new Color(0x444444);
        meshStandardMaterial.roughness = 1.0f;
        meshStandardMaterial.metalness = 0;


        Mesh table = new Mesh(geometry, meshStandardMaterial);
        table.position.y = 0.35f;
        table.position.z = 0.85f;
        table.castShadow = true;
        table.receiveShadow = true;
        scene.add(table);
        PlaneBufferGeometry planeBufferGeometry = new PlaneBufferGeometry(4, 4);
        meshStandardMaterial = new MeshStandardMaterial();
        meshStandardMaterial.color = new Color(0x222222);
        meshStandardMaterial.roughness = 1.0f;
        meshStandardMaterial.metalness = 0;

        Mesh floor = new Mesh(planeBufferGeometry, meshStandardMaterial);
        floor.rotation.x = (float) -Math.PI / 2;
        floor.receiveShadow = true;
        scene.add(floor);
        scene.add(new GridHelper(20, 40, new Color(0x111111), new Color(0x111111)));
        scene.add(new HemisphereLight(0x888877, 0x777788));
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 6, 0);
        light.castShadow = true;
        OrthographicCamera orthographicCamera = (OrthographicCamera) light.shadow.camera;
        orthographicCamera.top = 2;
        orthographicCamera.bottom = -2;
        orthographicCamera.right = 2;
        orthographicCamera.left = -2;
        light.shadow.mapSize.set(4096, 4096);
        scene.add(light);
        //
        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;

        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.vr.enabled = true;
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        renderer.shadowMap.enabled = true;

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));
        // controllers

        controller1 = new ViveController(0);
        controller1.standingMatrix = renderer.vr.getStandingMatrix();
        scene.add(controller1);


        controller2 = new ViveController(1);

        controller2.standingMatrix = renderer.vr.getStandingMatrix();
        scene.add(controller2);

        OBJLoader loader = new OBJLoader();
        loader.setPath("models/obj/vive-controller/");
        loader.load("vr_controller_vive_1_5.obj", object -> {

            TextureLoader textureLoader = new TextureLoader();
            textureLoader.setPath("models/obj/vive-controller/");

            Object3D controller = object.children[0];

            MeshPhongMaterial material = controller.getProperty("material");

            material.map = textureLoader.load("onepointfive_texture.png");
            material.specularMap = textureLoader.load("onepointfive_spec.png");
            controller.castShadow = true;
            controller.receiveShadow = true;

            Mesh pivot = new Mesh(new IcosahedronBufferGeometry(0.01f, 2));
            pivot.name = "pivot";
            pivot.position.y = -0.016f;
            pivot.position.z = -0.043f;
            pivot.rotation.x = (float) (Math.PI / 5.5);
            controller.add(pivot);

            MeshBasicMaterialParameters parameters1 = new MeshBasicMaterialParameters();
            parameters1.opacity = 0.25f;
            parameters1.transparent = true;

            Mesh range = new Mesh(new IcosahedronGeometry(0.03f, 3), new MeshBasicMaterial(parameters1));
            pivot.add(range);
            controller1.add(controller.clone());
            controller2.add(controller.clone());

            initBlob();
            ready = true;

        });
    }

    private void initBlob() {
        MeshStandardMaterial material = new MeshStandardMaterial();
        material.color = new Color(0xffffff);
        material.roughness = 0.9f;
        material.metalness = 0;

        blob = new MarchingCubes(64, material, true);
        blob.position.y = 1;
        scene.add(blob);
        initPoints();
    }

    private void initPoints() {
        points = new ArrayList<>();
        points.add(new Points(new Vector3(), -0.08f, 10));
        points.add(new Points(new Vector3(), 0.04f, 10));
    }

    private void transformPoint(Vector3 vector) {
        vector.x = (vector.x + 1.0f) / 2.0f;
        vector.y = (vector.y / 2.0f);
        vector.z = (vector.z + 1.0f) / 2.0f;
    }

    private void handleController(ViveController controller, int id) {
        controller.update();
        Mesh pivot = (Mesh) controller.getObjectByName("pivot");

        if (pivot != null) {
            Matrix4 matrix = pivot.matrixWorld;

            points.get(id).position.setFromMatrixPosition(matrix);

            transformPoint(points.get(id).position);
            if (controller.getButtonState("thumbpad")) {
                blob.material.color.setHex(rand.nextInt() * 0xffffff);
            }
            if (controller.getButtonState("trigger")) {
                float strength = points.get(id).strength / 2;
                Vector3 vector = new Vector3().setFromMatrixPosition(matrix);
                transformPoint(vector);
                points.add(new Points(vector, strength, 10));
            }
            if (id == 0 && controller.getButtonState("grips")) {
                if (points.size() > 2) {
                    points.remove(0);
                    points.remove(0);
                    updateBlob();
                    BufferGeometry geometry = blob.generateBufferGeometry();
                    Mesh mesh = new Mesh(geometry, blob.material.clone());
                    mesh.position.y = 1;
                    mesh.castShadow = true;
                    mesh.receiveShadow = true;
                    scene.add(mesh);
                    initPoints();
                }
            }
            if (id == 1 && controller.getButtonState("grips")) {
                points.get(id).strength = (float) ((Math.sin(window.performance.now() / 1000) + 1.5) / 20.0);
            }
        }
    }

    public void updateBlob() {
        blob.reset();
        for (int i = 0; i < points.size(); i++) {
            Points point = points.get(i);
            Vector3 position = point.position;
            blob.addBall(position.x, position.y, position.z, point.strength, point.subtract);
        }
    }

    private void animate() {
        renderer.setAnimationLoop(() -> {
            if (container.parentNode != null && container.parentNode.parentNode != null && ready) {
                render();
            }
        });
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" <a href=\"http://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> webgl - htc vive");
    }

    private void render() {
        handleController(controller1, 0);
        handleController(controller2, 1);
        updateBlob();
        renderer.render(scene, camera);
    }

    class Points {
        Vector3 position;
        float strength, subtract;

        Points(Vector3 position, float strength, float subtract) {
            this.position = position;
            this.strength = strength;
            this.subtract = subtract;
        }
    }
}
