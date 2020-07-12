package org.treblereel.gwt.three4g.demo.client.local.examples.controls;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.KeyboardEvent;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.PointerLockControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 10/10/18.
 */
@InjectJavaScriptFor(elements = PointerLockControls.class)
public class MiscControlsPointerlock extends Attachable {
    private HTMLDivElement blocker = (HTMLDivElement) document.createElement("div");
    private HTMLDivElement instructions = (HTMLDivElement) document.createElement("div");

    private final String content =
            "\t\t\t\t<span style=\"font-size:40px\">Click to play</span>\n" +
                    "\t\t\t\t<br />\n" +
                    "\t\t\t\t(W, A, S, D = Move, SPACE = Jump, MOUSE = Look around)\n";

    public static final String name = "controls / pointerlock";
    private Mesh[] objects = new Mesh[500];
    private Raycaster raycaster;
    private boolean moveForward = false;
    private boolean moveBackward = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean canJump = false;
    private Vector3 velocity = new Vector3();
    private Vector3 direction = new Vector3();
    private Vector3 vertex = new Vector3();
    private Color color = new Color();
    private PointerLockControls controls;
    private Random random = new Random();
    private double prevTime = window.performance.now();
    private EventListener keydown = evt -> onKeyDown(evt);
    private EventListener keyup = evt -> onKeyUp(evt);

    public MiscControlsPointerlock() {

        DomGlobal.console.log("1");


        instructions.innerHTML = content;
        instructions.id = "instructions";
        blocker.appendChild(instructions);
        blocker.id = "blocker";

        document.body.appendChild(blocker);

        //root.appendChild(blocker);


        camera = new PerspectiveCamera(75, aspect, 1, 1000);
        scene = new Scene();
        scene.background = new Color(0xffffff);
        DomGlobal.console.log("1.1");


        scene.fog = new Fog(0xffffff, 0, 750);
        HemisphereLight light = new HemisphereLight(0xeeeeff, 0x777788, 0.75f);
        light.position.set(0.5f, 1, 0.75f);

        scene.add(light);
        DomGlobal.console.log("1.1.4 ");

        controls = new PointerLockControls(camera, document.body);
        DomGlobal.console.log("1.2");


        instructions.addEventListener("click", evt -> controls.lock(), false);

        DomGlobal.console.log("2");


        controls.addEventListener("lock", evt -> {
            instructions.style.display = "none";
            blocker.style.display = "none";
        });

        controls.addEventListener("unlock", evt -> {
            blocker.style.display = "block";
            instructions.style.display = "";
        });


        scene.add(controls.getObject());

        DomGlobal.console.log("3");


        raycaster = new Raycaster(new Vector3(), new Vector3(0, -1, 0), 0, 10);
        // floor
        BufferGeometry floorGeometry = new PlaneBufferGeometry(2000, 2000, 100, 100);

        floorGeometry.rotateX((float) -Math.PI / 2);
        // vertex displacement
        BufferAttribute position = floorGeometry.attributes.position;
        for (int i = 0, l = position.count; i < l; i++) {
            vertex.fromBufferAttribute(position, i);
            vertex.x += Math.random() * 20 - 10;
            vertex.y += Math.random() * 2;
            vertex.z += Math.random() * 20 - 10;
            position.setXYZ(i, vertex.x, vertex.y, vertex.z);
        }
        DomGlobal.console.log("4");

        floorGeometry = floorGeometry.toNonIndexed(); // ensure each face has unique vertices

        position = floorGeometry.attributes.position;
        JsArray<Float> colors = new JsArray<>();


        for (int i = 0, l = position.count; i < l; i++) {
            color.setHSL(random.nextFloat() * 0.3f + 0.5f, 0.75f, random.nextFloat() * 0.25f + 0.75f);

            colors.push(color.r, color.g, color.b);
        }

        DomGlobal.console.log("5");

        floorGeometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        MeshBasicMaterial floorMaterial = new MeshBasicMaterial();
        floorMaterial.vertexColors = THREE.VertexColors;
        Mesh floor = new Mesh(floorGeometry, floorMaterial);
        scene.add(floor);
        // objects
        BufferGeometry boxGeometry = new BoxBufferGeometry(20, 20, 20);
        boxGeometry = boxGeometry.toNonIndexed(); // ensure each face has unique vertices
        position = boxGeometry.attributes.position;
        colors = new JsArray<>();
        for (int i = 0, l = position.count; i < l; i++) {
            color.setHSL(random.nextFloat() * 0.3f + 0.5f, 0.75f, random.nextFloat() * 0.25f + 0.75f);
            colors.push(color.r, color.g, color.b);
        }
        boxGeometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        DomGlobal.console.log("6");

        MeshPhongMaterialParameters meshPhongMaterialParameters = new MeshPhongMaterialParameters();
        meshPhongMaterialParameters.specular = new Color(0xffffff);
        meshPhongMaterialParameters.flatShading = true;
        meshPhongMaterialParameters.vertexColors = THREE.VertexColors;

        for (int i = 0; i < 500; i++) {
            MeshPhongMaterial boxMaterial = new MeshPhongMaterial(meshPhongMaterialParameters);
            boxMaterial.color.setHSL(random.nextFloat() * 0.2f + 0.5f, 0.75f, random.nextFloat() * 0.25f + 0.75f);
            Mesh box = new Mesh(boxGeometry, boxMaterial);
            box.position.x = (float) Math.floor(Math.random() * 20 - 10) * 20;
            box.position.y = (float) Math.floor(Math.random() * 20) * 20 + 10;
            box.position.z = (float) Math.floor(Math.random() * 20 - 10) * 20;
            scene.add(box);
            objects[i] = box;
        }

        DomGlobal.console.log("7");

        setupWebGLRenderer(renderer);
        renderer.shadowMap.enabled = true;

        document.addEventListener("keydown", keydown, false);
        document.addEventListener("keyup", keyup, false);
    }

