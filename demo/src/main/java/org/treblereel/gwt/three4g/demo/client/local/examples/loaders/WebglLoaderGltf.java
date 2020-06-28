package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 6/10/18.
 */
@InjectJavaScriptFor(elements = GLTFLoader.class)
public class WebglLoaderGltf extends Attachable {

  public static final String name = "loader / gltf";

  private CubeTexture envMap;

  public WebglLoaderGltf() {

    camera = new PerspectiveCamera(45, aspect, 0.25f, 20);
    camera.position.set(-1.8f, 0.9f, 2.7f);
    orbitControls = new OrbitControls(camera);
    orbitControls.target.set(0f, -0.2f, -0.2f);
    orbitControls.update();

    // envmap
    String path = "textures/cube/Bridge2/";
    String format = ".jpg";

    String[] urls = new String[6];
    urls[0] = path + "posx" + format;
    urls[1] = path + "negx" + format;
    urls[2] = path + "posy" + format;
    urls[3] = path + "negy" + format;
    urls[4] = path + "posz" + format;
    urls[5] = path + "negz" + format;

    envMap = new CubeTextureLoader().load(urls);

    scene = new Scene();
    scene.background = envMap;

    HemisphereLight light = new HemisphereLight(0xbbbbff, 0x444422);
    light.position.set(0, 1, 0);
    scene.add(light);
    // model
    GLTFLoader<PropertyHolder> loader = new GLTFLoader<>();
    loader.load("models/gltf/DamagedHelmet/glTF/DamagedHelmet.gltf",
        gltf -> {
          Scene obj = gltf.getProperty("scene");
          obj.traverse(child -> {
            if (child instanceof Mesh) {
              MeshStandardMaterial material = child.getProperty("material");
              material.envMap = envMap;
            }
          });
          scene.add(obj);
        });

    HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
    WebGLRenderingContext context = Js.uncheckedCast(canvas.getContext("webgl2"));

    WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
    rendererParameters.context = context;
    rendererParameters.canvas = canvas;

    renderer = new WebGLRenderer(rendererParameters);
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.gammaInput = true;
    //
    container.appendChild(renderer.domElement);

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
        .setInnetHtml(" - GLTFLoader<br />\n" +
            "\t\t\tBattle Damaged Sci-fi Helmet by\n" +
            "\t\t\t<a href=\"https://sketchfab.com/theblueturtle_\" target=\"_blank\" rel=\"noopener\">theblueturtle_</a><br />");


  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();
        renderer.render(scene, camera);
        animate();

      }
    });
  }

}
