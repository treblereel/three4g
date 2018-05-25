package org.treblereel.gwt.three4g.examples.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a .pdb resource.
 * The Protein Data Bank file format is a textual file describing the three-dimensional structures of molecules.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PDBLoader {


    public PDBLoader() {

    }

    public PDBLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url — A string containing the path/URL of the .pdb file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .pdb file.
     * @param onLoad —  A function to be called after loading is successfully completed. The function receives the object having the following properties. geometryAtoms, geometryBonds and the JSON structure.
     */
    public native void load(String url, OnLoadCallback<PDB> onLoad);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .pdb file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the object having the following properties. geometryAtoms, geometryBonds and the JSON structure.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback<PDB> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .pdb file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the object having the following properties. geometryAtoms, geometryBonds and the JSON structure.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback<PDB> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * @param text — The textual pdb structure to parse.
     * @return a PDB //TODO check the result
     */
    public native PDB parse(String text);

}
