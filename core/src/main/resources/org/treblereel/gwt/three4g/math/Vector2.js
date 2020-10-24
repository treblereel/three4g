//closure compiler
import { MatrixInterface } from "../closure/math/MatrixInterface.js";

class Vector2 {

	/**
	 * @param {number=} x 
	 * @param {number=} y 
	 */
	constructor( x = 0, y = 0 ) {

		/** @type {number} */
		this.x = x;
		/** @type {number} */
		this.y = y;

	}

	/**
	 * @return {number}
	 */
	get width() {

		return this.x;

	}

	/**
	 * @param {number} value
	 */
	set width( value ) {

		this.x = value;

	}

	/**
	 * @return {number}
	 */
	get height() {

		return this.y;

	}

	/**
	 * @param {number} value
	 */
	set height( value ) {

		this.y = value;

	}

	/**
	 * 
	 * @param {number} x 
	 * @param {number} y
	 * @return {Vector2} 
	 */
	set( x, y ) {

		this.x = x;
		this.y = y;

		return this;

	}

	/**
	 * @param {number} scalar
	 * @return {Vector2} 
	 */
	setScalar( scalar ) {

		this.x = scalar;
		this.y = scalar;

		return this;

	}

	/**
	 * @param {number} x 
	 * @return {Vector2}
	 */
	setX( x ) {

		this.x = x;

		return this;

	}

	/**
	 * @param {number} y 
	 * @return {Vector2}
	 */
	setY( y ) {

		this.y = y;

		return this;

	}

	/**
	 * @param {number} index 
	 * @param {number} value
	 * @return {Vector2} 
	 */
	setComponent( index, value ) {

		switch ( index ) {

			case 0: this.x = value; break;
			case 1: this.y = value; break;
			default: throw new Error( 'index is out of range: ' + index );

		}

		return this;

	}

	/**
	 * @param {number} index 
	 * @return {number}
	 */
	getComponent( index ) {

		switch ( index ) {

			case 0: return this.x;
			case 1: return this.y;
			default: throw new Error( 'index is out of range: ' + index );

		}

	}

	/**
	 * @return {Vector2}
	 */
	clone() {

		return new this.constructor( this.x, this.y );

	}

	/**
	 * 
	 * @param {Vector2} v 
	 * @return {Vector2}
	 */
	copy( v ) {

		this.x = v.x;
		this.y = v.y;

		return this;

	}

	/**
	 * 
	 * @param {Vector2} v 
	 * @param {Vector2=} w
	 * @return {Vector2} 
	 */
	add( v, w ) {

		if ( w !== undefined ) {

			console.warn( 'THREE.Vector2: .add() now only accepts one argument. Use .addVectors( a, b ) instead.' );
			return this.addVectors( v, w );

		}

		this.x += v.x;
		this.y += v.y;

		return this;

	}

	/**
	 * @param {number} s 
	 * @return {Vector2}
	 */
	addScalar( s ) {

		this.x += s;
		this.y += s;

		return this;

	}

	/**
	 * @param {Vector2} a 
	 * @param {Vector2} b
	 * @return {Vector2} 
	 */
	addVectors( a, b ) {

		this.x = a.x + b.x;
		this.y = a.y + b.y;

		return this;

	}

	/**
	 * 
	 * @param {Vector2} v 
	 * @param {number} s
	 * @return {Vector2} 
	 */
	addScaledVector( v, s ) {

		this.x += v.x * s;
		this.y += v.y * s;

		return this;

	}

		/**
	 *
	 * @param {Vector2} v
	 * @param {Vector2=} w
 	 * @return {Vector2}
	 */
	sub( v, w ) {

		if ( w !== undefined ) {

			console.warn( 'THREE.Vector2: .sub() now only accepts one argument. Use .subVectors( a, b ) instead.' );
			return this.subVectors( v, w );

		}

		this.x -= v.x;
		this.y -= v.y;

		return this;

	}

	/**
	 * @param {number} s
	 * @return {Vector2} 
	 */
	subScalar( s ) {

		this.x -= s;
		this.y -= s;

		return this;

	}

