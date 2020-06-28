package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.AMFLoader;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/18/19
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, AMFLoader.class})
public class WebglLoaderAmf extends Attachable {

  public static final String name = "loader / amf";

  public WebglLoaderAmf() {

    scene = new Scene();
    scene.background = new Color(0x999999);
    scene.add(new AmbientLight(0x999999));

    camera = new PerspectiveCamera(35, window.innerWidth / window.innerHeight, 1, 500);
    // Z is up for objects intended to be 3D printed.
    camera.up.set(0, 0, 1);
    camera.position.set(0, -9, 6);
    camera.add(new PointLight(0xffffff, 0.8f));

    scene.add(camera);

    GridHelper grid = new GridHelper(50, 50, 0xffffff, 0x555555);
    grid.rotateOnAxis(new Vector3(1, 0, 0), (float) (90 * (Math.PI / 180)));
    scene.add(grid);

    OrbitControls controls = new OrbitControls(camera, root);
    controls.addEventListener("change", event -> renderer.render(scene, camera));
    controls.target.set(0, 1.2f, 2);
    controls.update();

    AMFLoader loader = new AMFLoader();
    loader.load("models/amf/rook.amf", object -> {
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
            + "\t\t\t<a style=\"color:white\" href=\"http://amf.wikispaces.com\" target=\"_blank\" rel=\"noopener\">AMF File format</a>\n"
            + "\t\t\t<div>AMF loader test by <a style=\"color:orange\" href=\"https://github.com/tamarintech\" target=\"_blank\" rel=\"noopener\">tamarintech</a></div>\n"
            + "\t\t\t<div>Rook manufacturing file from <a style=\"color:orange\" href=\"http://amf.wikispaces.com/AMF+test+files\" target=\"_blank\" rel=\"noopener\">AMF test files</a></div>\n"
            + "\t\t</div>");
  }

  private void animate() {
    renderer.render(scene, camera);
  }

}
