import { MaterialParameters } from './MaterialParameters.js';

import { Texture } from '../../textures/Texture.js';

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

/**
 * @record
 * @extends {MaterialParameters}
 */
var MeshDepthMaterialParameters = function() {};
/** @type {number|undefined} */
MeshDepthMaterialParameters.prototype.opacity;
/** @type {Texture|undefined} */
MeshDepthMaterialParameters.prototype.map;
/** @type {Texture|undefined} */
MeshDepthMaterialParameters.prototype.alphaMap;
/** @type {Texture|undefined} */
MeshDepthMaterialParameters.prototype.displacementMap;
/** @type {number|undefined} */
MeshDepthMaterialParameters.prototype.displacementScale;
/** @type {number|undefined} */
MeshDepthMaterialParameters.prototype.displacementBias;
/** @type {boolean|undefined} */
MeshDepthMaterialParameters.prototype.wireframe
;/** @type {number|undefined} */
MeshDepthMaterialParameters.prototype.wireframeLinewidth;


export { MeshDepthMaterialParameters };
