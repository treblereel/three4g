/**
* @interface
*/
var EventDispatcher = function () { };

/**
 * @param {string} type 
 * @param {function(Event)} listener 
 */
EventDispatcher.prototype.addEventListener = function (type, listener) { };

/**
 * @param {string} type 
 * @param {function(Event)} listener 
 * @return {boolean}
 */
EventDispatcher.prototype.hasEventListener = function (type, listener) { };

/**
 * @param {string} type 
 * @param {function(Event)} listener 
 */
EventDispatcher.prototype.removeEventListener = function (type, listener) { }

/**
 * 
 * @param {Event} event 
 */
EventDispatcher.prototype.dispatchEvent = function (event) { }

export { EventDispatcher };