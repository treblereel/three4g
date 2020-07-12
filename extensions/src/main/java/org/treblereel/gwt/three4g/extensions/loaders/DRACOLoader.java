package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@Three4gElement(paths = "js/loaders/DRACOLoader.js")
@JsType(isNative = true, namespace = "THREE")
public class DRACOLoader {

    public DRACOLoader() {

    }

    public native void setDecoderPath(String path);

    public native void setDecoderConfig(DRACOLoaderDecoderConfig config);

    public native void load(String url, OnLoadCallback<? extends PropertyHolder> onLoad);

    public native void load(String url, OnLoadCallback<? extends PropertyHolder> onLoad, OnProgressCallback onProgress);

    public native void load(String url, OnLoadCallback<? extends PropertyHolder> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    public static native void releaseDecoderModule();

    /**
     * Set the base path for additional resources.
     *
     * @param path — Base path for loading additional resources e.g. textures and .bin data.
     * @return instance of DRACOLoader
     */
    public native DRACOLoader setPath(String path);

}
