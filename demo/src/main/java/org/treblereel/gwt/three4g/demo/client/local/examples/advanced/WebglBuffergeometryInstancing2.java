package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.dom.HTMLScriptElement;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.core.InstancedBufferGeometry;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.geometries.IcosahedronBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/21/18.
 */
@InjectJavaScriptFor(elements = TrackballControls.class)
public class WebglBuffergeometryInstancing2 extends Attachable {

    public static final String name = "buffergeometry / instancing 2";

    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private Random random = new Random();
    private boolean ANGLE_instanced_arrays = false;


    private String fragmentShader = "precision highp float;\n" +
            "\t\tvarying vec3 vColor;\n" +
            "\t\tvoid main() {\n" +
            "\t\t\tgl_FragColor = vec4( vColor, 1.0 );\n" +
            "\t\t}";


    private String vertexShader = "precision highp float;\n" +
            "\t\tattribute vec3 instancePosition;\n" +
            "\t\tattribute vec4 instanceQuaternion;\n" +
            "\t\tattribute vec3 instanceScale;\n" +
            "\t\tvarying vec3 vColor;\n" +
            "\t\tvec3 applyTRS( vec3 position, vec3 translation, vec4 quaternion, vec3 scale ) {\n" +
            "\t\t\tposition *= scale;\n" +
            "\t\t\tposition += 2.0 * cross( quaternion.xyz, cross( quaternion.xyz, position ) + quaternion.w * position );\n" +
            "\t\t\treturn position + translation;\n" +
            "\t\t}\n" +
            "\t\tvoid main(){\n" +
            "\t\t\tvColor = color;\n" +
            "\t\t\tvec3 transformed = applyTRS( position.xyz, instancePosition, instanceQuaternion, instanceScale );\n" +
            "\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( transformed, 1.0 );\n" +
            "\t\t}";

    public WebglBuffergeometryInstancing2() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);


        camera = new PerspectiveCamera(50, aspect, 0.01f, 100);
        camera.position.z = 4;
        trackballControls = new TrackballControls(camera);
        scene = new Scene();
        //
        IcosahedronBufferGeometry geometry = new IcosahedronBufferGeometry(0.1f, 1);
        JsArray colors = new JsArray();
        for (int i = 0, l = geometry.attributes.position.count; i < l; i++) {
            colors.push(Math.random(), Math.random(), Math.random());
        }
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
        MeshBasicMaterial material = new MeshBasicMaterial();
        material.color = new Color(0xff0000);
        material.vertexColors = THREE.VertexColors;
        //
        int instances = 100;
        JsArray instancePositions = new JsArray();
        JsArray instanceQuaternions = new JsArray();
        JsArray instanceScales = new JsArray();
        // we create for each mesh a counterpart in our instanced geometry data
        for (int i = 0; i < instances; i++) {
            // the red meshes are drawn with separate draw calls
            Mesh mesh = new Mesh(geometry, material);
            scene.add(mesh);
            Vector3 position = mesh.position;
            Quaternion quaternion = mesh.quaternion;
            Vector3 scale = mesh.scale;

            position.set(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1);
            quaternion.set(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1);
            quaternion.normalize();

            scale.set(random.nextFloat() * 2, random.nextFloat() * 2, random.nextFloat() * 2);
            // instanced attribute data
            instancePositions.push(position.x, position.y, position.z);
            instanceQuaternions.push(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
            instanceScales.push(scale.x, scale.y, scale.z);
        }
        InstancedBufferGeometry instancedGeometry = new InstancedBufferGeometry();
        instancedGeometry.attributes.position = geometry.attributes.position;
        instancedGeometry.attributes.color = geometry.attributes.color;
        instancedGeometry.addAttribute("instancePosition", new InstancedBufferAttribute(toFloat32Array(instancePositions), 3));
        instancedGeometry.addAttribute("instanceQuaternion", new InstancedBufferAttribute(toFloat32Array(instanceQuaternions), 4));
        instancedGeometry.addAttribute("instanceScale", new InstancedBufferAttribute(toFloat32Array(instanceScales), 3));
        //

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        Uniforms uniforms = new Uniforms();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        ShaderMaterial shaderMaterial = new ShaderMaterial(shaderMaterialParameters);
        shaderMaterial.vertexColors = THREE.VertexColors;

        // counterparts are drawn all at once with a single draw call (via instanced rendering)
        Mesh instancedMesh = new Mesh(instancedGeometry, shaderMaterial);
        instancedMesh.position.x = 0.1f;
        scene.add(instancedMesh);
        //
        if (renderer.extensions.hasProperty("ANGLE_instanced_arrays")) {
            ANGLE_instanced_arrays = false;
        }

        trackballControls = new TrackballControls(camera);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
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
        String text = "- instancing demo (single triangle)";
        if (!ANGLE_instanced_arrays) {
            text = text + "<br><div id=\"notSupported\" style=\"display:none\">Sorry your graphics card + browser does not support hardware instancing</div>";
        }

        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(text);
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
        trackballControls.update();
        renderer.render(scene, camera);
    }
}
