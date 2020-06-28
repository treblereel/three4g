package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.HashMap;
import java.util.Map;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.CircleBufferGeometry;
import org.treblereel.gwt.three4g.geometries.CylinderBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.OctahedronBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.RingBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotBufferGeometry;
import org.treblereel.gwt.three4g.helpers.VertexNormalsHelper;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/12/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglGeometryNormals extends Attachable {


    public static final String name = "geometry / normals";
    private Mesh mesh;
    private BufferGeometry geometry;
    private MeshBasicMaterial material;
    private String activeGeometry = "BoxBufferGeometry";
    private Map<String, BufferGeometry> geometries = new HashMap<>();

    public WebglGeometryNormals() {

        geometries.put("BoxBufferGeometry", new BoxBufferGeometry(200, 200, 200, 2, 2, 2));
        geometries.put("CircleBufferGeometry", new CircleBufferGeometry(200, 32));
        geometries.put("CylinderBufferGeometry", new CylinderBufferGeometry(75, 75, 200, 8, 8));
        geometries.put("IcosahedronBufferGeometry", new IcosahedronBufferGeometry(100, 1));
        geometries.put("OctahedronBufferGeometry", new OctahedronBufferGeometry(200, 0));
        geometries.put("PlaneBufferGeometry", new PlaneBufferGeometry(200, 200, 4, 4));
        geometries.put("RingBufferGeometry", new RingBufferGeometry(32, 64, 16));
        geometries.put("SphereBufferGeometry", new SphereBufferGeometry(100, 12, 12));
        geometries.put("TorusBufferGeometry", new TorusBufferGeometry(64, 16, 12, 12));
        geometries.put("TorusKnotBufferGeometry", new TorusKnotBufferGeometry(64, 16));

        camera = new PerspectiveCamera(70, aspect, 1, 1000);
        camera.position.z = 500;

        material = new MeshBasicMaterial();
        material.color = new Color(0xfefefe);
        material.wireframe = true;
        material.opacity = 0.5f;

        scene = new Scene();
        addMesh();

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        gui.add("enabled", geometries.keySet().toArray(new String[geometries.size()]), "BoxBufferGeometry").onChange(result -> {
            activeGeometry = result.toString();
            addMesh();
        }).done();


        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());


        //
        orbitControls = new OrbitControls(camera, root);

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
    }


    private void addMesh() {
        if (mesh != null) {
            scene.remove(mesh);
            geometry.dispose();
        }
        geometry = geometries.get(activeGeometry);
        // scale geometry to a uniform size
        geometry.computeBoundingSphere();
        float scaleFactor = 160 / geometry.boundingSphere.radius;
        geometry.scale(scaleFactor, scaleFactor, scaleFactor);
        mesh = new Mesh(geometry, material);
        scene.add(mesh);
        VertexNormalsHelper vertexNormalsHelper = new VertexNormalsHelper(mesh, 10);
        mesh.add(vertexNormalsHelper);
    }

    private void render() {
        renderer.render(scene, camera);
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

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - geometry - normals");
    }

}
