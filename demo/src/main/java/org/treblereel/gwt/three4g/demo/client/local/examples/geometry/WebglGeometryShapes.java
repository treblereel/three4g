package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extras.core.Path;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometry;
import org.treblereel.gwt.three4g.geometries.ShapeBufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.ExtrudeGeometryParameters;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.LineBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.materials.parameters.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.PointsMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/12/18.
 */
public class WebglGeometryShapes extends Attachable {


    public static final String name = "geometry / shapes";
    private Vector2 mouse = new Vector2();
    private Group group;
    private Texture texture;
    private double windowHalfX = window.innerWidth / 2;
    private double targetRotation = 0;
    private double targetRotationOnMouseDown = 0;
    private double mouseX = 0;
    private double mouseXOnMouseDown = 0;

    private EventListener onDocumentMouseDown, onDocumentTouchStart, onDocumentTouchMove, onDocumentMouseMove, onDocumentMouseUp, onDocumentMouseOut;

    public WebglGeometryShapes() {

        scene = new Scene();
        scene.background = new Color(0xf0f0f0);
        camera = new PerspectiveCamera(50, aspect, 1, 1000);
        camera.position.set(0, 150, 500);
        scene.add(camera);

        PointLight light = new PointLight(0xffffff, 0.8f);
        camera.add(light);
        group = new Group();
        group.position.y = 50;
        scene.add(group);
        TextureLoader loader = new TextureLoader();
        texture = loader.load("textures/UV_Grid_Sm.jpg");
        // it"s necessary to apply these settings in order to correctly display the texture on a shape geometry
        texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
        texture.repeat.set(0.008f, 0.008f);


        // California
        JsArray<Vector2> californiaPts = new JsArray();
        californiaPts.push(new Vector2(610, 320));
        californiaPts.push(new Vector2(450, 300));
        californiaPts.push(new Vector2(392, 392));
        californiaPts.push(new Vector2(266, 438));
        californiaPts.push(new Vector2(190, 570));
        californiaPts.push(new Vector2(190, 600));
        californiaPts.push(new Vector2(160, 620));
        californiaPts.push(new Vector2(160, 650));
        californiaPts.push(new Vector2(180, 640));
        californiaPts.push(new Vector2(165, 680));
        californiaPts.push(new Vector2(150, 670));
        californiaPts.push(new Vector2(90, 737));
        californiaPts.push(new Vector2(80, 795));
        californiaPts.push(new Vector2(50, 835));
        californiaPts.push(new Vector2(64, 870));
        californiaPts.push(new Vector2(60, 945));
        californiaPts.push(new Vector2(300, 945));
        californiaPts.push(new Vector2(300, 743));
        californiaPts.push(new Vector2(600, 473));
        californiaPts.push(new Vector2(626, 425));
        californiaPts.push(new Vector2(600, 370));
        californiaPts.push(new Vector2(610, 320));

        for (int i = 0; i < californiaPts.length; i++) {
            californiaPts.getAt(i).multiplyScalar(0.25f);
        }
        Shape californiaShape = new Shape(Js.uncheckedCast(californiaPts));


        // Triangle
        Shape triangleShape = new Shape();
        triangleShape.moveTo(80, 20);
        triangleShape.lineTo(40, 80);
        triangleShape.lineTo(120, 80);
        triangleShape.lineTo(80, 20); // close path
        // Heart
        int x = 0, y = 0;
        Shape heartShape = new Shape(); // From http://blog.burlock.org/html5/130-paths
        heartShape.moveTo(x + 25, y + 25);
        heartShape.bezierCurveTo(x + 25, y + 25, x + 20, y, x, y);
        heartShape.bezierCurveTo(x - 30, y, x - 30, y + 35, x - 30, y + 35);
        heartShape.bezierCurveTo(x - 30, y + 55, x - 10, y + 77, x + 25, y + 95);
        heartShape.bezierCurveTo(x + 60, y + 77, x + 80, y + 55, x + 80, y + 35);
        heartShape.bezierCurveTo(x + 80, y + 35, x + 80, y, x + 50, y);
        heartShape.bezierCurveTo(x + 35, y, x + 25, y + 25, x + 25, y + 25);
        // Square
        int sqLength = 80;
        Shape squareShape = new Shape();
        squareShape.moveTo(0, 0);
        squareShape.lineTo(0, sqLength);
        squareShape.lineTo(sqLength, sqLength);
        squareShape.lineTo(sqLength, 0);
        squareShape.lineTo(0, 0);
        // Rectangle
        int rectLength = 120, rectWidth = 40;
        Shape rectShape = new Shape();
        rectShape.moveTo(0, 0);
        rectShape.lineTo(0, rectWidth);
        rectShape.lineTo(rectLength, rectWidth);
        rectShape.lineTo(rectLength, 0);
        rectShape.lineTo(0, 0);
        // Rounded rectangle
        Shape roundedRectShape = new Shape();
        roundedRect(roundedRectShape, 0, 0, 50, 50, 20);
        // Track
        Shape trackShape = new Shape();
        trackShape.moveTo(40, 40);
        trackShape.lineTo(40, 160);
        trackShape.absarc(60, 160, 20, (float) Math.PI, 0, true);
        trackShape.lineTo(80, 40);
        trackShape.absarc(60, 40, 20, (float) (2 * Math.PI), (float) Math.PI, true);
        // Circle
        int circleRadius = 40;
        Shape circleShape = new Shape();
        circleShape.moveTo(0, circleRadius);
        circleShape.quadraticCurveTo(circleRadius, circleRadius, circleRadius, 0);
        circleShape.quadraticCurveTo(circleRadius, -circleRadius, 0, -circleRadius);
        circleShape.quadraticCurveTo(-circleRadius, -circleRadius, -circleRadius, 0);
        circleShape.quadraticCurveTo(-circleRadius, circleRadius, 0, circleRadius);
        // Fish
        x = y = 0;
        Shape fishShape = new Shape();
        fishShape.moveTo(x, y);
        fishShape.quadraticCurveTo(x + 50, y - 80, x + 90, y - 10);
        fishShape.quadraticCurveTo(x + 100, y - 10, x + 115, y - 40);
        fishShape.quadraticCurveTo(x + 115, y, x + 115, y + 40);
        fishShape.quadraticCurveTo(x + 100, y + 10, x + 90, y + 10);
        fishShape.quadraticCurveTo(x + 50, y + 80, x, y);
        // Arc circle
        Shape arcShape = new Shape();
        arcShape.moveTo(50, 10);
        arcShape.absarc(10, 10, 40, 0, (float) Math.PI * 2, false);
        Path holePath = new Path();
        holePath.moveTo(20, 10);
        holePath.absarc(10, 10, 10, 0, (float) Math.PI * 2, true);
        arcShape.holes.push(holePath);
        // Smiley
        Shape smileyShape = new Shape();
        smileyShape.moveTo(80, 40);
        smileyShape.absarc(40, 40, 40, 0, (float) Math.PI * 2, false);
        Path smileyEye1Path = new Path();
        smileyEye1Path.moveTo(35, 20);
        smileyEye1Path.absellipse(25, 20, 10, 10, 0, (float) Math.PI * 2, true);
        smileyShape.holes.push(smileyEye1Path);
        Path smileyEye2Path = new Path();
        smileyEye2Path.moveTo(65, 20);
        smileyEye2Path.absarc(55, 20, 10, 0, (float) Math.PI * 2, true);
        smileyShape.holes.push(smileyEye2Path);
        Path smileyMouthPath = new Path();
        smileyMouthPath.moveTo(20, 40);
        smileyMouthPath.quadraticCurveTo(40, 60, 60, 40);
        smileyMouthPath.bezierCurveTo(70, 45, 70, 50, 60, 60);
        smileyMouthPath.quadraticCurveTo(40, 80, 20, 60);
        smileyMouthPath.quadraticCurveTo(5, 50, 20, 40);
        smileyShape.holes.push(smileyMouthPath);
        // Spline shape
        Vector2[] splinepts = new Vector2[4];
        splinepts[0] = new Vector2(70, 20);
        splinepts[1] = new Vector2(80, 90);
        splinepts[2] = new Vector2(-30, 70);
        splinepts[3] = new Vector2(0, 0);

        Shape splineShape = new Shape();
        splineShape.moveTo(0, 0);
        splineShape.splineThru(splinepts);

        ExtrudeGeometryParameters extrudeSettings = new ExtrudeGeometryParameters();
        extrudeSettings.depth = 8;
        extrudeSettings.bevelEnabled = true;
        extrudeSettings.bevelSegments = 2;
        extrudeSettings.steps = 2;
        extrudeSettings.bevelSize = 1;
        extrudeSettings.bevelThickness = 1;

        addShape(californiaShape, extrudeSettings, 0xf08000, -300, -100, 0, 0, 0, 0, 1);


        addShape(triangleShape, extrudeSettings, 0x8080f0, -180, 0, 0, 0, 0, 0, 1);
        addShape(roundedRectShape, extrudeSettings, 0x008000, -150, 150, 0, 0, 0, 0, 1);
        addShape(trackShape, extrudeSettings, 0x008080, 200, -100, 0, 0, 0, 0, 1);
        addShape(squareShape, extrudeSettings, 0x0040f0, 150, 100, 0, 0, 0, 0, 1);
        addShape(heartShape, extrudeSettings, 0xf00000, 60, 100, 0, 0, 0, (float) Math.PI, 1);
        addShape(circleShape, extrudeSettings, 0x00f000, 120, 250, 0, 0, 0, 0, 1);
        addShape(fishShape, extrudeSettings, 0x404040, -60, 200, 0, 0, 0, 0, 1);
        addShape(smileyShape, extrudeSettings, 0xf000f0, -200, 250, 0, 0, 0, (float) Math.PI, 1);
        addShape(arcShape, extrudeSettings, 0x804000, 150, 0, 0, 0, 0, 0, 1);
        addShape(splineShape, extrudeSettings, 0x808080, -50, -100, 0, 0, 0, 0, 1);
        addLineShape(arcShape.holes.getAt(0), 0x804000, 150, 0, 0, 0, 0, 0, 1);


        for (int i = 0; i < smileyShape.holes.length; i += 1) {
            addLineShape(smileyShape.holes.getAt(i), 0xf000f0, -200, 250, 0, 0, 0, (float) Math.PI, 1);
        }
        //
        onDocumentMouseDown = evt -> onDocumentMouseDown(Js.uncheckedCast(evt));
        onDocumentTouchStart = evt -> onDocumentTouchStart(Js.uncheckedCast(evt));
        onDocumentTouchMove = evt -> onDocumentTouchMove(Js.uncheckedCast(evt));
        onDocumentMouseMove = evt -> onDocumentMouseMove(Js.uncheckedCast(evt));
        onDocumentMouseUp = evt -> onDocumentMouseUp(evt);
        onDocumentMouseOut = evt -> onDocumentMouseOut(evt);

        document.addEventListener("mousedown", onDocumentMouseDown, false);
        document.addEventListener("touchstart", onDocumentTouchStart, false);
        document.addEventListener("touchmove", onDocumentTouchMove, false);

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
    }

