package org.treblereel.gwt.three4g.demo.client.local;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.event.shared.GwtEvent;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLIFrameElement;
import elemental2.dom.Window;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.utils.WebGLRendererProducer;
import org.treblereel.gwt.three4g.extensions.controls.FirstPersonControls;
import org.treblereel.gwt.three4g.extensions.controls.FlyControls;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;


/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/13/18.
 */
public abstract class Attachable extends GwtEvent<Attachable.EventHandler> {

    public static Type<Attachable.EventHandler> TYPE = new Type<>();
    protected Window window = DomGlobal.window;
    protected WebGLRenderer renderer = WebGLRendererProducer.getRenderer();
    protected Scene scene;
    protected PerspectiveCamera camera;
    protected Mesh mesh;
    protected HTMLDivElement panel = (HTMLDivElement) DomGlobal.document.getElementById("panel");
    protected HTMLDivElement container = (HTMLDivElement) DomGlobal.document.createElement("div");
    protected HTMLDivElement root = (HTMLDivElement) DomGlobal.document.createElement("div");
    protected EventListener onResize = evt -> onWindowResize();
    protected float aspect = new Float((getWidth() / getHeight()));
    protected double devicePixelRatio = ((org.treblereel.gwt.three4g.demo.client.api.dom.Window) DomGlobal.window).devicePixelRatio;
    protected GUI gui;
    protected OrbitControls orbitControls;
    protected FirstPersonControls firstPersonControls;
    protected TrackballControls trackballControls;
    protected FlyControls flyControls;


    public static void loadJavaScript(String script) {
        ScriptInjector.fromString(script).setWindow(ScriptInjector.TOP_WINDOW).inject();
    }

    @Override
    public Type<Attachable.EventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Attachable.EventHandler handler) {
        handler.on(this);
    }

    protected abstract void doAttachScene();

    protected abstract void doAttachInfo();


    public void attach() {
        doAttachScene();
        doAttachInfo();
        doAttachLink();
    }

    public void detach() {
        doDetach();
    }

    public void doDetach() {
        AppSetup.infoDiv.hide();
        AppSetup.menuDiv.hide();
        detachControls();
        detachGui();
        renderer.dispose();
        window.removeEventListener("resize", onResize);
    }

    private void detachControls() {
        if (orbitControls != null) {
            orbitControls.dispose();
        }
        if (firstPersonControls != null) {
            firstPersonControls.dispose();
        }
        if (trackballControls != null) {
            trackballControls.dispose();
        }
        if (flyControls != null) {
            flyControls.dispose();
        }
    }

    private void detachGui() {
        if (gui != null) {
            gui.getDomElement().parentNode.removeChild(gui.getDomElement());
            gui = null;
        }
    }

    private void clearDiv(HTMLDivElement element) {
        while (element.hasChildNodes()) {
            element.removeChild(element.firstChild);
        }
    }

    private void doAttachLink() {
        AppSetup.viewSrcButton.setLink(getClass().getCanonicalName());
    }

    private void clearContainer(HTMLIFrameElement container) {
        while (container.hasChildNodes()) {
            container.removeChild(container.firstChild);
        }
    }

    public double getWidth() {
        return window.innerWidth * 0.8;
    }

    public double getHeight() {
        return window.innerHeight;
    }

    //TODO
    public void onWindowResize() {
        if (root.parentNode != null && camera != null) {
            camera.aspect = new Float(getWidth() / getHeight());
            camera.updateProjectionMatrix();
            renderer.setSize(getWidth(), getHeight());
        }
    }

    public void setupWebGLRenderer(WebGLRenderer webGLRenderer) {
        webGLRenderer.domElement.id = "viewer";
        webGLRenderer.setPixelRatio(devicePixelRatio);
        webGLRenderer.setSize(getWidth(), getHeight());
    }

    public HTMLDivElement asWidget() {
        window.addEventListener("resize", onResize);
        attach();
        AppSetup.currentPageHolder.setCurrentPage(this);
        return root;
    }

    public interface EventHandler extends com.google.gwt.event.shared.EventHandler {
        void on(Attachable event);
    }

}
