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

package org.treblereel.gwt.three4g.demo.client.simple;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLabelElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 2/22/19
 */
@Singleton
@Page(path = "cube")
public class Cube implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private PerspectiveCamera camera;
    private Scene scene;
    private Mesh mesh;
    private WebGLRenderer renderer;

    private boolean run;

    @PostConstruct
    public void init(){
        HTMLLabelElement labelElement = (HTMLLabelElement) DomGlobal.document.createElement("label");
        labelElement.textContent = "CUBE";
        root.append(labelElement);

        camera = new PerspectiveCamera( 70, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000 );
        camera.position.z = 400;
        scene = new Scene();
        Texture texture = new TextureLoader().load("https://threejs.org/examples/textures/crate.gif" );
        MeshBasicMaterialParameters meshBasicMaterialParameters = MeshBasicMaterialParameters.create();
        meshBasicMaterialParameters.setMap(texture);

        BoxGeometry geometry = new BoxGeometry(200, 200, 200 );
        MeshBasicMaterial material = new MeshBasicMaterial(meshBasicMaterialParameters);

        mesh = new Mesh( geometry, material );

        scene.add( mesh );

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio( DomGlobal.window.devicePixelRatio );
        renderer.setSize( DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8 );
        root.appendChild(renderer.domElement);

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void  onWindowResize() {
        camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize( DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8 );

    }

    private void animate() {
        if(!run) {
            return;
        }
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        mesh.rotation.x += 0.005;
        mesh.rotation.y += 0.01;

        renderer.render( scene, camera );
    }

    @PageHiding
    private void onHide() {
        run = false;
    }

    @PageShown
    private void onShow() {
        run = true;
        animate();

    }

}