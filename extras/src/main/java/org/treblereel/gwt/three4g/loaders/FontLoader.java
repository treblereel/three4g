package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.FontLoader", namespace = JsPackage.GLOBAL)
public class FontLoader extends Loader<FontLoader, Font> {

    public FontLoader() {}

    public FontLoader(LoadingManager manager) {}
}
