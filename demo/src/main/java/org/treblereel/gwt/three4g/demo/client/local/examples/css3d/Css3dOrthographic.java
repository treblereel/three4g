package org.treblereel.gwt.three4g.demo.client.local.examples.css3d;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.renderers.CSS3DObject;
import org.treblereel.gwt.three4g.extensions.renderers.CSS3DRenderer;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/11/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, CSS3DRenderer.class})
public class Css3dOrthographic extends Attachable {

    public static final String name = "orthographic";

    private Scene scene2;
    private OrthographicCamera camera;
    private CSS3DRenderer renderer2;
    private MeshBasicMaterial material;

    public Css3dOrthographic() {

        int frustumSize = 500;
        camera = new OrthographicCamera(frustumSize * aspect / -2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / -2, 1, 1000);
        camera.position.set(-200, 200, 200);

        orbitControls = new OrbitControls(camera);

        scene = new Scene();
        scene.background = new Color(0xf0f0f0);
        scene2 = new Scene();

        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.color = new Color(0x000000);
        parameters.wireframe = true;
        parameters.wireframeLinewidth = 1;
        parameters.side = THREE.DoubleSide;

        material = new MeshBasicMaterial(parameters);
        // left
        createPlane(
                100, 100,
                "chocolate",
                new Vector3(-50, 0, 0),
                new Euler(0, -90 * org.treblereel.gwt.three4g.math.Math.DEG2RAD, 0)
        );
        // right
        createPlane(
                100, 100,
                "saddlebrown",
                new Vector3(0, 0, 50),
                new Euler(0, 0, 0)
        );
        // top
        createPlane(
                100, 100,
                "yellowgreen",
                new Vector3(0, 50, 0),
                new Euler(-90 * org.treblereel.gwt.three4g.math.Math.DEG2RAD, 0, 0)
        );


        createPlane(
                300, 300,
                "seagreen",
                new Vector3(0, -50, 0),
                new Euler(-90 * org.treblereel.gwt.three4g.math.Math.DEG2RAD, 0, 0)
        );
        //
        renderer = new WebGLRenderer();
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(getWidth(), getHeight());

        renderer2 = new CSS3DRenderer();
        renderer2.setSize(getWidth(), getHeight());
        renderer2.domElement.style.position = "absolute";
        renderer2.domElement.style.top = "0";
    }

    public void createPlane(int width, int height, String cssColor, Vector3 pos, Euler rot) {
        HTMLDivElement element = (HTMLDivElement) DomGlobal.document.createElement("div");

        element.style.width = CSSProperties.WidthUnionType.of(width + "px");
        element.style.height = CSSProperties.HeightUnionType.of(height + "px");
        element.style.opacity = CSSProperties.OpacityUnionType.of(0.75);
        element.style.background = cssColor;
        CSS3DObject object = new CSS3DObject(element);
        object.position.copy(pos);
        object.rotation.copy(rot);
        scene2.add(object);
        PlaneBufferGeometry geometry = new PlaneBufferGeometry(width, height);
        Mesh mesh = new Mesh(geometry, material);
        mesh.position.copy(object.position);
        mesh.rotation.copy(object.rotation);
        scene.add(mesh);
    }


    @Override
    public void detach() {
        super.detach();
        root.removeChild(renderer2.domElement);
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(renderer.domElement);
        root.appendChild(renderer2.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                renderer.render(scene, camera);
                renderer2.render(scene2, camera);
                animate();
            }
        });
    }

}


