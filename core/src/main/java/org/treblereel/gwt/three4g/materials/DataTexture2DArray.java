package org.treblereel.gwt.three4g.materials;

import elemental2.core.ArrayBufferView;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * Creates an array of textures directly from raw data, width and height and depth. This type of texture can only be
 * used with a WebGL 2 rendering context.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@JsType(isNative = true, namespace = "THREE")
public class DataTexture2DArray extends Texture {

    /**
     * The data argument must be an ArrayBufferView. The properties inherited from Texture are the default, except magFilter and minFilter default to THREE.NearestFilter. The properties flipY and generateMipmaps are intially set to false.
     *
     * The interpretation of the data depends on type and format: If the type is THREE.UnsignedByteType, a Uint8Array will be useful for addressing the texel data. If the format is THREE.RGBAFormat, data needs four values for one texel; Red, Green, Blue and Alpha (typically the opacity). Similarly, THREE.RGBFormat specifies a format where only three values are used for each texel.
     * For the packed types, THREE.UnsignedShort4444Type, THREE.UnsignedShort5551Type or THREE.UnsignedShort565Type, all color components of one texel can be addressed as bitfields within an integer element of a Uint16Array.
     * In order to use the types THREE.FloatType and THREE.HalfFloatType, the WebGL implementation must support the respective extensions OES_texture_float and OES_texture_half_float. In order to use THREE.LinearFilter for component-wise, bilinear interpolation of the texels based on these types, the WebGL extensions OES_texture_float_linear or OES_texture_half_float_linear must also be present.
     * @param data an ArrayBufferView
     * @param width int value
     * @param height int value
     * @param depth int value
     */
    @JsConstructor
    public DataTexture2DArray(ArrayBufferView data, int width, int height, int depth) {

    }

    /**
     *
     * @return true is DataTexture2DArray
     */
    public native boolean isDataTexture2DArray();

}
