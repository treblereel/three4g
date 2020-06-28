package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.Event;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/1/18.
 */
public class WebglMaterialsTextureAnisotropy extends Attachable {

    public static final String name = "materials / texture / anisotropy";

    private Scene scene1, scene2;
    private Texture texture1, texture2;
    private int maxAnisotropy;
    private Vector2 mouse = new Vector2();


    public WebglMaterialsTextureAnisotropy() {

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
        renderer.autoClear = false;
        renderer.domElement.style.position = "relative";
        //
        camera = new PerspectiveCamera(35, aspect, 1, 25000);
        camera.position.z = 1500;

        scene1 = new Scene();
        scene1.background = new Color(0xf2f7ff);
        scene1.fog = new Fog(0xf2f7ff, 1, 25000);

        scene2 = new Scene();
        scene2.background = new Color(0xf2f7ff);
        scene2.fog = new Fog(0xf2f7ff, 1, 25000);
        scene1.add(new AmbientLight(0xeef0ff));
        scene2.add(new AmbientLight(0xeef0ff));
        DirectionalLight light1 = new DirectionalLight(0xffffff, 2);
        light1.position.set(1, 1, 1);
        scene1.add(light1);
        DirectionalLight light2 = new DirectionalLight(0xffffff, 2);
        light2.position.set(1, 1, 1);
        scene2.add(light2);
        // GROUND
        TextureLoader textureLoader = new TextureLoader();
        maxAnisotropy = renderer.capabilities.getMaxAnisotropy();

        texture1 = textureLoader.load("textures/crate.gif");
        MeshPhongMaterial material1 = new MeshPhongMaterial();
        material1.color = new Color(0xffffff);
        material1.map = texture1;

        texture1.anisotropy = maxAnisotropy;
        texture1.wrapS = texture1.wrapT = THREE.RepeatWrapping;
        texture1.repeat.set(512, 512);

        texture2 = textureLoader.load("textures/crate.gif");
        MeshPhongMaterial material2 = new MeshPhongMaterial();
        material2.color = new Color(0xffffff);
        material2.map = texture2;

        texture2.anisotropy = 1;
        texture2.wrapS = texture2.wrapT = THREE.RepeatWrapping;
        texture2.repeat.set(512, 512);

        PlaneBufferGeometry geometry = new PlaneBufferGeometry(100, 100);
        Mesh mesh1 = new Mesh(geometry, material1);
        mesh1.rotation.x = (float) -Math.PI / 2;
        mesh1.scale.set(1000, 1000, 1000);

        Mesh mesh2 = new Mesh(geometry, material2);
        mesh2.rotation.x = (float) -Math.PI / 2;
        mesh2.scale.set(1000, 1000, 1000);
        scene1.add(mesh1);
        scene2.add(mesh2);

        container.appendChild(renderer.domElement);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
    }

    public void onDocumentMouseMove(Event evt) {
        MouseEvent event = (MouseEvent) evt;
        mouse.x = (float) ((event.clientX - (window.innerWidth)));
        mouse.y = (float) ((event.clientY - (window.innerHeight)));
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        String info = " <span style='color:orange;'> - anisotropic texture filtering example <br>";

        if (maxAnisotropy > 0) {
            info += " LEFT : " + texture1.anisotropy;
            info += " RIGHT : " + texture2.anisotropy;
        } else {
            info += " LEFT : not supported";
            info += " RIGHT : not supported";
        }
        info += "</span>";

        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(info);
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
        camera.position.x += (mouse.x - camera.position.x) * .05;
        camera.position.y = org.treblereel.gwt.three4g.math.Math.clamp(camera.position.y + (-(mouse.y - 200) - camera.position.y) * .05f, 50, 1000);
        camera.lookAt(scene1.position);
        renderer.clear();
        renderer.setScissorTest(true);
        renderer.setScissor(0, 0, root.clientWidth / 2 - 2, root.clientHeight);
        renderer.render(scene1, camera);
        renderer.setScissor(root.clientWidth / 2, 0, root.clientWidth / 2 - 2, root.clientHeight);
        renderer.render(scene2, camera);
        renderer.setScissorTest(false);
    }

}


