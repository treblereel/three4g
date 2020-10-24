import { Camera } from './Camera.js';
import { Object3D } from '../core/Object3D.js';
import { MathUtils } from '../math/MathUtils.js';
import { Vector4 } from '../math/Vector4.js';

/**
 * @private
 * @typedef {{ enabled: boolean, fullWidth: number, fullHeight: number, offsetX: number, offsetY: number, width: number, height: number }}
 */
var PerspectiveCameraView;

class PerspectiveCamera extends Camera {

	/**
	 * 
	 * @param {number=} fov 
	 * @param {number=} aspect 
	 * @param {number=} near 
	 * @param {number=} far 
	 */
	constructor( fov = 50, aspect = 1, near = 0.1, far = 2000 ) {

		super();

		/**@type {string} */
		this.type = 'PerspectiveCamera';
		/** {number} */
		this.fov = fov;
		/** {number} */
		this.zoom = 1;
		/** {number} */
		this.near = near;
		/** {number} */
		this.far = far;
		/** {number} */
		this.focus = 10;
		/** {number} */
		this.aspect = aspect;
		/** @type {PerspectiveCameraView|null}  */
		this.view = null;
		/** {number} */
		this.filmGauge = 35;	// width of the film (default in millimeters)
		/** {number} */
		this.filmOffset = 0;	// horizontal film offset (same unit as gauge)

		this.updateProjectionMatrix();
		/** @type {boolean} */
		this.isPerspectiveCamera = true;
		/** @type {Vector4} */
		this.viewport;

	}

	/**
	 * @param {PerspectiveCamera} source 
	 * @param {boolean=} recursive 
	 * @return {PerspectiveCamera}
     * @suppress {checkTypes} 
	 */
	copy( source, recursive ) {

		Camera.prototype.copy.call( this, source, recursive );

		this.fov = source.fov;
		this.zoom = source.zoom;

		this.near = source.near;
		this.far = source.far;
		this.focus = source.focus;

		this.aspect = source.aspect;
		this.view = source.view === null ? null : Object.assign( {}, source.view );

		this.filmGauge = source.filmGauge;
		this.filmOffset = source.filmOffset;

		return this;

	}

	/**
	 * Sets the FOV by focal length in respect to the current .filmGauge.
	 *
	 * The default film gauge is 35, so that the focal length can be specified for
	 * a 35mm (full frame) camera.
	 *
	 * Values for focal length and film gauge must have the same unit.
	 */
	
	/**
	 * 
	 * @param {number} focalLength 
	 */
	setFocalLength( focalLength ) {

		/** see {@link http://www.bobatkins.com/photography/technical/field_of_view.html} */
		const vExtentSlope = 0.5 * this.getFilmHeight() / focalLength;

		this.fov = MathUtils.RAD2DEG * 2 * Math.atan( vExtentSlope );
		this.updateProjectionMatrix();

	}

	/**
	 * Calculates the focal length from the current .fov and .filmGauge.
	 * @return {number}
	 */
	getFocalLength() {

		const vExtentSlope = Math.tan( MathUtils.DEG2RAD * 0.5 * this.fov );

		return 0.5 * this.getFilmHeight() / vExtentSlope;

	}

	/**
 	 * @return {number}
	 */
	getEffectiveFOV() {

		return MathUtils.RAD2DEG * 2 * Math.atan(
			Math.tan( MathUtils.DEG2RAD * 0.5 * this.fov ) / this.zoom );

	}

	/**
 	 * @return {number}
	 */
	getFilmWidth() {

		// film not completely covered in portrait format (aspect < 1)
		return this.filmGauge * Math.min( this.aspect, 1 );

	}

	/**
 	 * @return {number}
	 */
	getFilmHeight() {

		// film not completely covered in landscape format (aspect > 1)
		return this.filmGauge / Math.max( this.aspect, 1 );

	}

