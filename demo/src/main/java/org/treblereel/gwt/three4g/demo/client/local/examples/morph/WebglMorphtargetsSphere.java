package org.treblereel.gwt.three4g.demo.client.local.examples.morph;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.materials.parameters.PointsMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 8/9/18.
 */
@InjectJavaScriptFor(elements = GLTFLoader.class)
public class WebglMorphtargetsSphere extends Attachable {

  public static final String name = "morphtargets / sphere";
  private int sign = 1;

  public WebglMorphtargetsSphere() {

    camera = new PerspectiveCamera(45, aspect, 0.2f, 100);
    camera.position.set(0, 5, 5);
    scene = new Scene();

    PointLight light = new PointLight(0xff2200, 0.7f);
    light.position.set(100, 100, 100);
    scene.add(light);

    light = new PointLight(0x22ff00, 0.7f);
    light.position.set(-100, -100, -100);
    scene.add(light);

    AmbientLight ambientLight = new AmbientLight(0x111111);
    scene.add(ambientLight);

    GLTFLoader<PropertyHolder> gltfLoader = new GLTFLoader<>();
    gltfLoader.load("models/gltf/AnimatedMorphSphere/glTF/AnimatedMorphSphere.gltf",
        gltf -> {
          Scene temp = gltf.getProperty("scene");
          temp.traverse(object -> {
            if (object instanceof Mesh) {
              mesh = object.cast();
              mesh.geometry.rotateY((float) -Math.PI / 2);
              ((MeshStandardMaterial) mesh.material).morphTargets = true;

              PointsMaterialParameters pointsMaterialParameters = new PointsMaterialParameters();
              pointsMaterialParameters.size = 10;
              pointsMaterialParameters.sizeAttenuation = false;
              pointsMaterialParameters.map = new TextureLoader().load("textures/sprites/disc.png");
              pointsMaterialParameters.alphaTest = 0.5f;
              pointsMaterialParameters.morphTargets = true;

              PointsMaterial pointsMaterial = new PointsMaterial(pointsMaterialParameters);
              Points points = new Points(mesh.geometry, pointsMaterial);
              points.setProperty("morphTargetInfluences", mesh.morphTargetInfluences);
              points.setProperty("morphTargetDictionary", mesh.morphTargetDictionary);
              mesh.add(points);
              scene.add(mesh);
            }
          });
        });

    renderer = new WebGLRenderer();
    setupWebGLRenderer(renderer);

    orbitControls = new OrbitControls(camera, root);
    orbitControls.minDistance = 1;
    orbitControls.maxDistance = 20;
  }


  @Override
  public void doAttachScene() {
    root.appendChild(renderer.domElement);
    onWindowResize();
    animate();
  }

  @Override
  protected void doAttachInfo() {
    AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js")
        .setInnetHtml(" - WebGL morph target example");
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
    if (mesh != null) {
      mesh.rotation.y += 0.01f;
      mesh.morphTargetInfluences[1] = mesh.morphTargetInfluences[1] + 0.01f * sign;
      if (mesh.morphTargetInfluences[1] <= 0 || mesh.morphTargetInfluences[1] >= 1) {
        sign *= -1;
      }
    }
    renderer.render(scene, camera);
  }
}


