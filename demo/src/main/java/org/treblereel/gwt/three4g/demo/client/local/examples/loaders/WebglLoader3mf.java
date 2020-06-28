package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.events.Event;
import org.treblereel.gwt.three4g.core.events.EventListener;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.ThreeMFLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/17/19
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, ThreeMFLoader.class})
public class WebglLoader3mf extends Attachable {

  public static final String name = "loader / 3mf";


  public WebglLoader3mf() {
    scene = new Scene();
    scene.background = new Color(0x333333);
    scene.add(new AmbientLight(0xffffff, 0.2f));

    camera = new PerspectiveCamera(35, window.innerWidth / window.innerHeight, 1, 500);
    // Z is up for objects intended to be 3D printed.
    camera.up.set(0, 0, 1);
    camera.position.set(-80, -90, 150);

    scene.add(camera);

    OrbitControls controls = new OrbitControls(camera, root);
    controls.addEventListener("change", event -> renderer.render( scene, camera ));
    controls.minDistance = 50;
    controls.maxDistance = 300;
    controls.enablePan = false;
    controls.target.set(80, 65, 20);
    controls.update();

    PointLight pointLight = new PointLight(0xffffff, 0.8f);

    camera.add(pointLight);

    ThreeMFLoader loader = new ThreeMFLoader();
    loader.load("models/3mf/cube_gears.3mf", object -> {
          scene.add(object);
          renderer.render(scene, camera);
        }
    );

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
            + "\t\t\t<a style=\"color:white\" href=\"http://3mf.io\" target=\"_blank\" rel=\"noopener\">3MF File format</a><br>\n"
            + "\t\t\t<div>3MF loader test by <a style=\"color:orange\" href=\"https://github.com/technohippy\" target=\"_blank\" rel=\"noopener\">technohippy</a></div>\n"
            + "\t\t\t<div>Cube gears file from <a style=\"color:orange\" href=\"https://github.com/3MFConsortium/3mf-samples\" target=\"_blank\" rel=\"noopener\">3mf-samples</a></div>\n"
            + "\t\t</div>");
  }

  private void animate() {
    renderer.render(scene, camera);
  }

}
