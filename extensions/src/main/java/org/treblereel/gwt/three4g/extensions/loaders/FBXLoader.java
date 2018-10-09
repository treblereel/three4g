package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.AbstractLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/9/18.
 */
@Three4gElement(paths = {"js/loaders/zlib.js", "js/loaders/FBXLoader.js"})
@JsType(isNative = true, namespace = "THREE")
public class FBXLoader<T extends Object3D> extends AbstractLoader<FBXLoader, T> {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is anonymous.
     */
    public String crossOrigin;

    public FBXLoader() {

    }

    public FBXLoader(LoadingManager manager) {

    }
}
