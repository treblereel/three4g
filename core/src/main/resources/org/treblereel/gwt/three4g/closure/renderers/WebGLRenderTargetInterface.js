import { EventDispatcher } from '../core/EventDispatcher.js';
import { TextureInterface } from '../textures/TextureInterface.js';
import { Vector4 } from '../../math/Vector4.js';


/** 
 * @extends {EventDispatcher}
 * @interface
 */
var WebGLRenderTargetInterface = function () { };

/** @type {string} */
WebGLRenderTargetInterface.prototype.uuid;
/** @type {number} */
WebGLRenderTargetInterface.prototype.width;
/** @type {number} */
WebGLRenderTargetInterface.prototype.height;
/** @type {Vector4} */
WebGLRenderTargetInterface.prototype.scissor;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.scissorTest;
/** @type {Vector4} */
WebGLRenderTargetInterface.prototype.viewport;
/** @type {TextureInterface} */
WebGLRenderTargetInterface.prototype.texture;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.depthBuffer;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.stencilBuffer;
/** @type {TextureInterface} */
WebGLRenderTargetInterface.prototype.depthTexture;


/** @type {number} */
WebGLRenderTargetInterface.prototype.samples;
/** @type {number} */
WebGLRenderTargetInterface.prototype.generateMipmaps;
/** @type {number} */
WebGLRenderTargetInterface.prototype.minFilter;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.depthBuffer;



/** @type {boolean} */
WebGLRenderTargetInterface.prototype.isWebGLRenderTarget;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.isWebGLMultisampleRenderTarget;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.isWebGLCubeRenderTarget;
/** @type {boolean} */
WebGLRenderTargetInterface.prototype.stencilBuffer;

/**
 * 
 * @param {number} width 
 * @param {number} height 
 */
WebGLRenderTargetInterface.prototype.setSize = function (width, height) { };
/**
 * @return {WebGLRenderTargetInterface}
 */
WebGLRenderTargetInterface.prototype.clone = function () { };
/**
 * 
 * @param {WebGLRenderTargetInterface} source 
 * @return {WebGLRenderTargetInterface}
 */
WebGLRenderTargetInterface.prototype.copy = function (source) { };

WebGLRenderTargetInterface.prototype.dispose = function () { };

export { WebGLRenderTargetInterface };