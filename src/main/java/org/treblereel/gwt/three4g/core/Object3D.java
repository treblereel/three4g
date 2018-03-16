package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Matrix3;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/15/17.
 */
@JsType(isNative = true, namespace = "THREE")
public class Object3D extends EventDispatcher {

    /**
     * Whether the object gets rendered into shadow map. Default is false.
     */
    public boolean castShadow;

    /**
     * Array with object's children. See Group for info on manually grouping objects.
     */
    public Object3D[] children;

    /**
     * When this is set, it checks every frame if the object is in the frustum of the camera before
     * rendering the object. Otherwise the object gets renderered every frame even if it isn't visible. Default is true.
     */
    public boolean frustumCulled;

    /**
     * readonly – Unique number for this object instance.
     */
    public int id;

    /**
     * Used to check whether this or derived classes are Object3Ds. Default is true.
     * You should not change this, as it is used internally for optimisation.
     */
    public boolean isObject;

    /**
     * The layer membership of the object. The object is only visible if it has at least one layer in common with the Camera in use.
     */
    public Layers layers;

    /**
     * The local transform matrix.
     */
    public Matrix4 matrix;

    /**
     * When this is set, it calculates the matrix of position, (rotation or quaternion) and scale every frame and also recalculates
     * the matrixWorld property. Default is Object3D.DefaultMatrixAutoUpdate (true).
     */
    public boolean matrixAutoUpdate;

    /**
     * The global transform of the object. If the Object3D has no parent, then it's identical to the local transform .matrix.
     */
    public Matrix4 matrixWorld;

    /**
     * When this is set, it calculates the matrixWorld in that frame and resets this property to false. Default is false.
     */
    public boolean matrixWorldNeedsUpdate;

    /**
     * This is passed to the shader and used to calculate the position of the object.
     */
    public Matrix4 modelViewMatrix;

    /**
     * Optional name of the object (doesn't need to be unique). Default is an empty string.
     */
    public String name;

    /**
     * This is passed to the shader and used to calculate lighting for the object. It is the transpose of the inverse of the upper left 3x3 sub-matrix of this object's modelViewMatrix.
     * The reason for this special matrix is that simply using the modelViewMatrix could result in a non-unit length of normals (on scaling) or in a non-perpendicular direction (on non-uniform scaling).
     * On the other hand the translation part of the modelViewMatrix is not relevant for the calculation of normals. Thus a Matrix3 is sufficient.
     */
    public Matrix3 normalMatrix;

    /**
     * An optional callback that is executed immediately after the Object3D is rendered. This function is called with the following parameters: renderer, scene, camera, geometry, material, group.
     */
    public RenderCallback onAfterRender;

    /**
     * An optional callback that is executed immediately before the Object3D is rendered. This function is called with the following parameters: renderer, scene, camera, geometry, material, group.
     */
    public RenderCallback onBeforeRender;

    /**
     * Object's parent in the scene graph.
     */
    public Object3D parent;

    /**
     * A Vector3 representing the object's local position. Default is (0, 0, 0).
     */
    public Vector3 position;

    /**
     * Object's local rotation as a Quaternion.
     */
    public Quaternion quaternion;

    /**
     * Whether the material receives shadows. Default is false.
     */
    public boolean receiveShadow;

    /**
     * This value allows the default rendering order of scene graph objects to be overridden although
     * opaque and transparent objects remain sorted independently. Sorting is from lowest to highest renderOrder.
     * Default value is 0.
     */
    public Number renderOrder;

    /**
     * Object's local rotation (see Euler angles), in radians.
     */
    public Euler rotation;

    /**
     * The object's local # .scale . Default is Vector3( 1, 1, 1 ).
     */
    public Vector3 scale;

    /**
     * This is used by the lookAt method, for example, to determine the orientation of the result.
     * Default is Object3D.DefaultUp - that is, ( 0, 1, 0 ).
     */
    public Vector3 up;

    /**
     * An object that can be used to store custom data about the Object3D. It should not hold references
     * to functions as these will not be cloned.
     */
    public Object userData;

    /**
     * UUID of this object instance. This gets automatically assigned, so this shouldn't be edited.
     */
    public String uuid;

    /**
     * Object gets rendered if true. Default is true.
     */
    public boolean visible;

    /**
     * The default up direction for objects, also used as the default position for DirectionalLight, HemisphereLight and Spotlight (which creates lights shining from the top down).
     * Set to ( 0, 1, 0 ) by default.
     */
    public static Vector3 DefaultUp;

    /**
     * The default setting for matrixAutoUpdate for newly created Object3Ds.
     */
    public static Vector3 DefaultMatrixAutoUpdate;

