package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import elemental2.core.ArrayBuffer;
import elemental2.core.Float32Array;
import elemental2.core.Uint8Array;
import elemental2.dom.DomGlobal;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.InterleavedBuffer;
import org.treblereel.gwt.three4g.core.InterleavedBufferAttribute;
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
public class WebglBuffergeometryPointsInterleaved extends Attachable {

    public static final String name = "buffergeometry / points / interleaved";
    private Random random = new Random();
    private Points points;

    public WebglBuffergeometryPointsInterleaved() {

        camera = new PerspectiveCamera(27, aspect, 5, 3500);
        camera.position.z = 2750;
        scene = new Scene();
        scene.background = new Color(0x050505);
        scene.fog = new Fog(0x050505, 2000, 3500);
        //
        int particles = 500000;
        BufferGeometry geometry = new BufferGeometry();
        // create a generic buffer of binary data (a single particle has 16 bytes of data)
        ArrayBuffer arrayBuffer = new ArrayBuffer(particles * 16);
        // the following typed arrays share the same buffer
        Float32Array interleavedFloat32Buffer = new Float32Array(arrayBuffer);
        Uint8Array interleavedUint8Buffer = new Uint8Array(arrayBuffer);
        //
        Color color = new Color();
        int n = 1000, n2 = n / 2; // particles spread in the cube
        for (int i = 0; i < interleavedFloat32Buffer.length; i += 4) {
            // position (first 12 bytes)
            double x = Math.random() * n - n2;
            double y = Math.random() * n - n2;
            double z = Math.random() * n - n2;
            interleavedFloat32Buffer.setAt(i, x);
            interleavedFloat32Buffer.setAt(i + 1, y);
            interleavedFloat32Buffer.setAt(i + 2, z);
            // color (last 4 bytes)
            float vx = (float) (x / n) + 0.5f;
            float vy = (float) (y / n) + 0.5f;
            float vz = (float) (z / n) + 0.5f;
            color.setRGB(vx, vy, vz);
            int j = (i + 3) * 4;
            interleavedUint8Buffer.setAt(j, (double) color.r * 255);
            interleavedUint8Buffer.setAt(j + 1, (double) color.g * 255);
            interleavedUint8Buffer.setAt(j + 2, (double) color.b * 255);
            interleavedUint8Buffer.setAt(j + 3, 0.0); // not needed
        }
        InterleavedBuffer interleavedBuffer32 = new InterleavedBuffer(interleavedFloat32Buffer, 4);
        InterleavedBuffer interleavedBuffer8 = new InterleavedBuffer(interleavedUint8Buffer, 16);
        geometry.addAttribute("position", new InterleavedBufferAttribute(interleavedBuffer32, 3, 0, false));
        geometry.addAttribute("color", new InterleavedBufferAttribute(interleavedBuffer8, 3, 12, true));
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("webgl - buffergeometry - particles");
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

