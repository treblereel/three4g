package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/31/18.
 */
public class WebglMaterialsCubemapBallsRefraction extends Attachable {

    public static final String name = "materials / cubemap / balls / refraction";
    private List<Mesh> spheres = new ArrayList<>();
    private Vector2 mouse = new Vector2();
    private Random random = new Random();

    public WebglMaterialsCubemapBallsRefraction() {

        camera = new PerspectiveCamera(60, aspect, 1, 100000);
        camera.position.z = 3200;
        scene = new Scene();
        scene.background = new CubeTextureLoader()
                .setPath("textures/cube/Park3Med/")
                .load(new String[]{"px.jpg", "nx.jpg", "py.jpg", "ny.jpg", "pz.jpg", "nz.jpg"});
        SphereBufferGeometry geometry = new SphereBufferGeometry(100, 32, 16);
        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.color = new Color(0xffffff);
        parameters.envMap = scene.background.cast();
        parameters.refractionRatio = 0.95f;
        MeshBasicMaterial material = new MeshBasicMaterial(parameters);
        material.envMap.mapping = THREE.CubeRefractionMapping;
        for (int i = 0; i < 500; i++) {
            Mesh mesh = new Mesh(geometry, material);
            mesh.position.x = random.nextFloat() * 10000 - 5000;
            mesh.position.y = random.nextFloat() * 10000 - 5000;
            mesh.position.z = random.nextFloat() * 10000 - 5000;
            mesh.scale.x = mesh.scale.y = mesh.scale.z = random.nextFloat() * 3 + 1;
            scene.add(mesh);
            spheres.add(mesh);
        }

        renderer = new WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);
        //
        container.appendChild(renderer.domElement);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };

    }

    private void onDocumentMouseMove(MouseEvent event) {
        mouse.x = (float) ((event.clientX - (window.innerWidth / 2)) * 10);
        mouse.y = (float) ((event.clientY - (window.innerHeight / 2)) * 10);
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - - webgl cube refraction demo. skybox by <a style=\"color:orange;\" href=\"http://www.zfight.com/\" target=\"_blank\" rel=\"noopener\">Jochum Skoglund</a>");
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
        float timer = new Date().getTime() * 0.0001f;

        for (int i = 0; i < spheres.size(); i++) {
            Mesh sphere = spheres.get(i);
            sphere.position.x = 5000 * (float) Math.cos(timer + i);
            sphere.position.y = 5000 * (float) Math.sin(timer + i * 1.1);
        }
        camera.position.x += (mouse.x - camera.position.x) * .05;
        camera.position.y += (-mouse.y - camera.position.y) * .05;
        camera.lookAt(scene.position);
        renderer.render(scene, camera);
    }

}




