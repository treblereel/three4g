/*
 * Copyright © 2022 Treblereel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.treblereel.gwt.three4g.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLHeadElement;
import elemental2.dom.HTMLScriptElement;
import elemental2.dom.HTMLStyleElement;
import org.treblereel.gwt.resources.api.client.TextResource;

public class ScriptInjector {

    public static void injectScript(TextResource script) {
        HTMLScriptElement scriptElement = (HTMLScriptElement) DomGlobal.document.createElement("script");
        scriptElement.text = script.getText();
        scriptElement.type = "text/javascript";
        DomGlobal.document.head.appendChild(scriptElement);
    }

    public static void injectStyleSheet(TextResource contents) {
        HTMLStyleElement style = (HTMLStyleElement) DomGlobal.document.createElement("style");
        style.textContent = contents.getText();
        style.setAttribute("language", "text/css");
        getHead().appendChild(style);
    }

    private static HTMLHeadElement head;
    private static HTMLHeadElement getHead() {
        if (head == null) {
            HTMLHeadElement elt = DomGlobal.document.head;

            assert elt != null : "The host HTML page does not have a <head> element which is required by StyleInjector";

            head = elt;
        }

        return head;
    }
}
