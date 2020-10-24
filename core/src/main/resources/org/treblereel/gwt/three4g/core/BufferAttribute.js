import { Vector4 } from '../math/Vector4.js';
import { Vector3 } from '../math/Vector3.js';
import { Vector2 } from '../math/Vector2.js';
import { Color } from '../math/Color.js';
import { StaticDrawUsage } from '../constants.js';
import { Matrix3 } from '../math/Matrix3.js';

import { Matrix4 } from '../math/Matrix4.js';


const _vector = new Vector3();
const _vector2 = new Vector2();

class BufferAttribute {


	/**
	 *
	 * @param {TypedArray|Array<number>} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		if (Array.isArray(array)) {

			throw new TypeError('THREE.BufferAttribute: array should be a Typed Array.');

		}
		/**@type {string} */
		this.name = '';
		/** @type {TypedArray|Array<number>} */
		this.array = array;
		/** @type {number} */
		this.itemSize = itemSize;
		/** @type {number} */
		this.count = array !== undefined ? array.length / itemSize : 0;
		/** @type {boolean} */
		this.normalized = normalized === true;

		/** @type {number} */ 
		this.usage = StaticDrawUsage;
		this.updateRange = { offset: 0, count: - 1 };

		/** @type {number} */
		this.version = 0;
		/** @type {boolean} */
		this.isBufferAttribute = true;
		/** @type {boolean} */
		this.isGLBufferAttribute;

	}

	/**
	 * @param {boolean} value
	 */
	set needsUpdate(value) {

		if (value === true) this.version++;

	}


	onUploadCallback() { }

	/**
	 * @param {number} value
	 * @return {BufferAttribute} 
	 */
	setUsage(value) {

		this.usage = value;

		return this;

	}

	/**
	 * @param {BufferAttribute} source
	 * @return {BufferAttribute} 
	 */
	copy(source) {

		this.name = source.name;
		this.array = new source.array.constructor(source.array);
		this.itemSize = source.itemSize;
		this.count = source.count;
		this.normalized = source.normalized;

		this.usage = source.usage;

		return this;

	}

	/**
	 * @param {number} index1 
	 * @param {BufferAttribute} attribute 
	 * @param {number} index2 
	 * @return {BufferAttribute}
	 */
	copyAt(index1, attribute, index2) {

		index1 *= this.itemSize;
		index2 *= attribute.itemSize;

		for (let i = 0, l = this.itemSize; i < l; i++) {

			this.array[index1 + i] = attribute.array[index2 + i];

		}

		return this;

	}

	/**
	 * @param {!Array<number>} array 
 	 * @return {BufferAttribute}
	 */
	copyArray(array) {

		this.array.set(array);

		return this;

	}

	/**
	 * @param {Array<{ r: number, g: number, b: number }>} colors 
 	 * @return {BufferAttribute}
	 */
	copyColorsArray(colors) {

		const array = this.array;
		let offset = 0;

		for (let i = 0, l = colors.length; i < l; i++) {

			let color = colors[i];

			if (color === undefined) {

				console.warn('THREE.BufferAttribute.copyColorsArray(): color is undefined', i);
				color = new Color();

			}

			array[offset++] = color.r;
			array[offset++] = color.g;
			array[offset++] = color.b;

		}

		return this;

	}

	/**
	 * @param {Array<Vector2>} vectors 
 	 * @return {BufferAttribute}
	 */
	copyVector2sArray(vectors) {

		const array = this.array;
		let offset = 0;

		for (let i = 0, l = vectors.length; i < l; i++) {

			let vector = vectors[i];

			if (vector === undefined) {

				console.warn('THREE.BufferAttribute.copyVector2sArray(): vector is undefined', i);
				vector = new Vector2();

			}

			array[offset++] = vector.x;
			array[offset++] = vector.y;

		}

		return this;

	}

	/**
	 * @param {Array<Vector3>} vectors 
 	 * @return {BufferAttribute}
	 */
	copyVector3sArray(vectors) {

		const array = this.array;
		let offset = 0;

		for (let i = 0, l = vectors.length; i < l; i++) {

			let vector = vectors[i];

			if (vector === undefined) {

				console.warn('THREE.BufferAttribute.copyVector3sArray(): vector is undefined', i);
				vector = new Vector3();

			}

			array[offset++] = vector.x;
			array[offset++] = vector.y;
			array[offset++] = vector.z;

		}

		return this;

	}

	/**
	 * @param {Array<Vector4>} vectors 
 	 * @return {BufferAttribute}
	 */
	copyVector4sArray(vectors) {

		const array = this.array;
		let offset = 0;

		for (let i = 0, l = vectors.length; i < l; i++) {

			/** @type {Vector4} */
			let vector = vectors[i];

			if (vector === undefined) {

				console.warn('THREE.BufferAttribute.copyVector4sArray(): vector is undefined', i);
				vector = new Vector4();

			}

			array[offset++] = vector.x;
			array[offset++] = vector.y;
			array[offset++] = vector.z;
			array[offset++] = vector.w;

		}

		return this;

	}

	/**
	 * @param {Matrix3} m 
 	 * @return {BufferAttribute}
	 * @suppress {checkTypes} 
	 */
	applyMatrix3(m) {

		if (this.itemSize === 2) {

			for (let i = 0, l = this.count; i < l; i++) {

				_vector2.fromBufferAttribute(this, i);
				_vector2.applyMatrix3(m);

				this.setXY(i, _vector2.x, _vector2.y);

			}

		} else if (this.itemSize === 3) {

			for (let i = 0, l = this.count; i < l; i++) {

				_vector.fromBufferAttribute(this, i);
				_vector.applyMatrix3(m);

				this.setXYZ(i, _vector.x, _vector.y, _vector.z);

			}

		}

		return this;

	}

	/**
	 * @param {Matrix4} m 
 	 * @return {BufferAttribute}
	 * @suppress {checkTypes} 
	 */
	applyMatrix4(m) {

		for (let i = 0, l = this.count; i < l; i++) {

			_vector.x = this.getX(i);
			_vector.y = this.getY(i);
			_vector.z = this.getZ(i);

			_vector.applyMatrix4(m);

			this.setXYZ(i, _vector.x, _vector.y, _vector.z);

		}

		return this;

	}

	/**
	 * @param {Matrix3} m 
 	 * @return {BufferAttribute}
	 * @suppress {checkTypes} 
	 */
	applyNormalMatrix(m) {

		for (let i = 0, l = this.count; i < l; i++) {

			_vector.x = this.getX(i);
			_vector.y = this.getY(i);
			_vector.z = this.getZ(i);

			_vector.applyNormalMatrix(m);

			this.setXYZ(i, _vector.x, _vector.y, _vector.z);

		}

		return this;

	}

	/**
	 * @param {Matrix4} m 
 	 * @return {BufferAttribute}
	 * @suppress {checkTypes}  
	 */
	transformDirection(m) {

		for (let i = 0, l = this.count; i < l; i++) {

			_vector.x = this.getX(i);
			_vector.y = this.getY(i);
			_vector.z = this.getZ(i);

			_vector.transformDirection(m);

			this.setXYZ(i, _vector.x, _vector.y, _vector.z);

		}

		return this;

	}

	/**
	 * @param {!Array<number>} value 
	 * @param {number=} offset 
	 */
	set(value, offset = 0) {

		this.array.set(value, offset);

		return this;

	}

	/**
	 * @param {number} index 
	 * @return {number}
	 */
	getX(index) {

		return this.array[index * this.itemSize];

	}

	/**
	 * @param {number} index 
	 * @param {number} x 
	 * @return {BufferAttribute}
	 */
	setX(index, x) {

		this.array[index * this.itemSize] = x;

		return this;

	}

	/**
	 * @param {number} index 
	 * @return {number}
	 */
	getY(index) {

		return this.array[index * this.itemSize + 1];

	}

	/**
	 * @param {number} index 
	 * @param {number} y 
	 * @return {BufferAttribute}
	 */
	setY(index, y) {

		this.array[index * this.itemSize + 1] = y;

		return this;

	}

	/**
	 * @param {number} index 
	 * @return {number}
	 */
	getZ(index) {

		return this.array[index * this.itemSize + 2];

	}

	/**
	 * @param {number} index 
	 * @param {number} z 
	 * @return {BufferAttribute}
	 */
	setZ(index, z) {

		this.array[index * this.itemSize + 2] = z;

		return this;

	}

	/**
	 * @param {number} index 
	 * @return {number}
	 */
	getW(index) {

		return this.array[index * this.itemSize + 3];

	}

	/**
	 * @param {number} index 
	 * @param {number} w
	 * @return {BufferAttribute}
	 */
	setW(index, w) {

		this.array[index * this.itemSize + 3] = w;

		return this;

	}

	/**
	 * @param {number} index 
	 * @param {number} x
	 * @param {number} y
	 * @return {BufferAttribute}
	 */
	setXY(index, x, y) {

		index *= this.itemSize;

		this.array[index + 0] = x;
		this.array[index + 1] = y;

		return this;

	}

	/**
	 * @param {number} index 
	 * @param {number} x
	 * @param {number} y
	 * @param {number} z
	 * @return {BufferAttribute}
	 */
	setXYZ(index, x, y, z) {

		index *= this.itemSize;

		this.array[index + 0] = x;
		this.array[index + 1] = y;
		this.array[index + 2] = z;

		return this;

	}

	/**
	 * @param {number} index 
	 * @param {number} x
	 * @param {number} y
	 * @param {number} z
	 * @param {number} w
	 * @return {BufferAttribute}
	 */
	setXYZW(index, x, y, z, w) {

		index *= this.itemSize;

		this.array[index + 0] = x;
		this.array[index + 1] = y;
		this.array[index + 2] = z;
		this.array[index + 3] = w;

		return this;

	}

	/**
	 * @param {function()} callback 
 	 * @return {BufferAttribute}
	 */
	onUpload(callback) {

		this.onUploadCallback = callback;

		return this;

	}


	/**
 	 * @return {BufferAttribute}
	 */
	clone() {

		return new this.constructor(this.array, this.itemSize).copy(this);

	}

	toJSON() {

		return {
			itemSize: this.itemSize,
			type: this.array.constructor.name,
			array: Array.prototype.slice.call(this.array),
			normalized: this.normalized
		};

	}

}

