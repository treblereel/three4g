package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import java.util.Date;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
public class WebglBuffergeometryLines extends Attachable {

    public static final String name = "buffergeometry / lines";
    private Line line;

    public WebglBuffergeometryLines() {

        camera = new PerspectiveCamera(27, aspect, 1, 4000);
        camera.position.z = 2750;
        scene = new Scene();
        int segments = 10000;
        BufferGeometry geometry = new BufferGeometry();
        LineBasicMaterial material = new LineBasicMaterial();
        material.vertexColors = THREE.VertexColors;
        JsArray positions = new JsArray();
        JsArray colors = new JsArray();
        int r = 800;
        for (int i = 0; i < segments; i++) {
            double x = Math.random() * r - r / 2;
            double y = Math.random() * r - r / 2;
            double z = Math.random() * r - r / 2;
            // positions
            positions.push(x, y, z);
            // colors
            colors.push((x / r) + 0.5);
            colors.push((y / r) + 0.5);
            colors.push((z / r) + 0.5);
        }
        geometry.addAttribute("position", new Float32BufferAttribute(positions, 3));
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        geometry.computeBoundingSphere();
        line = new Line(geometry, material);
        scene.add(line);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
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
        line.rotation.x = time * 0.25f;
        line.rotation.y = time * 0.5f;
        renderer.render(scene, camera);
    }
}