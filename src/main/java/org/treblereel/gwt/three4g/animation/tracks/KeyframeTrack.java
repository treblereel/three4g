package org.treblereel.gwt.three4g.animation.tracks;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public interface KeyframeTrack {

    @JsProperty
    String getType();
}
