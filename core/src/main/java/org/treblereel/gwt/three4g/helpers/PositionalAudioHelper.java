package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.audio.PositionalAudio;
import org.treblereel.gwt.three4g.objects.Line;

/**
 * This helper displays the directional cone of a PositionalAudio.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 10/16/19
 */
@JsType(isNative = true, name = "THREE.PositionalAudioHelper", namespace = JsPackage.GLOBAL)
public class PositionalAudioHelper extends Line {

    /**
     * PositionalAudio to be visualized.
     */
    public PositionalAudio audio;

    /**
     * The range of the directional cone.
     */
    public Number range;

    /**
     * The amount of divisions of the inner part of the directional cone.
     */
    public Number divisionsInnerAngle;

    /**
     * The amount of divisions of the outer part of the directional cone.
     */
    public Number divisionsOuterAngle;

    /**
     * @param audio -- The PositionalAudio to be visualized.
     */
    public PositionalAudioHelper(PositionalAudio audio) {

    }

    /**
     * @param audio -- The PositionalAudio to be visualized.
     * @param range -- The range of the directional cone.
     *
     */
    public PositionalAudioHelper(PositionalAudio audio, Number range) {

    }

    /**
     * @param audio -- The PositionalAudio to be visualized.
     * @param range -- The range of the directional cone.
     * @param divisionsInnerAngle -- The amount of divisions of the inner part of the directional cone.
     *
     */
    public PositionalAudioHelper(PositionalAudio audio, Number range, Number divisionsInnerAngle) {

    }

    /**
     * @param audio -- The PositionalAudio to be visualized.
     * @param range -- The range of the directional cone.
     * @param divisionsInnerAngle -- The amount of divisions of the inner part of the directional cone.
     * @param divisionsOuterAngle -- (optional) The amount of divisions of the outer part of the directional cone.
     *
     */
    public PositionalAudioHelper(PositionalAudio audio, Number range, Number divisionsInnerAngle, Number divisionsOuterAngle) {

    }

    /**
     * Disposes of the helper.
     */
    public native void dispose();

    /**
     * Updates the helper.
     */
    public native void update();


}
