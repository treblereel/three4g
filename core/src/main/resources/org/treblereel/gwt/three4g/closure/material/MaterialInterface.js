import { Texture } from '../../textures/Texture.js';
import { Vector2 } from '../../math/Vector2.js';
import { Vector3 } from '../../math/Vector3.js';
import { Color } from '../../math/Color.js';
import { Material } from '../../materials/Material.js';


/** 
 * @extends {Material}
*/
class MaterialInterface { };

/** @type {number} */
MaterialInterface.prototype.id;
/** @type {string} */
MaterialInterface.prototype.uuid;
/** @type {number} */
MaterialInterface.prototype.version;
/** @type {string} */
MaterialInterface.prototype.precision;
/** @type {number} */
MaterialInterface.prototype.size;
/** @type {number} */
MaterialInterface.prototype.side;
/** @type {string} */
MaterialInterface.prototype.type;
/** @type {number} */
MaterialInterface.prototype.displacementBias;
/** @type {number} */
MaterialInterface.prototype.displacementScale;
/** @type {number} */
MaterialInterface.prototype.bumpScale;
/** @type {number} */
MaterialInterface.prototype.farDistance;
/** @type {number} */
MaterialInterface.prototype.nearDistance;
/** @type {number} */
MaterialInterface.prototype.nearDistance;
/** @type {Vector3} */
MaterialInterface.prototype.referencePosition;
/** @type {number} */
MaterialInterface.prototype.clearcoatRoughness;
/** @type {number} */
MaterialInterface.prototype.clearcoat;
/** @type {number} */
MaterialInterface.prototype.envMapIntensity;
/** @type {number} */
MaterialInterface.prototype.metalness;
/** @type {number} */
MaterialInterface.prototype.roughness;
/** @type {Color} */
MaterialInterface.prototype.specular;
/** @type {Color} */
MaterialInterface.prototype.color;
/** @type {number} */
MaterialInterface.prototype.dashSize;
/** @type {number} */
MaterialInterface.prototype.scale;
/** @type {number} */
MaterialInterface.prototype.aoMapIntensity;
/** @type {number} */
MaterialInterface.prototype.lightMapIntensity;

/** @type {boolean} */
MaterialInterface.prototype.isMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isShaderMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isShadowMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshStandardMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshPhongMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshToonMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshStandardMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshLambertMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshBasicMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isSpriteMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isRawShaderMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshPhysicalMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshMatcapMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshDepthMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshDistanceMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isMeshNormalMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isLineDashedMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isPointsMaterial;
/** @type {boolean} */
MaterialInterface.prototype.isLineBasicMaterial;

/** @type {boolean} */
MaterialInterface.prototype.uniformsNeedUpdate;
/** @type {boolean} */
MaterialInterface.prototype.lights;
/** @type {boolean} */
MaterialInterface.prototype.clipping;
/** @type {boolean} */
MaterialInterface.prototype.depthPacking;
/** @type {boolean} */
MaterialInterface.prototype.premultipliedAlpha;
/** @type {boolean} */
MaterialInterface.prototype.toneMapped;
/** @type {boolean} */
MaterialInterface.prototype.dithering;
/** @type {boolean} */
MaterialInterface.prototype.vertexTangents;
/** @type {Object} */
MaterialInterface.prototype.uniforms;


/** @type {boolean} */
MaterialInterface.prototype.flatShading;
/** @type {Color} */
MaterialInterface.prototype.sheen;
/** @type {Color} */
MaterialInterface.prototype.emissive;
/** @type {number} */
MaterialInterface.prototype.emissiveIntensity;
/** @type {Color} */
MaterialInterface.prototype.specular;
/** @type {number} */
MaterialInterface.prototype.shininess;
/** @type {number} */
MaterialInterface.prototype.clearcoat;
/** @type {number} */
MaterialInterface.prototype.clearcoatRoughness;
/** @type {Object} */
MaterialInterface.prototype.clearcoatMap;
/** @type {Object} */
MaterialInterface.prototype.clearcoatRoughnessMap;
/** @type {Object} */
MaterialInterface.prototype.clearcoatNormalMap;
/** @type {Object} */
MaterialInterface.prototype.clearcoatNormalMap;
/** @type {Vector2} */
MaterialInterface.prototype.clearcoatNormalScale;
/** @type {Object} */
MaterialInterface.prototype.map;
/** @type {Object} */
MaterialInterface.prototype.matcap;
/** @type {Object} */
MaterialInterface.prototype.alphaMap;
/** @type {Object} */
MaterialInterface.prototype.lightMap;
/** @type {number} */
MaterialInterface.prototype.lightMapIntensity;
/** @type {Object} */
MaterialInterface.prototype.aoMap;
/** @type {Object} */
MaterialInterface.prototype.bumpMap;
/** @type {Object} */
MaterialInterface.prototype.normalMap;
/** @type {number} */
MaterialInterface.prototype.normalMapType;
/** @type {Texture} */
MaterialInterface.prototype.displacementMap;
/** @type {Object} */
MaterialInterface.prototype.roughnessMap;
/** @type {Object} */
MaterialInterface.prototype.metalnessMap;
/** @type {Object} */
MaterialInterface.prototype.emissiveMap;
/** @type {Object} */
MaterialInterface.prototype.envMap;
/** @type {number} */
MaterialInterface.prototype.refractionRatio;
/** @type {number} */
MaterialInterface.prototype.combine;
/** @type {number} */
MaterialInterface.prototype.envMapIntensity;
/** @type {Object} */
MaterialInterface.prototype.gradientMap;
/** @type {number} */
MaterialInterface.prototype.size;
/** @type {number} */
MaterialInterface.prototype.sizeAttenuation;
/** @type {number} */
MaterialInterface.prototype.rotation;
/** @type {number} */
MaterialInterface.prototype.polygonOffsetFactor;
/** @type {number} */
MaterialInterface.prototype.polygonOffsetUnits;
/** @type {number} */
MaterialInterface.prototype.linewidth;
/** @type {number} */
MaterialInterface.prototype.gapSize;
/** @type {boolean} */
MaterialInterface.prototype.wireframe;
/** @type {number} */
MaterialInterface.prototype.wireframeLinewidth;
/** @type {string} */
MaterialInterface.prototype.wireframeLinecap;
/** @type {string} */
MaterialInterface.prototype.wireframeLinejoin;
/** @type {string} */
MaterialInterface.prototype.index0AttributeName;
/** @type {boolean} */
MaterialInterface.prototype.morphTargets;
/** @type {boolean} */
MaterialInterface.prototype.morphNormals;
/** @type {boolean} */
MaterialInterface.prototype.skinning;
/** @type {Object} */
MaterialInterface.prototype.specularMap;