    @Override
    public void detach() {
        super.detach();
        document.removeEventListener("mousedown", onDocumentMouseDown);
        document.removeEventListener("touchstart", onDocumentTouchStart);
        document.removeEventListener("touchmove", onDocumentTouchMove);

    }

    public void roundedRect(Shape ctx, float x, float y, float width, float height, float radius) {
        ctx.moveTo(x, y + radius);
        ctx.lineTo(x, y + height - radius);
        ctx.quadraticCurveTo(x, y + height, x + radius, y + height);
        ctx.lineTo(x + width - radius, y + height);
        ctx.quadraticCurveTo(x + width, y + height, x + width, y + height - radius);
        ctx.lineTo(x + width, y + radius);
        ctx.quadraticCurveTo(x + width, y, x + width - radius, y);
        ctx.lineTo(x + radius, y);
        ctx.quadraticCurveTo(x, y, x, y + radius);
    }

    public void onDocumentMouseDown(MouseEvent event) {
        //event.preventDefault();
        document.addEventListener("mousemove", onDocumentMouseMove, false);
        document.addEventListener("mouseup", onDocumentMouseUp, false);
        document.addEventListener("mouseout", onDocumentMouseOut, false);

        mouseXOnMouseDown = event.clientX - windowHalfX;
        targetRotationOnMouseDown = targetRotation;
    }

