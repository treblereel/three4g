import {
	RGBAFormat,
	HalfFloatType,
	FloatType,
	UnsignedByteType,
	LinearEncoding,
	NoToneMapping
} from '../constants.js';
import { MathUtils } from '../math/MathUtils.js';
import { DataTexture } from '../textures/DataTexture.js';
import { Frustum } from '../math/Frustum.js';
import { Matrix4 } from '../math/Matrix4.js';
import { Vector2 } from '../math/Vector2.js';
import { Vector3 } from '../math/Vector3.js';
import { Vector4 } from '../math/Vector4.js';
import { Color } from '../math/Color.js';
import { WebGLAnimation } from './webgl/WebGLAnimation.js';
import { WebGLAttributes } from './webgl/WebGLAttributes.js';
import { WebGLBackground } from './webgl/WebGLBackground.js';
import { WebGLBindingStates } from './webgl/WebGLBindingStates.js';
import { WebGLBufferRenderer } from './webgl/WebGLBufferRenderer.js';
import { WebGLCapabilities } from './webgl/WebGLCapabilities.js';
import { WebGLClipping } from './webgl/WebGLClipping.js';
import { WebGLCubeMaps } from './webgl/WebGLCubeMaps.js';
import { WebGLExtensions } from './webgl/WebGLExtensions.js';
import { WebGLGeometries } from './webgl/WebGLGeometries.js';
import { WebGLIndexedBufferRenderer } from './webgl/WebGLIndexedBufferRenderer.js';
import { WebGLInfo } from './webgl/WebGLInfo.js';
import { WebGLMorphtargets } from './webgl/WebGLMorphtargets.js';
import { WebGLObjects } from './webgl/WebGLObjects.js';
import { WebGLPrograms } from './webgl/WebGLPrograms.js';
import { WebGLProperties } from './webgl/WebGLProperties.js';
import { WebGLRenderLists } from './webgl/WebGLRenderLists.js';
import { WebGLRenderStates } from './webgl/WebGLRenderStates.js';
import { WebGLShadowMap } from './webgl/WebGLShadowMap.js';
import { WebGLState } from './webgl/WebGLState.js';
import { WebGLTextures } from './webgl/WebGLTextures.js';
import { WebGLUniforms } from './webgl/WebGLUniforms.js';
import { WebGLUtils } from './webgl/WebGLUtils.js';
import { WebXRManager } from './webxr/WebXRManager.js';
import { WebGLMaterials } from './webgl/WebGLMaterials.js';

// closure compiler
import { WebGLRendererParameters } from './WebGLRendererParameters.js';
import { Material } from '../materials/Material.js';
import { MaterialInterface } from '../closure/material/MaterialInterface.js';
import { Scene } from '../scenes/Scene.js';
import { BufferGeometry } from '../core/BufferGeometry.js';

import { GeometryInterface } from '../closure/geometry/GeometryInterface.js';
import { Box3 } from '../math/Box3.js';

import { UniformInterface } from '../closure/renderers/shaders/UniformInterface.js';

import { Texture } from '../textures/Texture.js';
import { TextureInterface } from '../closure/textures/TextureInterface.js';
import { WebGLRenderTargetInterface } from '../closure/renderers/WebGLRenderTargetInterface.js';
import { Camera } from '../cameras/Camera.js';
import { Object3DInterface } from '../closure/core/Object3DInterface.js';
import { Object3D } from '../core/Object3D.js';
import { Event } from '../core/EventDispatcher.js';
import { Group } from '../objects/Group.js';
import { WebGLRenderState } from './webgl/WebGLRenderStates.js';
import { WebGLRenderList } from './webgl/WebGLRenderLists.js';

/**
 * @return {HTMLCanvasElement}
 */
function createCanvasElement() {

	const canvas = /** @type {HTMLCanvasElement} */ (document.createElementNS( 'http://www.w3.org/1999/xhtml', 'canvas' ));
	canvas.style.display = 'block';
	return canvas;

}

class WebGLRenderer {

