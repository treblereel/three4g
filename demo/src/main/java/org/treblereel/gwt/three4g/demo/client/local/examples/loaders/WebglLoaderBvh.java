package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import java.util.Objects;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.BVHLoader;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.helpers.SkeletonHelper;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Bone;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.utils.JSON;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/18/19
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, BVHLoader.class})
public class WebglLoaderBvh extends Attachable {

  public static final String name = "loader / bvh";

  private Clock clock = new Clock();
  private Group boneContainer;
  private SkeletonHelper skeletonHelper;
  private AnimationMixer mixer;

  public WebglLoaderBvh() {
    scene = new Scene();
    BVHLoader loader = new BVHLoader();
    loader.load("models/bvh/pirouette.bvh", result -> {

      Bone[] bones = Js.uncheckedCast(((JsPropertyMap) result.get("skeleton")).get("bones"));

      skeletonHelper = new SkeletonHelper(bones[0]);
      skeletonHelper.setProperty("skeleton",
          result.get("skeleton")); // allow animation mixer to bind to SkeletonHelper directly
      boneContainer = new Group();
      boneContainer.add(bones[0]);
      scene.add(skeletonHelper);
      scene.add(boneContainer);
      // play animation
      mixer = new AnimationMixer(skeletonHelper);
      mixer.clipAction((AnimationClip) result.get("clip")).setEffectiveWeight(1.0f).play();

      init();

    });
  }

  private void init() {
    camera = new PerspectiveCamera(60, aspect, 1, 1000);
    camera.position.set(0, 200, 400);

    orbitControls = new OrbitControls(camera, root);
    orbitControls.minDistance = 300;
    orbitControls.maxDistance = 700;

    scene.background = new Color(0xeeeeee);
    scene.add(new GridHelper(400, 10));

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
    AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js")
        .setInnetHtml("<div style=\"color:orange\"> - BVH Loader -\n"
            + "\t\t\tanimation from <a style=\"color:orange\" href=\"http://mocap.cs.cmu.edu/\">http://mocap.cs.cmu.edu/</a></div>");


  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();
        float delta = clock.getDelta();
        if (Objects.nonNull(mixer)) {
          mixer.update(delta);
          renderer.render(scene, camera);
        }
        animate();

      }
    });
  }

}