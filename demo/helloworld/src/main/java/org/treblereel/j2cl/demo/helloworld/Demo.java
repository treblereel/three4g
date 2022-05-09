package org.treblereel.j2cl.demo.helloworld;

import elemental2.dom.DomGlobal;
import org.treblereel.gwt.three4g.ThreeBootstrap;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.j2cl.processors.annotations.GWT3EntryPoint;

public class Demo {

    private PerspectiveCamera camera;
    private Scene scene;
    private Mesh mesh;
    private WebGLRenderer renderer;

    private void startApp() {
        camera = new PerspectiveCamera( 70, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000 );
        camera.position.z = 400;
        scene = new Scene();
        Texture texture = new TextureLoader().load("https://threejs.org/examples/textures/crate.gif" );
        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setMap(texture);

        BoxGeometry geometry = new BoxGeometry(200, 200, 200 );
        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        mesh = new Mesh( geometry, material );

        scene.add( mesh );

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        DomGlobal.document.body.appendChild( renderer.domElement );

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

        animate();
    }

    @GWT3EntryPoint
    public void onLoad() {
        ThreeBootstrap.inject(() -> {
            startApp();
        });
    }

    private void  onWindowResize() {

        camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
        camera.updateProjectionMatrix();

        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        mesh.rotation.x += 0.005;
        mesh.rotation.y += 0.01;

        renderer.render( scene, camera );
    }

}
