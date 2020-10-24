import { WebGLExtensions } from './WebGLExtensions.js';
import { WebGLCapabilities } from './WebGLCapabilities.js';
import { WebGLInfo } from './WebGLInfo.js';

class WebGLBufferRenderer {

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLInfo} info 
	 * @param {WebGLCapabilities} capabilities 
	 */
	constructor( gl, extensions, info, capabilities ) {

		this.gl = gl;
		this.extensions = extensions;
		this.info = info;
		this.capabilities = capabilities;

		this.isWebGL2 = capabilities.isWebGL2;

		this.mode = undefined;

	}

	setMode( value ) {

		this.mode = value;

	}

	/**
	 * 
	 * @param {number} start 
	 * @param {number} count 
	 */
	render( start, count ) {

		this.gl.drawArrays( this.mode, start, count );

		this.info.update( count, this.mode, 1 );

	}

	/**
	 * 
	 * @param {number} start 
	 * @param {number} count 
	 * @param {number} primcount 
	 */
	renderInstances( start, count, primcount ) {

		if ( primcount === 0 ) return;

		let extension, methodName;

		if ( this.isWebGL2 ) {

			extension = this.gl;
			methodName = 'drawArraysInstanced';

		} else {

			extension = this.extensions.get( 'ANGLE_instanced_arrays' );
			methodName = 'drawArraysInstancedANGLE';

			if ( extension === null ) {

				console.error( 'THREE.WebGLBufferRenderer: using THREE.InstancedBufferGeometry but hardware does not support extension ANGLE_instanced_arrays.' );
				return;

			}

		}

		extension[ methodName ]( this.mode, start, count, primcount );

		this.info.update( count, this.mode, primcount );

	}

}


export { WebGLBufferRenderer };
