package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Class for loading a font in JSON format. Returns a Font, which is an array of Shapes representing the font. This uses the FileLoader internally for loading files.
 * <p>
 * You can convert fonts online using facetype.js
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class FontLoader extends Loader<ImageBitmapLoader, Font> {

    @JsConstructor
    public FontLoader() {

    }

    @JsConstructor
    public FontLoader(LoadingManager manager) {

    }
}
