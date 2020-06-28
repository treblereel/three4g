package org.treblereel.gwt.three4g.demo.client.local.examples.decals;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.geometries.DecalGeometry;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 6/22/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, DecalGeometry.class})
public class WebglDecals extends Attachable {

  public static final String name = "decals";

  private Line line;
  private Raycaster raycaster;
  private Mesh mouseHelper;
  private boolean moved = false;
  private Vector2 mouse = new Vector2();
  private Intersection intersection = new Intersection();
  private Vector3 position = new Vector3();
  private Euler orientation = new Euler();
  private Vector3 size = new Vector3(10, 10, 10);
  private Vector3 up = new Vector3(0, 1, 0);
  private MeshPhongMaterial decalMaterial;
  private TextureLoader textureLoader;
  private Params params = new Params();
  private Random random = new Random();
  private List<Mesh> decals = new ArrayList<>();
  private Mesh aim;
  private EventListener onMousedown = evt -> moved = false;
  private EventListener onMouseUp = evt -> onMouseUp();
  private EventListener touchstart = evt -> moved = true;
  private EventListener mousemove = (e) -> onMove((MouseEvent) e);
  private EventListener touchMove = (e) -> onTouchMove((TouchEvent) e);


  public WebglDecals() {
    textureLoader = new TextureLoader();
    Texture decalDiffuse = textureLoader.load("textures/decal/decal-diffuse.png");
    Texture decalNormal = textureLoader.load("textures/decal/decal-normal.jpg");

    MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
    parameters.specular = new Color(0x444444);
    parameters.map = decalDiffuse;
    parameters.normalMap = decalNormal;
    parameters.normalScale = new Vector2(1, 1);
    parameters.shininess = 30;
    parameters.transparent = true;
    parameters.depthTest = true;
    parameters.depthWrite = false;
    parameters.polygonOffset = true;
    parameters.polygonOffsetFactor = -4;
    parameters.wireframe = false;

    decalMaterial = new MeshPhongMaterial(parameters);

    SphereGeometry mouseGeometry = new SphereGeometry(1, 0, 0);
    MeshBasicMaterial mouseMaterial = new MeshBasicMaterial();
    mouseMaterial.color = new Color(0x0000ff);
    aim = new Mesh(mouseGeometry, mouseMaterial);
    aim.position.z = -5;

    init();

  }

  private void init() {
    scene = new Scene();
    camera = new PerspectiveCamera(45, aspect, 1, 1000);
    camera.position.z = 120;

    orbitControls = new OrbitControls(camera);
    orbitControls.minDistance = 50;
    orbitControls.maxDistance = 200;

    scene.add(new AmbientLight(0x443333));
    DirectionalLight light = new DirectionalLight(0xffddcc, 1);
    light.position.set(1, 0.75f, 0.5f);
    scene.add(light);
    DirectionalLight light1 = new DirectionalLight(0xccccff, 1);
    light.position.set(-1, 0.75f, -0.5f);
    scene.add(light1);

    BufferGeometry geometry = new BufferGeometry();
    geometry.setFromPoints(new Vector3[]{new Vector3(), new Vector3()});

    LineBasicMaterialParameters lineBasicMaterialParameters = new LineBasicMaterialParameters();
    lineBasicMaterialParameters.linewidth = 4;
    line = new Line(geometry, new LineBasicMaterial(lineBasicMaterialParameters));
    geometry.attributes.position = new Float32BufferAttribute(new float[6], 3);
    scene.add(line);

    loadLeePerrySmith();

    raycaster = new Raycaster();
    mouseHelper = new Mesh(new BoxBufferGeometry(1, 1, 10), new MeshNormalMaterial());
    mouseHelper.visible = false;
    scene.add(mouseHelper);

    scene.add(aim);

    orbitControls.addEventListener("change", event -> moved = true);
    window.addEventListener("mousedown", onMousedown, false);
    window.addEventListener("mouseup", onMouseUp, false);
    window.addEventListener("touchstart", touchstart, false);
    window.addEventListener("touchend", onMouseUp, false);
    window.addEventListener("mousemove", mousemove);
    window.addEventListener("touchmove", touchMove);

    WebGLRendererParameters parameters = new WebGLRendererParameters();
    parameters.antialias = true;
    renderer = new WebGLRenderer(parameters);
    setupWebGLRenderer(renderer);
  }

