package org.treblereel.gwt.three4g.examples.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a .obj resource.
 * The OBJ file format is a simple data-format that represents 3D geometry in a human readable format as the position of each vertex, the UV position of each texture coordinate vertex, vertex normals, and the faces that make each polygon defined as a list of vertices, and texture vertices.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class OBJLoader {

    public OBJLoader() {

    }

    public OBJLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url — A string containing the path/URL of the .obj file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .obj file.
     * @param onLoad — A function to be called after the loading is successfully completed. The function receives the loaded Object3D as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .obj file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded Object3D as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .obj file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded Object3D as an argument.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     * @param onError    — A function to be called if an error occurs during loading. The function receives error as an argument.
     */
    public native void load(String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * @param text — The textual obj structure to parse.
     * @return Returns an Object3D. It contains the parsed meshes as Mesh and lines as LineSegments.
     * All geometry is created as BufferGeometry. Default materials are created as MeshPhongMaterial.
     * If an obj object or group uses multiple materials while declaring faces, geometry groups and an array of materials are used.
     */
    public native Object3D parse(String text);

}
