package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.MouseEvent;
import java.util.Date;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.PLYLoader;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/31/18.
 */
@InjectJavaScriptFor(elements = PLYLoader.class)
public class WebglMaterialsCubemapRefraction extends Attachable {

    public static final String name = "materials / cubemap / refraction";
    private Vector2 mouse = new Vector2();
    private PointLight pointLight;

    public WebglMaterialsCubemapRefraction() {

        camera = new PerspectiveCamera(50, aspect, 1, 100000);
        camera.position.z = -4000;
        //
        String r = "textures/cube/Park3Med/";
        String[] urls = new String[]{
                r + "px.jpg", r + "nx.jpg",
                r + "py.jpg", r + "ny.jpg",
                r + "pz.jpg", r + "nz.jpg"
        };
        CubeTexture textureCube = new CubeTextureLoader().load(urls);
        textureCube.mapping = THREE.CubeRefractionMapping;
        scene = new Scene();
        scene.background = textureCube;
        // LIGHTS
        AmbientLight ambient = new AmbientLight(0xffffff);
        scene.add(ambient);
        pointLight = new PointLight(0xffffff, 2);
        scene.add(pointLight);
        // light representation
        SphereBufferGeometry sphere = new SphereBufferGeometry(100, 16, 8);
        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(0xffffff);
        Mesh mesh = new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters));

        mesh.scale.set(0.05f, 0.05f, 0.05f);
        pointLight.add(mesh);
        // material samples
        MeshPhongMaterial cubeMaterial3 = new MeshPhongMaterial();
        cubeMaterial3.color = new Color(0xccddff);
        cubeMaterial3.envMap = textureCube;
        cubeMaterial3.refractionRatio = 0.98f;
        cubeMaterial3.reflectivity = 0.9f;


        MeshPhongMaterial cubeMaterial2 = new MeshPhongMaterial();
        cubeMaterial2.color = new Color(0xccfffd);
        cubeMaterial2.envMap = textureCube;
        cubeMaterial2.refractionRatio = 0.985f;

        MeshPhongMaterial cubeMaterial1 = new MeshPhongMaterial();
        cubeMaterial1.color = new Color(0xffffff);
        cubeMaterial1.envMap = textureCube;
        cubeMaterial1.refractionRatio = 0.98f;

        PLYLoader textureLoader = new PLYLoader();
        textureLoader.load("models/ply/binary/Lucy100k.ply", (OnLoadCallback<BufferGeometry>) object -> createScene(object, cubeMaterial1, cubeMaterial2, cubeMaterial3));


        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
    }

    private void onDocumentMouseMove(MouseEvent event) {
        mouse.x = (float) (event.clientX - (window.innerWidth / 2) * 4);
        mouse.y = (float) (event.clientY - (window.innerHeight / 2) * 4);
    }

    private void createScene(BufferGeometry geometry, MeshPhongMaterial cubeMaterial1, MeshPhongMaterial cubeMaterial2, MeshPhongMaterial cubeMaterial3) {
        geometry.computeVertexNormals();
        float s = 1.5f;
        Mesh mesh = new Mesh(geometry, cubeMaterial1);
        mesh.scale.x = mesh.scale.y = mesh.scale.z = s;
        scene.add(mesh);
        mesh = new Mesh(geometry, cubeMaterial2);
        mesh.position.x = -1500;
        mesh.scale.x = mesh.scale.y = mesh.scale.z = s;
        scene.add(mesh);
        mesh = new Mesh(geometry, cubeMaterial3);
        mesh.position.x = 1500;
        mesh.scale.x = mesh.scale.y = mesh.scale.z = s;
        scene.add(mesh);
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - Three.js cube map refraction demo\n" +
                "\n" +
                "Lucy model from Stanford 3d scanning repository\n" +
                "\n" +
                "Texture by Humus");
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

    private void render() {
        double time = new Date().getTime() * -0.0002;

        camera.position.x += (mouse.x - camera.position.x) * .05;
        camera.position.y += (-mouse.y - camera.position.y) * .05;
        camera.lookAt(scene.position);
        pointLight.position.x = 1500 * (float) Math.cos(time);
        pointLight.position.z = 1500 * (float) Math.sin(time);
        renderer.render(scene, camera);
    }

}






