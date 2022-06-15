package org.treblereel.gwt.three4g.demo.client.decals;

import elemental2.core.JsArray;
import elemental2.core.JsNumber;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.annotations.JsFunction;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.*;
import org.treblereel.gwt.three4g.demo.client.utils.PointerEvent;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.geometries.DecalGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.raycaster.Intersection;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_decals")
public class WebglDecals implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;
    private Mesh mesh;

    private boolean run, ready;

    private JsPropertyMap params = JsPropertyMap.of();

    private TextureLoader textureLoader;

    private JsArray<Object3D> decals = new JsArray<>();

    boolean moved = false;

    private Mesh mouseHelper;

    private Vector2 mouse = new Vector2();

    private IntersectionPojo intersection = new IntersectionPojo();

    private Line line;

    private MeshPhongMaterial decalMaterial;
    private Vector3 position = new Vector3();
    private Euler orientation = new Euler();
    private Vector3 size = new Vector3(10, 10, 10);

    private Raycaster raycaster = new Raycaster();

    private JsArray<Intersection<Raycaster>> intersects = new JsArray<>();

    @PostConstruct
    public void init() {
        textureLoader = new TextureLoader();
        Texture decalDiffuse = textureLoader.load("textures/decal/decal-diffuse.png");
        Texture decalNormal = textureLoader.load("textures/decal/decal-normal.jpg");

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setSpecular(0x444444);
        meshPhongMaterialParameters.setMap(decalDiffuse);
        meshPhongMaterialParameters.setNormalMap(decalNormal);
        meshPhongMaterialParameters.setNormalScale(new Vector2(1, 1));
        meshPhongMaterialParameters.setShininess(30);
        meshPhongMaterialParameters.setTransparent(true);
        meshPhongMaterialParameters.setDepthTest(true);
        meshPhongMaterialParameters.setDepthWrite(false);
        meshPhongMaterialParameters.setPolygonOffset(true);
        meshPhongMaterialParameters.setPolygonOffsetFactor(-4);
        meshPhongMaterialParameters.setWireframe(false);


        decalMaterial = new MeshPhongMaterial(meshPhongMaterialParameters);

        params.set("minScale", 10);
        params.set("maxScale", 20);
        params.set("rotate", true);
        params.set("clear", (Fn) () -> removeDecals());

        GUI gui = new GUI();
        gui.addNumber( params, "minScale", 1, 30 );
        gui.addNumber( params, "maxScale", 1, 30 );
        gui.addNumber( params, "rotate" );
        gui.addFunction( params, "clear" );
        root.appendChild(gui.getDomElement());

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        renderer.outputEncoding = THREE.sRGBEncoding;
        root.appendChild(renderer.domElement);

        stats = new Stats();
        root.appendChild(stats.dom);

        scene = new Scene();

        camera = new PerspectiveCamera(45, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000);
        camera.position.z = 120;

        OrbitControls controls = new OrbitControls(camera, renderer.domElement);
        controls.minDistance = 50;
        controls.maxDistance = 200;

        scene.add(new AmbientLight(0x443333));

        DirectionalLight dirLight1 = new DirectionalLight(0xffddcc, 1);
        dirLight1.position.set(1, 0.75, 0.5);
        scene.add(dirLight1);

        DirectionalLight dirLight2 = new DirectionalLight(0xccccff, 1);
        dirLight2.position.set(-1, 0.75, -0.5);
        scene.add(dirLight2);

        BufferGeometry geometry = new BufferGeometry();
        geometry.setFromPoints(new Vector3[]{new Vector3(), new Vector3()});

        line = new Line(geometry, new LineBasicMaterial());
        scene.add(line);

        loadLeePerrySmith();

        mouseHelper = new Mesh(new BoxGeometry(1, 1, 10), new MeshNormalMaterial());
        mouseHelper.visible = false;
        scene.add(mouseHelper);

        controls.addEventListener("change", event -> moved = true);

        DomGlobal.window.addEventListener("pointerdown", evt -> moved = false);


        DomGlobal.window.addEventListener("pointerup", evt -> {
            MouseEvent event = (MouseEvent) evt;

            if (moved == false) {

                checkIntersection(event);

                if (intersection.intersects) {
                    shoot();
                }
            }
        });


        DomGlobal.window.addEventListener("pointermove", evt -> onPointerMove((MouseEvent) evt));

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
    }

    private void onPointerMove(MouseEvent event) {
        PointerEvent pointerEvent = PointerEvent.of(event);
        if (pointerEvent.isPrimary) {
            checkIntersection(event);
        }
    }

    private void checkIntersection(MouseEvent event) {

        if (mesh == null) {
            return;
        }

        HTMLDivElement container = (HTMLDivElement) DomGlobal.document.getElementById("content");

        mouse.x = ( (event.clientX - container.getBoundingClientRect().left)/ (DomGlobal.window.innerWidth)) * 2 - 1;
        mouse.y = - ( (event.clientY)/ DomGlobal.window.innerHeight ) * 2 + 1;

        raycaster.setFromCamera(mouse, camera);
        raycaster.intersectObject(mesh, false, intersects);

        if (intersects.length > 0) {

            Vector3 p = intersects.getAt(0).getPoint();
            mouseHelper.position.copy(p);
            intersection.point.copy(p);

            Vector3 n = intersects.getAt(0).getFace().getNormal().clone_();
            n.transformDirection(mesh.matrixWorld);
            n.multiplyScalar(10);
            n.add(intersects.getAt(0).getPoint());

            intersection.normal.copy(intersects.getAt(0).getFace().getNormal());
            mouseHelper.lookAt(n);

            BufferAttribute positions = line.geometry.attributes.get("position").asBufferAttribute();
            positions.setXYZ(0, p.x, p.y, p.z);
            positions.setXYZ(1, n.x, n.y, n.z);
            positions.needsUpdate = true;

            intersection.intersects = true;

            intersects.length = 0;

        } else {

            intersection.intersects = false;

        }

    }

    private void loadLeePerrySmith() {

        GLTFLoader loader = new GLTFLoader();

        loader.load("models/gltf/LeePerrySmith/LeePerrySmith.glb", (OnLoadCallback<PropertyHolder>) gltf -> {
            Object3D scene1 = gltf.getProperty("scene");
            mesh = (Mesh) scene1.children.getAt(0);

            MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
            meshPhongMaterialParameters.setSpecular(0x111111);
            meshPhongMaterialParameters.setMap(textureLoader.load("models/gltf/LeePerrySmith/Map-COL.jpg"));
            meshPhongMaterialParameters.setSpecularMap(textureLoader.load("models/gltf/LeePerrySmith/Map-SPEC.jpg"));
            meshPhongMaterialParameters.setNormalMap(textureLoader.load("models/gltf/LeePerrySmith/Infinite-Level_02_Tangent_SmoothUV.jpg"));
            meshPhongMaterialParameters.setShininess(25);


            mesh.material = new MeshPhongMaterial(meshPhongMaterialParameters);

            scene.add(mesh);
            mesh.scale.set(10, 10, 10);

            ready = true;
        });
    }

    private void shoot() {

        position.copy(intersection.point);
        orientation.copy(mouseHelper.rotation);

        if (params.get("rotate").equals("true")) {
            orientation.z = Math.random() * 2 * Math.PI;
        }

        double minScale = new JsNumber(params.get("minScale")).valueOf();
        double maxScale = new JsNumber(params.get("maxScale")).valueOf();
        double scale = minScale + Math.random() * (maxScale - minScale);

        size.set(scale, scale, scale);

        MeshPhongMaterial material = decalMaterial.clone_();
        material.color.setHex(Math.random() * 0xffffff);

        Mesh m = new Mesh(new DecalGeometry(mesh, position, orientation, size), material);

        decals.push(m);
        scene.add(m);

    }

    private void removeDecals() {
        decals.forEach((d, p1, p2) -> {
            scene.remove(d);
            return null;
        });
        decals.length = 0;
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            renderer.render( scene, camera );
            stats.update();
        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - decal splatter<br/>\n" +
                "\t\t\tclick to shoot";

        run = true;
        animate();
    }

    @JsFunction
    @FunctionalInterface
    public interface Fn {
        void call();
    }

    private class IntersectionPojo {
        boolean intersects = false;
        Vector3 point = new Vector3();
        Vector3 normal = new Vector3();

    }
}
