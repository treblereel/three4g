package org.treblereel.gwt.three4g.extensions.effects.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/8/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class OutlineEffectParameters {

    public float defaultThickness;
    public Color defaultColor;
    public float defaultAlpha;
    public boolean defaultKeepAlive;

}
