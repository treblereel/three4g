import { Quaternion } from './Quaternion.js';
import { Vector3 } from './Vector3.js';
import { Matrix4 } from './Matrix4.js';
import { MathUtils } from './MathUtils.js';

//closure compiler
import { EulerInterface } from '../closure/math/EulerInterface.js';

const _matrix = /*@__PURE__*/ new Matrix4();
const _quaternion = /*@__PURE__*/ new Quaternion();

/**
 * @implements { EulerInterface }
 */
class Euler {

	/**
	 * @param {number=} x 
	 * @param {number=} y 
	 * @param {number=} z 
	 * @param {string=} order 
	 */
	constructor( x = 0, y = 0, z = 0, order = Euler.DefaultOrder ) {

		/** @type {number} */
		this._x = x;
		/** @type {number} */
		this._y = y;
		/** @type {number} */
		this._z = z;
		/** @type {string} */
		this._order = order;

	}

	/**
	 * @return {number}
	 */
	get x() {

		return this._x;

	}

	/**
	 * @param {number} value
	 */
	set x( value ) {

		this._x = value;
		this._onChangeCallback();

	}


	/**
	 * @return {number}
	 */
	get y() {

		return this._y;

	}

	/**
	 * @param {number} value
	 */
	set y( value ) {

		this._y = value;
		this._onChangeCallback();

	}


	/**
	 * @return {number}
	 */
	get z() {

		return this._z;

	}

	/**
	 * @param {number} value
	 */
	set z( value ) {

		this._z = value;
		this._onChangeCallback();

	}


	/**
	 * @return {string}
	 */
	get order() {

		return this._order;

	}

	/**
	 * @param {string} value
	 */
	set order( value ) {

		this._order = value;
		this._onChangeCallback();

	}

	/**
	 * @param {number} x 
	 * @param {number} y 
	 * @param {number} z 
	 * @param {string=} order 
	 * @return {Euler}
	 */
	set( x, y, z, order ) {

		this._x = x;
		this._y = y;
		this._z = z;
		this._order = order || this._order;

		this._onChangeCallback();

		return this;

	}

	/**
	 * @return {Euler}
	 */
	clone() {

		return new this.constructor( this._x, this._y, this._z, this._order );

	}

	/**
	 * 
	 * @param {Euler} euler
 	 * @return {Euler}
	 */
	copy( euler ) {

		this._x = euler._x;
		this._y = euler._y;
		this._z = euler._z;
		this._order = euler._order;

		this._onChangeCallback();

		return this;

	}

