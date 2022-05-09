package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.propertybinding.Composite;
import org.treblereel.gwt.three4g.propertybinding.ParseTrackNameResults;

@JsType(isNative = true, name = "THREE.PropertyBinding", namespace = JsPackage.GLOBAL)
public class PropertyBinding {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface CreateUnionType {
    @JsOverlay
    static PropertyBinding.CreateUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Composite asComposite() {
      return Js.cast(this);
    }

    @JsOverlay
    default PropertyBinding asPropertyBinding() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isComposite() {
      return (Object) this instanceof Composite;
    }

    @JsOverlay
    default boolean isPropertyBinding() {
      return (Object) this instanceof PropertyBinding;
    }
  }

  @JsFunction
  public interface GetterByBindingTypeFn {
    void onInvoke();
  }

  @JsFunction
  public interface SetterByBindingTypeAndVersioningFn {
    void onInvoke();
  }

  public static native PropertyBinding.CreateUnionType create(
      double root, double path, JsObject parsedPath);

  @JsOverlay
  public static final PropertyBinding.CreateUnionType create(
      double root, double path, Object parsedPath) {
    return create(root, path, Js.<JsObject>uncheckedCast(parsedPath));
  }

  public static native PropertyBinding.CreateUnionType create(double root, double path);

  public static native double findNode(double root, String nodeName);

  public static native ParseTrackNameResults parseTrackName(String trackName);

  public static native String sanitizeNodeName(String name);

  public JsPropertyMap<Double> BindingType;
  public JsArray<PropertyBinding.GetterByBindingTypeFn> GetterByBindingType;
  public JsArray<JsArray<PropertyBinding.SetterByBindingTypeAndVersioningFn>>
      SetterByBindingTypeAndVersioning;
  public JsPropertyMap<Double> Versioning;
  public double node;
  public double parsedPath;
  public String path;
  public double rootNode;

  public PropertyBinding(double rootNode, String path, JsObject parsedPath) {}

  public PropertyBinding(double rootNode, String path, Object parsedPath) {}

  public PropertyBinding(double rootNode, String path) {}

  public native void bind();

  public native double getValue(double targetArray, double offset);

  public native void setValue(double sourceArray, double offset);

  public native void unbind();
}
