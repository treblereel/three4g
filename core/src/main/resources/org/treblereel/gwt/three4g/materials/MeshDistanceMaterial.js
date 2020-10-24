import { Material } from './Material.js';
import { Vector3 } from '../math/Vector3.js';

import { MeshDistanceMaterialParameters } from '../closure/material/MeshDistanceMaterialParameters.js';
import { Texture } from './../textures/Texture.js';

/**
 * parameters = {
 *
 *  referencePosition: <float>,
 *  nearDistance: <float>,
 *  farDistance: <float>,
 *
 *  skinning: <bool>,
 *  morphTargets: <bool>,
 *
 *  map: new THREE.Texture( <Image> ),
 *
 *  alphaMap: new THREE.Texture( <Image> ),
 *
 *  displacementMap: new THREE.Texture( <Image> ),
 *  displacementScale: <float>,
 *  displacementBias: <float>
 *
 * }
 */

class MeshDistanceMaterial extends Material {

	/**
	 * @param {MeshDistanceMaterialParameters|Object|null= } parameters 
	 */
	constructor( parameters ) {

		super();

		/** @type {string} */
		this.type = 'MeshDistanceMaterial';
		/** @type {Vector3|null} */
		this.referencePosition = new Vector3();
		/** @type {number} */
		this.nearDistance = 1;
		/** @type {number} */
		this.farDistance = 1000;
		/** @type {boolean} */
		this.skinning = false;
		/** @type {boolean} */
		this.morphTargets = false;
		/** @type {Texture|null} */
		this.map = null;
		/** @type {Texture|null} */
		this.alphaMap = null;
		/** @type {Texture|null} */
		this.displacementMap = null;
		/** @type {number} */
		this.displacementScale = 1;
		/** @type {number} */
		this.displacementBias = 0;
		/** @type {boolean} */
		this.fog = false;

		this.setValues( parameters );

	}

	/**
	 * @suppress {checkTypes}
	 * @param {MeshDistanceMaterial} source 
	 * @return {MeshDistanceMaterial}
	 */
	copy( source ) {

		super.copy( source );

		this.referencePosition.copy( source.referencePosition );
		this.nearDistance = source.nearDistance;
		this.farDistance = source.farDistance;

		this.skinning = source.skinning;
		this.morphTargets = source.morphTargets;

		this.map = source.map;

		this.alphaMap = source.alphaMap;

		this.displacementMap = source.displacementMap;
		this.displacementScale = source.displacementScale;
		this.displacementBias = source.displacementBias;

		return this;

	}

}

MeshDistanceMaterial.prototype.isMeshDistanceMaterial = true;

export { MeshDistanceMaterial };
