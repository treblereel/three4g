import { Matrix3 } from '../../math/Matrix3.js';
import { Plane } from '../../math/Plane.js';

//closure 
import { CameraInterface } from '../../closure/cameras/CameraInterface.js';
import { WebGLProperties } from './WebGLProperties.js';
import { MaterialInterface } from '../../closure/material/MaterialInterface.js';


class WebGLClipping {

	/** @param {WebGLProperties} properties */
	constructor( properties ) {

		this.properties = properties;

		this.globalState = null;
		this.numGlobalPlanes = 0;
		this.localClippingEnabled = false;
		this.renderingShadows = false;

		this.plane = new Plane();
		this.viewNormalMatrix = new Matrix3();

		this.uniform = { value: null, needsUpdate: false };
		this.numPlanes = 0;
		this.numIntersection = 0;
	}	

	/**
	 * 
	 * @param {Array<Plane>} planes 
	 * @param {boolean} enableLocalClipping 
	 * @param {CameraInterface} camera 
	 * @return {boolean}
	 */
	init( planes, enableLocalClipping, camera ) {

		const enabled =
			planes.length !== 0 ||
			enableLocalClipping ||
			// enable state of previous frame - the clipping code has to
			// run another frame in order to reset the state:
			this.numGlobalPlanes !== 0 ||
			this.localClippingEnabled;

		this.localClippingEnabled = enableLocalClipping;

		this.globalState = this.projectPlanes( planes, camera, 0 );
		this.numGlobalPlanes = planes.length;

		return enabled;

	}

	beginShadows() {

		this.renderingShadows = true;
		this.projectPlanes( null );

	}

	endShadows() {

		this.renderingShadows = false;
		this.resetGlobalState();

	}

	/**
	 * 
	 * @param {MaterialInterface} material 
	 * @param {CameraInterface} camera 
	 * @param {boolean} useCache 
	 */
	setState( material, camera, useCache ) {

		const planes = material.clippingPlanes,
			clipIntersection = material.clipIntersection,
			clipShadows = material.clipShadows;

		const materialProperties = this.properties.get( material );

		if ( ! this.localClippingEnabled || planes === null || planes.length === 0 || this.renderingShadows && ! clipShadows ) {

			// there's no local clipping

			if ( this.renderingShadows ) {

				// there's no global clipping

				this.projectPlanes( null );

			} else {

				this.resetGlobalState();

			}

		} else {

			const nGlobal = this.renderingShadows ? 0 : this.numGlobalPlanes,
				lGlobal = nGlobal * 4;

			let dstArray = materialProperties.clippingState || null;

			this.uniform.value = dstArray; // ensure unique state

			dstArray = this.projectPlanes( planes, camera, lGlobal, useCache );

			for ( let i = 0; i !== lGlobal; ++ i ) {

				dstArray[ i ] = this.globalState[ i ];

			}

			materialProperties.clippingState = dstArray;
			this.numIntersection = clipIntersection ? this.numPlanes : 0;
			this.numPlanes += nGlobal;

		}


	}

	resetGlobalState() {

		if ( this.uniform.value !== this.globalState ) {

			this.uniform.value = this.globalState;
			this.uniform.needsUpdate = this.numGlobalPlanes > 0;

		}

		this.numPlanes = this.numGlobalPlanes;
		this.numIntersection = 0;

	}

	/**
	 * 
	 * @param {Array<Plane>=} planes 
	 * @param {CameraInterface=} camera 
	 * @param {number=} dstOffset 
	 * @param {boolean=} skipTransform 
	 * @return {Float32Array}
	 */
	projectPlanes( planes, camera, dstOffset, skipTransform ) {

		const nPlanes = planes !== null ? planes.length : 0;
		/** @type {Array<number>} */
		let dstArray = null;

		if ( nPlanes !== 0 ) {

			dstArray = this.uniform.value;

			if ( skipTransform !== true || dstArray === null ) {

				const flatSize = dstOffset + nPlanes * 4,
					viewMatrix = camera.matrixWorldInverse;

					this.viewNormalMatrix.getNormalMatrix( viewMatrix );

				if ( dstArray === null || dstArray.length < flatSize ) {

					dstArray = new Float32Array( flatSize );

				}

				for ( let i = 0, i4 = dstOffset; i !== nPlanes; ++ i, i4 += 4 ) {

					this.plane.copy( planes[ i ] ).applyMatrix4( viewMatrix, this.viewNormalMatrix );

					this.plane.normal.toArray( dstArray, i4 );
					dstArray[ i4 + 3 ] = this.plane.constant;

				}

			}

			this.uniform.value = dstArray;
			this.uniform.needsUpdate = true;

		}

		this.numPlanes = nPlanes;
		this.numIntersection = 0;

		return dstArray;

	}

}


export { WebGLClipping };
