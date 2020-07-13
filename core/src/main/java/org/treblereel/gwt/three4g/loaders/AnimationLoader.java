package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Class for loading AnimationClips in JSON format. This uses the FileLoader internally for loading files.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AnimationLoader extends Loader<AnimationLoader, AnimationClip[]> {

    @JsConstructor
    public AnimationLoader() {

    }

    @JsConstructor
    public AnimationLoader(LoadingManager manager) {

    }
}
