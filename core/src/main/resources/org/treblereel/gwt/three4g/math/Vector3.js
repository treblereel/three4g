import { MathUtils } from './MathUtils.js';
import { Quaternion } from './Quaternion.js';

//closure compiler
import { EulerInterface } from '../closure/math/EulerInterface.js';
import { Vector3Interface } from '../closure/math/Vector3Interface.js';
import { MatrixInterface } from '../closure/math/MatrixInterface.js';
import { CameraInterface } from '../closure/cameras/CameraInterface.js';

/**
 * @implements { Vector3Interface }
 */
class Vector3 {

	/**
	 * 
	 * @param {number=} x 
	 * @param {number=} y 
	 * @param {number=} z 
	 */
	constructor( x = 0, y = 0, z = 0 ) {

		/** @type {number} */
		this.x = x;
		/** @type {number} */
		this.y = y;
		/** @type {number} */
		this.z = z;

	}

	/**
	 * 
	 * @param {number} x 
	 * @param {number} y 
	 * @param {number=} z 
	 * @return {Vector3}
	 */
	set( x, y, z ) {

		if ( z === undefined ) z = this.z; // sprite.scale.set(x,y)

		this.x = x;
		this.y = y;
		this.z = z;

		return this;

	}

	/**
	 * @param {number} scalar 
	 * @return {Vector3}
	 */
	setScalar( scalar ) {

		this.x = scalar;
		this.y = scalar;
		this.z = scalar;

		return this;

	}

	/**
	 * @param {number} x 
	 * @return {Vector3}
	 */
	setX( x ) {

		this.x = x;

		return this;

	}

	/**
	 * @param {number} y
	 * @return {Vector3}
	 */
	setY( y ) {

		this.y = y;

		return this;

	}

	/**
	 * @param {number} z
	 * @return {Vector3}
	 */
	setZ( z ) {

		this.z = z;

		return this;

	}

	/**
	 * @param {number} index
	 * @param {number} value
	 * @return {Vector3}
	 */
	setComponent( index, value ) {

		switch ( index ) {

			case 0: this.x = value; break;
			case 1: this.y = value; break;
			case 2: this.z = value; break;
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
			case 2: return this.z;
			default: throw new Error( 'index is out of range: ' + index );

		}

	}

	/**
	* @return {Vector3}
	*/
	clone() {

		return new Vector3( this.x, this.y, this.z );

	}

	/**
	 * @param {Vector3} v
	 * @return {Vector3}
	 */
	copy( v ) {

		this.x = v.x;
		this.y = v.y;
		this.z = v.z;

		return this;

	}

	/**
	 * @param {Vector3} v
	 * @param {Vector3=} w
	 * @return {Vector3}
	 */
	add( v, w ) {

		if ( w !== undefined ) {

			console.warn( 'THREE.Vector3: .add() now only accepts one argument. Use .addVectors( a, b ) instead.' );
			return this.addVectors( v, w );

		}

		this.x += v.x;
		this.y += v.y;
		this.z += v.z;

		return this;

	}

	/**
	 * @param {number} s
	 * @return {Vector3} 
	 */
	addScalar( s ) {

		this.x += s;
		this.y += s;
		this.z += s;

		return this;

	}

	/**
	 * @param {Vector3} a
	 * @param {Vector3} b
	 * @return {Vector3} 
	 */
	addVectors( a, b ) {

		this.x = a.x + b.x;
		this.y = a.y + b.y;
		this.z = a.z + b.z;

		return this;

	}

	/**
	 * @param {Vector3} v
	 * @param {number} s
	 * @return {Vector3} 
	 */
	addScaledVector( v, s ) {

		this.x += v.x * s;
		this.y += v.y * s;
		this.z += v.z * s;

		return this;

	}

	/**
	 *
	 * @param {Vector3} v
	 * @param {Vector3=} w
	 * @return {Vector3}
	 */
	sub( v, w ) {

		if ( w !== undefined ) {

			console.warn( 'THREE.Vector3: .sub() now only accepts one argument. Use .subVectors( a, b ) instead.' );
			return this.subVectors( v, w );

		}

		this.x -= v.x;
		this.y -= v.y;
		this.z -= v.z;

		return this;

	}

	/**
	 * @param {number} s
	 * @return {Vector3} 
	 */
	subScalar( s ) {

		this.x -= s;
		this.y -= s;
		this.z -= s;

		return this;

	}

