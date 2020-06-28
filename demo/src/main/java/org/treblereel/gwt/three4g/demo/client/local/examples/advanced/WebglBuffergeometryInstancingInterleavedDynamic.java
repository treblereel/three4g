package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.core.Uint16Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferGeometry;
import org.treblereel.gwt.three4g.core.InstancedInterleavedBuffer;
import org.treblereel.gwt.three4g.core.InterleavedBuffer;
import org.treblereel.gwt.three4g.core.InterleavedBufferAttribute;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.RawShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.RawShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
public class WebglBuffergeometryInstancingInterleavedDynamic extends Attachable {

    public static final String name = "buffergeometry / instancing / interleaved / dynamic";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private boolean ANGLE_instanced_arrays = false;
    private RawShaderMaterial material;
    private Random random = new Random();
    private InstancedInterleavedBuffer instanceBuffer;
    private InterleavedBufferAttribute orientations;


    private InstancedBufferAttribute offsetAttribute, orientationAttribute;
    private double lastTime = 0;
    private Quaternion moveQ = new Quaternion(0.5f, 0.5f, 0.5f, 0.0f).normalize();
    private Quaternion tmpQ = new Quaternion();
    private Quaternion currentQ = new Quaternion();


    private String fragmentShader = "precision highp float;\n" +
            "\t\tuniform sampler2D map;\n" +
            "\t\tvarying vec2 vUv;\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tgl_FragColor = texture2D(map, vUv);\n" +
            "\t\t}";


    private String vertexShader = "precision highp float;\n" +
            "\t\tuniform mat4 modelViewMatrix;\n" +
            "\t\tuniform mat4 projectionMatrix;\n" +
            "\t\tattribute vec3 position;\n" +
            "\t\tattribute vec3 offset;\n" +
            "\t\tattribute vec2 uv;\n" +
            "\t\tattribute vec4 orientation;\n" +
            "\t\tvarying vec2 vUv;\n" +
            "\t\t// http://www.geeks3d.com/20141201/how-to-rotate-a-vertex-by-a-quaternion-in-glsl/\n" +
            "\t\tvec3 applyQuaternionToVector( vec4 q, vec3 v ){\n" +
            "\t\t\treturn v + 2.0 * cross( q.xyz, cross( q.xyz, v ) + q.w * v );\n" +
            "\t\t}\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tvec3 vPosition = applyQuaternionToVector( orientation, position );\n" +
            "\t\t\tvUv = uv;\n" +
            "\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( offset + vPosition, 1.0 );\n" +
            "\t\t}";

    public WebglBuffergeometryInstancingInterleavedDynamic() {


        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);


        camera = new PerspectiveCamera(50, aspect, 1, 1000);
        scene = new Scene();
        scene.background = new Color(0x101010);
        renderer = new WebGLRenderer();
        // geometry
        int instances = 5000;
        InstancedBufferGeometry geometry = new InstancedBufferGeometry();
        // per mesh data x,y,z,w,u,v,s,t for 4-element alignment
        // only use x,y,z and u,v; but x, y, z, nx, ny, nz, u, v would be a good layout
        InterleavedBuffer vertexBuffer = new InterleavedBuffer(Float32Array.of(
                // Front
                -1, 1, 1, 0, 0, 0, 0, 0,
                1, 1, 1, 0, 1, 0, 0, 0,
                -1, -1, 1, 0, 0, 1, 0, 0,
                1, -1, 1, 0, 1, 1, 0, 0,
                // Back
                1, 1, -1, 0, 1, 0, 0, 0,
                -1, 1, -1, 0, 0, 0, 0, 0,
                1, -1, -1, 0, 1, 1, 0, 0,
                -1, -1, -1, 0, 0, 1, 0, 0,
                // Left
                -1, 1, -1, 0, 1, 1, 0, 0,
                -1, 1, 1, 0, 1, 0, 0, 0,
                -1, -1, -1, 0, 0, 1, 0, 0,
                -1, -1, 1, 0, 0, 0, 0, 0,
                // Right
                1, 1, 1, 0, 1, 0, 0, 0,
                1, 1, -1, 0, 1, 1, 0, 0,
                1, -1, 1, 0, 0, 0, 0, 0,
                1, -1, -1, 0, 0, 1, 0, 0,
                // Top
                -1, 1, 1, 0, 0, 0, 0, 0,
                1, 1, 1, 0, 1, 0, 0, 0,
                -1, 1, -1, 0, 0, 1, 0, 0,
                1, 1, -1, 0, 1, 1, 0, 0,
                // Bottom
                1, -1, 1, 0, 1, 0, 0, 0,
                -1, -1, 1, 0, 0, 0, 0, 0,
                1, -1, -1, 0, 1, 1, 0, 0,
                -1, -1, -1, 0, 0, 1, 0, 0
        ), 8);
        // Use vertexBuffer, starting at offset 0, 3 items in position attribute
        InterleavedBufferAttribute positions = new InterleavedBufferAttribute(vertexBuffer, 3, 0);
        geometry.addAttribute("position", positions);
        // Use vertexBuffer, starting at offset 4, 2 items in uv attribute
        InterleavedBufferAttribute uvs = new InterleavedBufferAttribute(vertexBuffer, 2, 4);
        geometry.addAttribute("uv", uvs);
        Uint16Array indices = Uint16Array.of(
                0, 1, 2,
                2, 1, 3,
                4, 5, 6,
                6, 5, 7,
                8, 9, 10,
                10, 9, 11,
                12, 13, 14,
                14, 13, 15,
                16, 17, 18,
                18, 17, 19,
                20, 21, 22,
                22, 21, 23
        );
        geometry.setIndex(new BufferAttribute(indices, 1));
        // per instance data
        instanceBuffer = new InstancedInterleavedBuffer(new Float32Array(instances * 8), 8, 1).setDynamic(true);

