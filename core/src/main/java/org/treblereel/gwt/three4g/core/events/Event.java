package org.treblereel.gwt.three4g.core.events;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.PropertyHolder;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/15/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Event extends PropertyHolder {

    public String type;

    public PropertyHolder object;
}
