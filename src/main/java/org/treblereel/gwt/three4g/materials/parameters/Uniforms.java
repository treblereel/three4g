package org.treblereel.gwt.three4g.materials.parameters;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/7/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Uniforms extends JsObject {

    @JsOverlay
    public final Uniforms addToUniforms(String name, Object value) {
        JsPropertyMap holder =  Js.uncheckedCast(this);

        JsPropertyMap temp = JsPropertyMap.of();
        temp.set("value", value);
        holder.set(name, temp);
        return this;
    }

    @JsOverlay
    public final JsObject get(String name) {
        JsPropertyMap instance = Js.uncheckedCast(this);
        return (JsObject) instance.get(name);
    }

}
