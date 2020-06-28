package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/25/18.
 */
public class WebglMaterialsBlending extends Attachable {

    public static final String name = "materials / blending";
    private Texture mapBg;
    private TextureLoader textureLoader = new TextureLoader();
    private PlaneBufferGeometry geo1, geo2;
    private int i = 0;


    private Map<String, Integer> blendings = new HashMap() {{
        put("NoBlending", THREE.NoBlending);
        put("NormalBlending", THREE.NormalBlending);
        put("AdditiveBlending", THREE.AdditiveBlending);
        put("SubtractiveBlending", THREE.SubtractiveBlending);
        put("MultiplyBlending", THREE.MultiplyBlending);
    }};

    public WebglMaterialsBlending() {

        camera = new PerspectiveCamera(70, aspect, 1, 1000);
        camera.position.z = 600;
        // SCENE
        scene = new Scene();
        // BACKGROUND
        HTMLCanvasElement x = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        CanvasRenderingContext2D xc = Js.uncheckedCast(x.getContext("2d"));

        x.width = x.height = 128;
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#ddd");
        xc.fillRect(0, 0, 128, 128);
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#555");
        xc.fillRect(0, 0, 64, 64);
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#999");
        xc.fillRect(32, 32, 32, 32);
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#555");
        xc.fillRect(64, 64, 64, 64);
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#777");
        xc.fillRect(96, 96, 32, 32);
        mapBg = new Texture(x);
        mapBg.wrapS = mapBg.wrapT = THREE.RepeatWrapping;
        mapBg.repeat.set(128, 64);
        mapBg.needsUpdate = true;

        MeshBasicMaterial materialBg = new MeshBasicMaterial();
        materialBg.map = mapBg;
        Mesh meshBg = new Mesh(new PlaneBufferGeometry(4000, 2000), materialBg);
        meshBg.position.set(0, 0, -1);
        scene.add(meshBg);
        // OBJECTS
        Texture map0 = textureLoader.load("textures/UV_Grid_Sm.jpg");
        Texture map1 = textureLoader.load("textures/sprite0.jpg");
        Texture map2 = textureLoader.load("textures/sprite0.png");
        Texture map3 = textureLoader.load("textures/lensflare/lensflare0.png");
        Texture map4 = textureLoader.load("textures/lensflare/lensflare0_alpha.png");
        geo1 = new PlaneBufferGeometry(100, 100);
        geo2 = new PlaneBufferGeometry(100, 25);

        addImageRow(map0, 300);
        addImageRow(map1, 150);
        addImageRow(map2, 0);
        addImageRow(map3, -150);
        addImageRow(map4, -300);


        renderer = new WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);
        //
        container.appendChild(renderer.domElement);

    }

    private void addImageRow(Texture map, float y) {
        blendings.forEach((text, value) -> {
            MeshBasicMaterial material = new MeshBasicMaterial();
            material.map = map;
            material.transparent = true;

            material.blending = value;
            float x = (i - blendings.size() / 2) * 110;
            float z = 0;
            Mesh mesh = new Mesh(geo1, material);
            mesh.position.set(x, y, z);
            scene.add(mesh);
            mesh = new Mesh(geo2, generateLabelMaterial(text.replace("Blending", "")));
            mesh.position.set(x, y - 75, z);
            scene.add(mesh);
            i++;
        });
        i = 0;
    }


    public MeshBasicMaterial generateLabelMaterial(String text) {

        HTMLCanvasElement x = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        CanvasRenderingContext2D xc = Js.uncheckedCast(x.getContext("2d"));

        x.width = 128;
        x.height = 32;
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("rgba( 0, 0, 0, 0.95 )");
        xc.fillRect(0, 0, 128, 32);
        xc.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("white");
        xc.font = "12pt arial bold";
        xc.fillText(text, 10, 22);
        Texture map = new Texture(x);
        map.needsUpdate = true;
        MeshBasicMaterial material = new MeshBasicMaterial();
        material.map = map;
        material.transparent = true;
        return material;
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

    private void render() {
        float timer = new Date().getTime() * 0.00025f;
        float ox = (timer * -0.01f * mapBg.repeat.x) % 1f;
        float oy = (timer * -0.01f * mapBg.repeat.y) % 1;
        mapBg.offset.set(ox, oy);
        renderer.render(scene, camera);
    }

}

