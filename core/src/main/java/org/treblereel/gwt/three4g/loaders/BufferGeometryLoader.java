package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a BufferGeometry. This uses the FileLoader internally for loading files.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BufferGeometryLoader<T extends BufferGeometry> extends Loader<BufferGeometryLoader, T> {

    @JsConstructor
    public BufferGeometryLoader() {

    }

    @JsConstructor
    public BufferGeometryLoader(LoadingManager manager) {

    }
}
