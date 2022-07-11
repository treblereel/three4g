package org.treblereel.gwt.three4g.demo.client.geometries;


import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.bufferattribute.Float32BufferAttribute;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.BufferGeometryLoader;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.materials.SpriteMaterial;
import org.treblereel.gwt.three4g.materials.SpriteMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Lut;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Sprite;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_colors_lookuptable")
public class WebglGeometryColorsLookuptable implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private Scene scene;

    private boolean run, ready;

    private Scene uiScene;

    private PerspectiveCamera perpCamera;

    private OrthographicCamera orthoCamera;

    private Lut lut;

    private Sprite sprite;
    private Mesh mesh;

    private JsPropertyMap params = JsPropertyMap.of();

    private GUI gui;


    @PostConstruct
    public void init() {

        scene = new Scene();
        scene.setBackground(new Color(0xffffff));

        uiScene = new Scene();

        lut = new Lut();

        double width = DomGlobal.window.innerWidth;
        double height = DomGlobal.window.innerHeight;

        perpCamera = new PerspectiveCamera(60, width / height, 1, 100);
        perpCamera.position.set(0, 0, 10);
        scene.add(perpCamera);

        orthoCamera = new OrthographicCamera(-1, 1, 1, -1, 1, 2);
        orthoCamera.position.set(0.5, 0, 1);


        SpriteMaterialParameters spriteMaterialParameters = SpriteMaterialParameters.create();
        spriteMaterialParameters.setMap(new CanvasTexture(lut.createCanvas()));


        sprite = new Sprite(new SpriteMaterial(spriteMaterialParameters));
        sprite.scale.x = 0.125;
        uiScene.add(sprite);

        MeshLambertMaterialParameters meshLambertMaterialParameters = MeshLambertMaterialParameters.create();
        meshLambertMaterialParameters.setSide(THREE.DoubleSide);
        meshLambertMaterialParameters.setColor(0xF5F5F5);
        meshLambertMaterialParameters.setVertexColors(true);

        mesh = new Mesh((BufferGeometry) Js.undefined(), new MeshLambertMaterial(meshLambertMaterialParameters));
        scene.add(mesh);

        params.set("colorMap", "rainbow");

        loadModel();

        PointLight pointLight = new PointLight(0xffffff, 1);
        perpCamera.add(pointLight);


        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);


        renderer.autoClear = false;
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(width, height);
        root.appendChild(renderer.domElement);

        OrbitControls controls = new OrbitControls(perpCamera, renderer.domElement);
        controls.addEventListener("change", event -> render());

        gui = new GUI();

        gui.addOption(params, "colorMap", new String[]{"rainbow", "cooltowarm", "blackbody", "grayscale"}).onChange(e -> {

            updateColors();
            render();

        });

        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    private void loadModel() {
        BufferGeometryLoader loader = new BufferGeometryLoader();

        loader.load("models/json/pressure.json", geometry -> {

            geometry.center();
            geometry.computeVertexNormals();

            // default color attribute
            JsArray colors = new JsArray();

            for (int i = 0, n = geometry.attributes.get("position").asBufferAttribute().count; i < n; ++i) {

                colors.push(1, 1, 1);

            }

            geometry.setAttribute("color", new Float32BufferAttribute(colors, 3));

            mesh.geometry = geometry;
            updateColors();

            render();

        });
    }

    private void updateColors() {

        lut.setColorMap(params.get("colorMap").toString());

        lut.setMax(2000);
        lut.setMin(0);

        BufferGeometry geometry = mesh.geometry;
        BufferAttribute pressures = geometry.attributes.get("pressure").asBufferAttribute();
        BufferAttribute colors = geometry.attributes.get("color").asBufferAttribute();

        for (int i = 0; i < pressures.array.length; i++) {

            double colorValue = pressures.array.getAt(i);

            Color color = lut.getColor(colorValue);

            if (color == null) {

                DomGlobal.console.log("Unable to determine color for value:", colorValue);

            } else {

                colors.setXYZ(i, color.r, color.g, color.b);

            }

        }

        colors.needsUpdate = true;

        Texture map = sprite.material.map;
        lut.updateCanvas(map.image);
        map.needsUpdate = true;
    }

    private void render() {
        if (run && ready) {

            renderer.clear();
            renderer.render(scene, perpCamera);
            renderer.render(uiScene, orthoCamera);
        }
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        double width = DomGlobal.window.innerWidth;
        double height = DomGlobal.window.innerHeight;

        perpCamera.aspect = width / height;
        perpCamera.updateProjectionMatrix();

        renderer.setSize(width, height);
        render();
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
        gui.hide();
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a>webgl - lookup table";

        run = true;
    }
}

