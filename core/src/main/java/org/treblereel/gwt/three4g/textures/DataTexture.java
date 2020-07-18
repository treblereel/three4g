package org.treblereel.gwt.three4g.textures;

import elemental2.core.ArrayBuffer;
import elemental2.core.TypedArray;
import elemental2.dom.Image;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Creates a texture directly from raw data, width and height.
 * <p>
 * The data argument must be an ArrayBuffer or a typed array view. Further parameters correspond to the properties inherited from Texture, where both magFilter and minFilter default to THREE.NearestFilter. The properties flipY and generateMipmaps are intially set to false.
 * <p>
 * The interpretation of the data depends on type and format: If the type is THREE.UnsignedByteType, a Uint8Array will be useful for addressing the texel data. If the format is THREE.RGBAFormat, data needs four values for one texel; Red, Green, Blue and Alpha (typically the opacity). Similarly, THREE.RGBFormat specifies a format where only three values are used for each texel.
 * For the packed types, THREE.UnsignedShort4444Type, THREE.UnsignedShort5551Type or THREE.UnsignedShort565Type, all color components of one texel can be addressed as bitfields within an integer element of a Uint16Array.
 * In order to use the types THREE.FloatType and THREE.HalfFloatType, the WebGL implementation must support the respective extensions OES_texture_float and OES_texture_half_float. In order to use THREE.LinearFilter for component-wise, bilinear interpolation of the texels based on these types, the WebGL extensions OES_texture_float_linear or OES_texture_half_float_linear must also be present.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, name = "THREE.DataTexture", namespace = JsPackage.GLOBAL)
public class DataTexture extends Texture {

    /**
     * Overridden with a record type holding data, width and height.
     */
    public Image image;

    @JsConstructor
    public DataTexture(ArrayBuffer data, int width, int height, int format) {

    }

    @JsConstructor
    public DataTexture(ArrayBuffer data, int width, int height, int format, int type) {

    }

    @JsConstructor
    public DataTexture(ArrayBuffer data, int width, int height, int format, int type, int mapping) {

    }

    @JsConstructor
    public DataTexture(ArrayBuffer data, int width, int height, int format, int type, int mapping, int wrapS, int wrapT) {

    }

    @JsConstructor
    public DataTexture(ArrayBuffer data, int width, int height, int format, int type, int mapping, int wrapS, int wrapT, int magFilter, int minFilter) {

    }

    @JsConstructor
    public DataTexture(ArrayBuffer data, int width, int height, int format, int type, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int anisotropy) {

    }

    @JsConstructor
    public DataTexture(TypedArray data, int width, int height, int format) {

    }

    @JsConstructor
    public DataTexture(TypedArray data, int width, int height, int format, int type) {

    }

    @JsConstructor
    public DataTexture(TypedArray data, int width, int height, int format, int type, int mapping) {

    }

    @JsConstructor
    public DataTexture(TypedArray data, int width, int height, int format, int type, int mapping, int wrapS, int wrapT) {

    }

    @JsConstructor
    public DataTexture(TypedArray data, int width, int height, int format, int type, int mapping, int wrapS, int wrapT, int magFilter, int minFilter) {

    }

    @JsConstructor
    public DataTexture(TypedArray data, int width, int height, int format, int type, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int anisotropy) {

    }
}
