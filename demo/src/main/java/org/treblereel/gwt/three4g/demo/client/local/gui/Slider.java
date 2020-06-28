package org.treblereel.gwt.three4g.demo.client.local.gui;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/8/17.
 */
@JsType(isNative = true, namespace = "dat", name = "Group")
public class Slider extends Group {

    public native Slider listen();

    public native Slider max(Double min);

    public native Slider min(Double min);

    public native Slider name(String name);

    public native Slider step(Double min);

    public native Slider onChange(OnChangeEvent event);
}
