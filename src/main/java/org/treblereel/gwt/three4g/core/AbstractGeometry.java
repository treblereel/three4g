package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * parent for Geometry and BufferGeometry
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true)
public class AbstractGeometry<T> extends EventDispatcher {

    /**
     * Optional name for this bufferGeometry instance. Default is an empty string.
     */
    public String name;

    /**
     * OUUID of this object instance. This gets automatically assigned and shouldn't be edited.
     */
    public String uuid;

    /**
     * Unique number for this bufferGeometry instance.
     *
     * @return
     */
    @JsProperty
    public native int getId();

    @JsProperty
    public native int getName();

    @JsProperty
    public native String getUuid();

    /**
     * Bakes matrix transform directly into vertex coordinates.
     *
     * @param matrix
     */
    public native void applyMatrix(Matrix4 matrix);

    /**
     * Center the geometry based on the bounding box.
     */
    public native void center();

    /**
     * Creates a new clone of the BufferGeometry.
     * <p>
     * This method copies only vertices, faces and uvs. It does not copy any other properties of the geometry.
     *
     * @return Geometry
     */
    public native T clone();

    /**
     * Copies vertices, faces and uvs into this geometry. It does not copy any other properties of the geometry.
     */
    public native T copy(T geometry);

    /**
     * Computes bounding box of the geometry, updating Geometry.boundingBox attribute.
     */
    public native void computeBoundingBox();

    /**
     * Computes bounding sphere of the geometry, updating Geometry.boundingSphere attribute.
     * Neither bounding boxes or bounding spheres are computed by default. They need to be explicitly computed, otherwise
     * they are null.
     */
    public native void computeBoundingSphere();

    /**
     * Computes vertex normals by averaging face normals.
     */
    public native void computeVertexNormals();

    /**
     * Removes The object from memory.
     * Don't forget to call this method when you remove a geometry because it can cause memory leaks.
     */
    public native void dispose();

    /**
     * Rotates the geometry to face a point in space. This is typically done as a one time operation, and not during a loop.
     * Use Object3D.lookAt for typical real-time mesh usage.
     *
     * @param vector - A world vector to look at.
     * @return
     */
    public native T lookAt(Vector3 vector);

    /**
     * Rotate the geometry about the X axis. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.rotation for typical real-time mesh rotation.
     *
     * @param radians
     */
    public native T rotateX(float radians);

    /**
     * Rotate the geometry about the Y axis. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.rotation for typical real-time mesh rotation.
     *
     * @param radians
     */
    public native T rotateY(float radians);

    /**
     * Rotate the geometry about the Z axis. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.rotation for typical real-time mesh rotation.
     *
     * @param radians
     */
    public native T rotateZ(float radians);

    /**
     * Scale the geometry data. This is typically done as a one time operation, and not during a loop. Use Object3D.scale
     * for typical real-time mesh scaling.
     * @param x
     * @param y
     * @param z
     * @return
     */
    public native T scale(float x, float y, float z);

    /**
     * Sets the vertices for this Geometry from an array of points.
     *
     * @param points
     */
    public native T setFromPoints(Object[] points); //TODO chenge to proper type

    /**
     * Convert the geometry to JSON format.
     *
     * @return String
     */
    public native String toJSON();

    /**
     * Translate the geometry. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.position for typical real-time mesh translation.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public native T translate(float x, float y, float z);
}
