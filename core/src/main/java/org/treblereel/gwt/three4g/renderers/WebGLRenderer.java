package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.renderers.params.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.j2cl.processors.annotations.ES6Module;

@ES6Module
@JsType(isNative = true, namespace = "org.treblereel.gwt.three4g.renderers")
public class WebGLRenderer {

    public elemental2.dom.Node domElement;

    public WebGLRenderer() {

    }

    public WebGLRenderer(WebGLRendererParameters params) {

    }

    public native void setPixelRatio(double devicePixelRatio);

    public native void setSize(int innerWidth, int innerHeight);

    public native void render(Scene scene, PerspectiveCamera camera);
}
