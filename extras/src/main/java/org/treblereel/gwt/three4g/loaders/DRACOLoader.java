package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.DRACOLoader", namespace = JsPackage.GLOBAL)
public class DRACOLoader extends Loader {
    public native DRACOLoader setDecoderPath(String path);

    public native DRACOLoader setDecoderConfig(Object config);
    public native DRACOLoader setWorkerLimit(int workerLimit);
    public native DRACOLoader preload();
    public native DRACOLoader dispose();
}
