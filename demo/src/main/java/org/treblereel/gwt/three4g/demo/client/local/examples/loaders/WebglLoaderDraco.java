package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.DRACOLoader;
import org.treblereel.gwt.three4g.extensions.loaders.DRACOLoaderDecoderConfig;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/9/18.
 */
@InjectJavaScriptFor(elements = DRACOLoader.class)
public class WebglLoaderDraco extends Attachable {

    public static final String name = "loader / draco";

    private DRACOLoader dracoLoader;

    public WebglLoaderDraco() {


        DRACOLoaderDecoderConfig config = new DRACOLoaderDecoderConfig();
        config.type = "js";

        dracoLoader = new DRACOLoader();
        dracoLoader.setDecoderPath("js/libs/draco/");
        dracoLoader.setDecoderConfig(config);

        camera = new PerspectiveCamera(35, aspect, 0.1f, 15);
        camera.position.set(3, 0.25f, 3);
        scene = new Scene();
        scene.background = new Color(0x443333);
        scene.fog = new Fog(0x443333, 1, 4);
        // Ground
        MeshPhongMaterialParameters props = new MeshPhongMaterialParameters();
        props.color = new Color(0x999999);
        props.specular = new Color(0x101010);


        Mesh plane = new Mesh(
                new PlaneBufferGeometry(8, 8),
                new MeshPhongMaterial(props)
        );
        plane.rotation.x = ((float) -Math.PI / 2);
        plane.position.y = 0.03f;
        plane.receiveShadow = true;
        scene.add(plane);
        // Lights
        HemisphereLight hemisphereLight = new HemisphereLight(0x443333, 0x111122);
        scene.add(hemisphereLight);
        SpotLight spotLight = new SpotLight();
        spotLight.angle = ((float) Math.PI / 16);
        spotLight.penumbra = 0.5f;
        spotLight.castShadow = true;
        spotLight.position.set(-1, 1, 1);
        scene.add(spotLight);

        dracoLoader.load("models/draco/bunny.drc", (OnLoadCallback<BufferGeometry>) geometry -> {
            geometry.computeVertexNormals();
            MeshStandardMaterial material = new MeshStandardMaterial();
            material.vertexColors = THREE.VertexColors;
            Mesh mesh = new Mesh(geometry, material);
            mesh.castShadow = true;
            mesh.receiveShadow = true;
            scene.add(mesh);
            // Release decoder resources.
            DRACOLoader.releaseDecoderModule();
            //dracoLoader.dispose();
        });

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        renderer.shadowMap.enabled = true;

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("<a href=\"https://github.com/google/draco\" target=\"_blank\" rel=\"noopener\">DRACO</a> loader\n" +
                "\t</div>");
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                double timer = new Date().getTime() * 0.0003;
                camera.position.x = (float) (Math.sin(timer) * 0.5);
                camera.position.z = (float) (Math.cos(timer) * 0.5);
                camera.lookAt(new Vector3(0, 0.1f, 0));
                renderer.render(scene, camera);
            }
            animate();
        });
    }

}
