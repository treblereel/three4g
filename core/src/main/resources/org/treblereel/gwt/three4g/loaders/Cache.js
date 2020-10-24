/** @type {Object<string, Object>} */
const files = {};

class _Cache {

	constructor() {

		this.enabled = false;

		/** @type {Object<string, Object>} */
		this.files;

	}

	/**
	 * 
	 * @param {string} key 
	 * @param {Object} file 
	 */
	add( key, file ) {

		if ( this.enabled === false ) return;

		files[ key ] = file;

	}

	/**
	 * 
	 * @param {string} key 
	 * @return {Object|undefined} 
	 */
	get( key ) {

		if ( this.enabled === false ) return;

		return files[ key ];

	}

	/**
	 * 
	 * @param {string} key 
	 */
	remove( key ) {

		delete files[ key ];

	}

	clear() {

		this.files = {};

	}

}





const Cache = new _Cache();


export { Cache };