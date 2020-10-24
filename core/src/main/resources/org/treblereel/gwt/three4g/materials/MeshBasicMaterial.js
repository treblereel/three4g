import { Material } from './Material.js';
import { MultiplyOperation } from '../constants.js';
import { Color } from '../math/Color.js';

import { MeshBasicMaterialParameters } from '../closure/material/MeshBasicMaterialParameters.js';
import { Texture } from './../textures/Texture.js';
import { CubeTexture } from './../textures/CubeTexture.js';

class MeshBasicMaterial extends Material {

	/**
	 * @param { MeshBasicMaterialParameters|Object|null= } parameters 
	 */
	constructor( parameters ) {

		super();

		/** @type {string} */
		this.type = 'MeshBasicMaterial';
		/** @type {Color} */
		this.color = new Color( 0xffffff ); // emissive
		/** @type {Texture|null} */
		this.map = null;
		/** @type {Texture|null} */
		this.lightMap = null;
		/** @type {number} */
		this.lightMapIntensity = 1.0;
		/** @type {Texture|null} */
		this.aoMap = null;
		/** @type {number} */
		this.aoMapIntensity = 1.0;
		/** @type {Texture|null} */
		this.specularMap = null;
		/** @type {Texture|null} */
		this.alphaMap = null;
		/** @type {CubeTexture|null} */
		this.envMap = null;
		/** @type {number} */
		this.combine = MultiplyOperation;
		/** @type {number} */
		this.reflectivity = 1;
		/** @type {number} */
		this.refractionRatio = 0.98;
		/** @type {boolean} */
		this.wireframe = false;
		/** @type {number} */
		this.wireframeLinewidth = 1;
		/** @type {string} */
		this.wireframeLinecap = 'round';
		/** @type {string} */
		this.wireframeLinejoin = 'round';
		/** @type {boolean} */
		this.skinning = false;
		/** @type {boolean} */
		this.morphTargets = false;

		this.setValues( parameters );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {MeshBasicMaterial} source
	 * @return {MeshBasicMaterial} 
	 */
	copy( source ) {

		super.copy( source );

		this.color.copy( source.color );

		this.map = source.map;

		this.lightMap = source.lightMap;
		this.lightMapIntensity = source.lightMapIntensity;

		this.aoMap = source.aoMap;
		this.aoMapIntensity = source.aoMapIntensity;

		this.specularMap = source.specularMap;

		this.alphaMap = source.alphaMap;

		this.envMap = source.envMap;
		this.combine = source.combine;
		this.reflectivity = source.reflectivity;
		this.refractionRatio = source.refractionRatio;

		this.wireframe = source.wireframe;
		this.wireframeLinewidth = source.wireframeLinewidth;
		this.wireframeLinecap = source.wireframeLinecap;
		this.wireframeLinejoin = source.wireframeLinejoin;

		this.skinning = source.skinning;
		this.morphTargets = source.morphTargets;

		return this;

	}

}

MeshBasicMaterial.prototype.isMeshBasicMaterial = true;

export { MeshBasicMaterial };