	/**
	 * @param {WebGLRendererParameters=} parameters 
	 */
	constructor( parameters ) {


		console.log('pre ' + JSON.stringify(parameters))

		parameters = parameters || {};
		/** @type {WebGLRendererParameters} */
		this.parameters = parameters;

		/** @type {boolean} */
		this.isWebGL1Renderer = false;
		
		/** @type {HTMLCanvasElement|OffscreenCanvas|undefined} */
		let _canvas = parameters.canvas !== undefined ? parameters.canvas : createCanvasElement();

		/** @type {HTMLCanvasElement|OffscreenCanvas|undefined} */
		this._canvas = _canvas;

		/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
		this._context = parameters.context !== undefined ? parameters.context : null;

		/** @type {boolean} */
		let _alpha = parameters.alpha !== undefined ? parameters.alpha : false;
		/** @type {boolean} */
		let _depth = parameters.depth !== undefined ? parameters.depth : true;
		/** @type {boolean} */
		let _stencil = parameters.stencil !== undefined ? parameters.stencil : true;
		/** @type {boolean} */
		let _antialias = parameters.antialias !== undefined ? parameters.antialias : false;

		/** @type {boolean} */
		let _premultipliedAlpha = parameters.premultipliedAlpha !== undefined ? parameters.premultipliedAlpha : true;
		/** @type {boolean} */
		this._premultipliedAlpha = _premultipliedAlpha;

		/** @type {boolean} */
		let _preserveDrawingBuffer = parameters.preserveDrawingBuffer !== undefined ? parameters.preserveDrawingBuffer : false;
		/** @type {string} */
		let _powerPreference = parameters.powerPreference !== undefined ? parameters.powerPreference : 'default';
		/** @type {boolean} */
		let _failIfMajorPerformanceCaveat = parameters.failIfMajorPerformanceCaveat !== undefined ? parameters.failIfMajorPerformanceCaveat : false;
		/** @type {?WebGLRenderList} */
		this.currentRenderList = null;
		/** @type {?WebGLRenderState} */
		this.currentRenderState = null;

		// render() can be called from within a callback triggered by another render.
		// We track this so that the nested render call gets its list and state isolated from the parent render call.
		/** @type {!Array<WebGLRenderList>} */
		this.renderListStack = [];
		/** @type {!Array<WebGLRenderState>} */
		this.renderStateStack = [];

		// public properties
		/** @type {Node} */
		this.domElement = /** @type {Node}*/ (this._canvas);

		// Debug configuration container
		this.debug = {

			/**
			 * Enables error checking and reporting when shader programs are being compiled
			 * @type {boolean}
			 */
			checkShaderErrors: true
		};

		// clearing

		/** @type {boolean} */
		this.autoClear = true;
		/** @type {boolean} */
		this.autoClearColor = true;
		/** @type {boolean} */
		this.autoClearDepth = true;
		/** @type {boolean} */
		this.autoClearStencil = true;

		// scene graph
		/** @type {boolean} */
		this.sortObjects = true;

		// user-defined clipping

		this.clippingPlanes = [];
		/** @type {boolean} */
		this.localClippingEnabled = false;

		// physically based shading
		/** @type {number} */
		this.gammaFactor = 2.0;	// for backwards compatibility
		/** @type {number} */
		this.outputEncoding = LinearEncoding;

		// physical lights
		/** @type {boolean} */
		this.physicallyCorrectLights = false;

		// tone mapping
		/** @type {number} */
		this.toneMapping = NoToneMapping;
		/** @type {number} */
		this.toneMappingExposure = 1.0;

		// morphs
		/** @type {number} */
		this.maxMorphTargets = 8;
		/** @type {number} */
		this.maxMorphNormals = 4;

		// internal properties
		/** @type {boolean} */
		this._isContextLost = false;

		// internal state cache

		this._framebuffer = null;
		/** @type {number} */
		this._currentActiveCubeFace = 0;
		/** @type {number} */
		this._currentActiveMipmapLevel = 0;
		/** @type {WebGLRenderTargetInterface|null} */
		this._currentRenderTarget = null;
		this._currentFramebuffer = null;
		/** @type {number} */
		this._currentMaterialId = - 1;
		/** @type {Camera} */
		this._currentCamera = null;

		/** @type {Vector4} */
		this._currentViewport = new Vector4();
		/** @type {Vector4} */
		this._currentScissor = new Vector4();
		this._currentScissorTest = null;

		//
		/** @type {number} */
		this._width = this._canvas.width;
		/** @type {number} */
		this._height = this._canvas.height;

		/** @type {number} */
		this._pixelRatio = 1;
		this._opaqueSort = null;
		this._transparentSort = null;

		/** @type {Vector4} */
		this._viewport = new Vector4( 0, 0, this._width, this._height );
		/** @type {Vector4} */
		this._scissor = new Vector4( 0, 0, this._width, this._height );
		/** @type {boolean} */
		this._scissorTest = false;

		// frustum
		/** @type {Frustum} */
		this._frustum = new Frustum();

		// clipping
		/** @type {boolean} */
		this._clippingEnabled = false;
		/** @type {boolean} */
		this._localClippingEnabled = false;

		// camera matrices cache

		/** @type {Matrix4} */
		this._projScreenMatrix = new Matrix4();
		/** @type {Vector3} */
		this._vector3 = new Vector3();

		this._emptyScene = { background: null, fog: null, environment: null, overrideMaterial: null, isScene: true };

		// initialize

		/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
		let _gl = this._context;
		/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
		this._gl = _gl;

		/**
		 * 
		 * @param {Array<string>} contextNames 
		 * @param {WebGLContextAttributes=} contextAttributes 
		 * @return {WebGLRenderingContext|WebGL2RenderingContext|null}
		 */
		function getContext( contextNames, contextAttributes ) {

			for ( let i = 0; i < contextNames.length; i ++ ) {

				/** @type {string} */
				const contextName = contextNames[ i ];
				/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
				const context = _canvas.getContext( contextName, contextAttributes );
				if ( context !== null ) return context;

			}

			return null;

		}

		try {

			/** @type {WebGLContextAttributes} */
			const contextAttributes = {
				alpha: _alpha,
				depth: _depth,
				stencil: _stencil,
				antialias: _antialias,
				premultipliedAlpha: _premultipliedAlpha,
				preserveDrawingBuffer: _preserveDrawingBuffer,
				powerPreference: _powerPreference,
				failIfMajorPerformanceCaveat: _failIfMajorPerformanceCaveat
			};

			// event listeners must be registered before WebGL context is created, see #12753

			console.log('contextAttributes ' + JSON.stringify(contextAttributes))

			this._canvas.addEventListener( 'webglcontextlost', this.onContextLost, false );
			this._canvas.addEventListener( 'webglcontextrestored', this.onContextRestore, false );

			if ( this._gl === null ) {

				const contextNames = [ 'webgl2', 'webgl', 'experimental-webgl' ];

				if ( this.isWebGL1Renderer === true ) {

					contextNames.shift();

				}

				this._gl = getContext( contextNames, contextAttributes );

				if ( this._gl === null ) {

					if ( getContext( contextNames ) ) {

						throw new Error( 'Error creating WebGL context with your selected attributes.' );

					} else {

						throw new Error( 'Error creating WebGL context.' );

					}

				}

			}

			// Some experimental-webgl implementations do not have getShaderPrecisionFormat

			if ( this._gl.getShaderPrecisionFormat === undefined ) {

				this._gl.getShaderPrecisionFormat = function () {

					return { 'rangeMin': 1, 'rangeMax': 1, 'precision': 1 };

				};

			}

		} catch ( error ) {

			console.error( 'THREE.WebGLRenderer: ' + error.message );
			throw error;

		}

		/** @type {WebGLCapabilities} */
		this.capabilities;
		/** @type {WebGLExtensions} */
		this.extensions;
		/** @type {WebGLProperties} */
		this.properties;
		/** @type {WebGLRenderLists} */
		this.renderLists;
		/** @type {WebGLRenderStates} */
		this.renderStates;
		/** @type {WebGLClipping} */
		this.clipping;
		/** @type {WebGLObjects} */
		this.objects;
		/** @type {WebGLBackground} */
		this.background;
		/** @type {WebGLTextures} */
		this.textures;
		/** @type {WebGLState} */
		this.state;
		/** @type {WebGLInfo} */
		this.info;
		/** @type {WebGLShadowMap} */
		this.shadowMap;
		/** @type {WebGLUtils} */
		this.utils;
		/** @type {WebGLCubeMaps} */
		this.cubemaps;
		/** @type {WebGLPrograms} */
		this.programCache;
		/** @type {WebGLMaterials} */
		this.materials;
		/** @type {WebGLAttributes} */
		this.attributes;
		/** @type {WebGLIndexedBufferRenderer} */
		this.indexedBufferRenderer;
		/** @type {WebGLBufferRenderer} */
		this.bufferRenderer;
		/** @type {WebGLBindingStates} */
		this.bindingStates;
		
		/** @type {WebGLMorphtargets} */
		this.morphtargets;
		/** @type {WebGLGeometries} */
		this.geometries;

		this.initGLContext();

		// xr
		/** @type {WebXRManager} */
		const xr = new WebXRManager( this, this._gl );
		/** @type {WebXRManager} */
		this.xr = xr;

		this.onAnimationFrameCallback = null;

		/** @type {WebGLAnimation} */
		this.animation = new WebGLAnimation();
		this.animation.setAnimationLoop( this.onAnimationFrame );
	
		if ( typeof window !== 'undefined' ) this.animation.setContext( window );


		if ( typeof __THREE_DEVTOOLS__ !== 'undefined' ) {

			__THREE_DEVTOOLS__.dispatchEvent( new CustomEvent( 'observe', { detail: this } ) ); // eslint-disable-line no-undef
		
		}


	}

	/**
	 * @private
	 */
	initGLContext() {

		let extensions, capabilities, state, info;
		let properties, textures, cubemaps, attributes, geometries, objects;
		let programCache, materials, renderLists, renderStates, clipping, shadowMap;
	
		let background, morphtargets, bufferRenderer, indexedBufferRenderer;
	
		let utils, bindingStates;

		extensions = new WebGLExtensions( this._gl );

		capabilities = new WebGLCapabilities( this._gl, extensions, this.parameters );

		extensions.init( capabilities );

		utils = new WebGLUtils( this._gl, extensions, capabilities );

		state = new WebGLState( this._gl, extensions, capabilities );
		state.scissor( this._currentScissor.copy( this._scissor ).multiplyScalar( this._pixelRatio ).floor() );
		state.viewport( this._currentViewport.copy( this._viewport ).multiplyScalar( this._pixelRatio ).floor() );

		info = new WebGLInfo( this._gl );
		properties = new WebGLProperties();
		textures = new WebGLTextures( this._gl, extensions, state, properties, capabilities, utils, info );
		cubemaps = new WebGLCubeMaps( this );
		attributes = new WebGLAttributes( this._gl, capabilities );
		bindingStates = new WebGLBindingStates( this._gl, extensions, attributes, capabilities );
		geometries = new WebGLGeometries( this._gl, attributes, info, bindingStates );
		objects = new WebGLObjects( this._gl, geometries, attributes, info );
		morphtargets = new WebGLMorphtargets( this._gl );
		clipping = new WebGLClipping( properties );
		programCache = new WebGLPrograms( this, cubemaps, extensions, capabilities, bindingStates, clipping );
		materials = new WebGLMaterials( properties );
		renderLists = new WebGLRenderLists( properties );
		renderStates = new WebGLRenderStates( extensions, capabilities );
		background = new WebGLBackground( this, cubemaps, state, objects, this._premultipliedAlpha );
		shadowMap = new WebGLShadowMap( this, objects, capabilities.maxTextureSize );
		bufferRenderer = new WebGLBufferRenderer( this._gl, extensions, info, capabilities );
		indexedBufferRenderer = new WebGLIndexedBufferRenderer( this._gl, extensions, info, capabilities );

		info.programs = programCache.programs;

		this.capabilities = capabilities;
		this.extensions = extensions;
		this.properties = properties;
		this.renderLists = renderLists;
		this.renderStates = renderStates;
		this.shadowMap = shadowMap;
		this.state = state;
		this.info = info;
		this.utils = utils;
		this.bindingStates = bindingStates;
		this.clipping = clipping;
		this.objects = objects;
		this.background = background;
		this.textures = textures;
		this.cubemaps = cubemaps;
		this.programCache = programCache;
		this.materials = materials;
		this.attributes = attributes;
		this.indexedBufferRenderer = indexedBufferRenderer;
		this.bufferRenderer = bufferRenderer;

		this.morphtargets = morphtargets;
		this.geometries = geometries;

	}

	// API

	/**
	 * @return {number}
	 */
	getTargetPixelRatio() {

		return this._currentRenderTarget === null ? this._pixelRatio : 1;

	}

	/**
	 * @return {WebGLRenderingContext|WebGL2RenderingContext} 
	 */
	getContext() {

		return this._gl;

	}

	/**
	 * @return {WebGLContextAttributes}
	 */
	getContextAttributes() {

		return this._gl.getContextAttributes();

	}

	forceContextLoss() {

		const extension = this.extensions.get( 'WEBGL_lose_context' );
		if ( extension ) extension.loseContext();

	}

