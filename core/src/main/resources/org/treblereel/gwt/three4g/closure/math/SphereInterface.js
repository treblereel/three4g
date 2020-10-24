import { Vector3 } from '../../math/Vector3.js';
import { PlaneInterface } from './PlaneInterface.js';

/**
 * @interface
 */
var SphereInterface = function () { }
/** @type {Vector3} */
SphereInterface.prototype.center;
/** @type {number} */
SphereInterface.prototype.radius;

/**
 * 
 * @param { PlaneInterface } plane 
 * @return {boolean}
 */
SphereInterface.prototype.intersectsPlane = function (plane) { };

/**
* @param {Vector3} point
* @return {number} 
*/
SphereInterface.prototype.distanceToPoint = function (point) { };

export { SphereInterface };