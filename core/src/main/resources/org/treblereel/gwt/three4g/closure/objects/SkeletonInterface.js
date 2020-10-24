import { TextureInterface } from '../textures/TextureInterface.js';
import { Matrix4 } from '../../math/Matrix4.js';


/**
* @interface
*/
var SkeletonInterface = function () { };

/** @type {string} */
SkeletonInterface.prototype.uuid;
/** @type {Array} */
SkeletonInterface.prototype.bones;
/** @type {Array<number>|Float32Array|ArrayBufferView|null} */
SkeletonInterface.prototype.boneMatrices;
/** @type {Matrix4} */
SkeletonInterface.prototype.boneInverses;
/** @type {TextureInterface} */
SkeletonInterface.prototype.boneTexture;
/** @type {number} */
SkeletonInterface.prototype.boneTextureSize;
/** @type {number} */
SkeletonInterface.prototype.frame;

SkeletonInterface.prototype.init = function () { };
SkeletonInterface.prototype.calculateInverses = function () { };
SkeletonInterface.prototype.pose = function () { };
SkeletonInterface.prototype.update = function () { };
SkeletonInterface.prototype.dispose = function () { };
/** @return {SkeletonInterface} */
SkeletonInterface.prototype.clone = function () { };

/**
 * @param {string} name
 * @return {Object|undefined}
 */
SkeletonInterface.prototype.getBoneByName = function (name) { };


export { SkeletonInterface };