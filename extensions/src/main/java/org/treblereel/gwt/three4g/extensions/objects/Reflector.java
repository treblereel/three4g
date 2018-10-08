package org.treblereel.gwt.three4g.extensions.objects;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.extensions.objects.parameters.ReflectorParameters;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/14/18.
 */
@Three4gElement(paths = "js/objects/Reflector.js")
@JsType(isNative = true, namespace = "THREE")
public class Reflector extends Mesh {

    public String type;

    public Material material;

    public Reflector(AbstractGeometry geometry){

    }

    public Reflector(AbstractGeometry geometry, ReflectorParameters params){

    }

}
