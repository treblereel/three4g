package org.treblereel.gwt.three4g.demo.client.camera;

import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.WheelEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.geometries.TextGeometry;
import org.treblereel.gwt.three4g.geometries.TextGeometryParameters;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.Font;
import org.treblereel.gwt.three4g.loaders.FontLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.MathUtils;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Page(path = "webgl_camera_logarithmicdepthbuffer")
public class WebglCameraLogarithmicDepthBuffer implements IsElement<HTMLDivElement> {

    private boolean run, ready;

    @Inject
    private HTMLDivElement root, container, container_normal, container_logzbuf, renderer_border;


    @Named("h2")
    @Inject
    private HTMLHeadingElement renderer_label1;

    @Named("h2")
    @Inject
    private HTMLHeadingElement renderer_label2;

    private double NEAR = 1e-6, FAR = 1e27;
    private double SCREEN_WIDTH = DomGlobal.window.innerWidth;
    private double SCREEN_HEIGHT = DomGlobal.window.innerHeight;
    private double screensplit = .25, screensplit_right = 0;
    private double[] mouse = new double[]{.5d, .5d };
    private double zoompos = - 100, minzoomspeed = .015;
    private double zoomspeed = minzoomspeed;

    private Label[] labeldata = new Label[15];

    private Stats stats;

    private Objects objects = new Objects();

    public HTMLDivElement getElement() {
        return root;
    }

    @PostConstruct
    public void init() {
        root.appendChild(container);

        container.appendChild(container_normal);
        container.appendChild(container_logzbuf);
        container.appendChild(renderer_border);

        container_normal.id = "container_normal";
        container_logzbuf.id = "container_logzbuf";
        renderer_border.id = "renderer_border";

        container_normal.appendChild(renderer_label1);
        container_logzbuf.appendChild(renderer_label2);

        renderer_label1.textContent = "normal z-buffer";
        renderer_label2.textContent = "logarithmic z-buffer";

        initLabeldata();

        FontLoader loader = new FontLoader();
        loader.load( "fonts/helvetiker_regular.typeface.json", font -> {

            Scene scene = initScene( font );

            // Initialize two copies of the same scene, one with normal z-buffer and one with logarithmic z-buffer
            objects.normal = initView( scene, "normal", false );
            objects.logzbuf = initView( scene, "logzbuf", true );

            ready = true;
            animate();

        } );

        stats = new Stats();
        container.appendChild( stats.dom );

        // Resize border allows the user to easily compare effects of logarithmic depth buffer over the whole scene
        renderer_border.addEventListener( "pointerdown", ent -> onBorderPointerDown() );

        DomGlobal.window.addEventListener( "mousemove", ent -> onMouseMove(ent) );
        DomGlobal.window.addEventListener( "resize", ent -> onWindowResize() );
        DomGlobal.window.addEventListener( "wheel", ent -> onMouseWheel(ent) );



    }

    public void onWindowResize() {

        updateRendererSizes();

    }

    public void onBorderPointerDown() {

        // activate draggable window resizing bar
        DomGlobal.window.addEventListener( "pointermove", (ent) -> onBorderPointerMove(ent) );
        DomGlobal.window.addEventListener( "pointerup", ent -> onBorderPointerUp() );

    }

    public void onBorderPointerMove(Event ev) {

        screensplit = Math.max( 0, Math.min( 1, ((MouseEvent)ev).clientX / DomGlobal.window.innerWidth ) );

    }

    public void onBorderPointerUp() {

        DomGlobal.window.removeEventListener( "pointermove", ent -> onBorderPointerMove(ent) );
        DomGlobal.window.removeEventListener( "pointerup", ent -> onBorderPointerUp() );

    }

    public void onMouseMove(Event ev ) {

        mouse[ 0 ] = ((MouseEvent)ev).clientX / DomGlobal.window.innerWidth;
        mouse[ 1 ] = ((MouseEvent)ev).clientY / DomGlobal.window.innerHeight;

    }

    public void onMouseWheel(Event ev ) {

        double amount = ((WheelEvent)ev).deltaY;
        if ( amount == 0 ) return;
        double dir = amount / Math.abs( amount );
        zoomspeed = dir / 10;

        // Slow down default zoom speed after user starts zooming, to give them more control
        minzoomspeed = 0.001;

    }

