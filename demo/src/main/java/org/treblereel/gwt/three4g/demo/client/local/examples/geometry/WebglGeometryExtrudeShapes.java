package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.extras.curves.CatmullRomCurve3;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.ExtrudeGeometryParameters;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/24/18.
 */
@InjectJavaScriptFor(elements = TrackballControls.class)
public class WebglGeometryExtrudeShapes extends Attachable {


    public static final String name = "geometry / extrude / shapes";

    public WebglGeometryExtrudeShapes() {

        scene = new Scene();
        scene.background = new Color(0x222222);
        camera = new PerspectiveCamera(45, aspect, 1, 1000);
        camera.position.set(0, 0, 500);
        trackballControls = new TrackballControls(camera);
        trackballControls.minDistance = 200;
        trackballControls.maxDistance = 500;
        scene.add(new AmbientLight(0x222222));

        PointLight light = new PointLight(0xffffff);
        light.position.copy(camera.position);
        scene.add(light);
        //


        Vector3[] vector3s = new Vector3[]{
                new Vector3(-60, -100, 60),
                new Vector3(-60, 20, 60),
                new Vector3(-60, 120, 60),
                new Vector3(60, 20, -60),
                new Vector3(60, -100, -60)
        };

        CatmullRomCurve3 closedSpline = new CatmullRomCurve3(vector3s);
        closedSpline.curveType = "catmullrom";
        closedSpline.closed = true;

        ExtrudeGeometryParameters extrudeSettings = new ExtrudeGeometryParameters();
        extrudeSettings.steps = 100;
        extrudeSettings.bevelEnabled = false;
        extrudeSettings.extrudePath = closedSpline;


        Vector2[] pts = new Vector2[3];
        int count = 3;

        for (int i = 0; i < count; i++) {
            float l = 20;
            double a = 2 * (float) i / count * Math.PI;
            pts[i] = new Vector2((float) Math.cos(a) * l, (float) Math.sin(a) * l);
        }


        Shape shape = new Shape(pts);
        ExtrudeGeometry geometry = new ExtrudeGeometry(shape, extrudeSettings);
        MeshLambertMaterial material = new MeshLambertMaterial();
        material.color = new Color(0xb00000);
        material.wireframe = false;
        Mesh mesh = new Mesh(geometry, material);
        scene.add(mesh);


        //
        Vector3[] randomPoints = new Vector3[10];
        for (int i = 0; i < 10; i++) {
            randomPoints[i] = new Vector3((i - 4.5f) * 50f, org.treblereel.gwt.three4g.math.Math.randFloat(-50, 50), org.treblereel.gwt.three4g.math.Math.randFloat(-50f, 50f));
        }
        CatmullRomCurve3 randomSpline = new CatmullRomCurve3(randomPoints);
        //
        ExtrudeGeometryParameters extrudeSettings2 = new ExtrudeGeometryParameters();
        extrudeSettings2.steps = 200;
        extrudeSettings2.bevelEnabled = false;
        extrudeSettings2.extrudePath = randomSpline;

        int numPts = 5;
        pts = new Vector2[numPts * 2];
        for (int i = 0; i < numPts * 2; i++) {
            float l = i % 2 == 1 ? 10 : 20;
            double a = (float) i / numPts * Math.PI;
            pts[i] = new Vector2((float) (Math.cos(a) * l), (float) (Math.sin(a) * l));
        }

        shape = new Shape(pts);
        geometry = new ExtrudeGeometry(shape, extrudeSettings2);
        MeshLambertMaterial material2 = new MeshLambertMaterial();
        material2.color = new Color(0xff8000);
        material2.wireframe = false;
        mesh = new Mesh(geometry, material2);
        scene.add(mesh);
        //
        Material[] materials = new Material[]{material, material2};

        ExtrudeGeometryParameters extrudeSettings3 = new ExtrudeGeometryParameters();
        extrudeSettings3.depth = 20;
        extrudeSettings3.steps = 1;
        extrudeSettings3.bevelEnabled = true;
        extrudeSettings3.bevelThickness = 2;
        extrudeSettings3.bevelSize = 4;
        extrudeSettings3.bevelSegments = 1;


        geometry = new ExtrudeGeometry(shape, extrudeSettings3);
        mesh = new Mesh(geometry, materials);
        mesh.position.set(50, 100, 50);
        scene.add(mesh);

        renderer = new WebGLRenderer();
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);
        setupWebGLRenderer(renderer);
    }

    private void render() {
        trackballControls.update();
        renderer.render(scene, camera);
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - webgl - geometry extrude shapes");
    }

}

