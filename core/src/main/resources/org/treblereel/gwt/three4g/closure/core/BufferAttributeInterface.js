/** 
* @interface
*/
var BufferAttributeInterface = function () { };

/** @type {number} */
BufferAttributeInterface.prototype.count;

/**
 * @param {number} index
 *  @return {number}
 */
BufferAttributeInterface.prototype.getX = function(index) {};

/**
 * @param {number} index
 *  @return {number}
 */
BufferAttributeInterface.prototype.getY = function(index) {};

/**
 * @param {number} index
 *  @return {number}
 */
BufferAttributeInterface.prototype.getZ = function(index) {};

export { BufferAttributeInterface };