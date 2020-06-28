package org.treblereel.gwt.three4g.demo.client.local.examples.hdr;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/27/18.
 */
public class WebglHdr extends Attachable {

    public static final String name = "hdr";

    public Mesh quad;
    public ShaderMaterial materialHDR;
    public Clock clock = new Clock();
    public double rate, sign = 1;

    public final String vs_hdr = "\tuniform sampler2D   tDiffuse;\n" +
            "\t\t\tuniform float       exposure;\n" +
            "\t\t\tuniform float       brightMax;\n" +
            "\t\t\tvarying vec2  vUv;\n" +
            "\t\t\tvec3 decode_pnghdr( const in vec4 color ) {\n" +
            "\t\t\t\t// remove gamma correction\n" +
            "\t\t\t\tvec4 res = color * color;\n" +
            "\t\t\t\t// decoded RI\n" +
            "\t\t\t\tfloat ri = pow( 2.0, res.w * 32.0 - 16.0 );\n" +
            "\t\t\t\t// decoded HDR pixel\n" +
            "\t\t\t\tres.xyz = res.xyz * ri;\n" +
            "\t\t\t\treturn res.xyz;\n" +
            "\t\t\t}\n" +
            "\t\t\tvoid main()\t{\n" +
            "\t\t\t\tvec4 color = texture2D( tDiffuse, vUv );\n" +
            "\t\t\t\tcolor.xyz  = decode_pnghdr( color );\n" +
            "\t\t\t\t// apply gamma correction and exposure\n" +
            "\t\t\t\t//gl_FragColor = vec4( pow( exposure * color.xyz, vec3( 0.474 ) ), 1.0 );\n" +
            "\t\t\t\t// Perform tone-mapping\n" +
            "\t\t\t\tfloat Y = dot(vec4(0.30, 0.59, 0.11, 0.0), color);\n" +
            "\t\t\t\tfloat YD = exposure * (exposure/brightMax + 1.0) / (exposure + 1.0);\n" +
            "\t\t\t\tcolor *= YD;\n" +
            "\t\t\t\tgl_FragColor = vec4( color.xyz, 1.0 );\n" +
            "\t\t\t}";


    public final String fs_hdr = "\tvarying vec2 vUv;\n" +
            "\t\t\tvoid main()\t{\n" +
            "\t\t\t\tvUv  = uv;\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t}";

    private HTMLScriptElement fs_hdrElm, vs_hdrElm;

    public WebglHdr() {

        fs_hdrElm = (HTMLScriptElement) DomGlobal.document.createElement("script");
        fs_hdrElm.type = "x-shader/x-fragment";
        fs_hdrElm.textContent = fs_hdr;
        root.appendChild(fs_hdrElm);

        vs_hdrElm = (HTMLScriptElement) DomGlobal.document.createElement("script");
        vs_hdrElm.type = "x-shader/x-vertex";
        vs_hdrElm.textContent = vs_hdr;
        root.appendChild(vs_hdrElm);

        camera = new PerspectiveCamera(50, aspect, 1, 10000);
        camera.position.z = 900;
        scene = new Scene();

        Texture texture = new TextureLoader().load("textures/memorial.png");
        texture.minFilter = THREE.LinearFilter;
        texture.magFilter = THREE.NearestFilter;

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();

        Uniforms uniforms = new Uniforms();
        uniforms.set("tDiffuse", texture);
        uniforms.set("exposure", 0.125);
        uniforms.set("brightMax", 0.5);

        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = fs_hdrElm.textContent;
        shaderMaterialParameters.fragmentShader = vs_hdrElm.textContent;

        materialHDR = new ShaderMaterial(shaderMaterialParameters);

        PlaneBufferGeometry plane = new PlaneBufferGeometry(512, 768);
        quad = new Mesh(plane, materialHDR);
        quad.position.z = -100;
        scene.add(quad);

        setupWebGLRenderer(renderer);
    }

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("- webgl HDR texture example -\n" +
                "\t\t\tbased on <a href=\"http://spidergl.org/example.php?id=13\" style=\" color: blue;\" target=\"_blank\" rel=\"noopener\">SpiderGL</a>");

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
        double delta = clock.getDelta() * 5;
        Double exposure = materialHDR.uniforms.get("exposure");
        if (exposure > 0 || exposure < 1) {
            rate = 0.25;
        } else {
            rate = 1;
        }
        if (exposure > 5 || exposure <= 0) {
            sign *= -1;
        }
        exposure += sign * rate * delta;
        materialHDR.uniforms.set("exposure", exposure);
        renderer.render(scene, camera);
    }

}