    public void onDocumentMouseMove(MouseEvent event) {
        mouse.x = (float) (((event.clientX - panel.offsetWidth) / (window.innerWidth - panel.offsetWidth)) * 2 - 1);
        mouse.y = (float) (-(event.clientY / window.innerHeight) * 2 + 1);

        mouseX = event.clientX - windowHalfX;
        targetRotation = targetRotationOnMouseDown + (mouseX - mouseXOnMouseDown) * 0.02;
    }

    public void onDocumentMouseUp(Event event) {
        document.removeEventListener("mousemove", onDocumentMouseMove, false);
        document.removeEventListener("mouseup", onDocumentMouseUp, false);
        document.removeEventListener("mouseout", onDocumentMouseOut, false);
    }

    public void onDocumentMouseOut(Event event) {
        document.removeEventListener("mousemove", onDocumentMouseMove, false);
        document.removeEventListener("mouseup", onDocumentMouseUp, false);
        document.removeEventListener("mouseout", onDocumentMouseOut, false);
    }

    public void onDocumentTouchStart(TouchEvent event) {
        if (event.touches.length == 1) {
            event.preventDefault();
            mouseXOnMouseDown = event.touches.item(0).pageX - windowHalfX;
            targetRotationOnMouseDown = targetRotation;
        }
    }

