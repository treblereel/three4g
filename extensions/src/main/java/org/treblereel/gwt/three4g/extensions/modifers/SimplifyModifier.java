package org.treblereel.gwt.three4g.extensions.modifers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/8/18.
 */
@Three4gElement(paths = "js/modifers/SimplifyModifier.js")
@JsType(isNative = true, namespace = "THREE")
public class SimplifyModifier {
    //TODO deps on SimplifyModifier

    public native <T extends Geometry> T modify(Geometry geometry, double count);

    public native <T extends Geometry> T modify(BufferGeometry geometry, double count);

}
