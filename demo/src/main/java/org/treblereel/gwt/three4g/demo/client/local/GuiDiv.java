package org.treblereel.gwt.three4g.demo.client.local;

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.HTMLDivElement;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/20/18.
 */
public class GuiDiv {

    private HTMLDivElement container = (HTMLDivElement) document.createElement("div");

    GuiDiv() {
        document.body.appendChild(container);
        container.id = "gui_holder";
    }

    public HTMLDivElement get() {
        return container;
    }


}
