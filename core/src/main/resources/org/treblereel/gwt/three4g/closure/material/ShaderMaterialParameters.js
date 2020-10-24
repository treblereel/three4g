import { MaterialParameters } from './MaterialParameters.js';

/**
 * parameters = {
 *  defines: { "label" : "value" },
 *  uniforms: { "parameter1": { value: 1.0 }, "parameter2": { value2: 2 } },
 *
 *  fragmentShader: <string>,
 *  vertexShader: <string>,
 *
 *  wireframe: <boolean>,
 *  wireframeLinewidth: <float>,
 *
 *  lights: <bool>,
 *
 *  skinning: <bool>,
 *  morphTargets: <bool>,
 *  morphNormals: <bool>
 * }
 */

/**
 * @record
 * @extends {MaterialParameters}
 */
var ShaderMaterialParameters = function() {};
/** @type {Object|undefined} */
ShaderMaterialParameters.prototype.defines;
/** @type {Object|undefined} */
ShaderMaterialParameters.prototype.uniforms;
/** @type {string|undefined} */
ShaderMaterialParameters.prototype.fragmentShader;
/** @type {string|undefined} */
ShaderMaterialParameters.prototype.vertexShader;
/** @type {boolean|undefined} */
ShaderMaterialParameters.prototype.wireframe;
/** @type {boolean|undefined} */
ShaderMaterialParameters.prototype.wireframeLinewidth;
/** @type {boolean|undefined} */
ShaderMaterialParameters.prototype.lights;
/** @type {boolean|undefined} */
ShaderMaterialParameters.prototype.skinning;
/** @type {boolean|undefined} */
ShaderMaterialParameters.prototype.morphTargets;
/** @type {boolean|undefined} */
ShaderMaterialParameters.prototype.morphNormals;
/** @type {string} */
ShaderMaterialParameters.prototype.shaderID;



export { ShaderMaterialParameters };