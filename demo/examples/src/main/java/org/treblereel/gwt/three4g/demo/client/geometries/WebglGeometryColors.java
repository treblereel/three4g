package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.Float32Array;
import elemental2.dom.*;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.IcosahedronGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_colors")
public class WebglGeometryColors implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Stats stats = new Stats();

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera( 20, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 10000 );
        camera.position.z = 3200;

        scene = new Scene();
        scene.setBackground(new Color( 0xffffff ));

        DirectionalLight light = new DirectionalLight( 0xffffff );
        light.position.set( 0, 0, 1 );
        scene.add( light );

        // shadow

        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement( "canvas" );
        canvas.width = 128;
        canvas.height = 128;

        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext( "2d" ));


        CanvasGradient gradient = context.createRadialGradient( canvas.width / 2, canvas.height / 2, 0, canvas.width / 2, canvas.height / 2, canvas.width / 2 );
        gradient.addColorStop( 0.1, "rgba(210,210,210,1)" );
        gradient.addColorStop( 1, "rgba(255,255,255,1)" );

        context.fillStyle = BaseRenderingContext2D.FillStyleUnionType.of(gradient);
        context.fillRect( 0, 0, canvas.width, canvas.height );

        CanvasTexture shadowTexture = new CanvasTexture( canvas );

        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setMap(shadowTexture);
        MeshBasicMaterial shadowMaterial = new MeshBasicMaterial(meshBasicMaterialParameters);
        PlaneGeometry shadowGeo = new PlaneGeometry( 300, 300, 1, 1 );

        Mesh shadowMesh = new Mesh( shadowGeo, shadowMaterial );
        shadowMesh.position.y = - 250;
        shadowMesh.rotation.x = - Math.PI / 2;
        scene.add( shadowMesh );

        shadowMesh = new Mesh( shadowGeo, shadowMaterial );
        shadowMesh.position.y = - 250;
        shadowMesh.position.x = - 400;
        shadowMesh.rotation.x = - Math.PI / 2;
        scene.add( shadowMesh );

        shadowMesh = new Mesh( shadowGeo, shadowMaterial );
        shadowMesh.position.y = - 250;
        shadowMesh.position.x = 400;
        shadowMesh.rotation.x = - Math.PI / 2;
        scene.add( shadowMesh );

		double radius = 200;

        IcosahedronGeometry geometry1 = new IcosahedronGeometry( radius, 1 );

        int count = geometry1.attributes.get("position").asBufferAttribute().count;
        geometry1.setAttribute( "color", new BufferAttribute( new Float32Array( count * 3 ), 3 ) );

        BufferGeometry geometry2 = geometry1.clone_();
        BufferGeometry geometry3 = geometry1.clone_();

        Color color = new Color();
        BufferAttribute positions1 = geometry1.attributes.get("position").asBufferAttribute();
        BufferAttribute positions2 = geometry2.attributes.get("position").asBufferAttribute();
        BufferAttribute positions3 = geometry3.attributes.get("position").asBufferAttribute();
        BufferAttribute colors1 = geometry1.attributes.get("color").asBufferAttribute();
        BufferAttribute colors2 = geometry2.attributes.get("color").asBufferAttribute();
        BufferAttribute colors3 = geometry3.attributes.get("color").asBufferAttribute();

        for ( int i = 0; i < count; i ++ ) {

            color.setHSL( ( positions1.getY( i ) / radius + 1 ) / 2, 1.0, 0.5 );
            colors1.setXYZ( i, color.r, color.g, color.b );

            color.setHSL( 0, ( positions2.getY( i ) / radius + 1 ) / 2, 0.5 );
            colors2.setXYZ( i, color.r, color.g, color.b );

            color.setRGB( 1, 0.8 - ( positions3.getY( i ) / radius + 1 ) / 2, 0 );
            colors3.setXYZ( i, color.r, color.g, color.b );

        }

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setColor(0xffffff);
        meshPhongMaterialParameters.setFlatShading(true);
        meshPhongMaterialParameters.setVertexColors(true);
        meshPhongMaterialParameters.setShininess(0);

        MeshPhongMaterial material = new MeshPhongMaterial(meshPhongMaterialParameters);

        MeshBasicMaterialParameters meshBasicMaterialParameters1 = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters1.setColor(0x000000);
        meshBasicMaterialParameters1.setWireframe(true);
        meshBasicMaterialParameters1.setTransparent(true);

        MeshBasicMaterial wireframeMaterial = new MeshBasicMaterial(meshBasicMaterialParameters1);

        Mesh mesh = new Mesh( geometry1, material );
        Mesh wireframe = new Mesh( geometry1, wireframeMaterial );
        mesh.add( wireframe );
        mesh.position.x = - 400;
        mesh.rotation.x = - 1.87;
        scene.add( mesh );

        mesh = new Mesh( geometry2, material );
        wireframe = new Mesh( geometry2, wireframeMaterial );
        mesh.add( wireframe );
        mesh.position.x = 400;
        scene.add( mesh );

        mesh = new Mesh( geometry3, material );
        wireframe = new Mesh( geometry3, wireframeMaterial );
        mesh.add( wireframe );
        scene.add( mesh );

        //
        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );
        root.appendChild( renderer.domElement );

        stats = new Stats();
        root.appendChild( stats.dom );

        DomGlobal.document.addEventListener( "mousemove", this::onDocumentMouseMove);
        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    double mouseX = 0, mouseY = 0;

    double windowHalfX = DomGlobal.window.innerWidth / 2;
    double windowHalfY = DomGlobal.window.innerHeight / 2;

    private void onDocumentMouseMove(Event e) {
        MouseEvent event = (MouseEvent) e;
        mouseX = ( event.clientX - windowHalfX );
        mouseY = ( event.clientY - windowHalfY );
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

            renderer.setSize( DomGlobal.window.innerWidth, DomGlobal.window.innerHeight );

        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            stats.update();

            camera.position.x += ( mouseX - camera.position.x ) * 0.05;
            camera.position.y += ( - mouseY - camera.position.y ) * 0.05;

            camera.lookAt( scene.position );

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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> webgl - vertex color";

        run = true;
        animate();
    }
}
