package org.treblereel.gwt.three4g;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLScriptElement;

public class ThreeBootstrap {

    private static final String THREE_URL = "https://static.treblereel.org/files/three.min.js";


    public static void onLoad(Element.OnloadFn fn) {
        HTMLScriptElement scriptElement = (HTMLScriptElement) DomGlobal.document.createElement("script");
        scriptElement.src = THREE_URL;
        scriptElement.type = "text/javascript";
        scriptElement.async = true;
        scriptElement.onload = fn;
        DomGlobal.document.head.appendChild(scriptElement);
    }

}
