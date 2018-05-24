package org.treblereel.gwt.three4g;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import org.treblereel.gwt.three4g.resources.ThreeJsTextResource;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/26/18.
 */
public class Three4G implements EntryPoint {

    @Override
    public void onModuleLoad() {
        load();
    }

    public static void load() {
        ScriptInjector.fromString(ThreeJsTextResource.IMPL.getThreeJS().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

    }

}
