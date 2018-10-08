package org.treblereel.gwt.three4g.extensions.effects;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.extensions.effects.parameters.OutlineEffectParameters;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/8/18.
 */
@Three4gElement(paths = "js/effects/OutlineEffect.js")
@JsType(isNative = true, namespace = "THREE")
public class OutlineEffect {

    public OutlineEffect(WebGLRenderer renderer) {

    }

    public OutlineEffect(WebGLRenderer renderer, OutlineEffectParameters params) {

    }

    /**
     * Render a scene using a camera.
     * The render is done to the renderTarget (if specified) or to the canvas as usual.
     * If forceClear is true, the depth, stencil and color buffers will be cleared before rendering even if the renderer's autoClear property is false.
     * Even with forceClear set to true you can prevent certain buffers being cleared by setting either the autoClearColor, autoClearStencil or autoClearDepth properties to false.
     *
     * @param scene  instance of Scene
     * @param camera instance of Camera
     */
    public native void render(Scene scene, Camera camera);


}
