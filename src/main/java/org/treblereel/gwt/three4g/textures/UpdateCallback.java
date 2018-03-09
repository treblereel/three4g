package org.treblereel.gwt.three4g.textures;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/9/18.
 */
@JsFunction
@FunctionalInterface
public interface UpdateCallback {

    void onUpdate(Texture texture);
}
