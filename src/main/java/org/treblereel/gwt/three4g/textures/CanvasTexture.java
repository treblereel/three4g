package org.treblereel.gwt.three4g.textures;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Bocharov <bdshadow@gmail.com>
 */
@JsType(isNative = true, namespace = "THREE")
public class CanvasTexture extends Texture {

  @JsConstructor
  public CanvasTexture(HTMLElement canvas, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int format, int type, int anisotropy) {

  }

  @JsConstructor
  public CanvasTexture(HTMLElement canvas) {

  }

}
