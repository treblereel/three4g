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

package org.treblereel.gwt.three4g.demo.client.utils;

import org.treblereel.gwt.resources.api.client.ClientBundle;
import org.treblereel.gwt.resources.api.client.Resource;
import org.treblereel.gwt.resources.api.client.TextResource;
import org.treblereel.gwt.three4g.utils.ScriptInjector;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

@Singleton
@Startup
public class StatsLoader {

    private static final StatsBundle bundle = new StatsLoader_StatsBundleImpl();

    @PostConstruct
    public void init() {
        ScriptInjector.injectScript(bundle.stats());
    }

    @Resource
    public interface StatsBundle extends ClientBundle {

        @Source("stats.js.dat")
        TextResource stats();
    }
}
