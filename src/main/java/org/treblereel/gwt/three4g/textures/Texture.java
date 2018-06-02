package org.treblereel.gwt.three4g.textures;

import elemental2.dom.ImageData;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.EventDispatcher;
import org.treblereel.gwt.three4g.math.Matrix3;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Create a texture to apply to a surface or as a reflection or refraction map.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Texture extends EventDispatcher {

    /**
     * Optional name of the object (doesn't need to be unique). Default is an empty string.
     */
    public String name;

    /**
     * An image object, typically created using the TextureLoader.load method. This can be any image (e.g., PNG, JPG, GIF, DDS)
     * or video (e.g., MP4, OGG/OGV) type supported by three.js.
     * <p>
     * To use video as a texture you need to have a playing HTML5 video element as a source for your texture image and
     * continuously update this texture as long as video is playing - the VideoTexture class handles this automatically.
     */
    public ImageData image;

    /**
     * Array of user-specified mipmaps (optional).
     */
    public Object[] mipmaps;

    /**
     * How the image is applied to the object. An object type of THREE.UVMapping is the default, where the U,V coordinates are used to apply the map.
     * See the texture constants page for other mapping types.
     */
    public int mapping;

    /**
     * This defines how the texture is wrapped horizontally and corresponds to U in UV mapping.
     * The default is THREE.ClampToEdgeWrapping, where the edge is clamped to the outer edge texels. The other two choices
     * are THREE.RepeatWrapping and THREE.MirroredRepeatWrapping. See the texture constants page for details.
     */
    public int wrapS;

    /**
     * This defines how the texture is wrapped vertically and corresponds to V in UV mapping.
     * The same choices are available as for wrapS .
     * <p>
     * NOTE: tiling of images in textures only functions if image dimensions are powers of two (2, 4, 8, 16, 32, 64, 128,
     * 256, 512, 1024, 2048, ...) in terms of pixels. Individual dimensions need not be equal, but each must be a power of two.
     * This is a limitation of WebGL, not three.js.
     */
    public int wrapT;

    /**
     * How the texture is sampled when a texel covers more than one pixel. The default is THREE.LinearFilter, which takes
     * the four closest texels and bilinearly interpolates among them. The other option is THREE.NearestFilter, which uses
     * the value of the closest texel.
     * See the texture constants page for details.
     */
    public int magFilter;

    /**
     * How the texture is sampled when a texel covers less than one pixel. The default is THREE.LinearMipMapLinearFilter,
     * which uses mipmapping and a trilinear filter.
     * <p>
     * See the texture constants page for all possible choices.
     */
    public int minFilter;

    /**
     * The number of samples taken along the axis through the pixel that has the highest density of texels. By default,
     * this value is 1. A higher value gives a less blurry result than a basic mipmap, at the cost of more texture samples
     * being used. Use renderer.getMaxAnisotropy() to find the maximum valid anisotropy value for the GPU; this value is
     * usually a power of 2.
     */
    public int anisotropy;

    /**
     * The default is THREE.RGBAFormat, although the TextureLoader will automatically set this to THREE.RGBFormat for JPG images.
     * <p>
     * See the texture constants page for details of other formats.
     */
    public int format;

    /**
     * This must correspond to the .format. The default is THREE.UnsignedByteType, which will be used for most texture formats.
     * <p>
     * See the texture constants page for details of other formats.
     */
    public int type;

    /**
     * How much a single repetition of the texture is offset from the beginning, in each direction U and V. Typical range
     * is 0.0 to 1.0. _Note:_ The offset property is a convenience modifier and only affects the Texture's application to
     * the first set of UVs on a model. If the Texture is used as a map requiring additional UV sets (e.g. the aoMap or
     * lightMap of most stock materials), those UVs must be manually assigned to achieve the desired offset.
     */
    public Vector2 offset;

    /**
     * How many times the texture is repeated across the surface, in each direction U and V. If repeat is set greater than
     * 1 in either direction, the corresponding Wrap parameter should also be set to THREE.RepeatWrapping or THREE.MirroredRepeatWrapping
     * to achieve the desired tiling effect. _Note:_ The repeat property is a convenience modifier and only affects the
     * Texture's application to the first set of UVs on a model. If the Texture is used as a map requiring additional UV
     * sets (e.g. the aoMap or lightMap of most stock materials), those UVs must be manually assigned to achieve the desired
     * repetiton.
     */
    public Vector2 repeat;

    /**
     * How much the texture is rotated around the center point, in radians. Postive values are counter-clockwise. Default is 0.
     */
    public float rotation;

    /**
     * Indicates where the center of rotation is. To rotate around the center point set this value to (0.5, 0.5). Default value is (0.0, 0.0).
     */
    public Vector2 center;

    /**
     * Whether to update the texture's uv-transform # .matrix based on the .offset , .repeat , and .rotation settings.
     * True by default. Set this to false if you are specifying the uv-transform matrix directly.
     */
    public boolean matrixAutoUpdate;

    /**
     * The uv-transform matrix for the texture. Updated by the renderer from the texture properties  .offset ,
     * .repeat , and  .rotation when the texture's  .matrixAutoUpdate property is true. When  .matrixAutoUpdate
     * property is false, this matrix may be set manually. Default is the indentity matrix.
     */
    public Matrix3 matrix;

    /**
     * Whether to generate mipmaps (if possible) for a texture. True by default. Set this to false if you are creating
     * mipmaps manually.
     */
    public boolean generateMipmaps;

    /**
     * False by default, which is the norm for PNG images. Set to true if the RGB values have been stored premultiplied by alpha.
     */
    public boolean premultiplyAlpha;

    /**
     * True by default. Flips the image's Y axis to match the WebGL texture coordinate space.
     */
    public boolean flipY;

    /**
     * 4 by default. Specifies the alignment requirements for the start of each pixel row in memory. The allowable values
     * are 1 (byte-alignment), 2 (rows aligned to even-numbered bytes), 4 (word-alignment), and 8 (rows start on double-word
     * boundaries). See glPixelStorei for more information.
     */
    public int unpackAlignment;

    /**
     * THREE.LinearEncoding is the default. See the texture constants page for details of other formats.
     * <p>
     * Note that ff this value is changed on a texture after the material has been used, it is necessary to trigger a
     * Material.needsUpdate for this value to be realized in the shader.
     */
    public int encoding;

    /**
     * A callback function, called when the texture is updated (e.g., when needsUpdate has been set to true and then the texture is used).
     */
    public UpdateCallback onUpdate;

    /**
     * Set this to true to trigger an update next time the texture is used. Particularly important for setting the wrap mode.
     */
    public boolean needsUpdate;

    @JsConstructor
    public Texture() {

    }

    @JsConstructor
    public Texture(Object image, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int format, int type, int anisotropy, int encoding) {

    }

    /**
     * Readonly - unique number for this texture instance.
     *
     * @return id - unique number for this texture instance.
     */
    @JsProperty
    public native int getId();

    /**
     * UUID of this object instance. This gets automatically assigned, so this shouldn't be edited.
     *
     * @return uuid of this object instance
     */
    @JsProperty
    public native int getUuid();

    /**
     * This starts at 0 and counts how many times # .needsUpdate is set to true.
     *
     * @return version of this object instance
     */
    @JsProperty
    public native int getVersion();

    /**
     * Update the texture's uv-transform .matrix from the texture properties .offset, .repeat, .rotation, and .center.
     */
    public native void updateMatrix();

    /**
     * Make copy of the texture. Note this is not a "deep copy", the image is shared.
     *
     * @return instance of texture
     */
    public native Texture clone();

    /**
     * Convert the material to three.js JSON format.
     *
     * @return JSON String
     */
    public native String toJSON();

    /**
     * Convert the material to three.js JSON format.
     *
     * @param meta -- optional object containing metadata.
     * @return JSON String
     */
    public native String toJSON(Object meta);

    /**
     * Call EventDispatcher.dispatchEvent with a 'dispose' event type.
     */
    public native void dispose();

    /**
     *
     * @param uv instance of Vector2
     */
    public native void  transformUv(Vector2 uv);

}
