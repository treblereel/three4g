package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, name = "THREE.WebGlShadowMap", namespace = JsPackage.GLOBAL)
public class WebGlShadowMap {

    public boolean enabled;

    public boolean autoUpdate;

    public boolean needsUpdate;

    public int type;
}
