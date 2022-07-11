package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.FirstPersonControls;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.curves.NURBSCurve;
import org.treblereel.gwt.three4g.curves.NURBSSurface;
import org.treblereel.gwt.three4g.demo.client.utils.PointerEvent;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.geometries.parametric.ParametricGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.*;
import org.treblereel.gwt.three4g.math.*;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_nurbs")
public class WebglGeometryNurbs implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Stats stats;

    private Group group;

    private NURBSSurface nurbsSurface;

    private double targetRotation = 0;
    private double targetRotationOnPointerDown = 0;

    private double pointerX = 0;
    private double pointerXOnPointerDown = 0;

    private int windowHalfX = DomGlobal.window.innerWidth / 2;


    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera(50, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 2000);
        camera.position.set(0, 150, 750);

        scene = new Scene();
        scene.setBackground(new Color(0xf0f0f0));

        scene.add(new AmbientLight(0x808080));

        DirectionalLight light = new DirectionalLight(0xffffff, 1);
        light.position.set(1, 1, 1);
        scene.add(light);

        group = new Group();
        group.position.y = 50;
        scene.add(group);

        // NURBS curve

        JsArray<Vector> nurbsControlPoints = new JsArray<>();
        JsArray<Double> nurbsKnots = new JsArray<>();
        int nurbsDegree = 3;

        for (int i = 0; i <= nurbsDegree; i++) {

            nurbsKnots.push(0.0);

        }

        for (int i = 0, j = 20; i < j; i++) {

            nurbsControlPoints.push(
                    new Vector4(
                            Math.random() * 400 - 200,
                            Math.random() * 400,
                            Math.random() * 400 - 200,
                            1 // weight of control point: higher means stronger attraction
                    )
            );

            double knot = (i + 1) / (j - nurbsDegree);
            nurbsKnots.push(MathUtils.clamp(knot, 0, 1));

        }

        NURBSCurve nurbsCurve = new NURBSCurve(nurbsDegree, nurbsKnots, nurbsControlPoints);

        BufferGeometry nurbsGeometry = new BufferGeometry();
        nurbsGeometry.setFromPoints(nurbsCurve.getPoints(200));

        LineBasicMaterialParameters lineBasicMaterialParameters = LineBasicMaterialParameters.create();
        lineBasicMaterialParameters.setColor(0x333333);

        LineBasicMaterial nurbsMaterial = new LineBasicMaterial(lineBasicMaterialParameters);

        Line nurbsLine = new Line(nurbsGeometry, nurbsMaterial);
        nurbsLine.position.set(200, -100, 0);
        group.add(nurbsLine);

        BufferGeometry nurbsControlPointsGeometry = new BufferGeometry();
        nurbsControlPointsGeometry.setFromPoints(nurbsCurve.controlPoints);


        LineBasicMaterialParameters nurbsControlPointsMaterialParameters = LineBasicMaterialParameters.create();
        nurbsControlPointsMaterialParameters.setColor(0x333333);
        nurbsControlPointsMaterialParameters.setOpacity(0.25);
        nurbsControlPointsMaterialParameters.setTransparent(true);

        LineBasicMaterial nurbsControlPointsMaterial = new LineBasicMaterial(nurbsControlPointsMaterialParameters);

        Line nurbsControlPointsLine = new Line(nurbsControlPointsGeometry, nurbsControlPointsMaterial);
        nurbsControlPointsLine.position.copy(nurbsLine.position);
        group.add(nurbsControlPointsLine);

        // NURBS surface

        Vector[][] nsControlPoints = new Vector[][]{{

                new Vector4(-200, -200, 100, 1),
                new Vector4(-200, -100, -200, 1),
                new Vector4(-200, 100, 250, 1),
                new Vector4(-200, 200, -100, 1)
        },
                {
                        new Vector4(0, -200, 0, 1),
                        new Vector4(0, -100, -100, 5),
                        new Vector4(0, 100, 150, 5),
                        new Vector4(0, 200, 0, 1)
                },
                {
                        new Vector4(200, -200, -100, 1),
                        new Vector4(200, -100, 200, 1),
                        new Vector4(200, 100, -250, 1),
                        new Vector4(200, 200, 100, 1)
                }
        };

        int degree1 = 2;
        int degree2 = 3;
        int[] knots1 = new int[]{0, 0, 0, 1, 1, 1};
        int[] knots2 = new int[]{0, 0, 0, 0, 1, 1, 1, 1};
        nurbsSurface = new NURBSSurface(degree1, degree2, knots1, knots2, nsControlPoints);

        Texture map = new TextureLoader().load("textures/uv_grid_opengl.jpg");
        map.wrapS = map.wrapT = THREE.RepeatWrapping;
        map.anisotropy = 16;

        ParametricGeometry geometry = new ParametricGeometry((u, v, target) -> {

            getSurfacePoint(u, v, target);
            return null;
        }, 20, 20);


        MeshLambertMaterialParameters materialParameters = MeshLambertMaterialParameters.create();
        materialParameters.setMap(map);
        materialParameters.setSide(THREE.DoubleSide);

        MeshLambertMaterial material = new MeshLambertMaterial(materialParameters);
        Mesh object = new Mesh(geometry, material);
        object.position.set(-200, 100, 0);
        object.scale.multiplyScalar(1);
        group.add(object);

        //

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        stats = new Stats();
        root.appendChild(stats.dom);

        //root.style.touchAction = "none";
        root.addEventListener("pointerdown", e -> onPointerDown(e));


        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    EventListener pointerup = (Event event) -> {
        onPointerUp(event);
    };

    EventListener pointermove = (Event event) -> {
        onPointerMove(event);
    };

    private void onPointerDown(Event e) {

        PointerEvent event = (PointerEvent) e;

        if (event.isPrimary == false) return;

        pointerXOnPointerDown = event.clientX - windowHalfX;
        targetRotationOnPointerDown = targetRotation;

        DomGlobal.document.addEventListener("pointermove", pointermove);
        DomGlobal.document.addEventListener("pointerup", pointerup);
    }

    private void onPointerUp(Event e) {
        PointerEvent event = (PointerEvent) e;
        if (event.isPrimary == false) return;

        DomGlobal.document.removeEventListener("pointermove", pointermove);
        DomGlobal.document.removeEventListener("pointerup", pointerup);
    }

    private void onPointerMove(Event e) {
        PointerEvent event = (PointerEvent) e;

        if (event.isPrimary == false) return;

        pointerX = event.clientX - windowHalfX;

        targetRotation = targetRotationOnPointerDown + (pointerX - pointerXOnPointerDown) * 0.02;
    }

    private void getSurfacePoint(double u, double v, Vector3 target) {

        nurbsSurface.getPoint(u, v, target);

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

            group.rotation.y += (targetRotation - group.rotation.y) * 0.05;
            renderer.render(scene, camera);
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - NURBS curve and surface example";

        run = true;
        animate();
    }
}

