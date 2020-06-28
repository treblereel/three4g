package org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu;

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.Window;
import elemental2.core.Uint8ClampedArray;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import java.math.BigDecimal;
import java.util.Date;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.custom.BirdGeometry;
import org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.custom.BirdUniforms;
import org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.custom.Value;
import org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.renderer.GPUComputationRenderer;
import org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.shader.ShaderClientBundle;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;


/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/12/18.
 */
public class WebglGpgpuBirds extends Attachable {

    double width = getWidth();
    double birds = getWidth() * getWidth();
    double mouseX = 0, mouseY = 0;
    double windowHalfX = window.innerWidth / 2;
    double windowHalfY = window.innerHeight / 2;
    double BOUNDS = 800, BOUNDS_HALF = BOUNDS / 2;
    double last = new Date().getTime() * 0.0001;
    private GPUComputationRenderer gpuCompute;
    private JsPropertyMap velocityVariable;
    private JsPropertyMap positionVariable;
    private BirdUniforms positionUniforms;
    private BirdUniforms velocityUniforms;
    private BirdUniforms birdUniforms;

    public WebglGpgpuBirds() {

        ScriptInjector.fromString(JavascriptTextResource.IMPL.getGPUComputationRenderer().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

        ScriptInjector.fromString(JavascriptTextResource.IMPL.getBirdGeometry().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

        camera = new PerspectiveCamera(75, aspect, 1, 3000);

        camera.position.z = 350;
        scene = new Scene();
        scene.background = new Color(0xffffff);
        scene.fog = new Fog(0xffffff, 100, 1000);
        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);

        initComputeRenderer();


        document.addEventListener("mousemove", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                // mouseX = evt.clientX - windowHalfX;
                // mouseY = evt.clientY - windowHalfY;
            }
        }, false);
        document.addEventListener("touchstart", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
/*                if ( event.touches.length === 1 ) {
                    event.preventDefault();
                    mouseX = event.touches[ 0 ].pageX - windowHalfX;
                    mouseY = event.touches[ 0 ].pageY - windowHalfY;
                }*/


            }
        }, false);
        document.addEventListener("touchmove", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
/*                if ( event.touches.length === 1 ) {
                    event.preventDefault();
                    mouseX = event.touches[ 0 ].pageX - windowHalfX;
                    mouseY = event.touches[ 0 ].pageY - windowHalfY;
                }*/
            }
        }, false);


/*        var gui = new dat.GUI();
        var effectController = {
                seperation:20.0,
                alignment:20.0,
                cohesion:20.0,
                freedom:0.75
				};*/

