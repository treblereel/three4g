package org.treblereel.gwt.three4g.extensions.objects;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/14/18.
 */
@Three4gElement(paths = "js/objects/Lensflare.js")
@JsType(isNative = true, namespace = "THREE")
public class LensflareElement {

    /**
     * @param texture - Texture to use for the flare.
     */
    public LensflareElement(Texture texture) {

    }

    /**
     * @param texture - Texture to use for the flare.
     * @param size    -  size in pixels
     */
    public LensflareElement(Texture texture, double size) {

    }

    /**
     * @param texture  - Texture to use for the flare.
     * @param size     -  size in pixels
     * @param distance - (0-1) from light source (0 = at light source)
     */
    public LensflareElement(Texture texture, double size, float distance) {

    }

    /**
     * @param texture  - Texture to use for the flare.
     * @param size     -  size in pixels
     * @param distance - (0-1) from light source (0 = at light source)
     * @param color    - the Color of the lens flare
     */
    public LensflareElement(Texture texture, double size, float distance, Color color) {

    }
}
