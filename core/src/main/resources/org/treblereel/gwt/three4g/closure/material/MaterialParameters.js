import { Plane } from '../../math/Plane.js';

/**
 * @record
 */
function MaterialParameters() {};

/** @type {number|undefined} */
MaterialParameters.prototype.alphaTest;
/** @type {number|undefined} */
MaterialParameters.prototype.blendDst;
/** @type {number|undefined} */
MaterialParameters.prototype.blendDstAlpha;
/** @type {number|undefined} */
MaterialParameters.prototype.blendEquation;
/** @type {number|undefined} */
MaterialParameters.prototype.blendEquationAlpha;
/** @type {number|undefined} */
MaterialParameters.prototype.blendSrcAlpha;
/** @type {boolean|undefined} */
MaterialParameters.prototype.clipIntersection;
/** @type {Array<Plane>|undefined} */
MaterialParameters.prototype.clippingPlanes;
/** @type {Object|undefined} */
MaterialParameters.prototype.clipShadows;
/** @type {Object|undefined} */
MaterialParameters.prototype.defines;
/** @type {boolean|undefined} */
MaterialParameters.prototype.depthTest;
/** @type {boolean|undefined} */
MaterialParameters.prototype.depthWrite;
/** @type {boolean|undefined} */
MaterialParameters.prototype.fog;
/** @type {string|undefined} */
MaterialParameters.prototype.name;
/** @type {number|undefined} */
MaterialParameters.prototype.opacity;
/** @type {boolean|undefined} */
MaterialParameters.prototype.polygonOffset;
/** @type {number|undefined} */
MaterialParameters.prototype.polygonOffsetFactor;
/** @type {number|undefined} */
MaterialParameters.prototype.polygonOffsetUnits;
/** @type {boolean|undefined} */
MaterialParameters.prototype.premultipliedAlpha;
/** @type {boolean|undefined} */
MaterialParameters.prototype.dithering;
/** @type {boolean|undefined} */
MaterialParameters.prototype.flatShading;
/** @type {number|undefined} */
MaterialParameters.prototype.side;
/** @type {number|undefined} */
MaterialParameters.prototype.shadowSide;
/** @type {boolean|undefined} */
MaterialParameters.prototype.toneMapped;
/** @type {boolean|undefined} */
MaterialParameters.prototype.transparent;
/** @type {boolean|undefined} */
MaterialParameters.prototype.vertexColors;
/** @type {boolean|undefined} */
MaterialParameters.prototype.visible;
/** @type {boolean|undefined} */
MaterialParameters.prototype.stencilWrite;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilFunc;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilRef;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilWriteMask;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilFuncMask;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilFail;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilZFail;
/** @type {number|undefined} */
MaterialParameters.prototype.stencilZPass;
/** @type {Object|undefined} */
MaterialParameters.prototype.userData;
/** @type {string} */
MaterialParameters.prototype.type;

/** @type {number} */
MaterialParameters.prototype.precision;

/** @type {boolean} */
MaterialParameters.prototype.isRawShaderMaterial;

export { MaterialParameters };
