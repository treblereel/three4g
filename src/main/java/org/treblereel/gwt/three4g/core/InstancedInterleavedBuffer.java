package org.treblereel.gwt.three4g.core;

import elemental2.core.TypedArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * An instanced version of InterleavedBuffer.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class InstancedInterleavedBuffer extends InterleavedBuffer{

    /**
     * Default is 1.
     */
    public int meshPerAttribute;

    /**
     * Default is true.
     */
    public boolean isInstancedInterleavedBuffer;

    @JsConstructor
    public InstancedInterleavedBuffer(TypedArray array, int itemSize, int meshPerAttribute) {

    }



}
