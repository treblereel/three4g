package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.core.TypedArray;
import elemental2.core.Uint16Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import java.util.Random;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.geometries.SphereGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
public class WebglCustomAttributesPoints2 extends Attachable {

    public static final String name = "custom / attributes / points 2";
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private Random random = new Random();
    private Points sphere;
    private int length1;

    private String fragmentShader = "\t\t\tuniform vec3 color;\n" +
            "\t\t\tuniform sampler2D texture;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvec4 color = vec4( color * vColor, 1.0 ) * texture2D( texture, gl_PointCoord );\n" +
            "\t\t\t\tgl_FragColor = color;\n" +
            "\t\t\t}";


    private String vertexShader = "\tattribute float size;\n" +
            "\t\t\tattribute vec3 ca;\n" +
            "\t\t\tvarying vec3 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvColor = ca;\n" +
            "\t\t\t\tvec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t\tgl_PointSize = size * ( 300.0 / -mvPosition.z );\n" +
            "\t\t\t\tgl_Position = projectionMatrix * mvPosition;\n" +
            "\t\t\t}";

    public WebglCustomAttributesPoints2() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        camera = new PerspectiveCamera(45, aspect, 1, 10000);
        camera.position.z = 300;
        scene = new Scene();
        int radius = 100, segments = 68, rings = 38;
        JsArray<Vector3> vertices1 = new SphereGeometry(radius, segments, rings).vertices;
        JsArray<Vector3> vertices2 = new BoxGeometry(0.8f * radius, 0.8f * radius, 0.8f * radius, 10, 10, 10).vertices;
        length1 = vertices1.length;
        JsArray<Vector3> vertices = vertices1.concat(Js.uncheckedCast(vertices2));
        Float32Array positions = new Float32Array(vertices.length * 3);
        Float32Array colors = new Float32Array(vertices.length * 3);
        Float32Array sizes = new Float32Array(vertices.length);
        Vector3 vertex;
        Color color = new Color();
        for (int i = 0, l = vertices.length; i < l; i++) {
            vertex = vertices.getAt(i);
            vertex.toArray(positions, i * 3);
            if (i < length1) {
                color.setHSL(0.01f + 0.1f * ((float) i / length1), 0.99f, (vertex.y + radius) / (4 * radius));
            } else {
                color.setHSL(0.6f, 0.75f, 0.25f + vertex.y / (2 * radius));
            }
            color.toArray(colors, i * 3);
            sizes.setAt(i, i < length1 ? 10.0 : 40);
        }
        BufferGeometry geometry = new BufferGeometry();
        geometry.addAttribute("position", new BufferAttribute(positions, 3));
        geometry.addAttribute("size", new BufferAttribute(sizes, 1));
        geometry.addAttribute("ca", new BufferAttribute(colors, 3));
        //
        Texture texture = new TextureLoader().load("textures/sprites/disc.png");
        texture.wrapS = THREE.RepeatWrapping;
        texture.wrapT = THREE.RepeatWrapping;
        //
        Uniforms uniforms = new Uniforms();
        uniforms.set("amplitude", 1.0);
        uniforms.set("texture", texture);
        uniforms.set("color", new Color(0xffffff));

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        shaderMaterialParameters.transparent = true;

        ShaderMaterial material = new ShaderMaterial(shaderMaterialParameters);

        sphere = new Points(geometry, material);
        scene.add(sphere);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }


    public void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" - custom attributes example - particles 2");
    }

    private void animate() {
        StatsProducer.getStats().update();
        DomGlobal.requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void sortPoints() {
        Vector3 vector = new Vector3();
        // Model View Projection matrix
        Matrix4 matrix = new Matrix4();
        matrix.multiplyMatrices(camera.projectionMatrix, camera.matrixWorldInverse);
        matrix.multiply(sphere.matrixWorld);
        //
        BufferGeometry geometry = sphere.geometry.cast();
        BufferAttribute index = geometry.getIndex();
        TypedArray positions = geometry.getAttribute("position").array;
        int length = positions.length / 3;
        if (index == null) {
            Uint16Array array = new Uint16Array(length);
            for (int i = 0; i < length; i++) {
                array.setAt(i, (double) i); //TODO elemental2 bug
            }
            index = new BufferAttribute(array, 1);
            geometry.setIndex(index);
        }

        JsArray<JsArray<Double>> sortArray = new JsArray();
        for (int i = 0; i < length; i++) {
            vector.fromArray(positions, i * 3);
            vector.applyMatrix4(matrix);
            JsArray temp = new JsArray();
            temp.setAt(0, vector.z);
            temp.setAt(1, i);
            sortArray.push(temp); //HERE
        }

        sortArray.sort((a, b) -> b.getAt(0) - a.getAt(0));

        TypedArray indices = index.array;
        for (int i = 0; i < length; i++) {
            indices.setAt(i, sortArray.getAt(i).getAt(1));
        }
        geometry.index.needsUpdate = true;
    }

    private void render() {
        float time = new Date().getTime() * 0.005f;
        sphere.rotation.y = 0.02f * time;
        sphere.rotation.z = 0.02f * time;
        BufferGeometry geometry = sphere.geometry.cast();
        for (int i = 0; i < geometry.attributes.size.array.length; i++) {
            if (i < length1) {
                geometry.attributes.size.array.setAt(i, 16 + 12 * Math.sin(0.1 * i + time));
            }
        }

        geometry.attributes.size.needsUpdate = true;
        sortPoints();
        renderer.render(scene, camera);
    }
}
