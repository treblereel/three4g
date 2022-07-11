/**
 * @externs
 * @suppress {duplicate,checkTypes}
 */

/**
 * @param {THREE.Camera} object
 * @param {HTMLElement=} domElement
 * @extends {THREE.EventDispatcher}
 * @constructor
 */
THREE.OrbitControls = function (object, domElement) {}

/**
 * @type {THREE.Camera}
 */
THREE.OrbitControls.prototype.object;

/**
 * @type {HTMLElement}
 */
THREE.OrbitControls.prototype.domElement;

// API
/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.enabled;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.minDistance;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.maxDistance;

/**
 * @type {THREE.Vector3}
 */
THREE.OrbitControls.prototype.target;


/**
 * @type {number}
 */
THREE.OrbitControls.prototype.minDistance;


/**
 * @type {number}
 */
THREE.OrbitControls.prototype.maxDistance;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.minZoom;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.maxZoom;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.minPolarAngle;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.maxPolarAngle;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.minAzimuthAngle;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.maxAzimuthAngle;

/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.enableDamping;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.dampingFactor;

/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.enableZoom;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.zoomSpeed;

/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.enableRotate;


/**
 * @type {number}
 */
THREE.OrbitControls.prototype.rotateSpeed;

/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.enablePan;
/**
 * @type {number}
 */
THREE.OrbitControls.prototype.panSpeed;
/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.screenSpacePanning;
/**
 * @type {number}
 */
THREE.OrbitControls.prototype.keyPanSpeed;

/**
 * @type {boolean}
 */
THREE.OrbitControls.prototype.autoRotate;

/**
 * @type {number}
 */
THREE.OrbitControls.prototype.autoRotateSpeed;

/**
 * @type {THREE.Vector3}
 */
THREE.OrbitControls.prototype.target0;

/**
 * @type {THREE.Vector3}
 */
THREE.OrbitControls.prototype.position0;
/**
 * @type {number}
 */
THREE.OrbitControls.prototype.zoomO;

/**
 * @return {boolean}
 */
THREE.OrbitControls.prototype.update = function () {};

/**
 * @param {HTMLElement | Window} domElement
 */
THREE.OrbitControls.prototype.listenToKeyEvents = function (domElement) {};

THREE.OrbitControls.prototype.saveState = function () {};

THREE.OrbitControls.prototype.reset= function () {};

THREE.OrbitControls.prototype.dispose = function () {};

/**
 * @return {number}
 */
THREE.OrbitControls.prototype.getPolarAngle = function() {};

/**
 * @return {number}
 */
THREE.OrbitControls.prototype.getAzimuthalAngle = function () {};

/**
 * @return {number}
 */
THREE.OrbitControls.prototype.getDistance = function(){};

/**
 * @param {THREE.Camera} object
 * @param {HTMLElement=} domElement
 * @extends {THREE.OrbitControls}
 * @constructor
 */
THREE.MapControls = function (object, domElement) {}

/**
 * @extends {THREE.Scene}
 * @constructor
 */
THREE.RoomEnvironment = function () {}


/**
 * @param {THREE.LoadingManager=} manager
 * @extends {THREE.Loader}
 * @constructor
 */
THREE.DRACOLoader = function (manager) {}

/**
 *
 * @param {string} path
 * @return {DRACOLoader}
 */
THREE.DRACOLoader.prototype.setDecoderPath = function (path) {};

/**
 *
 * @param {*} config
 * @return {DRACOLoader}
 */
THREE.DRACOLoader.prototype.setDecoderConfig = function (config) {};

/**
 *
 * @param {number} workerLimit
 * @return {DRACOLoader}
 */
THREE.DRACOLoader.prototype.setWorkerLimit = function (workerLimit) {};

/**
 * @return {DRACOLoader}
 */
THREE.DRACOLoader.prototype.preload = function () {};
/**
 * @return {DRACOLoader}
 */
THREE.DRACOLoader.prototype.dispose = function () {};

/**
 * @param {THREE.LoadingManager=} manager
 * @extends {THREE.Loader}
 * @constructor
 */
THREE.GLTFLoader = function (manager) {}


/**
 * @param {string} url
 * @param {function(!Array<!THREE.AnimationClip>): void} onLoad
 * @param {(undefined|function(!ProgressEvent<!EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {void}
 */
THREE.GLTFLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @param {THREE.DRACOLoader} dracoLoader
 * @return {THREE.GLTFLoader}
 */
THREE.GLTFLoader.prototype.setDRACOLoader = function (dracoLoader) {};


/**
 * @record
 */
THREE.SkeletonUtils = function() {};

/**
 * @param {THREE.Object3D|THREE.Skeleton} target
 * @param {THREE.Object3D|THREE.Skeleton} source
 * @param {*} options
 */
THREE.SkeletonUtils.retarget = function(target, source, options) {};

/**
 * @param {THREE.Object3D|THREE.Skeleton} target
 * @param {THREE.Object3D|THREE.Skeleton} source
 * @param {THREE.AnimationClip} clip
 * @param {*} options
 * @return {THREE.AnimationClip}
 */
