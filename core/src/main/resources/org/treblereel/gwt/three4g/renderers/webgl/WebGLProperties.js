import {WebGLProperty} from '../../closure/renderers/webgl/WebGLProperty.js';

class WebGLProperties {


	constructor() {
		/**
		 * @type {WeakMap<Object, WebGLProperty>}
		 */
		this.properties = new WeakMap();

	}

	/**
	 * @param {Object} object 
	 * @return {WebGLProperty}
	 */
	get( object ) {

		let map = this.properties.get( object );

		if ( map === undefined ) {

			map = {};
			this.properties.set( object, map );

		}

		return map;

	}

	/**
	 * 
	 * @param {Object} object 
	 */
	remove( object ) {

		this.properties.delete( object );

	}

	/**
	 * 
	 * @param {Object} object 
	 * @param {string} key 
	 * @param {*} value 
	 */
	update( object, key, value ) {

		this.properties.get( object )[ key ] = value;

	}

	dispose() {

		this.properties = new WeakMap();

	}

}


export { WebGLProperties };
