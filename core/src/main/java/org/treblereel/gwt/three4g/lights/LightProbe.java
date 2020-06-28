package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.lights.Light;
import org.treblereel.gwt.three4g.math.SphericalHarmonics3;

/**
 * Light probes are an alternative way of adding light to a 3D scene. Unlike classical light sources (e.g. directional, point or spot lights), light probes do not emit light. Instead they store information about light passing through 3D space. During rendering, the light that hits a 3D object is approximated by using the data from the light probe.
 *
 * Light probes are usually created from (radiance) environment maps. The class LightProbeGenerator can be used to create light probes from instances of CubeTexture or WebGLCubeRenderTarget. However, light estimation data could also be provided in other forms e.g. by WebXR. This enables the rendering of augmented reality content that reacts to real world lighting.
 *
 * The current probe implementation in three.js supports so-called diffuse light probes. This type of light probe is functionally equivalent to an irradiance environment map.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@JsType(isNative = true, namespace = "THREE")
public class LightProbe extends Light {

    public SphericalHarmonics3 sh;

    public LightProbe() {

    }

    /**
     *
     * @param sh - (optional) An instance of SphericalHarmonics3.
     */
    public LightProbe(SphericalHarmonics3 sh) {

    }

    /**
     *
     * @param sh - (optional) An instance of SphericalHarmonics3.
     * @param intensity - (optional) Numeric value of the light probe's intensity. Default is 1.
     */
    public LightProbe(SphericalHarmonics3 sh, float intensity) {

    }

}
