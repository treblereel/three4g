package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.ImageBitmap;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading an Image as an ImageBitmap. An ImageBitmap provides an asynchronous and resource efficient pathway
 * to prepare textures for rendering in WebGL.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, name = "THREE.ImageBitmapLoader", namespace = JsPackage.GLOBAL)
public class ImageBitmapLoader extends Loader<ImageBitmapLoader, ImageBitmap> {

    /**
     * An optional object that sets options for the internally used createImageBitmap factory method. Default is undefined.
     */
    public String options;

    @JsConstructor
    public ImageBitmapLoader() {

    }

    @JsConstructor
    public ImageBitmapLoader(LoadingManager manager) {

    }

    /**
     * Sets the options object for createImageBitmap.
     * @param options object
     * @return instance of ImageBitmapLoader
     */
    public native ImageBitmapLoader setOptions(String options);
}