	/**
	 *
	 * @param {Vector3} a
	 * @param {Vector3} b
	 * @return {Vector3}
	 */
	subVectors( a, b ) {

		this.x = a.x - b.x;
		this.y = a.y - b.y;
		this.z = a.z - b.z;

		return this;

	}

	/**
	 *
	 * @param {Vector3} v
	 * @param {Vector3=} w
	 * @return {Vector3}
	 */
	multiply( v, w ) {

		if ( w !== undefined ) {

			console.warn( 'THREE.Vector3: .multiply() now only accepts one argument. Use .multiplyVectors( a, b ) instead.' );
			return this.multiplyVectors( v, w );

		}

		this.x *= v.x;
		this.y *= v.y;
		this.z *= v.z;

		return this;

	}

	/**
	 * @param {number} scalar
	 * @return {Vector3} 
	 */
	multiplyScalar( scalar ) {

		this.x *= scalar;
		this.y *= scalar;
		this.z *= scalar;

		return this;

	}

		/**
	 *
	 * @param {Vector3} a
	 * @param {Vector3=} b
	 * @return {Vector3}
	 */
	multiplyVectors( a, b ) {

		this.x = a.x * b.x;
		this.y = a.y * b.y;
		this.z = a.z * b.z;

		return this;

	}

	/**
	 * @param { EulerInterface } euler
	 * @return {Vector3}
	 */
	applyEuler( euler ) {

		if ( ! ( euler && euler.isEuler ) ) {

			console.error( 'THREE.Vector3: .applyEuler() now expects an Euler rotation rather than a Vector3 and order.' );

		}

		return this.applyQuaternion( _quaternion.setFromEuler( euler ) );

	}

	/**
	 * 
	 * @suppress {checkTypes} 
	 * @param {Vector3} axis 
	 * @param {number} angle
	 * @return {Vector3} 
	 */
	applyAxisAngle( axis, angle ) {

		return this.applyQuaternion( _quaternion.setFromAxisAngle( axis, angle ) );

	}

	/**
	 * @param { MatrixInterface } m
	 * @return {Vector3} 
	 */
	applyMatrix3( m ) {

		const x = this.x, y = this.y, z = this.z;
		const e = m.elements;

		this.x = e[ 0 ] * x + e[ 3 ] * y + e[ 6 ] * z;
		this.y = e[ 1 ] * x + e[ 4 ] * y + e[ 7 ] * z;
		this.z = e[ 2 ] * x + e[ 5 ] * y + e[ 8 ] * z;

		return this;

	}

	/**
	 * @param { MatrixInterface } m
	* @return {Vector3} 
	*/
	applyNormalMatrix( m ) {

		return this.applyMatrix3( m ).normalize();

	}

	/**
	 * @param  { MatrixInterface } m
	* @return {Vector3} 
	*/
	applyMatrix4( m ) {

		const x = this.x, y = this.y, z = this.z;
		const e = m.elements;

		const w = 1 / ( e[ 3 ] * x + e[ 7 ] * y + e[ 11 ] * z + e[ 15 ] );

		this.x = ( e[ 0 ] * x + e[ 4 ] * y + e[ 8 ] * z + e[ 12 ] ) * w;
		this.y = ( e[ 1 ] * x + e[ 5 ] * y + e[ 9 ] * z + e[ 13 ] ) * w;
		this.z = ( e[ 2 ] * x + e[ 6 ] * y + e[ 10 ] * z + e[ 14 ] ) * w;

		return this;

	}

	/**
	* @param {Quaternion} q 
  	* @return {Vector3} 
	*/
	applyQuaternion( q ) {

		const x = this.x, y = this.y, z = this.z;
		const qx = q.x, qy = q.y, qz = q.z, qw = q.w;

		// calculate quat * vector

		const ix = qw * x + qy * z - qz * y;
		const iy = qw * y + qz * x - qx * z;
		const iz = qw * z + qx * y - qy * x;
		const iw = - qx * x - qy * y - qz * z;

		// calculate result * inverse quat

		this.x = ix * qw + iw * - qx + iy * - qz - iz * - qy;
		this.y = iy * qw + iw * - qy + iz * - qx - ix * - qz;
		this.z = iz * qw + iw * - qz + ix * - qy - iy * - qx;

		return this;

	}

