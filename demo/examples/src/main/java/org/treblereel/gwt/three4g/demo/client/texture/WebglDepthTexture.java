package org.treblereel.gwt.three4g.demo.client.texture;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.lilgui4g.GUIProperty;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.DepthTexture;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Page(path = "webgl_depth_texture")
public class WebglDepthTexture implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private OrbitControls controls;

    private PerspectiveCamera camera;

    private Scene scene;

    private WebGLRenderTarget target;
    private Scene postScene;
    private OrthographicCamera postCamera;
    private ShaderMaterial postMaterial;

    private boolean run, ready;

    private String post_vert = "varying vec2 vUv;\n" +
            "\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvUv = uv;\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);\n" +
            "\t\t\t}";

    private String post_frag = "#include <packing>\n" +
            "\n" +
            "\t\t\tvarying vec2 vUv;\n" +
            "\t\t\tuniform sampler2D tDiffuse;\n" +
            "\t\t\tuniform sampler2D tDepth;\n" +
            "\t\t\tuniform float cameraNear;\n" +
            "\t\t\tuniform float cameraFar;\n" +
            "\n" +
            "\n" +
            "\t\t\tfloat readDepth( sampler2D depthSampler, vec2 coord ) {\n" +
            "\t\t\t\tfloat fragCoordZ = texture2D( depthSampler, coord ).x;\n" +
            "\t\t\t\tfloat viewZ = perspectiveDepthToViewZ( fragCoordZ, cameraNear, cameraFar );\n" +
            "\t\t\t\treturn viewZToOrthographicDepth( viewZ, cameraNear, cameraFar );\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\t//vec3 diffuse = texture2D( tDiffuse, vUv ).rgb;\n" +
            "\t\t\t\tfloat depth = readDepth( tDepth, vUv );\n" +
            "\n" +
            "\t\t\t\tgl_FragColor.rgb = 1.0 - vec3( depth );\n" +
            "\t\t\t\tgl_FragColor.a = 1.0;\n" +
            "\t\t\t}";


    private JsPropertyMap params = JsPropertyMap.of();
    private Map<String, Integer> formats = new HashMap<>();
    private Map<String, Integer> types = new HashMap<>();

    @PostConstruct
    public void init() {

        params.set("format", THREE.DepthFormat);
        params.set("type", THREE.UnsignedShortType);

        formats.put("DepthFormat", THREE.DepthFormat);
        formats.put("DepthStencilFormat", THREE.DepthStencilFormat);

        types.put("UnsignedShortType", THREE.UnsignedShortType);
        types.put("UnsignedIntType", THREE.UnsignedIntType);
        types.put("UnsignedInt248Type", THREE.UnsignedInt248Type);


        renderer = new WebGLRenderer();
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        stats = new Stats();
        root.appendChild(stats.dom);

        camera = new PerspectiveCamera(70, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 0.01, 50);
        camera.position.z = 4;

        controls = new OrbitControls(camera, renderer.domElement);
        controls.enableDamping = true;

        // Create a render target with depth texture
        setupRenderTarget();

        // Our scene
        setupScene();

        // Setup post-processing step
        setupPost();

        onWindowResize();
        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        //
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.setWidth(300);
        GUI gui = new GUI(guiProperty);

        gui.addOption(params, "format", formats).onChange(e -> setupRenderTarget());
        gui.addOption(params, "type", types).onChange(e -> setupRenderTarget());
        gui.open();

        ready = true;

    }

    private void setupRenderTarget() {

        if (target != null) target.dispose();

        int format = Integer.valueOf(params.get("format").toString());
        int type = Integer.valueOf(params.get("type").toString());

        target = new WebGLRenderTarget(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        target.texture.minFilter = THREE.NearestFilter;
        target.texture.magFilter = THREE.NearestFilter;
        target.stencilBuffer = (format == THREE.DepthStencilFormat) ? true : false;
        target.depthTexture = new DepthTexture();
        target.depthTexture.format = format;
        target.depthTexture.type = type;
    }

    private void setupPost() {
        // Setup post processing stage
        postCamera = new OrthographicCamera(-1, 1, 1, -1, 0, 1);

        ShaderMaterialParameters shaderMaterialParameters = ShaderMaterialParameters.create();
        shaderMaterialParameters.setVertexShader(post_vert);
        shaderMaterialParameters.setFragmentShader(post_frag);

        JsPropertyMap uniforms = JsPropertyMap.of();
        addToUniform("cameraNear", camera.near, uniforms);
        addToUniform("cameraFar", camera.far, uniforms);
        addToUniform("tDiffuse", null, uniforms);
        addToUniform("tDepth", null, uniforms);

        shaderMaterialParameters.setUniforms(uniforms);
        postMaterial = new ShaderMaterial(shaderMaterialParameters);

        PlaneGeometry postPlane = new PlaneGeometry(2, 2);
        Mesh postQuad = new Mesh(postPlane, postMaterial);
        postScene = new Scene();
        postScene.add(postQuad);

    }

    private void addToUniform(String name, Object value, JsPropertyMap uniform) {
        JsPropertyMap holder = JsPropertyMap.of();
        holder.set("value", value);
        uniform.set(name, holder);
    }

    private void setupScene() {

        scene = new Scene();

        TorusKnotGeometry geometry = new TorusKnotGeometry(1, 0.3, 128, 64);

        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor("blue");
        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        int count = 50;
        int scale = 5;

        for (int i = 0; i < count; i++) {

            double r = Math.random() * 2.0 * Math.PI;
            double z = (Math.random() * 2.0) - 1.0;
            double zScale = Math.sqrt(1.0 - z * z) * scale;

            Mesh mesh = new Mesh(geometry, material);
            mesh.position.set(
                    Math.cos(r) * zScale,
                    Math.sin(r) * zScale,
                    z * scale
            );
            mesh.rotation.set(Math.random(), Math.random(), Math.random());
            scene.add(mesh);

        }

    }


    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            renderer.setRenderTarget( target );
            renderer.render( scene, camera );

            // render post FX
            addToUniform("tDiffuse", target.texture, postMaterial.uniforms);
            addToUniform("tDepth", target.depthTexture, postMaterial.uniforms);


            WebGLRenderTarget renderTarget = null;
            renderer.setRenderTarget( renderTarget );
            renderer.render( postScene, postCamera );

            controls.update(); // required because damping is enabled

            stats.update();
        }
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> webgl - depth texture<br/>\n" +
                "\t\t\tStores render target depth in a texture attachment.<br/>\n" +
                "\t\t\tCreated by <a href=\"http://twitter.com/mattdesl\" target=\"_blank\" rel=\"noopener\">@mattdesl</a>.\n" +
                "\n" +
                "\t\t\t<div id=\"error\" style=\"display: none;\">\n" +
                "\t\t\tYour browser does not support <strong>WEBGL_depth_texture</strong>.<br/><br/>\n" +
                "\t\t\tThis demo will not work.\n" +
                "\t\t\t</div>";

        run = true;
        animate();
    }

}
