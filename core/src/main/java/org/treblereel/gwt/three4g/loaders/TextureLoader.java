package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * Class for loading a texture. This uses the ImageLoader internally for loading files.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/5/18.
 */
@JsType(isNative = true, name = "THREE.TextureLoader", namespace = JsPackage.GLOBAL)
public class TextureLoader extends Loader<TextureLoader, Texture> {

    /**
     * Creates a new TextureLoader.
     */
    public TextureLoader() {

    }

    /**
     * Creates a new TextureLoader.
     * @param manager — The loadingManager for the loader to use. Default is DefaultLoadingManager.
     */
    public TextureLoader(LoadingManager manager) {

    }
}
