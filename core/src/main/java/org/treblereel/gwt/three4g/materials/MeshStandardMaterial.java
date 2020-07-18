package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A standard physically based material, using Metallic-Roughness workflow.
 * <p>
 * Physically based rendering (PBR) has recently become the standard in many 3D applications, such as Unity, Unreal and 3D Studio Max.
 * <p>
 * This approach differs from older approaches in that instead of using approximations for the way in which light	interacts with a surface, a physically correct model is used. The idea is that, instead of tweaking materials to look good under specific lighting, a material can	be created that will react 'correctly' under all lighting scenarios.
 * <p>
 * In practice this gives a more	accurate and realistic looking result than the MeshLambertMaterial or MeshPhongMaterial, at the cost of being somewhat more computationally expensive.
 * <p>
 * Shading is calculated in the same way as for the MeshPhongMaterial, using a Phong shading model.	This calculates shading per pixel (i.e. in the fragment shader, AKA pixel shader) which gives more accurate results than the Gouraud model used by MeshLambertMaterial, at the cost of some performance.
 * <p>
 * Note that for best results you should always specify an environment map when using this material.
 * <p>
 * For a non-technical introduction to the concept of PBR and how to set up a PBR material, check out these articles by the people at marmoset:
 * <p>
 * Basic Theory of Physically Based Rendering
 * Physically Based Rendering and You Can Too
 * Technical details of the approach used in three.js (and most other PBR systems) can be found is this paper from Disney (pdf), by Brent Burley.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, name = "THREE.MeshStandardMaterial", namespace = JsPackage.GLOBAL)
public class MeshStandardMaterial extends Material {

    /**
     * The alpha map is a grayscale texture that controls the opacity across the surface (black: fully transparent; white: fully opaque). Default is null.
     * <p>
     * Only the color of the texture is used, ignoring the alpha channel if one exists. For RGB and RGBA textures, the WebGL renderer will use the green channel when sampling this texture due to the extra bit of precision provided for green in DXT-compressed and uncompressed RGB 565 formats. Luminance-only and luminance/alpha textures will also still work as expected.
     */
    public Texture alphaMap;

    /**
     * The red channel of this texture is used as the ambient occlusion map. Default is null. The aoMap requires a second set of UVs, and consequently will ignore the repeat and offset Texture properties.
     */
    public Texture aoMap;

    /**
     * Intensity of the ambient occlusion effect. Default is 1. Zero is no occlusion effect.
     */
    public float aoMapIntensity;

    /**
     * The texture to create a bump map. The black and white values map to the perceived depth in relation to the lights. Bump doesn't actually affect the geometry of the object, only the lighting. If a normal map is defined this will be ignored.
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
     * An object of the form:
     * { 'STANDARD': '' };
     * This is used by the WebGLRenderer for selecting shaders.
     */
    public Object defines;

    /**
     * The displacement map affects the position of the mesh's vertices. Unlike other maps which only affect the light and shade of the material the displaced vertices can cast shadows, block other objects, and otherwise act as real geometry. The displacement texture is an image where the value of each pixel (white being the highest) is mapped against, and repositions, the vertices of the mesh.
     */
    public Texture displacementMap;

    /**
     * How much the displacement map affects the mesh (where black is no displacement, and white is maximum displacement). Without a displacement map set, this value is not applied. Default is 1.
     */
    public float displacementScale;

    /**
     * The offset of the displacement map's values on the mesh's vertices. Without a displacement map set, this value is not applied. Default is 0.
     */
    public float displacementBias;

    /**
     * Emissive (light) color of the material, essentially a solid color unaffected by other lighting. Default is black.
     */
    public Color emissive;

    /**
     * Set emisssive (glow) map. Default is null. The emissive map color is modulated by the emissive color and the emissive intensity. If you have an emissive map, be sure to set the emissive color to something other than black.
     */
    public Texture emissiveMap;

    /**
     * Intensity of the emissive light. Modulates the emissive color. Default is 1.
     */
    public float emissiveIntensity;

    /**
     * The environment map. Default is null. Note that in order for the material roughness property to correctly blur out the environment map, the shader must have access to mipmaps of the env texture. TextureCubes created with default settings are correctly configured; if adjusting texture parameters manually, ensure minFilter is set to one of the Mipmap options, and that mip maps have not been otherwise forcibly disabled.
     */
    public CubeTexture envMap;

    /**
     * Scales the effect of the environment map by multiplying its color.
     */
    public float envMapIntensity;

    /**
     * Used to check whether this or derived classes are mesh standard materials. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMeshStandardMaterial;

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
     * How much the material is like a metal. Non-metallic materials such as wood or stone use 0.0, metallic use 1.0, with nothing (usually) in between. Default is 0.5. A value between 0.0 and 1.0 could be used for a rusty metal look. If metalnessMap is also provided, both values are multiplied.
     */
    public float metalness;

    /**
     * The blue channel of this texture is used to alter the metalness of the material.
     */
    public Texture metalnessMap;

    /**
     * Defines whether the material uses morphNormals. Set as true to pass morphNormal attributes from the Geometry	to the shader. Default is false.
     */
    public boolean morphNormals;

    /**
     * Define whether the material uses morphTargets. Default is false.
     */
    public boolean morphTargets;

    /**
     * The texture to create a normal map. The RGB values affect the surface normal for each pixel fragment and change the way the color is lit. Normal maps do not change the actual shape of the surface, only the lighting.
     */
    public Texture normalMap;

    /**
     * How much the normal map affects the material. Typical ranges are 0-1. Default is a Vector2 set to (1,1).
     */
    public Vector2 normalScale;

    /**
     * The index of refraction (IOR) of air (approximately 1) divided by the index of refraction of the material. It is used with environment mapping modes THREE.CubeRefractionMapping and THREE.EquirectangularRefractionMapping. The refraction ratio should not exceed 1. Default is 0.98.
     */
    public float refractionRatio;

    /**
     * How rough the material appears. 0.0 means a smooth mirror reflection, 1.0 means fully diffuse. Default is 0.5. If roughnessMap is also provided, both values are multiplied.
     */
    public float roughness;

    /**
     * The green channel of this texture is used to alter the roughness of the material.
     */
    public Texture roughnessMap;

    /**
     * Define whether the material uses skinning. Default is false.
     */
    public boolean skinning;

    /**
     * Render geometry as wireframe. Default is false (i.e. render as flat polygons).
     */
    public boolean wireframe;

    /**
     * Define appearance of line ends. Possible values are "butt", "round" and "square". Default is 'round'.
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


    public MeshStandardMaterial() {

    }

    /**
     * @param parameters - (optional) an object with one or more properties defining the material's appearance. Any property of the material (including any property inherited from Material) can be passed in here.
     *                   <p>
     *                   The exception is the property color, which can be passed in as a hexadecimal string and is 0xffffff (white) by default. Color.set( color ) is called internally.
     */
    public MeshStandardMaterial(MeshStandardMaterialParameters parameters) {

    }

    @JsOverlay
    public final MeshStandardMaterial setColor(int color) {
        this.color = new Color(color);
        return this;
    }

    @JsOverlay
    public final MeshStandardMaterial setColor(Color color) {
        this.color = color;
        return this;
    }
}
