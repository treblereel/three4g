import { Material } from './Material.js';
import { cloneUniforms } from '../renderers/shaders/UniformsUtils.js';

import default_vertex from '../renderers/shaders/ShaderChunk/default_vertex.glsl.js';
import default_fragment from '../renderers/shaders/ShaderChunk/default_fragment.glsl.js';

import { ShaderMaterialParameters } from '../closure/material/ShaderMaterialParameters.js';


/**
 * parameters = {
 *  defines: { "label" : "value" },
 *  uniforms: { "parameter1": { value: 1.0 }, "parameter2": { value2: 2 } },
 *
 *  fragmentShader: <string>,
 *  vertexShader: <string>,
 *
 *  wireframe: <boolean>,
 *  wireframeLinewidth: <float>,
 *
 *  lights: <bool>,
 *
 *  skinning: <bool>,
 *  morphTargets: <bool>,
 *  morphNormals: <bool>
 * }
 */

class ShaderMaterial extends Material {

	/** 
	 * @param {ShaderMaterialParameters|Object|null=} parameters
	 */
	constructor( parameters ) {

		super();

		/** @type {string} */
		this.type = 'ShaderMaterial';
		/** @type {Object|Map<(Object|null),(Object|null)>} */
		this.defines = {};
		/** @type {Object} */
		this.uniforms = {};

		/** @type {string} */
		this.vertexShader = default_vertex;
		/** @type {string} */
		this.fragmentShader = default_fragment;

		/** @type {number} */
		this.linewidth = 1;

		/** @type {boolean} */
		this.wireframe = false;
		/** @type {number} */
		this.wireframeLinewidth = 1;

		/** @type {boolean} */
		this.fog = false; // set to use scene fog
		/** @type {boolean} */
		this.lights = false; // set to use scene lights
		/** @type {boolean} */
		this.clipping = false; // set to use user-defined clipping planes

		/** @type {boolean} */
		this.skinning = false; // set to use skinning attribute streams
		/** @type {boolean} */
		this.morphTargets = false; // set to use morph targets
		/** @type {boolean} */
		this.morphNormals = false; // set to use morph normals

		/** @type {{derivatives : boolean, fragDepth : boolean, drawBuffers : boolean, shaderTextureLOD : boolean}} */
		this.extensions = {
			derivatives: false, // set to use derivatives
			fragDepth: false, // set to use fragment depth values
			drawBuffers: false, // set to use draw buffers
			shaderTextureLOD: false // set to use shader texture LOD
		};

		// When rendered geometry doesn't include these attributes but the material does,
		// use these default values in WebGL. This avoids errors when buffer data is missing.

		/** @type { { color : Array<number>, uv : Array<number>, uv2 : Array<number> } } */
		this.defaultAttributeValues = {
			'color': [ 1, 1, 1 ],
			'uv': [ 0, 0 ],
			'uv2': [ 0, 0 ]
		};

		/** @type {string|undefined} */
		this.index0AttributeName = undefined;
		/** @type {boolean} */
		this.uniformsNeedUpdate = false;

		/** @type {number|null} */
		this.glslVersion = null;

		if ( parameters !== undefined ) {

			if ( parameters.attributes !== undefined ) {

				console.error( 'THREE.ShaderMaterial: attributes should now be defined in THREE.BufferGeometry instead.' );

			}

			this.setValues( parameters );

		}

		/** @type {boolean} */
		this.isShaderMaterial = true;

	}

	/**
	 * 
	 * @param {ShaderMaterial} source 
	 * @return {ShaderMaterial}
	 * @suppress {checkTypes} 
	 */
	copy( source ) {

		Material.prototype.copy.call( this, source );

		this.fragmentShader = source.fragmentShader;
		this.vertexShader = source.vertexShader;

		this.uniforms = cloneUniforms( source.uniforms );

		this.defines = Object.assign( {}, source.defines );

		this.wireframe = source.wireframe;
		this.wireframeLinewidth = source.wireframeLinewidth;

		this.lights = source.lights;
		this.clipping = source.clipping;

		this.skinning = source.skinning;

		this.morphTargets = source.morphTargets;
		this.morphNormals = source.morphNormals;

		this.extensions = Object.assign( {}, source.extensions );

		this.glslVersion = source.glslVersion;

		return this;

	}

	toJSON( meta ) {

		const data = Material.prototype.toJSON.call( this, meta );

		data.glslVersion = this.glslVersion;
		data.uniforms = {};

		for ( const name in this.uniforms ) {

			const uniform = this.uniforms[ name ];
			const value = uniform.value;

			if ( value && value.isTexture ) {

				data.uniforms[ name ] = {
					type: 't',
					value: value.toJSON( meta ).uuid
				};

			} else if ( value && value.isColor ) {

				data.uniforms[ name ] = {
					type: 'c',
					value: value.getHex()
				};

			} else if ( value && value.isVector2 ) {

				data.uniforms[ name ] = {
					type: 'v2',
					value: value.toArray()
				};

			} else if ( value && value.isVector3 ) {

				data.uniforms[ name ] = {
					type: 'v3',
					value: value.toArray()
				};

			} else if ( value && value.isVector4 ) {

				data.uniforms[ name ] = {
					type: 'v4',
					value: value.toArray()
				};

			} else if ( value && value.isMatrix3 ) {

				data.uniforms[ name ] = {
					type: 'm3',
					value: value.toArray()
				};

			} else if ( value && value.isMatrix4 ) {

				data.uniforms[ name ] = {
					type: 'm4',
					value: value.toArray()
				};

			} else {

				data.uniforms[ name ] = {
					value: value
				};

				// note: the array variants v2v, v3v, v4v, m4v and tv are not supported so far

			}

		}

		if ( Object.keys( this.defines ).length > 0 ) data.defines = this.defines;

		data.vertexShader = this.vertexShader;
		data.fragmentShader = this.fragmentShader;

		const extensions = {};

		for ( const key in this.extensions ) {

			if ( this.extensions[ key ] === true ) extensions[ key ] = true;

		}

		if ( Object.keys( extensions ).length > 0 ) data.extensions = extensions;

		return data;

	}

}


export { ShaderMaterial };
