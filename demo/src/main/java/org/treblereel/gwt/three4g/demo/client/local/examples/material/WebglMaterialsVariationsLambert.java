package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TextBufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.TextGeometryParameters;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.FontLoader;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/7/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglMaterialsVariationsLambert extends Attachable {

    public static final String name = "materials / variations / lambert";
    private Font font;
    private Mesh particleLight;

    public WebglMaterialsVariationsLambert() {

        FontLoader loader = new FontLoader();
        loader.load("fonts/gentilis_regular.typeface.json", f -> {
            font = f;
            init();
        });
    }

    private void init() {

        camera = new PerspectiveCamera(40, aspect, 1, 2000);
        camera.position.set(0.0f, 400, 400 * 3.5f);
        //
        CubeTexture reflectionCube = new CubeTextureLoader()
                .setPath("textures/cube/SwedishRoyalCastle/")
                .load(new String[]{"px.jpg", "nx.jpg", "py.jpg", "ny.jpg", "pz.jpg", "nz.jpg"});
        reflectionCube.format = THREE.RGBFormat;
        scene = new Scene();
        scene.background = reflectionCube;
        // Materials
        Texture imgTexture = new TextureLoader().load("textures/planets/moon_1024.jpg");
        imgTexture.wrapS = imgTexture.wrapT = THREE.RepeatWrapping;
        imgTexture.anisotropy = 16;
        imgTexture = null;
        int cubeWidth = 400;
        int numberOfSphersPerSide = 5;
        float sphereRadius = (cubeWidth / numberOfSphersPerSide) * 0.8f * 0.5f;
        float stepSize = 1.0f / numberOfSphersPerSide;
        SphereBufferGeometry geometry = new SphereBufferGeometry(sphereRadius, 32, 16);
        for (float alpha = 0; alpha <= 1.0; alpha += stepSize) {
            for (float beta = 0; beta <= 1.0; beta += stepSize) {
                for (float gamma = 0; gamma <= 1.0; gamma += stepSize) {
                    Color diffuseColor = new Color().setHSL(alpha, 0.5f, gamma * 0.5f + 0.1f);
                    MeshLambertMaterialParameters parameters = new MeshLambertMaterialParameters();
                    parameters.map = imgTexture;
                    parameters.color = diffuseColor;
                    parameters.reflectivity = beta;
                    parameters.envMap = alpha < 0.5 ? reflectionCube : null;

                    MeshLambertMaterial material = new MeshLambertMaterial(parameters);
                    Mesh mesh = new Mesh(geometry, material);
                    mesh.position.x = alpha * 400 - 200;
                    mesh.position.y = beta * 400 - 200;
                    mesh.position.z = gamma * 400 - 200;
                    scene.add(mesh);
                }
            }
        }

        addLabel("+hue", new Vector3(-350, 0, 0));
        addLabel("-hue", new Vector3(350, 0, 0));
        addLabel("-reflectivity", new Vector3(0, -300, 0));
        addLabel("+reflectivity", new Vector3(0, 300, 0));
        addLabel("-diffuse", new Vector3(0, 0, -300));
        addLabel("+diffuse", new Vector3(0, 0, 300));
        addLabel("envMap", new Vector3(-350, 300, 0));
        addLabel("no envMap", new Vector3(350, 300, 0));

        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(0xffffff);
        particleLight = new Mesh(new SphereBufferGeometry(4, 8, 8), new MeshBasicMaterial(meshBasicMaterialParameters));
        scene.add(particleLight);
        // Lights
        scene.add(new AmbientLight(0x222222));
        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 1);
        directionalLight.position.set(1, 1, 1).normalize();
        scene.add(directionalLight);
        PointLight pointLight = new PointLight(0xffffff, 2, 800);
        particleLight.add(pointLight);

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.shadowMap.enabled = true;
        setupWebGLRenderer(renderer);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;

        orbitControls = new OrbitControls(camera, renderer.domElement);

        container.appendChild(renderer.domElement);
    }

    private void addLabel(String name, Vector3 location) {
        TextGeometryParameters textGeometryParameters = new TextGeometryParameters();
        textGeometryParameters.font = font;
        textGeometryParameters.size = 20;
        textGeometryParameters.height = 1;
        textGeometryParameters.curveSegments = 1;

        TextBufferGeometry textGeo = new TextBufferGeometry(name, textGeometryParameters);
        MeshBasicMaterial textMaterial = new MeshBasicMaterial();
        textMaterial.color = new Color(0xffffff);
        Mesh textMesh = new Mesh(textGeo, textMaterial);
        textMesh.position.copy(location);
        scene.add(textMesh);
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - Lambert Material Variantions by <a style='color:orange;' href=\"http://clara.io/\" target=\"_blank\" rel=\"noopener\">Ben Houston</a>.");
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
        if (camera != null && scene != null) {
            double timer = new Date().getTime() * 0.00025;
            camera.lookAt(scene.position);
            particleLight.position.x = (float) Math.sin(timer * 7) * 300;
            particleLight.position.y = (float) Math.cos(timer * 5) * 400;
            particleLight.position.z = (float) Math.cos(timer * 3) * 300;
            renderer.render(scene, camera);
        }
    }

}