  private void onMove(MouseEvent event) {
    mouse.x = (float) (
        ((event.clientX - panel.offsetWidth) / (window.innerWidth - panel.offsetWidth)) * 2 - 1);
    mouse.y = (float) (-(event.clientY / window.innerHeight) * 2 + 1);

    Vector3 vector = new Vector3(mouse.x, mouse.y, 0.5f);
    vector.unproject(camera);
    Vector3 dir = vector.sub(camera.position).normalize();
    float distance = -camera.position.z / dir.z;
    Vector3 pos = camera.position.clone().add(dir.multiplyScalar(distance));
    aim.position.copy(pos);

    checkIntersection();
  }

  private void onTouchMove(TouchEvent event) {
    if (event.changedTouches.length > 0) {
      mouse.x = (float) (event.changedTouches.item(0).pageX - panel.offsetWidth);
      mouse.y = (float) (event.changedTouches.item(0).pageY);
    }
    checkIntersection();
  }

  public void detach() {
    window.removeEventListener("mousedown", onMousedown);
    window.removeEventListener("mouseup", onMouseUp);
    window.removeEventListener("touchstart", touchstart);
    window.removeEventListener("mousemove", mousemove);
    window.removeEventListener("touchmove", touchMove);

    super.doDetach();
  }

  private void checkIntersection() {
    if (mesh == null) {
      return;
    }

    raycaster.setFromCamera(mouse, camera);
    Intersect[] intersects = raycaster.intersectObjects(new Mesh[]{mesh}); //varargs
    if (intersects.length > 0) {
      Vector3 p = intersects[0].point;
      mouseHelper.position.copy(p);

      intersection.point.copy(p);

      Vector3 n = intersects[0].face.normal.clone();
      n.transformDirection(mesh.matrixWorld);
      n.multiplyScalar(10);
      n.add(intersects[0].point);

      intersection.normal.copy(intersects[0].face.normal);

      mouseHelper.lookAt(n);

      BufferAttribute positions = ((BufferGeometry) line.geometry).attributes.position;
      positions.setXYZ(0, p.x, p.y, p.z);
      positions.setXYZ(1, n.x, n.y, n.z);
      positions.needsUpdate = true;
      intersection.intersects = true;
    } else {
      intersection.intersects = false;
    }
  }

  private void onMouseUp() {
    checkIntersection();
    if (!moved && intersection.intersects) {
      shoot();
    }
  }

  private void shoot() {
    position.copy(intersection.point);
    orientation.copy(mouseHelper.rotation);
    if (params.rotate) {
      orientation.z = (float) (Math.random() * 2 * Math.PI);
    }
    float scale = (float) ((params.minScale + Math.random() * (params.maxScale - params.minScale)));
    size.set(scale, scale, scale);
    MeshPhongMaterial material = (MeshPhongMaterial) decalMaterial.clone();
    material.color.setHex(random.nextInt() * 0xffffff);
    Mesh m = new Mesh(new DecalGeometry(mesh, position, orientation, size), material);
    decals.add(m);
    scene.add(m);
  }

  private void loadLeePerrySmith() {
    GLTFLoader<PropertyHolder> loader = new GLTFLoader<>();
    loader.load("models/gltf/LeePerrySmith/LeePerrySmith.glb",
        object -> {
          Scene s = object.getProperty("scene");
          mesh = s.children[0].cast();

          MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
          parameters.specular = new Color(0x11111);
          parameters.map = textureLoader.load("models/json/leeperrysmith/Map-COL.jpg");
          parameters.specularMap = textureLoader
              .load("models/json/leeperrysmith/Map-SPEC.jpg");
          parameters.normalMap = textureLoader
              .load("models/json/leeperrysmith/Infinite-Level_02_Tangent_SmoothUV.jpg");
          parameters.shininess = 25;
          MeshPhongMaterial material = new MeshPhongMaterial(parameters);
          mesh.material = material;
          scene.add(mesh);
          mesh.scale.set(10, 10, 10);
        });
  }

  @Override
  public void doAttachScene() {
    root.appendChild(renderer.domElement);
    onWindowResize();
    animate();
  }

  @Override
  protected void doAttachInfo() {
    AppSetup.infoDiv.hide();

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


  private void removeDecals() {
    decals.forEach(m ->
        scene.remove(m)
    );
    decals.clear();
  }

  private class Intersection {

    public boolean intersects = false;
    public Vector3 point = new Vector3();
    public Vector3 normal = new Vector3();
  }

  private class Params {

    public int minScale = 10;
    public int maxScale = 20;
    public boolean rotate = true;
    public Runnable clear = () -> removeDecals();
  }

}
