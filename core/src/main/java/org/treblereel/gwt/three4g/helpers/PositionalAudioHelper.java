package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.audio.PositionalAudio;
import org.treblereel.gwt.three4g.objects.Line;

/**
 * This helper displays the directional cone of a PositionalAudio.
 *
 * @author Dmitrii Tikhomirov Created by treblereel 5/6/19
 */
@JsType(isNative = true, namespace = "THREE")
public class PositionalAudioHelper extends Line {

  /** @param audio -- The PositionalAudio to be visualized. */
  public PositionalAudioHelper(PositionalAudio audio) {}

  /**
   * @param audio -- The PositionalAudio to be visualized.
   * @param range -- The range of the directional cone.
   */
  public PositionalAudioHelper(PositionalAudio audio, float range) {}

  /**
   * @param audio -- The PositionalAudio to be visualized.
   * @param range -- The range of the directional cone.
   * @param divisionsInnerAngle -- The amount of divisions of the inner part of the directional
   *     cone.
   */
  public PositionalAudioHelper(PositionalAudio audio, float range, float divisionsInnerAngle) {}

  /**
   * @param audio -- The PositionalAudio to be visualized.
   * @param range -- The range of the directional cone.
   * @param divisionsInnerAngle -- The amount of divisions of the inner part of the directional
   *     cone.
   * @param divisionsOuterAngle -- The amount of divisions of the outer part of the directional
   *     cone.
   */
  public PositionalAudioHelper(
      PositionalAudio audio, float range, float divisionsInnerAngle, float divisionsOuterAngle) {}

  /** Disposes of the helper. */
  public native void dispose();

  /** Updates of the helper. */
  public native void update();
}
