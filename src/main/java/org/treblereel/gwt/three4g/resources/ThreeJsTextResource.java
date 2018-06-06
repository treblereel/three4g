package org.treblereel.gwt.three4g.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/26/18.
 */
public interface ThreeJsTextResource extends ClientBundle{

    ThreeJsTextResource IMPL = GWT.create(ThreeJsTextResource.class);

    @Source("js/three.js")
    TextResource getThreeJS();

    @Source("js/three.min.js")
    TextResource getThreeJSMin();
}
