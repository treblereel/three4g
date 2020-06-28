package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CanvasGradient;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Face3;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.IcosahedronGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/12/18.
 */
public class WebglGeometryColors extends Attachable {

    public static final String name = "geometry / colors";
    private Vector2 mouse = new Vector2();


    public WebglGeometryColors() {

        camera = new PerspectiveCamera(20, aspect, 1, 10000);
        camera.position.z = 1800;
        scene = new Scene();
        scene.background = new Color(0xffffff);
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 0, 1);
        scene.add(light);
        // shadow
        HTMLCanvasElement canvas = (HTMLCanvasElement) document.createElement("canvas");
        canvas.width = 128;
        canvas.height = 128;

        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext("2d"));
        CanvasGradient gradient = context.createRadialGradient(canvas.width / 2, canvas.height / 2, 0, canvas.width / 2, canvas.height / 2, canvas.width / 2);

        gradient.addColorStop(0.1, "rgba(210,210,210,1)");
        gradient.addColorStop(1, "rgba(255,255,255,1)");
        context.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of(gradient);
        context.fillRect(0, 0, canvas.width, canvas.height);
        Texture shadowTexture = new Texture(canvas);
        shadowTexture.needsUpdate = true;
        MeshBasicMaterial shadowMaterial = new MeshBasicMaterial();
        shadowMaterial.map = shadowTexture;
        PlaneBufferGeometry shadowGeo = new PlaneBufferGeometry(300, 300, 1, 1);
        Mesh shadowMesh;
        shadowMesh = new Mesh(shadowGeo, shadowMaterial);
        shadowMesh.position.y = -250;
        shadowMesh.rotation.x = (float) -Math.PI / 2;
        scene.add(shadowMesh);
        shadowMesh = new Mesh(shadowGeo, shadowMaterial);
        shadowMesh.position.y = -250;
        shadowMesh.position.x = -400;
        shadowMesh.rotation.x = (float) -Math.PI / 2;
        scene.add(shadowMesh);
        shadowMesh = new Mesh(shadowGeo, shadowMaterial);
        shadowMesh.position.y = -250;
        shadowMesh.position.x = 400;
        shadowMesh.rotation.x = (float) -Math.PI / 2;
        scene.add(shadowMesh);

        String[] faceIndices = new String[]{"a", "b", "c"};
        Vector3 p;
        float radius = 200;
        Face3 f, f2, f3;
        Color color;
        int vertexIndex = -1;
        IcosahedronGeometry geometry = new IcosahedronGeometry(radius, 1),
                geometry2 = new IcosahedronGeometry(radius, 1),
                geometry3 = new IcosahedronGeometry(radius, 1);


        for (int i = 0; i < geometry.faces.length; i++) {
            f = geometry.faces.getAt(i);
            f2 = geometry2.faces.getAt(i);
            f3 = geometry3.faces.getAt(i);
            for (int j = 0; j < 3; j++) {
                if (faceIndices[j].equals("a")) {
                    vertexIndex = f.a;
                } else if (faceIndices[j].equals("b")) {
                    vertexIndex = f.b;
                } else if (faceIndices[j].equals("c")) {
                    vertexIndex = f.c;
                }
                p = geometry.vertices.getAt(vertexIndex);
                color = new Color(0xffffff);
                color.setHSL((p.y / radius + 1) / 2, 1.0f, 0.5f);
                f.vertexColors[j] = color;
                color = new Color(0xffffff);
                color.setHSL(0.0f, (p.y / radius + 1) / 2, 0.5f);
                f2.vertexColors[j] = color;
                color = new Color(0xffffff);
                color.setHSL(0.125f * vertexIndex / geometry.vertices.length, 1.0f, 0.5f);
                f3.vertexColors[j] = color;
            }
        }
        Mesh mesh, wireframe;
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0xffffff);
        material.flatShading = true;
        material.vertexColors = THREE.VertexColors;
        material.shininess = 0;


        MeshBasicMaterial wireframeMaterial = new MeshBasicMaterial();
        wireframeMaterial.color = new Color(0x000000);
        wireframeMaterial.wireframe = true;
        wireframeMaterial.transparent = true;

        mesh = new Mesh(geometry, material);
        wireframe = new Mesh(geometry, wireframeMaterial);
        mesh.add(wireframe);
        mesh.position.x = -400;
        mesh.rotation.x = -1.87f;
        scene.add(mesh);
        mesh = new Mesh(geometry2, material);
        wireframe = new Mesh(geometry2, wireframeMaterial);
        mesh.add(wireframe);
        mesh.position.x = 400;
        scene.add(mesh);
        mesh = new Mesh(geometry3, material);
        wireframe = new Mesh(geometry3, wireframeMaterial);
        mesh.add(wireframe);
        scene.add(mesh);

        document.addEventListener("mousemove", evt -> onDocumentMouseMove(Js.uncheckedCast(evt)), false);

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        setupWebGLRenderer(renderer);

    }

    double windowHalfX, windowHalfY;

    @Override
    public void onWindowResize() {
        super.onWindowResize();
        windowHalfX = getWidth() / 2;
        windowHalfY = getHeight() / 2;
    }


    public void onDocumentMouseMove(MouseEvent event) {
        mouse.x = (float) (event.clientX - windowHalfX);
        mouse.y = (float) (event.clientY - windowHalfY);
    }

    private void render() {
        camera.position.x += (mouse.x - camera.position.x) * 0.05;
        camera.position.y += (-mouse.y - camera.position.y) * 0.05;
        camera.lookAt(scene.position);
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  <a style=\"color:black;\">- webgl - vertex colors</a>");
    }
}

