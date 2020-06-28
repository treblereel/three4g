package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 7/31/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, OBJLoader.class})
public class WebglMaterialsDisplacementmap extends Attachable {

  public static final String name = "materials / displacementmap";
  private PointLight pointLight;
  private OrthographicCamera camera;

  private float metalness = 1.0f;
  private float roughness = 0.4f;
  private float ambientIntensity = 0.2f;
  private float aoMapIntensity = 1.0f;
  private float envMapIntensity = 1.0f;
  private float displacementScale = 2.436143f; // from original model
  private AmbientLight ambientLight;
  private MeshStandardMaterial material;
  private double r = 0.0;

  public WebglMaterialsDisplacementmap() {

    scene = new Scene();
    camera = new OrthographicCamera((float) -getHeight() * aspect, (float) getHeight() * aspect,
        (float) getHeight(), (float) -getHeight(), 1, 10000);
    camera.position.z = 1500;
    scene.add(camera);
    orbitControls = new OrbitControls(camera, renderer.domElement);
    orbitControls.enableZoom = false;
    orbitControls.enableDamping = true;
    // lights
    ambientLight = new AmbientLight(0xffffff, ambientIntensity);
    scene.add(ambientLight);
    pointLight = new PointLight(0xff0000, 0.5f);
    pointLight.position.z = 2500;
    scene.add(pointLight);
    PointLight pointLight2 = new PointLight(0xff6666, 1);
    camera.add(pointLight2);
    PointLight pointLight3 = new PointLight(0x0000ff, 0.5f);
    pointLight3.position.x = -1000;
    pointLight3.position.z = 1000;
    scene.add(pointLight3);
    // env map
    String path = "textures/cube/SwedishRoyalCastle/";
    String format = ".jpg";
    String[] urls = new String[]{
        path + "px" + format, path + "nx" + format,
        path + "py" + format, path + "ny" + format,
        path + "pz" + format, path + "nz" + format
    };
    CubeTexture reflectionCube = new CubeTextureLoader().load(urls);
    // textures
    TextureLoader textureLoader = new TextureLoader();
    Texture normalMap = textureLoader.load("models/obj/ninja/normal.jpg");
    Texture aoMap = textureLoader.load("models/obj/ninja/ao.jpg");
    Texture displacementMap = textureLoader.load("models/obj/ninja/displacement.jpg");
    // material

    MeshStandardMaterialParameters parameters = new MeshStandardMaterialParameters();
    parameters.color = new Color(0x888888);
    parameters.roughness = roughness;
    parameters.metalness = metalness;
    parameters.normalMap = normalMap;
    parameters.normalScale = new Vector2(1,
        -1); // why does the normal map require negation in this case?
    parameters.aoMap = aoMap;
    parameters.aoMapIntensity = 1;
    parameters.displacementMap = displacementMap;
    parameters.displacementScale = displacementScale;
    parameters.displacementBias = -0.428408f; // from original model
    parameters.envMap = reflectionCube;
    parameters.envMapIntensity = envMapIntensity;
    parameters.side = THREE.DoubleSide;

    material = new MeshStandardMaterial(parameters);
    OBJLoader loader = new OBJLoader();
    loader.load("models/obj/ninja/ninjaHead_Low.obj", new OnLoadCallback<Object3D>() {
      @Override
      public void onLoad(Object3D group) {
        Mesh temp = group.children[0].cast();

        BufferGeometry geometry = temp.geometry.cast();
        geometry.attributes.setProperty("uv2", geometry.attributes.uv);
        geometry.center();
        mesh = new Mesh(geometry, material);
        mesh.scale.multiplyScalar(25);
        scene.add(mesh);

      }
    });

    setupWebGLRenderer(renderer);
    container.appendChild(renderer.domElement);
    renderer.gammaInput = true;
    renderer.gammaOutput = true;
    initGui();
  }

  private void initGui() {
    GUIProperty guiProperty = new GUIProperty();
    guiProperty.autoPlace = false;

    gui = new GUI(guiProperty);
    gui.add("metalness", metalness, 0, 1).setStep(0.1)
        .onChange(result -> material.metalness = result.floatValue());
    gui.add("roughness", roughness, 0, 1).setStep(0.1)
        .onChange(result -> material.roughness = result.floatValue());
    gui.add("aoMapIntensity", aoMapIntensity, 0, 1).setStep(0.1)
        .onChange(result -> material.aoMapIntensity = result.floatValue());
    gui.add("ambientIntensity", ambientIntensity, 0, 1).setStep(0.1)
        .onChange(result -> ambientLight.intensity = result.floatValue());
    gui.add("envMapIntensity", envMapIntensity, 0, 3).setStep(0.1)
        .onChange(result -> material.envMapIntensity = result.floatValue());
    gui.add("displacementScale", envMapIntensity, 0, 3).setStep(0.1)
        .onChange(result -> material.displacementScale = result.floatValue());
    gui.add("normalScale", envMapIntensity, 0, 3).setStep(0.1)
        .onChange(result -> material.normalScale.set(1, -1).multiplyScalar(result.floatValue()));

    gui.finishAndBuild();
    AppSetup.guiDiv.get().appendChild(gui.getDomElement());
  }

  @Override
  protected void doAttachScene() {
    root.appendChild(container);
    renderer.setSize(getWidth(), getHeight());
    animate();
  }

  @Override
  protected void doAttachInfo() {
    AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js")
        .setInnetHtml(
            "- (<span id=\"description\">normal + ao + displacement + environment</span>) map demo.<br />\n"
                +
                "\t\t\tninja head from <a style='color:orange;' href=\"http://developer.amd.com/tools-and-sdks/archive/legacy-cpu-gpu-tools/amd-gpu-meshmapper/\" target=\"_blank\" rel=\"noopener\">AMD GPU MeshMapper</a>");
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
    pointLight.position.x = 2500 * (float) Math.cos(r);
    pointLight.position.z = 2500 * (float) Math.sin(r);
    r += 0.01;
    renderer.render(scene, camera);
  }

  public void onWindowResize() {
    if (root.parentNode != null) {
      camera.left = (float) -getHeight() * aspect;
      camera.right = (float) getHeight() * aspect;
      camera.top = (float) getHeight();
      camera.bottom = -(float) getHeight();
      camera.updateProjectionMatrix();
      renderer.setSize(window.innerWidth, window.innerHeight);
    }
  }

}