	forceContextRestore() {

		const extension = this.extensions.get( 'WEBGL_lose_context' );
		if ( extension ) extension.restoreContext();

	}

	/**
	 *  @return {number}
	 */
	getPixelRatio() {

		return this._pixelRatio;

	}

	/**
	 * @param {number} value 
	 */
	setPixelRatio( value ) {

		if ( value === undefined ) return;

		this._pixelRatio = value;

		this.setSize( this._width, this._height, false );

	}

	/**
	 * 
	 * @param { Vector2} target
	 * @return {Vector2} 
	 */
	getSize( target ) {

		if ( target === undefined ) {

			console.warn( 'WebGLRenderer: .getsize() now requires a Vector2 as an argument' );

			target = new Vector2();

		}

		return target.set( this._width, this._height );

	}

	/**
	 * 
	 * @param {number} width 
	 * @param {number} height 
	 * @param {boolean=} updateStyle 
	 */
	setSize( width, height, updateStyle ) {

		if ( this.xr.isPresenting ) {

			console.warn( 'THREE.WebGLRenderer: Can\'t change size while VR device is presenting.' );
			return;

		}

		this._width = width;
		this._height = height;

		this._canvas.width = Math.floor( width * this._pixelRatio );
		this._canvas.height = Math.floor( height * this._pixelRatio );

		if ( updateStyle !== false ) {

			this._canvas.style.width = width + 'px';
			this._canvas.style.height = height + 'px';

		}

		this.setViewport( 0, 0, width, height );

	}

	/**
	 * 
	 * @param { Vector2} target
	 * @return {Vector2} 
	 */
	getDrawingBufferSize( target ) {

		if ( target === undefined ) {

			console.warn( 'WebGLRenderer: .getdrawingBufferSize() now requires a Vector2 as an argument' );

			target = new Vector2();

		}

		return target.set( this._width * this._pixelRatio,this._height * this._pixelRatio ).floor();

	}

	/**
	 * 
	 * @param {number} width 
	 * @param {number} height 
	 * @param {number} pixelRatio 
	 */
	setDrawingBufferSize( width, height, pixelRatio ) {

		this._width = width;
		this._height = height;

		this._pixelRatio = pixelRatio;

		this._canvas.width = Math.floor( width * pixelRatio );
		this._canvas.height = Math.floor( height * pixelRatio );

		this.setViewport( 0, 0, width, height );

	}

	/**
	 * 
	 * @param {Vector4} target 
	 * @return {Vector4}
	 */
	getCurrentViewport( target ) {

		if ( target === undefined ) {

			console.warn( 'WebGLRenderer: .getCurrentViewport() now requires a Vector4 as an argument' );

			target = new Vector4();

		}

		return target.copy( this._currentViewport );

	}

	/**
	 * @param {Vector4} target
	 * @return {Vector4}
	 */
	getViewport( target ) {

		return target.copy( this._viewport );

	}

	/**
	 * 
	 * @param {Vector4|number} x 
	 * @param {number=} y 
	 * @param {number=} width 
	 * @param {number=} height 
	 */
	setViewport( x, y, width, height ) {

		if ( x.isVector4 ) {

			this._viewport.set( x.x, x.y, x.z, x.w );

		} else {

			this._viewport.set( /** @type {number} */ (x), y, width, height );

		}

		this.state.viewport( this._currentViewport.copy( this._viewport ).multiplyScalar( this._pixelRatio ).floor() );

	}

	/**
	 * @param {Vector4} target
	 * @return {Vector4}
	 */
	getScissor( target ) {

		return target.copy( this._scissor );

	}

	/**
	 * 
	 * @param {Vector4|number} x 
	 * @param {number=} y 
	 * @param {number=} width 
	 * @param {number=} height 
	 */
	setScissor( x, y, width, height ) {

		if ( x.isVector4 ) {

			this._scissor.set( x.x, x.y, x.z, x.w );

		} else {

			this._scissor.set( x, y, width, height );

		}

		this.state.scissor( this._currentScissor.copy(this._scissor ).multiplyScalar( this._pixelRatio ).floor() );

	}

	/**
	 * @return {boolean}
	 */
	getScissorTest() {

		return this._scissorTest;

	}

	/**
	 * 
	 * @param {boolean} boolean 
	 */
	setScissorTest( boolean ) {

		this.state.setScissorTest( this._scissorTest = boolean );

	}

	/**
	 * 
	 * @param {function()} method 
	 */
	setOpaqueSort( method ) {

		this._opaqueSort = method;

	}

	/**
	 * 
	 * @param {function()} method 
	 */
	setTransparentSort( method ) {

		this._transparentSort = method;

	}

	// Clearing

	/**
	 * 
	 * @param {Color} target 
	 * @return {Color} 
	 */
	getClearColor( target ) {

		if ( target === undefined ) {

			console.warn( 'WebGLRenderer: .getClearColor() now requires a Color as an argument' );

			target = new Color();

		}

		return target.copy( this.background.getClearColor() );

	}

	setClearColor() {

		this.background.setClearColor.apply( this.background, arguments );

	}

	/**
	 * @return {number}
	 */
	getClearAlpha() {

		return this.background.getClearAlpha();

	}

	setClearAlpha() {

		this.background.setClearAlpha.apply( this.background, arguments );

	}

	/**
	 * 
	 * @param {boolean=} color 
	 * @param {boolean=} depth 
	 * @param {boolean=} stencil 
	 */
	clear( color, depth, stencil ) {

		let bits = 0;

		if ( color === undefined || color ) bits |= this._gl.COLOR_BUFFER_BIT;
		if ( depth === undefined || depth ) bits |= this._gl.DEPTH_BUFFER_BIT;
		if ( stencil === undefined || stencil ) bits |= this._gl.STENCIL_BUFFER_BIT;

		this._gl.clear( bits );

	}

	clearColor() {

		this.clear( true, false, false );

	}

	clearDepth() {

		this.clear( false, true, false );

	}

	clearStencil() {

		this.clear( false, false, true );

	}

	//

	dispose() {

		this._canvas.removeEventListener( 'webglcontextlost', this.onContextLost, false );
		this._canvas.removeEventListener( 'webglcontextrestored', this.onContextRestore, false );

		this.renderLists.dispose();
		this.renderStates.dispose();
		this.properties.dispose();
		this.cubemaps.dispose();
		this.objects.dispose();
		this.bindingStates.dispose();

		this.xr.dispose();

		this.animation.stop();

	}

	// Events
	/** @param  { {preventDefault : function() }} event */
	onContextLost( event ) {

		event.preventDefault();

		this._isContextLost = true;

	}

	onContextRestore( /* event */ ) {

		this._isContextLost = false;

		this.initGLContext();

	}

	/** @param  {Event} event */
	onMaterialDispose( event ) {

		/** @type {MaterialInterface} */
		const material = /** @type {MaterialInterface} */ (event.target);

		material.removeEventListener( 'dispose', this.onMaterialDispose );

		this.deallocateMaterial( material );

	}

	// Buffer deallocation

	/** @param {MaterialInterface} material */
	deallocateMaterial( material ) {

		this.releaseMaterialProgramReference( material );

		this.properties.remove( material );

	}

	/** @param {MaterialInterface} material */
	releaseMaterialProgramReference( material ) {

		const programInfo = this.properties.get( material ).program;

		if ( programInfo !== undefined ) {

			this.programCache.releaseProgram( programInfo );

		}

	}

	// Buffer rendering

	renderObjectImmediate( object, program ) {

		let _this = this;

		object.render( function ( object ) {

			_this.renderBufferImmediate( object, program );

		} );

	}