/** @type {number} */
MaterialInterface.prototype.shadowSide;
/** @type {boolean} */
MaterialInterface.prototype.colorWrite;
/** @type {boolean} */
MaterialInterface.prototype.polygonOffset;
/** @type {number} */
MaterialInterface.prototype.alphaTest;
/** @type {boolean} */
MaterialInterface.prototype.visible;
/** @type {Object} */
MaterialInterface.prototype.userData;
/** @type {boolean} */
MaterialInterface.prototype.fog;
/** @type {number} */
MaterialInterface.prototype.blending;

/** @type {boolean} */
MaterialInterface.prototype.vertexColors;
/** @type {number} */
MaterialInterface.prototype.opacity;
/** @type {boolean} */
MaterialInterface.prototype.transparent;
/** @type {number} */
MaterialInterface.prototype.blendSrc;
/** @type {number} */
MaterialInterface.prototype.blendDst;
/** @type {number} */
MaterialInterface.prototype.blendEquation;
/** @type {number} */
MaterialInterface.prototype.blendSrcAlpha;
/** @type {number} */
MaterialInterface.prototype.blendDstAlpha;
/** @type {number} */
MaterialInterface.prototype.blendEquationAlpha;
/** @type {number} */
MaterialInterface.prototype.depthFunc;
/** @type {boolean} */
MaterialInterface.prototype.depthTest;
/** @type {boolean} */
MaterialInterface.prototype.depthWrite;
/** @type {number} */
MaterialInterface.prototype.stencilWriteMask;
/** @type {number} */
MaterialInterface.prototype.stencilFunc;
/** @type {number} */
MaterialInterface.prototype.stencilRef;
/** @type {number} */
MaterialInterface.prototype.stencilFuncMask;
/** @type {number} */
MaterialInterface.prototype.stencilFail;
/** @type {number} */
MaterialInterface.prototype.stencilZFail;
/** @type {number} */
MaterialInterface.prototype.stencilZPass;
/** @type {boolean} */
MaterialInterface.prototype.stencilWrite;
/** @type {Array} */
MaterialInterface.prototype.clippingPlanes;
/** @type {boolean} */
MaterialInterface.prototype.clipIntersection;
/** @type {boolean} */
MaterialInterface.prototype.clipShadows;
/** @type {Vector2} */
MaterialInterface.prototype.normalScale;

/** @type {number} */
MaterialInterface.prototype.decay;

/** @return {MaterialInterface} */
MaterialInterface.prototype.clone = function() {};

/** @type {number} */
MaterialInterface.prototype.nearDistance;
/** @type {number} */
MaterialInterface.prototype.far;
/** @type {number} */
MaterialInterface.prototype.ior;
/** @type {number} */
MaterialInterface.prototype.reflectivity;
/** @type {number} */
MaterialInterface.prototype.transmission;
/** @type {Texture} */
MaterialInterface.prototype.transmissionMap;

/** @return {string} */
MaterialInterface.prototype.customProgramCacheKey = function () { };

MaterialInterface.prototype.extensions = function () { };

/** @type {boolean} */
MaterialInterface.prototype.extensions.prototype.derivatives;
/** @type {boolean} */
MaterialInterface.prototype.extensions.prototype.fragDepth;
/** @type {boolean} */
MaterialInterface.prototype.extensions.prototype.drawBuffers;
/** @type {boolean} */
MaterialInterface.prototype.extensions.prototype.shaderTextureLOD;


/** @type {string} */
MaterialInterface.prototype.fragmentShader;
/** @type {string} */
MaterialInterface.prototype.vertexShader;
/** @type {string} */
MaterialInterface.prototype.glslVersion;

export { MaterialInterface };