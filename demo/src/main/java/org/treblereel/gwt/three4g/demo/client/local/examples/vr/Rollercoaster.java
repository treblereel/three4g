package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import com.google.gwt.core.client.ScriptInjector;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import jsinterop.annotations.JsFunction;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.api.RollerCoasterGeometry;
import org.treblereel.gwt.three4g.demo.client.api.RollerCoasterLiftersGeometry;
import org.treblereel.gwt.three4g.demo.client.api.RollerCoasterShadowGeometry;
import org.treblereel.gwt.three4g.demo.client.api.SkyGeometry;
import org.treblereel.gwt.three4g.demo.client.api.TreesGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.geometries.CylinderBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/3/18.
 */
@InjectJavaScriptFor(elements = {WebVR.class})
public class Rollercoaster extends Attachable {

    public static final String name = "rollercoaster";

    private HTMLDivElement container;
    private List<Mesh> funfairs = new ArrayList<>();

    private Vector3 position = new Vector3();
    private Vector3 tangent = new Vector3();
    private Vector3 lookAt = new Vector3();
    private Vector3 vertex = new Vector3();


    private double velocity = 0;
    private double progress = 0;
    private Object3D train;
    private double prevTime;
    private double PI2 = Math.PI * 2;

    public Rollercoaster() {

        ScriptInjector.fromString(JavascriptTextResource.IMPL.getRollercoaster().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

        container = (HTMLDivElement) DomGlobal.document.createElement("div");
        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.alpha = true;
        parameters.antialias = true;

        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.vr.enabled = true;

        //renderer.vr.userHeight = 0; // TOFIX

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));


        scene = new Scene();
        scene.background = new Color(0xf0f0ff);
        HemisphereLight light = new HemisphereLight(0xfff0f0, 0x606066);
        light.position.set(1, 1, 1);
        scene.add(light);

        train = new Object3D();
        scene.add(train);

        camera = new PerspectiveCamera(40, aspect, 0.1f, 500);
        train.add(camera);
        // environment
        PlaneBufferGeometry geometry = new PlaneBufferGeometry(500, 500, 15, 15);
        geometry.rotateX((float) -Math.PI / 2);

        float[] positions = Js.uncheckedCast(geometry.getAttribute("position").array);

        for (int i = 0; i < positions.length; i += 3) {
            vertex.fromArray(positions, i);
            vertex.x += Math.random() * 10 - 5;
            vertex.z += Math.random() * 10 - 5;
            float distance = (vertex.distanceTo(scene.position) / 5) - 25;
            vertex.y = (float) Math.random() * Math.max(0, distance);
            vertex.toArray(positions, i);
        }

        geometry.computeVertexNormals();

        MeshLambertMaterial meshLambertMaterial = new MeshLambertMaterial();
        meshLambertMaterial.color = new Color(0x407000);
        mesh = new Mesh(geometry, meshLambertMaterial);
        scene.add(mesh);


        TreesGeometry treesGeometry = new TreesGeometry(mesh);
        MeshBasicMaterial meshBasicMaterial = new MeshBasicMaterial();

        meshBasicMaterial.side = THREE.DoubleSide;
        meshBasicMaterial.vertexColors = THREE.VertexColors;
        mesh = new Mesh(treesGeometry, meshBasicMaterial);
        scene.add(mesh);

        SkyGeometry skyGeometry = new SkyGeometry();
        meshBasicMaterial = new MeshBasicMaterial();
        meshBasicMaterial.color = new Color(0xffffff);
        mesh = new Mesh(skyGeometry, meshBasicMaterial);
        scene.add(mesh);

        JsPropertyMap map = JsPropertyMap.of();
        map.set("getPointAt", calcGetPointAt());
        map.set("getTangentAt", calcGetTangentAt());


        RollerCoasterGeometry rollerCoasterGeometry = new RollerCoasterGeometry(map, 1500);

        MeshPhongMaterial meshPhongMaterial = new MeshPhongMaterial();

        meshPhongMaterial.vertexColors = THREE.VertexColors;


        mesh = new Mesh(rollerCoasterGeometry, meshPhongMaterial);
        scene.add(mesh);

        mesh = new Mesh(new RollerCoasterLiftersGeometry(map, 100), new MeshPhongMaterial());
        mesh.position.y = 0.1f;
        scene.add(mesh);

        meshBasicMaterial = new MeshBasicMaterial();
        meshBasicMaterial.color = new Color(0x305000);
        meshBasicMaterial.depthWrite = false;
        meshBasicMaterial.transparent = true;
        mesh = new Mesh(new RollerCoasterShadowGeometry(map, 500), meshBasicMaterial);
        mesh.position.y = 0.1f;
        scene.add(mesh);
        //
        CylinderBufferGeometry cylinderBufferGeometry = new CylinderBufferGeometry(10, 10, 5, 15);
        meshLambertMaterial = new MeshLambertMaterial();
        meshLambertMaterial.color = new Color(0xff8080);

        mesh = new Mesh(cylinderBufferGeometry, meshLambertMaterial);
        mesh.position.set(-80, 10, -70);
        mesh.rotation.x = (float) Math.PI / 2;
        scene.add(mesh);
        funfairs.add(mesh);

        cylinderBufferGeometry = new CylinderBufferGeometry(5, 6, 4, 10);
        meshLambertMaterial = new MeshLambertMaterial();
        meshLambertMaterial.color = new Color(0x8080ff);

        mesh = new Mesh(cylinderBufferGeometry, meshLambertMaterial);
        mesh.position.set(50, 2, 30);
        scene.add(mesh);
        funfairs.add(mesh);

        prevTime = window.performance.now();
    }

    public Calculate calcGetPointAt() {
        return (t) -> getPointAt(t);
    }

    public Calculate calcGetTangentAt() {
        return (t) -> getTangentAt(t);
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
        renderer.setAnimationLoop(() -> {
            if (container.parentNode != null && container.parentNode.parentNode != null) {
                render();
            }
        });
    }

    private void render() {
        double time = window.performance.now();
        double delta = time - prevTime;

        funfairs.forEach(fun -> fun.rotation.y = (float) (time * 0.0004));

        progress += velocity;
        progress = progress % 1;
        position.copy(getPointAt(progress));
        position.y += 0.3;
        train.position.copy(position);
        tangent.copy(getTangentAt(progress));

        velocity -= tangent.y * 0.0000001 * delta;
        velocity = Math.max(0.00004, Math.min(0.0002, velocity));
        train.lookAt(lookAt.copy(position).sub(tangent));

        renderer.render(scene, camera);
        prevTime = time;

    }

    private Vector3 getPointAt(double t) {
        t = t * PI2;
        double x = Math.sin(t * 3) * Math.cos(t * 4) * 50;
        double y = Math.sin(t * 10) * 2 + Math.cos(t * 17) * 2 + 5;
        double z = Math.sin(t) * Math.sin(t * 4) * 50;
        return new Vector3().set((float) x, (float) y, (float) z).multiplyScalar(2);
    }

    private Vector3 getTangentAt(double t) {
        double delta = 0.0001;
        double t1 = Math.max(0, t - delta);
        double t2 = Math.min(1, t + delta);
        return new Vector3().copy(this.getPointAt(t2)).sub(this.getPointAt(t1)).normalize();
    }

    @JsFunction
    public interface Calculate {
        Vector3 calc(double x);
    }

}