THREE.SkeletonUtils.retargetClip = function(target, source, clip, options) {};

/**
 * @param {THREE.Skeleton} skeleton
 * @return {THREE.SkeletonHelper}
 */
THREE.SkeletonUtils.getHelperFromSkeleton = function(skeleton) {};


/**
 * @param {THREE.Object3D|THREE.Skeleton} target
 * @param {THREE.Object3D|THREE.Skeleton} source
 * @param {*} options
 * @return {Array<THREE.Matrix4>}
 */
THREE.SkeletonUtils.getSkeletonOffsets = function(target, source, options) {};

/**
 * @param {THREE.Skeleton} skeleton
 * @param {*} names
 * @return {*}
 */
THREE.SkeletonUtils.renameBones = function(skeleton, names) {};

/**
 * @param {THREE.Skeleton|Array<THREE.Bone>} skeleton
 * @return {Array<THREE.Bone>}
 */
THREE.SkeletonUtils.getBones = function(skeleton) {};

/**
 * @param {String} name
 * @param {THREE.Skeleton} skeleton
 * @return {THREE.Bone}
 */
THREE.SkeletonUtils.getBoneByName = function(name, skeleton) {};

/**
 * @param {THREE.Bone} bone
 * @param {*} names
 * @return {THREE.Bone}
 */
THREE.SkeletonUtils.getNearestBone = function(bone, names) {};

/**
 * @param {THREE.Bone} bone
 * @param {Array} tracks
 * @return {*}
 */
THREE.SkeletonUtils.findBoneTrackData = function(bone, tracks) {};

/**
 * @param {THREE.Skeleton} skeleton
 * @param {THREE.Skeleton} targetSkeleton
 * @return {Array<String>}
 */
THREE.SkeletonUtils.getEqualsBonesNames = function(skeleton, targetSkeleton) {};

/**
 * @param {THREE.Object3D} source
 * @return {THREE.Object3D}
 */
THREE.SkeletonUtils.clone = function(source) {};

/**
 * @param {(undefined|number)=} fov
 * @param {(undefined|number)=} aspect
 * @param {(undefined|number)=} near
 * @param {(undefined|number)=} far
 * @extends {THREE.PerspectiveCamera}
 * @constructor
 */
THREE.CinematicCamera = function (fov, aspect, near, far) {}

/**
 * @typedef {{
 *     enabled: (boolean|undefined),
 *     scene: (THREE.Scene|undefined),
 *     camera: (THREE.OrthographicCamera|undefined),
 *     rtTextureDepth: (THREE.WebGLRenderTarget|undefined),
 *     rtTextureColor: (THREE.WebGLRenderTarget|undefined),
 *     bokeh_uniforms: (BokehShaderUniforms),
 * }}
 */
var postprocessing;

/**
 * @type {postprocessing}
 */
THREE.CinematicCamera.prototype.postprocessing;

/**
 * @typedef {{
 *     rings: (Number|undefined),
 *     samples: (Number|undefined),
 * }}
 */
var shaderSettings;

/**
 * @type {shaderSettings}
 */
THREE.CinematicCamera.prototype.shaderSettings;

/**
 * @type {THREE.ShaderMaterial}
 */
THREE.CinematicCamera.prototype.materialDepth;

/**
 * @type {(undefined|number)}
 */
THREE.CinematicCamera.prototype.coc;

/**
 * @type {(undefined|number)}
 */
THREE.CinematicCamera.prototype.aperture;

/**
 * @type {(undefined|number)}
 */
THREE.CinematicCamera.prototype.fNumber;

/**
 * @type {(undefined|number)}
 */
THREE.CinematicCamera.prototype.hyperFocal;

/**
 * @type {(undefined|number)}
 */
THREE.CinematicCamera.prototype.filmGauge;


/**
 * @return {(undefined|number)}
 * @param {(undefined|number)=} depth
 */
THREE.CinematicCamera.prototype.linearize = function (depth) {};

/**
 * @return {(undefined|number)}
 * @param {(undefined|number)=} depth
 * @param {(undefined|number)=} near
 * @param {(undefined|number)=} far
 */
THREE.CinematicCamera.prototype.smoothstep = function (near, far, depth) {};

/**
 * @return {(undefined|number)}
 * @param {(undefined|number)=} x
 */
THREE.CinematicCamera.prototype.saturate = function (x) {};

THREE.CinematicCamera.prototype.initPostProcessing = function () {};

/**
 * @return {(undefined|number)}
 * @param {THREE.Scene} scene
 * @param {THREE.WebGLRenderer} renderer
 */
THREE.CinematicCamera.prototype.renderCinematic = function (scene, renderer) {};

/**
 * @deprecated Use {\@link PerspectiveCamera#setFocalLength .setFocalLength()} and {\@link PerspectiveCamera#filmGauge .filmGauge} instead.
 * @param {number} focalLength
 * @param {(undefined|number)=} frameHeight
 * @param {(undefined|number)=} fNumber
 * @param {(undefined|number)=} coc
 * @return {void}
 */
