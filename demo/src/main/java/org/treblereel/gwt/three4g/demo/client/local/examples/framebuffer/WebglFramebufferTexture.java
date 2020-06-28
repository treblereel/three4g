package org.treblereel.gwt.three4g.demo.client.local.examples.framebuffer;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Uint8Array;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.TorusKnotBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.SpriteMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Sprite;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.DataTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/28/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglFramebufferTexture extends Attachable {

    public static final String name = "framebuffer / texture";

    private OrthographicCamera cameraOrtho;
    private Scene sceneOrtho;
    private Sprite sprite;
    private Vector2 vector = new Vector2();
    private DataTexture texture;
    private HTMLDivElement overlay;
    private int textureSize = 128;

    public WebglFramebufferTexture() {

        overlay = (HTMLDivElement) document.createElement("div");
        overlay.id = "overlay";
        HTMLDivElement inner = (HTMLDivElement) document.createElement("div");
        overlay.appendChild(inner);
        document.body.appendChild(overlay);


        textureSize *= devicePixelRatio;

        camera = new PerspectiveCamera(70, aspect, 1, 1000);
        camera.position.z = 20;

        cameraOrtho = new OrthographicCamera((float) (-getWidth() / 2), (float) (getWidth() / 2f), (float) (getHeight() / 2f), (float) (-getHeight() / 2f), 1, 10);
        cameraOrtho.position.z = 10;

        scene = new Scene();
        scene.background = new Color(0x20252f);
        sceneOrtho = new Scene();
        //
        TorusKnotBufferGeometry geometry = new TorusKnotBufferGeometry(3, 1, 256, 32);
        MeshStandardMaterial material = new MeshStandardMaterial();
        material.color = new Color(0x6083c2);
        mesh = new Mesh(geometry, material);
        scene.add(mesh);
        //
        AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4f);
        scene.add(ambientLight);
        PointLight pointLight = new PointLight(0xffffff, 0.8f);

        camera.add(pointLight);
        scene.add(camera);
        //
        Uint8Array data = new Uint8Array(textureSize * textureSize * 3);
        texture = new DataTexture(data, textureSize, textureSize, THREE.RGBFormat);
        texture.minFilter = THREE.NearestFilter;
        texture.magFilter = THREE.NearestFilter;
        texture.needsUpdate = true;
        //
        SpriteMaterial spriteMaterial = new SpriteMaterial();
        spriteMaterial.map = texture;

        sprite = new Sprite(spriteMaterial);
        sprite.scale.set(textureSize, textureSize, 1);
        sceneOrtho.add(sprite);
        updateSpritePosition();
        //

        //
        orbitControls = new OrbitControls(camera, overlay);
        orbitControls.enablePan = false;
        //
        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.antialias = true;
        renderer = new WebGLRenderer(rendererParameters);
        renderer.setPixelRatio(devicePixelRatio);
        renderer.autoClear = false;
        //
        container.appendChild(renderer.domElement);

    }


    @Override
    public void onWindowResize() {
        camera.aspect = (float) (getWidth() / getHeight());
        camera.updateProjectionMatrix();
        cameraOrtho.left = (float) (-getWidth() / 2);
        cameraOrtho.right = (float) (getWidth() / 2);
        cameraOrtho.top = (float) (getHeight() / 2);
        cameraOrtho.bottom = (float) (-getHeight() / 2);
        cameraOrtho.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);

        overlay.style.marginLeft = CSSProperties.MarginLeftUnionType.of(panel.clientWidth);
        updateSpritePosition();
    }

    private void updateSpritePosition() {
        double halfWidth = getWidth() / 2;
        double halfHeight = getHeight() / 2;
        double halfImageWidth = textureSize / 2;
        double halfImageHeight = textureSize / 2;
        sprite.position.set((float) (-halfWidth + halfImageWidth), (float) (halfHeight - halfImageHeight), 1);
    }

    @Override
    public void detach() {
        super.doDetach();
        document.body.removeChild(overlay);
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" framebuffer to texture <br/>\n" +
                "\t\t\tThe area of the white square is copied from the framebuffer to a texture (shown in the top-left corner).");
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                mesh.rotation.x += 0.005;
                mesh.rotation.y += 0.01;
                renderer.clear();
                renderer.render(scene, camera);
                // calculate start position for copying data
                vector.x = (float) (getWidth() * devicePixelRatio / 2) - (textureSize / 2);
                vector.y = (float) (getHeight() * devicePixelRatio / 2) - (textureSize / 2);
                renderer.copyFramebufferToTexture(vector, texture);
                renderer.clearDepth();
                renderer.render(sceneOrtho, cameraOrtho);
                animate();

            }
        });
    }

}

