package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/17/18.
 */
public class WebglBuffergeometry extends Attachable {

    public static final String name = "buffergeometry";
    private Random random = new Random();

    public WebglBuffergeometry() {

        camera = new PerspectiveCamera(27, aspect, 1, 3500);
        camera.position.z = 2750;
        scene = new Scene();
        scene.background = new Color(0x050505);
        scene.fog = new Fog(0x050505, 2000, 3500);
        //
        scene.add(new AmbientLight(0x444444));
        DirectionalLight light1 = new DirectionalLight(0xffffff, 0.5f);
        light1.position.set(1, 1, 1);
        scene.add(light1);
        DirectionalLight light2 = new DirectionalLight(0xffffff, 1.5f);
        light2.position.set(0, -1, 0);
        scene.add(light2);
        //
        //int triangles = 160000;
        int triangles = 160000;
        BufferGeometry geometry = new BufferGeometry();
        JsArray<Float> positions = new JsArray();
        JsArray<Float> normals = new JsArray();
        JsArray<Float> colors = new JsArray();
        Color color = new Color();
        int n = 800, n2 = n / 2;    // triangles spread in the cube
        int d = 12, d2 = d / 2;    // individual triangle size
        Vector3 pA = new Vector3();
        Vector3 pB = new Vector3();
        Vector3 pC = new Vector3();
        Vector3 cb = new Vector3();
        Vector3 ab = new Vector3();
        for (int i = 0; i < triangles; i++) {
            // positions
            float x = random.nextFloat() * n - n2;
            float y = random.nextFloat() * n - n2;
            float z = random.nextFloat() * n - n2;
            float ax = x + random.nextFloat() * d - d2;
            float ay = y + random.nextFloat() * d - d2;
            float az = z + random.nextFloat() * d - d2;
            float bx = x + random.nextFloat() * d - d2;
            float by = y + random.nextFloat() * d - d2;
            float bz = z + random.nextFloat() * d - d2;
            float cx = x + random.nextFloat() * d - d2;
            float cy = y + random.nextFloat() * d - d2;
            float cz = z + random.nextFloat() * d - d2;

            positions.push(ax, ay, az);
            positions.push(bx, by, bz);
            positions.push(cx, cy, cz);
            // flat face normals
            pA.set(ax, ay, az);
            pB.set(bx, by, bz);
            pC.set(cx, cy, cz);
            cb.subVectors(pC, pB);
            ab.subVectors(pA, pB);
            cb.cross(ab);
            cb.normalize();
            float nx = cb.x;
            float ny = cb.y;
            float nz = cb.z;
            normals.push(nx, ny, nz);
            normals.push(nx, ny, nz);
            normals.push(nx, ny, nz);
            // colors
            float vx = (x / n) + 0.5f;
            float vy = (y / n) + 0.5f;
            float vz = (z / n) + 0.5f;
            color.setRGB(vx, vy, vz);
            colors.push(color.r, color.g, color.b);
            colors.push(color.r, color.g, color.b);
            colors.push(color.r, color.g, color.b);

        }

        float[] _p = new float[positions.length];
        for (int i = 0; i < positions.length; i++) {
            _p[i] = positions.getAt(i);
        }
        float[] _n = new float[normals.length];
        for (int i = 0; i < normals.length; i++) {
            _n[i] = normals.getAt(i);
        }
        float[] _c = new float[colors.length];
        for (int i = 0; i < colors.length; i++) {
            _c[i] = colors.getAt(i);
        }

        geometry.addAttribute("position", new Float32BufferAttribute(_p, 3));
        geometry.addAttribute("normal", new Float32BufferAttribute(_n, 3));
        geometry.addAttribute("color", new Float32BufferAttribute(_c, 3));

        //geometry.addAttribute("normal", new Float32BufferAttribute(Js.uncheckedCast(normals), 3));//.onUpload(() -> geometry.removeAttribute("normal")));
        //geometry.addAttribute("color", new Float32BufferAttribute(Js.uncheckedCast(colors), 3));//.onUpload(() -> geometry.removeAttribute("color")));
        geometry.computeBoundingSphere();

        MeshPhongMaterial meshPhongMaterial = new MeshPhongMaterial();
        meshPhongMaterial.color = new Color(0xaaaaaa);
        meshPhongMaterial.specular = new Color(0xffffff);
        meshPhongMaterial.shininess = 250;
        meshPhongMaterial.side = THREE.DoubleSide;
        meshPhongMaterial.vertexColors = THREE.VertexColors;
        mesh = new Mesh(geometry, meshPhongMaterial);
        scene.add(mesh);


        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
        renderer.gammaOutput = true;
        renderer.gammaInput = true;

    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" -  webgl - buffergeometry");
    }

    private void animate() {
        //StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        double time = new Date().getTime() * 0.001;
        mesh.rotation.x = (float) time * 0.25f;
        mesh.rotation.y = (float) time * 0.5f;
        renderer.render(scene, camera);
    }
}