	renderBufferImmediate( object, program ) {

		this.bindingStates.initAttributes();

		const buffers = this.properties.get( object );

		if ( object.hasPositions && ! buffers.position ) buffers.position = this._gl.createBuffer();
		if ( object.hasNormals && ! buffers.normal ) buffers.normal = this._gl.createBuffer();
		if ( object.hasUvs && ! buffers.uv ) buffers.uv = this._gl.createBuffer();
		if ( object.hasColors && ! buffers.color ) buffers.color = this._gl.createBuffer();

		const programAttributes = program.getAttributes();

		if ( object.hasPositions ) {

			this._gl.bindBuffer( this._gl.ARRAY_BUFFER, buffers.position );
			this._gl.bufferData( this._gl.ARRAY_BUFFER, object.positionArray, this._gl.DYNAMIC_DRAW );

			this.bindingStates.enableAttribute( programAttributes.position );
			this._gl.vertexAttribPointer( programAttributes.position, 3, this._gl.FLOAT, false, 0, 0 );

		}

		if ( object.hasNormals ) {

			this._gl.bindBuffer( this._gl.ARRAY_BUFFER, buffers.normal );
			this._gl.bufferData( this._gl.ARRAY_BUFFER, object.normalArray, this._gl.DYNAMIC_DRAW );

			this.bindingStates.enableAttribute( programAttributes.normal );
			this._gl.vertexAttribPointer( programAttributes.normal, 3, this._gl.FLOAT, false, 0, 0 );

		}

		if ( object.hasUvs ) {

			this._gl.bindBuffer( this._gl.ARRAY_BUFFER, buffers.uv );
			this._gl.bufferData( this._gl.ARRAY_BUFFER, object.uvArray, this._gl.DYNAMIC_DRAW );

			this.bindingStates.enableAttribute( programAttributes.uv );
			this._gl.vertexAttribPointer( programAttributes.uv, 2, this._gl.FLOAT, false, 0, 0 );

		}

		if ( object.hasColors ) {

			this._gl.bindBuffer( this._gl.ARRAY_BUFFER, buffers.color );
			this._gl.bufferData( this._gl.ARRAY_BUFFER, object.colorArray, this._gl.DYNAMIC_DRAW );

			this.bindingStates.enableAttribute( programAttributes.color );
			this._gl.vertexAttribPointer( programAttributes.color, 3, this._gl.FLOAT, false, 0, 0 );

		}

		this.bindingStates.disableUnusedAttributes();

		this._gl.drawArrays( this._gl.TRIANGLES, 0, object.count );

		object.count = 0;

	}

	/**
	 * 
	 * @param {Camera} camera 
	 * @param {Object3DInterface} scene 
	 * @param {GeometryInterface} geometry 
	 * @param {MaterialInterface} material 
	 * @param {Object3DInterface} object 
	 * @param {Group} group 
	 */
	renderBufferDirect( camera, scene, geometry, material, object, group ) {

		if ( scene === null ) scene = this._emptyScene; // renderBufferDirect second parameter used to be fog (could be null)

		const frontFaceCW = ( object.isMesh && object.matrixWorld.determinant() < 0 );

		const program = this.setProgram( camera, scene, material, object );

		this.state.setMaterial( material, frontFaceCW );

		//

		let index = geometry.index;
		const position = geometry.attributes.position;

		//

		if ( index === null ) {

			if ( position === undefined || position.count === 0 ) return;

		} else if ( index.count === 0 ) {

			return;

		}

		//

		let rangeFactor = 1;

		if ( material.wireframe === true ) {

			index = this.geometries.getWireframeAttribute( geometry );
			rangeFactor = 2;

		}

		if ( material.morphTargets || material.morphNormals ) {

			this.morphtargets.update( object, geometry, material, program );

		}

		this.bindingStates.setup( object, material, program, geometry, index );

		let attribute;
		let renderer = this.bufferRenderer;

		if ( index !== null ) {

			attribute = this.attributes.get( index );

			renderer = this.indexedBufferRenderer;
			renderer.setIndex( attribute );

		}

		//

		const dataCount = ( index !== null ) ? index.count : position.count;

		const rangeStart = geometry.drawRange.start * rangeFactor;
		const rangeCount = geometry.drawRange.count * rangeFactor;

		const groupStart = group !== null ? group.start * rangeFactor : 0;
		const groupCount = group !== null ? group.count * rangeFactor : Infinity;

		const drawStart = Math.max( rangeStart, groupStart );
		const drawEnd = Math.min( dataCount, rangeStart + rangeCount, groupStart + groupCount ) - 1;

		const drawCount = Math.max( 0, drawEnd - drawStart + 1 );

		if ( drawCount === 0 ) return;

		//

		if ( object.isMesh ) {

			if ( material.wireframe === true ) {

				this.state.setLineWidth( material.wireframeLinewidth * this.getTargetPixelRatio() );
				renderer.setMode( this._gl.LINES );

			} else {

				renderer.setMode( this._gl.TRIANGLES );

			}

		} else if ( object.isLine ) {

			let lineWidth = material.linewidth;

			if ( lineWidth === undefined ) lineWidth = 1; // Not using Line*Material

			this.state.setLineWidth( lineWidth * this.getTargetPixelRatio() );

			if ( object.isLineSegments ) {

				renderer.setMode( this._gl.LINES );

			} else if ( object.isLineLoop ) {

				renderer.setMode( this._gl.LINE_LOOP );

			} else {

				renderer.setMode( this._gl.LINE_STRIP );

			}

		} else if ( object.isPoints ) {

			renderer.setMode( this._gl.POINTS );

		} else if ( object.isSprite ) {

			renderer.setMode( this._gl.TRIANGLES );

		}

		if ( object.isInstancedMesh ) {

			renderer.renderInstances( drawStart, drawCount, object.count );

		} else if ( geometry.isInstancedBufferGeometry ) {

			const instanceCount = Math.min( geometry.instanceCount, geometry._maxInstanceCount );

			renderer.renderInstances( drawStart, drawCount, instanceCount );

		} else {

			renderer.render( drawStart, drawCount );

		}

	}

	// Compile
	/**
	 * @param {Object3DInterface} scene 
	 * @param {Camera} camera 
	 * @suppress {checkTypes}
	 */
	compile( scene, camera ) {

		this.currentRenderState = this.renderStates.get( scene );
		this.currentRenderState.init();

		scene.traverseVisible( function ( object ) {

			if ( object.isLight && object.layers.test( camera.layers ) ) {

				this.currentRenderState.pushLight( object );

				if ( object.castShadow ) {

					this.urrentRenderState.pushShadow( object );

				}

			}

		} );

		this.currentRenderState.setupLights();

		const compiled = new WeakMap();

		scene.traverse( function ( object ) {

			const material = object.material;

			if ( material ) {

				if ( Array.isArray( material ) ) {

					for ( let i = 0; i < material.length; i ++ ) {

						const material2 = material[ i ];

						if ( compiled.has( material2 ) === false ) {

							this.initMaterial( material2, scene, object );
							//Function set requires at least 2 argument(s)
							compiled.set( material2 );

						}

					}

				} else if ( compiled.has( material ) === false ) {

					this.initMaterial( material, scene, object );
					//Function set requires at least 2 argument(s)
					compiled.set( material );

				}

			}

		} );

	}

	// Animation Loop
	/**
	 * 
	 * @param {number} time 
	 */
	onAnimationFrame( time ) {

		if ( this.xr.isPresenting ) return;
		if ( this.onAnimationFrameCallback ) this.onAnimationFrameCallback( time );

	}

	setAnimationLoop( callback ) {

		this.onAnimationFrameCallback = callback;
		this.xr.setAnimationLoop( callback );

		( callback === null ) ? this.animation.stop() : this.animation.start();

	};

