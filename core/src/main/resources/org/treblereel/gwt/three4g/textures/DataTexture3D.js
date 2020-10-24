import { Texture } from './Texture.js';
import { ClampToEdgeWrapping, NearestFilter } from '../constants.js';

class DataTexture3D extends Texture {

	/**
	 * @param {number|null=} data 
	 * @param {number=} width 
	 * @param {number=} height 
	 * @param {number=} depth 
	 */
	constructor( data = null, width = 1, height = 1, depth = 1 ) {

		// We're going to add .setXXX() methods for setting properties later.
		// Users can still set in DataTexture3D directly.
		//
		//	const texture = new THREE.DataTexture3D( data, width, height, depth );
		// 	texture.anisotropy = 16;
		//
		// See #14839

		super( null );
		/** @type { { data : (null|number), width : number, height : number, depth:  number } } */
		this.image = { data, width, height, depth };
		/** @type {number} */
		this.magFilter = NearestFilter;
		/** @type {number} */
		this.minFilter = NearestFilter;
		/** @type {number} */
		this.wrapR = ClampToEdgeWrapping;
		/** @type {boolean} */
		this.generateMipmaps = false;
		/** @type {boolean} */
		this.flipY = false;
		/** @type {boolean} */
		this.needsUpdate = true;

	}

}

DataTexture3D.prototype.isDataTexture3D = true;

export { DataTexture3D };