THREE.CinematicCamera.prototype.setLens = function(focalLength, frameHeight, fNumber, coc) {};

/**
 * @param {(undefined|number)=} focusDistance
 */
THREE.CinematicCamera.prototype.focusAt = function (focusDistance) {};



/**
 * @typedef {{
 *     textureWidth: (Uniform|undefined),
 *     textureHeight: (Uniform|undefined),
 *     focalDepth: (Uniform|undefined),
 *     focalLength: (Uniform|undefined),
 *     fstop: (Uniform|undefined),
 *     tColor: (Uniform|undefined),
 *     tDepth: (Uniform|undefined),
 *     maxblur: (Uniform|undefined),
 *     showFocus: (Uniform|undefined),
 *     manualdof: (Uniform|undefined),
 *     vignetting: (Uniform|undefined),
 *     depthblur: (Uniform|undefined),
 *     threshold: (Uniform|undefined),
 *     gain: (Uniform|undefined),
 *     bias: (Uniform|undefined),
 *     fringe: (Uniform|undefined),
 *     znear: (Uniform|undefined),
 *     zfar: (Uniform|undefined),
 *     noise: (Uniform|undefined),
 *     dithering: (Uniform|undefined),
 *     pentagon: (Uniform|undefined),
 *     shaderFocus: (Uniform|undefined),
 *     focusCoords: (Uniform|undefined),
 * }}
 */
var BokehShaderUniforms;


/**
 * @constructor
 */
THREE.BokehShader = function () {};

/**
 * @type {BokehShaderUniforms}
 */
THREE.BokehShader.prototype.uniforms;

/**
 * @type {string}
 */
THREE.BokehShader.prototype.vertexShader;

/**
 * @type {string}
 */
THREE.BokehShader.prototype.fragmentShader;

/**
 * @constructor
 */
THREE.BokehDepthShader = function () {};

/**
 * @typedef {{
 *    mNear: (Uniform|undefined),
 *    mFar: (Uniform|undefined),
 * }}
 */
THREE.BokehDepthShader.prototype.uniforms;

/**
 * @type {string}
 */
THREE.BokehDepthShader.prototype.vertexShader;

/**
 * @type {string}
 */
THREE.BokehDepthShader.prototype.fragmentShader;

/**
 * @param {THREE.LoadingManager=} manager
 * @extends {THREE.Loader}
 * @constructor
 */
THREE.FontLoader = function (manager) {}


/**
 * @param {string} url
 * @param {function(!Font): void} onLoad
 * @param {(undefined|function(!ProgressEvent<!EventTarget>): void)=} onProgress
 * @param {(undefined|function(!ErrorEvent): void)=} onError
 * @return {void}
 */
THREE.FontLoader.prototype.load = function(url, onLoad, onProgress, onError) {};

/**
 * @constructor
 */
THREE.Font = function () {}

/**
 * @const {String}
 */
THREE.Font.prototype.type;

/**
 * @const {String}
 */
THREE.Font.prototype.data;

/**
 * @param {String} text
 * @param {number} number
 * @return {Array<THREE.Shape>}
 */
THREE.Font.prototype.generateShapes = function (text, number) {};

/**
 * @extends {THREE.ExtrudeGeometry}
 * @param {string} text
 * @param {THREE.TextGeometryParameters} parameters
 * @constructor
 */
THREE.TextGeometry = function (text, parameters) {};

/**
 * @const {String}
 */
THREE.TextGeometry.prototype.type;

/**
 * @record
 */
THREE.TextGeometryParameters = function() {};

/** @type {THREE.Font} */
THREE.TextGeometryParameters.prototype.font;

/** @type {number} */
THREE.TextGeometryParameters.prototype.size;

/** @type {number} */
THREE.TextGeometryParameters.prototype.height;

/** @type {number} */
THREE.TextGeometryParameters.prototype.curveSegments;

/** @type {boolean} */
THREE.TextGeometryParameters.prototype.bevelEnabled;

/** @type {number} */
THREE.TextGeometryParameters.prototype.bevelThickness;

/** @type {number} */
THREE.TextGeometryParameters.prototype.bevelSize;

/** @type {number} */
THREE.TextGeometryParameters.prototype.bevelOffset;

/** @type {number} */
THREE.TextGeometryParameters.prototype.bevelSegments;

/**
 * @extends {THREE.BufferGeometry}
 * @param {THREE.Mesh} mesh
 * @param {THREE.Vector3} position
 * @param {THREE.Euler} orientation
 * @param {THREE.Vector3} size
 * @constructor
 */
THREE.DecalGeometry = function (mesh, position, orientation, size) {};

/**
 * @param {THREE.Vector3} position
 * @param {THREE.Vector3} normal
 * @constructor
 */
THREE.DecalVertex = function (position,  normal) {};

/**
 * @param {THREE.WebGLRenderer} renderer
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} height
 * @constructor
 */
THREE.AnaglyphEffect = function (renderer,  width, height) {};

