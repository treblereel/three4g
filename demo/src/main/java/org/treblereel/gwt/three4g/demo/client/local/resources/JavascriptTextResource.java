package org.treblereel.gwt.three4g.demo.client.local.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/26/18.
 */
public interface JavascriptTextResource extends ClientBundle {

    JavascriptTextResource IMPL = GWT.create(JavascriptTextResource.class);

    @Source("js/CurveExtras.js")
    TextResource getCurveExtras();

    @Source("js/ParametricGeometries.js")
    TextResource getParametricGeometries();

    @Source("js/GPUComputationRenderer.js")
    TextResource getGPUComputationRenderer();

    @Source("js/birdGeometry.js")
    TextResource getBirdGeometry();

    @Source("js/stats.min.js")
    TextResource getStatsMin();

    @Source("js/RollerCoaster.js")
    TextResource getRollercoaster();

    @Source("js/PaintViveController.js")
    TextResource getPaintViveController();

    @Source("js/MarchingCubes.js")
    TextResource getMarchingCubes();

    @Source("js/Tween.js")
    TextResource getTWEEN();

    @Source("js/ShaderSkin.js")
    TextResource getShaderSkin();

    @Source("js/CopyShader.js")
    TextResource getCopyShader();

    @Source("js/EffectComposer.js")
    TextResource getEffectComposer();

    @Source("js/RenderPass.js")
    TextResource getRenderPass();

    @Source("js/ShaderPass.js")
    TextResource getShaderPass();

    @Source("js/MaskPass.js")
    TextResource getMaskPass();

    @Source("js/ImprovedNoise.js")
    TextResource getImprovedNoise();

    @Source("js/TeapotBufferGeometry.js")
    TextResource getTeapotBufferGeometry();

}
