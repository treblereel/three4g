package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglMaterialsCubemap extends Attachable {

    public static final String name = "materials / cubemap";
    private PointLight pointLight;

    public WebglMaterialsCubemap() {

        camera = new PerspectiveCamera(50, aspect, 1, 5000);
        camera.position.z = 2000;
        //controls
        OrbitControls controls = new OrbitControls(camera);
        controls.enableZoom = false;
        controls.enablePan = false;
        controls.minPolarAngle = (float) Math.PI / 4;
        controls.maxPolarAngle = (float) Math.PI / 1.5f;
        //cubemap
        String path = "textures/cube/SwedishRoyalCastle/";
        String format = ".jpg";
        String[] urls = new String[]{
                path + "px" + format, path + "nx" + format,
                path + "py" + format, path + "ny" + format,
                path + "pz" + format, path + "nz" + format
        };
        CubeTexture reflectionCube = new CubeTextureLoader().load(urls);
        reflectionCube.format = THREE.RGBFormat;
        CubeTexture refractionCube = new CubeTextureLoader().load(urls);
        refractionCube.mapping = THREE.CubeRefractionMapping;
        refractionCube.format = THREE.RGBFormat;
        scene = new Scene();
        scene.background = reflectionCube;
        //lights
        AmbientLight ambient = new AmbientLight(0xffffff);
        scene.add(ambient);
        pointLight = new PointLight(0xffffff, 2);
        scene.add(pointLight);
        //materials
        MeshLambertMaterialParameters meshLambertMaterialParameters = new MeshLambertMaterialParameters();
        meshLambertMaterialParameters.color = new Color(0xff6600);
        meshLambertMaterialParameters.envMap = reflectionCube;
        meshLambertMaterialParameters.combine = THREE.MixOperation;
        meshLambertMaterialParameters.reflectivity = 0.3f;

        MeshLambertMaterialParameters meshLambertMaterialParameters2 = new MeshLambertMaterialParameters();
        meshLambertMaterialParameters2.color = new Color(0xffee00);
        meshLambertMaterialParameters2.envMap = refractionCube;
        meshLambertMaterialParameters2.refractionRatio = 0.95f;

        MeshLambertMaterialParameters meshLambertMaterialParameters1 = new MeshLambertMaterialParameters();
        meshLambertMaterialParameters1.color = new Color(0xffffff);
        meshLambertMaterialParameters1.envMap = refractionCube;

        MeshLambertMaterial cubeMaterial3 = new MeshLambertMaterial(meshLambertMaterialParameters);
        MeshLambertMaterial cubeMaterial2 = new MeshLambertMaterial(meshLambertMaterialParameters2);
        MeshLambertMaterial cubeMaterial1 = new MeshLambertMaterial(meshLambertMaterialParameters1);
        //models
        OBJLoader objLoader = new OBJLoader();
        objLoader.setPath("models/obj/walt/");
        objLoader.load("WaltHead.obj", new OnLoadCallback<Object3D>() {


            @Override
            public void onLoad(Object3D object) {
                Mesh head = object.children[0].cast();
                head.scale.multiplyScalar(15);
                head.position.y = -500;
                head.material = cubeMaterial1;
                Mesh head2 = head.clone();
                head2.position.x = -900;
                head2.material = cubeMaterial2;
                Mesh head3 = head.clone();
                head3.position.x = 900;
                head3.material = cubeMaterial3;
                scene.add(head, head2, head3);
            }
        });

        renderer = new WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);
        //
        container.appendChild(renderer.domElement);

    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml("- cube mapping demo.<br />\n" +
                "\t\t\tTexture by <a style='color:orange;' href=\"http://www.humus.name/index.php?page=Textures\" target=\"_blank\" rel=\"noopener\">Humus</a> Walt Disney head by <a style='color:orange;'  href=\"http://davidoreilly.com/post/18087489343/disneyhead\" target=\"_blank\" rel=\"noopener\">David OReilly</a>");
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
        renderer.render(scene, camera);
    }

}


