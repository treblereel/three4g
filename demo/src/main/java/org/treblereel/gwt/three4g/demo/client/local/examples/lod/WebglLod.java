package org.treblereel.gwt.three4g.demo.client.local.examples.lod;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.TraverseCallback;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.FlyControls;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LOD;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/25/18.
 */
@InjectJavaScriptFor(elements = FlyControls.class)
public class WebglLod extends Attachable {

    public static final String name = "lod";
    private Random rand = new Random();

    private Clock clock = new Clock();

    public WebglLod() {

        camera = new PerspectiveCamera(45, aspect, 1, 15000);
        camera.position.z = 1000;

        flyControls = new FlyControls(camera);
        flyControls.movementSpeed = 1000;
        flyControls.rollSpeed = (float) Math.PI / 10;

        scene = new Scene();
        scene.fog = new Fog(0x000000, 1, 15000);
        scene.autoUpdate = false;

        PointLight light = new PointLight(0xff2200);
        light.position.set(0, 0, 0);
        scene.add(light);

        light = new PointLight(0xffffff);
        light.position.set(0, 0, 1).normalize();
        scene.add(light);

        Map<IcosahedronBufferGeometry, Integer> map = new HashMap<IcosahedronBufferGeometry, Integer>() {{
            put(new IcosahedronBufferGeometry(100, 4), 50);
            put(new IcosahedronBufferGeometry(100, 3), 300);
            put(new IcosahedronBufferGeometry(100, 2), 1000);
            put(new IcosahedronBufferGeometry(100, 1), 2000);
            put(new IcosahedronBufferGeometry(100, 0), 8000);
        }};


        MeshLambertMaterial material = new MeshLambertMaterial();
        material.color = new Color(0xffffff);
        material.wireframe = true;

        for (int j = 0; j < 1000; j++) {
            LOD lod = new LOD();

            map.forEach((k, v) -> {
                Mesh mesh = new Mesh(k, material);
                mesh.scale.set(1.5f, 1.5f, 1.5f);
                mesh.updateMatrix();
                mesh.matrixAutoUpdate = false;
                lod.addLevel(mesh, v);
            });

            lod.position.x = 10000 * (0.5f - rand.nextFloat());
            lod.position.y = 7500 * (0.5f - rand.nextFloat());
            lod.position.z = 10000 * (0.5f - rand.nextFloat());
            lod.updateMatrix();
            lod.matrixAutoUpdate = false;
            scene.add(lod);


        }

        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.antialias = true;
        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        //
        container.appendChild(renderer.domElement);

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - level-of-details WebGL example");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                flyControls.update(clock.getDelta());
                scene.updateMatrixWorld();
                scene.traverse(new TraverseCallback() {
                    @Override
                    public void onEvent(Object3D object) {
                        if (object instanceof LOD) {
                            ((LOD) object).update(camera);
                        }
                    }
                });
                renderer.render(scene, camera);
                animate();
            }
        });
    }

}
