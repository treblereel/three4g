package org.treblereel.gwt.three4g.demo.client.effects;

import elemental2.core.JsArray;
import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.effects.StereoEffect;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static elemental2.dom.DomGlobal.window;

@ApplicationScoped
@Page(path = "webgl_effects_stereo")
public class WebglEffectsStereo implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private StereoEffect effect;

    private JsArray<Mesh> spheres = new JsArray<>();

    double windowHalfX = window.innerWidth / 2;
    double windowHalfY = window.innerHeight / 2;

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 1, 100000 );
        camera.position.z = 3200;

        scene = new Scene();

        scene.setBackground(new CubeTextureLoader()
                .<CubeTextureLoader>setPath( "textures/cube/Park3Med/" )
                .load(new String[] { "px.jpg", "nx.jpg", "py.jpg", "ny.jpg", "pz.jpg", "nz.jpg" } ));

        SphereGeometry geometry = new SphereGeometry( 100, 32, 16 );

        CubeTexture textureCube = new CubeTextureLoader()
                .<CubeTextureLoader>setPath( "textures/cube/Park3Med/" )
                .load(new String[] { "px.jpg", "nx.jpg", "py.jpg", "ny.jpg", "pz.jpg", "nz.jpg" } );


        textureCube.mapping = THREE.CubeRefractionMapping;

        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setColor(0xffffff);
        meshBasicMaterialParameters.setEnvMap(textureCube);
        meshBasicMaterialParameters.setRefractionRatio(0.95);

        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        for ( int i = 0; i < 500; i ++ ) {

            Mesh mesh = new Mesh( geometry, material );
            mesh.position.x = Math.random() * 10000 - 5000;
            mesh.position.y = Math.random() * 10000 - 5000;
            mesh.position.z = Math.random() * 10000 - 5000;
            mesh.scale.x = mesh.scale.y = mesh.scale.z = Math.random() * 3 + 1;
            scene.add( mesh );

            spheres.push( mesh );

        }

        //

        renderer = new WebGLRenderer();
        renderer.setPixelRatio( window.devicePixelRatio );
        root.appendChild( renderer.domElement );

        effect = new StereoEffect( renderer );
        effect.setSize( window.innerWidth, window.innerHeight );

        window.addEventListener("resize", e -> onWindowResize());
        DomGlobal.document.addEventListener( "mousemove", evt -> onDocumentMouseMove(evt) );

        ready = true;

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onDocumentMouseMove(Event e) {

        MouseEvent event = (MouseEvent) e;

        mouseX = (event.clientX - root.clientWidth / 2) / 100;
        mouseY = (event.clientY - root.clientHeight / 2) / 100;

    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {

            windowHalfX = window.innerWidth / 2;
            windowHalfY = window.innerHeight / 2;

            camera.aspect = window.innerWidth / window.innerHeight;
            camera.updateProjectionMatrix();

            effect.setSize( window.innerWidth, window.innerHeight );

        }
    }

    private double mouseX = 0;
    private double mouseY = 0;

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {

            double timer = JsDate.now() * 0.0001 ;

            camera.position.x += ( mouseX - camera.position.x ) * .05;
            camera.position.y += ( - mouseY - camera.position.y ) * .05;

            camera.lookAt( scene.position );

            for ( int i = 0, il = spheres.length; i < il; i ++ ) {

                Mesh sphere = spheres.getAt(i);

                sphere.position.x = 5000 * Math.cos( timer + i );
                sphere.position.y = 5000 * Math.sin( timer + i * 1.1 );

            }

            effect.render( scene, camera );
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - effects - stereo. skybox by <a href=\"http://www.zfight.com/\" target=\"_blank\" rel=\"noopener\">Jochum Skoglund</a>";

        run = true;
        animate();
    }
}
