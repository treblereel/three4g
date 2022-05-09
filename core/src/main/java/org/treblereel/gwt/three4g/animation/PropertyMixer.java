package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.PropertyMixer", namespace = JsPackage.GLOBAL)
public class PropertyMixer {
  public double binding;
  public double buffer;
  public double cumulativeWeight;
  public double cumulativeWeightAdditive;
  public double referenceCount;
  public double useCount;
  public double valueSize;

  public PropertyMixer(double binding, String typeName, double valueSize) {}

  public native void accumulate(double accuIndex, double weight);

  public native void accumulateAdditive(double weight);

  public native void apply(double accuIndex);

  public native void restoreOriginalState();

  public native void saveOriginalState();
}
