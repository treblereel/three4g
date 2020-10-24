import { MaterialParameters } from './MaterialParameters.js';

import { Texture } from '../../textures/Texture.js';

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

/**
 * @record
 * @extends {MaterialParameters}
 */
var MeshDistanceMaterialParameters = function() {};
/** @type {number|undefined} */
MeshDistanceMaterialParameters.prototype.referencePosition;
/** @type {number|undefined} */
MeshDistanceMaterialParameters.prototype.nearDistance;
/** @type {number|undefined} */
MeshDistanceMaterialParameters.prototype.farDistance;

/** @type {boolean|undefined} */
MeshDistanceMaterialParameters.prototype.skinning;
/** @type {boolean|undefined} */
MeshDistanceMaterialParameters.prototype.morphTargets;

/** @type {Texture|undefined} */
MeshDistanceMaterialParameters.prototype.map;

/** @type {Texture|undefined} */
MeshDistanceMaterialParameters.prototype.alphaMap;

/** @type {Texture|undefined} */
MeshDistanceMaterialParameters.prototype.displacementMap;
/** @type {number|undefined} */
MeshDistanceMaterialParameters.prototype.displacementScale;
/** @type {number|undefined} */
MeshDistanceMaterialParameters.prototype.displacementBias;



export { MeshDistanceMaterialParameters };