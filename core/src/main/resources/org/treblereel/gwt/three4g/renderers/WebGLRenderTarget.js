import { EventDispatcher } from '../core/EventDispatcher.js';
import { Texture } from '../textures/Texture.js';
import { LinearFilter } from '../constants.js';
import { Vector4 } from '../math/Vector4.js';

import { WebGLRenderTargetOptions } from './WebGLRenderTargetOptions.js';

/*
 In options, we can specify:
 * Texture parameters for an auto-generated target texture
 * depthBuffer/stencilBuffer: Booleans to indicate if we should generate these buffers
*/
class WebGLRenderTarget extends EventDispatcher {

	/**
	 * 
	 * @param {number} width 
	 * @param {number} height 
	 * @param {WebGLRenderTargetOptions=} options 
	 */
	constructor( width, height, options ) {

		super();

		this.width = width;
		this.height = height;
		this.depth = 1;

		this.scissor = new Vector4( 0, 0, width, height );
		this.scissorTest = false;

		this.viewport = new Vector4( 0, 0, width, height );

		options = options || {};

		/** @type {Texture} */
		this.texture = new Texture( undefined, options.mapping, options.wrapS, options.wrapT, options.magFilter, options.minFilter, options.format, options.type, options.anisotropy, options.encoding );

		/** @type {{width: number, height: number, depth: number}} */
		this.texture.image = {};
		this.texture.image.width = width;
		this.texture.image.height = height;
		this.texture.image.depth = 1;

		this.texture.generateMipmaps = options.generateMipmaps !== undefined ? options.generateMipmaps : false;
		this.texture.minFilter = options.minFilter !== undefined ? options.minFilter : LinearFilter;

		this.depthBuffer = options.depthBuffer !== undefined ? options.depthBuffer : true;
		this.stencilBuffer = options.stencilBuffer !== undefined ? options.stencilBuffer : false;
		this.depthTexture = options.depthTexture !== undefined ? options.depthTexture : null;

	}

	/**
	 * @param {Texture} texture 
	 */
	setTexture( texture ) {

		texture.image = {
			width: this.width,
			height: this.height,
			depth: this.depth
		};

		this.texture = texture;

	}

	/**
	 * 
	 * @param {number} width 
	 * @param {number} height 
	 * @param {number=} depth 
	 */
	setSize( width, height, depth = 1 ) {

		if ( this.width !== width || this.height !== height || this.depth !== depth ) {

			this.width = width;
			this.height = height;
			this.depth = depth;

			this.texture.image.width = width;
			this.texture.image.height = height;
			this.texture.image.depth = depth;

			this.dispose();

		}

		this.viewport.set( 0, 0, width, height );
		this.scissor.set( 0, 0, width, height );

	}

	/**
	 * @return {WebGLRenderTarget}
	 */
	clone() {

		return new this.constructor().copy( this );

	}

	/**
	 * @param {WebGLRenderTarget} source
	 * @return {WebGLRenderTarget}
	 */
	copy( source ) {

		this.width = source.width;
		this.height = source.height;
		this.depth = source.depth;

		this.viewport.copy( source.viewport );

		this.texture = source.texture.clone();

		this.depthBuffer = source.depthBuffer;
		this.stencilBuffer = source.stencilBuffer;
		this.depthTexture = source.depthTexture;

		return this;

	}

	dispose() {

		this.dispatchEvent( { type: 'dispose' } );

	}

}

WebGLRenderTarget.prototype.isWebGLRenderTarget = true;

export { WebGLRenderTarget };
