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

package org.treblereel.gwt.three4g.controls;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.events.EventDispatcher;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.OrbitControls", namespace = JsPackage.GLOBAL)
public class OrbitControls extends EventDispatcher {

    public Vector3 target;
    public boolean enablePan;
    public boolean enableDamping;
    public boolean enableZoom;
    public double minDistance;
    public double maxDistance;
    public double maxPolarAngle;

    public OrbitControls(PerspectiveCamera camera, HTMLElement domElement) {
        super();
    }

    public native void update();
}
