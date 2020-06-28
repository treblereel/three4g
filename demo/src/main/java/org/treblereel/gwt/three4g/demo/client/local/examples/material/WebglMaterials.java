package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.ImageData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Face3;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshDepthMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshNormalMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/25/18.
 */
public class WebglMaterials extends Attachable {


    public static final String name = "materials";
    private Random rand = new Random();

    private PointLight pointLight;

    private List<Mesh> objects = new ArrayList<>();
    private List<Material> materials = new ArrayList<>();

    public WebglMaterials() {

        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.set(0, 200, 800);
        scene = new Scene();
        // Grid
        GridHelper helper = new GridHelper(1000, 40, new Color(0x303030), new Color(0x303030));
        helper.position.y = -75;
        scene.add(helper);
        // Materials
        Texture texture = new Texture(generateTexture());
        texture.needsUpdate = true;

        MeshLambertMaterialParameters param = new MeshLambertMaterialParameters();
        param.map = texture;
        param.transparent = true;

        materials.add(new MeshLambertMaterial(param));

        param = new MeshLambertMaterialParameters();
        param.color = new Color(0xdddddd);

        materials.add(new MeshLambertMaterial(param));

        MeshPhongMaterialParameters param1 = new MeshPhongMaterialParameters();
        param1.color = new Color(0xdddddd);
        param1.specular = new Color(0x009900);
        param1.shininess = 30;
        param1.flatShading = true;

        materials.add(new MeshPhongMaterial(param1));
        materials.add(new MeshNormalMaterial());

        MeshBasicMaterialParameters param2 = new MeshBasicMaterialParameters();
        param2.color = new Color(0xffaa00);
        param2.transparent = true;
        param2.blending = THREE.AdditiveBlending;

        materials.add(new MeshBasicMaterial(param2));

        MeshLambertMaterialParameters param3 = new MeshLambertMaterialParameters();
        param3.color = new Color(0xdddddd);

        materials.add(new MeshLambertMaterial(param3));

        MeshPhongMaterialParameters param4 = new MeshPhongMaterialParameters();
        param4.color = new Color(0xdddddd);
        param4.specular = new Color(0x009900);
        param4.shininess = 30;
        param.map = texture;
        param4.transparent = true;

        materials.add(new MeshPhongMaterial(param4));


        MeshNormalMaterialParameters param5 = new MeshNormalMaterialParameters();
        param5.flatShading = true;

        materials.add(new MeshNormalMaterial(param5));

        MeshBasicMaterialParameters param6 = new MeshBasicMaterialParameters();
        param6.color = new Color(0xffaa00);
        param6.wireframe = true;

        materials.add(new MeshBasicMaterial(param6));
        materials.add(new MeshDepthMaterial());

        MeshLambertMaterialParameters param7 = new MeshLambertMaterialParameters();
        param7.color = new Color(0x666666);

        param7.emissive = new Color(0xff0000);

        materials.add(new MeshLambertMaterial(param7));

        MeshPhongMaterialParameters param8 = new MeshPhongMaterialParameters();
        param8.color = new Color(0x000000);
        param8.specular = new Color(0x666666);
        param8.emissive = new Color(0xff0000);
        param8.shininess = 10;
        param8.opacity = 0.9f;
        param8.transparent = true;
        materials.add(new MeshPhongMaterial(param8));

        MeshBasicMaterialParameters param9 = new MeshBasicMaterialParameters();
        param9.map = texture;
        param9.transparent = true;

        materials.add(new MeshBasicMaterial(param9));

        // Spheres geometry
        SphereGeometry geometry = new SphereGeometry(70, 32, 16);

        for (int i = 0; i < geometry.faces.length; i++) {
            Face3 face = geometry.faces.getAt(i);
            face.materialIndex = (int) Math.floor(Math.random() * materials.size());
        }
        geometry.sortFacesByMaterialIndex();

        for (int i = 0, l = materials.size(); i < l; i++) {
            addMesh(geometry, materials.get(i));
        }

        addMesh(geometry, materials.toArray(new Material[materials.size()]));

        // Lights
        scene.add(new AmbientLight(0x111111));
        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 0.125f);
        directionalLight.position.x = rand.nextFloat() - 0.5f;
        directionalLight.position.y = rand.nextFloat() - 0.5f;
        directionalLight.position.z = rand.nextFloat() - 0.5f;
        directionalLight.position.normalize();
        scene.add(directionalLight);

        pointLight = new PointLight(0xffffff, 1);
        scene.add(pointLight);

        MeshBasicMaterialParameters parameters = new
                MeshBasicMaterialParameters();
        parameters.color = new Color(0xffffff);
        pointLight.add(new Mesh(new SphereBufferGeometry(4, 8, 8), new MeshBasicMaterial(parameters)));
        //
        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.antialias = true;
        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        //
        container.appendChild(renderer.domElement);

    }

    public void addMesh(Geometry geometry, Material... material) {
        Mesh mesh;
        if (material.length == 1) {
            mesh = new Mesh(geometry, material[0]);
        } else {
            mesh = new Mesh(geometry, material);
        }
        mesh.position.x = (objects.size() % 4) * 200 - 400;
        mesh.position.z = (float) (Math.floor(objects.size() / 4) * 200 - 200);
        mesh.rotation.x = (float) (Math.random() * 200 - 100);
        mesh.rotation.y = (float) (Math.random() * 200 - 100);
        mesh.rotation.z = (float) (Math.random() * 200 - 100);
        objects.add(mesh);
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
        AppSetup.infoDiv.hide();
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

    public HTMLCanvasElement generateTexture() {
        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext("2d"));

        canvas.width = 256;
        canvas.height = 256;

        ImageData image = context.getImageData(0, 0, 256, 256);
        int x, y = 0;
        for (int i = 0, j = 0, l = image.data.length; i < l; i += 4, j++) {
            x = j % 256;
            y = x == 0 ? y + 1 : y;
            image.data.setAt(i, 255d);
            image.data.setAt(i + 1, 255d);
            image.data.setAt(i + 2, 255d);
            image.data.setAt(i + 3, Math.floor(x ^ y));
        }
        context.putImageData(image, 0, 0);
        return canvas;
    }

    private void render() {

        double timer = new Date().getTime() * 0.0001;

        camera.position.x = (float) (Math.cos(timer) * 1000);
        camera.position.z = (float) (Math.sin(timer) * 1000);
        camera.lookAt(scene.position);


        for (int i = 0, l = objects.size(); i < l; i++) {
            Mesh object = objects.get(i);
            object.rotation.x += 0.01f;
            object.rotation.y += 0.005f;
        }

        MeshPhongMaterial meshPhongMaterial = materials.get(materials.size() - 2).cast();
        meshPhongMaterial.emissive.setHSL(0.54f, 1, (float) (0.35f * (0.5 + 0.5 * Math.sin(35 * timer))));

        MeshLambertMaterial meshLambertMaterial = materials.get(materials.size() - 3).cast();
        meshLambertMaterial.emissive.setHSL(0.04f, 1, (float) (0.35 * (0.5 + 0.5 * Math.cos(35 * timer))));

        pointLight.position.x = (float) (Math.sin(timer * 7) * 300);
        pointLight.position.y = (float) (Math.cos(timer * 5) * 400);
        pointLight.position.z = (float) (Math.cos(timer * 3) * 300);
        renderer.render(scene, camera);
    }

}
