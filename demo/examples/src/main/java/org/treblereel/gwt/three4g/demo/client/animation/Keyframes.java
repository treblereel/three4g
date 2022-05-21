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

package org.treblereel.gwt.three4g.demo.client.animation;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.environments.RoomEnvironment;
import org.treblereel.gwt.three4g.extras.PMREMGenerator;
import org.treblereel.gwt.three4g.loaders.DRACOLoader;
import org.treblereel.gwt.three4g.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Page(path = "animation_keyframes")
public class Keyframes implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Clock clock = new Clock();
    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private AnimationMixer mixer;

    private OrbitControls controls;

    private Scene scene;

    private boolean run, ready;


    @PostConstruct
    public void init() {
        root.appendChild(stats.dom);

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8);
        renderer.outputEncoding = THREE.sRGBEncoding;
        root.appendChild(renderer.domElement);

        PMREMGenerator pmremGenerator = new PMREMGenerator(renderer);

        scene = new Scene();
        scene.setBackground(new Color( 0xbfe3dd ));
        scene.setEnvironment(pmremGenerator.fromScene( new RoomEnvironment(), 0.04 ).texture);

        camera = new PerspectiveCamera( 40, DomGlobal.window.innerWidth * 0.8 / DomGlobal.window.innerHeight * 0.8, 1, 100 );
        camera.position.set( 5, 2, 8 );

        controls = new OrbitControls( camera, renderer.domElement );
        controls.target.set( 0, 0.5, 0 );
        controls.update();
        controls.enablePan = false;
        controls.enableDamping = true;

        DRACOLoader dracoLoader = new DRACOLoader();
        dracoLoader.setDecoderPath( "js/libs/draco/gltf/" );

        GLTFLoader loader = new GLTFLoader();
        loader.setDRACOLoader( dracoLoader );


        loader.load("models/gltf/LittlestTokyo.glb", (OnLoadCallback<PropertyHolder>) result -> {
            Object3D model = result.getProperty("scene");
            model.position.set( 1, 1, 0 );
            model.scale.set( 0.01, 0.01, 0.01 );
            scene.add( model );

            mixer = new AnimationMixer( model );
            AnimationClip[] clips = result.getProperty("animations");
            mixer.clipAction(clips[0]).play();

            ready = true;
        });

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if(camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            stats.update();
            double delta = clock.getDelta();
            mixer.update(delta);
            controls.update();
            renderer.render(scene, camera);
        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> webgl - animation - keyframes<br/>\n" +
                "\t\t\tModel: <a href=\"https://artstation.com/artwork/1AGwX\" target=\"_blank\" rel=\"noopener\">Littlest Tokyo</a> by\n" +
                "\t\t\t<a href=\"https://artstation.com/glenatron\" target=\"_blank\" rel=\"noopener\">Glen Fox</a>, CC Attribution.";

        run = true;
        animate();
    }

}