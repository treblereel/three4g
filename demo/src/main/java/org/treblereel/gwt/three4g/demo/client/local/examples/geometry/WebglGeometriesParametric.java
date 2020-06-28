package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.TraverseCallback;
import org.treblereel.gwt.three4g.demo.client.api.ParametricGeometries;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.GrannyKnot;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.ParametricGeometriesTorusKnotGeometry;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.SphereGeometry;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.TubeGeometry;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.ParametricBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/11/18.
 */
public class WebglGeometriesParametric extends Attachable {

    public static final String name = "geometries / parametric";
    float fov = 45f;
    float near = 1f;
    float far = 2000f;
    float y = 400f;
    float ox = 200f;
    float oy = 0f;
    float oz = 200f;
    float multiplyScalar = 30f;

    public WebglGeometriesParametric() {

        loadJavaScript(JavascriptTextResource.IMPL.getParametricGeometries().getText());
        loadJavaScript(JavascriptTextResource.IMPL.getCurveExtras().getText());

        camera = new PerspectiveCamera(fov, aspect, near, far);
        camera.position.y = y;
        scene = new Scene();
        //
        AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4f);
        scene.add(ambientLight);
        PointLight pointLight = new PointLight(0xffffff, 0.8f);
        camera.add(pointLight);


        scene.add(camera);
        //
        Texture map = new TextureLoader().load("img/UV_Grid_Sm.jpg");
        map.wrapS = map.wrapT = THREE.RepeatWrapping;
        map.anisotropy = 16;

        MeshPhongMaterialParameters meshPhongMaterialParameters = new MeshPhongMaterialParameters();
        meshPhongMaterialParameters.map = map;
        meshPhongMaterialParameters.side = THREE.DoubleSide;

        MeshPhongMaterial material = new MeshPhongMaterial(meshPhongMaterialParameters);
        //
        ParametricBufferGeometry geometry;
        Mesh object;


        geometry = new ParametricBufferGeometry(ParametricGeometries.plane(100, 100), 10, 10);
        geometry.center();

        object = new Mesh(geometry, material);
        object.position.set(-200f, 0f, 200f);
        scene.add(object);

        geometry = new ParametricBufferGeometry(ParametricGeometries.klein, 20, 20);
        object = new Mesh(geometry, material);
        object.position.set(0f, 0f, 200f);
        object.scale.multiplyScalar(5f);
        scene.add(object);

        geometry = new ParametricBufferGeometry(ParametricGeometries.mobius, 20, 20);
        object = new Mesh(geometry, material);
        object.position.set(ox, oy, oz);
        object.scale.multiplyScalar(multiplyScalar);
        scene.add(object);

        GrannyKnot grannyKnot = new GrannyKnot();
        ParametricGeometriesTorusKnotGeometry torus = new ParametricGeometriesTorusKnotGeometry(50, 10, 50, 20, 2, 3);
        SphereGeometry sphere = new SphereGeometry(50, 20, 10);
        TubeGeometry tube = new TubeGeometry(grannyKnot, 100, 3, 8, true, false);

        object = new Mesh(torus, material);
        object.position.set(-200f, 0f, -200f);
        scene.add(object);

        object = new Mesh(sphere, material);
        object.position.set(0f, 0f, -200f);
        scene.add(object);

        object = new Mesh(tube, material);
        object.position.set(200f, 0f, -200f);
        object.scale.multiplyScalar(2f);
        scene.add(object);

        setupWebGLRenderer(renderer);

    }

    private void render() {
        double timer = new Date().getTime() * 0.0001;
        camera.position.x = (float) (Math.cos(timer) * 800);
        camera.position.z = (float) (Math.sin(timer) * 800);
        camera.lookAt(scene.position);

        scene.traverse(new TraverseCallback() {
            @Override
            public void onEvent(Object3D object) {
                if (object instanceof Mesh) {
                    object.rotation.x = (float) (timer * 5);
                    object.rotation.y = (float) (timer * 2.5);
                }
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" webgl - parametric geometries");
    }
}
