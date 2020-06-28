package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.Pair;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.helpers.BoxHelper;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.materials.parameters.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.PointsMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.LineSegments;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/21/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglBuffergeometryDrawcalls extends Attachable {

    public static final String name = "buffergeometry / drawcalls";

    private Group group;
    private JsArray<Pair<Vector3, Integer>> particlesData = new JsArray();
    private Float32Array positions, colors;
    private BufferGeometry particles;
    private Points pointCloud;
    private Float32Array particlePositions;
    private LineSegments linesMesh;
    private int maxParticleCount = 1000;
    private int particleCount = 500;
    private int r = 800;
    private int rHalf = r / 2;
    private Random random = new Random();

    private boolean showDots = true;
    private boolean showLines = true;
    private int minDistance = 150;
    private boolean limitConnections = false;
    private int maxConnections = 20;

    public WebglBuffergeometryDrawcalls() {

        camera = new PerspectiveCamera(45, aspect, 1, 4000);
        camera.position.z = 1750;
        orbitControls = new OrbitControls(camera, root);
        scene = new Scene();
        group = new Group();
        scene.add(group);
        BoxHelper helper = new BoxHelper(new Mesh(new BoxBufferGeometry(r, r, r)));
        ((LineBasicMaterial) helper.material).color.setHex(0x080808);

        helper.material.blending = THREE.AdditiveBlending;

        helper.material.transparent = true;
        group.add(helper);
        int segments = maxParticleCount * maxParticleCount;
        positions = new Float32Array(segments * 3);
        colors = new Float32Array(segments * 3);

        PointsMaterialParameters pMaterialParameters = new PointsMaterialParameters();
        pMaterialParameters.color = new Color(0xFFFFFF);
        pMaterialParameters.size = 3;
        pMaterialParameters.blending = THREE.AdditiveBlending;
        pMaterialParameters.transparent = true;
        pMaterialParameters.sizeAttenuation = false;
        PointsMaterial pMaterial = new PointsMaterial(pMaterialParameters);
        particles = new BufferGeometry();

        particlePositions = new Float32Array(maxParticleCount * 3);
        for (int i = 0; i < maxParticleCount; i++) {
            double x = Math.random() * r - r / 2;
            double y = Math.random() * r - r / 2;
            double z = Math.random() * r - r / 2;

            particlePositions.setAt(i * 3, x);
            particlePositions.setAt(i * 3 + 1, y);
            particlePositions.setAt(i * 3 + 2, z);
            // add it to the geometry

            particlesData.push(new Pair(
                    new Vector3(-1 + random.nextFloat() * 2, -1 + random.nextFloat() * 2, -1 + random.nextFloat() * 2),
                    0
            ));
        }
        particles.setDrawRange(0, particleCount);
        particles.addAttribute("position", new BufferAttribute(particlePositions, 3).setDynamic(true));
        // create the particle system
        pointCloud = new Points(particles, pMaterial);
        group.add(pointCloud);
        BufferGeometry geometry = new BufferGeometry();
        geometry.addAttribute("position", new BufferAttribute(positions, 3).setDynamic(true));
        geometry.addAttribute("color", new BufferAttribute(colors, 3).setDynamic(true));
        geometry.computeBoundingSphere();
        geometry.setDrawRange(0, 0);

        LineBasicMaterialParameters lineBasicMaterialParameters = new LineBasicMaterialParameters();
        lineBasicMaterialParameters.vertexColors = THREE.VertexColors;
        lineBasicMaterialParameters.blending = THREE.AdditiveBlending;
        lineBasicMaterialParameters.transparent = true;

        LineBasicMaterial material = new LineBasicMaterial(lineBasicMaterialParameters);
        linesMesh = new LineSegments(geometry, material);
        group.add(linesMesh);

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

        initGUI();
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    private void initGUI() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);


        gui.add("showDots", showDots).onChange(result -> pointCloud.visible = result);
        gui.add("showLines", showLines).onChange(result -> linesMesh.visible = result);

        gui.add("minDistance", minDistance, 10, 300).onChange(result -> minDistance = result.intValue());
        gui.add("limitConnections", limitConnections).onChange(result -> limitConnections = result);
        gui.add("maxConnections", maxConnections, 0, 30).onChange(result -> maxConnections = result.intValue());
        gui.add("particleCount", particleCount, 0, maxParticleCount).onChange(result -> {
            particleCount = result.intValue();
            particles.setDrawRange(0, particleCount);

        });

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" webgl - buffergeometry drawcalls - by <a style='color:blue;' href=\"https://twitter.com/fernandojsg\">fernandojsg</a>");
    }

    private void animate() {
        double s = new Date().getTime();

        int vertexpos = 0;
        int colorpos = 0;
        int numConnected = 0;

        for (int i = 0; i < particleCount; i++)
            particlesData.getAt(i).snd = 0;


        for (int i = 0; i < particleCount; i++) {
            // get the particle
            particlesData.getAt(i);
            particlePositions.setAt(i * 3, particlePositions.getAt(i * 3) + particlesData.getAt(i).fst.x);
            particlePositions.setAt(i * 3 + 1, particlePositions.getAt(i * 3 + 1) + particlesData.getAt(i).fst.y);
            particlePositions.setAt(i * 3 + 2, particlePositions.getAt(i * 3 + 2) + particlesData.getAt(i).fst.z);


            if (particlePositions.getAt(i * 3 + 1) < -rHalf || particlePositions.getAt(i * 3 + 1) > rHalf)
                particlesData.getAt(i).fst.y = -particlesData.getAt(i).fst.y;
            if (particlePositions.getAt(i * 3) < -rHalf || particlePositions.getAt(i * 3) > rHalf)
                particlesData.getAt(i).fst.x = -particlesData.getAt(i).fst.x;
            if (particlePositions.getAt(i * 3 + 2) < -rHalf || particlePositions.getAt(i * 3 + 2) > rHalf)
                particlesData.getAt(i).fst.z = -particlesData.getAt(i).fst.z;

            if (limitConnections && particlesData.getAt(i).snd >= maxConnections)
                continue;
            // Check collision
            double dx, dy, dz;
            for (int j = i + 1; j < particleCount; j++) {
                Pair<Vector3, Integer> particleDataB = particlesData.getAt(j);
                if (limitConnections && particleDataB.snd >= maxConnections)
                    continue;
                dx = particlePositions.getAt(i * 3) - particlePositions.getAt(j * 3);
                dy = particlePositions.getAt(i * 3 + 1) - particlePositions.getAt(j * 3 + 1);
                dz = particlePositions.getAt(i * 3 + 2) - particlePositions.getAt(j * 3 + 2);
                double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
                if (dist < minDistance) {
                    particlesData.getAt(i).snd++;
                    particleDataB.snd++;
                    double alpha = 1.0 - dist / minDistance;
                    positions.setAt(vertexpos++, particlePositions.getAt(i * 3));
                    positions.setAt(vertexpos++, particlePositions.getAt(i * 3 + 1));
                    positions.setAt(vertexpos++, particlePositions.getAt(i * 3 + 2));
                    positions.setAt(vertexpos++, particlePositions.getAt(j * 3));
                    positions.setAt(vertexpos++, particlePositions.getAt(j * 3 + 1));
                    positions.setAt(vertexpos++, particlePositions.getAt(j * 3 + 2));

                    colors.setAt(colorpos++, alpha);
                    colors.setAt(colorpos++, alpha);
                    colors.setAt(colorpos++, alpha);
                    colors.setAt(colorpos++, alpha);
                    colors.setAt(colorpos++, alpha);
                    colors.setAt(colorpos++, alpha);
                    numConnected++;
                }
            }
        }
        BufferGeometry geometry = linesMesh.geometry.cast();
        geometry.setDrawRange(0, numConnected * 2);
        geometry.attributes.position.needsUpdate = true;
        geometry.attributes.color.needsUpdate = true;

        BufferGeometry pointCloudG = pointCloud.geometry.cast();
        pointCloudG.attributes.position.needsUpdate = true;

        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {
        double time = new Date().getTime() * 0.001;
        group.rotation.y = (float) time * 0.1f;
        renderer.render(scene, camera);
    }
}