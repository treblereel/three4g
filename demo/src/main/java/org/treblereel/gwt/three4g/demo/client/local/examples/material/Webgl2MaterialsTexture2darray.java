package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import elemental2.core.ArrayBuffer;
import elemental2.core.Uint8Array;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLScriptElement;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.JSON;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.utils.JSZip;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.loaders.FileLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.DataTexture2DArray;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import static elemental2.dom.DomGlobal.document;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@InjectJavaScriptFor(elements = JSZip.class)
public class Webgl2MaterialsTexture2darray extends Attachable {

    public static final String name = "materials / 2D texture array";
    private HTMLScriptElement vs;
    private HTMLScriptElement fs;

    private String vsShader = "#version 300 es\n" +
            "\n" +
            "\tuniform vec2 size;\n" +
            "\tout vec2 vUv;\n" +
            "\n" +
            "\tvoid main() {\n" +
            "\n" +
            "\t\tgl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );\n" +
            "\n" +
            "\t\t// Convert position.xy to 1.0-0.0\n" +
            "\n" +
            "\t\tvUv.xy = position.xy / size + 0.5;\n" +
            "\t\tvUv.y = 1.0 - vUv.y; // original data is upside down\n" +
            "\n" +
            "\t}";
    private String fsShader = "#version 300 es\n" +
            "\n" +
            "\tprecision highp float;\n" +
            "\tprecision highp int;\n" +
            "\tprecision highp sampler2DArray;\n" +
            "\n" +
            "\tuniform sampler2DArray diffuse;\n" +
            "\tin vec2 vUv;\n" +
            "\tuniform int depth;\n" +
            "\tout vec4 out_FragColor;\n" +
            "\n" +
            "\tvoid main() {\n" +
            "\n" +
            "\t\tvec4 color = texture( diffuse, vec3( vUv, depth ) );\n" +
            "\n" +
            "\t\t// lighten a bit\n" +
            "\t\tout_FragColor = vec4( color.rrr * 1.5, 1.0 );\n" +
            "\n" +
            "\t}";
    private PerspectiveCamera camera;
    private Scene scene;
    private Mesh mesh;
    private int planeWidth = 50;
    private int planeHeight = 50;
    private float depthStep = 0.4f;

    public Webgl2MaterialsTexture2darray() {

        vs = (HTMLScriptElement) document.createElement("script");
        vs.type = "x-shader/x-vertex";
        vs.textContent = vsShader;
        document.body.appendChild(vs);

        fs = (HTMLScriptElement) document.createElement("script");
        fs.type = "x-shader/x-fragment";
        fs.textContent = fsShader;
        document.body.appendChild(fs);

        camera = new PerspectiveCamera(45, window.innerWidth / window.innerHeight, 0.1f, 2000);
        camera.position.z = 70;

        scene = new Scene();

        // width 256, height 256, depth 109, 8-bit, zip archived raw data
        new FileLoader()
                .setResponseType("arraybuffer")
                .load("textures/3d/head256x256x109.zip", new OnLoadCallback<ArrayBuffer>() {
                    @Override
                    public void onLoad(ArrayBuffer object) {

                        DomGlobal.console.log("onLoad 1 " + object);
                        DomGlobal.console.log("onLoad 2 " + JSON.stringify(object));

                        JSZip zip = new JSZip(object);
                        Uint8Array array = zip.getFile("head256x256x109").asUint8Array();

                        DataTexture2DArray texture = new DataTexture2DArray(array, 256, 256, 109);
                        texture.format = THREE.RedFormat;
                        texture.type = THREE.UnsignedByteType;

                        Uniforms uniforms = new Uniforms();
                        uniforms.set("diffuse", texture);
                        uniforms.set("depth", 55);
                        uniforms.set("size", new Vector2(planeWidth, planeHeight));

                        ShaderMaterialParameters parameters = new ShaderMaterialParameters();
                        parameters.uniforms = uniforms;
                        parameters.vertexShader = vs.textContent;
                        parameters.fragmentShader = fs.textContent;

                        ShaderMaterial material = new ShaderMaterial(parameters);
                        PlaneBufferGeometry geometry = new PlaneBufferGeometry(planeWidth, planeHeight);
                        mesh = new Mesh(geometry, material);
                        scene.add(mesh);

                        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
                        WebGLRenderingContext context = Js.uncheckedCast(canvas.getContext("webgl2"));

                        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
                        //rendererParameters.context = context;
                        //rendererParameters.canvas = canvas;

                        renderer = new WebGLRenderer(rendererParameters);
                        renderer.setSize(window.innerWidth, window.innerHeight);
                        renderer.setPixelRatio(devicePixelRatio);
                        renderer.setSize(getWidth(), getHeight());

                        //
                        container.appendChild(renderer.domElement);
                    }
                });
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        //renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js")
                .setInnetHtml("  - 2D Texture array<br />\n" +
                                      "\t\t\tScanned head data by\n" +
                                      "\t\t\t<a href=\"https://www.codeproject.com/Articles/352270/Getting-started-with-Volume-Rendering\" target=\"_blank\" rel=\"noopener\">Divine Augustine</a><br />\n" +
                                      "\t\t\tlicensed under\n" +
                                      "\t\t\t<a href=\"https://www.codeproject.com/info/cpol10.aspx\" target=\"_blank\" rel=\"noopener\">CPOL</a>");
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                if (mesh != null) {

                    double value = Js.uncheckedCast(((ShaderMaterial) mesh.material).uniforms.get("depth"));

                    value += depthStep;

                    if (value > 109.0 || value < 0.0) {

                        if (value > 1.0) {
                            value = 109.0 * 2.0 - value;
                        }
                        if (value < 0.0) {
                            value = -value;
                        }

                        depthStep = -depthStep;
                    }
                    ((ShaderMaterial) mesh.material).uniforms.set("depth", value);
                }

                StatsProducer.getStats().update();
                render();
                animate();
            }
        });
    }

    private void render() {
        if (renderer != null) {
            renderer.render(scene, camera);
        }
    }
}
