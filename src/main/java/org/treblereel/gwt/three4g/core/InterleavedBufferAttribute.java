package org.treblereel.gwt.three4g.core;

import elemental2.core.TypedArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class InterleavedBufferAttribute {

    /**
     * The InterleavedBuffer instance passed in the constructor.
     */
    public InterleavedBuffer data;

    /**
     * The value of data.array.
     */
    public TypedArray array;
    /**
     * The value of data.count. If the buffer is storing a 3-component item (such as a position, normal, or color), then this will count the number of such items stored.
     */
    public int count;

    /**
     * How many values make up each item.
     */
    public int itemSize;

    /**
     * The offset in the underlying array buffer where an item starts.
     */
    public int offset;

    /**
     * Default is true.
     */
    public boolean normalized;

    /**
     * Default is true.
     */
    public boolean isInterleavedBufferAttribute;

    @JsConstructor
    public InterleavedBufferAttribute(InterleavedBuffer interleavedBuffer, int itemSize, int offset, boolean normalized) {

    }

    /**
     * Returns the x component of the item at the given index.
     *
     * @param index
     * @return
     */
    public native Number getX(Number index);

    /**
     * Returns the y component of the item at the given index.
     *
     * @param index
     * @return
     */
    public native Number getY(Number index);

    /**
     * Returns the z component of the item at the given index.
     *
     * @param index
     * @return
     */
    public native Number getZ(Number index);

    /**
     * Returns the w component of the item at the given index.
     *
     * @param index
     * @return
     */
    public native Number getW(Number index);

    public native void setX(Number index, Number x);

    public native void setY(Number index, Number y);

    public native void setZ(Number index, Number z);

    public native void setW(Number index, Number w);

    public native void setXY(Number index, Number x, Number y);

    public native void setXYZ(Number index, Number x, Number y, Number z);

    public native void setXYZW(Number index, Number x, Number y, Number z, Number w);

}
