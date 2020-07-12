package org.treblereel.gwt.three4g.loaders;

import elemental2.media.AudioBuffer;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Class for loading an AudioBuffer. This uses the FileLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AudioLoader extends Loader<AudioLoader, AudioBuffer> {

    @JsConstructor
    public AudioLoader() {

    }

    @JsConstructor
    public AudioLoader(LoadingManager manager) {

    }

}
