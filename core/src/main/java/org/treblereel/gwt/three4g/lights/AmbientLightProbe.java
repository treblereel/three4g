package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.AmbientLightProbe", namespace = JsPackage.GLOBAL)
public class AmbientLightProbe extends LightProbe {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static AmbientLightProbe.ConstructorColorUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  public boolean isAmbientLightProbe;

  public AmbientLightProbe() {}

  public AmbientLightProbe(Color color, double intensity) {}

  public AmbientLightProbe(Color color) {}

  public AmbientLightProbe(AmbientLightProbe.ConstructorColorUnionType color, double intensity) {}

  public AmbientLightProbe(AmbientLightProbe.ConstructorColorUnionType color) {}

  public AmbientLightProbe(String color, double intensity) {}

  public AmbientLightProbe(String color) {}

  public AmbientLightProbe(double color, double intensity) {}

  public AmbientLightProbe(double color) {}
}
