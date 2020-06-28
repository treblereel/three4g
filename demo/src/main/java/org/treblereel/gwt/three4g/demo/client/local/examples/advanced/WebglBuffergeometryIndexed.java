package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import java.util.Date;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/21/18.
 */
public class WebglBuffergeometryIndexed extends Attachable {

    public static final String name = "buffergeometry / indexed";

    public WebglBuffergeometryIndexed() {

        camera = new PerspectiveCamera(27, aspect, 1, 3500);
        camera.position.z = 64;
        scene = new Scene();
        scene.background = new Color(0x050505);
        //
        AmbientLight ambientLight = new AmbientLight(0x222222);
        scene.add(ambientLight);
        DirectionalLight light1 = new DirectionalLight(0xffffff, 0.5f);
        light1.position.set(1, 1, 1);
        scene.add(light1);
        DirectionalLight light2 = new DirectionalLight(0xffffff, 1);
        light2.position.set(0, -1, 0);
        scene.add(light2);
        //
        BufferGeometry geometry = new BufferGeometry();
        JsArray indices = new JsArray();
        JsArray vertices = new JsArray();
        JsArray normals = new JsArray();
        JsArray colors = new JsArray();

        int size = 20;
        int segments = 10;
        int halfSize = size / 2;
        int segmentSize = size / segments;
        // generate vertices, normals and color data for a simple grid geometry
        for (int i = 0; i <= segments; i++) {
            int y = (i * segmentSize) - halfSize;
            for (int j = 0; j <= segments; j++) {
                int x = (j * segmentSize) - halfSize;
                vertices.push(x, -y, 0);
                normals.push(0, 0, 1);
                float r = (x / size) + 0.5f;
                float g = (y / size) + 0.5f;
                colors.push(r, g, 1);
            }
        }
        // generate indices (data for element array buffer)
        for (int i = 0; i < segments; i++) {
            for (int j = 0; j < segments; j++) {
                int a = i * (segments + 1) + (j + 1);
                int b = i * (segments + 1) + j;
                int c = (i + 1) * (segments + 1) + j;
                int d = (i + 1) * (segments + 1) + (j + 1);
                // generate two faces (triangles) per iteration
                indices.push(a, b, d); // face one
                indices.push(b, c, d); // face two
            }
        }
        //
        geometry.setIndex(indices);
        geometry.addAttribute("position", new Float32BufferAttribute(vertices, 3));
        geometry.addAttribute("normal", new Float32BufferAttribute(normals, 3));
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));

        MeshPhongMaterialParameters meshPhongMaterialParameters = new MeshPhongMaterialParameters();
        meshPhongMaterialParameters.specular = new Color(0x111111);
        meshPhongMaterialParameters.shininess = 250;
        meshPhongMaterialParameters.side = THREE.DoubleSide;
        meshPhongMaterialParameters.vertexColors = THREE.VertexColors;

        MeshPhongMaterial material = new MeshPhongMaterial(meshPhongMaterialParameters);
        mesh = new Mesh(geometry, material);
        scene.add(mesh);

        WebGLRendererParameters parameters1 = new WebGLRendererParameters();
        parameters1.antialias = true;
        renderer = new WebGLRenderer(parameters1);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);
        gui.add("wireframe", false).onChange(result -> material.wireframe = result);

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" webgl - buffergeometry - indexed");
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
        float time = new Date().getTime() * 0.001f;
        mesh.rotation.x = time * 0.25f;
        mesh.rotation.y = time * 0.5f;
        renderer.render(scene, camera);
    }
}