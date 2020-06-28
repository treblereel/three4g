package org.treblereel.gwt.three4g.demo.client.local.examples.webaudio;

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAudioElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.audio.Audio;
import org.treblereel.gwt.three4g.audio.AudioAnalyser;
import org.treblereel.gwt.three4g.audio.AudioListener;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.DataTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
public class WebaudioVisualizer extends Attachable {

    public static final String name = "webaudio / visualizer";
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;

    private HTMLAudioElement mediaElement;
    private HTMLDivElement overlay;
    private int fftSize = 128;
    private Camera camera;
    private AudioAnalyser analyser;
    private Uniforms uniforms;
    private Audio audio;


    private String fragmentShader = "\tuniform sampler2D tAudioData;\n" +
            "\t\t\tvarying vec2 vUv;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvec3 backgroundColor = vec3( 0.125, 0.125, 0.125 );\n" +
            "\t\t\t\tvec3 color = vec3( 1.0, 1.0, 0.0 );\n" +
            "\t\t\t\tfloat f = texture2D( tAudioData, vec2( vUv.x, 0.0 ) ).r;\n" +
            "\t\t\t\tfloat i = step( vUv.y, f ) * step( f - 0.0125, vUv.y );\n" +
            "\t\t\t\tgl_FragColor = vec4( mix( backgroundColor, color, i ), 1.0 );\n" +
            "\t\t\t}";


    private String vertexShader = "\tvarying vec2 vUv;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvUv = uv;\n" +
            "\t\t\t\tgl_Position = vec4( position, 1.0 );\n" +
            "\t\t\t}";

    public WebaudioVisualizer() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        overlay = (HTMLDivElement) DomGlobal.document.createElement("div");
        overlay.id = "a_overlay";
        container.appendChild(overlay);

        HTMLDivElement div = (HTMLDivElement) DomGlobal.document.createElement("div");
        overlay.appendChild(div);

        HTMLButtonElement button = (HTMLButtonElement) DomGlobal.document.createElement("button");
        button.id = "startButton";
        button.textContent = "Click to Play";
        div.appendChild(button);

        HTMLParagraphElement p = (HTMLParagraphElement) DomGlobal.document.createElement("p");
        p.textContent = "Automatic audio playback requires a user interaction.";
        div.appendChild(p);

        button.addEventListener("click", evt -> init());
    }


    public void init() {
        overlay.remove();
        scene = new Scene();
        //
        camera = new Camera();
        //
        AudioListener listener = new AudioListener();
        audio = new Audio(listener);

        mediaElement = (HTMLAudioElement) document.createElement("audio");
        mediaElement.src = "sounds/376737_Skullbeatz___Bad_Cat_Maste.mp3";
        mediaElement.loop = true;
        mediaElement.play();
        audio.setMediaElementSource(mediaElement);
        analyser = new AudioAnalyser(audio, fftSize);


        uniforms = new Uniforms();
        uniforms.set("tAudioData", new DataTexture(analyser.data, fftSize / 2, 1, THREE.LuminanceFormat));

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        //
        PlaneBufferGeometry geometry = new PlaneBufferGeometry(1, 1);
        Mesh mesh = new Mesh(geometry, new ShaderMaterial(shaderMaterialParameters));
        scene.add(mesh);
        //
        WebGLRendererParameters parameters1 = new WebGLRendererParameters();
        parameters1.antialias = true;
        renderer = new WebGLRenderer(parameters1);
        setupWebGLRenderer(renderer);
        renderer.setClearColor(0x000000);
        container.appendChild(renderer.domElement);
        //
        root.appendChild(renderer.domElement);
        animate();
    }

    @Override
    public void detach() {
        super.doDetach();
        if (mediaElement != null)
            mediaElement.pause();
    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("    webaudio orientation | music by <a style=\"color:orange;\" href=\"http://www.newgrounds.com/audio/listen/376737\" target=\"_blank\" rel=\"noopener noreferrer\">skullbeatz</a>");
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
        analyser.getFrequencyData();
        Texture texture = uniforms.get("tAudioData");
        texture.needsUpdate = true;
        renderer.render(scene, camera);
    }
}