package org.treblereel.gwt.three4g.demo.client.local.examples.lights;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLScriptElement;
import elemental2.dom.KeyboardEvent;
import java.util.ArrayList;
import java.util.List;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.helpers.DirectionalLightHelper;
import org.treblereel.gwt.three4g.helpers.HemisphereLightHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 7/30/18.
 */
public class WebglLightsHemisphere extends Attachable {

  public static final String name = "lights / hemisphere";
  public final String vertexShader = "\tvarying vec3 vWorldPosition;\n" +
      "\t\t\tvoid main() {\n" +
      "\t\t\t\tvec4 worldPosition = modelMatrix * vec4( position, 1.0 );\n" +
      "\t\t\t\tvWorldPosition = worldPosition.xyz;\n" +
      "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );\n" +
      "\t\t\t}";
  public final String fragmentShader = "uniform vec3 topColor;\n" +
      "\t\t\tuniform vec3 bottomColor;\n" +
      "\t\t\tuniform float offset;\n" +
      "\t\t\tuniform float exponent;\n" +
      "\t\t\tvarying vec3 vWorldPosition;\n" +
      "\t\t\tvoid main() {\n" +
      "\t\t\t\tfloat h = normalize( vWorldPosition + offset ).y;\n" +
      "\t\t\t\tgl_FragColor = vec4( mix( bottomColor, topColor, max( pow( max( h , 0.0), exponent ), 0.0 ) ), 1.0 );\n"
      +
      "\t\t\t}";
  public Mesh quad;
  public Clock clock = new Clock();
  public HemisphereLight hemiLight;
  public HemisphereLightHelper hemiLightHelper;
  public DirectionalLight dirLight;
  public DirectionalLightHelper dirLightHeper;
  public List<AnimationMixer> mixers = new ArrayList<>();
  private EventListener event;
  private HTMLScriptElement vertexShaderElm, fragmentShaderElm;

