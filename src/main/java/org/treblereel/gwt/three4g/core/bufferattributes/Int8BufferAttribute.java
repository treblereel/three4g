package org.treblereel.gwt.three4g.core.bufferattributes;

import elemental2.core.Int8Array;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/29/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Int8BufferAttribute extends BufferAttribute {

    /**
     * @param array      -- Must be a Integer[]. Used to instantiate the buffer.
     *                   This array should have
     *                   itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize   -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                   attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     */
    public Int8BufferAttribute(int[] array, int itemSize) {
        super(new Int8Array(array), itemSize);
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
