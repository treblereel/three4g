package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import java.util.Date;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.CubeCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 7/31/18.
 */
public class WebglMaterialsCubemapDynamic2 extends Attachable {

  public static final String name = "materials / cubemap / dynamic";
  private Vector2 mouse = new Vector2();
  private CubeCamera cubeCamera1, cubeCamera2;
  private Mesh sphere, cube, torus;
  private int count = 0;
  private float lon = 0, lat = 0;
  private float phi = 0, theta = 0;
  private MeshBasicMaterial material;
  private double onPointerDownPointerX, onPointerDownPointerY;
  private float onPointerDownLon, onPointerDownLat;

  private EventListener onDocumentMouseMove = new EventListener() {
    @Override
    public void handleEvent(Event evt) {
      MouseEvent event = (MouseEvent) evt;
      lon = (float) ((event.clientX - onPointerDownPointerX) * 0.1 + onPointerDownLon);
      lat = (float) ((event.clientY - onPointerDownPointerY) * 0.1 + onPointerDownLat);
    }
  };

  private EventListener onDocumentMouseUp = new EventListener() {
    @Override
    public void handleEvent(Event evt) {
      renderer.domElement.removeEventListener("mousemove", onDocumentMouseMove, false);
      renderer.domElement.removeEventListener("mouseup", onDocumentMouseUp, false);
    }
  };

  public WebglMaterialsCubemapDynamic2() {

    TextureLoader textureLoader = new TextureLoader();
    textureLoader
        .load("textures/2294472375_24a3b8ef46_o.jpg", texture -> {
          texture.mapping = THREE.UVMapping;
          init(texture);
        });
  }

  private void init(Texture texture) {

    scene = new Scene();
    camera = new PerspectiveCamera(60, aspect, 1, 1000);

    MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
    meshBasicMaterialParameters.map = texture;
    Mesh mesh = new Mesh(new SphereBufferGeometry(500, 32, 16),
        new MeshBasicMaterial(meshBasicMaterialParameters));
    mesh.geometry.scale(-1, 1, 1);
    scene.add(mesh);

    cubeCamera1 = new CubeCamera(1, 1000, 256);
    cubeCamera1.renderTarget.texture.generateMipmaps = true;
    cubeCamera1.renderTarget.texture.minFilter = THREE.LinearMipMapLinearFilter;
    scene.add(cubeCamera1);

    cubeCamera2 = new CubeCamera(1, 1000, 256);
    cubeCamera2.renderTarget.texture.generateMipmaps = true;
    cubeCamera2.renderTarget.texture.minFilter = THREE.LinearMipMapLinearFilter;
    scene.add(cubeCamera2);

    MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
    parameters.envMap = Js.uncheckedCast(cubeCamera2.renderTarget.texture);

    material = new MeshBasicMaterial(parameters);

    sphere = new Mesh(new IcosahedronBufferGeometry(20, 3), material);
    scene.add(sphere);
    cube = new Mesh(new BoxBufferGeometry(20, 20, 20), material);
    scene.add(cube);
    torus = new Mesh(new TorusKnotBufferGeometry(10, 5, 100, 25), material);
    scene.add(torus);

    WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
    webGLRendererParameters.antialias = true;
    renderer = new WebGLRenderer(webGLRendererParameters);
    setupWebGLRenderer(renderer);
    container.appendChild(renderer.domElement);

    renderer.domElement.onmousemove = p0 -> {
      MouseEvent event = Js.uncheckedCast(p0);
      onDocumentMouseMove(event);
      return null;
    };

    renderer.domElement.onmousedown = evn -> {
      MouseEvent event = Js.uncheckedCast(evn);
      onDocumentMouseDown(event);
      return null;
    };
  }

  private void onDocumentMouseDown(MouseEvent event) {
    event.preventDefault();
    onPointerDownPointerX = event.clientX;
    onPointerDownPointerY = event.clientY;
    onPointerDownLon = lon;
    onPointerDownLat = lat;
    renderer.domElement.addEventListener("mousemove", onDocumentMouseMove, false);
    renderer.domElement.addEventListener("mouseup", onDocumentMouseUp, false);

  }

  private void onDocumentMouseMove(MouseEvent event) {
    mouse.x = (float) ((event.clientX - (window.innerWidth / 2)) * 10);
    mouse.y = (float) ((event.clientY - (window.innerHeight / 2)) * 10);
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
        .setInnetHtml(
            " - - webgl cube refraction demo. skybox by <a style=\"color:orange;\" href=\"http://www.zfight.com/\" target=\"_blank\" rel=\"noopener\">Jochum Skoglund</a>");
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

    if (cube != null) {
      float time = new Date().getTime();
      lon += .15;
      lat = Math.max(-85, Math.min(85, lat));
      phi = org.treblereel.gwt.three4g.math.Math.degToRad(90 - lat);
      theta = org.treblereel.gwt.three4g.math.Math.degToRad(lon);

      cube.position.x = (float) Math.cos(time * 0.001) * 30;
      cube.position.y = (float) Math.sin(time * 0.001) * 30;
      cube.position.z = (float) Math.sin(time * 0.001) * 30;

      cube.rotation.x += 0.02;
      cube.rotation.y += 0.03;

      torus.position.x = (float) Math.cos(time * 0.001 + 10) * 30;
      torus.position.y = (float) Math.sin(time * 0.001 + 10) * 30;
      torus.position.z = (float) Math.sin(time * 0.001 + 10) * 30;

      torus.rotation.x += 0.02;
      torus.rotation.y += 0.03;

      camera.position.x = (float) (100 * Math.sin(phi) * Math.cos(theta));
      camera.position.y = (float) (100 * Math.cos(phi));
      camera.position.z = (float) (100 * Math.sin(phi) * Math.sin(theta));
      camera.lookAt(scene.position);

      sphere.visible = false;
      // pingpong
      if (count % 2 == 0) {
        material.envMap = cubeCamera1.renderTarget.texture.cast();
        cubeCamera2.update(renderer, scene);
      } else {
        material.envMap = cubeCamera2.renderTarget.texture.cast();
        cubeCamera1.update(renderer, scene);
      }
      count++;
      sphere.visible = true;
      renderer.render(scene, camera);
    }
  }


}





