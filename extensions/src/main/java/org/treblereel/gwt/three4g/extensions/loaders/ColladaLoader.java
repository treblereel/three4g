package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.JsObject;
import org.treblereel.gwt.three4g.loaders.AbstractLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@Three4gElement(paths = "js/loaders/ColladaLoader.js")
@JsType(isNative = true, namespace = "THREE")
public class ColladaLoader extends AbstractLoader<ColladaLoader, JsObject> {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is anonymous.
     */
    public String crossOrigin;

    public ColladaLoader() {

    }

    public ColladaLoader(LoadingManager loadingManager) {

    }

}
