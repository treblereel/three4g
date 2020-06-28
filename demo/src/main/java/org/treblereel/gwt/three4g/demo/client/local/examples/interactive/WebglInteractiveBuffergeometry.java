package org.treblereel.gwt.three4g.demo.client.local.examples.interactive;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import java.util.Date;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Face3;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/8/18.
 */
public class WebglInteractiveBuffergeometry extends Attachable {

    public final static String name = "interactive / buffergeometry";
    private HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");

    private Random rand = new Random();
    private Raycaster raycaster;
    private Vector2 mouse;
    private Mesh mesh;
    private Line line;

    public WebglInteractiveBuffergeometry() {
        //
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
        int triangles = 5000;
        BufferGeometry geometry = new BufferGeometry();
        Float32Array positions = new Float32Array(triangles * 3 * 3);
        Float32Array normals = new Float32Array(triangles * 3 * 3);
        Float32Array colors = new Float32Array(triangles * 3 * 3);
        Color color = new Color();
        float n = 800, n2 = n / 2;  // triangles spread in the cube
        float d = 120, d2 = d / 2;  // individual triangle size
        Vector3 pA = new Vector3();
        Vector3 pB = new Vector3();
        Vector3 pC = new Vector3();
        Vector3 cb = new Vector3();
        Vector3 ab = new Vector3();
        for (int i = 0; i < positions.length; i += 9) {
            // positions
            float x = rand.nextFloat() * n - n2;
            float y = rand.nextFloat() * n - n2;
            float z = rand.nextFloat() * n - n2;
            float ax = x + rand.nextFloat() * d - d2;
            float ay = y + rand.nextFloat() * d - d2;
            float az = z + rand.nextFloat() * d - d2;
            float bx = x + rand.nextFloat() * d - d2;
            float by = y + rand.nextFloat() * d - d2;
            float bz = z + rand.nextFloat() * d - d2;
            float cx = x + rand.nextFloat() * d - d2;
            float cy = y + rand.nextFloat() * d - d2;
            float cz = z + rand.nextFloat() * d - d2;

            positions.setAt(i, (double) ax);
            positions.setAt(i + 1, (double) ay);
            positions.setAt(i + 2, (double) az);
            positions.setAt(i + 3, (double) bx);
            positions.setAt(i + 4, (double) by);
            positions.setAt(i + 5, (double) bz);
            positions.setAt(i + 6, (double) cx);
            positions.setAt(i + 7, (double) cy);
            positions.setAt(i + 8, (double) cz);

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
            normals.setAt(i, (double) nx);
            normals.setAt(i + 1, (double) ny);
            normals.setAt(i + 2, (double) nz);
            normals.setAt(i + 3, (double) nx);
            normals.setAt(i + 4, (double) ny);
            normals.setAt(i + 5, (double) nz);
            normals.setAt(i + 6, (double) nx);
            normals.setAt(i + 7, (double) ny);
            normals.setAt(i + 8, (double) nz);

            // colors
            float vx = (x / n) + 0.5f;
            float vy = (y / n) + 0.5f;
            float vz = (z / n) + 0.5f;
            color.setRGB(vx, vy, vz);

            colors.setAt(i, (double) color.r);
            colors.setAt(i + 1, (double) color.g);
            colors.setAt(i + 2, (double) color.b);
            colors.setAt(i + 3, (double) color.r);
            colors.setAt(i + 4, (double) color.g);
            colors.setAt(i + 5, (double) color.b);
            colors.setAt(i + 6, (double) color.r);
            colors.setAt(i + 7, (double) color.g);
            colors.setAt(i + 8, (double) color.b);

        }
        geometry.addAttribute("position", new BufferAttribute(positions, 3));
        geometry.addAttribute("normal", new BufferAttribute(normals, 3));
        geometry.addAttribute("color", new BufferAttribute(colors, 3));
        geometry.computeBoundingSphere();

        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0xaaaaaa);
        material.specular = new Color(0xffffff);
        material.shininess = 250f;
        material.side = THREE.DoubleSide;
        material.vertexColors = THREE.VertexColors;


        mesh = new Mesh(geometry, material);
        scene.add(mesh);
        //
        raycaster = new Raycaster();
        mouse = new Vector2();

        geometry = new BufferGeometry();
        geometry.addAttribute("position", new BufferAttribute(new Float32Array(4 * 3), 3));

        LineBasicMaterial lineBasicMaterial = new LineBasicMaterial();
        lineBasicMaterial.color = new Color(0xffffff);
        lineBasicMaterial.linewidth = 2;
        lineBasicMaterial.transparent = true;


        line = new Line(geometry, lineBasicMaterial);
        scene.add(line);
        //
        renderer = new WebGLRenderer();

        container.appendChild(renderer.domElement);

        raycaster = new Raycaster();
        mouse = new Vector2();
        //
        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
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

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float) (((event.clientX - panel.offsetWidth) / (window.innerWidth - panel.offsetWidth)) * 2 - 1);
        mouse.y = (float) (-(event.clientY / window.innerHeight) * 2 + 1);
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("webgl - interactive - buffergeometry");

    }


    private void render() {
        double time = new Date().getTime() * 0.001;

        mesh.rotation.x = (float) (time * 0.15);
        mesh.rotation.y = (float) (time * 0.25);
        raycaster.setFromCamera(mouse, camera);
        Intersect[] intersects = raycaster.intersectObject(mesh);
        if (intersects.length > 0) {
            Intersect intersect = intersects[0];
            Face3 face = intersect.face;

            BufferAttribute linePosition = ((BufferGeometry) line.geometry).attributes.position;
            BufferAttribute meshPosition = ((BufferGeometry) mesh.geometry).attributes.position;
            linePosition.copyAt(0, meshPosition, face.a);
            linePosition.copyAt(1, meshPosition, face.b);
            linePosition.copyAt(2, meshPosition, face.c);
            linePosition.copyAt(3, meshPosition, face.a);
            mesh.updateMatrix();
            line.geometry.applyMatrix(mesh.matrix);
            line.visible = true;
        } else {
            line.visible = false;
        }
        renderer.render(scene, camera);
    }
}
