package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector;

/**
 * An abstract base class for creating a Curve object that contains methods for interpolation. For an array of Curves see CurvePath.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/11/18.
 */
@JsType(isNative = true, namespace = "THREE")
public abstract class Curve {

    /**
     * This value determines the amount of divisions when calculating the cumulative segment lengths of a curve via
     * .getLengths. To ensure precision when using methods like .getSpacedPoints, it is recommended to increase
     * .arcLengthDivisions if the curve is very large. Default is 200.
     */
    public int arcLengthDivisions;

    @JsConstructor
    public Curve() {

    }

    /**
     * Returns a vector for a given position on the curve.
     *
     * @param t - A position on the curve. Must be in the range [ 0, 1 ].
     * @return Vector
     */
    public native Vector getPoint(float t);

    /**
     * Returns a vector for a given position on the curve.
     *
     * @param t              - A position on the curve. Must be in the range [ 0, 1 ].
     * @param optionalTarget — (optional) If specified, the result will be copied into this Vector, otherwise a new Vector will be created.
     * @return Vector
     */
    public native Vector getPoint(float t, Vector optionalTarget);

    /**
     * Returns a vector for a given position on the curve according to the arc length.
     *
     * @param u - A position on the curve according to the arc length. Must be in the range [ 0, 1 ].
     * @return Vector
     */
    public native Vector getPointAt(float u);

    /**
     * Returns a vector for a given position on the curve according to the arc length.
     *
     * @param u              - A position on the curve according to the arc length. Must be in the range [ 0, 1 ].
     * @param optionalTarget — (optional) If specified, the result will be copied into this Vector, otherwise a new Vector will be created.
     * @return Vector
     */
    public native Vector getPointAt(float u, Vector optionalTarget);

    /**
     * Returns a set of divisions + 1 points using getPoint( t ).
     * divisions -- number of pieces to divide the curve into. Default is 5.
     *
     * @param divisions
     * @return
     */
    public native int[] getPoints(int divisions); //TODO

    /**
     * Returns a set of divisions + 1 equi-spaced points using getPointAt( u ).
     *
     * @param divisions -- number of pieces to divide the curve into. Default is 5.
     * @return
     */
    public native int[] getSpacedPoints(int divisions);


    /**
     * Get total curve arc length.
     *
     * @return
     */
    public native float getLength();

    /**
     * Get total curve arc length.
     *
     * @param divisions -- Get list of cumulative segment lengths.
     * @return
     */
    public native float getLength(int divisions);

    /**
     * Update the cumlative segment distance cache.
     */
    public native void updateArcLengths();

    /**
     * Given u in the range ( 0 .. 1 ), returns t also in the range ( 0 .. 1 ). u and t can then be used to give you points which are equidistant from the ends of the curve, using .getPoint.
     *
     * @param u
     * @param distance
     * @return
     */
    public native float getUtoTmapping(float u, float distance);

    /**
     * Returns a unit vector tangent at t. If the derived curve does not implement its tangent derivation, two points a small delta apart will be used to find its gradient which seems to give a reasonable approximation.
     *
     * @param t
     * @return
     */
    public native Vector getTangent(float t);

    /**
     * Returns tangent at a point which is equidistant to the ends of the curve from the point given in .getTangent.
     *
     * @param u
     * @return
     */
    public native Vector getTangentAt(float u);

    /**
     * Generates the Frenet Frames. Used in geometries like TubeGeometry or ExtrudeGeometry.
     *
     * @param segments
     * @param closed
     * @return
     */
    public native Object computeFrenetFrames(int segments, boolean closed);

    /**
     * Creates a clone of this instance.
     *
     * @return
     */
    public native Curve clone();

    /**
     * Copies another Curve object to this instance.
     *
     * @param source
     * @return
     */
    public native Curve copy(Curve source);

    /**
     * Returns a JSON object representation of this instance.
     *
     * @return
     */
    public native String toJSON();

    /**
     * Copies the data from the given JSON object to this instance.
     *
     * @return
     */
    public native Curve toJSON(String json);

}
