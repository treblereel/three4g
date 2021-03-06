package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 12/5/17.
 */
@JsType(isNative = true, namespace = "THREE")
public class Scene extends Object3D {

    /**
     * A fog instance defining the type of fog that affects everything rendered in the scene. Default is null.
     */
    public Fog fog;

    /**
     * If not null, it will force everything in the scene to be rendered with that material. Default is null.
     */
    public Material overrideMaterial;

    /**
     * Default is true. If set, then the renderer checks every frame if the scene and its objects needs matrix updates. When it isn't, then you have to maintain all matrices in the scene yourself.
     */
    public boolean autoUpdate;

    /**
     * Used to check whether this or derived classes are Scene. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isScene;

    /**
     * If not null, sets the background used when rendering the scene, and is always rendered first. Can be set to a Color which sets the clear color, a Texture covering the canvas, or a CubeTexture. Default is null.
     */
    public PropertyHolder background;

    @JsConstructor
    public Scene() {

    }

    /**
     * Return the scene data in JSON format.
     *
     * @return to JSON String
     */
    public native String toJSON();


    /**
     * Clears scene related data internally cached by WebGLRenderer.
     */
    public native void dispose();
}
