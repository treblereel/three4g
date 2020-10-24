import { Matrix4 } from '../../math/Matrix4.js';

/**
 * @interface
 */
var CameraInterface = function () { }

/**
 * @type {Matrix4} 
 */
CameraInterface.prototype.matrixWorld;

/**
 * @type {Matrix4} 
 */
CameraInterface.prototype.matrixWorldInverse;

/**
 * @type {Matrix4} 
 */
CameraInterface.prototype.projectionMatrix;

/**
 * @type {Matrix4} 
 */
CameraInterface.prototype.projectionMatrixInverse

CameraInterface.prototype.updateProjectionMatrix = function() {};

/** @type {boolean} */
CameraInterface.prototype.isCamera;
/** @type {boolean} */
CameraInterface.prototype.isOrthographicCamera;

/**
 * @type {number} 
 */
CameraInterface.prototype.near

/**
 * @type {number} 
 */
CameraInterface.prototype.far

export { CameraInterface };