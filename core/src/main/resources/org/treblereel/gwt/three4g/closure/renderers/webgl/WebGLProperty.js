/** 
 * @constructor
 */
var WebGLProperty = function() {};

/** @type {WebGLFramebuffer|Array<WebGLFramebuffer>} */
WebGLProperty.prototype.__webglFramebuffer;

/** @type {WebGLTexture} */
WebGLProperty.prototype.__webglTexture;

/** @type {number} */
WebGLProperty.prototype.__currentAnisotropy;
/** @type {number} */
WebGLProperty.prototype.__version;
/** @type {boolean} */
WebGLProperty.prototype.__webglInit;
/** @type {Object} */
WebGLProperty.prototype.envMap;

export { WebGLProperty };