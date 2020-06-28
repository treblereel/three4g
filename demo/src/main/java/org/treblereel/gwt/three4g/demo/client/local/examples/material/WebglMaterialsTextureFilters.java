package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.ImageData;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/6/18.
 */
public class WebglMaterialsTextureFilters extends Attachable {

    public static final String name = "materials / texture / filters";

    private Scene scene2;
    private Vector2 mouse = new Vector2();
    private Texture texturePainting2;
    private MeshBasicMaterial materialPainting, materialPainting2;
    private Mesh meshCanvas, meshCanvas2;


    public WebglMaterialsTextureFilters() {
        addLabels();

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
        renderer.autoClear = false;
        renderer.domElement.style.position = "relative";


        camera = new PerspectiveCamera(35, aspect, 1, 5000);
        camera.position.z = 1500;
        scene = new Scene();
        scene.background = new Color(0x000000);
        scene.fog = new Fog(0x000000, 1500, 4000);
        scene2 = new Scene();
        scene2.background = new Color(0x000000);
        scene2.fog = new Fog(0x000000, 1500, 4000);
        // GROUND
        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext("2d"));

        canvas.height = 128;
        // draw white background
        context.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#444");
        context.fillRect(0, 0, 128, 128);
        context.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#fff");
        context.fillRect(0, 0, 64, 64);
        context.fillRect(64, 64, 64, 64);


        CanvasTexture textureCanvas = new CanvasTexture(canvas);
        textureCanvas.repeat.set(1000, 1000);
        textureCanvas.wrapS = THREE.RepeatWrapping;
        textureCanvas.wrapT = THREE.RepeatWrapping;

        CanvasTexture textureCanvas2 = (CanvasTexture) textureCanvas.clone();
        textureCanvas2.magFilter = THREE.NearestFilter;
        textureCanvas2.minFilter = THREE.NearestFilter;
        MeshBasicMaterial materialCanvas = new MeshBasicMaterial();
        materialCanvas.map = textureCanvas;
        MeshBasicMaterial materialCanvas2 = new MeshBasicMaterial();
        materialCanvas2.color = new Color(0xffccaa);
        materialCanvas2.map = textureCanvas2;
        PlaneBufferGeometry geometry = new PlaneBufferGeometry(100, 100);
        meshCanvas = new Mesh(geometry, materialCanvas);
        meshCanvas.rotation.x = (float) -Math.PI / 2;
        meshCanvas.scale.set(1000, 1000, 1000);
        meshCanvas2 = new Mesh(geometry, materialCanvas2);
        meshCanvas2.rotation.x = (float) -Math.PI / 2;
        meshCanvas2.scale.set(1000, 1000, 1000);

        texturePainting2 = new Texture();
        materialPainting = new MeshBasicMaterial();
        materialPainting2 = new MeshBasicMaterial();

