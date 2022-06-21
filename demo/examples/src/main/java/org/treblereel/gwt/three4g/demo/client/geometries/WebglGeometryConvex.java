package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.geometries.ConvexGeometry;
import org.treblereel.gwt.three4g.geometries.DodecahedronGeometry;
import org.treblereel.gwt.three4g.helpers.AxesHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.materials.PointsMaterialParameters;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.utils.BufferGeometryUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_convex")
public class WebglGeometryConvex implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Group group;

    @PostConstruct
    public void init() {

        scene = new Scene();

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);

        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        // camera

        camera = new PerspectiveCamera(40, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000);
        camera.position.set(15, 20, 30);
        scene.add(camera);

        // controls

        OrbitControls controls = new OrbitControls(camera, renderer.domElement);
        controls.minDistance = 20;
        controls.maxDistance = 50;
        controls.maxPolarAngle = Math.PI / 2;

        // ambient light

        scene.add(new AmbientLight(0x222222));

        // point light

        PointLight light = new PointLight(0xffffff, 1);
        camera.add(light);

        // helper

        scene.add(new AxesHelper(20));

        // textures

        TextureLoader loader = new TextureLoader();
        Texture texture = loader.load("textures/sprites/disc.png");

        group = new Group();
        scene.add(group);

        // points

        BufferGeometry dodecahedronGeometry = new DodecahedronGeometry(10);

        // if normal and uv attributes are not removed, mergeVertices() can"t consolidate indentical vertices with different normal/uv data

        dodecahedronGeometry.deleteAttribute("normal");
        dodecahedronGeometry.deleteAttribute("uv");

        dodecahedronGeometry = BufferGeometryUtils.mergeVertices(dodecahedronGeometry);

        JsArray<Vector3> vertices = new JsArray<>();
        BufferAttribute positionAttribute = dodecahedronGeometry.getAttribute("position").asBufferAttribute();

        for (int i = 0; i < positionAttribute.count; i++) {

            Vector3 vertex = new Vector3();
            vertex.fromBufferAttribute(positionAttribute, i);
            vertices.push(vertex);

        }

        PointsMaterialParameters pointsMaterialParameters = PointsMaterialParameters.create();
        pointsMaterialParameters.setColor(0x0080ff);
        pointsMaterialParameters.setMap(texture);
        pointsMaterialParameters.setSize(1);
        pointsMaterialParameters.setAlphaTest(0.5);


        PointsMaterial pointsMaterial = new PointsMaterial(pointsMaterialParameters);

        BufferGeometry pointsGeometry = new BufferGeometry().setFromPoints(vertices);

        Points points = new Points(pointsGeometry, pointsMaterial);
        group.add(points);

        // convex hull

        MeshLambertMaterialParameters meshLambertMaterialParameters = MeshLambertMaterialParameters.create();
        meshLambertMaterialParameters.setColor(0xffffff);
        meshLambertMaterialParameters.setOpacity(0.5);
        meshLambertMaterialParameters.setTransparent(true);


        MeshLambertMaterial meshMaterial = new MeshLambertMaterial(meshLambertMaterialParameters);

        ConvexGeometry meshGeometry = new ConvexGeometry(vertices);

        Mesh mesh1 = new Mesh(meshGeometry, meshMaterial);
        mesh1.material.side = THREE.BackSide; // back faces
        mesh1.renderOrder = 0;
        group.add(mesh1);

        Mesh mesh2 = new Mesh(meshGeometry, meshMaterial.clone_());
        mesh2.material.side = THREE.FrontSide; // front faces
        mesh2.renderOrder = 1;
        group.add(mesh2);

        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    double mouseX = 0, mouseY = 0;

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
            group.rotation.y += 0.005;

            renderer.render(scene, camera);
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - convex geometry";

        run = true;
        animate();
    }
}
