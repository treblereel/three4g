package org.treblereel.gwt.three4g.demo.client.local.utils;

import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/1/18.
 */
public class WebGLRendererProducer {
    private static WebGLRenderer renderer;

    private WebGLRendererProducer() {

    }

    public static WebGLRenderer getRenderer() {
        if (renderer == null) {
            WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
            rendererParameters.antialias = true;
            renderer = new WebGLRenderer(rendererParameters);
        } else {

            renderer.clear();
            //  renderer.forceContextLoss();
        }
        renderer.autoClear = true;
        return renderer;
    }
}
