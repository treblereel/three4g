package org.treblereel.gwt.three4g.demo.client.local.examples.clipping;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.helpers.AxesHelper;
import org.treblereel.gwt.three4g.helpers.PlaneHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/11/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglClippingIntersection extends Attachable {

    public static final String name = "clipping / intersection";
    private Plane[] clipPlanes = new Plane[3];
    private boolean clipIntersection = true;

    public WebglClippingIntersection() {

        clipPlanes[0] = new Plane(new Vector3(1, 0, 0), 0);
        clipPlanes[1] = new Plane(new Vector3(0, -1, 0), 0);
        clipPlanes[2] = new Plane(new Vector3(0, 0, -1), 0);

        scene = new Scene();
        camera = new PerspectiveCamera(40, aspect, 1, 200);
        camera.position.set(-20, 30, 40);

        orbitControls = new OrbitControls(camera, root);
        orbitControls.minDistance = 10;
        orbitControls.maxDistance = 100;
        orbitControls.enablePan = false;

        HemisphereLight light = new HemisphereLight(0xffffff, 0x080808, 1);
        scene.add(light);
        scene.add(new AmbientLight(0x505050));
        //
        Group group = new Group();
        for (int i = 1; i < 25; i++) {
            SphereBufferGeometry geometry = new SphereBufferGeometry(i / 2, 48, 24);
            MeshLambertMaterial material = new MeshLambertMaterial();
            material.color = new Color((float) (Math.sin(i * 0.5) * 0.5 + 0.5), (float) (Math.cos(i * 1.5) * 0.5 + 0.5), (float) (Math.sin(i * 4.5 + 0) * 0.5 + 0.5));
            material.side = THREE.DoubleSide;
            material.clippingPlanes = clipPlanes;
            material.clipIntersection = clipIntersection;
            group.add(new Mesh(geometry, material));
        }
        scene.add(group);
        // helpers
        Group helpers = new Group();
        helpers.add(new AxesHelper(20));
        helpers.add(new PlaneHelper(clipPlanes[0], 30, new Color(0xff0000)));
        helpers.add(new PlaneHelper(clipPlanes[1], 30, new Color(0x00ff00)));
        helpers.add(new PlaneHelper(clipPlanes[2], 30, new Color(0x0000ff)));
        helpers.visible = false;
        scene.add(helpers);

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;
        gui = new GUI(guiProperty);

        gui.add("clip Intersection", true).onChange(result -> {
            Object3D[] children = group.children;
            for (int i = 0; i < children.length; i++) {
                Mesh mesh = children[i].cast();
                MeshLambertMaterial material = mesh.material.cast();
                material.clipIntersection = result;
            }
            render();
        }).done();

        gui.add("planeConstant", 0, -16, 16).onChange(result -> {
            for (int j = 0; j < clipPlanes.length; j++) {
                clipPlanes[j].constant = result.floatValue();
            }
            render();
        }).done();

        gui.add("show Helpers", false).onChange(result -> {
            helpers.visible = result;
            render();
        }).done();

        gui.finishAndBuild();


        AppSetup.guiDiv.get().appendChild(gui.getDomElement());

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(getWidth(), getHeight());
        renderer.localClippingEnabled = true;

    }


    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
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
                render();
                animate();
            }
        });
    }

    private void render() {
        renderer.render(scene, camera);
    }
}

