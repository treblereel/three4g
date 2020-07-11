package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.loaders.AbstractLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * Virtual Reality Modeling Language loader
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
@Three4gElement(paths = {"js/libs/chevrotain.min.js", "js/loaders/VRMLLoader.js"})
@JsType(isNative = true, namespace = "THREE")
public class VRMLLoader extends AbstractLoader<VRMLLoader, Scene> {

    public VRMLLoader() {

    }

    public VRMLLoader(LoadingManager manager) {

    }

    /**
     * @param text — String to parse.
     * @param path — the path.
     * @return instance of Scene
     */
    public native Scene parse(String text, String path);
}
