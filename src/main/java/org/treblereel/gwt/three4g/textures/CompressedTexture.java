package org.treblereel.gwt.three4g.textures;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Creates a texture based on data in compressed form, for example from a DDS file.
 * <p>
 * For use with the CompressedTextureLoader.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CompressedTexture extends Texture {

    /**
     * False by default. Flipping textures does not work for compressed textures.
     */
    public boolean flipY;

    /**
     * False by default. Mipmaps can't be generated for compressed textures
     */
    public boolean generateMipmaps;

    /**
     * @param mipmaps    -- The mipmaps array should contain objects with data, width and height. The mipmaps should be of the correct format and type.
     * @param width      -- The width of the biggest mipmap.
     * @param height     -- The height of the biggest mipmap.
     * @param format     -- The format used in the mipmaps. See ST3C Compressed Texture Formats, PVRTC Compressed Texture Formats and ETC Compressed Texture Format for other choices.
     * @param type       -- Default is THREE.UnsignedByteType. See type constants for other choices.
     * @param mapping    -- How the image is applied to the object. An object type of THREE.UVMapping. See mapping constants for other choices.
     * @param wrapS      -- The default is THREE.ClampToEdgeWrapping. See wrap mode constants for other choices.
     * @param wrapT      -- The default is THREE.ClampToEdgeWrapping. See wrap mode constants for other choices.
     * @param magFilter  -- How the texture is sampled when a texel covers more than one pixel. The default is THREE.LinearFilter. See magnification filter constants for other choices.
     * @param minFilter  -- How the texture is sampled when a texel covers less than one pixel. The default is THREE.LinearMipMapLinearFilter. See minification filter constants for other choices.
     * @param anisotropy -- The number of samples taken along the axis through the pixel that has the highest density of texels. By default, this value is 1. A higher value gives a less blurry result than a basic mipmap, at the cost of more texture samples being used. Use renderer.getMaxAnisotropy() to find the maximum valid anisotropy value for the GPU; this value is usually a power of 2.
     */
    @JsConstructor
    public CompressedTexture(Object mipmaps, float width, float height, int format, int type, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int anisotropy) {

    }
}
