package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.events.Event;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.extensions.vr.vive.ViveController;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.ConeBufferGeometry;
import org.treblereel.gwt.three4g.geometries.CylinderBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/5/18.
 */
@InjectJavaScriptFor(elements = {ViveController.class, WebVR.class, OBJLoader.class})
public class ViveDragging extends Attachable {

    public static final String name = "vive / dragging";
    private HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");
    private Random rand = new Random();
    private ViveController controller1, controller2;
    private Raycaster raycaster;
    private List<Mesh> intersected = new ArrayList<>();
    private Matrix4 tempMatrix = new Matrix4();
    private Group group;
    private boolean ready = false;

    public ViveDragging() {
        scene = new Scene();
        scene.background = new Color(0x808080);
        camera = new PerspectiveCamera(70, aspect, 0.1f, 10);
        PlaneBufferGeometry planeBufferGeometry = new PlaneBufferGeometry(4, 4);
        MeshStandardMaterialParameters meshStandardMaterialParameters = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters.color = new Color(0xeeeeee);
        meshStandardMaterialParameters.roughness = 1.0f;
        meshStandardMaterialParameters.metalness = 0.0f;

        MeshStandardMaterial meshStandardMaterial = new MeshStandardMaterial(meshStandardMaterialParameters);
        Mesh floor = new Mesh(planeBufferGeometry, meshStandardMaterial);
        floor.rotation.x = (float) -Math.PI / 2;
        floor.receiveShadow = true;
        scene.add(floor);
        scene.add(new HemisphereLight(0x808080, 0x606060));
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 6, 0);
        light.castShadow = true;

        OrthographicCamera orthographicCamera = (OrthographicCamera) light.shadow.camera;
        orthographicCamera.top = 2f;
        orthographicCamera.bottom = -2;
        orthographicCamera.right = 2;
        orthographicCamera.left = -2;

        light.shadow.mapSize.set(4096, 4096);
        scene.add(light);
        group = new Group();
        scene.add(group);


        BufferGeometry[] geometries = new BufferGeometry[5];
        geometries[0] = new BoxBufferGeometry(0.2f, 0.2f, 0.2f);
        geometries[1] = new ConeBufferGeometry(0.2f, 0.2f, 64);
        geometries[2] = new CylinderBufferGeometry(0.2f, 0.2f, 0.2f, 64);
        geometries[3] = new IcosahedronBufferGeometry(0.2f, 3);
        geometries[4] = new TorusBufferGeometry(0.2f, 0.04f, 64, 32);

