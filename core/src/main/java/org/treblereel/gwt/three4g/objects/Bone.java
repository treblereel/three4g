package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * A bone which is part of a Skeleton. The skeleton in turn is used by the SkinnedMesh. Bones are almost identical to a blank Object3D.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, name = "THREE.Bone", namespace = JsPackage.GLOBAL)
public class Bone extends Object3D {

    /**
     * Used to check whether this or derived classes are bones. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isBone;

    /**
     * Set to 'Bone', this can be used to find all Bones in a scene.
     */
    public String type;

    @JsConstructor
    public Bone() {

    }


}