	// Rendering
	/**
	 * 
	 * @param {Object3DInterface} scene 
	 * @param {Camera} camera 
	 */
	render( scene, camera ) {

		let renderTarget, forceClear;

		if ( arguments[ 2 ] !== undefined ) {

			console.warn( 'THREE.WebGLRenderer.render(): the renderTarget argument has been removed. Use .setRenderTarget() instead.' );
			renderTarget = arguments[ 2 ];

		}

		if ( arguments[ 3 ] !== undefined ) {

			console.warn( 'THREE.WebGLRenderer.render(): the forceClear argument has been removed. Use .clear() instead.' );
			forceClear = arguments[ 3 ];

		}

		if ( camera !== undefined && camera.isCamera !== true ) {

			console.error( 'THREE.WebGLRenderer.render: camera is not an instance of THREE.Camera.' );
			return;

		}

		if ( this._isContextLost === true ) return;

		// reset caching for this frame

		this.bindingStates.resetDefaultState();
		this._currentMaterialId = - 1;
		this._currentCamera = null;

		// update scene graph

		if ( scene.autoUpdate === true ) scene.updateMatrixWorld();

		// update camera matrices and frustum

		if ( camera.parent === null ) camera.updateMatrixWorld();

		if ( this.xr.enabled === true && this.xr.isPresenting === true ) {

			camera = this.xr.getCamera( camera );

		}

		//
		if ( scene.isScene === true ) scene.onBeforeRender( this, scene, camera, renderTarget || this._currentRenderTarget );

		this.currentRenderState = this.renderStates.get( scene, this.renderStateStack.length );
		this.currentRenderState.init();

		this.renderStateStack.push( this.currentRenderState );

		this._projScreenMatrix.multiplyMatrices( camera.projectionMatrix, camera.matrixWorldInverse );
		this._frustum.setFromProjectionMatrix( this._projScreenMatrix );

		this._localClippingEnabled = this.localClippingEnabled;
		this._clippingEnabled = this.clipping.init( this.clippingPlanes, this._localClippingEnabled, camera );

		this.currentRenderList = this.renderLists.get( scene, this.renderListStack.length );
		this.currentRenderList.init();

		this.renderListStack.push( this.currentRenderList );

		this.projectObject( scene, camera, 0, this.sortObjects );

		this.currentRenderList.finish();

		if ( this.sortObjects === true ) {

			this.currentRenderList.sort( this._opaqueSort, this._transparentSort );

		}

		//

		if ( this._clippingEnabled === true ) this.clipping.beginShadows();

		const shadowsArray = this.currentRenderState.state.shadowsArray;

		this.shadowMap.render( shadowsArray, scene, camera );

		this.currentRenderState.setupLights();
		this.currentRenderState.setupLightsView( camera );

		if ( this._clippingEnabled === true ) this.clipping.endShadows();

		//

		if ( this.info.autoReset === true ) this.info.reset();

		if ( renderTarget !== undefined ) {

			this.setRenderTarget( renderTarget );

		}

		//

		this.background.render( this.currentRenderList, scene, camera, forceClear );

		// render scene

		const opaqueObjects = this.currentRenderList.opaque;
		const transparentObjects = this.currentRenderList.transparent;

		if ( opaqueObjects.length > 0 ) this.renderObjects( opaqueObjects, scene, camera );
		if ( transparentObjects.length > 0 ) this.renderObjects( transparentObjects, scene, camera );

		//

		if ( scene.isScene === true ) scene.onAfterRender( this, scene, camera );

		//

		if ( this._currentRenderTarget !== null ) {

			// Generate mipmap if we're using any kind of mipmap filtering

			this.textures.updateRenderTargetMipmap( this._currentRenderTarget );

			// resolve multisample renderbuffers to a single-sample texture if necessary

			this.textures.updateMultisampleRenderTarget( this._currentRenderTarget );

		}

		// Ensure depth buffer writing is enabled so it can be cleared on next render

		this.state.buffers.depth.setTest( true );
		this.state.buffers.depth.setMask( true );
		this.state.buffers.color.setMask( true );

		this.state.setPolygonOffset( false );

		// this._gl.finish();

		this.renderStateStack.pop();

		if ( this.renderStateStack.length > 0 ) {

			this.currentRenderState = this.renderStateStack[ this.renderStateStack.length - 1 ];

		} else {

			this.currentRenderState = null;

		}

		this.renderListStack.pop();

		if ( this.renderListStack.length > 0 ) {

			this.currentRenderList = this.renderListStack[ this.renderListStack.length - 1 ];

		} else {

			this.currentRenderList = null;

		}

	};

	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {Camera} camera 
	 * @param {number} groupOrder 
	 * @param {boolean} sortObjects 
	 */
	projectObject( object, camera, groupOrder, sortObjects ) {

		if ( object.visible === false ) return;

		const visible = object.layers.test( camera.layers );

		if ( visible ) {

			if ( object.isGroup ) {

				groupOrder = object.renderOrder;

			} else if ( object.isLOD ) {

				if ( object.autoUpdate === true ) object.update( camera );

			} else if ( object.isLight ) {

				this.currentRenderState.pushLight( object );

				if ( object.castShadow ) {

					this.currentRenderState.pushShadow( object );

				}

			} else if ( object.isSprite ) {

				if ( ! object.frustumCulled || this._frustum.intersectsSprite( object ) ) {

					if ( sortObjects ) {

						this._vector3.setFromMatrixPosition( object.matrixWorld )
							.applyMatrix4( this._projScreenMatrix );

					}

					const geometry = this.objects.update( object );
					const material = object.material;

					if ( material.visible ) {

						this.currentRenderList.push( object, geometry, material, groupOrder, this._vector3.z, null );

					}

				}

			} else if ( object.isImmediateRenderObject ) {

				if ( sortObjects ) {

					this._vector3.setFromMatrixPosition( object.matrixWorld )
						.applyMatrix4( this._projScreenMatrix );

				}

				this.currentRenderList.push( object, null, object.material, groupOrder, this._vector3.z, null );

			} else if ( object.isMesh || object.isLine || object.isPoints ) {

				if ( object.isSkinnedMesh ) {

					// update skeleton only once in a frame

					if ( object.skeleton.frame !== this.info.render.frame ) {

						object.skeleton.update();
						object.skeleton.frame = this.info.render.frame;

					}

				}

				if ( ! object.frustumCulled || this._frustum.intersectsObject( object ) ) {

					if ( sortObjects ) {

						this._vector3.setFromMatrixPosition( object.matrixWorld )
							.applyMatrix4( this._projScreenMatrix );

					}

					const geometry = this.objects.update( object );
					const material = object.material;

					if ( Array.isArray( material ) ) {

						const groups = geometry.groups;

						for ( let i = 0, l = groups.length; i < l; i ++ ) {

							const group = groups[ i ];
							const groupMaterial = material[ group.materialIndex ];

							if ( groupMaterial && groupMaterial.visible ) {

								this.currentRenderList.push( object, geometry, groupMaterial, groupOrder, this._vector3.z, group );

							}

						}

					} else if ( material.visible ) {

						this.currentRenderList.push( object, geometry, material, groupOrder, this._vector3.z, null );

					}

				}

			}

		}

		const children = object.children;

		for ( let i = 0, l = children.length; i < l; i ++ ) {

			this.projectObject( children[ i ], camera, groupOrder, sortObjects );

		}

	}

	/**
	 * 
	 * @param {*} renderList 
	 * @param {Object3DInterface} scene 
	 * @param {Camera} camera 
	 */
	renderObjects( renderList, scene, camera ) {

		const overrideMaterial = scene.isScene === true ? scene.overrideMaterial : null;

		for ( let i = 0, l = renderList.length; i < l; i ++ ) {

			const renderItem = renderList[ i ];

			const object = renderItem.object;
			const geometry = renderItem.geometry;
			const material = overrideMaterial === null ? renderItem.material : overrideMaterial;
			const group = renderItem.group;

			if ( camera.isArrayCamera ) {

				const cameras = camera.cameras;

				for ( let j = 0, jl = cameras.length; j < jl; j ++ ) {

					const camera2 = cameras[ j ];

					if ( object.layers.test( camera2.layers ) ) {

						this.state.viewport( this._currentViewport.copy( camera2.viewport ) );

						this.currentRenderState.setupLightsView( camera2 );

						this.renderObject( object, scene, camera2, geometry, material, group );

					}

				}

			} else {

				this.renderObject( object, scene, camera, geometry, material, group );

			}

		}

	}


	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {Scene} scene 
	 * @param {Camera} camera 
	 * @param {BufferGeometry} geometry 
	 * @param {MaterialInterface} material 
	 * @param {Group} group 
	 */
	renderObject( object, scene, camera, geometry, material, group ) {

		object.onBeforeRender( this, scene, camera, geometry, material, group );
		object.modelViewMatrix.multiplyMatrices( camera.matrixWorldInverse, object.matrixWorld );
		object.normalMatrix.getNormalMatrix( object.modelViewMatrix );
		if ( object.isImmediateRenderObject ) {

			const program = this.setProgram( camera, scene, material, object );

			this.state.setMaterial( material );

			this.bindingStates.reset();

			this.renderObjectImmediate( object, program );

		} else {
			this.renderBufferDirect( camera, scene, geometry, material, object, group );
		}

		object.onAfterRender( this, scene, camera, geometry, material, group );

	}

