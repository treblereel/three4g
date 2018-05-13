package org.treblereel.gwt.three4g.renderers.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class WebGLRenderTargetCubeParameters {

    public int wrapS; // - default is ClampToEdgeWrapping.

    public int wrapT; // - default is ClampToEdgeWrapping.

    public int magFilter; // - default is .LinearFilter.

    public int minFilter; // - default is LinearFilter.

    public int format;  // - default is RGBAFormat.

    public int type; // - default is UnsignedByteType.

    public int anisotropy; // - default is 1. See Texture.anistropy

    public int encoding; //  - default is LinearEncoding.

    public boolean depthBuffer; // - default is true. Set this to false if you don't need it.

    public boolean stencilBuffer; // - default is true. Set this to false if you don't need it.
}
