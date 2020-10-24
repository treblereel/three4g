class Layers {

	constructor() {

		/** @type {number} */
		this.mask = 1 | 0;

	}

	/**
	 * 
	 * @param {number} channel 
	 */
	set( channel ) {

		this.mask = 1 << channel | 0;

	}

	/**
	 * @param {number} channel 
	 */
	enable( channel ) {

		this.mask |= 1 << channel | 0;

	}

	enableAll() {

		this.mask = 0xffffffff | 0;

	}

	/**
	 * @param {number} channel 
	 */
	toggle( channel ) {

		this.mask ^= 1 << channel | 0;

	}

	/**
	 * @param {number} channel 
	 */
	disable( channel ) {

		this.mask &= ~ ( 1 << channel | 0 );

	}

	disableAll() {

		this.mask = 0;

	}

	/**
	 * @param {Layers} layers 
	 * @return {boolean}
	 */
	test( layers ) {

		return ( this.mask & layers.mask ) !== 0;

	}

}


export { Layers };
