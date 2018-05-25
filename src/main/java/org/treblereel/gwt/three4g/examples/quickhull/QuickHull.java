package org.treblereel.gwt.three4g.examples.quickhull;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * General information about the Quickhull algorithm: Dirk Gregorius. March 2014, Game Developers Conference: Implementing QuickHull.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class QuickHull {

    /**
     * The epsilon value that is used for internal comparative operations. The calculation of this value depends on the size of the geometry. Default is -1.
     */
    public float tolerance;

    /**
     * The generated faces of the convex hull. Default is an empty array.
     */
    public Face[] faces;

    /**
     * This array holds the faces that are generated within a single iteration. Default is an empty array.
     */
    public Face[] newFaces;

    /**
     * This vertex list holds all vertices that are assigned to a face. Default is an empty vertex list.
     */
    public VertexList assigned;

    /**
     * This vertex list holds all vertices that are not assigned to a face. Default is an empty vertex list.
     */
    public VertexList aunassigned;

    /**
     * The internal representation of the given geometry data (an array of vertices).
     */
    public VertexNode[] vertices;


    public QuickHull() {

    }

    /**
     * Computes to convex hull for the given array of points.
     *
     * @param points - Array of Vector3s that the resulting convex hull will contain.
     * @return instance of QuickHull
     */
    public native QuickHull setFromPoints(Vector3... points);


    /**
     * Computes the convex hull of an Object3D (including its children), accounting for the world transforms of both the object and its childrens.
     *
     * @param object - Object3D to compute the convex hull of.
     * @return instance of QuickHull
     */
    public native QuickHull setFromObject(Object3D object);

    /**
     * Makes this convex hull empty.
     *
     * @return instance of QuickHull
     */
    public native QuickHull makeEmpty();

    /**
     * Adds a vertex to the 'assigned' list of vertices and assigns it to the given face.
     *
     * @param vertex - The vetex to add.
     * @param face   - The target face.
     * @return instance of QuickHull
     */
    public native QuickHull addVertexToFace(VertexNode vertex, Face face);

    /**
     * Removes a vertex from the 'assigned' list of vertices and from the given face. It also makes sure that the link from 'face' to the first vertex it sees in 'assigned' is linked correctly after the removal.
     *
     * @param vertex - The vetex to remove.
     * @param face   - The target face.
     * @return instance of QuickHull
     */
    public native QuickHull removeVertexFromFace(VertexNode vertex, Face face);

    /**
     * Removes all the visible vertices that a given face is able to see which are stored in the 'assigned' vertext list.
     *
     * @param face - The given face.
     * @return instance of VertexNode
     */
    public native VertexNode removeAllVerticesFromFace(Face face);

    /**
     * If 'absorbingFace' doesn't exist, then all the removed vertices will be added to the 'unassigned' vertex list.
     * If 'absorbingFace' exists, then this method will assign all the vertices of 'face' that can see 'absorbingFace'.
     * If a vertex cannot see 'absorbingFace', it's added to the 'unassigned' vertex list.
     * <p>
     * Removes all the visible vertices that 'face' is able to see.
     *
     * @param face          - The given face.
     * @param absorbingFace - An optional face that tries to absorb the vertices of the first face.
     * @return instance of QuickHull
     */
    public native QuickHull deleteFaceVertices(Face face, Face absorbingFace);

    /**
     * Reassigns as many vertices as possible from the unassigned list to the new faces.
     *
     * @param newFaces - An array of new faces.
     * @return instance of QuickHull
     */
    public native QuickHull resolveUnassignedPoints(Face... newFaces);


    /**
     * Computes the extremes values (min/max vectors) which will be used to compute the inital hull.
     *
     * @return value holder
     */
    public native Extremes computeExtremes();

    /**
     * Computes the initial simplex assigning to its faces all the points that are candidates to form part of the hull.
     *
     * @return instance of QuickHull
     */
    public native QuickHull computeInitialHull();

    /**
     * Removes inactive (e.g. deleted) faces from the internal face list.
     *
     * @return instance of QuickHull
     */
    public native QuickHull reindexFaces();

    /**
     * Finds the next vertex to create faces with the current hull.
     * <p>
     * Let the initial face be the first face existing in the 'assigned' vertex list.
     * If a face doesn't exist then return since there're no vertices left.
     * Otherwise for each vertex that face sees find the one furthest away from it.
     *
     * @return instance of VertexNode
     */
    public native VertexNode nextVertexToAdd();

    /**
     * Computes a chain of half edges in CCW order called the 'horizon'. For an edge to be part of the horizon it must join a face that can see 'eyePoint' and a face that cannot see 'eyePoint'.
     *
     * @param eyePoint  - The 3D-coordinates of a point.
     * @param crossEdge - The edge used to jump to the current face.
     * @param face      - The current face being tested.
     * @param horizon   - The edges that form part of the horizon in CCW order.
     * @return instance of QuickHull
     */
    public native QuickHull computeHorizon(Vector3 eyePoint, HalfEdge crossEdge, Face face, VertexNode[] horizon);

    /**
     * Creates a face with the vertices 'eyeVertex.point', 'horizonEdge.tail' and 'horizonEdge.head' in CCW order. All the half edges are created in CCW order thus the face is always pointing outside the hull
     *
     * @param eyeVertex   - The vertex that is added to the hull.
     * @param horizonEdge - A single edge of the horizon.
     * @return instance of QuickHull
     */
    public native QuickHull addAdjoiningFace(VertexNode eyeVertex, HalfEdge horizonEdge);

    /**
     * Adds 'horizon.length' faces to the hull, each face will be linked with the horizon opposite face and the face on the left/right.
     *
     * @param eyeVertex   - The vertex that is added to the hull.
     * @param horizonEdge - An array of half-edges that form the horizon.
     * @return instance of QuickHull
     */
    public native QuickHull addNewFaces(VertexNode eyeVertex, HalfEdge[] horizonEdge);

    /**
     * Adds a vertex to the hull with the following algorithm
     * <p>
     * Compute the 'horizon' which is a chain of half edges. For an edge to belong to this group it must be the edge connecting a face that can see 'eyeVertex' and a face which cannot see 'eyeVertex'.
     * All the faces that can see 'eyeVertex' have its visible vertices removed from the assigned vertex list.
     * A new set of faces is created with each edge of the 'horizon' and 'eyeVertex'. Each face is connected with the opposite horizon face and the face on the left/right.
     * The vertices removed from all the visible faces are assigned to the new faces if possible.
     *
     * @param eyeVertex - The vertex that is added to the hull.
     * @return instance of QuickHull
     */
    public native QuickHull addVertexToHull(VertexNode eyeVertex);

    /**
     * Cleans up internal properties after computing the convex hull.
     *
     * @return instance of QuickHull
     */
    public native QuickHull cleanup();

    /**
     * Starts the execution of the quick hull algorithm.
     *
     * @return instance of QuickHull
     */
    public native QuickHull compute();
}
