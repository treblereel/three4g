package org.treblereel.gwt.three4g.demo.client.local.examples.geometry.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/9/18.
 */
public interface GeometryCssClientBundle extends ClientBundle {
    GeometryCssClientBundle IMPL = GWT.create(GeometryCssClientBundle.class);

    @Source("geometryCssClientBundle.css")
    StyleWebglAnimationScene webglAnimationScene();

    interface StyleWebglAnimationScene extends CssResource {
    }

}
