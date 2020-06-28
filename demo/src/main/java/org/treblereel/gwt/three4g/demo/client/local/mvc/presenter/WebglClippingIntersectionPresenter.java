package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.clipping.WebglClippingIntersection;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/11/18.
 */
public class WebglClippingIntersectionPresenter implements Presenter {
    @Override
    public void dispatch(HTMLDivElement container) {
        container.appendChild(((Attachable) GWT.create(WebglClippingIntersection.class)).asWidget());
    }
}

