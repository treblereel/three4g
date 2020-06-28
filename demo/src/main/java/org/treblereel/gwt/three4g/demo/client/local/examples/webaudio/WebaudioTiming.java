package org.treblereel.gwt.three4g.demo.client.local.examples.webaudio;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAudioElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.HTMLSourceElement;
import elemental2.media.AudioBuffer;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.audio.Audio;
import org.treblereel.gwt.three4g.audio.AudioListener;
import org.treblereel.gwt.three4g.audio.PositionalAudio;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.AudioLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebaudioTiming extends Attachable {

    public static final String name = "webaudio / timing";

    private HTMLAudioElement audio;
    private HTMLDivElement overlay;

    private float speed = 1.7f;
    private float height = 3;
    private float offset = 0.5f;
    private float time = 0;
    private Mesh[] objects = new Mesh[5];
    private boolean ready = false;

    public WebaudioTiming() {
        audio = (HTMLAudioElement) DomGlobal.document.createElement("audio");
        audio.id = "music";
        audio.loop = true;
        audio.style.display = "none";
        audio.setAttribute("preload", "auto");
        container.appendChild(audio);

        HTMLSourceElement sourceElement1 = (HTMLSourceElement) DomGlobal.document.createElement("source");
        sourceElement1.src = "sounds/376737_Skullbeatz___Bad_Cat_Maste.ogg";
        sourceElement1.type = "audio/ogg";
        audio.appendChild(sourceElement1);

        HTMLSourceElement sourceElement2 = (HTMLSourceElement) DomGlobal.document.createElement("source");
        sourceElement2.src = "sounds/376737_Skullbeatz___Bad_Cat_Maste.mp3";
        sourceElement2.type = "audio/mpeg";
        audio.appendChild(sourceElement2);

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
        camera = new PerspectiveCamera(45, aspect, 0.1f, 100);
        camera.position.set(7, 3, 7);
        // lights
        scene.add(new AmbientLight(0xcccccc, 0.4f));
        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 0.7f);
        directionalLight.position.set(0, 5, 5);
        scene.add(directionalLight);
        int d = 5;
        directionalLight.castShadow = true;

        OrthographicCamera ortho = directionalLight.shadow.camera.cast();
        ortho.left = -d;
        ortho.right = d;
        ortho.top = d;
        ortho.bottom = -d;
        ortho.near = 1;
        ortho.far = 20;
        directionalLight.shadow.mapSize.x = 1024;
        directionalLight.shadow.mapSize.y = 1024;
        // audio
        AudioLoader audioLoader = new AudioLoader();
        AudioListener listener = new AudioListener();
        camera.add(listener);
        // floor
        PlaneBufferGeometry floorGeometry = new PlaneBufferGeometry(10, 10);
        MeshLambertMaterial floorMaterial = new MeshLambertMaterial();
        floorMaterial.color = new Color(0x4676b6);
        Mesh floor = new Mesh(floorGeometry, floorMaterial);
        floor.rotation.x = (float) Math.PI * -0.5f;
        floor.receiveShadow = true;
        scene.add(floor);
        // objects
        int count = 5;
        double radius = 3;
        SphereBufferGeometry ballGeometry = new SphereBufferGeometry(0.3f, 32, 16);
        ballGeometry.translate(0, 0.3f, 0);
        MeshLambertMaterial ballMaterial = new MeshLambertMaterial();
        ballMaterial.color = new Color(0xcccccc);
        // create objects when audio buffer is loaded
        audioLoader.load("sounds/ping_pong.mp3", new OnLoadCallback<AudioBuffer>() {
            @Override
            public void onLoad(AudioBuffer buffer) {
                for (int i = 0; i < count; i++) {
                    double s = (float) i / count * Math.PI * 2;
                    Mesh ball = new Mesh(ballGeometry, ballMaterial);
                    ball.castShadow = true;
                    ball.userData.setProperty("down", "false");
                    ball.position.x = (float) (radius * Math.cos(s));
                    ball.position.z = (float) (radius * Math.sin(s));
                    PositionalAudio audio = new PositionalAudio(listener);
                    audio.setBuffer(buffer);
                    ball.add(audio);
                    scene.add(ball);
                    objects[i] = ball;
                }
                ready = true;
            }
        });
        //
        WebGLRendererParameters parameters1 = new WebGLRendererParameters();
        parameters1.antialias = true;
        renderer = new WebGLRenderer(parameters1);
        setupWebGLRenderer(renderer);
        renderer.shadowMap.enabled = true;
        renderer.setClearColor(0x000000);
        container.appendChild(renderer.domElement);
        //
        orbitControls = new OrbitControls(camera, renderer.domElement);
        orbitControls.minDistance = 1;
        orbitControls.maxDistance = 25;

        root.appendChild(renderer.domElement);
        animate();
    }

    @Override
    public void detach() {
        super.doDetach();
        container.removeChild(audio);
    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("webaudio timing |\n" +
                "\t\tsound effect by <a style='color:orange;' href=\"https://freesound.org/people/michorvath/sounds/269718/\" target=\"_blank\" rel=\"noopener noreferrer\">michorvath</a>");
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
        if (ready) {
            time += 0.02;
            for (int i = 0; i < objects.length; i++) {
                Mesh ball = objects[i];
                float previousHeight = ball.position.y;
                ball.position.y = (float) Math.abs(Math.sin(i * offset + (time * speed)) * height);
                if (ball.position.y < previousHeight) {
                    ball.userData.setProperty("down", "true");
                } else {
                    if (ball.userData.getProperty("down").equals("true")) {
                        // ball changed direction from down to up
                        Audio audio = ball.children[0].cast();
                        audio.play(); // play audio with perfect timing when ball hits the surface
                        ball.userData.setProperty("down", "false");
                    }
                }
            }
        }
        renderer.render(scene, camera);
    }
}


