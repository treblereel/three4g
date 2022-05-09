package org.treblereel.gwt.three4g.textures;

import elemental2.dom.HTMLVideoElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.VideoTexture", namespace = JsPackage.GLOBAL)
public class VideoTexture extends Texture {
  public boolean generateMipmaps;
  public boolean isVideoTexture;

  public VideoTexture(
      HTMLVideoElement video,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public VideoTexture(
      HTMLVideoElement video,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public VideoTexture(
      HTMLVideoElement video,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public VideoTexture(
      HTMLVideoElement video,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public VideoTexture(
      HTMLVideoElement video, double mapping, double wrapS, double wrapT, double magFilter) {}

  public VideoTexture(HTMLVideoElement video, double mapping, double wrapS, double wrapT) {}

  public VideoTexture(HTMLVideoElement video, double mapping, double wrapS) {}

  public VideoTexture(HTMLVideoElement video, double mapping) {}

  public VideoTexture(HTMLVideoElement video) {}
}
