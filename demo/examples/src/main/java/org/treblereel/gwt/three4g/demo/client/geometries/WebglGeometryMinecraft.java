package org.treblereel.gwt.three4g.demo.client.geometries;

import elemental2.core.JsArray;
import elemental2.dom.*;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.FirstPersonControls;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.ImprovedNoise;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.utils.BufferGeometryUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Page(path = "webgl_geometry_minecraft")
public class WebglGeometryMinecraft implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Scene scene;

    private boolean run, ready;

    private Stats stats = new Stats();

    private Clock clock = new Clock();

    private int worldWidth = 128,
            worldDepth = 128;

    private int worldHalfWidth = worldWidth / 2;
    private int worldHalfDepth = worldDepth / 2;

    private JsArray<Double> data = generateHeight(worldWidth, worldDepth);


    private FirstPersonControls controls;

    @PostConstruct
    public void init() {

        camera = new PerspectiveCamera(60, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 20000);
        camera.position.y = getY(worldHalfWidth, worldHalfDepth) * 100 + 100;

        scene = new Scene();
        scene.setBackground(new Color(0xbfd1e5));

        // sides

        Matrix4 matrix = new Matrix4();

        PlaneGeometry pxGeometry = new PlaneGeometry(100, 100);
        pxGeometry.attributes.get("uv").asBufferAttribute().array.setAt(1, 0.5);
        pxGeometry.attributes.get("uv").asBufferAttribute().array.setAt(3, 0.5);

        pxGeometry.rotateY(Math.PI / 2);
        pxGeometry.translate(50, 0, 0);

        PlaneGeometry nxGeometry = new PlaneGeometry(100, 100);
        nxGeometry.attributes.get("uv").asBufferAttribute().array.setAt(1, 0.5);
        nxGeometry.attributes.get("uv").asBufferAttribute().array.setAt(3, 0.5);

        nxGeometry.rotateY(-Math.PI / 2);
        nxGeometry.translate(-50, 0, 0);

        PlaneGeometry pyGeometry = new PlaneGeometry(100, 100);
        pyGeometry.attributes.get("uv").asBufferAttribute().array.setAt(5, 0.5);
        pyGeometry.attributes.get("uv").asBufferAttribute().array.setAt(7, 0.5);
        pyGeometry.rotateX(-Math.PI / 2);
        pyGeometry.translate(0, 50, 0);

        PlaneGeometry pzGeometry = new PlaneGeometry(100, 100);
        pzGeometry.attributes.get("uv").asBufferAttribute().array.setAt(1, 0.5);
        pzGeometry.attributes.get("uv").asBufferAttribute().array.setAt(3, 0.5);
        pzGeometry.translate(0, 0, 50);

        PlaneGeometry nzGeometry = new PlaneGeometry(100, 100);
        nzGeometry.attributes.get("uv").asBufferAttribute().array.setAt(1, 0.5);
        nzGeometry.attributes.get("uv").asBufferAttribute().array.setAt(3, 0.5);
        nzGeometry.rotateY(Math.PI);
        nzGeometry.translate(0, 0, -50);

        //

        JsArray<BufferGeometry> geometries = new JsArray<>();

        for (int z = 0; z < worldDepth; z++) {

            for (int x = 0; x < worldWidth; x++) {

                int h = getY(x, z);

                matrix.makeTranslation(
                        x * 100 - worldHalfWidth * 100,
                        h * 100,
                        z * 100 - worldHalfDepth * 100
                );

                int px = getY(x + 1, z);
                int nx = getY(x - 1, z);
                int pz = getY(x, z + 1);
                int nz = getY(x, z - 1);

                geometries.push(pyGeometry.clone_().applyMatrix4(matrix));

                if ((px != h && px != h + 1) || x == 0) {

                    geometries.push(pxGeometry.clone_().applyMatrix4(matrix));

                }

                if ((nx != h && nx != h + 1) || x == worldWidth - 1) {

                    geometries.push(nxGeometry.clone_().applyMatrix4(matrix));

                }

                if ((pz != h && pz != h + 1) || z == worldDepth - 1) {

                    geometries.push(pzGeometry.clone_().applyMatrix4(matrix));

                }

                if ((nz != h && nz != h + 1) || z == 0) {

                    geometries.push(nzGeometry.clone_().applyMatrix4(matrix));

                }

            }

        }

        BufferGeometry geometry = BufferGeometryUtils.mergeBufferGeometries(geometries);
        geometry.computeBoundingSphere();

        Texture texture = new TextureLoader().load("textures/minecraft/atlas.png");
        texture.magFilter = THREE.NearestFilter;


        MeshLambertMaterialParameters meshLambertMaterialParameters = MeshLambertMaterialParameters.create();
        meshLambertMaterialParameters.setMap(texture);
        meshLambertMaterialParameters.setSide(THREE.DoubleSide);

        Mesh mesh = new Mesh(geometry, new MeshLambertMaterial(meshLambertMaterialParameters));
        scene.add(mesh);

        AmbientLight ambientLight = new AmbientLight(0xcccccc);
        scene.add(ambientLight);

        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 2);
        directionalLight.position.set(1, 1, 0.5).normalize();
        scene.add(directionalLight);

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        root.appendChild(renderer.domElement);

        controls = new FirstPersonControls(camera, DomGlobal.document.body);

        controls.movementSpeed = 1000;
        controls.lookSpeed = 0.125;
        controls.lookVertical = true;
        controls.activeLook = true;

        stats = new Stats();
        root.appendChild(stats.dom);


        DomGlobal.window.addEventListener("resize", e -> onWindowResize());

        ready = true;

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);

        }
    }

    private JsArray<Double> generateHeight(int width, int height) {

        JsArray<Double> data = new JsArray<>();

        ImprovedNoise perlin = new ImprovedNoise();

        int size = width * height;
        int z = (int) Math.random() * 100;

        int quality = 2;

        for (int j = 0; j < 4; j++) {

            if (j == 0) for (int i = 0; i < size; i++) data.setAt(i, 0.0);

            for (int i = 0; i < size; i++) {

                double x = i % width, y = (i / width) | 0;

                data.setAt(i, data.getAt(i) + perlin.noise(x / quality, y / quality, z) * quality);
            }

            quality *= 4;

        }

        return data;

    }

    private int getY(int x, int z) {
        Double result = data.getAt((x + z * worldWidth));
        if(result == null) {
            return 0;
        }
        return (int) (result * 0.15); // ( data[ x + z * worldWidth ] * 0.15 ) | 0; must simpler to truncate digts to get int from double
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            stats.update();

            controls.update( clock.getDelta() );
            renderer.render( scene, camera );
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">threejs</a> - <a href=\"http://www.minecraft.net/\" target=\"_blank\" rel=\"noopener\">minecraft</a> demo. featuring <a href=\"http://painterlypack.net/\" target=\"_blank\" rel=\"noopener\">painterly pack</a><br />(left click: forward, right click: backward)";

        run = true;
        animate();
    }
}

