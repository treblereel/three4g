package org.treblereel.gwt.three4g.demo;

import elemental2.dom.DomGlobal;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.params.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.params.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.j2cl.processors.annotations.GWT3EntryPoint;

public class App {

    private PerspectiveCamera camera;
    private Scene scene;
    private Mesh mesh;
    private WebGLRenderer renderer;

    @GWT3EntryPoint
    public void onModuleLoad() {

        camera = new PerspectiveCamera( 70, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000 );
        camera.position.z = 400;

        scene = new Scene();

        Texture texture = new TextureLoader().load("https://threejs.org/examples/textures/crate.gif" );

        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.map = texture;

        BoxBufferGeometry geometry = new BoxBufferGeometry(200, 200, 200 );
        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        mesh = new Mesh( geometry, material );
        scene.add( mesh );

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        DomGlobal.document.body.appendChild( renderer.domElement );

        //

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

        animate();
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
