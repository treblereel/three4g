import { Uint16BufferAttribute, Uint32BufferAttribute } from '../../core/BufferAttribute.js';
import { arrayMax } from '../../utils.js';

import { WebGLAttributes } from './WebGLAttributes.js';
import { WebGLInfo } from './WebGLInfo.js';
import { WebGLBindingStates } from './WebGLBindingStates.js';

//closure compiler

import { Object3D } from '../../core/Object3D.js';
import { BufferGeometry } from '../../core/BufferGeometry.js';


class WebGLGeometries {

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLAttributes} attributes 
	 * @param {WebGLInfo} info 
	 * @param {WebGLBindingStates} bindingStates 
	 */
	constructor( gl, attributes, info, bindingStates ) {

		this.gl = gl;
		this.attributes = attributes;
		this.info = info;
		this.bindingStates = bindingStates;

		this.geometries = {};
		this.wireframeAttributes = new WeakMap();
	}	

	onGeometryDispose( event ) {

		const geometry = event.target;

		if ( geometry.index !== null ) {

			this.attributes.remove( geometry.index );

		}

		for ( const name in geometry.attributes ) {

			this.attributes.remove( geometry.attributes[ name ] );

		}

		geometry.removeEventListener( 'dispose', this.onGeometryDispose );

		delete this.geometries[ geometry.id ];

		const attribute = this.wireframeAttributes.get( geometry );

		if ( attribute ) {

			this.attributes.remove( attribute );
			this.wireframeAttributes.delete( geometry );

		}

		this.bindingStates.releaseStatesOfGeometry( geometry );

		if ( geometry.isInstancedBufferGeometry === true ) {

			delete geometry._maxInstanceCount;

		}

		//

		this.info.memory.geometries --;

	}

	/**
	 * @param {Object3D} object 
	 * @param {BufferGeometry} geometry 
	 * @return {BufferGeometry}
	 */
	get( object, geometry ) {

		if ( this.geometries[ geometry.id ] === true ) return geometry;

		geometry.addEventListener( 'dispose', this.onGeometryDispose );

		this.geometries[ geometry.id ] = true;

		this.info.memory.geometries ++;

		return geometry;

	}

	/**
	 * @param {BufferGeometry} geometry 
	 */
	update( geometry ) {

		const geometryAttributes = geometry.attributes;

		// Updating index buffer in VAO now. See WebGLBindingStates.

		for ( const name in geometryAttributes ) {

			this.attributes.update( geometryAttributes[ name ], this.gl.ARRAY_BUFFER );

		}

		// morph targets
		const morphAttributes = geometry.morphAttributes;

		for ( const name in morphAttributes ) {

			const array = morphAttributes[ name ];

			for ( let i = 0, l = array.length; i < l; i ++ ) {

				this.attributes.update( array[ i ], this.gl.ARRAY_BUFFER );

			}

		}

	}

	updateWireframeAttribute( geometry ) {

		const indices = [];

		const geometryIndex = geometry.index;
		const geometryPosition = geometry.attributes.position;
		let version = 0;

		if ( geometryIndex !== null ) {

			const array = geometryIndex.array;
			version = geometryIndex.version;

			for ( let i = 0, l = array.length; i < l; i += 3 ) {

				const a = array[ i + 0 ];
				const b = array[ i + 1 ];
				const c = array[ i + 2 ];

				indices.push( a, b, b, c, c, a );

			}

		} else {

			const array = geometryPosition.array;
			version = geometryPosition.version;

			for ( let i = 0, l = ( array.length / 3 ) - 1; i < l; i += 3 ) {

				const a = i + 0;
				const b = i + 1;
				const c = i + 2;

				indices.push( a, b, b, c, c, a );

			}

		}

		const attribute = new ( arrayMax( indices ) > 65535 ? Uint32BufferAttribute : Uint16BufferAttribute )( indices, 1 );
		attribute.version = version;

		// Updating index buffer in VAO now. See WebGLBindingStates

		//

		const previousAttribute = this.wireframeAttributes.get( geometry );

		if ( previousAttribute ) this.attributes.remove( previousAttribute );

		//

		this.wireframeAttributes.set( geometry, attribute );

	}

	/**
	 * @param {BufferGeometry} geometry 
	 * @return {BufferGeometry}
	 */
	getWireframeAttribute( geometry ) {

		const currentAttribute = this.wireframeAttributes.get( geometry );

		if ( currentAttribute ) {

			const geometryIndex = geometry.index;

			if ( geometryIndex !== null ) {

				// if the attribute is obsolete, create a new one

				if ( currentAttribute.version < geometryIndex.version ) {

					this.updateWireframeAttribute( geometry );

				}

			}

		} else {

			this.updateWireframeAttribute( geometry );

		}

		return this.wireframeAttributes.get( geometry );

	}

}


export { WebGLGeometries };
