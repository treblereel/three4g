package org.treblereel.gwt.three4g.loaders.managers;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
public interface OnProgress {
    void onProgress(String url, int itemsLoaded, int itemsTotal);
}
