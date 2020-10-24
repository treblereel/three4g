/**
 * Uniforms of a program.
 * Those form a tree structure with a special top-level container for the root,
 * which you get by calling 'new WebGLUniforms( gl, program )'.
 *
 *
 * Properties of inner nodes including the top-level container:
 *
 * .seq - array of nested uniforms
 * .map - nested uniforms by name
 *
 *
 * Methods of all nodes except the top-level container:
 *
 * .setValue( gl, value, [textures] )
 *
 * 		uploads a uniform value(s)
 *  	the 'textures' parameter is needed for sampler uniforms
 *
 *
 * Static methods of the top-level container (textures factorizations):
 *
 * .upload( gl, seq, values, textures )
 *
 * 		sets uniforms in 'seq' to 'values[id].value'
 *
 * .seqWithValue( seq, values ) : filteredSeq
 *
 * 		filters 'seq' entries with corresponding entry in values
 *
 *
 * Methods of the top-level container (textures factorizations):
 *
 * .setValue( gl, name, value, textures )
 *
 * 		sets uniform with  name 'name' to 'value'
 *
 * .setOptional( gl, obj, prop )
 *
 * 		like .set for an optional property of the object
 *
 */

import { CubeTexture } from '../../textures/CubeTexture.js';
import { Texture } from '../../textures/Texture.js';
import { DataTexture2DArray } from '../../textures/DataTexture2DArray.js';
import { DataTexture3D } from '../../textures/DataTexture3D.js';

import { WebGLTextures } from './WebGLTextures.js';

//closure compiler
import { WebGLRenderTargetInterface } from '../../closure/renderers/WebGLRenderTargetInterface.js';
import { TextureInterface } from '../../closure/textures/TextureInterface.js';
import { Vector2 } from '../../math/Vector2.js';
import { Vector3 } from '../../math/Vector3.js';
import { Vector4 } from '../../math/Vector4.js';



const emptyTexture = new Texture();
const emptyTexture2dArray = new DataTexture2DArray();
const emptyTexture3d = new DataTexture3D();
const emptyCubeTexture = new CubeTexture();

// --- Utilities ---

// Array Caches (provide typed arrays for temporary by size)
const arrayCacheF32 = [];
const arrayCacheI32 = [];

// Float32Array caches used for uploading Matrix uniforms

const mat4array = new Float32Array(16);
const mat3array = new Float32Array(9);
const mat2array = new Float32Array(4);

// Flattening for arrays of vectors and matrices
/**
 * @suppress {checkTypes}  
 * @param {Array<Float32Array>} array 
 * @param {number} nBlocks 
 * @param {number} blockSize
 * @return {Array} 
 */
function flatten(array, nBlocks, blockSize) {

	const firstElem = array[0];

	if (firstElem <= 0 || firstElem > 0) return array;
	// unoptimized: ! isNaN( firstElem )
	// see http://jacksondunstan.com/articles/983

	const n = nBlocks * blockSize;
	let r = arrayCacheF32[n];

	if (r === undefined) {

		r = new Float32Array(n);
		arrayCacheF32[n] = r;

	}

	if (nBlocks !== 0) {

		firstElem.toArray(r, 0);

		for (let i = 1, offset = 0; i !== nBlocks; ++i) {

			offset += blockSize;
			array[i].toArray(r, offset);

		}

	}

	return r;

}

/**
 * 
 * @param {Array} a 
 * @param {Array<number>|TypedArray} b 
 * @return {boolean}
 * 
 */
function arraysEqual(a, b) {

	if (a.length !== b.length) return false;

	for (let i = 0, l = a.length; i < l; i++) {

		if (a[i] !== b[i]) return false;

	}

	return true;

}

/**
 * 
 * @param {Array<number>|TypedArray|null} a 
 * @param {Array<number>|TypedArray|null} b 
 */
function copyArray(a, b) {

	for (let i = 0, l = b.length; i < l; i++) {

		a[i] = b[i];

	}

}

// Texture unit allocation
/**
 * 
 * @param {WebGLTextures} textures 
 * @param {number} n
 * @return {Array<number>} 
 */
