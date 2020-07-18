package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Abstract base class to load generic binary textures formats (rgbe, hdr, ...).
 * This uses the FileLoader internally for loading files, and creates a new DataTexture.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
public abstract class DataTextureLoader<L extends DataTextureLoader, V> extends Loader<L, V> {

    /**
     * Creates a new CompressedTextureLoader.
     */
    public DataTextureLoader() {
        this(null);
    }

    /**
     * Creates a new CompressedTextureLoader.
     * @param manager — The loadingManager for the loader to use. Default is THREE.DefaultLoadingManager.
     */
    @JsConstructor
    public DataTextureLoader(LoadingManager manager) {

    }
}