/**
 * @type {THREE.Matrix3}
 */
THREE.AnaglyphEffect.prototype.colorMatrixLeft;

/**
 * @type {THREE.Matrix3}
 */
THREE.AnaglyphEffect.prototype.colorMatrixRight;


THREE.AnaglyphEffect.prototype.dispose = function() {};

/**
 *
 * @param {THREE.Scene} scene
 * @param {THREE.Camera} camera
 */
THREE.AnaglyphEffect.prototype.render = function(scene, camera){};

/**
 *
 * @param {(undefined|number)} width
 * @param {(undefined|number)} height
 */
THREE.AnaglyphEffect.prototype.setSize = function(width, height) {};


/**
 * @typedef {{
 *     resolution: (number|undefined),
 *     scale: (number|undefined),
 *     color: (boolean|undefined),
 *     alpha: (boolean|undefined),
 *     block: (boolean|undefined),
 *     invert: (boolean|undefined),
 * }}
 */
var AsciiEffectOptions;

/**
 * @param {THREE.WebGLRenderer} renderer
 * @param {(undefined|string)} charSet
 * @param {(undefined|AsciiEffectOptions)} options
 * @constructor
 */
THREE.AsciiEffect = function (renderer,  charSet, options) {};

/**
 * @type {HTMLElement}
 */
THREE.AsciiEffect.prototype.domElement;

/**
 *
 * @param {THREE.Scene} scene
 * @param {THREE.Camera} camera
 */
THREE.AsciiEffect.prototype.render = function(scene, camera){};

/**
 *
 * @param {(undefined|number)} width
 * @param {(undefined|number)} height
 */
THREE.AsciiEffect.prototype.setSize = function(width, height) {};

/**
 * @param {THREE.Camera} object
 * @param {HTMLElement=} domElement
 * @extends {THREE.EventDispatcher}
 * @constructor
 */
THREE.TrackballControls = function (object,  domElement) {};

/** @type {THREE.Camera} */
THREE.TrackballControls.prototype.object;
/** @type {HTMLElement} */
THREE.TrackballControls.prototype.domElement;
/** @type {boolean} */
THREE.TrackballControls.prototype.enabled;

/**
 * @typedef {{
 *     left: (number|undefined),
 *     top: (number|undefined),
 *     width: (number|undefined),
 *     height: (number|undefined),
 * }}
 */
THREE.TrackballControls.prototype.screen;
/** @type {number} */
THREE.TrackballControls.prototype.rotateSpeed;
/** @type {number} */
THREE.TrackballControls.prototype.zoomSpeed;
/** @type {number} */
THREE.TrackballControls.prototype.panSpeed;
/** @type {boolean} */
THREE.TrackballControls.prototype.noRotate;
/** @type {boolean} */
THREE.TrackballControls.prototype.noZoom;
/** @type {boolean} */
THREE.TrackballControls.prototype.noPan;
/** @type {boolean} */
THREE.TrackballControls.prototype.noRoll;
/** @type {boolean} */
THREE.TrackballControls.prototype.staticMoving;
/** @type {number} */
THREE.TrackballControls.prototype.dynamicDampingFactor;
/** @type {number} */
THREE.TrackballControls.prototype.minDistance;
/** @type {number} */
THREE.TrackballControls.prototype.maxDistance;
/** @type {Array<String>} */
THREE.TrackballControls.prototype.keys;

/**
 * @typedef {{
 *     LEFT: (THREE.MOUSE),
 *     MIDDLE: (THREE.MOUSE),
 *     RIGHT: (THREE.MOUSE),
 * }}
 */
THREE.TrackballControls.prototype.mouseButtons

/** @type {THREE.Vector3} */
THREE.TrackballControls.prototype.target;
/** @type {THREE.Vector3} */
THREE.TrackballControls.prototype.position0;
/** @type {THREE.Vector3} */
THREE.TrackballControls.prototype.target0;
/** @type {THREE.Vector3} */
THREE.TrackballControls.prototype.up0;
THREE.TrackballControls.prototype.update = function () {};
THREE.TrackballControls.prototype.reset = function () {};
THREE.TrackballControls.prototype.dispose = function () {};
THREE.TrackballControls.prototype.checkDistances = function () {};
THREE.TrackballControls.prototype.zoomCamera = function () {};
THREE.TrackballControls.prototype.panCamera = function () {};
THREE.TrackballControls.prototype.rotateCamera = function () {};
THREE.TrackballControls.prototype.handleResize = function () {};


/**
 * @param {THREE.WebGLRenderer} renderer
 * @constructor
 */
THREE.ParallaxBarrierEffect = function (renderer) {};

/**
 *
 * @param {THREE.Scene} scene
 * @param {THREE.Camera} camera
 */
THREE.ParallaxBarrierEffect.prototype.render = function(scene, camera) {};


/**
 *
 * @param {number} width
 * @param {number}  height
 */
THREE.ParallaxBarrierEffect.prototype.setSize = function(width, height) {};

/**
 * @param {THREE.WebGLRenderer} renderer
 * @constructor
 */
