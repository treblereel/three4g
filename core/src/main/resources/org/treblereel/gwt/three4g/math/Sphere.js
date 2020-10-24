import { Box3 } from './Box3.js';
import { Vector3 } from './Vector3.js';

//closure shim
import { PlaneInterface } from '../closure/math/PlaneInterface.js';
import { SphereInterface } from '../closure/math/SphereInterface.js';
import { MatrixInterface } from '../closure/math/MatrixInterface.js';

const _box = /*@__PURE__*/ new Box3();

/**
 * @implements { SphereInterface }
 */
class Sphere {

	/**
	 * @param {Vector3=} center 
	 * @param {number} radius 
	 */
	constructor( center = new Vector3(), radius = - 1 ) {

		/** @type {Vector3} */
		this.center = center;
		/** @type {number} */
		this.radius = radius;

	}

	/**
	 * 
	 * @param {Vector3} center 
	 * @param {number} radius 
	 * @return {Sphere}
	 */
	set( center, radius ) {

		this.center.copy( center );
		this.radius = radius;

		return this;

	}

	/**
	 * 
	 * @param {Array<Vector3>} points 
	 * @param {Vector3} optionalCenter
	 * @return {Sphere} 
	 */
	setFromPoints( points, optionalCenter ) {

		const center = this.center;

		if ( optionalCenter !== undefined ) {

			center.copy( optionalCenter );

		} else {

			_box.setFromPoints( points ).getCenter( center );

		}

		let maxRadiusSq = 0;

		for ( let i = 0, il = points.length; i < il; i ++ ) {

			maxRadiusSq = Math.max( maxRadiusSq, center.distanceToSquared( points[ i ] ) );

		}

		this.radius = Math.sqrt( maxRadiusSq );

		return this;

	}

	/**
	 * 
	 * @param {Sphere} sphere
	 * @return {Sphere} 
	 */
	copy( sphere ) {

		this.center.copy( sphere.center );
		this.radius = sphere.radius;

		return this;

	}

	/**
	 * @return {boolean}
	 */
	isEmpty() {

		return ( this.radius < 0 );

	}

	/**
	 * @return {Sphere}
	 */
	makeEmpty() {

		this.center.set( 0, 0, 0 );
		this.radius = - 1;

		return this;

	}

	/**
	 * 
	 * @param {Vector3} point 
	 * @return {boolean}
	 */
	containsPoint( point ) {

		return ( point.distanceToSquared( this.center ) <= ( this.radius * this.radius ) );

	}

	/**
	 * 
	 * @param {Vector3} point 
	 * @return {number}
	 */
	distanceToPoint( point ) {

		return ( point.distanceTo( this.center ) - this.radius );

	}

	/**
	 * 
	 * @param {Sphere} sphere 
	 * @return {boolean}
	 */
	intersectsSphere( sphere ) {

		const radiusSum = this.radius + sphere.radius;

		return sphere.center.distanceToSquared( this.center ) <= ( radiusSum * radiusSum );

	}

	/**
	 * 
	 * @param {Box3} box 
	 * @return {boolean}
	 */
	intersectsBox( box ) {

		return box.intersectsSphere( this );

	}

	/**
	 * 
	 * @param { PlaneInterface } plane 
	 * @return {boolean}
	 */
	intersectsPlane( plane ) {

		return Math.abs( plane.distanceToPoint( this.center ) ) <= this.radius;

	}

	/**
	 * 
	 * @param {Vector3} point 
	 * @param {Vector3} target
	 * @return {Vector3} 
	 */
	clampPoint( point, target ) {

		const deltaLengthSq = this.center.distanceToSquared( point );

		if ( target === undefined ) {

			console.warn( 'THREE.Sphere: .clampPoint() target is now required' );
			target = new Vector3();

		}

		target.copy( point );

		if ( deltaLengthSq > ( this.radius * this.radius ) ) {

			target.sub( this.center ).normalize();
			target.multiplyScalar( this.radius ).add( this.center );

		}

		return target;

	}

	/**
	 * 
	 * @param {Box3} target 
	 * @return {Box3}
	 */
	getBoundingBox( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Sphere: .getBoundingBox() target is now required' );
			target = new Box3();

		}

		if ( this.isEmpty() ) {

			// Empty sphere produces empty bounding box
			target.makeEmpty();
			return target;

		}

		target.set( this.center, this.center );
		target.expandByScalar( this.radius );

		return target;

	}

	/**
	 * 
	 * @param  { MatrixInterface } matrix
	 * @return {Sphere}
	 */
	applyMatrix4( matrix ) {

		this.center.applyMatrix4( matrix );
		this.radius = this.radius * matrix.getMaxScaleOnAxis();

		return this;

	}

	/**
	 * @param {Vector3} offset
	 * @return {Sphere}
	 */
	translate( offset ) {

		this.center.add( offset );

		return this;

	}

	/**
	 * @param {Sphere} sphere
	 * @return {boolean}
	 */
	equals( sphere ) {

		return sphere.center.equals( this.center ) && ( sphere.radius === this.radius );

	}

	/**
	 * @return {Sphere}
	 */
	clone() {

		return new this.constructor().copy( this );

	}

}

export { Sphere };
