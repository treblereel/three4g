package org.treblereel.gwt.three4g.textures;

import elemental2.dom.HTMLVideoElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Creates a texture for use with a video texture.
 * <p>
 * This is almost the same as the base Texture class, except that it continuosly sets needsUpdate to true so that the
 * texture is updated as the video plays. Automatic creation of mipmaps is also disabled.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class VideoTexture extends Texture {

    /**
     * You will not need to set this manually here as it is handled by the update method.
     */
    public boolean needsUpdate;

    /**
     * @param video      -- The video element to use as the texture.
     * @param mapping    -- How the image is applied to the object. An object type of THREE.UVMapping. See mapping constants for other choices.
     * @param wrapS      -- The default is THREE.ClampToEdgeWrapping. See wrap mode constants for other choices.
     * @param wrapT      -- The default is THREE.ClampToEdgeWrapping. See wrap mode constants for other choices.
     * @param magFilter  -- How the texture is sampled when a texel covers more than one pixel. The default is THREE.LinearFilter. See magnification filter constants for other choices.
     * @param minFilter  -- How the texture is sampled when a texel covers less than one pixel. The default is THREE.LinearMipMapLinearFilter. See minification filter constants for other choices.
     * @param format     -- The format used in the texture. See format constants for other choices.
     * @param type       -- Default is THREE.UnsignedByteType. See type constants for other choices.
     * @param anisotropy -- The number of samples taken along the axis through the pixel that has the highest density of texels. By default, this value is 1. A higher value gives a less blurry result than a basic mipmap, at the cost of more texture samples being used. Use renderer.getMaxAnisotropy() to find the maximum valid anisotropy value for the GPU; this value is usually a power of 2.
     */
    @JsConstructor
    VideoTexture(HTMLVideoElement video, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int format, int type, int anisotropy) {

    }

    /**
     * This is called automatically and sets # .needsUpdate : booleanto true every time a new frame is available.
     */
    public native void update();
}
