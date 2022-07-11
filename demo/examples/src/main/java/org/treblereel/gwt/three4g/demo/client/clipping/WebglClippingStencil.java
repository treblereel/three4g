package org.treblereel.gwt.three4g.demo.client.clipping;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotGeometry;
import org.treblereel.gwt.three4g.helpers.PlaneHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.materials.ShadowMaterial;
import org.treblereel.gwt.three4g.materials.ShadowMaterialParameters;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_clipping_stencil")
public class WebglClippingStencil implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private PerspectiveCamera camera;
    private Scene scene;

    private Mesh mesh;
    private WebGLRenderer renderer;

    private Stats stats;

    private boolean run;

    private double startTime;

    private boolean ready;

    private Clock clock;

    private JsArray<Plane> planes = new JsArray<>();

    private JsArray<PlaneHelper> planeHelpers;

    private Group object;

    private GUI gui;

    @PostConstruct
    public void init() {
        clock = new Clock();
        scene = new Scene();

        camera = new PerspectiveCamera(36, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 100);
        camera.position.set(2, 2, 2);

        scene.add(new AmbientLight(0xffffff, 0.5));

        DirectionalLight dirLight = new DirectionalLight(0xffffff, 1);
        dirLight.position.set(5, 10, 7.5);
        dirLight.castShadow = true;
        dirLight.shadow.camera.right = 2;
        dirLight.shadow.camera.left = -2;
        dirLight.shadow.camera.top = 2;
        dirLight.shadow.camera.bottom = -2;

        dirLight.shadow.mapSize.width = 1024;
        dirLight.shadow.mapSize.height = 1024;
        scene.add(dirLight);

        planes.push(
                new Plane(new Vector3(-1, 0, 0), 0),
                new Plane(new Vector3(0, -1, 0), 0),
                new Plane(new Vector3(0, 0, -1), 0)
        );

        planeHelpers = planes.map((p, p1, p2) -> new PlaneHelper(p, 2, 0xffffff));

        planeHelpers.forEach((ph, p1, p2) -> {
            ph.visible = false;
            scene.add(ph);
            return null;
        });

        TorusKnotGeometry geometry = new TorusKnotGeometry(0.4, 0.15, 220, 60);
        object = new Group();
        scene.add(object);

        // Set up clip plane rendering
        JsArray<Mesh> planeObjects = new JsArray<>();

        PlaneGeometry planeGeom = new PlaneGeometry(4, 4);

        for (int i = 0; i < 3; i++) {

            Group poGroup = new Group();
            Plane plane = planes.getAt(i);
            Group stencilGroup = createPlaneStencilGroup(geometry, plane, i + 1);

            // plane is clipped by the other clipping planes
            MeshStandardMaterialParameters meshStandardMaterialParameters = MeshStandardMaterialParameters.create();
            meshStandardMaterialParameters.setColor(0xE91E63);
            meshStandardMaterialParameters.setMetalness(0.1);
            meshStandardMaterialParameters.setRoughness(0.75);
            meshStandardMaterialParameters.setClippingPlanes(planes.filter(new JsArray.FilterCallbackFn<Plane>() {
                @Override
                public Object onInvoke(Plane p, int p1, JsArray<Plane> p2) {
                    return p != plane;
                }
            }));

            meshStandardMaterialParameters.setStencilWrite(true);
            meshStandardMaterialParameters.setStencilRef(0);
            meshStandardMaterialParameters.setStencilFunc(THREE.NotEqualStencilFunc);
            meshStandardMaterialParameters.setStencilFail(THREE.ReplaceStencilOp);
            meshStandardMaterialParameters.setStencilZFail(THREE.ReplaceStencilOp);
            meshStandardMaterialParameters.setStencilZPass(THREE.ReplaceStencilOp);

            MeshStandardMaterial planeMat =
                    new MeshStandardMaterial(meshStandardMaterialParameters);

            Mesh po = new Mesh(planeGeom, planeMat);

            po.onAfterRender = (renderer, p1, p2, p3, p4, p5) -> renderer.clearStencil();
            po.renderOrder = i + 1.1;

            object.add(stencilGroup);
            poGroup.add(po);
            planeObjects.push(po);
            scene.add(poGroup);

        }

        MeshStandardMaterialParameters meshStandardMaterialParameters = MeshStandardMaterialParameters.create();
        meshStandardMaterialParameters.setColor(0xFFC107);
        meshStandardMaterialParameters.setMetalness(0.1);
        meshStandardMaterialParameters.setRoughness(0.75);
        meshStandardMaterialParameters.setClippingPlanes(planes);
        meshStandardMaterialParameters.setClipShadows(true);
        meshStandardMaterialParameters.setShadowSide(THREE.DoubleSide);

        MeshStandardMaterial material = new MeshStandardMaterial(meshStandardMaterialParameters);

        // add the color
        Mesh clippedColorFront = new Mesh(geometry, material);
        clippedColorFront.castShadow = true;
        clippedColorFront.renderOrder = 6;
        object.add(clippedColorFront);

        ShadowMaterialParameters shadowMaterialParameters = ShadowMaterialParameters.create();
        shadowMaterialParameters.setColor(0x000000);
        shadowMaterialParameters.setOpacity(0.25);
        shadowMaterialParameters.setSide(THREE.DoubleSide);

        Mesh ground = new Mesh(
                new PlaneGeometry(9, 9, 1, 1),
                new ShadowMaterial(shadowMaterialParameters)
        );

        ground.rotation.x = -Math.PI / 2; // rotates X/Y to X/Z
        ground.position.y = -1;
        ground.receiveShadow = true;
        scene.add(ground);

        // Stats
        stats = new Stats();
        DomGlobal.document.body.appendChild(stats.dom);

        // Renderer
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.shadowMap.enabled = true;
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        renderer.setClearColor(0x263238);
        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        renderer.localClippingEnabled = true;

        // Controls
        OrbitControls controls = new OrbitControls(camera, renderer.domElement);
        controls.minDistance = 2;
        controls.maxDistance = 20;
        controls.update();


        JsPropertyMap params = JsPropertyMap.of();
        params.set("animate", true);
        JsPropertyMap _planeX = JsPropertyMap.of();
        _planeX.set("constant", 0);
        _planeX.set("negated", false);
        _planeX.set("displayHelper", false);
        params.set("planeX", _planeX);

        JsPropertyMap _planeY = JsPropertyMap.of();
        _planeY.set("constant", 0);
        _planeY.set("negated", false);
        _planeY.set("displayHelper", false);
        params.set("planeY", _planeY);

        JsPropertyMap _planeZ = JsPropertyMap.of();
        _planeZ.set("constant", 0);
        _planeZ.set("negated", false);
        _planeZ.set("displayHelper", false);
        params.set("planeZ", _planeZ);


        // GUI
        gui = new GUI();
        gui.addBoolean(params, "animate");

        GUI planeX = gui.addFolder("planeX");
        planeX.addBoolean(_planeX, "displayHelper").onChange(v -> planeHelpers.getAt(0).visible = v);
        planeX.addNumber(_planeX, "constant").setMin(-1).setMax(1).onChange(d -> {
            planes.getAt(0).constant = d.doubleValue();
        });
        planeX.addNumber(_planeX, "negated").onChange(e -> {

            planes.getAt(0).negate();
            _planeX.set("constant", planes.getAt(0).constant);

        });
        planeX.open();

        GUI planeY = gui.addFolder("planeY");
        planeY.addBoolean(_planeY, "displayHelper").onChange(v -> planeHelpers.getAt(1).visible = v);
        planeY.addNumber(_planeY, "constant").setMin(-1).setMax(1).onChange(d -> planes.getAt(1).constant = d.doubleValue());
        planeY.addNumber(_planeY, "negated").onChange(e -> {

            planes.getAt(1).negate();
            _planeY.set("constant", planes.getAt(1).constant);

        });
        planeY.open();

        GUI planeZ = gui.addFolder("planeZ");
        planeZ.addBoolean(_planeZ, "displayHelper").onChange(v -> planeHelpers.getAt(2).visible = v);
        planeZ.addNumber(_planeZ, "constant").setMin(-1).setMax(1).onChange(d -> planes.getAt(2).constant = d.doubleValue());
        planeZ.addNumber(_planeZ, "negated").onChange(e -> {

            planes.getAt(2).negate();
            _planeZ.set("constant", planes.getAt(2).constant);

        });
        planeZ.open();

        root.appendChild( renderer.domElement );
        root.appendChild(gui.getDomElement());

        ready = true;
    }

    private Group createPlaneStencilGroup(TorusKnotGeometry geometry, Plane plane, double renderOrder) {

        Group group = new Group();
        MeshBasicMaterial baseMat = new MeshBasicMaterial();
        baseMat.depthWrite = false;
        baseMat.depthTest = false;
        baseMat.colorWrite = false;
        baseMat.stencilWrite = true;
        baseMat.stencilFunc = THREE.AlwaysStencilFunc;

        // back faces
        MeshBasicMaterial mat0 = baseMat.clone_();
        mat0.side = THREE.BackSide;
        mat0.clippingPlanes = new Plane[]{plane};
        mat0.stencilFail = THREE.IncrementWrapStencilOp;
        mat0.stencilZFail = THREE.IncrementWrapStencilOp;
        mat0.stencilZPass = THREE.IncrementWrapStencilOp;

        Mesh mesh0 = new Mesh(geometry, mat0);
        mesh0.renderOrder = renderOrder;
        group.add(mesh0);

        // front faces
        MeshBasicMaterial mat1 = baseMat.clone_();
        mat1.side = THREE.FrontSide;
        mat1.clippingPlanes = new Plane[]{plane};
        mat1.stencilFail = THREE.DecrementWrapStencilOp;
        mat1.stencilZFail = THREE.DecrementWrapStencilOp;
        mat1.stencilZPass = THREE.DecrementWrapStencilOp;

        Mesh mesh1 = new Mesh(geometry, mat1);
        mesh1.renderOrder = renderOrder;

        group.add(mesh1);

        return group;

    }


    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);

    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            double currentTime = DomGlobal.performance.now();
            double time = (currentTime - startTime) / 1000;


            stats.begin();
            renderer.render(scene, camera);
            stats.end();
        }
    }

    @PageHiding
    private void onHide() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
        run = false;
        gui.hide();
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<div style=\"color:yellowgreen\"><a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> - - solid geometry with clip planes and stencil materials</div>";

        run = true;
        animate();

    }

}

