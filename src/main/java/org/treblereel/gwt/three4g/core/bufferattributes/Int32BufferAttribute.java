package org.treblereel.gwt.three4g.core.bufferattributes;

import elemental2.core.Int32Array;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/29/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Int32BufferAttribute extends BufferAttribute {

    /**
     * @param array    -- Must be a Integer[]. Used to instantiate the buffer.
     *                 This array should have
     *                 itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                 attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     */
    public Int32BufferAttribute(int[] array, int itemSize) {
        super(new Int32Array(array), itemSize);
    }

    /**
     * @param array      -- Must be a Integer[]. Used to instantiate the buffer.
     *                   This array should have
     *                   itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize   -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                   attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     * @param normalized -- Indicates how the underlying data in the buffer maps to the values in the GLSL code.
     *                   For instance, if array is an instance of UInt16Array, and normalized is true, the values 0 - +65535
     *                   in the array data will be mapped to 0.0f - +1.0f in the GLSL attribute. An Int16Array (signed)
     *                   would map from -32767 - +32767 to -1.0f - +1.0f. If normalized is false, the values will be converted
     */
    public Int32BufferAttribute(int[] array, int itemSize, boolean normalized) {
        super(new Int32Array(array), itemSize, normalized);
    }

    /**
     * Returns the x component of the vector at the given index.
     *
     * @param index of x component
     * @return instance of Integer
     */
    public native Integer getX(int index);

    /**
     * Returns the y component of the vector at the given index.
     *
     * @param index of y component
     * @return instance of Integer
     */
    public native Integer getY(int index);

    /**
     * Returns the z component of the vector at the given index.
     *
     * @param index of z component
     * @return instance of Integer
     */
    public native Integer getZ(int index);
}
