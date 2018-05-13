package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/13/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class ContextAttributes {

    public boolean alpha;

    public boolean antialias;

    public boolean depth;

    public boolean failIfMajorPerformanceCaveat;

    public boolean premultipliedAlpha;

    public boolean preserveDrawingBuffer;

    public boolean stencil;
}
