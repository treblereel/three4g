package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/19/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class PointsMaterialParameters extends MaterialParameters{

    public Color color;
    public boolean lights;
    public Texture map;
    public Number size;
    public boolean sizeAttenuation;

}
