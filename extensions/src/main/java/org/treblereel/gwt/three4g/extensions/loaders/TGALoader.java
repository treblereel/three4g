package org.treblereel.gwt.three4g.extensions.loaders;

import elemental2.core.ArrayBuffer;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A loader for loading a .tga resource.
 * TGA is a raster graphics, image file format.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@Three4gElement(paths = "js/loaders/TGALoader.js")
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
     * @return instance of Texture
     */
    public native Texture load(String url);

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url    — A string containing the path/URL of the .tga file.
     * @param onLoad —  A function to be called after loading is successfully completed. The function receives loaded DataTexture as an argument.
     * @return instance of Texture
     */
    public native Texture load(String url, OnLoadCallback<Texture> onLoad);

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url        — A string containing the path/URL of the .tga file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives loaded DataTexture as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     * @return instance of Texture
     */
    public native Texture load(String url, OnLoadCallback<Texture> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and pass the loaded texture to onLoad. The texture is also directly returned for immediate use (but may not be fully loaded).
     *
     * @param url        — A string containing the path/URL of the .tga file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives loaded DataTexture as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives the error as an argument.
     * @return instance of Texture
     */
    public native Texture load(String url, OnLoadCallback<Texture> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);


    /**
     * //TODO check it
     *
     * @param text — ArrayBuffer to parse.
     * @return instance of Texture
     */
    public native Texture parse(ArrayBuffer text);

    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many models from the same directory.
     *
     * @param path base path or URL
     * @return instance of TextureLoader
     */
    public native TGALoader setPath(String path);
}
