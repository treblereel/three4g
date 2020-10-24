class WebGLExtensions {

	/**
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl 
	 */
	constructor(gl) {

		this.gl = gl;
		this.extensions = {};

	}

	/**
	* @param {string} name
	* @return {*} 
	*/
	getExtension(name) {

		if (this.extensions[name] !== undefined) {

			return this.extensions[name];

		}

		let extension;

		switch (name) {

			case 'WEBGL_depth_texture':
				extension = this.gl.getExtension('WEBGL_depth_texture') || this.gl.getExtension('MOZ_WEBGL_depth_texture') || this.gl.getExtension('WEBKIT_WEBGL_depth_texture');
				break;

			case 'EXT_texture_filter_anisotropic':
				extension = this.gl.getExtension('EXT_texture_filter_anisotropic') || this.gl.getExtension('MOZ_EXT_texture_filter_anisotropic') || this.gl.getExtension('WEBKIT_EXT_texture_filter_anisotropic');
				break;

			case 'WEBGL_compressed_texture_s3tc':
				extension = this.gl.getExtension('WEBGL_compressed_texture_s3tc') || this.gl.getExtension('MOZ_WEBGL_compressed_texture_s3tc') || this.gl.getExtension('WEBKIT_WEBGL_compressed_texture_s3tc');
				break;

			case 'WEBGL_compressed_texture_pvrtc':
				extension = this.gl.getExtension('WEBGL_compressed_texture_pvrtc') || this.gl.getExtension('WEBKIT_WEBGL_compressed_texture_pvrtc');
				break;

			default:
				extension = this.gl.getExtension(name);

		}

		this.extensions[name] = extension;

		return extension;

	}

	/**
	 * @param {string} name
	 * @return {boolean} 
	 */
	has(name) {

		return this.getExtension(name) !== null;

	}

	/**
	 * 
	 * @param {{isWebGL2:boolean}} capabilities 
	 */
	init(capabilities) {

		if (capabilities.isWebGL2) {

			this.getExtension('EXT_color_buffer_float');

		} else {

			this.getExtension('WEBGL_depth_texture');
			this.getExtension('OES_texture_float');
			this.getExtension('OES_texture_half_float');
			this.getExtension('OES_texture_half_float_linear');
			this.getExtension('OES_standard_derivatives');
			this.getExtension('OES_element_index_uint');
			this.getExtension('OES_vertex_array_object');
			this.getExtension('ANGLE_instanced_arrays');

		}

		this.getExtension('OES_texture_float_linear');
		this.getExtension('EXT_color_buffer_half_float');

	}

	/**
	 * @param {string} name
	 * @return {*} 
	 */
	get(name) {

		const extension = this.getExtension(name);

		if (extension === null) {

			console.warn('THREE.WebGLRenderer: ' + name + ' extension not supported.');

		}

		return extension;

	}


}


export { WebGLExtensions };
