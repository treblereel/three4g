package org.treblereel.gwt.three4g.demo.client.local.examples.camera;

import java.util.Date;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.KeyboardEvent;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.helpers.CameraHelper;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.PointsMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.scenes.Scene;

import static elemental2.dom.DomGlobal.document;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/18/18.
 */
public class WebGlCamera extends Attachable {

    public static final String name = "camera";
    private Camera activeCamera;
    private PerspectiveCamera cameraPerspective;
    private OrthographicCamera cameraOrtho;
    private CameraHelper cameraOrthoHelper, cameraPerspectiveHelper, activeHelper;
    private Group cameraRig;
    private Mesh mesh, mesh2;
    private int frustumSize = 600;

    public WebGlCamera() {

        scene = new Scene();

        camera = new PerspectiveCamera(50f, 0.5f * aspect, 1f, 10000f);
        camera.position.z = 2500f;
        cameraPerspective = new PerspectiveCamera(50f, 0.5f * aspect, 150f, 1000f);
        cameraPerspectiveHelper = new CameraHelper(cameraPerspective);
        scene.add(cameraPerspectiveHelper);

        cameraOrtho = new OrthographicCamera((float) (0.5 * frustumSize * aspect / -2), (float) (0.5 * frustumSize * aspect / 2), frustumSize / 2, frustumSize / -2, 150, 1000);
        cameraOrthoHelper = new CameraHelper(cameraOrtho);
        scene.add(cameraOrthoHelper);

        activeCamera = cameraPerspective;
        activeHelper = cameraPerspectiveHelper;
        // counteract different front orientation of cameras vs rig
        cameraOrtho.rotation.y = (float) Math.PI;
        cameraPerspective.rotation.y = (float) Math.PI;
        cameraRig = new Group();
        cameraRig.add(cameraPerspective);
        cameraRig.add(cameraOrtho);
        scene.add(cameraRig);

        MeshBasicMaterialParameters param1 = new MeshBasicMaterialParameters();
        param1.color = new Color(0xffffff);
        param1.wireframe = true;

        mesh = new Mesh(
                new SphereBufferGeometry(100f, 16, 8),
                new MeshBasicMaterial(param1)
        );
        scene.add(mesh);

        MeshBasicMaterialParameters param2 = new MeshBasicMaterialParameters();
        param2.color = new Color(0x00ff00);
        param2.wireframe = true;

        mesh2 = new Mesh(
                new SphereBufferGeometry(50f, 16, 8),
                new MeshBasicMaterial(param2)
        );
        mesh2.position.y = 150f;
        mesh.add(mesh2);

        MeshBasicMaterialParameters param3 = new MeshBasicMaterialParameters();
        param3.color = new Color(0x0000ff);
        param3.wireframe = true;

        Mesh mesh3 = new Mesh(
                new SphereBufferGeometry(5f, 16, 8),
                new MeshBasicMaterial(param3)
        );
        mesh3.position.z = 150f;
        cameraRig.add(mesh3);

        BufferGeometry geometry = new BufferGeometry();

        JsArray<Float> vertices = new JsArray<>();

        for (int i = 0; i < 10000; i++) {
            vertices.push(org.treblereel.gwt.three4g.math.Math.randFloatSpread(2000f)); // x
            vertices.push(org.treblereel.gwt.three4g.math.Math.randFloatSpread(2000f)); // y
            vertices.push(org.treblereel.gwt.three4g.math.Math.randFloatSpread(2000f)); // z
        }

        geometry.attributes.position = new Float32BufferAttribute(vertices, 3);
        PointsMaterialParameters pointsMaterialParameters = new PointsMaterialParameters();
        pointsMaterialParameters.color = new Color(0x888888);

        Points particles = new Points(geometry, new PointsMaterial(pointsMaterialParameters));
        scene.add(particles);

        setupWebGLRenderer(renderer);
        renderer.autoClear = false;

        document.addEventListener("keydown", evt -> onKeyDown(evt), false);
    }

    private void onKeyDown(Event evt) {
        if (evt instanceof KeyboardEvent) {
            KeyboardEvent e = (KeyboardEvent) evt;

            switch (e.code) {
                case "KeyP":
                    activeCamera = cameraPerspective;
                    activeHelper = cameraPerspectiveHelper;
                    break;
                case "KeyO":
                    activeCamera = cameraOrtho;
                    activeHelper = cameraOrthoHelper;
                    break;
            }
        }
    }

    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("- cameras<br/>\n" +
                                                                                                                          "\t\t<b>O</b> orthographic <b>P</b> perspective");
    }

    @Override
    public void onWindowResize() {
        if (camera != null && renderer != null) {
            aspect = new Float(getWidth() / getHeight());

            renderer.setSize(getWidth(), getHeight());
            camera.aspect = 0.5f * aspect;
            camera.updateProjectionMatrix();
            cameraPerspective.aspect = 0.5f * aspect;
            cameraPerspective.updateProjectionMatrix();
            cameraOrtho.left = (float) (-0.5f * frustumSize * (getWidth() / getHeight()) / 2);
            cameraOrtho.right = (float) (0.5f * frustumSize * (getWidth() / getHeight()) / 2);
            cameraOrtho.top = frustumSize / 2f;
            cameraOrtho.bottom = -frustumSize / 2f;
            cameraOrtho.updateProjectionMatrix();
        }
    }

    private void animate() {
        StatsProducer.getStats().update();

        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {

        double r = new Date().getTime() * 0.0005;
        mesh.position.x = (float) (700 * Math.cos(r));
        mesh.position.z = (float) (700 * Math.sin(r));
        mesh.position.y = (float) (700 * Math.sin(r));

        mesh.children[0].position.x = (float) (70 * Math.cos(2 * r));
        mesh.children[0].position.z = (float) (70 * Math.sin(r));

        if (activeCamera instanceof PerspectiveCamera) {
            cameraPerspective.fov = (float) (35 + 30 * Math.sin(0.5 * r));
            cameraPerspective.far = mesh.position.length();
            cameraPerspective.updateProjectionMatrix();
            cameraPerspectiveHelper.update();
            cameraPerspectiveHelper.visible = true;
            cameraOrthoHelper.visible = false;
        } else {
            cameraOrtho.far = mesh.position.length() + 100;
            cameraOrtho.updateProjectionMatrix();
            cameraOrthoHelper.update();
            cameraOrthoHelper.visible = true;
            cameraPerspectiveHelper.visible = false;
        }
        cameraRig.lookAt(mesh.position);
        renderer.clear(true, true, true); //TODO
        activeHelper.visible = false;
        renderer.setViewport(0, 0, (int) (getWidth() / 2), (int) getHeight());
        renderer.render(scene, activeCamera);

        activeHelper.visible = true;
        renderer.setViewport((int) getWidth() / 2, 0, (int) getWidth() / 2, (int) getHeight());
        renderer.render(scene, camera);
    }
}
