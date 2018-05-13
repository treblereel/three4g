package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class SpriteMaterialParameters extends MaterialParameters {

    /**
     * Color of the material, by default set to white (0xffffff). The .map is mutiplied by the color.
     */
    public Color color;

    /**
     * Whether or not this material affected by the scene's fog. Default is false
     */
    public boolean fog;

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
}
