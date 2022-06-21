package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import elemental2.core.JsMap;
import elemental2.dom.HTMLCanvasElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.Lut", namespace = JsPackage.GLOBAL)
public class Lut {

    public Lut() {

    }

    public Lut(String colormap) {

    }

    public Lut(String colormap, int numberofcolors) {

    }

    public JsArray<Color> lut;

    public JsArray<JsPropertyMap> map;

    public int n;

    public double minV;

    public double maxV;

    public native Lut set(Lut value);

    public native Lut setMin(double min);

    public native Lut setMax(double max);

    public native Lut setColorMap();

    public native Lut setColorMap(String colormap);

    public native Lut setColorMap(String colormap, int numberofcolors);

    public native Lut copy(Lut lut);

    public native Color getColor(double alpha);

    public native void addColorMap(String colormapName, double[][] arrayOfColors);
    public native HTMLCanvasElement createCanvas();

    public native HTMLCanvasElement updateCanvas(HTMLCanvasElement canvas);
}
