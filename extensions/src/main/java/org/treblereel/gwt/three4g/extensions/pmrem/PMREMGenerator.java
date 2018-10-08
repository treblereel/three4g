package org.treblereel.gwt.three4g.extensions.pmrem;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTargetCube;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/7/18.
 */
@Three4gElement(paths = "js/pmrem/PMREMGenerator.js")
@JsType(isNative = true, namespace = "THREE")
public class PMREMGenerator {

    public WebGLRenderTargetCube[] cubeLods;

    public PMREMGenerator(CubeTexture sourceTexture) {

    }

    public PMREMGenerator(CubeTexture sourceTexture, int samplesPerLevel) {

    }

    public PMREMGenerator(CubeTexture sourceTexture, int samplesPerLevel, int resolution) {

    }

    public native void update(WebGLRenderer renderer);
}
