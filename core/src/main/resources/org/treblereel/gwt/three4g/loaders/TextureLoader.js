import { RGBAFormat, RGBFormat } from '../constants.js';
import { ImageLoader } from './ImageLoader.js';
import { Texture } from '../textures/Texture.js';
import { Loader } from './Loader.js';

import { LoadingManager } from './LoadingManager.js';

class TextureLoader extends Loader {


	/**
	 * 
	 * @param {LoadingManager=} manager 
	 */
	constructor( manager ) {

		super( manager );

	}

	/**
	 * @suppress {checkTypes}  
	 * @param {string} url 
	 * @param {function(Texture)=} onLoad 
	 * @param {function(*)=} onProgress 
	 * @param {function(*)=} onError 
	 * @return {Texture}
	 */
	load( url, onLoad, onProgress, onError ) {

		const texture = new Texture();

		const loader = new ImageLoader( this.manager );
		loader.setCrossOrigin( this.crossOrigin );
		loader.setPath( this.path );

		loader.load( url, function ( image ) {

			texture.image = image;

			// JPEGs can't have an alpha channel, so memory can be saved by storing them as RGB.
			const isJPEG = url.search( /\.jpe?g($|\?)/i ) > 0 || url.search( /^data\:image\/jpeg/ ) === 0;

			texture.format = isJPEG ? RGBFormat : RGBAFormat;
			texture.needsUpdate = true;

			if ( onLoad !== undefined ) {

				onLoad( texture );

			}

		}, onProgress, onError );

		return texture;

	}

}


export { TextureLoader };
