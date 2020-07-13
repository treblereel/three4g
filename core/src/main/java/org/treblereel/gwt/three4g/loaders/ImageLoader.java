package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.Image;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading an Image. This uses the FileLoader internally for loading files, and is used internally by the
 * CubeTextureLoader, ObjectLoader and TextureLoader.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ImageLoader extends Loader<ImageLoader, Image> {

    @JsConstructor
    public ImageLoader() {

    }

    @JsConstructor
    public ImageLoader(LoadingManager manager) {

    }
}
