package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.objects.Lensflare;
import org.treblereel.gwt.three4g.extensions.objects.LensflareElement;
import org.treblereel.gwt.three4g.extensions.objects.Reflector;
import org.treblereel.gwt.three4g.extensions.objects.parameters.ReflectorParameters;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.OnAnimate;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/14/18.
 */
@InjectJavaScriptFor(elements = {WebVR.class, Reflector.class, Lensflare.class, LensflareElement.class})
public class WebVRSandbox extends Attachable {

    public static final String name = "sandbox";

    private HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");
    private Reflector reflector;

    private WebVRSandbox() {

        String[] textures = {"dark-s_px.jpg", "dark-s_nx.jpg", "dark-s_py.jpg", "dark-s_ny.jpg", "dark-s_pz.jpg", "dark-s_nz.jpg"};

        CubeTexture background = new CubeTextureLoader()
                .setPath("textures/cube/MilkyWay/")
                .load(textures);

        background.format = THREE.RGBFormat;

        scene = new Scene();
        scene.background = background;
        camera = new PerspectiveCamera(50, aspect, 0.1f, 10);
        TorusKnotBufferGeometry geometry = new TorusKnotBufferGeometry(0.4f, 0.15f, 150, 20);
        MeshStandardMaterial material = new MeshStandardMaterial();
        material.roughness = 0.01f;
        material.metalness = 0.2f;
        material.envMap = background;

        Mesh mesh = new Mesh(geometry, material);
        mesh.position.y = 0.75f;
        mesh.position.z = -2;
        mesh.castShadow = true;
        mesh.receiveShadow = true;
        scene.add(mesh);

        BoxBufferGeometry boxBufferGeometry = new BoxBufferGeometry(1.5f, 0.1f, 1.5f);
        MeshPhongMaterial meshPhongMaterial = new MeshPhongMaterial();

        mesh = new Mesh(boxBufferGeometry, meshPhongMaterial);
        mesh.position.y = -0.2f;
        mesh.position.z = -2;
        mesh.castShadow = true;
        mesh.receiveShadow = true;
        scene.add(mesh);

        DirectionalLight light = new DirectionalLight(0x8800ff);
        light.position.set(-1, 1.5f, -1.5f);
        light.castShadow = true;

        ((OrthographicCamera) light.shadow.camera).zoom = 4;
        scene.add(light);
        light.target.position.set(0, 0, -2);
        scene.add(light.target);

        light = new DirectionalLight(0xff0000);
        light.position.set(1, 1.5f, -2.5f);
        light.castShadow = true;
        ((OrthographicCamera) light.shadow.camera).zoom = 4;
        scene.add(light);
        light.target.position.set(0, 0, -2);
        scene.add(light.target);
        // lensflare
        TextureLoader loader = new TextureLoader();
        Texture texture0 = loader.load("textures/lensflare/lensflare0.png");
        Texture texture3 = loader.load("textures/lensflare/lensflare3.png");

        Lensflare lensflare = new Lensflare();
        lensflare.position.set(0, 5, -5);
        lensflare.addElement(new LensflareElement(texture0, 700, 0));
        lensflare.addElement(new LensflareElement(texture3, 60, 0.6f));
        lensflare.addElement(new LensflareElement(texture3, 70, 0.7f));
        lensflare.addElement(new LensflareElement(texture3, 120, 0.9f));
        lensflare.addElement(new LensflareElement(texture3, 70, 1));
        scene.add(lensflare);
        //
        PlaneBufferGeometry planeBufferGeometry = new PlaneBufferGeometry(1.4f, 1.4f);

        JsPropertyMap windowCasted = Js.uncheckedCast(window);
        double devicePixelRatio = Js.uncheckedCast(windowCasted.get("devicePixelRatio"));
        GWT.log("devicePixelRatio " + devicePixelRatio);


        ReflectorParameters reflectorParameters = new ReflectorParameters();
        reflectorParameters.textureHeight = window.innerHeight * devicePixelRatio;
        reflectorParameters.textureWidth = window.innerWidth * devicePixelRatio;
        reflector = new Reflector(planeBufferGeometry, reflectorParameters);

        reflector.position.x = 1;
        reflector.position.y = 0.5f;
        reflector.position.z = -3;
        reflector.rotation.y = (float) -Math.PI / 4;
        scene.add(reflector);

        BoxBufferGeometry boxBufferGeometry1 = new BoxBufferGeometry(1.5f, 1.5f, 0.1f);
        MeshPhongMaterial meshPhongMaterial1 = new MeshPhongMaterial();
        Mesh mesh1 = new Mesh(boxBufferGeometry1, meshPhongMaterial1);
        mesh1.position.z = -0.07f;
        mesh1.castShadow = true;
        mesh1.receiveShadow = true;
        reflector.add(mesh1);

        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.alpha = true;
        rendererParameters.antialias = true;

        renderer = new WebGLRenderer(rendererParameters);
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.vr.enabled = true;

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }

    private void animate() {
        renderer.setAnimationLoop(new OnAnimate() {
            @Override
            public void animate() {
                if (container.parentNode != null && container.parentNode.parentNode != null) {
                    render();
                }
            }
        });
    }

    private void render() {
        float time = (float) (DomGlobal.performance.now() * 0.0002);
        Object3D mesh = scene.children[0];
        mesh.rotation.x = time * 2;
        mesh.rotation.y = time * 5;
        renderer.render(scene, camera);
    }
}