    @JsConstructor
    public Object3D() {

    }

    /**
     * Adds object as child of this object. An arbitrary number of objects may be added.
     *
     * @param objects
     */
    public native void add(Object3D... objects);

    /**
     * Applies the matrix transform to the object and updates the object's position, rotation and scale.
     *
     * @param matrix
     */
    public native void applyMatrix(Matrix4 matrix);

    /**
     * Applies the rotation represented by the quaternion to the object.
     *
     * @param quaternion
     */
    public native void applyQuaternion(Quaternion quaternion);

    /**
     * recursive -- if true, descendants of the object are also cloned. Default is true.
     * Returns a clone of this object and optionally all descendants.
     *
     * @param recursive
     * @return Object3D
     */
    public native Object3D clone(boolean recursive);

    /**
     * recursive -- if true, descendants of the object are also copied. Default is true.
     * Copy the given object into this object.
     *
     * @param object3D
     * @param recursive
     * @return
     */
    public native Object3D copy(Object3D object3D, boolean recursive);

    /**
     * id -- Unique number of the object instance
     * <p>
     * Searches through the object's children and returns the first with a matching id.
     * Note that ids are assigned in chronological order: 1, 2, 3, ..., incrementing by one for each new object.
     *
     * @param id
     * @return Object3D
     */
    public native Object3D getObjectById(int id);

    /**
     * name -- String to match to the children's Object3D.name property.
     * Searches through the object's children and returns the first with a matching name.
     * Note that for most objects the # .name is an empty string by default. You will have to set it manually to make use of this method.
     *
     * @param name
     * @return Object3D
     */
    public native Object3D getObjectByName(String name);

    /**
     * name -- the property name to search for.
     * value -- value of the given property.
     * Searches through the object's children and returns the first with a property that matches the value given.
     *
     * @param name
     * @param value
     * @return Object3D
     */
    public native Object3D getObjectByProperty(String name, float value);

    /**
     * Returns a vector representing the position of the object in world space.
     *
     * @return
     */
    public native Vector3 getWorldPosition();

    /**
     * optionalTarget — target to set the result. Otherwise, a new Vector3 is instantiated.
     * Returns a vector representing the position of the object in world space.
     *
     * @param optionalTarget
     * @return
     */
    public native Vector3 getWorldPosition(Vector3 optionalTarget);

    /**
     * Returns a quaternion representing the rotation of the object in world space.
     *
     * @return
     */
    public native Quaternion getWorldQuaternion();

    /**
     * optionalTarget — (optional) if specified, the result will be copied into this Quaternion, otherwise a new Quaternion will be created.
     * Returns a quaternion representing the rotation of the object in world space.
     *
     * @param optionalTarget
     * @return
     */
    public native Quaternion getWorldQuaternion(Quaternion optionalTarget);

    /**
     * Returns the euler angles representing the rotation of the object in world space.
     *
     * @return Euler
     */
    public native Euler getWorldRotation();

    /**
     * optionalTarget — (optional) if specified, the result will be copied into this Euler, otherwise a new Euler will be created.
     * Returns the euler angles representing the rotation of the object in world space.
     *
     * @param optionalTarget
     * @return Euler
     */
    public native Euler getWorldRotation(Euler optionalTarget);

    /**
     * Returns a vector representing the direction of object's positive z-axis in world space.
     *
     * @return Vector3
     */
    public native Vector3 getWorldDirection();

    /**
     * optionalTarget — (optional) if specified, the result will be copied into this Vector3, otherwise a new Vector3 will be created.
     * Returns a vector representing the direction of object's positive z-axis in world space.
     *
     * @param optionalTarget
     * @return Vector3
     */
    public native Vector3 getWorldDirection(Vector3 optionalTarget);

    /**
     * vector - A vector representing a position in local (object) space.
     * Converts the vector from local space to world space.
     * .lookAt ( vector )
     * .lookAt ( x, y, z )
     * vector - A vector representing a position in world space.
     * <p>
     * Optionally, the x, y and z components of the world space position.
     * <p>
     * Rotates the object to face a point in world space.
     * <p>
     * This method does not support objects with rotated and/or translated parent(s).
     *
     * @param vector
     * @return
     */
    public native Vector3 localToWorld(Vector3 vector);

    /**
     * Rotates the object to face a point in world space.
     * <p>
     * This method does not support objects with rotated and/or translated parent(s).
     *
     * @param vector - A vector representing a position in world space.
     */
    public native void lookAt(Vector3 vector);

