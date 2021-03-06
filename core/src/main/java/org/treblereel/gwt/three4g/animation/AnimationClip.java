package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.MorphTarget;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.objects.Bone;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationClip extends PropertyHolder {

    public String name;

    public int duration;

    public KeyframeTrack[] tracks;

    public String uuid;

    /**
     * Note: Instead of instantiating an AnimationClip directly with the constructor, you can use one of its static methods to create AnimationClips: from JSON (parse), from morph target sequences (CreateFromMorphTargetSequence, CreateClipsFromMorphTargetSequences) or from animation hierarchies (parseAnimation) - if your model doesn't already hold AnimationClips in its geometry's animations array.
     *
     * @param name     - a name for this clip.
     * @param duration - the duration of this clip (in seconds). If a negative value is passed, the duration will be calculated from the passed tracks array.
     * @param tracks   - an array of KeyframeTracks.
     */
    @JsConstructor
    public AnimationClip(String name, int duration, KeyframeTrack[] tracks) {

    }

    /**
     * Optimizes each track by removing equivalent sequential keys (which are common in morph target sequences).
     *
     * @return instance of AnimationClip
     */
    public native AnimationClip optimize();

    /**
     * Sets the duration of the clip to the duration of its longest KeyframeTrack.
     */
    public native void resetDuration();

    /**
     * Trims all tracks to the clip's duration.
     *
     * @return instance of AnimationClip
     */
    public native AnimationClip trim();

    /**
     * Returns an array of new AnimationClips created from the morph target sequences of a geometry, trying to sort
     * morph target names into animation-group-based patterns like "Walk_001, Walk_002, Run_001, Run_002 ..."
     *
     * @param name                as String value
     * @param morphTargetSequence array of morphTargetSequences
     * @param fps                 as int value
     * @param noLoop              true, if noLoop required
     * @return instance of array of AnimationClips
     */
    @JsMethod(name = "CreateClipsFromMorphTargetSequences")
    public native static AnimationClip[] createClipsFromMorphTargetSequences(String name, JsArray<MorphTarget> morphTargetSequence, int fps, boolean noLoop);

    /**
     * Returns a new AnimationClip from the passed morph targets array of a geometry, taking a name and the number of frames per second.
     * <p>
     * Note: The fps parameter is required, but the animation speed can be overridden in an AnimationAction via animationAction.setDuration.
     *
     * @param name                as String value
     * @param morphTargetSequence array of morphTargetSequences
     * @param fps                 as int value
     * @param noLoop              true, if noLoop required
     * @return instance of AnimationClip
     */
    @JsMethod(name = "CreateFromMorphTargetSequence")
    public native static AnimationClip createFromMorphTargetSequence(String name, JsArray<MorphTarget> morphTargetSequence, int fps, boolean noLoop);

    /**
     * Searches for an AnimationClip by name, taking as its first parameter either an array of AnimationClips, or a mesh or geometry that contains an array named "animations".
     *
     * @param objectOrClipArray could array or object
     * @param name              the name of
     * @return instance of AnimationClip
     */
    public native static AnimationClip findByName(Object objectOrClipArray, String name);

    /**
     * Parses a JSON representation of a clip and returns an AnimationClip.
     *
     * @param json as String value
     * @return AnimationClip
     */
    public native static AnimationClip parse(Object json);

    /**
     * Parses the animation.hierarchy format and returns an AnimationClip.
     *
     * @param json  as String value
     * @param bones array of bones
     * @return AnimationClip
     */
    public native static AnimationClip parseAnimation(Object json, Bone[] bones);

    /**
     * Takes an AnimationClip and returns a JSON object.
     *
     * @param clip instance of AnimationClip
     * @return JSON
     */
    public native static String toJSON(AnimationClip clip);


}
