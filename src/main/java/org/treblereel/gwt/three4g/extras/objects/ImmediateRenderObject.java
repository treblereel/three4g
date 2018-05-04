package org.treblereel.gwt.three4g.extras.objects;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.RenderCallback;

/**
 * base class for immediate rendering objects.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ImmediateRenderObject extends Object3D {

    public ImmediateRenderObject() {

    }

    /**
     * This function needs to be overridden to start the creation of the object and should call renderCallback when finished.
     *
     * @param renderCallback -- A function to render the generated object.
     */
    public native void render(RenderCallback renderCallback);
}
