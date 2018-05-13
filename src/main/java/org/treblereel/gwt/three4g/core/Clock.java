package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Object for keeping track of time. This uses performance.now() if it is available, otherwise it reverts to the less accurate Date.now().
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/9/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Clock {

    /**
     * If set, starts the clock automatically when the first update is called. Default is true.
     */
    public boolean autoStart;

    /**
     * Holds the time at which the clock's start method was last called.
     */
    public float startTime;

    /**
     * Holds the time at which the clock's start, getElapsedTime or getDelta methods were last called.
     */
    public float oldTime;

    /**
     * Keeps track of the total time that the clock has been running.
     */
    public float elapsedTime;

    /**
     * Whether the clock is running or not.
     */
    public boolean running;

    @JsConstructor
    public Clock() {

    }

    /**
     * @param autoStart — whether to automatically start the clock. Default is true.
     */
    @JsConstructor
    public Clock(boolean autoStart) {

    }

    /**
     * Starts clock. Also sets the startTime and oldTime to the current time, sets elapsedTime to 0 and running to true.
     */
    public native void start();

    /**
     * Stops clock and sets oldTime to the current time.
     */
    public native void stop();

    /**
     * Get the seconds passed since the clock started and sets oldTime to the current time.
     * If autoStart is true and the clock is not running, also starts the clock.
     *
     * @return float
     */
    public native float getElapsedTime();

    /**
     * Get the seconds passed since the time oldTime was set and sets oldTime to the current time.
     * If autoStart is true and the clock is not running, also starts the clock.
     *
     * @return float
     */
    public native float getDelta();


}
