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
