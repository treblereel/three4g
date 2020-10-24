/**
 * https://github.com/mrdoob/eventdispatcher.js/
 */
/**
 * @record
 */
var Event = function() {};
/** @type {string} */
Event.prototype.type;
/** @type {*|undefined} */
Event.prototype.target;

class EventDispatcher {

	constructor() {
		/** @type {Object<string, Array<function(Event)>>|undefined} */
		this._listeners = undefined;
	}

	/**
	 * @param {string} type 
	 * @param {function(Event)} listener 
	 */
	addEventListener( type, listener ) {

		if ( this._listeners === undefined ) this._listeners = {};

		const listeners = this._listeners;

		if ( listeners[ type ] === undefined ) {

			listeners[ type ] = [];

		}

		if ( listeners[ type ].indexOf( listener ) === - 1 ) {

			listeners[ type ].push( listener );

		}

	}

	/**
	 * @param {string} type 
	 * @param {function(Event)} listener 
	 * @return {boolean}
	 */
	hasEventListener( type, listener ) {

		if ( this._listeners === undefined ) return false;

		const listeners = this._listeners;
		return listeners[ type ] !== undefined && listeners[ type ].indexOf( listener ) !== - 1;

	}

	/**
	 * @param {string} type 
	 * @param {function(Event)} listener 
	 */
	removeEventListener( type, listener ) {

		if ( this._listeners === undefined ) return;

		const listeners = this._listeners;
		const listenerArray = listeners[ type ];

		if ( listenerArray !== undefined ) {

			const index = listenerArray.indexOf( listener );

			if ( index !== - 1 ) {

				listenerArray.splice( index, 1 );

			}

		}

	}

	/**
	 * 
	 * @param {Event} event 
	 */
	dispatchEvent( event ) {

		if ( this._listeners === undefined ) return;

		const listeners = this._listeners;
		const listenerArray = listeners[ event.type ];

		if ( listenerArray !== undefined ) {

			event.target = this;

			// Make a copy, in case listeners are removed while iterating.
			const array = listenerArray.slice( 0 );

			for ( let i = 0, l = array.length; i < l; i ++ ) {

				array[ i ].call( this, event );

			}

		}

	}

}


export { EventDispatcher, Event };