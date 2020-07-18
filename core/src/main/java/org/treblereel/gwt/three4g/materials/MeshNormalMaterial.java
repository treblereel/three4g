package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.MeshNormalMaterialParameters;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, name = "THREE.MeshNormalMaterial", namespace = JsPackage.GLOBAL)
public class MeshNormalMaterial extends Material {

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
     * Whether the material is affected by fog. Default is false.
     */
    public boolean fog;

    /**
     * Used to check whether this or derived classes are mesh normal materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMeshNormalMaterial;

    /**
     * Whether the material is affected by lights. Default is false.
     */
    public boolean lights;

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
     * Render geometry as wireframe. Default is false (i.e. render as smooth shaded).
     */
    public boolean wireframe;

    /**
     * Controls wireframe thickness. Default is 1.
     * Due to limitations in the ANGLE layer, on Windows platforms linewidth will always be 1 regardless of the set value.
     */
    public float wireframeLinewidth;

    public MeshNormalMaterial() {

    }

    @JsConstructor
    public MeshNormalMaterial(MeshNormalMaterialParameters meshNormalMaterialParameters) {

    }
}
