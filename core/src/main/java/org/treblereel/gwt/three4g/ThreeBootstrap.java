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

package org.treblereel.gwt.three4g;

import org.treblereel.gwt.resources.api.client.ClientBundle;
import org.treblereel.gwt.resources.api.client.Resource;
import org.treblereel.gwt.resources.api.client.TextResource;
import org.treblereel.gwt.three4g.utils.ScriptInjector;

public class ThreeBootstrap {

    private static final ThreeBootstrap_ThreeJsResourceBundleImpl resource = new ThreeBootstrap_ThreeJsResourceBundleImpl();

    private static boolean loaded = false;

    public static void inject(Runnable fn) {
        if(!loaded) {
            ScriptInjector.injectScript(resource.getMinThreeJs());
            loaded = true;
        }
        fn.run();
    }

    @Resource
    public interface ThreeJsResourceBundle extends ClientBundle {

        @ClientBundle.Source("three.min")
        TextResource getMinThreeJs();
    }

}
