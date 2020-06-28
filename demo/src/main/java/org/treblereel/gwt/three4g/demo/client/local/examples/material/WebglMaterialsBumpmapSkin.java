package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRenderTargetParameters;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.renderers.shaders.UniformsUtils;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 6/25/18.
 */
public class WebglMaterialsBumpmapSkin extends Attachable {

  public static final String name = "materials / bumpmap / skin";
  private EffectComposer composerBeckmann;
  private Vector2 mouse = new Vector2();
  private Mesh mesh;
  private DirectionalLight directionalLight;
  private boolean firstPass = true;

  public WebglMaterialsBumpmapSkin() {

    loadJavaScript(JavascriptTextResource.IMPL.getShaderSkin().getText());
    loadJavaScript(JavascriptTextResource.IMPL.getCopyShader().getText());
    loadJavaScript(JavascriptTextResource.IMPL.getEffectComposer().getText());
    loadJavaScript(JavascriptTextResource.IMPL.getRenderPass().getText());
    loadJavaScript(JavascriptTextResource.IMPL.getMaskPass().getText());

    loadJavaScript(JavascriptTextResource.IMPL.getShaderPass().getText());

    camera = new PerspectiveCamera(27, aspect, 1, 10000);
    camera.position.z = 1200;
    scene = new Scene();
    scene.background = new Color(0x242a34);
    // LIGHTS
    scene.add(new AmbientLight(0x333344));
    directionalLight = new DirectionalLight(0xffffff, 1);
    directionalLight.position.set(500, 0, 500);
    directionalLight.castShadow = true;
    directionalLight.shadow.mapSize.width = 2048;
    directionalLight.shadow.mapSize.height = 2048;

    OrthographicCamera cam = directionalLight.shadow.camera.cast();
    cam.near = 200;
    cam.far = 1500;
    cam.left = -500;
    cam.right = 500;
    cam.top = 500;
    cam.bottom = -500;
    directionalLight.shadow.bias = -0.005f;
    scene.add(directionalLight);
    //

    GLTFLoader<PropertyHolder> loader = new GLTFLoader<>();
    loader.load("models/gltf/LeePerrySmith/LeePerrySmith.glb",
        object -> {
          Scene scene = object.getProperty("scene");
          Mesh mesh = scene.children[0].cast();
          createScene(mesh.geometry, 100);
        });

    WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
    rendererParameters.antialias = true;
    renderer = new WebGLRenderer(rendererParameters);
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.shadowMap.enabled = true;
    renderer.autoClear = false;
    renderer.gammaInput = true;
    renderer.gammaOutput = true;
    //
    container.appendChild(renderer.domElement);

    // COMPOSER
    renderer.autoClear = false;
    // BECKMANN

    ShaderPass effectBeckmann = new ShaderPass(ShaderSkin.beckmann);

    ShaderPass effectCopy = new ShaderPass(CopyShader.CopyShader);

    effectCopy.renderToScreen = true;

    WebGLRenderTargetParameters parameters = new WebGLRenderTargetParameters();
    parameters.minFilter = THREE.LinearFilter;
    parameters.magFilter = THREE.LinearFilter;
    parameters.format = THREE.RGBFormat;
    parameters.stencilBuffer = false;

    int rtwidth = 512, rtheight = 512;

    composerBeckmann = new EffectComposer(renderer,
        new WebGLRenderTarget(rtwidth, rtheight, parameters));
    composerBeckmann.addPass(effectBeckmann);
    composerBeckmann.addPass(effectCopy);

    //
    renderer.domElement.onmousemove = p0 -> {
      MouseEvent event = Js.uncheckedCast(p0);
      onDocumentMouseMove(event);
      return null;
    };

  }

  private void onDocumentMouseMove(MouseEvent event) {
    mouse.x = (float) ((event.clientX - (window.innerWidth) / 2) / 2);
    mouse.y = (float) ((event.clientY - (window.innerHeight / 2)) / 2);
  }

  private void createScene(AbstractGeometry geometry, int scale) {

    TextureLoader textureLoader = new TextureLoader();
    Texture mapHeight = textureLoader
        .load("models/json/leeperrysmith/Infinite-Level_02_Disp_NoSmoothUV-4096.jpg");
    mapHeight.anisotropy = 4;
    mapHeight.wrapS = mapHeight.wrapT = THREE.RepeatWrapping;
    mapHeight.format = THREE.RGBFormat;
    Texture mapSpecular = textureLoader.load("models/json/leeperrysmith/Map-SPEC.jpg");
    mapSpecular.anisotropy = 4;
    mapSpecular.wrapS = mapSpecular.wrapT = THREE.RepeatWrapping;
    mapSpecular.format = THREE.RGBFormat;
    Texture mapColor = textureLoader.load("models/json/leeperrysmith/Map-COL.jpg");
    mapColor.anisotropy = 4;
    mapColor.wrapS = mapColor.wrapT = THREE.RepeatWrapping;
    mapColor.format = THREE.RGBFormat;

    String fragmentShader = ShaderSkin.skinSimple.fragmentShader;
    String vertexShader = ShaderSkin.skinSimple.vertexShader;
    Uniforms shaderUniform = ShaderSkin.skinSimple.uniforms;

    Uniforms uniforms = UniformsUtils.clone(shaderUniform);

    uniforms.set("enableBump", true);
    uniforms.set("enableSpecular", true);
    uniforms.set("tBeckmann", composerBeckmann.renderTarget1.getProperty("texture"));
    uniforms.set("tDiffuse", mapColor);
    uniforms.set("bumpMap", mapHeight);
    uniforms.set("specularMap", mapSpecular);

    ((Color) uniforms.get("diffuse")).setHex(0xa0a0a0);
    ((Color) uniforms.get("specular")).setHex(0xa0a0a0);
    uniforms.set("uRoughness", 0.2);
    uniforms.set("uSpecularBrightness", 0.5);

    ShaderMaterialParameters parameters = new ShaderMaterialParameters();
    parameters.fragmentShader = fragmentShader;
    parameters.vertexShader = vertexShader;

    parameters.uniforms = uniforms;
    parameters.lights = true;

    ShaderMaterial material = new ShaderMaterial(parameters);

    material.getExtensions().derivatives = true;
    mesh = new Mesh(geometry, material);
    mesh.position.y = -50;
    mesh.scale.set(scale, scale, scale);
    mesh.castShadow = true;
    mesh.receiveShadow = true;
    scene.add(mesh);
  }


  @Override
  protected void doAttachScene() {
    root.appendChild(container);
    renderer.setSize(getWidth(), getHeight());
    animate();
  }

  @Override
  protected void doAttachInfo() {
    AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js")
        .setInnetHtml(
            "  - webgl simple, single-pass, skin material with tangent-less bump mapping</a> -\n" +
                "\t\t\t<a href=\"http://graphics.cs.williams.edu/data/meshes.xml#14\" target=\"_blank\" rel=\"noopener\">Lee Perry-Smith</a> head");


  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();

        float targetX = mouse.x * .001f;
        float targetY = mouse.y * .001f;
        if (mesh != null) {
          mesh.rotation.y += 0.05 * (targetX - mesh.rotation.y);
          mesh.rotation.x += 0.05 * (targetY - mesh.rotation.x);
        }
        if (firstPass) {
          composerBeckmann.render();
          firstPass = false;
        }
        renderer.clear();
        renderer.render(scene, camera);
        animate();
      }
    });
  }

}

