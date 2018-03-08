package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsType;

/**
 * A Layers object assigns an Object3D to 1 or more of 32 layers numbered 0 to 31 - internally the layers are stored
 * as a bit mask, and by default all Object3Ds are a member of layer 0.
 * <p>
 * This can be used to control visibility - an object must share a layer with a camera to be visible when that camera's
 * view is renderered.
 * <p>
 * All classes that inherit from Object3D have an Object3D.layers property which is an instance of this class.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/8/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Layers {
}
