package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.AssimpJSONLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 12/17/18
 */
@InjectJavaScriptFor(elements = {AssimpJSONLoader.class})
public class WebglLoaderAssimp2Json extends Attachable {


  public static final String name = "loader / assimp2json";

  private Clock clock;

  public WebglLoaderAssimp2Json() {

    camera = new PerspectiveCamera(50, aspect, 1, 2000);
    clock = new Clock();
    scene = new Scene();

    // load jeep model
    AssimpJSONLoader loader1 = new AssimpJSONLoader();
    loader1.load("models/assimp/jeep/jeep.assimp.json", (OnLoadCallback<Object3D>) object -> {
      object.scale.multiplyScalar(0.2f);
      scene.add(object);
    });
    // load interior model
    AssimpJSONLoader loader2 = new AssimpJSONLoader();
    loader2
        .load("models/assimp/interior/interior.assimp.json", (OnLoadCallback<Object3D>) object -> scene.add(object));

    AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4f);
    scene.add(ambientLight);

    DirectionalLight directionalLight = new DirectionalLight(0xeeeeee);
    directionalLight.position.set(1, 1, -1);
    directionalLight.position.normalize();
    scene.add(directionalLight);

    renderer = new WebGLRenderer();
    setupWebGLRenderer(renderer);
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
        .setInnetHtml("<a href=\"http://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> -\n"
            + "\t\t\tJeep by Psionic, interior from\n"
            + "\t\t\t<a href=\"http://www.assimp.org/\" target=\"_blank\" rel=\"noopener\">Assimp</a>");


  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();

        float elapsedTime = clock.getElapsedTime();
        camera.position.x = (float) Math.cos(elapsedTime * 0.5) * 10;
        camera.position.y = 4;
        camera.position.z = (float) Math.sin(elapsedTime * 0.5) * 10;
        camera.lookAt(scene.position);
        renderer.render(scene, camera);
        animate();
      }
    });
  }

}

