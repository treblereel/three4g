package org.treblereel.gwt.three4g.animation;

import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.interpolants.DiscreteInterpolant;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class KeyframeTrack {  //TODO check it

    /**
     * The track's name can refer to morph targets or bones or possibly other values within an animated object. See PropertyBinding.parseTrackName for the forms of strings that can be parsed for property binding:
     * <p>
     * The name can specify the node either using its name or its uuid (although it needs to be in the subtree of the scene graph node passed into the mixer). Or, if the track name starts with a dot, the track applies to the root node that was passed into the mixer.
     * <p>
     * Usually after the node a property will be specified directly. But you can also specify a subproperty, such as .rotation[x], if you just want to drive the X component of the rotation via a float track.
     * <p>
     * You can also specify bones or multimaterials by using an object name, for example: .bones[R_hand].scale; the red channel of the diffuse color of the fourth material in a materials array - as a further example - can be accessed with .materials[3].diffuse[r].
     * <p>
     * PropertyBinding will also resolve morph target names, for example: .morphTargetInfluences[run].
     * <p>
     * Note: The track's name does not necessarily have to be unique. Multiple tracks can drive the same property. The result should be based on a weighted blend between the multiple tracks according to the weights of their respective actions.
     */
    public String name;

    /**
     * A Float32Array, converted from the times array which is passed in the constructor.
     */
    public Float32Array times;


    /**
     * A Float32Array, converted from the values array which is passed in the constructor.
     */
    public Float32Array values;

    /**
     * The default interpolation type: InterpolateLinear.
     */
    public static int DefaultInterpolation;

    /**
     * Float32Array, the type of the buffer internally used for the times.
     */
    public static String TimeBufferType;

    /**
     * Float32Array, the type of the buffer internally used for the values.
     */
    public static String ValueBufferType;


    protected KeyframeTrack() {

    }

    /**
     * @param name          - the identifier for the KeyframeTrack.
     * @param times         - an array of keyframe times, converted internally to a Float32Array.
     * @param values        - an array with the values related to the times array, converted internally to a Float32Array.
     */
    @JsConstructor
    public KeyframeTrack(String name, JsArray times, JsArray values) {

    }

    /**
     * @param name          - the identifier for the KeyframeTrack.
     * @param times         - an array of keyframe times, converted internally to a Float32Array.
     * @param values        - an array with the values related to the times array, converted internally to a Float32Array.
     * @param interpolation - the type of interpolation to use. See Animation Constants for possible values. Default is InterpolateLinear.
     */
    @JsConstructor
    public KeyframeTrack(String name, JsArray times, JsArray values, int interpolation) {

    }

    /**
     * Creates a LinearInterpolant, CubicInterpolant or DiscreteInterpolant, depending on the value of the interpolation parameter passed in the constructor.
     */
    public native void createInterpolant();

    /**
     * Returns the interpolation type.
     */
    public native void getInterpolation();

    /**
     * Returns the size of each value (that is the length of the values array divided by the length of the times array).
     *
     * @return
     */
    public native int getValueSize();

    /**
     * Creates a new DiscreteInterpolant from the times and values. A Float32Array can be passed which will receive the results. Otherwise a new array with the appropriate size will be created automatically.
     *
     * @param result
     * @return
     */
    @JsMethod(name = "InterpolantFactoryMethodDiscrete")
    public native DiscreteInterpolant interpolantFactoryMethodDiscrete(Float32Array result);

    /**
     * Creates a new LinearInterpolant from the times and values. A Float32Array can be passed which will receive the results. Otherwise a new array with the appropriate size will be created automatically.
     *
     * @param result
     */
    @JsMethod(name = "InterpolantFactoryMethodLinear")
    public native void interpolantFactoryMethodLinear(Float32Array result);

    /**
     * Create a new CubicInterpolant from the times and values. A Float32Array can be passed which will receive the results. Otherwise a new array with the appropriate size will be created automatically.
     *
     * @param result
     */
    @JsMethod(name = "InterpolantFactoryMethodSmooth")
    public native void interpolantFactoryMethodSmooth(Float32Array result);

    /**
     * Removes equivalent sequential keys, which are common in morph target sequences. Called automatically by the constructor.
     */
    public native void optimize();

    /**
     * Scales all keyframe times by a factor.
     * <p>
     * Note: This is useful, for example, for conversions to a certain rate of frames per seconds (as it is done internally by animationClip.CreateFromMorphTargetSequence).
     */
    public native void scale();

    /**
     * Sets the interpolation type. See Animation Constants for choices.
     *
     * @param interpolationType
     */
    public native void setInterpolation(int interpolationType);

    /**
     * Moves all keyframes either forward or backward in time.
     *
     * @param timeOffsetInSeconds
     */
    public native void shift(double timeOffsetInSeconds);

    /**
     * Removes keyframes before startTime and after endTime, without changing any values within the range [startTime, endTime].
     */
    public native void trim(double startTimeInSeconds, double endTimeInSeconds);

    /**
     * Performs minimal validation on the tracks. Called automatically by the constructor.
     * <p>
     * This method logs errors to the console, if a track is empty, if the value size is not valid, if an item in the times or values array is not a valid number or if the items in the times array are out of order.
     */
    public native void validate();

    /**
     * Parses a JSON object and returns a new keyframe track of the correct type.
     *
     * @param json
     * @return
     */
    public native static KeyframeTrack parse(String json);

    /**
     * Converts the track to JSON.
     *
     * @param track
     * @return
     */
    public native static String toJSON(KeyframeTrack track);


    @JsProperty
    public native String getType();
}
