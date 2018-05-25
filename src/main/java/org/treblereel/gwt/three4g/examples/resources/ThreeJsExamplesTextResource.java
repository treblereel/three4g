package org.treblereel.gwt.three4g.examples.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/26/18.
 */
public interface ThreeJsExamplesTextResource extends ClientBundle{

    ThreeJsExamplesTextResource IMPL = GWT.create(ThreeJsExamplesTextResource.class);

    @Source("js/OrbitControls.js")
    TextResource getThreeOrbitControlsJS();

    @Source("js/DecalGeometry.js")
    TextResource getThreeDecalGeometryJS();

    @Source("js/ConvexGeometry.js")
    TextResource getThreeConvexGeometryJS();

    @Source("js/SceneUtils.js")
    TextResource getThreeSceneUtilsJS();

    @Source("js/BufferGeometryUtils.js")
    TextResource getThreeBufferGeometryUtilsJS();

    @Source("js/CSS2DRenderer.js")
    TextResource getThreeCSS2DRendererJS();

    @Source("js/CSS3DRenderer.js")
    TextResource getThreeCSS3DRendererJS();

    @Source("js/SVGRenderer.js")
    TextResource getThreeSVGRendererJS();



}
