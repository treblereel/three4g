package org.treblereel.gwt.three4g.demo.client.local.gui;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/7/17.
 */
@JsType(isNative = true, namespace = "dat", name = "Group")
public class Button {

    public native Slider listen();

    public native Slider name(String name);

    public native Slider onChange(OnChangeEvent event);

}
