package org.treblereel.gwt.three4g.loaders;

import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Abstract base class for block based textures loader (dds, pvr, ...). This uses the FileLoader internally for loading files.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
public abstract class CompressedTextureLoader<L, V> extends Loader<L, V> {

    /**
     * Creates a new CompressedTextureLoader.
     */
    public CompressedTextureLoader() {

    }

    /**
     * Creates a new CompressedTextureLoader.
     * @param manager — The loadingManager for the loader to use. Default is THREE.DefaultLoadingManager.
     */
    public CompressedTextureLoader(LoadingManager manager) {

    }
}
