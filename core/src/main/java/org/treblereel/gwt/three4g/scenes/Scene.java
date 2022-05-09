package org.treblereel.gwt.three4g.scenes;

import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.Scene", namespace = JsPackage.GLOBAL)
public class Scene extends Object3D {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface BackgroundUnionType {
    @JsOverlay
    static Scene.BackgroundUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default Texture asTexture() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isTexture() {
      return (Object) this instanceof Texture;
    }
  }

  @JsFunction
  public interface OnAfterRenderFn {
    void onInvoke(WebGLRenderer p0, Scene p1, Camera p2);
  }

  @JsFunction
  public interface OnBeforeRenderFn {
    void onInvoke(WebGLRenderer p0, Scene p1, Camera p2, JsObject p3);

    @JsOverlay
    default void onInvoke(WebGLRenderer p0, Scene p1, Camera p2, Object p3) {
      onInvoke(p0, p1, p2, Js.<JsObject>uncheckedCast(p3));
    }
  }

  public boolean autoUpdate;
  public Scene.BackgroundUnionType background;
  public Texture environment;
  public FogBase fog;
  public boolean isScene;
  public Scene.OnAfterRenderFn onAfterRender;
  public Scene.OnBeforeRenderFn onBeforeRender;
  public Material overrideMaterial;
  public String type;

  public native Object toJSON();

  public native Object toJSON(String key);
}
