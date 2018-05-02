package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsArray;
import jsinterop.annotations.JsType;

/**
 * An object with various functions to assist with animations, used internally.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/2/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationUtils { //TODO check it

    /**
     * This is the same as Array.prototype.slice, but also works on typed arrays.
     *
     * @param array
     * @param from
     * @param to
     * @return
     */
    public native static JsArray arraySlice(JsArray array, int from, int to);

    /**
     * Converts an array to a specific type.
     *
     * @param array
     * @param type
     * @param forceClone
     * @return
     */
    public native static JsArray convertArray(JsArray array, Object type, boolean forceClone);

    /**
     * Used for parsing AOS keyframe formats.
     *
     * @param jsonKeys
     * @param times
     * @param values
     * @param valuePropertyName
     * @return
     */
    public native static JsArray flattenJSON(JsArray jsonKeys, JsArray times, JsArray values, String valuePropertyName);

    /**
     * Returns an array by which times and values can be sorted.
     *
     * @param times
     * @return
     */
    public native static JsArray getKeyframeOrder(JsArray times);

    /**
     * Returns true if the object is a typed array.
     *
     * @param times
     * @return
     */
    public native static boolean isTypedArray(JsArray times);

    /**
     * Sorts the array previously returned by getKeyframeOrder.
     *
     * @param values
     * @param stride
     * @param order
     * @return
     */
    public native static JsArray sortedArray(JsArray values, int stride, JsArray order);
}
