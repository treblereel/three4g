package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.JsObject;
import org.treblereel.gwt.three4g.loaders.DataTextureLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/7/18.
 */
@Three4gElement(paths = "js/loaders/RGBELoader.js")
@JsType(isNative = true, namespace = "THREE")
public class RGBELoader extends DataTextureLoader<RGBELoader, JsObject> {

    public RGBELoader() {

    }

    public RGBELoader(LoadingManager manager) {

    }
}
