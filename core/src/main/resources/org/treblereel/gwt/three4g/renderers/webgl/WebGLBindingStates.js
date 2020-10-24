import { WebGLExtensions } from './WebGLExtensions.js';
import { WebGLCapabilities } from './WebGLCapabilities.js';
import { WebGLAttributes } from './WebGLAttributes.js';
import { WebGLProgram } from './WebGLProgram.js';


//closure compiler

import {Object3DInterface} from '../../closure/core/Object3DInterface.js';
import {MaterialInterface} from '../../closure/material/MaterialInterface.js';
import {GeometryInterface} from '../../closure/geometry/GeometryInterface.js';
import {BufferAttribute} from '../../core/BufferAttribute.js';

class WebGLBindingStates {

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLAttributes} attributes 
	 * @param {WebGLCapabilities} capabilities 
	 */
	constructor( gl, extensions, attributes, capabilities ) {

		/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
		this.gl = gl;
		/** @type {WebGLExtensions} */
		this.extensions = extensions;
		/** @type {WebGLAttributes} */
		this.attributes = attributes;
		/** @type {WebGLCapabilities} */
		this.capabilities = capabilities;
		/** @type {number} */
		this.maxVertexAttributes = /** @type {number} */ (gl.getParameter( gl.MAX_VERTEX_ATTRIBS ));

		this.extension = capabilities.isWebGL2 ? null : extensions.get( 'OES_vertex_array_object' );
		this.vaoAvailable = capabilities.isWebGL2 || this.extension !== null;

		this.bindingStates = {};

		this.defaultState = this.createBindingState( null );
		this.currentState = this.defaultState;
	}	

	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {MaterialInterface} material 
	 * @param {WebGLProgram} program 
	 * @param {GeometryInterface} geometry 
	 * @param {BufferAttribute} index 
	 */
	setup( object, material, program, geometry, index ) {

		let updateBuffers = false;

		if ( this.vaoAvailable ) {

			const state = this.getBindingState( geometry, program, material );

			if ( this.currentState !== state ) {

				this.currentState = state;
				this.bindVertexArrayObject( this.currentState.object );

			}

			updateBuffers = this.needsUpdate( geometry, index );

			if ( updateBuffers ) this.saveCache( geometry, index );

		} else {

			const wireframe = ( material.wireframe === true );

			if ( this.currentState.geometry !== geometry.id ||
				this.currentState.program !== program.id ||
				this.currentState.wireframe !== wireframe ) {

					this.currentState.geometry = geometry.id;
					this.currentState.program = program.id;
					this.currentState.wireframe = wireframe;

				updateBuffers = true;

			}

		}

		if ( object.isInstancedMesh === true ) {

			updateBuffers = true;

		}

		if ( index !== null ) {

			this.attributes.update( index, this.gl.ELEMENT_ARRAY_BUFFER );

		}

		if ( updateBuffers ) {

			this.setupVertexAttributes( object, material, program, geometry );

			if ( index !== null ) {

				this.gl.bindBuffer( this.gl.ELEMENT_ARRAY_BUFFER, this.attributes.get( index ).buffer );

			}

		}

	}

	createVertexArrayObject() {

		if ( this.capabilities.isWebGL2 ) return this.gl.createVertexArray();

		return this.extension.createVertexArrayOES();

	}

	bindVertexArrayObject( vao ) {

		if ( this.capabilities.isWebGL2 ) return this.gl.bindVertexArray( vao );

		return this.extension.bindVertexArrayOES( vao );

	}

	deleteVertexArrayObject( vao ) {

		if ( this.capabilities.isWebGL2 ) return this.gl.deleteVertexArray( vao );

		return this.extension.deleteVertexArrayOES( vao );

	}

	getBindingState( geometry, program, material ) {

		const wireframe = ( material.wireframe === true );

		let programMap = this.bindingStates[ geometry.id ];

		if ( programMap === undefined ) {

			programMap = {};
			this.bindingStates[ geometry.id ] = programMap;

		}

		let stateMap = programMap[ program.id ];

		if ( stateMap === undefined ) {

			stateMap = {};
			programMap[ program.id ] = stateMap;

		}

		let state = stateMap[ wireframe ];

		if ( state === undefined ) {

			state = this.createBindingState( this.createVertexArrayObject() );
			stateMap[ wireframe ] = state;

		}

		return state;

	}

	createBindingState( vao ) {

		const newAttributes = [];
		const enabledAttributes = [];
		const attributeDivisors = [];

		for ( let i = 0; i < this.maxVertexAttributes; i ++ ) {

			newAttributes[ i ] = 0;
			enabledAttributes[ i ] = 0;
			attributeDivisors[ i ] = 0;

		}

		return {

			// for backward compatibility on non-VAO support browser
			geometry: null,
			program: null,
			wireframe: false,

			newAttributes: newAttributes,
			enabledAttributes: enabledAttributes,
			attributeDivisors: attributeDivisors,
			object: vao,
			attributes: {},
			index: null

		};

	}

	/**
	 * 
	 * @param {GeometryInterface} geometry 
	 * @param {BufferAttribute} index 
	 * @return {boolean}
	 */
	needsUpdate( geometry, index ) {

		const cachedAttributes = this.currentState.attributes;
		const geometryAttributes = geometry.attributes;

		let attributesNum = 0;

		for ( const key in geometryAttributes ) {

			const cachedAttribute = cachedAttributes[ key ];
			const geometryAttribute = geometryAttributes[ key ];

			if ( cachedAttribute === undefined ) return true;

			if ( cachedAttribute.attribute !== geometryAttribute ) return true;

			if ( cachedAttribute.data !== geometryAttribute.data ) return true;

			attributesNum ++;

		}

		if ( this.currentState.attributesNum !== attributesNum ) return true;

		if ( this.currentState.index !== index ) return true;

		return false;

	}

	/**
	 * 
	 * @param {GeometryInterface} geometry 
	 * @param {number} index 
	 */
	saveCache( geometry, index ) {

		const cache = {};
		const attributes = geometry.attributes;
		let attributesNum = 0;

		for ( const key in attributes ) {

			const attribute = attributes[ key ];

			const data = {};
			data.attribute = attribute;

			if ( attribute.data ) {

				data.data = attribute.data;

			}

			cache[ key ] = data;

			attributesNum ++;

		}

		this.currentState.attributes = cache;
		this.currentState.attributesNum = attributesNum;

		this.currentState.index = index;

	}

	initAttributes() {

		const newAttributes = this.currentState.newAttributes;

		for ( let i = 0, il = newAttributes.length; i < il; i ++ ) {

			newAttributes[ i ] = 0;

		}

	}

	enableAttribute( attribute ) {

		this.enableAttributeAndDivisor( attribute, 0 );

	}

	enableAttributeAndDivisor( attribute, meshPerAttribute ) {

		const newAttributes = this.currentState.newAttributes;
		const enabledAttributes = this.currentState.enabledAttributes;
		const attributeDivisors = this.currentState.attributeDivisors;

		newAttributes[ attribute ] = 1;

		if ( enabledAttributes[ attribute ] === 0 ) {

			this.gl.enableVertexAttribArray( attribute );
			enabledAttributes[ attribute ] = 1;

		}

		if ( attributeDivisors[ attribute ] !== meshPerAttribute ) {

			const extension = this.capabilities.isWebGL2 ? this.gl : this.extensions.get( 'ANGLE_instanced_arrays' );

			extension[ this.capabilities.isWebGL2 ? 'vertexAttribDivisor' : 'vertexAttribDivisorANGLE' ]( attribute, meshPerAttribute );
			attributeDivisors[ attribute ] = meshPerAttribute;

		}

	}

	disableUnusedAttributes() {

		const newAttributes = this.currentState.newAttributes;
		const enabledAttributes = this.currentState.enabledAttributes;

		for ( let i = 0, il = enabledAttributes.length; i < il; i ++ ) {

			if ( enabledAttributes[ i ] !== newAttributes[ i ] ) {

				this.gl.disableVertexAttribArray( i );
				enabledAttributes[ i ] = 0;

			}

		}

	}

	vertexAttribPointer( index, size, type, normalized, stride, offset ) {

		if ( this.capabilities.isWebGL2 === true && ( type === this.gl.INT || type === this.gl.UNSIGNED_INT ) ) {

			this.gl.vertexAttribIPointer( index, size, type, stride, offset );

		} else {

			this.gl.vertexAttribPointer( index, size, type, normalized, stride, offset );

		}

	}

	setupVertexAttributes( object, material, program, geometry ) {

		if ( this.capabilities.isWebGL2 === false && ( object.isInstancedMesh || geometry.isInstancedBufferGeometry ) ) {

			if ( this.extensions.get( 'ANGLE_instanced_arrays' ) === null ) return;

		}

		this.initAttributes();

		const geometryAttributes = geometry.attributes;

		const programAttributes = program.getAttributes();

		const materialDefaultAttributeValues = material.defaultAttributeValues;

		for ( const name in programAttributes ) {

			const programAttribute = programAttributes[ name ];

			if ( programAttribute >= 0 ) {

				const geometryAttribute = geometryAttributes[ name ];

				if ( geometryAttribute !== undefined ) {
					const normalized = geometryAttribute.normalized;
					const size = geometryAttribute.itemSize;

					const attribute = this.attributes.get( geometryAttribute );

					// TODO Attribute may not be available on context restore

					if ( attribute === undefined ) continue;

					const buffer = attribute.buffer;
					const type = attribute.type;
					const bytesPerElement = attribute.bytesPerElement;

					if ( geometryAttribute.isInterleavedBufferAttribute ) {

						const data = geometryAttribute.data;
						const stride = data.stride;
						const offset = geometryAttribute.offset;

						if ( data && data.isInstancedInterleavedBuffer ) {

							this.enableAttributeAndDivisor( programAttribute, data.meshPerAttribute );

							if ( geometry._maxInstanceCount === undefined ) {

								geometry._maxInstanceCount = data.meshPerAttribute * data.count;

							}

						} else {

							this.enableAttribute( programAttribute );

						}

						this.gl.bindBuffer( this.gl.ARRAY_BUFFER, buffer );
						this.vertexAttribPointer( programAttribute, size, type, normalized, stride * bytesPerElement, offset * bytesPerElement );

					} else {

						if ( geometryAttribute.isInstancedBufferAttribute ) {

							this.enableAttributeAndDivisor( programAttribute, geometryAttribute.meshPerAttribute );

							if ( geometry._maxInstanceCount === undefined ) {

								geometry._maxInstanceCount = geometryAttribute.meshPerAttribute * geometryAttribute.count;

							}

						} else {

							this.enableAttribute( programAttribute );

						}

						this.gl.bindBuffer( this.gl.ARRAY_BUFFER, buffer );
						this.vertexAttribPointer( programAttribute, size, type, normalized, 0, 0 );

					}

				} else if ( name === 'instanceMatrix' ) {

					const attribute = this.attributes.get( object.instanceMatrix );

					// TODO Attribute may not be available on context restore

					if ( attribute === undefined ) continue;

					const buffer = attribute.buffer;
					const type = attribute.type;

					this.enableAttributeAndDivisor( programAttribute + 0, 1 );
					this.enableAttributeAndDivisor( programAttribute + 1, 1 );
					this.enableAttributeAndDivisor( programAttribute + 2, 1 );
					this.enableAttributeAndDivisor( programAttribute + 3, 1 );

					this.gl.bindBuffer( this.gl.ARRAY_BUFFER, buffer );

					this.gl.vertexAttribPointer( programAttribute + 0, 4, type, false, 64, 0 );
					this.gl.vertexAttribPointer( programAttribute + 1, 4, type, false, 64, 16 );
					this.gl.vertexAttribPointer( programAttribute + 2, 4, type, false, 64, 32 );
					this.gl.vertexAttribPointer( programAttribute + 3, 4, type, false, 64, 48 );

				} else if ( name === 'instanceColor' ) {

					const attribute = this.attributes.get( object.instanceColor );

					// TODO Attribute may not be available on context restore

					if ( attribute === undefined ) continue;

					const buffer = attribute.buffer;
					const type = attribute.type;

					this.enableAttributeAndDivisor( programAttribute, 1 );

					this.gl.bindBuffer( this.gl.ARRAY_BUFFER, buffer );

					this.gl.vertexAttribPointer( programAttribute, 3, type, false, 12, 0 );

				} else if ( materialDefaultAttributeValues !== undefined ) {
					const value = materialDefaultAttributeValues[ name ];

					if ( value !== undefined ) {

						switch ( value.length ) {

							case 2:
								this.gl.vertexAttrib2fv( programAttribute, value );
								break;

							case 3:
								this.gl.vertexAttrib3fv( programAttribute, value );
								break;

							case 4:
								this.gl.vertexAttrib4fv( programAttribute, value );
								break;

							default:
								this.gl.vertexAttrib1fv( programAttribute, value );

						}

					}

				}

			}

		}

		this.disableUnusedAttributes();

	}

	dispose() {

		this.reset();

		for ( const geometryId in this.bindingStates ) {

			const programMap = this.bindingStates[ geometryId ];

			for ( const programId in programMap ) {

				const stateMap = programMap[ programId ];

				for ( const wireframe in stateMap ) {

					this.deleteVertexArrayObject( stateMap[ wireframe ].object );

					delete stateMap[ wireframe ];

				}

				delete programMap[ programId ];

			}

			delete this.bindingStates[ geometryId ];

		}

	}

	releaseStatesOfGeometry( geometry ) {

		if ( this.bindingStates[ geometry.id ] === undefined ) return;

		const programMap = this.bindingStates[ geometry.id ];

		for ( const programId in programMap ) {

			const stateMap = programMap[ programId ];

			for ( const wireframe in stateMap ) {

				this.deleteVertexArrayObject( stateMap[ wireframe ].object );

				delete stateMap[ wireframe ];

			}

			delete programMap[ programId ];

		}

		delete this.bindingStates[ geometry.id ];

	}

	releaseStatesOfProgram( program ) {

		for ( const geometryId in this.bindingStates ) {

			const programMap = this.bindingStates[ geometryId ];

			if ( programMap[ program.id ] === undefined ) continue;

			const stateMap = programMap[ program.id ];

			for ( const wireframe in stateMap ) {

				this.deleteVertexArrayObject( stateMap[ wireframe ].object );

				delete stateMap[ wireframe ];

			}

			delete programMap[ program.id ];

		}

	}

	reset() {

		this.resetDefaultState();

		if ( this.currentState === this.defaultState ) return;

		this.currentState = this.defaultState;
		this.bindVertexArrayObject( this.currentState.object );

	}

	// for backward-compatilibity

	resetDefaultState() {

		this.defaultState.geometry = null;
		this.defaultState.program = null;
		this.defaultState.wireframe = false;

	}

}


export { WebGLBindingStates };
