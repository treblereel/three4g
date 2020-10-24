class WebGLAnimation {

	constructor() {

		/** @type {Window|null} */
		this.context = null;
		/** @type {boolean} */
		this.isAnimating = false;
		/** @type {function(number, number)|null} */
		this.animationLoop = null;
		/** @type {?number} */
		this.requestId = null;

	}

	/**
	 * 
	 * @param {number} time 
	 * @param {number} frame 
	 */
	onAnimationFrame(time, frame) {

		this.animationLoop(time, frame);

		this.requestId = this.context.requestAnimationFrame(this.onAnimationFrame);

	}

	start() {

		if (this.isAnimating === true) return;
		if (this.animationLoop === null) return;

		this.requestId = this.context.requestAnimationFrame(this.onAnimationFrame);

		this.isAnimating = true;

	}

	stop() {

		this.context.cancelAnimationFrame(this.requestId);

		this.isAnimating = false;

	}

	/**
	 * 
	 * @param {function(number)} callback 
	 */
	setAnimationLoop(callback) {

		this.animationLoop = callback;

	}

	/**
	 * 
	 * @param {Window} value 
	 */
	setContext(value) {

		this.context = value;

	}

}

export { WebGLAnimation };
