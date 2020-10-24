import { Matrix4 } from '../../math/Matrix4.js';
import { Vector2 } from '../../math/Vector2.js';
import { Vector3 } from '../../math/Vector3.js';
import { Vector4 } from '../../math/Vector4.js';
import { Frustum } from '../../math/Frustum.js';

import { CameraInterface } from '../cameras/CameraInterface.js';
import { LightInterface } from '../lights/LightInterface.js';

/**
* @interface
*/
var LightShadowInterface = function () { };

/** @type {boolean} */
LightShadowInterface.prototype.autoUpdate;

/** @type {boolean} */
LightShadowInterface.prototype.needsUpdate;

/** @type {CameraInterface} */
LightShadowInterface.prototype.camera;
/** @type {number} */
LightShadowInterface.prototype.bias;
/** @type {number} */
LightShadowInterface.prototype.normalBias;
/** @type {number} */
LightShadowInterface.prototype.radius;
/** @type {Vector2} */
LightShadowInterface.prototype.mapSize;
/** @type { { texture: * } } */
LightShadowInterface.prototype.map;
/** @type {*} */
LightShadowInterface.prototype.mapPass;
/** @type {Matrix4} */
LightShadowInterface.prototype.matrix;

/** @type {boolean} */
LightShadowInterface.prototype.autoUpdate;
/** @type {boolean} */
LightShadowInterface.prototype.needsUpdate;

/** @type {boolean} */
LightShadowInterface.prototype.isPointLightShadow;

/** @return {Vector2} */
LightShadowInterface.prototype.getFrameExtents = function () { }

/** @return {Frustum} */
LightShadowInterface.prototype.getFrustum = function () { }

/** @return {number} */
LightShadowInterface.prototype.getViewportCount = function () { }

/** 
 * @param {number} viewportIndex
 * @return {Vector4}
 *  */
LightShadowInterface.prototype.getViewport = function (viewportIndex) { }

/** 
 * @param {LightInterface} light
 * @param {number=} viewportIndex
 *  */
LightShadowInterface.prototype.updateMatrices = function (light, viewportIndex) { }

/**
 * @param {LightShadowInterface} source
 * @return {LightShadowInterface}
 *  */
LightShadowInterface.prototype.copy = function (source) { }

/**
 * @return {LightShadowInterface}
 *  */
LightShadowInterface.prototype.clone = function () { }

export { LightShadowInterface };