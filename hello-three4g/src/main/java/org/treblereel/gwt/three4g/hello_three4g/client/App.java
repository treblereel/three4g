package org.treblereel.gwt.three4g.hello_three4g.client;

import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

import com.google.gwt.core.client.EntryPoint;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;

/**
 * {@link EntryPoint} to the hello cube app.
 * 
 * <p>
 * Straight forward translation of the rotating cube example from
 * https://threejsfundamentals.org/threejs/lessons/threejs-fundamentals.html to
 * GWT using the three4g API.
 * </p>
 */
public class App implements EntryPoint {
	private Scene _scene;

	private Mesh _cube;

	private PerspectiveCamera _camera;

	private WebGLRenderer _renderer;

	@Override
	public void onModuleLoad() {
		HTMLCanvasElement canvas = 
			(HTMLCanvasElement) DomGlobal.document.getElementById("canvas");

		WebGLRendererParameters rendererParams = new WebGLRendererParameters();
		rendererParams.canvas = canvas;
		_renderer = new WebGLRenderer(rendererParams);

		// Create camera.
		float fov = 75;
		float aspect = 2;
		float near = 0.1f;
		float far = 5;
		_camera = new PerspectiveCamera(fov, aspect, near, far);
		_camera.position.z = 2;

		_scene = new Scene();

		// Create light.
		int color = 0xFFFFFF;
		float intensity = 1;
		DirectionalLight light = new DirectionalLight(color, intensity);
		light.position.set(-1, 2, 4);
		_scene.add(light);

		// Create cube geometry.
		float boxWidth = 1;
		float boxHeight = 1;
		float boxDepth = 1;
		BoxGeometry geometry = new BoxGeometry(boxWidth, boxHeight, boxDepth);
		
		// Create cube material.
		MeshPhongMaterialParameters materialParams = new MeshPhongMaterialParameters();
		materialParams.color = new Color(0x44aa88);
		MeshPhongMaterial material = new MeshPhongMaterial(materialParams);
		
		// Crete Cube
		_cube = new Mesh(geometry, material);
		_scene.add(_cube);

		// Start the event loop by requesting the first update.
		DomGlobal.requestAnimationFrame(this::eventLoop);
	}

	void eventLoop(double timestamp) {
		update(timestamp);

		// Request the next update.
		DomGlobal.requestAnimationFrame(this::eventLoop);
	}

	void update(double timestamp) {
		// Update cube rotation.
		float time = (float) (timestamp * 0.001);
		_cube.rotation.x = time;
		_cube.rotation.y = time;

		// Render the updated scene.
		_renderer.render(_scene, _camera);
	}

}
