package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.dom.CSSProperties;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/2/18.
 */
public class WebglMaterialsTextureCanvas extends Attachable {

    public static final String name = "materials / texture / canvas";

    private Vector2 drawStartPos = new Vector2();
    private MeshBasicMaterial material;

    public WebglMaterialsTextureCanvas() {
        camera = new PerspectiveCamera(50, aspect, 1, 2000);
        camera.position.z = 500;
        scene = new Scene();
        material = new MeshBasicMaterial();
        mesh = new Mesh(new BoxBufferGeometry(200, 200, 200), material);
        scene.add(mesh);


        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);

        generateHTMLCanvasElement();

    }

    public void generateHTMLCanvasElement() {
        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext("2d"));

        canvas.width = 128;
        canvas.height = 128;
        canvas.style.zIndex = CSSProperties.ZIndexUnionType.of(9999999);
        canvas.style.position = "absolute";

        // draw white background
        context.fillStyle = CanvasRenderingContext2D.FillStyleUnionType.of("#FFFFFF");
        context.fillRect(0, 0, 128, 128);
        // set canvas as material.map (this could be done to any map, bump, displacement etc.)
        material.map = new CanvasTexture(canvas);

        AtomicBoolean paint = new AtomicBoolean(false);

        // add canvas event listeners
        canvas.addEventListener("mousedown", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                MouseEvent e = (MouseEvent) evt;
                paint.set(true);
                drawStartPos.set((float) e.offsetX, (float) e.offsetY);
            }
        });

        canvas.addEventListener("mousemove", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                MouseEvent e = (MouseEvent) evt;
                if (paint.get()) draw(context, e.offsetX, e.offsetY);
            }
        });


        canvas.addEventListener("mouseup", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                paint.set(false);
            }
        });

        canvas.addEventListener("mouseleave", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                paint.set(false);
            }
        });

        root.appendChild(canvas);
    }

    private void draw(CanvasRenderingContext2D drawContext, double x, double y) {
        drawContext.moveTo(drawStartPos.x, drawStartPos.y);
        drawContext.strokeStyle = CanvasRenderingContext2D.StrokeStyleUnionType.of("#00000");
        drawContext.lineTo(x, y);
        drawContext.stroke();
        // reset drawing start position to current position.
        drawStartPos.set((float) x, (float) y);
        // need to flag the map as needing updating.
        material.map.needsUpdate = true;
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml("- webgl - canvas as a texture\n" +
                "\t\t\t<div>click and draw in the white box</div>");
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                render();
                animate();
            }
        });
    }

    private void render() {
        mesh.rotation.x += 0.01;
        mesh.rotation.y += 0.01;
        renderer.render(scene, camera);
    }

}