    /**
     * Rotates the object to face a point in world space.
     * <p>
     * This method does not support objects with rotated and/or translated parent(s).
     *
     * @param x, y and z components of the world space position.
     */
    public native void lookAt(float x, float y, float z);


    /**
     * Abstract (empty) method to get intersections between a casted ray and this object. Subclasses such as Mesh, Line, and Points implement this method in order to use raycasting.
     *
     * @param raycaster
     * @param intersects
     * @return
     */
    public native void raycast(Raycaster raycaster, Object intersects); //TODO

    /**
     * Removes object as child of this object. An arbitrary number of objects may be removed.
     *
     * @param objects
     */
    public native void remove(Object3D... objects);

    /**
     * axis -- A normalized vector in object space.
     * angle -- The angle in radians.
     * Rotate an object along an axis in object space. The axis is assumed to be normalized.
     *
     * @param axis
     * @param angle
     * @return Object3D
     */
    public native Object3D rotateOnAxis(Vector3 axis, float angle);

    /**
     * Rotate an object along an axis in world space. The axis is assumed to be normalized. Method Assumes no rotated parent.
     *
     * @param axis  -- A normalized vector in object space.
     * @param angle -- The angle in radians.
     * @return Object3D
     */
    public native Object3D rotateOnWorldAxis(Vector3 axis, float angle);

    /**
     * Rotates the object around x axis in local space.
     *
     * @param rad - the angle to rotate in radians.
     */
    public native void rotateX(float rad);

    /**
     * rad - the angle to rotate in radians.
     * Rotates the object around y axis in local space.
     *
     * @param rad
     */
    public native void rotateY(float rad);

    /**
     * rad - the angle to rotate in radians.
     * Rotates the object around z axis in local space.
     *
     * @param rad
     */
    public native void rotateZ(float rad);

    /**
     * axis -- A normalized vector in object space.
     * angle -- angle in radians
     * Calls setFromAxisAngle( axis, angle ) on the .quaternion.
     *
     * @param axis
     * @param angle
     */
    public native void setRotationFromAxisAngle(Vector3 axis, float angle);

    /**
     * euler -- Euler angle specifying rotation amount.
     * Calls setRotationFromEuler( euler) on the .quaternion.
     *
     * @param euler
     */
    public native void setRotationFromEuler(Euler euler);

    /**
     * Calls setFromRotationMatrix( m) on the .quaternion.
     * Note that this assumes that the upper 3x3 of m is a pure rotation matrix (i.e, unscaled).
     *
     * @param matrix -- rotate the quaternion by the rotation component of the matrix.
     */
    public native void setRotationFromMatrix(Matrix4 matrix);

    /**
     * Copy the given quaternion into .quaternion.
     *
     * @param quaternion -- normalized Quaternion.
     */
    public native void setRotationFromQuaternion(Quaternion quaternion);

    /**
     * Convert the Object3D to three.js JSON format.
     *
     * @param meta
     * @return
     */
    public native Object toJSON(Object meta);

    /**
     * Translate an object by distance along an axis in object space. The axis is assumed to be normalized.
     *
     * @param axis     -- A normalized vector in object space.
     * @param distance -- The distance to translate.
     * @return
     */
    public native Object3D translateOnAxis(Vector3 axis, float distance);

    /**
     * Translates object along x axis by distance units.
     *
     * @param distance
     */
    public native void translateX(float distance);

    /**
     * Translates object along y axis by distance units.
     *
     * @param distance
     */
    public native void translateY(float distance);

    /**
     * Translates object along Z axis by distance units.
     *
     * @param distance
     */
    public native void translateZ(float distance);

    /**
     * callback - A function with as first argument an object3D object.
     * Executes the callback on this object and all descendants.
     *
     * @param traverseCallback
     */
    public native void traverse(TraverseCallback traverseCallback);

    /**
     * callback - A function with as first argument an object3D object.
     * Like traverse, but the callback will only be executed for visible objects. Descendants of invisible objects are not traversed.
     *
     * @param traverseCallback
     */
    public native void traverseVisible(TraverseCallback traverseCallback);

    /**
     * callback - A function with as first argument an object3D object.
     * Executes the callback on all ancestors.
     *
     * @param traverseCallback
     */
    public native void traverseAncestors(TraverseCallback traverseCallback);

    /**
     * Update the local transform.
     */
    public native void updateMatrix();

    /**
     * Update the global transform of the object and its children.
     *
     * @param force
     */
    public native void updateMatrix(boolean force);

    /**
     * vector - A world vector.
     * Updates the vector from world space to local space.
     *
     * @param vector3
     * @return
     */
    public native Vector3 worldToLocal(Vector3 vector3);

}
