package org.treblereel.gwt.three4g;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;

import java.util.logging.Level;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/26/18.
 */
public class Three implements EntryPoint {
    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry point.
     */
    @Override
    public void onModuleLoad() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Three.class.getSimpleName());

/*        ScriptInjector.fromUrl("js/three.js").setCallback(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                logger.log(Level.WARNING," unable to load three.js " + reason.getMessage());
            }

            @Override
            public void onSuccess(Void result) {
                logger.log(Level.SEVERE," three.js loaded successfully");

            }
        }).inject();*/
    }
}