	/**
	 * @param {Vector2} a 
	 * @param {Vector2} b 
	 * @return {Vector2}
	 */
	subVectors( a, b ) {

		this.x = a.x - b.x;
		this.y = a.y - b.y;

		return this;

	}

	/**
	 * @param {Vector2} v 
 	 * @return {Vector2}
	 */
	multiply( v ) {

		this.x *= v.x;
		this.y *= v.y;

		return this;

	}

	/**
	 * 
	 * @param {number} scalar
	 * @return {Vector2} 
	 */
	multiplyScalar( scalar ) {

		this.x *= scalar;
		this.y *= scalar;

		return this;

	}

	/**
	 * @param {Vector2} v
	 * @return {Vector2} 
	 */
	divide( v ) {

		this.x /= v.x;
		this.y /= v.y;

		return this;

	}

	/**
	 * @param {number} scalar 
 	 * @return {Vector2} 
	 */
	divideScalar( scalar ) {

		return this.multiplyScalar( 1 / scalar );

	}

	/**
	 * @param { MatrixInterface } m
	 * @return {Vector2} 
	 */
	applyMatrix3( m ) {

		const x = this.x, y = this.y;
		const e = m.elements;

		this.x = e[ 0 ] * x + e[ 3 ] * y + e[ 6 ];
		this.y = e[ 1 ] * x + e[ 4 ] * y + e[ 7 ];

		return this;

	}

	/**
	 * @param {Vector2} v
	 * @return {Vector2} 
	 */
	min( v ) {

		this.x = Math.min( this.x, v.x );
		this.y = Math.min( this.y, v.y );

		return this;

	}

	/**
	 * @param {Vector2} v
	 * @return {Vector2} 
	 */
	max( v ) {

		this.x = Math.max( this.x, v.x );
		this.y = Math.max( this.y, v.y );

		return this;

	}

	/**
	 * @param {Vector2} min 
	 * @param {Vector2} max
	 * @return {Vector2} 
	 */
	clamp( min, max ) {

		// assumes min < max, componentwise

		this.x = Math.max( min.x, Math.min( max.x, this.x ) );
		this.y = Math.max( min.y, Math.min( max.y, this.y ) );

		return this;

	}

	/**
	 * @param {number} minVal 
	 * @param {number} maxVal 
 	 * @return {Vector2} 
	 */
	clampScalar( minVal, maxVal ) {

		this.x = Math.max( minVal, Math.min( maxVal, this.x ) );
		this.y = Math.max( minVal, Math.min( maxVal, this.y ) );

		return this;

	}

	/**
	 * @param {number} min 
	 * @param {number} max 
 	 * @return {Vector2} 
	 */
	clampLength( min, max ) {

		const length = this.length();

		return this.divideScalar( length || 1 ).multiplyScalar( Math.max( min, Math.min( max, length ) ) );

	}

	/**
	 * @return {Vector2}
	 */
	floor() {

		this.x = Math.floor( this.x );
		this.y = Math.floor( this.y );

		return this;

	}

	/**
	 * @return {Vector2}
	 */
	ceil() {

		this.x = Math.ceil( this.x );
		this.y = Math.ceil( this.y );

		return this;

	}

	/**
	 * @return {Vector2}
	 */
	round() {

		this.x = Math.round( this.x );
		this.y = Math.round( this.y );

		return this;

	}

	/**
	 * @return {Vector2}
	 */
	roundToZero() {

		this.x = ( this.x < 0 ) ? Math.ceil( this.x ) : Math.floor( this.x );
		this.y = ( this.y < 0 ) ? Math.ceil( this.y ) : Math.floor( this.y );

		return this;

	}

	/**
	 * @return {Vector2}
	 */
	negate() {

		this.x = - this.x;
		this.y = - this.y;

		return this;

	}

	/**
	 * @param {Vector2} v
	 * @return {number} 
	 */
	dot( v ) {

		return this.x * v.x + this.y * v.y;

	}

	/**
	 * @param {Vector2} v
	 * @return {number} 
	 */
	cross( v ) {

		return this.x * v.y - this.y * v.x;

	}

