package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;
import jsinterop.base.JsPropertyMap;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/8/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class JsObject {

    @JsOverlay
    public final <T> T getProperty(String name){
        JsPropertyMap asMap =  Js.uncheckedCast(this);
        return (T) asMap.get(name);
    }

    @JsOverlay
    public final void setProperty(String name, Object value){
        JsPropertyMap asMap =  Js.uncheckedCast(this);
        asMap.set(name, value);
    }

    @JsOverlay
    public final boolean hasProperty(String name){
        JsPropertyMap asMap =  Js.uncheckedCast(this);
        return asMap.has(name);
    }

    @JsOverlay
    public final void deleteProperty(String name){
        JsPropertyMap asMap =  Js.uncheckedCast(this);
        asMap.delete(name);
    }

    @JsOverlay
    public final <T> T cast() {
        return (T) Js.uncheckedCast(this);
    }

    @JsOverlay
    public final JsPropertyMap<JsObject> asPropertyMap() {
        return (JsPropertyMap)Js.uncheckedCast(this);
    }

    @JsOverlay
    public final <T> JsArrayLike<T> asArrayLike() {
        return (JsArrayLike<T>)Js.asArrayLike(this);
    }

}