/*        var valuesChanger = function() {
            velocityUniforms.seperationDistance.value = effectController.seperation;
            velocityUniforms.alignmentDistance.value = effectController.alignment;
            velocityUniforms.cohesionDistance.value = effectController.cohesion;
            velocityUniforms.freedomFactor.value = effectController.freedom;
        }
        ;

        valuesChanger();

        gui.add(effectController, "seperation", 0.0, 100.0, 1.0).onChange(valuesChanger);
        gui.add(effectController, "alignment", 0.0, 100, 0.001).onChange(valuesChanger);
        gui.add(effectController, "cohesion", 0.0, 100, 0.025).onChange(valuesChanger);
        gui.close();*/

        initBirds();

    }

    private void initBirds() {
        BirdGeometry geometry = new BirdGeometry();
        // For Vertex and Fragment

        birdUniforms = new BirdUniforms();
        birdUniforms.color = new Value(new Color(0xff2200));
        birdUniforms.time = new Value(1.0);
        birdUniforms.delta = new Value(0.0);


        // ShaderMaterial
        ShaderMaterialParameters shaderMaterialParameters = new ShaderMaterialParameters();

        //shaderMaterialParameters.uniforms = birdUniforms; //TODO


        shaderMaterialParameters.vertexShader = ShaderClientBundle.IMPL.getBirdVS().getText();
        shaderMaterialParameters.fragmentShader = ShaderClientBundle.IMPL.getBirdFS().getText();
        shaderMaterialParameters.side = THREE.DoubleSide;

        ShaderMaterial material = new ShaderMaterial(shaderMaterialParameters);
        Mesh birdMesh = new Mesh(geometry, material);
        birdMesh.rotation.y = (float) Math.PI / 2;
        birdMesh.matrixAutoUpdate = false;
        birdMesh.updateMatrix();
        scene.add(birdMesh);

    }

    @Override
    protected void doAttachScene() {
        document.body.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    private void animate() {
        render();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (renderer.domElement.parentNode != null) {
                animate();
            }
        });

    }

    private void render() {
        double now = new Date().getTime() * 0.0001;
        double delta = (now - last) / 1000;
        if (delta > 1) delta = 1; // safety cap on large deltas
        last = now;

        positionUniforms.time = new Value(now);

        positionUniforms.delta = new Value(delta);

        velocityUniforms.time = new Value(now);
        velocityUniforms.delta = new Value(delta);

        birdUniforms.time = new Value(now);
        birdUniforms.delta = new Value(delta);


        velocityUniforms.predator = new Value(new Vector3((float) (0.5 * mouseX / windowHalfX), (float) (-0.5 * mouseY / windowHalfY), 0));


        mouseX = 10000;
        mouseY = 10000;
        gpuCompute.compute();


        //JsPropertyMap positionVariable = Js.cast(gpuCompute.getCurrentRenderTarget(positionVariable));

        Object currentRenderTargetByPositionVariable = gpuCompute.getCurrentRenderTarget(positionVariable);
        JsPropertyMap currentRenderTargetByPositionVariableJsPropertyMap = Js.cast(currentRenderTargetByPositionVariable);
        birdUniforms.texturePosition = new Value(currentRenderTargetByPositionVariableJsPropertyMap);

        Object currentRenderTargetByVelocityVariable = gpuCompute.getCurrentRenderTarget(velocityVariable);
        JsPropertyMap currentRenderTargetByVelocityVariableJsPropertyMap = Js.cast(currentRenderTargetByVelocityVariable);
        birdUniforms.textureVelocity = new Value(currentRenderTargetByVelocityVariableJsPropertyMap);


        renderer.render(scene, camera);
    }

    private void initComputeRenderer() {
        gpuCompute = new GPUComputationRenderer(width, width, renderer);

        Texture dtPosition = gpuCompute.createTexture();
        Texture dtVelocity = gpuCompute.createTexture();

        fillPositionTexture(dtPosition);
        fillVelocityTexture(dtVelocity);

        velocityVariable = gpuCompute.addVariable("textureVelocity", ShaderClientBundle.IMPL.getFragmentShaderVelocity().getText(), dtVelocity);
        positionVariable = gpuCompute.addVariable("texturePosition", ShaderClientBundle.IMPL.getFragmentShaderPosition().getText(), dtPosition);


        JsPropertyMap[] array = new JsPropertyMap[2];
        array[0] = positionVariable;
        array[1] = velocityVariable;

        gpuCompute.setVariableDependencies(velocityVariable, array); //TODO ???
        gpuCompute.setVariableDependencies(positionVariable, array);


        ShaderMaterial positionVariableShaderMaterial = Js.cast(positionVariable.get("material"));
        ShaderMaterial velocityVariableShaderMaterial = Js.cast(velocityVariable.get("material"));

        positionUniforms = Js.cast(positionVariableShaderMaterial.uniforms);
        velocityUniforms = Js.cast(velocityVariableShaderMaterial.uniforms);


        addToJsPropertyMap(positionVariableShaderMaterial.uniforms, "time", 0.0);
        addToJsPropertyMap(positionVariableShaderMaterial.uniforms, "delta", 0.0);

        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "time", 1.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "delta", 0.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "testing", 1.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "seperationDistance", 1.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "alignmentDistance", 1.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "cohesionDistance", 1.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "freedomFactor", 1.0);
        addToJsPropertyMap(velocityVariableShaderMaterial.uniforms, "predator", new Vector3());

        velocityVariableShaderMaterial.defines.setProperty("BOUNDS", BigDecimal.valueOf(BOUNDS).setScale(2, BigDecimal.ROUND_HALF_UP));
        velocityVariable.set("wrapS", THREE.RepeatWrapping);
        velocityVariable.set("wrapT", THREE.RepeatWrapping);

        positionVariable.set("wrapS", THREE.RepeatWrapping);
        positionVariable.set("wrapT", THREE.RepeatWrapping);


        Object error = gpuCompute.init();
        if (error != null) {
            Window.alert(error.toString());
        }
    }

    private void addToJsPropertyMap(Uniforms map, String key, Object value) {
        map.set(key, value);
    }


    private void fillPositionTexture(Texture texture) {
        Uint8ClampedArray theArray = texture.image.data; // Uint8ClampedArray
        for (double k = 0, kl = theArray.length; k < kl; k += 4) {
            double x = Math.random() * BOUNDS - BOUNDS_HALF;
            double y = Math.random() * BOUNDS - BOUNDS_HALF;
            double z = Math.random() * BOUNDS - BOUNDS_HALF;

            theArray.setAt((int) (k + 0), x);
            theArray.setAt((int) (k + 1), y);
            theArray.setAt((int) (k + 2), z);
            theArray.setAt((int) (k + 3), 1.0);
        }
    }

    private void fillVelocityTexture(Texture texture) {
        Uint8ClampedArray theArray = texture.image.data;
        for (double k = 0, kl = theArray.length; k < kl; k += 4) {
            double x = Math.random() - 0.5;
            double y = Math.random() - 0.5;
            double z = Math.random() - 0.5;

            theArray.setAt((int) (k + 0), x * 10);
            theArray.setAt((int) (k + 1), y * 10);
            theArray.setAt((int) (k + 2), z * 10);
            theArray.setAt((int) (k + 3), 1.0);
        }
    }

    @Override
    protected void doAttachInfo() {

    }
}
