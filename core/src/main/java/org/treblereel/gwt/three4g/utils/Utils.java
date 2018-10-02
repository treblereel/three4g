package org.treblereel.gwt.three4g.utils;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/1/18.
 */
public class Utils {

    public static void injectJavaScript(TextResource textResource) {
        ScriptInjector.fromString(textResource.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();

    }
}
