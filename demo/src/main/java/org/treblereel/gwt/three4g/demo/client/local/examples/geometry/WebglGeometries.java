package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.CircleBufferGeometry;
import org.treblereel.gwt.three4g.geometries.CylinderBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.LatheBufferGeometry;
import org.treblereel.gwt.three4g.geometries.OctahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.RingBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TetrahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/26/18.
 */
public class WebglGeometries extends Attachable {

    public static final String name = "geometries";

    public WebglGeometries() {

        //   loadJavaScript(JavascriptTextResource.IMPL.getParametricGeometries().getText());
        //   loadJavaScript(JavascriptTextResource.IMPL.getCurveExtras().getText());

        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.y = 400;
        scene = new Scene();
        Mesh object;

        AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4f);
        scene.add(ambientLight);
        PointLight pointLight = new PointLight(0xffffff, 0.8f);
        camera.add(pointLight);
        scene.add(camera);
        Texture map = new TextureLoader().load("textures/UV_Grid_Sm.jpg");
        map.wrapS = map.wrapT = THREE.RepeatWrapping;
        map.anisotropy = 16;
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.map = map;
        material.side = THREE.DoubleSide;
        //
        object = new Mesh(new SphereBufferGeometry(75, 20, 10), material);
        object.position.set(-300, 0, 200);
        scene.add(object);
        object = new Mesh(new IcosahedronBufferGeometry(75, 1), material);
        object.position.set(-100, 0, 200);
        scene.add(object);
        object = new Mesh(new OctahedronBufferGeometry(75, 2), material);
        object.position.set(100, 0, 200);
        scene.add(object);
        object = new Mesh(new TetrahedronBufferGeometry(75, 0), material);
        object.position.set(300, 0, 200);
        scene.add(object);
        //
        object = new Mesh(new PlaneBufferGeometry(100, 100, 4, 4), material);
        object.position.set(-300, 0, 0);
        scene.add(object);
        object = new Mesh(new BoxBufferGeometry(100, 100, 100, 4, 4, 4), material);
        object.position.set(-100, 0, 0);
        scene.add(object);
        object = new Mesh(new CircleBufferGeometry(50, 20, 0, (float) Math.PI * 2), material);
        object.position.set(100, 0, 0);
        scene.add(object);
        object = new Mesh(new RingBufferGeometry(10, 50, 20, 5, 0, (float) Math.PI * 2), material);
        object.position.set(300, 0, 0);
        scene.add(object);
        //
        object = new Mesh(new CylinderBufferGeometry(25, 75, 100, 40, 5), material);
        object.position.set(-300, 0, -200);
        scene.add(object);
        Vector2[] points = new Vector2[50];
        for (int i = 0; i < 50; i++) {
            points[i] = new Vector2((float) (Math.sin(i * 0.2f) * Math.sin(i * 0.1f) * 15 + 50), (i - 5) * 2);
        }
        object = new Mesh(new LatheBufferGeometry(points, 20), material);
        object.position.set(-100, 0, -200);
        scene.add(object);
        object = new Mesh(new TorusBufferGeometry(50, 20, 20, 20), material);
        object.position.set(100, 0, -200);
        scene.add(object);
        object = new Mesh(new TorusKnotBufferGeometry(50, 10, 50, 20), material);
        object.position.set(300, 0, -200);
        scene.add(object);
        //
        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);

    }

    private void render() {
        double timer = new Date().getTime() * 0.0001;

        camera.position.x = (float) Math.cos(timer) * 800;
        camera.position.z = (float) Math.sin(timer) * 800;
        camera.lookAt(scene.position);

        scene.traverse(object -> {
            if (object instanceof Mesh) {
                object.rotation.x = (float) (timer * 5);
                object.rotation.y = (float) (timer * 2.5);
            }
        });
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" webgl - geometries");
    }
}

