package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.datgui4g.OnChange;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.events.Event;
import org.treblereel.gwt.three4g.core.events.EventListener;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/12/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglGeometryTeapot extends Attachable {


    public static final String name = "geometry / teapot";
    private int teapotSize = 400;
    private AmbientLight ambientLight;
    private DirectionalLight light;
    private double tess = -1;    // force initialization
    private boolean bBottom;
    private boolean bLid;
    private boolean bBody;
    private boolean bFitLid;
    private boolean bNonBlinn;

    private float shininess = 40.0f;
    private float ka = 0.17f;
    private float kd = 0.51f;
    private float ks = 0.2f;
    private boolean metallic = true;
    private float hue = 0.121f;
    private float saturation = 0.73f;
    private float lightness = 0.66f;
    private float lhue = 0.04f;
    private float lsaturation = 0.01f;    // non-zero so that fractions will be shown
    private float llightness = 1.0f;
    // bizarrely, if you initialize these with negative numbers, the sliders
    // will not show any decimal places.
    private float lx = 0.32f;
    private float ly = 0.39f;
    private float lz = 0.7f;
    private double newTess = 15;
    private boolean bottom = true;
    private boolean lid = true;
    private boolean body = true;
    private boolean fitLid = false;
    private boolean nonblinn = false;
    private String shading, newShading = "glossy";

    private MeshBasicMaterial wireMaterial;
    private MeshPhongMaterial flatMaterial;
    private MeshLambertMaterial gouraudMaterial;
    private MeshPhongMaterial phongMaterial;
    private MeshPhongMaterial texturedMaterial;

    private MeshPhongMaterial reflectiveMaterial;
    private Mesh teapot, textureCube;
    // allocate these just once
    private Color diffuseColor = new Color();
    private Color specularColor = new Color();

    public WebglGeometryTeapot() {
        loadJavaScript(JavascriptTextResource.IMPL.getTeapotBufferGeometry().getText());

        camera = new PerspectiveCamera(45, aspect, 1, 80000);
        camera.position.set(-600, 550, 1300);
        // LIGHTS
        ambientLight = new AmbientLight(0x333333);
        light = new DirectionalLight(0xFFFFFF, 1.0f);
        // direction is set in GUI
        // RENDERER
        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        // EVENTS
        // CONTROLS
        orbitControls = new OrbitControls(camera, root);
        orbitControls.addEventListener("change", new EventListener() {
            @Override
            public void call(Event event) {
                render();
            }
        });
        // TEXTURE MAP
        Texture textureMap = new TextureLoader().load("textures/UV_Grid_Sm.jpg");
        textureMap.wrapS = textureMap.wrapT = THREE.RepeatWrapping;
        textureMap.anisotropy = 16;
        // REFLECTION MAP
        String path = "textures/cube/skybox/";

        String[] urls = new String[]{
                path + "px.jpg", path + "nx.jpg",
                path + "py.jpg", path + "ny.jpg",
                path + "pz.jpg", path + "nz.jpg"
        };
        CubeTexture textureCube = new CubeTextureLoader().load(urls);
        // MATERIALS
        Color materialColor = new Color();
        materialColor.setRGB(1.0f, 1.0f, 1.0f);
        wireMaterial = new MeshBasicMaterial();
        wireMaterial.color = new Color(0xFFFFFF);
        wireMaterial.wireframe = true;

        flatMaterial = new MeshPhongMaterial();
        flatMaterial.color = materialColor;
        flatMaterial.specular = new Color(0x000000);
        flatMaterial.flatShading = true;
        flatMaterial.side = THREE.DoubleSide;

        gouraudMaterial = new MeshLambertMaterial();
        gouraudMaterial.color = materialColor;
        gouraudMaterial.side = THREE.DoubleSide;


        phongMaterial = new MeshPhongMaterial();
        phongMaterial.color = materialColor;
        phongMaterial.side = THREE.DoubleSide;

        texturedMaterial = new MeshPhongMaterial();
        texturedMaterial.map = textureMap;
        texturedMaterial.color = materialColor;
        texturedMaterial.side = THREE.DoubleSide;

        reflectiveMaterial = new MeshPhongMaterial();
        reflectiveMaterial.envMap = textureCube;
        reflectiveMaterial.color = materialColor;
        reflectiveMaterial.side = THREE.DoubleSide;


        // scene itself
        scene = new Scene();
        scene.background = new Color(0xAAAAAA);
        scene.add(ambientLight);
        scene.add(light);
        // GUI
        setupGui();


        //
    }

    private void setupGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        gui.addFolder("Material control").add("shininess", shininess, 1.0, 400.0).setStep(1.0).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                shininess = result.floatValue();
                render();
            }
        }).done().add("diffuse strength", kd, 1.0, 10.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                kd = result.floatValue();
                render();
            }
        }).done().add("specular strength", ks, 1.0, 10.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                ks = result.floatValue();
                render();
            }
        }).done().add("metallic", metallic).onChange(new OnChange<Boolean>() {
            @Override
            public void onChange(Boolean result) {
                metallic = result;
                render();
            }
        });

        gui.addFolder("Material color").add("hue", hue, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                hue = result.floatValue();
                render();
            }
        }).done().add("saturation", saturation, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                saturation = result.floatValue();
                render();
            }
        }).done().add("lightness", lightness, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lightness = result.floatValue();
                render();
            }
        }).done();

        gui.addFolder("Lighting").add("hue", lhue, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lhue = result.floatValue();
                render();
            }
        }).done().add("saturation", lsaturation, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lsaturation = result.floatValue();
                render();
            }
        }).done().add("lightness", llightness, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                llightness = result.floatValue();
                render();
            }
        }).done().add("ambient", ka, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                ka = result.floatValue();
                render();
            }
        }).done();

        gui.addFolder("Lighting").add("hue", lhue, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lhue = result.floatValue();
                render();
            }
        }).done().add("saturation", lsaturation, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lsaturation = result.floatValue();
                render();
            }
        }).done().add("lightness", llightness, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                llightness = result.floatValue();
                render();
            }
        }).done().add("ambient", ka, 0.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                ka = result.floatValue();
                render();
            }
        }).done();

        gui.addFolder("Light direction").add("x", lx, -1.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lhue = result.floatValue();
                render();
            }
        }).done().add("y", ly, -1.0, 1.0).setStep(0.025).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                lsaturation = result.floatValue();
                render();
            }
        }).done().add("z", lz, -1.0, 1.0).setStep(0.025).onChange(result -> {
            llightness = result.floatValue();
            render();
        }).done();

        gui.addFolder("Tessellation control").add("Tessellation Level", new String[]{"2", "3", "4", "5", "6", "8", "10", "15", "20", "30", "40", "50"}, "50").onChange(new OnChange() {
            @Override
            public void onChange(Object result) {
                newTess = Double.valueOf(result.toString());
                render();
            }
        }).done().add("display lid", lid).onChange(new OnChange<Boolean>() {
            @Override
            public void onChange(Boolean result) {
                lid = result;
                render();
            }
        }).done().add("display body", body).onChange(new OnChange<Boolean>() {
            @Override
            public void onChange(Boolean result) {
                body = result;
                render();
            }
        }).done().add("display bottom", bottom).onChange(new OnChange<Boolean>() {
            @Override
            public void onChange(Boolean result) {
                bottom = result;
                render();
            }
        }).done().add("snug lid", fitLid).onChange(new OnChange<Boolean>() {
            @Override
            public void onChange(Boolean result) {
                fitLid = result;
                render();
            }
        }).done().add("original scale", nonblinn).onChange(new OnChange<Boolean>() {
            @Override
            public void onChange(Boolean result) {
                nonblinn = result;
                render();
            }
        }).done();

        gui.add("Shading", new String[]{"wireframe", "flat", "smooth", "glossy", "textured", "reflective"}, "glossy").onChange(new OnChange() {
            @Override
            public void onChange(Object result) {
                newShading = result.toString();
                render();
            }
        }).done();

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());

    }

    private void render() {
        if (newTess != tess || bottom != bBottom || lid != bLid || body != bBody || fitLid != bFitLid ||
                nonblinn != bNonBlinn || !newShading.equals(shading)) {
            tess = newTess;
            bBottom = bottom;
            bLid = lid;
            bBody = body;
            bFitLid = fitLid;
            bNonBlinn = nonblinn;
            shading = newShading;
            createNewTeapot();
        }
        // We're a bit lazy here. We could check to see if any material attributes changed and update
        // only if they have. But, these calls are cheap enough and this is just a demo.
        phongMaterial.shininess = shininess;
        texturedMaterial.shininess = shininess;
        diffuseColor.setHSL(hue, saturation, lightness);
        if (metallic) {
            // make colors match to give a more metallic look
            specularColor.copy(diffuseColor);
        } else {
            // more of a plastic look
            specularColor.setRGB(1, 1, 1);
        }
        diffuseColor.multiplyScalar(kd);
        flatMaterial.color.copy(diffuseColor);
        gouraudMaterial.color.copy(diffuseColor);
        phongMaterial.color.copy(diffuseColor);
        texturedMaterial.color.copy(diffuseColor);
        specularColor.multiplyScalar(ks);
        phongMaterial.specular.copy(specularColor);
        texturedMaterial.specular.copy(specularColor);
        // Ambient's actually controlled by the light for this demo
        ambientLight.color.setHSL(hue, saturation, lightness * ka);
        light.position.set(lx, ly, lz);
        light.color.setHSL(lhue, lsaturation, llightness);
        // skybox is rendered separately, so that it is always behind the teapot.
        if (shading.equals("reflective")) {
            scene.background = textureCube;
        } else {
            scene.background = null;
        }
        renderer.render(scene, camera);
    }

    public void createNewTeapot() {
        if (teapot != null) {
            teapot.geometry.dispose();
            scene.remove(teapot);
        }
        TeapotBufferGeometry teapotGeometry = new TeapotBufferGeometry(teapotSize,
                tess,
                bottom,
                lid,
                body,
                fitLid,
                !nonblinn);
        Material material = null;

        if (shading.equals("wireframe")) {
            material = wireMaterial;
        } else if (shading.equals("flat")) {
            material = flatMaterial;
        } else if (shading.equals("smooth")) {
            material = gouraudMaterial;
        } else if (shading.equals("glossy")) {
            material = phongMaterial;
        } else if (shading.equals("textured")) {
            material = texturedMaterial;
        } else {
            material = reflectiveMaterial;
        }

        teapot = new Mesh(teapotGeometry, material);
        scene.add(teapot);
    }

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        render();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  the Utah Teapot<br />\n" +
                "\t\t\tfrom <a style=\"color:white;\" href=\"https://www.udacity.com/course/interactive-3d-graphics--cs291\">Udacity Interactive 3D Graphics</a>");
    }

}

