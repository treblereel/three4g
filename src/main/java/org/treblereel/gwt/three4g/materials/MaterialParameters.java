package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Plane;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/7/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class MaterialParameters {

    /**
     * Sets the alpha value to be used when running an alpha test. The material will not be renderered if the opacity is lower than this value. Default is 0.
     */
    public float alphaTest;

    /**
     * Blending destination. Default is OneMinusSrcAlphaFactor. See the destination factors constants for all possible values.
     * The material's # .blending must be set to CustomBlending for this to have any effect.
     */
    public int blendDst;

    /**
     * The tranparency of the .blendDst. Default is null.
     */
    public int blendDstAlpha;

    /**
     * Blending equation to use when applying blending. Default is AddEquation. See the blending equation constants for all possible values.
     * The material's # .blending must be set to CustomBlending for this to have any effect.
     */
    public int blendEquation;

    /**
     * The tranparency of the .blendEquation. Default is null.
     */
    public int blendEquationAlpha;

    /**
     * Which blending to use when displaying objects with this material.
     * This must be set to CustomBlending to use custom # .blendSrc , # .blendDst or # .blendEquation .
     * See the blending mode constants for all possible values. Default is NormalBlending.
     */
    public int blending;

    /**
     * Blending source. Default is SrcAlphaFactor. See the source factors constants for all possible values.
     * The material's # .blending must be set to CustomBlending for this to have any effect.
     */
    public int blendSrc;

    /**
     * The tranparency of the .blendSrc. Default is null.
     */
    public int blendSrcAlpha;

    /**
     * Changes the behavior of clipping planes so that only their intersection is clipped, rather than their union. Default is false.
     */
    public boolean clipIntersection;

    /**
     * User-defined clipping planes specified as THREE.Plane objects in world space. These planes apply to the objects this material is attached to. Points in space whose signed distance to the plane is negative are clipped (not rendered). See the WebGL / clipping /intersection example. Default is null.
     */
    public Plane[] clippingPlanes;

    /**
     * Defines whether to clip shadows according to the clipping planes specified on this material. Default is false.
     */
    public boolean clipShadows;

    /**
     * Whether to render the material's color. This can be used in conjunction with a mesh's # .renderOrder property to create invisible objects that occlude other objects. Default is true.
     */
    public boolean colorWrite;

    /**
     * Custom depth material to be used by this material when rendering to the depth map. When shadow-casting with
     * a DirectionalLight or SpotLight, if you are (a) modifying vertex positions in the vertex shader, (b) using
     * a displacement map, (c) using an alpha map with alphaTest, or (d) using a transparent texture with alphaTest,
     * you must specify a customDepthMaterial for proper shadows. Default is undefined.
     */
    public Material customDepthMaterial;

    /**
     * Same as customDepthMaterial, but used with PointLight. Default is undefined.
     */
    public Material customDistanceMaterial;

    /**
     * Custom defines to be injected into the shader. These are passed in form of an object literal, with key/value pairs. { MY_CUSTOM_DEFINE: '' , PI2: Math.PI * 2 }. The pairs are defined in both vertex and fragment shaders. Default is undefined.
     */
    public Object defines;


    /**
     * Which depth function to use. Default is LessEqualDepth. See the depth mode constants for all possible values.
     */
    public int depthFunc;

    /**
     * Whether to have depth test enabled when rendering this material. Default is true.
     */
    public boolean depthTest;

    /**
     * Whether rendering this material has any effect on the depth buffer. Default is true.
     * <p>
     * When drawing 2D overlays it can be useful to disable the depth writing in order to layer several things together without creating z-index artifacts.
     */
    public boolean depthWrite;

    /**
     * Define whether the material is rendered with flat shading. Default is false.
     */
    public boolean flatShading;

    /**
     * Whether the material is affected by fog. Default is true.
     */
    public boolean fog;

    /**
     * Unique number for this material instance.
     */
    public int id;

    /**
     * Used to check whether this or derived classes are materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMaterial;

    /**
     * Whether the material is affected by lights. Default is true.
     */
    public boolean lights;


    /**
     * Optional name of the object (doesn't need to be unique). Default is an empty string.
     */
    public String name;

    /**
     * Specifies that the material needs to be updated at the WebGL level. Set it to true if you made changes that need to be reflected in WebGL.
     * This property is automatically set to true when instancing a new material.
     */
    public boolean needsUpdate;

    /**
     * Float in the range of 0.0 - 1.0 indicating how transparent the material is. A value of 0.0 indicates fully transparent, 1.0 is fully opaque.
     * If the material's # .transparent property is not set to true, the material will remain fully opaque and this value will only affect its color.
     * Default is 1.0.
     */
    public float opacity;

    /**
     * Amount of triangle expansion at draw time. This is a workaround for cases when gaps appear between triangles when using CanvasRenderer. 0.5 tends to give good results across browsers. Default is 0.
     */
    public float overdraw;

    /**
     * Whether to use polygon offset. Default is false. This corresponds to the GL_POLYGON_OFFSET_FILL WebGL feature.
     */
    public boolean polygonOffset;

    /**
     * Sets the polygon offset factor. Default is 0.
     */
    public int polygonOffsetFactor;

    /**
     * Sets the polygon offset units. Default is 0.
     */
    public int polygonOffsetUnits;

    /**
     * Override the renderer's default precision for this material. Can be "highp", "mediump" or "lowp". Default is null.
     */
    public String precision;

    /**
     * Whether to premultiply the alpha (transparency) value. See WebGL / Materials / Transparency for an example of the difference. Default is false.
     */
    public boolean premultipliedAlpha;

    /**
     * Whether to apply dithering to the color to remove the appearance of banding. Default is false.
     */
    public boolean dithering;

    /**
     * Defines which side of faces cast shadows. When set, can be FrontSide, BackSide, or DoubleSide. Default is null.
     * If null, the side casting shadows is determined as follows:
     * Material.side            Side casting shadows
     * FrontSide                 back side
     * BackSide                  front side
     * DoubleSide                both sides
     */
    public int shadowSide;

    /**
     * Defines which side of faces will be rendered - front, back or both. Default is FrontSide. Other options are BackSide and DoubleSide.
     */
    public int side;


    /**
     * Defines whether this material is transparent. This has an effect on rendering as transparent objects need special treatment and are rendered after non-transparent objects.
     * When set to true, the extent to which the material is transparent is controlled by setting it's # .opacity property.
     * Default is false.
     */
    public boolean transparent;


    /**
     * Value is the string 'Material'. This shouldn't be changed, and can be used to find all objects of this type in a scene.
     */
    public String type;

    /**
     * UUID of this material instance. This gets automatically assigned, so this shouldn't be edited.
     */
    public String uuid;

    /**
     * Defines whether vertex coloring is used. Default is NoColors. Other options are VertexColors and FaceColors.
     */
    public int vertexColors;

    /**
     * Defines whether this material is visible. Default is true.
     */
    public boolean visible;


    /**
     * An object that can be used to store custom data about the Material. It should not hold references to functions as these will not be cloned.
     */
    public Object userData;
}
