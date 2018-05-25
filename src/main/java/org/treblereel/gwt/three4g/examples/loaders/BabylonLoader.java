package org.treblereel.gwt.three4g.examples.loaders;

import com.google.gwt.json.client.JSONObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a .babylon resource.
 * The .babylon file format used by Babylon.js.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BabylonLoader {

    public BabylonLoader() {

    }

    public BabylonLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url — A string containing the path/URL of the .babylon file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .babylon file.
     * @param onLoad — A function to be called after loading is successfully completed. The function receives the loaded Object3D as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .babylon file.
     * @param onLoad     — A function to be called after loading is successfully completed. The function receives the loaded Object3D as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .babylon file.
     * @param onLoad     — A function to be called after loading is successfully completed. The function receives the loaded Object3D as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    — A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Parse a JSON structure and return an object or a scene.
     * <p>
     * Found objects are converted to Mesh with a BufferGeometry and a default MeshPhongMaterial.
     * Lights are parsed accordingly.
     *
     * @param json — The JSON structure to parse.
     * @return instance of Object3D
     */
    public native Object3D parse(JSONObject json);

}
