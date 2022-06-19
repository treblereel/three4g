package org.treblereel.gwt.three4g.demo.client.geometries;


import elemental2.core.JsArray;
import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.*;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometries")
public class WebglGeometries implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Stats  stats = new Stats();

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera(45, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 2000);
        camera.position.y = 400;

        scene = new Scene();

        Mesh object;

        AmbientLight ambientLight = new AmbientLight( 0xcccccc, 0.4 );
        scene.add( ambientLight );

        PointLight pointLight = new PointLight( 0xffffff, 0.8 );
        camera.add( pointLight );
        scene.add( camera );

        Texture map = new TextureLoader().load( "textures/uv_grid_opengl.jpg" );

        map.wrapS = map.wrapT = THREE.RepeatWrapping;
        map.anisotropy = 16;

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setMap(map);
        meshPhongMaterialParameters.setSide(THREE.DoubleSide);

        MeshPhongMaterial material = new MeshPhongMaterial(meshPhongMaterialParameters);

        //

        object = new Mesh( new SphereGeometry( 75, 20, 10 ), material );
        object.position.set( - 300, 0, 200 );
        scene.add( object );

        object = new Mesh( new IcosahedronGeometry( 75, 1 ), material );
        object.position.set( - 100, 0, 200 );
        scene.add( object );

        object = new Mesh( new OctahedronGeometry( 75, 2 ), material );
        object.position.set( 100, 0, 200 );
        scene.add( object );

        object = new Mesh( new TetrahedronGeometry( 75, 0 ), material );
        object.position.set( 300, 0, 200 );
        scene.add( object );

        //

        object = new Mesh( new org.treblereel.gwt.three4g.geometries.parametric.PlaneGeometry( 100, 100, 4, 4 ), material );
        object.position.set( - 300, 0, 0 );
        scene.add( object );

        object = new Mesh( new BoxGeometry( 100, 100, 100, 4, 4, 4 ), material );
        object.position.set( - 100, 0, 0 );
        scene.add( object );

        object = new Mesh( new CircleGeometry( 50, 20, 0, Math.PI * 2 ), material );
        object.position.set( 100, 0, 0 );
        scene.add( object );

        object = new Mesh( new RingGeometry( 10, 50, 20, 5, 0, Math.PI * 2 ), material );
        object.position.set( 300, 0, 0 );
        scene.add( object );

        //

        object = new Mesh( new CylinderGeometry( 25, 75, 100, 40, 5 ), material );
        object.position.set( - 300, 0, - 200 );
        scene.add( object );

        JsArray<Vector2> points = new JsArray<>();

        for ( int i = 0; i < 50; i ++ ) {

            points.push( new Vector2( Math.sin( i * 0.2 ) * Math.sin( i * 0.1 ) * 15 + 50, ( i - 5 ) * 2 ) );

        }

        object = new Mesh( new LatheGeometry( points, 20 ), material );
        object.position.set( - 100, 0, - 200 );
        scene.add( object );

        object = new Mesh( new TorusGeometry( 50, 20, 20, 20 ), material );
        object.position.set( 100, 0, - 200 );
        scene.add( object );

        object = new Mesh( new TorusKnotGeometry( 50, 10, 50, 20 ), material );
        object.position.set( 300, 0, - 200 );
        scene.add( object );

        //
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        root.appendChild( renderer.domElement );

        stats = new Stats();
        root.appendChild( stats.dom );


        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            double timer = JsDate.now() * 0.0001;

            camera.position.x = Math.cos( timer ) * 800;
            camera.position.z = Math.sin( timer ) * 800;

            camera.lookAt( scene.position );

            scene.traverse(object -> {
                if ( object instanceof Mesh) {

                    object.rotation.x = timer * 5;
                    object.rotation.y = timer * 2.5;

                }
                return null;
            });
            renderer.render( scene, camera );
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> webgl - geometries";

        run = true;
        animate();
    }
}