		/**
	*
	* @param {Matrix4} m
	* @param {string} order
	* @param {boolean=} update
	* @return {Euler}
	*/
	setFromRotationMatrix( m, order, update ) {

		const clamp = MathUtils.clamp;

		// assumes the upper 3x3 of m is a pure rotation matrix (i.e, unscaled)

		const te = m.elements;
		const m11 = te[ 0 ], m12 = te[ 4 ], m13 = te[ 8 ];
		const m21 = te[ 1 ], m22 = te[ 5 ], m23 = te[ 9 ];
		const m31 = te[ 2 ], m32 = te[ 6 ], m33 = te[ 10 ];

		order = order || this._order;

		switch ( order ) {

			case 'XYZ':

				this._y = Math.asin( clamp( m13, - 1, 1 ) );

				if ( Math.abs( m13 ) < 0.9999999 ) {

					this._x = Math.atan2( - m23, m33 );
					this._z = Math.atan2( - m12, m11 );

				} else {

					this._x = Math.atan2( m32, m22 );
					this._z = 0;

				}

				break;

			case 'YXZ':

				this._x = Math.asin( - clamp( m23, - 1, 1 ) );

				if ( Math.abs( m23 ) < 0.9999999 ) {

					this._y = Math.atan2( m13, m33 );
					this._z = Math.atan2( m21, m22 );

				} else {

					this._y = Math.atan2( - m31, m11 );
					this._z = 0;

				}

				break;

			case 'ZXY':

				this._x = Math.asin( clamp( m32, - 1, 1 ) );

				if ( Math.abs( m32 ) < 0.9999999 ) {

					this._y = Math.atan2( - m31, m33 );
					this._z = Math.atan2( - m12, m22 );

				} else {

					this._y = 0;
					this._z = Math.atan2( m21, m11 );

				}

				break;

			case 'ZYX':

				this._y = Math.asin( - clamp( m31, - 1, 1 ) );

				if ( Math.abs( m31 ) < 0.9999999 ) {

					this._x = Math.atan2( m32, m33 );
					this._z = Math.atan2( m21, m11 );

				} else {

					this._x = 0;
					this._z = Math.atan2( - m12, m22 );

				}

				break;

			case 'YZX':

				this._z = Math.asin( clamp( m21, - 1, 1 ) );

				if ( Math.abs( m21 ) < 0.9999999 ) {

					this._x = Math.atan2( - m23, m22 );
					this._y = Math.atan2( - m31, m11 );

				} else {

					this._x = 0;
					this._y = Math.atan2( m13, m33 );

				}

				break;

			case 'XZY':

				this._z = Math.asin( - clamp( m12, - 1, 1 ) );

				if ( Math.abs( m12 ) < 0.9999999 ) {

					this._x = Math.atan2( m32, m22 );
					this._y = Math.atan2( m13, m11 );

				} else {

					this._x = Math.atan2( - m23, m33 );
					this._y = 0;

				}

				break;

			default:

				console.warn( 'THREE.Euler: .setFromRotationMatrix() encountered an unknown order: ' + order );

		}

		this._order = order;

		if ( update !== false ) this._onChangeCallback();

		return this;

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Quaternion} q
	 * @param {string=} order
	 * @param {boolean=} update
	 * @return {Euler}
	 */
	setFromQuaternion( q, order, update ) {

		_matrix.makeRotationFromQuaternion( q );

		return this.setFromRotationMatrix( _matrix, order, update );

	}

	/**
	 * 
	 * @param {Vector3} v 
	 * @param {string=} order
	 * @return {Euler} 
	 */
	setFromVector3( v, order ) {

		return this.set( v.x, v.y, v.z, order || this._order );

	}

	/**
	 * 
	 * @param {string} newOrder
	 * @return {Euler} 
	 */
	reorder( newOrder ) {

		// WARNING: this discards revolution information -bhouston

		_quaternion.setFromEuler( this );

		return this.setFromQuaternion( _quaternion, newOrder );

	}

	/**
	 * 
	 * @param {Euler} euler 
	 * @return {boolean}
	 */
	equals( euler ) {

		return ( euler._x === this._x ) && ( euler._y === this._y ) && ( euler._z === this._z ) && ( euler._order === this._order );

	}

	/**
	 * 
	 * @param {Array} array
	 * @return {Euler} 
	 */
	fromArray( array ) {

		this._x = array[ 0 ];
		this._y = array[ 1 ];
		this._z = array[ 2 ];
		if ( array[ 3 ] !== undefined ) this._order = array[ 3 ];

		this._onChangeCallback();

		return this;

	}

	/**
	 * @param {Array=} array 
	 * @param {number=} offset
	 * @return {Array} 
	 */
	toArray( array = [], offset = 0 ) {

		array[ offset ] = this._x;
		array[ offset + 1 ] = this._y;
		array[ offset + 2 ] = this._z;
		array[ offset + 3 ] = this._order;

		return array;

	}

	/**
	 * 
	 * @param {Vector3=} optionalResult
	 * @return {Vector3} 
	 */
	toVector3( optionalResult ) {

		if ( optionalResult ) {

			return optionalResult.set( this._x, this._y, this._z );

		} else {

			return new Vector3( this._x, this._y, this._z );

		}

	}

	/**
	 * 
	 * @param {function()} callback 
	 * @return {Euler}
	 */
	_onChange( callback ) {

		this._onChangeCallback = callback;

		return this;

	}

	_onChangeCallback() {}

}

Euler.prototype.isEuler = true;

/** @type {string} */
Euler.DefaultOrder = 'XYZ';
/** @type {Array<String>} */
Euler.RotationOrders = [ 'XYZ', 'YZX', 'ZXY', 'XZY', 'YXZ', 'ZYX' ];

export { Euler };
