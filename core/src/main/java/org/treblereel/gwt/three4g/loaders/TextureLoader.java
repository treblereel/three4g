package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.j2cl.processors.annotations.ES6Module;

@ES6Module
@JsType(isNative = true, namespace = "org.treblereel.gwt.three4g.loaders")
public class TextureLoader {

    public native Texture load(String path);
}