	/**
	 * Sets an offset in a larger frustum. This is useful for multi-window or
	 * multi-monitor/multi-machine setups.
	 *
	 * For example, if you have 3x2 monitors and each monitor is 1920x1080 and
	 * the monitors are in grid like this
	 *
	 *   +---+---+---+
	 *   | A | B | C |
	 *   +---+---+---+
	 *   | D | E | F |
	 *   +---+---+---+
	 *
	 * then for each monitor you would call it like this
	 *
	 *   const w = 1920;
	 *   const h = 1080;
	 *   const fullWidth = w * 3;
	 *   const fullHeight = h * 2;
	 *
	 *   --A--
	 *   camera.setViewOffset( fullWidth, fullHeight, w * 0, h * 0, w, h );
	 *   --B--
	 *   camera.setViewOffset( fullWidth, fullHeight, w * 1, h * 0, w, h );
	 *   --C--
	 *   camera.setViewOffset( fullWidth, fullHeight, w * 2, h * 0, w, h );
	 *   --D--
	 *   camera.setViewOffset( fullWidth, fullHeight, w * 0, h * 1, w, h );
	 *   --E--
	 *   camera.setViewOffset( fullWidth, fullHeight, w * 1, h * 1, w, h );
	 *   --F--
	 *   camera.setViewOffset( fullWidth, fullHeight, w * 2, h * 1, w, h );
	 *
	 *   Note there is no reason monitors have to be the same size or in a grid.
	 * 
	 * @param {number} fullWidth
	 * @param {number} fullHeight
	 * @param {number} x
	 * @param {number} y
	 * @param {number} width
	 * @param {number} height
	 */
	setViewOffset( fullWidth, fullHeight, x, y, width, height ) {

		this.aspect = fullWidth / fullHeight;

		if ( this.view === null ) {

			this.view = {
				enabled: true,
				fullWidth: 1,
				fullHeight: 1,
				offsetX: 0,
				offsetY: 0,
				width: 1,
				height: 1
			};

		}

		this.view.enabled = true;
		this.view.fullWidth = fullWidth;
		this.view.fullHeight = fullHeight;
		this.view.offsetX = x;
		this.view.offsetY = y;
		this.view.width = width;
		this.view.height = height;

		this.updateProjectionMatrix();

	}

	clearViewOffset() {

		if ( this.view !== null ) {

			this.view.enabled = false;

		}

		this.updateProjectionMatrix();

	}

	updateProjectionMatrix() {

		const near = this.near;
		let top = near * Math.tan( MathUtils.DEG2RAD * 0.5 * this.fov ) / this.zoom;
		let height = 2 * top;
		let width = this.aspect * height;
		let left = - 0.5 * width;
		/** @type {PerspectiveCameraView|null} */
		const view = this.view;

		if ( /** @type {PerspectiveCameraView} */ (this.view) !== null && /** @type {PerspectiveCameraView} */ (this.view).enabled ) {

			const fullWidth = view.fullWidth,
				fullHeight = view.fullHeight;

			left += view.offsetX * width / fullWidth;
			top -= view.offsetY * height / fullHeight;
			width *= view.width / fullWidth;
			height *= view.height / fullHeight;

		}

		const skew = this.filmOffset;
		if ( skew !== 0 ) left += near * skew / this.getFilmWidth();

		this.projectionMatrix.makePerspective( left, left + width, top, top - height, near, this.far );

		this.projectionMatrixInverse.copy( this.projectionMatrix ).invert();

	}

	toJSON( meta ) {

		///** @type { { object: { fov: number, zoom: number } } } */
		const data = Object3D.prototype.toJSON.call( this, meta );

		(/** @type { { object: { fov: number } } } */(data)).object.fov = this.fov;
		(/** @type { { object: { zoom: number } } } */(data)).object.zoom = this.zoom;

		(/** @type { { object: { near: number } } } */(data)).object.near = this.near;
		(/** @type { { object: { far: number } } } */(data)).object.far = this.far;
		(/** @type { { object: { focus: number } } } */(data)).object.focus = this.focus;

		(/** @type { { object: { aspect: number } } } */(data)).object.aspect = this.aspect;

		if ( this.view !== null ) (/** @type { { object: { view: Object } } } */(data)).object.view = Object.assign( {}, this.view );

		(/** @type { { object: { filmGauge: number } } } */(data)).object.filmGauge = this.filmGauge;
		(/** @type { { object: { filmOffset: number } } } */(data)).object.filmOffset = this.filmOffset;

		return data;

	}

}


export { PerspectiveCamera };
