package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * An object containing details about the capabilities of the current RenderingContext.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/1/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Capabilities {
    /**
     * The shader precision currently being used by the renderer.
     */
    public String precision;
    /**
     * true if the logarithmicDepthBuffer was set to true in the constructor and the context supports the EXT_frag_depth extension. According to WebGLStats, as of February 2016 around 66% of WebGL enabled devices support this.
     */
    public boolean logarithmicDepthBuffer;
    /**
     * true if # .maxVertexTextures : Integeris greater than 0 (i.e. vertext textures can be used).
     */
    public boolean vertexTextures;
    /**
     * whether the context supports the OES_texture_float extension. According to WebGLStats, as of February 2016 over 95% of WebGL enabled devices support this.
     */
    public boolean floatFragmentTextures;
    /**
     * true if floatFragmentTextures and vertexTextures are both true.
     */
    public boolean floatVertexTextures;
    /**
     * The value of gl.MAX_TEXTURE_IMAGE_UNITS. The maximum number of textures that can be used by a shader.
     */
    public int maxTextures;
    /**
     * The value of gl.MAX_VERTEX_TEXTURE_IMAGE_UNITS. The number of textures that can be used in a vertex shader.
     */
    public int maxVertexTextures;
    /**
     * The value of gl.MAX_TEXTURE_SIZE. Maximum height * width of a texture that a shader use.
     */
    public int maxTextureSize;
    /**
     * The value of gl.MAX_CUBE_MAP_TEXTURE_SIZE. Maximum height * width of cube map textures that a shader can use.
     */
    public int maxCubemapSize;
    /**
     * The value of gl.MAX_VERTEX_ATTRIBS.
     */
    public int maxAttributes;
    /**
     * The value of gl.MAX_VERTEX_UNIFORM_VECTORS. The maximum number of uniforms that can be used in a vertex shader.
     */
    public int maxVertexUniforms;
    /**
     * The value of gl.MAX_VARYING_VECTORS. The number of varying vectors that can used by shaders.
     */
    public int maxVaryings;
    /**
     * The value of gl.MAX_FRAGMENT_UNIFORM_VECTORS. The number of uniforms that can be used by a fragment shader.
     */
    public int maxFragmentUniforms;

    /**
     * @return Returns the maximum available anisotropy.
     */
    public native int getMaxAnisotropy();

    /**
     * @return Returns the maximum available precision for vertex and fragment shaders.
     */
    public native int getMaxPrecision();
}
