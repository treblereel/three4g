package org.treblereel.gwt.three4g.core;

import elemental2.core.JsObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Box3;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Sphere;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Points;

import java.util.HashMap;

/**
 * This class is an efficient alternative to Geometry, because it stores all data, including vertex positions, face indices,
 * normals, colors, UVs, and custom attributes within buffers; this reduces the cost of passing all this data to the GPU.
 * This also makes BufferGeometry harder to work with than Geometry; rather than accessing position data as Vector3 objects,
 * color data as Color objects, and so on, you have to access the raw data from the appropriate attribute buffer. This makes
 * BufferGeometry best-suited for static objects where you don't need to manipulate the geometry much after instantiating it.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/21/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BufferGeometry extends EventDispatcher {

    /**
     * This hashmap has as id the name of the attribute to be set and as value the buffer to set it to. Rather than accessing this property directly, use .addAttribute and .getAttribute to access attributes of this geometry.
     */
    public HashMap<String, JsObject> attributes; //TODO


    /**
     * Bounding box for the bufferGeometry, which can be calculated with .computeBoundingBox(). Default is null.
     */
    public Box3 boundingBox;

    /**
     * Bounding sphere for the bufferGeometry, which can be calculated with .computeBoundingSphere(). Default is null.
     */
    public Sphere boundingSphere;

    /**
     * Used to determine what part of the geometry should be rendered. This should not be set directly, instead use .setDrawRange.
     * Default is
     * { start: 0, count: Infinity }
     */
    public JsObject drawRange; //TODO

    /**
     * Split the geometry into groups, each of which will be rendered in a separate WebGL draw call. This allows an array of materials to be used with the bufferGeometry.
     * <p>
     * Each group is an object of the form:
     * { start: Integer, count: Integer, materialIndex: Integer } where start specifies the first element in this draw call – the first vertex for non-indexed geometry, otherwise the first triangle index. Count specifies how many vertices (or indices) are included, and materialIndex specifies the material array index to use.
     * <p>
     * Use .addGroup to add groups, rather than modifying this array directly.
     */
    public JsObject groups;

    /**
     * Allows for vertices to be re-used across multiple triangles; this is called using "indexed triangles" and works
     * much the same as it does in Geometry: each triangle is associated with the indices of three vertices. This attribute
     * therefore stores the index of each vertex for each triangular face. If this attribute is not set, the renderer assumes
     * that each three contiguous positions represent a single triangle. Default is null.
     */
    public BufferAttribute index;

    /**
     * Used to check whether this or derived classes are BufferGeometries. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isBufferGeometry;

    /**
     * Hashmap of BufferAttributes holding details of the geometry's morphTargets.
     */
    public HashMap<String, BufferAttribute> morphAttributes;

    /**
     * Optional name for this bufferGeometry instance. Default is an empty string.
     */
    public String name;

    /**
     * OUUID of this object instance. This gets automatically assigned and shouldn't be edited.
     */
    public String uuid;

    /**
     * This creates a new BufferGeometry. It also sets several properties to a default value.
     */
    @JsConstructor
    public BufferGeometry() {

    }

    /**
     * Unique number for this bufferGeometry instance.
     *
     * @return
     */
    @JsProperty
    public native int getId();


    /**
     * Adds an attribute to this geometry. Use this rather than the attributes property, because an internal hashmap of
     * attributes is maintained to speed up iterating over a
     *
     * @param name
     * @param attribute
     */
    public native void addAttribute(String name, BufferAttribute attribute);

    /**
     * Adds a group to this geometry; see the groups property for details.
     *
     * @param start
     * @param count
     * @param materialIndex
     */
    public native void addGroup(int start, int count, int materialIndex);

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
    public native BufferGeometry clone();

    /**
     * Copies vertices, faces and uvs into this geometry. It does not copy any other properties of the geometry.
     */
    public native BufferGeometry copy(BufferGeometry geometry);

    /**
     * Clears all groups
     */
    public native void clearGroups();

    /**
     * Computes bounding box of the geometry, updating [param:.boundingBox] attribute.
     * Bounding boxes aren't computed by default. They need to be explicitly computed, otherwise they are null.
     */
    public native void computeBoundingBox();

    /**
     * Computes bounding sphere of the geometry, updating .boundingSphere attribute.
     * Bounding spheres aren't computed by default. They need to be explicitly computed, otherwise they are null.
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
     * Convert a Geometry to a BufferGeometry.
     *
     * @param geometry
     * @return
     */
    public native BufferGeometry fromDirectGeometry(Geometry geometry);

    /**
     * Populates this BufferGeometry with data from a Geometry object.
     *
     * @param geometry
     * @return
     */
    public native BufferGeometry fromGeometry(Geometry geometry);

    /**
     * Returns the attribute with the specified name.
     *
     * @param name
     * @return
     */
    public native BufferAttribute getAttribute(String name);

    /**
     * Return the .index buffer
     *
     * @return
     */
    public native BufferAttribute getIndex();

    /**
     * vector - A world vector to look at.
     * <p>
     * Rotates the geometry to face a point in space. This is typically done as a one time operation, and not during a loop.
     * Use Object3D.lookAt for typical real-time mesh usage.
     *
     * @param vector
     * @return
     */
    public native BufferGeometry lookAt(Vector3 vector);

    /**
     * Merge in another BufferGeometry with an optional offset of where to start merging in.
     * @param bufferGeometry
     * @param offset
     */
    public native void merge(BufferGeometry  bufferGeometry, int offset);

    /**
     * Every normal vector in a geometry will have a magnitude of 1. This will correct lighting on the geometry surfaces.
     */
    public native void normalizeNormals();

    /**
     * Removes the attribute with the specified name.
     * @param name
     * @return
     */
    public native BufferAttribute removeAttribute(String name);

    /**
     * Rotate the geometry about the X axis. This is typically done as a one time operation, and not during a loop. Use
     * Object3D.rotation for typical real-time mesh rotation.
     * @param radians
     * @return
     */
    public native BufferGeometry rotateX(float radians);

    /**
     * Rotate the geometry about the Y axis. This is typically done as a one time operation, and not during a loop. Use
     * Object3D.rotation for typical real-time mesh rotation.
     * @param radians
     * @return
     */
    public native BufferGeometry rotateY(float radians);

    /**
     * Rotate the geometry about the Z axis. This is typically done as a one time operation, and not during a loop. Use
     * Object3D.rotation for typical real-time mesh rotation.
     * @param radians
     * @return
     */
    public native BufferGeometry rotateZ(float radians);

    /**
     * Scale the geometry data. This is typically done as a one time operation, and not during a loop. Use Object3D.scale for typical real-time mesh scaling.
     * @param x
     * @param y
     * @param z
     * @return
     */
    public native BufferGeometry scale(float x, float y, float z);

    /**
     * Set the .index buffer.
     * @param index
     */
    public native void setIndex(BufferAttribute index);

    /**
     * Set the .drawRange buffer. See that property for details.
     * @param start
     * @param count
     */
    public native void setDrawRange(int start, int count);

    /**
     * Sets the attributes for this BufferGeometry from an Object3D.
     * @param object
     * @return
     */
    public native BufferGeometry setFromObject(Object3D object);

    /**
     * Sets the attributes for this BufferGeometry from an array of points.
     * @param points
     * @return
     */
    public native BufferGeometry setFromPoints(Points points); //TODO ???

    /**
     * Returns a JSON object representation of the BufferGeometry.
     * @return
     */
    public native String toJSON();

    /**
     * Return a non-index version of an indexed BufferGeometry.
     * @return
     */
    public native BufferGeometry toNonIndexed();

    /**
     * Translate the geometry. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.position for typical real-time mesh translation.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public native BufferGeometry translate(float x, float y, float z);

    /**
     * Updates the attributes for this BufferGeometry from an Object3D.
     * @param object
     * @return
     */
    public native BufferGeometry updateFromObject(Object3D object);
}
