package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.mvc.view.MainView;


public class MainPresenter implements Presenter {

    private Attachable display = GWT.create(MainView.class);

    @Override
    public void dispatch(HTMLDivElement container) {
        container.appendChild(display.asWidget());
    }
}
