package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.materials.RawShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.RawShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/21/18.
 */
public class WebglBuffergeometryInstancing extends Attachable {

    public static final String name = "buffergeometry / instancing";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private int particles = 100000;
    private Random random = new Random();


    private String fragmentShader = "precision highp float;\n" +
            "\t\tuniform float time;\n" +
            "\t\tvarying vec3 vPosition;\n" +
            "\t\tvarying vec4 vColor;\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tvec4 color = vec4( vColor );\n" +
            "\t\t\tcolor.r += sin( vPosition.x * 10.0 + time ) * 0.5;\n" +
            "\t\t\tgl_FragColor = color;\n" +
            "\t\t}";


    private String vertexShader = "precision highp float;\n" +
            "\t\tuniform float sineTime;\n" +
            "\t\tuniform mat4 modelViewMatrix;\n" +
            "\t\tuniform mat4 projectionMatrix;\n" +
            "\t\tattribute vec3 position;\n" +
            "\t\tattribute vec3 offset;\n" +
            "\t\tattribute vec4 color;\n" +
            "\t\tattribute vec4 orientationStart;\n" +
            "\t\tattribute vec4 orientationEnd;\n" +
            "\t\tvarying vec3 vPosition;\n" +
            "\t\tvarying vec4 vColor;\n" +
            "\t\tvoid main(){\n" +
            "\t\t\tvPosition = offset * max( abs( sineTime * 2.0 + 1.0 ), 0.5 ) + position;\n" +
            "\t\t\tvec4 orientation = normalize( mix( orientationStart, orientationEnd, sineTime ) );\n" +
            "\t\t\tvec3 vcV = cross( orientation.xyz, vPosition );\n" +
            "\t\t\tvPosition = vcV * ( 2.0 * orientation.w ) + ( cross( orientation.xyz, vcV ) * 2.0 + vPosition );\n" +
            "\t\t\tvColor = color;\n" +
            "\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( vPosition, 1.0 );\n" +
            "\t\t}";

    public WebglBuffergeometryInstancing() {


        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);


        camera = new PerspectiveCamera(50, aspect, 1, 10);
        camera.position.z = 2;
        scene = new Scene();
        // geometry
        Vector4 vector = new Vector4();
        int instances = 50000;

        Double.valueOf(0.5925247710102289);

        JsArray positions = new JsArray();
        JsArray offsets = new JsArray();
        JsArray colors = new JsArray();
        JsArray orientationsStart = new JsArray();
        JsArray orientationsEnd = new JsArray();

        positions.push(0.025, -0.025, 0);
        positions.push(-0.025, 0.025, 0);
        positions.push(0, 0, 0.025);
        // instanced attributes
        for (int i = 0; i < instances; i++) {
            // offsets
            offsets.push(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5);
            // colors
            colors.push(Math.random(), Math.random(), Math.random(), Math.random());
            // orientation start
            vector.set(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1);
            vector.normalize();
            orientationsStart.push(vector.x, vector.y, vector.z, vector.w);
            // orientation end
            vector.set(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1);
            vector.normalize();
            orientationsEnd.push(vector.x, vector.y, vector.z, vector.w);
        }
        InstancedBufferGeometry geometry = new InstancedBufferGeometry();
        geometry.maxInstancedCount = instances; // set so its initalized for dat.GUI, will be set in first draw otherwise
        geometry.addAttribute("position", new Float32BufferAttribute(positions, 3));

        //TODO i ll be fixed in next elemental2 version
        GWT.log("1");
        geometry.addAttribute("offset", new InstancedBufferAttribute(toFloat32Array(offsets), 3));
        GWT.log("2");

        geometry.addAttribute("color", new InstancedBufferAttribute(toFloat32Array(colors), 4));
        GWT.log("3");

        geometry.addAttribute("orientationStart", new InstancedBufferAttribute(toFloat32Array(orientationsStart), 4));
        GWT.log("4");

        geometry.addAttribute("orientationEnd", new InstancedBufferAttribute(toFloat32Array(orientationsEnd), 4));
        // material
        RawShaderMaterialParameters rawShaderMaterialParameters = new RawShaderMaterialParameters();
        Uniforms uniforms = new Uniforms();
        uniforms.set("time", 1.0);
        uniforms.set("sineTime", 1.0);
        rawShaderMaterialParameters.uniforms = uniforms;
        rawShaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        rawShaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        rawShaderMaterialParameters.side = THREE.DoubleSide;
        rawShaderMaterialParameters.transparent = true;

        RawShaderMaterial material = new RawShaderMaterial(rawShaderMaterialParameters);

        //
        Mesh mesh = new Mesh(geometry, material);
        scene.add(mesh);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);
        gui.add("maxInstancedCount", instances, 0, instances).onChange(result -> geometry.maxInstancedCount = result.intValue());
        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    private Float32Array toFloat32Array(JsArray<Double> array) {
        Float32Array offsetsFloat32Array = new Float32Array(array.length);
        for (int i = 0; i < array.length; i++) {
            offsetsFloat32Array.setAt(i, Js.uncheckedCast(array.getAt(i))); //TODO looks like a gwt bug
        }
        return offsetsFloat32Array;
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" - instancing demo (single triangle)");
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

    private void render() {
        float time = (float) DomGlobal.performance.now();
        Mesh object = scene.children[0].cast();
        object.rotation.y = time * 0.0005f;
        float t = time * 0.005f;
        ((RawShaderMaterial) object.material).uniforms.set("time", t);
        ((RawShaderMaterial) object.material).uniforms.set("sineTime", Math.sin(t * 0.05));
        renderer.render(scene, camera);
    }
}