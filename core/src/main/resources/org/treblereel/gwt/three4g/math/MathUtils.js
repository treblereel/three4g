/** @type {Array<string>} */
const _lut = [];

for ( let i = 0; i < 256; i ++ ) {

	_lut[ i ] = ( i < 16 ? '0' : '' ) + ( i ).toString( 16 );

}

let _seed = 1234567;

const MathUtils = {

	DEG2RAD: Math.PI / 180,
	RAD2DEG: 180 / Math.PI,

	/**
	 * 
	 * @return {string}
	 */
	generateUUID: function () {

		// http://stackoverflow.com/questions/105034/how-to-create-a-guid-uuid-in-javascript/21963136#21963136

		const d0 = Math.random() * 0xffffffff | 0;
		const d1 = Math.random() * 0xffffffff | 0;
		const d2 = Math.random() * 0xffffffff | 0;
		const d3 = Math.random() * 0xffffffff | 0;
		const uuid = _lut[ d0 & 0xff ] + _lut[ d0 >> 8 & 0xff ] + _lut[ d0 >> 16 & 0xff ] + _lut[ d0 >> 24 & 0xff ] + '-' +
			_lut[ d1 & 0xff ] + _lut[ d1 >> 8 & 0xff ] + '-' + _lut[ d1 >> 16 & 0x0f | 0x40 ] + _lut[ d1 >> 24 & 0xff ] + '-' +
			_lut[ d2 & 0x3f | 0x80 ] + _lut[ d2 >> 8 & 0xff ] + '-' + _lut[ d2 >> 16 & 0xff ] + _lut[ d2 >> 24 & 0xff ] +
			_lut[ d3 & 0xff ] + _lut[ d3 >> 8 & 0xff ] + _lut[ d3 >> 16 & 0xff ] + _lut[ d3 >> 24 & 0xff ];

		// .toUpperCase() here flattens concatenated strings to save heap memory space.
		return uuid.toUpperCase();

	},

	/**
	 * @param {number} value 
	 * @param {number} min 
	 * @param {number} max
	 * @return {number} 
	 */
	clamp: function ( value, min, max ) {

		return Math.max( min, Math.min( max, value ) );

	},

	// compute euclidian modulo of m % n
	// https://en.wikipedia.org/wiki/Modulo_operation

	/**
	 * @param {number} n 
	 * @param {number} m
	 * @return {number} 
	 */
	euclideanModulo: function ( n, m ) {

		return ( ( n % m ) + m ) % m;

	},

	// Linear mapping from range <a1, a2> to range <b1, b2>

	/**
	 * @param {number} x 
	 * @param {number} a1 
	 * @param {number} a2 
	 * @param {number} b1 
	 * @param {number} b2
	 * @return {number} 
	 */
	mapLinear: function ( x, a1, a2, b1, b2 ) {

		return b1 + ( x - a1 ) * ( b2 - b1 ) / ( a2 - a1 );

	},

	// https://en.wikipedia.org/wiki/Linear_interpolation

	/**
	 * 
	 * @param {number} x 
	 * @param {number} y 
	 * @param {number} t
	 * @return {number} 
	 */
	lerp: function ( x, y, t ) {

		return ( 1 - t ) * x + t * y;

	},

	// http://www.rorydriscoll.com/2016/03/07/frame-rate-independent-damping-using-lerp/
	/**
	 * @param {number} x 
	 * @param {number} y 
	 * @param {number} lambda 
	 * @param {number} dt
	 * @return {number} 
	 */
	damp: function ( x, y, lambda, dt ) {

		return MathUtils.lerp( x, y, 1 - Math.exp( - lambda * dt ) );

	},

	// https://www.desmos.com/calculator/vcsjnyz7x4
	/**
	 * 
	 * @param {number} x 
	 * @param {number=} length
	 * @return {number} 
	 */
	pingpong: function ( x, length = 1 ) {

		return length - Math.abs( MathUtils.euclideanModulo( x, length * 2 ) - length );

	},

	// http://en.wikipedia.org/wiki/Smoothstep
	/**
	 * @param {number} x 
	 * @param {number} min 
	 * @param {number} max
	 * @return {number} 
	 */
	smoothstep: function ( x, min, max ) {

		if ( x <= min ) return 0;
		if ( x >= max ) return 1;

		x = ( x - min ) / ( max - min );

		return x * x * ( 3 - 2 * x );

	},

	/**
	 * @param {number} x 
	 * @param {number} min 
	 * @param {number} max
	 * @return {number} 
	 */
	smootherstep: function ( x, min, max ) {

		if ( x <= min ) return 0;
		if ( x >= max ) return 1;

		x = ( x - min ) / ( max - min );

		return x * x * x * ( x * ( x * 6 - 15 ) + 10 );

	},

	// Random integer from <low, high> interval
	/**
	 * @param {number} low 
	 * @param {number} high
	 * @return {number} 
	 */
	randInt: function ( low, high ) {

		return low + Math.floor( Math.random() * ( high - low + 1 ) );

	},

	// Random float from <low, high> interval
	/**
	 * @param {number} low 
	 * @param {number} high
	 * @return {number} 
	 */
	randFloat: function ( low, high ) {

		return low + Math.random() * ( high - low );

	},

	// Random float from <-range/2, range/2> interval
	/**
	 * @param {number} range
	 * @return {number} 
	 */
	randFloatSpread: function ( range ) {

		return range * ( 0.5 - Math.random() );

	},

	// Deterministic pseudo-random float in the interval [ 0, 1 ]
	/**
	 * @param {number} s
	 * @return {number} 
	 */
	seededRandom: function ( s ) {

		if ( s !== undefined ) _seed = s % 2147483647;

		// Park-Miller algorithm

		_seed = _seed * 16807 % 2147483647;

		return ( _seed - 1 ) / 2147483646;

	},

	/**
	 * @param {number} degrees 
	 * @return {number}
	 */
	degToRad: function ( degrees ) {

		return degrees * MathUtils.DEG2RAD;

	},

	/**
	 * @param {number} radians 
	 * @return {number}
	 */
	radToDeg: function ( radians ) {

		return radians * MathUtils.RAD2DEG;

	},

	/**
	 * @param {number} value 
	 * @return {boolean}
	 */
	isPowerOfTwo: function ( value ) {

		return ( value & ( value - 1 ) ) === 0 && value !== 0;

	},

	/**
	 * @param {number} value
 	 * @return {number}
	 */
	ceilPowerOfTwo: function ( value ) {

		return Math.pow( 2, Math.ceil( Math.log( value ) / Math.LN2 ) );

	},

	/**
	 * @param {number} value
 	 * @return {number}
	 */
	floorPowerOfTwo: function ( value ) {

		return Math.pow( 2, Math.floor( Math.log( value ) / Math.LN2 ) );

	},

	/**
	 * 
	 * @param { { set : function(number,number,number,number) } } q 
	 * @param {number} a 
	 * @param {number} b 
	 * @param {number} c 
	 * @param {string} order 
	 */
	setQuaternionFromProperEuler: function ( q, a, b, c, order ) {

		// Intrinsic Proper Euler Angles - see https://en.wikipedia.org/wiki/Euler_angles

		// rotations are applied to the axes in the order specified by 'order'
		// rotation by angle 'a' is applied first, then by angle 'b', then by angle 'c'
		// angles are in radians

		const cos = Math.cos;
		const sin = Math.sin;

		const c2 = cos( b / 2 );
		const s2 = sin( b / 2 );

		const c13 = cos( ( a + c ) / 2 );
		const s13 = sin( ( a + c ) / 2 );

		const c1_3 = cos( ( a - c ) / 2 );
		const s1_3 = sin( ( a - c ) / 2 );

		const c3_1 = cos( ( c - a ) / 2 );
		const s3_1 = sin( ( c - a ) / 2 );

		switch ( order ) {

			case 'XYX':
				q.set( c2 * s13, s2 * c1_3, s2 * s1_3, c2 * c13 );
				break;

			case 'YZY':
				q.set( s2 * s1_3, c2 * s13, s2 * c1_3, c2 * c13 );
				break;

			case 'ZXZ':
				q.set( s2 * c1_3, s2 * s1_3, c2 * s13, c2 * c13 );
				break;

			case 'XZX':
				q.set( c2 * s13, s2 * s3_1, s2 * c3_1, c2 * c13 );
				break;

			case 'YXY':
				q.set( s2 * c3_1, c2 * s13, s2 * s3_1, c2 * c13 );
				break;

			case 'ZYZ':
				q.set( s2 * s3_1, s2 * c3_1, c2 * s13, c2 * c13 );
				break;

			default:
				console.warn( 'THREE.MathUtils: .setQuaternionFromProperEuler() encountered an unknown order: ' + order );

		}

	}

};


export { MathUtils };
