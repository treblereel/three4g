package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * Class for loading a CubeTexture. This uses the ImageLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CubeTextureLoader {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is undefined.
     */
    public String crossOrigin;

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     */
    public String path;

    @JsConstructor
    public CubeTextureLoader() {

    }

    @JsConstructor
    public CubeTextureLoader(LoadingManager manager) {

    }

    /**
     * @param urls — array of 6 urls to images, one for each side of the CubeTexture. The urls should be specified in the following order: pos-x, neg-x, pos-y, neg-y, pos-z, neg-z. They can also be Data URIs.
     *             Note that, by convention, cube maps are specified in a coordinate system in which positive-x is to the right when looking up the positive-z axis -- in other words, using a left-handed coordinate system. Since three.js uses a right-handed coordinate system, environment maps used in three.js will have pos-x and neg-x swapped.
     * @return instance of CubeTexture
     */
    public native CubeTexture load(String[] urls);


    /**
     * @param urls   — array of 6 urls to images, one for each side of the CubeTexture. The urls should be specified in the following order: pos-x, neg-x, pos-y, neg-y, pos-z, neg-z. They can also be Data URIs.
     *               Note that, by convention, cube maps are specified in a coordinate system in which positive-x is to the right when looking up the positive-z axis -- in other words, using a left-handed coordinate system. Since three.js uses a right-handed coordinate system, environment maps used in three.js will have pos-x and neg-x swapped.
     * @param onLoad — Will be called when load completes. The argument will be the loaded texture.
     */
    public native void load(String[] urls, OnLoadCallback<CubeTexture> onLoad);


    /**
     * @param urls       — array of 6 urls to images, one for each side of the CubeTexture. The urls should be specified in the following order: pos-x, neg-x, pos-y, neg-y, pos-z, neg-z. They can also be Data URIs.
     *                   Note that, by convention, cube maps are specified in a coordinate system in which positive-x is to the right when looking up the positive-z axis -- in other words, using a left-handed coordinate system. Since three.js uses a right-handed coordinate system, environment maps used in three.js will have pos-x and neg-x swapped.
     * @param onLoad     — Will be called when load completes. The argument will be the loaded texture.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     * @param onError    — Will be called when load errors.
     */
    public native void load(String[] urls, OnLoadCallback<CubeTexture> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the .crossOrigin attribute.
     *
     * @param origin crossOrigin attribute
     */
    public native void setCrossOrigin(String origin);

    /**
     * @param path Set the base path or URL from which to load files. This can be useful if you are loading many textures from the same directory.
     * @return instance of FileLoader
     */
    public native CubeTextureLoader setPath(String path);
}
