package org.treblereel.gwt.three4g.demo.client.local;

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/20/18.
 */

public class InfoDiv {

    private HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");
    private HTMLAnchorElement info = (HTMLAnchorElement) DomGlobal.document.createElement("a");
    private HTMLElement text = (HTMLElement) DomGlobal.document.createElement("span");

    public InfoDiv() {
        container.id = "info";
        container.style.display = "none";
        container.appendChild(info);
        container.style.color = "white";


        info.href = "http://threejs.org";
        info.target = "_blank";
        info.rel = "noopener";
        info.textContent = "three.js";
        info.style.color = "blue";

        container.appendChild(text);
        document.body.appendChild(container);
    }

    public InfoDiv setHrefToInfo(String t) {
        info.href = t;
        return this;
    }

    public InfoDiv setTextContentToInfo(String t) {
        info.textContent = t;
        return this;
    }

    public InfoDiv setTextToDesc(String textContent) {
        text.textContent = textContent;
        return this;
    }

    public InfoDiv setInnetHtml(String innerHTML) {
        text.innerHTML = innerHTML;
        return this;
    }

    public InfoDiv addElement(HTMLElement elm) {
        container.appendChild(elm);
        return this;
    }

    public InfoDiv removeElement(HTMLElement elm) {
        container.removeChild(elm);
        return this;
    }

    public InfoDiv hide() {
        container.style.display = "none";
        return this;
    }

    public InfoDiv show() {
        container.style.display = "block";
        return this;
    }
}
