package org.treblereel.gwt.three4g.examples.loaders;

import elemental2.core.ArrayBuffer;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a .pcd resource.
 * Point Cloud Data is a file format for Point Cloud Library.
 * Loader support ascii and binary. Compressed binary files are not supported.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PCDLoader {

    public boolean littleEndian;

    public PCDLoader() {

    }

    public PCDLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url — A string containing the path/URL of the .pcd file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .pcd file.
     * @param onLoad — A function to be called after the loading is successfully completed. The function receives the loaded Object3D as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .pcd file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded Object3D as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .pcd file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded Object3D as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     * @param onError    — A function to be called if an error occurs during loading. The function receives error as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Parse an pcd binary structure and return an Object3D.
     * The object is converted to Points with a BufferGeometry and a PointsMaterial.
     *
     * @param data — The binary structure to parse.
     * @param url — The file name or file url.
     * @return instance of Object3D
     */
    public native Object3D parse(ArrayBuffer data, String url);
}
