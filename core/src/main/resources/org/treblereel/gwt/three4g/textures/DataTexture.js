import { Texture } from './Texture.js';
import { NearestFilter } from '../constants.js';

class DataTexture extends Texture {

	/**
	 * 
	 * @param {ArrayBufferView} data 
	 * @param {number} width 
	 * @param {number} height 
	 * @param {number} format 
	 * @param {number=} type 
	 * @param {number=} mapping 
	 * @param {number=} wrapS 
	 * @param {number=} wrapT 
	 * @param {number=} magFilter 
	 * @param {number=} minFilter 
	 * @param {number=} anisotropy 
	 * @param {number=} encoding 
	 * @suppress {checkTypes} 
	 */
	constructor( data, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy, encoding ) {

		super( null, mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy, encoding );

		this.image = { data: data || null, width: width || 1, height: height || 1 };

		this.magFilter = magFilter !== undefined ? magFilter : NearestFilter;
		this.minFilter = minFilter !== undefined ? minFilter : NearestFilter;

		this.generateMipmaps = false;
		this.flipY = false;
		this.unpackAlignment = 1;

		this.needsUpdate = true;

	}

}

DataTexture.prototype.isDataTexture = true;

export { DataTexture };
