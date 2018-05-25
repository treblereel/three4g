package org.treblereel.gwt.three4g.examples.loaders;

import elemental2.core.ArrayBuffer;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a .prwm resource.
 * Packed Raw WebGL Model is an open-source binary file format for nD geometries specifically designed for JavaScript and WebGL with a strong focus on fast parsing (from 1ms to 0.1ms in Chrome 59 on a MBP Late 2013). The parsing of PRWM file is especially fast when the endianness of the file is the same as the endianness of the client platform. More information on this here https://github.com/kchapelier/PRWM.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PRWMLoader {

    public PRWMLoader() {

    }

    public PRWMLoader(LoadingManager manager) {

    }


    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url — A string containing the path/URL of the .prwm file. Any * character in the URL will be automatically replaced by le or be depending on the platform endianness.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .prwm file. Any * character in the URL will be automatically replaced by le or be depending on the platform endianness.
     * @param onLoad —  A function to be called after the loading is successfully completed. The function receives the loaded BufferGeometry as an argument.
     */
    public native void load(String url, OnLoadCallback<BufferGeometry> onLoad);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .prwm file. Any * character in the URL will be automatically replaced by le or be depending on the platform endianness.
     * @param onLoad     —  A function to be called after the loading is successfully completed. The function receives the loaded BufferGeometry as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The function receives a XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback<BufferGeometry> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .prwm file. Any * character in the URL will be automatically replaced by le or be depending on the platform endianness.
     * @param onLoad     —  A function to be called after the loading is successfully completed. The function receives the loaded BufferGeometry as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The function receives a XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives error as an argument.
     */
    public native void load(String url, OnLoadCallback<BufferGeometry> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Parse a prwm file passed as an ArrayBuffer and directly return an instance of BufferGeometry.
     *
     * @param arrayBuffer — ArrayBuffer containing the prwm data.
     * @return instance of BufferGeometry
     */
    public native BufferGeometry parse(ArrayBuffer arrayBuffer);

    /**
     * @return true if the endianness of the platform is Big Endian, false otherwise.
     */
    public native static boolean isBigEndianPlatform();
}
