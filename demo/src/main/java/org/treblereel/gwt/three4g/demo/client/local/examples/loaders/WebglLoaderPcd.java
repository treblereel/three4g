package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.Event;
import elemental2.dom.KeyboardEvent;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extensions.loaders.PCDLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/10/18.
 */
@InjectJavaScriptFor(elements = {TrackballControls.class, PCDLoader.class})
public class WebglLoaderPcd extends Attachable {

    public static final String name = "loader / pcd";

    public WebglLoaderPcd() {

        scene = new Scene();
        scene.background = new Color(0x000000);
        camera = new PerspectiveCamera(15, aspect, 0.01f, 40);
        camera.position.x = 0.4f;
        camera.position.z = -2;
        camera.up.set(0, 0, 1);

        trackballControls = new TrackballControls(camera);
        trackballControls.rotateSpeed = 2.0f;
        trackballControls.zoomSpeed = 0.3f;
        trackballControls.panSpeed = 0.2f;
        trackballControls.noZoom = false;
        trackballControls.noPan = false;
        trackballControls.staticMoving = true;
        trackballControls.dynamicDampingFactor = 0.3f;
        trackballControls.minDistance = 0.3f;
        trackballControls.maxDistance = 0.3f * 100f;
        scene.add(camera);

        PCDLoader loader = new PCDLoader();
        loader.load("./models/pcd/binary/Zaghetto.pcd", new OnLoadCallback<Object3D>() {


            @Override
            public void onLoad(Object3D object) {
                BufferGeometry bufferGeometry = object.getProperty("geometry");

                Vector3 center = bufferGeometry.boundingSphere.center;
                scene.add(object);
                trackballControls.target.set(center.x, center.y, center.z);
                trackballControls.update();
            }
        });

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        renderer.shadowMap.enabled = true;

        container.appendChild(renderer.domElement);
        document.addEventListener("keydown", evt -> onKeyDown(evt), false);

    }

    private void onKeyDown(Event evt) {
        if (evt instanceof KeyboardEvent) {
            KeyboardEvent ev = (KeyboardEvent) evt;
            Object3D zaghettoMesh = scene.getObjectByName("Zaghetto.pcd");
            PointsMaterial material = zaghettoMesh.getProperty("material");
            switch (ev.code) {
                case "Equal":
                    material.size *= 1.2;
                    material.needsUpdate = true;
                    break;
                case "Minus":
                    material.size /= 1.2;
                    material.needsUpdate = true;
                    break;
                case "KeyC":
                    material.color.setHex(new Random().nextInt() * 0xffffff);
                    material.needsUpdate = true;
                    break;
            }
        }
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("<a href=\"http://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a>\n" +
                "\t\t\t<a href=\"http://pointclouds.org/documentation/tutorials/pcd_file_format.php#pcd-file-format\" target=\"_blank\" rel=\"noopener\">PCD File format</a>\n" +
                "\t\t\t<div>PCD loader test by <a href=\"http://filipecaixeta.com.br\" target=\"_blank\" rel=\"noopener\">Filipe Caixeta</a></div>\n" +
                "\t\t\t<div>+/-: Increase/Decrease point size</div>\n" +
                "\t\t\t<div>c: Toggle color</div>");
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                trackballControls.update();
                renderer.render(scene, camera);
            }
            animate();
        });
    }

}