	/**
 	 * @param { CameraInterface } camera
  	* @return {Vector3} 
	*/
	project( camera ) {

		return this.applyMatrix4( camera.matrixWorldInverse ).applyMatrix4( camera.projectionMatrix );

	}

	/**
	 * @param { CameraInterface } camera
  	* @return {Vector3} 
	*/
	unproject( camera ) {

		return this.applyMatrix4( camera.projectionMatrixInverse ).applyMatrix4( camera.matrixWorld );

	}

	/**
	 * @param { MatrixInterface } m
  	* @return {Vector3} 
	*/
	transformDirection( m ) {

		// input: THREE.Matrix4 affine matrix
		// vector interpreted as a direction

		const x = this.x, y = this.y, z = this.z;
		const e = m.elements;

		this.x = e[ 0 ] * x + e[ 4 ] * y + e[ 8 ] * z;
		this.y = e[ 1 ] * x + e[ 5 ] * y + e[ 9 ] * z;
		this.z = e[ 2 ] * x + e[ 6 ] * y + e[ 10 ] * z;

		return this.normalize();

	}

	/**
	* @param {Vector3} v
  	* @return {Vector3} 
	*/
	divide( v ) {

		this.x /= v.x;
		this.y /= v.y;
		this.z /= v.z;

		return this;

	}

	/**
	* @param {number} scalar
  	* @return {Vector3} 
	*/
	divideScalar( scalar ) {

		return this.multiplyScalar( 1 / scalar );

	}

	/**
	* @param {Vector3} v
  	* @return {Vector3} 
	*/
	min( v ) {

		this.x = Math.min( this.x, v.x );
		this.y = Math.min( this.y, v.y );
		this.z = Math.min( this.z, v.z );

		return this;

	}

	/**
	* @param {Vector3} v
  	* @return {Vector3} 
	*/
	max( v ) {

		this.x = Math.max( this.x, v.x );
		this.y = Math.max( this.y, v.y );
		this.z = Math.max( this.z, v.z );

		return this;

	}

	/**
	* @param {Vector3} min
	* @param {Vector3} max
  	* @return {Vector3} 
	*/
	clamp( min, max ) {

		// assumes min < max, componentwise

		this.x = Math.max( min.x, Math.min( max.x, this.x ) );
		this.y = Math.max( min.y, Math.min( max.y, this.y ) );
		this.z = Math.max( min.z, Math.min( max.z, this.z ) );

		return this;

	}

	/**
	* @param {number} minVal
	* @param {number} maxVal
  	* @return {Vector3} 
	*/
	clampScalar( minVal, maxVal ) {

		this.x = Math.max( minVal, Math.min( maxVal, this.x ) );
		this.y = Math.max( minVal, Math.min( maxVal, this.y ) );
		this.z = Math.max( minVal, Math.min( maxVal, this.z ) );

		return this;

	}

	/**
	* @param {number} min
	* @param {number} max
  	* @return {Vector3} 
	*/
	clampLength( min, max ) {

		const length = this.length();

		return this.divideScalar( length || 1 ).multiplyScalar( Math.max( min, Math.min( max, length ) ) );

	}

	/**
  	* @return {Vector3} 
	*/
	floor() {

		this.x = Math.floor( this.x );
		this.y = Math.floor( this.y );
		this.z = Math.floor( this.z );

		return this;

	}

	/**
  	* @return {Vector3} 
	*/
	ceil() {

		this.x = Math.ceil( this.x );
		this.y = Math.ceil( this.y );
		this.z = Math.ceil( this.z );

		return this;

	}

	/**
  	* @return {Vector3} 
	*/
	round() {

		this.x = Math.round( this.x );
		this.y = Math.round( this.y );
		this.z = Math.round( this.z );

		return this;

	}

	/**
  	* @return {Vector3} 
	*/
	roundToZero() {

		this.x = ( this.x < 0 ) ? Math.ceil( this.x ) : Math.floor( this.x );
		this.y = ( this.y < 0 ) ? Math.ceil( this.y ) : Math.floor( this.y );
		this.z = ( this.z < 0 ) ? Math.ceil( this.z ) : Math.floor( this.z );

		return this;

	}

	/**
  	* @return {Vector3} 
	*/
	negate() {

		this.x = - this.x;
		this.y = - this.y;
		this.z = - this.z;

		return this;

	}

	/**
	* @suppress {checkTypes}
	* @overrides
	* @param {Vector3} v
  	* @return {number} 
	*/
	dot( v ) {

		return this.x * v.x + this.y * v.y + this.z * v.z;

	}

