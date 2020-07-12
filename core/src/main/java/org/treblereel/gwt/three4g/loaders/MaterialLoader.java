package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A loader for loading a Material in JSON format. This uses the FileLoader internally for loading files.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MaterialLoader extends Loader<MaterialLoader, Material> {

    /**
     * Object holding any textures used by the material. See .setTextures.
     */
    public Texture[] texture; //TODO check it

    @JsConstructor
    public MaterialLoader() {

    }

    @JsConstructor
    public MaterialLoader(LoadingManager loadingManager) {

    }

    /**
     * @param textures — object containing any textures used by the material.
     * @return instance of MaterialLoader
     */
    public native MaterialLoader setTextures(Texture[] textures);

}
