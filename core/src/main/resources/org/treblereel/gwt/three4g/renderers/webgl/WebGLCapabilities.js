import { WebGLRendererParameters } from '../WebGLRendererParameters.js';
import { WebGLExtensions } from './WebGLExtensions.js';

/**
 * @suppress {checkTypes, reportUnknownTypes} 
 */
class WebGLCapabilities {

	/**
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl 
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLRendererParameters} parameters 
	 */
	constructor( gl, extensions, parameters ) {

		this.gl = gl;
		this.extensions = extensions;
		this.parameters = parameters;

		/** @type {number} */
		this.maxAnisotropy;

		/* eslint-disable no-undef */
		this.isWebGL2 = ( typeof WebGL2RenderingContext !== 'undefined' && gl instanceof WebGL2RenderingContext ) ||
			( typeof WebGL2ComputeRenderingContext !== 'undefined' && gl instanceof WebGL2ComputeRenderingContext );
		/* eslint-enable no-undef */

		/** @type {string} */
		this.precision = parameters.precision !== undefined ? parameters.precision : 'highp';
		/** @type {string} */
		this.maxPrecision = this.getMaxPrecision( this.precision );

		if ( this.maxPrecision !== this.precision ) {

			console.warn( 'THREE.WebGLRenderer:', this.precision, 'not supported, using', this.maxPrecision, 'instead.' );
			this.precision = this.maxPrecision;

		}
		/** @type {boolean} */
		this.logarithmicDepthBuffer = parameters.logarithmicDepthBuffer === true;
		/** @type {number} */
		this.maxTextures = gl.getParameter( gl.MAX_TEXTURE_IMAGE_UNITS );
		/** @type {number} */
		this.maxVertexTextures = gl.getParameter( gl.MAX_VERTEX_TEXTURE_IMAGE_UNITS );
		/** @type {number} */
		this.maxTextureSize = gl.getParameter( gl.MAX_TEXTURE_SIZE );
		/** @type {number} */
		this.maxCubemapSize = gl.getParameter( gl.MAX_CUBE_MAP_TEXTURE_SIZE );
		/** @type {number} */
		this.maxAttributes = gl.getParameter( gl.MAX_VERTEX_ATTRIBS );
		/** @type {number} */
		this.maxVertexUniforms = gl.getParameter( gl.MAX_VERTEX_UNIFORM_VECTORS );
		/** @type {number} */
		this.maxVaryings = gl.getParameter( gl.MAX_VARYING_VECTORS );
		/** @type {number} */
		this.maxFragmentUniforms = gl.getParameter( gl.MAX_FRAGMENT_UNIFORM_VECTORS );
		/** @type {boolean} */
		this.vertexTextures = this.maxVertexTextures > 0;
		/** @type {boolean} */
		this.floatFragmentTextures = this.isWebGL2 || extensions.has( 'OES_texture_float' );
		/** @type {boolean} */
		this.floatVertexTextures = this.vertexTextures && this.floatFragmentTextures;
		/** @type {number} */
		this.maxSamples = this.isWebGL2 ? gl.getParameter( gl.MAX_SAMPLES ) : 0;

	}	

	/**
	 * @return {number} 
	 */
	getMaxAnisotropy() {

		if ( this.maxAnisotropy !== undefined ) return this.maxAnisotropy;

		if ( this.extensions.has( 'EXT_texture_filter_anisotropic' ) === true ) {

			const extension = this.extensions.get( 'EXT_texture_filter_anisotropic' );

			this.maxAnisotropy = this.gl.getParameter( extension.MAX_TEXTURE_MAX_ANISOTROPY_EXT );

		} else {

			this.maxAnisotropy = 0;

		}

		return this.maxAnisotropy;

	}

	/**
	 * @param {string} precision
	 * @return {string} 
	 */
	getMaxPrecision( precision ) {

		if ( precision === 'highp' ) {

			if ( this.gl.getShaderPrecisionFormat( this.gl.VERTEX_SHADER, this.gl.HIGH_FLOAT ).precision > 0 &&
			this.gl.getShaderPrecisionFormat( this.gl.FRAGMENT_SHADER, this.gl.HIGH_FLOAT ).precision > 0 ) {

				return 'highp';

			}

			precision = 'mediump';

		}

		if ( precision === 'mediump' ) {

			if ( this.gl.getShaderPrecisionFormat( this.gl.VERTEX_SHADER, this.gl.MEDIUM_FLOAT ).precision > 0 &&
			this.gl.getShaderPrecisionFormat( this.gl.FRAGMENT_SHADER, this.gl.MEDIUM_FLOAT ).precision > 0 ) {

				return 'mediump';

			}

		}

		return 'lowp';

	}

}


export { WebGLCapabilities };
