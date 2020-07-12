package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.shaders.Shader;
import org.treblereel.gwt.three4g.renderers.shaders.ShaderLib;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/31/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglMaterialsEnvmaps extends Attachable {

    public static final String name = "materials / envmaps";
    private PerspectiveCamera cameraCube;
    private Scene sceneCube;

    private CubeTexture textureCube;
    private Texture textureEquirec, textureSphere;
    private Mesh cubeMesh, sphereMesh;
    private MeshLambertMaterial sphereMaterial;
    private ShaderMaterial cubeMaterial;
    private ShaderMaterial equirectMaterial;


    public WebglMaterialsEnvmaps() {

        camera = new PerspectiveCamera(70, aspect, 1, 100000);
        camera.position.set(0, 0, 1000);
        cameraCube = new PerspectiveCamera(70, aspect, 1, 100000);
        orbitControls = new OrbitControls(camera, root);
        orbitControls.minDistance = 500;
        orbitControls.maxDistance = 2500;
        // SCENE
        scene = new Scene();
        sceneCube = new Scene();
        // Lights
        AmbientLight ambient = new AmbientLight(0xffffff);
        scene.add(ambient);
        // Textures
        String r = "textures/cube/Bridge2/";
        String[] urls = new String[]{r + "posx.jpg", r + "negx.jpg",
                r + "posy.jpg", r + "negy.jpg",
                r + "posz.jpg", r + "negz.jpg"};

        textureCube = new CubeTextureLoader().load(urls);
        textureCube.format = THREE.RGBFormat;
        textureCube.mapping = THREE.CubeReflectionMapping;
        TextureLoader textureLoader = new TextureLoader();
        textureEquirec = textureLoader.load("textures/2294472375_24a3b8ef46_o.jpg");
        textureEquirec.mapping = THREE.EquirectangularReflectionMapping;
        textureEquirec.magFilter = THREE.LinearFilter;
        textureEquirec.minFilter = THREE.LinearMipmapLinearFilter;
        textureSphere = textureLoader.load("textures/metal.jpg");
        textureSphere.mapping = THREE.SphericalReflectionMapping;

        // Materials
        Shader equirectShader = ShaderLib.equirect;

        ShaderMaterialParameters parameters = new ShaderMaterialParameters();
        parameters.fragmentShader = equirectShader.fragmentShader;
        parameters.vertexShader = equirectShader.vertexShader;
        parameters.uniforms = equirectShader.uniforms;
        parameters.depthWrite = false;
        parameters.side = THREE.BackSide;

        equirectMaterial = new ShaderMaterial(parameters);
        equirectMaterial.uniforms.set("tEquirect", textureEquirec);

        Shader cubeShader = ShaderLib.cube;

        parameters = new ShaderMaterialParameters();
        parameters.fragmentShader = cubeShader.fragmentShader;
        parameters.vertexShader = cubeShader.vertexShader;
        parameters.uniforms = cubeShader.uniforms;
        parameters.depthWrite = false;
        parameters.side = THREE.BackSide;

        cubeMaterial = new ShaderMaterial(parameters);
        cubeMaterial.uniforms.set("tCube", textureCube);

        // Skybox
        cubeMesh = new Mesh(new BoxBufferGeometry(100, 100, 100), cubeMaterial);
        sceneCube.add(cubeMesh);
        //
        SphereBufferGeometry geometry = new SphereBufferGeometry(400.0f, 48, 24);
        sphereMaterial = new MeshLambertMaterial();
        sphereMaterial.envMap = textureCube;
        sphereMesh = new Mesh(geometry, sphereMaterial);
        scene.add(sphereMesh);

        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
        renderer.autoClear = false;
        initGui();
    }

    private void initGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        gui.add("Cube", () -> {
            cubeMesh.material = cubeMaterial;
            cubeMesh.visible = true;
            sphereMaterial.envMap = textureCube;
            sphereMaterial.needsUpdate = true;
        });

        gui.add("Equirectangular", () -> {
            cubeMesh.material = equirectMaterial;
            cubeMesh.visible = true;
            sphereMaterial.envMap = textureEquirec.cast();
            sphereMaterial.needsUpdate = true;
        });

        gui.add("Spherical", () -> {
            cubeMesh.visible = false;
            sphereMaterial.envMap = textureSphere.cast();
            sphereMaterial.needsUpdate = true;
        });

        gui.add("Refraction", false).onChange(value -> {
            if (value) {
                textureEquirec.mapping = THREE.EquirectangularRefractionMapping;
                textureCube.mapping = THREE.CubeRefractionMapping;
            } else {
                textureEquirec.mapping = THREE.EquirectangularReflectionMapping;
                textureCube.mapping = THREE.CubeReflectionMapping;
            }
            sphereMaterial.needsUpdate = true;
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
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - webgl environment mapping example<br/>\n" +
                "\t\t\tEquirectangular Map by <a style='color:orange;' href=\"http://gl.ict.usc.edu/Data/HighResProbes/\">University of Southern California</a><br/>\n" +
                "\t\t\tSpherical Map by <a style='color:orange;' href=\"http://www.pauldebevec.com/Probes/\">Paul Debevec</a>");
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
        camera.lookAt(scene.position);
        cameraCube.rotation.copy(camera.rotation);
        renderer.render(sceneCube, cameraCube);
        renderer.render(scene, camera);
    }

}
