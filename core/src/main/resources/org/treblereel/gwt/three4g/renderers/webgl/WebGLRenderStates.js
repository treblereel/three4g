import { WebGLLights } from './WebGLLights.js';

import { WebGLExtensions } from './WebGLExtensions.js';
import { WebGLCapabilities } from './WebGLCapabilities.js';

import { Scene } from '../../scenes/Scene.js';
import { Camera } from '../../cameras/Camera.js';
//import { Light } from '../../lights/Light.js';

class WebGLRenderState {

	/**
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLCapabilities} capabilities 
	 */
	constructor( extensions, capabilities ) {

		/** @type {WebGLLights} */
		this.lights = new WebGLLights( extensions, capabilities );

		/** @type {Array} */
		this.lightsArray = [];
		/** @type {Array} */
		this.shadowsArray = [];

		this.state = {
			lightsArray: this.lightsArray,
			shadowsArray: this.shadowsArray,
	
			lights: this.lights
		};

	}	

	init() {

		this.lightsArray.length = 0;
		this.shadowsArray.length = 0;

	}

	/**
	 * @param {Object} light 
	 */
	pushLight( light ) {

		this.lightsArray.push( light );

	}

	/**
	 * @param {Object} shadowLight 
	 */
	pushShadow( shadowLight ) {

		this.shadowsArray.push( shadowLight );

	}

	setupLights() {

		this.lights.setup( this.lightsArray );

	}

	/**
	 * @param {Camera} camera 
	 */
	setupLightsView( camera ) {

		this.lights.setupView( this.lightsArray, camera );

	}

}

class WebGLRenderStates {

	/**
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLCapabilities} capabilities 
	 */
	constructor( extensions, capabilities ) {

		this.extensions = extensions;
		this.capabilities = capabilities;

		this.renderStates = new WeakMap();
	}	

	/**
	 * 
	 * @param {Scene=} scene 
	 * @param {number=} renderCallDepth 
	 * @return { WebGLRenderState}
	 */
	get( scene = undefined, renderCallDepth = 0 ) {

		let renderState;

		if ( this.renderStates.has( scene ) === false ) {

			renderState = new WebGLRenderState( this.extensions, this.capabilities );
			this.renderStates.set( scene, [ renderState ] );

		} else {

			if ( renderCallDepth >= this.renderStates.get( scene ).length ) {

				renderState = new WebGLRenderState( this.extensions, this.capabilities );
				this.renderStates.get( scene ).push( renderState );

			} else {

				renderState = this.renderStates.get( scene )[ renderCallDepth ];

			}

		}

		return renderState;

	}

	dispose() {

		this.renderStates = new WeakMap();

	}

}


export { WebGLRenderState, WebGLRenderStates };
