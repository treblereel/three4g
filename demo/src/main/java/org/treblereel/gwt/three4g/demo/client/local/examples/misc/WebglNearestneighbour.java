package org.treblereel.gwt.three4g.demo.client.local.examples.misc;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import elemental2.dom.HTMLScriptElement;
import java.util.Date;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.FirstPersonControls;
import org.treblereel.gwt.three4g.extensions.utils.DistanceFunction;
import org.treblereel.gwt.three4g.extensions.utils.TypedArrayUtils;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Frustum;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Points;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/16/18.
 */
@InjectJavaScriptFor(elements = {FirstPersonControls.class, TypedArrayUtils.class})
public class WebglNearestneighbour extends Attachable {

    public static final String name = "nearest neighbour";
    private final DistanceFunction distanceFunction = (a, b) -> Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2) + Math.pow(a[2] - b[2], 2);

    private Clock clock = new Clock();

    private int amountOfParticles = 500000;
    private double maxDistance = Math.pow(120, 2);

    private Float32Array positions, alphas;
    private Points particles;
    private BufferGeometry _particleGeom;
    private TypedArrayUtils.Kdtree kdtree;

    private HTMLScriptElement vertexShaderElm, fragmentShaderElm;

    private String fragmentShader = "uniform sampler2D tex1;\n" +
            "\t\t\tvarying float vAlpha;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tgl_FragColor = texture2D( tex1, gl_PointCoord );\n" +
            "\t\t\t\tgl_FragColor.r = ( 1.0 - gl_FragColor.r ) * vAlpha + gl_FragColor.r;\n" +
            "\t\t\t}";

    private String vertexShader = "\tattribute float alpha;\n" +
            "\t\t\tvarying float vAlpha;\n" +
            "\t\t\tvoid main() {\n" +
            "\t\t\t\tvAlpha = 1.0 - alpha;\n" +
            "\t\t\t\tvec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );\n" +
            "\t\t\t\tgl_PointSize = 4.0 * ( 300.0 / -mvPosition.z );\n" +
            "\t\t\t\tgl_Position = projectionMatrix * mvPosition;\n" +
            "\t\t\t}";

    public WebglNearestneighbour() {

        vertexShaderElm = (HTMLScriptElement) document.createElement("script");
        vertexShaderElm.type = "x-shader/x-vertex";
        vertexShaderElm.textContent = vertexShader;
        root.appendChild(vertexShaderElm);

        fragmentShaderElm = (HTMLScriptElement) document.createElement("script");
        fragmentShaderElm.type = "x-shader/x-fragment";
        fragmentShaderElm.textContent = fragmentShader;
        root.appendChild(fragmentShaderElm);

        camera = new PerspectiveCamera(75, aspect, 1, 1000000);
        scene = new Scene();

        // add a skybox background
        CubeTextureLoader cubeTextureLoader = new CubeTextureLoader();
        cubeTextureLoader.setPath("textures/cube/skybox/");
        CubeTexture cubeTexture = cubeTextureLoader.load(new String[]{
                "px.jpg", "nx.jpg",
                "py.jpg", "ny.jpg",
                "pz.jpg", "nz.jpg"
        });
        scene.background = cubeTexture;
        // create the custom shader
        TextureLoader textureLoader = new TextureLoader();
        Texture imagePreviewTexture = textureLoader.load("textures/crate.gif");
        imagePreviewTexture.minFilter = THREE.LinearMipmapLinearFilter;
        imagePreviewTexture.magFilter = THREE.LinearFilter;

        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();
        Uniforms uniforms = new Uniforms(); //TODO direct access
        uniforms.set("tex1", imagePreviewTexture);
        uniforms.set("zoom", 9.0);
        shaderMaterialParameters.uniforms = uniforms;
        shaderMaterialParameters.vertexShader = vertexShaderElm.textContent;
        shaderMaterialParameters.fragmentShader = fragmentShaderElm.textContent;
        shaderMaterialParameters.transparent = true;

        ShaderMaterial pointShaderMaterial = new ShaderMaterial(shaderMaterialParameters);


        positions = new Float32Array(amountOfParticles * 3);
        alphas = new Float32Array(amountOfParticles);
        _particleGeom = new BufferGeometry();
        _particleGeom.addAttribute("position", new BufferAttribute(positions, 3));
        _particleGeom.addAttribute("alpha", new BufferAttribute(alphas, 1));
        particles = new Points(_particleGeom, pointShaderMaterial);

        for (int x = 0; x < amountOfParticles; x++) {
            positions.setAt((x * 3 + 0), Math.random() * 1000);
            positions.setAt((x * 3 + 1), Math.random() * 1000);
            positions.setAt((x * 3 + 2), Math.random() * 1000);
            alphas.setAt(x, 1.0);
        }
        long measureStart = new Date().getTime();
        // creating the kdtree takes a lot of time to execute, in turn the nearest neighbour search will be much faster
        kdtree = new TypedArrayUtils.Kdtree(positions, distanceFunction, 3);

        GWT.log("TIME building kdtree " + (new Date().getTime() - measureStart));
        // display particles after the kd-tree was generated and the sorting of the positions-array is done
        scene.add(particles);


        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);

        firstPersonControls = new FirstPersonControls(camera, document.body);
        firstPersonControls.movementSpeed = 100;
        firstPersonControls.lookSpeed = 0.1;

    }

    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    private void displayNearest(Vector3 position) {
        // take the nearest 200 around him. distance^2 'cause we use the manhattan distance and no square is applied in the distance function
        JsArray<JsArray> imagePositionsInRange = kdtree.nearest(new float[]{position.x, position.y, position.z}, 100, (float) maxDistance);
        // We combine the nearest neighbour with a view frustum. Doesn't make sense if we change the sprites not in our view... well maybe it does. Whatever you want.
        Frustum _frustum = new Frustum();
        Matrix4 _projScreenMatrix = new Matrix4();
        _projScreenMatrix.multiplyMatrices(camera.projectionMatrix, camera.matrixWorldInverse);
        _frustum.setFromMatrix(_projScreenMatrix);
        for (int i = 0, il = imagePositionsInRange.length; i < il; i++) {
            JsArray object = imagePositionsInRange.getAt(i);
            PropertyHolder object1 = Js.uncheckedCast(object.getAt(0));
            Float32Array array = object1.getProperty("obj");
            Vector3 objectPoint = new Vector3().fromArray(array);
            if (_frustum.containsPoint(objectPoint)) {
                Number objectIndex = object1.getProperty("pos");
                alphas.setAt(objectIndex.intValue(), 1.0 / maxDistance * (double) object.getAt(1));
                BufferAttribute attribute = _particleGeom.attributes.getProperty("alpha");
                attribute.needsUpdate = true;
            }
        }

    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" -webgl - typed arrays - nearest neighbour for 500,000 sprites");
    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                displayNearest(camera.position);
                firstPersonControls.update(clock.getDelta());
                render();
                animate();
            }
        });
    }

    private void render() {
        renderer.render(scene, camera);
    }
}