	/**
	 * 
	 * @param {MaterialInterface} material 
	 * @param {Scene|{ background: *, environment: *, fog: *, isScene: boolean, overrideMaterial: * } } scene 
	 * @param {Object3DInterface} object 
	 */
	initMaterial( material, scene, object ) {

		if ( scene.isScene !== true ) scene = this._emptyScene; // scene could be a Mesh, Line, Points, ...

		const materialProperties = this.properties.get( material );
		const lights = this.currentRenderState.state.lights;
		const shadowsArray = this.currentRenderState.state.shadowsArray;

		const lightsStateVersion = lights.state.version;

		const parameters = this.programCache.getParameters( material, lights.state, shadowsArray, scene, object );
		const programCacheKey = this.programCache.getProgramCacheKey( parameters );

		let program = materialProperties.program;
		let programChange = true;

		// always update environment and fog - changing these trigger an initMaterial call, but it's possible that the program doesn't change

		materialProperties.environment = material.isMeshStandardMaterial ? scene.environment : null;
		materialProperties.fog = scene.fog;
		materialProperties.envMap = this.cubemaps.get( material.envMap || materialProperties.environment );

		if ( program === undefined ) {

			// new material
			material.addEventListener( 'dispose', this.onMaterialDispose );

		} else if ( program.cacheKey !== programCacheKey ) {

			// changed glsl or parameters
			this.releaseMaterialProgramReference( material );

		} else if ( materialProperties.lightsStateVersion !== lightsStateVersion ) {

			programChange = false;

		} else if ( parameters.shaderID !== undefined ) {

			// same glsl and uniform list
			return;

		} else {

			// only rebuild uniform list
			programChange = false;

		}

		if ( programChange ) {

			parameters.uniforms = this.programCache.getUniforms( material );

			material.onBeforeCompile( parameters, this );

			program = this.programCache.acquireProgram( parameters, programCacheKey );

			materialProperties.program = program;
			materialProperties.uniforms = parameters.uniforms;
			materialProperties.outputEncoding = parameters.outputEncoding;

		}

		/** @type {UniformInterface} */
		const uniforms = materialProperties.uniforms;

		if ( ! material.isShaderMaterial &&
			! material.isRawShaderMaterial ||
			material.clipping === true ) {

			materialProperties.numClippingPlanes = this.clipping.numPlanes;
			materialProperties.numIntersection = this.clipping.numIntersection;
			uniforms.clippingPlanes = this.clipping.uniform;

		}

		// store the light setup it was created for

		materialProperties.needsLights = this.materialNeedsLights( material );
		materialProperties.lightsStateVersion = lightsStateVersion;

		if ( materialProperties.needsLights ) {

			// wire up the material to this renderer's lighting state

			uniforms.ambientLightColor.value = lights.state.ambient;
			uniforms.lightProbe.value = lights.state.probe;
			uniforms.directionalLights.value = lights.state.directional;
			uniforms.directionalLightShadows.value = lights.state.directionalShadow;
			uniforms.spotLights.value = lights.state.spot;
			uniforms.spotLightShadows.value = lights.state.spotShadow;
			uniforms.rectAreaLights.value = lights.state.rectArea;
			uniforms.ltc_1.value = lights.state.rectAreaLTC1;
			uniforms.ltc_2.value = lights.state.rectAreaLTC2;
			uniforms.pointLights.value = lights.state.point;
			uniforms.pointLightShadows.value = lights.state.pointShadow;
			uniforms.hemisphereLights.value = lights.state.hemi;

			uniforms.directionalShadowMap.value = lights.state.directionalShadowMap;
			uniforms.directionalShadowMatrix.value = lights.state.directionalShadowMatrix;
			uniforms.spotShadowMap.value = lights.state.spotShadowMap;
			uniforms.spotShadowMatrix.value = lights.state.spotShadowMatrix;
			uniforms.pointShadowMap.value = lights.state.pointShadowMap;
			uniforms.pointShadowMatrix.value = lights.state.pointShadowMatrix;
			// TODO (abelnation): add area lights shadow info to uniforms

		}

		const progUniforms = materialProperties.program.getUniforms();

		//TODO !!!!	
		const uniformsList = WebGLUniforms.seqWithValue( progUniforms.seq, uniforms );

		materialProperties.uniformsList = uniformsList;

	}

	/**
	 * 
	 * @param {CameraInterface} camera 
	 * @param {Scene} scene 
	 * @param {MaterialInterface} material 
	 * @param {Object3DInterface} object 
	 */
	setProgram( camera, scene, material, object ) {

		if ( scene.isScene !== true ) scene = this._emptyScene; // scene could be a Mesh, Line, Points, ...

		this.textures.resetTextureUnits();

		const fog = scene.fog;
		const environment = material.isMeshStandardMaterial ? scene.environment : null;
		const encoding = ( this._currentRenderTarget === null ) ? this.outputEncoding : this._currentRenderTarget.texture.encoding;
		const envMap = this.cubemaps.get( material.envMap || environment );

		const materialProperties = this.properties.get( material );
		const lights = this.currentRenderState.state.lights;

		if ( this._clippingEnabled === true ) {

			if ( this._localClippingEnabled === true || camera !== this._currentCamera ) {

				const useCache =
					camera === this._currentCamera &&
					material.id === this._currentMaterialId;

				// we might want to call this function with some ClippingGroup
				// object instead of the material, once it becomes feasible
				// (#8465, #8379)
				this.clipping.setState( material, camera, useCache );

			}

		}

		if ( material.version === materialProperties.__version ) {

			if ( material.fog && materialProperties.fog !== fog ) {

				this.initMaterial( material, scene, object );

			} else if ( materialProperties.environment !== environment ) {

				this.initMaterial( material, scene, object );

			} else if ( materialProperties.needsLights && ( materialProperties.lightsStateVersion !== lights.state.version ) ) {

				this.initMaterial( material, scene, object );

			} else if ( materialProperties.numClippingPlanes !== undefined &&
				( materialProperties.numClippingPlanes !== this.clipping.numPlanes ||
				materialProperties.numIntersection !== this.clipping.numIntersection ) ) {

				this.initMaterial( material, scene, object );

			} else if ( materialProperties.outputEncoding !== encoding ) {

				this.initMaterial( material, scene, object );

			} else if ( materialProperties.envMap !== envMap ) {

				this.initMaterial( material, scene, object );

			}

		} else {

			this.initMaterial( material, scene, object );
			materialProperties.__version = material.version;

		}

		let refreshProgram = false;
		let refreshMaterial = false;
		let refreshLights = false;

		const program = materialProperties.program,
			p_uniforms = program.getUniforms(),
			m_uniforms = materialProperties.uniforms;

		if ( this.state.useProgram( program.program ) ) {

			refreshProgram = true;
			refreshMaterial = true;
			refreshLights = true;

		}

		if ( material.id !== this._currentMaterialId ) {

			this._currentMaterialId = material.id;

			refreshMaterial = true;

		}

		if ( refreshProgram || this._currentCamera !== camera ) {

			p_uniforms.setValue( this._gl, 'projectionMatrix', camera.projectionMatrix );

			if ( this.capabilities.logarithmicDepthBuffer ) {

				p_uniforms.setValue( this._gl, 'logDepthBufFC',
					2.0 / ( Math.log( camera.far + 1.0 ) / Math.LN2 ) );

			}

			if ( this._currentCamera !== camera ) {

				this._currentCamera = camera;

				// lighting uniforms depend on the camera so enforce an update
				// now, in case this material supports lights - or later, when
				// the next material that does gets activated:

				refreshMaterial = true;		// set to true on material change
				refreshLights = true;		// remains set until update done

			}

			// load material specific uniforms
			// (shader material also gets them for the sake of genericity)

			if ( material.isShaderMaterial ||
				material.isMeshPhongMaterial ||
				material.isMeshToonMaterial ||
				material.isMeshStandardMaterial ||
				material.envMap ) {

				const uCamPos = p_uniforms.map.cameraPosition;

				if ( uCamPos !== undefined ) {

					uCamPos.setValue( this._gl,
						this._vector3.setFromMatrixPosition( camera.matrixWorld ) );

				}

			}

			if ( material.isMeshPhongMaterial ||
				material.isMeshToonMaterial ||
				material.isMeshLambertMaterial ||
				material.isMeshBasicMaterial ||
				material.isMeshStandardMaterial ||
				material.isShaderMaterial ) {

				p_uniforms.setValue( this._gl, 'isOrthographic', camera.isOrthographicCamera === true );

			}

			if ( material.isMeshPhongMaterial ||
				material.isMeshToonMaterial ||
				material.isMeshLambertMaterial ||
				material.isMeshBasicMaterial ||
				material.isMeshStandardMaterial ||
				material.isShaderMaterial ||
				material.isShadowMaterial ||
				material.skinning ) {

				p_uniforms.setValue( this._gl, 'viewMatrix', camera.matrixWorldInverse );

			}

		}

		// skinning uniforms must be set even if material didn't change
		// auto-setting of texture unit for bone texture must go before other textures
		// otherwise textures used for skinning can take over texture units reserved for other material textures

		if ( material.skinning ) {

			p_uniforms.setOptional( this._gl, object, 'bindMatrix' );
			p_uniforms.setOptional( this._gl, object, 'bindMatrixInverse' );

			const skeleton = object.skeleton;

			if ( skeleton ) {

				const bones = skeleton.bones;

				if ( this.capabilities.floatVertexTextures ) {

					if ( skeleton.boneTexture === null ) {

						// layout (1 matrix = 4 pixels)
						//      RGBA RGBA RGBA RGBA (=> column1, column2, column3, column4)
						//  with  8x8  pixel texture max   16 bones * 4 pixels =  (8 * 8)
						//       16x16 pixel texture max   64 bones * 4 pixels = (16 * 16)
						//       32x32 pixel texture max  256 bones * 4 pixels = (32 * 32)
						//       64x64 pixel texture max 1024 bones * 4 pixels = (64 * 64)


						let size = Math.sqrt( bones.length * 4 ); // 4 pixels needed for 1 matrix
						size = MathUtils.ceilPowerOfTwo( size );
						size = Math.max( size, 4 );

						const boneMatrices = new Float32Array( size * size * 4 ); // 4 floats per RGBA pixel
						boneMatrices.set( skeleton.boneMatrices ); // copy current values

						const boneTexture = new DataTexture( boneMatrices, size, size, RGBAFormat, FloatType );

						skeleton.boneMatrices = boneMatrices;
						skeleton.boneTexture = boneTexture;
						skeleton.boneTextureSize = size;

					}

					p_uniforms.setValue( this._gl, 'boneTexture', skeleton.boneTexture, this.textures );
					p_uniforms.setValue( this._gl, 'boneTextureSize', skeleton.boneTextureSize );

				} else {

					p_uniforms.setOptional( this._gl, skeleton, 'boneMatrices' );

				}

			}

		}

		if ( refreshMaterial || materialProperties.receiveShadow !== object.receiveShadow ) {

			materialProperties.receiveShadow = object.receiveShadow;
			p_uniforms.setValue( this._gl, 'receiveShadow', object.receiveShadow );

		}

		if ( refreshMaterial ) {

			p_uniforms.setValue( this._gl, 'toneMappingExposure', this.toneMappingExposure );

			if ( materialProperties.needsLights ) {

				// the current material requires lighting info

				// note: all lighting uniforms are always set correctly
				// they simply reference the renderer's state for their
				// values
				//
				// use the current material's .needsUpdate flags to set
				// the GL state when required

				this.markUniformsLightsNeedsUpdate( m_uniforms, refreshLights );

			}

			// refresh uniforms common to several materials

			if ( fog && material.fog ) {

				this.materials.refreshFogUniforms( m_uniforms, fog );

			}

			this.materials.refreshMaterialUniforms( m_uniforms, material, this._pixelRatio, this._height );

			WebGLUniforms.upload( this._gl, materialProperties.uniformsList, m_uniforms, this.textures );

		}

		if ( material.isShaderMaterial && material.uniformsNeedUpdate === true ) {

			WebGLUniforms.upload( this._gl, materialProperties.uniformsList, m_uniforms, this.textures );
			material.uniformsNeedUpdate = false;

		}

		if ( material.isSpriteMaterial ) {

			p_uniforms.setValue( this._gl, 'center', object.center );

		}

		// common matrices

		p_uniforms.setValue( this._gl, 'modelViewMatrix', object.modelViewMatrix );
		p_uniforms.setValue( this._gl, 'normalMatrix', object.normalMatrix );
		p_uniforms.setValue( this._gl, 'modelMatrix', object.matrixWorld );

		return program;

	}

