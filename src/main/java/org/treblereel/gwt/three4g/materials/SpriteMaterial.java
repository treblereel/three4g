package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.ShaderMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SpriteMaterial extends Material {

    /**
     * Color of the material, by default set to white (0xffffff). The .map is mutiplied by the color.
     */
    public Color color;

    /**
     * Whether or not this material affected by the scene's fog. Default is false
     */
    public boolean fog;


    public boolean isSpriteMaterial;
    /**
     * Whether the material is affected by lights. Default is false.
     */
    public boolean lights;

    /**
     * The texture map. Default is null.
     */
    public Texture map;

    /**
     * The rotation of the sprite in radians. Default is 0.
     */
    public float rotation;

    /**
     * Whether the size of the sprite is attenuated by the camera depth. (Perspective camera only.) Default is true.
     */
    public boolean sizeAttenuation;

    @JsConstructor
    public SpriteMaterial(){

    }

    @JsConstructor
    public SpriteMaterial(ShaderMaterialParameters parameters){

    }
}
