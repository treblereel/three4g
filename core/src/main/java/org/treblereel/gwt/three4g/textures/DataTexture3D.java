package org.treblereel.gwt.three4g.textures;

import elemental2.core.TypedArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * initial implementation
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
@JsType(isNative = true, name = "THREE.DataTexture3D", namespace = JsPackage.GLOBAL)
public class DataTexture3D extends Texture {

    /**
     * Used to check whether this or derived classes are DataTexture3D's. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isDataTexture3D;

    public DataTexture3D(TypedArray data, float width, float height, float depth) {

    }

}
