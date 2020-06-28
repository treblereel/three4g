package org.treblereel.gwt.three4g.demo.client.local.examples.interactive;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.MouseEvent;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/13/18.
 */
public class WebglInteractiveCubes extends Attachable {

    public final static String name = "interactive / cubes";
    private Random rand = new Random();
    private Raycaster raycaster;
    private Vector2 mouse = new Vector2();
    private float radius = 100, theta = 0;
    private Mesh INTERSECTED;

    public WebglInteractiveCubes() {
        camera = new PerspectiveCamera(70, aspect, 1, 10000);
        scene = new Scene();
        scene.background = new Color(0xf0f0f0);

        DirectionalLight light = new DirectionalLight(0xffffff, 1);
        light.position.set(1, 1, 1).normalize();

        scene.add(light);
        BoxBufferGeometry geometry = new BoxBufferGeometry(20, 20, 20);
        for (int i = 0; i < 2000; i++) {
            MeshLambertMaterialParameters parameters = new MeshLambertMaterialParameters();
            parameters.color = new Color(rand.nextInt() * 0xffffff);
            Mesh object = new Mesh(geometry, new MeshLambertMaterial(parameters));

            object.position.x = rand.nextFloat() * 800 - 400;
            object.position.y = rand.nextFloat() * 800 - 400;
            object.position.z = rand.nextFloat() * 800 - 400;
            object.rotation.x = (float) (rand.nextFloat() * 2 * Math.PI);
            object.rotation.y = (float) (rand.nextFloat() * 2 * Math.PI);
            object.rotation.z = (float) (rand.nextFloat() * 2 * Math.PI);
            object.scale.x = rand.nextFloat() + 0.5f;
            object.scale.y = rand.nextFloat() + 0.5f;
            object.scale.z = rand.nextFloat() + 0.5f;
            scene.add(object);
        }
        raycaster = new Raycaster();

        // RENDERER
        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
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

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float) (((event.clientX - panel.offsetWidth) / (window.innerWidth - panel.offsetWidth)) * 2 - 1);
        mouse.y = (float) (-(event.clientY / window.innerHeight) * 2 + 1);
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  -  webgl - interactive cubes");

    }

    private void render() {
        theta += 0.1;
        camera.position.x = radius * (float) Math.sin(org.treblereel.gwt.three4g.math.Math.degToRad(theta));
        camera.position.y = radius * (float) Math.sin(org.treblereel.gwt.three4g.math.Math.degToRad(theta));
        camera.position.z = radius * (float) Math.cos(org.treblereel.gwt.three4g.math.Math.degToRad(theta));
        camera.lookAt(scene.position);
        camera.updateMatrixWorld();
        // find intersections
        raycaster.setFromCamera(mouse, camera);
        Intersect[] intersects = raycaster.intersectObjects(scene.children);

        if (intersects.length > 0) {
            Intersect intersect = intersects[0];
            Mesh intersected = intersect.object;
            if (INTERSECTED != intersected) {
                int currentHex = ((MeshLambertMaterial) intersected.material).emissive.getHex();
                intersected.userData.setProperty("currentHex", currentHex);
                ((MeshLambertMaterial) intersected.material).emissive.setHex(0xff0000);
                INTERSECTED = intersected;
            }
        } else {
            if (INTERSECTED != null) {
                ((MeshLambertMaterial) INTERSECTED.material).emissive.setHex(INTERSECTED.userData.getProperty("currentHex"));
                INTERSECTED = null;
            }
        }
        renderer.render(scene, camera);
    }
}