THREE.PeppersGhostEffect = function (renderer) {};

/** @type {number} */
THREE.PeppersGhostEffect.prototype.cameraDistance;

/** @type {boolean} */
THREE.PeppersGhostEffect.prototype.reflectFromAbove;

/**
 *
 * @param {THREE.Scene} scene
 * @param {THREE.Camera} camera
 */
THREE.PeppersGhostEffect.prototype.render = function(scene, camera) {};

/**
 *
 * @param {number} width
 * @param {number}  height
 */
THREE.PeppersGhostEffect.prototype.setSize = function(width, height) {};

/**
 * @param {THREE.WebGLRenderer} renderer
 * @constructor
 */
THREE.StereoEffect = function (renderer) {};

/**
 *  @param {number} eyeSep
 *
 */
THREE.StereoEffect.prototype.setEyeSeparation = function (eyeSep) {};

/**
 *
 * @param {THREE.Scene} scene
 * @param {THREE.Camera} camera
 */
THREE.StereoEffect.prototype.render = function(scene, camera) {};

/**
 *
 * @param {number} width
 * @param {number}  height
 */
THREE.StereoEffect.prototype.setSize = function(width, height) {};


/**
 * @param {THREE.WebGLRenderer} renderer
 * @constructor
 */
THREE.StereoEffect = function (renderer) {};


/** @const */
THREE.GeometryUtils = {};

/**
 * @param {(THREE.Vector3|undefined)=} center
 * @param {(number|undefined)=} size
 * @param {(number|undefined)=} iterations
 * @param {(number|undefined)=} v0
 * @param {(number|undefined)=} v1
 * @param {(number|undefined)=} v2
 * @param {(number|undefined)=} v3
 * @return {Array<THREE.Vector3>}
 */
THREE.GeometryUtils.hilbert2D = function (
    center,
    size,
    iterations,
    v0,
    v1,
    v2,
    v3,
) {};

/**
 * @param {(THREE.Vector3|undefined)=} center
 * @param {(number|undefined)=} size
 * @param {(number|undefined)=} iterations
 * @param {(number|undefined)=} v0
 * @param {(number|undefined)=} v1
 * @param {(number|undefined)=} v2
 * @param {(number|undefined)=} v3
 * @param {(number|undefined)=} v4
 * @param {(number|undefined)=} v5
 * @param {(number|undefined)=} v6
 * @param {(number|undefined)=} v7
 * @return {Array<THREE.Vector3>}
 */
THREE.GeometryUtils.hilbert3D = function (
    center,
    size,
    iterations,
    v0,
    v1,
    v2,
    v3,
) {};

/**
 * @param {(number|undefined)=} size
 * @return {Array<number>}
 */
THREE.GeometryUtils.gosper = function(size) {};

/**
 *
 * @const
 */
THREE.Curves = {}

/**
 * @extends {THREE.Curve}
 * @constructor
 */
THREE.Curves.GrannyKnot = function () {}

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number} scale
 */
THREE.Curves.HeartCurve = function (scale) {}

/** @type {number} */
THREE.Curves.HeartCurve.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number} scale
 */
THREE.Curves.VivianiCurve = function (scale) {}

/** @type {number} */
THREE.Curves.VivianiCurve.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 */
THREE.Curves.KnotCurve = function () {}

/**
 * @extends {THREE.Curve}
 * @constructor
 */
THREE.Curves.HelixCurve = function () {}

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number=} scale
 */
THREE.Curves.TrefoilKnot = function (scale) {}

/** @type {number} */
THREE.Curves.TrefoilKnot.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number} scale
 */
THREE.Curves.TorusKnot = function (scale) {}

/** @type {number} */
THREE.Curves.TorusKnot.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number} scale
 */
THREE.Curves.CinquefoilKnot = function (scale) {}

/** @type {number} */
THREE.Curves.CinquefoilKnot.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number} scale
 */
THREE.Curves.TrefoilPolynomialKnot = function (scale) {}

/** @type {number} */
THREE.Curves.TrefoilPolynomialKnot.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number=} scale
 */
THREE.Curves.FigureEightPolynomialKnot = function (scale) {}

/** @type {number} */
THREE.Curves.FigureEightPolynomialKnot.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number=} scale
 */
THREE.Curves.DecoratedTorusKnot4a = function (scale) {}

/** @type {number} */
THREE.Curves.DecoratedTorusKnot4a.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number=} scale
 */
THREE.Curves.DecoratedTorusKnot4b = function (scale) {}

/** @type {number} */
THREE.Curves.DecoratedTorusKnot4b.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number=} scale
 */
THREE.Curves.DecoratedTorusKnot5a = function (scale) {}

/** @type {number} */
THREE.Curves.DecoratedTorusKnot5a.prototype.scale;

/**
 * @extends {THREE.Curve}
 * @constructor
 * @param {number=} scale
 */
THREE.Curves.DecoratedTorusKnot5c = function (scale) {}

/** @type {number} */
THREE.Curves.DecoratedTorusKnot5c.prototype.scale;


