package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.extensions.vr.daydream.DaydreamController;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.lights.Light;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.parameters.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.OnAnimate;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/3/18.
 */
@InjectJavaScriptFor(elements = {DaydreamController.class})
public class DayDream extends Attachable {

    public static final String name = "daydream";

    private Random rand = new Random();
    private DaydreamController controller;
    private HTMLDivElement container;


    private DayDream() {
        container = (HTMLDivElement) DomGlobal.document.createElement("div");

        scene = new Scene();
        scene.background = new Color(0x505050);
        camera = new PerspectiveCamera(70f, aspect, 0.1f, 10f);
        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(0x808080);
        meshBasicMaterialParameters.wireframe = true;

        mesh = new Mesh(
                new BoxGeometry(6f, 6f, 6f, 8, 8, 8),
                new MeshBasicMaterial(meshBasicMaterialParameters)
        );
        mesh.position.y = 3;
        scene.add(mesh);
        scene.add(new HemisphereLight(0x606060, 0x404040));
        Light light = new DirectionalLight(0xffffff);
        light.position.set(1, 1, 1).normalize();
        scene.add(light);
        Geometry geometry = new IcosahedronGeometry(0.08f, 2);


        for (int i = 0; i < 200; i++) {
            MeshLambertMaterialParameters meshLambertMaterial = new MeshLambertMaterialParameters();
            meshLambertMaterial.color = new Color(rand.nextFloat() * 0xffffff);

            Mesh object = new Mesh(geometry, new MeshLambertMaterial(meshLambertMaterial));
            object.position.x = rand.nextFloat() * 4 - 2;
            object.position.y = rand.nextFloat() * 4 - 2;
            object.position.z = rand.nextFloat() * 4 - 2;

            Vector3 velocity = new Vector3();
            velocity.x = rand.nextFloat() * 0.01f - 0.005f;
            velocity.y = rand.nextFloat() * 0.01f - 0.005f;
            velocity.z = rand.nextFloat() * 0.01f - 0.005f;

            object.userData.setProperty("velocity", velocity);
            mesh.add(object);
        }

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.alpha = true;

        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.vr.enabled = true;

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));

        controller = new DaydreamController();
        controller.position.set(0.3f, 0.75f, 0);
        scene.add(controller);

        LineBasicMaterialParameters lineBasicMaterial = new LineBasicMaterialParameters();
        lineBasicMaterial.linewidth = 2;

        BufferGeometry bufferGeometry = new BufferGeometry();
        bufferGeometry.addAttribute("position", new Float32BufferAttribute(new float[]{0f, 0f, 0f, 0f, 0f, -10f}, 3));

        Line controllerHelper = new Line(bufferGeometry, new LineBasicMaterial(lineBasicMaterial));
        controller.add(controllerHelper);

    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }

    private void animate() {
        renderer.setAnimationLoop(new OnAnimate() {
            @Override
            public void animate() {
                if (container.parentNode != null && container.parentNode.parentNode != null) {
                    render();
                }
            }
        });
    }

    private void render() {
        controller.update();
        if (controller.getTouchpadState() == true) {
            Object3D cube = mesh.children[0];
            mesh.remove(cube);
            cube.position.copy(controller.position).sub(mesh.position);

            Vector3 velocity = cube.userData.getProperty("velocity");
            velocity.x = (rand.nextFloat() - 0.5f) * 0.02f;
            velocity.y = (rand.nextFloat() - 0.5f) * 0.02f;
            velocity.z = (rand.nextFloat() * 0.02f - 0.1f);
            velocity.applyQuaternion(controller.quaternion);

            mesh.add(cube);
        }
        // keep cubes inside mesh
        float range = 3 - 0.08f;
        for (int i = 0; i < mesh.children.length; i++) {
            Object3D cube = mesh.children[i];
            Vector3 velocity = cube.userData.getProperty("velocity");
            cube.position.add(velocity);
            if (cube.position.x < -range || cube.position.x > range) {
                cube.position.x = org.treblereel.gwt.three4g.math.Math.clamp(cube.position.x, -range, range);
                velocity.x = -velocity.x;
            }
            if (cube.position.y < -range) {
                cube.position.y = Math.max(cube.position.y, -range);
                //TODO check, maybe better do not have a refrence
                velocity.x *= 0.9;
                velocity.y = -velocity.y * 0.8f;
                velocity.z *= 0.9f;
            }
            if (cube.position.z < -range || cube.position.z > range) {
                cube.position.z = org.treblereel.gwt.three4g.math.Math.clamp(cube.position.z, -range, range);
                velocity.z = -velocity.z;
            }
            velocity.y -= 0.00098;
        }
        renderer.render(scene, camera);
    }
}
