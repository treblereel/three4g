package org.treblereel.gwt.three4g.demo.client.local.mvc.view;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;

public class RootPanel extends Attachable {


    HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");

    public RootPanel() {
        container.id = "content";
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
