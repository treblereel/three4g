import { Color } from '../../math/Color.js';
import { Vector3 } from '../../math/Vector3.js';
import { LightShadowInterface } from './LightShadowInterface.js'
import { Object3D } from '../../core/Object3D.js'


/**
* @extends {Object3D}
*/
class LightInterface {};

/** @type {number} */
LightInterface.prototype.id;
/** @type {string} */
LightInterface.prototype.name;
/** @type {string} */
LightInterface.prototype.type;
/** @type {number} */
LightInterface.prototype.intensity;
/** @type {Color} */
LightInterface.prototype.color ;
/** @type {Color} */
LightInterface.prototype.color1 ;
/** @type {Color} */
LightInterface.prototype.color2 ;
/** @type {Color} */
LightInterface.prototype.sky ;
/** @type {Color} */
LightInterface.prototype.ground ;
/** @type {Color} */
LightInterface.prototype.groundColor ;
/** @type {Object3D} */
LightInterface.prototype.target ;

/** @type {number} */
LightInterface.prototype.bias;
/** @type {number} */
LightInterface.prototype.normalBias;
/** @type {number} */
LightInterface.prototype.radius;
/** @type {number} */
LightInterface.prototype.width;
/** @type {number} */
LightInterface.prototype.height;
/** @type {number} */
LightInterface.prototype.penumbraCos;
/** @type {number} */
LightInterface.prototype.penumbra;
/** @type {number} */
LightInterface.prototype.decay;
/** @type {number} */
LightInterface.prototype.coneCos;

/** @type {LightShadowInterface} */
LightInterface.prototype.shadow;

/** @type {boolean} */
LightInterface.prototype.isPointLight;
/** @type {boolean} */
LightInterface.prototype.isDirectionalLight;
/** @type {boolean} */
LightInterface.prototype.isHemisphereLightProbe;
/** @type {boolean} */
LightInterface.prototype.isAmbientLight;
/** @type {boolean} */
LightInterface.prototype.isAmbientLightProbe;
/** @type {boolean} */
LightInterface.prototype.isDirectionalLightShadow;
/** @type {boolean} */
LightInterface.prototype.isHemisphereLight;
/** @type {boolean} */
LightInterface.prototype.isLightProbe;
/** @type {boolean} */
LightInterface.prototype.isRectAreaLight;
/** @type {boolean} */
LightInterface.prototype.isSpotLight;

LightInterface.prototype.sh = function(){}
/** @type {Array<Vector3>} */
LightInterface.prototype.sh.coefficients;


/** @type {number} */
LightInterface.prototype.distance;
/** @type {number} */
LightInterface.prototype.angle;

export {LightInterface};