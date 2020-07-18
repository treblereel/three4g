package org.treblereel.gwt.three4g.core;

import elemental2.core.TypedArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.bufferattributes.Uint16BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, name = "THREE.InterleavedBufferAttribute", namespace = JsPackage.GLOBAL)
public class InterleavedBufferAttribute extends BufferAttribute<Number, InterleavedBufferAttribute>{

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

    public InterleavedBufferAttribute(InterleavedBuffer interleavedBuffer, int itemSize, int offset) {

    }

    public InterleavedBufferAttribute(InterleavedBuffer interleavedBuffer, int itemSize, int offset, boolean normalized) {

    }

}
