package org.treblereel.gwt.three4g;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import org.treblereel.gwt.three4g.resources.ThreeJsTextResource;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/11/18.
 */
public class Three4GMin implements EntryPoint {

    @Override
    public void onModuleLoad() {
        load();
    }

    private static void load() {
        ScriptInjector.fromString(ThreeJsTextResource.IMPL.getThreeJSMin().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();

    }

}
