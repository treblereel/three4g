package org.treblereel.gwt.three4g.textures;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DepthTexture extends Texture {

    /**
     * @param width      -- width of the texture.
     * @param height     -- height of the texture.
     * @param type       -- Default is THREE.UnsignedShortType. See type constants for other choices.
     * @param mapping    -- See type constants for details.
     * @param wrapS      -- The default is THREE.ClampToEdgeWrapping. See wrap mode constants for other choices.
     * @param wrapT      -- The default is THREE.ClampToEdgeWrapping. See wrap mode constants for other choices.
     * @param magFilter  -- How the texture is sampled when a texel covers more than one pixel. The default is THREE.NearestFilter. See magnification filter constants for other choices.
     * @param minFilter  -- How the texture is sampled when a texel covers less than one pixel. The default is THREE.NearestFilter. See minification filter constants for other choices.
     * @param anisotropy -- The number of samples taken along the axis through the pixel that has the highest density of texels. By default, this value is 1. A higher value gives a less blurry result than a basic mipmap, at the cost of more texture samples being used. Use renderer.getMaxAnisotropy() to find the maximum valid anisotropy value for the GPU; this value is usually a power of 2.
     * @param format     -- must be either DepthFormat (default) or DepthStencilFormat. See format constants for details.
     */
    @JsConstructor
    public DepthTexture(float width, float height, int type, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int anisotropy, int format) {

    }

    /**
     * Either DepthFormat (default) or DepthStencilFormat. See format constants for details.
     */
    public int format;

    /**
     * Default is THREE.UnsignedShortType. See format constants for details.
     */
    public int type;

    /**
     * How the texture is sampled when a texel covers more than one pixel. The default is THREE.NearestFilter. See magnification filter constants for other choices.
     */
    public int magFilter;

    /**
     * How the texture is sampled when a texel covers less than one pixel. The default is THREE.NearestFilter. See magnification filter constants for other choices.
     */
    public int minFilter;

    /**
     * Depth textures do not need to be flipped so this is false by default.
     */
    public boolean flipY;

    /**
     * Depth textures do not use mipmaps.
     */
    public boolean generateMipmaps;
}
