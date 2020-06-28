package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.Float32Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
public class WebglCustomAttributesPoints extends Attachable {

    public static final String name = "custom / attributes / points";
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private Random random = new Random();
    private Points sphere;

    private String fragmentShader = "\tuniform vec3 color;\n" +
            "\t\t\tuniform sampler2D texture;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tgl_FragColor = vec4( color * vColor, 1.0 );\n" +
            "\t\t\t\tgl_FragColor = gl_FragColor * texture2D( texture, gl_PointCoord );\n" +
            "\t\t\t}";


    private String vertexShader = "\tuniform float amplitude;\n" +
            "\t\t\tattribute float size;\n" +
            "\t\t\tattribute vec3 customColor;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvColor = customColor;\n" +
            "\t\t\t\tvec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t\tgl_PointSize = size * ( 300.0 / -mvPosition.z );\n" +
            "\t\t\t\tgl_Position = projectionMatrix * mvPosition;\n" +
            "\t\t\t}";

    public WebglCustomAttributesPoints() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        camera = new PerspectiveCamera(40, aspect, 1, 10000);
        camera.position.z = 300;
        scene = new Scene();
        int amount = 100000;
        int radius = 200;
        Float32Array positions = new Float32Array(amount * 3);
        Float32Array colors = new Float32Array(amount * 3);
        Float32Array sizes = new Float32Array(amount);
        Vector3 vertex = new Vector3();
        Color color = new Color(0xffffff);
        for (int i = 0; i < amount; i++) {
            vertex.x = (random.nextFloat() * 2 - 1) * radius;
            vertex.y = (random.nextFloat() * 2 - 1) * radius;
            vertex.z = (random.nextFloat() * 2 - 1) * radius;
            vertex.toArray(positions, i * 3);
            if (vertex.x < 0) {
                color.setHSL(0.5f + 0.1f * ((float) i / amount), 0.7f, 0.5f);
            } else {
                color.setHSL(0.0f + 0.1f * ((float) i / amount), 0.9f, 0.5f);
            }
            color.toArray(colors, i * 3);
            sizes.setAt(i, 10.0);
        }
        BufferGeometry geometry = new BufferGeometry();
        geometry.addAttribute("position", new BufferAttribute(positions, 3));
        geometry.addAttribute("customColor", new BufferAttribute(colors, 3));
        geometry.addAttribute("size", new BufferAttribute(sizes, 1));
        //
        Uniforms uniforms = new Uniforms();
        uniforms.set("amplitude", 1.0);
        uniforms.set("texture", new TextureLoader().load("textures/sprites/spark1.png"));
        uniforms.set("color", new Color(0xffffff));

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        shaderMaterialParameters.blending = THREE.AdditiveBlending;
        shaderMaterialParameters.depthTest = false;
        shaderMaterialParameters.transparent = true;

        ShaderMaterial material = new ShaderMaterial(shaderMaterialParameters);
        sphere = new Points(geometry, material);
        scene.add(sphere);

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" - custom attributes example - particles");
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
        float time = new Date().getTime() * 0.005f;
        sphere.rotation.z = 0.01f * time;
        BufferGeometry geometry = sphere.geometry.cast();
        BufferAttribute bufferAttribute = geometry.attributes.getProperty("size");
        for (int i = 0; i < bufferAttribute.array.length; i++) {
            bufferAttribute.array.setAt(i, 14 + 13 * Math.sin(0.1 * i + time));
        }
        bufferAttribute.needsUpdate = true;
        renderer.render(scene, camera);

    }

}