class Int8BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Int8Array} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Int8Array(array), itemSize, normalized);

	}

}

class Uint8BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Uint8Array} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Uint8Array(array), itemSize, normalized);

	}

}

class Uint8ClampedBufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Uint8ClampedArray} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Uint8ClampedArray(array), itemSize, normalized);

	}

}

class Int16BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Int16Array} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Int16Array(array), itemSize, normalized);

	}

}

class Uint16BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Uint16Array} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Uint16Array(array), itemSize, normalized);

	}

}

class Int32BufferAttribute extends BufferAttribute {


	/**
	 * @param {Array<number>|Float32Array|Int32Array} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Int32Array(array), itemSize, normalized);

	}

}

class Uint32BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Uint32Array} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Uint32Array(array), itemSize, normalized);

	}

}

class Float16BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Uint16Array|Float32Array|number} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Uint16Array(array), itemSize, normalized);

		Object.defineProperty(this, 'isFloat16BufferAttribute', { value: true });

	}

}

class Float32BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|number} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Float32Array(array), itemSize, normalized);

	}

}

class Float64BufferAttribute extends BufferAttribute {

	/**
	 * @param {Array<number>|Float32Array|Float64Array|number} array
	 * @param {number} itemSize
	 * @param {boolean=} normalized
	 */
	constructor(array, itemSize, normalized) {

		super(new Float64Array(array), itemSize, normalized);

	}

}

export {
	Float64BufferAttribute,
	Float32BufferAttribute,
	Float16BufferAttribute,
	Uint32BufferAttribute,
	Int32BufferAttribute,
	Uint16BufferAttribute,
	Int16BufferAttribute,
	Uint8ClampedBufferAttribute,
	Uint8BufferAttribute,
	Int8BufferAttribute,
	BufferAttribute
};
