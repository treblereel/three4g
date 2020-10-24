import { Object3DInterface } from '../closure/core/Object3DInterface.js';
import { Object3D } from '../core/Object3D.js';
import { Vector3 } from '../math/Vector3.js';
import { PerspectiveCamera } from './PerspectiveCamera.js';
import { WebGLRenderer } from '../renderers/WebGLRenderer.js';
import { WebGLCubeRenderTarget } from '../renderers/WebGLCubeRenderTarget.js';

const fov = 90, aspect = 1;

class CubeCamera extends Object3D {

	/**
	 * 
	 * @param {number} near 
	 * @param {number} far 
	 * @param {WebGLCubeRenderTarget} renderTarget 
	 */
	constructor( near, far, renderTarget ) {

		super();
		/**@type {string} */
		this.type = 'CubeCamera';

		if ( renderTarget.isWebGLCubeRenderTarget !== true ) {

			console.error( 'THREE.CubeCamera: The constructor now expects an instance of WebGLCubeRenderTarget as third parameter.' );
			return;

		}
		/** @type {WebGLCubeRenderTarget} */
		this.renderTarget = renderTarget;
		/** @type {PerspectiveCamera} */
		const cameraPX = new PerspectiveCamera( fov, aspect, near, far );
		cameraPX.layers = this.layers;
		cameraPX.up.set( 0, - 1, 0 );
		cameraPX.lookAt( new Vector3( 1, 0, 0 ) );
		this.cameraPX = cameraPX;
		this.add( cameraPX );

		/** @type {PerspectiveCamera} */
		const cameraNX = new PerspectiveCamera( fov, aspect, near, far );
		cameraNX.layers = this.layers;
		cameraNX.up.set( 0, - 1, 0 );
		cameraNX.lookAt( new Vector3( - 1, 0, 0 ) );
		this.cameraNX = cameraNX;
		this.add( cameraNX );

		/** @type {PerspectiveCamera} */
		const cameraPY = new PerspectiveCamera( fov, aspect, near, far );
		cameraPY.layers = this.layers;
		cameraPY.up.set( 0, 0, 1 );
		cameraPY.lookAt( new Vector3( 0, 1, 0 ) );
		this.cameraPY = cameraPY;
		this.add( cameraPY );

		/** @type {PerspectiveCamera} */
		const cameraNY = new PerspectiveCamera( fov, aspect, near, far );
		cameraNY.layers = this.layers;
		cameraNY.up.set( 0, 0, - 1 );
		cameraNY.lookAt( new Vector3( 0, - 1, 0 ) );
		this.cameraNY = cameraNY;
		this.add( cameraNY );

		/** @type {PerspectiveCamera} */
		const cameraPZ = new PerspectiveCamera( fov, aspect, near, far );
		cameraPZ.layers = this.layers;
		cameraPZ.up.set( 0, - 1, 0 );
		cameraPZ.lookAt( new Vector3( 0, 0, 1 ) );
		this.cameraPZ = cameraPZ;
		this.add( cameraPZ );

		/** @type {PerspectiveCamera} */
		const cameraNZ = new PerspectiveCamera( fov, aspect, near, far );
		cameraNZ.layers = this.layers;
		cameraNZ.up.set( 0, - 1, 0 );
		cameraNZ.lookAt( new Vector3( 0, 0, - 1 ) );
		this.cameraNZ = cameraNZ;
		this.add( cameraNZ );

	}

	/**
	 * @param {WebGLRenderer} renderer 
	 * @param {Object3DInterface} scene
	 * @suppress {checkTypes} 
	 */
	update( renderer, scene ) {

		if ( this.parent === null ) this.updateMatrixWorld();

		/** @type {WebGLCubeRenderTarget} */
		const renderTarget = this.renderTarget;

		const [ cameraPX, cameraNX, cameraPY, cameraNY, cameraPZ, cameraNZ ] = /** @type {!Iterable} */ (this.children);

		/** @type {boolean} */
		const currentXrEnabled = renderer.xr.enabled;
		const currentRenderTarget = renderer.getRenderTarget();

		renderer.xr.enabled = false;

		const generateMipmaps = renderTarget.texture.generateMipmaps;

		renderTarget.texture.generateMipmaps = false;

		renderer.setRenderTarget( renderTarget, 0 );
		renderer.render( scene, cameraPX );

		renderer.setRenderTarget( renderTarget, 1 );
		renderer.render( scene, cameraNX );

		renderer.setRenderTarget( renderTarget, 2 );
		renderer.render( scene, cameraPY );

		renderer.setRenderTarget( renderTarget, 3 );
		renderer.render( scene, cameraNY );

		renderer.setRenderTarget( renderTarget, 4 );
		renderer.render( scene, cameraPZ );

		renderTarget.texture.generateMipmaps = generateMipmaps;

		renderer.setRenderTarget( renderTarget, 5 );
		renderer.render( scene, cameraNZ );

		renderer.setRenderTarget( currentRenderTarget );

		renderer.xr.enabled = currentXrEnabled;

	}

}

export { CubeCamera };
