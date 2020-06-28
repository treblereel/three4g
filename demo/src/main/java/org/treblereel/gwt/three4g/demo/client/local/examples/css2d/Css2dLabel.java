package org.treblereel.gwt.three4g.demo.client.local.examples.css2d;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.renderers.CSS2DObject;
import org.treblereel.gwt.three4g.extensions.renderers.CSS2DRenderer;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.helpers.AxesHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/11/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, CSS2DRenderer.class})
public class Css2dLabel extends Attachable {

    public static final String name = "label";

    private Clock clock = new Clock();
    private OrbitControls controls;
    private Scene scene2;
    private Mesh earth, moon;
    private TextureLoader textureLoader = new TextureLoader();
    private CSS2DRenderer labelRenderer;

    public Css2dLabel() {

        float EARTH_RADIUS = 1;
        float MOON_RADIUS = 0.27f;

        camera = new PerspectiveCamera(45, aspect, 1, 1000);
        camera.position.set(10, 5, 20);
        orbitControls = new OrbitControls(camera);
        scene = new Scene();
        scene2 = new Scene();
        DirectionalLight dirLight = new DirectionalLight(0xffffff);
        dirLight.position.set(0, 0, 1);
        scene.add(dirLight);
        AxesHelper axesHelper = new AxesHelper(5);
        scene.add(axesHelper);
        //
        SphereBufferGeometry earthGeometry = new SphereBufferGeometry(EARTH_RADIUS, 16, 16);

        MeshPhongMaterial earthMaterial = new MeshPhongMaterial();
        earthMaterial.specular = new Color(0x333333);
        earthMaterial.shininess = 5;
        earthMaterial.map = textureLoader.load("textures/planets/earth_atmos_2048.jpg");
        earthMaterial.specularMap = textureLoader.load("textures/planets/earth_specular_2048.jpg");
        earthMaterial.normalMap = textureLoader.load("textures/planets/earth_normal_2048.jpg");
        earthMaterial.normalScale = new Vector2(0.85f, 0.85f);

        earth = new Mesh(earthGeometry, earthMaterial);

        scene.add(earth);

        SphereBufferGeometry moonGeometry = new SphereBufferGeometry(MOON_RADIUS, 16, 16);
        MeshPhongMaterial moonMaterial = new MeshPhongMaterial();
        moonMaterial.shininess = 5;
        moonMaterial.map = textureLoader.load("textures/planets/moon_1024.jpg");

        moon = new Mesh(moonGeometry, moonMaterial);
        scene.add(moon);
        //
        HTMLDivElement earthDiv = (HTMLDivElement) DomGlobal.document.createElement("div");
        earthDiv.className = "label";
        earthDiv.textContent = "Earth";
        earthDiv.style.marginTop = CSSProperties.MarginTopUnionType.of("-1em");
        CSS2DObject earthLabel = new CSS2DObject(earthDiv);
        earthLabel.position.set(0, EARTH_RADIUS, 0);
        earth.add(earthLabel);

        HTMLDivElement moonDiv = (HTMLDivElement) DomGlobal.document.createElement("div");
        moonDiv.className = "label";
        moonDiv.textContent = "Moon";
        moonDiv.style.marginTop = CSSProperties.MarginTopUnionType.of("-1em");
        CSS2DObject moonLabel = new CSS2DObject(moonDiv);
        moonLabel.position.set(0, MOON_RADIUS, 0);
        moon.add(moonLabel);
        //
        renderer = new WebGLRenderer();
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(getWidth(), getHeight());

        labelRenderer = new CSS2DRenderer();
        labelRenderer.setSize(getWidth(), getHeight());
        labelRenderer.domElement.style.position = "absolute";
        labelRenderer.domElement.style.top = "0";
        root.appendChild(labelRenderer.domElement);
    }

    @Override
    public void detach() {
        super.detach();
        root.removeChild(labelRenderer.domElement);
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
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

    private void render() {
        float elapsed = clock.getElapsedTime();
        moon.position.set((float) Math.sin(elapsed) * 5f, 0, (float) Math.cos(elapsed) * 5f);
        renderer.render(scene, camera);
        labelRenderer.render(scene, camera);
    }
}

