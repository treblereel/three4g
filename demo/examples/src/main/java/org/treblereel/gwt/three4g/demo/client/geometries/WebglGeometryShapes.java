package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsArray;
import elemental2.dom.*;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.utils.PointerEvent;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.extras.core.Path;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometry;
import org.treblereel.gwt.three4g.geometries.ExtrudeGeometryOptions;
import org.treblereel.gwt.three4g.geometries.ShapeGeometry;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.*;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_shapes")
public class WebglGeometryShapes implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Stats stats = new Stats();

    private Group group;

    private Texture texture;

    @PostConstruct
    public void init() {

        scene = new Scene();
        scene.setBackground(new Color(0xf0f0f0));

        camera = new PerspectiveCamera(50, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 2000);
        camera.position.set(0, 150, 1000);
        scene.add(camera);

        PointLight light = new PointLight(0xffffff, 0.8);
        camera.add(light);

        group = new Group();
        group.position.y = 50;
        scene.add(group);

        TextureLoader loader = new TextureLoader();
        texture = loader.load("textures/uv_grid_opengl.jpg");

        // it"s necessary to apply these settings in order to correctly display the texture on a shape geometry

        texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
        texture.repeat.set(0.008, 0.008);

        // California

        JsArray<Vector2> californiaPts = new JsArray<>();

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

        for (int i = 0; i < californiaPts.length; i++) californiaPts.getAt(i).multiplyScalar(0.25);

        Shape californiaShape = new Shape(californiaPts);


        // Triangle

        Shape triangleShape = new Shape()
                .moveTo(80, 20)
                .lineTo(40, 80)
                .lineTo(120, 80)
                .lineTo(80, 20); // close path


        // Heart

        int x = 0, y = 0;

        Shape heartShape = new Shape()
                .moveTo(x + 25, y + 25)
                .bezierCurveTo(x + 25, y + 25, x + 20, y, x, y)
                .bezierCurveTo(x - 30, y, x - 30, y + 35, x - 30, y + 35)
                .bezierCurveTo(x - 30, y + 55, x - 10, y + 77, x + 25, y + 95)
                .bezierCurveTo(x + 60, y + 77, x + 80, y + 55, x + 80, y + 35)
                .bezierCurveTo(x + 80, y + 35, x + 80, y, x + 50, y)
                .bezierCurveTo(x + 35, y, x + 25, y + 25, x + 25, y + 25);


        // Square

        int sqLength = 80;

        Shape squareShape = new Shape()
                .moveTo(0, 0)
                .lineTo(0, sqLength)
                .lineTo(sqLength, sqLength)
                .lineTo(sqLength, 0)
                .lineTo(0, 0);

        // Rounded rectangle

        Shape roundedRectShape = new Shape();

        roundedRect(roundedRectShape, 0, 0, 50, 50, 20 );
        // Track

        Shape trackShape = new Shape()
                .moveTo(40, 40)
                .lineTo(40, 160)
                .absarc(60, 160, 20, Math.PI, 0, true)
                .lineTo(80, 40)
                .absarc(60, 40, 20, 2 * Math.PI, Math.PI, true);


        // Circle

        int circleRadius = 40;
        Shape circleShape = new Shape()
                .moveTo(0, circleRadius)
                .quadraticCurveTo(circleRadius, circleRadius, circleRadius, 0)
                .quadraticCurveTo(circleRadius, -circleRadius, 0, -circleRadius)
                .quadraticCurveTo(-circleRadius, -circleRadius, -circleRadius, 0)
                .quadraticCurveTo(-circleRadius, circleRadius, 0, circleRadius);


        // Fish

        Shape fishShape = new Shape()
                .moveTo(x, y)
                .quadraticCurveTo(x + 50, y - 80, x + 90, y - 10)
                .quadraticCurveTo(x + 100, y - 10, x + 115, y - 40)
                .quadraticCurveTo(x + 115, y, x + 115, y + 40)
                .quadraticCurveTo(x + 100, y + 10, x + 90, y + 10)
                .quadraticCurveTo(x + 50, y + 80, x, y);


        // Arc circle

        Shape arcShape = new Shape()
                .moveTo(50, 10)
                .absarc(10, 10, 40, 0, Math.PI * 2, false);

        Path holePath = new Path()
                .moveTo(20, 10)
                .absarc(10, 10, 10, 0, Math.PI * 2, true);

        arcShape.holes.push(holePath);


        // Smiley

        Shape smileyShape = new Shape()
                .moveTo(80, 40)
                .absarc(40, 40, 40, 0, Math.PI * 2, false);

        Path smileyEye1Path = new Path()
                .moveTo(35, 20)
                .absellipse(25, 20, 10, 10, 0, Math.PI * 2, true);

        Path smileyEye2Path = new Path()
                .moveTo(65, 20)
                .absarc(55, 20, 10, 0, Math.PI * 2, true);

        Path smileyMouthPath = new Path()
                .moveTo(20, 40)
                .quadraticCurveTo(40, 60, 60, 40)
                .bezierCurveTo(70, 45, 70, 50, 60, 60)
                .quadraticCurveTo(40, 80, 20, 60)
                .quadraticCurveTo(5, 50, 20, 40);

        smileyShape.holes.push(smileyEye1Path);
        smileyShape.holes.push(smileyEye2Path);
        smileyShape.holes.push(smileyMouthPath);


        // Spline shape

        JsArray<Vector2> splinepts = new JsArray<>();
        splinepts.push(new Vector2(70, 20));
        splinepts.push(new Vector2(80, 90));
        splinepts.push(new Vector2(-30, 70));
        splinepts.push(new Vector2(0, 0));

        Shape splineShape = new Shape()
                .moveTo(0, 0)
                .splineThru(splinepts);

        ExtrudeGeometryOptions extrudeSettings = ExtrudeGeometryOptions.create();
        extrudeSettings.setDepth(8);
        extrudeSettings.setBevelEnabled(true);
        extrudeSettings.setBevelSegments(2);
        extrudeSettings.setSteps(2);
        extrudeSettings.setBevelSize(1);
        extrudeSettings.setBevelThickness(1);

        // addShape( shape, color, x, y, z, rx, ry,rz, s );

        addShape(californiaShape, extrudeSettings, 0xf08000, -300, -100, 0, 0, 0, 0, 1);
        addShape(triangleShape, extrudeSettings, 0x8080f0, -180, 0, 0, 0, 0, 0, 1);
        addShape(roundedRectShape, extrudeSettings, 0x008000, -150, 150, 0, 0, 0, 0, 1);
        addShape(trackShape, extrudeSettings, 0x008080, 200, -100, 0, 0, 0, 0, 1);
        addShape(squareShape, extrudeSettings, 0x0040f0, 150, 100, 0, 0, 0, 0, 1);
        addShape(heartShape, extrudeSettings, 0xf00000, 60, 100, 0, 0, 0, Math.PI, 1);
        addShape(circleShape, extrudeSettings, 0x00f000, 120, 250, 0, 0, 0, 0, 1);
        addShape(fishShape, extrudeSettings, 0x404040, -60, 200, 0, 0, 0, 0, 1);
        addShape(smileyShape, extrudeSettings, 0xf000f0, -200, 250, 0, 0, 0, Math.PI, 1);
        addShape(arcShape, extrudeSettings, 0x804000, 150, 0, 0, 0, 0, 0, 1);
        addShape(splineShape, extrudeSettings, 0x808080, -50, -100, 0, 0, 0, 0, 1);

        addLineShape(arcShape.holes.getAt(0), 0x804000, 150, 0, 0, 0, 0, 0, 1);

        for (int i = 0; i < smileyShape.holes.length; i += 1) {

            addLineShape(smileyShape.holes.getAt(i), 0xf000f0, -200, 250, 0, 0, 0, Math.PI, 1);

        }

        //
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        stats = new Stats();
        root.appendChild(stats.dom);

        //root.style.touchAction = "none";
        DomGlobal.window.addEventListener("pointerdown", e -> onPointerDown(e));
        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    private void roundedRect(Path ctx, double x,  double y, double width, double height, double radius) {
        ctx.moveTo( x, y + radius );
        ctx.lineTo( x, y + height - radius );
        ctx.quadraticCurveTo( x, y + height, x + radius, y + height );
        ctx.lineTo( x + width - radius, y + height );
        ctx.quadraticCurveTo( x + width, y + height, x + width, y + height - radius );
        ctx.lineTo( x + width, y + radius );
        ctx.quadraticCurveTo( x + width, y, x + width - radius, y );
        ctx.lineTo( x + radius, y );
        ctx.quadraticCurveTo( x, y, x, y + radius );
    }

    double pointerX = 0;
    double pointerXOnPointerDown = 0;

    double targetRotation = 0;
    double targetRotationOnPointerDown = 0;

    private void onPointerDown(Event e ) {
        PointerEvent event = (PointerEvent) e;

        DomGlobal.console.log("onPointerDown " + e);

        if ( event.isPrimary == false ) return;

        pointerXOnPointerDown = event.clientX - windowHalfX;
        targetRotationOnPointerDown = targetRotation;

        DomGlobal.document.addEventListener("pointermove", pointermove);
        DomGlobal.document.addEventListener( "pointerup", pointerup );

    }

    EventListener pointermove = new EventListener() {
        @Override
        public void handleEvent(Event evt) {
            onPointerMove(evt);
        }
    };

    EventListener pointerup = new EventListener() {
        @Override
        public void handleEvent(Event evt) {
            onPointerUp(evt);
        }
    };

    private void onPointerMove(Event e ) {
        PointerEvent event = (PointerEvent) e;

        if ( event.isPrimary == false ) return;

        pointerX = event.clientX - windowHalfX;

        targetRotation = targetRotationOnPointerDown + ( pointerX - pointerXOnPointerDown ) * 0.02;

    }

    private void  onPointerUp(Event e) {
        PointerEvent event = (PointerEvent) e;

        if ( event.isPrimary == false ) return;

        DomGlobal. document.removeEventListener( "pointermove", pointermove );
        DomGlobal.document.removeEventListener( "pointerup", pointerup );

    }

    private void addShape(Shape shape, ExtrudeGeometryOptions extrudeSettings, int color, double x, double y, double z, double rx, double ry, double rz, double s) {

        // flat shape with texture
        // note: default UVs generated by ShapeGeometry are simply the x- and y-coordinates of the vertices

        BufferGeometry geometry = new ShapeGeometry(shape);

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setSide(THREE.DoubleSide);
        meshPhongMaterialParameters.setMap(texture);


        Mesh mesh = new Mesh(geometry, new MeshPhongMaterial(meshPhongMaterialParameters));
        mesh.position.set(x, y, z - 175);
        mesh.rotation.set(rx, ry, rz);
        mesh.scale.set(s, s, s);
        group.add(mesh);

        // flat shape

        geometry = new ShapeGeometry(shape);

        MeshPhongMaterialParameters meshPhongMaterialParameters1 = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters1.setColor(color);
        meshPhongMaterialParameters1.setSide(THREE.DoubleSide);

        mesh = new Mesh(geometry, new MeshPhongMaterial(meshPhongMaterialParameters1));
        mesh.position.set(x, y, z - 125);
        mesh.rotation.set(rx, ry, rz);
        mesh.scale.set(s, s, s);
        group.add(mesh);

        // extruded shape

        geometry = new ExtrudeGeometry(shape, extrudeSettings);


        MeshPhongMaterialParameters meshPhongMaterialParameters2 = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters2.setColor(color);

        mesh = new Mesh(geometry, new MeshPhongMaterial(meshPhongMaterialParameters2));
        mesh.position.set(x, y, z - 75);
        mesh.rotation.set(rx, ry, rz);
        mesh.scale.set(s, s, s);
        group.add(mesh);

        addLineShape(shape, color, x, y, z, rx, ry, rz, s);

    }

    private void addLineShape(Path shape, int color, double x, double y, double z, double rx, double ry, double rz, double s) {

        // lines

        shape.autoClose = true;

        JsArray<Vector> points = shape.getPoints();
        JsArray<Object> spacedPoints = shape.getSpacedPoints(50);

        BufferGeometry geometryPoints = new BufferGeometry().setFromPoints(points);
        BufferGeometry geometrySpacedPoints = new BufferGeometry().setFromPoints(spacedPoints);

        // solid line

        LineBasicMaterialParameters lineBasicMaterialParameters = LineBasicMaterialParameters.create();
        lineBasicMaterialParameters.setColor(color);

        Line line = new Line(geometryPoints, new LineBasicMaterial(lineBasicMaterialParameters));
        line.position.set(x, y, z - 25);
        line.rotation.set(rx, ry, rz);
        line.scale.set(s, s, s);
        group.add(line);

        // line from equidistance sampled points
        LineBasicMaterialParameters lineBasicMaterialParameters2 = LineBasicMaterialParameters.create();
        lineBasicMaterialParameters2.setColor(color);

        line = new Line(geometrySpacedPoints, new LineBasicMaterial(lineBasicMaterialParameters2));
        line.position.set(x, y, z + 25);
        line.rotation.set(rx, ry, rz);
        line.scale.set(s, s, s);
        group.add(line);

        // vertices from real points
        PointsMaterialParameters pointsMaterialParameters = PointsMaterialParameters.create();
        pointsMaterialParameters.setColor(color);
        pointsMaterialParameters.setSize(4);

        Points particles = new Points(geometryPoints, new PointsMaterial(pointsMaterialParameters));
        particles.position.set(x, y, z + 75);
        particles.rotation.set(rx, ry, rz);
        particles.scale.set(s, s, s);
        group.add(particles);

        // equidistance sampled points

        particles = new Points(geometrySpacedPoints, new PointsMaterial(pointsMaterialParameters));
        particles.position.set(x, y, z + 125);
        particles.rotation.set(rx, ry, rz);
        particles.scale.set(s, s, s);
        group.add(particles);

    }

    double mouseX = 0, mouseY = 0;

    double windowHalfX = DomGlobal.window.innerWidth / 2;
    double windowHalfY = DomGlobal.window.innerHeight / 2;

    private void onDocumentMouseMove(Event e) {
        MouseEvent event = (MouseEvent) e;
        mouseX = (event.clientX - windowHalfX);
        mouseY = (event.clientY - windowHalfY);
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {

            windowHalfX = DomGlobal.window.innerWidth / 2;
            windowHalfY = DomGlobal.window.innerHeight / 2;

            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            render();
            stats.update();
        }
    }

    private void  render() {

        group.rotation.y += ( targetRotation - group.rotation.y ) * 0.05;
        renderer.render( scene, camera );

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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a>Simple procedurally-generated shapes";

        run = true;
        animate();
    }
}
