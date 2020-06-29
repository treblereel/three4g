package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

/**
 * Used to implement post-processing effects in three.js. The class manages a chain of post-processing passes to produce the final visual result. Post-processing passes are executed in order of their addition/insertion. The last pass is automatically rendered to screen.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class EffectComposer {

    public PropertyHolder renderTarget1;

    /**
     * @param renderer -- The renderer used to render the scene.
     */
    public EffectComposer(WebGLRenderer renderer) {
    }

    /**
     * @param renderer -- The renderer used to render the scene.
     * @param renderTarget -- (optional) A preconfigured render target internally used by EffectComposer.
     */
    public EffectComposer(WebGLRenderer renderer, WebGLRenderTarget renderTarget) {
    }

    public native void addPass(ShaderPass effectBeckmann);

    public native void render();
}
