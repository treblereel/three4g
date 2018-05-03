package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/12/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class MeshPhongMaterialParameters extends MaterialParameters {
    /**
     * The alpha map is a grayscale texture that controls the opacity across the surface (black: fully transparent; white:
     * fully opaque). Default is null.
     * <p>
     * Only the color of the texture is used, ignoring the alpha channel if one exists. For RGB and RGBA textures, the WebGL
     * renderer will use the green channel when sampling this texture due to the extra bit of precision provided for green
     * in DXT-compressed and uncompressed RGB 565 formats. Luminance-only and luminance/alpha textures will also still
     * work as expected.
     */
    public Texture alphaMap;

    /**
     * The red channel of this texture is used as the ambient occlusion map. Default is null. The aoMap requires a second
     * set of UVs, and consequently will ignore the repeat and offset Texture properties.
     */
    public Texture aoMap;

    /**
     * Intensity of the ambient occlusion effect. Default is 1. Zero is no occlusion effect.
     */
    public float aoMapIntensity;

    /**
     * The texture to create a bump map. The black and white values map to the perceived depth in relation to the lights.
     * Bump doesn't actually affect the geometry of the object, only the lighting. If a normal map is defined this will be ignored.
     */
    public Texture bumpMap;

    /**
     * How much the bump map affects the material. Typical ranges are 0-1. Default is 1.
     */
    public float bumpScale;

    /**
     * Color of the material, by default set to white (0xffffff).
     */
    public Color color;

    /**
     * How to combine the result of the surface's color with the environment map, if any.
     * <p>
     * Options are Multiply (default), MixOperation, AddOperation. If mix is chosen, the .reflectivity is used to blend between the two colors.
     */
    public int combine;

    /**
     * The displacement map affects the position of the mesh's vertices. Unlike other maps which only affect the light and
     * shade of the material the displaced vertices can cast shadows, block other objects, and otherwise act as real geometry.
     * The displacement texture is an image where the value of each pixel (white being the highest) is mapped against, and
     * repositions, the vertices of the mesh.
     */
    public Texture displacementMap;

    /**
     * How much the displacement map affects the mesh (where black is no displacement, and white is maximum displacement).
     * Without a displacement map set, this value is not applied. Default is 1.
     */
    public float displacementScale;

    /**
     * The offset of the displacement map's values on the mesh's vertices. Without a displacement map set, this value is not applied. Default is 0.
     */
    public float displacementBias;

    /**
     * Emissive (light) color of the material, essentially a solid color unaffected by other lighting. Default is black..
     */
    public Color emissive;

    /**
     * Set emisssive (glow) map. Default is null. The emissive map color is modulated by the emissive color and the emissive
     * intensity. If you have an emissive map, be sure to set the emissive color to something other than black.
     */
    public Texture emissiveMap;

    /**
     * Intensity of the emissive light. Modulates the emissive color. Default is 1.
     */
    public float emissiveIntensity;

    /**
     * The environment map. Default is null.
     */
    public CubeTexture envMap;

    /**
     * The light map. Default is null. The lightMap requires a second set of UVs, and consequently will ignore the repeat and offset Texture properties.
     */
    public Texture lightMap;

    /**
     * Intensity of the baked light. Default is 1.
     */
    public float lightMapIntensity;

    /**
     * The color map. Default is null. The texture map color is modulated by the diffuse .color.
     */
    public Texture map;

    /**
     * Defines whether the material uses morphNormals. Set as true to pass morphNormal attributes from the Geometry	to the shader. Default is false.
     */
    public boolean morphNormals;

    /**
     * Define whether the material uses morphTargets. Default is false.
     */
    public boolean morphTargets;

    /**
     * The texture to create a normal map. The RGB values affect the surface normal for each pixel fragment and change the
     * way the color is lit. Normal maps do not change the actual shape of the surface, only the lighting.
     */
    public Texture normalMap;

    /**
     * How much the normal map affects the material. Typical ranges are 0-1. Default is a Vector2 set to (1,1).
     */
    public Vector2 normalScale;

    /**
     * How much the environment map affects the surface; also see .combine. The default value is 1 and the valid range is
     * between 0 (no reflections) and 1 (full reflections).
     */
    public float reflectivity;

    /**
     * The index of refraction (IOR) of air (approximately 1) divided by the index of refraction of the material. It is
     * used with environment mapping modes CubeRefractionMapping and EquirectangularRefractionMapping. The
     * refraction ratio should not exceed 1. Default is 0.98.
     */
    public float refractionRatio;

    /**
     * How shiny the .specular highlight is; a higher value gives a sharper highlight. Default is 30.
     */
    public float shininess;

    /**
     * Define whether the material uses skinning. Default is false.
     */
    public boolean skinning;

    /**
     * Specular color of the material. Default is a Color set to 0x111111 (very dark grey).
     * <p>
     * This defines how shiny the material is and the color of its shine.
     */
    public Color specular;

    /**
     * The specular map value affects both how much the specular surface highlight contributes and how much of the
     * environment map affects the surface. Default is null.
     */
    public Texture specularMap;

    /**
     * Render geometry as wireframe. Default is false (i.e. render as flat polygons).
     */
    public boolean wireframe;

    /**
     * Define appearance of line ends. Possible values are "butt", "round" and "square". Default is 'round'.
     * <p>
     * This corresponds to the 2D Canvas lineCap property and it is ignored by the WebGL renderer.
     */
    public String wireframeLinecap;

    /**
     * Define appearance of line joints. Possible values are "round", "bevel" and "miter". Default is 'round'.
     * <p>
     * This corresponds to the 2D Canvas lineJoin property and it is ignored by the WebGL renderer.
     */
    public String wireframeLinejoin;

    /**
     * Controls wireframe thickness. Default is 1.
     * <p>
     * Due to limitations in the ANGLE layer, on Windows platforms linewidth will always be 1 regardless of the set value.
     */
    public float wireframeLinewidth;
}
