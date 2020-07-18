package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * Class for loading a CubeTexture. This uses the ImageLoader internally for loading files.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, name = "THREE.CubeTextureLoader", namespace = JsPackage.GLOBAL)
public class CubeTextureLoader extends Loader<CubeTextureLoader, CubeTexture> {

    @JsConstructor
    public CubeTextureLoader() {

    }

    @JsConstructor
    public CubeTextureLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call onLoad with the response content.
     * @param url — A string containing the path/URL of the file.
     */
    public native CubeTexture load(String[] url);

    /**
     * Begin loading from url and call onLoad with the response content.
     * @param url — A string containing the path/URL of the file.
     * @param onLoad — A function to be called after loading is successfully completed. The function
     * receives the loaded SVGDocument as an argument.
     */
    public native void load(String[] url, OnLoadCallback<CubeTexture> onLoad);

    /**
     * Begin loading from url and call onLoad with the response content.
     * @param url — A string containing the path/URL of the file.
     * @param onLoad — A function to be called after loading is successfully completed. The function
     * receives the loaded SVGDocument as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will
     * be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String[] url, OnLoadCallback<CubeTexture> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the response content.
     * @param url — A string containing the path/URL of the file.
     * @param onLoad — A function to be called after loading is successfully completed. The function
     * receives the loaded SVGDocument as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will
     * be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError — A function to be called if an error occurs during loading. The function
     * receives the error as an argument.
     */
    public native void load(
            String url[], OnLoadCallback<CubeTexture> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);
}
