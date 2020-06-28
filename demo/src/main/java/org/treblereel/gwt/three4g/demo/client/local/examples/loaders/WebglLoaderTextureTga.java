package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.TGALoader;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/12/18.
 */
@InjectJavaScriptFor(elements = {TGALoader.class, OrbitControls.class})
public class WebglLoaderTextureTga extends Attachable {

    public static final String name = "loader / texture / tga";

    private Clock clock = new Clock();

    public WebglLoaderTextureTga() {

        camera = new PerspectiveCamera(45, aspect, 0.1f, 2000);
        camera.position.set(0, 50, 250);
        scene = new Scene();
        //
        TGALoader loader = new TGALoader();
        BoxBufferGeometry geometry = new BoxBufferGeometry(50, 50, 50);
        // add box 1 - grey8 texture
        Texture texture1 = loader.load("textures/crate_grey8.tga");
        MeshPhongMaterialParameters parameter1 = new MeshPhongMaterialParameters();
        parameter1.color = new Color(0xffffff);
        parameter1.map = texture1;
        MeshPhongMaterial material1 = new MeshPhongMaterial(parameter1);
        Mesh mesh1 = new Mesh(geometry, material1);
        mesh1.position.x = -50;
        scene.add(mesh1);
        // add box 2 - tga texture
        Texture texture2 = loader.load("textures/crate_color8.tga");
        MeshPhongMaterialParameters parameter2 = new MeshPhongMaterialParameters();
        parameter2.color = new Color(0xffffff);
        parameter2.map = texture2;
        MeshPhongMaterial material2 = new MeshPhongMaterial(parameter2);
        Mesh mesh2 = new Mesh(geometry, material2);
        mesh2.position.x = 50;
        scene.add(mesh2);
        //
        AmbientLight ambientLight = new AmbientLight(0xffffff, 0.4f);
        scene.add(ambientLight);
        DirectionalLight light = new DirectionalLight(0xffffff, 1);
        light.position.set(1, 1, 1);
        scene.add(light);
        //
        orbitControls = new OrbitControls(camera);


        //
        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.antialias = true;
        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.shadowMap.enabled = true;
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - TGA texture example by <a href=\"https://github.com/DaoshengMu/\" target=\"_blank\" rel=\"noopener\">Daosheng Mu</a>");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                renderer.render(scene, camera);
                animate();
            }
        });
    }

}
