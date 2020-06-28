package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.materials.MeshDepthMaterial;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshDepthMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshNormalMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/26/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, OBJLoader.class})
public class WebglMaterialsChannels extends Attachable {

    public static final String name = "materials / channels";
    private MeshNormalMaterial materialNormal;
    private MeshDepthMaterial materialDepthRGBA, materialDepthBasic;
    private MeshStandardMaterial materialStandard;
    private OrbitControls controlsPerspective, controlsOrtho;
    private PerspectiveCamera cameraPerspective;
    private OrthographicCamera cameraOrtho;
    private Camera thisCamera;


    private PointLight pointLight, pointLight2;
    private AmbientLight ambientLight;
    private int height = 500; // of camera frustum
    private float SCALE = 2.436143f; // from original model
    private float BIAS = -0.428408f; // from original model

    public WebglMaterialsChannels() {
        scene = new Scene();

        cameraPerspective = new PerspectiveCamera(45, aspect, 1000, 2500);
        cameraPerspective.position.z = 1500;
        scene.add(cameraPerspective);

        cameraOrtho = new OrthographicCamera(-height * aspect, height * aspect, height, -height, 1000, 2500);
        cameraOrtho.position.z = 1500;
        scene.add(cameraOrtho);

        controlsPerspective = new OrbitControls(cameraPerspective, container);
        controlsPerspective.minDistance = 1000;
        controlsPerspective.maxDistance = 2500;
        controlsPerspective.enablePan = false;
        controlsPerspective.enableDamping = true;

        controlsOrtho = new OrbitControls(cameraOrtho, container);
        controlsOrtho.minZoom = 0.5f;
        controlsOrtho.maxZoom = 2;
        controlsOrtho.enablePan = false;
        controlsOrtho.enableDamping = true;
        // lights

        ambientLight = new AmbientLight(0xffffff, 0.1f);
        scene.add(ambientLight);
        pointLight = new PointLight(0xff0000, 0.5f);
        pointLight.position.z = 2500;
        scene.add(pointLight);
        pointLight2 = new PointLight(0xff6666, 1);

        PointLight pointLight3 = new PointLight(0x0000ff, 0.5f);
        pointLight3.position.x = -1000;
        pointLight3.position.z = 1000;
        scene.add(pointLight3);

        // textures
        TextureLoader textureLoader = new TextureLoader();
        Texture normalMap = textureLoader.load("models/obj/ninja/normal.jpg");
        Texture aoMap = textureLoader.load("models/obj/ninja/ao.jpg");
        Texture displacementMap = textureLoader.load("models/obj/ninja/displacement.jpg");
        // material
        MeshStandardMaterialParameters meshStandardMaterialParameters = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters.color = new Color(0xffffff);
        meshStandardMaterialParameters.metalness = 0.5f;
        meshStandardMaterialParameters.roughness = 0.6f;
        meshStandardMaterialParameters.displacementMap = displacementMap;
        meshStandardMaterialParameters.displacementScale = SCALE;
        meshStandardMaterialParameters.displacementBias = BIAS;
        meshStandardMaterialParameters.aoMap = aoMap;
        meshStandardMaterialParameters.normalMap = normalMap;
        meshStandardMaterialParameters.normalScale = new Vector2(1, -1);
        meshStandardMaterialParameters.side = THREE.DoubleSide;
        materialStandard = new MeshStandardMaterial(meshStandardMaterialParameters);

        MeshDepthMaterialParameters meshDepthMaterialParameters = new MeshDepthMaterialParameters();
        meshDepthMaterialParameters.depthPacking = THREE.RGBADepthPacking;
        meshDepthMaterialParameters.displacementMap = displacementMap;
        meshDepthMaterialParameters.displacementScale = SCALE;
        meshDepthMaterialParameters.displacementBias = BIAS;
        meshDepthMaterialParameters.side = THREE.DoubleSide;
        materialDepthRGBA = new MeshDepthMaterial(meshDepthMaterialParameters);

        MeshNormalMaterialParameters meshNormalMaterialParameters = new MeshNormalMaterialParameters();
        meshNormalMaterialParameters.displacementMap = displacementMap;
        meshNormalMaterialParameters.displacementBias = BIAS;
        meshNormalMaterialParameters.displacementScale = SCALE;
        meshNormalMaterialParameters.normalMap = normalMap;
        meshNormalMaterialParameters.normalScale = new Vector2(1, -1);
        meshNormalMaterialParameters.side = THREE.DoubleSide;
        materialNormal = new MeshNormalMaterial(meshNormalMaterialParameters);

        MeshDepthMaterialParameters meshDepthMaterialParameters1 = new MeshDepthMaterialParameters();
        meshDepthMaterialParameters1.depthPacking = THREE.BasicDepthPacking;
        meshDepthMaterialParameters1.displacementMap = displacementMap;
        meshDepthMaterialParameters1.displacementScale = SCALE;
        meshDepthMaterialParameters1.displacementBias = BIAS;
        meshDepthMaterialParameters1.side = THREE.DoubleSide;
        materialDepthBasic = new MeshDepthMaterial(meshDepthMaterialParameters1);


        //
        OBJLoader loader = new OBJLoader();
        loader.load("models/obj/ninja/ninjaHead_Low.obj", new OnLoadCallback<Object3D>() {
            @Override
            public void onLoad(Object3D object) {
                Group group = object.cast();
                Mesh mmesh = group.children[0].cast();

                BufferGeometry geometry = mmesh.geometry.cast();
                geometry.attributes.setProperty("uv2", geometry.attributes.uv);
                geometry.center();
                mesh = new Mesh(geometry, materialNormal);
                mesh.scale.multiplyScalar(25);
                scene.add(mesh);
            }
        });


        renderer = new WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);
        //
        container.appendChild(renderer.domElement);
        thisCamera = cameraPerspective;
        initGui();
    }

    private String c_material = "standard";
    private String c_side = "front";

    public void initGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;
        gui = new GUI(guiProperty);
        String[] materials = new String[]{"standard", "normal", "depthBasic", "depthRGBA"};
        String[] cameras = new String[]{"perspective", "ortho"};
        String[] sides = new String[]{"front", "back", "double"};


        gui.add("material", materials, "standard").onChange(result -> {
            c_material = result.toString();
        });

        gui.add("camera", cameras, "perspective").onChange(result -> {
            if (result.toString().equals("perspective")) {
                thisCamera = cameraPerspective;
            } else {
                thisCamera = cameraOrtho;
            }
        });

        gui.add("side", sides, "front").onChange(result -> {
            GWT.log("onChange side " + result.toString());
            c_side = result.toString();
        });

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    public void onWindowResize() {
        if (root.parentNode != null && thisCamera != null) {
            if (thisCamera.getType().equals("PerspectiveCamera")) {
                ((PerspectiveCamera) thisCamera).aspect = new Float(getWidth() / getHeight());
                ((PerspectiveCamera) thisCamera).updateProjectionMatrix();
            } else {
                OrthographicCamera cam = thisCamera.cast();
                cam.left = -height * aspect;
                cam.right = height * aspect;
                cam.top = height;
                cam.bottom = -height;
                cam.updateProjectionMatrix();
            }
            renderer.setSize(getWidth(), getHeight());
        }
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - <span id=\"description\">Normal; Depth; DepthRGBA; DepthRGBAUnpacked; Materials</span> by <a href=\"https=//Clara.io\">Ben Houston</a>.<br />\n" +
                "\t\t\tninja head from <a href=\"http=//developer.amd.com/tools-and-sdks/archive/legacy-cpu-gpu-tools/amd-gpu-meshmapper/\" target=\"_blank\" rel=\"noopener\">AMD GPU MeshMapper</a>\n" +
                "\n" +
                "\t\t\t<div id=\"vt\">displacement mapping requires vertex textures</div>");


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
        if (mesh != null) {
            Material material = mesh.material;

            switch (c_material) {
                case "standard":
                    material = materialStandard;
                    break;
                case "depthBasic":
                    material = materialDepthBasic;
                    break;
                case "depthRGBA":
                    material = materialDepthRGBA;
                    break;
                case "normal":
                    material = materialNormal;
                    break;
            }
            mesh.material = material;


            if (!c_side.equals(material.side)) {
                switch (c_side) {
                    case "front":
                        material.side = THREE.FrontSide;
                        break;
                    case "back":
                        material.side = THREE.BackSide;
                        break;
                    case "double":
                        material.side = THREE.DoubleSide;
                        break;
                }
                material.needsUpdate = true;
            }
        }

        renderer.render(scene, thisCamera);
    }

}

