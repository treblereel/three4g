package org.treblereel.gwt.three4g.examples.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class PDB {

    public BufferGeometry geometryAtoms;

    public BufferGeometry geometryBonds;

    public String JSON;
}
