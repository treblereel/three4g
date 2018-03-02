package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 2/27/18.
 */
@JsType
@FunctionalInterface
public interface RenderCallback {
    void call(WebGLRenderer renderer, Scene scene, Camera camera, Geometry geometry, Material material, Group group);
}
