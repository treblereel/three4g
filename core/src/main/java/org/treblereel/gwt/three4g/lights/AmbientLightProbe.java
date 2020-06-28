package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 *  Light probes are an alternative way of adding light to a 3D scene. AmbientLightProbe is the light estimation data of a single ambient light in the scene. For more information about light probes, go to LightProbe.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@JsType(isNative = true, namespace = "THREE")
public class AmbientLightProbe extends LightProbe {

    /**
     * Creates a new AmbientLightProbe.
     * @param color - (optional) An instance of Color, string representing a color or a number representing a color.
     * @param intensity - (optional) Numeric value of the light probe's intensity. Default is 1.
     */
    public AmbientLightProbe(Color color, float intensity) {

    }

}
