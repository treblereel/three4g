import { WebGLCapabilities } from './WebGLCapabilities.js';

class WebGLAttributes {

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLCapabilities} capabilities 
	 */
	constructor( gl, capabilities ) {

		this.gl = gl;	
		this.capabilities = capabilities;	

		this.isWebGL2 = capabilities.isWebGL2;

		this.buffers = new WeakMap();

	}

	createBuffer( attribute, bufferType ) {

		const array = attribute.array;
		const usage = attribute.usage;

		const buffer = this.gl.createBuffer();

		this.gl.bindBuffer( bufferType, buffer );
		this.gl.bufferData( bufferType, array, usage );

		attribute.onUploadCallback();

		let type = this.gl.FLOAT;

		if ( array instanceof Float32Array ) {

			type = this.gl.FLOAT;

		} else if ( array instanceof Float64Array ) {

			console.warn( 'THREE.WebGLAttributes: Unsupported data buffer format: Float64Array.' );

		} else if ( array instanceof Uint16Array ) {

			if ( attribute.isFloat16BufferAttribute ) {

				if ( this.isWebGL2 ) {

					type = this.gl.HALF_FLOAT;

				} else {

					console.warn( 'THREE.WebGLAttributes: Usage of Float16BufferAttribute requires WebGL2.' );

				}

			} else {

				type = this.gl.UNSIGNED_SHORT;

			}

		} else if ( array instanceof Int16Array ) {

			type = this.gl.SHORT;

		} else if ( array instanceof Uint32Array ) {

			type = this.gl.UNSIGNED_INT;

		} else if ( array instanceof Int32Array ) {

			type = this.gl.INT;

		} else if ( array instanceof Int8Array ) {

			type = this.gl.BYTE;

		} else if ( array instanceof Uint8Array ) {

			type = this.gl.UNSIGNED_BYTE;

		}

		return {
			buffer: buffer,
			type: type,
			bytesPerElement: array.BYTES_PER_ELEMENT,
			version: attribute.version
		};

	}

	updateBuffer( buffer, attribute, bufferType ) {

		const array = attribute.array;
		const updateRange = attribute.updateRange;

		this.gl.bindBuffer( bufferType, buffer );

		if ( updateRange.count === - 1 ) {

			// Not using update ranges

			this.gl.bufferSubData( bufferType, 0, array );

		} else {

			if ( this.isWebGL2 ) {

				this.gl.bufferSubData( bufferType, updateRange.offset * array.BYTES_PER_ELEMENT,
					array, updateRange.offset, updateRange.count );

			} else {

				this.gl.bufferSubData( bufferType, updateRange.offset * array.BYTES_PER_ELEMENT,
					array.subarray( updateRange.offset, updateRange.offset + updateRange.count ) );

			}

			updateRange.count = - 1; // reset range

		}

	}

	//

	get( attribute ) {

		if ( attribute.isInterleavedBufferAttribute ) attribute = attribute.data;

		return this.buffers.get( attribute );

	}

	remove( attribute ) {

		if ( attribute.isInterleavedBufferAttribute ) attribute = attribute.data;

		const data = this.buffers.get( attribute );

		if ( data ) {

			this.gl.deleteBuffer( data.buffer );

			this.buffers.delete( attribute );

		}

	}

	update( attribute, bufferType ) {

		if ( attribute.isGLBufferAttribute ) {

			const cached = this.buffers.get( attribute );

			if ( ! cached || cached.version < attribute.version ) {

				this.buffers.set( attribute, {
					buffer: attribute.buffer,
					type: attribute.type,
					bytesPerElement: attribute.elementSize,
					version: attribute.version
				} );

			}

			return;

		}

		if ( attribute.isInterleavedBufferAttribute ) attribute = attribute.data;

		const data = this.buffers.get( attribute );

		if ( data === undefined ) {

			this.buffers.set( attribute, this.createBuffer( attribute, bufferType ) );

		} else if ( data.version < attribute.version ) {

			this.updateBuffer( data.buffer, attribute, bufferType );

			data.version = attribute.version;

		}

	}

}


export { WebGLAttributes };
