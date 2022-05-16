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