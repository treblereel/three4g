import { Vector3 } from '../../math/Vector3.js';

/**
 * @interface
 */
var TriangleInterface = function () {}
/** @type {Vector3} */
TriangleInterface.prototype.a;
/** @type {Vector3} */
TriangleInterface.prototype.b;
/** @type {Vector3} */
TriangleInterface.prototype.c;

export {TriangleInterface};