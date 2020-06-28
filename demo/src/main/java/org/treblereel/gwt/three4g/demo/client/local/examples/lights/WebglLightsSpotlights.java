package org.treblereel.gwt.three4g.demo.client.local.examples.lights;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.lights.custom.Easing;
import org.treblereel.gwt.three4g.demo.client.local.examples.lights.custom.TWEEN;
import org.treblereel.gwt.three4g.demo.client.local.examples.lights.custom.Tween;
import org.treblereel.gwt.three4g.demo.client.local.examples.lights.custom.XYZ;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.helpers.SpotLightHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglLightsSpotlights extends Attachable {

    public static final String name = "lights / spotlights";

    private SpotLightHelper lightHelper1, lightHelper2, lightHelper3;
    private OrbitControls orbitControls;
    private SpotLight spotLight1, spotLight2, spotLight3;

    public WebglLightsSpotlights() {

        loadJavaScript(JavascriptTextResource.IMPL.getTWEEN().getText());


        camera = new PerspectiveCamera(35, aspect, 1, 2000);

        scene = new Scene();
        orbitControls = new OrbitControls(camera, root);


        MeshPhongMaterial matFloor = new MeshPhongMaterial();
        MeshPhongMaterial matBox = new MeshPhongMaterial();
        matBox.color = new Color(0xaaaaaa);
        PlaneBufferGeometry geoFloor = new PlaneBufferGeometry(2000, 2000);
        BoxBufferGeometry geoBox = new BoxBufferGeometry(3, 1, 2);
        Mesh mshFloor = new Mesh(geoFloor, matFloor);
        mshFloor.rotation.x = (float) (-Math.PI * 0.5);

        Mesh mshBox = new Mesh(geoBox, matBox);
        AmbientLight ambient = new AmbientLight(0x111111);

        spotLight1 = createSpotlight(0xFF7F00);
        spotLight2 = createSpotlight(0x00FF7F);
        spotLight3 = createSpotlight(0x7F00FF);

        camera.position.set(46, 22, -21);
        spotLight1.position.set(15, 40, 45);
        spotLight2.position.set(0, 40, 35);
        spotLight3.position.set(-15, 40, 45);

        lightHelper1 = new SpotLightHelper(spotLight1);
        lightHelper2 = new SpotLightHelper(spotLight2);
        lightHelper3 = new SpotLightHelper(spotLight3);

        matFloor.color.set(0x808080);
        mshFloor.receiveShadow = true;
        mshFloor.position.set(0, -0.05f, 0);
        mshBox.castShadow = true;
        mshBox.receiveShadow = true;
        mshBox.position.set(0, 5, 0);

        scene.add(mshFloor);
        scene.add(mshBox);
        scene.add(ambient);
        scene.add(spotLight1, spotLight2, spotLight3);
        scene.add(lightHelper1, lightHelper2, lightHelper3);

        orbitControls.target.set(0, 7, 0);
        orbitControls.maxPolarAngle = (float) Math.PI / 2;
        orbitControls.update();

        setupWebGLRenderer(renderer);

        renderer.shadowMap.enabled = true;
        renderer.shadowMap.type = THREE.PCFSoftShadowMap;
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
    }

    private SpotLight createSpotlight(int color) {
        SpotLight newObj = new SpotLight(color, 2);
        newObj.castShadow = true;
        newObj.angle = 0.3f;
        newObj.penumbra = 0.2f;
        newObj.decay = 2;
        newObj.distance = 50;
        newObj.shadow.mapSize.width = 1024;
        newObj.shadow.mapSize.height = 1024;
        return newObj;
    }

    private void tween(SpotLight light) {
        XYZ xyz = new XYZ();
        xyz.x = (Math.random() * 30) - 15;
        xyz.x = (Math.random() * 10) + 15;
        xyz.x = (Math.random() * 30) - 15;

        JsPropertyMap map = JsPropertyMap.of();
        map.set("angle", ((Math.random() * 0.7) + 0.1));
        map.set("penumbra", Math.random() + 1);


        GWT.log("? " + Easing.Quadratic.get("In"));

        new Tween(light).to(map, Math.random() * 3000 + 2000)
                .easing(Easing.Quadratic.get("Out")).start();


        new Tween(light.position).to(xyz, Math.random() * 3000 + 2000)
                .easing(Easing.Quadratic.get("In")).start();
    }


    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  - This animates 3 Spot Lights - by <a href=\"http://master-domain.com\" target=\"_blank\" rel=\"noopener\">Master James</a><br />\n" +
                "\t\t\tOrbit Controls are available to navigate.<br />\n" +
                "\t\t\tWhere the lights converge to make white light the shadows will appear as C M Y from light color pairing.");

    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                tween(spotLight1);
                tween(spotLight2);
                tween(spotLight3);

                render();
                animate();
            }
        });
    }

    private void render() {
        TWEEN.update();
        if (lightHelper1 != null) lightHelper1.update();
        if (lightHelper2 != null) lightHelper2.update();
        if (lightHelper3 != null) lightHelper3.update();
        renderer.render(scene, camera);
    }

}


