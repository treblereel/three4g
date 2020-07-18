package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
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
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/8/18.
 */
@JsType(isNative = true, name = "THREE.Layers", namespace = JsPackage.GLOBAL)
public class Layers {

    /**
     * A bit mask storing which of the 32 layers this layers object is currently a member of.
     */
    public int mask;

    @JsConstructor
    public Layers() {

    }

    /**
     * Remove membership of this layer.
     *
     * @param layer - an integer from 0 to 31.
     */
    public native void disable(int layer);

    /**
     * enable membership of this layer.
     *
     * @param layer - an integer from 0 to 31.
     */
    public native void enable(int layer);

    /**
     * Set membership to layer, and remove membership all other layers.
     *
     * @param layer - an integer from 0 to 31.
     */
    public native void set(int layer);

    /**
     * Returns true if this and the passed layers object are members of the same set of layers.
     *
     * @param layer - a Layers object
     * @return true, if memebers of the same layer
     */
    public native boolean test(Layers layer);

    /**
     * Toggle membership of layer.
     *
     * @param layer - an integer from 0 to 31.
     */
    public native void toggle(int layer);

}
