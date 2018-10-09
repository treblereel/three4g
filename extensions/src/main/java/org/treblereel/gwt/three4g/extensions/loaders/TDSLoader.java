package org.treblereel.gwt.three4g.extensions.loaders;

import elemental2.core.ArrayBuffer;
import elemental2.core.TypedArray;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.AbstractLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.objects.Group;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/9/18.
 */
@Three4gElement(paths = "js/loaders/TDSLoader.js")
@JsType(isNative = true, namespace = "THREE")
public class TDSLoader extends AbstractLoader<TDSLoader, Object3D> {

    public TDSLoader() {

    }

    public TDSLoader(LoadingManager manager) {

    }

    /**
     * @param arraybuffer Arraybuffer data to be loaded.
     * @param path        Path for external resources.
     * @return Group loaded from 3ds file.
     */
    public native Group parse(ArrayBuffer arraybuffer, String path);

    /**
     * @param arraybuffer TypedArray data to be loaded.
     * @param path        Path for external resources.
     * @return Group loaded from 3ds file.
     */
    public native Group parse(TypedArray arraybuffer, String path);

}
