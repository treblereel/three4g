package org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.custom;

import jsinterop.base.JsPropertyMap;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/13/18.
 */
public class Value<T> {

    JsPropertyMap value;

    public Value(T value) {
        this.value = JsPropertyMap.of("value", value);

    }

    public T get() {
        return (T) value.get("value");
    }
}