	// If uniforms are marked as clean, they don't need to be loaded to the GPU.

	/**
	 * 
	 * @param {UniformInterface} uniforms 
	 * @param {boolean} value 
	 */
	markUniformsLightsNeedsUpdate( uniforms, value ) {

		uniforms.ambientLightColor.needsUpdate = value;
		uniforms.lightProbe.needsUpdate = value;

		uniforms.directionalLights.needsUpdate = value;
		uniforms.directionalLightShadows.needsUpdate = value;
		uniforms.pointLights.needsUpdate = value;
		uniforms.pointLightShadows.needsUpdate = value;
		uniforms.spotLights.needsUpdate = value;
		uniforms.spotLightShadows.needsUpdate = value;
		uniforms.rectAreaLights.needsUpdate = value;
		uniforms.hemisphereLights.needsUpdate = value;

	}

	/**
	 * 
	 * @param {MaterialInterface} material 
	 */
	materialNeedsLights( material ) {

		return material.isMeshLambertMaterial || material.isMeshToonMaterial || material.isMeshPhongMaterial ||
			material.isMeshStandardMaterial || material.isShadowMaterial ||
			( material.isShaderMaterial && material.lights === true );

	}

	/**
	 * 
	 * @param {WebGLFramebuffer} value 
	 */
	setFramebuffer( value ) {

		if ( this._framebuffer !== value && this._currentRenderTarget === null ) this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, value );

