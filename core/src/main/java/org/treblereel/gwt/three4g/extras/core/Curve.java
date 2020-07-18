package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import org.treblereel.gwt.three4g.math.Vector3;

/**
 * An abstract base class for creating a Curve object that contains methods for interpolation. For an array of Curves see CurvePath.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/11/18.
 */
@JsType(isNative = true, name = "THREE.Curve", namespace = JsPackage.GLOBAL)
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
    public native Vector3 getPoint(float t);

    /**
     * Returns a vector for a given position on the curve.
     *
     * @param t              - A position on the curve. Must be in the range [ 0, 1 ].
     * @param optionalTarget — (optional) If specified, the result will be copied into this Vector, otherwise a new Vector will be created.
     * @return Vector
     */
    public native Vector3 getPoint(float t, Vector3 optionalTarget);

    /**
     * Returns a vector for a given position on the curve according to the arc length.
     *
     * @param u - A position on the curve according to the arc length. Must be in the range [ 0, 1 ].
     * @return Vector
     */
    public native Vector3 getPointAt(float u);

    /**
     * Returns a vector for a given position on the curve according to the arc length.
     *
     * @param u              - A position on the curve according to the arc length. Must be in the range [ 0, 1 ].
     * @param optionalTarget — (optional) If specified, the result will be copied into this Vector3, otherwise a new Vector3 will be created.
     * @return Vector3
     */
    public native Vector3 getPointAt(float u, Vector3 optionalTarget);

    /**
     * Returns a set of divisions + 1 points using getPoint( t ).
     *
     * @return array of points
     */
    public native Vector3[] getPoints();

    /**
     * Returns a set of divisions + 1 points using getPoint( t ).
     *
     * @param divisions -- number of pieces to divide the curve into. Default is 5.
     * @return array of points
     */
    public native Vector3[] getPoints(int divisions);

    /**
     * Returns a set of divisions + 1 equi-spaced points using getPointAt( u ).
     *
     * @param divisions -- number of pieces to divide the curve into. Default is 5.
     * @return array of points
     */
    public native Vector3[] getSpacedPoints(int divisions);


    /**
     * Get total curve arc length.
     *
     * @return as float value
     */
    public native float getLength();

    /**
     * Get total curve arc length.
     *
     * @param divisions -- Get list of cumulative segment lengths.
     * @return array of lengths
     */
    public native float[] getLengths(int divisions);

    /**
     * Update the cumlative segment distance cache.
     */
    public native void updateArcLengths();

    /**
     * Given u in the range ( 0 .. 1 ), returns t also in the range ( 0 .. 1 ). u and t can then be used to give you points which are equidistant from the ends of the curve, using .getPoint.
     *
     * @param u        as float value
     * @param distance as float value
     * @return flaot value, equidistant from the ends of the curve
     */
    public native float getUtoTmapping(float u, float distance);

    /**
     * Returns a unit Vector3 tangent at t. If the derived curve does not implement its tangent derivation, two points a small delta apart will be used to find its gradient which seems to give a reasonable approximation.
     *
     * @param t as float value
     * @return tangent at t
     */
    public native Vector3 getTangent(float t);

    /**
     * Returns tangent at a point which is equidistant to the ends of the curve from the point given in .getTangent.
     *
     * @param u as float value
     * @return tangent at t
     */
    public native Vector3 getTangentAt(float u);

    @JsProperty
    public final native String getType();

    /**
     * Generates the Frenet Frames. Used in geometries like TubeGeometry or ExtrudeGeometry.
     *
     * @param segments number of segments
     * @param closed   true,if closed
     * @return Frenet Frames Object
     */
    public native Object computeFrenetFrames(int segments, boolean closed);

    /**
     * Creates a clone of this instance.
     *
     * @return instance of Curve
     */
    public native Curve clone();

    /**
     * Copies another Curve object to this instance.
     *
     * @param source Curve
     * @return instance of Curve
     */
    public native Curve copy(Curve source);

    /**
     * Returns a JSON object representation of this instance.
     *
     * @return JSON String
     */
    public native String toJSON();

    /**
     * Copies the data from the given JSON object to this instance.
     *
     * @param json String
     * @return instance of Curve
     */
    public native Curve toJSON(String json);

}
