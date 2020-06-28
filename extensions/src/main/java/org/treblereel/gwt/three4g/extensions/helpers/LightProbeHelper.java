package org.treblereel.gwt.three4g.extensions.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.lights.LightProbe;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * Renders a sphere to visualize a light probe in the scene.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */

@Three4gElement(paths = "js/helpers/LightProbeHelper.js")
@JsType(isNative = true, namespace = "THREE")
public class LightProbeHelper extends Mesh {

    public LightProbe lightProbe;

    public int size;

    /**
     *
     * @param lightProbe -- the light probe.
     * @param size -- size of the helper sphere
     */
    public LightProbeHelper(LightProbe lightProbe, int size) {

    }

    /**
     * Frees internal resources.
     */
    public native void dispose();

}
