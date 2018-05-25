package org.treblereel.gwt.three4g.examples.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.HeightWidth;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * CSS2DRenderer is a simplified version of CSS3DRenderer. The only transformation that is supported is translation.
 * <p>
 * The renderer is very useful if you want to combine HTML based labels with 3D objects. Here too, the respective DOM elements are wrapped into an instance of CSS2DObject and added to the scene graph.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CSS2DRenderer {


    public CSS2DRenderer() {

    }

    /**
     * @return Returns an object containing the width and height of the renderer.
     */
    public native HeightWidth getSize();

    /**
     * Renders a scene using a camera.
     *
     * @param scene  instance of Scene
     * @param camera instance of Camera
     */
    public native void render(Scene scene, Camera camera);

    /**
     * Resizes the renderer to (width, height).
     *
     * @param width  as Number
     * @param height as Number
     */
    public native void setSize(Number width, Number height);
}
