package org.treblereel.gwt.three4g.textures;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Texture {

    @JsConstructor
    public Texture(){

    }

    @JsConstructor
    public Texture(Object image, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int format, int type, int anisotropy, int encoding) {

    }
}