        Texture texturePainting = new TextureLoader().load("textures/758px-Canestra_di_frutta_(Caravaggio).jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture texturePainting) {
                ImageData image = texturePainting.image;
                texturePainting2.image = image;
                texturePainting2.needsUpdate = true;
                scene.add(meshCanvas);
                scene2.add(meshCanvas2);
                PlaneBufferGeometry geometry = new PlaneBufferGeometry(100, 100);
                Mesh mesh = new Mesh(geometry, materialPainting);
                Mesh mesh2 = new Mesh(geometry, materialPainting2);
                addPainting(scene, mesh, image, geometry);
                addPainting(scene2, mesh2, image, geometry);
            }

        });


        materialPainting.color = new Color(0xffffff);
        materialPainting.map = texturePainting;

        materialPainting2.color = new Color(0xffccaa);
        materialPainting2.map = texturePainting2;
        texturePainting2.minFilter = texturePainting2.magFilter = THREE.NearestFilter;
        texturePainting.minFilter = texturePainting.magFilter = THREE.LinearFilter;
        texturePainting.mapping = THREE.UVMapping;

        container.appendChild(renderer.domElement);
        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
    }

    private void addLabels() {
        HTMLDivElement lbl_left = (HTMLDivElement) DomGlobal.document.createElement("div");
        lbl_left.className = "lbl";
        lbl_left.innerHTML = "Floor <span class=\"g\">(128x128)</span><br/>\n" +
                "\t\tmag: <span class=\"c\">Linear</span><br/>\n" +
                "\t\tmin: <span class=\"c\">LinearMipMapLinear</span><br/>\n" +
                "\t\t<br/>\n" +
                "\t\tPainting <span class=\"g\">(748x600)</span><br/>\n" +
                "\t\tmag: <span class=\"c\">Linear</span><br/>\n" +
                "\t\tmin: <span class=\"c\">Linear</span>";
        root.appendChild(lbl_left);

        HTMLDivElement lbl_right = (HTMLDivElement) DomGlobal.document.createElement("div");
        lbl_right.className = "lbl";
        lbl_right.id = "lbl_right";
        lbl_right.innerHTML = "Floor <br/>\n" +
                "\t\tmag: <span class=\"c\">Nearest</span><br/>\n" +
                "\t\tmin: <span class=\"c\">Nearest</span><br/>\n" +
                "\t\t<br/>\n" +
                "\t\tPainting <br/>\n" +
                "\t\tmag: <span class=\"c\">Nearest</span><br/>\n" +
                "\t\tmin: <span class=\"c\">Nearest</span>";
        root.appendChild(lbl_right);


    }

    public void onDocumentMouseMove(Event evt) {
        MouseEvent event = (MouseEvent) evt;
        mouse.x = (float) ((event.clientX - (root.clientWidth)));
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
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml("- texture filtering example\n" +
                "\t\t\t- painting by <a style='color:red;' href=\"http://en.wikipedia.org/wiki/Basket_of_Fruit_%28Caravaggio%29\">Caravaggio</a>");
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
        camera.position.y += (-(mouse.y - 200) - camera.position.y) * .05;
        camera.lookAt(scene.position);
        renderer.clear();
        renderer.setScissorTest(true);
        renderer.setScissor(0, 0, (int) (getWidth() / 2 - 2), (int) getHeight());
        renderer.render(scene, camera);
        renderer.setScissor((int) (getWidth()) / 2, 0, (int) (getWidth()) / 2 - 2, (int) getHeight());
        renderer.render(scene2, camera);
        renderer.setScissorTest(false);
    }

    private void addPainting(Scene zscene, Mesh zmesh, ImageData image, PlaneBufferGeometry geometry) {
        zmesh.scale.x = image.width / 100;
        zmesh.scale.y = image.height / 100;
        zscene.add(zmesh);
        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.color = new Color(0x000000);
        Mesh meshFrame = new Mesh(geometry, new MeshBasicMaterial(parameters));
        meshFrame.position.z = -10.0f;
        meshFrame.scale.x = 1.1f * image.width / 100;
        meshFrame.scale.y = 1.1f * image.height / 100;
        zscene.add(meshFrame);

        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(0x000000);
        meshBasicMaterialParameters.opacity = 0.75f;
        meshBasicMaterialParameters.transparent = true;

        Mesh meshShadow = new Mesh(geometry, new MeshBasicMaterial(meshBasicMaterialParameters));
        meshShadow.position.y = -1.1f * image.height / 2;
        meshShadow.position.z = -1.1f * image.height / 2;
        meshShadow.rotation.x = (float) -Math.PI / 2;
        meshShadow.scale.x = 1.1f * image.width / 100;
        meshShadow.scale.y = 1.1f * image.height / 100;
        zscene.add(meshShadow);
        float floorHeight = -1.117f * image.height / 2;
        meshCanvas.position.y = meshCanvas2.position.y = floorHeight;


    }

}






