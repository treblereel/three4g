package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 6/25/18.
 */
public class WebglMaterialsBumpmap extends Attachable {

  public static final String name = "materials / bumpmap";
  private SpotLight spotLight;
  private Mesh mesh;
  private Vector2 mouse = new Vector2();

  public WebglMaterialsBumpmap() {

    camera = new PerspectiveCamera(27, aspect, 1, 10000);
    camera.position.z = 1200;
    scene = new Scene();
    scene.background = new Color(0x060708);
    // LIGHTS
    scene.add(new HemisphereLight(0x443333, 0x111122));
    spotLight = new SpotLight(0xffffbb, 2);
    spotLight.position.set(0.5f, 0, 1);
    spotLight.position.multiplyScalar(700);
    scene.add(spotLight);
    spotLight.castShadow = true;
    spotLight.shadow.mapSize.width = 2048;
    spotLight.shadow.mapSize.height = 2048;
    PerspectiveCamera cam = spotLight.shadow.camera.cast();
    cam.near = 200;
    cam.far = 1500;
    cam.fov = 40;
    spotLight.shadow.bias = -0.005f;
    //
    Texture mapHeight = new TextureLoader()
        .load("models/json/leeperrysmith/Infinite-Level_02_Disp_NoSmoothUV-4096.jpg");
    MeshPhongMaterial material = new MeshPhongMaterial();
    material.color = new Color(0x552811);
    material.specular = new Color(0x222222);
    material.shininess = 25;
    material.bumpMap = mapHeight;
    material.bumpScale = 12;

    GLTFLoader<PropertyHolder> loader = new GLTFLoader<>();
    loader.load("models/gltf/LeePerrySmith/LeePerrySmith.glb",
        object -> {
          Scene scene = object.getProperty("scene");
          Mesh mesh = scene.children[0].cast();
          createScene(mesh.geometry, 100, material);
        });

    WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
    rendererParameters.antialias = true;
    renderer = new WebGLRenderer(rendererParameters);
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.gammaInput = true;
    renderer.gammaOutput = true;
    //
    container.appendChild(renderer.domElement);

    //
    renderer.domElement.onmousemove = p0 -> {
      MouseEvent event = Js.uncheckedCast(p0);
      onDocumentMouseMove(event);
      return null;
    };

  }

  private void onDocumentMouseMove(MouseEvent event) {
    mouse.x = (float) ((event.clientX - (window.innerWidth) / 2) / 2);
    mouse.y = (float) ((event.clientY - (window.innerHeight / 2)) / 2);
  }

  private void createScene(AbstractGeometry geometry, int scale, MeshPhongMaterial material) {

    mesh = new Mesh(geometry, material);
    mesh.position.y = -50;
    mesh.scale.set(scale, scale, scale);
    mesh.castShadow = true;
    mesh.receiveShadow = true;
    scene.add(mesh);
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
        .setInnetHtml(" - webgl bump mapping without tangents -\n" +
            "\t\t\t<a href=\"http://graphics.cs.williams.edu/data/meshes.xml#14\" target=\"_blank\" rel=\"noopener\">Lee Perry-Smith</a> head");


  }

  private void animate() {
    AnimationScheduler.get().requestAnimationFrame(timestamp -> {
      if (root.parentNode != null) {
        StatsProducer.getStats().update();

        float targetX = mouse.x * .001f;
        float targetY = mouse.y * .001f;
        if (mesh != null) {
          mesh.rotation.y += 0.05 * (targetX - mesh.rotation.y);
          mesh.rotation.x += 0.05 * (targetY - mesh.rotation.x);
        }
        renderer.render(scene, camera);
        animate();
      }
    });
  }

}
