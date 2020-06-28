package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.AWDLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/18/19
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, AWDLoader.class})
public class WebglLoaderAwd extends Attachable {

  public static final String name = "loader / awd";
  private PointLight pointLight;

  public WebglLoaderAwd() {

    scene = new Scene();

    camera = new PerspectiveCamera(35, window.innerWidth / window.innerHeight, 1, 500);
    camera.position.set(70, 50, -100);

    scene.add(camera);

    orbitControls = new OrbitControls(camera, root);
    scene.add(new AmbientLight(0x606060));
    DirectionalLight directionalLight = new DirectionalLight( /*Math.random() * 0xffffff*/0xeeeeee);
    directionalLight.position.set(.2f, -1, .2f);
    directionalLight.position.normalize();
    scene.add(directionalLight);
    pointLight = new PointLight(0xffffff, .6f);
    scene.add(pointLight);

    AWDLoader loader = new AWDLoader();
    loader.load("models/awd/simple/simple.awd", object -> scene.add(object));

    WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
    rendererParameters.antialias = true;
    renderer = new WebGLRenderer(rendererParameters);
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
    org.treblereel.gwt.three4g.demo.client.local.AppSetup.infoDiv.show()
        .setHrefToInfo("")
        .setInnetHtml("<div id=\"info\"><br>\n"
            + "\t\t\t<div style=\"color:white\">simple AWD loader</div>\n"
            + "\t\t</div>");
  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();

        float timer = new Date().getTime() * 0.0005f;
        pointLight.position.x = (float) Math.sin(timer * 4) * 3000;
        pointLight.position.y = 600;
        pointLight.position.z = (float) Math.cos(timer * 4) * 3000;
        renderer.render(scene, camera);

        animate();
      }
    });
  }

}

