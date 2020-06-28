package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.CinquefoilKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.DecoratedTorusKnot4a;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.DecoratedTorusKnot4b;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.DecoratedTorusKnot5a;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.DecoratedTorusKnot5c;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.FigureEightPolynomialKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.GrannyKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.HeartCurve;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.HelixCurve;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.KnotCurve;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.TorusKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.TrefoilKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.TrefoilPolynomialKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.VivianiCurve;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.extras.curves.CatmullRomCurve3;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TubeBufferGeometry;
import org.treblereel.gwt.three4g.helpers.CameraHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/25/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglGeometryExtrudeSplines extends Attachable {


    public static final String name = "geometry / extrude / splines";
    private PerspectiveCamera splineCamera;

    private Vector3 binormal = new Vector3();
    private Vector3 normal = new Vector3();

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

    private Object3D parent;
    private TubeBufferGeometry tubeGeometry;
    private Mesh cameraEye;
    private CameraHelper cameraHelper;

    private Map<String, Curve> splines = new HashMap<>();

    private String spline = "GrannyKnot";
    private int scale = 4;
    private int extrusionSegments = 100;
    private int radiusSegments = 3;
    private boolean closed = true;
    private boolean animationView = false;
    private boolean lookAhead = false;
    private boolean isCameraHelper = false;

    private MeshLambertMaterial material;
    private MeshBasicMaterial wireframeMaterial;


    public WebglGeometryExtrudeSplines() {
        loadJavaScript(JavascriptTextResource.IMPL.getCurveExtras().getText());

        splines.put("GrannyKnot", new GrannyKnot());
        splines.put("HeartCurve", new HeartCurve(3.5f));
        splines.put("VivianiCurve", new VivianiCurve(70));
        splines.put("KnotCurve", new KnotCurve());
        splines.put("HelixCurve", new HelixCurve());
        splines.put("TrefoilKnot", new TrefoilKnot());
        splines.put("TorusKnot", new TorusKnot(20));
        splines.put("CinquefoilKnot", new CinquefoilKnot(20));
        splines.put("TrefoilPolynomialKnot", new TrefoilPolynomialKnot(14));
        splines.put("FigureEightPolynomialKnot", new FigureEightPolynomialKnot());
        splines.put("DecoratedTorusKnot4a", new DecoratedTorusKnot4a());
        splines.put("DecoratedTorusKnot4b", new DecoratedTorusKnot4b());
        splines.put("DecoratedTorusKnot5a", new DecoratedTorusKnot5a());
        splines.put("DecoratedTorusKnot5c", new DecoratedTorusKnot5c());
        splines.put("PipeSpline", pipeSpline);
        splines.put("SampleClosedSpline", sampleClosedSpline);

        sampleClosedSpline.curveType = "catmullrom";
        sampleClosedSpline.closed = true;

        material = new MeshLambertMaterial();
        material.color = new Color(0xff00ff);

        wireframeMaterial = new MeshBasicMaterial();
        wireframeMaterial.color = new Color(0x000000);
        wireframeMaterial.opacity = 0.3f;
        wireframeMaterial.wireframe = true;
        wireframeMaterial.transparent = true;


        scene = new Scene();
        scene.background = new Color(0xf0f0f0);
        // light
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 0, 1);
        scene.add(light);
        // tube
        parent = new Object3D();
        scene.add(parent);

        camera = new PerspectiveCamera(50, aspect, 0.01f, 10000);
        camera.position.set(0, 50, 500);

        splineCamera = new PerspectiveCamera(84, aspect, 0.01f, 1000);
        splineCamera.position.set(0, 50, 500);

        parent.add(splineCamera);
        cameraHelper = new CameraHelper(splineCamera);
        scene.add(cameraHelper);

        addTube();
        // debug camera
        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.color = new Color(0xdddddd);

        cameraEye = new Mesh(new SphereBufferGeometry(5), new MeshBasicMaterial(parameters));
        parent.add(cameraEye);

        cameraHelper.visible = isCameraHelper;
        cameraEye.visible = isCameraHelper;


        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);

        orbitControls = new OrbitControls(camera, renderer.domElement);

        initGui();
    }

    private void initGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;
        gui = new GUI(guiProperty);

        String[] values = splines.keySet().stream().toArray(String[]::new);
        GUI folderGeometry = gui.addFolder("Geometry").add("spline", values, "GrannyKnot").done().open();

        folderGeometry.add("scale", scale, 2, 10).setStep(2).onChange(result -> scale = result.intValue()).done();
        folderGeometry.add("extrusionSegments", extrusionSegments, 50, 500).setStep(50).onChange(result -> extrusionSegments = result.intValue()).done();
        folderGeometry.add("radiusSegments", radiusSegments, 2, 12).setStep(1).onChange(result -> radiusSegments = result.intValue()).done();
        folderGeometry.add("closed", closed).onChange(result -> closed = result).done();

        GUI folderCamera = gui.addFolder("Camera").open();
        folderCamera.add("animationView", animationView).onChange(result -> {
            animationView = result;
            animateCamera();
        }).done();
        folderCamera.add("lookAhead", lookAhead).onChange(result -> {
            lookAhead = result;
            animateCamera();
        }).done();
        folderCamera.add("cameraHelper", isCameraHelper).onChange(result -> {
            isCameraHelper = result;
            animateCamera();
        }).done();
        gui.finishAndBuild();


        AppSetup.guiDiv.get().appendChild(gui.getDomElement());


    }

    private void render() {

        double time = new Date().getTime();
        orbitControls.update();

        double looptime = 20 * 1000;
        double t = (time % looptime) / looptime;
        Vector3 pos = tubeGeometry.parameters.path.getPointAt((float) t);
        pos.multiplyScalar(scale);
        // interpolation
        int segments = tubeGeometry.tangents.length;
        double pickt = t * segments;
        double pick = Math.floor(pickt);
        double pickNext = (pick + 1) % segments;

        binormal.subVectors(tubeGeometry.binormals[(int) pickNext], tubeGeometry.binormals[(int) pick]);
        binormal.multiplyScalar((int) (pickt - pick)).add(tubeGeometry.binormals[(int) pick]);

        Vector3 dir = tubeGeometry.parameters.path.getTangentAt((int) t);
        int offset = 15;
        normal.copy(binormal).cross(dir);
        // we move on a offset on its binormal
        pos.add(normal.clone().multiplyScalar(offset));
        camera.position.copy(pos);
        cameraEye.position.copy(pos);
        // using arclength for stablization in look ahead
        Vector3 lookAt = tubeGeometry.parameters.path.getPointAt(((float) t + 30 / tubeGeometry.parameters.path.getLength()) % 1).multiplyScalar(scale);
        // camera orientation 2 - up orientation via normal
        if (!lookAhead) lookAt.copy(pos).add(dir);

        camera.matrix.lookAt(camera.position, lookAt, normal);
        camera.rotation.setFromRotationMatrix(camera.matrix, camera.rotation.order);

        cameraHelper.update();
        renderer.render(scene, animationView ? camera : splineCamera);
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

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  - geometry - spline extrusion examples by <a href=\"http://www.lab4games.net/zz85/blog\" target=\"_blank\" rel=\"noopener\">zz85</a>");
    }

    private void addTube() {
        if (mesh != null) {
            parent.remove(mesh);
            mesh.geometry.dispose();
        }
        Curve extrudePath = splines.get(spline);
        tubeGeometry = new TubeBufferGeometry(extrudePath, extrusionSegments, 2, radiusSegments, closed);
        addGeometry(tubeGeometry);
        setScale();
    }


    private void setScale() {
        mesh.scale.set(scale, scale, scale);
    }


    private void addGeometry(TubeBufferGeometry geometry) {
        // 3D shape
        mesh = new Mesh(geometry, material);
        Mesh wireframe = new Mesh(geometry, wireframeMaterial);
        mesh.add(wireframe);
        parent.add(mesh);
    }

    private void animateCamera() {
        cameraHelper.visible = isCameraHelper;
        cameraEye.visible = isCameraHelper;
    }

}
