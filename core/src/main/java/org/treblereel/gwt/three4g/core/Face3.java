package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Triangular face used in Geometry. These are created automatically for all standard geometry types, however if you are building a custom geometry you will have to create them manually.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/9/18.
 */
@JsType(isNative = true, name = "THREE.Face3", namespace = JsPackage.GLOBAL)
public class Face3 {

    /**
     * Vertex A index.
     */
    public int a;

    /**
     * Vertex B index.
     */
    public int b;

    /**
     * Vertex C index.
     */
    public int c;


    /**
     * Face normal - vector showing the direction of the Face3. If calculated automatically (using Geometry.computeFaceNormals), this is the normalized cross product of two edges of the triangle. Default is (0, 0, 0).
     */
    public Vector3 normal;

    /**
     * Face color - for this to be used a material's vertexColors property must be set to THREE.FaceColors.
     */
    public Color color;

    /**
     * Array of 3 vertex normals.
     */
    public Vector3[] vertexNormals;

    /**
     * Array of 3 vertex colors - for these to be used a material's vertexColors property must be set to THREE.VertexColors.
     */
    public Color[] vertexColors;

    /**
     * Material index (points to an index in the associated array of materials). Default is 0.
     */
    public int materialIndex;

    /**
     * @param a — Vertex A index.
     * @param b — Vertex B index.
     * @param c — Vertex C index.
     */
    @JsConstructor
    public Face3(int a, int b, int c) {

    }

    /**
     * @param a      — Vertex A index.
     * @param b      — Vertex B index.
     * @param c      — Vertex C index.
     * @param normal — Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
     */
    @JsConstructor
    public Face3(int a, int b, int c, Vector3 normal) {

    }

    /**
     * @param a      — Vertex A index.
     * @param b      — Vertex B index.
     * @param c      — Vertex C index.
     * @param normal — Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
     * @param color  —  Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
     */
    @JsConstructor
    public Face3(int a, int b, int c, Vector3 normal, Color color) {

    }

    /**
     * @param a             — Vertex A index.
     * @param b             — Vertex B index.
     * @param c             — Vertex C index.
     * @param normal        — Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
     * @param color         — Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
     * @param materialIndex — which index of an array of materials to associate with the face.
     */
    @JsConstructor
    public Face3(int a, int b, int c, Vector3 normal, Color color, int materialIndex) {

    }

    /**
     * Creates a clone of this instance.
     *
     * @return instance of Face3
     */
    public native Face3 clone();

    /**
     * Copies another Face3 object to this instance.
     *
     * @param source Face3
     * @return instance of Face3
     */
    public native Face3 copy(Face3 source);

}
