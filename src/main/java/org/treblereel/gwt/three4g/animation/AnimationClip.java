package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.tracks.KeyframeTrack;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationClip {

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
     * @return
     */
    public native AnimationClip optimize();

    /**
     * Sets the duration of the clip to the duration of its longest KeyframeTrack.
     */
    public native void resetDuration();

    /**
     * Trims all tracks to the clip's duration.
     *
     * @return
     */
    public native AnimationClip trim();

    /**
     * Returns an array of new AnimationClips created from the morph target sequences of a geometry, trying to sort
     * morph target names into animation-group-based patterns like "Walk_001, Walk_002, Run_001, Run_002 ..."
     * This method is called by the JSONLoader internally, and it uses CreateFromMorphTargetSequence.
     *
     * @param name
     * @param morphTargetSequence
     * @param fps
     * @param noLoop
     * @return
     */
    public native static AnimationClip[] createClipsFromMorphTargetSequences(String name, Object[] morphTargetSequence, int fps, boolean noLoop);

    /**
     * Returns a new AnimationClip from the passed morph targets array of a geometry, taking a name and the number of frames per second.
     * <p>
     * Note: The fps parameter is required, but the animation speed can be overridden in an AnimationAction via animationAction.setDuration.
     *
     * @param name
     * @param morphTargetSequence
     * @param fps
     * @param noLoop
     * @return
     */
    public native static AnimationClip[] CreateFromMorphTargetSequence(String name, Object[] morphTargetSequence, int fps, boolean noLoop);

    /**
     * Searches for an AnimationClip by name, taking as its first parameter either an array of AnimationClips, or a mesh or geometry that contains an array named "animations".
     * @param objectOrClipArray
     * @param name
     * @return
     */
    public native static AnimationClip findByName(Object objectOrClipArray, String name);

    /**
     * Parses a JSON representation of a clip and returns an AnimationClip.
     * @param json
     * @return AnimationClip
     */
    public native static AnimationClip parse(Object json);

    /**
     *Parses the animation.hierarchy format and returns an AnimationClip.
     * @param json
     * @param bones
     * @return AnimationClip
     */
    public native static AnimationClip parseAnimation(Object json, Object[] bones);

    /**
     * Takes an AnimationClip and returns a JSON object.
     * @param clip
     * @return
     */
    public native static String toJSON (AnimationClip clip);


}