	// TODO lengthSquared?
	/**
  	* @return {number} 
	*/
	lengthSq() {

		return this.x * this.x + this.y * this.y + this.z * this.z;

	}

	/**
	 * @return {number}
	 */
	length() {

		return Math.sqrt( this.x * this.x + this.y * this.y + this.z * this.z );

	}

	/**
  	* @return {number} 
	*/
	manhattanLength() {

		return Math.abs( this.x ) + Math.abs( this.y ) + Math.abs( this.z );

	}

	/**
  	* @return {Vector3} 
	*/
	normalize() {

		return this.divideScalar( this.length() || 1 );

	}

	/**
	* @param {number} length
  	* @return {Vector3} 
	*/
	setLength( length ) {

		return this.normalize().multiplyScalar( length );

	}

	/**
	* @param {Vector3} v
	* @param {number} alpha
  	* @return {Vector3} 
	*/
	lerp( v, alpha ) {

		this.x += ( v.x - this.x ) * alpha;
		this.y += ( v.y - this.y ) * alpha;
		this.z += ( v.z - this.z ) * alpha;

		return this;

	}

	/**
	* @param {Vector3} v1
	* @param {Vector3} v2
	* @param {number} alpha
  	* @return {Vector3} 
	*/
	lerpVectors( v1, v2, alpha ) {

		this.x = v1.x + ( v2.x - v1.x ) * alpha;
		this.y = v1.y + ( v2.y - v1.y ) * alpha;
		this.z = v1.z + ( v2.z - v1.z ) * alpha;

		return this;

	}


		/**
	 * @param {Vector3} v
	 * @param {Vector3=} w
	 * @return {Vector3}
	 */
	cross( v, w ) {

		if ( w !== undefined ) {

			console.warn( 'THREE.Vector3: .cross() now only accepts one argument. Use .crossVectors( a, b ) instead.' );
			return this.crossVectors( v, w );

		}

		return this.crossVectors( this, v );

	}

	/**
	* @param {Vector3} a
	* @param {Vector3} b
  	* @return {Vector3} 
	*/
	crossVectors( a, b ) {

		const ax = a.x, ay = a.y, az = a.z;
		const bx = b.x, by = b.y, bz = b.z;

		this.x = ay * bz - az * by;
		this.y = az * bx - ax * bz;
		this.z = ax * by - ay * bx;

		return this;

	}

	/**
	* @param {Vector3} v
  	* @return {Vector3} 
	*/
	projectOnVector( v ) {

		const denominator = v.lengthSq();

		if ( denominator === 0 ) return this.set( 0, 0, 0 );

		const scalar = v.dot( this ) / denominator;

		return this.copy( v ).multiplyScalar( scalar );

	}

	/**
	* @param {Vector3} planeNormal
  	* @return {Vector3} 
	*/
	projectOnPlane( planeNormal ) {

		_vector.copy( this ).projectOnVector( planeNormal );

		return this.sub( _vector );

	}

	/**
	* @param {Vector3} normal
  	* @return {Vector3} 
	*/
	reflect( normal ) {

		// reflect incident vector off plane orthogonal to normal
		// normal is assumed to have unit length

		return this.sub( _vector.copy( normal ).multiplyScalar( 2 * this.dot( normal ) ) );

	}

	/**
	* @param {Vector3} v
  	* @return {number} 
	*/
	angleTo( v ) {

		const denominator = Math.sqrt( this.lengthSq() * v.lengthSq() );

		if ( denominator === 0 ) return Math.PI / 2;

		const theta = this.dot( v ) / denominator;

		// clamp, to handle numerical problems

		return Math.acos( MathUtils.clamp( theta, - 1, 1 ) );

	}

	/**
	* @param {Vector3} v
  	* @return {number} 
	*/
	distanceTo( v ) {

		return Math.sqrt( this.distanceToSquared( v ) );

	}

	/**
	* @param {Vector3} v
  	* @return {number} 
	*/
	distanceToSquared( v ) {

		const dx = this.x - v.x, dy = this.y - v.y, dz = this.z - v.z;

		return dx * dx + dy * dy + dz * dz;

	}

	/**
	* @param {Vector3} v
  	* @return {number} 
	*/
	manhattanDistanceTo( v ) {

		return Math.abs( this.x - v.x ) + Math.abs( this.y - v.y ) + Math.abs( this.z - v.z );

	}

