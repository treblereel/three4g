import { Matrix4 } from '../math/Matrix4.js';
import { Object3D } from '../core/Object3D.js';
import { Vector3 } from '../math/Vector3.js';

class Camera extends Object3D {

	constructor() {

		super();

		/** @type {string} */
		this.type = 'Camera';
		/** @type {Matrix4} */
		this.matrixWorldInverse = new Matrix4();
		/** @type {Matrix4} */
		this.projectionMatrix = new Matrix4();
		/** @type {Matrix4} */
		this.projectionMatrixInverse = new Matrix4();
		/** @type {boolean} */
		this.isCamera = true;

	}

	/**
     * @suppress {checkTypes} 
	 * @param {Camera} source 
	 * @param {boolean=} recursive 
	 * @return {Camera}
	 */
	copy( source, recursive ) {

		Object3D.prototype.copy.call( this, source, recursive );

		this.matrixWorldInverse.copy( source.matrixWorldInverse );

		this.projectionMatrix.copy( source.projectionMatrix );
		this.projectionMatrixInverse.copy( source.projectionMatrixInverse );

		return this;

	}

	/**
	 * @param {Vector3=} target 
	 */
	getWorldDirection( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Camera: .getWorldDirection() target is now required' );
			target = new Vector3();

		}

		this.updateWorldMatrix( true, false );

		const e = this.matrixWorld.elements;

		return target.set( - e[ 8 ], - e[ 9 ], - e[ 10 ] ).normalize();

	}

	/**
	 * @param {boolean=} force 
	 */
	updateMatrixWorld( force ) {

		Object3D.prototype.updateMatrixWorld.call( this, force );

		this.matrixWorldInverse.copy( this.matrixWorld ).invert();

	}

	/**
	 * 
	 * @param {boolean} updateParents 
	 * @param {boolean} updateChildren 
	 */
	updateWorldMatrix( updateParents, updateChildren ) {

		Object3D.prototype.updateWorldMatrix.call( this, updateParents, updateChildren );

		this.matrixWorldInverse.copy( this.matrixWorld ).invert();

	}

	/**
	 * @return {Camera}
	 */
	clone() {

		return new this.constructor().copy( this );

	}

}

export { Camera };
