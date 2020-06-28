package org.treblereel.gwt.three4g.demo.client.local.examples.lights;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.datgui4g.OnChange;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglLightsPhysical extends Attachable {

    public static final String name = "lights / physical";

    private Clock clock = new Clock();
    private HemisphereLight hemiLight;

    private PointLight bulbLight;
    private MeshStandardMaterial bulbMat;
    private MeshStandardMaterial cubeMat;
    private MeshStandardMaterial ballMat;
    private MeshStandardMaterial floorMat;

    private Map<String, Integer> bulbLuminousPowers = new HashMap<String, Integer>() {{
        put("110000 lm (1000W)", 110000);
        put("3500 lm (300W)", 3500);
        put("1700 lm (100W)", 1700);
        put("800 lm (60W)", 800);
        put("400 lm (40W)", 400);
        put("180 lm (25W)", 180);
        put("20 lm (4W)", 20);
        put("Off", 0);

    }};

    private Map<String, Float> hemiLuminousIrradiances = new HashMap<String, Float>() {{
        put("0.0001 lx (Moonless Night)", 0.0001f);
        put("0.002 lx (Night Airglow)", 0.002f);
        put("0.5 lx (Full Moon)", 0.5f);
        put("3.4 lx (City Twilight)", 3.4f);
        put("50 lx (Living Room)", 50f);
        put("100 lx (Very Overcast)", 100f);
        put("350 lx (Office Room)", 350f);
        put("400 lx (Sunrise/Sunset)", 400f);
        put("1000 lx (Overcast)", 1000f);
        put("18000 lx (Daylight)", 18000f);
        put("50000 lx (Direct Sun)", 50000f);
    }};

    private boolean shadows = true;
    private boolean previousShadowMap = false;
    private double exposure = 0.68d;
    private String bulbPower = "400 lm (40W)";
    private String hemiIrradiance = "0.0001 lx (Moonless Night)";


    public WebglLightsPhysical() {

        camera = new PerspectiveCamera(50, aspect, 0.1f, 100);
        camera.position.x = -4;
        camera.position.z = 4;
        camera.position.y = 2;

        scene = new Scene();
        SphereBufferGeometry bulbGeometry = new SphereBufferGeometry(0.02f, 16, 8);
        bulbLight = new PointLight(0xffee88, 1, 100, 2);
        MeshStandardMaterialParameters meshStandardMaterialParameters = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters.emissive = new Color(0xffffee);
        meshStandardMaterialParameters.emissiveIntensity = 1;
        meshStandardMaterialParameters.color = new Color(0x000000);
        bulbMat = new MeshStandardMaterial(meshStandardMaterialParameters);
        bulbLight.add(new Mesh(bulbGeometry, bulbMat));
        bulbLight.position.set(0, 2, 0);
        bulbLight.castShadow = true;
        scene.add(bulbLight);
        hemiLight = new HemisphereLight(0xddeeff, 0x0f0e0d, 0.02f);
        scene.add(hemiLight);

        MeshStandardMaterialParameters meshStandardMaterialParameters1 = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters1.roughness = 0.8f;
        meshStandardMaterialParameters1.metalness = 0.2f;
        meshStandardMaterialParameters1.bumpScale = 0.0005f;
        meshStandardMaterialParameters.color = new Color(0xffffff);

        floorMat = new MeshStandardMaterial(meshStandardMaterialParameters1);

        TextureLoader textureLoader = new TextureLoader();
        textureLoader.load("textures/hardwood2_diffuse.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.wrapS = THREE.RepeatWrapping;
                map.wrapT = THREE.RepeatWrapping;
                map.anisotropy = 4;
                map.repeat.set(10, 24);
                floorMat.map = map;
                floorMat.needsUpdate = true;
            }
        });


        textureLoader.load("textures/hardwood2_bump.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.wrapS = THREE.RepeatWrapping;
                map.wrapT = THREE.RepeatWrapping;
                map.anisotropy = 4;
                map.repeat.set(10, 24);
                floorMat.bumpMap = map;
                floorMat.needsUpdate = true;
            }
        });


        textureLoader.load("textures/hardwood2_roughness.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.wrapS = THREE.RepeatWrapping;
                map.wrapT = THREE.RepeatWrapping;
                map.anisotropy = 4;
                map.repeat.set(10, 24);
                floorMat.roughnessMap = map;
                floorMat.needsUpdate = true;
            }
        });

        MeshStandardMaterialParameters meshStandardMaterialParameters2 = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters2.roughness = 0.7f;
        meshStandardMaterialParameters2.color = new Color(0xffffff);
        meshStandardMaterialParameters2.bumpScale = 0.002f;
        meshStandardMaterialParameters2.metalness = 0.2f;

        cubeMat = new MeshStandardMaterial(meshStandardMaterialParameters2);


        textureLoader.load("textures/brick_diffuse.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.wrapS = THREE.RepeatWrapping;
                map.wrapT = THREE.RepeatWrapping;
                map.anisotropy = 4;
                map.repeat.set(1, 1);
                cubeMat.map = map;
                cubeMat.needsUpdate = true;
            }
        });


        textureLoader.load("textures/brick_bump.jpg", new
                OnLoadCallback<Texture>() {
                    @Override
                    public void onLoad(Texture map) {
                        map.wrapS = THREE.RepeatWrapping;
                        map.wrapT = THREE.RepeatWrapping;
                        map.anisotropy = 4;
                        map.repeat.set(1, 1);
                        cubeMat.bumpMap = map;
                        cubeMat.needsUpdate = true;

                    }
                });


        MeshStandardMaterialParameters meshStandardMaterialParameters3 = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters3.color = new Color(0xffffff);
        meshStandardMaterialParameters3.roughness = 0.5f;
        meshStandardMaterialParameters3.metalness = 1.0f;

        ballMat = new MeshStandardMaterial(meshStandardMaterialParameters3);

        textureLoader.load("textures/planets/earth_atmos_2048.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.anisotropy = 4;
                ballMat.map = map;
                ballMat.needsUpdate = true;

            }
        });

        textureLoader.load("textures/planets/earth_specular_2048.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.anisotropy = 4;
                ballMat.metalnessMap = map;
                ballMat.needsUpdate = true;
            }
        });


        PlaneBufferGeometry floorGeometry = new PlaneBufferGeometry(20, 20);
        Mesh floorMesh = new Mesh(floorGeometry, floorMat);
        floorMesh.receiveShadow = true;
        floorMesh.rotation.x = (float) (-Math.PI / 2.0);
        scene.add(floorMesh);
        SphereBufferGeometry ballGeometry = new SphereBufferGeometry(0.5f, 32, 32);
        Mesh ballMesh = new Mesh(ballGeometry, ballMat);
        ballMesh.position.set(1, 0.5f, 1);
        ballMesh.rotation.y = (float) Math.PI;
        ballMesh.castShadow = true;
        scene.add(ballMesh);
        BoxBufferGeometry boxGeometry = new BoxBufferGeometry(0.5f, 0.5f, 0.5f);
        Mesh boxMesh = new Mesh(boxGeometry, cubeMat);
        boxMesh.position.set(-0.5f, 0.25f, -1);
        boxMesh.castShadow = true;
        scene.add(boxMesh);
        Mesh boxMesh2 = new Mesh(boxGeometry, cubeMat);
        boxMesh2.position.set(0, 0.25f, -5);
        boxMesh2.castShadow = true;
        scene.add(boxMesh2);

        Mesh boxMesh3 = new Mesh(boxGeometry, cubeMat);
        boxMesh3.position.set(7, 0.25f, 0);
        boxMesh3.castShadow = true;
        scene.add(boxMesh3);

        renderer.physicallyCorrectLights = true;
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        renderer.shadowMap.enabled = true;
        renderer.toneMapping = THREE.ReinhardToneMapping;
        setupWebGLRenderer(renderer);

        orbitControls = new OrbitControls(camera, root);
        setupGui();
    }

    private void setupGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);


        gui.add("hemiIrradiance", hemiLuminousIrradiances.keySet().toArray(new String[hemiLuminousIrradiances.size()]), hemiIrradiance).onChange(new OnChange<Object>() {
            @Override
            public void onChange(Object result) {
                hemiIrradiance = result.toString();
            }
        });

        gui.add("bulbLuminousPowers", bulbLuminousPowers.keySet().toArray(new String[bulbLuminousPowers.size()]), bulbPower).onChange(new OnChange<Object>() {
            @Override
            public void onChange(Object result) {
                bulbPower = result.toString();
            }
        });

        gui.add("exposure", exposure, 0.0, 1.0).setStep(0.01).onChange(new OnChange<Number>() {
            @Override
            public void onChange(Number result) {
                exposure = result.doubleValue();
            }
        }).done();

        gui.add("shadows", shadows).onChange(result -> shadows = result).done();

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());

    }

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - Physically accurate lighting example using a incandescent bulb - by <a href=\"http://clara.io\" target=\"_blank\" rel=\"noopener\">Ben Houston</a><br />\n" +
                "\t\t\tUsing real world scale: Brick cube is 1 meter in size.  Light is 2 meters from floor.  Globe is 25 cm in diameter.<br/>\n" +
                "\t\t\tUsing Reinhard inline tonemapping with real-world light falloff (decay = 2).");

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
        renderer.toneMappingExposure = Math.pow(exposure, 5.0); // to allow for very bright scenes.
        renderer.shadowMap.enabled = shadows;
        bulbLight.castShadow = shadows;
        if (shadows != previousShadowMap) {
            ballMat.needsUpdate = true;
            cubeMat.needsUpdate = true;
            floorMat.needsUpdate = true;
            previousShadowMap = shadows;
        }
        bulbLight.power = bulbLuminousPowers.get(bulbPower);
        bulbMat.emissiveIntensity = bulbLight.intensity / (float) Math.pow(0.02, 2.0); // convert from intensity to irradiance at bulb surface
        hemiLight.intensity = hemiLuminousIrradiances.get(hemiIrradiance);
        double time = new Date().getTime() * 0.0005;
        bulbLight.position.y = (float) Math.cos(time) * 0.75f + 1.25f;
        renderer.render(scene, camera);
    }

}