function allocTexUnits(textures, n) {

	let r = arrayCacheI32[n];

	if (r === undefined) {

		r = new Int32Array(n);
		arrayCacheI32[n] = r;

	}

	for (let i = 0; i !== n; ++i) {

		r[i] = textures.allocateTextureUnit();

	}

	return r;

}


class UniformParent {

	/**
	 * 
	 * @param {number} id 
	   * @param {WebGLActiveInfo} activeInfo 
	 * @param {WebGLUniformLocation} addr 
	 */
	constructor(id, activeInfo, addr) {

		this.id = id;
		this.addr = addr;
		this.cache = [];
		this.size = activeInfo.size;
		this.activeInfo = activeInfo;

		// this.path = activeInfo.name; // DEBUG

	}

	// --- Setters ---

	// Note: Defining these methods externally, because they come in a bunch
	// and this way their names minify.

	// Single scalar

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {number} v 
	 */
	setValueV1f(gl, v) {

		const cache = this.cache;

		if (cache[0] === v) return;

		gl.uniform1f(this.addr, v);

		cache[0] = v;

	}

	// Single float vector (from flat array or THREE.VectorN)

	/**
	   * @suppress {checkTypes}  
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<number>| Vector2} v 
	 */
	setValueV2f(gl, v) {

		const cache = this.cache;

		if (v.x !== undefined) {

			if (cache[0] !== v.x || cache[1] !== v.y) {

				gl.uniform2f(this.addr, v.x, v.y);

				cache[0] = v.x;
				cache[1] = v.y;

			}

		} else {

			if (arraysEqual(cache, v)) return;

			gl.uniform2fv(this.addr, v);

			copyArray(cache, v);

		}

	}

	/**
	 * @suppress {checkTypes}
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<number>| Vector3} v 
	 */
	setValueV3f(gl, v) {

		const cache = this.cache;

		if (v.x !== undefined) {

			if (cache[0] !== v.x || cache[1] !== v.y || cache[2] !== v.z) {

				gl.uniform3f(this.addr, v.x, v.y, v.z);

				cache[0] = v.x;
				cache[1] = v.y;
				cache[2] = v.z;

			}

		} else if (v.r !== undefined) {

			if (cache[0] !== v.r || cache[1] !== v.g || cache[2] !== v.b) {

				gl.uniform3f(this.addr, v.r, v.g, v.b);

				cache[0] = v.r;
				cache[1] = v.g;
				cache[2] = v.b;

			}

		} else {

			if (arraysEqual(cache, v)) return;

			gl.uniform3fv(this.addr, v);

			copyArray(cache, v);

		}

	}

	/**
	 * @suppress {checkTypes}  
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<number>| Vector4} v 
	 */
	setValueV4f(gl, v) {

		const cache = this.cache;

		if (v.x !== undefined) {

			if (cache[0] !== v.x || cache[1] !== v.y || cache[2] !== v.z || cache[3] !== v.w) {

				gl.uniform4f(this.addr, v.x, v.y, v.z, v.w);

				cache[0] = v.x;
				cache[1] = v.y;
				cache[2] = v.z;
				cache[3] = v.w;

			}

		} else {

			if (arraysEqual(cache, v)) return;

			gl.uniform4fv(this.addr, v);

			copyArray(cache, v);

		}

	}

	// Single matrix (from flat array or MatrixN)

	/**
	 * @suppress {checkTypes}  
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueM2(gl, v) {

		const cache = this.cache;
		const elements = v.elements;

		if (elements === undefined) {

			if (arraysEqual(cache, v)) return;

			gl.uniformMatrix2fv(this.addr, false, v);

			copyArray(cache, v);

		} else {

			if (arraysEqual(cache, elements)) return;

			mat2array.set(elements);

			gl.uniformMatrix2fv(this.addr, false, mat2array);

			copyArray(cache, elements);

		}

	}

	/**
	 * @suppress {checkTypes}
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<number>} v 
	 */
	setValueM3(gl, v) {

		const cache = this.cache;
		const elements = v.elements;

		if (elements === undefined) {

			if (arraysEqual(cache, v)) return;

			gl.uniformMatrix3fv(this.addr, false, v);

			copyArray(cache, v);

		} else {

			if (arraysEqual(cache, elements)) return;

			mat3array.set(elements);

			gl.uniformMatrix3fv(this.addr, false, mat3array);

			copyArray(cache, elements);

		}

	}

