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
import org.treblereel.gwt.three4g.extensions.effects.OutlineEffect;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TextBufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.TextGeometryParameters;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.FontLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshToonMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshToonMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/8/18.
 */
@InjectJavaScriptFor(elements = {OutlineEffect.class})
public class WebglMaterialsVariationsToon extends Attachable {

    public static final String name = "materials / variations / toon";
    private Font font;
    private Mesh particleLight;
    private OutlineEffect effect;

    public WebglMaterialsVariationsToon() {

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
        int cubeWidth = 400;
        int numberOfSphersPerSide = 5;
        float sphereRadius = (cubeWidth / numberOfSphersPerSide) * 0.8f * 0.5f;
        float stepSize = 1.0f / numberOfSphersPerSide;
        int bumpScale = 1;
        SphereBufferGeometry geometry = new SphereBufferGeometry(sphereRadius, 32, 16);
        int alphaIndex = 0;
        for (float alpha = 0; alpha <= 1.0; alpha += stepSize) {
            alphaIndex++;
            double specularShininess = Math.pow(2, alpha * 10);
            for (float beta = 0; beta <= 1.0; beta += stepSize) {
                Color specularColor = new Color(beta * 0.2f, beta * 0.2f, beta * 0.2f);
                for (float gamma = 0; gamma <= 1.0; gamma += stepSize) {
                    Color diffuseColor = new Color().setHSL(alpha, 0.5f, gamma * 0.5f + 0.1f);
                    MeshToonMaterialParameters parameters = new MeshToonMaterialParameters();
                    parameters.color = diffuseColor;
                    parameters.bumpScale = bumpScale;
                    parameters.specular = specularColor;
                    parameters.shininess = (float) specularShininess;
                    parameters.reflectivity = beta;

                    if (alphaIndex % 2 == 0)
                        parameters.envMap = reflectionCube;

                    MeshToonMaterial material = new MeshToonMaterial(parameters);
                    Mesh mesh = new Mesh(geometry, material);
                    mesh.position.x = alpha * 400 - 200;
                    mesh.position.y = beta * 400 - 200;
                    mesh.position.z = gamma * 400 - 200;
                    scene.add(mesh);
                }
            }
        }

        addLabel("-shininess", new Vector3(-350, 0, 0));
        addLabel("+shininess", new Vector3(350, 0, 0));
        addLabel("-specular, -reflectivity", new Vector3(0, -300, 0));
        addLabel("+specular, +reflectivity", new Vector3(0, 300, 0));
        addLabel("-diffuse", new Vector3(0, 0, -300));
        addLabel("+diffuse", new Vector3(0, 0, 300));


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

        effect = new OutlineEffect(renderer);

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
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - - Toon Material Variantions w/ OutlineEffect by <a style='color:orange;' href=\"http://clara.io/\" target=\"_blank\" rel=\"noopener\">Ben Houston</a>.");
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
            effect.render(scene, camera);
        }
    }

}