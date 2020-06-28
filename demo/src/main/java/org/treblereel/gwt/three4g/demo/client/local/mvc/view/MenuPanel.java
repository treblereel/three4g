package org.treblereel.gwt.three4g.demo.client.local.mvc.view;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/31/18.
 */
public class MenuPanel extends Attachable {

    HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");

    public MenuPanel() {
        container.id = "RootPanel";
    }

    @Override
    protected void doAttachScene() {

    }

    @Override
    protected void doAttachInfo() {

    }

    public HTMLDivElement asWidget() {
        return container;
    }
}
