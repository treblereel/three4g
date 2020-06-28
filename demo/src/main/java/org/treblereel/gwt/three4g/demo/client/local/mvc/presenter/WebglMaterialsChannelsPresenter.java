package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.material.WebglMaterialsChannels;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/26/18.
 */
public class WebglMaterialsChannelsPresenter implements Presenter {
    @Override
    public void dispatch(HTMLDivElement container) {
        container.appendChild(((Attachable) GWT.create(WebglMaterialsChannels.class)).asWidget());
    }
}
