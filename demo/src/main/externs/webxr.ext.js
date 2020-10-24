/*
 * Copyright 2021 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @TODO check  XRSession.prototype.inputSources;
 */

/**
 * @fileoverview Definitions for W3C's Web XR specification.
 * @see https://developer.mozilla.org/en-US/docs/Web/API/XRSystem
 * @externs
 */

/**
 * @type {!XRSystem}
 */
Navigator.prototype.xr;

/**
 * @interface
 * @extends {EventTarget}
 */
var XRSystem = function () { };

/**
 * @param {XRSessionMode} mode
 * @return  {Promise<boolean>}
 */
XRSystem.prototype.isSessionSupported = function (mode) { };

/**
 * @param {XRSessionMode} mode
 * @return  {XRSession}
 */
XRSystem.prototype.requestSession = function (mode) { };

/**
 * @constructor
 * @extends {Event}
 */
var XRSessionEvent = function () { };

/**
 * @const
 * @type {XRSession}
 */
XRSessionEvent.prototype.session;

/**
 * @enum
 */
var XRSessionMode = {
  IMMERSIVEAR: 'immersive-ar',
  IMMERSIVEVR: 'immersive-vr',
  INLINE: 'inline'
};

/**
* @interface
* @extends {EventTarget}
*/
var XRSession = function () { };

/**
 * @const
 * @type {string} (readonly)
 */
XRSession.prototype.environmentBlendMode;

/**
 * @const
 * @type {XRInputSourceArray}
 */
XRSession.prototype.inputSources;

/**
 * @const
 * @type {XRRenderState}
 */
XRSession.prototype.renderState;

/**
 * @const
 * @type {string}
 */
XRSession.prototype.visibilityState;

/**
* @param {number} handle
*/
XRSession.prototype.cancelAnimationFrame = function (handle) { };

/**
* @return {Promise<void>}
*/
XRSession.prototype.end = function () { };

/**
 * @typedef {function(number, XRFrame): undefined}
 */
var XRFrameRequestCallback;

/**
 * @param {!XRFrameRequestCallback} callback
 * @return {number}
 */
XRSession.prototype.requestAnimationFrame = function (callback) { }

/**
 * @param {XRReferenceSpaceType} referenceSpaceType
 * @return {Promise<XRReferenceSpace|XRBoundedReferenceSpace>}
 * @throws {!NotSupportedError}
 */
XRSession.prototype.requestReferenceSpace = function (referenceSpaceType) { };

/**
 * @param {XRRenderStateInit} newState
 */
XRSession.prototype.updateRenderState = function (newState) { };

/**
 * @enum
 */
var XRReferenceSpaceType = {
  BOUNDEDFLOOR: 'bounded-floor',
  LOCAL: 'local',
  LOCALFLOOR: 'local-floor',
  UNBOUNDED: 'unbounded',
  VIEWER: 'viewer'
};

/**
* @interface
*/
var XRInputSource = function () { };

/**
 * @const
 * @type {XRSpace}
 */
XRInputSource.prototype.gripSpace;

/**
 * @const
 * @type {string}
 */
XRInputSource.prototype.handedness;

/**
 * @const
 * @type {string}
 */
XRInputSource.prototype.profiles;

/**
 * @const
 * @type {string}
 */
XRInputSource.prototype.targetRayMode;

/**
 * @const
 * @type {XRSpace}
 */
XRInputSource.prototype.targetRaySpace;

/**
* @interface
*/
var XRInputSourceArray = function () { };

/**
 * @const {number}
 */
XRInputSourceArray.prototype.length;


/**
 * @const
 * @return {!Iterator<XRInputSource>}
 */
XRInputSourceArray.prototype.values = function() {};


/**
* @interface
* @extends {EventTarget}
*/
var XRSpace = function () { };

/**
* @interface
* @extends {XRSpace}
*/
var XRReferenceSpace = function () { };

/**
 * @param {XRRigidTransform}  originOffset
 * @return {XRReferenceSpace}
 */
XRReferenceSpace.prototype.getOffsetReferenceSpace = function (originOffset) { };

/**
* @interface
* @extends {XRReferenceSpace}
*/
var XRBoundedReferenceSpace = function () { };

/**
 * @const
 * @type {DOMPointReadOnly}
 */
