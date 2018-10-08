package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.JsObject;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * A group of objects that receives a shared animation state.
 * <p>
 * For an overview of the different elements of the three.js animation system see the "Animation System" article in the "Next Steps" section of the manual.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationObjectGroup {

    /**
     * An object that contains some informations of this AnimationObjectGroup (total number, number in use, number of bindings per object)
     */
    public JsObject stats;

    /**
     * The UUID of this AnimationObjectGroup. It gets automatically assigned and shouldn't be edited.
     */
    public String uuid;

    /**
     * @param objs - an abitrary number of meshes that share the same animation state.
     */
    @JsConstructor
    public AnimationObjectGroup(Object3D... objs) {

    }

    /**
     * Adds an arbitrary number of objects to this AnimationObjectGroup.
     *
     * @param objs array of Object3Ds
     */
    public native void add(Object3D... objs);

    /**
     * Removes an arbitrary number of objects from this AnimationObjectGroup.
     *
     * @param objs array of Object3Ds
     */
    public native void remove(Object3D... objs);

    /**
     * Deallocates all memory resources for the passed objects of this AnimationObjectGroup.
     *
     * @param objs array of Object3Ds
     */
    public native void uncache(Object3D... objs);

}