/**
 * @typedef {{
 *     slices: (undefined|number),
 *     stacks: (undefined|number),
 *     func: function(number, number, THREE.Vector3),
 * }}
 */
var ParametricGeometryParam

/**
 * @extends {THREE.BufferGeometry}
 * @constructor
 *
 * @param {function(number, number, THREE.Vector3)} func
 * @param {(undefined|number)=} slices
 * @param {(undefined|number)=} stacks
 */
THREE.ParametricGeometry = function (func, slices, stacks) {};

/**
 * @type {ParametricGeometryParam}
 */
THREE.ParametricGeometry.prototype.parameters;

/**
 *
 * @const
 */
THREE.ParametricGeometries  = {}

/**
 * @type {function(number, number, THREE.Vector3): THREE.Vector3}
 */
THREE.ParametricGeometries.klein;

/**
 * @type {function(number, number, THREE.Vector3) : THREE.Vector3}
 */
THREE.ParametricGeometries.mobius;

/**
 * @type {function(number, number, THREE.Vector3) : THREE.Vector3}
 */
THREE.ParametricGeometries.mobius3d;

/**
 *
 * @param {number} width
 * @param {number} height
 * @return {function(number, number, THREE.Vector3) : THREE.Vector3}
 */
THREE.ParametricGeometries.plane = function(width, height) {};

/**
 * @extends {THREE.ParametricGeometry}
 * @constructor
 * @param {THREE.Curve} path
 * @param {(undefined|number)=} segments
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} segmentsRadius
 * @param {boolean=} closed
 */
THREE.ParametricGeometries.TubeGeometry = function (path, segments, radius, segmentsRadius, closed) {}

/**
 * @extends {THREE.ParametricGeometries.TubeGeometry}
 * @constructor
 * @param {(undefined|number)=} radius
 * @param {(undefined|number)=} tube
 * @param {(undefined|number)=} segmentsT
 * @param {(undefined|number)=} segmentsR
 * @param {(undefined|number)=} p
 * @param {(undefined|number)=} q
 */
THREE.ParametricGeometries.TorusKnotGeometry = function (radius, tube, segmentsT, segmentsR, p, q){}

/**
 * @extends {THREE.ParametricGeometry}
 * @constructor
 * @param {(undefined|number)=} size
 * @param {(undefined|number)=} u
 * @param {(undefined|number)=} v
 */
THREE.ParametricGeometries.SphereGeometry = function (size, u, v){}

/**
 * @extends {THREE.ParametricGeometry}
 * @constructor
 * @param {(undefined|number)=} width
 * @param {(undefined|number)=} depth
 * @param {(undefined|number)=} segmentsWidth
 * @param {(undefined|number)=} segmentsDepth
 */
THREE.ParametricGeometries.PlaneGeometry = function (width, depth, segmentsWidth, segmentsDepth){}

/**
 * @param {String=} colormap
 * @param {number=} numberofcolors
 * @constructor
 */
THREE.Lut = function (colormap, numberofcolors) {}

/** @type {Array<Color>} */
THREE.Lut.prototype.lut;

/** @type {Array<Object>} */
THREE.Lut.prototype.map;

/** @type {number} */
THREE.Lut.prototype.n;

/** @type {number} */
THREE.Lut.prototype.minV;

/** @type {number} */
THREE.Lut.prototype.maxV;

/**
 * @param {THREE.Lut} value
 * @return {THREE.Lut}
 */
THREE.Lut.prototype.set = function (value) {}

/**
 * @param {number} min
 * @return {THREE.Lut}
 */
THREE.Lut.prototype.setMin = function (min) {}

/**
 * @param {number} max
 * @return {THREE.Lut}
 */
THREE.Lut.prototype.setMax = function (max) {}

/**
 * @param {string} colormap
 * @param {number=} numberofcolors
 * @return {THREE.Lut}
 */
THREE.Lut.prototype.setColorMap = function (colormap, numberofcolors) {}

/**
 * @param {THREE.Lut} lut
 * @return {THREE.Lut}
 */
THREE.Lut.prototype.copy = function (lut) {}

/**
 * @param {number} alpha
 * @return {THREE.Color}
 */
THREE.Lut.prototype.getColor = function(alpha) {}

/**
 * @param {string} colormapName
 * @param {Array<Array<number>>} arrayOfColors
 */
THREE.Lut.prototype.addColorMap = function(colormapName, arrayOfColors) {}

/**
 * @return {HTMLCanvasElement}
 */
THREE.Lut.prototype.createCanvas = function() {}

/**
 * @param {(HTMLImageElement|HTMLCanvasElement|HTMLVideoElement)} canvas
 * @return {HTMLCanvasElement}
 */
THREE.Lut.prototype.updateCanvas = function(canvas) {}

/**
 * @extends {THREE.BufferGeometry}
 * @param {Array<THREE.Vector3>} colormap
 * @constructor
 */
THREE.ConvexGeometry = function (points) {}

/**
 * @constructor
 *
 */
