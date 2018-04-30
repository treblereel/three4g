package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsType;

/**
 * An instanced version of BufferGeometry.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class InstancedBufferGeometry extends BufferGeometry {

    /**
     * Default is undefined.
     */
    public int maxInstancedCount;

    /**
     * Default is true.
     */
    public boolean isInstancedBufferGeometry;


}
