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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ThreeExtrasBootstrap {

    private static final ThreeJsResourceBundle resource = new ThreeExtrasBootstrap_ThreeJsResourceBundleImpl();

    private static final Map<String, Bucket> holder = new HashMap<>();

    static {
        holder.put("RoomEnvironment", new Bucket(resource.RoomEnvironment()));
        holder.put("DRACOLoader", new Bucket(resource.RoomEnvironment()));
        holder.put("GLTFLoader", new Bucket(resource.GLTFLoader()));
        holder.put("DRACOLoader", new Bucket(resource.DRACOLoader()));
        holder.put("OrbitControls", new Bucket(resource.OrbitControls()));
        holder.put("SkeletonUtils", new Bucket(resource.SkeletonUtils()));
        //holder.put("BokehShader", new Bucket(resource.BokehShader()));
        holder.put("BokehShader2", new Bucket(resource.BokehShader2()));
        holder.put("CinematicCamera", new Bucket(resource.CinematicCamera()));
        holder.put("FontLoader", new Bucket(resource.FontLoader()));
        holder.put("TextGeometry", new Bucket(resource.TextGeometry()));
        holder.put("DecalGeometry", new Bucket(resource.DecalGeometry()));
        holder.put("AnaglyphEffect", new Bucket(resource.AnaglyphEffect()));
        holder.put("AsciiEffect", new Bucket(resource.AsciiEffect()));
        holder.put("TrackballControls", new Bucket(resource.TrackballControls()));
        holder.put("ParallaxBarrierEffect", new Bucket(resource.ParallaxBarrierEffect()));
        holder.put("PeppersGhostEffect", new Bucket(resource.PeppersGhostEffect()));
    }


    public static void injectAll(Runnable fn) {
        Set<Map.Entry<String, Bucket>> set = holder.entrySet();
        Iterator<Map.Entry<String, Bucket>> iter = set.iterator();
        Holder<Map.Entry<String, Bucket>> current = new Holder<>(iter.next());
        while(current.value != null) {
            inject(current.value.getKey(), () -> {
                if(iter.hasNext()) {
                    current.value = iter.next();
                }   else {
                    current.value = null;
                }
            });
        }
        fn.run();
    }

    public static void inject(String clazz, Runnable fn) {
        Bucket bucket = holder.get(clazz);
        if(!bucket.loaded) {
            org.treblereel.gwt.three4g.utils.ScriptInjector.injectScript(bucket.resource);
            bucket.loaded = true;
        }
        fn.run();
    }

    @Resource
    public interface ThreeJsResourceBundle extends ClientBundle {

        @ClientBundle.Source("js/environments/RoomEnvironment.js")
        TextResource RoomEnvironment();

        @ClientBundle.Source("js/loaders/DRACOLoader.js")
        TextResource DRACOLoader();

        @ClientBundle.Source("js/loaders/GLTFLoader.js")
        TextResource GLTFLoader();

        @ClientBundle.Source("js/controls/OrbitControls.js")
        TextResource OrbitControls();

        @ClientBundle.Source("js/utils/SkeletonUtils.js")
        TextResource SkeletonUtils();
        @ClientBundle.Source("js/cameras/CinematicCamera.js")
        TextResource CinematicCamera();

        @ClientBundle.Source("js/shaders/BokehShader.js")
        TextResource BokehShader();
        @ClientBundle.Source("js/shaders/BokehShader2.js")
        TextResource BokehShader2();

        @ClientBundle.Source("js/loaders/FontLoader.js")
        TextResource FontLoader();

        @ClientBundle.Source("js/geometries/TextGeometry.js")
        TextResource TextGeometry();

        @ClientBundle.Source("js/geometries/DecalGeometry.js")
        TextResource DecalGeometry();

        @ClientBundle.Source("js/effects/AnaglyphEffect.js")
        TextResource AnaglyphEffect();

        @ClientBundle.Source("js/effects/AsciiEffect.js")
        TextResource AsciiEffect();

        @ClientBundle.Source("js/controls/TrackballControls.js")
        TextResource TrackballControls();

        @ClientBundle.Source("js/effects/ParallaxBarrierEffect.js")
        TextResource ParallaxBarrierEffect();

        @ClientBundle.Source("js/effects/PeppersGhostEffect.js")
        TextResource PeppersGhostEffect();
    }

    private static class Bucket {

        private boolean loaded = false;
        private TextResource resource;

        private Bucket(TextResource resource) {
            this.resource = resource;
        }
    }

    private static class Holder<T> {

        private T value;

        public Holder(T value) {
            this.value = value;
        }
    }
}
