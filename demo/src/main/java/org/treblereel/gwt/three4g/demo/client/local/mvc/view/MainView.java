package org.treblereel.gwt.three4g.demo.client.local.mvc.view;

import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;


/**
 * Created by treblereel on 6/14/16.
 */
public class MainView extends Attachable {


    public MainView() {
        root.textContent = "MainView2";
    }

    @Override
    protected void doAttachScene() {

    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }
}
