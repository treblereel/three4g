package org.treblereel.gwt.three4g.loaders;

import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Abstract base class for block based textures loader (dds, pvr, ...). This uses the FileLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
public abstract class CompressedTextureLoader<T, V> {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     */
    public String path;

    /**
     * Creates a new CompressedTextureLoader.
     */
    public CompressedTextureLoader() {

    }

    /**
     * Creates a new CompressedTextureLoader.
     *
     * @param manager — The loadingManager for the loader to use. Default is THREE.DefaultLoadingManager.
     */
    public CompressedTextureLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and pass the loaded texture to onLoad.
     *
     * @param url — the path or URL to the file. This can also be a Data URI.
     */
    public native void load(String url);

    /**
     * Begin loading from url and pass the loaded texture to onLoad.
     *
     * @param url    — the path or URL to the file. This can also be a Data URI.
     * @param onLoad — Will be called when loading completes. The argument will be the loaded response.
     */
    public native void load(String url, OnLoadCallback<V> onLoad);

    /**
     * Begin loading from url and pass the loaded texture to onLoad.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress);


    /**
     * Begin loading from url and pass the loaded texture to onLoad.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many models from the same directory.
     *
     * @param path base path or URL
     * @return instance of FileLoader
     */
    public native T setPath(String path);
}
