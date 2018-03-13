package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationAction {

    /**
     * Tells the mixer to activate the action. This method can be chained.
     * <p>
     * Note: Activating this action doesn’t necessarily mean that the animation starts immediately: If the action had
     * already finished before (by reaching the end of its last loop), or if a time for a delayed start has been set
     * (via startAt), a reset must be executed first. Some other settings (paused=true, enabled=false, weight=0, timeScale=0)
     * can prevent the animation from playing, too.
     *
     * @return
     */
    public native AnimationAction play();
}