THREE.BufferGeometryUtils = function() {};

/**
 * @param {Array<THREE.BufferGeometry>} geometries
 * @param {boolean=} useGroups
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometryUtils.mergeBufferGeometries = function(geometries, useGroups) {};

/**
 * @param {Array<THREE.BufferAttribute>} attributes
 * @return {THREE.BufferAttribute}
 */
THREE.BufferGeometryUtils.mergeBufferAttributes = function(attributes) {};

/**
 * @param {Array<THREE.BufferAttribute>} attributes
 * @return {THREE.InterleavedBufferAttribute}
 */
THREE.BufferGeometryUtils.interleaveAttributes = function(attributes) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @return {number}
 */
THREE.BufferGeometryUtils.estimateBytesUsed = function(geometry) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @param {number=} tolerance
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometryUtils.mergeVertices = function(geometry, tolerance) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @param {number} drawMode
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometryUtils.toTrianglesDrawMode = function(geometry, drawMode) {};

/**
 * @param {THREE.Mesh|THREE.Line|THREE.Points} geometry
 * @return {object}
 */
THREE.BufferGeometryUtils.computeMorphedAttributes = function(object) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @param {*} MikkTSpace
 * @param {boolean=} negateSign
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometryUtils.computeMikkTSpaceTangents = function(geometry, MikkTSpace, negateSign) {};

/**
 * @param {THREE.BufferGeometry} geometry
 * @return {THREE.BufferGeometry}
 */
THREE.BufferGeometryUtils.mergeGroups = function(geometry) {};

/**
 * @param {THREE.BufferGeometry} geometry
 */
THREE.BufferGeometryUtils.deinterleaveAttribute = function(geometry) {};

/**
 * @param {THREE.BufferGeometry} geometry
 */
THREE.BufferGeometryUtils.deinterleaveGeometry = function(geometry) {};

/**
 *
 * @param {THREE.Camera} object
 * @param {HTMLElement=} domElement
 * @constructor
 */
THREE.FirstPersonControls = function(object, domElement) {};

/** @type {THREE.Camera} */
THREE.FirstPersonControls.prototype.object;

/** @type {HTMLElement | HTMLDocument} */
THREE.FirstPersonControls.prototype.domElement;

/** @type {boolean} */
THREE.FirstPersonControls.prototype.enabled;

/** @type {number} */
THREE.FirstPersonControls.prototype.movementSpeed;

/** @type {number} */
THREE.FirstPersonControls.prototype.lookSpeed;

/** @type {boolean} */
THREE.FirstPersonControls.prototype.lookVertical;

/** @type {boolean} */
THREE.FirstPersonControls.prototype.autoForward;
/** @type {boolean} */
THREE.FirstPersonControls.prototype.activeLook;
/** @type {boolean} */
THREE.FirstPersonControls.prototype.heightSpeed;
/** @type {number} */
THREE.FirstPersonControls.prototype.heightCoef;
/** @type {number} */
THREE.FirstPersonControls.prototype.heightMin;
/** @type {number} */
THREE.FirstPersonControls.prototype.heightMax;
/** @type {boolean} */
THREE.FirstPersonControls.prototype.constrainVertical;
/** @type {number} */
THREE.FirstPersonControls.prototype.verticalMin;
/** @type {number} */
THREE.FirstPersonControls.prototype.verticalMax;
/** @type {boolean} */
THREE.FirstPersonControls.prototype.mouseDragOn;

THREE.FirstPersonControls.prototype.handleResize = function () {};

/**
 *
 * @param {number | Vector3} x
 * @param number} y
 * @param {number} z
 * @return {THREE.FirstPersonControls}
 */
THREE.FirstPersonControls.prototype.lookAt = function (x,y,z) {};

/**
 * @param number} number
 * @param {number} z
 * @return {THREE.FirstPersonControls}
 */
THREE.FirstPersonControls.prototype.update = function (delta) {};

THREE.FirstPersonControls.prototype.dispose = function () {};

/**
 * @constructor
 */
THREE.ImprovedNoise = function () {}

/**
 * @param {number}  x
 * @param {number}  y
 * @param {number}  z
 * @return {number}
 */
THREE.ImprovedNoise.prototype.noise = function (x, y, z) {};

/**
 * @extends {THREE.Curve}
 * @param {number} degree
 * @param {Array<number>} knots
 * @param {Array<THREE.Vector2>|Array<THREE.Vector3>|Array<THREE.Vector4>} controlPoints
 * @param {number=} startKnot
 * @param {number=} endKnot
 * @constructor
 */
THREE.NURBSCurve = function (degree,
    knots,
    controlPoints,
    startKnot,
    endKnot) {}

/** @type {Array} */
THREE.NURBSCurve.prototype.controlPoints

/**
 * @param {number} degree1
 * @param {number} degree2
 * @param {Array<number>} knots1
 * @param {Array<number>} knots2
 * @param {Array<Array<THREE.Vector2>>|Array<Array<THREE.Vector3>>|Array<Array<THREE.Vector4>>} controlPoints
 * @constructor
 */
