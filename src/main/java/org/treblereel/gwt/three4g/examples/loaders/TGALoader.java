package org.treblereel.gwt.three4g.examples.loaders;

import elemental2.core.ArrayBuffer;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.DataTexture;

/**
 * A loader for loading a .tga resource.
 * TGA is a raster graphics, image file format.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TGALoader {

    public TGALoader() {

    }

    public TGALoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url — A string containing the path/URL of the .tga file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url    — A string containing the path/URL of the .tga file.
     * @param onLoad —  A function to be called after loading is successfully completed. The function receives loaded DataTexture as an argument.
     */
    public native void load(String url, OnLoadCallback<DataTexture> onLoad);

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url        — A string containing the path/URL of the .tga file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives loaded DataTexture as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     */
    public native void load(String url, OnLoadCallback<DataTexture> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url        — A string containing the path/URL of the .tga file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives loaded DataTexture as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback<DataTexture> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);


    /**
     * //TODO check it
     * @param text — ArrayBuffer to parse.
     * @return instance of DataTexture
     */
    public native DataTexture parse(ArrayBuffer text);
}
