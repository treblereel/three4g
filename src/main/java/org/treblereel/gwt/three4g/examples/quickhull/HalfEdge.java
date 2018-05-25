package org.treblereel.gwt.three4g.examples.quickhull;

import jsinterop.annotations.JsType;

/**
 * The basis for a half-edge data structure, also known as doubly connected edge list (DCEL).
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class HalfEdge {

    /**
     * Reference to the destination vertex. The origin vertex can be obtained by querying the destination of its twin, or of the previous half-edge. Default is undefined.
     */
    public VertexNode vertex;

    /**
     * Reference to the previous half-edge of the same face. Default is null.
     */
    public HalfEdge prev;

    /**
     * Reference to the next half-edge of the same face. Default is null.
     */
    public HalfEdge next;

    /**
     * Reference to the twin half-edge to reach the opposite face. Default is null.
     */
    public HalfEdge twin;

    /**
     * Each half-edge bounds a single face and thus has a reference to that face. Default is undefined.
     */
    public Face face;

    /**
     * @param vertex - VertexNode A reference to its destination vertex.
     * @param face   - Face A reference to its face.
     */
    public HalfEdge(VertexNode vertex, Face face) {

    }

    /**
     * Returns the destintation vertex.
     *
     * @return destintation vertex
     */
    public native VertexNode head();

    /**
     * Returns the origin vertex.
     *
     * @return origin vertex
     */
    public native VertexNode tail();

    /**
     * Returns the Euclidean length (straight-line length) of the edge.
     *
     * @return Euclidean length
     */
    public native float length();

    /**
     * Returns the square of the Euclidean length (straight-line length) of the edge.
     *
     * @return Euclidean length
     */
    public native float lengthSquared();

    /**
     * Sets the twin edge of this half-edge. It also ensures that the twin reference of the given half-edge is correctly set.
     *
     * @param edge - Any half-edge.
     * @return resulting HalfEdge
     */
    public native HalfEdge setTwin(HalfEdge edge);
}
