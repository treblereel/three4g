import { WebGLGeometries } from './WebGLGeometries.js';
import { WebGLAttributes } from './WebGLAttributes.js';
import { WebGLInfo } from './WebGLInfo.js';

//closure compiler
import { Object3DInterface } from '../../closure/core/Object3DInterface.js';
import { BufferGeometry } from '../../core/BufferGeometry.js';
import { Event } from '../../core/EventDispatcher.js';

class WebGLObjects {

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLGeometries} geometries 
	 * @param {WebGLAttributes} attributes 
	 * @param {WebGLInfo} info 
	 */
	constructor( gl, geometries, attributes, info ) {

		this.updateMap = new WeakMap();

		this.gl = gl;
		this.geometries = geometries;
		this.attributes = attributes;
		this.info = info;


	}

	/**
	 * @param {Object3DInterface} object 
	 * @return {BufferGeometry}
	 */
	update( object ) {

		const frame = this.info.render.frame;

		const geometry = object.geometry;
		const buffergeometry = this.geometries.get( object, geometry );

		// Update once per frame

		if ( this.updateMap.get( buffergeometry ) !== frame ) {

			this.geometries.update( buffergeometry );

			this.updateMap.set( buffergeometry, frame );

		}

		if ( object.isInstancedMesh ) {

			if ( object.hasEventListener( 'dispose', this.onInstancedMeshDispose ) === false ) {

				object.addEventListener( 'dispose', this.onInstancedMeshDispose );

			}

			this.attributes.update( object.instanceMatrix, this.gl.ARRAY_BUFFER );

			if ( object.instanceColor !== null ) {

				this.attributes.update( object.instanceColor, this.gl.ARRAY_BUFFER );

			}

		}

		return buffergeometry;

	}

	dispose() {

		this.updateMap = new WeakMap();

	}

	/**
	 * 
	 * @param {Event} event 
	 */
	onInstancedMeshDispose( event ) {

		const instancedMesh = event.target;

		instancedMesh.removeEventListener( 'dispose', this.onInstancedMeshDispose );

		this.attributes.remove( instancedMesh.instanceMatrix );

		if ( instancedMesh.instanceColor !== null ) this.attributes.remove( instancedMesh.instanceColor );

	}


}


export { WebGLObjects };
