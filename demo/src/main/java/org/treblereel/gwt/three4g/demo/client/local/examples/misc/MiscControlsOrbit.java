package org.treblereel.gwt.three4g.demo.client.local.examples.misc;

import elemental2.dom.DomGlobal;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.CylinderBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.FogExp2;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class MiscControlsOrbit extends Attachable {

    public static final String name = "controls / orbit";
    private Random random = new Random();

    public MiscControlsOrbit() {

        scene = new Scene();
        scene.background = new Color(0xcccccc);
        scene.fog = new FogExp2(0xcccccc, 0.002f);


        camera = new PerspectiveCamera(60, aspect, 1, 1000);
        camera.position.set(400, 200, 0);
        // controls
        orbitControls = new OrbitControls(camera, root);
        //controls.addEventListener( "change", render ); // call this only in static scenes (i.e., if there is no animation loop)
        orbitControls.enableDamping = true; // an animation loop is required when either damping or auto-rotation are enabled
        orbitControls.dampingFactor = 0.25f;
        orbitControls.screenSpacePanning = false;
        orbitControls.minDistance = 100;
        orbitControls.maxDistance = 500;
        orbitControls.maxPolarAngle = (float) Math.PI / 2;
        // world
        CylinderBufferGeometry geometry = new CylinderBufferGeometry(0, 10, 30, 4, 1);
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0xffffff);
        material.flatShading = true;

        for (int i = 0; i < 500; i++) {
            Mesh mesh = new Mesh(geometry, material);
            mesh.position.x = random.nextFloat() * 1600 - 800;
            mesh.position.y = 0;
            mesh.position.z = random.nextFloat() * 1600 - 800;
            mesh.updateMatrix();
            mesh.matrixAutoUpdate = false;
            scene.add(mesh);
        }
        // lights
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(1, 1, 1);
        scene.add(light);
        light = new DirectionalLight(0x002288);
        light.position.set(-1, -1, -1);
        scene.add(light);
        scene.add(new AmbientLight(0x222222));


        //
        WebGLRendererParameters parameters1 = new WebGLRendererParameters();
        parameters1.antialias = true;
        renderer = new WebGLRenderer(parameters1);
        setupWebGLRenderer(renderer);
        renderer.setClearColor(0x000000);
        container.appendChild(renderer.domElement);
        //
        root.appendChild(renderer.domElement);
        animate();
    }

    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml("    webaudio orientation | music by <a style=\"color:orange;\" href=\"http://www.newgrounds.com/audio/listen/376737\" target=\"_blank\" rel=\"noopener noreferrer\">skullbeatz</a>");
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
        orbitControls.update();
        renderer.render(scene, camera);
    }

}
