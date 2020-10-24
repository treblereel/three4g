import { Vector3 } from '../../math/Vector3.js';
import { TriangleInterface } from './TriangleInterface.js';

/**
 * @interface
 */
var Box3Interface = function () { }
/** @type {Vector3} */
Box3Interface.prototype.min;
/** @type {Vector3} */
Box3Interface.prototype.max;

/**
 * @param {TriangleInterface} triangle 
 * @return {boolean}
 */
Box3Interface.prototype.intersectsTriangle = function (triangle) { };

/**
 * 
 * @param { {normal : Vector3, constant: number}} plane 
 * @return {boolean}
 */
Box3Interface.prototype.intersectsPlane = function (plane) { };

export { Box3Interface };