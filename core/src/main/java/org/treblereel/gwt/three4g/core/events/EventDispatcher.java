package org.treblereel.gwt.three4g.core.events;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.PropertyHolder;

/**
 * JavaScript events for custom objects.
 */
@JsType(isNative = true, namespace = "THREE")
public class EventDispatcher extends PropertyHolder {

    /**
     * Creates EventDispatcher object.
     */
    public EventDispatcher() {
    }

    /**
     * @param type     - The type of event to listen to.
     * @param listener - The function that gets called when the event is fired.
     */
    public native void addEventListener(String type, EventListener listener);

    /**
     * @param type     - The type of event to listen to.
     * @param listener - The function that gets called when the event is fired.
     * @return Checks if listener is added to an event type.
     */
    public native boolean hasEventListener(String type, EventListener listener);

    /**
     * Removes a listener from an event type.
     *
     * @param type     - The type of the listener that gets removed.
     * @param listener - The listener function that gets removed.
     */
    public native void removeEventListener(String type, EventListener listener);

    /**
     * Fire an event type.
     *
     * @param event - The event that gets fired.
     */
    public native void dispatchEvent(Event event);

}
