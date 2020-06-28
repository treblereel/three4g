package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.extras.core.Path;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.ShapeGeometry;
import org.treblereel.gwt.three4g.loaders.FontLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/27/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglGeometryTextShapes extends Attachable {

    public static final String name = "geometry / text / shapes";

    public WebglGeometryTextShapes() {
        camera = new PerspectiveCamera(45, aspect, 1, 10000);
        camera.position.set(0, -400, 600);

        orbitControls = new OrbitControls(camera, root);
        orbitControls.target.set(0, 0, 0);
        orbitControls.update();

        scene = new Scene();
        scene.background = new Color(0xf0f0f0);

        FontLoader loader = new FontLoader();
        loader.load("fonts/helvetiker_regular.typeface.json", new OnLoadCallback<Font>() {
            @Override
            public void onLoad(Font font) {
                BufferGeometry textShape = new BufferGeometry();

                LineBasicMaterialParameters lineBasicMaterialParameters = new LineBasicMaterialParameters();
                lineBasicMaterialParameters.color = new Color(0x006699);
                lineBasicMaterialParameters.side = THREE.DoubleSide;
                LineBasicMaterial matDark = new LineBasicMaterial(lineBasicMaterialParameters);

                MeshBasicMaterialParameters meshBasicMaterialParameter = new MeshBasicMaterialParameters();
                meshBasicMaterialParameter.color = new Color(0x006699);
                meshBasicMaterialParameter.transparent = true;
                meshBasicMaterialParameter.opacity = 0.4f;
                meshBasicMaterialParameter.side = THREE.DoubleSide;

                MeshBasicMaterial matLite = new MeshBasicMaterial(meshBasicMaterialParameter);
                String message = "   Three.js\nSimple text.";
                Shape[] shapes = font.generateShapes(message, 100);
                ShapeGeometry geometry = new ShapeGeometry(shapes);
                geometry.computeBoundingBox();
                float xMid = -0.5f * (geometry.boundingBox.max.x - geometry.boundingBox.min.x);
                geometry.translate(xMid, 0, 0);
                // make shape ( N.B. edge view not visible )
                textShape.fromGeometry(geometry);
                Mesh text = new Mesh(textShape, matLite);
                text.position.z = -150;
                scene.add(text);
                // make line shape ( N.B. edge view remains visible )
                JsArray<Path> holeShapes = new JsArray<>();
                for (int i = 0; i < shapes.length; i++) {
                    Shape shape = shapes[i];
                    if (shape.holes != null && shape.holes.length > 0) {
                        for (int j = 0; j < shape.holes.length; j++) {
                            Path hole = shape.holes.getAt(j);
                            holeShapes.push(hole);
                        }
                    }
                }

                Path[] temp = Js.uncheckedCast(holeShapes);
                List<Path> list = new ArrayList<>();
                Object3D lineText = new Object3D();

                Arrays.stream(shapes).forEach(v -> list.add(v));
                Arrays.stream(temp).forEach(v -> list.add(v));

                list.forEach(shape -> {
                    Vector3[] points = shape.getPoints();
                    BufferGeometry bufferGeometry = new BufferGeometry().setFromPoints(points);
                    bufferGeometry.translate(xMid, 0, 0);
                    Line lineMesh = new Line(bufferGeometry, matDark);
                    lineText.add(lineMesh);
                });

                scene.add(lineText);
            }
        });


        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
    }

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("<span style='color: black'> - Simple text from json fonts.</span>");
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
        renderer.render(scene, camera);
    }

}


