package org.treblereel.gwt.three4g.demo.client.local.examples.interactive;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/6/18.
 */
public class WebglInteractivePoints extends Attachable {

    public static final String name = "interactive / points";

    private Points particles;
    private Double PARTICLE_SIZE = 20d;
    private Raycaster raycaster;
    private Intersect[] intersects;
    private Vector2 mouse;
    private int INTERSECTED = -1;

    public WebglInteractivePoints() {
        scene = new Scene();
        camera = new PerspectiveCamera(45, aspect, 1, 10000);
        camera.position.z = 250;
        //

        BoxGeometry geometry1 = new BoxGeometry(200, 200, 200, 16, 16, 16);
        JsArray<Vector3> vertices = geometry1.vertices;
        float[] positions = new float[vertices.length * 3];
        float[] colors = new float[vertices.length * 3];
        float[] sizes = new float[vertices.length];

        Color color = new Color();
        for (int i = 0, l = vertices.length; i < l; i++) {
            Vector3 vertex = vertices.getAt(i);
            vertex.toArray(positions, i * 3);
            color.setHSL(0.01f + 0.1f * (i * 1.0f / l), 1.0f, 0.5f);
            color.toArray(colors, i * 3);
            sizes[i] = PARTICLE_SIZE.floatValue() * 0.5f;
        }
        BufferGeometry geometry = new BufferGeometry();

        geometry.addAttribute("position", new Float32BufferAttribute(positions, 3).set(positions));
        geometry.addAttribute("customColor", new Float32BufferAttribute(colors, 3).set(colors));
        geometry.addAttribute("size", new Float32BufferAttribute(sizes, 1).set(sizes));
        //
        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();


        Uniforms uniforms = new Uniforms();

        uniforms.set("color", new Color(0xffffff));
        uniforms.set("texture", new TextureLoader().load("textures/sprites/disc.png"));
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.fragmentShader = ShaderResource.INSTANCE.fragmentshader().getText();
        shaderMaterialParameters.vertexShader = ShaderResource.INSTANCE.vertexshader().getText();
        shaderMaterialParameters.alphaTest = 0.9f;

        ShaderMaterial material = new ShaderMaterial(shaderMaterialParameters);

        particles = new Points(geometry, material);
        scene.add(particles);
        //
        renderer = new WebGLRenderer();

        container.appendChild(renderer.domElement);

        raycaster = new Raycaster();
        mouse = new Vector2();
        //
        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };

    }

    public void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("webgl - interactive - particles ");
    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float) (((event.clientX - panel.offsetWidth) / (window.innerWidth - panel.offsetWidth)) * 2 - 1);
        mouse.y = (float) (-(event.clientY / window.innerHeight) * 2 + 1);
    }

    private void render() {
        particles.rotation.x += 0.0005;
        particles.rotation.y += 0.001;
        BufferGeometry geometry = (BufferGeometry) particles.geometry;
        BufferAttribute attribute = geometry.getAttribute("size");

        raycaster.setFromCamera(mouse, camera);

        intersects = raycaster.intersectObject(particles);

        if (intersects.length > 0) {
            if (INTERSECTED != intersects[0].index) {
                attribute.array.getAt(intersects[0].index);
                INTERSECTED = intersects[0].index;
                attribute.array.setAt(INTERSECTED, PARTICLE_SIZE * 1.25);
                attribute.needsUpdate = true;
            }
        } else if (INTERSECTED != -1) {
            attribute.array.setAt(INTERSECTED, PARTICLE_SIZE);
            attribute.needsUpdate = true;
            INTERSECTED = -1;
        }
        renderer.render(scene, camera);
    }
}
