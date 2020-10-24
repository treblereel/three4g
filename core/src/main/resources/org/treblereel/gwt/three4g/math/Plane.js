import { Matrix3 } from './Matrix3.js';
import { Matrix4 } from './Matrix4.js';
import { Vector3 } from './Vector3.js';

//closure compiler
import { Box3Interface } from '../closure/math/Box3Interface.js';
import { PlaneInterface } from '../closure/math/PlaneInterface.js';
import { SphereInterface } from '../closure/math/SphereInterface.js';

const _vector1 = /*@__PURE__*/ new Vector3();
const _vector2 = /*@__PURE__*/ new Vector3();
const _normalMatrix = /*@__PURE__*/ new Matrix3();

/**
 * @implements { PlaneInterface }
 */
class Plane {

	/**
	 * @param {Vector3=} normal 
	 * @param {number=} constant 
	 */
	constructor( normal = new Vector3( 1, 0, 0 ), constant = 0 ) {

		// normal is assumed to be normalized

		/** @type {Vector3} */
		this.normal = normal;
		/** @type {number} */
		this.constant = constant;

	}

	/**
	 * @param {Vector3} normal 
	 * @param {number} constant
	 * @return {Plane} 
	 */
	set( normal, constant ) {

		this.normal.copy( normal );
		this.constant = constant;

		return this;

	}

	/**
	 * @param {number} x 
	 * @param {number} y 
	 * @param {number} z 
	 * @param {number} w 
	 * @return {Plane} 
	 */
	setComponents( x, y, z, w ) {

		this.normal.set( x, y, z );
		this.constant = w;

		return this;

	}

	/**
	 * @param {Vector3} normal 
	 * @param {Vector3} point
	 * @return {Plane} 
	 */
	setFromNormalAndCoplanarPoint( normal, point ) {

		this.normal.copy( normal );
		this.constant = - point.dot( this.normal );

		return this;

	}

	/**
	* @param {Vector3} a 
	* @param {Vector3} b
	* @param {Vector3} c
	* @return {Plane} 
	*/
	setFromCoplanarPoints( a, b, c ) {

		const normal = _vector1.subVectors( c, b ).cross( _vector2.subVectors( a, b ) ).normalize();

		// Q: should an error be thrown if normal is zero (e.g. degenerate plane)?

		this.setFromNormalAndCoplanarPoint( normal, a );

		return this;

	}

	/**
	* @param {Plane} plane
	* @return {Plane} 
	*/
	copy( plane ) {

		this.normal.copy( plane.normal );
		this.constant = plane.constant;

		return this;

	}

	/**
	* @return {Plane} 
	*/
	normalize() {

		// Note: will lead to a divide by zero if the plane is invalid.

		const inverseNormalLength = 1.0 / this.normal.length();
		this.normal.multiplyScalar( inverseNormalLength );
		this.constant *= inverseNormalLength;

		return this;

	}

	/**
	* @return {Plane} 
	*/
	negate() {

		this.constant *= - 1;
		this.normal.negate();

		return this;

	}

	/**
	* @param {Vector3} point
	* @return {number} 
	*/
	distanceToPoint( point ) {

		return this.normal.dot( point ) + this.constant;

	}

	/**
	 * @param { SphereInterface } sphere
	* @return {number} 
	*/
	distanceToSphere( sphere ) {

		return this.distanceToPoint( sphere.center ) - sphere.radius;

	}

	/**
	* @param {Vector3} point
	* @param {Vector3=} target
	* @return {Vector3} 
	*/
	projectPoint( point, target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Plane: .projectPoint() target is now required' );
			target = new Vector3();

		}

		return target.copy( this.normal ).multiplyScalar( - this.distanceToPoint( point ) ).add( point );

	}

	/**
	 * @param { { delta : function(Vector3) : Vector3, start : Vector3 } } line
	 * @param {Vector3} target
	 * @return {Vector3|undefined} 
	 */
	intersectLine( line, target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Plane: .intersectLine() target is now required' );
			target = new Vector3();

		}

		const direction = line.delta( _vector1 );

		const denominator = this.normal.dot( direction );

		if ( denominator === 0 ) {

			// line is coplanar, return origin
			if ( this.distanceToPoint( line.start ) === 0 ) {

				return target.copy( line.start );

			}

			// Unsure if this is the correct method to handle this case.
			return undefined;

		}

		const t = - ( line.start.dot( this.normal ) + this.constant ) / denominator;

		if ( t < 0 || t > 1 ) {

			return undefined;

		}

		return target.copy( direction ).multiplyScalar( t ).add( line.start );

	}

	/**
	 * @param {{start : Vector3, end: Vector3}} line
	* @return {boolean} 
	*/
	intersectsLine( line ) {

		// Note: this tests if a line intersects the plane, not whether it (or its end-points) are coplanar with it.

		const startSign = this.distanceToPoint( line.start );
		const endSign = this.distanceToPoint( line.end );

		return ( startSign < 0 && endSign > 0 ) || ( endSign < 0 && startSign > 0 );

	}

	/**
	 * @param { Box3Interface } box
	* @return {boolean} 
	*/
	intersectsBox( box ) {

		return box.intersectsPlane( this );

	}

	/**
	 * @param { SphereInterface } sphere
	* @return {boolean} 
	*/
	intersectsSphere( sphere ) {

		return sphere.intersectsPlane( this );

	}

	/**
	* @param {Vector3} target 
	* @return {Vector3} 
	*/
	coplanarPoint( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Plane: .coplanarPoint() target is now required' );
			target = new Vector3();

		}

		return target.copy( this.normal ).multiplyScalar( - this.constant );

	}

	/**
	 * 
	 * @suppress {checkTypes} 
	 * @param {Matrix4} matrix
	 * @param {Matrix3} optionalNormalMatrix
	 * @return {Plane} 
	*/
	applyMatrix4( matrix, optionalNormalMatrix ) {

		const normalMatrix = optionalNormalMatrix || _normalMatrix.getNormalMatrix( matrix );

		const referencePoint = this.coplanarPoint( _vector1 ).applyMatrix4( matrix );

		const normal = this.normal.applyMatrix3( normalMatrix ).normalize();

		this.constant = - referencePoint.dot( normal );

		return this;

	}

	/**
	 * @param {Vector3} offset
	* @return {Plane} 
	*/
	translate( offset ) {

		this.constant -= offset.dot( this.normal );

		return this;

	}

	/**
	 * @param {Plane} plane
	 * @return {boolean} 
	 */
	equals( plane ) {

		return plane.normal.equals( this.normal ) && ( plane.constant === this.constant );

	}

	/**
	 * @return {Plane} 
	 */
	clone() {

		return new this.constructor().copy( this );

	}

}

Plane.prototype.isPlane = true;

export { Plane };
