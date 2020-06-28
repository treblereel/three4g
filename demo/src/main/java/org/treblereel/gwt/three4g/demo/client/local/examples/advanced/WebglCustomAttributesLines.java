package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.Float32Array;
import elemental2.core.TypedArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.geometries.TextBufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.TextGeometryParameters;
import org.treblereel.gwt.three4g.loaders.FontLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
public class WebglCustomAttributesLines extends Attachable {

    public static final String name = "custom / attributes / lines";
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private Line object;
    private Uniforms uniforms;

    private String fragmentShader = "uniform vec3 color;\n" +
            "\t\t\tuniform float opacity;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tgl_FragColor = vec4( vColor * color, opacity );\n" +
            "\t\t\t}";


    private String vertexShader = "\t\t\tuniform float amplitude;\n" +
            "\t\t\tattribute vec3 displacement;\n" +
            "\t\t\tattribute vec3 customColor;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvec3 newPosition = position + amplitude * displacement;\n" +
            "\t\t\t\tvColor = customColor;\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( newPosition, 1.0 );\n" +
            "\t\t\t}";

    public WebglCustomAttributesLines() {
        FontLoader loader = new FontLoader();
        loader.load("fonts/helvetiker_bold.typeface.json", font -> init(font));
    }

    private void init(Font font) {
        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        camera = new PerspectiveCamera(30, aspect, 1, 10000);
        camera.position.z = 400;
        scene = new Scene();
        scene.background = new Color(0x050505);

        uniforms = new Uniforms();
        uniforms.set("amplitude", 5.0);
        uniforms.set("opacity", 0.3);
        uniforms.set("color", new Color(0xffffff));


        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        shaderMaterialParameters.blending = THREE.AdditiveBlending;
        shaderMaterialParameters.depthTest = false;
        shaderMaterialParameters.transparent = true;

        ShaderMaterial shaderMaterial = new ShaderMaterial(shaderMaterialParameters);

        TextGeometryParameters textGeometryParameters = new TextGeometryParameters();
        textGeometryParameters.font = font;
        textGeometryParameters.size = 50;
        textGeometryParameters.height = 15;
        textGeometryParameters.curveSegments = 10;
        textGeometryParameters.curveSegments = 10;
        textGeometryParameters.bevelThickness = 5;
        textGeometryParameters.bevelSize = 1.5f;
        textGeometryParameters.bevelEnabled = true;
        textGeometryParameters.bevelSegments = 10;

        TextBufferGeometry geometry = new TextBufferGeometry("three.js", textGeometryParameters);
        geometry.center();

        int count = geometry.attributes.position.count;
        new Float32Array(4);
        Float32BufferAttribute displacement = new Float32BufferAttribute(new Float32Array(count * 3), 3);
        geometry.addAttribute("displacement", displacement);
        Float32BufferAttribute customColor = new Float32BufferAttribute(new Float32Array(count * 3), 3);
        geometry.addAttribute("customColor", customColor);
        Color color = new Color(0xffffff);
        for (int i = 0, l = customColor.count; i < l; i++) {
            color.setHSL((float)i / l, 0.5f, 0.5f);
            color.toArray(customColor.array, i * customColor.itemSize);
        }
        object = new Line(geometry, shaderMaterial);
        object.rotation.x = 0.2f;
        scene.add(object);

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("  - custom attributes example");
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
        if (object != null) {
            float time = new Date().getTime() * 0.001f;
            object.rotation.y = 0.25f * time;
            uniforms.set("amplitude", Math.sin(0.5 * time));
            Color color = uniforms.get("color");
            color.offsetHSL(0.0005f, 0, 0);
            BufferGeometry.Attributes attributes = ((TextBufferGeometry) object.geometry).attributes;
            TypedArray array = ((Float32BufferAttribute) attributes.getProperty("displacement")).array;
            for (int i = 0, l = array.length; i < l; i += 3) {
                array.setAt(i, array.getAt(i) + 0.3 * (0.5 - Math.random()));
                array.setAt(i + 1, array.getAt(i + 1) + 0.3 * (0.5 - Math.random()));
                array.setAt(i + 2, array.getAt(i + 2) + 0.3 * (0.5 - Math.random()));
            }
            renderer.render(scene, camera);

        }
    }

}