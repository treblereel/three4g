package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsFunction;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/7/18.
 */
@JsFunction
@FunctionalInterface
public interface RenderCallback {
    void onEvent(WebGLRenderer renderer, Scene scene, Camera camera, AbstractGeometry geometry, Material material, Group group);
}
