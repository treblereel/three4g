import { Texture } from '../../textures/Texture.js';
import { MaterialInterface } from './MaterialInterface.js';

/** 
* @extends {MaterialInterface}
*/
class MeshDepthMaterialInterface { };

/** @type {number} */
MeshDepthMaterialInterface.prototype.opacity;
/** @type {Texture} */
MeshDepthMaterialInterface.prototype.map;
/** @type {Texture} */
MeshDepthMaterialInterface.prototype.alphaMap;
/** @type {Texture} */
MeshDepthMaterialInterface.prototype.displacementMap;
/** @type {number} */
MeshDepthMaterialInterface.prototype.displacementScale;
/** @type {number} */
MeshDepthMaterialInterface.prototype.displacementBias;
/** @type {boolean} */
MeshDepthMaterialInterface.prototype.wireframe;
/** @type {number} */
MeshDepthMaterialInterface.prototype.wireframeLinewidth;

export { MeshDepthMaterialInterface };