THREE.NURBSSurface = function (degree1,
                               degree2,
                               knots1,
                               knots2,
                               controlPoints) {}

/**
 *  @param {number} t1
 *  @param {number} t2
 *  @param {THREE.Vector3} target
 */
THREE.NURBSSurface.prototype.getPoint = function (t1, t2, target) {}

/**
 * @extends {THREE.Object3D}
 * @param {THREE.Camera} object
 * @param {HTMLElement=} domElement
 * @constructor
 */
THREE.TransformControls = function (object, domElement) {}

/** @type {HTMLElement} */
THREE.TransformControls.prototype.domElement;

// API
/** @type {HTMLElement} */
THREE.TransformControls.prototype.camera;
/** @type {THREE.Object3D} */
THREE.TransformControls.prototype.object;
/** @type {boolean} */
THREE.TransformControls.prototype.enabled;
/** @type {String} */
THREE.TransformControls.prototype.axis; // 'X' | 'Y' | 'Z' | 'E' | 'XY' | 'YZ' | 'XZ' | 'XYZ' | 'XYZE' | null;
/** @type {String} */
THREE.TransformControls.prototype.mode; // 'translate' | 'rotate' | 'scale';
/** @type {number} */
THREE.TransformControls.prototype.translationSnap;
/** @type {number} */
THREE.TransformControls.prototype.rotationSnap;
/** @type {String} */
THREE.TransformControls.prototype.space; // 'world' | 'local';
/** @type {number} */
THREE.TransformControls.prototype.size;
/** @type {boolean} */
THREE.TransformControls.prototype.dragging;
/** @type {boolean} */
THREE.TransformControls.prototype.showX;
/** @type {boolean} */
THREE.TransformControls.prototype.showY;
/** @type {boolean} */
THREE.TransformControls.prototype.showZ;
/** @const {boolean} */
THREE.TransformControls.prototype.isTransformControls;
/** @type {THREE.MOUSE} */
THREE.TransformControls.prototype.mouseButtons;

/**
 * @return {THREE.TransformControls}
 * @param {THREE.Object3D} object
 */
THREE.TransformControls.prototype.attach = function (object) {};

/**
 * @return {THREE.TransformControls}
 */
THREE.TransformControls.prototype.detach = function () {};

/**
 * @return {String}
 */
THREE.TransformControls.prototype.getMode = function () {};

/**
 * @return {THREE.Raycaster}
 */
THREE.TransformControls.prototype.getRaycaster = function (){};

/**
 * @param {String} mode
 */
THREE.TransformControls.prototype.setMode = function (mode) {};

/**
 * @param {number} translationSnap
 */
THREE.TransformControls.prototype.setTranslationSnap = function (translationSnap){};

/**
 * @param {number} rotationSnap
 */
THREE.TransformControls.prototype.setRotationSnap = function (rotationSnap){};
/**
 * @param {number} scaleSnap
 */
THREE.TransformControls.prototype.setScaleSnap = function (scaleSnap) {};

/**
 * @param {number} size
 */
THREE.TransformControls.prototype.setSize = function (size) {}

/**
 * @param {String} space
 */
THREE.TransformControls.prototype.setSpace = function (space) {};
THREE.TransformControls.prototype.reset = function () {};
THREE.TransformControls.prototype.dispose = function () {};

/**
 * @extends {THREE.Object3D}
 * @constructor
 */
THREE.TransformControlsGizmo = function () {}

/** @type {String} */
THREE.TransformControlsGizmo.prototype.type;

/** @const {boolean} */
THREE.TransformControlsGizmo.prototype.isTransformControlsGizmo;

/**
 * @typedef {{
 *     translate: (THREE.Object3D),
 *     rotate: (THREE.Object3D),
 *     scale: (THREE.Object3D),
 * }}
 */
var TransformControlsGizmoDTO;

/** @type {TransformControlsGizmoDTO} */
THREE.TransformControlsGizmo.prototype.gizmo;

/** @type {TransformControlsGizmoDTO} */
THREE.TransformControlsGizmo.prototype.helper;

/** @type {TransformControlsGizmoDTO} */
THREE.TransformControlsGizmo.prototype.picker;

/**
 * @extends {THREE.Mesh}
 * @constructor
 */
THREE.TransformControlsPlane = function () {}

/** @const {String} */
THREE.TransformControlsPlane.prototype.type;
/** @const {boolean} */
THREE.TransformControlsPlane.prototype.isTransformControlsPlane;
/** @type {String} */
THREE.TransformControlsPlane.prototype.mode;
/** @type {String} */
THREE.TransformControlsPlane.prototype.axis;
/** @type {String} */
THREE.TransformControlsPlane.prototype.space;
/** @type {THREE.Vector3} */
THREE.TransformControlsPlane.prototype.eye;
/** @type {THREE.Vector3} */
THREE.TransformControlsPlane.prototype.worldPosition;
/** @type {THREE.Quaternion} */
THREE.TransformControlsPlane.prototype.worldQuaternion;