import { MaterialInterface } from '../material/MaterialInterface.js';
import { BufferGeometry } from '../../core/BufferGeometry.js';
import { BufferAttributeInterface } from './BufferAttributeInterface.js';
import { Event } from '../../core/EventDispatcher.js';
import { SkeletonInterface } from '../objects/SkeletonInterface.js';
import { Camera } from '../../cameras/Camera.js';
import { Vector3 } from '../../math/Vector3.js';
import { Object3D } from '../../core/Object3D.js';

/** 
 * @extends {Object3D}
 */
class Object3DInterface {}

/**
 * @type {BufferGeometry}
 */
Object3DInterface.prototype.geometry;

/** @type {boolean} */
Object3DInterface.prototype.autoUpdate;

/** @type {boolean} */
Object3DInterface.prototype.isObject3D;
/** @type {boolean} */
Object3DInterface.prototype.isInstancedMesh;
/** @type {boolean} */
Object3DInterface.prototype.isMesh;
/** @type {boolean} */
Object3DInterface.prototype.isLine;
/** @type {boolean} */
Object3DInterface.prototype.isPoints;
/** @type {boolean} */
Object3DInterface.prototype.isSkinnedMesh;
/** @type {boolean} */
Object3DInterface.prototype.isScene;
/** @type {boolean} */
Object3DInterface.prototype.isLineSegments;
/** @type {boolean} */
Object3DInterface.prototype.isLineSegments;
/** @type {boolean} */
Object3DInterface.prototype.isSprite;
/** @type {boolean} */
Object3DInterface.prototype.isLOD;
/** @type {boolean} */
Object3DInterface.prototype.isGroup;
/** @type {boolean} */
Object3DInterface.prototype.isLight;
/** @type {boolean} */
Object3DInterface.prototype.isImmediateRenderObject;
/** @type {boolean} */
Object3DInterface.prototype.isLineLoop;

/** @type {boolean} */
Object3DInterface.prototype.matrixWorldNeedsUpdate;
/** @type {boolean} */
Object3DInterface.prototype.visible;
/** @type {boolean} */
Object3DInterface.prototype.castShadow;
/** @type {boolean} */
Object3DInterface.prototype.receiveShadow;
/** @type {boolean} */
Object3DInterface.prototype.frustumCulled;
/** @type {number} */
Object3DInterface.prototype.renderOrder;
/** @type {number} */
Object3DInterface.prototype.count;
/** @type {Object} */
Object3DInterface.prototype.userData;
/** @type {Object} */
Object3DInterface.prototype.overrideMaterial;


/** @type {Vector3} */
Object3DInterface.prototype.center;
/** @type {SkeletonInterface} */
Object3DInterface.prototype.skeleton;

/** @type {MaterialInterface} */
Object3DInterface.prototype.material;

/** @type {MaterialInterface} */
Object3DInterface.prototype.customDepthMaterial;
/** @type {MaterialInterface} */
Object3DInterface.prototype.customDistanceMaterial;
/** @type {BufferAttributeInterface} */
Object3DInterface.prototype.instanceColor;
/** @type {BufferAttributeInterface} */
Object3DInterface.prototype.instanceMatrix;

/** @type {Array<number>} */
Object3DInterface.prototype.morphTargetInfluences;

/**
 * @param {number} index
 * @param {Vector3} target
 * @return {Vector3}
 */
Object3DInterface.prototype.boneTransform = function( index, target) {};


/** 
 * @param {Camera} camera
 */
Object3DInterface.prototype.update = function (camera) { };

/** 
 * @param {boolean=} force
 */
Object3DInterface.prototype.updateMatrixWorld = function (force) { };


export { Object3DInterface };