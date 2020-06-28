package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Uint8Array;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.DataTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/6/18.
 */
public class WebglMaterialsTexturePartialupdate extends Attachable {

    public static final String name = "materials / texture / partialupdate";

    private float last = 0;
    private Vector2 position = new Vector2();
    private Color color = new Color();
    private Clock clock;
    private DataTexture dataTexture;
    private Texture diffuseMap;
    private Random random = new Random();


    public WebglMaterialsTexturePartialupdate() {


        camera = new PerspectiveCamera(70, aspect, 0.01f, 10);
        camera.position.z = 2;
        scene = new Scene();
        clock = new Clock();
        TextureLoader loader = new TextureLoader();
        diffuseMap = loader.load("textures/floors/FloorsCheckerboard_S_Diffuse.jpg");

        diffuseMap.minFilter = THREE.LinearFilter;
        diffuseMap.generateMipmaps = false;
        PlaneBufferGeometry geometry = new PlaneBufferGeometry(2, 2);
        MeshBasicMaterial material = new MeshBasicMaterial();
        material.map = diffuseMap;
        Mesh mesh = new Mesh(geometry, material);
        scene.add(mesh);
        //
        int width = 32;
        int height = 32;
        Uint8Array data = new Uint8Array(width * height * 3);
        dataTexture = new DataTexture(data, width, height, THREE.RGBFormat);

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);


        container.appendChild(renderer.domElement);
    }

    private void updateDataTexture(DataTexture texture) {
        int size = texture.image.width * texture.image.height;
        PropertyHolder image = Js.uncheckedCast(texture.image);
        Uint8Array data = image.getProperty("data");
        // generate a random color and update texture data
        color.setHex(random.nextInt() * 0xffffff);
        double r = Math.floor(color.r * 255);
        double g = Math.floor(color.g * 255);
        double b = Math.floor(color.b * 255);
        for (int i = 0; i < size; i++) {
            int stride = i * 3;
            data.setAt(stride, r);
            data.setAt(stride + 1, g);
            data.setAt(stride + 2, b);
        }
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - partial texture update <br/>\n" +
                "\t\t\treplace parts of an existing texture with all data of another texture");
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
        float elapsedTime = clock.getElapsedTime();
        if (elapsedTime - last > 0.1) {
            last = elapsedTime;
            position.x = (32 * org.treblereel.gwt.three4g.math.Math.randInt(1, 16)) - 32;
            position.y = (32 * org.treblereel.gwt.three4g.math.Math.randInt(1, 16)) - 32;
            // generate new color data
            updateDataTexture(dataTexture);
            // perform copy from src to dest texture to a random position
            renderer.copyTextureToTexture(position, dataTexture, diffuseMap);
        }
        renderer.render(scene, camera);
    }

}


