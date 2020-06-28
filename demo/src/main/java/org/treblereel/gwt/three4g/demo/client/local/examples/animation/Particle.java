package org.treblereel.gwt.three4g.demo.client.local.examples.animation;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/22/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Particle {

    public Vector3 position;
}
