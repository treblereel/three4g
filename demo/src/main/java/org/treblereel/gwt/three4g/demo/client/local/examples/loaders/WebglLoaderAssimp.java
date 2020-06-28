package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.AssimpLoader;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 12/14/18
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, AssimpLoader.class})
public class WebglLoaderAssimp extends Attachable {

  public static final String name = "loader / assimp";

  private Animation animation;

  public WebglLoaderAssimp() {
    camera = new PerspectiveCamera(25, aspect, 1, 10000);
    camera.position.set(600, 1150, 5);
    camera.up.set(0, 0, 1);
    camera.lookAt(-100, 0, 0);

    scene = new Scene();

    HemisphereLight ambient = new HemisphereLight(0x8888fff, 0xff8888, 0.5f);
    ambient.position.set(0, 1, 0);
    scene.add(ambient);
    DirectionalLight light = new DirectionalLight(0xffffff, 1);
    light.position.set(0, 4, 4).normalize();
    scene.add(light);

    WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
    rendererParameters.antialias = true;
    renderer = new WebGLRenderer(rendererParameters);
    setupWebGLRenderer(renderer);
    container.appendChild(renderer.domElement);

    orbitControls = new OrbitControls(camera, root);

    AssimpLoader loader = new AssimpLoader();
    loader.load("models/assimp/octaminator/Octaminator.assimp",
        (OnLoadCallback<PropertyHolder>) result -> {
            Object3D object = result.getProperty("object");
            object.position.y = -100;
            object.rotation.x = (float) Math.PI / 2;
            scene.add(object);
            animation = result.getProperty("animation");
        });
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
        .setInnetHtml("\t<div id=\"info\">\n"
            + "\t\t\t<a href=\"http://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a>\n"
            + "\t\t\t<a href=\"https://github.com/Virtulous\" target=\"_blank\" rel=\"noopener\">Assimp File format</a>\n"
            + "\t\t\t<div>Assimp loader by <a style=\"color:white;\" href=\"https://virtulo.us\" target=\"_blank\" rel=\"noopener\">Virtulous</a></div>\n"
            + "\t\t\t<div>Octaminator model from <a style=\"color:white;\" href=\"http://opengameart.org/content/octaminator-engine-ready\" target=\"_blank\" rel=\"noopener\">Teh_Bucket and raymoohawk</a></div>\n"
            + "\t\t</div>");
  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();
        renderer.render(scene, camera);
        if (animation != null) {
          double time = window.performance.now();
          animation.setTime(time / 1000);
        }
        animate();
      }
    });
  }

  @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  private static class Animation extends PropertyHolder {

    public native void setTime(double timeout);
  }

}

