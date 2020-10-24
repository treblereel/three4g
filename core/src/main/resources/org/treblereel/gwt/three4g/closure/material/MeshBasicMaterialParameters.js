import { MaterialParameters } from './MaterialParameters.js';

import { Texture } from '../../textures/Texture.js';
import { CubeTexture } from '../../textures/CubeTexture.js';


/**
 * @typedef { { map: (Texture|undefined), color : number} }
 */
var MeshBasicMaterialParameters = function() {};

/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.color;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.opacity;
/** @type {Texture|undefined} */
MeshBasicMaterialParameters.prototype.map;
/** @type {Texture|undefined} */
MeshBasicMaterialParameters.prototype.lightMap;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.lightMapIntensity;
/** @type {Texture|undefined} */
MeshBasicMaterialParameters.prototype.aoMap;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.aoMapIntensity;
/** @type {Texture|undefined} */
MeshBasicMaterialParameters.prototype.specularMap;
/** @type {Texture|undefined} */
MeshBasicMaterialParameters.prototype.alphaMap;
/** @type {CubeTexture|undefined} */
MeshBasicMaterialParameters.prototype.envMap;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.combine;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.reflectivity;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.refractionRatio;
/** @type {boolean|undefined} */
MeshBasicMaterialParameters.prototype.depthTest;
/** @type {boolean|undefined} */
MeshBasicMaterialParameters.prototype.depthWrite;
/** @type {boolean|undefined} */
MeshBasicMaterialParameters.prototype.wireframe;
/** @type {number|undefined} */
MeshBasicMaterialParameters.prototype.wireframeLinewidth;
/** @type {boolean|undefined} */
MeshBasicMaterialParameters.prototype.skinning;
/** @type {boolean|undefined} */
MeshBasicMaterialParameters.prototype.morphTargets;


export { MeshBasicMaterialParameters };
