package org.treblereel.gwt.three4g.extensions.lights;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.lights.LightProbe;
import org.treblereel.gwt.three4g.renderers.WebGLCubeRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * Utility class for creating instances of LightProbe.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */

@Three4gElement(paths = "js/lights/LightProbeGenerator.js")
@JsType(isNative = true, namespace = "THREE")
public class LightProbeGenerator {

    public native static LightProbe fromCubeTexture(CubeTexture cubeTexture);

    public native static LightProbe fromCubeRenderTarget(WebGLRenderer renderer, WebGLCubeRenderTarget cubeRenderTarget);
}
