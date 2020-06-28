package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import elemental2.core.TypedArray;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/17/18.
 */
public class WebglBuffergeometryCustomAttributesParticles extends Attachable {

    public static final String name = "buffergeometry / custom / attributes / particles";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private int particles = 100000;
    private Random random = new Random();
    private Points particleSystem;
    private BufferGeometry geometry;


    private String fragmentShader = "uniform sampler2D texture;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tgl_FragColor = vec4( vColor, 1.0 );\n" +
            "\t\t\t\tgl_FragColor = gl_FragColor * texture2D( texture, gl_PointCoord );\n" +
            "\t\t\t}";


    private String vertexShader = "attribute float size;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvColor = color;\n" +
            "\t\t\t\tvec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t\tgl_PointSize = size * ( 300.0 / -mvPosition.z );\n" +
            "\t\t\t\tgl_Position = projectionMatrix * mvPosition;\n" +
            "\t\t\t}";

    public WebglBuffergeometryCustomAttributesParticles() {


        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);


        scene = new Scene();
        camera = new PerspectiveCamera(40, aspect, 1, 10000);
        camera.position.z = 300;

        Uniforms uniforms = new Uniforms();
        uniforms.set("texture", new TextureLoader().load("textures/sprites/spark1.png"));

        ShaderMaterial shaderMaterial = new ShaderMaterial();
        shaderMaterial.uniforms = uniforms;

        shaderMaterial.vertexShader = vertexShaderElm.textContent;
        shaderMaterial.fragmentShader = fragmentShaderElm.textContent;
        shaderMaterial.blending = THREE.AdditiveBlending;
        shaderMaterial.depthTest = false;
        shaderMaterial.transparent = true;
        shaderMaterial.vertexColors = THREE.VertexColors;


        int radius = 200;
        geometry = new BufferGeometry();
        JsArray<Float> positions = new JsArray<>();
        JsArray<Float> colors = new JsArray<>();
        JsArray<Float> sizes = new JsArray<>();

        Color color = new Color();
        for (float i = 0; i < particles; i++) {
            positions.push((float) ((random.nextDouble() * 2 - 1) * radius));
            positions.push((float) ((random.nextDouble() * 2 - 1) * radius));
            positions.push((float) ((random.nextDouble() * 2 - 1) * radius));
            color.setHSL(i / particles, 1.0f, 0.5f);
            colors.push(color.r, color.g, color.b);
            sizes.push(20f);
        }

        geometry.addAttribute("position", new Float32BufferAttribute(positions, 3));
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        geometry.addAttribute("size", new Float32BufferAttribute(sizes, 1).setDynamic(true));
        particleSystem = new Points(geometry, shaderMaterial);
        scene.add(particleSystem);

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" webgl - buffergeometry custom attributes - particles");
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
        double time = new Date().getTime() * 0.005;
        particleSystem.rotation.z = 0.01f * (float) time;
        Float32BufferAttribute float32BufferAttribute = geometry.attributes.getProperty("size");
        TypedArray sizes = float32BufferAttribute.array;
        for (int i = 0; i < particles; i++) {
            sizes.setAt(i, 10 * (1 + Math.sin(0.1 * i + time)));
        }

        float32BufferAttribute.needsUpdate = true;
        renderer.render(scene, camera);
    }
}