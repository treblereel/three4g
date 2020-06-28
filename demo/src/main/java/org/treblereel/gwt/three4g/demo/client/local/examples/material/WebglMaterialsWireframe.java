package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.Float32Array;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/8/18.
 */
public class WebglMaterialsWireframe extends Attachable {

    public static final String name = "materials / wireframe";
    private BoxBufferGeometry geometry;
    private MeshBasicMaterial material;
    private HTMLScriptElement fragmentShaderElm, vertexShaderElm;

    private String fragmentShader = "varying vec3 vCenter;\n" +
            "\t\t\tfloat edgeFactorTri() {\n" +
            "\t\t\t\tvec3 d = fwidth( vCenter.xyz );\n" +
            "\t\t\t\tvec3 a3 = smoothstep( vec3( 0.0 ), d * 1.5, vCenter.xyz );\n" +
            "\t\t\t\treturn min( min( a3.x, a3.y ), a3.z );\n" +
            "\t\t\t}\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tgl_FragColor.rgb = mix( vec3( 1.0 ), vec3( 0.2 ), edgeFactorTri() );\n" +
            "\t\t\t\tgl_FragColor.a = 1.0;\n" +
            "\t\t\t}";


    private String vertexShader = "\tattribute vec3 center;\n" +
            "\t\t\tvarying vec3 vCenter;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvCenter = center;\n" +
            "\t\t\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t}";


    public WebglMaterialsWireframe() {

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        float size = 150;
        camera = new PerspectiveCamera(40, aspect, 1, 2000);
        camera.position.z = 800;
        scene = new Scene();
        //
        geometry = new BoxBufferGeometry(size, size, size);
        material = new MeshBasicMaterial();
        material.wireframe = true;
        mesh = new Mesh(geometry, material);
        mesh.position.x = -150;
        scene.add(mesh);
        //
        BoxBufferGeometry geometry = new BoxBufferGeometry(size, size, size);

        BufferGeometry toNonIndexedgeometry = geometry.toNonIndexed();
        setupAttributes(toNonIndexedgeometry);

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;

        ShaderMaterial shaderMaterial = new ShaderMaterial(shaderMaterialParameters);
        shaderMaterial.getExtensions().derivatives = true;

        mesh = new Mesh(toNonIndexedgeometry, shaderMaterial);
        mesh.position.x = 150;
        scene.add(mesh);
        //
        SphereBufferGeometry sphereBufferGeometry = new SphereBufferGeometry(size / 2, 32, 16);
        toNonIndexedgeometry = sphereBufferGeometry.toNonIndexed();
        setupAttributes(toNonIndexedgeometry);

        shaderMaterialParameters = new ShaderMaterialParameters();
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;

        shaderMaterial = new ShaderMaterial(shaderMaterialParameters);
        shaderMaterial.getExtensions().derivatives = true;

        mesh = new Mesh(toNonIndexedgeometry, shaderMaterial);
        mesh.position.x = -150;
        scene.add(mesh);

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
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
                render();
                animate();
            }
        });
    }

    private void setupAttributes(BufferGeometry geometry) {
        Vector3[] vectors = new Vector3[]{
                new Vector3(1, 0, 0),
                new Vector3(0, 1, 0),
                new Vector3(0, 0, 1)
        };

        BufferAttribute position = geometry.attributes.position;
        Float32Array centers = new Float32Array(position.count * 3);
        for (int i = 0, l = position.count; i < l; i++) {
            vectors[i % 3].toArray(centers, i * 3);
        }
        geometry.addAttribute("center", new BufferAttribute(centers, 3));
    }

    private void render() {
        for (int i = 0; i < scene.children.length; i++) {
            Object3D object = scene.children[i];
            object.rotation.x += 0.005;
            object.rotation.y += 0.01;
        }
        renderer.render(scene, camera);
    }

}



