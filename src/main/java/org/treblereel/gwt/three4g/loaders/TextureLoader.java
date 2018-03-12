package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * Class for loading a texture. This uses the ImageLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/5/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TextureLoader {

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

    /**
     * Whether the XMLHttpRequest uses credentials - see .setWithCredentials. Default is undefined.
     */
    public String withCredentials;


    /**
     * Creates a new TextureLoader.
     */
    @JsConstructor
    public TextureLoader() {

    }

    /**
     * Creates a new TextureLoader.
     *
     * @param manager — The loadingManager for the loader to use. Default is DefaultLoadingManager.
     */
    @JsConstructor
    public TextureLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from the given URL and pass the fully loaded texture to onLoad. The method also returns a new texture
     * object which can directly be used for material creation. If you do it this way, the texture may pop up in your scene
     * once the respective loading process is finished.
     *
     * @param url — the path or URL to the file. This can also be a Data URI.
     * @return Texture
     */
    public native Texture load(String url);

    /**
     * Begin loading from the given URL and pass the fully loaded texture to onLoad. The method also returns a new texture
     * object which can directly be used for material creation. If you do it this way, the texture may pop up in your scene
     * once the respective loading process is finished.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when load completes. The argument will be the loaded texture.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     * @param onError    — Will be called when load errors.
     *                   <p>
     * @return Texture
     */
    public native Texture load(String url, OnLoadCallback<Texture> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the .crossOrigin attribute.
     *
     * @param value
     */
    public native void setCrossOrigin(String value);


    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many models from the same directory.
     *
     * @param path
     * @return
     */
    public native TextureLoader setPath(String path);

    /**
     * Whether the XMLHttpRequest uses credentials such as cookies, authorization headers or TLS client certificates. See XMLHttpRequest.withCredentials.
     * Note that this has no effect if you are loading files locally or from the same domain.
     *
     * @param value
     * @return
     */
    public native TextureLoader setWithCredentials(String value);


}
