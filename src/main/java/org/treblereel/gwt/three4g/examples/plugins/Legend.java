package org.treblereel.gwt.three4g.examples.plugins;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.HeightWidth;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Legend {

    /**
     * Horizontal or vertical layout. Default is vertical.
     */
    public String layout;

    public Position position;

    public HeightWidth dimensions;

}