	/**
 	 * @suppress {checkTypes}
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<number>|TypedArray} v 
	 */
	setValueM4(gl, v) {

		const cache = this.cache;
		const elements = v.elements;

		if (elements === undefined) {

			if (arraysEqual(cache, v)) return;

			gl.uniformMatrix4fv(this.addr, false, v);

			copyArray(cache, v);

		} else {

			if (arraysEqual(cache, elements)) return;

			mat4array.set(elements);

			gl.uniformMatrix4fv(this.addr, false, mat4array);

			copyArray(cache, elements);

		}

	}

	// Single texture (2D / Cube)

	/**
	 * @suppress {checkTypes}
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLRenderTargetInterface} v 
	 * @param {WebGLTextures} textures 
	 */
	setValueT1(gl, v, textures) {

		const cache = this.cache;
		const unit = textures.allocateTextureUnit();

		if (cache[0] !== unit) {

			gl.uniform1i(this.addr, unit);
			cache[0] = unit;

		}

		textures.safeSetTexture2D(v || emptyTexture, unit);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLRenderTargetInterface} v 
	 * @param {WebGLTextures} textures 
	 */
	setValueT2DArray1(gl, v, textures) {

		const cache = this.cache;
		const unit = textures.allocateTextureUnit();

		if (cache[0] !== unit) {

			gl.uniform1i(this.addr, unit);
			cache[0] = unit;

		}

		textures.setTexture2DArray(v || emptyTexture2dArray, unit);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {TextureInterface} v 
	   * @param {WebGLTextures} textures 
	 */
	setValueT3D1(gl, v, textures) {

		const cache = this.cache;
		const unit = textures.allocateTextureUnit();

		if (cache[0] !== unit) {

			gl.uniform1i(this.addr, unit);
			cache[0] = unit;

		}

		textures.setTexture3D(v || emptyTexture3d, unit);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLRenderTargetInterface} v 
	 * @param {WebGLTextures} textures 
	 */
	setValueT6(gl, v, textures) {

		const cache = this.cache;
		const unit = textures.allocateTextureUnit();

		if (cache[0] !== unit) {

			gl.uniform1i(this.addr, unit);
			cache[0] = unit;

		}

		textures.safeSetTextureCube(v || emptyCubeTexture, unit);

	}

	// Integer / Boolean vectors or arrays thereof (always flat arrays)

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {boolean|number} v 
	 */
	setValueV1i(gl, v) {

		const cache = this.cache;

		if (cache[0] === v) return;

		gl.uniform1i(this.addr, v);

		cache[0] = v;

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV2i(gl, v) {

		const cache = this.cache;

		if (arraysEqual(cache, v)) return;

		gl.uniform2iv(this.addr, v);

		copyArray(cache, v);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV3i(gl, v) {

		const cache = this.cache;

		if (arraysEqual(cache, v)) return;

		gl.uniform3iv(this.addr, v);

		copyArray(cache, v);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV4i(gl, v) {

		const cache = this.cache;

		if (arraysEqual(cache, v)) return;

		gl.uniform4iv(this.addr, v);

		copyArray(cache, v);

	}

	// uint

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {*} v 
	 */
	setValueV1ui(gl, v) {

		const cache = this.cache;

		if (cache[0] === v) return;

		gl.uniform1ui(this.addr, v);

		cache[0] = v;

	}

	// Helper to pick the right setter for the singular case

	/**
	 * 
	 * @param {number} type
	 */
	getSingularSetter(type) {

		switch (type) {

			case 0x1406: return this.setValueV1f; // FLOAT
			case 0x8b50: return this.setValueV2f; // _VEC2
			case 0x8b51: return this.setValueV3f; // _VEC3
			case 0x8b52: return this.setValueV4f; // _VEC4

			case 0x8b5a: return this.setValueM2; // _MAT2
			case 0x8b5b: return this.setValueM3; // _MAT3
			case 0x8b5c: return this.setValueM4; // _MAT4

			case 0x1404: case 0x8b56: return this.setValueV1i; // INT, BOOL
			case 0x8b53: case 0x8b57: return this.setValueV2i; // _VEC2
			case 0x8b54: case 0x8b58: return this.setValueV3i; // _VEC3
			case 0x8b55: case 0x8b59: return this.setValueV4i; // _VEC4

			case 0x1405: return this.setValueV1ui; // UINT

			case 0x8b5e: // SAMPLER_2D
			case 0x8d66: // SAMPLER_EXTERNAL_OES
			case 0x8dca: // INT_SAMPLER_2D
			case 0x8dd2: // UNSIGNED_INT_SAMPLER_2D
			case 0x8b62: // SAMPLER_2D_SHADOW
				return this.setValueT1;

			case 0x8b5f: // SAMPLER_3D
			case 0x8dcb: // INT_SAMPLER_3D
			case 0x8dd3: // UNSIGNED_INT_SAMPLER_3D
				return this.setValueT3D1;

			case 0x8b60: // SAMPLER_CUBE
			case 0x8dcc: // INT_SAMPLER_CUBE
			case 0x8dd4: // UNSIGNED_INT_SAMPLER_CUBE
			case 0x8dc5: // SAMPLER_CUBE_SHADOW
				return this.setValueT6;

			case 0x8dc1: // SAMPLER_2D_ARRAY
			case 0x8dcf: // INT_SAMPLER_2D_ARRAY
			case 0x8dd7: // UNSIGNED_INT_SAMPLER_2D_ARRAY
			case 0x8dc4: // SAMPLER_2D_ARRAY_SHADOW
				return this.setValueT2DArray1;

		}

	}

	// Array of scalars

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV1fArray(gl, v) {

		gl.uniform1fv(this.addr, v);

	}

	// Integer / Boolean vectors or arrays thereof (always flat arrays)

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV1iArray(gl, v) {

		gl.uniform1iv(this.addr, v);

	}


	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV2iArray(gl, v) {

		gl.uniform2iv(this.addr, v);

	}


	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV3iArray(gl, v) {

		gl.uniform3iv(this.addr, v);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 */
	setValueV4iArray(gl, v) {

		gl.uniform4iv(this.addr, v);

	}


	// Array of vectors (flat or from THREE classes)

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<Float32Array>} v 
	 */
	setValueV2fArray(gl, v) {

		const data = flatten(v, this.size, 2);

		gl.uniform2fv(this.addr, data);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<Float32Array>} v 
	 */
	setValueV3fArray(gl, v) {

		const data = flatten(v, this.size, 3);

		gl.uniform3fv(this.addr, data);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<Float32Array>} v 
	 */
	setValueV4fArray(gl, v) {

		const data = flatten(v, this.size, 4);

		gl.uniform4fv(this.addr, data);

	}

	// Array of matrices (flat or from THREE clases)

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<Float32Array>} v 
	 */
	setValueM2Array(gl, v) {

		const data = flatten(v, this.size, 4);

		gl.uniformMatrix2fv(this.addr, false, data);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<Float32Array>} v 
	 */
	setValueM3Array(gl, v) {

		const data = flatten(v, this.size, 9);

		gl.uniformMatrix3fv(this.addr, false, data);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array<Float32Array>} v 
	 */
	setValueM4Array(gl, v) {

		const data = flatten(v, this.size, 16);

		gl.uniformMatrix4fv(this.addr, false, data);

	}

	// Array of textures (2D / Cube)

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 * @param {WebGLTextures} textures 
	 */
	setValueT1Array(gl, v, textures) {

		const n = v.length;

		const units = allocTexUnits(textures, n);

		gl.uniform1iv(this.addr, units);

		for (let i = 0; i !== n; ++i) {

			textures.safeSetTexture2D(v[i] || emptyTexture, units[i]);

		}

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {Array} v 
	 * @param {WebGLTextures} textures 
	 */
	setValueT6Array(gl, v, textures) {

		const n = v.length;

		const units = allocTexUnits(textures, n);

		gl.uniform1iv(this.addr, units);

		for (let i = 0; i !== n; ++i) {

			textures.safeSetTextureCube(v[i] || emptyCubeTexture, units[i]);

		}

	}

	// Helper to pick the right setter for a pure (bottom-level) array

	/**
	 * 
	 * @param {number} type
	 */
	getPureArraySetter(type) {

		switch (type) {

			case 0x1406: return this.setValueV1fArray; // FLOAT
			case 0x8b50: return this.setValueV2fArray; // _VEC2
			case 0x8b51: return this.setValueV3fArray; // _VEC3
			case 0x8b52: return this.setValueV4fArray; // _VEC4

			case 0x8b5a: return this.setValueM2Array; // _MAT2
			case 0x8b5b: return this.setValueM3Array; // _MAT3
			case 0x8b5c: return this.setValueM4Array; // _MAT4

			case 0x1404: case 0x8b56: return this.setValueV1iArray; // INT, BOOL
			case 0x8b53: case 0x8b57: return this.setValueV2iArray; // _VEC2
			case 0x8b54: case 0x8b58: return this.setValueV3iArray; // _VEC3
			case 0x8b55: case 0x8b59: return this.setValueV4iArray; // _VEC4

			case 0x8b5e: // SAMPLER_2D
			case 0x8d66: // SAMPLER_EXTERNAL_OES
			case 0x8dca: // INT_SAMPLER_2D
			case 0x8dd2: // UNSIGNED_INT_SAMPLER_2D
			case 0x8b62: // SAMPLER_2D_SHADOW
				return this.setValueT1Array;

			case 0x8b60: // SAMPLER_CUBE
			case 0x8dcc: // INT_SAMPLER_CUBE
			case 0x8dd4: // UNSIGNED_INT_SAMPLER_CUBE
			case 0x8dc5: // SAMPLER_CUBE_SHADOW
				return this.setValueT6Array;

		}

	}
}

// --- Uniform Classes ---

class SingleUniform extends UniformParent {

	/**
	 * 
	 * @param {number} id 
	   * @param {WebGLActiveInfo} activeInfo 
	 * @param {WebGLUniformLocation} addr 
	 */
	constructor(id, activeInfo, addr) {

		super(id, activeInfo, addr);

		this.id = id;
		this.addr = addr;
		this.cache = [];
		this.setValue = this.getSingularSetter(activeInfo.type);

		// this.path = activeInfo.name; // DEBUG

	}
}

class PureArrayUniform extends UniformParent {

	/**
	 * 
	 * @param {number} id 
	   * @param {WebGLActiveInfo} activeInfo 
	 * @param {WebGLUniformLocation} addr 
	 */
	constructor(id, activeInfo, addr) {

		super(id, activeInfo, addr);

		this.id = id;
		this.addr = addr;
		this.cache = [];
		this.size = activeInfo.size;
		this.setValue = this.getPureArraySetter(activeInfo.type);

		// this.path = activeInfo.name; // DEBUG

	}

	/**
	 * 
	 * @param {Array} data 
	 */
	updateCache(data) {

		const cache = this.cache;

		if (data instanceof Float32Array && cache.length !== data.length) {

			this.cache = new Float32Array(data.length);

		}

		copyArray(cache, data);

	}
}

class StructuredUniform {

	/** @param {number} id */
	constructor(id) {
		/** @type {number} */
		this.id = id;
		/** @type { Array<{ id : number, setValue : function((WebGLRenderingContext|WebGL2RenderingContext), *, Array<Texture>) }> } */
		this.seq = [];
		this.map = {};

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {*} value 
	 * @param {Array<Texture>} textures 
	 */
	setValue(gl, value, textures) {

		const seq = this.seq;

		for (let i = 0, n = seq.length; i !== n; ++i) {

			const u = seq[i];
			u.setValue(gl, value[u.id], textures);

		}

	}
}

// --- Top-level ---

// Parser - builds up the property tree from the path strings

const RePathPart = /(\w+)(\])?(\[|\.)?/g;

// extracts
// 	- the identifier (member name or array index)
//  - followed by an optional right bracket (found when array index)
//  - followed by an optional left bracket or dot (type of subscript)
//
// Note: These portions can be read in a non-overlapping fashion and
// allow straightforward parsing of the hierarchy that WebGL encodes
// in the uniform names.

/**
 * @param {WebGLUniforms} container 
 * @param {StructuredUniform|SingleUniform|PureArrayUniform|null} uniformObject
 */
function addUniform(container, uniformObject) {

	container.seq.push(uniformObject);
	container.map[uniformObject.id] = uniformObject;

}
/**
 * 
 * @param {WebGLActiveInfo} activeInfo 
 * @param {WebGLUniformLocation} addr
 * @param {WebGLUniforms} container 
 * @suppress {checkTypes}
 */
function parseUniform(activeInfo, addr, container) {

	const path = activeInfo.name,
		pathLength = path.length;

	// reset RegExp object, because of the early exit of a previous run
	RePathPart.lastIndex = 0;

	while (true) {

		const match = RePathPart.exec(path),
			matchEnd = RePathPart.lastIndex;
		/** @type {number} */
		let id = match[1];
		const idIsIndex = match[2] === ']',
			subscript = match[3];

		if (idIsIndex) id = id | 0; // convert to integer

		if (subscript === undefined || subscript === '[' && matchEnd + 2 === pathLength) {

			// bare name or "pure" bottom-level array "[0]" suffix

			addUniform(container, subscript === undefined ?
				new SingleUniform(id, activeInfo, addr) :
				new PureArrayUniform(id, activeInfo, addr));

			break;

		} else {

			// step into inner node / create it in case it doesn't exist

			const map = container.map;
			let next = map[id];

			if (next === undefined) {

				next = new StructuredUniform(id);
				addUniform(container, next);

			}

			container = next;

		}

	}

}

// Root Container

class WebGLUniforms {

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {WebGLProgram } program 
	 */
	constructor(gl, program) {

		this.seq = [];
		this.map = {};

		const n = /** @type {number} */ (gl.getProgramParameter(program, gl.ACTIVE_UNIFORMS));

		for (let i = 0; i < n; ++i) {

			const info = gl.getActiveUniform(program, i),
				addr = gl.getUniformLocation(program, info.name);

			parseUniform(info, addr, this);

		}

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {String} name 
	 * @param {*} value 
	 * @param {WebGLTextures=} textures 
	 */
	setValue(gl, name, value, textures) {

		/** @type { { setValue : function((WebGLRenderingContext|WebGL2RenderingContext),*, WebGLTextures=)} } */
		const u = this.map[name];

		if (u !== undefined) u.setValue(gl, value, textures);

	}

	/**
	 * 
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * @param {String} name 
	 * @param {*} object 
	 */
	setOptional(gl, object, name) {

		const v = object[name];

		if (v !== undefined) this.setValue(gl, name, v);

	}
}

// Static interface

/**
 * 
 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
 * @param {Array} seq 
 * @param {Array} values 
 * @param {WebGLTextures} textures 
 */
WebGLUniforms.upload = function (gl, seq, values, textures) {

	for (let i = 0, n = seq.length; i !== n; ++i) {

		/** @type { { id: number , setValue : function((WebGLRenderingContext|WebGL2RenderingContext),*, WebGLTextures)} } */
		const u = seq[i];
		/** @type {{ needsUpdate : boolean, value : * } } */
		const v = values[u.id];

		if (v.needsUpdate !== false) {

			// note: always updating when .needsUpdate is undefined
			u.setValue(gl, v.value, textures);

		}

	}

};

/**
 * 
 * @param {Array} seq 
 * @param {Array} values
 * @return {Array} 
 */
WebGLUniforms.seqWithValue = function (seq, values) {

	const r = [];

	for (let i = 0, n = seq.length; i !== n; ++i) {

		/** @type { { id: * } } */
		const u = seq[i];

		if (u.id in values) {
			r.push(u);
		}

	}

	return r;

};

export { WebGLUniforms };
