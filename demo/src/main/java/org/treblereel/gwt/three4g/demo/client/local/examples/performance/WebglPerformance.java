package org.treblereel.gwt.three4g.demo.client.local.examples.performance;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.loaders.BufferGeometryLoader;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/10/18.
 */
public class WebglPerformance extends Attachable {

    public static final String name = "performance";
    private Vector2 mouse = new Vector2();
    private int windowHalfX = window.innerWidth / 2;
    private int windowHalfY = window.innerHeight / 2;
    private List<Mesh> objects = new ArrayList<>();


    public WebglPerformance() {

        camera = new PerspectiveCamera(60, aspect, 1, 10000);
        camera.position.z = 3200;
        scene = new Scene();
        scene.background = new Color(0xffffff);
        MeshNormalMaterial material = new MeshNormalMaterial();
        BufferGeometryLoader loader = new BufferGeometryLoader();
        loader.load("json/suzanne_buffergeometry.json", geometry -> {
            geometry.computeVertexNormals();
            for (int i = 0; i < 5000; i++) {
                Mesh mesh = new Mesh(geometry, material);
                mesh.position.x = (float) Math.random() * 8000 - 4000;
                mesh.position.y = (float) Math.random() * 8000 - 4000;
                mesh.position.z = (float) Math.random() * 8000 - 4000;
                mesh.rotation.x = (float) (Math.random() * 2 * Math.PI);
                mesh.rotation.y = (float) (Math.random() * 2 * Math.PI);
                mesh.scale.x = mesh.scale.y = mesh.scale.z = (float) Math.random() * 50 + 100;
                objects.add(mesh);
                scene.add(mesh);
            }
        });

        renderer = new WebGLRenderer();
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
    }

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float)( event.clientX - windowHalfX ) * 10;
        mouse.y = (float)( event.clientY - windowHalfY ) * 10;
    }

    @Override
    public void onWindowResize() {
        if (camera != null && renderer != null) {
            windowHalfX = window.innerWidth / 2;
            windowHalfY = window.innerHeight / 2;
            camera.aspect = aspect;
            camera.updateProjectionMatrix();
            renderer.setSize(window.innerWidth, window.innerHeight);
        }
    }

    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
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

        camera.position.x += ( mouse.x - camera.position.x ) * .05;
        camera.position.y += ( - mouse.y - camera.position.y ) * .05;
        camera.lookAt( scene.position );
        for ( int i = 0, il = objects.size(); i < il; i ++ ) {
            objects.get(i).rotation.x += 0.01;
            objects.get(i).rotation.y += 0.02;
        }
        renderer.render( scene, camera );
    }
}