    public View initView(Scene scene, String name, boolean logDepthBuf ) {

        HTMLElement framecontainer = (HTMLElement) DomGlobal.document.getElementById( "container_" + name );

        PerspectiveCamera camera = new PerspectiveCamera( 50, screensplit * SCREEN_WIDTH / SCREEN_HEIGHT, NEAR, FAR );
        scene.add( camera );

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        webGLRendererParameters.setLogarithmicDepthBuffer(logDepthBuf);

        WebGLRenderer renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( SCREEN_WIDTH / 2, SCREEN_HEIGHT );
        renderer.domElement.style.position = "relative";
        renderer.domElement.id = "renderer_" + name;
        framecontainer.appendChild( renderer.domElement );

        View result = new View();
        result.container = framecontainer;
        result.renderer = renderer;
        result.scene = scene;
        result.camera = camera;

        return result;

    }

    private void updateRendererSizes() {

        // Recalculate size for both renderers when screen size or split location changes

        SCREEN_WIDTH = DomGlobal.window.innerWidth;
        SCREEN_HEIGHT = DomGlobal.window.innerHeight;

        screensplit_right = 1 - screensplit;

        objects.normal.renderer.setSize( screensplit * SCREEN_WIDTH, SCREEN_HEIGHT );
        objects.normal.camera.aspect = screensplit * SCREEN_WIDTH / SCREEN_HEIGHT;
        objects.normal.camera.updateProjectionMatrix();
        objects.normal.camera.setViewOffset( SCREEN_WIDTH, SCREEN_HEIGHT, 0, 0, SCREEN_WIDTH * screensplit, SCREEN_HEIGHT );
        objects.normal.container.style.width = CSSProperties.WidthUnionType.of(( screensplit * 100 ) + "%");

        objects.logzbuf.renderer.setSize( screensplit_right * SCREEN_WIDTH, SCREEN_HEIGHT );
        objects.logzbuf.camera.aspect = screensplit_right * SCREEN_WIDTH / SCREEN_HEIGHT;
        objects.logzbuf.camera.updateProjectionMatrix();
        objects.logzbuf.camera.setViewOffset( SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_WIDTH * screensplit, 0, SCREEN_WIDTH * screensplit_right, SCREEN_HEIGHT );
        objects.logzbuf.container.style.width = CSSProperties.WidthUnionType.of(( screensplit_right * 100 ) + "%");
        renderer_border.style.left = ( screensplit * 100 ) + "%";

    }

    private Scene initScene(Font font ) {

        Scene scene = new Scene();

        scene.add( new AmbientLight( 0x222222 ) );

        DirectionalLight light = new DirectionalLight( 0xffffff, 1 );
        light.position.set( 100, 100, 100 );
        scene.add( light );


        MeshPhongMaterialParameters materialargs = MeshPhongMaterialParameters.create();
        materialargs.setColor(0xffffff);
        materialargs.setSpecular(0x050505);
        materialargs.setShininess(50);
        materialargs.setEmissive(0x000000);

        SphereGeometry geometry = new SphereGeometry( 0.5, 24, 12 );

        for ( int i = 0; i < labeldata.length; i ++ ) {

					double scale = labeldata[ i ].scale;

            TextGeometryParameters parameters = TextGeometryParameters.create();
            parameters.setFont(font);
            parameters.setSize(labeldata[ i ].size);
            parameters.setHeight(labeldata[ i ].size / 2);

            TextGeometry labelgeo = new TextGeometry( labeldata[ i ].label, parameters);

            labelgeo.computeBoundingSphere();

            // center text
            labelgeo.translate( - labelgeo.boundingSphere.radius, 0, 0 );

            materialargs.setColor(new Color().setHSL( Math.random(), 0.5, 0.5 ));

            MeshPhongMaterial material = new MeshPhongMaterial( materialargs );

            Group group = new Group();
            group.position.z = - labeldata[ i ].size * scale;
            scene.add( group );

            Mesh textmesh = new Mesh( labelgeo, material );
            textmesh.scale.set( scale, scale, scale );
            textmesh.position.z = - labeldata[ i ].size * scale;
            textmesh.position.y = labeldata[ i ].size / 4 * scale;
            group.add( textmesh );

            Mesh dotmesh = new Mesh( geometry, material );
            dotmesh.position.y = - labeldata[ i ].size / 4 * scale;
            dotmesh.scale.multiplyScalar( labeldata[ i ].size * scale );
            group.add( dotmesh );

        }

        return scene;

    }

