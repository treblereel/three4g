package org.treblereel.gwt.three4g;

import com.google.gwt.core.client.EntryPoint;
import org.treblereel.gwt.three4g.resources.ThreeJsTextResource;
import org.treblereel.gwt.three4g.utils.Utils;

class Three4GMin implements EntryPoint {
    @Override
    public void onModuleLoad() {
        Utils.injectJavaScript(ThreeJsTextResource.IMPL.getThreeJSMin());
    }
}
