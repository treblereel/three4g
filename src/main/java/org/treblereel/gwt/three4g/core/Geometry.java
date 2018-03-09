package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Base class for all geometries (but not for BufferGeometries).
 * This can also be used directly for building custom geometries.
 * <p>
 * Geometries are easier to work with than BufferGeometries as they store attributes such as vertices, faces, colors and
 * so on directly (rather than in buffers), however they are generally slower.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Geometry extends EventDispatcher {


    @JsConstructor
    public Geometry() {

    }
}
