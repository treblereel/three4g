package org.treblereel.gwt.three4g.examples.quickhull;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Represents a section bounded by a specific amount of half-edges. The current implmentation assumes that a face always consist of three edges.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Face {

    /**
     * The normal vector of the face. Default is a Vector3 at (0, 0, 0).
     */
    public Vector3 normal;

    /**
     * The midpoint or centroid of the face. Default is a Vector3 at (0, 0, 0).
     */
    public Vector3 midpoint;

    /**
     * The area of the face. Default is 0.
     */
    public float area;

    /**
     * Signed distance from face to the origin. Default is 0.
     */
    public float constant;

    /**
     * Reference to a vertex in a vertex list this face can see. Default is null.
     */
    public VertexNode outside;

    /**
     * Marks if a face is visible or deleted. Default is 'Visible'.
     */
    public int mark;

    /**
     * Reference to the base edge of a face. To retrieve all edges, you can use the 'next' reference of the current edge. Default is null.
     */
    public HalfEdge edge;


    public Face() {

    }

    /**
     * Creates a face.
     *
     * @param a - First vertex of the face.
     * @param b - Second vertex of the face.
     * @param c - Third vertex of the face.
     * @return instance of Face
     */
    public native Face create(VertexNode a, VertexNode b, VertexNode c);

    /**
     * @param i - The index of the edge.
     * @return Returns an edge by the given index.
     */
    public native HalfEdge getEdge(int i);

    /**
     * Computes all properties of the face.
     *
     * @return instance of Face
     */
    public native Face compute();

    /**
     * Returns the signed distance from a given point to the plane representation of this face.
     *
     * @param point - Any point in 3D space.
     * @return the distance
     */
    public native float distanceToPoint(Vector3 point);


}
