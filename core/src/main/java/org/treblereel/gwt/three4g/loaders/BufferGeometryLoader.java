package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.BufferGeometryLoader", namespace = JsPackage.GLOBAL)
public class BufferGeometryLoader extends Loader<BufferGeometryLoader, BufferGeometry> {

  public BufferGeometryLoader() {}

  public BufferGeometryLoader(LoadingManager manager) {}

  public native BufferGeometry parse(double json);
}