        InterleavedBufferAttribute offsets = new InterleavedBufferAttribute(instanceBuffer, 3, 0);
        Vector4 vector = new Vector4();
        for (int i = 0, ul = offsets.count; i < ul; i++) {
            float x = random.nextFloat() * 100 - 50;
            float y = random.nextFloat() * 100 - 50;
            float z = random.nextFloat() * 100 - 50;
            vector.set(x, y, z, 0).normalize();
            // move out at least 5 units from center in current direction
            offsets.setXYZ(i, x + vector.x * 5, y + vector.y * 5, z + vector.z * 5);
        }
        geometry.addAttribute("offset", offsets); // per mesh translation
        orientations = new InterleavedBufferAttribute(instanceBuffer, 4, 4);
        for (int i = 0, ul = orientations.count;
             i < ul; i++)

        {
            vector.set(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1);
            vector.normalize();
            orientations.setXYZW(i, vector.x, vector.y, vector.z, vector.w);
        }
        geometry.addAttribute("orientation", orientations); // per mesh orientation
        // material
        // material
        RawShaderMaterialParameters rawShaderMaterialParameters = new RawShaderMaterialParameters();
        Uniforms uniforms = new Uniforms();
        uniforms.set("map", new TextureLoader().load("textures/crate.gif"));
        rawShaderMaterialParameters.uniforms = uniforms;
        rawShaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        rawShaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;

        rawShaderMaterialParameters.side = THREE.DoubleSide;
        rawShaderMaterialParameters.transparent = false;

        material = new RawShaderMaterial(rawShaderMaterialParameters);
        mesh = new Mesh(geometry, material);
        scene.add(mesh);
        //
        if (renderer.extensions.hasProperty("ANGLE_instanced_arrays")) {
            ANGLE_instanced_arrays = false;
        }

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        String text = " - indexed instancing (single box), dynamic updates";
        if (!ANGLE_instanced_arrays) {
            text = text + "<br><div id=\"notSupported\" style=\"display:none\">Sorry your graphics card + browser does not support hardware instancing</div>";
        }

        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(text);
    }

    private Float32Array toFloat32Array(JsArray<Double> array) {
        Float32Array offsetsFloat32Array = new Float32Array(array.length);
        for (int i = 0; i < array.length; i++) {
            offsetsFloat32Array.setAt(i, Js.uncheckedCast(array.getAt(i))); //TODO looks like a gwt bug
        }
        return offsetsFloat32Array;
    }

    private void animate() {
        StatsProducer.getStats().update();
        DomGlobal.requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        float time = (float) DomGlobal.performance.now() * 0.005f;
        Object3D object = scene.children[0];
        object.rotation.y = time * 0.00005f;
        renderer.render(scene, camera);
        float delta = (float)((time - lastTime) / 5000);
        tmpQ.set(moveQ.x * delta, moveQ.y * delta, moveQ.z * delta, 1).normalize();
        for (int i = 0, ul = orientations.count; i < ul; i++) {
            int index = i * instanceBuffer.stride + orientations.offset;
            currentQ.set(instanceBuffer.array.getAt(index).floatValue(), instanceBuffer.array.getAt(index + 1).floatValue(), instanceBuffer.array.getAt(index + 2).floatValue(), instanceBuffer.array.getAt(index + 3).floatValue());
            currentQ.multiply(tmpQ);
            orientations.setXYZW(i, currentQ.x, currentQ.y, currentQ.z, currentQ.w);
        }
        instanceBuffer.needsUpdate = true;
        renderer.render(scene, camera);
    }

}