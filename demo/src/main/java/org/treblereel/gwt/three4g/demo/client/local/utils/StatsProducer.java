package org.treblereel.gwt.three4g.demo.client.local.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.api.Stats;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/1/18.
 */
public class StatsProducer {
    private static Stats stats;

    private StatsProducer() {

    }

    public static Stats getStats() {
        if (stats == null) {
            Attachable.loadJavaScript(JavascriptTextResource.IMPL.getStatsMin().getText());
            stats = new Stats();
            HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");
            stats.dom.style.position = "inherit";
            container.style.bottom = "0";
            container.style.right = "0";
            container.appendChild(stats.dom);

            DomGlobal.document.body.appendChild(container);

        }
        return stats;
    }

}
