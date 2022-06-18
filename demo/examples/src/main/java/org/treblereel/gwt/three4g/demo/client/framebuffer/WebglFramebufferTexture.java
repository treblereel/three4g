package org.treblereel.gwt.three4g.demo.client.framebuffer;

import elemental2.core.Float32Array;
import elemental2.core.JsIterable;
import elemental2.core.Uint8Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.bufferattribute.Float32BufferAttribute;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.SpriteMaterial;
import org.treblereel.gwt.three4g.materials.SpriteMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Sprite;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.DataTexture;
import org.treblereel.gwt.three4g.utils.GeometryUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static elemental2.dom.DomGlobal.window;


@ApplicationScoped
@Page(path = "webgl_framebuffer_texture")
public class WebglFramebufferTexture implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;
    private OrthographicCamera cameraOrtho;

    private Scene scene, sceneOrtho;

    private boolean run, ready;

    private Line line;

    private double offset = 0;

    private double dpr = window.devicePixelRatio;

    private int textureSize = 128 * (int) dpr;
    private Vector2 vector = new Vector2();
    private Color color = new Color();

    private DataTexture texture;

    private Sprite sprite;

    private HTMLDivElement selection = (HTMLDivElement) DomGlobal.document.createElement("div");
    private HTMLDivElement selectionChild = (HTMLDivElement) DomGlobal.document.createElement("div");

    @PostConstruct
    public void init() {
        selection.id = "selection";
        root.appendChild(selection);
        selection.appendChild(selectionChild);

        double width = window.innerWidth;
        double height = window.innerHeight;


        camera = new PerspectiveCamera(70, width / height, 1, 1000);
        camera.position.z = 20;

        cameraOrtho = new OrthographicCamera(-width / 2, width / 2, height / 2, -height / 2, 1, 10);
        cameraOrtho.position.z = 10;

        scene = new Scene();
        sceneOrtho = new Scene();

        //

        JsIterable<Double> points = GeometryUtils.gosper(8);

        BufferGeometry geometry = new BufferGeometry();
        Float32BufferAttribute positionAttribute = new Float32BufferAttribute(points, 3);
        geometry.setAttribute("position", positionAttribute);
        geometry.center();

        BufferAttribute colorAttribute = new BufferAttribute(new Float32Array(positionAttribute.array.length), 3);
        colorAttribute.setUsage(THREE.DynamicDrawUsage);
        geometry.setAttribute("color", colorAttribute);


        LineBasicMaterialParameters lineBasicMaterialParameters = LineBasicMaterialParameters.create();
        lineBasicMaterialParameters.setVertexColors(true);
        LineBasicMaterial material = new LineBasicMaterial(lineBasicMaterialParameters);

        line = new Line(geometry, material);
        line.scale.setScalar(0.05);
        scene.add(line);

        //TODO ver 140+

/*        texture = new FramebufferTexture(textureSize, textureSize, THREE.RGBAFormat);
        texture.minFilter = THREE.NearestFilter;
        texture.magFilter = THREE.NearestFilter;*/

        //

        Uint8Array data = new Uint8Array(textureSize * textureSize * 3);

        texture = new DataTexture(data, textureSize, textureSize, THREE.RGBFormat);
        texture.minFilter = THREE.NearestFilter;
        texture.magFilter = THREE.NearestFilter;

        SpriteMaterialParameters spriteMaterialParameters = SpriteMaterialParameters.create();
        spriteMaterialParameters.setMap(texture);
        SpriteMaterial spriteMaterial = new SpriteMaterial(spriteMaterialParameters);
        sprite = new Sprite(spriteMaterial);
        sprite.scale.set(textureSize, textureSize, 1);
        sceneOrtho.add(sprite);

        updateSpritePosition();

        //
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(window.devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.autoClear = false;
        root.appendChild(renderer.domElement);

        //
        OrbitControls controls = new OrbitControls(camera, selection);
        controls.enablePan = false;

        window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    private void updateSpritePosition() {

        double halfWidth = window.innerWidth / 2;
        double halfHeight = window.innerHeight / 2;

        double halfImageWidth = textureSize / 2;
        double halfImageHeight = textureSize / 2;

        sprite.position.set(-halfWidth + halfImageWidth, halfHeight - halfImageHeight, 1);

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {

            double width = window.innerWidth;
            double height = window.innerHeight;

            camera.aspect = width / height;
            camera.updateProjectionMatrix();

            cameraOrtho.left = -width / 2;
            cameraOrtho.right = width / 2;
            cameraOrtho.top = height / 2;
            cameraOrtho.bottom = -height / 2;
            cameraOrtho.updateProjectionMatrix();

            renderer.setSize(window.innerWidth, window.innerHeight);

            updateSpritePosition();

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {

            BufferAttribute colorAttribute = line.geometry.getAttribute("color").asBufferAttribute();
            updateColors(colorAttribute);

            // scene rendering

            renderer.clear();
            renderer.render(scene, camera);

            // calculate start position for copying data

            vector.x = (window.innerWidth * dpr / 2) - (textureSize / 2);
            vector.y = (window.innerHeight * dpr / 2) - (textureSize / 2);

            renderer.copyFramebufferToTexture(vector, texture);

            renderer.clearDepth();
            renderer.render(sceneOrtho, cameraOrtho);
        }
    }

    private void updateColors(BufferAttribute colorAttribute) {

        int l = (int) colorAttribute.count;

        for (int i = 0; i < l; i++) {

            double h = ((offset + i) % l) / l;

            color.setHSL(h, 1, 0.5);
            colorAttribute.setX(i, color.r);
            colorAttribute.setY(i, color.g);
            colorAttribute.setZ(i, color.b);

        }

        colorAttribute.needsUpdate = true;

        offset -= 25;

    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> framebuffer to texture";

        run = true;
        animate();
    }
}
