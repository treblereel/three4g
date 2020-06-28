package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import java.util.Date;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/26/18.
 */
public class WebglGeometryHierarchy2 extends Attachable {

    public static final String name = "geometry / hierarchy2";
    private Mesh r;
    private Vector2 mouse = new Vector2();
    private double windowHalfX = window.innerWidth / 2;
    private double windowHalfY = window.innerHeight / 2;

    private EventListener onDocumentMouseMove;


    public WebglGeometryHierarchy2() {
        onDocumentMouseMove = evt -> onDocumentMouseMove(Js.uncheckedCast(evt));

        camera = new PerspectiveCamera(60, aspect, 1, 15000);
        camera.position.z = 500;
        scene = new Scene();
        scene.background = new Color(0xffffff);
        BoxBufferGeometry geometry = new BoxBufferGeometry(100, 100, 100);
        MeshNormalMaterial material = new MeshNormalMaterial();
        r = new Mesh(geometry, material);
        r.position.x = 1000;
        scene.add(r);
        int amount = 200;
        Mesh object, parent = r;
        for (int i = 0; i < amount; i++) {
            object = new Mesh(geometry, material);
            object.position.x = 100;
            parent.add(object);
            parent = object;
        }
        parent = r;
        for (int i = 0; i < amount; i++) {
            object = new Mesh(geometry, material);
            object.position.x = -100;
            parent.add(object);
            parent = object;
        }
        parent = r;
        for (int i = 0; i < amount; i++) {
            object = new Mesh(geometry, material);
            object.position.y = -100;
            parent.add(object);
            parent = object;
        }
        parent = r;
        for (int i = 0; i < amount; i++) {
            object = new Mesh(geometry, material);
            object.position.y = 100;
            parent.add(object);
            parent = object;
        }
        parent = r;
        for (int i = 0; i < amount; i++) {
            object = new Mesh(geometry, material);
            object.position.z = -100;
            parent.add(object);
            parent = object;
        }
        parent = r;
        for (int i = 0; i < amount; i++) {
            object = new Mesh(geometry, material);
            object.position.z = 100;
            parent.add(object);
            parent = object;
        }


        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);

        document.addEventListener("mousemove", onDocumentMouseMove, false);

    }

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float) (event.clientX - windowHalfX) * 10;
        mouse.y = (float) (event.clientY - windowHalfY) * 10;
    }

    @Override
    public void onWindowResize() {
        if (root.parentNode != null && camera != null) {
            super.onWindowResize();
            windowHalfX = getWidth() / 2;
            windowHalfY = getHeight() / 2;
        }
    }


    @Override
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
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                render();
                animate();
            }
        });
    }

    private void render() {
        double time = new Date().getTime() * 0.0001;
        float rx = (float) Math.sin(time * 0.7) * 0.2f,
                ry = (float) Math.sin(time * 0.3) * 0.1f,
                rz = (float) Math.sin(time * 0.2) * 0.1f;
        camera.position.x += (mouse.x - camera.position.x) * 0.05;
        camera.position.y += (-mouse.y - camera.position.y) * 0.05;
        camera.lookAt(scene.position);
        r.traverse(object -> {
            object.rotation.x = rx;
            object.rotation.y = ry;
            object.rotation.z = rz;
        });
        renderer.render(scene, camera);
    }

}

