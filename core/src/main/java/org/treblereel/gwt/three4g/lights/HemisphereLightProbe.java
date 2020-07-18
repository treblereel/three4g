package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 * Light probes are an alternative way of adding light to a 3D scene. HemisphereLightProbe is the light estimation data of a single hemisphere light in the scene. For more information about light probes, go to LightProbe.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@JsType(isNative = true, name = "THREE.HemisphereLightProbe", namespace = JsPackage.GLOBAL)
public class HemisphereLightProbe extends LightProbe {

    /**
     * Creates a new HemisphereLightProbe.
     */
    public HemisphereLightProbe() {

    }

    /**
     * Creates a new HemisphereLightProbe.
     * @param skyColor - (optional) An instance of Color, string representing a color or a number representing a color.
     */
    public HemisphereLightProbe(Color skyColor) {

    }

    /**
     * Creates a new HemisphereLightProbe.
     * @param skyColor - (optional) An instance of Color, string representing a color or a number representing a color.
     * @param groundColor - (optional) An instance of Color, string representing a color or a number representing a color.
     */
    public HemisphereLightProbe(Color skyColor, Color groundColor) {

    }

    /**
     * Creates a new HemisphereLightProbe.
     * @param skyColor - (optional) An instance of Color, string representing a color or a number representing a color.
     * @param groundColor - (optional) An instance of Color, string representing a color or a number representing a color.
     * @param intensity - (optional) Numeric value of the light probe's intensity. Default is 1.
     */
    public HemisphereLightProbe(Color skyColor, Color groundColor, float intensity) {

    }
}
