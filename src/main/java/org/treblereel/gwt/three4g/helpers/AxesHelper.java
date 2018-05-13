package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * An axis object to visualize the 3 axes in a simple way.
 * The X axis is red. The Y axis is green. The Z axis is blue.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AxesHelper extends LineSegments {

    public AxesHelper() {

    }

    /**
     * @param size --  size of the lines representing the axes. Default is 1.
     */
    public AxesHelper(Number size) {

    }
}
