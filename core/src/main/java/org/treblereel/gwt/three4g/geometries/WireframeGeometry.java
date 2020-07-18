package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;

/**
 * This can be used as a helper object to view a Geometry object as a wireframe.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, name = "THREE.WireframeGeometry", namespace = JsPackage.GLOBAL)
public class WireframeGeometry {

    /**
     * @param geometry — any geometry object.
     */
    public WireframeGeometry(AbstractGeometry geometry) {

    }
}
