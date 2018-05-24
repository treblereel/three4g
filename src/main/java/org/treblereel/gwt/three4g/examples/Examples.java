package org.treblereel.gwt.three4g.examples;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import org.treblereel.gwt.three4g.examples.resources.ThreeJsExamplesTextResource;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/26/18.
 */
public class Examples implements EntryPoint {

    @Override
    public void onModuleLoad() {
        load();
    }

    public static void load() {
        ScriptInjector.fromString(ThreeJsExamplesTextResource.IMPL.getThreeOrbitControlsJS().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();


/*        try {
            if (new OrbitControls(null) == null) {
                GWT.log("it is a null");
            }
        } catch (JavaScriptException e) {
            loadJavaScript(JavascriptTextResource.IMPL.getOrbitControls().getText());
        }*/

    }


}
