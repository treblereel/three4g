package org.treblereel.gwt.three4g.loaders;

import elemental2.core.TypedArray;
import jsinterop.annotations.JsType;

/**
 * An object with several loader utility functions.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LoaderUtils {

    /**
     * The function takes a stream of bytes as input and returns a string representation.
     *
     * @param array — A stream of bytes as a typed array.
     * @return string representation
     */
    public native String decodeText(TypedArray array);

    /**
     * Extract the base from the URL.
     *
     * @param url — The url to extract the base url from.
     * @return url base as String value
     */
    public native String extractUrlBase(String url);
}
