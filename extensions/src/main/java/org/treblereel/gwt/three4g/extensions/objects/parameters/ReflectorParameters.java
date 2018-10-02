package org.treblereel.gwt.three4g.extensions.objects.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.JsObject;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/14/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ReflectorParameters {

    public double textureWidth, textureHeight;

    public int clipBias;

    public boolean recursion;

    public JsObject shader;
}