	/**
	 * 
	 * @param {{radius:number, phi: number, theta : number }} s
	 * @return {Vector3} 
	 */
	setFromSpherical( s ) {

		return this.setFromSphericalCoords( s.radius, s.phi, s.theta );

	}

	/**
	* @param {number} radius
	* @param {number} phi
	* @param {number} theta
  	* @return {Vector3} 
	*/
	setFromSphericalCoords( radius, phi, theta ) {

		const sinPhiRadius = Math.sin( phi ) * radius;

		this.x = sinPhiRadius * Math.sin( theta );
		this.y = Math.cos( phi ) * radius;
		this.z = sinPhiRadius * Math.cos( theta );

		return this;

	}

	/**
	 * 
	 * @param {{radius:number, theta: number, y : number }} c 
	 * @return {Vector3} 
	 */
	setFromCylindrical( c ) {

		return this.setFromCylindricalCoords( c.radius, c.theta, c.y );

	}

	/**
	* @param {number} radius
	* @param {number} theta
	* @param {number} y
  	* @return {Vector3} 
	*/
	setFromCylindricalCoords( radius, theta, y ) {

		this.x = radius * Math.sin( theta );
		this.y = y;
		this.z = radius * Math.cos( theta );

		return this;

	}

	/**
	* @param { MatrixInterface } m
  	* @return {Vector3} 
	*/
	setFromMatrixPosition( m ) {

		const e = m.elements;

		this.x = e[ 12 ];
		this.y = e[ 13 ];
		this.z = e[ 14 ];

		return this;

	}

	/**
	 * @param { MatrixInterface } m
  	* @return {Vector3} 
	*/
	setFromMatrixScale( m ) {

		const sx = this.setFromMatrixColumn( m, 0 ).length();
		const sy = this.setFromMatrixColumn( m, 1 ).length();
		const sz = this.setFromMatrixColumn( m, 2 ).length();

		this.x = sx;
		this.y = sy;
		this.z = sz;

		return this;

	}

	/**
	 * @param { MatrixInterface } m
	 * @param {number} index
  	 * @return {Vector3} 
	 */
	setFromMatrixColumn( m, index ) {

		return this.fromArray( m.elements, index * 4 );

	}

	/**
	 * @param { MatrixInterface } m
	 * @param {number} index
  	* @return {Vector3} 
	*/
	setFromMatrix3Column( m, index ) {

		return this.fromArray( m.elements, index * 3 );

	}

	/**
	 * @param {Vector3} v
	 * @return {boolean} 
	 */
	equals( v ) {

		return ( ( v.x === this.x ) && ( v.y === this.y ) && ( v.z === this.z ) );

	}

	/**
	 * @param {Array<number>} array 
	 * @param {number=} offset 
	 * @return {Vector3}
	 */
	fromArray( array, offset = 0 ) {

		this.x = array[ offset ];
		this.y = array[ offset + 1 ];
		this.z = array[ offset + 2 ];

		return this;

	}

	/**
	* @param {Array<number>=} array 
	* @param {number=} offset 
	* @return {Array<number>}
	*/
	toArray( array = [], offset = 0 ) {

		array[ offset ] = this.x;
		array[ offset + 1 ] = this.y;
		array[ offset + 2 ] = this.z;

		return array;

	}

		/**
	 *
	 * @param {Object} attribute
	 * @param {number} index
	 * @param {number=} offset
	 * @return {Vector3}
	 */
	fromBufferAttribute( attribute, index, offset ) {

		if ( offset !== undefined ) {

			console.warn( 'THREE.Vector3: offset has been removed from .fromBufferAttribute().' );

		}

		this.x = ( /** @type {{ getX : function(number): number}} */ (attribute)).getX( index );
		this.y = ( /** @type {{ getY : function(number): number}} */ (attribute)).getY( index );
		this.z = ( /** @type {{ getZ : function(number): number}} */ (attribute)).getZ( index );

		return this;

	}

	/**
	 * @return {Vector3}
	 */
	random() {

		this.x = Math.random();
		this.y = Math.random();
		this.z = Math.random();

		return this;

	}

}

Vector3.prototype.isVector3 = true;

const _vector = /*@__PURE__*/ new Vector3();
const _quaternion = /*@__PURE__*/ new Quaternion();

export { Vector3 };
