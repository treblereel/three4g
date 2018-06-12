package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsType;

/**
 * Wrapper for the EventDispatcher-Class of ThreeJs
 * <p>
 * JavaScript events for custom objects.
 *
 * @author pesse
 */
@JsType(isNative = true, namespace = "THREE")
public class EventDispatcher extends JsObject{

    @JsType
    @FunctionalInterface
    public interface EventListener<JsObject> {
        void call(JsObject sender, JsObject event);
    }

    /**
     * Creates EventDispatcher object.
     */
    public EventDispatcher() {
    }

    /**
     * Adds a listener to an event type.
     *
     * @param type     The type of event to listen to.
     * @param listener The function that gets called when the event is fired.
     */
    @SuppressWarnings("rawtypes")
    public native void addEventListener(String type, EventListener<JsObject> listener);

    /**
     * Checks if listener is added to an event type.
     *
     * @param type     The type of event to listen to.
     * @param listener The function that gets called when the event is fired.
     * @return isAdded
     */
    @SuppressWarnings("rawtypes")
    public native boolean hasEventListener(String type, EventListener<JsObject> listener);


    /**
     * Removes a listener from an event type.
     *
     * @param type     The type of event to listen to.
     * @param listener The function that gets called when the event is fired.
     */
    @SuppressWarnings("rawtypes")
    public native void removeEventListener(String type, EventListener<JsObject> listener);

    /**
     * Fire an event type.
     *
     * @param <T>   This is the type parameter
     * @param event The event that gets fired.
     */
    public native <T> void dispatchEvent(T event);

}
