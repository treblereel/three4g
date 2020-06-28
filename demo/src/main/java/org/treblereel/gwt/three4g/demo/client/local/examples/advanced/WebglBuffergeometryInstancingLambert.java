package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import elemental2.core.Float32Array;
import elemental2.dom.DomGlobal;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferGeometry;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom.TorusKnot;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.renderers.shaders.Shader;
import org.treblereel.gwt.three4g.renderers.shaders.ShaderLib;
import org.treblereel.gwt.three4g.renderers.shaders.UniformsUtils;
import org.treblereel.gwt.three4g.scenes.FogExp2;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/22/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglBuffergeometryInstancingLambert extends Attachable {

    public static final String name = "buffergeometry / instancing / lambert";

    private boolean ANGLE_instanced_arrays = false;

    public WebglBuffergeometryInstancingLambert() {
        loadJavaScript(JavascriptTextResource.IMPL.getCurveExtras().getText());

        scene = new Scene();
        scene.fog = new FogExp2(new Color(0x000000), 0.004f);

        renderer.setClearColor(scene.fog.color, 1);
        camera = new PerspectiveCamera(40, aspect, 1, 1000);
        camera.position.set(80, 40, 80);
        scene.add(camera);

        orbitControls = new OrbitControls(camera, root);
        orbitControls.enableZoom = false;
        orbitControls.maxPolarAngle = (float) Math.PI / 2;

        scene.add(new AmbientLight(0xffffff, 0.7f));
        DirectionalLight light = new DirectionalLight(0xffffff, 0.4f);
        light.position.set(50, 40, 0);
        light.castShadow = true;
        OrthographicCamera orthographicCamera = light.shadow.camera.cast();
        orthographicCamera.left = -40;
        orthographicCamera.right = 40;
        orthographicCamera.top = 40;
        orthographicCamera.bottom = -40;
        orthographicCamera.near = 10;
        orthographicCamera.far = 180;
        light.shadow.bias = -0.001f;
        light.shadow.mapSize.width = 512;
        light.shadow.mapSize.height = 512;
        scene.add(light);

        InstancedBufferGeometry geometry = new InstancedBufferGeometry();
        geometry.copy(new TorusBufferGeometry(2, 0.5f, 8, 128));
        final int INSTANCES = 256;
        TorusKnot knot = new TorusKnot(10);
        Vector3[] positions = knot.getSpacedPoints(INSTANCES);
        Float32Array offsets = new Float32Array(INSTANCES * 3); // xyz
        Float32Array colors = new Float32Array(INSTANCES * 3); // rgb
        Float32Array scales = new Float32Array(INSTANCES * 1); // s
        for (int i = 0, l = INSTANCES; i < l; i++) {
            int index = 3 * i;
            // per-instance position offset
            offsets.setAt(index, (double) positions[i].x);
            offsets.setAt(index + 1, (double) positions[i].y);
            offsets.setAt(index + 2, (double) positions[i].z);
            // per-instance color tint - optional
            colors.setAt(index, 1d);
            colors.setAt(index + 1, 1d);
            colors.setAt(index + 2, 1d);
            // per-instance scale variation
            scales.setAt(i, 1 + 0.5 * Math.sin(32 * Math.PI * i / INSTANCES));
        }
        geometry.addAttribute("instanceOffset", new InstancedBufferAttribute(offsets, 3));
        geometry.addAttribute("instanceColor", new InstancedBufferAttribute(colors, 3));
        geometry.addAttribute("instanceScale", new InstancedBufferAttribute(scales, 1));
        // material
        Texture envMap = new TextureLoader().load("textures/metal.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture texture) {
                texture.mapping = THREE.SphericalReflectionMapping;
                texture.encoding = THREE.sRGBEncoding;
                if (mesh != null) mesh.material.needsUpdate = true;
            }
        });


        MeshLambertMaterialParameters parameters = new MeshLambertMaterialParameters();
        parameters.color = new Color(0xffb54a);
        parameters.envMap = envMap;
        parameters.combine = THREE.MultiplyOperation;
        parameters.reflectivity = 0.8f;
        parameters.vertexColors = THREE.VertexColors;
        parameters.fog = true;

        MeshLambertMaterial material = new MeshLambertMaterial(parameters);

        //material.defines = material.defines || {};
        //material.defines["INSTANCED"] = "";


        // custom depth material - required for instanced shadows
        Shader shader = ShaderLib.depth;


        Uniforms uniforms = UniformsUtils.clone(shader.uniforms);

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        PropertyHolder defines = new PropertyHolder();
        defines.setProperty("INSTANCED", "");
        defines.setProperty("DEPTH_PACKING", THREE.RGBADepthPacking);

        shaderMaterialParameters.defines = defines;
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = shader.vertexShader;
        shaderMaterialParameters.fragmentShader = shader.fragmentShader;


        ShaderMaterial customDepthMaterial = new ShaderMaterial(shaderMaterialParameters);
        //
        mesh = new Mesh(geometry, material);
        mesh.scale.set(1, 1, 2);
        mesh.castShadow = true;
        mesh.receiveShadow = true;
        mesh.customDepthMaterial = customDepthMaterial;
        mesh.frustumCulled = false;
        scene.add(mesh);

        MeshPhongMaterialParameters meshPhongMaterialParameters = new MeshPhongMaterialParameters();
        meshPhongMaterialParameters.color = new Color(0x888888);
        PlaneBufferGeometry planeBufferGeometry = new PlaneBufferGeometry(800, 800).rotateX((float) -Math.PI / 2);
        Mesh ground = new Mesh(planeBufferGeometry, new MeshPhongMaterial(meshPhongMaterialParameters));

        ground.position.set(0, -40, 0);
        ground.receiveShadow = true;
        scene.add(ground);

        //
        if (renderer.extensions.hasProperty("ANGLE_instanced_arrays")) {
            ANGLE_instanced_arrays = false;
        }

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
        renderer.setClearColor(scene.fog.color, 1);
        renderer.shadowMap.enabled = true;
        renderer.gammaOutput = true;

        container.appendChild(renderer.domElement);
    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        String text = " - indexed instancing (single box), dynamic updates";
        if (!ANGLE_instanced_arrays) {
            text = text + "<br><div id=\"notSupported\" style=\"display:none\">Sorry your graphics card + browser does not support hardware instancing</div>";
        }

        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(text);
    }

    private void animate() {
        StatsProducer.getStats().update();
        DomGlobal.requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        mesh.rotation.y += 0.005;
        renderer.render(scene, camera);
    }

}
