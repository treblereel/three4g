package org.treblereel.gwt.three4g.demo.client.local.examples.animation;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import java.util.Date;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.geometries.ParametricGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/22/18.
 */
public class WebglAnimationCloth extends Attachable {


    DirectionalLight light;
    ParametricGeometry clothGeometry;
    Material materials;
    Mesh sphere;


    public WebglAnimationCloth() {

        int[][] pinsFormation = new int[5][];
        int[] pins = new int[]{6};
        pinsFormation[0] = pins;
        pins = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        pinsFormation[1] = pins;
        pins = new int[]{0};
        pinsFormation[2] = pins;
        pins = new int[]{};
        pinsFormation[3] = pins;
        //   pins = [ 0, cloth.w ];
        pinsFormation[4] = pins;
        pins = pinsFormation[1];


        ScriptInjector.fromUrl("js/Cloth.js")
                .setWindow(ScriptInjector.TOP_WINDOW)
                .setCallback(new Callback<Void, Exception>() {
                    @Override
                    public void onFailure(Exception reason) {
                    }

                    @Override
                    public void onSuccess(Void result) {


                    }
                }).inject();


    }


    @Override
    protected void doAttachScene() {
        //document.body.appendChild(renderer.domElement);
        //onWindowResize();
        //animate();
    }

    @Override
    protected void doAttachInfo() {

    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (renderer.domElement != null) {
                double time = new Date().getTime();
                double windStrength = Math.cos(time / 7000) * 20 + 40;
/*
                Cloth.windForce.set((float) Math.sin(time / 2000), (float) Math.cos(time / 3000), (float) Math.sin(time / 1000));
                Cloth.windForce.normalize();
                Cloth.windForce.multiplyScalar((float) windStrength);
                Cloth.simulate(time);*/

                render();
                animate();
            }
        });
    }

    private void render() {
       /* Particle[] p = Cloth.cloth.particles;
        for (int i = 0, il = p.length; i < il; i++) {
            clothGeometry.vertices[i].copy(p[i].position);
        }
        clothGeometry.verticesNeedUpdate = true;
        clothGeometry.computeFaceNormals();
        clothGeometry.computeVertexNormals(true);
        sphere.position.copy(Cloth.ballPosition);*/

        renderer.render(scene, camera);
    }
}
