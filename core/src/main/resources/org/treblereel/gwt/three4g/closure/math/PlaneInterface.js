import { Vector3 } from '../../math/Vector3.js';

/**
 * @interface
 */
var PlaneInterface = function () { }
/** @type {Vector3} */
PlaneInterface.prototype.normal;
/** @type {number} */
PlaneInterface.prototype.constant;


/**
* @param {Vector3} point
* @return {number} 
*/
PlaneInterface.prototype.distanceToPoint = function (point) { };

export { PlaneInterface };