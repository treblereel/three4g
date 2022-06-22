package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.TrackballControls;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.extras.curves.CatmullRomCurve3;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometry;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometryOptions;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.MathUtils;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static elemental2.dom.DomGlobal.document;

@ApplicationScoped
@Page(path = "webgl_geometry_extrude_shapes")
public class WebglGeometryExtrudeShapes implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private TrackballControls controls;

    @PostConstruct
    public void init() {

        renderer = new WebGLRenderer();
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        scene = new Scene();
        scene.setBackground(new Color(0x222222));

        camera = new PerspectiveCamera(45, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000);
        camera.position.set(0, 0, 500);

        controls = new TrackballControls(camera, document.body);
        controls.minDistance = 200;
        controls.maxDistance = 500;

        scene.add(new AmbientLight(0x222222));

        PointLight light = new PointLight(0xffffff);
        light.position.copy(camera.position);
        scene.add(light);

        //

        CatmullRomCurve3 closedSpline = new CatmullRomCurve3(new Vector3[]{
                new Vector3(-60, -100, 60),
                new Vector3(-60, 20, 60),
                new Vector3(-60, 120, 60),
                new Vector3(60, 20, -60),
                new Vector3(60, -100, -60)
        });

        closedSpline.curveType = "catmullrom";
        closedSpline.closed = true;


        JsArray<Vector2> pts1 = new JsArray<>();
        int count = 3;

        for (int i = 0; i < count; i++) {

            int l = 20;

            double a = 2 * i / count * Math.PI;

            pts1.push(new Vector2(Math.cos(a) * l, Math.sin(a) * l));

        }

        Shape shape1 = new Shape(pts1);


        ExtrudeGeometryOptions extrudeSettings1 = ExtrudeGeometryOptions.create();
        extrudeSettings1.setSteps(100);
        extrudeSettings1.setBevelEnabled(false);
        extrudeSettings1.setExtrudePath(closedSpline);

        ExtrudeGeometry geometry1 = new ExtrudeGeometry(shape1, extrudeSettings1);

        MeshLambertMaterialParameters meshLambertMaterialParameters = MeshLambertMaterialParameters.create();
        meshLambertMaterialParameters.setColor(0xb00000);
        meshLambertMaterialParameters.setWireframe(false);

        MeshLambertMaterial material1 = new MeshLambertMaterial(meshLambertMaterialParameters);

        Mesh mesh1 = new Mesh(geometry1, material1);

        scene.add(mesh1);


        //


        JsArray<Vector3> randomPoints = new JsArray<>();

        for (int i = 0; i < 10; i++) {

            randomPoints.push(new Vector3((i - 4.5) * 50, MathUtils.randFloat(-50, 50), MathUtils.randFloat(-50, 50)));

        }

        CatmullRomCurve3 randomSpline = new CatmullRomCurve3(randomPoints);

        //

        ExtrudeGeometryOptions extrudeSettings2 = ExtrudeGeometryOptions.create();
        extrudeSettings2.setSteps(200);
        extrudeSettings2.setBevelEnabled(false);
        extrudeSettings2.setExtrudePath(randomSpline);

        JsArray<Vector2> pts2 = new JsArray<>();
        int numPts = 5;

        for (int i = 0; i < numPts * 2; i++) {

            double l = i % 2 == 1 ? 10 : 20;

            double a = ((double) i) / numPts * Math.PI;

            pts2.push(new Vector2(Math.cos(a) * l, Math.sin(a) * l));

        }

        Shape shape2 = new Shape(pts2);

        ExtrudeGeometry geometry2 = new ExtrudeGeometry(shape2, extrudeSettings2);


        MeshLambertMaterialParameters meshLambertMaterialParameters1 = MeshLambertMaterialParameters.create();
        meshLambertMaterialParameters1.setColor(0xff8000);
        meshLambertMaterialParameters1.setWireframe(false);


        MeshLambertMaterial material2 = new MeshLambertMaterial(meshLambertMaterialParameters1);

        Mesh mesh2 = new Mesh(geometry2, material2);

        scene.add(mesh2);


        //
        ExtrudeGeometryOptions extrudeSettings3 = ExtrudeGeometryOptions.create();
        extrudeSettings3.setDepth(20);
        extrudeSettings3.setSteps(1);
        extrudeSettings3.setBevelEnabled(true);
        extrudeSettings3.setBevelThickness(2);
        extrudeSettings3.setBevelSize(4);
        extrudeSettings3.setBevelSegments(1);

        Material[] materials = new Material[]{material1, material2};

        ExtrudeGeometry geometry3 = new ExtrudeGeometry(shape2, extrudeSettings3);

        Mesh mesh3 = new Mesh(geometry3, materials);

        mesh3.position.set(50, 100, 50);

        scene.add(mesh3);

        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

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
            controls.update();
            renderer.render(scene, camera);

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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> webgl - geometry extrude shapes";

        run = true;
        animate();
    }
}
