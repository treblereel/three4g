package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.materials.SpriteMaterial;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * A sprite is a plane that always faces towards the camera, generally with a partially transparent texture applied.
 * <p>
 * Sprites do not cast shadows, setting
 * castShadow = true will have no effect.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Sprite extends Object3D {

    /**
     * Used to check whether this or derived classes are sprites. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    boolean isSprite;

    /**
     * An instance of SpriteMaterial, defining the object's appearance. Default is a white SpriteMaterial.
     */
    public SpriteMaterial material;

    /**
     * The sprite's anchor point, and the point around which the sprite rotates. A value of (0.5, 0.5) corresponds to the midpoint of the sprite. A value of (0, 0) corresponds to the lower left corner of the sprite. The default is (0.5, 0.5).
     */
    public Vector2 center;

    @JsConstructor
    public Sprite() {

    }

    /**
     * @param material - an instance of SpriteMaterial. Default is a white SpriteMaterial.
     */
    @JsConstructor
    public Sprite(SpriteMaterial material) {

    }

    /**
     * Returns a clone of this Sprite object and any descendants.
     *
     * @return instance of Sprite
     */
    public native Sprite clone();

    /**
     * Copies the properties of the passed sprite to this one.
     *
     * @param sprite instance of Sprite
     * @return instance of Sprite
     */
    public native Sprite copy(Sprite sprite);

    /**
     * Get intersections between a casted Ray and this Line. Raycaster.intersectObject will call this method.
     *
     * @param raycaster instance of Raycaster
     * @param intersects intercasting objects
     */
    public native void raycast(Raycaster raycaster, Object[] intersects);
}
