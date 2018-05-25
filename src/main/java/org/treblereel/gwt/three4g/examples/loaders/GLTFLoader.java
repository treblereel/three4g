package org.treblereel.gwt.three4g.examples.loaders;

import com.google.gwt.core.client.JavaScriptObject;
import elemental2.core.ArrayBuffer;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for glTF 2.0 resources.
 * <p>
 * glTF (GL Transmission Format) is an open format specification for efficient delivery and loading of 3D content. Assets may be provided either in JSON (.gltf) or binary (.glb) format. External files store textures (.jpg, .png) and additional binary data (.bin). A glTF asset may deliver one or more scenes, including meshes, materials, textures, skins, skeletons, morph targets, animations, lights, and/or cameras.
 * <p>
 * Extensions
 * GLTFLoader supports the following glTF 2.0 extensions:
 * <p>
 * KHR_draco_mesh_compression
 * KHR_materials_pbrSpecularGlossiness
 * KHR_materials_unlit
 * KHR_lights (experimental)
 * <p>
 * Browser compatibility
 * GLTFLoader relies on ES6 Promises, which are not supported in IE11. To use the loader in IE11, you must include a polyfill providing a Promise replacement.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class GLTFLoader {

    public GLTFLoader() {

    }

    public GLTFLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .gltf or .glb file.
     * @param onLoad — A function to be called after the loading is successfully completed. The function receives the loaded JSON response returned from parse.
     */
    public native void load(String url, OnLoadCallback<JavaScriptObject> onLoad);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .gltf or .glb file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded JSON response returned from parse.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     */
    public native void load(String url, OnLoadCallback<JavaScriptObject> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .gltf or .glb file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded JSON response returned from parse.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     * @param onError    — A function to be called if an error occurs during loading. The function receives error as an argument.
     */
    public native void load(String url, OnLoadCallback<JavaScriptObject> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the base path for additional resources.
     *
     * @param path — Base path for loading additional resources e.g. textures and .bin data.
     */
    public native void setPath(String path);

    /**
     * @param value — The crossOrigin string to implement CORS for loading the url from a different domain that allows CORS.
     */
    public native void setCrossOrigin(String value);

    /**
     * Refer to this readme for the details of Draco and its decoder.
     *
     * @param dracoLoader — Instance of THREE.DRACOLoader, to be used for decoding assets compressed with the KHR_draco_mesh_compression extension.
     */
    public native void setDRACOLoader(DRACOLoader dracoLoader);

    /**
     * Parse a glTF-based ArrayBuffer or JSON String and fire onLoad callback when complete. The argument to onLoad will be an object that contains loaded parts: .scene, .scenes, .cameras, .animations, and .asset.
     *
     * @param data   — glTF asset to parse, as an ArrayBuffer or JSON string.
     * @param path   — The base path from which to find subsequent glTF resources such as textures and .bin data files.
     * @param onLoad — A function to be called when parse completes.
     */
    public native void parse(ArrayBuffer data, String path, OnLoadCallback<JavaScriptObject> onLoad);

    /**
     * Parse a glTF-based ArrayBuffer or JSON String and fire onLoad callback when complete. The argument to onLoad will be an object that contains loaded parts: .scene, .scenes, .cameras, .animations, and .asset.
     *
     * @param data    — glTF asset to parse, as an ArrayBuffer or JSON string.
     * @param path    — The base path from which to find subsequent glTF resources such as textures and .bin data files.
     * @param onLoad  — A function to be called when parse completes.
     * @param onError — A function to be called if an error occurs during parsing. The function receives error as an argument.
     */
    public native void parse(ArrayBuffer data, String path, OnLoadCallback<JavaScriptObject> onLoad, OnErrorCallback onError);
}