  public WebglLightsHemisphere() {

    fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
    fragmentShaderElm.type = "x-shader/x-fragment";
    fragmentShaderElm.textContent = fragmentShader;
    root.appendChild(fragmentShaderElm);

    vertexShaderElm = (HTMLScriptElement) document.createElement("script");
    vertexShaderElm.type = "x-shader/x-vertex";
    vertexShaderElm.textContent = vertexShader;
    root.appendChild(vertexShaderElm);

    camera = new PerspectiveCamera(30, aspect, 1, 5000);
    camera.position.set(0, 0, 250);
    scene = new Scene();
    scene.background = new Color().setHSL(0.6f, 0, 1);
    scene.fog = new Fog(((Color) scene.background).getHex(), 1, 5000);
    // LIGHTS
    hemiLight = new HemisphereLight(0xffffff, 0xffffff, 0.6f);
    hemiLight.color.setHSL(0.6f, 1, 0.6f);
    hemiLight.groundColor.setHSL(0.095f, 1, 0.75f);
    hemiLight.position.set(0, 50, 0);
    scene.add(hemiLight);
    hemiLightHelper = new HemisphereLightHelper(hemiLight, 10);
    scene.add(hemiLightHelper);
    //
    dirLight = new DirectionalLight(0xffffff, 1);
    dirLight.color.setHSL(0.1f, 1f, 0.95f);
    dirLight.position.set(-1, 1.75f, 1);
    dirLight.position.multiplyScalar(30);
    scene.add(dirLight);

    dirLight.castShadow = true;
    dirLight.shadow.mapSize.width = 2048;
    dirLight.shadow.mapSize.height = 2048;

    int d = 50;

    OrthographicCamera cam = dirLight.shadow.camera.cast();
    cam.left = -d;
    cam.right = d;
    cam.top = d;
    cam.bottom = -d;
    cam.far = 3500;
    dirLight.shadow.bias = -0.0001f;
    dirLightHeper = new DirectionalLightHelper(dirLight, 10);
    scene.add(dirLightHeper);
    // GROUND
    PlaneBufferGeometry groundGeo = new PlaneBufferGeometry(10000, 10000);
    MeshPhongMaterial groundMat = new MeshPhongMaterial();
    groundMat.color = new Color(0xffffff);
    groundMat.specular = new Color(0x050505);
    groundMat.color.setHSL(0.095f, 1, 0.75f);
    Mesh ground = new Mesh(groundGeo, groundMat);
    ground.rotation.x = (float) -Math.PI / 2;
    ground.position.y = -33;
    scene.add(ground);
    ground.receiveShadow = true;
    // SKYDOME
    Uniforms uniforms = new Uniforms();
    uniforms.set("topColor", new Color(0x0077ff));
    uniforms.set("bottomColor", new Color(0xffffff));
    uniforms.set("offset", 33);
    uniforms.set("exponent", 0.6);

    Color topColor = uniforms.get("topColor");
    topColor.copy(hemiLight.color);
    Color bottomColor = uniforms.get("bottomColor");
    scene.fog.color.copy(bottomColor);

    SphereBufferGeometry skyGeo = new SphereBufferGeometry(4000, 32, 15);

    ShaderMaterial skyMat = new ShaderMaterial();
    skyMat.vertexShader = vertexShaderElm.textContent;
    skyMat.fragmentShader = fragmentShaderElm.textContent;
    skyMat.uniforms = uniforms;
    skyMat.side = THREE.BackSide;

    Mesh sky = new Mesh(skyGeo, skyMat);
    scene.add(sky);

    // MODEL
    GLTFLoader<PropertyHolder> loader = new GLTFLoader<>();
    loader.load("models/gltf/Flamingo.glb", gltf -> {
      Scene _scene = gltf.getProperty("scene");
      Mesh mesh = _scene.children[0].cast();
      float s = 0.35f;
      mesh.scale.set(s, s, s);
      mesh.position.y = 15;
      mesh.rotation.y = -1;
      mesh.castShadow = true;
      mesh.receiveShadow = true;
      scene.add(mesh);
      AnimationMixer mixer = new AnimationMixer(mesh);
      AnimationClip[] animationAction = gltf.getProperty("animations");
      mixer.clipAction(animationAction[0]).setDuration(1).play();
      mixers.add(mixer);
    });

    // RENDERER
    WebGLRendererParameters parameters = new WebGLRendererParameters();
    parameters.antialias = true;
    renderer = new WebGLRenderer(parameters);
    setupWebGLRenderer(renderer);
    renderer.gammaInput = true;
    renderer.gammaOutput = true;
    renderer.shadowMap.enabled = true;

    event = evt -> onKeyDown((KeyboardEvent) evt);
    document.addEventListener("keydown", event, false);
  }

  private void onKeyDown(KeyboardEvent evt) {
    switch (evt.code) {
      case "KeyH":
        hemiLight.visible = !hemiLight.visible;
        hemiLightHelper.visible = !hemiLightHelper.visible;
        break;
      case "KeyD":
        dirLight.visible = !dirLight.visible;
        dirLightHeper.visible = !dirLightHeper.visible;
        break;
    }
  }

  @Override
  public void doDetach() {
    super.doDetach();
    document.removeEventListener("keydown", event);
  }

  @Override
  public void doAttachScene() {
    root.appendChild(renderer.domElement);
    onWindowResize();
    animate();
  }

  @Override
  protected void doAttachInfo() {
    AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js")
        .setInnetHtml(" - webgl hemisphere light example -" +
            "\t\t\tflamingo by <a href=\"http://mirada.com/\">mirada</a> from <a href=\"http://ro.me\">rome</a><br/><div>\n"
            +
            "\t\t\tpress <strong <strong style='color:red;'>h</strong> to toggle hemisphere light, <strong style='color:red;'"
            +
            ">d</strong> to toggle directional light\n" +
            "\t\t</div>");

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
    double delta = clock.getDelta();
    for (int i = 0; i < mixers.size(); i++) {
      mixers.get(i).update(delta);
    }
    renderer.render(scene, camera);
  }

}


