package org.treblereel.gwt.three4g.extensions.renderers;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
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
@Three4gElement(paths = "js/renderers/CSS2DRenderer.js")
@JsType(isNative = true, namespace = "THREE")
public class CSS2DRenderer {

    /**
     * A canvas where the renderer draws its output.
     * This is automatically created by the renderer in the constructor (if not provided already); you just need to
     * add it to your page like so:
     * document.body.appendChild( renderer.domElement );
     */
    public HTMLElement domElement;

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
    public native void setSize(double width, double height);
}
