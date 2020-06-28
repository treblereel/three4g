package org.treblereel.gwt.three4g.demo.client.local.gui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import java.util.Map;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.examples.gui.Utils;

//import org.treblereel.gwt.three4g.demo.client.local.three.Camera;
//import org.treblereel.gwt.three4g.demo.client.local.three.Object3D;
//import org.treblereel.gwt.three4g.cameras.Camera;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/6/17.
 */
@JsType(isNative = true, namespace = "dat")
public class GUIVR extends Object3D {

    public static native GUIVR create(String name);

    public static native Object addInputObject(Object input);

    public static native void disableMouse();

    public static native Object enableMouse(Camera camera);

    public native GUIVR addFolder(String name);

    private native Slider add(Object holder, String value);

    public native GUIVR add(GUIVR folder, String value);

    private native Slider add(Object holder, String value, Double min, Double max);

    private native Group add(Object holder, String value, JsArrayString jsArrayString);

    private native Group add(Object holder, String value, JavaScriptObject jsArrayString);

    @JsOverlay
    public final Slider addSlider(Object holder, String value) {
        return add(holder, value);
    }

    @JsOverlay
    public final Slider addSlider(Object holder, String value, Double min, Double max) {
        return add(holder, value, min, max);
    }


    public native Group addButton(Object holder, String value);

    @JsOverlay
    public final Group addCheckbox(Object holder, String value) {
        return add(holder, value);
    }

    @JsOverlay
    public final Group addDropdown(Object holder, String value, String[] values) {
        JsArrayString jsArrayString = JsArrayString.createArray().cast();
        for (String s : values) {
            jsArrayString.push(s);
        }
        return add(holder, value, jsArrayString);
    }

    @JsOverlay
    public final Group addDropdown(Object holder, String value, Map values) {
        return add(holder, value, Utils.toJavaScriptObject(values));
    }

}
