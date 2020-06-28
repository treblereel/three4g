package org.treblereel.gwt.three4g.demo.client.local.examples.modifiers;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extensions.modifers.TessellateModifier;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.geometries.TextGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.TextGeometryParameters;
import org.treblereel.gwt.three4g.loaders.FontLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/8/18.
 */
@InjectJavaScriptFor(elements = {TrackballControls.class, TessellateModifier.class})
public class WebglModifierTessellation extends Attachable {

    public static final String name = "modifier / tessellation";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private Random random = new Random();
    private Uniforms uniforms;

    private String fragmentShader = "\tvarying vec3 vNormal;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tconst float ambient = 0.4;\n" +
            "\t\t\t\tvec3 light = vec3( 1.0 );\n" +
            "\t\t\t\tlight = normalize( light );\n" +
            "\t\t\t\tfloat directional = max( dot( vNormal, light ), 0.0 );\n" +
            "\t\t\t\tgl_FragColor = vec4( ( directional + ambient ) * vColor, 1.0 );\n" +
            "\t\t\t}";


    private String vertexShader = "\t\t\tuniform float amplitude;\n" +
            "\t\t\tattribute vec3 customColor;\n" +
            "\t\t\tattribute vec3 displacement;\n" +
            "\t\t\tvarying vec3 vNormal;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvNormal = normal;\n" +
            "\t\t\t\tvColor = customColor;\n" +
            "\t\t\t\tvec3 newPosition = position + normal * amplitude * displacement;\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( newPosition, 1.0 );}";

    public WebglModifierTessellation() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        FontLoader loader = new FontLoader();
        loader.load("fonts/helvetiker_bold.typeface.json", font -> init(font));
    }

    private void init(Font font) {


        camera = new PerspectiveCamera(40, aspect, 1, 10000);
        camera.position.set(-100, 100, 200);

        trackballControls = new TrackballControls(camera);

        scene = new Scene();
        scene.background = new Color(0x050505);
        //
        TextGeometryParameters textGeometryParameters = new TextGeometryParameters();
        textGeometryParameters.size = 40;
        textGeometryParameters.height = 5;
        textGeometryParameters.curveSegments = 3;
        textGeometryParameters.bevelThickness = 2;
        textGeometryParameters.bevelSize = 1;
        textGeometryParameters.bevelEnabled = true;
        textGeometryParameters.font = font;


        TextGeometry geometry = new TextGeometry("THREE4G", textGeometryParameters);
        geometry.center();

        TessellateModifier tessellateModifier = new TessellateModifier(8);
        for (int i = 0; i < 6; i++) {
            tessellateModifier.modify(geometry);
        }
        //
        BufferGeometry bufferGeometry = new BufferGeometry().fromGeometry(geometry);
        int numFaces = bufferGeometry.attributes.position.count / 3;

        Float32Array colors = new Float32Array(numFaces * 3 * 3);
        Float32Array displacement = new Float32Array(numFaces * 3 * 3);
        Color color = new Color();
        for (int f = 0; f < numFaces; f++) {

            int index = 9 * f;
            float h = 0.2f * random.nextFloat();
            float s = 0.5f + 0.5f * random.nextFloat();
            float l = 0.5f + 0.5f * random.nextFloat();
            color.setHSL(h, s, l);
            float d = 10 * (0.5f - random.nextFloat());
            for (int i = 0; i < 3; i++) {

                colors.setAt(index + (3 * i), (double) color.r);
                colors.setAt(index + (3 * i) + 1, (double) color.g);
                colors.setAt(index + (3 * i) + 2, (double) color.b);

                displacement.setAt(index + (3 * i), (double) d);
                displacement.setAt(index + (3 * i) + 1, (double) d);
                displacement.setAt(index + (3 * i) + 2, (double) d);
            }
        }
        bufferGeometry.addAttribute("customColor", new BufferAttribute(colors, 3));
        bufferGeometry.addAttribute("displacement", new BufferAttribute(displacement, 3));
        //
        uniforms = new Uniforms();
        uniforms.set("amplitude", 0.0);

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        shaderMaterialParameters.uniforms = uniforms;

        ShaderMaterial shaderMaterial = new ShaderMaterial(shaderMaterialParameters);
        //
        mesh = new Mesh(bufferGeometry, shaderMaterial);
        scene.add(mesh);


        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);

        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

    }


    @Override
    public void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - modifier tessellation");

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
        if (uniforms != null) {
            double time = new Date().getTime() * 0.001;
            double value = 1.0 + Math.sin(time * 0.5);
            uniforms.set("amplitude", value);
            trackballControls.update();
            renderer.render(scene, camera);
        }
    }

}


