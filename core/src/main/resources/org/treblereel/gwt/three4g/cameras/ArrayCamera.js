import { PerspectiveCamera } from './PerspectiveCamera.js';

class ArrayCamera extends PerspectiveCamera {

	/**
	 * @param {Array<PerspectiveCamera>=} array 
	 */
	constructor(array = [] ) {

		super();
		/** @type {Array<PerspectiveCamera>} */
		this.cameras = array;
		/** @type {boolean} */
		this.isArrayCamera = true;

	}

}	

export { ArrayCamera };
