package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 2/27/18.
 */
@JsType
@FunctionalInterface
public interface TraverseCallback {
    void call(Object3D object);
}
