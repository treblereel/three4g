package org.treblereel.gwt.three4g.demo.client.local.examples.modifiers;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.extensions.modifers.SimplifyModifier;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 8/8/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, SimplifyModifier.class})
public class WebglModifierSimplifier extends Attachable {

  public static final String name = "modifier / simplifier";

  public WebglModifierSimplifier() {

    camera = new PerspectiveCamera(70f, aspect, 1f, 1000f);
    camera.position.z = 400f;

    scene = new Scene();
    camera = new PerspectiveCamera(40, aspect, 1, 1000);
    camera.position.z = 15;

    orbitControls = new OrbitControls(camera, root);
    orbitControls.enablePan = false;
    orbitControls.enableZoom = false;

    scene.add(new AmbientLight(0xffffff, 0.2f));
    camera.add(new PointLight(0xffffff, 0.7f));
    scene.add(camera);

    new GLTFLoader<PropertyHolder>()
        .load("models/gltf/LeePerrySmith/LeePerrySmith.glb",
            object -> {
              Scene _scene = object.getProperty("scene");

              Mesh mesh = _scene.children[0].cast();
              mesh.position.x = -3;
              mesh.rotation.y = (float) Math.PI / 2;
              scene.add(mesh);
              SimplifyModifier modifier = new SimplifyModifier();
              Mesh simplified = mesh.clone();
              simplified.material = simplified.material.clone();
              simplified.material.flatShading = true;

              double count = Math
                  .floor(((BufferGeometry) simplified.geometry).attributes.position.count
                      * 0.875f); // number of vertices to remove

              simplified.geometry = modifier.modify((BufferGeometry) simplified.geometry, count);
              simplified.position.x = 3;
              simplified.rotation.y = (float) -Math.PI / 2;
              scene.add(simplified);


            });

    WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
    webGLRendererParameters.antialias = true;
    renderer = new WebGLRenderer(webGLRendererParameters);
    setupWebGLRenderer(renderer);
    container.appendChild(renderer.domElement);

  }


  @Override
  public void doAttachScene() {
    root.appendChild(renderer.domElement);
    onWindowResize();
    animate();
  }

  @Override
  protected void doAttachInfo() {
    AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js")
        .setInnetHtml(" - Vertex Reduction using SimplifyModifier");

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