    private void onKeyDown(Event evt) {
        if (evt instanceof KeyboardEvent) {
            KeyboardEvent ev = (KeyboardEvent) evt;
            switch (ev.code) {
                case "ArrowUp": // up
                case "KeyW": // w
                    moveForward = true;
                    break;
                case "ArrowLeft": // left
                case "KeyA": // a
                    moveLeft = true;
                    break;
                case "ArrowDown": // down
                case "KeyS": // s
                    moveBackward = true;
                    break;
                case "ArrowRight": // right
                case "KeyD": // d
                    moveRight = true;
                    break;
                case "Space": // space
                    if (canJump == true) velocity.y += 350;
                    canJump = false;
                    break;
            }
        }
    }

    private void onKeyUp(Event evt) {
        if (evt instanceof KeyboardEvent) {
            KeyboardEvent ev = (KeyboardEvent) evt;
            switch (ev.code) {
                case "ArrowUp": // up
                case "KeyW": // w
                    moveForward = false;
                    break;
                case "ArrowLeft": // left
                case "KeyA": // a
                    moveLeft = false;
                    break;
                case "ArrowDown": // down
                case "KeyS": // s
                    moveBackward = false;
                    break;
                case "ArrowRight": // right
                case "KeyD": // d
                    moveRight = false;
                    break;
            }
        }
    }

    @Override
    public void detach() {
        super.detach();
        blocker.style.display = "none";
        blocker.parentNode.removeChild(blocker);
        document.removeEventListener("keyup", keyup);
        document.removeEventListener("keydown", keydown);
        controls.dispose();
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                render();
                animate();
            }
        });
    }

    private void render() {
        if (controls.isLocked) {
            DomGlobal.console.log("1111");
            raycaster.ray.origin.copy(controls.getObject().position);
            raycaster.ray.origin.y -= 10;
            Intersect[] intersections = raycaster.intersectObjects(objects);
            boolean onObject = intersections.length > 0;
            double time = window.performance.now();
            float delta = (float) (time - prevTime) / 1000;
            velocity.x -= velocity.x * 10.0 * delta;
            velocity.z -= velocity.z * 10.0 * delta;
            velocity.y -= 9.8 * 100.0 * delta; // 100.0 = mass
            direction.z = toInt(moveForward) - toInt(moveBackward);
            direction.x = toInt(moveLeft) - toInt(moveRight);

            direction.normalize(); // this ensures consistent movements in all directions
            if (moveForward || moveBackward) velocity.z -= direction.z * 400.0 * delta;
            if (moveLeft || moveRight) velocity.x -= direction.x * 400.0 * delta;

            if (onObject) {
                velocity.y = Math.max(0, velocity.y);
                canJump = true;
            }
            controls.getObject().translateX(velocity.x * delta);
            controls.getObject().translateY(velocity.y * delta);
            controls.getObject().translateZ(velocity.z * delta);
            if (controls.getObject().position.y < 10) {
                velocity.y = 0;
                controls.getObject().position.y = 10;
                canJump = true;
            }
            prevTime = time;
        }
        renderer.render(scene, camera);
    }

    private int toInt(boolean value) {
        return value ? 1 : 0;
    }

    @Override
    protected void doAttachScene() {
        blocker.style.display = "block";
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }
}
