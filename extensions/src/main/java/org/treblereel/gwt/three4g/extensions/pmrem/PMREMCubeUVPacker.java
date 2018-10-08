package org.treblereel.gwt.three4g.extensions.pmrem;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTargetCube;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/7/18.
 */
@Three4gElement(paths = "js/pmrem/PMREMCubeUVPacker.js")
@JsType(isNative = true, namespace = "THREE")
public class PMREMCubeUVPacker {

    public WebGLRenderTarget CubeUVRenderTarget;

    public PMREMCubeUVPacker(WebGLRenderTargetCube[] cubeLods) {

    }

    public native void update(WebGLRenderer renderer);

}
