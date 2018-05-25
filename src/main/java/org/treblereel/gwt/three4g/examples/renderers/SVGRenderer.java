package org.treblereel.gwt.three4g.examples.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * SVGRenderer can be used to render geometric data using SVG. The produced vector graphics are particular useful in the following use cases:
 * <p>
 * Animated logos or icons
 * Interactive 2D/3D diagrams or graphs
 * Interactive maps
 * Complex or animated user interfaces
 * SVGRenderer has various advantages. It produces crystal-clear and sharp output which is independet of the actual viewport resolution.
 * SVG elements can be styled via CSS. And they have good accessibility since it's possible to add metadata like title or description (useful for search engines or screen readers).
 * <p>
 * There are, however, some important limitations:
 * <p>
 * No advanced shading
 * No texture support
 * No shadow support
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SVGRenderer {

    public SVGRenderer() {

    }

    /**
     * Tells the renderer to clear its drawing surface.
     */
    public native void clear();

    /**
     * Renders a scene using a camera.
     *
     * @param scene  instance of Scene
     * @param camera instance of Camera
     */
    public native void render(Scene scene, Camera camera);

    /**
     * Sets the clear color and opacity.
     *
     * @param alpha the clear alpha
     * @param color instance of Color
     */
    public native void setClearColor(Color color, float alpha);

    /**
     * @param precision Sets the precision of the data used to create a path.
     */
    public native void setPrecision(Number precision);

    /**
     * @param quality Sets the render quality. Possible values are low and high (default).
     */
    public native void setQuality(String quality);

    /**
     * Resizes the renderer to (width, height).
     *
     * @param width  as Number
     * @param height as Number
     */
    public native void setSize(Number width, Number height);

}
