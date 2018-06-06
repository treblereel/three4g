package org.treblereel.gwt.three4g.core.bufferattributes;

import elemental2.core.Int16Array;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/29/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Int16BufferAttribute extends BufferAttribute {

    /**
     * @param array    -- Must be a Integer[]. Used to instantiate the buffer.
     *                 This array should have
     *                 itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                 attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     */
    public Int16BufferAttribute(int[] array, int itemSize) {
        super(new Int16Array(array), itemSize);
    }
}
