package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.PropertyHolder;

@JsType(isNative = true, name = "THREE.GLTFLoader", namespace = JsPackage.GLOBAL)
public class GLTFLoader<T extends PropertyHolder> extends Loader<GLTFLoader, T> {

    public GLTFLoader() {}

    public GLTFLoader(LoadingManager manager) {}

    public native void setDRACOLoader(DRACOLoader dracoLoader);
}
