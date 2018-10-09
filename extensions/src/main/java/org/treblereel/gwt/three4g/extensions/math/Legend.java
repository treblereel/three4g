package org.treblereel.gwt.three4g.extensions.math;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.HeightWidth;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Legend extends PropertyHolder {

    /**
     * Horizontal or vertical layout. Default is vertical.
     */
    public String layout;

    public Vector3 position;

    public HeightWidth dimensions;

}
