package org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.renderer;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/12/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "GPUComputationRenderer")
public class GPUComputationRenderer {

    @JsConstructor
    public GPUComputationRenderer() {

    }

    @JsConstructor
    public GPUComputationRenderer(double width, double width1, WebGLRenderer renderer) {
    }

    public native Texture createTexture();

    public native JsPropertyMap addVariable(String textureVelocity, String text, Texture dtVelocity);

    public native Object init();

    public native void setVariableDependencies(JsPropertyMap velocityVariable, JsPropertyMap[] array);

    public native void compute();

    public native Object getCurrentRenderTarget(JsPropertyMap positionVariable);
}
