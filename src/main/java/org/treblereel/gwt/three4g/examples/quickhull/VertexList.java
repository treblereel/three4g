package org.treblereel.gwt.three4g.examples.quickhull;

import jsinterop.annotations.JsType;

/**
 * A doubly linked list of vertices.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class VertexList {

    /**
     * Reference to the first vertex of the linked list. Default is null.
     */
    public VertexNode head;

    /**
     * Reference to the last vertex of the linked list. Default is null.
     */
    public VertexNode tail;

    public VertexList() {

    }

    /**
     * Returns the head reference.
     *
     * @return instance of VertexNode
     */
    public native VertexNode first();

    /**
     * Returns the tail reference.
     *
     * @return instance of VertexNode
     */
    public native VertexNode last();

    /**
     * Clears the linked list.
     *
     * @return instance of VertexList
     */
    public native VertexList clear();

    /**
     * Inserts a vertex before a target vertex.
     *
     * @param target - The target vertex. It's assumed that this vertex belongs to the linked list.
     * @param vertex - The vertex to insert.
     * @return instance of VertexList
     */
    public native VertexList insertBefore(VertexNode target, VertexNode vertex);

    /**
     * Inserts a vertex after a target vertex.
     *
     * @param target - The target vertex. It's assumed that this vertex belongs to the linked list.
     * @param vertex - The vertex to insert.
     * @return instance of VertexList
     */
    public native VertexList insertAfter(VertexNode target, VertexNode vertex);

    /**
     * Appends a vertex to the end of the linked list.
     *
     * @param vertex - The vertex to append.
     * @return instance of VertexList
     */
    public native VertexList append(VertexNode vertex);

    /**
     * Appends a chain of vertices where the given vertex is the head.
     *
     * @param vertex - The head vertex of a chain of vertices.
     * @return instance of VertexList
     */
    public native VertexList appendChain(VertexNode vertex);

    /**
     * Removes a vertex from the linked list.
     *
     * @param vertex - The vertex to remove.
     * @return instance of VertexList
     */
    public native VertexList remove(VertexNode vertex);

    /**
     * Removes a sublist of vertices from the linked list.
     *
     * @param a - The head of the sublist.
     * @param b - The tail of the sublist.
     * @return instance of VertexList
     */
    public native VertexList removeSubList(VertexNode a, VertexNode b);

    /**
     * @return Returns true if the linked list is empty.
     */
    public native boolean isEmpty();
}
