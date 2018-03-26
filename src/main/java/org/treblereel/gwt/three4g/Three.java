package org.treblereel.gwt.three4g;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import org.treblereel.gwt.three4g.js.ThreeJsTextResource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/26/18.
 */
public class Three implements EntryPoint {

    @Override
    public void onModuleLoad() {
        loadThreeJS();
    }

    public static void loadThreeJS(){
        load("three.js");
    }

    public static void loadThreeJSMin(){
        load("three.min.js");
    }

    private static void load(String scriptName) {
        ScriptInjector.fromString(ThreeJsTextResource.IMPL.getThreeJS().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

    }

}
