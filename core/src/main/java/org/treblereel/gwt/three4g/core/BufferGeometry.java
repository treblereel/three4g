package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;
import org.treblereel.gwt.three4g.math.Box3;
import org.treblereel.gwt.three4g.math.Sphere;
import org.treblereel.gwt.three4g.math.Vector3;

import java.util.HashMap;

/**
 * This class is an efficient alternative to Geometry, because it stores all data, including vertex positions, face indices,
 * normals, colors, UVs, and custom attributes within buffers; this reduces the cost of passing all this data to the GPU.
 * This also makes BufferGeometry harder to work with than Geometry; rather than accessing position data as Vector3 objects,
 * color data as Color objects, and so on, you have to access the raw data from the appropriate attribute buffer. This makes
 * BufferGeometry best-suited for static objects where you don't need to manipulate the geometry much after instantiating it.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/21/18.
 */
@JsType(isNative = true, name = "THREE.BufferGeometry", namespace = JsPackage.GLOBAL)
public class BufferGeometry<T extends BufferGeometry> extends AbstractGeometry<T> {

    @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
    public static class Attributes extends PropertyHolder {

        public BufferAttribute position;
        public BufferAttribute normal;
        public BufferAttribute color;
        public BufferAttribute uv;
        public BufferAttribute uv2;
        public BufferAttribute size;
        public BufferAttribute lineDistance;

        Attributes() {

        }

    }

    /**
     * This hashmap has as id the name of the attribute to be set and as value the buffer to set it to. Rather than accessing this property directly, use .addAttribute and .getAttribute to access attributes of this geometry.
     */
    public Attributes attributes;


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
    public DrawRange drawRange;

    /**
     * Split the geometry into groups, each of which will be rendered in a separate WebGL draw call. This allows an array of materials to be used with the bufferGeometry.
     * <p>
     * Each group is an object of the form:
     * { start: Integer, count: Integer, materialIndex: Integer } where start specifies the first element in this draw call – the first vertex for non-indexed geometry, otherwise the first triangle index. Count specifies how many vertices (or indices) are included, and materialIndex specifies the material array index to use.
     * <p>
     * Use .addGroup to add groups, rather than modifying this array directly.
     */
    public Groups groups;

    @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
    public static class Groups extends PropertyHolder {
        public int start, count, materialIndex;
    }


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
     * An object that can be used to store custom data about the BufferGeometry. It should not hold references to functions as these will not be cloned.
     */
    public PropertyHolder userData;

    /**
     * This creates a new BufferGeometry. It also sets several properties to a default value.
     */
    @JsConstructor
    public BufferGeometry() {

    }

    /**
     * Adds an attribute to this geometry. Use this rather than the attributes property, because an internal hashmap of
     * attributes is maintained to speed up iterating over a
     *
     * @param name      of the attribute
     * @param attribute instance of BufferAttribute
     */
    public native void addAttribute(String name, BufferAttribute attribute);

    /**
     * Adds a group to this geometry; see the groups property for details.
     *
     * @param start         as int value
     * @param count         as int value
     * @param materialIndex as int value
     */
    public native void addGroup(int start, int count, int materialIndex);

    /**
     * Clears all groups
     */
    public native void clearGroups();

    /**
     * Creates a new clone of the BufferGeometry.
     * <p>
     * This method copies only vertices, faces and uvs. It does not copy any other properties of the geometry.
     *
     * @return extends AbstractGeometry
     */
    public native T clone();

    /**
     * Convert a Geometry to a BufferGeometry.
     *
     * @param geometry instance of Geometry
     * @return instance of BufferGeometry
     */
    public native BufferGeometry fromDirectGeometry(Geometry geometry);

    /**
     * Populates this BufferGeometry with data from a Geometry object.
     *
     * @param geometry instance of Geometry
     * @return instance of BufferGeometry
     */
    public native BufferGeometry fromGeometry(Geometry geometry);

    /**
     * Returns the attribute with the specified name.
     *
     * @param name of attribute
     * @return instance of BufferGeometry
     */
    public native BufferAttribute getAttribute(String name);

    /**
     * Return the .index buffer
     *
     * @return instance of BufferGeometry
     */
    public native BufferAttribute getIndex();

    /**
     * Merge in another BufferGeometry with an optional offset of where to start merging in.
     *
     * @param bufferGeometry instance of BufferGeometry
     * @param offset         as int value
     */
    public native void merge(BufferGeometry bufferGeometry, int offset);

    /**
     * Every normal vector in a geometry will have a magnitude of 1. This will correct lighting on the geometry surfaces.
     */
    public native void normalizeNormals();

    /**
     * Removes the attribute with the specified name.
     *
     * @param name of the attribute
     * @return instance of BufferGeometry
     */
    public native BufferAttribute removeAttribute(String name);

    /**
     * Set the .index buffer.
     *
     * @param index instance of BufferGeometry
     */
    public native void setIndex(JsArrayLike index);

    /**
     * Set the .index buffer.
     *
     * @param index instance of BufferGeometry
     */
    public native void setIndex(BufferAttribute index);

    /**
     * Set the .drawRange buffer. See that property for details.
     *
     * @param start int value
     * @param count int value
     */
    public native void setDrawRange(int start, int count);

    /**
     * Sets the attributes for this BufferGeometry from an Object3D.
     *
     * @param object instance of Object3D
     * @return instance of BufferGeometry
     */
    public native T setFromObject(Object3D object);

    /**
     * Sets the vertices for this Geometry from an array of points.
     *
     * @param points array of points
     * @return extends AbstractGeometry
     */
    public native T setFromPoints(Vector3[] points);

    /**
     * Return a non-index version of an indexed BufferGeometry.
     *
     * @return instance of BufferGeometry
     */
    public native BufferGeometry toNonIndexed();

    /**
     * Updates the attributes for this BufferGeometry from an Object3D.
     *
     * @param object instance of Object3D
     * @return instance of BufferGeometry
     */
    public native BufferGeometry updateFromObject(Object3D object);
}
