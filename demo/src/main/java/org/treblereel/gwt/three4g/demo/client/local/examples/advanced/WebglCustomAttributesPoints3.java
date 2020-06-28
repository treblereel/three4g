package org.treblereel.gwt.three4g.demo.client.local.examples.advanced;

import static elemental2.dom.DomGlobal.document;

import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/23/18.
 */
public class WebglCustomAttributesPoints3 extends Attachable {

    public static final String name = "custom / attributes / points 3";
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;
    private Points object;
    private Random random = new Random();
    private Matrix4 matrix = new Matrix4();
    private Vector3 position = new Vector3();
    private Euler rotation = new Euler();
    private Quaternion quaternion = new Quaternion();
    private Vector3 scale = new Vector3(1, 1, 1);
    private JsArray<Vector3> vertices = new JsArray();
    private int vertices1;


    private String fragmentShader = "uniform vec3 color;\n" +
            "\t\t\tuniform sampler2D texture;\n" +
            "\t\t\tvarying vec4 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvec4 outColor = texture2D( texture, gl_PointCoord );\n" +
            "\t\t\t\tif ( outColor.a < 0.5 ) discard;\n" +
            "\t\t\t\tgl_FragColor = outColor * vec4( color * vColor.xyz, 1.0 );\n" +
            "\t\t\t\tfloat depth = gl_FragCoord.z / gl_FragCoord.w;\n" +
            "\t\t\t\tconst vec3 fogColor = vec3( 0.0 );\n" +
            "\t\t\t\tfloat fogFactor = smoothstep( 200.0, 600.0, depth );\n" +
            "\t\t\t\tgl_FragColor = mix( gl_FragColor, vec4( fogColor, gl_FragColor.w ), fogFactor );\n" +
            "\t\t\t}";


    private String vertexShader = "\t\t\tattribute float size;\n" +
            "\t\t\tattribute vec4 ca;\n" +
            "\t\t\tvarying vec4 vColor;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvColor = ca;\n" +
            "\t\t\t\tvec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t\tgl_PointSize = size * ( 150.0 / -mvPosition.z );\n" +
            "\t\t\t\tgl_Position = projectionMatrix * mvPosition;\n" +
            "\t\t\t}";

    public WebglCustomAttributesPoints3() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        camera = new PerspectiveCamera(40, aspect, 1, 1000);
        camera.position.z = 500;
        scene = new Scene();
        float radius = 100, inner = 0.6f * radius;
        for (int i = 0; i < 100000; i++) {
            Vector3 vertex = new Vector3();
            vertex.x = random.nextFloat() * 2 - 1;
            vertex.y = random.nextFloat() * 2 - 1;
            vertex.z = random.nextFloat() * 2 - 1;
            vertex.multiplyScalar(radius);
            if ((vertex.x > inner || vertex.x < -inner) ||
                    (vertex.y > inner || vertex.y < -inner) ||
                    (vertex.z > inner || vertex.z < -inner))
                vertices.push(vertex);
        }
        vertices1 = vertices.length;
        radius = 200;
        BoxGeometry geometry2 = new BoxGeometry(radius, 0.1f * radius, 0.1f * radius, 50, 5, 5);


        addGeo(geometry2, 0, 110, 110, 0);
        addGeo(geometry2, 0, 110, -110, 0);
        addGeo(geometry2, 0, -110, 110, 0);
        addGeo(geometry2, 0, -110, -110, 0);
        // side 2
        addGeo(geometry2, 110, 110, 0, (float) Math.PI / 2);
        addGeo(geometry2, 110, -110, 0, (float) Math.PI / 2);
        addGeo(geometry2, -110, 110, 0, (float) Math.PI / 2);
        addGeo(geometry2, -110, -110, 0, (float) Math.PI / 2);
        // corner edges
        BoxGeometry geometry3 = new BoxGeometry(0.1f * radius, radius * 1.2f, 0.1f * radius, 5, 60, 5);
        addGeo(geometry3, 110, 0, 110, 0);
        addGeo(geometry3, 110, 0, -110, 0);
        addGeo(geometry3, -110, 0, 110, 0);
        addGeo(geometry3, -110, 0, -110, 0);
        Float32Array positions = new Float32Array(vertices.length * 3);
        Float32Array colors = new Float32Array(vertices.length * 3);
        Float32Array sizes = new Float32Array(vertices.length);
        Vector3 vertex;
        Color color = new Color();


        for (int i = 0; i < vertices.length; i++) {
            vertex = vertices.getAt(i);
            vertex.toArray(positions, i * 3);
            if (i < vertices1) {
                color.setHSL(0.5f + 0.2f * (i / vertices1), 1, 0.5f);
            } else {
                color.setHSL(0.1f, 1, 0.5f);
            }
            color.toArray(colors, i * 3);
            sizes.setAt(i, i < vertices1 ? 10.0 : 40);
        }


        BufferGeometry geometry = new BufferGeometry();
        geometry.addAttribute("position", new BufferAttribute(positions, 3));
        geometry.addAttribute("size", new BufferAttribute(sizes, 1));
        geometry.addAttribute("ca", new BufferAttribute(colors, 3));
        //
        Texture texture = new TextureLoader().load("textures/sprites/ball.png");
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

        object = new Points(geometry, material);
        scene.add(object);

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setInnetHtml(" - custom attributes example - particles 3");
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

    private void addGeo(BoxGeometry geo, float x, float y, float z, float ry) {
        position.set(x, y, z);
        rotation.set(0, ry, 0);
        matrix.compose(position, quaternion.setFromEuler(rotation), scale);
        for (int i = 0, l = geo.vertices.length; i < l; i++) {
            Vector3 vertex = geo.vertices.getAt(i);
            vertices.push(vertex.clone().applyMatrix4(matrix));
        }
    }

    private void render() {
        float time = new Date().getTime() * 0.01f;
        object.rotation.y = object.rotation.z = 0.02f * time;
        BufferGeometry geometry = object.geometry.cast();
        for (int i = 0; i < geometry.attributes.size.array.length; i++) {
            if (i < vertices1) {
                geometry.attributes.size.array.setAt(i, Math.max(0, 26 + 32 * Math.sin(0.1 * i + 0.6 * time)));
            }
        }
        geometry.attributes.size.needsUpdate = true;
        renderer.render(scene, camera);
    }
}