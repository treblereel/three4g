package org.treblereel.gwt.three4g.examples.utils;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * A class containing utility functions for BufferGeometry instances.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/24/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BufferGeometryUtils {

    /**
     * Calculates and adds tangent attribute to a geometry.
     *
     * @param geometry -- A BufferGeometry instance, which must have index, position, normal, and uv attributes.
     */
    public native static void computeTangents(BufferGeometry geometry);

    /**
     * Merges a set of geometries into a single instance. All geometries must have compatible attributes. If merge does not succeed, the method returns null.
     *
     * @param geometries -- Array of BufferGeometry instances.
     * @return instance of BufferGeometry
     */
    public native static BufferGeometry mergeBufferGeometries(BufferGeometry... geometries);

    /**
     * Merges a set of attributes into a single instance. All attributes must have compatible properties and types, and InterleavedBufferAttributes are not supported. If merge does not succeed, the method returns null.
     *
     * @param attributes -- Array of BufferAttribute instances.
     * @return instance of BufferAttribute
     */
    public native static BufferAttribute mergeBufferAttribute(BufferAttribute... attributes);

}
