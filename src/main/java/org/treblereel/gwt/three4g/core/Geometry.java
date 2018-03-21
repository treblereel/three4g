package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Box3;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * Base class for all geometries (but not for BufferGeometries).
 * This can also be used directly for building custom geometries.
 * <p>
 * Geometries are easier to work with than BufferGeometries as they store attributes such as vertices, faces, colors and
 * so on directly (rather than in buffers), however they are generally slower.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Geometry extends EventDispatcher {

    /**
     * Bounding sphere for the Geometry, which can be calculated with .computeBoundingSphere(). Default is null.
     */
    public Box3 boundingBox;

    /**
     * Array of vertex colors, matching number and order of vertices.
     * <p>
     * This is used by Points and Line and any classes derived from those such as LineSegments and various helpers. Meshes use Face3.vertexColors instead of this.
     * <p>
     * To signal an update in this array, Geometry.colorsNeedUpdate needs to be set to true.
     */
    public Color[] colors;//TODO

    /**
     * Array of faces.
     * The array of faces describe how each vertex in the model is connected to form faces. Additionally it holds information about face and vertex normals and colors.
     * <p>
     * To signal an update in this array, Geometry.elementsNeedUpdate needs to be set to true.
     */
    public Face3[] faces;

    /**
     * Array of face UV layers, used for mapping textures onto the geometry.
     * Each UV layer is an array of UVs matching the order and number of vertices in faces.
     * <p>
     * To signal an update in this array, Geometry.uvsNeedUpdate needs to be set to true.
     */
    public Object[] faceVertexUvs;//TODO

    /**
     * Unique number for this geometry instance.
     */
    public int id;

    /**
     * Used to check whether this or derived classes are Geometries. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isGeometry;

    /**
     * An array containing distances between vertices for Line geometries. This is required for LineDashedMaterial to render correctly.
     */
    public Object[] lineDistances;//TODO

    /**
     * Array of morph targets. Each morph target is a Javascript object:
     * { name: "targetName", vertices: [ new THREE.Vector3(), ... ] } Morph vertices match number and order of primary vertices.
     */
    public Object[] morphTargets;//TODO

    /**
     * Array of morph normals. Morph normals have similar structure as morph targets, each normal set is a Javascript object:
     * morphNormal = { name: "NormalName", normals: [ new THREE.Vector3(), ... ] } See the WebGL / morphNormals example.
     */
    public Object[] morphNormals;//TODO

    /**
     * Optional name for this geometry. Default is an empty string.
     */
    public String name;

    /**
     * When working with a SkinnedMesh, each vertex can have up to 4 bones affecting it. The skinWeights property is an
     * array of weight values that correspond to the order of the vertices in the geometry. So for instance, the first
     * skinWeight would correspond to the first vertex in the geometry. Since each vertex can be modified by 4 bones,
     * a Vector4 is used to represent the skin weights for that vertex.
     * The values of the vector should typically be between 0 and 1. For instance when set to 0 the bone transformation
     * will have no affect. When set to 0.5 it will have 50% affect. When set to 100%, it will have 100% affect. If there
     * is only 1 bone associated with the vertex then you only need to worry about the first component of the vector,
     * the rest can be ignored and set to 0.
     */
    public Object[] skinWeights;//TODO

    /**
     * Just like the skinWeights property, the skinIndices' values correspond to the geometry's vertices. Each vertex can have up to 4 bones associated with it. So if you look at the first vertex, and the first skinIndex, this will tell you the bones associated with that vertex. For example the first vertex could have a value of ( 10.05, 30.10, 12.12 ). Then the first skin index could have the value of ( 10, 2, 0, 0 ). The first skin weight could have the value of ( 0.8, 0.2, 0, 0 ). In affect this would take the first vertex, and then the bone mesh.bones[10] and apply it 80% of the way. Then it would take the bone skeleton.bones[2] and apply it 20% of the way. The next two values have a weight of 0, so they would have no affect.
     * In code another example could look like this:
     * // e.g.
     * geometry.skinIndices[15] = new Vector4(   0,   5,   9, 10 );
     * geometry.skinWeights[15] = new Vector4( 0.2, 0.5, 0.3,  0 );
     * <p>
     * // corresponds with the following vertex
     * geometry.vertices[15];
     * <p>
     * // these bones will be used like so:
     * skeleton.bones[0]; // weight of 0.2
     * skeleton.bones[5]; // weight of 0.5
     * skeleton.bones[9]; // weight of 0.3
     * skeleton.bones[10]; // weight of 0
     */
    public Object[] skinIndices;//TODO

    /**
     * UUID of this object instance. This gets automatically assigned and shouldn't be edited.
     */
    public String uuid;

    /**
     * Array of vertices.
     * The array of vertices holds the position of every vertex in the model.
     * To signal an update in this array, .verticesNeedUpdate needs to be set to true.
     */
    public Vector3[] vertices;

    /**
     * Set to true if the vertices array has been updated.
     */
    public boolean verticesNeedUpdate;

    /**
     * Set to true if the faces array has been updated.
     */
    public boolean elementsNeedUpdate;

    /**
     * Set to true if the uvs array has been updated.
     */
    public boolean uvsNeedUpdate;

    /**
     * Set to true if the normals array has been updated.
     */
    public boolean normalsNeedUpdate;

    /**
     * Set to true if the colors array or a face3 color has been updated.
     */
    public boolean colorsNeedUpdate;

    /**
     * Set to true if a face3 materialIndex has been updated.
     */
    public boolean groupsNeedUpdate;

    /**
     * Set to true if the linedistances array has been updated.
     */
    public boolean lineDistancesNeedUpdate;


    @JsConstructor
    public Geometry() {

    }

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
     * Creates a new clone of the Geometry.
     * <p>
     * This method copies only vertices, faces and uvs. It does not copy any other properties of the geometry.
     *
     * @return Geometry
     */
    public native Geometry clone();

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
     * Computes face normals.
     */
    public native void computeFaceNormals();

    /**
     * Computes flat vertex normals. Sets the vertex normal of each vertex of each face to be the same as the face's normal.
     */
    public native void computeFlatVertexNormals();

    /**
     * Computes .morphNormals.
     */
    public native void computeMorphNormals();

    /**
     * areaWeighted - If true the contribution of each face normal to the vertex normal is weighted by the area of the face. Default is true.
     * <p>
     * Computes vertex normals by averaging face normals.
     */
    public native void computeVertexNormals(boolean areaWeighted);

    /**
     * Copies vertices, faces and uvs into this geometry. It does not copy any other properties of the geometry.
     */
    public native Geometry copy(Geometry geometry);

    /**
     * Removes The object from memory.
     * Don't forget to call this method when you remove a geometry because it can cause memory leaks.
     */
    public native void dispose();

    /**
     * Convert a BufferGeometry to a Geometry.
     *
     * @param geometry
     * @return
     */
    public native Geometry fromBufferGeometry(BufferGeometry geometry);

    /**
     * vector - A world vector to look at.
     * <p>
     * Rotates the geometry to face point in space. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.lookAt for typical real-time mesh usage.
     *
     * @param vector
     * @return
     */
    public native Geometry lookAt(Vector3 vector);

    /**
     * Merge two geometries or geometry and geometry from object (using object's transform)
     *
     * @param geometry
     * @param matrix
     * @param materialIndexOffset
     */
    public native void merge(Geometry geometry, Matrix4 matrix, int materialIndexOffset);

    /**
     * Merge the mesh's geometry with this, also applying the mesh's transform.
     *
     * @param mesh
     */
    public native void mergeMesh(Mesh mesh);

    /**
     * Checks for duplicate vertices using hashmap.
     * Duplicated vertices are removed and faces' vertices are updated.
     */
    public native void mergeVertices();

    /**
     * Normalize the geometry.
     * Make the geometry centered and have a bounding sphere of radius 1.0.
     */
    public native void normalize();

    /**
     * Rotate the geometry about the X axis. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.rotation for typical real-time mesh rotation.
     *
     * @param radians
     */
    public native Geometry rotateX(float radians);

    /**
     * Rotate the geometry about the Y axis. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.rotation for typical real-time mesh rotation.
     *
     * @param radians
     */
    public native Geometry rotateY(float radians);

    /**
     * Rotate the geometry about the Z axis. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.rotation for typical real-time mesh rotation.
     *
     * @param radians
     */
    public native Geometry rotateZ(float radians);

    /**
     * Sets the vertices for this Geometry from an array of points.
     *
     * @param points
     */
    public native Geometry setFromPoints(Object[] points);

    /**
     * Sorts the faces array according to material index. For complex geometries with several materials, this can result
     * in reduced draw calls and improved performance.
     */
    public native void sortFacesByMaterialIndex();

    /**
     * Scale the geometry data. This is typically done as a one time operation but not during the render loop.
     * Use Object3D.scale for typical real-time mesh scaling.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public native Geometry scale(float x, float y, float z);

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
    public native Geometry translate(float x, float y, float z);


}
