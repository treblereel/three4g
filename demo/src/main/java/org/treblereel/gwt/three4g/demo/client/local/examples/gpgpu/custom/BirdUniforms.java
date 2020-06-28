package org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.custom;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/13/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BirdUniforms {

    public Value<Color> color;
    public Value<Double> time, delta;
    public Value<Vector3> predator;
    public Value<Object> texturePosition, textureVelocity;
    @JsConstructor
    public BirdUniforms() {

    }


}
