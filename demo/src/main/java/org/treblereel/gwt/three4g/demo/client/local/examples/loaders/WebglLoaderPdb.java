package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extensions.loaders.PDB;
import org.treblereel.gwt.three4g.extensions.loaders.PDBLoader;
import org.treblereel.gwt.three4g.extensions.renderers.CSS2DObject;
import org.treblereel.gwt.three4g.extensions.renderers.CSS2DRenderer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/10/18.
 */
@InjectJavaScriptFor(elements = {TrackballControls.class, PDBLoader.class, CSS2DRenderer.class})
public class WebglLoaderPdb extends Attachable {

    public static final String name = "loader / pdb";

    private Map<String, String> moleculas = new HashMap<>();

    private PDBLoader loader = new PDBLoader();
    private Vector3 offset = new Vector3();
    private Group group = new Group();
    private CSS2DRenderer labelRenderer;


    public WebglLoaderPdb() {

        moleculas.put("Ethanol", "ethanol.pdb");
        moleculas.put("Aspirin", "aspirin.pdb");
        moleculas.put("Caffeine", "caffeine.pdb");
        moleculas.put("Nicotine", "nicotine.pdb");
        moleculas.put("LSD", "lsd.pdb");
        moleculas.put("Cocaine", "cocaine.pdb");
        moleculas.put("Cholesterol", "cholesterol.pdb");
        moleculas.put("Lycopene", "lycopene.pdb");
        moleculas.put("Glucose", "glucose.pdb");
        moleculas.put("Aluminium oxide", "Al2O3.pdb");
        moleculas.put("Cubane", "cubane.pdb");
        moleculas.put("Copper", "cu.pdb");
        moleculas.put("Fluorite", "caf2.pdb");
        moleculas.put("Salt", "nacl.pdb");
        moleculas.put("YBCO superconductor", "ybco.pdb");
        moleculas.put("Buckyball", "buckyball.pdb");
        moleculas.put("Graphite", "graphite.pdb");

        scene = new Scene();
        scene.background = new Color(0x050505);
        camera = new PerspectiveCamera(70, aspect, 1, 5000);
        camera.position.z = 1000;
        scene.add(camera);
        DirectionalLight light = new DirectionalLight(0xffffff, 0.8f);
        light.position.set(1, 1, 1);
        scene.add(light);
        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 0.5f);
        directionalLight.position.set(-1, -1, 1);
        scene.add(directionalLight);
        scene.add(group);
        //

        labelRenderer = new CSS2DRenderer();
        labelRenderer.setSize(window.innerWidth, window.innerHeight);
        labelRenderer.domElement.style.position = "absolute";
        labelRenderer.domElement.style.top = "0";
        labelRenderer.domElement.style.pointerEvents = "none";
        container.appendChild(labelRenderer.domElement);
        //
        trackballControls = new TrackballControls(camera);
        trackballControls.minDistance = 500;
        trackballControls.maxDistance = 2000;
        //
        loadMolecule("models/molecules/caffeine.pdb");
        createMenu();


        MeshBasicMaterial square_material = new MeshBasicMaterial();
        square_material.color = new Color(0xF6831E);
        square_material.side = THREE.DoubleSide;

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);


        container.appendChild(renderer.domElement);
    }

    private void createMenu() {
        HTMLDivElement menu = (HTMLDivElement) document.createElement("div");
        menu.id = "menu";
        document.body.appendChild(menu);
        moleculas.forEach((k, v) -> {
            HTMLButtonElement button = (HTMLButtonElement) document.createElement("button");
            button.innerHTML = k;
            menu.appendChild(button);
            String url = "models/molecules/" + v;
            button.addEventListener("click", generateButtonCallback(url), false);

        });

        AppSetup.menuDiv.addMenu(menu).show();

    }

    private EventListener generateButtonCallback(String url) {
        return evt -> loadMolecule(url);
    }

    private void loadMolecule(String url) {
        while (group.children.length > 0) {
            Object3D object = group.children[0];
            object.parent.remove(object);
        }

        loader.load(url, new OnLoadCallback<PDB>() {
            @Override
            public void onLoad(PDB pdb) {
                BufferGeometry geometryAtoms = pdb.geometryAtoms;
                BufferGeometry geometryBonds = pdb.geometryBonds;

                PropertyHolder json = pdb.json;
                BoxBufferGeometry boxGeometry = new BoxBufferGeometry(1, 1, 1);
                IcosahedronBufferGeometry sphereGeometry = new IcosahedronBufferGeometry(1, 2);
                geometryAtoms.computeBoundingBox();
                geometryAtoms.boundingBox.getCenter(offset).negate();
                geometryAtoms.translate(offset.x, offset.y, offset.z);
                geometryBonds.translate(offset.x, offset.y, offset.z);

                BufferAttribute positions = geometryAtoms.getAttribute("position");
                BufferAttribute colors = geometryAtoms.getAttribute("color");
                Vector3 position = new Vector3();
                Color color;

                for (int i = 0; i < positions.count; i++) {

                    position.x = positions.getX(i).floatValue();
                    position.y = positions.getY(i).floatValue();
                    position.z = positions.getZ(i).floatValue();

                    color = new Color();
                    color.r = colors.getX(i).intValue();
                    color.g = colors.getY(i).intValue();
                    color.b = colors.getZ(i).intValue();

                    MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
                    parameters.color = color;
                    MeshPhongMaterial material = new MeshPhongMaterial(parameters);

                    Mesh object = new Mesh(sphereGeometry, material);
                    object.position.copy(position);
                    object.position.multiplyScalar(75);
                    object.scale.multiplyScalar(25);
                    group.add(object);

                    PropertyHolder[][][] atoms = json.getProperty("atoms");
                    PropertyHolder[][] atom = atoms[i];

                    HTMLDivElement text = (HTMLDivElement) document.createElement("div");

                    text.className = "label";
                    text.style.color = "rgb(" + atom[3][0] + "," + atom[3][1] + "," + atom[3][2] + ")";
                    text.textContent = "" + atom[4];

                    CSS2DObject label = new CSS2DObject(text);
                    label.position.copy(object.position);
                    group.add(label);

                }
                positions = geometryBonds.getAttribute("position");
                Vector3 start = new Vector3();
                Vector3 end = new Vector3();


                for (int i = 0; i < positions.count; i += 2) {
                    start.x = positions.getX(i).floatValue();
                    start.y = positions.getY(i).floatValue();
                    start.z = positions.getZ(i).floatValue();
                    end.x = positions.getX(i + 1).floatValue();
                    end.y = positions.getY(i + 1).floatValue();
                    end.z = positions.getZ(i + 1).floatValue();
                    start.multiplyScalar(75);
                    end.multiplyScalar(75);

                    MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
                    parameters.color = new Color(0xffffff);
                    Mesh object = new Mesh(boxGeometry, new MeshPhongMaterial(parameters));

                    object.position.copy(start);
                    object.position.lerp(end, 0.5f);
                    object.scale.set(5, 5, start.distanceTo(end));
                    object.lookAt(end);
                    group.add(object);
                }
            }


        });

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                trackballControls.update();

                float timer = new Date().getTime() * 0.0004f;
                group.rotation.x = timer;
                group.rotation.y = timer * 0.7f;

                labelRenderer.setSize(window.innerWidth - panel.offsetWidth, window.innerHeight);

                renderer.render(scene, camera);
                labelRenderer.render(scene, camera);
            }
            animate();
        });
    }

}

