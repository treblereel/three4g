package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.core.bufferattributes.Uint8BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.materials.RawShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.RawShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
public class WebglBuffergeometryRawshader extends Attachable {

    public static final String name = "buffergeometry / rawshader";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;

    private String fragmentShader = "precision mediump float;\n" +
            "\t\t\tprecision mediump int;\n" +
            "\t\t\tuniform float time;\n" +
            "\t\t\tvarying vec3 vPosition;\n" +
            "\t\t\tvarying vec4 vColor;\n" +
            "\t\t\tvoid main()\t{\n" +
            "\t\t\t\tvec4 color = vec4( vColor );\n" +
            "\t\t\t\tcolor.r += sin( vPosition.x * 10.0 + time ) * 0.5;\n" +
            "\t\t\t\tgl_FragColor = color;\n" +
            "\t\t\t}";


    private String vertexShader = "precision mediump float;\n" +
            "\t\t\tprecision mediump int;\n" +
            "\t\t\tuniform mat4 modelViewMatrix; // optional\n" +
            "\t\t\tuniform mat4 projectionMatrix; // optional\n" +
            "\t\t\tattribute vec3 position;\n" +
            "\t\t\tattribute vec4 color;\n" +
            "\t\t\tvarying vec3 vPosition;\n" +
            "\t\t\tvarying vec4 vColor;\n" +
            "\t\t\tvoid main()\t{\n" +
            "\t\t\t\tvPosition = position;\n" +
            "\t\t\t\tvColor = color;\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t}";

    public WebglBuffergeometryRawshader() {


        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);


        camera = new PerspectiveCamera(50, aspect, 1, 10);
        camera.position.z = 2;

        scene = new Scene();
        scene.background = new Color(0x101010);
        // geometry
        int triangles = 500;
        BufferGeometry geometry = new BufferGeometry();
        JsArray positions = new JsArray();
        JsArray colors = new JsArray();
        for (int i = 0; i < triangles; i++) {
            positions.push(Math.random() - 0.5);
            positions.push(Math.random() - 0.5);
            positions.push(Math.random() - 0.5);
            colors.push(Math.random() * 255);
            colors.push(Math.random() * 255);
            colors.push(Math.random() * 255);
            colors.push(Math.random() * 255);
        }
        Float32BufferAttribute positionAttribute = new Float32BufferAttribute(positions, 3);
        Uint8BufferAttribute colorAttribute = new Uint8BufferAttribute(colors, 4);
        colorAttribute.normalized = true; // this will map the buffer values to 0.0f - +1.0f in the shader
        geometry.addAttribute("position", positionAttribute);
        geometry.addAttribute("color", colorAttribute);
        // material
        RawShaderMaterialParameters rawShaderMaterialParameters = new RawShaderMaterialParameters();
        Uniforms uniforms = new Uniforms();
        uniforms.set("time", 1.0);
        rawShaderMaterialParameters.uniforms = uniforms;
        rawShaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        rawShaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        rawShaderMaterialParameters.side = THREE.DoubleSide;
        rawShaderMaterialParameters.transparent = true;

        RawShaderMaterial material = new RawShaderMaterial(rawShaderMaterialParameters);

        mesh = new Mesh(geometry, material);
        scene.add(mesh);

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" - raw shader demo");
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
        double time = DomGlobal.performance.now();
        Mesh object = scene.children[0].cast();
        object.rotation.y = (float) time * 0.0005f;
        ((RawShaderMaterial) object.material).uniforms.set("time", time * 0.005f);
        renderer.render(scene, camera);
    }

}
