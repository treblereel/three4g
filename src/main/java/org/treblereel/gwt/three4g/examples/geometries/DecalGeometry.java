package org.treblereel.gwt.three4g.examples.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * DecalGeometry can be used to create a decal mesh that serves different kinds of purposes e.g. adding unique details to models, performing dynamic visual environmental changes or covering seams.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/24/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DecalGeometry extends BufferGeometry {

    /**
     * @param mesh        — Any mesh object.
     * @param position    — Position of the decal projector.
     * @param orientation — Orientation of the decal projector.
     * @param paramsize — Size of the decal projector.
     */
    public DecalGeometry(Mesh mesh, Vector3 position, Euler orientation, Vector3 paramsize) {

    }
}
