/**
 * @record
 */
var WebGLRendererParameters  = function() {};
/** @type {HTMLCanvasElement|OffscreenCanvas|undefined} */
WebGLRendererParameters.prototype.canvas;
/** @type {WebGLRenderingContext|undefined} */
WebGLRendererParameters.prototype.context;
/** @type {string|undefined} */
WebGLRendererParameters.prototype.precision;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.alpha;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.premultipliedAlpha;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.antialias;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.stencil;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.preserveDrawingBuffer;
/** @type {string|undefined} */
WebGLRendererParameters.prototype.powerPreference;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.depth;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.logarithmicDepthBuffer;
/** @type {boolean|undefined} */
WebGLRendererParameters.prototype.failIfMajorPerformanceCaveat;

export { WebGLRendererParameters };
