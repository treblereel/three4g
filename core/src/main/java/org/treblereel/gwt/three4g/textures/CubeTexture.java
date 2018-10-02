package org.treblereel.gwt.three4g.textures;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Creates a texture from a canvas element.
 * <p>
 * This is almost the same as the base Texture class, except that it sets needsUpdate to true immediately.
 * <p>
 * Creates a cube texture made up of six images.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CubeTexture extends Texture {

    @JsConstructor
    public CubeTexture(Object[] images, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int format, int type, int anisotropy ){

    }


}
