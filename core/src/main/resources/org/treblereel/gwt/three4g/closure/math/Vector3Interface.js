/**
 * @interface
 */
var Vector3Interface = function () { }
/** @type {number} */
Vector3Interface.prototype.x;
/** @type {number} */
Vector3Interface.prototype.y;
/** @type {number} */
Vector3Interface.prototype.z;


/**
* @param {Vector3Interface} v
* @return {number} 
*/
Vector3Interface.prototype.dot = function (v) { };

export { Vector3Interface };