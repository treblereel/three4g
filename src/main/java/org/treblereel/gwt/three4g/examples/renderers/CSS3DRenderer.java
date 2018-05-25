package org.treblereel.gwt.three4g.examples.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.HeightWidth;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * CSS3DRenderer can be used to apply hierarchical 3D transformations to DOM elements via the CSS3 transform property. This renderer is particular interesting if you want to apply 3D effects to a website without canvas based rendering. It can also be used in order to combine DOM elements with WebGL content.
 * <p>
 * There are, however, some important limitations:
 * <p>
 * It's not possible to use the material system of three.js.
 * It's also not possible to use geometries.
 * So CSS3DRenderer is just focused on ordinary DOM elements. These elements are wrapped into special objects (CSS3DObject or CSS3DSprite) and then added to the scene graph.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CSS3DRenderer {


    public CSS3DRenderer() {

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
