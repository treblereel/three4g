package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLElement;
import java.util.Date;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/1/18.
 */
public class WebglMaterialsGrass extends Attachable {

    public static final String name = "materials / grass";

    public WebglMaterialsGrass() {

        camera = new PerspectiveCamera(60, aspect, 1, 1000);
        camera.position.set(0, 75, 100);
        scene = new Scene();
        scene.background = new Color(0x003300);
        PlaneBufferGeometry geometry = new PlaneBufferGeometry(100, 100);
        CanvasTexture texture = new CanvasTexture(generateTexture());

        for (int i = 0; i < 15; i++) {
            MeshBasicMaterial material = new MeshBasicMaterial();
            material.color = new Color().setHSL(0.3f, 0.75f, (i / 15f) * 0.4f + 0.1f);
            material.map = texture;
            material.depthTest = false;
            material.depthWrite = false;
            material.transparent = true;

            Mesh mesh = new Mesh(geometry, material);
            mesh.position.y = i * 0.25f;
            mesh.rotation.x = (float) -Math.PI / 2;
            scene.add(mesh);
        }

        reverse(scene.children);

        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }

    public void reverse(Object3D[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object3D temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    private HTMLElement generateTexture() {

        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext("2d"));
        canvas.height = 512;
        canvas.width = 512;

        for (int i = 0; i < 20000; i++) {
            context.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("hsl(0,0%," + (Math.random() * 50 + 50) + "%)");
            context.beginPath();
            context.arc(Math.random() * canvas.width, Math.random() * canvas.height, Math.random() + 0.15, 0, Math.PI * 2, true);
            context.fill();
        }
        context.globalAlpha = 0.075;
        context.globalCompositeOperation = "lighter";
        return canvas;
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().hide();
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
        double time = new Date().getTime() * 0.0002;

        camera.position.x = (float) (80 * Math.cos(time));
        camera.position.z = (float) (80 * Math.sin(time));
        camera.lookAt(scene.position);
        for (int i = 0, l = scene.children.length; i < l; i++) {
            Object3D mesh = scene.children[i];
            mesh.position.x = (float) (Math.sin(time * 4) * i * i * 0.005f);
            mesh.position.z = (float) (Math.cos(time * 6) * i * i * 0.005f);
        }
        renderer.render(scene, camera);
    }

}

