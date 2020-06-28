package org.treblereel.gwt.three4g.demo.client.local.examples.gui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import java.util.Map;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/14/17.
 */
public class Utils {

    public static JavaScriptObject toJavaScriptObject(Map<String, Object> map) {
        JSONObject entity = new JSONObject();
        map.forEach((k, v) -> {
            if (v instanceof Boolean) {
                entity.put(k, JSONBoolean.getInstance((Boolean) v));
            } else if (v instanceof String) {
                entity.put(k, new JSONString((String) v));
            } else if (v instanceof Double) {
                entity.put(k, new JSONNumber((Double) v));
            } else if (v instanceof Integer) {
                entity.put(k, new JSONNumber((Integer) v));
            } else if (v instanceof Float) {
                entity.put(k, new JSONNumber((Float) v));
            }
        });
        return entity.getJavaScriptObject();
    }
}
