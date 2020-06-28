package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.extensions.vr.vive.ViveController;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/4/18.
 */
@InjectJavaScriptFor(elements = {ViveController.class, OBJLoader.class})
public class Vive extends Attachable {

    public static final String name = "vive";
    private Clock clock = new Clock();

    private ViveController controller1, controller2;
    private Mesh room;
    private Random rand = new Random();
    private OBJLoader objLoader;
    private boolean ready = false;

    public Vive() {

        scene = new Scene();
        scene.background = new Color(0x505050);
        camera = new PerspectiveCamera(70, aspect, 0.1f, 10);
        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(0x404040);
        meshBasicMaterialParameters.wireframe = true;

        room = new Mesh(
                new BoxBufferGeometry(6, 6, 6, 8, 8, 8),
                new MeshBasicMaterial(meshBasicMaterialParameters)
        );
        room.position.y = 3;
        scene.add(room);
        scene.add(new HemisphereLight(0x606060, 0x404040));
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(1, 1, 1).normalize();
        scene.add(light);
        BoxBufferGeometry geometry = new BoxBufferGeometry(0.2f, 0.2f, 0.2f);
        for (int i = 0; i < 200; i++) {
            MeshLambertMaterial meshLambertMaterial = new MeshLambertMaterial();
            meshLambertMaterial.color = new Color(rand.nextFloat() * 0xffffff);

            Mesh object = new Mesh(geometry, meshLambertMaterial);

            object.position.x = rand.nextFloat() * 4 - 2;
            object.position.y = rand.nextFloat() * 4 - 2;
            object.position.z = rand.nextFloat() * 4 - 2;
            object.rotation.x = rand.nextFloat() * 2 * (float) Math.PI;
            object.rotation.y = rand.nextFloat() * 2 * (float) Math.PI;
            object.rotation.z = rand.nextFloat() * 2 * (float) Math.PI;
            object.scale.x = rand.nextFloat() + 0.5f;
            object.scale.y = rand.nextFloat() + 0.5f;
            object.scale.z = rand.nextFloat() + 0.5f;

            Vector3 velocity = new Vector3();
            velocity.x = rand.nextFloat() * 0.01f - 0.005f;
            velocity.y = rand.nextFloat() * 0.01f - 0.005f;
            velocity.z = rand.nextFloat() * 0.01f - 0.005f;
            object.userData.setProperty("velocity", velocity);
            room.add(object);
        }
        MeshStandardMaterial material = new MeshStandardMaterial();
        objLoader = new OBJLoader();
        objLoader.load("models/obj/cerberus/Cerberus.obj", object -> {
            Group group = (Group) object;

            TextureLoader textureLoader = new TextureLoader();
            material.roughness = 1;
            material.metalness = 1;
            material.map = textureLoader.load("models/obj/cerberus/Cerberus_A.jpg");
            material.roughnessMap = textureLoader.load("models/obj/cerberus/Cerberus_R.jpg");
            material.metalnessMap = textureLoader.load("models/obj/cerberus/Cerberus_M.jpg");
            material.normalMap = textureLoader.load("models/obj/cerberus/Cerberus_N.jpg");
            material.map.wrapS = THREE.RepeatWrapping;
            material.roughnessMap.wrapS = THREE.RepeatWrapping;
            material.metalnessMap.wrapS = THREE.RepeatWrapping;
            material.normalMap.wrapS = THREE.RepeatWrapping;

            group.traverse(object12 -> {
                if (object12 instanceof Mesh) {
                    ((Mesh) object12).material = material;
                }
            });
            group.traverse(object1 -> {
                if (object1 instanceof Mesh) {
                    ((Mesh) object1).material = material;
                }
            });

            group.position.y = -2;
            group.rotation.y = (float) -Math.PI / 2;
            room.add(group);


            CubeTextureLoader cubeTextureLoader = new CubeTextureLoader();
            cubeTextureLoader.setPath("textures/cube/pisa/");
            String[] urls = new String[6];
            urls[0] = "px.png";
            urls[1] = "nx.png";
            urls[2] = "py.png";
            urls[3] = "ny.png";
            urls[4] = "pz.png";
            urls[5] = "nz.png";

            cubeTextureLoader.load(urls, object14 -> material.envMap = object14);

            WebGLRendererParameters parameters = new WebGLRendererParameters();
            parameters.alpha = true;

            renderer = new WebGLRenderer(parameters);
            renderer.setSize(window.innerWidth, window.innerHeight);
            renderer.vr.enabled = true;

            container.appendChild(renderer.domElement);
            container.appendChild(WebVR.createButton(renderer));

            controller1 = new ViveController(0);
            controller1.standingMatrix = renderer.vr.getStandingMatrix();
            scene.add(controller1);

            controller2 = new ViveController(1);
            controller2.standingMatrix = renderer.vr.getStandingMatrix();
            scene.add(controller2);

            objLoader = new OBJLoader();
            objLoader.load("models/obj/vive-controller/vr_controller_vive_1_5.obj", object13 -> {

                TextureLoader loader = new TextureLoader();
                loader.setPath("models/obj/vive-controller/");

                Object3D controller = object13.children[0];
                MeshPhongMaterial material1 = Js.uncheckedCast(Js.asPropertyMap(controller).get("material"));

                material1.map = loader.load("onepointfive_texture.png");
                material1.specularMap = loader.load("onepointfive_spec.png");

                controller1.add(object13.clone());
                controller2.add(object13.clone());

                ready = true;
            });

        });

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  webgl - htc vive");
    }

    private void render() {
        double delta = clock.getDelta() * 60;
        controller1.update();
        controller2.update();

        for (int i = 0; i < room.children.length; i++) {
            Mesh cube = Js.uncheckedCast(room.children[i]);
            if (!(cube.geometry instanceof BoxBufferGeometry))
                continue;

            Vector3 velocity = cube.userData.getProperty("velocity");
            if (cube.position.x < -3 || cube.position.x > 3) {
                cube.position.x = org.treblereel.gwt.three4g.math.Math.clamp(cube.position.x, -3, 3);
                velocity.x = -velocity.x;
            }
            if (cube.position.y < -3 || cube.position.y > 3) {
                cube.position.y = org.treblereel.gwt.three4g.math.Math.clamp(cube.position.y, -3, 3);
                velocity.y = -velocity.y;
            }
            if (cube.position.z < -3 || cube.position.z > 3) {
                cube.position.z = org.treblereel.gwt.three4g.math.Math.clamp(cube.position.z, -3, 3);
                velocity.z = -velocity.z;
            }
            cube.rotation.x += 0.01 * delta;
        }
        renderer.render(scene, camera);
    }
}
