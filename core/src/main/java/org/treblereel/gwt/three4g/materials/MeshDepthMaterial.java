package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.MeshDepthMaterialParameters;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A material for drawing geometry by depth. Depth is based off of the camera near and far plane. White is nearest, black is farthest.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/22/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MeshDepthMaterial extends Material {


    /**
     * The alpha map is a grayscale texture that controls the opacity across the surface (black: fully transparent; white: fully opaque). Default is null.
     * Only the color of the texture is used, ignoring the alpha channel if one exists. For RGB and RGBA textures, the WebGL renderer will use the green channel when sampling this texture due to the extra bit of precision provided for green in DXT-compressed and uncompressed RGB 565 formats. Luminance-only and luminance/alpha textures will also still work as expected.
     */
    public Texture alphaMap;

    /**
     * Encoding for depth packing. Default is BasicDepthPacking. See Constants
     */
    public int depthPacking;

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
     * Whether the material is affected by fog. Default is false.
     */
    public boolean fog;

    /**
     * Used to check whether this or derived classes are mesh depth materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMeshDepthMaterial;

    /**
     * Whether the material is affected by lights. Default is false.
     */
    public boolean lights;

    /**
     * Sets the color of the points using data from a Texture.
     */
    public Texture map;

    /**
     * Define whether the material uses morphTargets. Default is false.
     */
    public boolean morphTargets;

    /**
     * Define whether the material uses skinning. Default is false.
     */
    public boolean skinning;

    /**
     * Render geometry as wireframe. Default is false (i.e. render as flat polygons).
     */
    public boolean wireframe;

    /**
     * Controls wireframe thickness. Default is 1.
     * <p>
     * Due to limitations in the ANGLE layer, on Windows platforms linewidth will always be 1 regardless of the set value.
     */
    public float wireframeLinewidth;

    @JsConstructor
    public MeshDepthMaterial() {

    }

    /**
     * @param parameters - (optional) an object with one or more properties defining the material's appearance. Any property
     *                   of the material (including any property inherited from Material) can be passed in here.
     */
    @JsConstructor
    public MeshDepthMaterial(MeshDepthMaterialParameters parameters) {

    }


}
