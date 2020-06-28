package org.treblereel.gwt.three4g.extensions.utils;

import elemental2.core.JsDate;
import elemental2.core.Uint8Array;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.PropertyHolder;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@Three4gElement(paths = {"js/libs/jszip.min.js"})
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JSZip {

    private PropertyHolder files;

    public JSZip() {
    }

    public JSZip(Object data) {
    }

    public native void file(String name, String content);

    public native JSZip folder(String name);

    public native void remove(String name);

    @JsOverlay
    public final ZipObject getFile(String name) {
        ZipObject result = Js.uncheckedCast(files.getProperty(name));
        return result;
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class ZipObject {

        public String name;
        public JsDate date;
        public String comment;
        public boolean dir;

        public native Uint8Array asUint8Array();

/*        asText function(){return q.call(this,!0)}
        JSZip.java:42      asBinary function(){return q.call(this,!1)}
        JSZip.java:42      asNodeBuffer function(){var a=p(this);return d.transformTo("nodebuffer",a)}
        JSZip.java:42      asUint8Array function(){var a=p(this);return d.transformTo("uint8array",a)}
        JSZip.java:42      asArrayBuffer function(){return this.asUint8Array().buffer}*/
    }
}