    private void initLabeldata() {
        labeldata[0] = new Label(.01, 0.0001, "microscopic (1µm)");
        labeldata[1] = new Label(.01, 0.1, "minuscule (1mm)");
        labeldata[2] = new Label(.01, 1.0, "tiny (1cm)");
        labeldata[3] = new Label(1, 1.0, "child-sized (1m)");
        labeldata[4] = new Label(10, 1.0, "tree-sized (10m)");
        labeldata[5] = new Label(100, 1.0, "building-sized (100m)");
        labeldata[6] = new Label(1000, 1.0, "medium (1km)");
        labeldata[7] = new Label(10000, 1.0, "city-sized (10km)");
        labeldata[8] = new Label(3400000, 1.0, "moon-sized (3,400 Km)");
        labeldata[9] = new Label(12000000, 1.0, "planet-sized (12,000 km)");
        labeldata[10] = new Label(1400000000, 1.0, "sun-sized (1,400,000 km)");
        labeldata[11] = new Label(7.47e12, 1.0, "solar system-sized (50Au)");
        labeldata[12] = new Label(9.4605284e15, 1.0, "gargantuan (1 light year)");
        labeldata[13] = new Label(3.08567758e16, 1.0, "ludicrous (1 parsec)");
        labeldata[14] = new Label(1e19, 1.0, "mind boggling (1000 light years)");
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            render();
        }
    }

    private void render() {

        // Put some limits on zooming
        double minzoom = labeldata[ 0 ].size * labeldata[ 0 ].scale * 1;
        double maxzoom = labeldata[ labeldata.length - 1 ].size * labeldata[ labeldata.length - 1 ].scale * 100;
        double damping = ( Math.abs( zoomspeed ) > minzoomspeed ? .95 : 1.0 );

        // Zoom out faster the further out you go
        double zoom = MathUtils.clamp( Math.pow( Math.E, zoompos ), minzoom, maxzoom );
        zoompos = Math.log( zoom );

        // Slow down quickly at the zoom limits
        if ( ( zoom == minzoom && zoomspeed < 0 ) || ( zoom == maxzoom && zoomspeed > 0 ) ) {

            damping = .85;

        }

        zoompos += zoomspeed;
        zoomspeed *= damping;

        objects.normal.camera.position.x = Math.sin( .5 * Math.PI * ( mouse[ 0 ] - .5 ) ) * zoom;
        objects.normal.camera.position.y = Math.sin( .25 * Math.PI * ( mouse[ 1 ] - .5 ) ) * zoom;
        objects.normal.camera.position.z = Math.cos( .5 * Math.PI * ( mouse[ 0 ] - .5 ) ) * zoom;
        objects.normal.camera.lookAt( objects.normal.scene.position );

        // Clone camera settings across both scenes
        objects.logzbuf.camera.position.copy( objects.normal.camera.position );
        objects.logzbuf.camera.quaternion.copy( objects.normal.camera.quaternion );

        // Update renderer sizes if the split has changed
        if ( screensplit_right != 1 - screensplit ) {

            updateRendererSizes();

        }

        objects.normal.renderer.render( objects.normal.scene, objects.normal.camera );
        objects.logzbuf.renderer.render( objects.logzbuf.scene, objects.logzbuf.camera );

        stats.update();

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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> - cameras - logarithmic depth buffer<br/>\n" +
                "\t\t\tmousewheel to dolly out";

        run = true;
        animate();
    }

    private class Objects {
        private View normal;
        private View logzbuf;
    }

    private class View {

        public HTMLElement container;
        public WebGLRenderer renderer;
        public Scene scene;
        public PerspectiveCamera camera;
    }

    private class Label {

        private double size;
        private double scale;
        private String label;

        private Label(double size, double scale, String label) {
            this.size = size;
            this.scale = scale;
            this.label = label;
        }
    }
}