    public void onDocumentTouchMove(TouchEvent event) {
        if (event.touches.length == 1) {
            event.preventDefault();
            mouseX = event.touches.item(0).pageX - windowHalfX;
            targetRotation = targetRotationOnMouseDown + (mouseX - mouseXOnMouseDown) * 0.05;
        }
    }

    public void addShape(Shape shape, ExtrudeGeometryParameters extrudeSettings, int color, float x, float y, float z, float rx, float ry, float rz, float s) {
        // flat shape with texture
        // note: default UVs generated by ShapeBufferGeometry are simply the x- and y-coordinates of the vertices
        ShapeBufferGeometry geometry = new ShapeBufferGeometry(shape);
        MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
        parameters.side = THREE.DoubleSide;
        parameters.map = texture;
        Mesh mesh = new Mesh(geometry, new MeshPhongMaterial(parameters));
        mesh.position.set(x, y, z - 175);
        mesh.rotation.set(rx, ry, rz);
        mesh.scale.set(s, s, s);
        group.add(mesh);
        // flat shape
        ShapeBufferGeometry geometry1 = new ShapeBufferGeometry(shape);

        MeshPhongMaterialParameters parameters1 = new MeshPhongMaterialParameters();
        parameters1.color = new Color(color);
        parameters1.side = THREE.DoubleSide;

        mesh = new Mesh(geometry1, new MeshPhongMaterial(parameters1));
        mesh.position.set(x, y, z - 125);
        mesh.rotation.set(rx, ry, rz);
        mesh.scale.set(s, s, s);
        group.add(mesh);
        // extruded shape
        ExtrudeGeometry geometry2 = new ExtrudeGeometry(shape, extrudeSettings);
        MeshPhongMaterialParameters parameters2 = new MeshPhongMaterialParameters();
        parameters2.color = new Color(color);

        mesh = new Mesh(geometry2, new MeshPhongMaterial(parameters2));
        mesh.position.set(x, y, z - 75);
        mesh.rotation.set(rx, ry, rz);
        mesh.scale.set(s, s, s);
        group.add(mesh);
        addLineShape(shape, color, x, y, z, rx, ry, rz, s);
    }

    public void addLineShape(Path shape, int color, float x, float y, float z, float rx, float ry, float rz, float s) {
        // lines
        shape.autoClose = true;
        Vector3[] points = shape.getPoints();
        BufferGeometry geometryPoints = Js.uncheckedCast(new BufferGeometry().setFromPoints(points));
        // solid line
        LineBasicMaterialParameters parameters = new LineBasicMaterialParameters();
        parameters.color = new Color(color);
        parameters.linewidth = 3;

        Line line = new Line(geometryPoints, new LineBasicMaterial(parameters));
        line.position.set(x, y, z - 25);
        line.rotation.set(rx, ry, rz);
        line.scale.set(s, s, s);

        group.add(line);

        Vector3[] spacedPoints = shape.getSpacedPoints(50);

        BufferGeometry geometrySpacedPoints = Js.uncheckedCast(new BufferGeometry().setFromPoints(spacedPoints));

        // line from equidistance sampled points
        line = new Line(geometrySpacedPoints, new LineBasicMaterial(parameters));
        line.position.set(x, y, z + 25);
        line.rotation.set(rx, ry, rz);
        line.scale.set(s, s, s);
        group.add(line);

        // vertices from real points
        PointsMaterialParameters parameters1 = new PointsMaterialParameters();
        parameters1.color = new Color(color);
        parameters1.size = 4;
        Points particles = new Points(geometryPoints, new PointsMaterial(parameters1));
        particles.position.set(x, y, z + 75);
        particles.rotation.set(rx, ry, rz);
        particles.scale.set(s, s, s);
        group.add(particles);
        // equidistance sampled points
        particles = new Points(geometrySpacedPoints, new PointsMaterial(parameters1));
        particles.position.set(x, y, z + 125);
        particles.rotation.set(rx, ry, rz);
        particles.scale.set(s, s, s);
        group.add(particles);
    }

    private void render() {
        group.rotation.y += (targetRotation - group.rotation.y) * 0.05;
        renderer.render(scene, camera);
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

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" <a style=\"color:black;\">Simple procedurally-generated shapes<br/>Drag to spin<a>");
    }

}

