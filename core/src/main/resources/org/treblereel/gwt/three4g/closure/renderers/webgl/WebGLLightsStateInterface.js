import {Vector3} from '../../../math/Vector3.js'
/** 
 * 
 * @record
 */
var Hash = function() {};

/** @type {number} */
Hash.prototype.directionalLength;

/** @type {number} */
Hash.prototype.pointLength;

/** @type {number} */
Hash.prototype.spotLength;

/** @type {number} */
Hash.prototype.rectAreaLength;

/** @type {number} */
Hash.prototype.hemiLength;

/** @type {number} */
Hash.prototype.numDirectionalShadows;

/** @type {number} */
Hash.prototype.numPointShadows;

/** @type {number} */
Hash.prototype.numSpotShadows;

/** @type {number} */
Hash.prototype.numSpotShadows;

/** 
 * 
 * @record
 */

var WebGLLightsStateInterface = function() {};

/** @type {number} */
WebGLLightsStateInterface.prototype.version;

/** @type {Hash} */
WebGLLightsStateInterface.prototype.hash;

/** @type {Array<number>} */
WebGLLightsStateInterface.prototype.ambient;

/** @type {Array<Vector3>} */
WebGLLightsStateInterface.prototype.probe;

/** @type {Array} */
WebGLLightsStateInterface.prototype.directional;

/** @type {Array} */
WebGLLightsStateInterface.prototype.directionalShadow;

/** @type {Array} */
WebGLLightsStateInterface.prototype.directionalShadowMap;

/** @type {Array} */
WebGLLightsStateInterface.prototype.directionalShadowMatrix;

/** @type {Array} */
WebGLLightsStateInterface.prototype.spot;

/** @type {Array} */
WebGLLightsStateInterface.prototype.spotShadow;

/** @type {Array} */
WebGLLightsStateInterface.prototype.spotShadowMap;

/** @type {Array} */
WebGLLightsStateInterface.prototype.spotShadowMatrix;

/** @type {Array} */
WebGLLightsStateInterface.prototype.rectArea;

/** @type {Object} */
WebGLLightsStateInterface.prototype.rectAreaLTC1;

/** @type {Object} */
WebGLLightsStateInterface.prototype.rectAreaLTC2;

/** @type {Array} */
WebGLLightsStateInterface.prototype.point;

/** @type {Array} */
WebGLLightsStateInterface.prototype.pointShadow;

/** @type {Array} */
WebGLLightsStateInterface.prototype.pointShadowMap;

/** @type {Array} */
WebGLLightsStateInterface.prototype.pointShadowMatrix;

/** @type {Array} */
WebGLLightsStateInterface.prototype.hemi;

export { WebGLLightsStateInterface };