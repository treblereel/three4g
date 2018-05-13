package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebGlShadowMap {

    public boolean enabled;

    public boolean autoUpdate;

    public boolean needsUpdate;
}
