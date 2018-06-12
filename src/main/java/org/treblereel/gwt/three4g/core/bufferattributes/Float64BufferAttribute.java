package org.treblereel.gwt.three4g.core.bufferattributes;

import elemental2.core.ArrayBuffer;
import elemental2.core.Float64Array;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/29/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Float64BufferAttribute extends BufferAttribute {

    /**
     * @param array    -- Must be a Float[]. Used to instantiate the buffer.
     *                 This array should have
     *                 itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                 attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     */
    public Float64BufferAttribute(Float[] array, int itemSize) {
        super(new Float64Array((ArrayBuffer) Js.uncheckedCast(array)), itemSize);
    }

    /**
     * Returns the x component of the vector at the given index.
     *
     * @param index of x component
     * @return instance of Float
     */
    public native Float getX(int index);

    /**
     * Returns the y component of the vector at the given index.
     *
     * @param index of y component
     * @return instance of Float
     */
    public native Float getY(int index);

    /**
     * Returns the z component of the vector at the given index.
     *
     * @param index of z component
     * @return instance of Float
     */
    public native Float getZ(int index);

}
