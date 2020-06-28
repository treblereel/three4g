package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.material.WebglMaterialsTexturePartialupdate;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/6/18.
 */
public class WebglMaterialsTexturePartialupdatePresenter implements Presenter {
    @Override
    public void dispatch(HTMLDivElement container) {
        container.appendChild(((Attachable) GWT.create(WebglMaterialsTexturePartialupdate.class)).asWidget());
    }
}
