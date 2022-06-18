/**
 * @externs
 */


/** @const */
var THREE = {};

/** @type {string} */
THREE.REVISION;

/** @enum {number} */
THREE.MOUSE = {
  LEFT: 1,
  MIDDLE: 1,
  RIGHT: 1,
  ROTATE: 1,
  DOLLY: 1,
  PAN: 1,
};

/** @enum {number} */
THREE.TOUCH = {
  ROTATE: 1,
  PAN: 1,
  DOLLY_PAN: 1,
  DOLLY_ROTATE: 1,
};

/**
 * @type {number}
 */
THREE.CullFaceNone;

/** @type {number} */
THREE.CullFaceBack;
/** @type {number} */
THREE.CullFaceFront;
/** @type {number} */
THREE.CullFaceFrontBack;

/** @type {number} */
THREE.BasicShadowMap;
/** @type {number} */
THREE.PCFShadowMap;
/** @type {number} */
THREE.PCFSoftShadowMap;
/** @type {number} */
THREE.VSMShadowMap;

/** @type {number} */
THREE.FrontSide;
/** @type {number} */
THREE.BackSide;
/** @type {number} */
THREE.DoubleSide;

/** @type {number} */
THREE.FlatShading;
/** @type {number} */
THREE.SmoothShading;

/** @type {number} */
THREE.NoBlending;
/** @type {number} */
THREE.NormalBlending;
/** @type {number} */
THREE.AdditiveBlending;
/** @type {number} */
THREE.SubtractiveBlending;
/** @type {number} */
THREE.MultiplyBlending;
/** @type {number} */
THREE.CustomBlending;

/** @type {number} */
THREE.AddEquation;
/** @type {number} */
THREE.SubtractEquation;
/** @type {number} */
THREE.ReverseSubtractEquation;
/** @type {number} */
THREE.MinEquation;
/** @type {number} */
THREE.MaxEquation;

/** @type {number} */
THREE.ZeroFactor;
/** @type {number} */
THREE.OneFactor;
/** @type {number} */
THREE.SrcColorFactor;
/** @type {number} */
THREE.OneMinusSrcColorFactor;
/** @type {number} */
THREE.SrcAlphaFactor;
/** @type {number} */
THREE.OneMinusSrcAlphaFactor;
/** @type {number} */
THREE.DstAlphaFactor;
/** @type {number} */
THREE.OneMinusDstAlphaFactor;
/** @type {number} */
THREE.DstColorFactor;
/** @type {number} */
THREE.OneMinusDstColorFactor;

/** @type {number} */
THREE.SrcAlphaSaturateFactor;

/** @type {number} */
THREE.NeverDepth;
/** @type {number} */
THREE.AlwaysDepth;
/** @type {number} */
THREE.LessDepth;
/** @type {number} */
THREE.LessEqualDepth;
/** @type {number} */
THREE.EqualDepth;
/** @type {number} */
THREE.GreaterEqualDepth;
/** @type {number} */
THREE.GreaterDepth;
/** @type {number} */
THREE.NotEqualDepth;

/** @type {number} */
THREE.MultiplyOperation;
/** @type {number} */
THREE.MixOperation;
/** @type {number} */
THREE.AddOperation;

/** @type {number} */
THREE.NoToneMapping;
/** @type {number} */
THREE.LinearToneMapping;
/** @type {number} */
THREE.ReinhardToneMapping;
/** @type {number} */
THREE.CineonToneMapping;
/** @type {number} */
THREE.ACESFilmicToneMapping;

/** @type {number} */
THREE.UVMapping;
/** @type {number} */
THREE.CubeReflectionMapping;
/** @type {number} */
THREE.CubeRefractionMapping;
/** @type {number} */
THREE.EquirectangularReflectionMapping;
/** @type {number} */
THREE.EquirectangularRefractionMapping;
/** @type {number} */
THREE.CubeUVReflectionMapping;
/** @type {number} */
THREE.CubeUVRefractionMapping;

/** @type {number} */
THREE.RepeatWrapping;
/** @type {number} */
THREE.ClampToEdgeWrapping;
/** @type {number} */
THREE.MirroredRepeatWrapping;

/** @type {number} */
THREE.NearestFilter;
/** @type {number} */
THREE.NearestMipmapNearestFilter;
/** @type {number} */
THREE.NearestMipMapNearestFilter;
/** @type {number} */
THREE.NearestMipmapLinearFilter;
/** @type {number} */
THREE.NearestMipMapLinearFilter;
/** @type {number} */
THREE.LinearFilter;
/** @type {number} */
THREE.LinearMipmapNearestFilter;
/** @type {number} */
THREE.LinearMipMapNearestFilter;
/** @type {number} */
THREE.LinearMipmapLinearFilter;
/** @type {number} */
THREE.LinearMipMapLinearFilter;

/** @type {number} */
THREE.UnsignedByteType;
/** @type {number} */
THREE.ByteType;
/** @type {number} */
THREE.ShortType;
/** @type {number} */
THREE.UnsignedShortType;
/** @type {number} */
THREE.IntType;
/** @type {number} */
THREE.UnsignedIntType;
/** @type {number} */
THREE.FloatType;
/** @type {number} */
THREE.HalfFloatType;
/** @type {number} */
THREE.UnsignedShort4444Type;
/** @type {number} */
THREE.UnsignedShort5551Type;
/** @type {number} */
THREE.UnsignedShort565Type;
/** @type {number} */
THREE.UnsignedInt248Type;

/** @type {number} */
THREE.AlphaFormat;
/** @type {number} */
THREE.RGBFormat;
/** @type {number} */
THREE.RGBAFormat;
/** @type {number} */
THREE.LuminanceFormat;
/** @type {number} */
THREE.LuminanceAlphaFormat;
/** @type {number} */
THREE.RGBEFormat;
/** @type {number} */
THREE.DepthFormat;
/** @type {number} */
THREE.DepthStencilFormat;
/** @type {number} */
THREE.RedFormat;
/** @type {number} */
THREE.RedIntegerFormat;
/** @type {number} */
THREE.RGFormat;
/** @type {number} */
THREE.RGIntegerFormat;
/** @type {number} */
THREE.RGBIntegerFormat;
/** @type {number} */
THREE.RGBAIntegerFormat;

 /** @type {string} */
 THREE.PixelFormatGPU;

/** @type {number} */
THREE.RGB_S3TC_DXT1_Format;
/** @type {number} */
THREE.RGBA_S3TC_DXT1_Format;
/** @type {number} */
THREE.RGBA_S3TC_DXT3_Format;
/** @type {number} */
THREE.RGBA_S3TC_DXT5_Format;
/** @type {number} */
THREE.RGB_PVRTC_4BPPV1_Format;
/** @type {number} */
THREE.RGB_PVRTC_2BPPV1_Format;
/** @type {number} */
THREE.RGBA_PVRTC_4BPPV1_Format;
/** @type {number} */
THREE.RGBA_PVRTC_2BPPV1_Format;
/** @type {number} */
THREE.RGB_ETC1_Format;
/** @type {number} */
THREE.RGB_ETC2_Format;
/** @type {number} */
THREE.RGBA_ETC2_EAC_Format;
/** @type {number} */
THREE.RGBA_ASTC_4x4_Format;
/** @type {number} */
THREE.RGBA_ASTC_5x4_Format;
/** @type {number} */
THREE.RGBA_ASTC_5x5_Format;
/** @type {number} */
THREE.RGBA_ASTC_6x5_Format;
/** @type {number} */
THREE.RGBA_ASTC_6x6_Format;
/** @type {number} */
THREE.RGBA_ASTC_8x5_Format;
/** @type {number} */
THREE.RGBA_ASTC_8x6_Format;
/** @type {number} */
THREE.RGBA_ASTC_8x8_Format;
/** @type {number} */
THREE.RGBA_ASTC_10x5_Format;
/** @type {number} */
THREE.RGBA_ASTC_10x6_Format;
/** @type {number} */
THREE.RGBA_ASTC_10x8_Format;
/** @type {number} */
THREE.RGBA_ASTC_10x10_Format;
/** @type {number} */
THREE.RGBA_ASTC_12x10_Format;
/** @type {number} */
THREE.RGBA_ASTC_12x12_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_4x4_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_5x4_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_5x5_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_6x5_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_6x6_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_8x5_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_8x6_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_8x8_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_10x5_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_10x6_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_10x8_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_10x10_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_12x10_Format;
/** @type {number} */
THREE.SRGB8_ALPHA8_ASTC_12x12_Format;
/** @type {number} */
THREE.RGBA_BPTC_Format;

/** @type {number} */
THREE.LoopOnce;
/** @type {number} */
THREE.LoopRepeat;
/** @type {number} */
THREE.LoopPingPong;

/** @type {number} */
THREE.InterpolateDiscrete;
/** @type {number} */
THREE.InterpolateLinear;
/** @type {number} */
THREE.InterpolateSmooth;

/** @type {number} */
THREE.ZeroCurvatureEnding;
/** @type {number} */
THREE.ZeroSlopeEnding;
/** @type {number} */
THREE.WrapAroundEnding;

/** @type {number} */
THREE.NormalAnimationBlendMode;
/** @type {number} */
THREE.AdditiveAnimationBlendMode;

/** @type {number} */
THREE.TrianglesDrawMode;
/** @type {number} */
THREE.TriangleStripDrawMode;
/** @type {number} */
THREE.TriangleFanDrawMode;

/** @type {number} */
THREE.LinearEncoding;
/** @type {number} */
THREE.sRGBEncoding;
/** @type {number} */
THREE.GammaEncoding;
/** @type {number} */
THREE.RGBEEncoding;
/** @type {number} */
THREE.LogLuvEncoding;
/** @type {number} */
THREE.RGBM7Encoding;
/** @type {number} */
THREE.RGBM16Encoding;
/** @type {number} */
THREE.RGBDEncoding;

/** @type {number} */
THREE.BasicDepthPacking;
/** @type {number} */
THREE.RGBADepthPacking;

/** @type {number} */
THREE.TangentSpaceNormalMap;
/** @type {number} */
THREE.ObjectSpaceNormalMap;

/** @type {number} */
THREE.ZeroStencilOp;
/** @type {number} */
THREE.KeepStencilOp;
/** @type {number} */
THREE.ReplaceStencilOp;
/** @type {number} */
THREE.IncrementStencilOp;
/** @type {number} */
THREE.DecrementStencilOp;
/** @type {number} */
THREE.IncrementWrapStencilOp;
/** @type {number} */
THREE.DecrementWrapStencilOp;
/** @type {number} */
THREE.InvertStencilOp;

/** @type {number} */
THREE.NeverStencilFunc;
/** @type {number} */
THREE.LessStencilFunc;
/** @type {number} */
THREE.EqualStencilFunc;
/** @type {number} */
THREE.LessEqualStencilFunc;
/** @type {number} */
THREE.GreaterStencilFunc;
/** @type {number} */
THREE.NotEqualStencilFunc;
/** @type {number} */
THREE.GreaterEqualStencilFunc;
/** @type {number} */
THREE.AlwaysStencilFunc;

/** @type {number} */
THREE.StaticDrawUsage;
/** @type {number} */
THREE.DynamicDrawUsage;
/** @type {number} */
THREE.StreamDrawUsage;
/** @type {number} */
THREE.StaticReadUsage;
/** @type {number} */
THREE.DynamicReadUsage;
/** @type {number} */
THREE.StreamReadUsage;
/** @type {number} */
THREE.StaticCopyUsage;
/** @type {number} */
THREE.DynamicCopyUsage;
/** @type {number} */
THREE.StreamCopyUsage;

/** @type {number} */
THREE.GLSL1;
/** @type {number} */
THREE.GLSL3;

/** @type {string} */
THREE.BuiltinShaderAttributeName;
// externs from src/src/math/Quaternion.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|number)=} x x coordinate
 * @param {(undefined|number)=} y y coordinate
 * @param {(undefined|number)=} z z coordinate
 * @param {(undefined|number)=} w w coordinate
 */
THREE.Quaternion = function(x, y, z, w) {};
/** @type {number} */
THREE.Quaternion.prototype.x;
/** @type {number} */
THREE.Quaternion.prototype.y;
/** @type {number} */
THREE.Quaternion.prototype.z;
/** @type {number} */
THREE.Quaternion.prototype.w;
/** @type {boolean} */
THREE.Quaternion.prototype.isQuaternion;
/** @type {function(): void} */
THREE.Quaternion.prototype._onChangeCallback;

/**
 * Sets values of this quaternion.
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @param {number} w
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.set = function(x, y, z, w) {};

/**
 * Clones this quaternion.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Quaternion.prototype.clone = function() {};

/**
 * Copies values of q to this quaternion.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Quaternion} q
 * @return {THIS}
 */
THREE.Quaternion.prototype.copy = function(q) {};

/**
 * Sets this quaternion from rotation specified by Euler angles.
 * @param {THREE.Euler} euler
 * @param {(undefined|boolean)=} update
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.setFromEuler = function(euler, update) {};

/**
 * Sets this quaternion from rotation specified by axis and angle.
 * Adapted from http://www.euclideanspace.com/maths/geometry/rotations/conversions/angleToQuaternion/index.htm.
 * Axis have to be normalized, angle is in radians.
 * @param {THREE.Vector3} axis
 * @param {number} angle
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.setFromAxisAngle = function(axis, angle) {};

/**
 * Sets this quaternion from rotation component of m. Adapted from http://www.euclideanspace.com/maths/geometry/rotations/conversions/matrixToQuaternion/index.htm.
 * @param {THREE.Matrix4} m
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.setFromRotationMatrix = function(m) {};

/**
 * @param {THREE.Vector3} vFrom
 * @param {THREE.Vector3} vTo
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.setFromUnitVectors = function(vFrom, vTo) {};

/**
 * @param {THREE.Quaternion} q
 * @return {number}
 */
THREE.Quaternion.prototype.angleTo = function(q) {};

/**
 * @param {THREE.Quaternion} q
 * @param {number} step
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.rotateTowards = function(q, step) {};

/**
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.identity = function() {};

/**
 * Inverts this quaternion.
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.invert = function() {};

/**
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.conjugate = function() {};

/**
 * @param {THREE.Quaternion} v
 * @return {number}
 */
THREE.Quaternion.prototype.dot = function(v) {};

/**
 * @return {number}
 */
THREE.Quaternion.prototype.lengthSq = function() {};

/**
 * Computes length of this quaternion.
 * @return {number}
 */
THREE.Quaternion.prototype.length = function() {};

/**
 * Normalizes this quaternion.
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.normalize = function() {};

/**
 * Multiplies this quaternion by b.
 * @param {THREE.Quaternion} q
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.multiply = function(q) {};

/**
 * @param {THREE.Quaternion} q
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.premultiply = function(q) {};

/**
 * Sets this quaternion to a x b
 * Adapted from http://www.euclideanspace.com/maths/algebra/realNormedAlgebra/quaternions/code/index.htm.
 * @param {THREE.Quaternion} a
 * @param {THREE.Quaternion} b
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.multiplyQuaternions = function(a, b) {};

/**
 * @param {THREE.Quaternion} qb
 * @param {number} t
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.slerp = function(qb, t) {};

/**
 * @param {THREE.Quaternion} qa
 * @param {THREE.Quaternion} qb
 * @param {number} t
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.slerpQuaternions = function(qa, qb, t) {};

/**
 * @param {THREE.Quaternion} v
 * @return {boolean}
 */
THREE.Quaternion.prototype.equals = function(v) {};

/**
 * Sets this quaternion's x, y, z and w value from the provided array or array-like.
 * @template THIS
 * @this {THIS}
 * @param {(!Array<number>|Array<number>)} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array. Default is 0.
 * @return {THIS}
 */
THREE.Quaternion.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array [x, y, z, w], or copies x, y, z and w into the provided array. / Copies x, y, z and w into the provided array-like.
 * @param {(undefined|Array<number>)=} array (optional) array to store the quaternion to. If this is not provided, a new array will be created. / array-like to store the quaternion to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array.
 * @return {Array<number>} The created or provided array. / The provided array-like.
 */
THREE.Quaternion.prototype.toArray = function(array, offset) {};

/**
 * @param {function(): void} callback
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype._onChange = function(callback) {};

/**
 * @param {Array<number>} dst
 * @param {number} dstOffset
 * @param {Array<number>} src0
 * @param {number} srcOffset
 * @param {Array<number>} src1
 * @param {number} stcOffset1
 * @param {number} t
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.slerpFlat = function(dst, dstOffset, src0, srcOffset, src1, stcOffset1, t) {};

/**
 * @param {Array<number>} dst
 * @param {number} dstOffset
 * @param {Array<number>} src0
 * @param {number} srcOffset
 * @param {Array<number>} src1
 * @param {number} stcOffset1
 * @return {Array<number>}
 */
THREE.Quaternion.multiplyQuaternionsFlat = function(dst, dstOffset, src0, srcOffset, src1, stcOffset1) {};

/**
 * @deprecated Use qm.slerpQuaternions( qa, qb, t ) instead..
 * @param {THREE.Quaternion} qa
 * @param {THREE.Quaternion} qb
 * @param {THREE.Quaternion} qm
 * @param {number} t
 * @return {number}
 */
THREE.Quaternion.slerp = function(qa, qb, qm, t) {};

/**
 * @deprecated Use {\@link Vector#applyQuaternion vector.applyQuaternion( quaternion )} instead.
 * @param {number} v
 * @return {number}
 */
THREE.Quaternion.prototype.multiplyVector3 = function(v) {};

/**
 * @deprecated Use {\@link Quaternion#invert .invert()} instead.
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.inverse = function() {};

/**
 * @return {THREE.Quaternion}
 */
THREE.Quaternion.prototype.random = function() {};
// externs from src/src/math/Euler.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|number)=} x
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} z
 * @param {(undefined|string)=} order
 */
THREE.Euler = function(x, y, z, order) {};
/** @type {number} */
THREE.Euler.prototype.x;
/** @type {number} */
THREE.Euler.prototype.y;
/** @type {number} */
THREE.Euler.prototype.z;
/** @type {string} */
THREE.Euler.prototype.order;
/** @type {boolean} */
THREE.Euler.prototype.isEuler;
/** @type {function(): void} */
THREE.Euler.prototype._onChangeCallback;
/** @type {Array<string>} */
THREE.Euler.RotationOrders;
/** @type {string} */
THREE.Euler.DefaultOrder;

/**
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @param {(undefined|string)=} order
 * @return {THREE.Euler}
 */
THREE.Euler.prototype.set = function(x, y, z, order) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Euler.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Euler} euler
 * @return {THIS}
 */
THREE.Euler.prototype.copy = function(euler) {};

/**
 * @param {THREE.Matrix4} m
 * @param {(undefined|string)=} order
 * @param {(undefined|boolean)=} update
 * @return {THREE.Euler}
 */
THREE.Euler.prototype.setFromRotationMatrix = function(m, order, update) {};

/**
 * @param {THREE.Quaternion} q
 * @param {(undefined|string)=} order
 * @param {(undefined|boolean)=} update
 * @return {THREE.Euler}
 */
THREE.Euler.prototype.setFromQuaternion = function(q, order, update) {};

/**
 * @param {THREE.Vector3} v
 * @param {(undefined|string)=} order
 * @return {THREE.Euler}
 */
THREE.Euler.prototype.setFromVector3 = function(v, order) {};

/**
 * @param {string} newOrder
 * @return {THREE.Euler}
 */
THREE.Euler.prototype.reorder = function(newOrder) {};

/**
 * @param {THREE.Euler} euler
 * @return {boolean}
 */
THREE.Euler.prototype.equals = function(euler) {};

/**
 * @param {Array<Object>} xyzo
 * @return {THREE.Euler}
 */
THREE.Euler.prototype.fromArray = function(xyzo) {};

/**
 * @param {(undefined|Array<number>)=} array
 * @param {(undefined|number)=} offset
 * @return {Array<number>}
 */
THREE.Euler.prototype.toArray = function(array, offset) {};

/**
 * @param {(undefined|THREE.Vector3)=} optionalResult
 * @return {THREE.Vector3}
 */
THREE.Euler.prototype.toVector3 = function(optionalResult) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {function(): void} callback
 * @return {THIS}
 */
THREE.Euler.prototype._onChange = function(callback) {};
// externs from src/src/core/Layers.d.ts:

/**
 * @constructor
 * 
 */
THREE.Layers = function() {};
/** @type {number} */
THREE.Layers.prototype.mask;

/**
 * @param {number} channel
 * @return {void}
 */
THREE.Layers.prototype.set = function(channel) {};

/**
 * @param {number} channel
 * @return {void}
 */
THREE.Layers.prototype.enable = function(channel) {};

/**
 * @return {void}
 */
THREE.Layers.prototype.enableAll = function() {};

/**
 * @param {number} channel
 * @return {void}
 */
THREE.Layers.prototype.toggle = function(channel) {};

/**
 * @param {number} channel
 * @return {void}
 */
THREE.Layers.prototype.disable = function(channel) {};

/**
 * @return {void}
 */
THREE.Layers.prototype.disableAll = function() {};

/**
 * @param {THREE.Layers} layers
 * @return {boolean}
 */
THREE.Layers.prototype.test = function(layers) {};
// externs from src/src/scenes/Fog.d.ts:
/**
 * @interface
 * 
 */
THREE.FogBase = function() {};
/** @type {string} */
THREE.FogBase.prototype.name;
/** @type {THREE.Color} */
THREE.FogBase.prototype.color;

/**
 * @return {THREE.FogBase}
 */
THREE.FogBase.prototype.clone = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.FogBase.prototype.toJSON = function(opt_key) {};

/**
 * @implements {THREE.FogBase}
 * @constructor
 * 
 * @param {(string|number|THREE.Color)} color
 * @param {(undefined|number)=} near
 * @param {(undefined|number)=} far
 */
THREE.Fog = function(color, near, far) {};
/** @type {string} */
THREE.Fog.prototype.name;
/** @type {THREE.Color} */
THREE.Fog.prototype.color;
/** @type {number} */
THREE.Fog.prototype.near;
/** @type {number} */
THREE.Fog.prototype.far;
/** @type {boolean} */
THREE.Fog.prototype.isFog;

/**
 * @return {THREE.Fog}
 */
THREE.Fog.prototype.clone = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.Fog.prototype.toJSON = function(opt_key) {};
// externs from src/src/math/Vector2.d.ts:

/** @type {Array<Object>} */
THREE.Vector2Tuple;

/**
 * @interface
 * 
 */
THREE.Vector = function() {};

/**
 * @implements {THREE.Vector}
 * @constructor
 * 
 * @param {(undefined|number)=} x
 * @param {(undefined|number)=} y
 */
THREE.Vector2 = function(x, y) {};
/** @type {number} */
THREE.Vector2.prototype.x;
/** @type {number} */
THREE.Vector2.prototype.y;
/** @type {number} */
THREE.Vector2.prototype.width;
/** @type {number} */
THREE.Vector2.prototype.height;
/** @type {boolean} */
THREE.Vector2.prototype.isVector2;

/**
 * Sets value of this vector.
 * @param {number} x
 * @param {number} y
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.set = function(x, y) {};

/**
 * Sets the x and y values of this vector both equal to scalar.
 * @param {number} scalar
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.setScalar = function(scalar) {};

/**
 * Sets X component of this vector.
 * @param {number} x
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.setX = function(x) {};

/**
 * Sets Y component of this vector.
 * @param {number} y
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.setY = function(y) {};

/**
 * Sets a component of this vector.
 * @param {number} index
 * @param {number} value
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.setComponent = function(index, value) {};

/**
 * Gets a component of this vector.
 * @param {number} index
 * @return {number}
 */
THREE.Vector2.prototype.getComponent = function(index) {};

/**
 * Returns a new Vector2 instance with the same `x` and `y` values.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.clone = function() {};

/**
 * Copies value of v to this vector.
 * @param {THREE.Vector2} v
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.copy = function(v) {};

/**
 * Adds v to this vector.
 * @param {THREE.Vector2} v
 * @param {(undefined|THREE.Vector2)=} w
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.add = function(v, w) {};

/**
 * Adds the scalar value s to this vector's x and y values.
 * @param {number} s
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.addScalar = function(s) {};

/**
 * Sets this vector to a + b.
 * @param {THREE.Vector2} a
 * @param {THREE.Vector2} b
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.addVectors = function(a, b) {};

/**
 * Adds the multiple of v and s to this vector.
 * @template THIS
 * @param {THREE.Vector2} v
 * @param {number} s
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.addScaledVector = function(v, s) {};

/**
 * Subtracts v from this vector.
 * @param {THREE.Vector2} v
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.sub = function(v) {};

/**
 * Subtracts s from this vector's x and y components.
 * @param {number} s
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.subScalar = function(s) {};

/**
 * Sets this vector to a - b.
 * @param {THREE.Vector2} a
 * @param {THREE.Vector2} b
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.subVectors = function(a, b) {};

/**
 * Multiplies this vector by v.
 * @param {THREE.Vector2} v
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.multiply = function(v) {};

/**
 * Multiplies this vector by scalar s.
 * @param {number} scalar
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.multiplyScalar = function(scalar) {};

/**
 * Divides this vector by v.
 * @param {THREE.Vector2} v
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.divide = function(v) {};

/**
 * Divides this vector by scalar s.
 * Set vector to ( 0, 0 ) if s == 0.
 * @param {number} s
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.divideScalar = function(s) {};

/**
 * Multiplies this vector (with an implicit 1 as the 3rd component) by m.
 * @param {THREE.Matrix3} m
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.applyMatrix3 = function(m) {};

/**
 * If this vector's x or y value is greater than v's x or y value, replace that value with the corresponding min value.
 * @param {THREE.Vector2} v
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.min = function(v) {};

/**
 * If this vector's x or y value is less than v's x or y value, replace that value with the corresponding max value.
 * @param {THREE.Vector2} v
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.max = function(v) {};

/**
 * If this vector's x or y value is greater than the max vector's x or y value, it is replaced by the corresponding value.
 * If this vector's x or y value is less than the min vector's x or y value, it is replaced by the corresponding value.
 * @param {THREE.Vector2} min the minimum x and y values.
 * @param {THREE.Vector2} max the maximum x and y values in the desired range.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.clamp = function(min, max) {};

/**
 * If this vector's x or y values are greater than the max value, they are replaced by the max value.
 * If this vector's x or y values are less than the min value, they are replaced by the min value.
 * @param {number} min the minimum value the components will be clamped to.
 * @param {number} max the maximum value the components will be clamped to.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.clampScalar = function(min, max) {};

/**
 * If this vector's length is greater than the max value, it is replaced by the max value.
 * If this vector's length is less than the min value, it is replaced by the min value.
 * @param {number} min the minimum value the length will be clamped to.
 * @param {number} max the maximum value the length will be clamped to.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.clampLength = function(min, max) {};

/**
 * The components of the vector are rounded down to the nearest integer value.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.floor = function() {};

/**
 * The x and y components of the vector are rounded up to the nearest integer value.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.ceil = function() {};

/**
 * The components of the vector are rounded to the nearest integer value.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.round = function() {};

/**
 * The components of the vector are rounded towards zero (up if negative, down if positive) to an integer value.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.roundToZero = function() {};

/**
 * Inverts this vector.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.negate = function() {};

/**
 * Computes dot product of this vector and v.
 * @param {THREE.Vector2} v
 * @return {number}
 */
THREE.Vector2.prototype.dot = function(v) {};

/**
 * Computes cross product of this vector and v.
 * @param {THREE.Vector2} v
 * @return {number}
 */
THREE.Vector2.prototype.cross = function(v) {};

/**
 * Computes squared length of this vector.
 * @return {number}
 */
THREE.Vector2.prototype.lengthSq = function() {};

/**
 * Computes length of this vector.
 * @return {number}
 */
THREE.Vector2.prototype.length = function() {};

/**
 * @deprecated Use {\@link Vector2#manhattanLength .manhattanLength()} instead.
 * @return {number}
 */
THREE.Vector2.prototype.lengthManhattan = function() {};

/**
 * Computes the Manhattan length of this vector.
 * 
 * see {\@link http://en.wikipedia.org/wiki/Taxicab_geometry|Wikipedia: Taxicab Geometry}
 * @return {number}
 */
THREE.Vector2.prototype.manhattanLength = function() {};

/**
 * Normalizes this vector.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.normalize = function() {};

/**
 * computes the angle in radians with respect to the positive x-axis
 * @return {number}
 */
THREE.Vector2.prototype.angle = function() {};

/**
 * Computes distance of this vector to v.
 * @param {THREE.Vector2} v
 * @return {number}
 */
THREE.Vector2.prototype.distanceTo = function(v) {};

/**
 * Computes squared distance of this vector to v.
 * @param {THREE.Vector2} v
 * @return {number}
 */
THREE.Vector2.prototype.distanceToSquared = function(v) {};

/**
 * @deprecated Use {\@link Vector2#manhattanDistanceTo .manhattanDistanceTo()} instead.
 * @param {THREE.Vector2} v
 * @return {number}
 */
THREE.Vector2.prototype.distanceToManhattan = function(v) {};

/**
 * Computes the Manhattan length (distance) from this vector to the given vector v
 * 
 * see {\@link http://en.wikipedia.org/wiki/Taxicab_geometry|Wikipedia: Taxicab Geometry}
 * @param {THREE.Vector2} v
 * @return {number}
 */
THREE.Vector2.prototype.manhattanDistanceTo = function(v) {};

/**
 * Normalizes this vector and multiplies it by l.
 * @param {number} length
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.setLength = function(length) {};

/**
 * Linearly interpolates between this vector and v, where alpha is the distance along the line - alpha = 0 will be this vector, and alpha = 1 will be v.
 * @param {THREE.Vector2} v vector to interpolate towards.
 * @param {number} alpha interpolation factor in the closed interval [0, 1].
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.lerp = function(v, alpha) {};

/**
 * Sets this vector to be the vector linearly interpolated between v1 and v2 where alpha is the distance along the line connecting the two vectors - alpha = 0 will be v1, and alpha = 1 will be v2.
 * @param {THREE.Vector2} v1 the starting vector.
 * @param {THREE.Vector2} v2 vector to interpolate towards.
 * @param {number} alpha interpolation factor in the closed interval [0, 1].
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.lerpVectors = function(v1, v2, alpha) {};

/**
 * Checks for strict equality of this vector and v.
 * @param {THREE.Vector2} v
 * @return {boolean}
 */
THREE.Vector2.prototype.equals = function(v) {};

/**
 * Sets this vector's x and y value from the provided array or array-like.
 * @param {(!Array<number>)} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array. Default is 0.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array [x, y], or copies x and y into the provided array. / Copies x and y into the provided array-like.
 * @param {(undefined|Array<number>)|(undefined|Array<Object>)=} array (optional) array to store the vector to. If this is not provided, a new array will be created. / array-like to store the vector to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array.
 * @return {Array<number>|Array<Object>} The created or provided array. / The provided array-like.
 */
THREE.Vector2.prototype.toArray = function(array, offset) {};

/**
 * Sets this vector's x and y values from the attribute.
 * @param {THREE.BufferAttribute} attribute the source attribute.
 * @param {number} index index in the attribute.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.fromBufferAttribute = function(attribute, index) {};

/**
 * Rotates the vector around center by angle radians.
 * @param {THREE.Vector2} center the point around which to rotate.
 * @param {number} angle the angle to rotate, in radians.
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.rotateAround = function(center, angle) {};

/**
 * Sets this vector's x and y from Math.random
 * @return {THREE.Vector2}
 */
THREE.Vector2.prototype.random = function() {};
// externs from src/src/core/InterleavedBuffer.d.ts:

/**
 * @constructor
 * 
 * @param {Array<number>} array
 * @param {number} stride
 */
THREE.InterleavedBuffer = function(array, stride) {};
/** @type {Array<number>} */
THREE.InterleavedBuffer.prototype.array;
/** @type {number} */
THREE.InterleavedBuffer.prototype.stride;
/** @type {number} */
THREE.InterleavedBuffer.prototype.usage;
/** @type {{offset: number, count: number}} */
THREE.InterleavedBuffer.prototype.updateRange;
/** @type {number} */
THREE.InterleavedBuffer.prototype.version;
/** @type {number} */
THREE.InterleavedBuffer.prototype.length;
/** @type {number} */
THREE.InterleavedBuffer.prototype.count;
/** @type {boolean} */
THREE.InterleavedBuffer.prototype.needsUpdate;
/** @type {string} */
THREE.InterleavedBuffer.prototype.uuid;

/**
 * @param {number} usage
 * @return {THREE.InterleavedBuffer}
 */
THREE.InterleavedBuffer.prototype.setUsage = function(usage) {};

/**
 * @param {Object} data
 * @return {THREE.InterleavedBuffer}
 */
THREE.InterleavedBuffer.prototype.clone = function(data) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.InterleavedBuffer} source
 * @return {THIS}
 */
THREE.InterleavedBuffer.prototype.copy = function(source) {};

/**
 * @param {number} index1
 * @param {THREE.InterleavedBufferAttribute} attribute
 * @param {number} index2
 * @return {THREE.InterleavedBuffer}
 */
THREE.InterleavedBuffer.prototype.copyAt = function(index1, attribute, index2) {};

/**
 * @param {Array<number>} value
 * @param {number} index
 * @return {THREE.InterleavedBuffer}
 */
THREE.InterleavedBuffer.prototype.set = function(value, index) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.InterleavedBuffer.prototype.toJSON = function(opt_key) {};
// externs from src/src/core/InterleavedBufferAttribute.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.InterleavedBuffer} interleavedBuffer
 * @param {number} itemSize
 * @param {number} offset
 * @param {(undefined|boolean)=} normalized
 */
THREE.InterleavedBufferAttribute = function(interleavedBuffer, itemSize, offset, normalized) {};
/** @type {string} */
THREE.InterleavedBufferAttribute.prototype.name;
/** @type {THREE.InterleavedBuffer} */
THREE.InterleavedBufferAttribute.prototype.data;
/** @type {number} */
THREE.InterleavedBufferAttribute.prototype.itemSize;
/** @type {number} */
THREE.InterleavedBufferAttribute.prototype.offset;
/** @type {boolean} */
THREE.InterleavedBufferAttribute.prototype.normalized;

/* TODO: GetAccessor: THREE.InterleavedBufferAttribute.count */

/* TODO: GetAccessor: THREE.InterleavedBufferAttribute.array */

/* TODO: SetAccessor: THREE.InterleavedBufferAttribute.needsUpdate */
/** @type {boolean} */
THREE.InterleavedBufferAttribute.prototype.isInterleavedBufferAttribute;

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.applyMatrix4 = function(m) {};

/**
 * @param {(undefined|Object)=} data
 * @return {THREE.BufferAttribute}
 */
THREE.InterleavedBufferAttribute.prototype.clone = function(data) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.InterleavedBufferAttribute.prototype.getX = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setX = function(index, x) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.InterleavedBufferAttribute.prototype.getY = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} y
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setY = function(index, y) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.InterleavedBufferAttribute.prototype.getZ = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} z
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setZ = function(index, z) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.InterleavedBufferAttribute.prototype.getW = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} z
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setW = function(index, z) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @param {number} y
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setXY = function(index, x, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setXYZ = function(index, x, y, z) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @param {number} w
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.setXYZW = function(index, x, y, z, w) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.InterleavedBufferAttribute.prototype.toJSON = function(opt_key) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} matrix
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.applyNormalMatrix = function(matrix) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} matrix
 * @return {THIS}
 */
THREE.InterleavedBufferAttribute.prototype.transformDirection = function(matrix) {};
// externs from src/src/math/Triangle.d.ts:

/**
 * @implements {THREE.Vector}
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} a
 * @param {(undefined|THREE.Vector3)=} b
 * @param {(undefined|THREE.Vector3)=} c
 */
THREE.Triangle = function(a, b, c) {};
/** @type {THREE.Vector3} */
THREE.Triangle.prototype.a;
/** @type {THREE.Vector3} */
THREE.Triangle.prototype.b;
/** @type {THREE.Vector3} */
THREE.Triangle.prototype.c;

/**
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @return {THREE.Triangle}
 */
THREE.Triangle.prototype.set = function(a, b, c) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<THREE.Vector3>} points
 * @param {number} i0
 * @param {number} i1
 * @param {number} i2
 * @return {THIS}
 */
THREE.Triangle.prototype.setFromPointsAndIndices = function(points, i0, i1, i2) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)} attribute
 * @param {number} i0
 * @param {number} i1
 * @param {number} i2
 * @return {THIS}
 */
THREE.Triangle.prototype.setFromAttributeAndIndices = function(attribute, i0, i1, i2) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Triangle.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Triangle} triangle
 * @return {THIS}
 */
THREE.Triangle.prototype.copy = function(triangle) {};

/**
 * @return {number}
 */
THREE.Triangle.prototype.getArea = function() {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Triangle.prototype.getMidpoint = function(target) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Triangle.prototype.getNormal = function(target) {};

/**
 * @param {THREE.Plane} target
 * @return {THREE.Plane}
 */
THREE.Triangle.prototype.getPlane = function(target) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Triangle.prototype.getBarycoord = function(point, target) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector2} uv1
 * @param {THREE.Vector2} uv2
 * @param {THREE.Vector2} uv3
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.Triangle.prototype.getUV = function(point, uv1, uv2, uv3, target) {};

/**
 * @param {THREE.Vector3} point
 * @return {boolean}
 */
THREE.Triangle.prototype.containsPoint = function(point) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Triangle.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Vector3} direction
 * @return {boolean}
 */
THREE.Triangle.prototype.isFrontFacing = function(direction) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Triangle.prototype.closestPointToPoint = function(point, target) {};

/**
 * @param {THREE.Triangle} triangle
 * @return {boolean}
 */
THREE.Triangle.prototype.equals = function(triangle) {};

/**
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Triangle.getNormal = function(a, b, c, target) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Triangle.getBarycoord = function(point, a, b, c, target) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @return {boolean}
 */
THREE.Triangle.containsPoint = function(point, a, b, c) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} p1
 * @param {THREE.Vector3} p2
 * @param {THREE.Vector3} p3
 * @param {THREE.Vector2} uv1
 * @param {THREE.Vector2} uv2
 * @param {THREE.Vector2} uv3
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.Triangle.getUV = function(point, p1, p2, p3, uv1, uv2, uv3, target) {};

/**
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @param {THREE.Vector3} direction
 * @return {boolean}
 */
THREE.Triangle.isFrontFacing = function(a, b, c, direction) {};
// externs from src/src/math/Box3.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} min
 * @param {(undefined|THREE.Vector3)=} max
 */
THREE.Box3 = function(min, max) {};
/** @type {THREE.Vector3} */
THREE.Box3.prototype.min;
/** @type {THREE.Vector3} */
THREE.Box3.prototype.max;
/** @type {boolean} */
THREE.Box3.prototype.isBox3;

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} min
 * @param {THREE.Vector3} max
 * @return {THIS}
 */
THREE.Box3.prototype.set = function(min, max) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<number>} array
 * @return {THIS}
 */
THREE.Box3.prototype.setFromArray = function(array) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.BufferAttribute} bufferAttribute
 * @return {THIS}
 */
THREE.Box3.prototype.setFromBufferAttribute = function(bufferAttribute) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<THREE.Vector3>} points
 * @return {THIS}
 */
THREE.Box3.prototype.setFromPoints = function(points) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} center
 * @param {THREE.Vector3} size
 * @return {THIS}
 */
THREE.Box3.prototype.setFromCenterAndSize = function(center, size) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {THIS}
 */
THREE.Box3.prototype.setFromObject = function(object) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Box3.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Box3} box
 * @return {THIS}
 */
THREE.Box3.prototype.copy = function(box) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Box3.prototype.makeEmpty = function() {};

/**
 * @return {boolean}
 */
THREE.Box3.prototype.isEmpty = function() {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Box3.prototype.getCenter = function(target) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Box3.prototype.getSize = function(target) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} point
 * @return {THIS}
 */
THREE.Box3.prototype.expandByPoint = function(point) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} vector
 * @return {THIS}
 */
THREE.Box3.prototype.expandByVector = function(vector) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} scalar
 * @return {THIS}
 */
THREE.Box3.prototype.expandByScalar = function(scalar) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {THIS}
 */
THREE.Box3.prototype.expandByObject = function(object) {};

/**
 * @param {THREE.Vector3} point
 * @return {boolean}
 */
THREE.Box3.prototype.containsPoint = function(point) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Box3.prototype.containsBox = function(box) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Box3.prototype.getParameter = function(point, target) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Box3.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {boolean}
 */
THREE.Box3.prototype.intersectsSphere = function(sphere) {};

/**
 * @param {THREE.Plane} plane
 * @return {boolean}
 */
THREE.Box3.prototype.intersectsPlane = function(plane) {};

/**
 * @param {THREE.Triangle} triangle
 * @return {boolean}
 */
THREE.Box3.prototype.intersectsTriangle = function(triangle) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Box3.prototype.clampPoint = function(point, target) {};

/**
 * @param {THREE.Vector3} point
 * @return {number}
 */
THREE.Box3.prototype.distanceToPoint = function(point) {};

/**
 * @param {THREE.Sphere} target
 * @return {THREE.Sphere}
 */
THREE.Box3.prototype.getBoundingSphere = function(target) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Box3} box
 * @return {THIS}
 */
THREE.Box3.prototype.intersect = function(box) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Box3} box
 * @return {THIS}
 */
THREE.Box3.prototype.union = function(box) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} matrix
 * @return {THIS}
 */
THREE.Box3.prototype.applyMatrix4 = function(matrix) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} offset
 * @return {THIS}
 */
THREE.Box3.prototype.translate = function(offset) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Box3.prototype.equals = function(box) {};

/**
 * @deprecated Use {\@link Box3#isEmpty .isEmpty()} instead.
 * @return {number}
 */
THREE.Box3.prototype.empty = function() {};

/**
 * @deprecated Use {\@link Box3#intersectsBox .intersectsBox()} instead.
 * @param {number} b
 * @return {number}
 */
THREE.Box3.prototype.isIntersectionBox = function(b) {};

/**
 * @deprecated Use {\@link Box3#intersectsSphere .intersectsSphere()} instead.
 * @param {number} s
 * @return {number}
 */
THREE.Box3.prototype.isIntersectionSphere = function(s) {};
// externs from src/src/math/Sphere.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} center
 * @param {(undefined|number)=} radius
 */
THREE.Sphere = function(center, radius) {};
/** @type {THREE.Vector3} */
THREE.Sphere.prototype.center;
/** @type {number} */
THREE.Sphere.prototype.radius;

/**
 * @param {THREE.Vector3} center
 * @param {number} radius
 * @return {THREE.Sphere}
 */
THREE.Sphere.prototype.set = function(center, radius) {};

/**
 * @param {Array<THREE.Vector3>} points
 * @param {(undefined|THREE.Vector3)=} optionalCenter
 * @return {THREE.Sphere}
 */
THREE.Sphere.prototype.setFromPoints = function(points, optionalCenter) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Sphere.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Sphere} sphere
 * @return {THIS}
 */
THREE.Sphere.prototype.copy = function(sphere) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} point
 * @return {THIS}
 */
THREE.Sphere.prototype.expandByPoint = function(point) {};

/**
 * @return {boolean}
 */
THREE.Sphere.prototype.isEmpty = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Sphere.prototype.makeEmpty = function() {};

/**
 * @param {THREE.Vector3} point
 * @return {boolean}
 */
THREE.Sphere.prototype.containsPoint = function(point) {};

/**
 * @param {THREE.Vector3} point
 * @return {number}
 */
THREE.Sphere.prototype.distanceToPoint = function(point) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {boolean}
 */
THREE.Sphere.prototype.intersectsSphere = function(sphere) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Sphere.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Plane} plane
 * @return {boolean}
 */
THREE.Sphere.prototype.intersectsPlane = function(plane) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Sphere.prototype.clampPoint = function(point, target) {};

/**
 * @param {THREE.Box3} target
 * @return {THREE.Box3}
 */
THREE.Sphere.prototype.getBoundingBox = function(target) {};

/**
 * @param {THREE.Matrix4} matrix
 * @return {THREE.Sphere}
 */
THREE.Sphere.prototype.applyMatrix4 = function(matrix) {};

/**
 * @param {THREE.Vector3} offset
 * @return {THREE.Sphere}
 */
THREE.Sphere.prototype.translate = function(offset) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {boolean}
 */
THREE.Sphere.prototype.equals = function(sphere) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Sphere} sphere
 * @return {THIS}
 */
THREE.Sphere.prototype.union = function(sphere) {};

/**
 * @deprecated Use {\@link Sphere#isEmpty .isEmpty()} instead.
 * @return {number}
 */
THREE.Sphere.prototype.empty = function() {};
// externs from src/src/math/Line3.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} start
 * @param {(undefined|THREE.Vector3)=} end
 */
THREE.Line3 = function(start, end) {};
/** @type {THREE.Vector3} */
THREE.Line3.prototype.start;
/** @type {THREE.Vector3} */
THREE.Line3.prototype.end;

/**
 * @param {(undefined|THREE.Vector3)=} start
 * @param {(undefined|THREE.Vector3)=} end
 * @return {THREE.Line3}
 */
THREE.Line3.prototype.set = function(start, end) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Line3.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Line3} line
 * @return {THIS}
 */
THREE.Line3.prototype.copy = function(line) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Line3.prototype.getCenter = function(target) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Line3.prototype.delta = function(target) {};

/**
 * @return {number}
 */
THREE.Line3.prototype.distanceSq = function() {};

/**
 * @return {number}
 */
THREE.Line3.prototype.distance = function() {};

/**
 * @param {number} t
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Line3.prototype.at = function(t, target) {};

/**
 * @param {THREE.Vector3} point
 * @param {(undefined|boolean)=} clampToLine
 * @return {number}
 */
THREE.Line3.prototype.closestPointToPointParameter = function(point, clampToLine) {};

/**
 * @param {THREE.Vector3} point
 * @param {boolean} clampToLine
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Line3.prototype.closestPointToPoint = function(point, clampToLine, target) {};

/**
 * @param {THREE.Matrix4} matrix
 * @return {THREE.Line3}
 */
THREE.Line3.prototype.applyMatrix4 = function(matrix) {};

/**
 * @param {THREE.Line3} line
 * @return {boolean}
 */
THREE.Line3.prototype.equals = function(line) {};
// externs from src/src/math/Plane.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} normal
 * @param {(undefined|number)=} constant
 */
THREE.Plane = function(normal, constant) {};
/** @type {THREE.Vector3} */
THREE.Plane.prototype.normal;
/** @type {number} */
THREE.Plane.prototype.constant;
/** @type {boolean} */
THREE.Plane.prototype.isPlane;

/**
 * @param {THREE.Vector3} normal
 * @param {number} constant
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.set = function(normal, constant) {};

/**
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @param {number} w
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.setComponents = function(x, y, z, w) {};

/**
 * @param {THREE.Vector3} normal
 * @param {THREE.Vector3} point
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.setFromNormalAndCoplanarPoint = function(normal, point) {};

/**
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.setFromCoplanarPoints = function(a, b, c) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Plane.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Plane} plane
 * @return {THIS}
 */
THREE.Plane.prototype.copy = function(plane) {};

/**
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.normalize = function() {};

/**
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.negate = function() {};

/**
 * @param {THREE.Vector3} point
 * @return {number}
 */
THREE.Plane.prototype.distanceToPoint = function(point) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {number}
 */
THREE.Plane.prototype.distanceToSphere = function(sphere) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Plane.prototype.projectPoint = function(point, target) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Plane.prototype.orthoPoint = function(point, target) {};

/**
 * @param {THREE.Line3} line
 * @param {THREE.Vector3} target
 * @return {(null|THREE.Vector3)}
 */
THREE.Plane.prototype.intersectLine = function(line, target) {};

/**
 * @param {THREE.Line3} line
 * @return {boolean}
 */
THREE.Plane.prototype.intersectsLine = function(line) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Plane.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {boolean}
 */
THREE.Plane.prototype.intersectsSphere = function(sphere) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Plane.prototype.coplanarPoint = function(target) {};

/**
 * @param {THREE.Matrix4} matrix
 * @param {(undefined|THREE.Matrix3)=} optionalNormalMatrix
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.applyMatrix4 = function(matrix, optionalNormalMatrix) {};

/**
 * @param {THREE.Vector3} offset
 * @return {THREE.Plane}
 */
THREE.Plane.prototype.translate = function(offset) {};

/**
 * @param {THREE.Plane} plane
 * @return {boolean}
 */
THREE.Plane.prototype.equals = function(plane) {};

/**
 * @deprecated Use {\@link Plane#intersectsLine .intersectsLine()} instead.
 * @param {number} l
 * @return {number}
 */
THREE.Plane.prototype.isIntersectionLine = function(l) {};
// externs from src/src/core/EventDispatcher.d.ts:

/**
 * @record
 * 
 */
THREE.EventDispatcher.BaseEvent = function() {};
/** @type {string} */
THREE.EventDispatcher.BaseEvent.prototype.type;
/**
 * @extends {THREE.EventDispatcher.BaseEvent}
 * @record
 * 
 */
THREE.EventDispatcher.Event = function() {};
/** @type {Object|undefined} */
THREE.EventDispatcher.Event.prototype.target;

/* TODO: IndexSignature: THREE.EventDispatcher */

/** @type {function(Object): void} */
THREE.EventDispatcher.EventListener;

/**
 * @template E
 * @constructor
 * 
 * Creates eventDispatcher object. It needs to be call with '.call' to add the functionality to an object.
 */
THREE.EventDispatcher = function() {};

/**
 * Adds a listener to an event type.
 * @template T
 * @param {T} type The type of event to listen to.
 * @param {function(Object): void} listener The function that gets called when the event is fired.
 * @return {void}
 */
THREE.EventDispatcher.prototype.addEventListener = function(type, listener) {};

/**
 * Checks if listener is added to an event type.
 * @template T
 * @param {T} type The type of event to listen to.
 * @param {function(Object): void} listener The function that gets called when the event is fired.
 * @return {boolean}
 */
THREE.EventDispatcher.prototype.hasEventListener = function(type, listener) {};

/**
 * Removes a listener from an event type.
 * @template T
 * @param {T} type The type of the listener that gets removed.
 * @param {function(Object): void} listener The listener function that gets removed.
 * @return {void}
 */
THREE.EventDispatcher.prototype.removeEventListener = function(type, listener) {};

/**
 * Fire an event type.
 * @param {E} event
 * @return {void}
 */
THREE.EventDispatcher.prototype.dispatchEvent = function(event) {};
// externs from src/src/renderers/shaders/UniformsLib.d.ts:
/**
 * @template TValue
 * @record
 * 
 */
THREE.UniformsLib.IUniform = function() {};
/** @type {TValue} */
THREE.UniformsLib.IUniform.prototype.value;
/** @type {{common: {diffuse: Object, opacity: Object, map: Object, uvTransform: Object, uv2Transform: Object, alphaMap: Object}, specularmap: {specularMap: Object}, envmap: {envMap: Object, flipEnvMap: Object, reflectivity: Object, refractionRatio: Object, maxMipLevel: Object}, aomap: {aoMap: Object, aoMapIntensity: Object}, lightmap: {lightMap: Object, lightMapIntensity: Object}, emissivemap: {emissiveMap: Object}, bumpmap: {bumpMap: Object, bumpScale: Object}, normalmap: {normalMap: Object, normalScale: Object}, displacementmap: {displacementMap: Object, displacementScale: Object, displacementBias: Object}, roughnessmap: {roughnessMap: Object}, metalnessmap: {metalnessMap: Object}, gradientmap: {gradientMap: Object}, fog: {fogDensity: Object, fogNear: Object, fogFar: Object, fogColor: Object}, lights: {ambientLightColor: Object, directionalLights: {value: Array<Object>, properties: {direction: *, color: Object}}, directionalLightShadows: {value: Array<Object>, properties: {shadowBias: Object, shadowNormalBias: Object, shadowRadius: Object, shadowMapSize: Object}}, directionalShadowMap: Object, directionalShadowMatrix: Object, spotLights: {value: Array<Object>, properties: {color: Object, position: Object, direction: Object, distance: Object, coneCos: Object, penumbraCos: Object, decay: Object}}, spotLightShadows: {value: Array<Object>, properties: {shadowBias: Object, shadowNormalBias: Object, shadowRadius: Object, shadowMapSize: Object}}, spotShadowMap: Object, spotShadowMatrix: Object, pointLights: {value: Array<Object>, properties: {color: Object, position: Object, decay: Object, distance: Object}}, pointLightShadows: {value: Array<Object>, properties: {shadowBias: Object, shadowNormalBias: Object, shadowRadius: Object, shadowMapSize: Object}}, pointShadowMap: Object, pointShadowMatrix: Object, hemisphereLights: {value: Array<Object>, properties: {direction: Object, skycolor: Object, groundColor: Object}}, rectAreaLights: {value: Array<Object>, properties: {color: Object, position: Object, width: Object, height: Object}}}, points: {diffuse: Object, opacity: Object, size: Object, scale: Object, map: Object, uvTransform: Object}}} */
THREE.UniformsLib;
// externs from src/src/renderers/shaders/ShaderLib.d.ts:
/** @constructor */
THREE.ShaderLib = function() {};
/**
 * @record
 * 
 */
THREE.ShaderLib.Shader = function() {};
/** @type {Object<string,Object>} */
THREE.ShaderLib.Shader.prototype.uniforms;
/** @type {string} */
THREE.ShaderLib.Shader.prototype.vertexShader;
/** @type {string} */
THREE.ShaderLib.Shader.prototype.fragmentShader;

/**
 * @extends {THREE.EventDispatcher}
 * @constructor
 * 
 * @param {(undefined|HTMLImageElement|HTMLCanvasElement|HTMLVideoElement)=} image
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} format
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} anisotropy
 * @param {(undefined|number)=} encoding
 */
THREE.Texture = function(image, mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy, encoding) {};
/** @type {number} */
THREE.Texture.prototype.id;
/** @type {string} */
THREE.Texture.prototype.uuid;
/** @type {string} */
THREE.Texture.prototype.name;
/** @type {string} */
THREE.Texture.prototype.sourceFile;
/** @type {number} */
THREE.Texture.prototype.image;
/** @type {Array<Object>} */
THREE.Texture.prototype.mipmaps;
/** @type {number} */
THREE.Texture.prototype.mapping;
/** @type {number} */
THREE.Texture.prototype.wrapS;
/** @type {number} */
THREE.Texture.prototype.wrapT;
/** @type {number} */
THREE.Texture.prototype.magFilter;
/** @type {number} */
THREE.Texture.prototype.minFilter;
/** @type {number} */
THREE.Texture.prototype.anisotropy;
/** @type {number} */
THREE.Texture.prototype.format;
/** @type {(null|string)} */
THREE.Texture.prototype.internalFormat;
/** @type {number} */
THREE.Texture.prototype.type;
/** @type {THREE.Matrix3} */
THREE.Texture.prototype.matrix;
/** @type {boolean} */
THREE.Texture.prototype.matrixAutoUpdate;
/** @type {THREE.Vector2} */
THREE.Texture.prototype.offset;
/** @type {THREE.Vector2} */
THREE.Texture.prototype.repeat;
/** @type {THREE.Vector2} */
THREE.Texture.prototype.center;
/** @type {number} */
THREE.Texture.prototype.rotation;
/** @type {boolean} */
THREE.Texture.prototype.generateMipmaps;
/** @type {boolean} */
THREE.Texture.prototype.premultiplyAlpha;
/** @type {boolean} */
THREE.Texture.prototype.flipY;
/** @type {number} */
THREE.Texture.prototype.unpackAlignment;
/** @type {number} */
THREE.Texture.prototype.encoding;
/** @type {boolean} */
THREE.Texture.prototype.isRenderTargetTexture;
/** @type {number} */
THREE.Texture.prototype.userData;
/** @type {number} */
THREE.Texture.prototype.version;
/** @type {boolean} */
THREE.Texture.prototype.needsUpdate;
/** @type {boolean} */
THREE.Texture.prototype.isTexture;
/** @type {function(): void} */
THREE.Texture.prototype.onUpdate;
/** @type {number} */
THREE.Texture.DEFAULT_IMAGE;
/** @type {number} */
THREE.Texture.DEFAULT_MAPPING;

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Texture.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Texture} source
 * @return {THIS}
 */
THREE.Texture.prototype.copy = function(source) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.Texture.prototype.toJSON = function(opt_key) {};

/**
 * @return {void}
 */
THREE.Texture.prototype.dispose = function() {};

/**
 * @param {THREE.Vector2} uv
 * @return {THREE.Vector2}
 */
THREE.Texture.prototype.transformUv = function(uv) {};

/**
 * @return {void}
 */
THREE.Texture.prototype.updateMatrix = function() {};
// externs from src/src/materials/Material.d.ts:
/**
 * @record
 * 
 */
THREE.MaterialParameters = function() {};
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.alphaTest;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.alphaToCoverage;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.blendDst;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.blendDstAlpha;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.blendEquation;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.blendEquationAlpha;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.blending;
/** @type {(undefined|number|number)} */
THREE.MaterialParameters.prototype.blendSrc;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.blendSrcAlpha;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.clipIntersection;
/** @type {(undefined|Array<THREE.Plane>)} */
THREE.MaterialParameters.prototype.clippingPlanes;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.clipShadows;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.colorWrite;
/** @type {Object|undefined} */
THREE.MaterialParameters.prototype.defines;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.depthFunc;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.depthTest;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.depthWrite;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.fog;
/** @type {(undefined|string)} */
THREE.MaterialParameters.prototype.name;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.opacity;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.polygonOffset;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.polygonOffsetFactor;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.polygonOffsetUnits;
/** @type {(undefined|null|string)} */
THREE.MaterialParameters.prototype.precision;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.premultipliedAlpha;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.dithering;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.side;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.shadowSide;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.toneMapped;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.transparent;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.vertexColors;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.visible;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.format;
/** @type {(undefined|boolean)} */
THREE.MaterialParameters.prototype.stencilWrite;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilFunc;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilRef;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilWriteMask;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilFuncMask;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilFail;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilZFail;
/** @type {(undefined|number)} */
THREE.MaterialParameters.prototype.stencilZPass;
/** @type {Object|undefined} */
THREE.MaterialParameters.prototype.userData;

/**
 * @extends {THREE.EventDispatcher}
 * @constructor
 * 
 */
THREE.Material = function() {};
/** @type {number} */
THREE.Material.prototype.alphaTest;
/** @type {boolean} */
THREE.Material.prototype.alphaToCoverage;
/** @type {number} */
THREE.Material.prototype.blendDst;
/** @type {(null|number)} */
THREE.Material.prototype.blendDstAlpha;
/** @type {number} */
THREE.Material.prototype.blendEquation;
/** @type {(null|number)} */
THREE.Material.prototype.blendEquationAlpha;
/** @type {number} */
THREE.Material.prototype.blending;
/** @type {(number|number)} */
THREE.Material.prototype.blendSrc;
/** @type {(null|number)} */
THREE.Material.prototype.blendSrcAlpha;
/** @type {boolean} */
THREE.Material.prototype.clipIntersection;
/** @type {Array<THREE.Plane>} */
THREE.Material.prototype.clippingPlanes;
/** @type {boolean} */
THREE.Material.prototype.clipShadows;
/** @type {boolean} */
THREE.Material.prototype.colorWrite;
/** @type {(undefined|Object<string,Object>)} */
THREE.Material.prototype.defines;
/** @type {number} */
THREE.Material.prototype.depthFunc;
/** @type {boolean} */
THREE.Material.prototype.depthTest;
/** @type {boolean} */
THREE.Material.prototype.depthWrite;
/** @type {boolean} */
THREE.Material.prototype.fog;
/** @type {number} */
THREE.Material.prototype.format;
/** @type {number} */
THREE.Material.prototype.id;
/** @type {boolean} */
THREE.Material.prototype.stencilWrite;
/** @type {number} */
THREE.Material.prototype.stencilFunc;
/** @type {number} */
THREE.Material.prototype.stencilRef;
/** @type {number} */
THREE.Material.prototype.stencilWriteMask;
/** @type {number} */
THREE.Material.prototype.stencilFuncMask;
/** @type {number} */
THREE.Material.prototype.stencilFail;
/** @type {number} */
THREE.Material.prototype.stencilZFail;
/** @type {number} */
THREE.Material.prototype.stencilZPass;
/** @type {boolean} */
THREE.Material.prototype.isMaterial;
/** @type {string} */
THREE.Material.prototype.name;
/** @type {boolean} */
THREE.Material.prototype.needsUpdate;
/** @type {number} */
THREE.Material.prototype.opacity;
/** @type {boolean} */
THREE.Material.prototype.polygonOffset;
/** @type {number} */
THREE.Material.prototype.polygonOffsetFactor;
/** @type {number} */
THREE.Material.prototype.polygonOffsetUnits;
/** @type {(null|string)} */
THREE.Material.prototype.precision;
/** @type {boolean} */
THREE.Material.prototype.premultipliedAlpha;
/** @type {boolean} */
THREE.Material.prototype.dithering;
/** @type {number} */
THREE.Material.prototype.side;
/** @type {(null|number)} */
THREE.Material.prototype.shadowSide;
/** @type {boolean} */
THREE.Material.prototype.toneMapped;
/** @type {boolean} */
THREE.Material.prototype.transparent;
/** @type {string} */
THREE.Material.prototype.type;
/** @type {string} */
THREE.Material.prototype.uuid;
/** @type {boolean} */
THREE.Material.prototype.vertexColors;
/** @type {boolean} */
THREE.Material.prototype.visible;
/** @type {number} */
THREE.Material.prototype.userData;
/** @type {number} */
THREE.Material.prototype.version;

/**
 * Return a new material with the same parameters as this material.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Material.prototype.clone = function() {};

/**
 * Copy the parameters from the passed material into this material.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Material} material
 * @return {THIS}
 */
THREE.Material.prototype.copy = function(material) {};

/**
 * This disposes the material. Textures of a material don't get disposed. These needs to be disposed by {\@link Texture}.
 * @return {void}
 */
THREE.Material.prototype.dispose = function() {};

/**
 * An optional callback that is executed immediately before the shader program is compiled.
 * This function is called with the shader source code as a parameter.
 * Useful for the modification of built-in materials.
 * @param {Object} shader Source code of the shader
 * @param {THREE.WebGLRenderer} renderer WebGLRenderer Context that is initializing the material
 * @return {void}
 */
THREE.Material.prototype.onBeforeCompile = function(shader, renderer) {};

/**
 * In case onBeforeCompile is used, this callback can be used to identify values of settings used in onBeforeCompile, so three.js can reuse a cached shader or recompile the shader as needed.
 * @return {string}
 */
THREE.Material.prototype.customProgramCacheKey = function() {};

/**
 * Sets the properties based on the values.
 * @param {THREE.MaterialParameters} values A container with parameters.
 * @return {void}
 */
THREE.Material.prototype.setValues = function(values) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.Material.prototype.toJSON = function(opt_key) {};
// externs from src/src/scenes/Scene.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 */
THREE.Scene = function() {};
/** @type {string} */
THREE.Scene.prototype.type;
/** @type {(null|THREE.FogBase)} */
THREE.Scene.prototype.fog;
/** @type {(null|THREE.Material)} */
THREE.Scene.prototype.overrideMaterial;
/** @type {boolean} */
THREE.Scene.prototype.autoUpdate;
/** @type {(null|THREE.Color|THREE.Texture)} */
THREE.Scene.prototype.background;
/** @type {(null|THREE.Texture)} */
THREE.Scene.prototype.environment;
/** @type {boolean} */
THREE.Scene.prototype.isScene;
/** @type {function(!THREE.WebGLRenderer, THREE.Scene, THREE.Camera, Object): void} */
THREE.Scene.prototype.onBeforeRender;
/** @type {function(!THREE.WebGLRenderer, THREE.Scene, THREE.Camera): void} */
THREE.Scene.prototype.onAfterRender;

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.Scene.prototype.toJSON = function(opt_key) {};
// externs from src/src/renderers/webgl/WebGLCapabilities.d.ts:
/**
 * @record
 * 
 */
THREE.WebGLCapabilitiesParameters = function() {};
/** @type {(undefined|string)} */
THREE.WebGLCapabilitiesParameters.prototype.precision;
/** @type {(undefined|boolean)} */
THREE.WebGLCapabilitiesParameters.prototype.logarithmicDepthBuffer;

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {number} extensions
 * @param {THREE.WebGLCapabilitiesParameters} parameters
 */
THREE.WebGLCapabilities = function(gl, extensions, parameters) {};
/** @type {boolean} */
THREE.WebGLCapabilities.prototype.isWebGL2;
/** @type {string} */
THREE.WebGLCapabilities.prototype.precision;
/** @type {boolean} */
THREE.WebGLCapabilities.prototype.logarithmicDepthBuffer;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxTextures;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxVertexTextures;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxTextureSize;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxCubemapSize;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxAttributes;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxVertexUniforms;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxVaryings;
/** @type {number} */
THREE.WebGLCapabilities.prototype.maxFragmentUniforms;
/** @type {boolean} */
THREE.WebGLCapabilities.prototype.vertexTextures;
/** @type {boolean} */
THREE.WebGLCapabilities.prototype.floatFragmentTextures;
/** @type {boolean} */
THREE.WebGLCapabilities.prototype.floatVertexTextures;

/**
 * @return {number}
 */
THREE.WebGLCapabilities.prototype.getMaxAnisotropy = function() {};

/**
 * @param {string} precision
 * @return {string}
 */
THREE.WebGLCapabilities.prototype.getMaxPrecision = function(precision) {};
// externs from src/src/renderers/webgl/WebGLExtensions.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 */
THREE.WebGLExtensions = function(gl) {};

/**
 * @param {string} name
 * @return {boolean}
 */
THREE.WebGLExtensions.prototype.has = function(name) {};

/**
 * @param {THREE.WebGLCapabilities} capabilities
 * @return {void}
 */
THREE.WebGLExtensions.prototype.init = function(capabilities) {};

/**
 * @param {string} name
 * @return {number}
 */
THREE.WebGLExtensions.prototype.get = function(name) {};
// externs from src/src/renderers/webgl/WebGLShader.d.ts:

/**
 * @param {WebGLRenderingContext} gl
 * @param {string} type
 * @param {string} string
 * @return {WebGLShader}
 */
THREE.WebGLShader = function(gl, type, string) {};
// externs from src/src/math/Vector4.d.ts:

/** @type {Array<Object>} */
THREE.Vector4Tuple;

/**
 * @implements {THREE.Vector}
 * @constructor
 * 
 * @param {(undefined|number)=} x
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} z
 * @param {(undefined|number)=} w
 */
THREE.Vector4 = function(x, y, z, w) {};
/** @type {number} */
THREE.Vector4.prototype.x;
/** @type {number} */
THREE.Vector4.prototype.y;
/** @type {number} */
THREE.Vector4.prototype.z;
/** @type {number} */
THREE.Vector4.prototype.w;
/** @type {number} */
THREE.Vector4.prototype.width;
/** @type {number} */
THREE.Vector4.prototype.height;
/** @type {boolean} */
THREE.Vector4.prototype.isVector4;

/**
 * Sets value of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @param {number} w
 * @return {THIS}
 */
THREE.Vector4.prototype.set = function(x, y, z, w) {};

/**
 * Sets all values of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} scalar
 * @return {THIS}
 */
THREE.Vector4.prototype.setScalar = function(scalar) {};

/**
 * Sets X component of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @return {THIS}
 */
THREE.Vector4.prototype.setX = function(x) {};

/**
 * Sets Y component of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} y
 * @return {THIS}
 */
THREE.Vector4.prototype.setY = function(y) {};

/**
 * Sets Z component of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} z
 * @return {THIS}
 */
THREE.Vector4.prototype.setZ = function(z) {};

/**
 * Sets w component of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} w
 * @return {THIS}
 */
THREE.Vector4.prototype.setW = function(w) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} value
 * @return {THIS}
 */
THREE.Vector4.prototype.setComponent = function(index, value) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.Vector4.prototype.getComponent = function(index) {};

/**
 * Clones this vector.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.clone = function() {};

/**
 * Copies value of v to this vector.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @return {THIS}
 */
THREE.Vector4.prototype.copy = function(v) {};

/**
 * Adds v to this vector.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @return {THIS}
 */
THREE.Vector4.prototype.add = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} scalar
 * @return {THIS}
 */
THREE.Vector4.prototype.addScalar = function(scalar) {};

/**
 * Sets this vector to a + b.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} a
 * @param {THREE.Vector4} b
 * @return {THIS}
 */
THREE.Vector4.prototype.addVectors = function(a, b) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector4.prototype.addScaledVector = function(v, s) {};

/**
 * Subtracts v from this vector.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @return {THIS}
 */
THREE.Vector4.prototype.sub = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector4.prototype.subScalar = function(s) {};

/**
 * Sets this vector to a - b.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} a
 * @param {THREE.Vector4} b
 * @return {THIS}
 */
THREE.Vector4.prototype.subVectors = function(a, b) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @return {THIS}
 */
THREE.Vector4.prototype.multiply = function(v) {};

/**
 * Multiplies this vector by scalar s.
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector4.prototype.multiplyScalar = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Vector4.prototype.applyMatrix4 = function(m) {};

/**
 * Divides this vector by scalar s.
 * Set vector to ( 0, 0, 0 ) if s == 0.
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector4.prototype.divideScalar = function(s) {};

/**
 * http://www.euclideanspace.com/maths/geometry/rotations/conversions/quaternionToAngle/index.htm
 * @template THIS
 * @this {THIS}
 * @param {THREE.Quaternion} q is assumed to be normalized
 * @return {THIS}
 */
THREE.Vector4.prototype.setAxisAngleFromQuaternion = function(q) {};

/**
 * http://www.euclideanspace.com/maths/geometry/rotations/conversions/matrixToAngle/index.htm
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m assumes the upper 3x3 of m is a pure rotation matrix (i.e, unscaled)
 * @return {THIS}
 */
THREE.Vector4.prototype.setAxisAngleFromRotationMatrix = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @return {THIS}
 */
THREE.Vector4.prototype.min = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @return {THIS}
 */
THREE.Vector4.prototype.max = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} min
 * @param {THREE.Vector4} max
 * @return {THIS}
 */
THREE.Vector4.prototype.clamp = function(min, max) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} min
 * @param {number} max
 * @return {THIS}
 */
THREE.Vector4.prototype.clampScalar = function(min, max) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.floor = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.ceil = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.round = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.roundToZero = function() {};

/**
 * Inverts this vector.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.negate = function() {};

/**
 * Computes dot product of this vector and v.
 * @param {THREE.Vector4} v
 * @return {number}
 */
THREE.Vector4.prototype.dot = function(v) {};

/**
 * Computes squared length of this vector.
 * @return {number}
 */
THREE.Vector4.prototype.lengthSq = function() {};

/**
 * Computes length of this vector.
 * @return {number}
 */
THREE.Vector4.prototype.length = function() {};

/**
 * Computes the Manhattan length of this vector.
 * 
 * see {\@link http://en.wikipedia.org/wiki/Taxicab_geometry|Wikipedia: Taxicab Geometry}
 * @return {number}
 */
THREE.Vector4.prototype.manhattanLength = function() {};

/**
 * Normalizes this vector.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.normalize = function() {};

/**
 * Normalizes this vector and multiplies it by l.
 * @template THIS
 * @this {THIS}
 * @param {number} length
 * @return {THIS}
 */
THREE.Vector4.prototype.setLength = function(length) {};

/**
 * Linearly interpolate between this vector and v with alpha factor.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Vector4.prototype.lerp = function(v, alpha) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector4} v1
 * @param {THREE.Vector4} v2
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Vector4.prototype.lerpVectors = function(v1, v2, alpha) {};

/**
 * Checks for strict equality of this vector and v.
 * @param {THREE.Vector4} v
 * @return {boolean}
 */
THREE.Vector4.prototype.equals = function(v) {};

/**
 * Sets this vector's x, y, z and w value from the provided array or array-like.
 * @template THIS
 * @this {THIS}
 * @param {(!Array<number>)} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array. Default is 0.
 * @return {THIS}
 */
THREE.Vector4.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array [x, y, z, w], or copies x, y, z and w into the provided array. / Copies x, y, z and w into the provided array-like.
 * @param {(undefined|Array<number>)|(undefined|Array<Object>)=} array (optional) array to store the vector to. If this is not provided, a new array will be created. / array-like to store the vector to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array. / (optional) optional offset into the array-like.
 * @return {Array<number>|Array<Object>} The created or provided array. / The provided array-like.
 */
THREE.Vector4.prototype.toArray = function(array, offset) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.BufferAttribute} attribute
 * @param {number} index
 * @return {THIS}
 */
THREE.Vector4.prototype.fromBufferAttribute = function(attribute, index) {};

/**
 * Sets this vector's x, y, z and w from Math.random
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector4.prototype.random = function() {};
// externs from src/src/renderers/webgl/WebGLState.d.ts:

/**
 * @constructor
 * 
 */
THREE.WebGLState.WebGLColorBuffer = function() {};

/**
 * @param {boolean} colorMask
 * @return {void}
 */
THREE.WebGLState.WebGLColorBuffer.prototype.setMask = function(colorMask) {};

/**
 * @param {boolean} lock
 * @return {void}
 */
THREE.WebGLState.WebGLColorBuffer.prototype.setLocked = function(lock) {};

/**
 * @param {number} r
 * @param {number} g
 * @param {number} b
 * @param {number} a
 * @param {boolean} premultipliedAlpha
 * @return {void}
 */
THREE.WebGLState.WebGLColorBuffer.prototype.setClear = function(r, g, b, a, premultipliedAlpha) {};

/**
 * @return {void}
 */
THREE.WebGLState.WebGLColorBuffer.prototype.reset = function() {};

/**
 * @constructor
 * 
 */
THREE.WebGLState.WebGLDepthBuffer = function() {};

/**
 * @param {boolean} depthTest
 * @return {void}
 */
THREE.WebGLState.WebGLDepthBuffer.prototype.setTest = function(depthTest) {};

/**
 * @param {boolean} depthMask
 * @return {void}
 */
THREE.WebGLState.WebGLDepthBuffer.prototype.setMask = function(depthMask) {};

/**
 * @param {number} depthFunc
 * @return {void}
 */
THREE.WebGLState.WebGLDepthBuffer.prototype.setFunc = function(depthFunc) {};

/**
 * @param {boolean} lock
 * @return {void}
 */
THREE.WebGLState.WebGLDepthBuffer.prototype.setLocked = function(lock) {};

/**
 * @param {number} depth
 * @return {void}
 */
THREE.WebGLState.WebGLDepthBuffer.prototype.setClear = function(depth) {};

/**
 * @return {void}
 */
THREE.WebGLState.WebGLDepthBuffer.prototype.reset = function() {};

/**
 * @constructor
 * 
 */
THREE.WebGLState.WebGLStencilBuffer = function() {};

/**
 * @param {boolean} stencilTest
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.setTest = function(stencilTest) {};

/**
 * @param {number} stencilMask
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.setMask = function(stencilMask) {};

/**
 * @param {number} stencilFunc
 * @param {number} stencilRef
 * @param {number} stencilMask
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.setFunc = function(stencilFunc, stencilRef, stencilMask) {};

/**
 * @param {number} stencilFail
 * @param {number} stencilZFail
 * @param {number} stencilZPass
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.setOp = function(stencilFail, stencilZFail, stencilZPass) {};

/**
 * @param {boolean} lock
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.setLocked = function(lock) {};

/**
 * @param {number} stencil
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.setClear = function(stencil) {};

/**
 * @return {void}
 */
THREE.WebGLState.WebGLStencilBuffer.prototype.reset = function() {};

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {THREE.WebGLExtensions} extensions
 * @param {THREE.WebGLCapabilities} capabilities
 */
THREE.WebGLState = function(gl, extensions, capabilities) {};
/** @type {{color: THREE.WebGLState.WebGLColorBuffer, depth: THREE.WebGLState.WebGLDepthBuffer, stencil: THREE.WebGLState.WebGLStencilBuffer}} */
THREE.WebGLState.prototype.buffers;

/**
 * @return {void}
 */
THREE.WebGLState.prototype.initAttributes = function() {};

/**
 * @param {number} attribute
 * @return {void}
 */
THREE.WebGLState.prototype.enableAttribute = function(attribute) {};

/**
 * @param {number} attribute
 * @param {number} meshPerAttribute
 * @return {void}
 */
THREE.WebGLState.prototype.enableAttributeAndDivisor = function(attribute, meshPerAttribute) {};

/**
 * @return {void}
 */
THREE.WebGLState.prototype.disableUnusedAttributes = function() {};

/**
 * @param {number} index
 * @param {number} size
 * @param {number} type
 * @param {boolean} normalized
 * @param {number} stride
 * @param {number} offset
 * @return {void}
 */
THREE.WebGLState.prototype.vertexAttribPointer = function(index, size, type, normalized, stride, offset) {};

/**
 * @param {number} id
 * @return {void}
 */
THREE.WebGLState.prototype.enable = function(id) {};

/**
 * @param {number} id
 * @return {void}
 */
THREE.WebGLState.prototype.disable = function(id) {};

/**
 * @param {number} target
 * @param {(null|WebGLFramebuffer)} framebuffer
 * @return {void}
 */
THREE.WebGLState.prototype.bindFramebuffer = function(target, framebuffer) {};

/**
 * @param {(null|WebGLFramebuffer)} framebuffer
 * @return {void}
 */
THREE.WebGLState.prototype.bindXRFramebuffer = function(framebuffer) {};

/**
 * @param {number} program
 * @return {boolean}
 */
THREE.WebGLState.prototype.useProgram = function(program) {};

/**
 * @param {number} blending
 * @param {(undefined|number)=} blendEquation
 * @param {(undefined|number)=} blendSrc
 * @param {(undefined|number)=} blendDst
 * @param {(undefined|number)=} blendEquationAlpha
 * @param {(undefined|number)=} blendSrcAlpha
 * @param {(undefined|number)=} blendDstAlpha
 * @param {(undefined|boolean)=} premultiplyAlpha
 * @return {void}
 */
THREE.WebGLState.prototype.setBlending = function(blending, blendEquation, blendSrc, blendDst, blendEquationAlpha, blendSrcAlpha, blendDstAlpha, premultiplyAlpha) {};

/**
 * @param {THREE.Material} material
 * @param {boolean} frontFaceCW
 * @return {void}
 */
THREE.WebGLState.prototype.setMaterial = function(material, frontFaceCW) {};

/**
 * @param {boolean} flipSided
 * @return {void}
 */
THREE.WebGLState.prototype.setFlipSided = function(flipSided) {};

/**
 * @param {number} cullFace
 * @return {void}
 */
THREE.WebGLState.prototype.setCullFace = function(cullFace) {};

/**
 * @param {number} width
 * @return {void}
 */
THREE.WebGLState.prototype.setLineWidth = function(width) {};

/**
 * @param {boolean} polygonoffset
 * @param {(undefined|number)=} factor
 * @param {(undefined|number)=} units
 * @return {void}
 */
THREE.WebGLState.prototype.setPolygonOffset = function(polygonoffset, factor, units) {};

/**
 * @param {boolean} scissorTest
 * @return {void}
 */
THREE.WebGLState.prototype.setScissorTest = function(scissorTest) {};

/**
 * @param {number} webglSlot
 * @return {void}
 */
THREE.WebGLState.prototype.activeTexture = function(webglSlot) {};

/**
 * @param {number} webglType
 * @param {number} webglTexture
 * @return {void}
 */
THREE.WebGLState.prototype.bindTexture = function(webglType, webglTexture) {};

/**
 * @return {void}
 */
THREE.WebGLState.prototype.unbindTexture = function() {};

/**
 * @param {number} target
 * @param {number} level
 * @param {number} internalformat
 * @param {number} width
 * @param {number} height
 * @param {number} border
 * @param {ArrayBufferView} data
 * @return {void}
 */
THREE.WebGLState.prototype.compressedTexImage2D = function(target, level, internalformat, width, height, border, data) {};

/**
 * @param {number} target
 * @param {number} level
 * @param {number} internalformat
 * @param {number} width_or_format
 * @param {number} height_or_type
 * @param {number|Object} border_or_source
 * @param {number=} format
 * @param {number=} type
 * @param {(null|ArrayBufferView)=} pixels
 * @return {void}
 */
THREE.WebGLState.prototype.texImage2D = function(target, level, internalformat, width_or_format, height_or_type, border_or_source, format, type, pixels) {};

/**
 * @param {number} target
 * @param {number} level
 * @param {number} internalformat
 * @param {number} width
 * @param {number} height
 * @param {number} depth
 * @param {number} border
 * @param {number} format
 * @param {number} type
 * @param {number} pixels
 * @return {void}
 */
THREE.WebGLState.prototype.texImage3D = function(target, level, internalformat, width, height, depth, border, format, type, pixels) {};

/**
 * @param {THREE.Vector4} scissor
 * @return {void}
 */
THREE.WebGLState.prototype.scissor = function(scissor) {};

/**
 * @param {THREE.Vector4} viewport
 * @return {void}
 */
THREE.WebGLState.prototype.viewport = function(viewport) {};

/**
 * @return {void}
 */
THREE.WebGLState.prototype.reset = function() {};
// externs from src/src/renderers/webgl/WebGLProperties.d.ts:

/**
 * @constructor
 * 
 */
THREE.WebGLProperties = function() {};

/**
 * @param {number} object
 * @return {number}
 */
THREE.WebGLProperties.prototype.get = function(object) {};

/**
 * @param {number} object
 * @return {void}
 */
THREE.WebGLProperties.prototype.remove = function(object) {};

/**
 * @param {number} object
 * @param {number} key
 * @param {number} value
 * @return {number}
 */
THREE.WebGLProperties.prototype.update = function(object, key, value) {};

/**
 * @return {void}
 */
THREE.WebGLProperties.prototype.dispose = function() {};
// externs from src/src/renderers/webgl/WebGLUtils.d.ts:

/**
 * @constructor
 * 
 * @param {(!WebGLRenderingContext|WebGL2RenderingContext)} gl
 * @param {number} extensions
 * @param {number} capabilities
 */
THREE.WebGLUtils = function(gl, extensions, capabilities) {};

/**
 * @param {number} p
 * @return {void}
 */
THREE.WebGLUtils.prototype.convert = function(p) {};
// externs from src/src/renderers/webgl/WebGLTextures.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {THREE.WebGLExtensions} extensions
 * @param {THREE.WebGLState} state
 * @param {THREE.WebGLProperties} properties
 * @param {THREE.WebGLCapabilities} capabilities
 * @param {THREE.WebGLUtils} utils
 * @param {THREE.WebGLInfo} info
 */
THREE.WebGLTextures = function(gl, extensions, state, properties, capabilities, utils, info) {};

/**
 * @return {void}
 */
THREE.WebGLTextures.prototype.allocateTextureUnit = function() {};

/**
 * @return {void}
 */
THREE.WebGLTextures.prototype.resetTextureUnits = function() {};

/**
 * @param {number} texture
 * @param {number} slot
 * @return {void}
 */
THREE.WebGLTextures.prototype.setTexture2D = function(texture, slot) {};

/**
 * @param {number} texture
 * @param {number} slot
 * @return {void}
 */
THREE.WebGLTextures.prototype.setTexture2DArray = function(texture, slot) {};

/**
 * @param {number} texture
 * @param {number} slot
 * @return {void}
 */
THREE.WebGLTextures.prototype.setTexture3D = function(texture, slot) {};

/**
 * @param {number} texture
 * @param {number} slot
 * @return {void}
 */
THREE.WebGLTextures.prototype.setTextureCube = function(texture, slot) {};

/**
 * @param {number} renderTarget
 * @return {void}
 */
THREE.WebGLTextures.prototype.setupRenderTarget = function(renderTarget) {};

/**
 * @param {number} renderTarget
 * @return {void}
 */
THREE.WebGLTextures.prototype.updateRenderTargetMipmap = function(renderTarget) {};

/**
 * @param {number} renderTarget
 * @return {void}
 */
THREE.WebGLTextures.prototype.updateMultisampleRenderTarget = function(renderTarget) {};

/**
 * @param {number} texture
 * @param {number} slot
 * @return {void}
 */
THREE.WebGLTextures.prototype.safeSetTexture2D = function(texture, slot) {};

/**
 * @param {number} texture
 * @param {number} slot
 * @return {void}
 */
THREE.WebGLTextures.prototype.safeSetTextureCube = function(texture, slot) {};
// externs from src/src/renderers/webgl/WebGLUniforms.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {THREE.WebGLProgram} program
 */
THREE.WebGLUniforms = function(gl, program) {};

/**
 * @param {WebGLRenderingContext} gl
 * @param {string} name
 * @param {number} value
 * @param {THREE.WebGLTextures} textures
 * @return {void}
 */
THREE.WebGLUniforms.prototype.setValue = function(gl, name, value, textures) {};

/**
 * @param {WebGLRenderingContext} gl
 * @param {number} object
 * @param {string} name
 * @return {void}
 */
THREE.WebGLUniforms.prototype.setOptional = function(gl, object, name) {};

/**
 * @param {WebGLRenderingContext} gl
 * @param {number} seq
 * @param {Array<Object>} values
 * @param {THREE.WebGLTextures} textures
 * @return {void}
 */
THREE.WebGLUniforms.upload = function(gl, seq, values, textures) {};

/**
 * @param {number} seq
 * @param {Array<Object>} values
 * @return {Array<Object>}
 */
THREE.WebGLUniforms.seqWithValue = function(seq, values) {};
// externs from src/src/renderers/webgl/WebGLProgram.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLRenderer} renderer
 * @param {string} cacheKey
 * @param {Object} parameters
 */
THREE.WebGLProgram = function(renderer, cacheKey, parameters) {};
/** @type {string} */
THREE.WebGLProgram.prototype.name;
/** @type {number} */
THREE.WebGLProgram.prototype.id;
/** @type {string} */
THREE.WebGLProgram.prototype.cacheKey;
/** @type {number} */
THREE.WebGLProgram.prototype.usedTimes;
/** @type {number} */
THREE.WebGLProgram.prototype.program;
/** @type {WebGLShader} */
THREE.WebGLProgram.prototype.vertexShader;
/** @type {WebGLShader} */
THREE.WebGLProgram.prototype.fragmentShader;
/** @type {number} */
THREE.WebGLProgram.prototype.uniforms;
/** @type {number} */
THREE.WebGLProgram.prototype.attributes;

/**
 * @return {THREE.WebGLUniforms}
 */
THREE.WebGLProgram.prototype.getUniforms = function() {};

/**
 * @return {number}
 */
THREE.WebGLProgram.prototype.getAttributes = function() {};

/**
 * @return {void}
 */
THREE.WebGLProgram.prototype.destroy = function() {};
// externs from src/src/renderers/webgl/WebGLInfo.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 */
THREE.WebGLInfo = function(gl) {};
/** @type {boolean} */
THREE.WebGLInfo.prototype.autoReset;
/** @type {{geometries: number, textures: number}} */
THREE.WebGLInfo.prototype.memory;
/** @type {(null|Array<THREE.WebGLProgram>)} */
THREE.WebGLInfo.prototype.programs;
/** @type {{calls: number, frame: number, lines: number, points: number, triangles: number}} */
THREE.WebGLInfo.prototype.render;

/**
 * @param {number} count
 * @param {number} mode
 * @param {number} instanceCount
 * @return {void}
 */
THREE.WebGLInfo.prototype.update = function(count, mode, instanceCount) {};

/**
 * @return {void}
 */
THREE.WebGLInfo.prototype.reset = function() {};
// externs from src/src/renderers/webgl/WebGLObjects.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {number} geometries
 * @param {number} attributes
 * @param {number} info
 */
THREE.WebGLObjects = function(gl, geometries, attributes, info) {};

/**
 * @param {number} object
 * @return {number}
 */
THREE.WebGLObjects.prototype.update = function(object) {};

/**
 * @return {void}
 */
THREE.WebGLObjects.prototype.dispose = function() {};
// externs from src/src/textures/DepthTexture.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} anisotropy
 */
THREE.DepthTexture = function(width, height, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy) {};
/** @type {{width: number, height: number}} */
THREE.DepthTexture.prototype.image;
/** @type {boolean} */
THREE.DepthTexture.prototype.flipY;
/** @type {boolean} */
THREE.DepthTexture.prototype.generateMipmaps;
/** @type {boolean} */
THREE.DepthTexture.prototype.isDepthTexture;
// externs from src/src/renderers/WebGLRenderTarget.d.ts:
/**
 * @record
 * 
 */
THREE.WebGLRenderTargetOptions = function() {};
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.wrapS;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.wrapT;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.magFilter;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.minFilter;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.format;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.type;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.anisotropy;
/** @type {(undefined|boolean)} */
THREE.WebGLRenderTargetOptions.prototype.depthBuffer;
/** @type {(undefined|boolean)} */
THREE.WebGLRenderTargetOptions.prototype.stencilBuffer;
/** @type {(undefined|boolean)} */
THREE.WebGLRenderTargetOptions.prototype.generateMipmaps;
/** @type {(undefined|THREE.DepthTexture)} */
THREE.WebGLRenderTargetOptions.prototype.depthTexture;
/** @type {(undefined|number)} */
THREE.WebGLRenderTargetOptions.prototype.encoding;

/**
 * @constructor
 * 
 * @param {number} width
 * @param {number} height
 * @param {(undefined|THREE.WebGLRenderTargetOptions)=} options
 */
THREE.WebGLRenderTarget = function(width, height, options) {};
/** @type {string} */
THREE.WebGLRenderTarget.prototype.uuid;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.width;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.height;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.depth;
/** @type {THREE.Vector4} */
THREE.WebGLRenderTarget.prototype.scissor;
/** @type {boolean} */
THREE.WebGLRenderTarget.prototype.scissorTest;
/** @type {THREE.Vector4} */
THREE.WebGLRenderTarget.prototype.viewport;
/** @type {THREE.Texture} */
THREE.WebGLRenderTarget.prototype.texture;
/** @type {boolean} */
THREE.WebGLRenderTarget.prototype.depthBuffer;
/** @type {boolean} */
THREE.WebGLRenderTarget.prototype.stencilBuffer;
/** @type {THREE.DepthTexture} */
THREE.WebGLRenderTarget.prototype.depthTexture;
/** @type {boolean} */
THREE.WebGLRenderTarget.prototype.isWebGLRenderTarget;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.wrapS;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.wrapT;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.magFilter;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.minFilter;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.anisotropy;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.offset;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.repeat;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.format;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.type;
/** @type {number} */
THREE.WebGLRenderTarget.prototype.generateMipmaps;

/**
 * @param {THREE.Texture} texture
 * @return {void}
 */
THREE.WebGLRenderTarget.prototype.setTexture = function(texture) {};

/**
 * @param {number} width
 * @param {number} height
 * @param {(undefined|number)=} depth
 * @return {void}
 */
THREE.WebGLRenderTarget.prototype.setSize = function(width, height, depth) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.WebGLRenderTarget.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.WebGLRenderTarget} source
 * @return {THIS}
 */
THREE.WebGLRenderTarget.prototype.copy = function(source) {};

/**
 * @return {void}
 */
THREE.WebGLRenderTarget.prototype.dispose = function() {};
// externs from src/src/lights/LightShadow.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.Camera} camera
 */
THREE.LightShadow = function(camera) {};
/** @type {THREE.Camera} */
THREE.LightShadow.prototype.camera;
/** @type {number} */
THREE.LightShadow.prototype.bias;
/** @type {number} */
THREE.LightShadow.prototype.normalBias;
/** @type {number} */
THREE.LightShadow.prototype.radius;
/** @type {number} */
THREE.LightShadow.prototype.blurSamples;
/** @type {THREE.Vector2} */
THREE.LightShadow.prototype.mapSize;
/** @type {THREE.WebGLRenderTarget} */
THREE.LightShadow.prototype.map;
/** @type {THREE.WebGLRenderTarget} */
THREE.LightShadow.prototype.mapPass;
/** @type {THREE.Matrix4} */
THREE.LightShadow.prototype.matrix;
/** @type {boolean} */
THREE.LightShadow.prototype.autoUpdate;
/** @type {boolean} */
THREE.LightShadow.prototype.needsUpdate;

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.LightShadow} source
 * @return {THIS}
 */
THREE.LightShadow.prototype.copy = function(source) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {(undefined|boolean)=} recursive
 * @return {THIS}
 */
THREE.LightShadow.prototype.clone = function(recursive) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.LightShadow.prototype.toJSON = function(opt_key) {};

/**
 * @return {number}
 */
THREE.LightShadow.prototype.getFrustum = function() {};

/**
 * @param {THREE.Light} light
 * @param {(undefined|number)=} viewportIndex
 * @return {void}
 */
THREE.LightShadow.prototype.updateMatrices = function(light, viewportIndex) {};

/**
 * @param {number} viewportIndex
 * @return {THREE.Vector4}
 */
THREE.LightShadow.prototype.getViewport = function(viewportIndex) {};

/**
 * @return {THREE.Vector2}
 */
THREE.LightShadow.prototype.getFrameExtents = function() {};

/**
 * @return {void}
 */
THREE.LightShadow.prototype.dispose = function() {};
// externs from src/src/lights/Light.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {(undefined|string|number)=} hex
 * @param {(undefined|number)=} intensity
 */
THREE.Light = function(hex, intensity) {};
/** @type {string} */
THREE.Light.prototype.type;
/** @type {THREE.Color} */
THREE.Light.prototype.color;
/** @type {number} */
THREE.Light.prototype.intensity;
/** @type {boolean} */
THREE.Light.prototype.isLight;
/** @type {THREE.LightShadow} */
THREE.Light.prototype.shadow;
/** @type {number} */
THREE.Light.prototype.shadowCameraFov;
/** @type {number} */
THREE.Light.prototype.shadowCameraLeft;
/** @type {number} */
THREE.Light.prototype.shadowCameraRight;
/** @type {number} */
THREE.Light.prototype.shadowCameraTop;
/** @type {number} */
THREE.Light.prototype.shadowCameraBottom;
/** @type {number} */
THREE.Light.prototype.shadowCameraNear;
/** @type {number} */
THREE.Light.prototype.shadowCameraFar;
/** @type {number} */
THREE.Light.prototype.shadowBias;
/** @type {number} */
THREE.Light.prototype.shadowMapWidth;
/** @type {number} */
THREE.Light.prototype.shadowMapHeight;

/**
 * @return {void}
 */
THREE.Light.prototype.dispose = function() {};
// externs from src/src/renderers/webgl/WebGLShadowMap.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLRenderer} _renderer
 * @param {THREE.WebGLObjects} _objects
 * @param {THREE.WebGLCapabilities} _capabilities
 */
THREE.WebGLShadowMap = function(_renderer, _objects, _capabilities) {};
/** @type {boolean} */
THREE.WebGLShadowMap.prototype.enabled;
/** @type {boolean} */
THREE.WebGLShadowMap.prototype.autoUpdate;
/** @type {boolean} */
THREE.WebGLShadowMap.prototype.needsUpdate;
/** @type {number} */
THREE.WebGLShadowMap.prototype.type;
/** @type {number} */
THREE.WebGLShadowMap.prototype.cullFace;

/**
 * @param {Array<THREE.Light>} shadowsArray
 * @param {THREE.Scene} scene
 * @param {THREE.Camera} camera
 * @return {void}
 */
THREE.WebGLShadowMap.prototype.render = function(shadowsArray, scene, camera) {};
// externs from src/src/objects/Group.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 */
THREE.Group = function() {};
/** @type {string} */
THREE.Group.prototype.type;
/** @type {boolean} */
THREE.Group.prototype.isGroup;
// externs from src/src/core/BufferGeometry.d.ts:

/**
 * @extends {THREE.EventDispatcher}
 * @constructor
 * 
 * This creates a new BufferGeometry. It also sets several properties to an default value.
 */
THREE.BufferGeometry = function() {};
/** @type {number} */
THREE.BufferGeometry.MaxIndex;
/** @type {number} */
THREE.BufferGeometry.prototype.id;
/** @type {string} */
THREE.BufferGeometry.prototype.uuid;
/** @type {string} */
THREE.BufferGeometry.prototype.name;
/** @type {string} */
THREE.BufferGeometry.prototype.type;
/** @type {(null|THREE.BufferAttribute)} */
THREE.BufferGeometry.prototype.index;
/** @type {Object<string,(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)>} */
THREE.BufferGeometry.prototype.attributes;
/** @type {Object<string,!Array<(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)>>} */
THREE.BufferGeometry.prototype.morphAttributes;
/** @type {boolean} */
THREE.BufferGeometry.prototype.morphTargetsRelative;
/** @type {Array<{start: number, count: number, materialIndex: (undefined|number)}>} */
THREE.BufferGeometry.prototype.groups;
/** @type {(null|THREE.Box3)} */
THREE.BufferGeometry.prototype.boundingBox;
/** @type {(null|THREE.Sphere)} */
THREE.BufferGeometry.prototype.boundingSphere;
/** @type {{start: number, count: number}} */
THREE.BufferGeometry.prototype.drawRange;
/** @type {Object<string,Object>} */
THREE.BufferGeometry.prototype.userData;
/** @type {boolean} */
THREE.BufferGeometry.prototype.isBufferGeometry;
/** @type {number} */
THREE.BufferGeometry.prototype.drawcalls;
/** @type {number} */
THREE.BufferGeometry.prototype.offsets;

/**
 * @return {(null|THREE.BufferAttribute)}
 */
THREE.BufferGeometry.prototype.getIndex = function() {};

/**
 * @param {(null|Array<number>|THREE.BufferAttribute)} index
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.setIndex = function(index) {};

/**
 * @param {(string|Object)} name
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)} attribute
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.setAttribute = function(name, attribute) {};

/**
 * @param {(string|Object)} name
 * @return {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)}
 */
THREE.BufferGeometry.prototype.getAttribute = function(name) {};

/**
 * @param {(string|Object)} name
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.deleteAttribute = function(name) {};

/**
 * @param {(string|Object)} name
 * @return {boolean}
 */
THREE.BufferGeometry.prototype.hasAttribute = function(name) {};

/**
 * @param {number} start
 * @param {number} count
 * @param {(undefined|number)=} materialIndex
 * @return {void}
 */
THREE.BufferGeometry.prototype.addGroup = function(start, count, materialIndex) {};

/**
 * @return {void}
 */
THREE.BufferGeometry.prototype.clearGroups = function() {};

/**
 * @param {number} start
 * @param {number} count
 * @return {void}
 */
THREE.BufferGeometry.prototype.setDrawRange = function(start, count) {};

/**
 * Bakes matrix transform directly into vertex coordinates.
 * @param {THREE.Matrix4} matrix
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.applyMatrix4 = function(matrix) {};

/**
 * @param {THREE.Quaternion} q
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.applyQuaternion = function(q) {};

/**
 * @param {number} angle
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.rotateX = function(angle) {};

/**
 * @param {number} angle
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.rotateY = function(angle) {};

/**
 * @param {number} angle
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.rotateZ = function(angle) {};

/**
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.translate = function(x, y, z) {};

/**
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.scale = function(x, y, z) {};

/**
 * @param {THREE.Vector3} v
 * @return {void}
 */
THREE.BufferGeometry.prototype.lookAt = function(v) {};

/**
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.center = function() {};

/**
 * @param {(!Array<THREE.Vector3>|Array<THREE.Vector2>)} points
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.setFromPoints = function(points) {};

/**
 * Computes bounding box of the geometry, updating Geometry.boundingBox attribute.
 * Bounding boxes aren't computed by default. They need to be explicitly computed, otherwise they are null.
 * @return {void}
 */
THREE.BufferGeometry.prototype.computeBoundingBox = function() {};

/**
 * Computes bounding sphere of the geometry, updating Geometry.boundingSphere attribute.
 * Bounding spheres aren't' computed by default. They need to be explicitly computed, otherwise they are null.
 * @return {void}
 */
THREE.BufferGeometry.prototype.computeBoundingSphere = function() {};

/**
 * Computes and adds tangent attribute to this geometry.
 * @return {void}
 */
THREE.BufferGeometry.prototype.computeTangents = function() {};

/**
 * Computes vertex normals by averaging face normals.
 * @return {void}
 */
THREE.BufferGeometry.prototype.computeVertexNormals = function() {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @param {(undefined|number)=} offset
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.merge = function(geometry, offset) {};

/**
 * @return {void}
 */
THREE.BufferGeometry.prototype.normalizeNormals = function() {};

/**
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.toNonIndexed = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.BufferGeometry.prototype.toJSON = function(opt_key) {};

/**
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.BufferGeometry} source
 * @return {THIS}
 */
THREE.BufferGeometry.prototype.copy = function(source) {};

/**
 * Disposes the object from memory.
 * You need to call this when you want the bufferGeometry removed while the application is running.
 * @return {void}
 */
THREE.BufferGeometry.prototype.dispose = function() {};

/**
 * @deprecated Use {\@link BufferGeometry#setIndex .setIndex()} instead.
 * @param {number} index
 * @return {void}
 */
THREE.BufferGeometry.prototype.addIndex = function(index) {};

/**
 * @deprecated Use {\@link BufferGeometry#addGroup .addGroup()} instead.
 * @param {number} start
 * @param {number} count
 * @param {Object=} indexOffset
 * @return {void}
 */
THREE.BufferGeometry.prototype.addDrawCall = function(start, count, indexOffset) {};

/**
 * @deprecated Use {\@link BufferGeometry#clearGroups .clearGroups()} instead.
 * @return {void}
 */
THREE.BufferGeometry.prototype.clearDrawCalls = function() {};

/**
 * @deprecated Use {\@link BufferGeometry#setAttribute .setAttribute()} instead.
 * @param {string|Object} name
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)|Object} attribute_or_array
 * @param {Object=} itemSize
 * @return {THREE.BufferGeometry|Object}
 */
THREE.BufferGeometry.prototype.addAttribute = function(name, attribute_or_array, itemSize) {};

/**
 * @deprecated Use {\@link BufferGeometry#deleteAttribute .deleteAttribute()} instead.
 * @param {string} name
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometry.prototype.removeAttribute = function(name) {};
// externs from src/src/renderers/webgl/WebGLRenderLists.d.ts:
/**
 * @record
 * 
 */
THREE.WebGLRenderLists.RenderItem = function() {};
/** @type {number} */
THREE.WebGLRenderLists.RenderItem.prototype.id;
/** @type {THREE.Object3D<THREE.EventDispatcher.Event>} */
THREE.WebGLRenderLists.RenderItem.prototype.object;
/** @type {(null|THREE.BufferGeometry)} */
THREE.WebGLRenderLists.RenderItem.prototype.geometry;
/** @type {THREE.Material} */
THREE.WebGLRenderLists.RenderItem.prototype.material;
/** @type {THREE.WebGLProgram} */
THREE.WebGLRenderLists.RenderItem.prototype.program;
/** @type {number} */
THREE.WebGLRenderLists.RenderItem.prototype.groupOrder;
/** @type {number} */
THREE.WebGLRenderLists.RenderItem.prototype.renderOrder;
/** @type {number} */
THREE.WebGLRenderLists.RenderItem.prototype.z;
/** @type {(null|THREE.Group)} */
THREE.WebGLRenderLists.RenderItem.prototype.group;

/**
 * @constructor
 * 
 * @param {THREE.WebGLProperties} properties
 */
THREE.WebGLRenderLists.WebGLRenderList = function(properties) {};
/** @type {Array<THREE.WebGLRenderLists.RenderItem>} */
THREE.WebGLRenderLists.WebGLRenderList.prototype.opaque;
/** @type {Array<THREE.WebGLRenderLists.RenderItem>} */
THREE.WebGLRenderLists.WebGLRenderList.prototype.transparent;
/** @type {Array<THREE.WebGLRenderLists.RenderItem>} */
THREE.WebGLRenderLists.WebGLRenderList.prototype.transmissive;

/**
 * @return {void}
 */
THREE.WebGLRenderLists.WebGLRenderList.prototype.init = function() {};

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {(null|THREE.BufferGeometry)} geometry
 * @param {THREE.Material} material
 * @param {number} groupOrder
 * @param {number} z
 * @param {(null|THREE.Group)} group
 * @return {void}
 */
THREE.WebGLRenderLists.WebGLRenderList.prototype.push = function(object, geometry, material, groupOrder, z, group) {};

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {(null|THREE.BufferGeometry)} geometry
 * @param {THREE.Material} material
 * @param {number} groupOrder
 * @param {number} z
 * @param {(null|THREE.Group)} group
 * @return {void}
 */
THREE.WebGLRenderLists.WebGLRenderList.prototype.unshift = function(object, geometry, material, groupOrder, z, group) {};

/**
 * @param {function(Object, Object): number} opaqueSort
 * @param {function(Object, Object): number} transparentSort
 * @return {void}
 */
THREE.WebGLRenderLists.WebGLRenderList.prototype.sort = function(opaqueSort, transparentSort) {};

/**
 * @return {void}
 */
THREE.WebGLRenderLists.WebGLRenderList.prototype.finish = function() {};

/**
 * @constructor
 * 
 * @param {THREE.WebGLProperties} properties
 */
THREE.WebGLRenderLists = function(properties) {};

/**
 * @return {void}
 */
THREE.WebGLRenderLists.prototype.dispose = function() {};

/**
 * @param {THREE.Scene} scene
 * @param {number} renderCallDepth
 * @return {THREE.WebGLRenderLists.WebGLRenderList}
 */
THREE.WebGLRenderLists.prototype.get = function(scene, renderCallDepth) {};
// externs from src/src/renderers/WebGLMultipleRenderTargets.d.ts:

/**
 * @constructor
 * 
 * @param {number} width
 * @param {number} height
 * @param {number} count
 */
THREE.WebGLMultipleRenderTargets = function(width, height, count) {};
/** @type {Array<THREE.Texture>} */
THREE.WebGLMultipleRenderTargets.prototype.texture;
/** @type {boolean} */
THREE.WebGLMultipleRenderTargets.prototype.isWebGLMultipleRenderTargets;

/**
 * @template THIS
 * @this {THIS}
 * @param {number} width
 * @param {number} height
 * @param {(undefined|number)=} depth
 * @return {THIS}
 */
THREE.WebGLMultipleRenderTargets.prototype.setSize = function(width, height, depth) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.WebGLMultipleRenderTargets} source
 * @return {THIS}
 */
THREE.WebGLMultipleRenderTargets.prototype.copy = function(source) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.WebGLMultipleRenderTargets.prototype.clone = function() {};

/**
 * @return {void}
 */
THREE.WebGLMultipleRenderTargets.prototype.dispose = function() {};

/**
 * @param {THREE.Texture} texture
 * @return {void}
 */
THREE.WebGLMultipleRenderTargets.prototype.setTexture = function(texture) {};
// externs from src/src/renderers/webxr/WebXR.d.ts:
/** @constructor */
THREE.WebXR = function() {};

// externs from src/src/renderers/webxr/WebXRManager.d.ts:

/**
 * @constructor
 * 
 * @param {number} renderer
 * @param {WebGLRenderingContext} gl
 */
THREE.WebXRManager = function(renderer, gl) {};
/** @type {boolean} */
THREE.WebXRManager.prototype.enabled;
/** @type {boolean} */
THREE.WebXRManager.prototype.isPresenting;

/**
 * @param {number} index
 * @return {THREE.Group}
 */
THREE.WebXRManager.prototype.getController = function(index) {};

/**
 * @param {number} index
 * @return {THREE.Group}
 */
THREE.WebXRManager.prototype.getControllerGrip = function(index) {};

/**
 * @param {number} index
 * @return {THREE.Group}
 */
THREE.WebXRManager.prototype.getHand = function(index) {};

/**
 * @param {number} value
 * @return {void}
 */
THREE.WebXRManager.prototype.setFramebufferScaleFactor = function(value) {};

/**
 * @param {string} value
 * @return {void}
 */
THREE.WebXRManager.prototype.setReferenceSpaceType = function(value) {};

/**
 * @return {(null|XRReferenceSpace)}
 */
THREE.WebXRManager.prototype.getReferenceSpace = function() {};

/**
 * @return {(null|XRSession)}
 */
THREE.WebXRManager.prototype.getSession = function() {};

/**
 * @param {XRSession} value
 * @return {Promise<void>}
 */
THREE.WebXRManager.prototype.setSession = function(value) {};

/**
 * @param {THREE.Camera} camera
 * @return {THREE.Camera}
 */
THREE.WebXRManager.prototype.getCamera = function(camera) {};

/**
 * @param {function(number, XRFrame): void} callback
 * @return {void}
 */
THREE.WebXRManager.prototype.setAnimationLoop = function(callback) {};

/**
 * @return {(undefined|number)}
 */
THREE.WebXRManager.prototype.getFoveation = function() {};

/**
 * @param {number} foveation
 * @return {void}
 */
THREE.WebXRManager.prototype.setFoveation = function(foveation) {};

/**
 * @return {void}
 */
THREE.WebXRManager.prototype.dispose = function() {};
// externs from src/src/textures/DataTexture3D.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {(!ArrayBufferView|ArrayBuffer)} data
 * @param {number} width
 * @param {number} height
 * @param {number} depth
 */
THREE.DataTexture3D = function(data, width, height, depth) {};
/** @type {number} */
THREE.DataTexture3D.prototype.magFilter;
/** @type {number} */
THREE.DataTexture3D.prototype.minFilter;
/** @type {boolean} */
THREE.DataTexture3D.prototype.wrapR;
/** @type {boolean} */
THREE.DataTexture3D.prototype.flipY;
/** @type {boolean} */
THREE.DataTexture3D.prototype.generateMipmaps;
/** @type {boolean} */
THREE.DataTexture3D.prototype.isDataTexture3D;
// externs from src/src/textures/DataTexture2DArray.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {(undefined|ArrayBufferView|ArrayBuffer)=} data
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} depth
 */
THREE.DataTexture2DArray = function(data, width, height, depth) {};
/** @type {number} */
THREE.DataTexture2DArray.prototype.magFilter;
/** @type {number} */
THREE.DataTexture2DArray.prototype.minFilter;
/** @type {boolean} */
THREE.DataTexture2DArray.prototype.wrapR;
/** @type {boolean} */
THREE.DataTexture2DArray.prototype.flipY;
/** @type {boolean} */
THREE.DataTexture2DArray.prototype.generateMipmaps;
/** @type {boolean} */
THREE.DataTexture2DArray.prototype.isDataTexture2DArray;
// externs from src/src/renderers/WebGLRenderer.d.ts:
/**
 * @record
 * 
 */
THREE.WebGLRenderer.Renderer = function() {};
/** @type {HTMLCanvasElement} */
THREE.WebGLRenderer.Renderer.prototype.domElement;

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} scene
 * @param {THREE.Camera} camera
 * @return {void}
 */
THREE.WebGLRenderer.Renderer.prototype.render = function(scene, camera) {};

/**
 * @param {number} width
 * @param {number} height
 * @param {(undefined|boolean)=} updateStyle
 * @return {void}
 */
THREE.WebGLRenderer.Renderer.prototype.setSize = function(width, height, updateStyle) {};
/**
 * @record
 * 
 */
THREE.WebGLRenderer.OffscreenCanvas = function() {};
/**
 * @record
 * 
 */
THREE.WebGLRendererParameters = function() {};
/** @type {(undefined|HTMLCanvasElement|THREE.WebGLRenderer.OffscreenCanvas)} */
THREE.WebGLRendererParameters.prototype.canvas;
/** @type {(undefined|WebGLRenderingContext)} */
THREE.WebGLRendererParameters.prototype.context;
/** @type {(undefined|string)} */
THREE.WebGLRendererParameters.prototype.precision;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.alpha;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.premultipliedAlpha;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.antialias;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.stencil;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.preserveDrawingBuffer;
/** @type {(undefined|string)} */
THREE.WebGLRendererParameters.prototype.powerPreference;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.depth;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.logarithmicDepthBuffer;
/** @type {(undefined|boolean)} */
THREE.WebGLRendererParameters.prototype.failIfMajorPerformanceCaveat;
/**
 * @record
 * 
 */
THREE.WebGLRenderer.WebGLDebug = function() {};
/** @type {boolean} */
THREE.WebGLRenderer.WebGLDebug.prototype.checkShaderErrors;

/**
 * @implements {THREE.WebGLRenderer.Renderer}
 * @constructor
 * 
 * parameters is an optional object with properties defining the renderer's behaviour.
 * The constructor also accepts no parameters at all.
 * In all cases, it will assume sane defaults when parameters are missing.
 * @param {(undefined|THREE.WebGLRendererParameters)=} parameters
 */
THREE.WebGLRenderer = function(parameters) {};
/** @type {HTMLCanvasElement} */
THREE.WebGLRenderer.prototype.domElement;
/** @type {WebGLRenderingContext} */
THREE.WebGLRenderer.prototype.context;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.autoClear;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.autoClearColor;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.autoClearDepth;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.autoClearStencil;
/** @type {THREE.WebGLRenderer.WebGLDebug} */
THREE.WebGLRenderer.prototype.debug;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.sortObjects;
/** @type {Array<Object>} */
THREE.WebGLRenderer.prototype.clippingPlanes;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.localClippingEnabled;
/** @type {THREE.WebGLExtensions} */
THREE.WebGLRenderer.prototype.extensions;
/** @type {number} */
THREE.WebGLRenderer.prototype.outputEncoding;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.physicallyCorrectLights;
/** @type {number} */
THREE.WebGLRenderer.prototype.toneMapping;
/** @type {number} */
THREE.WebGLRenderer.prototype.toneMappingExposure;
/** @type {THREE.WebGLInfo} */
THREE.WebGLRenderer.prototype.info;
/** @type {THREE.WebGLShadowMap} */
THREE.WebGLRenderer.prototype.shadowMap;
/** @type {number} */
THREE.WebGLRenderer.prototype.pixelRatio;
/** @type {THREE.WebGLCapabilities} */
THREE.WebGLRenderer.prototype.capabilities;
/** @type {THREE.WebGLProperties} */
THREE.WebGLRenderer.prototype.properties;
/** @type {THREE.WebGLRenderLists} */
THREE.WebGLRenderer.prototype.renderLists;
/** @type {THREE.WebGLState} */
THREE.WebGLRenderer.prototype.state;
/** @type {THREE.WebXRManager} */
THREE.WebGLRenderer.prototype.xr;
/** @type {number} */
THREE.WebGLRenderer.prototype.gammaFactor;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.vr;
/** @type {boolean} */
THREE.WebGLRenderer.prototype.shadowMapEnabled;
/** @type {THREE.ShadowMapType} */
THREE.WebGLRenderer.prototype.shadowMapType;
/** @type {number} */
THREE.WebGLRenderer.prototype.shadowMapCullFace;

/**
 * Return the WebGL context.
 * @return {WebGLRenderingContext}
 */
THREE.WebGLRenderer.prototype.getContext = function() {};

/**
 * @return {number}
 */
THREE.WebGLRenderer.prototype.getContextAttributes = function() {};

/**
 * @return {void}
 */
THREE.WebGLRenderer.prototype.forceContextLoss = function() {};

/**
 * @return {void}
 */
THREE.WebGLRenderer.prototype.forceContextRestore = function() {};

/**
 * @deprecated Use {\@link WebGLCapabilities#getMaxAnisotropy .capabilities.getMaxAnisotropy()} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.getMaxAnisotropy = function() {};

/**
 * @deprecated Use {\@link WebGLCapabilities#precision .capabilities.precision} instead.
 * @return {string}
 */
THREE.WebGLRenderer.prototype.getPrecision = function() {};

/**
 * @return {number}
 */
THREE.WebGLRenderer.prototype.getPixelRatio = function() {};

/**
 * @param {number} value
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setPixelRatio = function(value) {};

/**
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.WebGLRenderer.prototype.getDrawingBufferSize = function(target) {};

/**
 * @param {number} width
 * @param {number} height
 * @param {number} pixelRatio
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setDrawingBufferSize = function(width, height, pixelRatio) {};

/**
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.WebGLRenderer.prototype.getSize = function(target) {};

/**
 * Resizes the output canvas to (width, height), and also sets the viewport to fit that size, starting in (0, 0).
 * @param {number} width
 * @param {number} height
 * @param {(undefined|boolean)=} updateStyle
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setSize = function(width, height, updateStyle) {};

/**
 * @param {THREE.Vector4} target
 * @return {THREE.Vector4}
 */
THREE.WebGLRenderer.prototype.getCurrentViewport = function(target) {};

/**
 * Copies the viewport into target.
 * @param {THREE.Vector4} target
 * @return {THREE.Vector4}
 */
THREE.WebGLRenderer.prototype.getViewport = function(target) {};

/**
 * Sets the viewport to render from (x, y) to (x + width, y + height).
 * (x, y) is the lower-left corner of the region.
 * @param {(number|THREE.Vector4)} x
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setViewport = function(x, y, width, height) {};

/**
 * Copies the scissor area into target.
 * @param {THREE.Vector4} target
 * @return {THREE.Vector4}
 */
THREE.WebGLRenderer.prototype.getScissor = function(target) {};

/**
 * Sets the scissor area from (x, y) to (x + width, y + height).
 * @param {(number|THREE.Vector4)} x
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setScissor = function(x, y, width, height) {};

/**
 * Returns true if scissor test is enabled; returns false otherwise.
 * @return {boolean}
 */
THREE.WebGLRenderer.prototype.getScissorTest = function() {};

/**
 * Enable the scissor test. When this is enabled, only the pixels within the defined scissor area will be affected by further renderer actions.
 * @param {boolean} enable
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setScissorTest = function(enable) {};

/**
 * Sets the custom opaque sort function for the WebGLRenderLists. Pass null to use the default painterSortStable function.
 * @param {function(Object, Object): number} method
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setOpaqueSort = function(method) {};

/**
 * Sets the custom transparent sort function for the WebGLRenderLists. Pass null to use the default reversePainterSortStable function.
 * @param {function(Object, Object): number} method
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setTransparentSort = function(method) {};

/**
 * Returns a THREE.Color instance with the current clear color.
 * @param {THREE.Color} target
 * @return {THREE.Color}
 */
THREE.WebGLRenderer.prototype.getClearColor = function(target) {};

/**
 * Sets the clear color, using color for the color and alpha for the opacity.
 * @param {(string|number|THREE.Color)} color
 * @param {(undefined|number)=} alpha
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setClearColor = function(color, alpha) {};

/**
 * Returns a float with the current clear alpha. Ranges from 0 to 1.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.getClearAlpha = function() {};

/**
 * @param {number} alpha
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setClearAlpha = function(alpha) {};

/**
 * Tells the renderer to clear its color, depth or stencil drawing buffer(s).
 * Arguments default to true
 * @param {(undefined|boolean)=} color
 * @param {(undefined|boolean)=} depth
 * @param {(undefined|boolean)=} stencil
 * @return {void}
 */
THREE.WebGLRenderer.prototype.clear = function(color, depth, stencil) {};

/**
 * @return {void}
 */
THREE.WebGLRenderer.prototype.clearColor = function() {};

/**
 * @return {void}
 */
THREE.WebGLRenderer.prototype.clearDepth = function() {};

/**
 * @return {void}
 */
THREE.WebGLRenderer.prototype.clearStencil = function() {};

/**
 * @param {THREE.WebGLRenderTarget} renderTarget
 * @param {boolean} color
 * @param {boolean} depth
 * @param {boolean} stencil
 * @return {void}
 */
THREE.WebGLRenderer.prototype.clearTarget = function(renderTarget, color, depth, stencil) {};

/**
 * @deprecated Use {\@link WebGLState#reset .state.reset()} instead.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.resetGLState = function() {};

/**
 * @return {void}
 */
THREE.WebGLRenderer.prototype.dispose = function() {};

/**
 * @param {THREE.Camera} camera
 * @param {THREE.Scene} scene
 * @param {THREE.BufferGeometry} geometry
 * @param {THREE.Material} material
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {number} geometryGroup
 * @return {void}
 */
THREE.WebGLRenderer.prototype.renderBufferDirect = function(camera, scene, geometry, material, object, geometryGroup) {};

/**
 * A build in function that can be used instead of requestAnimationFrame. For WebXR projects this function must be used.
 * @param {(null|function(number, (undefined|XRFrame)=): void)} callback The function will be called every available frame. If `null` is passed it will stop any already ongoing animation.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setAnimationLoop = function(callback) {};

/**
 * @deprecated Use {\@link WebGLRenderer#setAnimationLoop .setAnimationLoop()} instead.
 * @param {function(): void} callback
 * @return {void}
 */
THREE.WebGLRenderer.prototype.animate = function(callback) {};

/**
 * Compiles all materials in the scene with the camera. This is useful to precompile shaders before the first rendering.
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} scene
 * @param {THREE.Camera} camera
 * @return {void}
 */
THREE.WebGLRenderer.prototype.compile = function(scene, camera) {};

/**
 * Render a scene or an object using a camera.
 * The render is done to a previously specified {\@link WebGLRenderTarget#renderTarget .renderTarget} set by calling
 * {\@link WebGLRenderer#setRenderTarget .setRenderTarget} or to the canvas as usual.
 * 
 * By default render buffers are cleared before rendering but you can prevent this by setting the property
 * {\@link WebGLRenderer#autoClear autoClear} to false. If you want to prevent only certain buffers being cleared
 * you can set either the {\@link WebGLRenderer#autoClearColor autoClearColor},
 * {\@link WebGLRenderer#autoClearStencil autoClearStencil} or {\@link WebGLRenderer#autoClearDepth autoClearDepth}
 * properties to false. To forcibly clear one ore more buffers call {\@link WebGLRenderer#clear .clear}.
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} scene
 * @param {THREE.Camera} camera
 * @return {void}
 */
THREE.WebGLRenderer.prototype.render = function(scene, camera) {};

/**
 * Returns the current active cube face.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.getActiveCubeFace = function() {};

/**
 * Returns the current active mipmap level.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.getActiveMipmapLevel = function() {};

/**
 * Returns the current render target. If no render target is set, null is returned.
 * @return {(null|THREE.WebGLRenderTarget)}
 */
THREE.WebGLRenderer.prototype.getRenderTarget = function() {};

/**
 * @deprecated Use {\@link WebGLRenderer#getRenderTarget .getRenderTarget()} instead.
 * @return {(null|THREE.WebGLRenderTarget)}
 */
THREE.WebGLRenderer.prototype.getCurrentRenderTarget = function() {};

/**
 * Sets the active render target.
 * 
 * @param {(null|THREE.WebGLRenderTarget|THREE.WebGLMultipleRenderTargets)} renderTarget The {\@link WebGLRenderTarget renderTarget} that needs to be activated. When `null` is given, the canvas is set as the active render target instead.
 * @param {(undefined|number)=} activeCubeFace Specifies the active cube side (PX 0, NX 1, PY 2, NY 3, PZ 4, NZ 5) of {\@link WebGLCubeRenderTarget}.
 * @param {(undefined|number)=} activeMipmapLevel Specifies the active mipmap level.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.setRenderTarget = function(renderTarget, activeCubeFace, activeMipmapLevel) {};

/**
 * @param {(!THREE.WebGLRenderTarget|THREE.WebGLMultipleRenderTargets)} renderTarget
 * @param {number} x
 * @param {number} y
 * @param {number} width
 * @param {number} height
 * @param {number} buffer
 * @param {(undefined|number)=} activeCubeFaceIndex
 * @return {void}
 */
THREE.WebGLRenderer.prototype.readRenderTargetPixels = function(renderTarget, x, y, width, height, buffer, activeCubeFaceIndex) {};

/**
 * Copies a region of the currently bound framebuffer into the selected mipmap level of the selected texture.
 * This region is defined by the size of the destination texture's mip level, offset by the input position.
 * 
 * @param {THREE.Vector2} position Specifies the pixel offset from which to copy out of the framebuffer.
 * @param {THREE.Texture} texture Specifies the destination texture.
 * @param {(undefined|number)=} level Specifies the destination mipmap level of the texture.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.copyFramebufferToTexture = function(position, texture, level) {};

/**
 * Copies srcTexture to the specified level of dstTexture, offset by the input position.
 * 
 * @param {THREE.Vector2} position Specifies the pixel offset into the dstTexture where the copy will occur.
 * @param {THREE.Texture} srcTexture Specifies the source texture.
 * @param {THREE.Texture} dstTexture Specifies the destination texture.
 * @param {(undefined|number)=} level Specifies the destination mipmap level of the texture.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.copyTextureToTexture = function(position, srcTexture, dstTexture, level) {};

/**
 * Copies the pixels of a texture in the bounds sourceBox in the desination texture starting from the given position.
 * @param {THREE.Box3} sourceBox Specifies the bounds
 * @param {THREE.Vector3} position Specifies the pixel offset into the dstTexture where the copy will occur.
 * @param {THREE.Texture} srcTexture Specifies the source texture.
 * @param {(!THREE.DataTexture3D|THREE.DataTexture2DArray)} dstTexture Specifies the destination texture.
 * @param {(undefined|number)=} level Specifies the destination mipmap level of the texture.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.copyTextureToTexture3D = function(sourceBox, position, srcTexture, dstTexture, level) {};

/**
 * Initializes the given texture. Can be used to preload a texture rather than waiting until first render (which can cause noticeable lags due to decode and GPU upload overhead).
 * 
 * @param {THREE.Texture} texture The texture to Initialize.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.initTexture = function(texture) {};

/**
 * Can be used to reset the internal WebGL state.
 * @return {void}
 */
THREE.WebGLRenderer.prototype.resetState = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'OES_texture_float' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsFloatTextures = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'OES_texture_half_float' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsHalfFloatTextures = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'OES_standard_derivatives' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsStandardDerivatives = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'WEBGL_compressed_texture_s3tc' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsCompressedTextureS3TC = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'WEBGL_compressed_texture_pvrtc' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsCompressedTexturePVRTC = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'EXT_blend_minmax' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsBlendMinMax = function() {};

/**
 * @deprecated Use {\@link WebGLCapabilities#vertexTextures .capabilities.vertexTextures} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsVertexTextures = function() {};

/**
 * @deprecated Use {\@link WebGLExtensions#get .extensions.get( 'ANGLE_instanced_arrays' )} instead.
 * @return {number}
 */
THREE.WebGLRenderer.prototype.supportsInstancedArrays = function() {};

/**
 * @deprecated Use {\@link WebGLRenderer#setScissorTest .setScissorTest()} instead.
 * @param {number} boolean
 * @return {number}
 */
THREE.WebGLRenderer.prototype.enableScissorTest = function(boolean) {};
// externs from src/src/math/Ray.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} origin
 * @param {(undefined|THREE.Vector3)=} direction
 */
THREE.Ray = function(origin, direction) {};
/** @type {THREE.Vector3} */
THREE.Ray.prototype.origin;
/** @type {THREE.Vector3} */
THREE.Ray.prototype.direction;

/**
 * @param {THREE.Vector3} origin
 * @param {THREE.Vector3} direction
 * @return {THREE.Ray}
 */
THREE.Ray.prototype.set = function(origin, direction) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Ray.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Ray} ray
 * @return {THIS}
 */
THREE.Ray.prototype.copy = function(ray) {};

/**
 * @param {number} t
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Ray.prototype.at = function(t, target) {};

/**
 * @param {THREE.Vector3} v
 * @return {THREE.Ray}
 */
THREE.Ray.prototype.lookAt = function(v) {};

/**
 * @param {number} t
 * @return {THREE.Ray}
 */
THREE.Ray.prototype.recast = function(t) {};

/**
 * @param {THREE.Vector3} point
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Ray.prototype.closestPointToPoint = function(point, target) {};

/**
 * @param {THREE.Vector3} point
 * @return {number}
 */
THREE.Ray.prototype.distanceToPoint = function(point) {};

/**
 * @param {THREE.Vector3} point
 * @return {number}
 */
THREE.Ray.prototype.distanceSqToPoint = function(point) {};

/**
 * @param {THREE.Vector3} v0
 * @param {THREE.Vector3} v1
 * @param {(undefined|THREE.Vector3)=} optionalPointOnRay
 * @param {(undefined|THREE.Vector3)=} optionalPointOnSegment
 * @return {number}
 */
THREE.Ray.prototype.distanceSqToSegment = function(v0, v1, optionalPointOnRay, optionalPointOnSegment) {};

/**
 * @param {THREE.Sphere} sphere
 * @param {THREE.Vector3} target
 * @return {(null|THREE.Vector3)}
 */
THREE.Ray.prototype.intersectSphere = function(sphere, target) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {boolean}
 */
THREE.Ray.prototype.intersectsSphere = function(sphere) {};

/**
 * @param {THREE.Plane} plane
 * @return {number}
 */
THREE.Ray.prototype.distanceToPlane = function(plane) {};

/**
 * @param {THREE.Plane} plane
 * @param {THREE.Vector3} target
 * @return {(null|THREE.Vector3)}
 */
THREE.Ray.prototype.intersectPlane = function(plane, target) {};

/**
 * @param {THREE.Plane} plane
 * @return {boolean}
 */
THREE.Ray.prototype.intersectsPlane = function(plane) {};

/**
 * @param {THREE.Box3} box
 * @param {THREE.Vector3} target
 * @return {(null|THREE.Vector3)}
 */
THREE.Ray.prototype.intersectBox = function(box, target) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Ray.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @param {THREE.Vector3} c
 * @param {boolean} backfaceCulling
 * @param {THREE.Vector3} target
 * @return {(null|THREE.Vector3)}
 */
THREE.Ray.prototype.intersectTriangle = function(a, b, c, backfaceCulling, target) {};

/**
 * @param {THREE.Matrix4} matrix4
 * @return {THREE.Ray}
 */
THREE.Ray.prototype.applyMatrix4 = function(matrix4) {};

/**
 * @param {THREE.Ray} ray
 * @return {boolean}
 */
THREE.Ray.prototype.equals = function(ray) {};

/**
 * @deprecated Use {\@link Ray#intersectsBox .intersectsBox()} instead.
 * @param {number} b
 * @return {number}
 */
THREE.Ray.prototype.isIntersectionBox = function(b) {};

/**
 * @deprecated Use {\@link Ray#intersectsPlane .intersectsPlane()} instead.
 * @param {number} p
 * @return {number}
 */
THREE.Ray.prototype.isIntersectionPlane = function(p) {};

/**
 * @deprecated Use {\@link Ray#intersectsSphere .intersectsSphere()} instead.
 * @param {number} s
 * @return {number}
 */
THREE.Ray.prototype.isIntersectionSphere = function(s) {};
// externs from src/src/core/Raycaster.d.ts:
/**
 * @record
 * 
 */
THREE.Raycaster.Face = function() {};
/** @type {number} */
THREE.Raycaster.Face.prototype.a;
/** @type {number} */
THREE.Raycaster.Face.prototype.b;
/** @type {number} */
THREE.Raycaster.Face.prototype.c;
/** @type {THREE.Vector3} */
THREE.Raycaster.Face.prototype.normal;
/** @type {number} */
THREE.Raycaster.Face.prototype.materialIndex;
/**
 * @template TIntersected
 * @record
 * 
 */
THREE.Raycaster.Intersection = function() {};
/** @type {number} */
THREE.Raycaster.Intersection.prototype.distance;
/** @type {(undefined|number)} */
THREE.Raycaster.Intersection.prototype.distanceToRay;
/** @type {THREE.Vector3} */
THREE.Raycaster.Intersection.prototype.point;
/** @type {(undefined|number)} */
THREE.Raycaster.Intersection.prototype.index;
/** @type {(undefined|null|THREE.Raycaster.Face)} */
THREE.Raycaster.Intersection.prototype.face;
/** @type {(undefined|number)} */
THREE.Raycaster.Intersection.prototype.faceIndex;
/** @type {TIntersected} */
THREE.Raycaster.Intersection.prototype.object;
/** @type {(undefined|THREE.Vector2)} */
THREE.Raycaster.Intersection.prototype.uv;
/** @type {(undefined|number)} */
THREE.Raycaster.Intersection.prototype.instanceId;
/**
 * @record
 * 
 */
THREE.RaycasterParameters = function() {};
/** @type {Object|undefined} */
THREE.RaycasterParameters.prototype.Mesh;
/** @type {(undefined|{threshold: number})} */
THREE.RaycasterParameters.prototype.Line;
/** @type {Object|undefined} */
THREE.RaycasterParameters.prototype.LOD;
/** @type {(undefined|{threshold: number})} */
THREE.RaycasterParameters.prototype.Points;
/** @type {Object|undefined} */
THREE.RaycasterParameters.prototype.Sprite;

/**
 * @constructor
 * 
 * This creates a new raycaster object.
 * @param {(undefined|THREE.Vector3)=} origin The origin vector where the ray casts from.
 * @param {(undefined|THREE.Vector3)=} direction The direction vector that gives direction to the ray. Should be normalized.
 * @param {(undefined|number)=} near All results returned are further away than near. Near can't be negative. Default value is 0.
 * @param {(undefined|number)=} far All results returned are closer then far. Far can't be lower then near . Default value is Infinity.
 */
THREE.Raycaster = function(origin, direction, near, far) {};
/** @type {THREE.Ray} */
THREE.Raycaster.prototype.ray;
/** @type {number} */
THREE.Raycaster.prototype.near;
/** @type {number} */
THREE.Raycaster.prototype.far;
/** @type {THREE.Camera} */
THREE.Raycaster.prototype.camera;
/** @type {THREE.Layers} */
THREE.Raycaster.prototype.layers;
/** @type {THREE.RaycasterParameters} */
THREE.Raycaster.prototype.params;

/**
 * Updates the ray with a new origin and direction.
 * @param {THREE.Vector3} origin The origin vector where the ray casts from.
 * @param {THREE.Vector3} direction The normalized direction vector that gives direction to the ray.
 * @return {void}
 */
THREE.Raycaster.prototype.set = function(origin, direction) {};

/**
 * Updates the ray with a new origin and direction.
 * @param {THREE.Vector2} coords 2D coordinates of the mouse, in normalized device coordinates (NDC)---X and Y components should be between -1 and 1.
 * @param {THREE.Camera} camera camera from which the ray should originate
 * @return {void}
 */
THREE.Raycaster.prototype.setFromCamera = function(coords, camera) {};

/**
 * Checks all intersection between the ray and the object with or without the descendants. Intersections are returned sorted by distance, closest first.
 * @template TIntersected
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object The object to check for intersection with the ray.
 * @param {(undefined|boolean)=} recursive If true, it also checks all descendants. Otherwise it only checks intersecton with the object. Default is false.
 * @param {(undefined|Array<THREE.Raycaster.Intersection<TIntersected>>)=} optionalTarget (optional) target to set the result. Otherwise a new Array is instantiated. If set, you must clear this array prior to each call (i.e., array.length = 0;).
 * @return {Array<THREE.Raycaster.Intersection<TIntersected>>}
 */
THREE.Raycaster.prototype.intersectObject = function(object, recursive, optionalTarget) {};

/**
 * Checks all intersection between the ray and the objects with or without the descendants.
 * Intersections are returned sorted by distance, closest first.
 * Intersections are of the same form as those returned by .intersectObject.
 * @template TIntersected
 * @param {Array<THREE.Object3D<THREE.EventDispatcher.Event>>} objects The objects to check for intersection with the ray.
 * @param {(undefined|boolean)=} recursive If true, it also checks all descendants of the objects. Otherwise it only checks intersecton with the objects. Default is false.
 * @param {(undefined|Array<THREE.Raycaster.Intersection<TIntersected>>)=} optionalTarget (optional) target to set the result. Otherwise a new Array is instantiated. If set, you must clear this array prior to each call (i.e., array.length = 0;).
 * @return {Array<THREE.Raycaster.Intersection<TIntersected>>}
 */
THREE.Raycaster.prototype.intersectObjects = function(objects, recursive, optionalTarget) {};
// externs from src/src/math/Interpolant.d.ts:

/**
 * @constructor
 * 
 * @param {number} parameterPositions
 * @param {number} sampleValues
 * @param {number} sampleSize
 * @param {Object=} resultBuffer
 */
THREE.Interpolant = function(parameterPositions, sampleValues, sampleSize, resultBuffer) {};
/** @type {number} */
THREE.Interpolant.prototype.parameterPositions;
/** @type {number} */
THREE.Interpolant.prototype.sampleValues;
/** @type {number} */
THREE.Interpolant.prototype.valueSize;
/** @type {number} */
THREE.Interpolant.prototype.resultBuffer;

/**
 * @param {number} time
 * @return {number}
 */
THREE.Interpolant.prototype.evaluate = function(time) {};
// externs from src/src/math/interpolants/DiscreteInterpolant.d.ts:

/**
 * @constructor
 * 
 * @param {number} parameterPositions
 * @param {number} samplesValues
 * @param {number} sampleSize
 * @param {Object=} resultBuffer
 */
THREE.DiscreteInterpolant = function(parameterPositions, samplesValues, sampleSize, resultBuffer) {};

/**
 * @param {number} i1
 * @param {number} t0
 * @param {number} t
 * @param {number} t1
 * @return {number}
 */
THREE.DiscreteInterpolant.prototype.interpolate_ = function(i1, t0, t, t1) {};
// externs from src/src/math/interpolants/LinearInterpolant.d.ts:

/**
 * @constructor
 * 
 * @param {number} parameterPositions
 * @param {number} samplesValues
 * @param {number} sampleSize
 * @param {Object=} resultBuffer
 */
THREE.LinearInterpolant = function(parameterPositions, samplesValues, sampleSize, resultBuffer) {};

/**
 * @param {number} i1
 * @param {number} t0
 * @param {number} t
 * @param {number} t1
 * @return {number}
 */
THREE.LinearInterpolant.prototype.interpolate_ = function(i1, t0, t, t1) {};
// externs from src/src/math/interpolants/CubicInterpolant.d.ts:

/**
 * @constructor
 * 
 * @param {number} parameterPositions
 * @param {number} samplesValues
 * @param {number} sampleSize
 * @param {Object=} resultBuffer
 */
THREE.CubicInterpolant = function(parameterPositions, samplesValues, sampleSize, resultBuffer) {};

/**
 * @param {number} i1
 * @param {number} t0
 * @param {number} t
 * @param {number} t1
 * @return {number}
 */
THREE.CubicInterpolant.prototype.interpolate_ = function(i1, t0, t, t1) {};
// externs from src/src/animation/KeyframeTrack.d.ts:

/**
 * @constructor
 * 
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {(undefined|number)=} interpolation
 */
THREE.KeyframeTrack = function(name, times, values, interpolation) {};
/** @type {string} */
THREE.KeyframeTrack.prototype.name;
/** @type {Float32Array} */
THREE.KeyframeTrack.prototype.times;
/** @type {Float32Array} */
THREE.KeyframeTrack.prototype.values;
/** @type {string} */
THREE.KeyframeTrack.prototype.ValueTypeName;
/** @type {Float32Array} */
THREE.KeyframeTrack.prototype.TimeBufferType;
/** @type {Float32Array} */
THREE.KeyframeTrack.prototype.ValueBufferType;
/** @type {number} */
THREE.KeyframeTrack.prototype.DefaultInterpolation;

/**
 * @param {number} result
 * @return {THREE.DiscreteInterpolant}
 */
THREE.KeyframeTrack.prototype.InterpolantFactoryMethodDiscrete = function(result) {};

/**
 * @param {number} result
 * @return {THREE.LinearInterpolant}
 */
THREE.KeyframeTrack.prototype.InterpolantFactoryMethodLinear = function(result) {};

/**
 * @param {number} result
 * @return {THREE.CubicInterpolant}
 */
THREE.KeyframeTrack.prototype.InterpolantFactoryMethodSmooth = function(result) {};

/**
 * @param {number} interpolation
 * @return {THREE.KeyframeTrack}
 */
THREE.KeyframeTrack.prototype.setInterpolation = function(interpolation) {};

/**
 * @return {number}
 */
THREE.KeyframeTrack.prototype.getInterpolation = function() {};

/**
 * @return {number}
 */
THREE.KeyframeTrack.prototype.getValueSize = function() {};

/**
 * @param {number} timeOffset
 * @return {THREE.KeyframeTrack}
 */
THREE.KeyframeTrack.prototype.shift = function(timeOffset) {};

/**
 * @param {number} timeScale
 * @return {THREE.KeyframeTrack}
 */
THREE.KeyframeTrack.prototype.scale = function(timeScale) {};

/**
 * @param {number} startTime
 * @param {number} endTime
 * @return {THREE.KeyframeTrack}
 */
THREE.KeyframeTrack.prototype.trim = function(startTime, endTime) {};

/**
 * @return {boolean}
 */
THREE.KeyframeTrack.prototype.validate = function() {};

/**
 * @return {THREE.KeyframeTrack}
 */
THREE.KeyframeTrack.prototype.optimize = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.KeyframeTrack.prototype.clone = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.KeyframeTrack.toJSON = function(opt_key) {};
// externs from src/src/objects/Bone.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 */
THREE.Bone = function() {};
/** @type {boolean} */
THREE.Bone.prototype.isBone;
/** @type {string} */
THREE.Bone.prototype.type;

/**
 * @record
 * 
 */
THREE.AnimationClip.MorphTarget = function() {};
/** @type {string} */
THREE.AnimationClip.MorphTarget.prototype.name;
/** @type {Array<THREE.Vector3>} */
THREE.AnimationClip.MorphTarget.prototype.vertices;

/**
 * @constructor
 * 
 * @param {(undefined|string)=} name
 * @param {(undefined|number)=} duration
 * @param {(undefined|Array<THREE.KeyframeTrack>)=} tracks
 * @param {(undefined|number)=} blendMode
 */
THREE.AnimationClip = function(name, duration, tracks, blendMode) {};
/** @type {string} */
THREE.AnimationClip.prototype.name;
/** @type {Array<THREE.KeyframeTrack>} */
THREE.AnimationClip.prototype.tracks;
/** @type {number} */
THREE.AnimationClip.prototype.blendMode;
/** @type {number} */
THREE.AnimationClip.prototype.duration;
/** @type {string} */
THREE.AnimationClip.prototype.uuid;
/** @type {Array<Object>} */
THREE.AnimationClip.prototype.results;

/**
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.prototype.resetDuration = function() {};

/**
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.prototype.trim = function() {};

/**
 * @return {boolean}
 */
THREE.AnimationClip.prototype.validate = function() {};

/**
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.prototype.optimize = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.AnimationClip.prototype.clone = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.AnimationClip.prototype.toJSON = function(opt_key) {};

/**
 * @param {string} name
 * @param {Array<THREE.AnimationClip.MorphTarget>} morphTargetSequence
 * @param {number} fps
 * @param {boolean} noLoop
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.CreateFromMorphTargetSequence = function(name, morphTargetSequence, fps, noLoop) {};

/**
 * @param {Array<THREE.AnimationClip>} clipArray
 * @param {string} name
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.findByName = function(clipArray, name) {};

/**
 * @param {Array<THREE.AnimationClip.MorphTarget>} morphTargets
 * @param {number} fps
 * @param {boolean} noLoop
 * @return {Array<THREE.AnimationClip>}
 */
THREE.AnimationClip.CreateClipsFromMorphTargetSequences = function(morphTargets, fps, noLoop) {};

/**
 * @param {number} json
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.parse = function(json) {};

/**
 * @param {number} animation
 * @param {Array<THREE.Bone>} bones
 * @return {THREE.AnimationClip}
 */
THREE.AnimationClip.parseAnimation = function(animation, bones) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.AnimationClip.toJSON = function(opt_key) {};
// externs from src/src/core/Object3D.d.ts:

/**
 * @extends {THREE.EventDispatcher<THREE.Event>}
 * @constructor
 * 
 */
THREE.Object3D = function() {};
/** @type {number} */
THREE.Object3D.prototype.id;
/** @type {string} */
THREE.Object3D.prototype.uuid;
/** @type {string} */
THREE.Object3D.prototype.name;
/** @type {string} */
THREE.Object3D.prototype.type;
/** @type {(null|THREE.Object3D<THREE.EventDispatcher.Event>)} */
THREE.Object3D.prototype.parent;
/** @type {Array<THREE.Object3D<THREE.EventDispatcher.Event>>} */
THREE.Object3D.prototype.children;
/** @type {THREE.Vector3} */
THREE.Object3D.prototype.up;
/** @type {THREE.Vector3} */
THREE.Object3D.prototype.position;
/** @type {THREE.Euler} */
THREE.Object3D.prototype.rotation;
/** @type {THREE.Quaternion} */
THREE.Object3D.prototype.quaternion;
/** @type {THREE.Vector3} */
THREE.Object3D.prototype.scale;
/** @type {THREE.Matrix4} */
THREE.Object3D.prototype.modelViewMatrix;
/** @type {THREE.Matrix3} */
THREE.Object3D.prototype.normalMatrix;
/** @type {THREE.Matrix4} */
THREE.Object3D.prototype.matrix;
/** @type {THREE.Matrix4} */
THREE.Object3D.prototype.matrixWorld;
/** @type {boolean} */
THREE.Object3D.prototype.matrixAutoUpdate;
/** @type {boolean} */
THREE.Object3D.prototype.matrixWorldNeedsUpdate;
/** @type {THREE.Layers} */
THREE.Object3D.prototype.layers;
/** @type {boolean} */
THREE.Object3D.prototype.visible;
/** @type {boolean} */
THREE.Object3D.prototype.castShadow;
/** @type {boolean} */
THREE.Object3D.prototype.receiveShadow;
/** @type {boolean} */
THREE.Object3D.prototype.frustumCulled;
/** @type {number} */
THREE.Object3D.prototype.renderOrder;
/** @type {Array<THREE.AnimationClip>} */
THREE.Object3D.prototype.animations;
/** @type {Object<string,Object>} */
THREE.Object3D.prototype.userData;
/** @type {THREE.Material} */
THREE.Object3D.prototype.customDepthMaterial;
/** @type {THREE.Material} */
THREE.Object3D.prototype.customDistanceMaterial;
/** @type {boolean} */
THREE.Object3D.prototype.isObject3D;
/** @type {function(!THREE.WebGLRenderer, THREE.Scene, THREE.Camera, THREE.BufferGeometry, THREE.Material, THREE.Group): void} */
THREE.Object3D.prototype.onBeforeRender;
/** @type {function(!THREE.WebGLRenderer, THREE.Scene, THREE.Camera, THREE.BufferGeometry, THREE.Material, THREE.Group): void} */
THREE.Object3D.prototype.onAfterRender;
/** @type {THREE.Vector3} */
THREE.Object3D.DefaultUp;
/** @type {boolean} */
THREE.Object3D.DefaultMatrixAutoUpdate;

/**
 * This updates the position, rotation and scale with the matrix.
 * @param {THREE.Matrix4} matrix
 * @return {void}
 */
THREE.Object3D.prototype.applyMatrix4 = function(matrix) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Quaternion} quaternion
 * @return {THIS}
 */
THREE.Object3D.prototype.applyQuaternion = function(quaternion) {};

/**
 * @param {THREE.Vector3} axis
 * @param {number} angle
 * @return {void}
 */
THREE.Object3D.prototype.setRotationFromAxisAngle = function(axis, angle) {};

/**
 * @param {THREE.Euler} euler
 * @return {void}
 */
THREE.Object3D.prototype.setRotationFromEuler = function(euler) {};

/**
 * @param {THREE.Matrix4} m
 * @return {void}
 */
THREE.Object3D.prototype.setRotationFromMatrix = function(m) {};

/**
 * @param {THREE.Quaternion} q
 * @return {void}
 */
THREE.Object3D.prototype.setRotationFromQuaternion = function(q) {};

/**
 * Rotate an object along an axis in object space. The axis is assumed to be normalized.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} axis 	A normalized vector in object space.
 * @param {number} angle 	The angle in radians.
 * @return {THIS}
 */
THREE.Object3D.prototype.rotateOnAxis = function(axis, angle) {};

/**
 * Rotate an object along an axis in world space. The axis is assumed to be normalized. Method Assumes no rotated parent.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} axis 	A normalized vector in object space.
 * @param {number} angle 	The angle in radians.
 * @return {THIS}
 */
THREE.Object3D.prototype.rotateOnWorldAxis = function(axis, angle) {};

/**
 *
 * @template THIS
 * @this {THIS}
 * @param {number} angle
 * @return {THIS}
 */
THREE.Object3D.prototype.rotateX = function(angle) {};

/**
 *
 * @template THIS
 * @this {THIS}
 * @param {number} angle
 * @return {THIS}
 */
THREE.Object3D.prototype.rotateY = function(angle) {};

/**
 *
 * @template THIS
 * @this {THIS}
 * @param {number} angle
 * @return {THIS}
 */
THREE.Object3D.prototype.rotateZ = function(angle) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} axis 	A normalized vector in object space.
 * @param {number} distance 	The distance to translate.
 * @return {THIS}
 */
THREE.Object3D.prototype.translateOnAxis = function(axis, distance) {};

/**
 * Translates object along x axis by distance.
 * @template THIS
 * @this {THIS}
 * @param {number} distance Distance.
 * @return {THIS}
 */
THREE.Object3D.prototype.translateX = function(distance) {};

/**
 * Translates object along y axis by distance.
 * @template THIS
 * @this {THIS}
 * @param {number} distance Distance.
 * @return {THIS}
 */
THREE.Object3D.prototype.translateY = function(distance) {};

/**
 * Translates object along z axis by distance.
 * @template THIS
 * @this {THIS}
 * @param {number} distance Distance.
 * @return {THIS}
 */
THREE.Object3D.prototype.translateZ = function(distance) {};

/**
 * Updates the vector from local space to world space.
 * @param {THREE.Vector3} vector A local vector.
 * @return {THREE.Vector3}
 */
THREE.Object3D.prototype.localToWorld = function(vector) {};

/**
 * Updates the vector from world space to local space.
 * @param {THREE.Vector3} vector A world vector.
 * @return {THREE.Vector3}
 */
THREE.Object3D.prototype.worldToLocal = function(vector) {};

/**
 * Rotates object to face point in space.
 * @param {(number|THREE.Vector3)} vector A world vector to look at.
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} z
 * @return {void}
 */
THREE.Object3D.prototype.lookAt = function(vector, y, z) {};

/**
 * Adds object as child of this object.
 * @template THIS
 * @this {THIS}
 * @param {...!THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {THIS}
 */
THREE.Object3D.prototype.add = function(object) {};

/**
 * Removes object as child of this object.
 * @template THIS
 * @this {THIS}
 * @param {...!THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {THIS}
 */
THREE.Object3D.prototype.remove = function(object) {};

/**
 * Removes this object from its current parent.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Object3D.prototype.removeFromParent = function() {};

/**
 * Removes all child objects.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Object3D.prototype.clear = function() {};

/**
 * Adds object as a child of this, while maintaining the object's world transform.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {THIS}
 */
THREE.Object3D.prototype.attach = function(object) {};

/**
 * Searches through the object's children and returns the first with a matching id.
 * @param {number} id 	Unique number of the object instance
 * @return {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>)}
 */
THREE.Object3D.prototype.getObjectById = function(id) {};

/**
 * Searches through the object's children and returns the first with a matching name.
 * @param {string} name 	String to match to the children's Object3d.name property.
 * @return {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>)}
 */
THREE.Object3D.prototype.getObjectByName = function(name) {};

/**
 * @param {string} name
 * @param {string} value
 * @return {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>)}
 */
THREE.Object3D.prototype.getObjectByProperty = function(name, value) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Object3D.prototype.getWorldPosition = function(target) {};

/**
 * @param {THREE.Quaternion} target
 * @return {THREE.Quaternion}
 */
THREE.Object3D.prototype.getWorldQuaternion = function(target) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Object3D.prototype.getWorldScale = function(target) {};

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Object3D.prototype.getWorldDirection = function(target) {};

/**
 * @param {THREE.Raycaster} raycaster
 * @param {Array<THREE.Raycaster.Intersection<THREE.Object3D>>} intersects
 * @return {void}
 */
THREE.Object3D.prototype.raycast = function(raycaster, intersects) {};

/**
 * @param {function(!THREE.Object3D<THREE.EventDispatcher.Event>): Object} callback
 * @return {void}
 */
THREE.Object3D.prototype.traverse = function(callback) {};

/**
 * @param {function(!THREE.Object3D<THREE.EventDispatcher.Event>): Object} callback
 * @return {void}
 */
THREE.Object3D.prototype.traverseVisible = function(callback) {};

/**
 * @param {function(!THREE.Object3D<THREE.EventDispatcher.Event>): Object} callback
 * @return {void}
 */
THREE.Object3D.prototype.traverseAncestors = function(callback) {};

/**
 * Updates local transform.
 * @return {void}
 */
THREE.Object3D.prototype.updateMatrix = function() {};

/**
 * Updates global transform of the object and its children.
 * @param {(undefined|boolean)=} force
 * @return {void}
 */
THREE.Object3D.prototype.updateMatrixWorld = function(force) {};

/**
 * @param {boolean} updateParents
 * @param {boolean} updateChildren
 * @return {void}
 */
THREE.Object3D.prototype.updateWorldMatrix = function(updateParents, updateChildren) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.Object3D.prototype.toJSON = function(opt_key) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {(undefined|boolean)=} recursive
 * @return {THIS}
 */
THREE.Object3D.prototype.clone = function(recursive) {};

/**
 *
 * @template THIS
 * @this {THIS}
 * @param {THREE.Object3D} source
 * @param {(undefined|boolean)=} recursive
 * @return {THIS}
 */
THREE.Object3D.prototype.copy = function(source, recursive) {};
// externs from src/src/cameras/Camera.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * This constructor sets following properties to the correct type: matrixWorldInverse, projectionMatrix and projectionMatrixInverse.
 */
THREE.Camera = function() {};
/** @type {THREE.Matrix4} */
THREE.Camera.prototype.matrixWorldInverse;
/** @type {THREE.Matrix4} */
THREE.Camera.prototype.projectionMatrix;
/** @type {THREE.Matrix4} */
THREE.Camera.prototype.projectionMatrixInverse;
/** @type {boolean} */
THREE.Camera.prototype.isCamera;

/**
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.Camera.prototype.getWorldDirection = function(target) {};

/**
 * @param {(undefined|boolean)=} force
 * @return {void}
 */
THREE.Camera.prototype.updateMatrixWorld = function(force) {};
// externs from src/src/math/Spherical.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} phi
 * @param {(undefined|number)=} theta
 */
THREE.Spherical = function(radius, phi, theta) {};
/** @type {number} */
THREE.Spherical.prototype.radius;
/** @type {number} */
THREE.Spherical.prototype.phi;
/** @type {number} */
THREE.Spherical.prototype.theta;

/**
 * @template THIS
 * @this {THIS}
 * @param {number} radius
 * @param {number} phi
 * @param {number} theta
 * @return {THIS}
 */
THREE.Spherical.prototype.set = function(radius, phi, theta) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Spherical.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Spherical} other
 * @return {THIS}
 */
THREE.Spherical.prototype.copy = function(other) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Spherical.prototype.makeSafe = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Spherical.prototype.setFromVector3 = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THIS}
 */
THREE.Spherical.prototype.setFromCartesianCoords = function(x, y, z) {};
// externs from src/src/math/Cylindrical.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} theta
 * @param {(undefined|number)=} y
 */
THREE.Cylindrical = function(radius, theta, y) {};
/** @type {number} */
THREE.Cylindrical.prototype.radius;
/** @type {number} */
THREE.Cylindrical.prototype.theta;
/** @type {number} */
THREE.Cylindrical.prototype.y;

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Cylindrical.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Cylindrical} other
 * @return {THIS}
 */
THREE.Cylindrical.prototype.copy = function(other) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} radius
 * @param {number} theta
 * @param {number} y
 * @return {THIS}
 */
THREE.Cylindrical.prototype.set = function(radius, theta, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} vec3
 * @return {THIS}
 */
THREE.Cylindrical.prototype.setFromVector3 = function(vec3) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THIS}
 */
THREE.Cylindrical.prototype.setFromCartesianCoords = function(x, y, z) {};
// externs from src/src/math/Vector3.d.ts:

/** @type {Array<Object>} */
THREE.Vector3Tuple;

/**
 * @constructor
 * 
 * @param {(undefined|number)=} x
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} z
 */
THREE.Vector3 = function(x, y, z) {};
/** @type {number} */
THREE.Vector3.prototype.x;
/** @type {number} */
THREE.Vector3.prototype.y;
/** @type {number} */
THREE.Vector3.prototype.z;
/** @type {boolean} */
THREE.Vector3.prototype.isVector3;

/**
 * Sets value of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THIS}
 */
THREE.Vector3.prototype.set = function(x, y, z) {};

/**
 * Sets all values of this vector.
 * @template THIS
 * @this {THIS}
 * @param {number} scalar
 * @return {THIS}
 */
THREE.Vector3.prototype.setScalar = function(scalar) {};

/**
 * Sets x value of this vector.
 * @param {number} x
 * @return {THREE.Vector3}
 */
THREE.Vector3.prototype.setX = function(x) {};

/**
 * Sets y value of this vector.
 * @param {number} y
 * @return {THREE.Vector3}
 */
THREE.Vector3.prototype.setY = function(y) {};

/**
 * Sets z value of this vector.
 * @param {number} z
 * @return {THREE.Vector3}
 */
THREE.Vector3.prototype.setZ = function(z) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} value
 * @return {THIS}
 */
THREE.Vector3.prototype.setComponent = function(index, value) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.Vector3.prototype.getComponent = function(index) {};

/**
 * Clones this vector.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.clone = function() {};

/**
 * Copies value of v to this vector.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.copy = function(v) {};

/**
 * Adds v to this vector.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.add = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector3.prototype.addScalar = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector3.prototype.addScaledVector = function(v, s) {};

/**
 * Sets this vector to a + b.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @return {THIS}
 */
THREE.Vector3.prototype.addVectors = function(a, b) {};

/**
 * Subtracts v from this vector.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} a
 * @return {THIS}
 */
THREE.Vector3.prototype.sub = function(a) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector3.prototype.subScalar = function(s) {};

/**
 * Sets this vector to a - b.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @return {THIS}
 */
THREE.Vector3.prototype.subVectors = function(a, b) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.multiply = function(v) {};

/**
 * Multiplies this vector by scalar s.
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector3.prototype.multiplyScalar = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @return {THIS}
 */
THREE.Vector3.prototype.multiplyVectors = function(a, b) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Euler} euler
 * @return {THIS}
 */
THREE.Vector3.prototype.applyEuler = function(euler) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} axis
 * @param {number} angle
 * @return {THIS}
 */
THREE.Vector3.prototype.applyAxisAngle = function(axis, angle) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} m
 * @return {THIS}
 */
THREE.Vector3.prototype.applyMatrix3 = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} m
 * @return {THIS}
 */
THREE.Vector3.prototype.applyNormalMatrix = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Vector3.prototype.applyMatrix4 = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Quaternion} q
 * @return {THIS}
 */
THREE.Vector3.prototype.applyQuaternion = function(q) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Camera} camera
 * @return {THIS}
 */
THREE.Vector3.prototype.project = function(camera) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Camera} camera
 * @return {THIS}
 */
THREE.Vector3.prototype.unproject = function(camera) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Vector3.prototype.transformDirection = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.divide = function(v) {};

/**
 * Divides this vector by scalar s.
 * Set vector to ( 0, 0, 0 ) if s == 0.
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Vector3.prototype.divideScalar = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.min = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.max = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} min
 * @param {THREE.Vector3} max
 * @return {THIS}
 */
THREE.Vector3.prototype.clamp = function(min, max) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} min
 * @param {number} max
 * @return {THIS}
 */
THREE.Vector3.prototype.clampScalar = function(min, max) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} min
 * @param {number} max
 * @return {THIS}
 */
THREE.Vector3.prototype.clampLength = function(min, max) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.floor = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.ceil = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.round = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.roundToZero = function() {};

/**
 * Inverts this vector.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.negate = function() {};

/**
 * Computes dot product of this vector and v.
 * @param {THREE.Vector3} v
 * @return {number}
 */
THREE.Vector3.prototype.dot = function(v) {};

/**
 * Computes squared length of this vector.
 * @return {number}
 */
THREE.Vector3.prototype.lengthSq = function() {};

/**
 * Computes length of this vector.
 * @return {number}
 */
THREE.Vector3.prototype.length = function() {};

/**
 * Computes Manhattan length of this vector.
 * http://en.wikipedia.org/wiki/Taxicab_geometry
 * 
 * @deprecated Use {\@link Vector3#manhattanLength .manhattanLength()} instead.
 * @return {number}
 */
THREE.Vector3.prototype.lengthManhattan = function() {};

/**
 * Computes the Manhattan length of this vector.
 * 
 * see {\@link http://en.wikipedia.org/wiki/Taxicab_geometry|Wikipedia: Taxicab Geometry}
 * @return {number}
 */
THREE.Vector3.prototype.manhattanLength = function() {};

/**
 * Computes the Manhattan length (distance) from this vector to the given vector v
 * 
 * see {\@link http://en.wikipedia.org/wiki/Taxicab_geometry|Wikipedia: Taxicab Geometry}
 * @param {THREE.Vector3} v
 * @return {number}
 */
THREE.Vector3.prototype.manhattanDistanceTo = function(v) {};

/**
 * Normalizes this vector.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.normalize = function() {};

/**
 * Normalizes this vector and multiplies it by l.
 * @template THIS
 * @this {THIS}
 * @param {number} l
 * @return {THIS}
 */
THREE.Vector3.prototype.setLength = function(l) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Vector3.prototype.lerp = function(v, alpha) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v1
 * @param {THREE.Vector3} v2
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Vector3.prototype.lerpVectors = function(v1, v2, alpha) {};

/**
 * Sets this vector to cross product of itself and v.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} a
 * @return {THIS}
 */
THREE.Vector3.prototype.cross = function(a) {};

/**
 * Sets this vector to cross product of a and b.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} a
 * @param {THREE.Vector3} b
 * @return {THIS}
 */
THREE.Vector3.prototype.crossVectors = function(a, b) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} v
 * @return {THIS}
 */
THREE.Vector3.prototype.projectOnVector = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} planeNormal
 * @return {THIS}
 */
THREE.Vector3.prototype.projectOnPlane = function(planeNormal) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Vector3} vector
 * @return {THIS}
 */
THREE.Vector3.prototype.reflect = function(vector) {};

/**
 * @param {THREE.Vector3} v
 * @return {number}
 */
THREE.Vector3.prototype.angleTo = function(v) {};

/**
 * Computes distance of this vector to v.
 * @param {THREE.Vector3} v
 * @return {number}
 */
THREE.Vector3.prototype.distanceTo = function(v) {};

/**
 * Computes squared distance of this vector to v.
 * @param {THREE.Vector3} v
 * @return {number}
 */
THREE.Vector3.prototype.distanceToSquared = function(v) {};

/**
 * @deprecated Use {\@link Vector3#manhattanDistanceTo .manhattanDistanceTo()} instead.
 * @param {THREE.Vector3} v
 * @return {number}
 */
THREE.Vector3.prototype.distanceToManhattan = function(v) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Spherical} s
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromSpherical = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} r
 * @param {number} phi
 * @param {number} theta
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromSphericalCoords = function(r, phi, theta) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Cylindrical} s
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromCylindrical = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} radius
 * @param {number} theta
 * @param {number} y
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromCylindricalCoords = function(radius, theta, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromMatrixPosition = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromMatrixScale = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} matrix
 * @param {number} index
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromMatrixColumn = function(matrix, index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} matrix
 * @param {number} index
 * @return {THIS}
 */
THREE.Vector3.prototype.setFromMatrix3Column = function(matrix, index) {};

/**
 * Checks for strict equality of this vector and v.
 * @param {THREE.Vector3} v
 * @return {boolean}
 */
THREE.Vector3.prototype.equals = function(v) {};

/**
 * Sets this vector's x, y and z value from the provided array or array-like.
 * @template THIS
 * @this {THIS}
 * @param {Array<number>} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array. Default is 0.
 * @return {THIS}
 */
THREE.Vector3.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array [x, y, z], or copies x, y and z into the provided array. / Copies x, y and z into the provided array-like.
 * @param {(undefined|Array<number>)|(undefined|Array<Object>)=} array (optional) array to store the vector to. If this is not provided, a new array will be created. / array-like to store the vector to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array. / (optional) optional offset into the array-like.
 * @return {Array<number>|Array<Object>} The created or provided array. / The provided array-like.
 */
THREE.Vector3.prototype.toArray = function(array, offset) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)} attribute
 * @param {number} index
 * @return {THIS}
 */
THREE.Vector3.prototype.fromBufferAttribute = function(attribute, index) {};

/**
 * Sets this vector's x, y and z from Math.random
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.random = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Vector3.prototype.randomDirection = function() {};
// externs from src/src/math/Matrix4.d.ts:

/** @type {Array<number>} */
THREE.Matrix4Tuple;

/**
 * @constructor
 * 
 */
THREE.Matrix4 = function() {};
/** @type {Array<number>} */
THREE.Matrix4.prototype.elements;

/**
 * Sets all fields of this matrix.
 * @param {number} n11
 * @param {number} n12
 * @param {number} n13
 * @param {number} n14
 * @param {number} n21
 * @param {number} n22
 * @param {number} n23
 * @param {number} n24
 * @param {number} n31
 * @param {number} n32
 * @param {number} n33
 * @param {number} n34
 * @param {number} n41
 * @param {number} n42
 * @param {number} n43
 * @param {number} n44
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.set = function(n11, n12, n13, n14, n21, n22, n23, n24, n31, n32, n33, n34, n41, n42, n43, n44) {};

/**
 * Resets this matrix to identity.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.identity = function() {};

/**
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Matrix4.prototype.copy = function(m) {};

/**
 * @param {THREE.Matrix4} m
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.copyPosition = function(m) {};

/**
 * @param {THREE.Vector3} xAxis
 * @param {THREE.Vector3} yAxis
 * @param {THREE.Vector3} zAxis
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.extractBasis = function(xAxis, yAxis, zAxis) {};

/**
 * @param {THREE.Vector3} xAxis
 * @param {THREE.Vector3} yAxis
 * @param {THREE.Vector3} zAxis
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeBasis = function(xAxis, yAxis, zAxis) {};

/**
 * Copies the rotation component of the supplied matrix m into this matrix rotation component.
 * @param {THREE.Matrix4} m
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.extractRotation = function(m) {};

/**
 * @param {THREE.Euler} euler
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeRotationFromEuler = function(euler) {};

/**
 * @param {THREE.Quaternion} q
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeRotationFromQuaternion = function(q) {};

/**
 * Constructs a rotation matrix, looking from eye towards center with defined up vector.
 * @param {THREE.Vector3} eye
 * @param {THREE.Vector3} target
 * @param {THREE.Vector3} up
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.lookAt = function(eye, target, up) {};

/**
 * Multiplies this matrix by m.
 * @param {THREE.Matrix4} m
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.multiply = function(m) {};

/**
 * @param {THREE.Matrix4} m
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.premultiply = function(m) {};

/**
 * Sets this matrix to a x b.
 * @param {THREE.Matrix4} a
 * @param {THREE.Matrix4} b
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.multiplyMatrices = function(a, b) {};

/**
 * Sets this matrix to a x b and stores the result into the flat array r.
 * r can be either a regular Array or a TypedArray.
 * 
 * @deprecated This method has been removed completely.
 * @param {THREE.Matrix4} a
 * @param {THREE.Matrix4} b
 * @param {Array<number>} r
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.multiplyToArray = function(a, b, r) {};

/**
 * Multiplies this matrix by s.
 * @param {number} s
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.multiplyScalar = function(s) {};

/**
 * Computes determinant of this matrix.
 * Based on http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/fourD/index.htm
 * @return {number}
 */
THREE.Matrix4.prototype.determinant = function() {};

/**
 * Transposes this matrix.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.transpose = function() {};

/**
 * Sets the position component for this matrix from vector v.
 * @param {(number|THREE.Vector3)} v
 * @param {(undefined|number)=} y
 * @param {(undefined|number)=} z
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.setPosition = function(v, y, z) {};

/**
 * Inverts this matrix.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.invert = function() {};

/**
 * Multiplies the columns of this matrix by vector v.
 * @param {THREE.Vector3} v
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.scale = function(v) {};

/**
 * @return {number}
 */
THREE.Matrix4.prototype.getMaxScaleOnAxis = function() {};

/**
 * Sets this matrix as translation transform.
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeTranslation = function(x, y, z) {};

/**
 * Sets this matrix as rotation transform around x axis by theta radians.
 * 
 * @param {number} theta Rotation angle in radians.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeRotationX = function(theta) {};

/**
 * Sets this matrix as rotation transform around y axis by theta radians.
 * 
 * @param {number} theta Rotation angle in radians.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeRotationY = function(theta) {};

/**
 * Sets this matrix as rotation transform around z axis by theta radians.
 * 
 * @param {number} theta Rotation angle in radians.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeRotationZ = function(theta) {};

/**
 * Sets this matrix as rotation transform around axis by angle radians.
 * Based on http://www.gamedev.net/reference/articles/article1199.asp.
 * 
 * @param {THREE.Vector3} axis Rotation axis.
 * @param {number} angle
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeRotationAxis = function(axis, angle) {};

/**
 * Sets this matrix as scale transform.
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeScale = function(x, y, z) {};

/**
 * Sets this matrix as shear transform.
 * @param {number} xy
 * @param {number} xz
 * @param {number} yx
 * @param {number} yz
 * @param {number} zx
 * @param {number} zy
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeShear = function(xy, xz, yx, yz, zx, zy) {};

/**
 * Sets this matrix to the transformation composed of translation, rotation and scale.
 * @param {THREE.Vector3} translation
 * @param {THREE.Quaternion} rotation
 * @param {THREE.Vector3} scale
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.compose = function(translation, rotation, scale) {};

/**
 * Decomposes this matrix into it's position, quaternion and scale components.
 * @param {THREE.Vector3} translation
 * @param {THREE.Quaternion} rotation
 * @param {THREE.Vector3} scale
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.decompose = function(translation, rotation, scale) {};

/**
 * Creates a frustum matrix. / Creates a perspective projection matrix.
 * @param {number} left_or_fov
 * @param {number} right_or_aspect
 * @param {number} bottom_or_near
 * @param {number} top_or_far
 * @param {number=} near
 * @param {number=} far
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makePerspective = function(left_or_fov, right_or_aspect, bottom_or_near, top_or_far, near, far) {};

/**
 * Creates an orthographic projection matrix.
 * @param {number} left
 * @param {number} right
 * @param {number} top
 * @param {number} bottom
 * @param {number} near
 * @param {number} far
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.makeOrthographic = function(left, right, top, bottom, near, far) {};

/**
 * @param {THREE.Matrix4} matrix
 * @return {boolean}
 */
THREE.Matrix4.prototype.equals = function(matrix) {};

/**
 * Sets the values of this matrix from the provided array or array-like.
 * @param {Array<number>} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array-like. Default is 0.
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array with the values of this matrix, or copies them into the provided array. / Copies he values of this matrix into the provided array-like.
 * @param {(undefined|Array<number>)|(undefined|Array<Object>)=} array (optional) array to store the matrix to. If this is not provided, a new array will be created. / array-like to store the matrix to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array. / (optional) optional offset into the array-like.
 * @return {Array<number>|Array<Object>} The created or provided array. / The provided array-like.
 */
THREE.Matrix4.prototype.toArray = function(array, offset) {};

/**
 * Set the upper 3x3 elements of this matrix to the values of the Matrix3 m.
 * @param {THREE.Matrix3} m
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.setFromMatrix3 = function(m) {};

/**
 * @deprecated Use {\@link Matrix4#copyPosition .copyPosition()} instead.
 * @param {THREE.Matrix4} m
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.extractPosition = function(m) {};

/**
 * @deprecated Use {\@link Matrix4#makeRotationFromQuaternion .makeRotationFromQuaternion()} instead.
 * @param {THREE.Quaternion} q
 * @return {THREE.Matrix4}
 */
THREE.Matrix4.prototype.setRotationFromQuaternion = function(q) {};

/**
 * @deprecated Use {\@link Vector3#applyMatrix4 vector.applyMatrix4( matrix )} instead.
 * @param {number} v
 * @return {number}
 */
THREE.Matrix4.prototype.multiplyVector3 = function(v) {};

/**
 * @deprecated Use {\@link Vector4#applyMatrix4 vector.applyMatrix4( matrix )} instead.
 * @param {number} v
 * @return {number}
 */
THREE.Matrix4.prototype.multiplyVector4 = function(v) {};

/**
 * @deprecated This method has been removed completely.
 * @param {Array<number>} array
 * @return {Array<number>}
 */
THREE.Matrix4.prototype.multiplyVector3Array = function(array) {};

/**
 * @deprecated Use {\@link Vector3#transformDirection Vector3.transformDirection( matrix )} instead.
 * @param {number} v
 * @return {void}
 */
THREE.Matrix4.prototype.rotateAxis = function(v) {};

/**
 * @deprecated Use {\@link Vector3#applyMatrix4 vector.applyMatrix4( matrix )} instead.
 * @param {number} v
 * @return {void}
 */
THREE.Matrix4.prototype.crossVector = function(v) {};

/**
 * @deprecated Use {\@link Matrix4#toArray .toArray()} instead.
 * @param {Array<number>} array
 * @param {number} offset
 * @return {Array<number>}
 */
THREE.Matrix4.prototype.flattenToArrayOffset = function(array, offset) {};

/**
 * @deprecated Use {\@link Matrix4#invert .invert()} instead.
 * @param {THREE.Matrix3} matrix
 * @return {THREE.Matrix3}
 */
THREE.Matrix4.prototype.getInverse = function(matrix) {};
// externs from src/src/math/Matrix3.d.ts:

/** @type {Array<number>} */
THREE.Matrix3Tuple;


/**
 * @constructor
 * 
 */
THREE.Matrix3 = function() {};
/** @type {Array<number>} */
THREE.Matrix3.prototype.elements;

/** @type {Array<number>} */
THREE.Matrix3.prototype.elements;

/**
 * @param {number} n11
 * @param {number} n12
 * @param {number} n13
 * @param {number} n21
 * @param {number} n22
 * @param {number} n23
 * @param {number} n31
 * @param {number} n32
 * @param {number} n33
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.set = function(n11, n12, n13, n21, n22, n23, n31, n32, n33) {};

/**
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.identity = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Matrix3.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} m
 * @return {THIS}
 */
THREE.Matrix3.prototype.copy = function(m) {};

/**
 * @param {THREE.Vector3} xAxis
 * @param {THREE.Vector3} yAxis
 * @param {THREE.Vector3} zAxis
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.extractBasis = function(xAxis, yAxis, zAxis) {};

/**
 * @param {THREE.Matrix4} m
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.setFromMatrix4 = function(m) {};

/**
 * @param {number} s
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.multiplyScalar = function(s) {};

/**
 * @return {number}
 */
THREE.Matrix3.prototype.determinant = function() {};

/**
 * Inverts this matrix in place.
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.invert = function() {};

/**
 * Transposes this matrix in place.
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.transpose = function() {};

/**
 * @param {THREE.Matrix4} matrix4
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.getNormalMatrix = function(matrix4) {};

/**
 * Transposes this matrix into the supplied array r, and returns itself.
 * @param {Array<number>} r
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.transposeIntoArray = function(r) {};

/**
 * @param {number} tx
 * @param {number} ty
 * @param {number} sx
 * @param {number} sy
 * @param {number} rotation
 * @param {number} cx
 * @param {number} cy
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.setUvTransform = function(tx, ty, sx, sy, rotation, cx, cy) {};

/**
 * @param {number} sx
 * @param {number} sy
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.scale = function(sx, sy) {};

/**
 * @param {number} theta
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.rotate = function(theta) {};

/**
 * @param {number} tx
 * @param {number} ty
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.translate = function(tx, ty) {};

/**
 * @param {THREE.Matrix3} matrix
 * @return {boolean}
 */
THREE.Matrix3.prototype.equals = function(matrix) {};

/**
 * Sets the values of this matrix from the provided array or array-like.
 * @param {(!Array<number>)} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array-like. Default is 0.
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array with the values of this matrix, or copies them into the provided array. / Copies he values of this matrix into the provided array-like.
 * @param {(undefined|Array<number>)|(undefined|Array<Object>)=} array (optional) array to store the matrix to. If this is not provided, a new array will be created. / array-like to store the matrix to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array. / (optional) optional offset into the array-like.
 * @return {Array<number>|Array<Object>} The created or provided array. / The provided array-like.
 */
THREE.Matrix3.prototype.toArray = function(array, offset) {};

/**
 * Multiplies this matrix by m.
 * @param {THREE.Matrix3} m
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.multiply = function(m) {};

/**
 * @param {THREE.Matrix3} m
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.premultiply = function(m) {};

/**
 * Sets this matrix to a x b.
 * @param {THREE.Matrix3} a
 * @param {THREE.Matrix3} b
 * @return {THREE.Matrix3}
 */
THREE.Matrix3.prototype.multiplyMatrices = function(a, b) {};

/**
 * @deprecated Use {\@link Vector3.applyMatrix3 vector.applyMatrix3( matrix )} instead.
 * @param {THREE.Vector3} vector
 * @return {number}
 */
THREE.Matrix3.prototype.multiplyVector3 = function(vector) {};

/**
 * @deprecated This method has been removed completely.
 * @param {number} a
 * @return {number}
 */
THREE.Matrix3.prototype.multiplyVector3Array = function(a) {};

/**
 * @deprecated Use {\@link Matrix3#invert .invert()} instead.
 * @param {THREE.Matrix4|THREE.Matrix3} matrix
 * @param {(undefined|boolean)=} throwOnDegenerate
 * @return {THREE.Matrix3|THREE.Matrix3}
 */
THREE.Matrix3.prototype.getInverse = function(matrix, throwOnDegenerate) {};

/**
 * @deprecated Use {\@link Matrix3#toArray .toArray()} instead.
 * @param {Array<number>} array
 * @param {number} offset
 * @return {Array<number>}
 */
THREE.Matrix3.prototype.flattenToArrayOffset = function(array, offset) {};
// externs from src/src/core/BufferAttribute.d.ts:

/**
 * @constructor
 * 
 * @param {Float32Array|Array<number>} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.BufferAttribute = function(array, itemSize, normalized) {};
/** @type {string} */
THREE.BufferAttribute.prototype.name;
/** @type {Array<number>} */
THREE.BufferAttribute.prototype.array;
/** @type {number} */
THREE.BufferAttribute.prototype.itemSize;
/** @type {number} */
THREE.BufferAttribute.prototype.usage;
/** @type {{offset: number, count: number}} */
THREE.BufferAttribute.prototype.updateRange;
/** @type {number} */
THREE.BufferAttribute.prototype.version;
/** @type {boolean} */
THREE.BufferAttribute.prototype.normalized;
/** @type {number} */
THREE.BufferAttribute.prototype.count;
/** @type {boolean} */
THREE.BufferAttribute.prototype.needsUpdate;

/** @type {boolean} */
THREE.BufferAttribute.prototype.isBufferAttribute;
/** @type {function(): void} */
THREE.BufferAttribute.prototype.onUploadCallback;

/**
 * @template THIS
 * @this {THIS}
 * @param {function(): void} callback
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.onUpload = function(callback) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} usage
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setUsage = function(usage) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.BufferAttribute} source
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copy = function(source) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index1
 * @param {THREE.BufferAttribute} attribute
 * @param {number} index2
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copyAt = function(index1, attribute, index2) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<number>} array
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copyArray = function(array) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<{r: number, g: number, b: number}>} colors
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copyColorsArray = function(colors) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<{x: number, y: number}>} vectors
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copyVector2sArray = function(vectors) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<{x: number, y: number, z: number}>} vectors
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copyVector3sArray = function(vectors) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<{x: number, y: number, z: number, w: number}>} vectors
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.copyVector4sArray = function(vectors) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} m
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.applyMatrix3 = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.applyMatrix4 = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix3} m
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.applyNormalMatrix = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.transformDirection = function(m) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {(!Array<number>|ArrayBufferView)} value
 * @param {(undefined|number)=} offset
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.set = function(value, offset) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.BufferAttribute.prototype.getX = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setX = function(index, x) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.BufferAttribute.prototype.getY = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} y
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setY = function(index, y) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.BufferAttribute.prototype.getZ = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} z
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setZ = function(index, z) {};

/**
 * @param {number} index
 * @return {number}
 */
THREE.BufferAttribute.prototype.getW = function(index) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} z
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setW = function(index, z) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @param {number} y
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setXY = function(index, x, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setXYZ = function(index, x, y, z) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} index
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @param {number} w
 * @return {THIS}
 */
THREE.BufferAttribute.prototype.setXYZW = function(index, x, y, z, w) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.BufferAttribute.prototype.toJSON = function(opt_key) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Int8Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Uint8Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Uint8ClampedAttribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Int16Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Uint16Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Int32Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Uint32Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Float32Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @param {number} array
 * @param {number} itemSize
 */
THREE.Float64Attribute = function(array, itemSize) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Int8BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Uint8BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Uint8ClampedBufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Int16BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Uint16BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Int32BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Uint32BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Float16BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Float32BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @constructor
 * @extends {THREE.BufferAttribute}
 * @param {(number|Array<number>|ArrayBuffer|Iterable<number>)} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 */
THREE.Float64BufferAttribute = function(array, itemSize, normalized) {};

/**
 * @record
 * 
 */
THREE.Color.HSL = function() {};
/** @type {number} */
THREE.Color.HSL.prototype.h;
/** @type {number} */
THREE.Color.HSL.prototype.s;
/** @type {number} */
THREE.Color.HSL.prototype.l;

/**
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)|number=} color_or_r
 * @param {number=} g
 * @param {number=} b
 */
THREE.Color = function(color_or_r, g, b) {};
/** @type {boolean} */
THREE.Color.prototype.isColor;
/** @type {number} */
THREE.Color.prototype.r;
/** @type {number} */
THREE.Color.prototype.g;
/** @type {number} */
THREE.Color.prototype.b;
/** @type {number} */
THREE.Color.NAMES;

/**
 * @param {(string|number|THREE.Color)} color
 * @return {THREE.Color}
 */
THREE.Color.prototype.set = function(color) {};

/**
 * @param {number} scalar
 * @return {THREE.Color}
 */
THREE.Color.prototype.setScalar = function(scalar) {};

/**
 * @param {number} hex
 * @return {THREE.Color}
 */
THREE.Color.prototype.setHex = function(hex) {};

/**
 * Sets this color from RGB values.
 * @param {number} r Red channel value between 0 and 1.
 * @param {number} g Green channel value between 0 and 1.
 * @param {number} b Blue channel value between 0 and 1.
 * @return {THREE.Color}
 */
THREE.Color.prototype.setRGB = function(r, g, b) {};

/**
 * Sets this color from HSL values.
 * Based on MochiKit implementation by Bob Ippolito.
 * 
 * @param {number} h Hue channel value between 0 and 1.
 * @param {number} s Saturation value channel between 0 and 1.
 * @param {number} l Value channel value between 0 and 1.
 * @return {THREE.Color}
 */
THREE.Color.prototype.setHSL = function(h, s, l) {};

/**
 * Sets this color from a CSS context style string.
 * @param {string} style
 * @return {THREE.Color}
 */
THREE.Color.prototype.setStyle = function(style) {};

/**
 * Sets this color from a color name.
 * Faster than {\@link Color#setStyle .setStyle()} method if you don't need the other CSS-style formats.
 * @param {string} style Color name in X11 format.
 * @return {THREE.Color}
 */
THREE.Color.prototype.setColorName = function(style) {};

/**
 * Clones this color.
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Color.prototype.clone = function() {};

/**
 * Copies given color.
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color Color to copy.
 * @return {THIS}
 */
THREE.Color.prototype.copy = function(color) {};

/**
 * Copies given color making conversion from gamma to linear space.
 * @param {THREE.Color} color Color to copy.
 * @param {(undefined|number)=} gammaFactor
 * @return {THREE.Color}
 */
THREE.Color.prototype.copyGammaToLinear = function(color, gammaFactor) {};

/**
 * Copies given color making conversion from linear to gamma space.
 * @param {THREE.Color} color Color to copy.
 * @param {(undefined|number)=} gammaFactor
 * @return {THREE.Color}
 */
THREE.Color.prototype.copyLinearToGamma = function(color, gammaFactor) {};

/**
 * Converts this color from gamma to linear space.
 * @param {(undefined|number)=} gammaFactor
 * @return {THREE.Color}
 */
THREE.Color.prototype.convertGammaToLinear = function(gammaFactor) {};

/**
 * Converts this color from linear to gamma space.
 * @param {(undefined|number)=} gammaFactor
 * @return {THREE.Color}
 */
THREE.Color.prototype.convertLinearToGamma = function(gammaFactor) {};

/**
 * Copies given color making conversion from sRGB to linear space.
 * @param {THREE.Color} color Color to copy.
 * @return {THREE.Color}
 */
THREE.Color.prototype.copySRGBToLinear = function(color) {};

/**
 * Copies given color making conversion from linear to sRGB space.
 * @param {THREE.Color} color Color to copy.
 * @return {THREE.Color}
 */
THREE.Color.prototype.copyLinearToSRGB = function(color) {};

/**
 * Converts this color from sRGB to linear space.
 * @return {THREE.Color}
 */
THREE.Color.prototype.convertSRGBToLinear = function() {};

/**
 * Converts this color from linear to sRGB space.
 * @return {THREE.Color}
 */
THREE.Color.prototype.convertLinearToSRGB = function() {};

/**
 * Returns the hexadecimal value of this color.
 * @return {number}
 */
THREE.Color.prototype.getHex = function() {};

/**
 * Returns the string formated hexadecimal value of this color.
 * @return {string}
 */
THREE.Color.prototype.getHexString = function() {};

/**
 * @param {THREE.Color.HSL} target
 * @return {THREE.Color.HSL}
 */
THREE.Color.prototype.getHSL = function(target) {};

/**
 * Returns the value of this color in CSS context style.
 * Example: rgb(r, g, b)
 * @return {string}
 */
THREE.Color.prototype.getStyle = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} h
 * @param {number} s
 * @param {number} l
 * @return {THIS}
 */
THREE.Color.prototype.offsetHSL = function(h, s, l) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color
 * @return {THIS}
 */
THREE.Color.prototype.add = function(color) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color1
 * @param {THREE.Color} color2
 * @return {THIS}
 */
THREE.Color.prototype.addColors = function(color1, color2) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Color.prototype.addScalar = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color
 * @return {THIS}
 */
THREE.Color.prototype.sub = function(color) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color
 * @return {THIS}
 */
THREE.Color.prototype.multiply = function(color) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} s
 * @return {THIS}
 */
THREE.Color.prototype.multiplyScalar = function(s) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Color.prototype.lerp = function(color, alpha) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color1
 * @param {THREE.Color} color2
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Color.prototype.lerpColors = function(color1, color2, alpha) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} color
 * @param {number} alpha
 * @return {THIS}
 */
THREE.Color.prototype.lerpHSL = function(color, alpha) {};

/**
 * @param {THREE.Color} color
 * @return {boolean}
 */
THREE.Color.prototype.equals = function(color) {};

/**
 * Sets this color's red, green and blue value from the provided array or array-like.
 * @template THIS
 * @this {THIS}
 * @param {(!Array<number>|Array<number>)} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array-like. Default is 0.
 * @return {THIS}
 */
THREE.Color.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array [red, green, blue], or copies red, green and blue into the provided array. / Copies red, green and blue into the provided array-like.
 * @param {(undefined|Array<number>)|Array<number>=} array_or_xyz (optional) array to store the color to. If this is not provided, a new array will be created.
 * @param {(undefined|number)=} offset (optional) optional offset into the array. / (optional) optional offset into the array-like.
 * @return {Array<number>|Array<number>} The created or provided array. / The provided array-like.
 */
THREE.Color.prototype.toArray = function(array_or_xyz, offset) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.BufferAttribute} attribute
 * @param {number} index
 * @return {THIS}
 */
THREE.Color.prototype.fromBufferAttribute = function(attribute, index) {};
// externs from src/src/utils.d.ts:
/** @constructor */
THREE.utils = function() {};

/** @type {(string|number|THREE.Color)} */
THREE.utils.ColorRepresentation;
// externs from src/src/animation/tracks/VectorKeyframeTrack.d.ts:

/**
 * @extends {THREE.KeyframeTrack}
 * @constructor
 * 
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {(undefined|number)=} interpolation
 */
THREE.VectorKeyframeTrack = function(name, times, values, interpolation) {};
/** @type {string} */
THREE.VectorKeyframeTrack.prototype.ValueTypeName;
// externs from src/src/animation/tracks/StringKeyframeTrack.d.ts:

/**
 * @extends {THREE.KeyframeTrack}
 * @constructor
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {(undefined|number)=} interpolation
 */
THREE.StringKeyframeTrack = function(name, times, values, interpolation) {};
/** @type {string} */
THREE.StringKeyframeTrack.prototype.ValueTypeName;
// externs from src/src/animation/tracks/QuaternionKeyframeTrack.d.ts:


/**
 * @extends {THREE.KeyframeTrack}
 * @constructor
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {(undefined|number)=} interpolation
 */
THREE.QuaternionKeyframeTrack = function(name, times, values, interpolation) {};
/** @type {string} */
THREE.QuaternionKeyframeTrack.prototype.ValueTypeName;
// externs from src/src/animation/tracks/NumberKeyframeTrack.d.ts:

/**
 * @extends {THREE.KeyframeTrack}
 * @constructor
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {(undefined|number)=} interpolation
 */
THREE.NumberKeyframeTrack = function(name, times, values, interpolation) {};
/** @type {string} */
THREE.NumberKeyframeTrack.prototype.ValueTypeName;
// externs from src/src/animation/tracks/ColorKeyframeTrack.d.ts:

/**
 * @extends {THREE.KeyframeTrack}
 * @constructor
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {(undefined|number)=} interpolation
 */
THREE.ColorKeyframeTrack = function(name, times, values, interpolation) {};
/** @type {string} */
THREE.ColorKeyframeTrack.prototype.ValueTypeName;
// externs from src/src/animation/tracks/BooleanKeyframeTrack.d.ts:

/**
 * @extends {THREE.KeyframeTrack}
 * @constructor
 * @param {string} name
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 */
THREE.BooleanKeyframeTrack = function(name, times, values) {};
/** @type {string} */
THREE.BooleanKeyframeTrack.prototype.ValueTypeName;
// externs from src/src/animation/PropertyMixer.d.ts:

/**
 * @constructor
 * @param {number} binding
 * @param {string} typeName
 * @param {number} valueSize
 */
THREE.PropertyMixer = function(binding, typeName, valueSize) {};
/** @type {number} */
THREE.PropertyMixer.prototype.binding;
/** @type {number} */
THREE.PropertyMixer.prototype.valueSize;
/** @type {number} */
THREE.PropertyMixer.prototype.buffer;
/** @type {number} */
THREE.PropertyMixer.prototype.cumulativeWeight;
/** @type {number} */
THREE.PropertyMixer.prototype.cumulativeWeightAdditive;
/** @type {number} */
THREE.PropertyMixer.prototype.useCount;
/** @type {number} */
THREE.PropertyMixer.prototype.referenceCount;

/**
 * @param {number} accuIndex
 * @param {number} weight
 * @return {void}
 */
THREE.PropertyMixer.prototype.accumulate = function(accuIndex, weight) {};

/**
 * @param {number} weight
 * @return {void}
 */
THREE.PropertyMixer.prototype.accumulateAdditive = function(weight) {};

/**
 * @param {number} accuIndex
 * @return {void}
 */
THREE.PropertyMixer.prototype.apply = function(accuIndex) {};

/**
 * @return {void}
 */
THREE.PropertyMixer.prototype.saveOriginalState = function() {};

/**
 * @return {void}
 */
THREE.PropertyMixer.prototype.restoreOriginalState = function() {};
// externs from src/src/animation/PropertyBinding.d.ts:

/**
 * @record
 */
THREE.PropertyBinding.ParseTrackNameResults = function() {};
/** @type {string} */
THREE.PropertyBinding.ParseTrackNameResults.prototype.nodeName;
/** @type {string} */
THREE.PropertyBinding.ParseTrackNameResults.prototype.objectName;
/** @type {string} */
THREE.PropertyBinding.ParseTrackNameResults.prototype.objectIndex;
/** @type {string} */
THREE.PropertyBinding.ParseTrackNameResults.prototype.propertyName;
/** @type {string} */
THREE.PropertyBinding.ParseTrackNameResults.prototype.propertyIndex;

/**
 * @constructor
 * @param {number} rootNode
 * @param {string} path
 * @param {Object=} parsedPath
 */
THREE.PropertyBinding = function(rootNode, path, parsedPath) {};
/** @type {string} */
THREE.PropertyBinding.prototype.path;
/** @type {number} */
THREE.PropertyBinding.prototype.parsedPath;
/** @type {number} */
THREE.PropertyBinding.prototype.node;
/** @type {number} */
THREE.PropertyBinding.prototype.rootNode;
/** @type {Object<string,number>} */
THREE.PropertyBinding.prototype.BindingType;
/** @type {Object<string,number>} */
THREE.PropertyBinding.prototype.Versioning;
/** @type {Array<function(): void>} */
THREE.PropertyBinding.prototype.GetterByBindingType;
/** @type {Array<Array<function(): void>>} */
THREE.PropertyBinding.prototype.SetterByBindingTypeAndVersioning;

/**
 * @param {number} targetArray
 * @param {number} offset
 * @return {number}
 */
THREE.PropertyBinding.prototype.getValue = function(targetArray, offset) {};

/**
 * @param {number} sourceArray
 * @param {number} offset
 * @return {void}
 */
THREE.PropertyBinding.prototype.setValue = function(sourceArray, offset) {};

/**
 * @return {void}
 */
THREE.PropertyBinding.prototype.bind = function() {};

/**
 * @return {void}
 */
THREE.PropertyBinding.prototype.unbind = function() {};

/**
 * @param {number} root
 * @param {number} path
 * @param {Object=} parsedPath
 * @return {(!THREE.PropertyBinding|THREE.PropertyBinding.Composite)}
 */
THREE.PropertyBinding.create = function(root, path, parsedPath) {};

/**
 * @param {string} name
 * @return {string}
 */
THREE.PropertyBinding.sanitizeNodeName = function(name) {};

/**
 * @param {string} trackName
 * @return {THREE.PropertyBinding.ParseTrackNameResults}
 */
THREE.PropertyBinding.parseTrackName = function(trackName) {};

/**
 * @param {number} root
 * @param {string} nodeName
 * @return {number}
 */
THREE.PropertyBinding.findNode = function(root, nodeName) {};

/**
 * @constructor
 * @param {number} targetGroup
 * @param {number} path
 * @param {Object=} parsedPath
 */
THREE.PropertyBinding.Composite = function(targetGroup, path, parsedPath) {};

/**
 * @param {number} array
 * @param {number} offset
 * @return {number}
 */
THREE.PropertyBinding.Composite.prototype.getValue = function(array, offset) {};

/**
 * @param {number} array
 * @param {number} offset
 * @return {void}
 */
THREE.PropertyBinding.Composite.prototype.setValue = function(array, offset) {};

/**
 * @return {void}
 */
THREE.PropertyBinding.Composite.prototype.bind = function() {};

/**
 * @return {void}
 */
THREE.PropertyBinding.Composite.prototype.unbind = function() {};
// externs from src/src/animation/AnimationUtils.d.ts:
/** @constructor */
THREE.AnimationUtils = function() {};

/**
 * @param {number} array
 * @param {number} from
 * @param {number} to
 * @return {number}
 */
THREE.AnimationUtils.arraySlice = function(array, from, to) {};

/**
 * @param {number} array
 * @param {number} type
 * @param {boolean} forceClone
 * @return {number}
 */
THREE.AnimationUtils.convertArray = function(array, type, forceClone) {};

/**
 * @param {number} object
 * @return {boolean}
 */
THREE.AnimationUtils.isTypedArray = function(object) {};

/**
 * @param {Array<number>} times
 * @return {Array<number>}
 */
THREE.AnimationUtils.getKeyFrameOrder = function(times) {};

/**
 * @param {Array<Object>} values
 * @param {number} stride
 * @param {Array<number>} order
 * @return {Array<Object>}
 */
THREE.AnimationUtils.sortedArray = function(values, stride, order) {};

/**
 * @param {Array<string>} jsonKeys
 * @param {Array<Object>} times
 * @param {Array<Object>} values
 * @param {string} valuePropertyName
 * @return {void}
 */
THREE.AnimationUtils.flattenJSON = function(jsonKeys, times, values, valuePropertyName) {};

/**
 * @param {THREE.AnimationClip} sourceClip
 * @param {string} name
 * @param {number} startFrame
 * @param {number} endFrame
 * @param {(undefined|number)=} fps
 * @return {THREE.AnimationClip}
 */
THREE.AnimationUtils.subclip = function(sourceClip, name, startFrame, endFrame, fps) {};

/**
 * @param {THREE.AnimationClip} targetClip
 * @param {(undefined|number)=} referenceFrame
 * @param {(undefined|THREE.AnimationClip)=} referenceClip
 * @param {(undefined|number)=} fps
 * @return {THREE.AnimationClip}
 */
THREE.AnimationUtils.makeClipAdditive = function(targetClip, referenceFrame, referenceClip, fps) {};
// externs from src/src/animation/AnimationObjectGroup.d.ts:

/**
 * @constructor
 * @param {...Object} args
 */
THREE.AnimationObjectGroup = function(args) {};
/** @type {string} */
THREE.AnimationObjectGroup.prototype.uuid;
/** @type {{bindingsPerObject: number, objects: {total: number, inUse: number}}} */
THREE.AnimationObjectGroup.prototype.stats;
/** @type {boolean} */
THREE.AnimationObjectGroup.prototype.isAnimationObjectGroup;

/**
 * @param {...Object} args
 * @return {void}
 */
THREE.AnimationObjectGroup.prototype.add = function(args) {};

/**
 * @param {...Object} args
 * @return {void}
 */
THREE.AnimationObjectGroup.prototype.remove = function(args) {};

/**
 * @param {...Object} args
 * @return {void}
 */
THREE.AnimationObjectGroup.prototype.uncache = function(args) {};
// externs from src/src/animation/AnimationAction.d.ts:

/**
 * @record
 */
THREE.AnimationAction;
/** @type {number} */
THREE.AnimationAction.prototype.blendMode;
/** @type {number} */
THREE.AnimationAction.prototype.loop;
/** @type {number} */
THREE.AnimationAction.prototype.time;
/** @type {number} */
THREE.AnimationAction.prototype.timeScale;
/** @type {number} */
THREE.AnimationAction.prototype.weight;
/** @type {number} */
THREE.AnimationAction.prototype.repetitions;
/** @type {boolean} */
THREE.AnimationAction.prototype.paused;
/** @type {boolean} */
THREE.AnimationAction.prototype.enabled;
/** @type {boolean} */
THREE.AnimationAction.prototype.clampWhenFinished;
/** @type {boolean} */
THREE.AnimationAction.prototype.zeroSlopeAtStart;
/** @type {boolean} */
THREE.AnimationAction.prototype.zeroSlopeAtEnd;

/**
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.play = function() {};

/**
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.stop = function() {};

/**
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.reset = function() {};

/**
 * @return {boolean}
 */
THREE.AnimationAction.prototype.isRunning = function() {};

/**
 * @return {boolean}
 */
THREE.AnimationAction.prototype.isScheduled = function() {};

/**
 * @param {number} time
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.startAt = function(time) {};

/**
 * @param {number} mode
 * @param {number} repetitions
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.setLoop = function(mode, repetitions) {};

/**
 * @param {number} weight
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.setEffectiveWeight = function(weight) {};

/**
 * @return {number}
 */
THREE.AnimationAction.prototype.getEffectiveWeight = function() {};

/**
 * @param {number} duration
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.fadeIn = function(duration) {};

/**
 * @param {number} duration
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.fadeOut = function(duration) {};

/**
 * @param {THREE.AnimationAction} fadeOutAction
 * @param {number} duration
 * @param {boolean} warp
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.crossFadeFrom = function(fadeOutAction, duration, warp) {};

/**
 * @param {THREE.AnimationAction} fadeInAction
 * @param {number} duration
 * @param {boolean} warp
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.crossFadeTo = function(fadeInAction, duration, warp) {};

/**
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.stopFading = function() {};

/**
 * @param {number} timeScale
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.setEffectiveTimeScale = function(timeScale) {};

/**
 * @return {number}
 */
THREE.AnimationAction.prototype.getEffectiveTimeScale = function() {};

/**
 * @param {number} duration
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.setDuration = function(duration) {};

/**
 * @param {THREE.AnimationAction} action
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.syncWith = function(action) {};

/**
 * @param {number} duration
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.halt = function(duration) {};

/**
 * @param {number} statTimeScale
 * @param {number} endTimeScale
 * @param {number} duration
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.warp = function(statTimeScale, endTimeScale, duration) {};

/**
 * @return {THREE.AnimationAction}
 */
THREE.AnimationAction.prototype.stopWarping = function() {};

/**
 * @return {THREE.AnimationMixer}
 */
THREE.AnimationAction.prototype.getMixer = function() {};

/**
 * @return {THREE.AnimationClip}
 */
THREE.AnimationAction.prototype.getClip = function() {};

/**
 * @return {THREE.Object3D<THREE.EventDispatcher.Event>}
 */
THREE.AnimationAction.prototype.getRoot = function() {};
// externs from src/src/animation/AnimationMixer.d.ts:

/**
 * @extends {THREE.EventDispatcher} 
 * @constructor
 * @param {(!THREE.Object3D<THREE.EventDispatcher.Event>|THREE.AnimationObjectGroup)} root
 */
THREE.AnimationMixer = function(root) {};
/** @type {number} */
THREE.AnimationMixer.prototype.time;
/** @type {number} */
THREE.AnimationMixer.prototype.timeScale;

/**
 * @param {THREE.AnimationClip} clip
 * @param {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>|THREE.AnimationObjectGroup)=} root
 * @param {(undefined|number)=} blendMode
 * @return {THREE.AnimationAction}
 */
THREE.AnimationMixer.prototype.clipAction = function(clip, root, blendMode) {};

/**
 * @param {THREE.AnimationClip} clip
 * @param {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>|THREE.AnimationObjectGroup)=} root
 * @return {(null|THREE.AnimationAction)}
 */
THREE.AnimationMixer.prototype.existingAction = function(clip, root) {};

/**
 * @return {THREE.AnimationMixer}
 */
THREE.AnimationMixer.prototype.stopAllAction = function() {};

/**
 * @param {number} deltaTime
 * @return {THREE.AnimationMixer}
 */
THREE.AnimationMixer.prototype.update = function(deltaTime) {};

/**
 * @param {number} timeInSeconds
 * @return {THREE.AnimationMixer}
 */
THREE.AnimationMixer.prototype.setTime = function(timeInSeconds) {};

/**
 * @return {(!THREE.Object3D<THREE.EventDispatcher.Event>|THREE.AnimationObjectGroup)}
 */
THREE.AnimationMixer.prototype.getRoot = function() {};

/**
 * @param {THREE.AnimationClip} clip
 * @return {void}
 */
THREE.AnimationMixer.prototype.uncacheClip = function(clip) {};

/**
 * @param {(!THREE.Object3D<THREE.EventDispatcher.Event>|THREE.AnimationObjectGroup)} root
 * @return {void}
 */
THREE.AnimationMixer.prototype.uncacheRoot = function(root) {};

/**
 * @param {THREE.AnimationClip} clip
 * @param {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>|THREE.AnimationObjectGroup)=} root
 * @return {void}
 */
THREE.AnimationMixer.prototype.uncacheAction = function(clip, root) {};
// externs from src/src/audio/AudioContext.d.ts:
/** @constructor */
THREE.AudioContext = function() {};

/**
 * @return {AudioContext}
 */
THREE.AudioContext.getContext = function() {};

/**
 * @return {void}
 */
THREE.AudioContext.setContext = function() {};
// externs from src/src/audio/AudioListener.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 */
THREE.AudioListener = function() {};
/** @type {string} */
THREE.AudioListener.prototype.type;
/** @type {AudioContext} */
THREE.AudioListener.prototype.context;
/** @type {GainNode} */
THREE.AudioListener.prototype.gain;
/** @type {number} */
THREE.AudioListener.prototype.filter;
/** @type {number} */
THREE.AudioListener.prototype.timeDelta;

/**
 * @return {GainNode}
 */
THREE.AudioListener.prototype.getInput = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.AudioListener.prototype.removeFilter = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.AudioListener.prototype.setFilter = function(value) {};

/**
 * @return {number}
 */
THREE.AudioListener.prototype.getFilter = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.AudioListener.prototype.setMasterVolume = function(value) {};

/**
 * @return {number}
 */
THREE.AudioListener.prototype.getMasterVolume = function() {};

/**
 * @param {(undefined|boolean)=} force
 * @return {void}
 */
THREE.AudioListener.prototype.updateMatrixWorld = function(force) {};
// externs from src/src/audio/Audio.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {THREE.AudioListener} listener
 */
THREE.Audio = function(listener) {};
/** @type {string} */
THREE.Audio.prototype.type;
/** @type {THREE.AudioListener} */
THREE.Audio.prototype.listener;
/** @type {AudioContext} */
THREE.Audio.prototype.context;
/** @type {GainNode} */
THREE.Audio.prototype.gain;
/** @type {boolean} */
THREE.Audio.prototype.autoplay;
/** @type {(null|AudioBuffer)} */
THREE.Audio.prototype.buffer;
/** @type {number} */
THREE.Audio.prototype.detune;
/** @type {boolean} */
THREE.Audio.prototype.loop;
/** @type {number} */
THREE.Audio.prototype.loopStart;
/** @type {number} */
THREE.Audio.prototype.loopEnd;
/** @type {number} */
THREE.Audio.prototype.offset;
/** @type {(undefined|number)} */
THREE.Audio.prototype.duration;
/** @type {number} */
THREE.Audio.prototype.playbackRate;
/** @type {boolean} */
THREE.Audio.prototype.isPlaying;
/** @type {boolean} */
THREE.Audio.prototype.hasPlaybackControl;
/** @type {string} */
THREE.Audio.prototype.sourceType;
/** @type {(null|AudioBufferSourceNode)} */
THREE.Audio.prototype.source;
/** @type {Array<GainNode>} */
THREE.Audio.prototype.filters;

/**
 * @return {GainNode}
 */
THREE.Audio.prototype.getOutput = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {AudioBufferSourceNode} audioNode
 * @return {THIS}
 */
THREE.Audio.prototype.setNodeSource = function(audioNode) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {HTMLMediaElement} mediaElement
 * @return {THIS}
 */
THREE.Audio.prototype.setMediaElementSource = function(mediaElement) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {MediaStream} mediaStream
 * @return {THIS}
 */
THREE.Audio.prototype.setMediaStreamSource = function(mediaStream) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {AudioBuffer} audioBuffer
 * @return {THIS}
 */
THREE.Audio.prototype.setBuffer = function(audioBuffer) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {(undefined|number)=} delay
 * @return {THIS}
 */
THREE.Audio.prototype.play = function(delay) {};

/**
 * @return {void}
 */
THREE.Audio.prototype.onEnded = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Audio.prototype.pause = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Audio.prototype.stop = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Audio.prototype.connect = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Audio.prototype.disconnect = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.Audio.prototype.setDetune = function(value) {};

/**
 * @return {number}
 */
THREE.Audio.prototype.getDetune = function() {};

/**
 * @return {Array<GainNode>}
 */
THREE.Audio.prototype.getFilters = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<GainNode>} value
 * @return {THIS}
 */
THREE.Audio.prototype.setFilters = function(value) {};

/**
 * @return {GainNode}
 */
THREE.Audio.prototype.getFilter = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {GainNode} filter
 * @return {THIS}
 */
THREE.Audio.prototype.setFilter = function(filter) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.Audio.prototype.setPlaybackRate = function(value) {};

/**
 * @return {number}
 */
THREE.Audio.prototype.getPlaybackRate = function() {};

/**
 * @return {boolean}
 */
THREE.Audio.prototype.getLoop = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {boolean} value
 * @return {THIS}
 */
THREE.Audio.prototype.setLoop = function(value) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.Audio.prototype.setLoopStart = function(value) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.Audio.prototype.setLoopEnd = function(value) {};

/**
 * @return {number}
 */
THREE.Audio.prototype.getVolume = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.Audio.prototype.setVolume = function(value) {};

/**
 * @deprecated Use {\@link AudioLoader} instead.
 * @param {string} file
 * @return {THREE.Audio<GainNode>}
 */
THREE.Audio.prototype.load = function(file) {};
// externs from src/src/audio/PositionalAudio.d.ts:

/**
 * @extends {THREE.Audio<PannerNode>}
 * @constructor
 * 
 * @param {THREE.AudioListener} listener
 */
THREE.PositionalAudio = function(listener) {};
/** @type {PannerNode} */
THREE.PositionalAudio.prototype.panner;

/**
 * @return {PannerNode}
 */
THREE.PositionalAudio.prototype.getOutput = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.PositionalAudio.prototype.setRefDistance = function(value) {};

/**
 * @return {number}
 */
THREE.PositionalAudio.prototype.getRefDistance = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.PositionalAudio.prototype.setRolloffFactor = function(value) {};

/**
 * @return {number}
 */
THREE.PositionalAudio.prototype.getRolloffFactor = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {string} value
 * @return {THIS}
 */
THREE.PositionalAudio.prototype.setDistanceModel = function(value) {};

/**
 * @return {string}
 */
THREE.PositionalAudio.prototype.getDistanceModel = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} value
 * @return {THIS}
 */
THREE.PositionalAudio.prototype.setMaxDistance = function(value) {};

/**
 * @return {number}
 */
THREE.PositionalAudio.prototype.getMaxDistance = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} coneInnerAngle
 * @param {number} coneOuterAngle
 * @param {number} coneOuterGain
 * @return {THIS}
 */
THREE.PositionalAudio.prototype.setDirectionalCone = function(coneInnerAngle, coneOuterAngle, coneOuterGain) {};

/**
 * @param {(undefined|boolean)=} force
 * @return {void}
 */
THREE.PositionalAudio.prototype.updateMatrixWorld = function(force) {};
// externs from src/src/audio/AudioAnalyser.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.Audio<GainNode>} audio
 * @param {(undefined|number)=} fftSize
 */
THREE.AudioAnalyser = function(audio, fftSize) {};
/** @type {AnalyserNode} */
THREE.AudioAnalyser.prototype.analyser;
/** @type {Uint8Array} */
THREE.AudioAnalyser.prototype.data;

/**
 * @return {Uint8Array}
 */
THREE.AudioAnalyser.prototype.getFrequencyData = function() {};

/**
 * @return {number}
 */
THREE.AudioAnalyser.prototype.getAverageFrequency = function() {};

/**
 * @deprecated Use {\@link AudioAnalyser#getFrequencyData .getFrequencyData()} instead.
 * @param {number} file
 * @return {number}
 */
THREE.AudioAnalyser.prototype.getData = function(file) {};
// externs from src/src/cameras/PerspectiveCamera.d.ts:

/**
 * @extends {THREE.Camera}
 * @constructor
 * 
 * @param {(undefined|number)=} fov
 * @param {(undefined|number)=} aspect
 * @param {(undefined|number)=} near
 * @param {(undefined|number)=} far
 */
THREE.PerspectiveCamera = function(fov, aspect, near, far) {};
/** @type {string} */
THREE.PerspectiveCamera.prototype.type;
/** @type {boolean} */
THREE.PerspectiveCamera.prototype.isPerspectiveCamera;
/** @type {number} */
THREE.PerspectiveCamera.prototype.zoom;
/** @type {number} */
THREE.PerspectiveCamera.prototype.fov;
/** @type {number} */
THREE.PerspectiveCamera.prototype.aspect;
/** @type {number} */
THREE.PerspectiveCamera.prototype.near;
/** @type {number} */
THREE.PerspectiveCamera.prototype.far;
/** @type {number} */
THREE.PerspectiveCamera.prototype.focus;
/** @type {(null|{enabled: boolean, fullWidth: number, fullHeight: number, offsetX: number, offsetY: number, width: number, height: number})} */
THREE.PerspectiveCamera.prototype.view;
/** @type {number} */
THREE.PerspectiveCamera.prototype.filmGauge;
/** @type {number} */
THREE.PerspectiveCamera.prototype.filmOffset;
/** @type {THREE.Vector4} */
THREE.PerspectiveCamera.prototype.viewport;

/**
 * @param {number} focalLength
 * @return {void}
 */
THREE.PerspectiveCamera.prototype.setFocalLength = function(focalLength) {};

/**
 * @return {number}
 */
THREE.PerspectiveCamera.prototype.getFocalLength = function() {};

/**
 * @return {number}
 */
THREE.PerspectiveCamera.prototype.getEffectiveFOV = function() {};

/**
 * @return {number}
 */
THREE.PerspectiveCamera.prototype.getFilmWidth = function() {};

/**
 * @return {number}
 */
THREE.PerspectiveCamera.prototype.getFilmHeight = function() {};

/**
 * Sets an offset in a larger frustum. This is useful for multi-window or multi-monitor/multi-machine setups.
 * For example, if you have 3x2 monitors and each monitor is 1920x1080 and the monitors are in grid like this:
 * 
 * +---+---+---+
 * | A | B | C |
 * +---+---+---+
 * | D | E | F |
 * +---+---+---+
 * 
 * then for each monitor you would call it like this:
 * 
 * const w = 1920;
 * const h = 1080;
 * const fullWidth = w * 3;
 * const fullHeight = h * 2;
 * 
 * // A
 * camera.setViewOffset( fullWidth, fullHeight, w * 0, h * 0, w, h );
 * // B
 * camera.setViewOffset( fullWidth, fullHeight, w * 1, h * 0, w, h );
 * // C
 * camera.setViewOffset( fullWidth, fullHeight, w * 2, h * 0, w, h );
 * // D
 * camera.setViewOffset( fullWidth, fullHeight, w * 0, h * 1, w, h );
 * // E
 * camera.setViewOffset( fullWidth, fullHeight, w * 1, h * 1, w, h );
 * // F
 * camera.setViewOffset( fullWidth, fullHeight, w * 2, h * 1, w, h ); Note there is no reason monitors have to be the same size or in a grid.
 * 
 * @param {number} fullWidth full width of multiview setup
 * @param {number} fullHeight full height of multiview setup
 * @param {number} x horizontal offset of subcamera
 * @param {number} y vertical offset of subcamera
 * @param {number} width width of subcamera
 * @param {number} height height of subcamera
 * @return {void}
 */
THREE.PerspectiveCamera.prototype.setViewOffset = function(fullWidth, fullHeight, x, y, width, height) {};

/**
 * @return {void}
 */
THREE.PerspectiveCamera.prototype.clearViewOffset = function() {};

/**
 * Updates the camera projection matrix. Must be called after change of parameters.
 * @return {void}
 */
THREE.PerspectiveCamera.prototype.updateProjectionMatrix = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.PerspectiveCamera.prototype.toJSON = function(opt_key) {};

/**
 * @deprecated Use {\@link PerspectiveCamera#setFocalLength .setFocalLength()} and {\@link PerspectiveCamera#filmGauge .filmGauge} instead.
 * @param {Number} focalLength
 * @param {(undefined|Number)=} frameHeight
 * @return {void}
 */
THREE.PerspectiveCamera.prototype.setLens = function(focalLength, frameHeight) {};
// externs from src/src/cameras/StereoCamera.d.ts:

/**
 * @extends {THREE.Camera}
 * @constructor
 * 
 */
THREE.StereoCamera = function() {};
/** @type {string} */
THREE.StereoCamera.prototype.type;
/** @type {number} */
THREE.StereoCamera.prototype.aspect;
/** @type {number} */
THREE.StereoCamera.prototype.eyeSep;
/** @type {THREE.PerspectiveCamera} */
THREE.StereoCamera.prototype.cameraL;
/** @type {THREE.PerspectiveCamera} */
THREE.StereoCamera.prototype.cameraR;

/**
 * @param {THREE.PerspectiveCamera} camera
 * @return {void}
 */
THREE.StereoCamera.prototype.update = function(camera) {};
// externs from src/src/cameras/OrthographicCamera.d.ts:

/**
 * @extends {THREE.Camera}
 * @constructor
 * 
 * @param {number} left Camera frustum left plane.
 * @param {number} right Camera frustum right plane.
 * @param {number} top Camera frustum top plane.
 * @param {number} bottom Camera frustum bottom plane.
 * @param {(undefined|number)=} near
 * @param {(undefined|number)=} far
 */
THREE.OrthographicCamera = function(left, right, top, bottom, near, far) {};
/** @type {string} */
THREE.OrthographicCamera.prototype.type;
/** @type {boolean} */
THREE.OrthographicCamera.prototype.isOrthographicCamera;
/** @type {number} */
THREE.OrthographicCamera.prototype.zoom;
/** @type {(null|{enabled: boolean, fullWidth: number, fullHeight: number, offsetX: number, offsetY: number, width: number, height: number})} */
THREE.OrthographicCamera.prototype.view;
/** @type {number} */
THREE.OrthographicCamera.prototype.left;
/** @type {number} */
THREE.OrthographicCamera.prototype.right;
/** @type {number} */
THREE.OrthographicCamera.prototype.top;
/** @type {number} */
THREE.OrthographicCamera.prototype.bottom;
/** @type {number} */
THREE.OrthographicCamera.prototype.near;
/** @type {number} */
THREE.OrthographicCamera.prototype.far;

/**
 * Updates the camera projection matrix. Must be called after change of parameters.
 * @return {void}
 */
THREE.OrthographicCamera.prototype.updateProjectionMatrix = function() {};

/**
 * @param {number} fullWidth
 * @param {number} fullHeight
 * @param {number} offsetX
 * @param {number} offsetY
 * @param {number} width
 * @param {number} height
 * @return {void}
 */
THREE.OrthographicCamera.prototype.setViewOffset = function(fullWidth, fullHeight, offsetX, offsetY, width, height) {};

/**
 * @return {void}
 */
THREE.OrthographicCamera.prototype.clearViewOffset = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.OrthographicCamera.prototype.toJSON = function(opt_key) {};
// externs from src/src/textures/CubeTexture.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {(undefined|Array<Object>)=} images
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} format
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} anisotropy
 * @param {(undefined|number)=} encoding
 */
THREE.CubeTexture = function(images, mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy, encoding) {};
/** @type {number} */
THREE.CubeTexture.prototype.images;
/** @type {boolean} */
THREE.CubeTexture.prototype.flipY;
/** @type {boolean} */
THREE.CubeTexture.prototype.isCubeTexture;
// externs from src/src/renderers/WebGLCubeRenderTarget.d.ts:

/**
 * @constructor
 * 
 * @param {number} size
 * @param {(undefined|THREE.WebGLRenderTargetOptions)=} options
 */
THREE.WebGLCubeRenderTarget = function(size, options) {};
/** @type {THREE.CubeTexture} */
THREE.WebGLCubeRenderTarget.prototype.texture;

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.WebGLRenderer} renderer
 * @param {THREE.Texture} texture
 * @return {THIS}
 */
THREE.WebGLCubeRenderTarget.prototype.fromEquirectangularTexture = function(renderer, texture) {};

/**
 * @param {THREE.WebGLRenderer} renderer
 * @param {boolean} color
 * @param {boolean} depth
 * @param {boolean} stencil
 * @return {void}
 */
THREE.WebGLCubeRenderTarget.prototype.clear = function(renderer, color, depth, stencil) {};
// externs from src/src/cameras/CubeCamera.d.ts:

/**
 * @extends {THREE.Object3D} 
 * @constructor
 * 
 * @param {number} near
 * @param {number} far
 * @param {THREE.WebGLCubeRenderTarget} renderTarget
 */
THREE.CubeCamera = function(near, far, renderTarget) {};
/** @type {string} */
THREE.CubeCamera.prototype.type;
/** @type {THREE.WebGLCubeRenderTarget} */
THREE.CubeCamera.prototype.renderTarget;

/**
 * @param {THREE.WebGLRenderer} renderer
 * @param {THREE.Scene} scene
 * @return {void}
 */
THREE.CubeCamera.prototype.update = function(renderer, scene) {};
// externs from src/src/cameras/ArrayCamera.d.ts:

/**
 * @extends {THREE.PerspectiveCamera} 
 * @constructor
 * 
 * @param {(undefined|Array<THREE.PerspectiveCamera>)=} cameras
 */
THREE.ArrayCamera = function(cameras) {};
/** @type {Array<THREE.PerspectiveCamera>} */
THREE.ArrayCamera.prototype.cameras;
/** @type {boolean} */
THREE.ArrayCamera.prototype.isArrayCamera;
// externs from src/src/core/Uniform.d.ts:

/**
 * @constructor
 * 
 * @deprecated
 * @param {Object|string} value_or_type
 * @param {Object=} value
 */
THREE.Uniform = function(value_or_type, value) {};
/** @type {string} */
THREE.Uniform.prototype.type;
/** @type {number} */
THREE.Uniform.prototype.value;
/** @type {boolean} */
THREE.Uniform.prototype.dynamic;
/** @type {function(): void} */
THREE.Uniform.prototype.onUpdateCallback;

/**
 * @deprecated Use {\@link Object3D#onBeforeRender object.onBeforeRender()} instead.
 * @param {function(): void} callback
 * @return {THREE.Uniform}
 */
THREE.Uniform.prototype.onUpdate = function(callback) {};
// externs from src/src/core/InstancedBufferGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 */
THREE.InstancedBufferGeometry = function() {};
/** @type {string} */
THREE.InstancedBufferGeometry.prototype.type;
/** @type {boolean} */
THREE.InstancedBufferGeometry.prototype.isInstancedBufferGeometry;
/** @type {Array<{start: number, count: number, instances: number}>} */
THREE.InstancedBufferGeometry.prototype.groups;
/** @type {number} */
THREE.InstancedBufferGeometry.prototype.instanceCount;

/**
 * @param {number} start
 * @param {number} count
 * @param {number} instances
 * @return {void}
 */
THREE.InstancedBufferGeometry.prototype.addGroup = function(start, count, instances) {};
// externs from src/src/core/InstancedInterleavedBuffer.d.ts:

/**
 * @extends {THREE.InterleavedBuffer}
 * @constructor
 * 
 * @param {Array<number>} array
 * @param {number} stride
 * @param {(undefined|number)=} meshPerAttribute
 */
THREE.InstancedInterleavedBuffer = function(array, stride, meshPerAttribute) {};
/** @type {number} */
THREE.InstancedInterleavedBuffer.prototype.meshPerAttribute;
// externs from src/src/core/InstancedBufferAttribute.d.ts:

/**
 * @constructor
 * 
 */
THREE.BufferGeometryUtils = function() {};

/**
 * @param {Array<THREE.BufferGeometry>} geometries
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometryUtils.mergeBufferGeometries = function(geometries) {};

/**
 * @param {Array<THREE.BufferAttribute>} attributes
 * @return {THREE.BufferAttribute}
 */
THREE.BufferGeometryUtils.mergeBufferAttributes = function(attributes) {};

/**
 * @extends {THREE.BufferAttribute}
 * @constructor
 * 
 * @param {Array<number>} array
 * @param {number} itemSize
 * @param {(undefined|boolean)=} normalized
 * @param {(undefined|number)=} meshPerAttribute
 */
THREE.InstancedBufferAttribute = function(array, itemSize, normalized, meshPerAttribute) {};
/** @type {number} */
THREE.InstancedBufferAttribute.prototype.meshPerAttribute;
// externs from src/src/core/GLBufferAttribute.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLBuffer} buffer
 * @param {number} type
 * @param {number} itemSize
 * @param {number} elementSize
 * @param {number} count
 */
THREE.GLBufferAttribute = function(buffer, type, itemSize, elementSize, count) {};
/** @type {WebGLBuffer} */
THREE.GLBufferAttribute.prototype.buffer;
/** @type {number} */
THREE.GLBufferAttribute.prototype.type;
/** @type {number} */
THREE.GLBufferAttribute.prototype.itemSize;
/** @type {number} */
THREE.GLBufferAttribute.prototype.elementSize;
/** @type {number} */
THREE.GLBufferAttribute.prototype.count;
/** @type {number} */
THREE.GLBufferAttribute.prototype.version;
/** @type {boolean} */
THREE.GLBufferAttribute.prototype.isGLBufferAttribute;

/* TODO: SetAccessor: THREE.GLBufferAttribute.needsUpdate */

/**
 * @template THIS
 * @this {THIS}
 * @param {WebGLBuffer} buffer
 * @return {THIS}
 */
THREE.GLBufferAttribute.prototype.setBuffer = function(buffer) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} type
 * @param {number} elementSize
 * @return {THIS}
 */
THREE.GLBufferAttribute.prototype.setType = function(type, elementSize) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} itemSize
 * @return {THIS}
 */
THREE.GLBufferAttribute.prototype.setItemSize = function(itemSize) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} count
 * @return {THIS}
 */
THREE.GLBufferAttribute.prototype.setCount = function(count) {};
// externs from src/src/core/Clock.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|boolean)=} autoStart
 */
THREE.Clock = function(autoStart) {};
/** @type {boolean} */
THREE.Clock.prototype.autoStart;
/** @type {number} */
THREE.Clock.prototype.startTime;
/** @type {number} */
THREE.Clock.prototype.oldTime;
/** @type {number} */
THREE.Clock.prototype.elapsedTime;
/** @type {boolean} */
THREE.Clock.prototype.running;

/**
 * Starts clock.
 * @return {void}
 */
THREE.Clock.prototype.start = function() {};

/**
 * Stops clock.
 * @return {void}
 */
THREE.Clock.prototype.stop = function() {};

/**
 * Get the seconds passed since the clock started.
 * @return {number}
 */
THREE.Clock.prototype.getElapsedTime = function() {};

/**
 * Get the seconds passed since the last call to this method.
 * @return {number}
 */
THREE.Clock.prototype.getDelta = function() {};
// externs from src/src/extras/core/Curve.d.ts:

/**
 * @constructor
 */
THREE.Curve = function() {};
/** @type {string} */
THREE.Curve.prototype.type;
/** @type {number} */
THREE.Curve.prototype.arcLengthDivisions;

/**
 * Returns a vector for point t of the curve where t is between 0 and 1
 * getPoint(t: number, optionalTargetObject: T): T;
 * @param {number} t
 * @param {(undefined|THREE.Vector)=} optionalTarget
 * @return {THREE.Vector}
 */
THREE.Curve.prototype.getPoint = function(t, optionalTarget) {};

/**
 * Returns a vector for point at relative position in curve according to arc length
 * getPointAt(u: number, optionalTargetObject: T): T;
 * @param {number} u
 * @param {(undefined|THREE.Vector)=} optionalTarget
 * @return {THREE.Vector}
 */
THREE.Curve.prototype.getPointAt = function(u, optionalTarget) {};

/**
 * Get sequence of points using getPoint( t )
 * getPoints(divisionsObject: number): T[];
 * @param {(undefined|number)=} divisions
 * @return {Array<THREE.Vector>}
 */
THREE.Curve.prototype.getPoints = function(divisions) {};

/**
 * Get sequence of equi-spaced points using getPointAt( u )
 * getSpacedPoints(divisionsObject: number): T[];
 * @param {(undefined|number)=} divisions
 * @return {Array}
 */
THREE.Curve.prototype.getSpacedPoints = function(divisions) {};

/**
 * Get total curve arc length
 * @return {number}
 */
THREE.Curve.prototype.getLength = function() {};

/**
 * Get list of cumulative segment lengths
 * @param {(undefined|number)=} divisions
 * @return {Array<number>}
 */
THREE.Curve.prototype.getLengths = function(divisions) {};

/**
 * Update the cumlative segment distance cache
 * @return {void}
 */
THREE.Curve.prototype.updateArcLengths = function() {};

/**
 * Given u ( 0 .. 1 ), get a t to find p. This gives you points which are equi distance
 * @param {number} u
 * @param {number} distance
 * @return {number}
 */
THREE.Curve.prototype.getUtoTmapping = function(u, distance) {};

/**
 * Returns a unit vector tangent at t. If the subclassed curve do not implement its tangent derivation, 2 points a
 * small delta apart will be used to find its gradient which seems to give a reasonable approximation
 * getTangent(t: number, optionalTargetObject: T): T;
 * @param {number} t
 * @param {(undefined|THREE.Vector)=} optionalTarget
 * @return {THREE.Vector}
 */
THREE.Curve.prototype.getTangent = function(t, optionalTarget) {};

/**
 * Returns tangent at equidistance point u on the curve
 * getTangentAt(u: number, optionalTargetObject: T): T;
 * @param {number} u
 * @param {(undefined|THREE.Vector)=} optionalTarget
 * @return {THREE.Vector}
 */
THREE.Curve.prototype.getTangentAt = function(u, optionalTarget) {};

/**
 * Generate Frenet frames of the curve
 * @param {number} segments
 * @param {(undefined|boolean)=} closed
 * @return {{tangents: Array<THREE.Vector3>, normals: Array<THREE.Vector3>, binormals: Array<THREE.Vector3>}}
 */
THREE.Curve.prototype.computeFrenetFrames = function(segments, closed) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Curve.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Curve} source
 * @return {THIS}
 */
THREE.Curve.prototype.copy = function(source) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.Curve.prototype.toJSON = function(opt_key) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Object} json
 * @return {THIS}
 */
THREE.Curve.prototype.fromJSON = function(json) {};

/**
 * @deprecated since r84.
 * @param {function(): void} constructorFunc
 * @param {function(): void} getPointFunc
 * @return {function(): void}
 */
THREE.Curve.create = function(constructorFunc, getPointFunc) {};
// externs from src/src/extras/curves/EllipseCurve.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector2>}
 * @constructor
 * 
 * @param {number} aX
 * @param {number} aY
 * @param {number} xRadius
 * @param {number} yRadius
 * @param {number} aStartAngle
 * @param {number} aEndAngle
 * @param {boolean} aClockwise
 * @param {number} aRotation
 */
THREE.EllipseCurve = function(aX, aY, xRadius, yRadius, aStartAngle, aEndAngle, aClockwise, aRotation) {};
/** @type {string} */
THREE.EllipseCurve.prototype.type;
/** @type {number} */
THREE.EllipseCurve.prototype.aX;
/** @type {number} */
THREE.EllipseCurve.prototype.aY;
/** @type {number} */
THREE.EllipseCurve.prototype.xRadius;
/** @type {number} */
THREE.EllipseCurve.prototype.yRadius;
/** @type {number} */
THREE.EllipseCurve.prototype.aStartAngle;
/** @type {number} */
THREE.EllipseCurve.prototype.aEndAngle;
/** @type {boolean} */
THREE.EllipseCurve.prototype.aClockwise;
/** @type {number} */
THREE.EllipseCurve.prototype.aRotation;
// externs from src/src/extras/curves/ArcCurve.d.ts:

/**
 * @extends {THREE.EllipseCurve}
 * @constructor
 * 
 * @param {number} aX
 * @param {number} aY
 * @param {number} aRadius
 * @param {number} aStartAngle
 * @param {number} aEndAngle
 * @param {boolean} aClockwise
 */
THREE.ArcCurve = function(aX, aY, aRadius, aStartAngle, aEndAngle, aClockwise) {};
/** @type {string} */
THREE.ArcCurve.prototype.type;

/** @const */
THREE.CatmullRomCurve3.CurveUtils = function() {};

/**
 * @param {number} t
 * @param {number} p0
 * @param {number} p1
 * @param {number} p2
 * @return {number}
 */
THREE.CatmullRomCurve3.CurveUtils.tangentQuadraticBezier = function(t, p0, p1, p2) {};

/**
 * @param {number} t
 * @param {number} p0
 * @param {number} p1
 * @param {number} p2
 * @param {number} p3
 * @return {number}
 */
THREE.CatmullRomCurve3.CurveUtils.tangentCubicBezier = function(t, p0, p1, p2, p3) {};

/**
 * @param {number} t
 * @param {number} p0
 * @param {number} p1
 * @param {number} p2
 * @param {number} p3
 * @return {number}
 */
THREE.CatmullRomCurve3.CurveUtils.tangentSpline = function(t, p0, p1, p2, p3) {};

/**
 * @param {number} p0
 * @param {number} p1
 * @param {number} p2
 * @param {number} p3
 * @param {number} t
 * @return {number}
 */
THREE.CatmullRomCurve3.CurveUtils.interpolate = function(p0, p1, p2, p3, t) {};

/**
 * @constructor
 * 
 * @param {(undefined|Array<THREE.Vector3>)=} points
 * @param {(undefined|boolean)=} closed
 * @param {(undefined|string)=} curveType
 * @param {(undefined|number)=} tension
 */
THREE.CatmullRomCurve3 = function(points, closed, curveType, tension) {};
/** @type {string} */
THREE.CatmullRomCurve3.prototype.type;
/** @type {Array<THREE.Vector3>} */
THREE.CatmullRomCurve3.prototype.points;
// externs from src/src/extras/curves/CubicBezierCurve.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector2>}
 * @constructor
 * 
 * @param {THREE.Vector2} v0
 * @param {THREE.Vector2} v1
 * @param {THREE.Vector2} v2
 * @param {THREE.Vector2} v3
 */
THREE.CubicBezierCurve = function(v0, v1, v2, v3) {};
/** @type {string} */
THREE.CubicBezierCurve.prototype.type;
/** @type {THREE.Vector2} */
THREE.CubicBezierCurve.prototype.v0;
/** @type {THREE.Vector2} */
THREE.CubicBezierCurve.prototype.v1;
/** @type {THREE.Vector2} */
THREE.CubicBezierCurve.prototype.v2;
/** @type {THREE.Vector2} */
THREE.CubicBezierCurve.prototype.v3;
// externs from src/src/extras/curves/CubicBezierCurve3.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector3>}
 * @constructor
 * 
 * @param {THREE.Vector3} v0
 * @param {THREE.Vector3} v1
 * @param {THREE.Vector3} v2
 * @param {THREE.Vector3} v3
 */
THREE.CubicBezierCurve3 = function(v0, v1, v2, v3) {};
/** @type {string} */
THREE.CubicBezierCurve3.prototype.type;
/** @type {THREE.Vector3} */
THREE.CubicBezierCurve3.prototype.v0;
/** @type {THREE.Vector3} */
THREE.CubicBezierCurve3.prototype.v1;
/** @type {THREE.Vector3} */
THREE.CubicBezierCurve3.prototype.v2;
/** @type {THREE.Vector3} */
THREE.CubicBezierCurve3.prototype.v3;
// externs from src/src/extras/curves/LineCurve.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector2>}
 * @constructor
 * 
 * @param {THREE.Vector2} v1
 * @param {THREE.Vector2} v2
 */
THREE.LineCurve = function(v1, v2) {};
/** @type {string} */
THREE.LineCurve.prototype.type;
/** @type {THREE.Vector2} */
THREE.LineCurve.prototype.v1;
/** @type {THREE.Vector2} */
THREE.LineCurve.prototype.v2;
// externs from src/src/extras/curves/LineCurve3.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector3>}
 * @constructor
 * 
 * @param {THREE.Vector3} v1
 * @param {THREE.Vector3} v2
 */
THREE.LineCurve3 = function(v1, v2) {};
/** @type {string} */
THREE.LineCurve3.prototype.type;
/** @type {THREE.Vector3} */
THREE.LineCurve3.prototype.v1;
/** @type {THREE.Vector3} */
THREE.LineCurve3.prototype.v2;
// externs from src/src/extras/curves/QuadraticBezierCurve.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector2>}
 * @constructor
 * 
 * @param {THREE.Vector2} v0
 * @param {THREE.Vector2} v1
 * @param {THREE.Vector2} v2
 */
THREE.QuadraticBezierCurve = function(v0, v1, v2) {};
/** @type {string} */
THREE.QuadraticBezierCurve.prototype.type;
/** @type {THREE.Vector2} */
THREE.QuadraticBezierCurve.prototype.v0;
/** @type {THREE.Vector2} */
THREE.QuadraticBezierCurve.prototype.v1;
/** @type {THREE.Vector2} */
THREE.QuadraticBezierCurve.prototype.v2;
// externs from src/src/extras/curves/QuadraticBezierCurve3.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector3>}
 * @constructor
 * 
 * @param {THREE.Vector3} v0
 * @param {THREE.Vector3} v1
 * @param {THREE.Vector3} v2
 */
THREE.QuadraticBezierCurve3 = function(v0, v1, v2) {};
/** @type {string} */
THREE.QuadraticBezierCurve3.prototype.type;
/** @type {THREE.Vector3} */
THREE.QuadraticBezierCurve3.prototype.v0;
/** @type {THREE.Vector3} */
THREE.QuadraticBezierCurve3.prototype.v1;
/** @type {THREE.Vector3} */
THREE.QuadraticBezierCurve3.prototype.v2;
// externs from src/src/extras/curves/SplineCurve.d.ts:

/**
 * @extends {THREE.Curve<THREE.Vector2>}
 * @constructor
 * 
 * @param {(undefined|Array<THREE.Vector2>)=} points
 */
THREE.SplineCurve = function(points) {};
/** @type {string} */
THREE.SplineCurve.prototype.type;
/** @type {Array<THREE.Vector2>} */
THREE.SplineCurve.prototype.points;
// externs from src/src/extras/curves/Curves.d.ts:

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves

// TODO(tsickle): export * declaration in THREE.Curves
// externs from src/src/extras/core/CurvePath.d.ts:

/**
 * @extends {THREE.Curve} 
 * @constructor
 * 
 */
THREE.CurvePath = function() {};
/** @type {string} */
THREE.CurvePath.prototype.type;
/** @type {Array<THREE.Curve>} */
THREE.CurvePath.prototype.curves;
/** @type {boolean} */
THREE.CurvePath.prototype.autoClose;

/**
 * @param {THREE.Curve} curve
 * @return {void}
 */
THREE.CurvePath.prototype.add = function(curve) {};

/**
 * @return {void}
 */
THREE.CurvePath.prototype.closePath = function() {};

/**
 * @return {Array<number>}
 */
THREE.CurvePath.prototype.getCurveLengths = function() {};
// externs from src/src/extras/core/Path.d.ts:

/**
 * @extends {THREE.CurvePath<THREE.Vector2>}
 * @constructor
 * 
 * @param {(undefined|Array<THREE.Vector2>)=} points
 */
THREE.Path = function(points) {};
/** @type {string} */
THREE.Path.prototype.type;
/** @type {THREE.Vector2} */
THREE.Path.prototype.currentPoint;

/**
 * @deprecated Use {\@link Path#setFromPoints .setFromPoints()} instead.
 * @template THIS
 * @this {THIS}
 * @param {Array<THREE.Vector2>} vectors
 * @return {THIS}
 */
THREE.Path.prototype.fromPoints = function(vectors) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<THREE.Vector2>} vectors
 * @return {THIS}
 */
THREE.Path.prototype.setFromPoints = function(vectors) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @return {THIS}
 */
THREE.Path.prototype.moveTo = function(x, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @return {THIS}
 */
THREE.Path.prototype.lineTo = function(x, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aCPx
 * @param {number} aCPy
 * @param {number} aX
 * @param {number} aY
 * @return {THIS}
 */
THREE.Path.prototype.quadraticCurveTo = function(aCPx, aCPy, aX, aY) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aCP1x
 * @param {number} aCP1y
 * @param {number} aCP2x
 * @param {number} aCP2y
 * @param {number} aX
 * @param {number} aY
 * @return {THIS}
 */
THREE.Path.prototype.bezierCurveTo = function(aCP1x, aCP1y, aCP2x, aCP2y, aX, aY) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<THREE.Vector2>} pts
 * @return {THIS}
 */
THREE.Path.prototype.splineThru = function(pts) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aX
 * @param {number} aY
 * @param {number} aRadius
 * @param {number} aStartAngle
 * @param {number} aEndAngle
 * @param {boolean} aClockwise
 * @return {THIS}
 */
THREE.Path.prototype.arc = function(aX, aY, aRadius, aStartAngle, aEndAngle, aClockwise) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aX
 * @param {number} aY
 * @param {number} aRadius
 * @param {number} aStartAngle
 * @param {number} aEndAngle
 * @param {boolean} aClockwise
 * @return {THIS}
 */
THREE.Path.prototype.absarc = function(aX, aY, aRadius, aStartAngle, aEndAngle, aClockwise) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aX
 * @param {number} aY
 * @param {number} xRadius
 * @param {number} yRadius
 * @param {number} aStartAngle
 * @param {number} aEndAngle
 * @param {boolean} aClockwise
 * @param {number} aRotation
 * @return {THIS}
 */
THREE.Path.prototype.ellipse = function(aX, aY, xRadius, yRadius, aStartAngle, aEndAngle, aClockwise, aRotation) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aX
 * @param {number} aY
 * @param {number} xRadius
 * @param {number} yRadius
 * @param {number} aStartAngle
 * @param {number} aEndAngle
 * @param {boolean} aClockwise
 * @param {number} aRotation
 * @return {THIS}
 */
THREE.Path.prototype.absellipse = function(aX, aY, xRadius, yRadius, aStartAngle, aEndAngle, aClockwise, aRotation) {};
// externs from src/src/extras/core/Shape.d.ts:

/**
 * @extends {THREE.Path}
 * @constructor
 * 
 * @param {(undefined|Array<THREE.Vector2>)=} points
 */
THREE.Shape = function(points) {};
/** @type {string} */
THREE.Shape.prototype.type;
/** @type {string} */
THREE.Shape.prototype.uuid;
/** @type {Array<THREE.Path>} */
THREE.Shape.prototype.holes;

/**
 * @param {number} divisions
 * @return {Array<Array<THREE.Vector2>>}
 */
THREE.Shape.prototype.getPointsHoles = function(divisions) {};

/**
 * @param {number} divisions
 * @return {{shape: Array<THREE.Vector2>, holes: Array<Array<THREE.Vector2>>}}
 */
THREE.Shape.prototype.extractPoints = function(divisions) {};
// externs from src/src/extras/core/ShapePath.d.ts:

/**
 * @constructor
 * 
 */
THREE.ShapePath = function() {};
/** @type {string} */
THREE.ShapePath.prototype.type;
/** @type {THREE.Color} */
THREE.ShapePath.prototype.color;
/** @type {Array<Object>} */
THREE.ShapePath.prototype.subPaths;
/** @type {number} */
THREE.ShapePath.prototype.currentPath;

/**
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @return {THIS}
 */
THREE.ShapePath.prototype.moveTo = function(x, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} x
 * @param {number} y
 * @return {THIS}
 */
THREE.ShapePath.prototype.lineTo = function(x, y) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aCPx
 * @param {number} aCPy
 * @param {number} aX
 * @param {number} aY
 * @return {THIS}
 */
THREE.ShapePath.prototype.quadraticCurveTo = function(aCPx, aCPy, aX, aY) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {number} aCP1x
 * @param {number} aCP1y
 * @param {number} aCP2x
 * @param {number} aCP2y
 * @param {number} aX
 * @param {number} aY
 * @return {THIS}
 */
THREE.ShapePath.prototype.bezierCurveTo = function(aCP1x, aCP1y, aCP2x, aCP2y, aX, aY) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Array<THREE.Vector2>} pts
 * @return {THIS}
 */
THREE.ShapePath.prototype.splineThru = function(pts) {};

/**
 * @param {boolean} isCCW
 * @param {(undefined|boolean)=} noHoles
 * @return {Array<THREE.Shape>}
 */
THREE.ShapePath.prototype.toShapes = function(isCCW, noHoles) {};
// externs from src/src/extras/DataUtils.d.ts:
/** @const */
THREE.DataUtils = function() {};

/**
 * @param {number} val
 * @return {number}
 */
THREE.DataUtils.toHalfFloat = function(val) {};
// externs from src/src/extras/ImageUtils.d.ts:
/** @const */
THREE.ImageUtils = function() {};

/**
 * @param {number} image
 * @return {string}
 */
THREE.ImageUtils.getDataURL = function(image) {};
/** @type {string} */
THREE.ImageUtils.crossOrigin;

/**
 * @deprecated Use {\@link TextureLoader THREE.TextureLoader()} instead.
 * @param {string} url
 * @param {(undefined|number)=} mapping
 * @param {(undefined|function(!THREE.Texture): void)=} onLoad
 * @param {(undefined|function(string): void)=} onError
 * @return {THREE.Texture}
 */
THREE.ImageUtils.loadTexture = function(url, mapping, onLoad, onError) {};

/**
 * @deprecated Use {\@link CubeTextureLoader THREE.CubeTextureLoader()} instead.
 * @param {Array<string>} array
 * @param {(undefined|number)=} mapping
 * @param {(undefined|function(!THREE.Texture): void)=} onLoad
 * @param {(undefined|function(string): void)=} onError
 * @return {THREE.Texture}
 */
THREE.ImageUtils.loadTextureCube = function(array, mapping, onLoad, onError) {};
// externs from src/src/extras/ShapeUtils.d.ts:
/** @constructor */
THREE.ShapeUtils = function() {};
/**
 * @record
 * 
 */
THREE.ShapeUtils.Vec2 = function() {};
/** @type {number} */
THREE.ShapeUtils.Vec2.prototype.x;
/** @type {number} */
THREE.ShapeUtils.Vec2.prototype.y;

/**
 * @param {Array<THREE.ShapeUtils.Vec2>} contour
 * @return {number}
 */
THREE.ShapeUtils.area = function(contour) {};

/**
 * @param {Array<THREE.ShapeUtils.Vec2>} contour
 * @param {Array<Array<THREE.ShapeUtils.Vec2>>} holes
 * @return {Array<Array<number>>}
 */
THREE.ShapeUtils.triangulateShape = function(contour, holes) {};

/**
 * @param {Array<THREE.ShapeUtils.Vec2>} pts
 * @return {boolean}
 */
THREE.ShapeUtils.isClockWise = function(pts) {};
// externs from src/src/extras/PMREMGenerator.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLRenderer} renderer
 */
THREE.PMREMGenerator = function(renderer) {};

/**
 * @param {THREE.Scene} scene
 * @param {(undefined|number)=} sigma
 * @param {(undefined|number)=} near
 * @param {(undefined|number)=} far
 * @return {THREE.WebGLRenderTarget}
 */
THREE.PMREMGenerator.prototype.fromScene = function(scene, sigma, near, far) {};

/**
 * @param {THREE.Texture} equirectangular
 * @return {THREE.WebGLRenderTarget}
 */
THREE.PMREMGenerator.prototype.fromEquirectangular = function(equirectangular) {};

/**
 * @param {THREE.CubeTexture} cubemap
 * @return {THREE.WebGLRenderTarget}
 */
THREE.PMREMGenerator.prototype.fromCubemap = function(cubemap) {};

/**
 * @return {void}
 */
THREE.PMREMGenerator.prototype.compileCubemapShader = function() {};

/**
 * @return {void}
 */
THREE.PMREMGenerator.prototype.compileEquirectangularShader = function() {};

/**
 * @return {void}
 */
THREE.PMREMGenerator.prototype.dispose = function() {};
// externs from src/src/geometries/BoxGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} depth
 * @param {(undefined|number)=} widthSegments
 * @param {(undefined|number)=} heightSegments
 * @param {(undefined|number)=} depthSegments
 */
THREE.BoxGeometry = function(width, height, depth, widthSegments, heightSegments, depthSegments) {};
/** @type {string} */
THREE.BoxGeometry.prototype.type;
/** @type {{width: number, height: number, depth: number, widthSegments: number, heightSegments: number, depthSegments: number}} */
THREE.BoxGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.BoxGeometry}
 */
THREE.BoxGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/CircleGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} segments
 * @param {(undefined|number)=} thetaStart
 * @param {(undefined|number)=} thetaLength
 */
THREE.CircleGeometry = function(radius, segments, thetaStart, thetaLength) {};
/** @type {string} */
THREE.CircleGeometry.prototype.type;
/** @type {{radius: number, segments: number, thetaStart: number, thetaLength: number}} */
THREE.CircleGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.CircleGeometry}
 */
THREE.CircleGeometry.fromJSON = function(data) {};
// externs from src/src/geometries/CylinderGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radiusTop
 * @param {(undefined|number)=} radiusBottom
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} radialSegments
 * @param {(undefined|number)=} heightSegments
 * @param {(undefined|boolean)=} openEnded
 * @param {(undefined|number)=} thetaStart
 * @param {(undefined|number)=} thetaLength
 */
THREE.CylinderGeometry = function(radiusTop, radiusBottom, height, radialSegments, heightSegments, openEnded, thetaStart, thetaLength) {};
/** @type {string} */
THREE.CylinderGeometry.prototype.type;
/** @type {{radiusTop: number, radiusBottom: number, height: number, radialSegments: number, heightSegments: number, openEnded: boolean, thetaStart: number, thetaLength: number}} */
THREE.CylinderGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.CylinderGeometry}
 */
THREE.CylinderGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/ConeGeometry.d.ts:

/**
 * @extends {THREE.CylinderGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} radialSegments
 * @param {(undefined|number)=} heightSegments
 * @param {(undefined|boolean)=} openEnded
 * @param {(undefined|number)=} thetaStart
 * @param {(undefined|number)=} thetaLength
 */
THREE.ConeGeometry = function(radius, height, radialSegments, heightSegments, openEnded, thetaStart, thetaLength) {};
/** @type {string} */
THREE.ConeGeometry.prototype.type;

// externs from src/src/geometries/PolyhedronGeometry.d.ts:

/**
 * @constructor
 * @extends {THREE.BufferGeometry}
 * @param {(undefined|Array<number>)=} vertices
 * @param {(undefined|Array<number>)=} indices
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} detail
 */
THREE.PolyhedronGeometry = function(vertices, indices, radius, detail) {};
/** @type {string} */
THREE.PolyhedronGeometry.prototype.type;
/** @type {{vertices: Array<number>, indices: Array<number>, radius: number, detail: number}} */
THREE.PolyhedronGeometry.prototype.parameters;

/**
 * @param {*} data
 * @return {THREE.PolyhedronGeometry}
 */
THREE.PolyhedronGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/DodecahedronGeometry.d.ts:

/**
 * @extends {THREE.PolyhedronGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} detail
 */
THREE.DodecahedronGeometry = function(radius, detail) {};
/** @type {string} */
THREE.DodecahedronGeometry.prototype.type;

/**
 * @param {Object} data
 * @return {THREE.DodecahedronGeometry}
 */
THREE.DodecahedronGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/EdgesGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @template TBufferGeometry
 * @constructor
 * 
 * @param {(undefined|TBufferGeometry)=} geometry
 * @param {(undefined|number)=} thresholdAngle
 */
THREE.EdgesGeometry = function(geometry, thresholdAngle) {};
/** @type {string} */
THREE.EdgesGeometry.prototype.type;
/** @type {{geometry: TBufferGeometry, thresholdAngle: number}} */
THREE.EdgesGeometry.prototype.parameters;
// externs from src/src/geometries/ExtrudeGeometry.d.ts:

/**
 * @record
 * 
 */
THREE.ExtrudeGeometryOptions = function() {};
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.curveSegments;
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.steps;
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.depth;
/** @type {(undefined|boolean)} */
THREE.ExtrudeGeometryOptions.prototype.bevelEnabled;
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.bevelThickness;
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.bevelSize;
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.bevelOffset;
/** @type {(undefined|number)} */
THREE.ExtrudeGeometryOptions.prototype.bevelSegments;
/** @type {(undefined|THREE.Curve<THREE.Vector3>)} */
THREE.ExtrudeGeometryOptions.prototype.extrudePath;

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|THREE.Shape|Array<THREE.Shape>)=} shapes
 * @param {(undefined|THREE.ExtrudeGeometryOptions)=} options
 */
THREE.ExtrudeGeometry = function(shapes, options) {};
/** @type {string} */
THREE.ExtrudeGeometry.prototype.type;

/**
 * @param {Array<THREE.Shape>} shapes
 * @param {Object=} options
 * @return {void}
 */
THREE.ExtrudeGeometry.prototype.addShapeList = function(shapes, options) {};

/**
 * @param {THREE.Shape} shape
 * @param {Object=} options
 * @return {void}
 */
THREE.ExtrudeGeometry.prototype.addShape = function(shape, options) {};

/**
 * @param {Object} data
 * @return {THREE.ExtrudeGeometry}
 */
THREE.ExtrudeGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/IcosahedronGeometry.d.ts:

/**
 * @extends {THREE.PolyhedronGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} detail
 */
THREE.IcosahedronGeometry = function(radius, detail) {};
/** @type {string} */
THREE.IcosahedronGeometry.prototype.type;

/**
 * @param {Object} data
 * @return {THREE.IcosahedronGeometry}
 */
THREE.IcosahedronGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/LatheGeometry.d.ts:

/**
 * @constructor
 * @extends {THREE.BufferGeometry}
 * @param {(undefined|Array<THREE.Vector2>)=} points
 * @param {(undefined|number)=} segments
 * @param {(undefined|number)=} phiStart
 * @param {(undefined|number)=} phiLength
 */
THREE.LatheGeometry = function(points, segments, phiStart, phiLength) {};
/** @type {string} */
THREE.LatheGeometry.prototype.type;
/** @type {{points: Array<THREE.Vector2>, segments: number, phiStart: number, phiLength: number}} */
THREE.LatheGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.LatheGeometry}
 */
THREE.LatheGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/OctahedronGeometry.d.ts:

/**
 * @constructor
 * @extends {THREE.PolyhedronGeometry}
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} detail
 */
THREE.OctahedronGeometry = function(radius, detail) {};
/** @type {string} */
THREE.OctahedronGeometry.prototype.type;

/**
 * @param {Object} data
 * @return {THREE.OctahedronGeometry}
 */
THREE.OctahedronGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/PlaneGeometry.d.ts:

/**
 * @constructor
 * @extends {THREE.BoxGeometry}
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} widthSegments
 * @param {(undefined|number)=} heightSegments
 */
THREE.PlaneGeometry = function(width, height, widthSegments, heightSegments) {};
/** @type {string} */
THREE.PlaneGeometry.prototype.type;
/** @type {{width: number, height: number, widthSegments: number, heightSegments: number}} */
THREE.PlaneGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.PlaneGeometry}
 */
THREE.PlaneGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/RingGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} innerRadius
 * @param {(undefined|number)=} outerRadius
 * @param {(undefined|number)=} thetaSegments
 * @param {(undefined|number)=} phiSegments
 * @param {(undefined|number)=} thetaStart
 * @param {(undefined|number)=} thetaLength
 */
THREE.RingGeometry = function(innerRadius, outerRadius, thetaSegments, phiSegments, thetaStart, thetaLength) {};
/** @type {string} */
THREE.RingGeometry.prototype.type;
/** @type {{innerRadius: number, outerRadius: number, thetaSegments: number, phiSegments: number, thetaStart: number, thetaLength: number}} */
THREE.RingGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.RingGeometry}
 */
THREE.RingGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/ShapeGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|THREE.Shape|Array<THREE.Shape>)=} shapes
 * @param {(undefined|number)=} curveSegments
 */
THREE.ShapeGeometry = function(shapes, curveSegments) {};
/** @type {string} */
THREE.ShapeGeometry.prototype.type;

/**
 * @param {Object} data
 * @return {THREE.ShapeGeometry}
 */
THREE.ShapeGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/SphereGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} widthSegments
 * @param {(undefined|number)=} heightSegments
 * @param {(undefined|number)=} phiStart
 * @param {(undefined|number)=} phiLength
 * @param {(undefined|number)=} thetaStart
 * @param {(undefined|number)=} thetaLength
 */
THREE.SphereGeometry = function(radius, widthSegments, heightSegments, phiStart, phiLength, thetaStart, thetaLength) {};
/** @type {string} */
THREE.SphereGeometry.prototype.type;
/** @type {{radius: number, widthSegments: number, heightSegments: number, phiStart: number, phiLength: number, thetaStart: number, thetaLength: number}} */
THREE.SphereGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.SphereGeometry}
 */
THREE.SphereGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/TetrahedronGeometry.d.ts:

/**
 * @extends {THREE.PolyhedronGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} detail
 */
THREE.TetrahedronGeometry = function(radius, detail) {};
/** @type {string} */
THREE.TetrahedronGeometry.prototype.type;

/**
 * @param {Object} data
 * @return {THREE.TetrahedronGeometry}
 */
THREE.TetrahedronGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/TorusGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} tube
 * @param {(undefined|number)=} radialSegments
 * @param {(undefined|number)=} tubularSegments
 * @param {(undefined|number)=} arc
 */
THREE.TorusGeometry = function(radius, tube, radialSegments, tubularSegments, arc) {};
/** @type {string} */
THREE.TorusGeometry.prototype.type;
/** @type {{radius: number, tube: number, radialSegments: number, tubularSegments: number, arc: number}} */
THREE.TorusGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.TorusGeometry}
 */
THREE.TorusGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/TorusKnotGeometry.d.ts:

/**
 * @constructor
 * @extends {THREE.BufferGeometry}
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} tube
 * @param {(undefined|number)=} tubularSegments
 * @param {(undefined|number)=} radialSegments
 * @param {(undefined|number)=} p
 * @param {(undefined|number)=} q
 */
THREE.TorusKnotGeometry = function(radius, tube, tubularSegments, radialSegments, p, q) {};
/** @type {string} */
THREE.TorusKnotGeometry.prototype.type;
/** @type {{radius: number, tube: number, tubularSegments: number, radialSegments: number, p: number, q: number}} */
THREE.TorusKnotGeometry.prototype.parameters;

/**
 * @param {Object} data
 * @return {THREE.TorusKnotGeometry}
 */
THREE.TorusKnotGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/TubeGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 * 
 * @param {(undefined|THREE.Curve<THREE.Vector3>)=} path
 * @param {(undefined|number)=} tubularSegments
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} radiusSegments
 * @param {(undefined|boolean)=} closed
 */
THREE.TubeGeometry = function(path, tubularSegments, radius, radiusSegments, closed) {};
/** @type {string} */
THREE.TubeGeometry.prototype.type;
/** @type {{path: THREE.Curve<THREE.Vector3>, tubularSegments: number, radius: number, radialSegments: number, closed: boolean}} */
THREE.TubeGeometry.prototype.parameters;
/** @type {Array<THREE.Vector3>} */
THREE.TubeGeometry.prototype.tangents;
/** @type {Array<THREE.Vector3>} */
THREE.TubeGeometry.prototype.normals;
/** @type {Array<THREE.Vector3>} */
THREE.TubeGeometry.prototype.binormals;

/**
 * @param {Object} data
 * @return {THREE.TubeGeometry}
 */
THREE.TubeGeometry.fromJSON = function(data) {};

// externs from src/src/geometries/WireframeGeometry.d.ts:

/**
 * @extends {THREE.BufferGeometry}
 * @template TBufferGeometry
 * @constructor
 * 
 * @param {(undefined|TBufferGeometry)=} geometry
 */
THREE.WireframeGeometry = function(geometry) {};
/** @type {string} */
THREE.WireframeGeometry.prototype.type;
/** @type {{geometry: TBufferGeometry}} */
THREE.WireframeGeometry.prototype.parameters;

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {(undefined|THREE.BufferGeometry)=} geometry
 * @param {(undefined|THREE.Material)=} material
 */
THREE.Line = function(geometry, material) {};
/** @type {THREE.BufferGeometry} */
THREE.Line.prototype.geometry;
/** @type {THREE.Material} */
THREE.Line.prototype.material;
/** @type {string} */
THREE.Line.prototype.type;
/** @type {boolean} */
THREE.Line.prototype.isLine;
/** @type {(undefined|Array<number>)} */
THREE.Line.prototype.morphTargetInfluences;
/** @type {(undefined|Object<string,number>)} */
THREE.Line.prototype.morphTargetDictionary;

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Line.prototype.computeLineDistances = function() {};

/**
 * @return {void}
 */
THREE.Line.prototype.updateMorphTargets = function() {};
// externs from src/src/objects/LineSegments.d.ts:
/** @type {number} */
THREE.LineSegments.LineStrip;
/** @type {number} */
THREE.LineSegments.LinePieces;

/**
 * @template TGeometry, TMaterial
 * @extends {THREE.Line}
 * @constructor
 * 
 * @param {(undefined|TGeometry)=} geometry
 * @param {(undefined|TMaterial)=} material
 */
THREE.LineSegments = function(geometry, material) {};
/** @type {string} */
THREE.LineSegments.prototype.type;
/** @type {boolean} */
THREE.LineSegments.prototype.isLineSegments;
// externs from src/src/helpers/SpotLightHelper.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {THREE.Light} light
 * @param {(undefined|string|number|THREE.Color)=} color
 */
THREE.SpotLightHelper = function(light, color) {};
/** @type {THREE.Light} */
THREE.SpotLightHelper.prototype.light;
/** @type {THREE.Matrix4} */
THREE.SpotLightHelper.prototype.matrix;
/** @type {boolean} */
THREE.SpotLightHelper.prototype.matrixAutoUpdate;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.SpotLightHelper.prototype.color;
/** @type {THREE.LineSegments<THREE.BufferGeometry, (!THREE.Material|Array<THREE.Material>)>} */
THREE.SpotLightHelper.prototype.cone;

/**
 * @return {void}
 */
THREE.SpotLightHelper.prototype.dispose = function() {};

/**
 * @return {void}
 */
THREE.SpotLightHelper.prototype.update = function() {};
// externs from src/src/helpers/SkeletonHelper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 */
THREE.SkeletonHelper = function(object) {};
/** @type {string} */
THREE.SkeletonHelper.prototype.type;
/** @type {Array<THREE.Bone>} */
THREE.SkeletonHelper.prototype.bones;
/** @type {THREE.Object3D<THREE.EventDispatcher.Event>} */
THREE.SkeletonHelper.prototype.root;
/** @type {boolean} */
THREE.SkeletonHelper.prototype.isSkeletonHelper;
/** @type {THREE.Matrix4} */
THREE.SkeletonHelper.prototype.matrix;
/** @type {boolean} */
THREE.SkeletonHelper.prototype.matrixAutoUpdate;

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {Array<THREE.Bone>}
 */
THREE.SkeletonHelper.prototype.getBoneList = function(object) {};

/**
 * @return {void}
 */
THREE.SkeletonHelper.prototype.update = function() {};
// externs from src/src/lights/PointLightShadow.d.ts:
/**
 * @extends {THREE.LightShadow}
 * @constructor
 * 
 */
THREE.PointLightShadow = function() {};
/** @type {THREE.PerspectiveCamera} */
THREE.PointLightShadow.prototype.camera;
// externs from src/src/lights/PointLight.d.ts:

/**
 * @extends {THREE.Light}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} color
 * @param {(undefined|number)=} intensity
 * @param {(undefined|number)=} distance
 * @param {(undefined|number)=} decay
 */
THREE.PointLight = function(color, intensity, distance, decay) {};
/** @type {string} */
THREE.PointLight.prototype.type;
/** @type {number} */
THREE.PointLight.prototype.intensity;
/** @type {number} */
THREE.PointLight.prototype.distance;
/** @type {number} */
THREE.PointLight.prototype.decay;
/** @type {THREE.PointLightShadow} */
THREE.PointLight.prototype.shadow;
/** @type {number} */
THREE.PointLight.prototype.power;
// externs from src/src/helpers/PointLightHelper.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {THREE.PointLight} light
 * @param {(undefined|number)=} sphereSize
 * @param {(undefined|string|number|THREE.Color)=} color
 */
THREE.PointLightHelper = function(light, sphereSize, color) {};
/** @type {string} */
THREE.PointLightHelper.prototype.type;
/** @type {THREE.PointLight} */
THREE.PointLightHelper.prototype.light;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.PointLightHelper.prototype.color;
/** @type {THREE.Matrix4} */
THREE.PointLightHelper.prototype.matrix;
/** @type {boolean} */
THREE.PointLightHelper.prototype.matrixAutoUpdate;

/**
 * @return {void}
 */
THREE.PointLightHelper.prototype.dispose = function() {};

/**
 * @return {void}
 */
THREE.PointLightHelper.prototype.update = function() {};
// externs from src/src/lights/HemisphereLight.d.ts:

/**
 * @extends {THREE.Light}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} skyColor
 * @param {(undefined|string|number|THREE.Color)=} groundColor
 * @param {(undefined|number)=} intensity
 */
THREE.HemisphereLight = function(skyColor, groundColor, intensity) {};
/** @type {string} */
THREE.HemisphereLight.prototype.type;
/** @type {THREE.Vector3} */
THREE.HemisphereLight.prototype.position;
/** @type {THREE.Color} */
THREE.HemisphereLight.prototype.groundColor;
/** @type {boolean} */
THREE.HemisphereLight.prototype.isHemisphereLight;
// externs from src/src/materials/MeshBasicMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshBasicMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshBasicMaterialParameters.prototype.color;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.opacity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshBasicMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshBasicMaterialParameters.prototype.lightMap;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.lightMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshBasicMaterialParameters.prototype.aoMap;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.aoMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshBasicMaterialParameters.prototype.specularMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshBasicMaterialParameters.prototype.alphaMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshBasicMaterialParameters.prototype.envMap;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.combine;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.reflectivity;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.refractionRatio;
/** @type {(undefined|boolean)} */
THREE.MeshBasicMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshBasicMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|string)} */
THREE.MeshBasicMaterialParameters.prototype.wireframeLinecap;
/** @type {(undefined|string)} */
THREE.MeshBasicMaterialParameters.prototype.wireframeLinejoin;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshBasicMaterialParameters)=} parameters
 */
THREE.MeshBasicMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshBasicMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.MeshBasicMaterial.prototype.color;
/** @type {(null|THREE.Texture)} */
THREE.MeshBasicMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshBasicMaterial.prototype.lightMap;
/** @type {number} */
THREE.MeshBasicMaterial.prototype.lightMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshBasicMaterial.prototype.aoMap;
/** @type {number} */
THREE.MeshBasicMaterial.prototype.aoMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshBasicMaterial.prototype.specularMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshBasicMaterial.prototype.alphaMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshBasicMaterial.prototype.envMap;
/** @type {number} */
THREE.MeshBasicMaterial.prototype.combine;
/** @type {number} */
THREE.MeshBasicMaterial.prototype.reflectivity;
/** @type {number} */
THREE.MeshBasicMaterial.prototype.refractionRatio;
/** @type {boolean} */
THREE.MeshBasicMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshBasicMaterial.prototype.wireframeLinewidth;
/** @type {string} */
THREE.MeshBasicMaterial.prototype.wireframeLinecap;
/** @type {string} */
THREE.MeshBasicMaterial.prototype.wireframeLinejoin;

/**
 * @param {THREE.MeshBasicMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshBasicMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/helpers/HemisphereLightHelper.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {THREE.HemisphereLight} light
 * @param {number} size
 * @param {(undefined|string|number|THREE.Color)=} color
 */
THREE.HemisphereLightHelper = function(light, size, color) {};
/** @type {THREE.HemisphereLight} */
THREE.HemisphereLightHelper.prototype.light;
/** @type {THREE.Matrix4} */
THREE.HemisphereLightHelper.prototype.matrix;
/** @type {boolean} */
THREE.HemisphereLightHelper.prototype.matrixAutoUpdate;
/** @type {THREE.MeshBasicMaterial} */
THREE.HemisphereLightHelper.prototype.material;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.HemisphereLightHelper.prototype.color;

/**
 * @return {void}
 */
THREE.HemisphereLightHelper.prototype.dispose = function() {};

/**
 * @return {void}
 */
THREE.HemisphereLightHelper.prototype.update = function() {};
// externs from src/src/helpers/GridHelper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {(undefined|number)=} size
 * @param {(undefined|number)=} divisions
 * @param {(undefined|string|number|THREE.Color)=} color1
 * @param {(undefined|string|number|THREE.Color)=} color2
 */
THREE.GridHelper = function(size, divisions, color1, color2) {};
/** @type {string} */
THREE.GridHelper.prototype.type;

/**
 * @deprecated Colors should be specified in the constructor.
 * @param {(undefined|string|number|THREE.Color)=} color1
 * @param {(undefined|string|number|THREE.Color)=} color2
 * @return {void}
 */
THREE.GridHelper.prototype.setColors = function(color1, color2) {};
// externs from src/src/helpers/PolarGridHelper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} radials
 * @param {(undefined|number)=} circles
 * @param {(undefined|number)=} divisions
 * @param {(undefined|string|number|THREE.Color)=} color1
 * @param {(undefined|string|number|THREE.Color)=} color2
 */
THREE.PolarGridHelper = function(radius, radials, circles, divisions, color1, color2) {};
/** @type {string} */
THREE.PolarGridHelper.prototype.type;
// externs from src/src/lights/DirectionalLightShadow.d.ts:

/**
 * @extends {THREE.LightShadow}
 * @constructor
 * 
 */
THREE.DirectionalLightShadow = function() {};
/** @type {THREE.OrthographicCamera} */
THREE.DirectionalLightShadow.prototype.camera;
/** @type {boolean} */
THREE.DirectionalLightShadow.prototype.isDirectionalLightShadow;
// externs from src/src/lights/DirectionalLight.d.ts:

/**
 * @extends {THREE.Light}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} color
 * @param {(undefined|number)=} intensity
 */
THREE.DirectionalLight = function(color, intensity) {};
/** @type {string} */
THREE.DirectionalLight.prototype.type;
/** @type {THREE.Vector3} */
THREE.DirectionalLight.prototype.position;
/** @type {THREE.Object3D<THREE.EventDispatcher.Event>} */
THREE.DirectionalLight.prototype.target;
/** @type {number} */
THREE.DirectionalLight.prototype.intensity;
/** @type {THREE.DirectionalLightShadow} */
THREE.DirectionalLight.prototype.shadow;
/** @type {boolean} */
THREE.DirectionalLight.prototype.isDirectionalLight;
// externs from src/src/helpers/DirectionalLightHelper.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {THREE.DirectionalLight} light
 * @param {(undefined|number)=} size
 * @param {(undefined|string|number|THREE.Color)=} color
 */
THREE.DirectionalLightHelper = function(light, size, color) {};
/** @type {THREE.DirectionalLight} */
THREE.DirectionalLightHelper.prototype.light;
/** @type {THREE.Line<THREE.BufferGeometry, (!THREE.Material|Array<THREE.Material>)>} */
THREE.DirectionalLightHelper.prototype.lightPlane;
/** @type {THREE.Line<THREE.BufferGeometry, (!THREE.Material|Array<THREE.Material>)>} */
THREE.DirectionalLightHelper.prototype.targetLine;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.DirectionalLightHelper.prototype.color;
/** @type {THREE.Matrix4} */
THREE.DirectionalLightHelper.prototype.matrix;
/** @type {boolean} */
THREE.DirectionalLightHelper.prototype.matrixAutoUpdate;

/**
 * @return {void}
 */
THREE.DirectionalLightHelper.prototype.dispose = function() {};

/**
 * @return {void}
 */
THREE.DirectionalLightHelper.prototype.update = function() {};
// externs from src/src/helpers/CameraHelper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {THREE.Camera} camera
 */
THREE.CameraHelper = function(camera) {};
/** @type {THREE.Camera} */
THREE.CameraHelper.prototype.camera;
/** @type {Object<string,!Array<number>>} */
THREE.CameraHelper.prototype.pointMap;
/** @type {string} */
THREE.CameraHelper.prototype.type;

/**
 * @return {void}
 */
THREE.CameraHelper.prototype.update = function() {};

/**
 * @return {void}
 */
THREE.CameraHelper.prototype.dispose = function() {};
// externs from src/src/helpers/BoxHelper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {(undefined|string|number|THREE.Color)=} color
 */
THREE.BoxHelper = function(object, color) {};
/** @type {string} */
THREE.BoxHelper.prototype.type;

/**
 * @param {(undefined|THREE.Object3D<THREE.EventDispatcher.Event>)=} object
 * @return {void}
 */
THREE.BoxHelper.prototype.update = function(object) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {THIS}
 */
THREE.BoxHelper.prototype.setFromObject = function(object) {};
// externs from src/src/helpers/Box3Helper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {THREE.Box3} box
 * @param {(undefined|THREE.Color)=} color
 */
THREE.Box3Helper = function(box, color) {};
/** @type {string} */
THREE.Box3Helper.prototype.type;
/** @type {THREE.Box3} */
THREE.Box3Helper.prototype.box;
// externs from src/src/helpers/PlaneHelper.d.ts:

/**
 * @extends {THREE.LineSegments}
 * @constructor
 * 
 * @param {THREE.Plane} plane
 * @param {(undefined|number)=} size
 * @param {(undefined|number)=} hex
 */
THREE.PlaneHelper = function(plane, size, hex) {};
/** @type {string} */
THREE.PlaneHelper.prototype.type;
/** @type {THREE.Plane} */
THREE.PlaneHelper.prototype.plane;
/** @type {number} */
THREE.PlaneHelper.prototype.size;

/**
 * @param {(undefined|boolean)=} force
 * @return {void}
 */
THREE.PlaneHelper.prototype.updateMatrixWorld = function(force) {};
// externs from src/src/objects/Mesh.d.ts:

/**
 * @extends {THREE.Object3D}
 * @template TGeometry, TMaterial
 * @constructor
 * 
 * @param {(undefined|TGeometry)=} geometry
 * @param {(undefined|TMaterial)=} material
 */
THREE.Mesh = function(geometry, material) {};
/** @type {TGeometry} */
THREE.Mesh.prototype.geometry;
/** @type {TMaterial} */
THREE.Mesh.prototype.material;
/** @type {(undefined|Array<number>)} */
THREE.Mesh.prototype.morphTargetInfluences;
/** @type {(undefined|Object<string,number>)} */
THREE.Mesh.prototype.morphTargetDictionary;
/** @type {boolean} */
THREE.Mesh.prototype.isMesh;
/** @type {string} */
THREE.Mesh.prototype.type;

/**
 * @return {void}
 */
THREE.Mesh.prototype.updateMorphTargets = function() {};

//THREE.Mesh.prototype.raycast = function(raycaster, intersects) {};
// externs from src/src/helpers/ArrowHelper.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {(undefined|THREE.Vector3)=} dir
 * @param {(undefined|THREE.Vector3)=} origin
 * @param {(undefined|number)=} length
 * @param {(undefined|string|number|THREE.Color)=} color
 * @param {(undefined|number)=} headLength
 * @param {(undefined|number)=} headWidth
 */
THREE.ArrowHelper = function(dir, origin, length, color, headLength, headWidth) {};
/** @type {string} */
THREE.ArrowHelper.prototype.type;
/** @type {THREE.Line<THREE.BufferGeometry, (!THREE.Material|Array<THREE.Material>)>} */
THREE.ArrowHelper.prototype.line;
/** @type {THREE.Mesh<THREE.BufferGeometry, (!THREE.Material|Array<THREE.Material>)>} */
THREE.ArrowHelper.prototype.cone;

/**
 * @param {THREE.Vector3} dir The desired direction. Must be a unit vector.
 * @return {void}
 */
THREE.ArrowHelper.prototype.setDirection = function(dir) {};

/**
 * @param {number} length The desired length.
 * @param {(undefined|number)=} headLength
 * @param {(undefined|number)=} headWidth
 * @return {void}
 */
THREE.ArrowHelper.prototype.setLength = function(length, headLength, headWidth) {};

/**
 * @param {(string|number|THREE.Color)} color The desired color.
 * @return {void}
 */
THREE.ArrowHelper.prototype.setColor = function(color) {};
// externs from src/src/helpers/AxesHelper.d.ts:

/**
 * @constructor
 * @extends {THREE.LineSegments}
 * @param {(undefined|number)=} size
 */
THREE.AxesHelper = function(size) {};
/** @const {string} */
THREE.AxesHelper.prototype.type;

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Color} xAxisColor
 * @param {THREE.Color} yAxisColor
 * @param {THREE.Color} zAxisColor
 * @return {THIS}
 */
THREE.AxesHelper.prototype.setColors = function(xAxisColor, yAxisColor, zAxisColor) {};

/**
 * @return {void}
 */
THREE.AxesHelper.prototype.dispose = function() {};

/**
 * @extends {THREE.LightShadow}
 * @constructor
 * 
 */
THREE.SpotLightShadow = function() {};
/** @type {THREE.PerspectiveCamera} */
THREE.SpotLightShadow.prototype.camera;
/** @type {boolean} */
THREE.SpotLightShadow.prototype.isSpotLightShadow;
/** @type {number} */
THREE.SpotLightShadow.prototype.focus;
// externs from src/src/lights/SpotLight.d.ts:

/**
 * @extends {THREE.Light}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} color
 * @param {(undefined|number)=} intensity
 * @param {(undefined|number)=} distance
 * @param {(undefined|number)=} angle
 * @param {(undefined|number)=} penumbra
 * @param {(undefined|number)=} decay
 */
THREE.SpotLight = function(color, intensity, distance, angle, penumbra, decay) {};
/** @type {string} */
THREE.SpotLight.prototype.type;
/** @type {THREE.Vector3} */
THREE.SpotLight.prototype.position;
/** @type {THREE.Object3D<THREE.EventDispatcher.Event>} */
THREE.SpotLight.prototype.target;
/** @type {number} */
THREE.SpotLight.prototype.intensity;
/** @type {number} */
THREE.SpotLight.prototype.distance;
/** @type {number} */
THREE.SpotLight.prototype.angle;
/** @type {number} */
THREE.SpotLight.prototype.decay;
/** @type {THREE.SpotLightShadow} */
THREE.SpotLight.prototype.shadow;
/** @type {number} */
THREE.SpotLight.prototype.power;
/** @type {number} */
THREE.SpotLight.prototype.penumbra;
/** @type {boolean} */
THREE.SpotLight.prototype.isSpotLight;
// externs from src/src/lights/RectAreaLight.d.ts:

/**
 * @extends {THREE.Light}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} color
 * @param {(undefined|number)=} intensity
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 */
THREE.RectAreaLight = function(color, intensity, width, height) {};
/** @type {string} */
THREE.RectAreaLight.prototype.type;
/** @type {number} */
THREE.RectAreaLight.prototype.width;
/** @type {number} */
THREE.RectAreaLight.prototype.height;
/** @type {number} */
THREE.RectAreaLight.prototype.intensity;
/** @type {number} */
THREE.RectAreaLight.prototype.power;
/** @type {boolean} */
THREE.RectAreaLight.prototype.isRectAreaLight;
// externs from src/src/lights/AmbientLight.d.ts:

/**
 * @extends {THREE.Light} 
 * @constructor
 * 
 * This creates a Ambientlight with a color.
 * @param {(undefined|string|number|THREE.Color)=} color Numeric value of the RGB component of the color or a Color instance.
 * @param {(undefined|number)=} intensity
 */
THREE.AmbientLight = function(color, intensity) {};
/** @type {string} */
THREE.AmbientLight.prototype.type;
/** @type {boolean} */
THREE.AmbientLight.prototype.isAmbientLight;
// externs from src/src/math/SphericalHarmonics3.d.ts:

/**
 * @constructor
 * 
 */
THREE.SphericalHarmonics3 = function() {};
/** @type {Array<THREE.Vector3>} */
THREE.SphericalHarmonics3.prototype.coefficients;
/** @type {boolean} */
THREE.SphericalHarmonics3.prototype.isSphericalHarmonics3;

/**
 * @param {Array<THREE.Vector3>} coefficients
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.set = function(coefficients) {};

/**
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.zero = function() {};

/**
 * @param {THREE.SphericalHarmonics3} sh
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.add = function(sh) {};

/**
 * @param {THREE.SphericalHarmonics3} sh
 * @param {number} s
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.addScaledSH = function(sh, s) {};

/**
 * @param {number} s
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.scale = function(s) {};

/**
 * @param {THREE.SphericalHarmonics3} sh
 * @param {number} alpha
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.lerp = function(sh, alpha) {};

/**
 * @param {THREE.SphericalHarmonics3} sh
 * @return {boolean}
 */
THREE.SphericalHarmonics3.prototype.equals = function(sh) {};

/**
 * @param {THREE.SphericalHarmonics3} sh
 * @return {THREE.SphericalHarmonics3}
 */
THREE.SphericalHarmonics3.prototype.copy = function(sh) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.SphericalHarmonics3.prototype.clone = function() {};

/**
 * Sets the values of this spherical harmonics from the provided array or array-like.
 * @template THIS
 * @this {THIS}
 * @param {(!Array<number>|Array<number>)} array the source array or array-like.
 * @param {(undefined|number)=} offset (optional) offset into the array. Default is 0.
 * @return {THIS}
 */
THREE.SphericalHarmonics3.prototype.fromArray = function(array, offset) {};

/**
 * Returns an array with the values of this spherical harmonics, or copies them into the provided array. / Returns an array with the values of this spherical harmonics, or copies them into the provided array-like.
 * @param {(undefined|Array<number>)|Array<number>=} array (optional) array to store the spherical harmonics to. If this is not provided, a new array will be created. / array-like to store the spherical harmonics to.
 * @param {(undefined|number)=} offset (optional) optional offset into the array. / (optional) optional offset into the array-like.
 * @return {Array<number>|Array<number>} The created or provided array. / The provided array-like.
 */
THREE.SphericalHarmonics3.prototype.toArray = function(array, offset) {};

/**
 * @param {THREE.Vector3} normal
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.SphericalHarmonics3.prototype.getAt = function(normal, target) {};

/**
 * @param {THREE.Vector3} normal
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.SphericalHarmonics3.prototype.getIrradianceAt = function(normal, target) {};

/**
 * @param {THREE.Vector3} normal
 * @param {Array<number>} shBasis
 * @return {void}
 */
THREE.SphericalHarmonics3.getBasisAt = function(normal, shBasis) {};
// externs from src/src/lights/LightProbe.d.ts:

/**
 * @extends {THREE.Light}
 * @constructor
 * 
 * @param {(undefined|THREE.SphericalHarmonics3)=} sh
 * @param {(undefined|number)=} intensity
 */
THREE.LightProbe = function(sh, intensity) {};
/** @type {string} */
THREE.LightProbe.prototype.type;
/** @type {boolean} */
THREE.LightProbe.prototype.isLightProbe;
/** @type {THREE.SphericalHarmonics3} */
THREE.LightProbe.prototype.sh;

/**
 * @param {Object} json
 * @return {THREE.LightProbe}
 */
THREE.LightProbe.prototype.fromJSON = function(json) {};
// externs from src/src/lights/AmbientLightProbe.d.ts:

/**
 * @extends {THREE.LightProbe}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} color
 * @param {(undefined|number)=} intensity
 */
THREE.AmbientLightProbe = function(color, intensity) {};
/** @type {boolean} */
THREE.AmbientLightProbe.prototype.isAmbientLightProbe;
// externs from src/src/lights/HemisphereLightProbe.d.ts:

/**
 * @extends {THREE.LightProbe}
 * @constructor
 * 
 * @param {(undefined|string|number|THREE.Color)=} skyColor
 * @param {(undefined|string|number|THREE.Color)=} groundColor
 * @param {(undefined|number)=} intensity
 */
THREE.HemisphereLightProbe = function(skyColor, groundColor, intensity) {};
/** @type {boolean} */
THREE.HemisphereLightProbe.prototype.isHemisphereLightProbe;
// externs from src/src/loaders/Loader.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.Loader = function(manager) {};
/** @type {string} */
THREE.Loader.prototype.crossOrigin;
/** @type {boolean} */
THREE.Loader.prototype.withCredentials;
/** @type {string} */
THREE.Loader.prototype.path;
/** @type {string} */
THREE.Loader.prototype.resourcePath;
/** @type {THREE.LoadingManager} */
THREE.Loader.prototype.manager;
/** @type {Object<string,string>} */
THREE.Loader.prototype.requestHeader;

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise}
 */
THREE.Loader.prototype.loadAsync = function(url, onProgress) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {string} crossOrigin
 * @return {THIS}
 */
THREE.Loader.prototype.setCrossOrigin = function(crossOrigin) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {boolean} value
 * @return {THIS}
 */
THREE.Loader.prototype.setWithCredentials = function(value) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {string} path
 * @return {THIS}
 */
THREE.Loader.prototype.setPath = function(path) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {string} resourcePath
 * @return {THIS}
 */
THREE.Loader.prototype.setResourcePath = function(resourcePath) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Object<string,string>} requestHeader
 * @return {THIS}
 */
THREE.Loader.prototype.setRequestHeader = function(requestHeader) {};
// externs from src/src/loaders/LoadingManager.d.ts:

/** @type {THREE.LoadingManager} */
THREE.LoadingManager.DefaultLoadingManager;

/**
 * @constructor
 * 
 * @param {(undefined|function(): void)=} onLoad
 * @param {(undefined|function(string, number, number): void)=} onProgress
 * @param {(undefined|function(string): void)=} onError
 */
THREE.LoadingManager = function(onLoad, onProgress, onError) {};
/** @type {(undefined|function(string, number, number): void)} */
THREE.LoadingManager.prototype.onStart;
/** @type {function(): void} */
THREE.LoadingManager.prototype.onLoad;
/** @type {function(string, number, number): void} */
THREE.LoadingManager.prototype.onProgress;
/** @type {function(string): void} */
THREE.LoadingManager.prototype.onError;

/**
 * If provided, the callback will be passed each resource URL before a request is sent.
 * The callback may return the original URL, or a new URL to override loading behavior.
 * This behavior can be used to load assets from .ZIP files, drag-and-drop APIs, and Data URIs.
 * @template THIS
 * @this {THIS}
 * @param {(undefined|function(string): string)=} callback URL modifier callback. Called with url argument, and must return resolvedURL.
 * @return {THIS}
 */
THREE.LoadingManager.prototype.setURLModifier = function(callback) {};

/**
 * Given a URL, uses the URL modifier callback (if any) and returns a resolved URL.
 * If no URL modifier is set, returns the original URL.
 * @param {string} url the url to load
 * @return {string}
 */
THREE.LoadingManager.prototype.resolveURL = function(url) {};

/**
 * @param {string} url
 * @return {void}
 */
THREE.LoadingManager.prototype.itemStart = function(url) {};

/**
 * @param {string} url
 * @return {void}
 */
THREE.LoadingManager.prototype.itemEnd = function(url) {};

/**
 * @param {string} url
 * @return {void}
 */
THREE.LoadingManager.prototype.itemError = function(url) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {RegExp} regex
 * @param {THREE.Loader} loader
 * @return {THIS}
 */
THREE.LoadingManager.prototype.addHandler = function(regex, loader) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {RegExp} regex
 * @return {THIS}
 */
THREE.LoadingManager.prototype.removeHandler = function(regex) {};

/**
 * @param {string} file
 * @return {(null|THREE.Loader)}
 */
THREE.LoadingManager.prototype.getHandler = function(file) {};
// externs from src/src/loaders/AnimationLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.AnimationLoader = function(manager) {};

/**
 * @param {string} url
 * @param {function(!Array<*>): void} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {void}
 */
THREE.AnimationLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<Array<THREE.AnimationClip>>}
 */
THREE.AnimationLoader.prototype.loadAsync = function(url, onProgress) {};

/**
 * @param {number} json
 * @return {Array<THREE.AnimationClip>}
 */
THREE.AnimationLoader.prototype.parse = function(json) {};
// externs from src/src/textures/CompressedTexture.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {Array<ImageData>} mipmaps
 * @param {number} width
 * @param {number} height
 * @param {(undefined|number)=} format
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} anisotropy
 * @param {(undefined|number)=} encoding
 */
THREE.CompressedTexture = function(mipmaps, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy, encoding) {};
/** @type {{width: number, height: number}} */
THREE.CompressedTexture.prototype.image;
/** @type {Array<ImageData>} */
THREE.CompressedTexture.prototype.mipmaps;
/** @type {boolean} */
THREE.CompressedTexture.prototype.flipY;
/** @type {boolean} */
THREE.CompressedTexture.prototype.generateMipmaps;
/** @type {boolean} */
THREE.CompressedTexture.prototype.isCompressedTexture;
// externs from src/src/loaders/CompressedTextureLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.CompressedTextureLoader = function(manager) {};

/**
 * @param {string} url
 * @param {function(!THREE.CompressedTexture): void} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {THREE.CompressedTexture}
 */
THREE.CompressedTextureLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<THREE.CompressedTexture>}
 */
THREE.CompressedTextureLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/textures/DataTexture.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {(undefined|null|ArrayBufferView|ArrayBuffer)=} data
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @param {(undefined|number)=} format
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} anisotropy
 * @param {(undefined|number)=} encoding
 */
THREE.DataTexture = function(data, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy, encoding) {};
/** @type {ImageData} */
THREE.DataTexture.prototype.image;
/** @type {boolean} */
THREE.DataTexture.prototype.flipY;
/** @type {boolean} */
THREE.DataTexture.prototype.generateMipmaps;
/** @type {number} */
THREE.DataTexture.prototype.unpackAlignment;
/** @type {number} */
THREE.DataTexture.prototype.format;
/** @type {boolean} */
THREE.DataTexture.prototype.isDataTexture;
// externs from src/src/loaders/DataTextureLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.DataTextureLoader = function(manager) {};

/**
 * @param {string} url
 * @param {function(!THREE.DataTexture, Object): void} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {THREE.DataTexture}
 */
THREE.DataTextureLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<THREE.DataTexture>}
 */
THREE.DataTextureLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/loaders/CubeTextureLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.CubeTextureLoader = function(manager) {};

/**
 * @param {Array<string>} urls
 * @param {(undefined|function(!THREE.CubeTexture): void)=} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {THREE.CubeTexture}
 */
THREE.CubeTextureLoader.prototype.load = function(urls, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<THREE.CubeTexture>}
 */
THREE.CubeTextureLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/loaders/TextureLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.TextureLoader = function(manager) {};

/**
 * @param {string} url
 * @param {(undefined|function(!THREE.Texture): void)=} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {THREE.Texture}
 */
THREE.TextureLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<THREE.Texture>}
 */
THREE.TextureLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/loaders/ObjectLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.ObjectLoader = function(manager) {};

/**
 * @param {string} url
 * @param {(undefined|function(THREE.Object3D): void)=} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function((!ErrorEvent|Error)): void)=} onError
 * @return {void}
 */
THREE.ObjectLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @template T
 * @param {*} json
 * @param {(undefined|function(!THREE.Object3D<THREE.EventDispatcher.Event>): void)=} onLoad
 * @return {T}
 */
THREE.ObjectLoader.prototype.parse = function(json, onLoad) {};

/**
 * @template T
 * @param {*} json
 * @return {Promise<T>}
 */
THREE.ObjectLoader.prototype.parseAsync = function(json) {};

/**
 * @param {*} json
 * @return {Object<string,(!THREE.BufferGeometry|THREE.InstancedBufferGeometry)>}
 */
THREE.ObjectLoader.prototype.parseGeometries = function(json) {};

/**
 * @param {*} json
 * @param {Array<THREE.Texture>} textures
 * @return {Array<THREE.Material>}
 */
THREE.ObjectLoader.prototype.parseMaterials = function(json, textures) {};

/**
 * @param {*} json
 * @return {Array<THREE.AnimationClip>}
 */
THREE.ObjectLoader.prototype.parseAnimations = function(json) {};

/**
 * @param {*} json
 * @param {function(): void} onLoad
 * @return {Object<string,!HTMLImageElement>}
 */
THREE.ObjectLoader.prototype.parseImages = function(json, onLoad) {};

/**
 * @param {*} json
 * @return {Promise<Object<string,!HTMLImageElement>>}
 */
THREE.ObjectLoader.prototype.parseImagesAsync = function(json) {};

/**
 * @param {*} json
 * @param {*} images
 * @return {Array<THREE.Texture>}
 */
THREE.ObjectLoader.prototype.parseTextures = function(json, images) {};

/**
 * @template T
 * @param {*} data
 * @param {Array<THREE.Object3D>} geometries
 * @param {Array<THREE.Material>} materials
 * @param {Array<THREE.AnimationClip>} animations
 * @return {T}
 */
THREE.ObjectLoader.prototype.parseObject = function(data, geometries, materials, animations) {};

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.MaterialLoader = function(manager) {};
/** @type {Object<string,!THREE.Texture>} */
THREE.MaterialLoader.prototype.textures;

/**
 * @param {string} url
 * @param {function(!THREE.Material): void} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function((!ErrorEvent|Error)): void)=} onError
 * @return {void}
 */
THREE.MaterialLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<THREE.Material>}
 */
THREE.MaterialLoader.prototype.loadAsync = function(url, onProgress) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {Object<string,!THREE.Texture>} textures
 * @return {THIS}
 */
THREE.MaterialLoader.prototype.setTextures = function(textures) {};

/**
 * @param {number} json
 * @return {THREE.Material}
 */
THREE.MaterialLoader.prototype.parse = function(json) {};
// externs from src/src/loaders/BufferGeometryLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.BufferGeometryLoader = function(manager) {};

/**
 * @param {string} url
 * @param {function((!THREE.BufferGeometry|THREE.InstancedBufferGeometry)): void} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {void}
 */
THREE.BufferGeometryLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<(!THREE.BufferGeometry|THREE.InstancedBufferGeometry)>}
 */
THREE.BufferGeometryLoader.prototype.loadAsync = function(url, onProgress) {};

/**
 * @param {number} json
 * @return {(!THREE.BufferGeometry|THREE.InstancedBufferGeometry)}
 */
THREE.BufferGeometryLoader.prototype.parse = function(json) {};
// externs from src/src/loaders/ImageLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.ImageLoader = function(manager) {};

/**
 * @param {string} url
 * @param {(undefined|function(!HTMLImageElement): void)=} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {HTMLImageElement}
 */
THREE.ImageLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<HTMLImageElement>}
 */
THREE.ImageLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/loaders/ImageBitmapLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.ImageBitmapLoader = function(manager) {};
/** @type {(undefined|Object)} */
THREE.ImageBitmapLoader.prototype.options;
/** @type {boolean} */
THREE.ImageBitmapLoader.prototype.isImageBitmapLoader;

/**
 * @param {Object} options
 * @return {THREE.ImageBitmapLoader}
 */
THREE.ImageBitmapLoader.prototype.setOptions = function(options) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ImageBitmap): void)=} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {number}
 */
THREE.ImageBitmapLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<ImageBitmap>}
 */
THREE.ImageBitmapLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/loaders/FileLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.FileLoader = function(manager) {};
/** @type {(undefined|MimeType)} */
THREE.FileLoader.prototype.mimeType;
/** @type {(undefined|string)} */
THREE.FileLoader.prototype.responseType;

/**
 * @param {string} url
 * @param {(undefined|function((string|ArrayBuffer)): void)=} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {number}
 */
THREE.FileLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<(string|ArrayBuffer)>}
 */
THREE.FileLoader.prototype.loadAsync = function(url, onProgress) {};

/**
 * @param {MimeType} mimeType
 * @return {THREE.FileLoader}
 */
THREE.FileLoader.prototype.setMimeType = function(mimeType) {};

/**
 * @param {string} responseType
 * @return {THREE.FileLoader}
 */
THREE.FileLoader.prototype.setResponseType = function(responseType) {};
// externs from src/src/loaders/LoaderUtils.d.ts:
/**
 * @record
 * 
 */
THREE.LoaderUtils = function() {};

/**
 * @param {(!ArrayBufferView|ArrayBuffer)} array
 * @return {string}
 */
THREE.LoaderUtils.prototype.decodeText = function(array) {};

/**
 * @param {string} url
 * @return {string}
 */
THREE.LoaderUtils.prototype.extractUrlBase = function(url) {};

/**
 * @param {string} url
 * @param {string} path
 * @return {string}
 */
THREE.LoaderUtils.prototype.resolveURL = function(url, path) {};

/** @constructor */
THREE.Cache = function() {};
/** @type {boolean} */
THREE.Cache.enabled;
/** @type {number} */
THREE.Cache.files;

/**
 * @param {string} key
 * @param {number} file
 * @return {void}
 */
THREE.Cache.add = function(key, file) {};

/**
 * @param {string} key
 * @return {number}
 */
THREE.Cache.get = function(key) {};

/**
 * @param {string} key
 * @return {void}
 */
THREE.Cache.remove = function(key) {};

/**
 * @return {void}
 */
THREE.Cache.clear = function() {};
// externs from src/src/loaders/AudioLoader.d.ts:

/**
 * @extends {THREE.Loader}
 * @constructor
 * 
 * @param {(undefined|THREE.LoadingManager)=} manager
 */
THREE.AudioLoader = function(manager) {};

/**
 * @param {string} url
 * @param {function(!AudioBuffer): void} onLoad
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {void}
 */
THREE.AudioLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {string} url
 * @param {(undefined|function(!ProgressEvent<EventTarget>): void)=} onProgress
 * @return {Promise<AudioBuffer>}
 */
THREE.AudioLoader.prototype.loadAsync = function(url, onProgress) {};
// externs from src/src/materials/ShadowMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.ShadowMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.ShadowMaterialParameters.prototype.color;

/**
 * @constructor
 * @extends {THREE.Material}
 * 
 * @param {(undefined|THREE.ShadowMaterialParameters)=} parameters
 */
THREE.ShadowMaterial = function(parameters) {};
/** @type {string} */
THREE.ShadowMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.ShadowMaterial.prototype.color;
/** @type {boolean} */
THREE.ShadowMaterial.prototype.transparent;
// externs from src/src/materials/SpriteMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.SpriteMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.SpriteMaterialParameters.prototype.color;
/** @type {(undefined|null|THREE.Texture)} */
THREE.SpriteMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.SpriteMaterialParameters.prototype.alphaMap;
/** @type {(undefined|number)} */
THREE.SpriteMaterialParameters.prototype.rotation;
/** @type {(undefined|boolean)} */
THREE.SpriteMaterialParameters.prototype.sizeAttenuation;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.SpriteMaterialParameters)=} parameters
 */
THREE.SpriteMaterial = function(parameters) {};
/** @type {string} */
THREE.SpriteMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.SpriteMaterial.prototype.color;
/** @type {(null|THREE.Texture)} */
THREE.SpriteMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.SpriteMaterial.prototype.alphaMap;
/** @type {number} */
THREE.SpriteMaterial.prototype.rotation;
/** @type {boolean} */
THREE.SpriteMaterial.prototype.sizeAttenuation;
/** @type {boolean} */
THREE.SpriteMaterial.prototype.transparent;
/** @type {boolean} */
THREE.SpriteMaterial.prototype.isSpriteMaterial;

/**
 * @param {THREE.SpriteMaterialParameters} parameters
 * @return {void}
 */
THREE.SpriteMaterial.prototype.setValues = function(parameters) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.SpriteMaterial} source
 * @return {THIS}
 */
THREE.SpriteMaterial.prototype.copy = function(source) {};
// externs from src/src/materials/ShaderMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.ShaderMaterialParameters = function() {};
/** @type {(undefined|Object<string,Object>)} */
THREE.ShaderMaterialParameters.prototype.uniforms;
/** @type {(undefined|string)} */
THREE.ShaderMaterialParameters.prototype.vertexShader;
/** @type {(undefined|string)} */
THREE.ShaderMaterialParameters.prototype.fragmentShader;
/** @type {(undefined|number)} */
THREE.ShaderMaterialParameters.prototype.linewidth;
/** @type {(undefined|boolean)} */
THREE.ShaderMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.ShaderMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|boolean)} */
THREE.ShaderMaterialParameters.prototype.lights;
/** @type {(undefined|boolean)} */
THREE.ShaderMaterialParameters.prototype.clipping;
/** @type {(undefined|{derivatives: (undefined|boolean), fragDepth: (undefined|boolean), drawBuffers: (undefined|boolean), shaderTextureLOD: (undefined|boolean)})} */
THREE.ShaderMaterialParameters.prototype.extensions;
/** @type {(undefined|number)} */
THREE.ShaderMaterialParameters.prototype.glslVersion;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.ShaderMaterialParameters)=} parameters
 */
THREE.ShaderMaterial = function(parameters) {};
/** @type {string} */
THREE.ShaderMaterial.prototype.type;
/** @type {Object<string,Object>} */
THREE.ShaderMaterial.prototype.defines;
/** @type {Object<string,Object>} */
THREE.ShaderMaterial.prototype.uniforms;
/** @type {string} */
THREE.ShaderMaterial.prototype.vertexShader;
/** @type {string} */
THREE.ShaderMaterial.prototype.fragmentShader;
/** @type {number} */
THREE.ShaderMaterial.prototype.linewidth;
/** @type {boolean} */
THREE.ShaderMaterial.prototype.wireframe;
/** @type {number} */
THREE.ShaderMaterial.prototype.wireframeLinewidth;
/** @type {boolean} */
THREE.ShaderMaterial.prototype.fog;
/** @type {boolean} */
THREE.ShaderMaterial.prototype.lights;
/** @type {boolean} */
THREE.ShaderMaterial.prototype.clipping;
/** @type {number} */
THREE.ShaderMaterial.prototype.derivatives;
/** @type {{derivatives: boolean, fragDepth: boolean, drawBuffers: boolean, shaderTextureLOD: boolean}} */
THREE.ShaderMaterial.prototype.extensions;
/** @type {number} */
THREE.ShaderMaterial.prototype.defaultAttributeValues;
/** @type {(undefined|string)} */
THREE.ShaderMaterial.prototype.index0AttributeName;
/** @type {boolean} */
THREE.ShaderMaterial.prototype.uniformsNeedUpdate;
/** @type {(null|number)} */
THREE.ShaderMaterial.prototype.glslVersion;
/** @type {boolean} */
THREE.ShaderMaterial.prototype.isShaderMaterial;

/**
 * @param {THREE.ShaderMaterialParameters} parameters
 * @return {void}
 */
THREE.ShaderMaterial.prototype.setValues = function(parameters) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.ShaderMaterial.prototype.toJSON = function(opt_key) {};
// externs from src/src/materials/RawShaderMaterial.d.ts:

/**
 * @extends {THREE.ShaderMaterial}
 * @constructor
 * 
 * @param {(undefined|THREE.ShaderMaterialParameters)=} parameters
 */
THREE.RawShaderMaterial = function(parameters) {};
// externs from src/src/materials/PointsMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.PointsMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.PointsMaterialParameters.prototype.color;
/** @type {(undefined|null|THREE.Texture)} */
THREE.PointsMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.PointsMaterialParameters.prototype.alphaMap;
/** @type {(undefined|number)} */
THREE.PointsMaterialParameters.prototype.size;
/** @type {(undefined|boolean)} */
THREE.PointsMaterialParameters.prototype.sizeAttenuation;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.PointsMaterialParameters)=} parameters
 */
THREE.PointsMaterial = function(parameters) {};
/** @type {string} */
THREE.PointsMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.PointsMaterial.prototype.color;
/** @type {(null|THREE.Texture)} */
THREE.PointsMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.PointsMaterial.prototype.alphaMap;
/** @type {number} */
THREE.PointsMaterial.prototype.size;
/** @type {boolean} */
THREE.PointsMaterial.prototype.sizeAttenuation;

/**
 * @param {THREE.PointsMaterialParameters} parameters
 * @return {void}
 */
THREE.PointsMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshStandardMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshStandardMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshStandardMaterialParameters.prototype.color;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.roughness;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.metalness;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.lightMap;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.lightMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.aoMap;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.aoMapIntensity;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshStandardMaterialParameters.prototype.emissive;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.emissiveIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.emissiveMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.bumpMap;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.bumpScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.normalMap;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.normalMapType;
/** @type {(undefined|THREE.Vector2)} */
THREE.MeshStandardMaterialParameters.prototype.normalScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.displacementBias;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.roughnessMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.metalnessMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.alphaMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshStandardMaterialParameters.prototype.envMap;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.envMapIntensity;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.refractionRatio;
/** @type {(undefined|boolean)} */
THREE.MeshStandardMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshStandardMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|boolean)} */
THREE.MeshStandardMaterialParameters.prototype.flatShading;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshStandardMaterialParameters)=} parameters
 */
THREE.MeshStandardMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshStandardMaterial.prototype.type;
/** @type {Object<string,Object>} */
THREE.MeshStandardMaterial.prototype.defines;
/** @type {THREE.Color} */
THREE.MeshStandardMaterial.prototype.color;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.roughness;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.metalness;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.lightMap;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.lightMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.aoMap;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.aoMapIntensity;
/** @type {THREE.Color} */
THREE.MeshStandardMaterial.prototype.emissive;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.emissiveIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.emissiveMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.bumpMap;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.bumpScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.normalMap;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.normalMapType;
/** @type {THREE.Vector2} */
THREE.MeshStandardMaterial.prototype.normalScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.displacementBias;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.roughnessMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.metalnessMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.alphaMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshStandardMaterial.prototype.envMap;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.envMapIntensity;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.refractionRatio;
/** @type {boolean} */
THREE.MeshStandardMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshStandardMaterial.prototype.wireframeLinewidth;
/** @type {string} */
THREE.MeshStandardMaterial.prototype.wireframeLinecap;
/** @type {string} */
THREE.MeshStandardMaterial.prototype.wireframeLinejoin;
/** @type {boolean} */
THREE.MeshStandardMaterial.prototype.flatShading;
/** @type {boolean} */
THREE.MeshStandardMaterial.prototype.isMeshStandardMaterial;

/**
 * @param {THREE.MeshStandardMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshStandardMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshPhysicalMaterial.d.ts:
/**
 * @extends {THREE.MeshStandardMaterialParameters}
 * @record
 * 
 */
THREE.MeshPhysicalMaterialParameters = function() {};
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.clearcoat;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhysicalMaterialParameters.prototype.clearcoatMap;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.clearcoatRoughness;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhysicalMaterialParameters.prototype.clearcoatRoughnessMap;
/** @type {(undefined|THREE.Vector2)} */
THREE.MeshPhysicalMaterialParameters.prototype.clearcoatNormalScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhysicalMaterialParameters.prototype.clearcoatNormalMap;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.reflectivity;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.ior;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.sheen;
/** @type {(undefined|THREE.Color)} */
THREE.MeshPhysicalMaterialParameters.prototype.sheenColor;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.sheenRoughness;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.transmission;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhysicalMaterialParameters.prototype.transmissionMap;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.attenuationDistance;
/** @type {(undefined|THREE.Color)} */
THREE.MeshPhysicalMaterialParameters.prototype.attenuationColor;
/** @type {(undefined|number)} */
THREE.MeshPhysicalMaterialParameters.prototype.specularIntensity;
/** @type {(undefined|THREE.Color)} */
THREE.MeshPhysicalMaterialParameters.prototype.specularColor;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhysicalMaterialParameters.prototype.specularIntensityMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhysicalMaterialParameters.prototype.specularColorMap;

/**
 * @extends {THREE.MeshStandardMaterial}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshPhysicalMaterialParameters)=} parameters
 */
THREE.MeshPhysicalMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshPhysicalMaterial.prototype.type;
/** @type {Object<string,Object>} */
THREE.MeshPhysicalMaterial.prototype.defines;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.clearcoat;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.clearcoatMap;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.clearcoatRoughness;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.clearcoatRoughnessMap;
/** @type {THREE.Vector2} */
THREE.MeshPhysicalMaterial.prototype.clearcoatNormalScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.clearcoatNormalMap;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.reflectivity;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.ior;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.sheen;
/** @type {THREE.Color} */
THREE.MeshPhysicalMaterial.prototype.sheenColor;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.sheenColorMap;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.sheenRoughness;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.sheenRoughnessMap;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.transmission;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.transmissionMap;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.thickness;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.thicknessMap;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.attenuationDistance;
/** @type {THREE.Color} */
THREE.MeshPhysicalMaterial.prototype.attenuationColor;
/** @type {number} */
THREE.MeshPhysicalMaterial.prototype.specularIntensity;
/** @type {THREE.Color} */
THREE.MeshPhysicalMaterial.prototype.specularColor;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.specularIntensityMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhysicalMaterial.prototype.specularColorMap;
// externs from src/src/materials/MeshPhongMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshPhongMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshPhongMaterialParameters.prototype.color;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshPhongMaterialParameters.prototype.specular;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.shininess;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.opacity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.lightMap;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.lightMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.aoMap;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.aoMapIntensity;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshPhongMaterialParameters.prototype.emissive;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.emissiveIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.emissiveMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.bumpMap;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.bumpScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.normalMap;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.normalMapType;
/** @type {(undefined|THREE.Vector2)} */
THREE.MeshPhongMaterialParameters.prototype.normalScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.displacementBias;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.specularMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.alphaMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshPhongMaterialParameters.prototype.envMap;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.combine;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.reflectivity;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.refractionRatio;
/** @type {(undefined|boolean)} */
THREE.MeshPhongMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshPhongMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|string)} */
THREE.MeshPhongMaterialParameters.prototype.wireframeLinecap;
/** @type {(undefined|string)} */
THREE.MeshPhongMaterialParameters.prototype.wireframeLinejoin;
/** @type {(undefined|boolean)} */
THREE.MeshPhongMaterialParameters.prototype.flatShading;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshPhongMaterialParameters)=} parameters
 */
THREE.MeshPhongMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshPhongMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.MeshPhongMaterial.prototype.color;
/** @type {THREE.Color} */
THREE.MeshPhongMaterial.prototype.specular;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.shininess;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.lightMap;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.lightMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.aoMap;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.aoMapIntensity;
/** @type {THREE.Color} */
THREE.MeshPhongMaterial.prototype.emissive;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.emissiveIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.emissiveMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.bumpMap;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.bumpScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.normalMap;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.normalMapType;
/** @type {THREE.Vector2} */
THREE.MeshPhongMaterial.prototype.normalScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.displacementBias;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.specularMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.alphaMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshPhongMaterial.prototype.envMap;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.combine;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.reflectivity;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.refractionRatio;
/** @type {boolean} */
THREE.MeshPhongMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshPhongMaterial.prototype.wireframeLinewidth;
/** @type {string} */
THREE.MeshPhongMaterial.prototype.wireframeLinecap;
/** @type {string} */
THREE.MeshPhongMaterial.prototype.wireframeLinejoin;
/** @type {boolean} */
THREE.MeshPhongMaterial.prototype.flatShading;
/** @type {boolean} */
THREE.MeshPhongMaterial.prototype.metal;

/**
 * @param {THREE.MeshPhongMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshPhongMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshToonMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshToonMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshToonMaterialParameters.prototype.color;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.opacity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.gradientMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.lightMap;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.lightMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.aoMap;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.aoMapIntensity;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshToonMaterialParameters.prototype.emissive;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.emissiveIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.emissiveMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.bumpMap;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.bumpScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.normalMap;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.normalMapType;
/** @type {(undefined|THREE.Vector2)} */
THREE.MeshToonMaterialParameters.prototype.normalScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.displacementBias;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshToonMaterialParameters.prototype.alphaMap;
/** @type {(undefined|boolean)} */
THREE.MeshToonMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshToonMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|string)} */
THREE.MeshToonMaterialParameters.prototype.wireframeLinecap;
/** @type {(undefined|string)} */
THREE.MeshToonMaterialParameters.prototype.wireframeLinejoin;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshToonMaterialParameters)=} parameters
 */
THREE.MeshToonMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshToonMaterial.prototype.type;
/** @type {Object<string,Object>} */
THREE.MeshToonMaterial.prototype.defines;
/** @type {THREE.Color} */
THREE.MeshToonMaterial.prototype.color;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.gradientMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.lightMap;
/** @type {number} */
THREE.MeshToonMaterial.prototype.lightMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.aoMap;
/** @type {number} */
THREE.MeshToonMaterial.prototype.aoMapIntensity;
/** @type {THREE.Color} */
THREE.MeshToonMaterial.prototype.emissive;
/** @type {number} */
THREE.MeshToonMaterial.prototype.emissiveIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.emissiveMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.bumpMap;
/** @type {number} */
THREE.MeshToonMaterial.prototype.bumpScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.normalMap;
/** @type {number} */
THREE.MeshToonMaterial.prototype.normalMapType;
/** @type {THREE.Vector2} */
THREE.MeshToonMaterial.prototype.normalScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshToonMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshToonMaterial.prototype.displacementBias;
/** @type {(null|THREE.Texture)} */
THREE.MeshToonMaterial.prototype.alphaMap;
/** @type {boolean} */
THREE.MeshToonMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshToonMaterial.prototype.wireframeLinewidth;
/** @type {string} */
THREE.MeshToonMaterial.prototype.wireframeLinecap;
/** @type {string} */
THREE.MeshToonMaterial.prototype.wireframeLinejoin;

/**
 * @param {THREE.MeshToonMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshToonMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshNormalMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshNormalMaterialParameters = function() {};
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshNormalMaterialParameters.prototype.bumpMap;
/** @type {(undefined|number)} */
THREE.MeshNormalMaterialParameters.prototype.bumpScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshNormalMaterialParameters.prototype.normalMap;
/** @type {(undefined|number)} */
THREE.MeshNormalMaterialParameters.prototype.normalMapType;
/** @type {(undefined|THREE.Vector2)} */
THREE.MeshNormalMaterialParameters.prototype.normalScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshNormalMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshNormalMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshNormalMaterialParameters.prototype.displacementBias;
/** @type {(undefined|boolean)} */
THREE.MeshNormalMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshNormalMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|boolean)} */
THREE.MeshNormalMaterialParameters.prototype.flatShading;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshNormalMaterialParameters)=} parameters
 */
THREE.MeshNormalMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshNormalMaterial.prototype.type;
/** @type {(null|THREE.Texture)} */
THREE.MeshNormalMaterial.prototype.bumpMap;
/** @type {number} */
THREE.MeshNormalMaterial.prototype.bumpScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshNormalMaterial.prototype.normalMap;
/** @type {number} */
THREE.MeshNormalMaterial.prototype.normalMapType;
/** @type {THREE.Vector2} */
THREE.MeshNormalMaterial.prototype.normalScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshNormalMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshNormalMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshNormalMaterial.prototype.displacementBias;
/** @type {boolean} */
THREE.MeshNormalMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshNormalMaterial.prototype.wireframeLinewidth;
/** @type {boolean} */
THREE.MeshNormalMaterial.prototype.flatShading;

/**
 * @param {THREE.MeshNormalMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshNormalMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshLambertMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshLambertMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshLambertMaterialParameters.prototype.color;
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshLambertMaterialParameters.prototype.emissive;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.emissiveIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.emissiveMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.lightMap;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.lightMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.aoMap;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.aoMapIntensity;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.specularMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.alphaMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshLambertMaterialParameters.prototype.envMap;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.combine;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.reflectivity;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.refractionRatio;
/** @type {(undefined|boolean)} */
THREE.MeshLambertMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshLambertMaterialParameters.prototype.wireframeLinewidth;
/** @type {(undefined|string)} */
THREE.MeshLambertMaterialParameters.prototype.wireframeLinecap;
/** @type {(undefined|string)} */
THREE.MeshLambertMaterialParameters.prototype.wireframeLinejoin;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshLambertMaterialParameters)=} parameters
 */
THREE.MeshLambertMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshLambertMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.MeshLambertMaterial.prototype.color;
/** @type {THREE.Color} */
THREE.MeshLambertMaterial.prototype.emissive;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.emissiveIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.emissiveMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.lightMap;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.lightMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.aoMap;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.aoMapIntensity;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.specularMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.alphaMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshLambertMaterial.prototype.envMap;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.combine;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.reflectivity;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.refractionRatio;
/** @type {boolean} */
THREE.MeshLambertMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshLambertMaterial.prototype.wireframeLinewidth;
/** @type {string} */
THREE.MeshLambertMaterial.prototype.wireframeLinecap;
/** @type {string} */
THREE.MeshLambertMaterial.prototype.wireframeLinejoin;

/**
 * @param {THREE.MeshLambertMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshLambertMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshDepthMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshDepthMaterialParameters = function() {};
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshDepthMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshDepthMaterialParameters.prototype.alphaMap;
/** @type {(undefined|number)} */
THREE.MeshDepthMaterialParameters.prototype.depthPacking;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshDepthMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshDepthMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshDepthMaterialParameters.prototype.displacementBias;
/** @type {(undefined|boolean)} */
THREE.MeshDepthMaterialParameters.prototype.wireframe;
/** @type {(undefined|number)} */
THREE.MeshDepthMaterialParameters.prototype.wireframeLinewidth;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshDepthMaterialParameters)=} parameters
 */
THREE.MeshDepthMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshDepthMaterial.prototype.type;
/** @type {(null|THREE.Texture)} */
THREE.MeshDepthMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshDepthMaterial.prototype.alphaMap;
/** @type {number} */
THREE.MeshDepthMaterial.prototype.depthPacking;
/** @type {(null|THREE.Texture)} */
THREE.MeshDepthMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshDepthMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshDepthMaterial.prototype.displacementBias;
/** @type {boolean} */
THREE.MeshDepthMaterial.prototype.wireframe;
/** @type {number} */
THREE.MeshDepthMaterial.prototype.wireframeLinewidth;
/** @type {boolean} */
THREE.MeshDepthMaterial.prototype.fog;

/**
 * @param {THREE.MeshDepthMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshDepthMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshDistanceMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshDistanceMaterialParameters = function() {};
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshDistanceMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshDistanceMaterialParameters.prototype.alphaMap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshDistanceMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshDistanceMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshDistanceMaterialParameters.prototype.displacementBias;
/** @type {(undefined|number)} */
THREE.MeshDistanceMaterialParameters.prototype.farDistance;
/** @type {(undefined|number)} */
THREE.MeshDistanceMaterialParameters.prototype.nearDistance;
/** @type {(undefined|THREE.Vector3)} */
THREE.MeshDistanceMaterialParameters.prototype.referencePosition;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshDistanceMaterialParameters)=} parameters
 */
THREE.MeshDistanceMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshDistanceMaterial.prototype.type;
/** @type {(null|THREE.Texture)} */
THREE.MeshDistanceMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshDistanceMaterial.prototype.alphaMap;
/** @type {(null|THREE.Texture)} */
THREE.MeshDistanceMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshDistanceMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshDistanceMaterial.prototype.displacementBias;
/** @type {number} */
THREE.MeshDistanceMaterial.prototype.farDistance;
/** @type {number} */
THREE.MeshDistanceMaterial.prototype.nearDistance;
/** @type {THREE.Vector3} */
THREE.MeshDistanceMaterial.prototype.referencePosition;
/** @type {boolean} */
THREE.MeshDistanceMaterial.prototype.fog;

/**
 * @param {THREE.MeshDistanceMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshDistanceMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/MeshMatcapMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.MeshMatcapMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.MeshMatcapMaterialParameters.prototype.color;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshMatcapMaterialParameters.prototype.matcap;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshMatcapMaterialParameters.prototype.map;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshMatcapMaterialParameters.prototype.bumpMap;
/** @type {(undefined|number)} */
THREE.MeshMatcapMaterialParameters.prototype.bumpScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshMatcapMaterialParameters.prototype.normalMap;
/** @type {(undefined|number)} */
THREE.MeshMatcapMaterialParameters.prototype.normalMapType;
/** @type {(undefined|THREE.Vector2)} */
THREE.MeshMatcapMaterialParameters.prototype.normalScale;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshMatcapMaterialParameters.prototype.displacementMap;
/** @type {(undefined|number)} */
THREE.MeshMatcapMaterialParameters.prototype.displacementScale;
/** @type {(undefined|number)} */
THREE.MeshMatcapMaterialParameters.prototype.displacementBias;
/** @type {(undefined|null|THREE.Texture)} */
THREE.MeshMatcapMaterialParameters.prototype.alphaMap;
/** @type {(undefined|boolean)} */
THREE.MeshMatcapMaterialParameters.prototype.flatShading;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.MeshMatcapMaterialParameters)=} parameters
 */
THREE.MeshMatcapMaterial = function(parameters) {};
/** @type {string} */
THREE.MeshMatcapMaterial.prototype.type;
/** @type {Object<string,Object>} */
THREE.MeshMatcapMaterial.prototype.defines;
/** @type {THREE.Color} */
THREE.MeshMatcapMaterial.prototype.color;
/** @type {(null|THREE.Texture)} */
THREE.MeshMatcapMaterial.prototype.matcap;
/** @type {(null|THREE.Texture)} */
THREE.MeshMatcapMaterial.prototype.map;
/** @type {(null|THREE.Texture)} */
THREE.MeshMatcapMaterial.prototype.bumpMap;
/** @type {number} */
THREE.MeshMatcapMaterial.prototype.bumpScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshMatcapMaterial.prototype.normalMap;
/** @type {number} */
THREE.MeshMatcapMaterial.prototype.normalMapType;
/** @type {THREE.Vector2} */
THREE.MeshMatcapMaterial.prototype.normalScale;
/** @type {(null|THREE.Texture)} */
THREE.MeshMatcapMaterial.prototype.displacementMap;
/** @type {number} */
THREE.MeshMatcapMaterial.prototype.displacementScale;
/** @type {number} */
THREE.MeshMatcapMaterial.prototype.displacementBias;
/** @type {(null|THREE.Texture)} */
THREE.MeshMatcapMaterial.prototype.alphaMap;
/** @type {boolean} */
THREE.MeshMatcapMaterial.prototype.flatShading;

/**
 * @param {THREE.MeshMatcapMaterialParameters} parameters
 * @return {void}
 */
THREE.MeshMatcapMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/LineBasicMaterial.d.ts:
/**
 * @extends {THREE.MaterialParameters}
 * @record
 * 
 */
THREE.LineBasicMaterialParameters = function() {};
/** @type {(undefined|string|number|THREE.Color)} */
THREE.LineBasicMaterialParameters.prototype.color;
/** @type {(undefined|number)} */
THREE.LineBasicMaterialParameters.prototype.linewidth;
/** @type {(undefined|string)} */
THREE.LineBasicMaterialParameters.prototype.linecap;
/** @type {(undefined|string)} */
THREE.LineBasicMaterialParameters.prototype.linejoin;

/**
 * @extends {THREE.Material}
 * @constructor
 * 
 * @param {(undefined|THREE.LineBasicMaterialParameters)=} parameters
 */
THREE.LineBasicMaterial = function(parameters) {};
/** @type {string} */
THREE.LineBasicMaterial.prototype.type;
/** @type {THREE.Color} */
THREE.LineBasicMaterial.prototype.color;
/** @type {number} */
THREE.LineBasicMaterial.prototype.linewidth;
/** @type {string} */
THREE.LineBasicMaterial.prototype.linecap;
/** @type {string} */
THREE.LineBasicMaterial.prototype.linejoin;

/**
 * @param {THREE.LineBasicMaterialParameters} parameters
 * @return {void}
 */
THREE.LineBasicMaterial.prototype.setValues = function(parameters) {};
// externs from src/src/materials/LineDashedMaterial.d.ts:
/**
 * @extends {THREE.LineBasicMaterialParameters}
 * @record
 * 
 */
THREE.LineDashedMaterialParameters = function() {};
/** @type {(undefined|number)} */
THREE.LineDashedMaterialParameters.prototype.scale;
/** @type {(undefined|number)} */
THREE.LineDashedMaterialParameters.prototype.dashSize;
/** @type {(undefined|number)} */
THREE.LineDashedMaterialParameters.prototype.gapSize;

/**
 * @extends {THREE.LineBasicMaterial}
 * @constructor
 * 
 * @param {(undefined|THREE.LineDashedMaterialParameters)=} parameters
 */
THREE.LineDashedMaterial = function(parameters) {};
/** @type {string} */
THREE.LineDashedMaterial.prototype.type;
/** @type {number} */
THREE.LineDashedMaterial.prototype.scale;
/** @type {number} */
THREE.LineDashedMaterial.prototype.dashSize;
/** @type {number} */
THREE.LineDashedMaterial.prototype.gapSize;
/** @type {boolean} */
THREE.LineDashedMaterial.prototype.isLineDashedMaterial;

/**
 * @param {THREE.LineDashedMaterialParameters} parameters
 * @return {void}
 */
THREE.LineDashedMaterial.prototype.setValues = function(parameters) {};

/**
 * @constructor
 * 
 * @param {number} parameterPositions
 * @param {number} samplesValues
 * @param {number} sampleSize
 * @param {Object=} resultBuffer
 */
THREE.QuaternionLinearInterpolant = function(parameterPositions, samplesValues, sampleSize, resultBuffer) {};

/**
 * @param {number} i1
 * @param {number} t0
 * @param {number} t
 * @param {number} t1
 * @return {number}
 */
THREE.QuaternionLinearInterpolant.prototype.interpolate_ = function(i1, t0, t, t1) {};
// externs from src/src/objects/Sprite.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {(undefined|THREE.SpriteMaterial)=} material
 */
THREE.Sprite = function(material) {};
/** @type {string} */
THREE.Sprite.prototype.type;
/** @type {boolean} */
THREE.Sprite.prototype.isSprite;
/** @type {THREE.BufferGeometry} */
THREE.Sprite.prototype.geometry;
/** @type {THREE.SpriteMaterial} */
THREE.Sprite.prototype.material;
/** @type {THREE.Vector2} */
THREE.Sprite.prototype.center;

// externs from src/src/math/Frustum.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Plane)=} p0
 * @param {(undefined|THREE.Plane)=} p1
 * @param {(undefined|THREE.Plane)=} p2
 * @param {(undefined|THREE.Plane)=} p3
 * @param {(undefined|THREE.Plane)=} p4
 * @param {(undefined|THREE.Plane)=} p5
 */
THREE.Frustum = function(p0, p1, p2, p3, p4, p5) {};
/** @type {Array<THREE.Plane>} */
THREE.Frustum.prototype.planes;

/**
 * @param {THREE.Plane} p0
 * @param {THREE.Plane} p1
 * @param {THREE.Plane} p2
 * @param {THREE.Plane} p3
 * @param {THREE.Plane} p4
 * @param {THREE.Plane} p5
 * @return {THREE.Frustum}
 */
THREE.Frustum.prototype.set = function(p0, p1, p2, p3, p4, p5) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Frustum.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Frustum} frustum
 * @return {THIS}
 */
THREE.Frustum.prototype.copy = function(frustum) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Matrix4} m
 * @return {THIS}
 */
THREE.Frustum.prototype.setFromProjectionMatrix = function(m) {};

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @return {boolean}
 */
THREE.Frustum.prototype.intersectsObject = function(object) {};

/**
 * @param {THREE.Sprite} sprite
 * @return {boolean}
 */
THREE.Frustum.prototype.intersectsSprite = function(sprite) {};

/**
 * @param {THREE.Sphere} sphere
 * @return {boolean}
 */
THREE.Frustum.prototype.intersectsSphere = function(sphere) {};

/**
 * @param {THREE.Box3} box
 * @return {boolean}
 */
THREE.Frustum.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Vector3} point
 * @return {boolean}
 */
THREE.Frustum.prototype.containsPoint = function(point) {};
// externs from src/src/math/Box2.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.Vector2)=} min
 * @param {(undefined|THREE.Vector2)=} max
 */
THREE.Box2 = function(min, max) {};
/** @type {THREE.Vector2} */
THREE.Box2.prototype.min;
/** @type {THREE.Vector2} */
THREE.Box2.prototype.max;

/**
 * @param {THREE.Vector2} min
 * @param {THREE.Vector2} max
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.set = function(min, max) {};

/**
 * @param {Array<THREE.Vector2>} points
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.setFromPoints = function(points) {};

/**
 * @param {THREE.Vector2} center
 * @param {THREE.Vector2} size
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.setFromCenterAndSize = function(center, size) {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Box2.prototype.clone = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Box2} box
 * @return {THIS}
 */
THREE.Box2.prototype.copy = function(box) {};

/**
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.makeEmpty = function() {};

/**
 * @return {boolean}
 */
THREE.Box2.prototype.isEmpty = function() {};

/**
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.Box2.prototype.getCenter = function(target) {};

/**
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.Box2.prototype.getSize = function(target) {};

/**
 * @param {THREE.Vector2} point
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.expandByPoint = function(point) {};

/**
 * @param {THREE.Vector2} vector
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.expandByVector = function(vector) {};

/**
 * @param {number} scalar
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.expandByScalar = function(scalar) {};

/**
 * @param {THREE.Vector2} point
 * @return {boolean}
 */
THREE.Box2.prototype.containsPoint = function(point) {};

/**
 * @param {THREE.Box2} box
 * @return {boolean}
 */
THREE.Box2.prototype.containsBox = function(box) {};

/**
 * @param {THREE.Vector2} point
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.Box2.prototype.getParameter = function(point, target) {};

/**
 * @param {THREE.Box2} box
 * @return {boolean}
 */
THREE.Box2.prototype.intersectsBox = function(box) {};

/**
 * @param {THREE.Vector2} point
 * @param {THREE.Vector2} target
 * @return {THREE.Vector2}
 */
THREE.Box2.prototype.clampPoint = function(point, target) {};

/**
 * @param {THREE.Vector2} point
 * @return {number}
 */
THREE.Box2.prototype.distanceToPoint = function(point) {};

/**
 * @param {THREE.Box2} box
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.intersect = function(box) {};

/**
 * @param {THREE.Box2} box
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.union = function(box) {};

/**
 * @param {THREE.Vector2} offset
 * @return {THREE.Box2}
 */
THREE.Box2.prototype.translate = function(offset) {};

/**
 * @param {THREE.Box2} box
 * @return {boolean}
 */
THREE.Box2.prototype.equals = function(box) {};

/**
 * @deprecated Use {\@link Box2#isEmpty .isEmpty()} instead.
 * @return {number}
 */
THREE.Box2.prototype.empty = function() {};

/**
 * @deprecated Use {\@link Box2#intersectsBox .intersectsBox()} instead.
 * @param {number} b
 * @return {number}
 */
THREE.Box2.prototype.isIntersectionBox = function(b) {};
// externs from src/src/math/MathUtils.d.ts:
/** @constructor */
THREE.MathUtils = function() {};
/** @type {number} */
THREE.MathUtils.DEG2RAD;
/** @type {number} */
THREE.MathUtils.RAD2DEG;

/**
 * @return {string}
 */
THREE.MathUtils.generateUUID = function() {};

/**
 * Clamps the x to be between a and b.
 * 
 * @param {number} value Value to be clamped.
 * @param {number} min Minimum value
 * @param {number} max Maximum value.
 * @return {number}
 */
THREE.MathUtils.clamp = function(value, min, max) {};

/**
 * @param {number} n
 * @param {number} m
 * @return {number}
 */
THREE.MathUtils.euclideanModulo = function(n, m) {};

/**
 * Linear mapping of x from range [a1, a2] to range [b1, b2].
 * 
 * @param {number} x Value to be mapped.
 * @param {number} a1 Minimum value for range A.
 * @param {number} a2 Maximum value for range A.
 * @param {number} b1 Minimum value for range B.
 * @param {number} b2 Maximum value for range B.
 * @return {number}
 */
THREE.MathUtils.mapLinear = function(x, a1, a2, b1, b2) {};

/**
 * @param {number} x
 * @param {number} min
 * @param {number} max
 * @return {number}
 */
THREE.MathUtils.smoothstep = function(x, min, max) {};

/**
 * @param {number} x
 * @param {number} min
 * @param {number} max
 * @return {number}
 */
THREE.MathUtils.smootherstep = function(x, min, max) {};

/**
 * Random float from 0 to 1 with 16 bits of randomness.
 * Standard Math.random() creates repetitive patterns when applied over larger space.
 * 
 * @deprecated Use {\@link Math#random Math.random()}
 * @return {number}
 */
THREE.MathUtils.random16 = function() {};

/**
 * Random integer from low to high interval.
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
THREE.MathUtils.randInt = function(low, high) {};

/**
 * Random float from low to high interval.
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
THREE.MathUtils.randFloat = function(low, high) {};

/**
 * Random float from - range / 2 to range / 2 interval.
 * @param {number} range
 * @return {number}
 */
THREE.MathUtils.randFloatSpread = function(range) {};

/**
 * Deterministic pseudo-random float in the interval [ 0, 1 ].
 * @param {(undefined|number)=} seed
 * @return {number}
 */
THREE.MathUtils.seededRandom = function(seed) {};

/**
 * @param {number} degrees
 * @return {number}
 */
THREE.MathUtils.degToRad = function(degrees) {};

/**
 * @param {number} radians
 * @return {number}
 */
THREE.MathUtils.radToDeg = function(radians) {};

/**
 * @param {number} value
 * @return {boolean}
 */
THREE.MathUtils.isPowerOfTwo = function(value) {};

/**
 * @param {number} x
 * @param {number} y
 * @param {number} t
 * @return {number}
 */
THREE.MathUtils.inverseLerp = function(x, y, t) {};

/**
 * Returns a value linearly interpolated from two known points based
 * on the given interval - t = 0 will return x and t = 1 will return y.
 * 
 * @param {number} x Start point.
 * @param {number} y End point.
 * @param {number} t interpolation factor in the closed interval [0, 1]
 * @return {number}
 */
THREE.MathUtils.lerp = function(x, y, t) {};

/**
 * Smoothly interpolate a number from x toward y in a spring-like
 * manner using the dt to maintain frame rate independent movement.
 * 
 * @param {number} x Current point.
 * @param {number} y Target point.
 * @param {number} lambda A higher lambda value will make the movement more sudden, and a lower value will make the movement more gradual.
 * @param {number} dt Delta time in seconds.
 * @return {number}
 */
THREE.MathUtils.damp = function(x, y, lambda, dt) {};

/**
 * Returns a value that alternates between 0 and length.
 * 
 * @param {number} x The value to pingpong.
 * @param {(undefined|number)=} length The positive value the export function will pingpong to. Default is 1.
 * @return {number}
 */
THREE.MathUtils.pingpong = function(x, length) {};

/**
 * @deprecated Use {\@link Math#floorPowerOfTwo .floorPowerOfTwo()}
 * @param {number} value
 * @return {number}
 */
THREE.MathUtils.nearestPowerOfTwo = function(value) {};

/**
 * @deprecated Use {\@link Math#ceilPowerOfTwo .ceilPowerOfTwo()}
 * @param {number} value
 * @return {number}
 */
THREE.MathUtils.nextPowerOfTwo = function(value) {};

/**
 * @param {number} value
 * @return {number}
 */
THREE.MathUtils.floorPowerOfTwo = function(value) {};

/**
 * @param {number} value
 * @return {number}
 */
THREE.MathUtils.ceilPowerOfTwo = function(value) {};

/**
 * @param {THREE.Quaternion} q
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @param {string} order
 * @return {void}
 */
THREE.MathUtils.setQuaternionFromProperEuler = function(q, a, b, c, order) {};
// externs from src/src/objects/LOD.d.ts:

/**
 * @extends {THREE.Object3D}
 * @constructor
 * 
 */
THREE.LOD = function() {};
/** @type {string} */
THREE.LOD.prototype.type;
/** @type {Array<{distance: number, object: THREE.Object3D<THREE.EventDispatcher.Event>}>} */
THREE.LOD.prototype.levels;
/** @type {boolean} */
THREE.LOD.prototype.autoUpdate;
/** @type {boolean} */
THREE.LOD.prototype.isLOD;
/** @type {Array<Object>} */
THREE.LOD.prototype.objects;

/**
 * @template THIS
 * @this {THIS}
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {(undefined|number)=} distance
 * @return {THIS}
 */
THREE.LOD.prototype.addLevel = function(object, distance) {};

/**
 * @return {number}
 */
THREE.LOD.prototype.getCurrentLevel = function() {};

/**
 * @param {number} distance
 * @return {(null|THREE.Object3D<THREE.EventDispatcher.Event>)}
 */
THREE.LOD.prototype.getObjectForDistance = function(distance) {};

/**
 * @param {THREE.Camera} camera
 * @return {void}
 */
THREE.LOD.prototype.update = function(camera) {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.LOD.prototype.toJSON = function(opt_key) {};
// externs from src/src/objects/InstancedMesh.d.ts:

/**
 * @template TGeometry, TMaterial
 * @extends {THREE.Mesh<TGeometry, TMaterial>}
 * @constructor
 * 
 * @param {(undefined|TGeometry)} geometry
 * @param {(undefined|TMaterial)} material
 * @param {number} count
 */
THREE.InstancedMesh = function(geometry, material, count) {};
/** @type {number} */
THREE.InstancedMesh.prototype.count;
/** @type {(null|THREE.InstancedBufferAttribute)} */
THREE.InstancedMesh.prototype.instanceColor;
/** @type {THREE.InstancedBufferAttribute} */
THREE.InstancedMesh.prototype.instanceMatrix;
/** @type {boolean} */
THREE.InstancedMesh.prototype.isInstancedMesh;

/**
 * @param {number} index
 * @param {THREE.Color} color
 * @return {void}
 */
THREE.InstancedMesh.prototype.getColorAt = function(index, color) {};

/**
 * @param {number} index
 * @param {THREE.Matrix4} matrix
 * @return {void}
 */
THREE.InstancedMesh.prototype.getMatrixAt = function(index, matrix) {};

/**
 * @param {number} index
 * @param {THREE.Color} color
 * @return {void}
 */
THREE.InstancedMesh.prototype.setColorAt = function(index, color) {};

/**
 * @param {number} index
 * @param {THREE.Matrix4} matrix
 * @return {void}
 */
THREE.InstancedMesh.prototype.setMatrixAt = function(index, matrix) {};

/**
 * @return {void}
 */
THREE.InstancedMesh.prototype.dispose = function() {};
// externs from src/src/objects/Skeleton.d.ts:

/**
 * @constructor
 * 
 * @param {Array<THREE.Bone>} bones
 * @param {(undefined|Array<THREE.Matrix4>)=} boneInverses
 */
THREE.Skeleton = function(bones, boneInverses) {};
/** @type {string} */
THREE.Skeleton.prototype.uuid;
/** @type {Array<THREE.Bone>} */
THREE.Skeleton.prototype.bones;
/** @type {Array<THREE.Matrix4>} */
THREE.Skeleton.prototype.boneInverses;
/** @type {Float32Array} */
THREE.Skeleton.prototype.boneMatrices;
/** @type {(null|THREE.DataTexture)} */
THREE.Skeleton.prototype.boneTexture;
/** @type {number} */
THREE.Skeleton.prototype.boneTextureSize;
/** @type {number} */
THREE.Skeleton.prototype.frame;
/** @type {boolean} */
THREE.Skeleton.prototype.useVertexTexture;

/**
 * @return {void}
 */
THREE.Skeleton.prototype.init = function() {};

/**
 * @return {void}
 */
THREE.Skeleton.prototype.calculateInverses = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @return {THIS}
 */
THREE.Skeleton.prototype.computeBoneTexture = function() {};

/**
 * @return {void}
 */
THREE.Skeleton.prototype.pose = function() {};

/**
 * @return {void}
 */
THREE.Skeleton.prototype.update = function() {};

/**
 * @return {THREE.Skeleton}
 */
THREE.Skeleton.prototype.clone = function() {};

/**
 * @param {string} name
 * @return {(undefined|THREE.Bone)}
 */
THREE.Skeleton.prototype.getBoneByName = function(name) {};

/**
 * @return {void}
 */
THREE.Skeleton.prototype.dispose = function() {};
// externs from src/src/objects/SkinnedMesh.d.ts:

/**
 * @template TGeometry, TMaterial
 * @extends {THREE.Mesh<TGeometry, TMaterial>}
 * @constructor
 * 
 * @param {(undefined|TGeometry)=} geometry
 * @param {(undefined|TMaterial)=} material
 * @param {(undefined|boolean)=} useVertexTexture
 */
THREE.SkinnedMesh = function(geometry, material, useVertexTexture) {};
/** @type {string} */
THREE.SkinnedMesh.prototype.bindMode;
/** @type {THREE.Matrix4} */
THREE.SkinnedMesh.prototype.bindMatrix;
/** @type {THREE.Matrix4} */
THREE.SkinnedMesh.prototype.bindMatrixInverse;
/** @type {THREE.Skeleton} */
THREE.SkinnedMesh.prototype.skeleton;
/** @type {boolean} */
THREE.SkinnedMesh.prototype.isSkinnedMesh;

/**
 * @param {THREE.Skeleton} skeleton
 * @param {(undefined|THREE.Matrix4)=} bindMatrix
 * @return {void}
 */
THREE.SkinnedMesh.prototype.bind = function(skeleton, bindMatrix) {};

/**
 * @return {void}
 */
THREE.SkinnedMesh.prototype.pose = function() {};

/**
 * @return {void}
 */
THREE.SkinnedMesh.prototype.normalizeSkinWeights = function() {};

/**
 * @param {(undefined|boolean)=} force
 * @return {void}
 */
THREE.SkinnedMesh.prototype.updateMatrixWorld = function(force) {};

/**
 * @param {number} index
 * @param {THREE.Vector3} target
 * @return {THREE.Vector3}
 */
THREE.SkinnedMesh.prototype.boneTransform = function(index, target) {};
// externs from src/src/objects/LineLoop.d.ts:

/**
 * @template TGeometry, TMaterial
 * @extends {THREE.Line<TGeometry, TMaterial>}
 * @constructor
 * 
 * @param {(undefined|TGeometry)=} geometry
 * @param {(undefined|TMaterial)=} material
 */
THREE.LineLoop = function(geometry, material) {};
/** @type {string} */
THREE.LineLoop.prototype.type;
/** @type {boolean} */
THREE.LineLoop.prototype.isLineLoop;
// externs from src/src/objects/Points.d.ts:

/**
 * @template TGeometry, TMaterial
 * @extends {THREE.Object3D}
 * @constructor
 * 
 * @param {(undefined|TGeometry)=} geometry An instance of BufferGeometry.
 * @param {(undefined|TMaterial)=} material An instance of Material (optional).
 */
THREE.Points = function(geometry, material) {};
/** @type {string} */
THREE.Points.prototype.type;
/** @type {(undefined|Array<number>)} */
THREE.Points.prototype.morphTargetInfluences;
/** @type {(undefined|Object<string,number>)} */
THREE.Points.prototype.morphTargetDictionary;
/** @type {boolean} */
THREE.Points.prototype.isPoints;
/** @type {TGeometry} */
THREE.Points.prototype.geometry;
/** @type {TMaterial} */
THREE.Points.prototype.material;

/**
 * @return {void}
 */
THREE.Points.prototype.updateMorphTargets = function() {};
// externs from src/src/renderers/WebGLMultisampleRenderTarget.d.ts:

/**
 * @constructor
 * 
 * @param {number} width
 * @param {number} height
 * @param {(undefined|THREE.WebGLRenderTargetOptions)=} options
 */
THREE.WebGLMultisampleRenderTarget = function(width, height, options) {};
/** @type {boolean} */
THREE.WebGLMultisampleRenderTarget.prototype.isWebGLMultisampleRenderTarget;
/** @type {number} */
THREE.WebGLMultisampleRenderTarget.prototype.samples;
// externs from src/src/renderers/WebGL1Renderer.d.ts:

/**
 * @constructor
 * 
 * @param {(undefined|THREE.WebGLRendererParameters)=} parameters
 */
THREE.WebGL1Renderer = function(parameters) {};
/** @type {boolean} */
THREE.WebGL1Renderer.prototype.isWebGL1Renderer;
// externs from src/src/renderers/shaders/UniformsUtils.d.ts:

/**
 * @param {number} uniforms_src
 * @return {number}
 */
THREE.UniformsUtils.cloneUniforms = function(uniforms_src) {};

/**
 * @param {Array<Object>} uniforms
 * @return {number}
 */
THREE.UniformsUtils.mergeUniforms = function(uniforms) {};
/** @constructor */
THREE.UniformsUtils = function() {};

// externs from src/src/renderers/shaders/ShaderChunk.d.ts:
/** @constructor */
THREE.ShaderChunk = function() {};

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {THREE.WebGLExtensions} extensions
 * @param {THREE.WebGLInfo} info
 * @param {THREE.WebGLCapabilities} capabilities
 */
THREE.WebGLBufferRenderer = function(gl, extensions, info, capabilities) {};

/**
 * @param {number} value
 * @return {void}
 */
THREE.WebGLBufferRenderer.prototype.setMode = function(value) {};

/**
 * @param {number} start
 * @param {number} count
 * @return {void}
 */
THREE.WebGLBufferRenderer.prototype.render = function(start, count) {};

/**
 * @param {number} start
 * @param {number} count
 * @param {number} primcount
 * @return {void}
 */
THREE.WebGLBufferRenderer.prototype.renderInstances = function(start, count, primcount) {};
// externs from src/src/renderers/webgl/WebGLClipping.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLProperties} properties
 */
THREE.WebGLClipping = function(properties) {};
/** @type {{value: Object, needsUpdate: boolean}} */
THREE.WebGLClipping.prototype.uniform;
/** @type {number} */
THREE.WebGLClipping.prototype.numPlanes;
/** @type {number} */
THREE.WebGLClipping.prototype.numIntersection;

/**
 * @param {Array<Object>} planes
 * @param {boolean} enableLocalClipping
 * @param {THREE.Camera} camera
 * @return {boolean}
 */
THREE.WebGLClipping.prototype.init = function(planes, enableLocalClipping, camera) {};

/**
 * @return {void}
 */
THREE.WebGLClipping.prototype.beginShadows = function() {};

/**
 * @return {void}
 */
THREE.WebGLClipping.prototype.endShadows = function() {};

/**
 * @param {THREE.Material} material
 * @param {THREE.Camera} camera
 * @param {boolean} useCache
 * @return {void}
 */
THREE.WebGLClipping.prototype.setState = function(material, camera, useCache) {};
// externs from src/src/renderers/webgl/WebGLCubeUVMaps.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLRenderer} renderer
 */
THREE.WebGLCubeUVMaps = function(renderer) {};

/**
 * @template T
 * @param {T} texture
 * @return {number}
 */
THREE.WebGLCubeUVMaps.prototype.get = function(texture) {};

/**
 * @return {void}
 */
THREE.WebGLCubeUVMaps.prototype.dispose = function() {};
// externs from src/src/renderers/webgl/WebGLAttributes.d.ts:

/**
 * @constructor
 * 
 * @param {(!WebGLRenderingContext|WebGL2RenderingContext)} gl
 * @param {THREE.WebGLCapabilities} capabilities
 */
THREE.WebGLAttributes = function(gl, capabilities) {};

/**
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)} attribute
 * @return {{buffer: WebGLBuffer, type: number, bytesPerElement: number, version: number}}
 */
THREE.WebGLAttributes.prototype.get = function(attribute) {};

/**
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)} attribute
 * @return {void}
 */
THREE.WebGLAttributes.prototype.remove = function(attribute) {};

/**
 * @param {(!THREE.BufferAttribute|THREE.InterleavedBufferAttribute)} attribute
 * @param {number} bufferType
 * @return {void}
 */
THREE.WebGLAttributes.prototype.update = function(attribute, bufferType) {};
// externs from src/src/renderers/webgl/WebGLGeometries.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {THREE.WebGLAttributes} attributes
 * @param {THREE.WebGLInfo} info
 */
THREE.WebGLGeometries = function(gl, attributes, info) {};

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {THREE.BufferGeometry} geometry
 * @return {THREE.BufferGeometry}
 */
THREE.WebGLGeometries.prototype.get = function(object, geometry) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @return {void}
 */
THREE.WebGLGeometries.prototype.update = function(geometry) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @return {THREE.BufferAttribute}
 */
THREE.WebGLGeometries.prototype.getWireframeAttribute = function(geometry) {};
// externs from src/src/renderers/webgl/WebGLIndexedBufferRenderer.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {number} extensions
 * @param {number} info
 * @param {number} capabilities
 */
THREE.WebGLIndexedBufferRenderer = function(gl, extensions, info, capabilities) {};

/**
 * @param {number} value
 * @return {void}
 */
THREE.WebGLIndexedBufferRenderer.prototype.setMode = function(value) {};

/**
 * @param {number} index
 * @return {void}
 */
THREE.WebGLIndexedBufferRenderer.prototype.setIndex = function(index) {};

/**
 * @param {number} start
 * @param {number} count
 * @return {void}
 */
THREE.WebGLIndexedBufferRenderer.prototype.render = function(start, count) {};

/**
 * @param {number} start
 * @param {number} count
 * @param {number} primcount
 * @return {void}
 */
THREE.WebGLIndexedBufferRenderer.prototype.renderInstances = function(start, count, primcount) {};
// externs from src/src/renderers/webgl/WebGLLights.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLExtensions} extensions
 * @param {THREE.WebGLCapabilities} capabilities
 */
THREE.WebGLLights = function(extensions, capabilities) {};
/** @type {{version: number, hash: {directionalLength: number, pointLength: number, spotLength: number, rectAreaLength: number, hemiLength: number, numDirectionalShadows: number, numPointShadows: number, numSpotShadows: number}, ambient: Array<number>, probe: Array<Object>, directional: Array<Object>, directionalShadow: Array<Object>, directionalShadowMap: Array<Object>, directionalShadowMatrix: Array<Object>, spot: Array<Object>, spotShadow: Array<Object>, spotShadowMap: Array<Object>, spotShadowMatrix: Array<Object>, rectArea: Array<Object>, point: Array<Object>, pointShadow: Array<Object>, pointShadowMap: Array<Object>, pointShadowMatrix: Array<Object>, hemi: Array<Object>}} */
THREE.WebGLLights.prototype.state;

/**
 * @param {number} light
 * @return {number}
 */
THREE.WebGLLights.prototype.get = function(light) {};

/**
 * @param {number} lights
 * @return {void}
 */
THREE.WebGLLights.prototype.setup = function(lights) {};

/**
 * @param {number} lights
 * @param {number} camera
 * @return {void}
 */
THREE.WebGLLights.prototype.setupView = function(lights, camera) {};
// externs from src/src/renderers/webgl/WebGLCubeMaps.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLRenderer} renderer
 */
THREE.WebGLCubeMaps = function(renderer) {};

/**
 * @param {number} texture
 * @return {number}
 */
THREE.WebGLCubeMaps.prototype.get = function(texture) {};

/**
 * @return {void}
 */
THREE.WebGLCubeMaps.prototype.dispose = function() {};
// externs from src/src/renderers/webgl/WebGLBindingStates.d.ts:

/**
 * @constructor
 * 
 * @param {WebGLRenderingContext} gl
 * @param {THREE.WebGLExtensions} extensions
 * @param {THREE.WebGLAttributes} attributes
 * @param {THREE.WebGLCapabilities} capabilities
 */
THREE.WebGLBindingStates = function(gl, extensions, attributes, capabilities) {};

/**
 * @param {THREE.Object3D<THREE.EventDispatcher.Event>} object
 * @param {THREE.Material} material
 * @param {THREE.WebGLProgram} program
 * @param {THREE.BufferGeometry} geometry
 * @param {THREE.BufferAttribute} index
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.setup = function(object, material, program, geometry, index) {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.reset = function() {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.resetDefaultState = function() {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.dispose = function() {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.releaseStatesOfGeometry = function() {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.releaseStatesOfProgram = function() {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.initAttributes = function() {};

/**
 * @param {number} attribute
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.enableAttribute = function(attribute) {};

/**
 * @return {void}
 */
THREE.WebGLBindingStates.prototype.disableUnusedAttributes = function() {};
// externs from src/src/renderers/webgl/WebGLPrograms.d.ts:

/**
 * @constructor
 * 
 * @param {THREE.WebGLRenderer} renderer
 * @param {THREE.WebGLCubeMaps} cubemaps
 * @param {THREE.WebGLExtensions} extensions
 * @param {THREE.WebGLCapabilities} capabilities
 * @param {THREE.WebGLBindingStates} bindingStates
 * @param {THREE.WebGLClipping} clipping
 */
THREE.WebGLPrograms = function(renderer, cubemaps, extensions, capabilities, bindingStates, clipping) {};
/** @type {Array<THREE.WebGLProgram>} */
THREE.WebGLPrograms.prototype.programs;

/**
 * @param {THREE.Material} material
 * @param {number} lights
 * @param {Array<Object>} shadows
 * @param {THREE.Scene} scene
 * @param {number} object
 * @return {number}
 */
THREE.WebGLPrograms.prototype.getParameters = function(material, lights, shadows, scene, object) {};

/**
 * @param {number} parameters
 * @return {string}
 */
THREE.WebGLPrograms.prototype.getProgramCacheKey = function(parameters) {};

/**
 * @param {THREE.Material} material
 * @return {Object}
 */
THREE.WebGLPrograms.prototype.getUniforms = function(material) {};

/**
 * @param {number} parameters
 * @param {string} cacheKey
 * @return {THREE.WebGLProgram}
 */
THREE.WebGLPrograms.prototype.acquireProgram = function(parameters, cacheKey) {};

/**
 * @param {THREE.WebGLProgram} program
 * @return {void}
 */
THREE.WebGLPrograms.prototype.releaseProgram = function(program) {};
// externs from src/src/renderers/webxr/WebXRController.d.ts:

/** @type {string} */
THREE.XRControllerEventType;

/**
 * @constructor
 * 
 */
THREE.WebXRController = function() {};

/**
 * @return {THREE.Group}
 */
THREE.WebXRController.prototype.getTargetRaySpace = function() {};

/**
 * @return {THREE.Group}
 */
THREE.WebXRController.prototype.getGripSpace = function() {};

/**
 * @template THIS
 * @this {THIS}
 * @param {{type: string, data: (undefined|XRInputSource)}} event
 * @return {THIS}
 */
THREE.WebXRController.prototype.dispatchEvent = function(event) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {XRInputSource} inputSource
 * @return {THIS}
 */
THREE.WebXRController.prototype.disconnect = function(inputSource) {};

/**
 * @template THIS
 * @this {THIS}
 * @param {XRInputSource} inputSource
 * @param {XRFrame} frame
 * @param {XRReferenceSpace} referenceSpace
 * @return {THIS}
 */
THREE.WebXRController.prototype.update = function(inputSource, frame, referenceSpace) {};
// externs from src/src/scenes/FogExp2.d.ts:

/**
 * @implements {THREE.FogBase}
 * @constructor
 * 
 * @param {(string|number)} hex
 * @param {(undefined|number)=} density
 */
THREE.FogExp2 = function(hex, density) {};
/** @type {string} */
THREE.FogExp2.prototype.name;
/** @type {THREE.Color} */
THREE.FogExp2.prototype.color;
/** @type {number} */
THREE.FogExp2.prototype.density;
/** @type {boolean} */
THREE.FogExp2.prototype.isFogExp2;

/**
 * @return {THREE.FogExp2}
 */
THREE.FogExp2.prototype.clone = function() {};

/**
 * @param {string=} opt_key
 * @return {*}
 */
THREE.FogExp2.prototype.toJSON = function(opt_key) {};
// externs from src/src/textures/VideoTexture.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {HTMLVideoElement} video
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} format
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} anisotropy
 */
THREE.VideoTexture = function(video, mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy) {};
/** @type {boolean} */
THREE.VideoTexture.prototype.isVideoTexture;
/** @type {boolean} */
THREE.VideoTexture.prototype.generateMipmaps;
// externs from src/src/textures/CanvasTexture.d.ts:

/**
 * @extends {THREE.Texture}
 * @constructor
 * 
 * @param {(!HTMLImageElement|HTMLCanvasElement|HTMLVideoElement|ImageBitmap)} canvas
 * @param {(undefined|number)=} mapping
 * @param {(undefined|number)=} wrapS
 * @param {(undefined|number)=} wrapT
 * @param {(undefined|number)=} magFilter
 * @param {(undefined|number)=} minFilter
 * @param {(undefined|number)=} format
 * @param {(undefined|number)=} type
 * @param {(undefined|number)=} anisotropy
 */
THREE.CanvasTexture = function(canvas, mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy) {};
/** @type {boolean} */
THREE.CanvasTexture.prototype.isCanvasTexture;


/**
 * @extends {THREE.Texture}
 * @constructor
 *
 * @param {number} width
 * @param {number} height
 * @param {number} format
 */
THREE.FramebufferTexture = function(width, height, format) {};

/** @type {boolean} */
THREE.FramebufferTexture.prototype.isFramebufferTexture;


