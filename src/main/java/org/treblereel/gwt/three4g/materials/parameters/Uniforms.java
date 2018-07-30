package org.treblereel.gwt.three4g.materials.parameters;

import com.google.gwt.core.client.GWT;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.JsObject;
import org.treblereel.gwt.three4g.utils.JSON;


/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/7/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Uniforms {

    @JsOverlay
    public final Uniforms set(String name, Object value) {
        JsObject holder = Js.uncheckedCast(this);
        JsPropertyMap temp = JsPropertyMap.of();
        temp.set("value", value);
        holder.setProperty(name, temp);
        return this;
    }

    @JsOverlay
    /**
     * Left side must be non-primitive type
     */
    public final <T> T get(String name) {
        JsPropertyMap instance = Js.uncheckedCast(this);
        Object result = ((JsObject) instance.get(name)).getProperty("value");
        return (T) result;
    }

}
