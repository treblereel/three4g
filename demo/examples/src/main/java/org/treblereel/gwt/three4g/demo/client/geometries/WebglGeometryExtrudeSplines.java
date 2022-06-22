package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsArray;
import elemental2.core.JsBoolean;
import elemental2.core.JsDate;
import elemental2.core.JsNumber;
import elemental2.dom.*;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.lilgui4g.GUIProperty;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.controls.TrackballControls;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.curves.*;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.extras.curves.CatmullRomCurve3;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.geometries.TubeGeometry;
import org.treblereel.gwt.three4g.helpers.CameraHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static elemental2.dom.DomGlobal.document;

@ApplicationScoped
@Page(path = "webgl_geometry_extrude_splines")
public class WebglGeometryExtrudeSplines implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private TrackballControls controls;

    private Vector3 direction = new Vector3();
    private Vector3 binormal = new Vector3();
    private Vector3 normal = new Vector3();
    private Vector3 position = new Vector3();
    private Vector3 lookAt = new Vector3();

    private CatmullRomCurve3 pipeSpline = new CatmullRomCurve3(new Vector3[]{
            new Vector3(0, 10, -10), new Vector3(10, 0, -10),
            new Vector3(20, 0, 0), new Vector3(30, 0, 10),
            new Vector3(30, 0, 20), new Vector3(20, 0, 30),
            new Vector3(10, 0, 30), new Vector3(0, 0, 30),
            new Vector3(-10, 10, 30), new Vector3(-10, 20, 30),
            new Vector3(0, 30, 30), new Vector3(10, 30, 30),
            new Vector3(20, 30, 15), new Vector3(10, 30, 10),
            new Vector3(0, 30, 10), new Vector3(-10, 20, 10),
            new Vector3(-10, 10, 10), new Vector3(0, 0, 10),
            new Vector3(10, -10, 10), new Vector3(20, -15, 10),
            new Vector3(30, -15, 10), new Vector3(40, -15, 10),
            new Vector3(50, -15, 10), new Vector3(60, 0, 10),
            new Vector3(70, 0, 0), new Vector3(80, 0, 0),
            new Vector3(90, 0, 0), new Vector3(100, 0, 0)
    });

    private CatmullRomCurve3 sampleClosedSpline = new CatmullRomCurve3(new Vector3[]{
            new Vector3(0, -40, -40),
            new Vector3(0, 40, -40),
            new Vector3(0, 140, -40),
            new Vector3(0, 40, 40),
            new Vector3(0, -40, 40)
    });

    private JsPropertyMap splines = JsPropertyMap.of();
    private JsPropertyMap params = JsPropertyMap.of();

    private MeshLambertMaterial material;
    private MeshBasicMaterial wireframeMaterial;

    private Object3D parent;
    private PerspectiveCamera splineCamera;
    private CameraHelper cameraHelper;
    private Mesh cameraEye;
    private Stats stats;
    private HTMLElement splineFolderGeometry;

    @PostConstruct
    public void init() {

        sampleClosedSpline.curveType = "catmullrom";
        sampleClosedSpline.closed = true;

        splines.set("GrannyKnot", new GrannyKnot());
        splines.set("HeartCurve", new HeartCurve(3.5));
        splines.set("VivianiCurve", new VivianiCurve(70));
        splines.set("KnotCurve", new KnotCurve());
        splines.set("HelixCurve", new HelixCurve());
        splines.set("TrefoilKnot", new TrefoilKnot());
        splines.set("TorusKnot", new TorusKnot(20));
        splines.set("CinquefoilKnot", new CinquefoilKnot(20));
        splines.set("TrefoilPolynomialKnot", new TrefoilPolynomialKnot(14));
        splines.set("FigureEightPolynomialKnot", new FigureEightPolynomialKnot());
        splines.set("DecoratedTorusKnot4a", new DecoratedTorusKnot4a());
        splines.set("DecoratedTorusKnot4b", new DecoratedTorusKnot4b());
        splines.set("DecoratedTorusKnot5a", new DecoratedTorusKnot5a());
        splines.set("DecoratedTorusKnot5c", new DecoratedTorusKnot5c());
        splines.set("PipeSpline", pipeSpline);
        splines.set("SampleClosedSpline", sampleClosedSpline);

        params.set("spline", "GrannyKnot");
        params.set("scale", 4);
        params.set("extrusionSegments", 100);
        params.set("radiusSegments", 3);
        params.set("closed", true);
        params.set("animationView", false);
        params.set("lookAhead", false);
        params.set("cameraHelper", false);

        MeshLambertMaterialParameters meshLambertMaterialParameters = MeshLambertMaterialParameters.create();
        meshLambertMaterialParameters.setColor(0xff00ff);

        material = new MeshLambertMaterial(meshLambertMaterialParameters);


        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor(0x000000);
        meshBasicMaterialParameters.setOpacity(0.3);
        meshBasicMaterialParameters.setWireframe(true);
        meshBasicMaterialParameters.setTransparent(true);

        wireframeMaterial = new MeshBasicMaterial(meshBasicMaterialParameters);


        camera = new PerspectiveCamera(50, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 0.01, 10000);
        camera.position.set(0, 50, 500);

        // scene

        scene = new Scene();
        scene.setBackground(new Color(0xf0f0f0));

        // light

        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 0, 1);
        scene.add(light);

        // tube

        parent = new Object3D();
        scene.add(parent);

        splineCamera = new PerspectiveCamera(84, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 0.01, 1000);
        parent.add(splineCamera);

        cameraHelper = new CameraHelper(splineCamera);
        scene.add(cameraHelper);

        addTube();

        // debug camera

        MeshBasicMaterialParameters meshBasicMaterialParameters1 = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters1.setColor(0xdddddd);

        cameraEye = new Mesh(new SphereGeometry(5), new MeshBasicMaterial(meshBasicMaterialParameters1));
        parent.add(cameraEye);

        cameraHelper.visible = new JsBoolean(params.get("cameraHelper")).valueOf();
        cameraEye.visible = new JsBoolean(params.get("cameraHelper")).valueOf();

        // renderer
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        // stats

        stats = new Stats();
        root.appendChild(stats.dom);

        // dat.GUI

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.setWidth(285);
        GUI gui = new GUI(guiProperty);

        GUI folderGeometry = gui.addFolder("Geometry");

        JsArray<String> keys = new JsArray<>();
        splines.forEach(keys::push);

        splineFolderGeometry = folderGeometry.addOption(params, "spline", keys).onChange(e -> {

            addTube();

        }).domElement();

        folderGeometry.addNumber(params, "scale", 2, 10).setStep(2).onChange(e -> {

            setScale();

        });
        folderGeometry.addNumber(params, "extrusionSegments", 50, 500).setStep(50).onChange(e -> {

            addTube();

        });
        folderGeometry.addNumber(params, "radiusSegments", 2, 12).setStep(1).onChange(e -> {

            addTube();

        });
        folderGeometry.addBoolean(params, "closed").onChange(e -> {

            addTube();

        });
        folderGeometry.open();

        GUI folderCamera = gui.addFolder("Camera");
        folderCamera.addBoolean(params, "animationView").onChange(e -> {

            animateCamera();

        });
        folderCamera.addBoolean(params, "lookAhead").onChange(e -> {

            animateCamera();

        });
        folderCamera.addBoolean(params, "cameraHelper").onChange(e -> {

            animateCamera();

        });
        folderCamera.open();

        OrbitControls controls = new OrbitControls(camera, renderer.domElement);
        controls.minDistance = 100;
        controls.maxDistance = 2000;

        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    private TubeGeometry tubeGeometry;

    private void addTube() {

        if (mesh != null) {

            parent.remove(mesh);
            mesh.geometry.dispose();

        }

        Curve extrudePath = Js.uncheckedCast(splines.get(params.get("spline").toString()));
        tubeGeometry = new TubeGeometry(extrudePath, new JsNumber(params.get("extrusionSegments")).valueOf(),
                2,
                new JsNumber(params.get("radiusSegments")).valueOf(),
                new JsBoolean(params.get("closed")).valueOf());

        addGeometry(tubeGeometry);

        setScale();

    }

    private Mesh mesh;

    private void setScale() {

        mesh.scale.set(new JsNumber(params.get("scale")).valueOf(), new JsNumber(params.get("scale")).valueOf(), new JsNumber(params.get("scale")).valueOf());

    }


    private void addGeometry(BufferGeometry geometry) {

        // 3D shape

        mesh = new Mesh(geometry, material);
        Mesh wireframe = new Mesh(geometry, wireframeMaterial);
        mesh.add(wireframe);

        parent.add(mesh);

    }

    private void animateCamera() {

        cameraHelper.visible = new JsBoolean(params.get("cameraHelper")).valueOf();
        cameraEye.visible = new JsBoolean(params.get("cameraHelper")).valueOf();

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {

            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);

            controls.handleResize();

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            double time = JsDate.now();
            double looptime = 20 * 1000;
            double t = (time % looptime) / looptime;

            tubeGeometry.parameters.getPath().getPointAt(t, position);
            position.multiplyScalar(new JsNumber(params.get("scale")).valueOf());

            // interpolation

            int segments = tubeGeometry.tangents.length;
            int pickt = (int) t * segments;
            int pick = (int) Math.floor(pickt);
            int pickNext = (pick + 1) % segments;

            binormal.subVectors(tubeGeometry.binormals.getAt(pickNext), tubeGeometry.binormals.getAt(pick));
            binormal.multiplyScalar(pickt - pick).add(tubeGeometry.binormals.getAt(pick));

            tubeGeometry.parameters.getPath().getTangentAt(t, direction);
            int offset = 15;

            normal.copy(binormal).cross(direction);

            // we move on a offset on its binormal

            position.add(normal.clone_().multiplyScalar(offset));

            splineCamera.position.copy(position);
            cameraEye.position.copy(position);

            // using arclength for stablization in look ahead

            tubeGeometry.parameters.getPath().getPointAt((t + 30 / tubeGeometry.parameters.getPath().getLength()) % 1, lookAt);
            lookAt.multiplyScalar(new JsNumber(params.get("scale")).valueOf());

            // camera orientation 2 - up orientation via normal

            if (!new JsBoolean(params.get("lookAhead")).valueOf()) {
                lookAt.copy(position).add(direction);
            }
            splineCamera.matrix.lookAt(splineCamera.position, lookAt, normal);
            splineCamera.quaternion.setFromRotationMatrix(splineCamera.matrix);

            cameraHelper.update();

            renderer.render(scene, new JsBoolean(params.get("animationView")).valueOf() == true ? splineCamera : camera);

        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - spline extrusion examples";


        for (int i = 0; i < splineFolderGeometry.childElementCount; i++) {
            HTMLElement node = (HTMLElement) splineFolderGeometry.childNodes.getAt(i);
            if(node.classList.contains("widget")) {
                HTMLElement widget  = node;
                for (int j = 0; j < widget.childElementCount; j++) {
                    if(node instanceof HTMLSelectElement) {
                        node.style.backgroundColor = "grey";
                    }
                }
            }
        }

        run = true;
        animate();
    }
}
