package org.treblereel.gwt.three4g.core;

import elemental2.core.JsArray;
import elemental2.core.TypedArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Vector4;

/**
 * This class stores data for an attribute (such as vertex positions, face indices, normals, colors, UVs, and any custom
 * attributes ) associated with a BufferGeometry, which allows for more efficient passing of data to the GPU. See that page
 * for details and a usage example.
 * <p>
 * Data is stored as vectors of any length (defined by itemSize), and in general in the methods outlined below if passing
 * in an index, this is automatically multiplied by the vector length.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BufferAttribute {

    /**
     * The array holding data stored in the buffer.
     */
    public TypedArray array;

    /**
     * Stores the array's length divided by the itemSize.
     * If the buffer is storing a 3-component vector (such as a position, normal, or color), then this will count the number of such vectors stored.
     */
    public int count;

    /**
     * Whether the buffer is dynamic or not. Default is false.
     * If false, the GPU is informed that contents of the buffer are likely to be used often and not change often. This corresponds to the gl.STATIC_DRAW flag.
     * if true, the GPU is informed that contents of the buffer are likely to be used often and change often. This corresponds to the gl.DYNAMIC_DRAW flag.
     */
    public boolean dynamic;

    /**
     * Used to check whether this or derived classes are BufferAttributes. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isBufferAttribute;

    /**
     * The length of vectors that are being stored in the array.
     */
    public int itemSize;

    /**
     * Optional name for this attribute instance. Default is an empty string.
     */
    public String name;

    /**
     * Flag to indicate that this attribute has changed and should be re-sent to the GPU. Set this to true when you modify the value of the array.
     * <p>
     * Setting this to true also increments the version.
     */
    public boolean needsUpdate;


    /**
     * Indicates how the underlying data in the buffer maps to the values in the GLSL shader code. See the constructor above for details.
     */
    public boolean normalized;

    /**
     * A callback function that is executed after the Renderer has transfered the attribute array data to the GPU.
     */
    public OnUploadCallback onUploadCallback;

    /**
     * Object containing:
     * offset: Default is 0. Position at whcih to start update.
     * count: Default is -1, which means don't use update ranges.
     * <p>
     * This can be used to only update some components of stored vectors (for example, just the component related to color).
     */
    public UpdateRange updateRange;

    /**
     * A version number, incremented every time the needsUpdate property is set to true.
     */
    public int version;

    BufferAttribute() {

    }

    /**
     * @param array    -- Must be a TypedArray. Used to instantiate the buffer.
     *                 This array should have
     *                 itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                 attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     */
    @JsConstructor
    public BufferAttribute(TypedArray array, int itemSize) {

    }

    /**
     * @param array      -- Must be a TypedArray. Used to instantiate the buffer.
     *                   This array should have
     *                   itemSize * numVertices elements, where numVertices is the number of vertices in the associated BufferGeometry.
     * @param itemSize   -- the number of values of the array that should be associated with a particular vertex. For instance, if this
     *                   attribute is storing a 3-component vector (such as a position, normal, or color), then itemSize should be 3.
     * @param normalized -- (optional) Indicates how the underlying data in the buffer maps to the values in the GLSL code.
     *                   For instance, if array is an instance of UInt16Array, and normalized is true, the values 0 - +65535
     *                   in the array data will be mapped to 0.0f - +1.0f in the GLSL attribute. An Int16Array (signed)
     *                   would map from -32767 - +32767 to -1.0f - +1.0f. If normalized is false, the values will be converted
     *                   to floats which contain the exact value, i.e. 32767 becomes 32767.0f.
     */
    @JsConstructor
    public BufferAttribute(TypedArray array, int itemSize, boolean normalized) {

    }

    /**
     * Return a copy of this bufferAttribute.
     *
     * @return
     */
    public native BufferAttribute clone();

    /**
     * Copy the array given here (which can be a normal array or TypedArray) into array.
     * <p>
     * See TypedArray.set for notes on requirements if copying a TypedArray.
     *
     * @param array
     * @return
     */
    public native BufferAttribute copyArray(TypedArray array);

    /**
     * Copy the array given here (which can be a normal array or TypedArray) into array.
     *
     * @param array
     * @return
     */
    public native BufferAttribute copyArray(JsArray array);

    /**
     * Copy a vector from bufferAttribute[index2] to array[index1].
     *
     * @param index1
     * @param bufferAttribute
     * @param index2
     */
    public native void copyAt(int index1, BufferAttribute bufferAttribute, int index2);

    /**
     * Copy an array representing RGB color values into array.
     *
     * @param colors
     */
    public native BufferAttribute copyColorsArray(Color[] colors);

    /**
     * Copy an array representing Vector2s into array.
     *
     * @param vectors
     * @return
     */
    public native BufferAttribute copyVector2sArray(Vector2[] vectors);

    /**
     * Copy an array representing Vector2s into array.
     *
     * @param vectors
     * @return
     */
    public native BufferAttribute copyVector3sArray(Vector3[] vectors);

    /**
     * Copy an array representing Vector4s into array.
     *
     * @param vectors
     * @return
     */
    public native BufferAttribute copyVector4sArray(Vector4[] vectors);

    /**
     * Returns the x component of the vector at the given index.
     *
     * @param index
     * @return
     */
    public native Object getX(int index);

    /**
     * Returns the y component of the vector at the given index.
     *
     * @param index
     * @return
     */
    public native Object getY(int index);

    /**
     * Returns the z component of the vector at the given index.
     *
     * @param index
     * @return
     */
    public native Object getZ(int index);

    /**
     * Sets the value of the onUploadCallback property.
     * <p>
     * In the WebGL / Buffergeometry this is used to free memory after the buffer has been	transfered to the GPU.
     *
     * @param callback
     */
    public native void onUpload(OnUploadCallback callback);

    /**
     * @param value -- TypedArray from which to copy values.
     *              <p>
     *              In particular, see that page for requirements on value being a TypedArray.
     * @return
     */
    public native BufferAttribute set(TypedArray value);

    /**
     * @param value  -- TypedArray from which to copy values.
     * @param offset -- index of the array at which to start copying.
     *               Calls	TypedArray.set( value, offset ) on the array.
     *               <p>
     *               In particular, see that page for requirements on value being a TypedArray.
     * @return
     */
    public native BufferAttribute set(TypedArray value, int offset);

    /**
     * @param value -- an Array or JsArray from which to copy values.
     *              <p>
     *              In particular, see that page for requirements on value being a TypedArray.
     * @return
     */
    public native BufferAttribute set(JsArray value);

    /**
     * @param value  -- JsArray from which to copy values.
     * @param offset -- index of the array at which to start copying.
     *               Calls TypedArray.set( value, offset ) on the array.
     *               <p>
     *               In particular, see that page for requirements on value being a TypedArray.
     * @return
     */
    public native BufferAttribute set(JsArray value, int offset);


    /**
     * array to the TypedArray passed in here.
     * <p>
     * After setting the array, needsUpdate should be set to true.
     *
     * @param array
     * @return
     */
    public native BufferAttribute setArray(TypedArray array);

    /**
     * Set dynamic to value.
     *
     * @param value
     * @return
     */
    public native BufferAttribute setDynamic(boolean value);

    /**
     * Sets the x component of the vector at the given index.
     *
     * @param x
     * @return
     */
    public native BufferAttribute setX(int index, Object x);

    /**
     * Sets the y component of the vector at the given index.
     *
     * @param y
     * @return
     */
    public native BufferAttribute setY(int index, Object y);

    /**
     * Sets the z component of the vector at the given index.
     *
     * @param z
     * @return
     */
    public native BufferAttribute setZ(int index, Object z);

    /**
     * Sets the w component of the vector at the given index.
     *
     * @param w
     * @return
     */
    public native BufferAttribute setW(int index, Object w);

    /**
     * Sets the x and y components of the vector at the given index.
     *
     * @param x
     * @param y
     * @return
     */
    public native BufferAttribute setXY(int index, Object x, Object y);

    /**
     * Sets the x, y and z components of the vector at the given index.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public native BufferAttribute setXYZ(int index, Object x, Object y, Object z);

    /**
     * Sets the x, y, z and w components of the vector at the given index.
     *
     * @param x
     * @param y
     * @param z
     * @param w
     * @return
     */
    public native BufferAttribute setXYZW(int index, Object x, Object y, Object z, Object w);
}
