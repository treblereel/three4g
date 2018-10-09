package org.treblereel.gwt.three4g.loaders;

import com.google.gwt.json.client.JSONObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A loader for loading a Material in JSON format. This uses the FileLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MaterialLoader {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * Object holding any textures used by the material. See .setTextures.
     */
    public Texture[] texture; //TODO check it

    @JsConstructor
    public MaterialLoader() {

    }

    @JsConstructor
    public MaterialLoader(LoadingManager loadingManager) {

    }

    /**
     * Begin loading from url and return the Material object that will contain the data.
     *
     * @param url — the path or URL to the file. This can also be a Data URI.
     */
    public native void load(String url);

    /**
     * Begin loading from url and return the Material object that will contain the data.
     *
     * @param url    — the path or URL to the file. This can also be a Data URI.
     * @param onLoad — Will be called when load completes. The argument will be the loaded Material.
     */
    public native void load(String url, OnLoadCallback<? extends Material> onLoad);

    /**
     * Begin loading from url and return the Material object that will contain the data.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when load completes. The argument will be the loaded Material.
     * @param onProgress — Will be called while load progresses. The argument will be the progress event.
     */
    public native void load(String url, OnLoadCallback<? extends Material> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and return the Material object that will contain the data.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when load completes. The argument will be the loaded Material.
     * @param onProgress — Will be called while load progresses. The argument will be the progress event.
     * @param onError    — Will be called when load errors.
     */
    public native void load(String url, OnLoadCallback<? extends Material> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Parse a JSON structure and create a new Material of the type json.type with parameters defined in the json object.
     *
     * @param json — The json object containing the parameters of the Material.
     * @return instance of Material
     */
    public native Material parse(JSONObject json);

    /**
     * @param textures — object containing any textures used by the material.
     */
    public native void setTextures(Texture[] textures);

}