		this._framebuffer = value;

	}

	/**
	 * @return {number}
	 */
	getActiveCubeFace() {

		return this._currentActiveCubeFace;

	}
	/**
	 * @return {number}
	 */
	getActiveMipmapLevel() {

		return this._currentActiveMipmapLevel;

	}

	getRenderTarget() {

		return this._currentRenderTarget;

	}

	/**
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 * @param {number=} activeCubeFace 
	 * @param {number=} activeMipmapLevel 
	 */
	setRenderTarget( renderTarget, activeCubeFace = 0, activeMipmapLevel = 0 ) {

		this._currentRenderTarget = renderTarget;
		this._currentActiveCubeFace = activeCubeFace;
		this._currentActiveMipmapLevel = activeMipmapLevel;

		if ( renderTarget && this.properties.get( renderTarget ).__webglFramebuffer === undefined ) {

			this.textures.setupRenderTarget( renderTarget );

		}

		let framebuffer = this._framebuffer;
		let isCube = false;
		let isRenderTarget3D = false;

		if ( renderTarget ) {

			const texture = renderTarget.texture;

			if ( texture.isDataTexture3D || texture.isDataTexture2DArray ) {

				isRenderTarget3D = true;

			}

			const __webglFramebuffer = this.properties.get( renderTarget ).__webglFramebuffer;

			if ( renderTarget.isWebGLCubeRenderTarget ) {

				framebuffer = __webglFramebuffer[ activeCubeFace ];
				isCube = true;

			} else if ( renderTarget.isWebGLMultisampleRenderTarget ) {

				framebuffer = this.properties.get( renderTarget ).__webglMultisampledFramebuffer;

			} else {

				framebuffer = __webglFramebuffer;

			}

			this._currentViewport.copy( renderTarget.viewport );
			this._currentScissor.copy( renderTarget.scissor );
			this._currentScissorTest = renderTarget.scissorTest;

		} else {

			this._currentViewport.copy( this._viewport ).multiplyScalar( this._pixelRatio ).floor();
			this._currentScissor.copy( this._scissor ).multiplyScalar( this._pixelRatio ).floor();
			this._currentScissorTest = this._scissorTest;

		}

		if ( this._currentFramebuffer !== framebuffer ) {

			this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, framebuffer );
			this._currentFramebuffer = framebuffer;

		}

		this.state.viewport( this._currentViewport );
		this.state.scissor( this._currentScissor );
		this.state.setScissorTest( this._currentScissorTest );

		if ( isCube ) {

			const textureProperties = this.properties.get( renderTarget.texture );
			this._gl.framebufferTexture2D( this._gl.FRAMEBUFFER, this._gl.COLOR_ATTACHMENT0, this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + activeCubeFace, textureProperties.__webglTexture, activeMipmapLevel );

		} else if ( isRenderTarget3D ) {

			const textureProperties = this.properties.get( renderTarget.texture );
			const layer = activeCubeFace || 0;
			this._gl.framebufferTextureLayer( this._gl.FRAMEBUFFER, this._gl.COLOR_ATTACHMENT0, textureProperties.__webglTexture, activeMipmapLevel || 0, layer );

		}

	}

	/**
	 * 
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 * @param {number} x 
	 * @param {number} y 
	 * @param {number} width 
	 * @param {number} height 
	 * @param {ArrayBufferView} buffer 
	 * @param {number=} activeCubeFaceIndex 
	 */
	readRenderTargetPixels( renderTarget, x, y, width, height, buffer, activeCubeFaceIndex ) {

		if ( ! ( renderTarget && renderTarget.isWebGLRenderTarget ) ) {

			console.error( 'THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not THREE.WebGLRenderTarget.' );
			return;

		}

		let framebuffer = this.properties.get( renderTarget ).__webglFramebuffer;

		if ( renderTarget.isWebGLCubeRenderTarget && activeCubeFaceIndex !== undefined ) {

			framebuffer = framebuffer[ activeCubeFaceIndex ];

		}

		if ( framebuffer ) {

			let restore = false;

			if ( framebuffer !== this._currentFramebuffer ) {

				this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, framebuffer );

				restore = true;

			}

			try {

				const texture = renderTarget.texture;
				const textureFormat = texture.format;
				const textureType = texture.type;

				if ( textureFormat !== RGBAFormat && this.utils.convert( textureFormat ) !== this._gl.getParameter( this._gl.IMPLEMENTATION_COLOR_READ_FORMAT ) ) {

					console.error( 'THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not in RGBA or implementation defined format.' );
					return;

				}

				const halfFloatSupportedByExt = ( textureType === HalfFloatType ) && ( this.extensions.has( 'EXT_color_buffer_half_float' ) || ( this.capabilities.isWebGL2 && this.extensions.has( 'EXT_color_buffer_float' ) ) );

				if ( textureType !== UnsignedByteType && this.utils.convert( textureType ) !== this._gl.getParameter( this._gl.IMPLEMENTATION_COLOR_READ_TYPE ) && // Edge and Chrome Mac < 52 (#9513)
					! ( textureType === FloatType && ( this.capabilities.isWebGL2 || this.extensions.has( 'OES_texture_float' ) || this.extensions.has( 'WEBGL_color_buffer_float' ) ) ) && // Chrome Mac >= 52 and Firefox
					! halfFloatSupportedByExt ) {

					console.error( 'THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not in UnsignedByteType or implementation defined type.' );
					return;

				}

				if ( this._gl.checkFramebufferStatus( this._gl.FRAMEBUFFER ) === this._gl.FRAMEBUFFER_COMPLETE ) {

					// the following if statement ensures valid read requests (no out-of-bounds pixels, see #8604)

					if ( ( x >= 0 && x <= ( renderTarget.width - width ) ) && ( y >= 0 && y <= ( renderTarget.height - height ) ) ) {

						this._gl.readPixels( x, y, width, height, this.utils.convert( textureFormat ), this.utils.convert( textureType ), buffer );

					}

				} else {

					console.error( 'THREE.WebGLRenderer.readRenderTargetPixels: readPixels from renderTarget failed. Framebuffer not complete.' );

				}

			} finally {

				if ( restore ) {

					this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, this._currentFramebuffer );

				}

			}

		}

	}

	/**
	 * @param {Vector2} position 
	 * @param {TextureInterface} texture 
	 * @param {number=} level 
	 */
	copyFramebufferToTexture( position, texture, level = 0 ) {

		const levelScale = Math.pow( 2, - level );
		const width = Math.floor( texture.image.width * levelScale );
		const height = Math.floor( texture.image.height * levelScale );
		const glFormat = this.utils.convert( texture.format );

		this.textures.setTexture2D( texture, 0 );

		this._gl.copyTexImage2D( this._gl.TEXTURE_2D, level, glFormat, position.x, position.y, width, height, 0 );

		this.state.unbindTexture();

	}

	/**
	 * 
	 * @param {Vector2} position 
	 * @param {TextureInterface} srcTexture 
	 * @param {TextureInterface} dstTexture 
	 * @param {number=} level 
	 * @suppress {checkTypes}  
	 */
	copyTextureToTexture( position, srcTexture, dstTexture, level = 0 ) {

		const width = srcTexture.image.width;
		const height = srcTexture.image.height;
		const glFormat = this.utils.convert( dstTexture.format );
		const glType = this.utils.convert( dstTexture.type );

		this.textures.setTexture2D( dstTexture, 0 );

		// As another texture upload may have changed pixelStorei
		// parameters, make sure they are correct for the dstTexture
		this._gl.pixelStorei( this._gl.UNPACK_FLIP_Y_WEBGL, dstTexture.flipY );
		this._gl.pixelStorei( this._gl.UNPACK_PREMULTIPLY_ALPHA_WEBGL, dstTexture.premultiplyAlpha );
		this._gl.pixelStorei( this._gl.UNPACK_ALIGNMENT, dstTexture.unpackAlignment );

		if ( srcTexture.isDataTexture ) {

			this._gl.texSubImage2D( this._gl.TEXTURE_2D, level, position.x, position.y, width, height, glFormat, glType, srcTexture.image.data );

		} else {

			if ( srcTexture.isCompressedTexture ) {

				this._gl.compressedTexSubImage2D( this._gl.TEXTURE_2D, level, position.x, position.y, srcTexture.mipmaps[ 0 ].width, srcTexture.mipmaps[ 0 ].height, glFormat, srcTexture.mipmaps[ 0 ].data );

			} else {

				this._gl.texSubImage2D( this._gl.TEXTURE_2D, level, position.x, position.y, glFormat, glType, srcTexture.image );

			}

		}

		// Generate mipmaps only when copying level 0
		if ( level === 0 && dstTexture.generateMipmaps ) this._gl.generateMipmap( this._gl.TEXTURE_2D );

		this.state.unbindTexture();

	}

	/**
	 * @param {Box3} sourceBox 
	 * @param {Vector3} position 
	 * @param {TextureInterface} srcTexture 
	 * @param {TextureInterface} dstTexture 
	 * @param {number=} level 
	 */
	copyTextureToTexture3D( sourceBox, position, srcTexture, dstTexture, level = 0 ) {

		if ( this.isWebGL1Renderer ) {

			console.warn( 'THREE.WebGLRenderer.copyTextureToTexture3D: can only be used with WebGL2.' );
			return;

		}

		const { width, height, data } = srcTexture.image;
		const glFormat = this.utils.convert( dstTexture.format );
		const glType = this.utils.convert( dstTexture.type );
		let glTarget;

		if ( dstTexture.isDataTexture3D ) {

			this.textures.setTexture3D( dstTexture, 0 );
			glTarget = this._gl.TEXTURE_3D;

		} else if ( dstTexture.isDataTexture2DArray ) {

			this.textures.setTexture2DArray( dstTexture, 0 );
			glTarget = this._gl.TEXTURE_2D_ARRAY;

		} else {

			console.warn( 'THREE.WebGLRenderer.copyTextureToTexture3D: only supports THREE.DataTexture3D and THREE.DataTexture2DArray.' );
			return;

		}

		this._gl.pixelStorei( this._gl.UNPACK_FLIP_Y_WEBGL, dstTexture.flipY );
		this._gl.pixelStorei( this._gl.UNPACK_PREMULTIPLY_ALPHA_WEBGL, dstTexture.premultiplyAlpha );
		this._gl.pixelStorei( this._gl.UNPACK_ALIGNMENT, dstTexture.unpackAlignment );


		/** @type {boolean|number} */
		const unpackRowLen =  /** @type {boolean|number} */ (this._gl.getParameter( this._gl.UNPACK_ROW_LENGTH ));
		/** @type {boolean|number} */
		const unpackImageHeight = /** @type {boolean|number} */ (this._gl.getParameter( this._gl.UNPACK_IMAGE_HEIGHT ));
		/** @type {boolean|number} */
		const unpackSkipPixels = /** @type {boolean|number} */ (this._gl.getParameter( this._gl.UNPACK_SKIP_PIXELS ));
		/** @type {boolean|number} */
		const unpackSkipRows = /** @type {boolean|number} */ (this._gl.getParameter( this._gl.UNPACK_SKIP_ROWS ));
		/** @type {boolean|number} */
		const unpackSkipImages = /** @type {boolean|number} */ (this._gl.getParameter( this._gl.UNPACK_SKIP_IMAGES ));

		this._gl.pixelStorei( this._gl.UNPACK_ROW_LENGTH, width );
		this._gl.pixelStorei( this._gl.UNPACK_IMAGE_HEIGHT, height );
		this._gl.pixelStorei( this._gl.UNPACK_SKIP_PIXELS, sourceBox.min.x );
		this._gl.pixelStorei( this._gl.UNPACK_SKIP_ROWS, sourceBox.min.y );
		this._gl.pixelStorei( this._gl.UNPACK_SKIP_IMAGES, sourceBox.min.z );

		this._gl.texSubImage3D(
			glTarget,
			level,
			position.x,
			position.y,
			position.z,
			sourceBox.max.x - sourceBox.min.x + 1,
			sourceBox.max.y - sourceBox.min.y + 1,
			sourceBox.max.z - sourceBox.min.z + 1,
			glFormat,
			glType,
			data
		);

		this._gl.pixelStorei( this._gl.UNPACK_ROW_LENGTH, unpackRowLen );
		this._gl.pixelStorei( this._gl.UNPACK_IMAGE_HEIGHT, unpackImageHeight );
		this._gl.pixelStorei( this._gl.UNPACK_SKIP_PIXELS, unpackSkipPixels );
		this._gl.pixelStorei( this._gl.UNPACK_SKIP_ROWS, unpackSkipRows );
		this._gl.pixelStorei( this._gl.UNPACK_SKIP_IMAGES, unpackSkipImages );

		// Generate mipmaps only when copying level 0
		if ( level === 0 && dstTexture.generateMipmaps ) this._gl.generateMipmap( glTarget );

		this.state.unbindTexture();

	}

	/**
	 * @param {Texture} texture 
	 */
	initTexture( texture ) {

		this.textures.setTexture2D( texture, 0 );

		this.state.unbindTexture();

	}

	resetState() {

		this.state.reset();
		this.bindingStates.reset();

	}


}

export { WebGLRenderer };
