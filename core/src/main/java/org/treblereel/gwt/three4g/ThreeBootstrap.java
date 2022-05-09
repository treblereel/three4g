package org.treblereel.gwt.three4g;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLScriptElement;
import org.treblereel.gwt.resources.api.client.ClientBundle;
import org.treblereel.gwt.resources.api.client.Resource;
import org.treblereel.gwt.resources.api.client.TextResource;

public class ThreeBootstrap {

    private static final ThreeBootstrap_ThreeJsResourceBundleImpl resource = new ThreeBootstrap_ThreeJsResourceBundleImpl();

    private static boolean loaded = false;

    public static void inject(Runnable fn) {
        if(!loaded) {
            HTMLScriptElement scriptElement = (HTMLScriptElement) DomGlobal.document.createElement("script");
            scriptElement.text = resource.getMinThreeJs().getText();
            scriptElement.type = "text/javascript";
            DomGlobal.document.head.appendChild(scriptElement);
            loaded = true;
        }
        fn.run();
    }

    @Resource
    public interface ThreeJsResourceBundle extends ClientBundle {

        @ClientBundle.Source("three.min")
        TextResource getMinThreeJs();
    }

}
