package org.treblereel.gwt.three4g.demo.client.camera;

import elemental2.core.JsArray;
import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.KeyboardEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.bufferattribute.Float32BufferAttribute;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.helpers.CameraHelper;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.PointsMaterial;
import org.treblereel.gwt.three4g.materials.PointsMaterialParameters;
import org.treblereel.gwt.three4g.math.MathUtils;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_camera")
public class WebglCamera implements IsElement<HTMLDivElement> {

    double SCREEN_WIDTH = DomGlobal.window.innerWidth * 0.8;
    double SCREEN_HEIGHT = DomGlobal.window.innerHeight * 0.8;
    double aspect = SCREEN_WIDTH / SCREEN_HEIGHT;

    Group cameraRig;
    Camera activeCamera;
    PerspectiveCamera cameraPerspective;
    OrthographicCamera cameraOrtho;
    CameraHelper cameraPerspectiveHelper, cameraOrthoHelper, activeHelper;
    int frustumSize = 600;


    @Inject
    private HTMLDivElement root;

    private Clock clock = new Clock();
    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    Mesh mesh;

    private Scene scene;

    private boolean run, ready;


    @PostConstruct
    public void init() {
        root.appendChild(stats.dom);

        scene = new Scene();

        //

        camera = new PerspectiveCamera( 50, 0.5 * aspect, 1, 10000 );
        camera.position.z = 2500;

        cameraPerspective = new PerspectiveCamera( 50, 0.5 * aspect, 150, 1000 );

        cameraPerspectiveHelper = new CameraHelper( cameraPerspective );
        scene.add( cameraPerspectiveHelper );

        //
        cameraOrtho = new OrthographicCamera( 0.5 * frustumSize * aspect / - 2, 0.5 * frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 150, 1000 );

        cameraOrthoHelper = new CameraHelper( cameraOrtho );
        scene.add( cameraOrthoHelper );

        //

        activeCamera = cameraPerspective;
        activeHelper = cameraPerspectiveHelper;


        // counteract different front orientation of cameras vs rig

        cameraOrtho.rotation.y = Math.PI;
        cameraPerspective.rotation.y = Math.PI;

        cameraRig = new Group();

        cameraRig.add( cameraPerspective );
        cameraRig.add( cameraOrtho );

        scene.add( cameraRig );

        //

        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor(0xffffff);
        meshBasicMaterialParameters.setWireframe(true);

        mesh = new Mesh(
                new SphereGeometry( 100, 16, 8 ),
                new MeshBasicMaterial(meshBasicMaterialParameters)
				);
        scene.add( mesh );

        MeshBasicMaterialParameters meshBasicMaterialParameters2 = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters2.setColor(0x00ff00);
        meshBasicMaterialParameters2.setWireframe(true);

        Mesh mesh2 = new Mesh(
                new SphereGeometry( 50, 16, 8 ),
                new MeshBasicMaterial(meshBasicMaterialParameters2)
				);
        mesh2.position.y = 150;
        mesh.add( mesh2 );

        MeshBasicMaterialParameters meshBasicMaterialParameters3 = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters3.setColor(0x0000ff);
        meshBasicMaterialParameters3.setWireframe(true);

        Mesh mesh3 = new Mesh(
                new SphereGeometry( 5, 16, 8 ),
                new MeshBasicMaterial(meshBasicMaterialParameters3)
				);

        mesh3.position.z = 150;
        cameraRig.add( mesh3 );

        //

        BufferGeometry geometry = new BufferGeometry();
        JsArray<Double> vertices = new JsArray<>();

        for ( int i = 0; i < 10000; i ++ ) {

            vertices.push( MathUtils.randFloatSpread( 2000 ) ); // x
            vertices.push( MathUtils.randFloatSpread( 2000 ) ); // y
            vertices.push( MathUtils.randFloatSpread( 2000 ) ); // z

        }

        geometry.setAttribute( "position", new Float32BufferAttribute( vertices, 3 ) );

        PointsMaterialParameters pointsMaterialParameters = PointsMaterialParameters.create();
        pointsMaterialParameters.setColor(0x888888);

        Points particles = new Points( geometry, new PointsMaterial(pointsMaterialParameters));
        scene.add( particles );

        //
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
        root.appendChild(renderer.domElement);

        renderer.autoClear = false;
        ready = true;

        DomGlobal.document.addEventListener( "keydown", env -> onKeyDown(env));
        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if(camera != null && renderer != null) {
            SCREEN_WIDTH = DomGlobal.window.innerWidth * 0.8;
            SCREEN_HEIGHT = DomGlobal.window.innerHeight * 0.8;
            aspect = SCREEN_WIDTH / SCREEN_HEIGHT;

            renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );

            camera.aspect = 0.5 * aspect;
            camera.updateProjectionMatrix();

            cameraPerspective.aspect = 0.5 * aspect;
            cameraPerspective.updateProjectionMatrix();

            cameraOrtho.left = - 0.5 * frustumSize * aspect / 2;
            cameraOrtho.right = 0.5 * frustumSize * aspect / 2;
            cameraOrtho.top = frustumSize / 2;
            cameraOrtho.bottom = - frustumSize / 2;
            cameraOrtho.updateProjectionMatrix();
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            render();
            stats.update();
        }
    }

    private void render() {

        double r = JsDate.now() * 0.0005;

        mesh.position.x = 700 * Math.cos( r );
        mesh.position.z = 700 * Math.sin( r );
        mesh.position.y = 700 * Math.sin( r );

        mesh.children.getAt(0).position.x = 70 * Math.cos( 2 * r );
        mesh.children.getAt(0).position.z = 70 * Math.sin( r );

        if ( activeCamera == cameraPerspective ) {

            cameraPerspective.fov = 35 + 30 * Math.sin( 0.5 * r );
            cameraPerspective.far = mesh.position.length();
            cameraPerspective.updateProjectionMatrix();

            cameraPerspectiveHelper.update();
            cameraPerspectiveHelper.visible = true;

            cameraOrthoHelper.visible = false;

        } else {

            cameraOrtho.far = mesh.position.length();
            cameraOrtho.updateProjectionMatrix();

            cameraOrthoHelper.update();
            cameraOrthoHelper.visible = true;

            cameraPerspectiveHelper.visible = false;

        }

        cameraRig.lookAt( mesh.position );

        renderer.clear();

        activeHelper.visible = false;

        renderer.setViewport( 0, 0, SCREEN_WIDTH / 2, SCREEN_HEIGHT );
        renderer.render( scene, activeCamera );

        activeHelper.visible = true;

        renderer.setViewport( SCREEN_WIDTH / 2, 0, SCREEN_WIDTH / 2, SCREEN_HEIGHT );
        renderer.render( scene, camera );

    }

    private void onKeyDown(Event evt) {
        if (evt instanceof KeyboardEvent) {
            KeyboardEvent e = (KeyboardEvent) evt;

            switch (e.code) {
                case "KeyP":
                    activeCamera = cameraPerspective;
                    activeHelper = cameraPerspectiveHelper;
                    break;
                case "KeyO":
                    activeCamera = cameraOrtho;
                    activeHelper = cameraOrthoHelper;
                    break;
            }
        }
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

        info.innerHTML = "<div style=\"color:yellowgreen\"><a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> - cameras<br/>\n" +
                "\t\t<b>O</b> orthographic <b>P</b> perspective</div>";

        run = true;
        animate();
    }


}
