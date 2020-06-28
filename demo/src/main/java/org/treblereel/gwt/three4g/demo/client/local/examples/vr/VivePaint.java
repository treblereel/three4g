package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import com.google.gwt.core.client.ScriptInjector;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.api.PaintViveController;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.JSON;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/5/18.
 */
@InjectJavaScriptFor(elements = {WebVR.class, OBJLoader.class})
public class VivePaint extends Attachable {

    public static final String name = "vive / paint";
    Vector3 up = new Vector3(0, 1, 0);
    Vector3 vector1 = new Vector3();
    Vector3 vector2 = new Vector3();
    Vector3 vector3 = new Vector3();
    Vector3 vector4 = new Vector3();
    JsPropertyMap shapes = JsPropertyMap.of();
    private PaintViveController controller1, controller2;
    private boolean ready = false;
    private Mesh line;

    public VivePaint() {

        ScriptInjector.fromString(JavascriptTextResource.IMPL.getPaintViveController().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

        ScriptInjector.fromString(JavascriptTextResource.IMPL.getPaintViveController().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

        scene = new Scene();
        scene.background = new Color(0x222222);
        camera = new PerspectiveCamera(70, aspect, 0.1f, 10);

        BoxBufferGeometry geometry = new BoxBufferGeometry(0.5f, 0.8f, 0.5f);
        MeshStandardMaterial material = new MeshStandardMaterial();
        material.color = new Color(0x444444);
        material.roughness = 1.0f;
        material.metalness = 0.0f;

        Mesh table = new Mesh(geometry, material);
        table.position.y = 0.35f;
        table.position.z = 0.85f;
        table.castShadow = true;
        table.receiveShadow = true;
        scene.add(table);


        PlaneBufferGeometry planeBufferGeometry = new PlaneBufferGeometry(4, 4);
        MeshStandardMaterial meshStandardMaterial = new MeshStandardMaterial();
        meshStandardMaterial.color = new Color(0x222222);
        meshStandardMaterial.roughness = 1.0f;
        meshStandardMaterial.metalness = 0.0f;

        Mesh floor = new Mesh(planeBufferGeometry, meshStandardMaterial);
        floor.rotation.x = (float) -Math.PI / 2;
        floor.receiveShadow = true;
        scene.add(floor);
        scene.add(new GridHelper(20, 40, new Color(0x111111), new Color(0x111111)));
        scene.add(new HemisphereLight(0x888877, 0x777788));
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 6, 0);
        light.castShadow = true;
        ((OrthographicCamera) light.shadow.camera).top = 2;
        ((OrthographicCamera) light.shadow.camera).bottom = -2;
        ((OrthographicCamera) light.shadow.camera).right = 2;
        ((OrthographicCamera) light.shadow.camera).left = -2;
        light.shadow.mapSize.set(4096f, 4096f);
        scene.add(light);

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


        controller1 = new PaintViveController(0);
        controller1.standingMatrix = renderer.vr.getStandingMatrix();

        Vector3[] vectors = new Vector3[2];
        vectors[0] = new Vector3();
        vectors[1] = new Vector3();

        controller1.userData.setProperty("points", vectors);

        Matrix4[] matrices = new Matrix4[2];
        matrices[0] = new Matrix4();
        matrices[1] = new Matrix4();

        controller1.userData.setProperty("matrices", matrices);

        scene.add(controller1);
        controller2 = new PaintViveController(1);
        controller2.standingMatrix = renderer.vr.getStandingMatrix();

        vectors = new Vector3[2];
        vectors[0] = new Vector3();
        vectors[1] = new Vector3();

        controller2.userData.setProperty("points", vectors);

        matrices = new Matrix4[2];
        matrices[0] = new Matrix4();
        matrices[1] = new Matrix4();

        controller2.userData.setProperty("matrices", matrices);

        scene.add(controller2);

        OBJLoader loader = new OBJLoader();

        loader.load("models/obj/vive-controller/vr_controller_vive_1_5.obj", object -> {

            TextureLoader loader1 = new TextureLoader();
            loader1.setPath("models/obj/vive-controller/");

            Object3D controller = object.children[0];

            MeshPhongMaterial material1 = Js.uncheckedCast(Js.asPropertyMap(controller).get("material"));

            material1.map = loader1.load("onepointfive_texture.png");
            material1.specularMap = loader1.load("onepointfive_spec.png");
            controller.castShadow = true;
            controller.receiveShadow = true;

            Mesh pivot = new Mesh(new IcosahedronBufferGeometry(0.01f, 2));
            pivot.name = "pivot";
            pivot.position.y = -0.016f;
            pivot.position.z = -0.043f;
            pivot.rotation.x = (float) (Math.PI / 5.5);

            controller.add(pivot);
            controller1.add(controller.clone());
            pivot.material = pivot.material.clone();
            controller2.add(controller.clone());

            initGeometry();
            ready = true;
        }
        );


    }


    public void initGeometry() {
        BufferGeometry geometry = new BufferGeometry();
        BufferAttribute positions = new Float32BufferAttribute(new float[1000000 * 3], 3);
        positions.dynamic = true;
        geometry.addAttribute("position", positions);
        BufferAttribute normals = new Float32BufferAttribute(new float[1000000 * 3], 3);
        normals.dynamic = true;
        geometry.addAttribute("normal", normals);
        BufferAttribute colors = new Float32BufferAttribute(new float[1000000 * 3], 3);
        colors.dynamic = true;
        geometry.addAttribute("color", colors);
        geometry.drawRange.count = 0;

        MeshStandardMaterialParameters params = new MeshStandardMaterialParameters();


        MeshStandardMaterial material = new MeshStandardMaterial();
        material.roughness = 0.9f;
        material.metalness = 0.0f;
        material.vertexColors = THREE.VertexColors;
        material.side = THREE.DoubleSide;

        line = new Mesh(geometry, material);
        line.frustumCulled = false;
        line.castShadow = true;
        line.receiveShadow = true;
        scene.add(line);
        // Shapes

        shapes.set("tube", getTubeShapes(1));
        //shapes["tube"] = getTubeShapes(1.0f);


    }

    public Vector3[] getTubeShapes(int size) {
        double PI2 = Math.PI * 2;
        int sides = 10;
        Vector3[] array = new Vector3[10];
        float radius = 0.01f * size;

        for (int i = 0; i < sides; i++) {
            double angle = (i / sides) * PI2;
            array[i] = new Vector3((float) Math.sin(angle) * radius, (float) Math.cos(angle) * radius, 0);
        }
        return array;
    }

    public void stroke(PaintViveController controller1, Vector3 point1, Vector3 point2, Matrix4 matrix1, Matrix4 matrix2) {
        //Color color = controller.getColor();

        Color color = new Color();
        color.setHex(16777215);


        DomGlobal.console.log("stroke size " + color.getHex());

        Vector3[] shapes = getTubeShapes(1);


        //Vector3[] shapes = getTubeShapes(controller.getSize());

        DomGlobal.console.log("stroke shapes : " + JSON.stringify(shapes));

        //DomGlobal.console.log("stroke line : " + JSON.stringify(line));

        BufferGeometry geometry = (BufferGeometry) line.geometry;
        // DomGlobal.console.log("stroke geometry before : " + JSON.stringify(geometry));

        int count = geometry.drawRange.count;

        // DomGlobal.console.log("stroke size " + controller.getSize());


        //TODO
        float[] positions = Js.uncheckedCast(geometry.getAttribute("position").array);
        float[] normals = Js.uncheckedCast(geometry.getAttribute("normal").array);
        float[] colors = Js.uncheckedCast(geometry.getAttribute("color").array);


        for (int j = 0, jl = shapes.length; j < jl; j++) {
            Vector3 vertex1 = shapes[j];
            Vector3 vertex2 = shapes[(j + 1) % jl];

            DomGlobal.console.log("stroke %%% " + ((j + 1) % jl));


            // positions
            vector1.copy(vertex1);
            vector1.applyMatrix4(matrix2);
            vector1.add(point2);
            vector2.copy(vertex2);
            vector2.applyMatrix4(matrix2);
            vector2.add(point2);
            vector3.copy(vertex2);
            vector3.applyMatrix4(matrix1);
            vector3.add(point1);
            vector4.copy(vertex1);
            vector4.applyMatrix4(matrix1);
            vector4.add(point1);
            vector1.toArray(positions, (count + 0) * 3);
            vector2.toArray(positions, (count + 1) * 3);
            vector4.toArray(positions, (count + 2) * 3);
            vector2.toArray(positions, (count + 3) * 3);
            vector3.toArray(positions, (count + 4) * 3);
            vector4.toArray(positions, (count + 5) * 3);
            // normals
            vector1.copy(vertex1);
            vector1.applyMatrix4(matrix2);
            vector1.normalize();
            vector2.copy(vertex2);
            vector2.applyMatrix4(matrix2);
            vector2.normalize();
            vector3.copy(vertex2);
            vector3.applyMatrix4(matrix1);
            vector3.normalize();
            vector4.copy(vertex1);
            vector4.applyMatrix4(matrix1);
            vector4.normalize();
            vector1.toArray(normals, (count + 0) * 3);
            vector2.toArray(normals, (count + 1) * 3);
            vector4.toArray(normals, (count + 2) * 3);
            vector2.toArray(normals, (count + 3) * 3);
            vector3.toArray(normals, (count + 4) * 3);
            vector4.toArray(normals, (count + 5) * 3);
            // colors
            color.toArray(colors, (count + 0) * 3);
            color.toArray(colors, (count + 1) * 3);
            color.toArray(colors, (count + 2) * 3);
            color.toArray(colors, (count + 3) * 3);
            color.toArray(colors, (count + 4) * 3);
            color.toArray(colors, (count + 5) * 3);
            count += 6;
        }
        //DomGlobal.console.log("stroke geometry after : " + JSON.stringify(geometry)); 

        DomGlobal.console.log("stroke geometry color : " + JSON.stringify(color));

        DomGlobal.console.log("stroke geometry vector1 : " + JSON.stringify(vector1));
        DomGlobal.console.log("stroke geometry vector2 : " + JSON.stringify(vector2));
        DomGlobal.console.log("stroke geometry vector3 : " + JSON.stringify(vector3));
        DomGlobal.console.log("stroke geometry vector4 : " + JSON.stringify(vector4));

        geometry.drawRange.count = count;
    }

    public void updateGeometry(int start, int end) {


        if (start == end) return;

        DomGlobal.console.log("updateGeometry " + start + " " + end);


        int offset = start * 3;
        int count = (end - start) * 3;
        BufferGeometry geometry = (BufferGeometry) line.geometry;

        DomGlobal.console.log("updateGeometry offset " + offset + "  count " + count);


        geometry.getAttribute("position").updateRange.offset = offset;
        geometry.getAttribute("position").updateRange.count = count;
        geometry.getAttribute("position").needsUpdate = true;
        geometry.getAttribute("normal").updateRange.offset = offset;
        geometry.getAttribute("normal").updateRange.count = count;
        geometry.getAttribute("normal").needsUpdate = true;
        geometry.getAttribute("color").updateRange.offset = offset;
        geometry.getAttribute("color").updateRange.count = count;
        geometry.getAttribute("color").needsUpdate = true;


        DomGlobal.console.log("updateGeometry position " + JSON.stringify(geometry.getAttribute("position").array));
        DomGlobal.console.log("updateGeometry normal " + JSON.stringify(geometry.getAttribute("normal").array));
        DomGlobal.console.log("updateGeometry color " + JSON.stringify(geometry.getAttribute("color").array));


    }


    public void handleController(PaintViveController controller) {

        //    DomGlobal.console.log("handleController " + controller.name);


        controller.update();
        Mesh pivot = (Mesh) controller.getObjectByName("pivot");

        //DomGlobal.console.log("pivot" + JSON.stringify(pivot));

        if (pivot != null) {
            ((MeshBasicMaterial) pivot.material).color.copy(controller.getColor());
            pivot.scale.setScalar(controller.getSize());
            Matrix4 matrix = pivot.matrixWorld;

            Matrix4 matrixx = new Matrix4();
            matrixx.set(0.8263265804321446f, 0.0653743223568597f, 0.5593840198722803f, 0, -0.5623233023666134f, 0.15089012244220096f, 0.8130342249540927f, 0, -0.03125397059645499f, -0.9863865587698832f, 0.16144601745571446f, 0, -0.2790985798237979f, 0.9812008146829518f, 1.26712946641552f, 1);


            Vector3 point1 = ((Vector3[]) controller.userData.getProperty("points"))[0];
            Vector3 point2 = ((Vector3[]) controller.userData.getProperty("points"))[1];
            Matrix4 matrix1 = ((Matrix4[]) controller.userData.getProperty("matrices"))[0];
            Matrix4 matrix2 = ((Matrix4[]) controller.userData.getProperty("matrices"))[1];

            point1.setFromMatrixPosition(matrix);
            matrix1.lookAt(point2, point1, up);

            //DomGlobal.console.log("getButtonState " + controller.getButtonState("trigger"));


            if (controller.getButtonState("trigger")) {

/*                 DomGlobal.console.log("getButtonState controller.getSize()" + JSON.stringify(controller.getSize()));

                DomGlobal.console.log("getButtonState point1" + JSON.stringify(matrix));

                DomGlobal.console.log("getButtonState point1" + JSON.stringify(point1));
                DomGlobal.console.log("getButtonState point2" + JSON.stringify(point2));

                DomGlobal.console.log("getButtonState matrix1" + JSON.stringify(matrix1));
                DomGlobal.console.log("getButtonState matrix2" + JSON.stringify(matrix2)); */


                Vector3 point1x = new Vector3(-0.2790985798237979f, 0.9812008146829518f, 1.26712946641552f);
                Vector3 point2x = new Vector3(-0.27868371624763977f, 0.9809246232932015f, 1.2670630887135546f);

                Matrix4 matrix1x = new Matrix4();
                matrix1x.set(-0.15798940984523147f, 0, -0.9874408065179175f, 0, 0.5424167929168244f, 0.8356148637116435f, -0.08678607207379699f, 0, 0.825120214961785f, -0.5493157557763763f, -0.13201829917570607f, 0, 0, 0, 0, 1);

                Matrix4 matrix2x = new Matrix4();
                matrix2x.set(-0.3105378399815054f, 0, -0.9505610185251766f, 0, 0.7785905383552746f, 0.5736717733183716f, -0.2543569737227559f, 0, 0.5453100251446554f, -0.8190852803571523f, -0.1781467933446469f, 0, 0, 0, 0, 1);

/*                 DomGlobal.console.log("getButtonState controller.getSize()" + JSON.stringify(controller.getSize()));

                DomGlobal.console.log("getButtonState point1" + JSON.stringify(matrix));

                DomGlobal.console.log("getButtonState point1" + JSON.stringify(point1));
                DomGlobal.console.log("getButtonState point2" + JSON.stringify(point2));

                DomGlobal.console.log("getButtonState matrix1" + JSON.stringify(matrix1));
                DomGlobal.console.log("getButtonState matrix2" + JSON.stringify(matrix2)); */


                DomGlobal.console.log("getButtonState controller.getSize()" + JSON.stringify(controller.getSize()));

                DomGlobal.console.log("getButtonState point1x" + JSON.stringify(point1x));
                DomGlobal.console.log("getButtonState point2x" + JSON.stringify(point2x));

                DomGlobal.console.log("getButtonState matrix1x" + JSON.stringify(matrix1x));
                DomGlobal.console.log("getButtonState matrix2x" + JSON.stringify(matrix2x));

//                DomGlobal.console.log("getButtonState point1 after" + JSON.stringify(matrix));


                //PaintViveController paintViveController = new PaintViveController(3);

                // DomGlobal.console.log("getButtonState " + controller.getButtonState("trigger"));


                stroke(controller, point1x, point2x, matrix1x, matrix2x);
            }
            point2.copy(point1);
            matrix2.copy(matrix1);
        }
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" <a href=\"http://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> webgl - htc vive - paint");
    }

    private void render() {

        int count = ((BufferGeometry) line.geometry).drawRange.count;
        handleController(controller1);
        handleController(controller2);
        updateGeometry(count, ((BufferGeometry) line.geometry).drawRange.count);
        renderer.render(scene, camera);
    }
}
