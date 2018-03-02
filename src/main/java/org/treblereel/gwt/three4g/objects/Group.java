package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * This is almost identical to an Object3D. Its purpose is to make working with groups of objects syntactically clearer.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
public class Group extends Object3D {

    /**
     * A string 'Group'. This should not be changed.
     */
    public String type;

    @JsConstructor
    public Group(){
        
    }

    //TODO
    @JsProperty
    public native String getType();
}
