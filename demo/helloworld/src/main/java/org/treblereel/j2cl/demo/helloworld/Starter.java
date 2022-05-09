package org.treblereel.j2cl.demo.helloworld;


import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.j2cl.processors.annotations.GWT3EntryPoint;

public class Starter {

    private static final String THREE_URL = "https://static.treblereel.org/files/three.min.js";

    @GWT3EntryPoint
    public void onModuleLoad() {
        HTMLScriptElement scriptElement = (HTMLScriptElement) DomGlobal.document.createElement("script");
        scriptElement.src = THREE_URL;
        scriptElement.type = "text/javascript";
        scriptElement.async = true;
        scriptElement.onload = onload -> new Demo();

        DomGlobal.document.head.appendChild(scriptElement);
    }
}
