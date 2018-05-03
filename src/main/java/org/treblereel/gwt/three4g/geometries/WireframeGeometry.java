package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;

/**
 * This can be used as a helper object to view a Geometry object as a wireframe.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WireframeGeometry {

    /**
     * @param geometry — any geometry object.
     */
    public WireframeGeometry(AbstractGeometry geometry) {

    }
}
