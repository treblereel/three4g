package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class EffectComposer {

    public PropertyHolder renderTarget1;

    public EffectComposer(WebGLRenderer renderer, WebGLRenderTarget webGLRenderTarget) {
    }

    public native void addPass(ShaderPass effectBeckmann);

    public native void render();
}
