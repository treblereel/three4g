package org.treblereel.gwt.three4g.core;

import elemental2.core.TypedArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * "Interleaved" means that multiple attributes, possibly of different types, (e.g., position, normal, uv, color) are packed into a single array buffer.
 * <p>
 * An introduction into interleaved arrays can be found here: Interleaved array basics
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class InterleavedBuffer {

    /**
     * A typed array with a shared buffer. Stores the geometry data.
     */
    public TypedArray array;

    /**
     * The number of typed-array elements per vertex.
     */
    public int stride;

    /**
     * Gives the total number of elements in the array.
     */
    public int count;

    /**
     * Default is false.
     */
    public boolean dynamic;

    /**
     * Object containing offset and count.
     * updateRange.offset -> Default is 0
     * updateRange.count -> Default is 0
     */
    public Object updateRange;//TODO check this

    /**
     * A version number, incremented every time the needsUpdate property is set to true.
     */
    public int version;

    /**
     * Default is true.
     */
    public boolean isInterleavedBuffer;

    /**
     * Default is false. Setting this to true increments version.
     */
    public boolean needsUpdate;

    @JsConstructor
    InterleavedBuffer() {

    }

    @JsConstructor
    public InterleavedBuffer(TypedArray array, int stride) {

    }

    /**
     * @param array - must be a Typed Array.
     * @return
     */
    public native InterleavedBuffer setArray(TypedArray array);

    /**
     * Set dynamic to value.
     *
     * @param value
     * @return
     */
    public native InterleavedBuffer setDynamic(boolean value);

    /**
     * Copies another InterleavedBuffer to this InterleavedBuffer.
     *
     * @param source
     * @return
     */
    public native InterleavedBuffer copy(InterleavedBuffer source);

    /**
     * Copies data from attribute[index2] to array[index1].
     *
     * @param index1
     * @param index2
     * @return
     */
    public native InterleavedBuffer copyAt(int index1, Object attribute, int index2); //TODO check object

    /**
     * Stores multiple values in the buffer, reading input values from a specified array.
     *
     * @param value  - The source (typed) array.
     * @param offset - The offset into the target array at which to begin writing values from the source array. Default is 0.
     * @return
     */
    public native InterleavedBuffer set(TypedArray value, int offset);

    /**
     * Creates a clone of this InterleavedBuffer.
     *
     * @return
     */
    public native InterleavedBuffer clone();

}
