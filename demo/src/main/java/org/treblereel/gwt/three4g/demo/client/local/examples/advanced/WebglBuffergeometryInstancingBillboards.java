package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.CircleBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.RawShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.RawShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/21/18.
 */
public class WebglBuffergeometryInstancingBillboards extends Attachable {

    public static final String name = "buffergeometry / instancing / billboards";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private boolean ANGLE_instanced_arrays = false;
    private InstancedBufferGeometry geometry;
    private RawShaderMaterial material;


    private String fragmentShader = "\tprecision highp float;\n" +
            "\t\tuniform sampler2D map;\n" +
            "\t\tvarying vec2 vUv;\n" +
            "\t\tvarying float vScale;\n" +
            "\t\t// HSL to RGB Convertion helpers\n" +
            "\t\tvec3 HUEtoRGB(float H){\n" +
            "\t\t\tH = mod(H,1.0);\n" +
            "\t\t\tfloat R = abs(H * 6.0 - 3.0) - 1.0;\n" +
            "\t\t\tfloat G = 2.0 - abs(H * 6.0 - 2.0);\n" +
            "\t\t\tfloat B = 2.0 - abs(H * 6.0 - 4.0);\n" +
            "\t\t\treturn clamp(vec3(R,G,B),0.0,1.0);\n" +
            "\t\t}\n" +
            "\t\tvec3 HSLtoRGB(vec3 HSL){\n" +
            "\t\t\tvec3 RGB = HUEtoRGB(HSL.x);\n" +
            "\t\t\tfloat C = (1.0 - abs(2.0 * HSL.z - 1.0)) * HSL.y;\n" +
            "\t\t\treturn (RGB - 0.5) * C + HSL.z;\n" +
            "\t\t}\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tvec4 diffuseColor = texture2D( map, vUv );\n" +
            "\t\t\tgl_FragColor = vec4( diffuseColor.xyz * HSLtoRGB(vec3(vScale/5.0, 1.0, 0.5)), diffuseColor.w );\n" +
            "\t\t\tif ( diffuseColor.w < 0.5 ) discard;\n" +
            "\t\t}";


    private String vertexShader = "precision highp float;\n" +
            "\t\tuniform mat4 modelViewMatrix;\n" +
            "\t\tuniform mat4 projectionMatrix;\n" +
            "\t\tuniform float time;\n" +
            "\t\tattribute vec3 position;\n" +
            "\t\tattribute vec2 uv;\n" +
            "\t\tattribute vec3 translate;\n" +
            "\t\tvarying vec2 vUv;\n" +
            "\t\tvarying float vScale;\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tvec4 mvPosition = modelViewMatrix * vec4( translate, 1.0 );\n" +
            "\t\t\tvec3 trTime = vec3(translate.x + time,translate.y + time,translate.z + time);\n" +
            "\t\t\tfloat scale =  sin( trTime.x * 2.1 ) + sin( trTime.y * 3.2 ) + sin( trTime.z * 4.3 );\n" +
            "\t\t\tvScale = scale;\n" +
            "\t\t\tscale = scale * 10.0 + 10.0;\n" +
            "\t\t\tmvPosition.xyz += position * scale;\n" +
            "\t\t\tvUv = uv;\n" +
            "\t\t\tgl_Position = projectionMatrix * mvPosition;\n" +
            "\t\t}";

    public WebglBuffergeometryInstancingBillboards() {


        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);


        camera = new PerspectiveCamera(50, aspect, 1, 5000);
        camera.position.z = 1400;
        scene = new Scene();
        CircleBufferGeometry circleGeometry = new CircleBufferGeometry(1, 6);
        geometry = new InstancedBufferGeometry();
        geometry.index = circleGeometry.index;
        geometry.attributes = circleGeometry.attributes;
        int particleCount = 75000;
        Float32Array translateArray = new Float32Array(particleCount * 3);
        for (int i = 0, i3 = 0, l = particleCount; i < l; i++, i3 += 3) {
            translateArray.setAt(i3 + 0, Math.random() * 2 - 1);
            translateArray.setAt(i3 + 1, Math.random() * 2 - 1);
            translateArray.setAt(i3 + 2, Math.random() * 2 - 1);
        }
        geometry.addAttribute("translate", new InstancedBufferAttribute(translateArray, 3, true));

        RawShaderMaterialParameters rawShaderMaterialParameters = new RawShaderMaterialParameters();
        Uniforms uniforms = new Uniforms();
        uniforms.set("time", 0.0);
        uniforms.set("map", new TextureLoader().load("textures/sprites/circle.png"));
        rawShaderMaterialParameters.uniforms = uniforms;
        rawShaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        rawShaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        rawShaderMaterialParameters.depthTest = true;
        rawShaderMaterialParameters.depthWrite = true;

        material = new RawShaderMaterial(rawShaderMaterialParameters);

        mesh = new Mesh(geometry, material);
        mesh.scale.set(500, 500, 500);
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
        String text = " - instanced circle billboards - colors";
        if (!ANGLE_instanced_arrays) {
            text = text + "<br><div id=\"notSupported\" style=\"display:none\">Sorry your graphics card + browser does not support hardware instancing</div>";
        }

        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(text);
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
        float time = (float) DomGlobal.performance.now() * 0.0005f;
        material.uniforms.set("time", time);
        mesh.rotation.x = time * 0.2f;
        mesh.rotation.y = time * 0.4f;
        renderer.render(scene, camera);
    }
}
