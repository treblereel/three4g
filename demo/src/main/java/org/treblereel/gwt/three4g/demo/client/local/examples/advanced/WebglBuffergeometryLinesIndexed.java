package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import com.google.gwt.core.client.GWT;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import java.util.Date;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.LineSegments;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
public class WebglBuffergeometryLinesIndexed extends Attachable {

    public static final String name = "buffergeometry / lines / indexed";
    private LineSegments mesh;
    private Object3D parent_node;
    private int next_positions_index = 0;
    private int iteration_count = 4;
    private JsArray indices = new JsArray();
    private JsArray positions = new JsArray();
    private JsArray colors = new JsArray();
    private double rangle = 60 * Math.PI / 180.0;


    public WebglBuffergeometryLinesIndexed() {

        camera = new PerspectiveCamera(27, aspect, 1, 10000);
        camera.position.z = 9000;

        scene = new Scene();
        BufferGeometry geometry = new BufferGeometry();
        LineBasicMaterial material = new LineBasicMaterial();
        material.vertexColors = THREE.VertexColors;
        //
        int y = 0;
        snowflake(new Vector3[]{new Vector3(0, y, 0), new Vector3(500, y, 0)}, false, 600);
        y += 600;
        snowflake(new Vector3[]{new Vector3(0, y, 0), new Vector3(250, y + 400, 0), new Vector3(500, y, 0)}, true, 600);
        y += 600;
        snowflake(new Vector3[]{new Vector3(0, y, 0), new Vector3(500, y, 0), new Vector3(500, y + 500, 0), new Vector3(0, y + 500, 0)}, true, 600);
        y += 1000;
        snowflake(new Vector3[]{new Vector3(250, y, 0),
                new Vector3(500, y, 0),
                new Vector3(250, y, 0),
                new Vector3(250, y + 250, 0),
                new Vector3(250, y, 0),
                new Vector3(0, y, 0),
                new Vector3(250, y, 0),
                new Vector3(250, y - 250, 0),
                new Vector3(250, y, 0)
        }, false, 600);
        //
        geometry.setIndex(indices);
        geometry.addAttribute("position", new Float32BufferAttribute(positions, 3));
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        geometry.computeBoundingSphere();
        mesh = new LineSegments(geometry, material);
        mesh.position.x -= 1200;
        mesh.position.y -= 1200;
        parent_node = new Object3D();
        parent_node.add(mesh);
        scene.add(parent_node);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
    }

    public int add_vertex(Vector3 v) {
        if (next_positions_index == 0xffff) GWT.log("Too many points.");
        positions.push(v.x, v.y, v.z);
        colors.push(Math.random() * 0.5 + 0.5, Math.random() * 0.5 + 0.5, 1);
        return next_positions_index++;
    }

    public void snowflake_iteration(Vector3 p0, Vector3 p4, int depth) {
        if (--depth < 0) {
            int i = next_positions_index - 1; // p0 already there
            add_vertex(p4);
            indices.push(i, i + 1);
            return;
        }
        Vector3 v = p4.clone().sub(p0);
        Vector3 v_tier = v.clone().multiplyScalar(1 / 3);
        Vector3 p1 = p0.clone().add(v_tier);
        double angle = Math.atan2(v.y, v.x) + rangle;
        float length = v_tier.length();
        Vector3 p2 = p1.clone();
        p2.x += Math.cos(angle) * length;
        p2.y += Math.sin(angle) * length;
        Vector3 p3 = p0.clone().add(v_tier).add(v_tier);

        snowflake_iteration(p0, p1, depth);
        snowflake_iteration(p1, p2, depth);
        snowflake_iteration(p2, p3, depth);
        snowflake_iteration(p3, p4, depth);
    }

    public void snowflake(Vector3[] points, boolean loop, int x_offset) {
        for (int iteration = 0; iteration != iteration_count; iteration++) {
            add_vertex(points[0]);
            for (int p_index = 0, p_count = points.length - 1; p_index != p_count; p_index++) {
                snowflake_iteration(points[p_index], points[p_index + 1], iteration);
            }
            if (loop) snowflake_iteration(points[points.length - 1], points[0], iteration);
            // translate input curve for next iteration
            for (int p_index = 0, p_count = points.length; p_index != p_count; p_index++) {
                points[p_index].x += x_offset;
            }
        }
    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("webgl - buffergeometry - lines - indexed");
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
        parent_node.rotation.z = time * 0.5f;
        renderer.render(scene, camera);
    }

}