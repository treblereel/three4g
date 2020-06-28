package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.material.Webgl2MaterialsTexture2darray;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
public class Webgl2MaterialsTexture2darrayPresenter implements Presenter {
    @Override
    public void dispatch(HTMLDivElement container) {
        container.appendChild(((Attachable) GWT.create(Webgl2MaterialsTexture2darray.class)).asWidget());
    }

}
