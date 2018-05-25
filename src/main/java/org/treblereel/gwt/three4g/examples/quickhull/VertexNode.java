package org.treblereel.gwt.three4g.examples.quickhull;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * A vertex as a double linked list node.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class VertexNode {

    /**
     * A point (x, y, z) in 3D space. Default is undefined.
     */
    public Vector3 point;

    /**
     * Reference to the previous vertex in the double linked list. Default is null.
     */
    public VertexNode prev;

    /**
     * Reference to the next vertex in the double linked list. Default is null.
     */
    public VertexNode next;

    /**
     * Reference to the face that is able to see this vertex. Default is undefined.
     */
    public Face face;

    /**
     * @param point - Vector3 A point (x, y, z) in 3D space.
     */
    public VertexNode(Vector3 point) {

    }
}
