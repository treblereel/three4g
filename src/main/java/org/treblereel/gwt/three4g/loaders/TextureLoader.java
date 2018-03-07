package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/5/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TextureLoader {


    @JsConstructor
    public TextureLoader(){

    }

    public native Texture load(String url );

    public native Texture load( String url, LoadCallback<Texture> onLoad, ProgressCallback onProgress, ErrorCallback onError );
}
