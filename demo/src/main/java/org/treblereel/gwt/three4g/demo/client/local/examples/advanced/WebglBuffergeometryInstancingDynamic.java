package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
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
public class WebglBuffergeometryInstancingDynamic extends Attachable {

    public static final String name = "buffergeometry / instancing / dynamic";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private boolean ANGLE_instanced_arrays = false;
    private RawShaderMaterial material;
    private Random random = new Random();


    private InstancedBufferAttribute offsetAttribute, orientationAttribute;
    private double lastTime = 0;
    private Quaternion moveQ = new Quaternion(0.5f, 0.5f, 0.5f, 0.0f).normalize();
    private Quaternion tmpQ = new Quaternion();
    private Quaternion currentQ = new Quaternion();


    private String fragmentShader = "precision highp float;\n" +
            "\t\tuniform sampler2D map;\n" +
            "\t\tvarying vec2 vUv;\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tgl_FragColor = texture2D( map, vUv );\n" +
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

    public WebglBuffergeometryInstancingDynamic() {


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
        // geometry
        int instances = 5000;
        BoxBufferGeometry bufferGeometry = new BoxBufferGeometry(2, 2, 2);
        // copying data from a simple box geometry, but you can specify a custom geometry if you want
        InstancedBufferGeometry geometry = new InstancedBufferGeometry();
        geometry.index = bufferGeometry.index;
        geometry.attributes.position = bufferGeometry.attributes.position;
        geometry.attributes.uv = bufferGeometry.attributes.uv;
        // per instance data
        JsArray offsets = new JsArray();
        JsArray orientations = new JsArray();
        Vector4 vector = new Vector4();
        float x, y, z, w;
        for (int i = 0; i < instances; i++) {
            // offsets
            x = random.nextFloat() * 100 - 50;
            y = random.nextFloat() * 100 - 50;
            z = random.nextFloat() * 100 - 50;
            vector.set(x, y, z, 0).normalize();
            vector.multiplyScalar(5); // move out at least 5 units from center in current direction
            offsets.push(x + vector.x, y + vector.y, z + vector.z);
            // orientations
            x = random.nextFloat() * 2 - 1;
            y = random.nextFloat() * 2 - 1;
            z = random.nextFloat() * 2 - 1;
            w = random.nextFloat() * 2 - 1;
            vector.set(x, y, z, w).normalize();
            orientations.push(vector.x, vector.y, vector.z, vector.w);
        }

        offsetAttribute = new InstancedBufferAttribute(toFloat32Array(offsets), 3);
        orientationAttribute = new InstancedBufferAttribute(toFloat32Array(orientations), 4).setDynamic(true);
        geometry.addAttribute("offset", offsetAttribute);
        geometry.addAttribute("orientation", orientationAttribute);
        // material
        RawShaderMaterialParameters rawShaderMaterialParameters = new RawShaderMaterialParameters();
        Uniforms uniforms = new Uniforms();
        uniforms.set("map", new TextureLoader().load("textures/crate.gif"));
        rawShaderMaterialParameters.uniforms = uniforms;
        rawShaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        rawShaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;

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
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        float time = (float) DomGlobal.performance.now() * 0.005f;
        mesh.rotation.y = time * 0.005f;
        float delta = (time - (float) lastTime) / 50f;
        tmpQ.set(moveQ.x * delta, moveQ.y * delta, moveQ.z * delta, 1).normalize();
        for (int i = 0, il = orientationAttribute.count; i < il; i++) {
            currentQ.fromArray(orientationAttribute.array, (i * 4));
            currentQ.multiply(tmpQ);
            orientationAttribute.setXYZW(i, currentQ.x, currentQ.y, currentQ.z, currentQ.w);
        }
        orientationAttribute.needsUpdate = true;
        lastTime = time;
        renderer.render(scene, camera);
    }
}