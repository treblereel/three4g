package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.geometries.BoxLineGeometry;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.RingBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.LineSegments;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.OnAnimate;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/14/18.
 */
@InjectJavaScriptFor(elements = {WebVR.class, BoxLineGeometry.class})
public class WebVRCubes extends Attachable {

    public static final String name = "cubes";

    private Clock clock = new Clock();
    private Random rand = new Random();
    private Mesh crosshair;
    private LineSegments room;
    private HTMLDivElement container;
    private Raycaster raycaster;
    private boolean isMouseDown;
    private Mesh intersected;


    private WebVRCubes() {
        container = (HTMLDivElement) DomGlobal.document.createElement("div");

        scene = new Scene();
        scene.background = new Color(0x505050);
        camera = new PerspectiveCamera(70, aspect, 0.1f, 10);
        scene.add(camera);

        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.color = new Color(0xffffff);
        parameters.opacity = 0.5f;
        parameters.transparent = true;
        crosshair = new Mesh(
                new RingBufferGeometry(0.02f, 0.04f, 32),
                new MeshBasicMaterial(parameters)
        );
        crosshair.position.z = -2;
        camera.add(crosshair);

        room = new LineSegments(
                new BoxLineGeometry(6, 6, 6, 10, 10, 10),
                new LineBasicMaterial().setColor(0x808080)
        );

        room.position.y = 3;
        scene.add(room);
        scene.add(new HemisphereLight(0x606060, 0x404040));
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(1, 1, 1).normalize();
        scene.add(light);
        BoxBufferGeometry geometry = new BoxBufferGeometry(0.15f, 0.15f, 0.15f);

        for (int i = 0; i < 200; i++) {
            Mesh object = new Mesh(geometry, new MeshLambertMaterial());
            ((MeshLambertMaterial) object.material).color = new Color(rand.nextInt() * 0xffffff);

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

        raycaster = new Raycaster();


        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.alpha = true;

        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.vr.enabled = true;

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));

        window.addEventListener("vrdisplaypointerrestricted", (e) -> onPointerRestricted(), false);
        window.addEventListener("vrdisplaypointerunrestricted", (e) -> onPointerUnrestricted(), false);

        container.addEventListener("mousedown", (e) -> onMouseDown(), false);
        container.addEventListener("mouseup", (e) -> onMouseUp(), false);
        container.addEventListener("touchstart", (e) -> onMouseDown(), false);
        container.addEventListener("touchend", (e) -> onMouseUp(), false);
    }

    private void onMouseDown() {
        isMouseDown = true;
    }

    private void onMouseUp() {
        isMouseDown = false;
    }

    private void onPointerUnrestricted() {
        org.treblereel.gwt.three4g.demo.client.api.dom.Document currentPointerLockElement = Js.uncheckedCast(DomGlobal.document);
        org.treblereel.gwt.three4g.demo.client.api.dom.Document expectedPointerLockElement = Js.uncheckedCast(renderer.domElement);

        if (currentPointerLockElement.pointerLockElement != null && currentPointerLockElement.pointerLockElement.equals(expectedPointerLockElement)) {
            currentPointerLockElement.exitPointerLock();
        }

    }


    private void onPointerRestricted() {
        org.treblereel.gwt.three4g.demo.client.api.dom.HTMLElement pointerLockElement = (org.treblereel.gwt.three4g.demo.client.api.dom.HTMLElement) renderer.domElement;
        if (pointerLockElement != null)
            pointerLockElement.requestPointerLock();
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
        float delta = clock.getDelta() * 60;
        if (isMouseDown) {
            Object3D cube = room.children[0];
            room.remove(cube);
            cube.position.set(0, 0, -0.75f);
            cube.position.applyQuaternion(camera.quaternion);

            Vector3 velocity = cube.userData.getProperty("velocity");
            velocity.x = (rand.nextFloat() - 0.5f) * 0.02f * delta;
            velocity.y = (rand.nextFloat() - 0.5f) * 0.02f * delta;
            velocity.z = (rand.nextFloat() * 0.01f - 0.05f) * delta;
            velocity.applyQuaternion(camera.quaternion);
            room.add(cube);
        }
        // find intersections
        raycaster.setFromCamera(new Vector2(0, 0), camera);
        Intersect[] intersects = raycaster.intersectObjects(room.children);

        if (intersects.length > 0) {
            if (intersected == null) {
                intersected = intersects[0].object.cast();

                MeshLambertMaterial material = ((MeshLambertMaterial) intersected.material);
                material.userData.setProperty("currentHex", material.color.getHex());
                material.color.setHex(material.emissive.getHex());
                material.emissive.setHex(0xff0000);

            }
        } else {
            if (intersected != null) {
                MeshLambertMaterial material = (MeshLambertMaterial) intersected.material;
                material.emissive.setHex(material.userData.getProperty("currentHex"));
                intersected = null;
            }
        }
        // Keep cubes inside room
        for (int i = 0; i < room.children.length; i++) {
            Object3D cube = room.children[i];

            Vector3 velocity = cube.userData.getProperty("velocity");
            velocity.multiplyScalar(1 - (0.001f * delta));

            cube.position.add(velocity);
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

            cube.rotation.x += velocity.x * 2 * delta;
            cube.rotation.y += velocity.y * 2 * delta;
            cube.rotation.z += velocity.z * 2 * delta;
        }
        renderer.render(scene, camera);

    }
}
