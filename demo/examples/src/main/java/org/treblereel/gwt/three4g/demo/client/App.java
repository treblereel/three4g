/*
 * Copyright © 2020 Treblereel
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

package org.treblereel.gwt.three4g.demo.client;

import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import io.crysknife.annotation.Application;
import org.treblereel.gwt.lilgui4g.LilGuiBootstrap;
import org.treblereel.gwt.three4g.ThreeBootstrap;
import org.treblereel.gwt.three4g.ThreeExtrasBootstrap;
import org.treblereel.j2cl.processors.annotations.GWT3EntryPoint;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Application
public class App {
    @Inject
    private Main main;

    @GWT3EntryPoint
    public void onModuleLoad() {
        ThreeBootstrap.inject(() -> new ThreeExtrasBootstrap().injectAll(() -> LilGuiBootstrap.inject(() -> onReady())));
    }

    private void onReady() {
        new AppBootstrap(this).initialize();
    }


    @PostConstruct
    public void init() {
        DomGlobal.document.body.appendChild(main.getElement());
        resizeSideBar();
        DomGlobal.window.addEventListener("resize", evt -> resizeSideBar());
    }


    private void resizeSideBar() {
        HTMLElement sidebar = (HTMLElement) DomGlobal.document.getElementsByClassName("active").item(0);
        double size = DomGlobal.document.body.clientHeight;
        sidebar.style.height = CSSProperties.HeightUnionType.of(size * 0.6 + "px");
    }
}
