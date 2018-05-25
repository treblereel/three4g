package org.treblereel.gwt.three4g.examples.loaders;

import com.google.gwt.core.client.JavaScriptObject;
import elemental2.core.ArrayBuffer;
import elemental2.core.Uint8Array;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * A loader for loading a .obj resource.
 * The OBJ file format is a simple data-format that represents 3D geometry in a human redeable format as, the position of each vertex, the UV position of each texture coordinate vertex, vertex normals, and the faces that make each polygon defined as a list of vertices, and texture vertices.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class OBJLoader2 {

    public OBJLoader2() {

    }

    public OBJLoader2(LoadingManager manager) {

    }

    //TODO
/*    public OBJLoader2(LoadingManager manager, LoaderSupport.ConsoleLogger logger) {

    }*/

    /**
     * Use this convenient method to load a file at the given URL. By default the fileLoader uses an ArrayBuffer.
     *
     * @param url    - A string containing the path/URL of the file to be loaded.
     * @param onLoad - A function to be called after loading is successfully completed. The function receives loaded Object3D as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad);

    /**
     * Use this convenient method to load a file at the given URL. By default the fileLoader uses an ArrayBuffer.
     *
     * @param url        - A string containing the path/URL of the file to be loaded.
     * @param onLoad     - A function to be called after loading is successfully completed. The function receives loaded Object3D as an argument.
     * @param onProgress - A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress);

    /**
     * Use this convenient method to load a file at the given URL. By default the fileLoader uses an ArrayBuffer.
     *
     * @param url        - A string containing the path/URL of the file to be loaded.
     * @param onLoad     - A function to be called after loading is successfully completed. The function receives loaded Object3D as an argument.
     * @param onProgress - A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    - A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Use this convenient method to load a file at the given URL. By default the fileLoader uses an ArrayBuffer.
     *
     * @param url         - A string containing the path/URL of the file to be loaded.
     * @param onLoad      - A function to be called after loading is successfully completed. The function receives loaded Object3D as an argument.
     * @param onProgress  - A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError     - A function to be called if an error occurs during loading. The function receives the error as an argument.
     * @param onMeshAlter - A function to be called after a new mesh raw data becomes available for alteration.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress, OnErrorCallback onError, OnMeshAlter onMeshAlter);

    /**
     * Use this convenient method to load a file at the given URL. By default the fileLoader uses an ArrayBuffer.
     *
     * @param url         - A string containing the path/URL of the file to be loaded.
     * @param onLoad      - A function to be called after loading is successfully completed. The function receives loaded Object3D as an argument.
     * @param onProgress  - A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError     - A function to be called if an error occurs during loading. The function receives the error as an argument.
     * @param onMeshAlter - A function to be called after a new mesh raw data becomes available for alteration.
     * @param useAsync    - If true, uses async loading with worker, if false loads data synchronously.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress, OnErrorCallback onError, OnMeshAlter onMeshAlter, boolean useAsync);


    /**
     * Parses OBJ data synchronously from arraybuffer or string and returns the loaderRoorNode.
     *
     * @param content as ArrayBuffer
     * @return instance of Object3D
     */
    public native Object3D parse(ArrayBuffer content);

    /**
     * Parses OBJ data synchronously from arraybuffer or string and returns the loaderRoorNode.
     *
     * @param content as Uint8Array
     * @return instance of Object3D
     */
    public native Object3D parse(Uint8Array content);

    /**
     * Parses OBJ data synchronously from arraybuffer or string and returns the loaderRoorNode.
     *
     * @param content as String
     * @return instance of Object3D
     */
    public native Object3D parse(String content);

    /**
     * Parses OBJ content asynchronously from arraybuffer.
     *
     * @param content - OBJ data as Uint8Array
     * @param onLoad  - Called after worker successfully completed loading
     * @return instance of Object3D
     */
    public native Object3D parseAsync(Uint8Array content, OnLoadCallback<JavaScriptObject> onLoad);

    //TODO
/*    .run ( params : LoaderSupport.PrepData, workerSupportExternal : LoaderSupport.WorkerSupport ) : null
    params - prepData All parameters and resources required for execution
    workerSupportExternal - Use pre-existing WorkerSupport

    Run the loader according the provided instructions.*/

    /**
     * Enable or disable logging in general (except warn and error), plus enable or disable debug logging.
     *
     * @param enabled True or false.
     * @param debug   True or false.
     */
    public native void setLogging(boolean enabled, boolean debug);

    /**
     * Set the name of the model.
     *
     * @param modelName modelName
     */
    public native void setModelName(String modelName);

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     *
     * @param path - URL
     */
    public native void setPath(String path);

    /**
     * Set the node where the loaded objects will be attached directly.
     *
     * @param streamMeshesTo - Object already attached to scenegraph where new meshes will be attached to
     */
    public native void setStreamMeshesTo(Object3D streamMeshesTo);

    /**
     * Set materials loaded by MTLLoader or any other supplier of an Array of Materials.
     *
     * @param materials Array of materials - Array of Materials
     */
    public native void setMaterials(Material... materials);

    /**
     * @param useIndices Instructs loaders to create indexed BufferGeometry.
     */
    public native void setUseIndices(boolean useIndices);

    /**
     * Tells whether normals should be completely disregarded and regenerated.
     *
     * @param disregardNormals set true, to disregardNormals
     */
    public native void setDisregardNormals(boolean disregardNormals);

    /**
     * Tells whether a material shall be created per smoothing group.
     *
     * @param materialPerSmoothingGroup true to set
     */
    public native void setMaterialPerSmoothingGroup(boolean materialPerSmoothingGroup);

    /**
     * Announce feedback which is give to the registered LoaderSupport.Callbacks.
     *
     * @param type           - The type of event
     * @param text           - Textual description of the event
     * @param numericalValue - Numerical value describing the progress
     */
    public native void onProgress(String type, String text, Number numericalValue);

    /**
     * Utility method for loading an mtl file according resource description. Provide url or content..
     *
     * @param url            - URL to the file
     * @param content        - The file content as arraybuffer or text
     * @param callbackOnLoad - Callback to be called after successful load
     */
    public native void loadMtl(String url, ArrayBuffer content, OnLoadCallback<Object3D> callbackOnLoad);

    /**
     * Utility method for loading an mtl file according resource description. Provide url or content..
     *
     * @param url            - URL to the file
     * @param content        - The file content as arraybuffer or text
     * @param callbackOnLoad - Callback to be called after successful load
     * @param crossOrigin    - (optional) CORS value
     */
    public native void loadMtl(String url, ArrayBuffer content, OnLoadCallback<Object3D> callbackOnLoad, String crossOrigin);

    /**
     * Utility method for loading an mtl file according resource description. Provide url or content..
     *
     * @param url            - URL to the file
     * @param content        - The file content as arraybuffer or text
     * @param callbackOnLoad - Callback to be called after successful load
     */
    public native void loadMtl(String url, String content, OnLoadCallback<Object3D> callbackOnLoad);

    /**
     * Utility method for loading an mtl file according resource description. Provide url or content..
     *
     * @param url            - URL to the file
     * @param content        - The file content as arraybuffer or text
     * @param callbackOnLoad - Callback to be called after successful load
     * @param crossOrigin    - (optional) CORS value
     */
    public native void loadMtl(String url, String content, OnLoadCallback<Object3D> callbackOnLoad, String crossOrigin);

}
