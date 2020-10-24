import { Texture } from './Texture.js';
import { ClampToEdgeWrapping, NearestFilter } from '../constants.js';

class DataTexture2DArray extends Texture {

	/**
	 * @param {number|null=} data 
	 * @param {number=} width 
	 * @param {number=} height 
	 * @param {number=} depth 
	 */
	constructor( data = null, width = 1, height = 1, depth = 1 ) {

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

DataTexture2DArray.prototype.isDataTexture2DArray = true;

export { DataTexture2DArray };
