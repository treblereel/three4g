package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
public class WebglBuffergeometryPoints extends Attachable {

    public static final String name = "buffergeometry / points";
    private Random random = new Random();
    private Points points;

    public WebglBuffergeometryPoints() {

        camera = new PerspectiveCamera(27, aspect, 5, 3500);
        camera.position.z = 2750;
        scene = new Scene();
        scene.background = new Color(0x050505);
        scene.fog = new Fog(0x050505, 2000, 3500);
        //
        int particles = 500000;
        BufferGeometry geometry = new BufferGeometry();
        JsArray positions = new JsArray();
        JsArray colors = new JsArray();
        Color color = new Color();
        int n = 1000, n2 = n / 2; // particles spread in the cube
        for (int i = 0; i < particles; i++) {
            // positions
            float x = random.nextFloat() * n - n2;
            float y = random.nextFloat() * n - n2;
            float z = random.nextFloat() * n - n2;
            positions.push(x, y, z);
            // colors
            float vx = (x / n) + 0.5f;
            float vy = (y / n) + 0.5f;
            float vz = (z / n) + 0.5f;
            color.setRGB(vx, vy, vz);
            colors.push(color.r, color.g, color.b);
        }
        geometry.addAttribute("position", new Float32BufferAttribute(positions, 3));
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        geometry.computeBoundingSphere();
        //
        PointsMaterial material = new PointsMaterial();
        material.size = 15;
        material.vertexColors = THREE.VertexColors;
        points = new Points(geometry, material);
        scene.add(points);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("webgl - buffergeometry - lines");
    }

    private void animate() {
        StatsProducer.getStats().update();
        DomGlobal.requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        float time = new Date().getTime() * 0.001f;
        points.rotation.x = time * 0.25f;
        points.rotation.y = time * 0.5f;
        renderer.render(scene, camera);
    }
}