XRBoundedReferenceSpace.prototype.boundsGeometry;

/**
 * @record
 * @struct
*/
var XRRenderStateInit = function () { };

/**
 * @type {XRWebGLLayer}
 */
XRRenderStateInit.prototype.baseLayer;

/**
 * @type {number}
 */
XRRenderStateInit.prototype.depthFar;

/**
 * @type {number}
 */
XRRenderStateInit.prototype.depthNear;

/**
 * @type {number}
 */
XRRenderStateInit.prototype.inlineVerticalFieldOfView;

/**
 * @constructor
 * @extends {DOMError}
 */
function NotSupportedError() { }

/**
 * @interface
 */
var XRPose = function () { };

/**
 * @const
 * @type {XRRigidTransform}
 */
XRPose.prototype.transform;

/**
 * @const
 * @type {boolean}
 */
XRPose.prototype.emulatedPosition;

/**
* @interface
*/
var XRFrame = function () { };

/**
 * @const
 * @type {XRSession}
 */
XRFrame.prototype.session;

/**
 * @const
 * @param {XRSpace} space
 * @param {XRSpace} baseSpace
 * @return {XRPose}
 */
XRFrame.prototype.getPose = function (space, baseSpace) { };

/**
* @interface
*/
var XRRenderState = function () { };

/**
 * @const
 * @type {XRWebGLLayer}
 */
XRRenderState.prototype.baseLayer;

/**
 * @const
 * @type {number}
 */
XRRenderState.prototype.depthFar;

/**
 * @const
 * @type {number}
 */
XRRenderState.prototype.depthNear;

/**
 * @const
 * @type {number|null}
 */
XRRenderState.prototype.inlineVerticalFieldOfView;

/**
* @interface
*/
var XRViewport = function () { };

/**
 * @const
 * @type {number}
 */
XRViewport.prototype.height;

/**
 * @const
 * @type {number}
 */
XRViewport.prototype.width;

/**
 * @const
 * @type {number}
 */
XRViewport.prototype.x;

/**
 * @const
 * @type {number}
 */
XRViewport.prototype.y;

/**
 * @typedef {{
 *   alpha: (boolean|undefined), 
 *   antialias: (boolean|undefined), 
 *   depth: (boolean|undefined), 
 *   framebufferScaleFactor: (number|undefined), 
 *   ignoreDepthValues: (boolean|undefined), 
 *   stencil: (boolean|undefined)
 * }} 
 */
var XRWebGLLayerInit = function () { };

/**
* @constructor
* @param {XRSession} session
* @param {WebGLRenderingContext|WebGL2RenderingContext} context
* @param {XRWebGLLayerInit=} layerInit
*/
var XRWebGLLayer = function (session, context, layerInit) { };

/**
 * @const
 * @type {boolean}
 */
XRWebGLLayer.prototype.antialias;

/**
 * @const
 * @type {WebGLFramebuffer}
 */
XRWebGLLayer.prototype.framebuffer;

/**
 * @const
 * @type {number}
 */
XRWebGLLayer.prototype.framebufferWidth;

/**
 * @const
 * @type {number}
 */
XRWebGLLayer.prototype.framebufferHeight;

/**
 * @const
 * @type {boolean}
 */
XRWebGLLayer.prototype.ignoreDepthValues;

/**
 * @return {XRViewport}
 */
XRWebGLLayer.prototype.getViewport = function () { };

/**
 * @static
 * @return {number}
 */
XRWebGLLayer.prototype.getNativeFramebufferScaleFactor = function () { };

/**
 * @constructor
 */
var XRRigidTransform = function () { };

/**
 * @const
 * @type {DOMPointReadOnly}
 */
XRRigidTransform.prototype.position;

/**
 * @const
 * @type {DOMPointReadOnly}
 */
XRRigidTransform.prototype.orientation;

/**
 * @const
 * @type {Float32Array}
 */
XRRigidTransform.prototype.matrix;

/**
 * @const
 * @type {XRRigidTransform}
 */
XRRigidTransform.prototype.inverse;

/**
 * @return {Promise<void>}
 */
WebGLRenderingContext.prototype.makeXRCompatible = function () { };

/**
 * @type {boolean}
 */
WebGLContextAttributes.prototype.xrCompatible;
