package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/9/18.
 */
public class WebglLoaderColladaKinematics { ///} extends Attachable {
/*

    public static final String name = "loader / collada / kinematics";

    private Clock clock = new Clock();
    private Object3D dae;
    private JsObject kinematics;
    private Mesh particleLight;

    private JsPropertyMap tweenParameters = JsPropertyMap.of();

    private Tween kinematicsTween;
    private boolean isReady = false;

    public WebglLoaderColladaKinematics() {

        loadJavaScript(JavascriptTextResource.IMPL.getTWEEN().getText());

        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.set(2f, 2f, 3f);
        scene = new Scene();

        ColladaLoader loader = new ColladaLoader();
        loader.load("models/collada/abb_irb52_7_120.dae", (OnLoadCallback<JsObject>) object -> {
            dae = object.getProperty("scene");
            dae.traverse(child -> {
                if (child instanceof Mesh) {
                    MeshPhongMaterial material = child.getProperty("material");
                    material.flatShading = true;
                }
            });

            dae.scale.x = dae.scale.y = dae.scale.z = 10.0f;
            dae.updateMatrix();
            kinematics = object.getProperty("kinematics");

            init();

        });

    }

    private void init() {

        // Grid
        GridHelper grid = new GridHelper(20, 20);
        scene.add(grid);
        // Add the COLLADA
        scene.add(dae);

        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.color = new Color(0xffffff);

        particleLight = new Mesh(new SphereBufferGeometry(4, 8, 8), new MeshBasicMaterial(parameters));

        scene.add(particleLight);
        // Lights
        HemisphereLight light = new HemisphereLight(0xffeeee, 0x111122);
        scene.add(light);

        PointLight pointLight = new PointLight(0xffffff, 0.3f);
        particleLight.add(pointLight);

        renderer = new WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);
        container.appendChild(renderer.domElement);


        setupTween();
    }

    private void setupTween() {
        int duration = org.treblereel.gwt.three4g.math.Math.randInt(1000, 5000);

        JsPropertyMap array = Js.uncheckedCast(kinematics.getProperty("joints"));
        JsPropertyMap target = JsPropertyMap.of();


        array.forEach(new JsForEachCallbackFn() {
            @Override
            public void onKey(String key) {
                JsObject cadidate = Js.uncheckedCast(array.get(key));
                if (!(boolean) cadidate.getProperty("static")) {

                    GWT.log("key " + key);
                    GWT.log("cadidate " + JSON.stringify(cadidate));

                    JsObject old = Js.uncheckedCast(tweenParameters.get(key));

                    float position;
                    if (old == null) {

                        GWT.log(" >>> " + JSON.stringify(cadidate.getProperty("zeroPosition")));

                        position = Float.valueOf(cadidate.getProperty("zeroPosition").toString());
                    } else {
                        position = Js.uncheckedCast(old);
                    }
                    GWT.log("old " + JSON.stringify(old));

                    tweenParameters.set(key, position);


                    JsObject limits = cadidate.getProperty("limits");
                    Double min = limits.getProperty("min");
                    Double max = limits.getProperty("max");
                    target.set(key, org.treblereel.gwt.three4g.math.Math.randFloat(min.floatValue(), max.floatValue()));

                }


            }
        });

        GWT.log("tweenParameters init " + JSON.stringify(tweenParameters));
        GWT.log("target init " + JSON.stringify(target));
        GWT.log("duration init " + duration);

        kinematicsTween = new Tween(tweenParameters).to(target, duration);
        GWT.log("kinematicsTween -------->\n " + JSON.stringify(kinematicsTween));

        kinematicsTween.easing(Out.action2());


        GWT.log("kinematicsTween <--------\n " + JSON.stringify(kinematicsTween));

        kinematicsTween.onUpdate(new OnLoad() {
            @Override
            public void onLoad() {

                GWT.log("onLoad " + JSON.stringify(tweenParameters));

                JsPropertyMap array = Js.uncheckedCast(kinematics.getProperty("joints"));
                JsPropertyMap target = JsPropertyMap.of();


                array.forEach(new JsForEachCallbackFn() {
                    @Override
                    public void onKey(String key) {

                        JsObject cadidate = Js.uncheckedCast(array.get(key));
                        if (!(boolean) cadidate.getProperty("static")) {

                            GWT.log("onLoad before " + JSON.stringify(kinematics));


                            Kinematics k = kinematics.cast();
                            k.setJointValue( key, tweenParameters.get(key) );

                            GWT.log("onLoad after " + JSON.stringify(kinematics));


                        }

                    }
                });

            }
        });


        //   kinematicsTween = new TWEEN.Tween( tweenParameters ).to( target, duration ).easing( TWEEN.Easing.Quadratic.Out );
*/
/*        kinematicsTween.onUpdate( function() {
            for ( var prop in kinematics.joints ) {
                if ( kinematics.joints.hasOwnProperty( prop ) ) {
                    if ( ! kinematics.joints[ prop ].static ) {
                        kinematics.setJointValue( prop, this[ prop ] );
                    }
                }
            }
        } );*//*

        kinematicsTween.start();

        isReady = true;
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("  collada loader - kinematics\n" +
                "\t\t\t | robot from <a href=\"https://github.com/rdiankov/collada_robots\" target=\"_blank\" rel=\"noopener\">collada robots</a>");


    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null && isReady) {

                double timer = new Date().getTime() * 0.0001;

                camera.position.x = ((float) Math.cos(timer) * 20);
                camera.position.y = 10;
                camera.position.z = ((float) Math.sin(timer) * 20);

                particleLight.position.x = ((float) Math.sin(timer * 4) * 3009);
                particleLight.position.y = ((float) Math.cos(timer * 5) * 4000);
                particleLight.position.z = ((float) Math.cos(timer * 4) * 3009);
                renderer.render(scene, camera);
                kinematicsTween.update();

            }
            animate();
        });
    }
*/

}
