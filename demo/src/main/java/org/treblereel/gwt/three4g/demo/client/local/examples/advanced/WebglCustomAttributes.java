package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.Float32Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
public class WebglCustomAttributes extends Attachable {

    public static final String name = "custom / attributes";
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;

    private Float32Array displacement, noise;
    private Mesh sphere;
    private Uniforms uniforms;

    private String fragmentShader = "\tvarying vec3 vNormal;\n" +
            "\t\t\tvarying vec2 vUv;\n" +
            "\t\t\tuniform vec3 color;\n" +
            "\t\t\tuniform sampler2D texture;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvec3 light = vec3( 0.5, 0.2, 1.0 );\n" +
            "\t\t\t\tlight = normalize( light );\n" +
            "\t\t\t\tfloat dProd = dot( vNormal, light ) * 0.5 + 0.5;\n" +
            "\t\t\t\tvec4 tcolor = texture2D( texture, vUv );\n" +
            "\t\t\t\tvec4 gray = vec4( vec3( tcolor.r * 0.3 + tcolor.g * 0.59 + tcolor.b * 0.11 ), 1.0 );\n" +
            "\t\t\t\tgl_FragColor = gray * vec4( vec3( dProd ) * vec3( color ), 1.0 );\n" +
            "\t\t\t}";


    private String vertexShader = "\tuniform float amplitude;\n" +
            "\t\t\tattribute float displacement;\n" +
            "\t\t\tvarying vec3 vNormal;\n" +
            "\t\t\tvarying vec2 vUv;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvNormal = normal;\n" +
            "\t\t\t\tvUv = ( 0.5 + amplitude ) * uv + vec2( amplitude );\n" +
            "\t\t\t\tvec3 newPosition = position + amplitude * normal * vec3( displacement );\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( newPosition, 1.0 );\n" +
            "\t\t\t}";

    public WebglCustomAttributes() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        camera = new PerspectiveCamera(30, aspect, 1, 10000);
        camera.position.z = 300;
        scene = new Scene();
        scene.background = new Color(0x050505);
        uniforms = new Uniforms();
        uniforms.set("amplitude", 1.0);
        uniforms.set("color", new Color(0xff2200));
        uniforms.set("texture", new TextureLoader().load("textures/water.jpg"));
        Texture texture = uniforms.get("texture");
        texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;

        ShaderMaterial shaderMaterial = new ShaderMaterial(shaderMaterialParameters);
        int radius = 50, segments = 128, rings = 64;
        SphereBufferGeometry geometry = new SphereBufferGeometry(radius, segments, rings);
        displacement = new Float32Array(geometry.attributes.position.count);
        noise = new Float32Array(geometry.attributes.position.count);
        for (int i = 0; i < displacement.length; i++) {
            noise.setAt(i, Math.random() * 5);
        }
        geometry.addAttribute("displacement", new BufferAttribute(displacement, 1));
        sphere = new Mesh(geometry, shaderMaterial);
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" - custom attributes example");
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
        float time = new Date().getTime() * 0.01f;
        sphere.rotation.y = sphere.rotation.z = 0.01f * time;

        uniforms.set("amplitude", 2.5 * Math.sin(sphere.rotation.y * 0.125));
        Color color = uniforms.get("color");
        color.offsetHSL(0.0005f, 0, 0);

        for (int i = 0; i < displacement.length; i++) {
            displacement.setAt(i, Math.sin(0.1 * i + time));
            noise.setAt(i, noise.getAt(i) + 0.5 * (0.5 - Math.random()));
            noise.setAt(i, (double) org.treblereel.gwt.three4g.math.Math.clamp(noise.getAt(i).floatValue(), -5, 5));
            displacement.setAt(i, displacement.getAt(i) + noise.getAt(i));
        }

        //Like this shitty code
        PropertyHolder displacement = ((SphereBufferGeometry) sphere.geometry).attributes.getProperty("displacement");
        displacement.setProperty("needsUpdate", true);
        renderer.render(scene, camera);

    }

}


