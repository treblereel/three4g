/**
 * @param {Array<number>} array 
 * @return {number}
 */
function arrayMin( array ) {

	if ( array.length === 0 ) return Infinity;

	/** @type {number} */
	let min = array[ 0 ];

	for ( let i = 1, l = array.length; i < l; ++ i ) {

		if ( array[ i ] < min ) min = array[ i ];

	}

	return min;

}

/**
 * @param {Array<number>} array 
 * @return {number}
 */
function arrayMax( array ) {

	if ( array.length === 0 ) return - Infinity;

	/** @type {number} */
	let max = array[ 0 ];

	for ( let i = 1, l = array.length; i < l; ++ i ) {

		if ( array[ i ] > max ) max = array[ i ];

	}

	return max;

}

const TYPED_ARRAYS = {
	Int8Array: Int8Array,
	Uint8Array: Uint8Array,
	Uint8ClampedArray: Uint8ClampedArray,
	Int16Array: Int16Array,
	Uint16Array: Uint16Array,
	Int32Array: Int32Array,
	Uint32Array: Uint32Array,
	Float32Array: Float32Array,
	Float64Array: Float64Array
};

/**
 * 
 * @param {string} type 
 * @param {number|ArrayBufferView|Array<number>|ArrayBuffer|SharedArrayBuffer} buffer
 * @return {TypedArray} 
 */
function getTypedArray( type, buffer ) {

	return new TYPED_ARRAYS[ type ]( buffer );

}

export { arrayMin, arrayMax, getTypedArray };
