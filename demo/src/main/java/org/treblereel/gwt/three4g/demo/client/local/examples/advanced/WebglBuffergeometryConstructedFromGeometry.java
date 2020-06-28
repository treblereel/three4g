package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.ExtrudeGeometryParameters;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Spherical;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/17/18.
 */
@InjectJavaScriptFor(elements = TrackballControls.class)
public class WebglBuffergeometryConstructedFromGeometry extends Attachable {

    public static final String name = "buffergeometry / constructed / from / geometry";

    public WebglBuffergeometryConstructedFromGeometry() {

        scene = new Scene();
        camera = new PerspectiveCamera(45, aspect, 100, 1500);
        camera.position.z = 480.0f;
        scene.add(new AmbientLight(0x444444));
        DirectionalLight light1 = new DirectionalLight(0x999999, 0.1f);
        light1.position.set(1, 1, 1);
        scene.add(light1);
        DirectionalLight light2 = new DirectionalLight(0x999999, 1.5f);
        light2.position.set(0, -1, 0);
        scene.add(light2);

        trackballControls = new TrackballControls(camera);
        trackballControls.minDistance = 100;
        trackballControls.maxDistance = 800;
        trackballControls.dynamicDampingFactor = 0.1f;

        createScene();

        WebGLRendererParameters parameters1 = new WebGLRendererParameters();
        parameters1.antialias = true;
        renderer = new WebGLRenderer(parameters1);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }

    private void createScene() {
        BufferGeometry bufferGeometry = new BufferGeometry();
        int radius = 125;
        double count = 80;
        JsArray<Float> positions = new JsArray<>();
        JsArray<Float> normals = new JsArray<>();
        JsArray<Float> colors = new JsArray<>();

        Spherical spherical = new Spherical();
        Vector3 vector = new Vector3();
        for (double i = 1, l = count; i <= l; i++) {
            double phi = Math.acos(-1 + (2 * i) / l);
            double theta = Math.sqrt(l * Math.PI) * phi;
            spherical.set(radius, (float) phi, (float) theta);
            vector.setFromSpherical(spherical);
            ExtrudeGeometry geometry = createGeometry();
            geometry.lookAt(vector);
            geometry.translate(vector.x, vector.y, vector.z);
            Color color = new Color(0xffffff);
            color.setHSL(((float) i / (float) l), 1.0f, 0.7f);

            geometry.faces.forEach((face, index, p2) -> {
                positions.push(geometry.vertices.getAt(face.a).x);
                positions.push(geometry.vertices.getAt(face.a).y);
                positions.push(geometry.vertices.getAt(face.a).z);
                positions.push(geometry.vertices.getAt(face.b).x);
                positions.push(geometry.vertices.getAt(face.b).y);
                positions.push(geometry.vertices.getAt(face.b).z);
                positions.push(geometry.vertices.getAt(face.c).x);
                positions.push(geometry.vertices.getAt(face.c).y);
                positions.push(geometry.vertices.getAt(face.c).z);
                normals.push(face.normal.x);
                normals.push(face.normal.y);
                normals.push(face.normal.z);
                normals.push(face.normal.x);
                normals.push(face.normal.y);
                normals.push(face.normal.z);
                normals.push(face.normal.x);
                normals.push(face.normal.y);
                normals.push(face.normal.z);
                colors.push(color.r);
                colors.push(color.g);
                colors.push(color.b);
                colors.push(color.r);
                colors.push(color.g);
                colors.push(color.b);
                colors.push(color.r);
                colors.push(color.g);
                colors.push(color.b);

                return null;
            });
        }

        float[] _positions = new float[positions.length];
        for (int i1 = 0; i1 < positions.length; i1++) {
            _positions[i1] = positions.getAt(i1);
        }

        float[] _normals = new float[normals.length];
        for (int i1 = 0; i1 < normals.length; i1++) {
            _normals[i1] = normals.getAt(i1);
        }

        float[] _colors = new float[colors.length];
        for (int i1 = 0; i1 < colors.length; i1++) {
            _colors[i1] = colors.getAt(i1);
        }


        bufferGeometry.addAttribute("position", new Float32BufferAttribute(_positions, 3));
        bufferGeometry.addAttribute("normal", new Float32BufferAttribute(_normals, 3));
        bufferGeometry.addAttribute("color", new Float32BufferAttribute(_colors, 3));

        MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
        parameters.shininess = 80;
        parameters.vertexColors = THREE.VertexColors;

        Mesh mesh = new Mesh(bufferGeometry, new MeshPhongMaterial(parameters));
        scene.add(mesh);


    }

    private ExtrudeGeometry createGeometry() {
        Shape heartShape = new Shape(); // From http://blog.burlock.org/html5/130-paths
        int x = 0, y = 0;
        heartShape.moveTo(x + 25, y + 25);
        heartShape.bezierCurveTo(x + 25, y + 25, x + 20, y, x, y);
        heartShape.bezierCurveTo(x - 30, y, x - 30, y + 35, x - 30, y + 35);
        heartShape.bezierCurveTo(x - 30, y + 55, x - 10, y + 77, x + 25, y + 95);
        heartShape.bezierCurveTo(x + 60, y + 77, x + 80, y + 55, x + 80, y + 35);
        heartShape.bezierCurveTo(x + 80, y + 35, x + 80, y, x + 50, y);
        heartShape.bezierCurveTo(x + 35, y, x + 25, y + 25, x + 25, y + 25);

        ExtrudeGeometryParameters extrudeGeometryParameters = new ExtrudeGeometryParameters();
        extrudeGeometryParameters.depth = 16;
        extrudeGeometryParameters.bevelEnabled = true;
        extrudeGeometryParameters.bevelSegments = 1;
        extrudeGeometryParameters.steps = 2;
        extrudeGeometryParameters.bevelSize = 1;
        extrudeGeometryParameters.bevelThickness = 1;


        ExtrudeGeometry geometry = new ExtrudeGeometry(heartShape, extrudeGeometryParameters);
        geometry.rotateX((float) Math.PI);
        geometry.scale(0.4f, 0.4f, 0.4f);
        return geometry;
    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" webgl - buffer geometry constructed from geometry - (<a style='color:orange;' target=\"_blank\" href=\"http://callum.com\">author</a>)");
    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        trackballControls.update();
        renderer.render(scene, camera);
    }
}