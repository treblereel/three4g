package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.core.bufferattributes.Int16BufferAttribute;
import org.treblereel.gwt.three4g.core.bufferattributes.Uint8BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
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
 * Created by treblereel on 8/22/18.
 */
public class WebglBuffergeometryUint extends Attachable {

    public static final String name = "buffergeometry / uint";
    private Random random = new Random();

    public WebglBuffergeometryUint() {

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
        int triangles = 500000;
        BufferGeometry geometry = new BufferGeometry();
        JsArray positions = new JsArray();
        JsArray normals = new JsArray();
        JsArray colors = new JsArray();
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
            normals.push(nx * 32767, ny * 32767, nz * 32767);
            normals.push(nx * 32767, ny * 32767, nz * 32767);
            normals.push(nx * 32767, ny * 32767, nz * 32767);
            // colors
            float vx = (x / n) + 0.5f;
            float vy = (y / n) + 0.5f;
            float vz = (z / n) + 0.5f;
            color.setRGB(vx, vy, vz);
            colors.push(color.r * 255, color.g * 255, color.b * 255);
            colors.push(color.r * 255, color.g * 255, color.b * 255);
            colors.push(color.r * 255, color.g * 255, color.b * 255);
        }
        Float32BufferAttribute positionAttribute = new Float32BufferAttribute(positions, 3);
        Int16BufferAttribute normalAttribute = new Int16BufferAttribute(normals, 3);
        Uint8BufferAttribute colorAttribute = new Uint8BufferAttribute(colors, 3);
        normalAttribute.normalized = true; // this will map the buffer values to 0.0f - +1.0f in the shader
        colorAttribute.normalized = true;
        geometry.addAttribute("position", positionAttribute);
        geometry.addAttribute("normal", normalAttribute);
        geometry.addAttribute("color", colorAttribute);
        geometry.computeBoundingSphere();
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0xaaaaaa);
        material.specular = new Color(0xffffff);
        material.shininess = 250;
        material.side = THREE.DoubleSide;
        material.vertexColors = THREE.VertexColors;
        mesh = new Mesh(geometry, material);
        scene.add(mesh);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        container.appendChild(renderer.domElement);
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" webgl - buffergeometry - uint");
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
        mesh.rotation.x = time * 0.25f;
        mesh.rotation.y = time * 0.5f;
        renderer.render(scene, camera);
    }

}

