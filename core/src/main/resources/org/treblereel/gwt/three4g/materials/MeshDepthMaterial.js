import { Material } from './Material.js';
import { BasicDepthPacking } from '../constants.js';

import { MeshDepthMaterialParameters } from '../closure/material/MeshDepthMaterialParameters.js';
import { Texture } from './../textures/Texture.js';

/**
 * parameters = {
 *
 *  opacity: <float>,
 *
 *  map: new THREE.Texture( <Image> ),
 *
 *  alphaMap: new THREE.Texture( <Image> ),
 *
 *  displacementMap: new THREE.Texture( <Image> ),
 *  displacementScale: <float>,
 *  displacementBias: <float>,
 *
 *  wireframe: <boolean>,
 *  wireframeLinewidth: <float>
 * }
 */

class MeshDepthMaterial extends Material {

	/**
	 * @param {MeshDepthMaterialParameters|Object|null=} parameters 
	 */
	constructor( parameters ) {

		super();

		/** @type {string} */
		this.type = 'MeshDepthMaterial';
		/** @type {number} */
		this.depthPacking = BasicDepthPacking;
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
		this.wireframe = false;
		/** @type {number} */
		this.wireframeLinewidth = 1;
		/** @type {boolean} */
		this.fog = false;

		this.setValues( parameters );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {MeshDepthMaterial} source 
	 * @return {MeshDepthMaterial}
	 */
	copy( source ) {

		super.copy( source );

		this.depthPacking = source.depthPacking;

		this.skinning = source.skinning;
		this.morphTargets = source.morphTargets;

		this.map = source.map;

		this.alphaMap = source.alphaMap;

		this.displacementMap = source.displacementMap;
		this.displacementScale = source.displacementScale;
		this.displacementBias = source.displacementBias;

		this.wireframe = source.wireframe;
		this.wireframeLinewidth = source.wireframeLinewidth;

		return this;

	}

}

MeshDepthMaterial.prototype.isMeshDepthMaterial = true;

export { MeshDepthMaterial };