        for (int i = 0; i < 50; i++) {
            double step = rand.nextDouble() * geometries.length;
            BufferGeometry geometry = geometries[Double.valueOf(Math.floor(step)).intValue()];

            MeshStandardMaterialParameters parameters = new MeshStandardMaterialParameters();
            parameters.color = new Color(rand.nextFloat() * 0xffffff);
            parameters.roughness = 0.7f;
            parameters.metalness = 0.0f;

            MeshStandardMaterial material = new MeshStandardMaterial(parameters);

            Mesh object = new Mesh(geometry, material);
            object.position.x = rand.nextFloat() * 4 - 2;
            object.position.y = rand.nextFloat() * 2;
            object.position.z = rand.nextFloat() * 4 - 2;
            object.rotation.x = rand.nextFloat() * (float) (2 * Math.PI);
            object.rotation.y = rand.nextFloat() * (float) (2 * Math.PI);
            object.rotation.z = rand.nextFloat() * (float) (2 * Math.PI);
            object.scale.setScalar(rand.nextFloat() + 0.5f);
            object.castShadow = true;
            object.receiveShadow = true;
            group.add(object);
        }

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.alpha = true;
        parameters.antialias = true;

        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);

        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        renderer.shadowMap.enabled = true;
        renderer.vr.enabled = true;

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));

        controller1 = new ViveController(0);
        controller1.standingMatrix = renderer.vr.getStandingMatrix();

        controller1.addEventListener("triggerdown", (event) -> onTriggerDown(event));
        controller1.addEventListener("triggerup", (event) -> onTriggerUp(event));

        scene.add(controller1);
        controller2 = new ViveController(1);

        controller2.standingMatrix = renderer.vr.getStandingMatrix();
        controller2.addEventListener("triggerdown", (event) -> onTriggerDown(event));
        controller2.addEventListener("triggerup", (event) -> onTriggerUp(event));
        scene.add(controller2);

        OBJLoader loader = new OBJLoader();
        loader.load("models/obj/vive-controller/vr_controller_vive_1_5.obj", new OnLoadCallback<Object3D>() {
            @Override
            public void onLoad(Object3D object) {
                TextureLoader loader = new TextureLoader();
                loader.setPath("models/obj/vive-controller/");

                Object3D controller = object.children[0];
                MeshPhongMaterial material = controller.getProperty("material");
                material.map = loader.load("onepointfive_texture.png");
                material.specularMap = loader.load("onepointfive_spec.png");
                controller1.add(object.clone());
                controller2.add(object.clone());

                BufferGeometry geometry = new BufferGeometry().setFromPoints(new Vector3[]{new Vector3(0, 0, 0), new Vector3(0, 0, -1)});
                Line line = new Line(geometry);
                line.name = "line";
                line.scale.z = 5;

                controller1.add(line.clone());
                controller2.add(line.clone());

                raycaster = new Raycaster();
                ready = true;
            }
        });
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    private void animate() {
        renderer.setAnimationLoop(() -> {
            if (container.parentNode != null && container.parentNode.parentNode != null && ready) {
                render();
            }
        });
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" webgl - htc vive");
    }

    private void onTriggerDown(Event event) {
        ViveController controller = event.getProperty("target");

        Intersect[] intersections = getIntersections(controller);

        if (intersections.length > 0) {
            Intersect intersection = intersections[0];
            tempMatrix.getInverse(controller.matrixWorld);
            Mesh object = intersection.object;
            object.matrix.premultiply(tempMatrix);
            object.matrix.decompose(object.position, object.quaternion, object.scale);
            ((MeshStandardMaterial) object.material).emissive.b = 1;
            controller.add(object);
            controller.userData.setProperty("selected", object);
        }
    }

    public void onTriggerUp(Event event) {
        ViveController controller = event.getProperty("target");

        if (controller.userData.hasProperty("selected")) {
            Mesh object = controller.userData.getProperty("selected");

            object.matrix.premultiply(controller.matrixWorld);
            object.matrix.decompose(object.position, object.quaternion, object.scale);
            ((MeshStandardMaterial) object.material).emissive.b = 0;
            group.add(object);
            controller.userData.deleteProperty("selected");
        }
    }

    public Intersect[] getIntersections(ViveController controller) {
        tempMatrix.identity().extractRotation(controller.matrixWorld);
        raycaster.ray.origin.setFromMatrixPosition(controller.matrixWorld);
        raycaster.ray.direction.set(0, 0, -1).applyMatrix4(tempMatrix);
        return raycaster.intersectObjects(group.children);
    }


    public void intersectObjects(ViveController controller) {
        // Do not highlight when already selected
        if (!controller.userData.hasProperty("selected")) return;

        Line line = (Line) controller.getObjectByName("line");
        Intersect[] intersections = getIntersections(controller);
        if (intersections.length > 0) {
            Intersect intersection = intersections[0];
            Mesh object = intersection.object;
            ((MeshStandardMaterial) object.material).emissive.r = 1;
            intersected.add(object);
            line.scale.z = intersection.distance;
        } else {
            line.scale.z = 5;
        }
    }

    public void cleanIntersected() {
        intersected.forEach(m -> ((MeshStandardMaterial) m.material).emissive.r = 0);
        intersected.clear();
    }

    public void render() {
        controller1.update();
        controller2.update();
        cleanIntersected();
        intersectObjects(controller1);
        intersectObjects(controller2);

        renderer.render(scene, camera);
    }
}
