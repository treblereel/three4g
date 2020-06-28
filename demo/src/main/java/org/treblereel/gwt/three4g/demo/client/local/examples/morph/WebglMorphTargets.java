package org.treblereel.gwt.three4g.demo.client.local.examples.morph;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import java.util.ArrayList;
import java.util.List;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.MorphTarget;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/9/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglMorphTargets extends Attachable {

    public static final String name = "morphtargets";

    private Clock clock = new Clock();
    private List<AnimationMixer> mixers = new ArrayList<>();

    public WebglMorphTargets() {

        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.z = 500;
        scene = new Scene();
        scene.background = new Color(0x222222);
        scene.fog = new Fog(0x000000, 1, 15000);
        PointLight light = new PointLight(0xff2200);
        camera.add(light);
        scene.add(camera);
        scene.add(new AmbientLight(0x111111));

        BoxGeometry geometry = new BoxGeometry(100, 100, 100);

        MeshLambertMaterial material = new MeshLambertMaterial();
        material.color = new Color(0xffffff);
        material.morphTargets = true;
        // construct 8 blend shapes
        for (int i = 0; i < 8; i++) {
            JsArray<Vector3> vertices = new JsArray<>();
            for (int v = 0; v < geometry.vertices.length; v++) {
                vertices.push(geometry.vertices.getAt(v).clone());
                if (v == i) {
                    vertices.getAt(vertices.length - 1).x *= 2;
                    vertices.getAt(vertices.length - 1).y *= 2;
                    vertices.getAt(vertices.length - 1).z *= 2;
                }
            }
            MorphTarget morphTarget = new MorphTarget();
            morphTarget.name = "target" + i;
            morphTarget.vertices = vertices;
            geometry.morphTargets.push(morphTarget);
        }
        BufferGeometry geometry1 = new BufferGeometry().fromGeometry(geometry);
        mesh = new Mesh(geometry1, material);
        scene.add(mesh);

        orbitControls = new OrbitControls(camera, root);
        orbitControls.minDistance = 400;
        orbitControls.maxDistance = 1000;

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);

        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
        initGui();
    }

    private void initGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);
        gui.add("influence1", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[0] = result.floatValue()).done();
        gui.add("influence2", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[1] = result.floatValue()).done();
        gui.add("influence3", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[2] = result.floatValue()).done();
        gui.add("influence4", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[3] = result.floatValue()).done();
        gui.add("influence5", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[4] = result.floatValue()).done();
        gui.add("influence6", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[5] = result.floatValue()).done();
        gui.add("influence7", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[6] = result.floatValue()).done();
        gui.add("influence8", 0, 0, 1).setStep(0.01).onChange(result -> mesh.morphTargetInfluences[7] = result.floatValue()).done();

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
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - WebGL morph target example");

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
        mesh.rotation.y += 0.01;
        renderer.render(scene, camera);
    }

}