	/**
	 * @return {number}
	 */
	lengthSq() {

		return this.x * this.x + this.y * this.y;

	}

	/**
	 * @return {number}
	 */
	length() {

		return Math.sqrt( this.x * this.x + this.y * this.y );

	}

	/**
	 * @return {number}
	 */
	manhattanLength() {

		return Math.abs( this.x ) + Math.abs( this.y );

	}

	/**
	 * @return {Vector2}
	 */
	normalize() {

		return this.divideScalar( this.length() || 1 );

	}

	/**
	 * @return {number}
	 */
	angle() {

		// computes the angle in radians with respect to the positive x-axis

		const angle = Math.atan2( - this.y, - this.x ) + Math.PI;

		return angle;

	}

	/**
	 * @param {Vector2} v
	 * @return {number} 
	 */
	distanceTo( v ) {

		return Math.sqrt( this.distanceToSquared( v ) );

	}

	/**
	 * @param {Vector2} v
	 * @return {number} 
	 */
	distanceToSquared( v ) {

		const dx = this.x - v.x, dy = this.y - v.y;
		return dx * dx + dy * dy;

	}

	/**
	 * @param {Vector2} v
	 * @return {number} 
	 */
	manhattanDistanceTo( v ) {

		return Math.abs( this.x - v.x ) + Math.abs( this.y - v.y );

	}

	/**
	 * 
	 * @param {number} length 
	 * @return {Vector2}
	 */
	setLength( length ) {

		return this.normalize().multiplyScalar( length );

	}

	/**
	 * 
	 * @param {Vector2} v 
	 * @param {number} alpha 
	 * @return {Vector2}
	 */
	lerp( v, alpha ) {

		this.x += ( v.x - this.x ) * alpha;
		this.y += ( v.y - this.y ) * alpha;

		return this;

	}

	/**
	 * @param {Vector2} v1 
	 * @param {Vector2} v2 
	 * @param {number} alpha 
	 * @return {Vector2}
	 */
	lerpVectors( v1, v2, alpha ) {

		this.x = v1.x + ( v2.x - v1.x ) * alpha;
		this.y = v1.y + ( v2.y - v1.y ) * alpha;

		return this;

	}

	/**
	 * @param {Vector2} v 
	 * @return {boolean}
	 */
	equals( v ) {

		return ( ( v.x === this.x ) && ( v.y === this.y ) );

	}

	/**
	 * 
	 * @param {Array<number>|TypedArray|null} array 
	 * @param {number=} offset 
	 * @return {Vector2}
	 */
	fromArray( array, offset = 0 ) {

		this.x = array[ offset ];
		this.y = array[ offset + 1 ];

		return this;

	}

	/**
	 * 
	 * @param {Array<number>=} array 
	 * @param {number=} offset 
	 * @return {Array<number>}
	 */
	toArray( array = [], offset = 0 ) {

		array[ offset ] = this.x;
		array[ offset + 1 ] = this.y;

		return array;

	}

	/**
	 *
	 * @param {Object} attribute
	 * @param {number} index
	 * @param {number=} offset
	 * @return {Vector2}
	 */
	fromBufferAttribute( attribute, index, offset ) {

		if ( offset !== undefined ) {

			console.warn( 'THREE.Vector2: offset has been removed from .fromBufferAttribute().' );

		}

		this.x = ( /** @type {{ getX : function(number): number}} */ (attribute)).getX( index );
		this.y = ( /** @type {{ getY : function(number): number}} */ (attribute)).getY( index );

		return this;

	}

	/**
	 * 
	 * @param {Vector2} center 
	 * @param {number} angle 
	 * @return {Vector2}
	 */
	rotateAround( center, angle ) {

		const c = Math.cos( angle ), s = Math.sin( angle );

		const x = this.x - center.x;
		const y = this.y - center.y;

		this.x = x * c - y * s + center.x;
		this.y = x * s + y * c + center.y;

		return this;

	}

	/**
	 * @return {Vector2}
	 */
	random() {

		this.x = Math.random();
		this.y = Math.random();

		return this;

	}

}

Vector2.prototype.isVector2 = true;

export { Vector2 };
