import { LinearFilter, LinearMipmapLinearFilter, LinearMipmapNearestFilter, NearestFilter, NearestMipmapLinearFilter, NearestMipmapNearestFilter, RGBFormat, RGBAFormat, DepthFormat, DepthStencilFormat, UnsignedShortType, UnsignedIntType, UnsignedInt248Type, FloatType, HalfFloatType, MirroredRepeatWrapping, ClampToEdgeWrapping, RepeatWrapping } from '../../constants.js';
import { MathUtils } from '../../math/MathUtils.js';

import { WebGLExtensions } from './WebGLExtensions.js';
import { WebGLState } from './WebGLState.js';
import { WebGLProperties } from './WebGLProperties.js';
import { WebGLCapabilities } from './WebGLCapabilities.js';
import { WebGLUtils } from './WebGLUtils.js';
import { WebGLInfo } from './WebGLInfo.js';

//closure compiler
import { Event } from '../../core/EventDispatcher.js';
import { TextureInterface } from '../../closure/textures/TextureInterface.js';
import { WebGLRenderTargetInterface } from '../../closure/renderers/WebGLRenderTargetInterface.js';
import { WebGLProperty } from '../../closure/renderers/webgl/WebGLProperty.js';

/**
 * @suppress {checkTypes, reportUnknownTypes}
 */
class WebGLTextures {

	/**
 	 * @param {WebGLRenderingContext|WebGL2RenderingContext} _gl
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLState} state 
	 * @param {WebGLProperties} properties 
	 * @param {WebGLCapabilities} capabilities 
	 * @param {WebGLUtils} utils 
	 * @param {WebGLInfo} info 
	 */
	constructor( _gl, extensions, state, properties, capabilities, utils, info ) {

		/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
		this._gl = _gl;
		this.extensions = extensions;
		this.state = state;
		this.properties = properties;
		this.capabilities = capabilities;
		/** @type {WebGLUtils} */this.utils = utils;
		this.info = info;

		this.isWebGL2 = capabilities.isWebGL2;
		this.maxTextures = capabilities.maxTextures;
		this.maxCubemapSize = capabilities.maxCubemapSize;
		this.maxTextureSize = capabilities.maxTextureSize;
		this.maxSamples = capabilities.maxSamples;
	
		this._videoTextures = new WeakMap();
		this._canvas = undefined;
	
		// cordova iOS (as of 5.0) still uses UIWebView, which provides OffscreenCanvas,
		// also OffscreenCanvas.getContext("webgl"), but not OffscreenCanvas.getContext("2d")!
		// Some implementations may only implement OffscreenCanvas partially (e.g. lacking 2d).
	
		this.useOffscreenCanvas = false;
		this.textureUnits = 0;

	
		try {
	
			this.useOffscreenCanvas = typeof OffscreenCanvas !== 'undefined'
				&& ( new OffscreenCanvas( 1, 1 ).getContext( '2d' ) ) !== null;
	
		} catch ( err ) {
	
			// Ignore any errors
	
		}

		this.wrappingToGL = {
			[ RepeatWrapping ]: this._gl.REPEAT,
			[ ClampToEdgeWrapping ]: this._gl.CLAMP_TO_EDGE,
			[ MirroredRepeatWrapping ]: this._gl.MIRRORED_REPEAT
		};
	
		this.filterToGL = {
			[ NearestFilter ]: this._gl.NEAREST,
			[ NearestMipmapNearestFilter ]: this._gl.NEAREST_MIPMAP_NEAREST,
			[ NearestMipmapLinearFilter ]: this._gl.NEAREST_MIPMAP_LINEAR,
	
			[ LinearFilter ]: this._gl.LINEAR,
			[ LinearMipmapNearestFilter ]: this._gl.LINEAR_MIPMAP_NEAREST,
			[ LinearMipmapLinearFilter ]: this._gl.LINEAR_MIPMAP_LINEAR
		};

		this.warnedTexture2D = false;
		this.warnedTextureCube = false;
	
	}	

	/**
	 * @param {number} width
	 * @param {number} height
	 * @return {Element}
	 */
	createCanvas( width, height ) {

		// Use OffscreenCanvas when available. Specially needed in web workers

		return this.useOffscreenCanvas ?
			new OffscreenCanvas( width, height ) :
			document.createElementNS( 'http://www.w3.org/1999/xhtml', 'canvas' );

	}

	/** 
	 * @param {HTMLImageElement|HTMLCanvasElement|ImageBitmap} image
	 * @param {boolean} needsPowerOfTwo
	 * @param {boolean} needsNewCanvas
	 * @param {number} maxSize
	 * @return {HTMLImageElement|HTMLCanvasElement|ImageBitmap}
	 */

	resizeImage( image, needsPowerOfTwo, needsNewCanvas, maxSize ) {

		let scale = 1;

		// handle case if texture exceeds max size

		if ( image.width > maxSize || image.height > maxSize ) {

			scale = maxSize / Math.max( image.width, image.height );

		}

		// only perform resize if necessary

		if ( scale < 1 || needsPowerOfTwo === true ) {

			// only perform resize for certain image types

			if ( ( typeof HTMLImageElement !== 'undefined' && image instanceof HTMLImageElement ) ||
				( typeof HTMLCanvasElement !== 'undefined' && image instanceof HTMLCanvasElement ) ||
				( typeof ImageBitmap !== 'undefined' && image instanceof ImageBitmap ) ) {

				/** @type { function(number) : number } */		
				const floor = needsPowerOfTwo ? MathUtils.floorPowerOfTwo : Math.floor;

				const width = floor( scale * image.width );
				const height = floor( scale * image.height );

				if ( this._canvas === undefined ) this._canvas = this.createCanvas( width, height );

				// cube textures can't reuse the same canvas

				const canvas = needsNewCanvas ? this.createCanvas( width, height ) : this._canvas;

				canvas.width = width;
				canvas.height = height;

				const context = canvas.getContext( '2d' );
				context.drawImage( image, 0, 0, width, height );

				console.warn( 'THREE.WebGLRenderer: Texture has been resized from (' + image.width + 'x' + image.height + ') to (' + width + 'x' + height + ').' );

				return canvas;

			} else {

				if ( 'data' in image ) {

					console.warn( 'THREE.WebGLRenderer: Image in DataTexture is too big (' + image.width + 'x' + image.height + ').' );

				}

				return image;

			}

		}

		return image;

	}

	/**
	 *  @param {HTMLImageElement|HTMLCanvasElement|ImageBitmap}  image
	 *  @return {number}
	 */
	isPowerOfTwo( image ) {

		return MathUtils.isPowerOfTwo( image.width ) && MathUtils.isPowerOfTwo( image.height );

	}

	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @return {number}
	 */
	textureNeedsPowerOfTwo( texture ) {

		if ( this.isWebGL2 ) return false;

		return ( texture.wrapS !== ClampToEdgeWrapping || texture.wrapT !== ClampToEdgeWrapping ) ||
			( texture.minFilter !== NearestFilter && texture.minFilter !== LinearFilter );

	}

	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @param {boolean} supportsMips 
	 * @return {boolean}
	 */
	textureNeedsGenerateMipmaps( texture, supportsMips ) {

		return texture.generateMipmaps && supportsMips &&
			texture.minFilter !== NearestFilter && texture.minFilter !== LinearFilter;

	}

	/**
	 * 
	 * @param {number} target 
	 * @param {TextureInterface} texture 
	 * @param {number} width 
	 * @param {number} height 
	 * @return {number}
 	 * @suppress {reportUnknownTypes,missingReturn} 
	 */
	generateMipmap( target, texture, width, height ) {

		this._gl.generateMipmap( target );

		const textureProperties = this.properties.get( texture );

		textureProperties.__maxMipLevel = Math.log2( Math.max( width, height ) );

	}

	/**
	 * 
	 * @param {number} internalFormatName 
	 * @param {number} glFormat 
	 * @param {number} glType 
	 * @return {number}
	 */
	getInternalFormat( internalFormatName, glFormat, glType ) {

		if ( this.isWebGL2 === false ) return glFormat;

		if ( internalFormatName !== null ) {

			if ( this._gl[ internalFormatName ] !== undefined ) return this._gl[ internalFormatName ];

			console.warn( 'THREE.WebGLRenderer: Attempt to use non-existing WebGL internal format \'' + internalFormatName + '\'' );

		}

		let internalFormat = glFormat;

		if ( glFormat === this._gl.RED ) {

			if ( glType === this._gl.FLOAT ) internalFormat = this._gl.R32F;
			if ( glType === this._gl.HALF_FLOAT ) internalFormat = this._gl.R16F;
			if ( glType === this._gl.UNSIGNED_BYTE ) internalFormat = this._gl.R8;

		}

		if ( glFormat === this._gl.RGB ) {

			if ( glType === this._gl.FLOAT ) internalFormat = this._gl.RGB32F;
			if ( glType === this._gl.HALF_FLOAT ) internalFormat = this._gl.RGB16F;
			if ( glType === this._gl.UNSIGNED_BYTE ) internalFormat = this._gl.RGB8;

		}

		if ( glFormat === this._gl.RGBA ) {

			if ( glType === this._gl.FLOAT ) internalFormat = this._gl.RGBA32F;
			if ( glType === this._gl.HALF_FLOAT ) internalFormat = this._gl.RGBA16F;
			if ( glType === this._gl.UNSIGNED_BYTE ) internalFormat = this._gl.RGBA8;

		}

		if ( internalFormat === this._gl.R16F || internalFormat === this._gl.R32F ||
			internalFormat === this._gl.RGBA16F || internalFormat === this._gl.RGBA32F ) {

			this.extensions.get( 'EXT_color_buffer_float' );

		}

		return internalFormat;

	}

	// Fallback filters for non-power-of-2 textures

	filterFallback( f ) {

		if ( f === NearestFilter || f === NearestMipmapNearestFilter || f === NearestMipmapLinearFilter ) {

			return this._gl.NEAREST;

		}

		return this._gl.LINEAR;

	}

	//
	/**
	 * 
	 * @param {Event} event 
	 */
	onTextureDispose( event ) {

		/** @type {TextureInterface} */
		const texture = event.target;

		texture.removeEventListener( 'dispose', this.onTextureDispose );

		this.deallocateTexture( texture );

		if ( texture.isVideoTexture ) {

			this._videoTextures.delete( texture );

		}

		this.info.memory.textures --;

	}

	/**
	 * 
	 * @param {Event} event 
	 */
	onRenderTargetDispose( event ) {

		const renderTarget = event.target;

		renderTarget.removeEventListener( 'dispose', this.onRenderTargetDispose );

		this.deallocateRenderTarget( renderTarget );

		this.info.memory.textures --;

	}

	//
	/**
	 * 
	 * @param {TextureInterface} texture 
	 */
	deallocateTexture( texture ) {

		const textureProperties = this.properties.get( texture );

		if ( textureProperties.__webglInit === undefined ) return;

		this._gl.deleteTexture( textureProperties.__webglTexture );

		this.properties.remove( texture );

	}

	/**
	 * 
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 */
	deallocateRenderTarget( renderTarget ) {

		const texture = renderTarget.texture;

		const renderTargetProperties = this.properties.get( renderTarget );
		const textureProperties = this.properties.get( texture );

		if ( ! renderTarget ) return;

		if ( textureProperties.__webglTexture !== undefined ) {

			this._gl.deleteTexture( textureProperties.__webglTexture );

		}

		if ( renderTarget.depthTexture ) {

			renderTarget.depthTexture.dispose();

		}

		if ( renderTarget.isWebGLCubeRenderTarget ) {

			for ( let i = 0; i < 6; i ++ ) {

				this._gl.deleteFramebuffer( renderTargetProperties.__webglFramebuffer[ i ] );
				if ( renderTargetProperties.__webglDepthbuffer ) this._gl.deleteRenderbuffer( renderTargetProperties.__webglDepthbuffer[ i ] );

			}

		} else {

			this._gl.deleteFramebuffer( renderTargetProperties.__webglFramebuffer );
			if ( renderTargetProperties.__webglDepthbuffer ) this._gl.deleteRenderbuffer( renderTargetProperties.__webglDepthbuffer );
			if ( renderTargetProperties.__webglMultisampledFramebuffer ) this._gl.deleteFramebuffer( renderTargetProperties.__webglMultisampledFramebuffer );
			if ( renderTargetProperties.__webglColorRenderbuffer ) this._gl.deleteRenderbuffer( renderTargetProperties.__webglColorRenderbuffer );
			if ( renderTargetProperties.__webglDepthRenderbuffer ) this._gl.deleteRenderbuffer( renderTargetProperties.__webglDepthRenderbuffer );

		}

		this.properties.remove( texture );
		this.properties.remove( renderTarget );

	}

	//

	resetTextureUnits() {

		this.textureUnits = 0;

	}

	/**
	 * @return {number}
	 */
	allocateTextureUnit() {

		const textureUnit = this.textureUnits;

		if ( textureUnit >= this.maxTextures ) {

			console.warn( 'THREE.WebGLTextures: Trying to use ' + textureUnit + ' texture units while this GPU supports only ' + this.maxTextures );

		}

		this.textureUnits += 1;

		return textureUnit;

	}

	//
	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
	setTexture2D( texture, slot ) {

		const textureProperties = this.properties.get( texture );

		if ( texture.isVideoTexture ) this.updateVideoTexture( texture );

		if ( texture.version > 0 && textureProperties.__version !== texture.version ) {

			const image = texture.image;

			if ( image === undefined ) {

				console.warn( 'THREE.WebGLRenderer: Texture marked for update but image is undefined' );

			} else if ( image.complete === false ) {

				console.warn( 'THREE.WebGLRenderer: Texture marked for update but image is incomplete' );

			} else {

				this.uploadTexture( textureProperties, texture, slot );
				return;

			}

		}

		this.state.activeTexture( this._gl.TEXTURE0 + slot );
		this.state.bindTexture( this._gl.TEXTURE_2D, textureProperties.__webglTexture );

	}

	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
	setTexture2DArray( texture, slot ) {

		const textureProperties = this.properties.get( texture );

		if ( texture.version > 0 && textureProperties.__version !== texture.version ) {

			this.uploadTexture( textureProperties, texture, slot );
			return;

		}

		this.state.activeTexture( this._gl.TEXTURE0 + slot );
		this.state.bindTexture( this._gl.TEXTURE_2D_ARRAY, textureProperties.__webglTexture );

	}

	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
	setTexture3D( texture, slot ) {

		const textureProperties = this.properties.get( texture );

		if ( texture.version > 0 && textureProperties.__version !== texture.version ) {

			this.uploadTexture( textureProperties, texture, slot );
			return;

		}

		this.state.activeTexture( this._gl.TEXTURE0 + slot );
		this.state.bindTexture( this._gl.TEXTURE_3D, textureProperties.__webglTexture );

	}

	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
	setTextureCube( texture, slot ) {

		const textureProperties = this.properties.get( texture );

		if ( texture.version > 0 && textureProperties.__version !== texture.version ) {

			this.uploadCubeTexture( textureProperties, texture, slot );
			return;

		}

		this.state.activeTexture( this._gl.TEXTURE0 + slot );
		this.state.bindTexture( this._gl.TEXTURE_CUBE_MAP, textureProperties.__webglTexture );

	}

	/**
	 * 
	 * @param {number} textureType 
	 * @param {TextureInterface} texture 
	 * @param {boolean} supportsMips 
	 */
	setTextureParameters( textureType, texture, supportsMips ) {

		if ( supportsMips ) {

			this._gl.texParameteri( textureType, this._gl.TEXTURE_WRAP_S, this.wrappingToGL[ texture.wrapS ] );
			this._gl.texParameteri( textureType, this._gl.TEXTURE_WRAP_T, this.wrappingToGL[ texture.wrapT ] );

			if ( textureType === this._gl.TEXTURE_3D || textureType === this._gl.TEXTURE_2D_ARRAY ) {

				this._gl.texParameteri( textureType, this._gl.TEXTURE_WRAP_R, this.wrappingToGL[ texture.wrapR ] );

			}

			this._gl.texParameteri( textureType, this._gl.TEXTURE_MAG_FILTER, this.filterToGL[ texture.magFilter ] );
			this._gl.texParameteri( textureType, this._gl.TEXTURE_MIN_FILTER, this.filterToGL[ texture.minFilter ] );

		} else {

			this._gl.texParameteri( textureType, this._gl.TEXTURE_WRAP_S, this._gl.CLAMP_TO_EDGE );
			this._gl.texParameteri( textureType, this._gl.TEXTURE_WRAP_T, this._gl.CLAMP_TO_EDGE );

			if ( textureType === this._gl.TEXTURE_3D || textureType === this._gl.TEXTURE_2D_ARRAY ) {

				this._gl.texParameteri( textureType, this._gl.TEXTURE_WRAP_R, this._gl.CLAMP_TO_EDGE );

			}

			if ( texture.wrapS !== ClampToEdgeWrapping || texture.wrapT !== ClampToEdgeWrapping ) {

				console.warn( 'THREE.WebGLRenderer: Texture is not power of two. Texture.wrapS and Texture.wrapT should be set to THREE.ClampToEdgeWrapping.' );

			}

			this._gl.texParameteri( textureType, this._gl.TEXTURE_MAG_FILTER, this.filterFallback( texture.magFilter ) );
			this._gl.texParameteri( textureType, this._gl.TEXTURE_MIN_FILTER, this.filterFallback( texture.minFilter ) );

			if ( texture.minFilter !== NearestFilter && texture.minFilter !== LinearFilter ) {

				console.warn( 'THREE.WebGLRenderer: Texture is not power of two. Texture.minFilter should be set to THREE.NearestFilter or THREE.LinearFilter.' );

			}

		}

		if ( this.extensions.has( 'EXT_texture_filter_anisotropic' ) === true ) {

			const extension = this.extensions.get( 'EXT_texture_filter_anisotropic' );

			if ( texture.type === FloatType && this.extensions.has( 'OES_texture_float_linear' ) === false ) return; // verify extension for WebGL 1 and WebGL 2
			if ( this.isWebGL2 === false && ( texture.type === HalfFloatType && this.extensions.has( 'OES_texture_half_float_linear' ) === false ) ) return; // verify extension for WebGL 1 only

			if ( texture.anisotropy > 1 || this.properties.get( texture ).__currentAnisotropy ) {

				this._gl.texParameterf( textureType, extension.TEXTURE_MAX_ANISOTROPY_EXT, Math.min( texture.anisotropy, this.capabilities.getMaxAnisotropy() ) );
				this.properties.get( texture ).__currentAnisotropy = texture.anisotropy;

			}

		}

	}

	/**
	 * 
	 * @param {*} textureProperties 
	 * @param {TextureInterface} texture 
	 */
	initTexture( textureProperties, texture ) {

		if ( textureProperties.__webglInit === undefined ) {

			textureProperties.__webglInit = true;

			texture.addEventListener( 'dispose', this.onTextureDispose );

			textureProperties.__webglTexture = this._gl.createTexture();

			this.info.memory.textures ++;

		}

	}

	/**
 	 * @suppress {checkTypes}
	 * @param {*} textureProperties 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
	uploadTexture( textureProperties, texture, slot ) {

		let textureType = this._gl.TEXTURE_2D;

		if ( texture.isDataTexture2DArray ) textureType = this._gl.TEXTURE_2D_ARRAY;
		if ( texture.isDataTexture3D ) textureType = this._gl.TEXTURE_3D;

		this.initTexture( textureProperties, texture );

		this.state.activeTexture( this._gl.TEXTURE0 + slot );
		this.state.bindTexture( textureType, textureProperties.__webglTexture );

		this._gl.pixelStorei( this._gl.UNPACK_FLIP_Y_WEBGL, texture.flipY );
		this._gl.pixelStorei( this._gl.UNPACK_PREMULTIPLY_ALPHA_WEBGL, texture.premultiplyAlpha );
		this._gl.pixelStorei( this._gl.UNPACK_ALIGNMENT, texture.unpackAlignment );
		this._gl.pixelStorei( this._gl.UNPACK_COLORSPACE_CONVERSION_WEBGL, this._gl.NONE );

		const needsPowerOfTwo = this.textureNeedsPowerOfTwo( texture ) && this.isPowerOfTwo( texture.image ) === false;
		/** @type {HTMLImageElement|HTMLCanvasElement|ImageBitmap}  */
		const image = this.resizeImage( texture.image, needsPowerOfTwo, false, this.maxTextureSize );

		const supportsMips = this.isPowerOfTwo( image ) || this.isWebGL2,
			glFormat = this.utils.convert( texture.format );

		let glType = this.utils.convert( texture.type );

		/** @type {number} */
		let	glInternalFormat = this.getInternalFormat( texture.internalFormat, glFormat, glType );

		this.setTextureParameters( textureType, texture, supportsMips );

		let mipmap;
		const mipmaps = texture.mipmaps;

		if ( texture.isDepthTexture ) {

			// populate depth texture with dummy data

			glInternalFormat = this._gl.DEPTH_COMPONENT;

			if ( this.isWebGL2 ) {

				if ( texture.type === FloatType ) {

					glInternalFormat = this._gl.DEPTH_COMPONENT32F;

				} else if ( texture.type === UnsignedIntType ) {

					glInternalFormat = this._gl.DEPTH_COMPONENT24;

				} else if ( texture.type === UnsignedInt248Type ) {

					glInternalFormat = this._gl.DEPTH24_STENCIL8;

				} else {

					glInternalFormat = this._gl.DEPTH_COMPONENT16; // WebGL2 requires sized internalformat for glTexImage2D

				}

			} else {

				if ( texture.type === FloatType ) {

					console.error( 'WebGLRenderer: Floating point depth texture requires WebGL2.' );

				}

			}

			// validation checks for WebGL 1

			if ( texture.format === DepthFormat && glInternalFormat === this._gl.DEPTH_COMPONENT ) {

				// The error INVALID_OPERATION is generated by texImage2D if format and internalformat are
				// DEPTH_COMPONENT and type is not UNSIGNED_SHORT or UNSIGNED_INT
				// (https://www.khronos.org/registry/webgl/extensions/WEBGL_depth_texture/)
				if ( texture.type !== UnsignedShortType && texture.type !== UnsignedIntType ) {

					console.warn( 'THREE.WebGLRenderer: Use UnsignedShortType or UnsignedIntType for DepthFormat DepthTexture.' );

					texture.type = UnsignedShortType;
					glType = this.utils.convert( texture.type );

				}

			}

			if ( texture.format === DepthStencilFormat && glInternalFormat === this._gl.DEPTH_COMPONENT ) {

				// Depth stencil textures need the DEPTH_STENCIL internal format
				// (https://www.khronos.org/registry/webgl/extensions/WEBGL_depth_texture/)
				glInternalFormat = this._gl.DEPTH_STENCIL;

				// The error INVALID_OPERATION is generated by texImage2D if format and internalformat are
				// DEPTH_STENCIL and type is not UNSIGNED_INT_24_8_WEBGL.
				// (https://www.khronos.org/registry/webgl/extensions/WEBGL_depth_texture/)
				if ( texture.type !== UnsignedInt248Type ) {

					console.warn( 'THREE.WebGLRenderer: Use UnsignedInt248Type for DepthStencilFormat DepthTexture.' );

					texture.type = UnsignedInt248Type;
					glType = this.utils.convert( texture.type );

				}

			}

			//
			this.state.texImage2D( this._gl.TEXTURE_2D, 0, glInternalFormat, image.width, image.height, 0, glFormat, glType, null );

		} else if ( texture.isDataTexture ) {

			// use manually created mipmaps if available
			// if there are no manual mipmaps
			// set 0 level mipmap and then use GL to generate other mipmap levels

			if ( mipmaps.length > 0 && supportsMips ) {

				for ( let i = 0, il = mipmaps.length; i < il; i ++ ) {

					mipmap = mipmaps[ i ];
					this.state.texImage2D( this._gl.TEXTURE_2D, i, glInternalFormat, mipmap.width, mipmap.height, 0, glFormat, glType, mipmap.data );

				}

				texture.generateMipmaps = false;
				textureProperties.__maxMipLevel = mipmaps.length - 1;

			} else {
				this.state.texImage2D( this._gl.TEXTURE_2D, 0, glInternalFormat, image.width, image.height, 0, glFormat, glType, image.data );
				textureProperties.__maxMipLevel = 0;

			}

		} else if ( texture.isCompressedTexture ) {

			for ( let i = 0, il = mipmaps.length; i < il; i ++ ) {

				mipmap = mipmaps[ i ];

				if ( texture.format !== RGBAFormat && texture.format !== RGBFormat ) {

					if ( glFormat !== null ) {
						this.state.compressedTexImage2D( this._gl.TEXTURE_2D, i, glInternalFormat, mipmap.width, mipmap.height, 0, mipmap.data );

					} else {

						console.warn( 'THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .uploadTexture()' );

					}

				} else {
					this.state.texImage2D( this._gl.TEXTURE_2D, i, glInternalFormat, mipmap.width, mipmap.height, 0, glFormat, glType, mipmap.data );

				}

			}

			textureProperties.__maxMipLevel = mipmaps.length - 1;

		} else if ( texture.isDataTexture2DArray ) {
			this.state.texImage3D( this._gl.TEXTURE_2D_ARRAY, 0, glInternalFormat, image.width, image.height, image.depth, 0, glFormat, glType, image.data );
			textureProperties.__maxMipLevel = 0;

		} else if ( texture.isDataTexture3D ) {
			this.state.texImage3D( this._gl.TEXTURE_3D, 0, glInternalFormat, image.width, image.height, image.depth, 0, glFormat, glType, image.data );
			textureProperties.__maxMipLevel = 0;

		} else {

			// regular Texture (image, video, canvas)

			// use manually created mipmaps if available
			// if there are no manual mipmaps
			// set 0 level mipmap and then use GL to generate other mipmap levels

			if ( mipmaps.length > 0 && supportsMips ) {

				for ( let i = 0, il = mipmaps.length; i < il; i ++ ) {

					mipmap = mipmaps[ i ];
					this.state.texImage2D( this._gl.TEXTURE_2D, i, glInternalFormat, glFormat, glType, mipmap );

				}

				texture.generateMipmaps = false;
				textureProperties.__maxMipLevel = mipmaps.length - 1;

			} else {
				this.state.texImage2D( this._gl.TEXTURE_2D, 0, glInternalFormat, glFormat, glType, image );
				textureProperties.__maxMipLevel = 0;

			}

		}

		if ( this.textureNeedsGenerateMipmaps( texture, supportsMips ) ) {

			this.generateMipmap( textureType, texture, image.width, image.height );

		}

		textureProperties.__version = texture.version;

		if ( texture.onUpdate ) texture.onUpdate( texture );

	}

	/**
	 * @param {WebGLProperty} textureProperties 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
	uploadCubeTexture( textureProperties, texture, slot ) {

		if ( texture.image.length !== 6 ) return;

		this.initTexture( textureProperties, texture );

		this.state.activeTexture( this._gl.TEXTURE0 + slot );
		this.state.bindTexture( this._gl.TEXTURE_CUBE_MAP, textureProperties.__webglTexture );

		this._gl.pixelStorei( this._gl.UNPACK_FLIP_Y_WEBGL, texture.flipY );
		this._gl.pixelStorei( this._gl.UNPACK_PREMULTIPLY_ALPHA_WEBGL, texture.premultiplyAlpha );
		this._gl.pixelStorei( this._gl.UNPACK_ALIGNMENT, texture.unpackAlignment );
		this._gl.pixelStorei( this._gl.UNPACK_COLORSPACE_CONVERSION_WEBGL, this._gl.NONE );

		/** @type {boolean} */	
		const isCompressed = ( texture && ( texture.isCompressedTexture || texture.image[ 0 ].isCompressedTexture ) );
		/** @type {boolean} */	
		const isDataTexture = ( texture.image[ 0 ] && texture.image[ 0 ].isDataTexture );

		const cubeImage = [];

		for ( let i = 0; i < 6; i ++ ) {

			if ( ! isCompressed && ! isDataTexture ) {

				cubeImage[ i ] = this.resizeImage( texture.image[ i ], false, true, this.maxCubemapSize );

			} else {

				cubeImage[ i ] = isDataTexture ? texture.image[ i ].image : texture.image[ i ];

			}

		}

		const image = cubeImage[ 0 ];
		const supportsMips = this.isPowerOfTwo( image ) || this.isWebGL2;
		/** @type {number} */
		const glFormat = this.utils.convert( texture.format );
		/** @type {number} */
		const glType = this.utils.convert( texture.type );
		/** @type {number} */
		const glInternalFormat = this.getInternalFormat( texture.internalFormat, glFormat, glType );

		this.setTextureParameters( this._gl.TEXTURE_CUBE_MAP, texture, supportsMips );

		let mipmaps;

		if ( isCompressed ) {

			for ( let i = 0; i < 6; i ++ ) {

				mipmaps = cubeImage[ i ].mipmaps;

				for ( let j = 0; j < mipmaps.length; j ++ ) {

					const mipmap = mipmaps[ j ];

					if ( texture.format !== RGBAFormat && texture.format !== RGBFormat ) {

						if ( glFormat !== null ) {

							this.state.compressedTexImage2D( this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i, j, glInternalFormat, mipmap.width, mipmap.height, 0, mipmap.data );

						} else {

							console.warn( 'THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .setTextureCube()' );

						}

					} else {

						this.state.texImage2D( this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i, j, glInternalFormat, mipmap.width, mipmap.height, 0, glFormat, glType, mipmap.data );

					}

				}

			}

			textureProperties.__maxMipLevel = mipmaps.length - 1;

		} else {

			mipmaps = texture.mipmaps;

			for ( let i = 0; i < 6; i ++ ) {

				if ( isDataTexture ) {

					this.state.texImage2D( this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i, 0, glInternalFormat, cubeImage[ i ].width, cubeImage[ i ].height, 0, glFormat, glType, cubeImage[ i ].data );

					for ( let j = 0; j < mipmaps.length; j ++ ) {

						const mipmap = mipmaps[ j ];
						const mipmapImage = mipmap.image[ i ].image;

						this.state.texImage2D( this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i, j + 1, glInternalFormat, mipmapImage.width, mipmapImage.height, 0, glFormat, glType, mipmapImage.data );

					}

				} else {

					this.state.texImage2D( this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i, 0, glInternalFormat, glFormat, glType, cubeImage[ i ] );

					for ( let j = 0; j < mipmaps.length; j ++ ) {

						const mipmap = mipmaps[ j ];

						this.state.texImage2D( this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i, j + 1, glInternalFormat, glFormat, glType, mipmap.image[ i ] );

					}

				}

			}

			textureProperties.__maxMipLevel = mipmaps.length;

		}

		if ( this.textureNeedsGenerateMipmaps( texture, supportsMips ) ) {

			// We assume images for cube map have the same size.
			this.generateMipmap( this._gl.TEXTURE_CUBE_MAP, texture, image.width, image.height );

		}

		textureProperties.__version = texture.version;

		if ( texture.onUpdate ) texture.onUpdate( texture );

	}

	// Render targets

	// Setup storage for target texture and bind it to correct framebuffer
	/**
 	 * @suppress {checkTypes, reportUnknownTypes}
	 * @param {WebGLFramebuffer} framebuffer 
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 * @param {number} attachment 
	 * @param {number} textureTarget 
	 */
	setupFrameBufferTexture( framebuffer, renderTarget, attachment, textureTarget ) {

		const texture = renderTarget.texture;

		const glFormat = this.utils.convert( texture.format );
		const glType = this.utils.convert( texture.type );
		const glInternalFormat = this.getInternalFormat( texture.internalFormat, glFormat, glType );

		if ( textureTarget === this._gl.TEXTURE_3D || textureTarget === this._gl.TEXTURE_2D_ARRAY ) {

			this.state.texImage3D( textureTarget, 0, glInternalFormat, renderTarget.width, renderTarget.height, renderTarget.depth, 0, glFormat, glType, null );

		} else {

			this.state.texImage2D( textureTarget, 0, glInternalFormat, renderTarget.width, renderTarget.height, 0, glFormat, glType, null );

		}

		this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, framebuffer );
		this._gl.framebufferTexture2D( this._gl.FRAMEBUFFER, attachment, textureTarget, this.properties.get( texture ).__webglTexture, 0 );
		this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, null );

	}

	// Setup storage for internal depth/stencil buffers and bind to correct framebuffer
	/**
	 * @param {WebGLFramebuffer} framebuffer 
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 * @param {boolean} isMultisample 
	 */
	setupRenderBufferStorage( renderbuffer, renderTarget, isMultisample ) {

		this._gl.bindRenderbuffer( this._gl.RENDERBUFFER, renderbuffer );

		if ( renderTarget.depthBuffer && ! renderTarget.stencilBuffer ) {

			/** @type {number} */
			let glInternalFormat = this._gl.DEPTH_COMPONENT16;

			if ( isMultisample ) {

				const depthTexture = renderTarget.depthTexture;

				if ( depthTexture && depthTexture.isDepthTexture ) {

					if ( depthTexture.type === FloatType ) {

						glInternalFormat = this._gl.DEPTH_COMPONENT32F;

					} else if ( depthTexture.type === UnsignedIntType ) {

						glInternalFormat = this._gl.DEPTH_COMPONENT24;

					}

				}

				const samples = this.getRenderTargetSamples( renderTarget );

				this._gl.renderbufferStorageMultisample( this._gl.RENDERBUFFER, samples, glInternalFormat, renderTarget.width, renderTarget.height );

			} else {

				this._gl.renderbufferStorage( this._gl.RENDERBUFFER, glInternalFormat, renderTarget.width, renderTarget.height );

			}

			this._gl.framebufferRenderbuffer( this._gl.FRAMEBUFFER, this._gl.DEPTH_ATTACHMENT, this._gl.RENDERBUFFER, renderbuffer );

		} else if ( renderTarget.depthBuffer && renderTarget.stencilBuffer ) {

			if ( isMultisample ) {

				const samples =this. getRenderTargetSamples( renderTarget );

				this._gl.renderbufferStorageMultisample( this._gl.RENDERBUFFER, samples, this._gl.DEPTH24_STENCIL8, renderTarget.width, renderTarget.height );

			} else {

				this._gl.renderbufferStorage( this._gl.RENDERBUFFER, this._gl.DEPTH_STENCIL, renderTarget.width, renderTarget.height );

			}


			this._gl.framebufferRenderbuffer( this._gl.FRAMEBUFFER, this._gl.DEPTH_STENCIL_ATTACHMENT, this._gl.RENDERBUFFER, renderbuffer );

		} else {

			const texture = renderTarget.texture;

			const glFormat = this.utils.convert( texture.format );
			const glType = this.utils.convert( texture.type );
			const glInternalFormat = this.getInternalFormat( texture.internalFormat, glFormat, glType );

			if ( isMultisample ) {

				const samples = this.getRenderTargetSamples( renderTarget );

				this._gl.renderbufferStorageMultisample( this._gl.RENDERBUFFER, samples, glInternalFormat, renderTarget.width, renderTarget.height );

			} else {

				this._gl.renderbufferStorage( this._gl.RENDERBUFFER, glInternalFormat, renderTarget.width, renderTarget.height );

			}

		}

		this._gl.bindRenderbuffer( this._gl.RENDERBUFFER, null );

	}

	// Setup resources for a Depth Texture for a FBO (needs an extension)
	/**
	 * @param {WebGLFramebuffer} framebuffer 
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 */
	setupDepthTexture( framebuffer, renderTarget ) {

		const isCube = ( renderTarget && renderTarget.isWebGLCubeRenderTarget );
		if ( isCube ) throw new Error( 'Depth Texture with cube render targets is not supported' );

		this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, framebuffer );

		if ( ! ( renderTarget.depthTexture && renderTarget.depthTexture.isDepthTexture ) ) {

			throw new Error( 'renderTarget.depthTexture must be an instance of THREE.DepthTexture' );

		}

		// upload an empty depth texture with framebuffer size
		if ( ! this.properties.get( renderTarget.depthTexture ).__webglTexture ||
				renderTarget.depthTexture.image.width !== renderTarget.width ||
				renderTarget.depthTexture.image.height !== renderTarget.height ) {

			renderTarget.depthTexture.image.width = renderTarget.width;
			renderTarget.depthTexture.image.height = renderTarget.height;
			renderTarget.depthTexture.needsUpdate = true;

		}

		this.setTexture2D( renderTarget.depthTexture, 0 );

		const webglDepthTexture = this.properties.get( renderTarget.depthTexture ).__webglTexture;

		if ( renderTarget.depthTexture.format === DepthFormat ) {

			this._gl.framebufferTexture2D( this._gl.FRAMEBUFFER, this._gl.DEPTH_ATTACHMENT, this._gl.TEXTURE_2D, webglDepthTexture, 0 );

		} else if ( renderTarget.depthTexture.format === DepthStencilFormat ) {

			this._gl.framebufferTexture2D( this._gl.FRAMEBUFFER, this._gl.DEPTH_STENCIL_ATTACHMENT, this._gl.TEXTURE_2D, webglDepthTexture, 0 );

		} else {

			throw new Error( 'Unknown depthTexture format' );

		}

	}

	// Setup GL resources for a non-texture depth buffer
	/**
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 */
	setupDepthRenderbuffer( renderTarget ) {

		const renderTargetProperties = this.properties.get( renderTarget );

		const isCube = ( renderTarget.isWebGLCubeRenderTarget === true );

		if ( renderTarget.depthTexture ) {

			if ( isCube ) throw new Error( 'target.depthTexture not supported in Cube render targets' );

			this.setupDepthTexture( renderTargetProperties.__webglFramebuffer, renderTarget );

		} else {

			if ( isCube ) {

				renderTargetProperties.__webglDepthbuffer = [];

				for ( let i = 0; i < 6; i ++ ) {

					this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, renderTargetProperties.__webglFramebuffer[ i ] );
					renderTargetProperties.__webglDepthbuffer[ i ] = this._gl.createRenderbuffer();
					this.setupRenderBufferStorage( renderTargetProperties.__webglDepthbuffer[ i ], renderTarget, false );

				}

			} else {

				this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, renderTargetProperties.__webglFramebuffer );
				renderTargetProperties.__webglDepthbuffer = this._gl.createRenderbuffer();
				this.setupRenderBufferStorage( renderTargetProperties.__webglDepthbuffer, renderTarget, false );

			}

		}

		this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, null );

	}

	// Set up GL resources for the render target
	/**
	 * @suppress {checkTypes} 
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 */
	setupRenderTarget( renderTarget ) {

		const texture = renderTarget.texture;

		const renderTargetProperties = this.properties.get( renderTarget );
		const textureProperties = this.properties.get( texture );

		renderTarget.addEventListener( 'dispose', this.onRenderTargetDispose );

		textureProperties.__webglTexture = this._gl.createTexture();

		this.info.memory.textures ++;

		const isCube = ( renderTarget.isWebGLCubeRenderTarget === true );
		const isMultisample = ( renderTarget.isWebGLMultisampleRenderTarget === true );
		const isRenderTarget3D = texture.isDataTexture3D || texture.isDataTexture2DArray;
		/** @type {number} */	
		const supportsMips = this.isPowerOfTwo( renderTarget ) || this.isWebGL2;

		// Handles WebGL2 RGBFormat fallback - #18858

		if ( this.isWebGL2 && texture.format === RGBFormat && ( texture.type === FloatType || texture.type === HalfFloatType ) ) {

			texture.format = RGBAFormat;

			console.warn( 'THREE.WebGLRenderer: Rendering to textures with RGB format is not supported. Using RGBA format instead.' );

		}

		// Setup framebuffer

		if ( isCube ) {

			renderTargetProperties.__webglFramebuffer = [];

			for ( let i = 0; i < 6; i ++ ) {

				renderTargetProperties.__webglFramebuffer[ i ] = this._gl.createFramebuffer();

			}

		} else {

			renderTargetProperties.__webglFramebuffer = this._gl.createFramebuffer();

			if ( isMultisample ) {

				if ( this.isWebGL2 ) {

					renderTargetProperties.__webglMultisampledFramebuffer = this._gl.createFramebuffer();
					renderTargetProperties.__webglColorRenderbuffer = this._gl.createRenderbuffer();

					this._gl.bindRenderbuffer( this._gl.RENDERBUFFER, renderTargetProperties.__webglColorRenderbuffer );

					/** @type {number} */
					const glFormat = this.utils.convert( texture.format );
					/** @type {number} */
					const glType = this.utils.convert( texture.type );
					/** @type {number} */
					const glInternalFormat = this.getInternalFormat( texture.internalFormat, glFormat, glType );
					const samples = this.getRenderTargetSamples( renderTarget );
					this._gl.renderbufferStorageMultisample( this._gl.RENDERBUFFER, samples, glInternalFormat, renderTarget.width, renderTarget.height );

					this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, renderTargetProperties.__webglMultisampledFramebuffer );
					this._gl.framebufferRenderbuffer( this._gl.FRAMEBUFFER, this._gl.COLOR_ATTACHMENT0, this._gl.RENDERBUFFER, renderTargetProperties.__webglColorRenderbuffer );
					this._gl.bindRenderbuffer( this._gl.RENDERBUFFER, null );

					if ( renderTarget.depthBuffer ) {

						renderTargetProperties.__webglDepthRenderbuffer = this._gl.createRenderbuffer();
						this.setupRenderBufferStorage( renderTargetProperties.__webglDepthRenderbuffer, renderTarget, true );

					}

					this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, null );


				} else {

					console.warn( 'THREE.WebGLRenderer: WebGLMultisampleRenderTarget can only be used with WebGL2.' );

				}

			}

		}

		// Setup color buffer

		if ( isCube ) {

			this.state.bindTexture( this._gl.TEXTURE_CUBE_MAP, textureProperties.__webglTexture );
			this.setTextureParameters( this._gl.TEXTURE_CUBE_MAP, texture, supportsMips );

			for ( let i = 0; i < 6; i ++ ) {

				this.setupFrameBufferTexture( renderTargetProperties.__webglFramebuffer[ i ], renderTarget, this._gl.COLOR_ATTACHMENT0, this._gl.TEXTURE_CUBE_MAP_POSITIVE_X + i );

			}

			if ( this.textureNeedsGenerateMipmaps( texture, supportsMips ) ) {

				this.generateMipmap( this._gl.TEXTURE_CUBE_MAP, texture, renderTarget.width, renderTarget.height );

			}

			this.state.bindTexture( this._gl.TEXTURE_CUBE_MAP, null );

		} else {

			let glTextureType = this._gl.TEXTURE_2D;

			if ( isRenderTarget3D ) {

				// Render targets containing layers, i.e: Texture 3D and 2d arrays

				if ( this.isWebGL2 ) {

					const isTexture3D = texture.isDataTexture3D;
					glTextureType = isTexture3D ? this._gl.TEXTURE_3D : this._gl.TEXTURE_2D_ARRAY;

				} else {

					console.warn( 'THREE.DataTexture3D and THREE.DataTexture2DArray only supported with WebGL2.' );

				}

			}

			this.state.bindTexture( glTextureType, textureProperties.__webglTexture );
			this.setTextureParameters( glTextureType, texture, supportsMips );
			this.setupFrameBufferTexture( renderTargetProperties.__webglFramebuffer, renderTarget, this._gl.COLOR_ATTACHMENT0, glTextureType );

			if ( this.textureNeedsGenerateMipmaps( texture, supportsMips ) ) {

				this.generateMipmap( this._gl.TEXTURE_2D, texture, renderTarget.width, renderTarget.height );

			}

			this.state.bindTexture( this._gl.TEXTURE_2D, null );

		}

		// Setup depth and stencil buffers

		if ( renderTarget.depthBuffer ) {

			this.setupDepthRenderbuffer( renderTarget );

		}

	}

	/**
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 */
	updateRenderTargetMipmap( renderTarget ) {

		const texture = renderTarget.texture;

		const supportsMips = this.isPowerOfTwo( renderTarget ) || this.isWebGL2;

		if ( this.textureNeedsGenerateMipmaps( texture, supportsMips ) ) {

			const target = renderTarget.isWebGLCubeRenderTarget ? this._gl.TEXTURE_CUBE_MAP : this._gl.TEXTURE_2D;
			const webglTexture = this.properties.get( texture ).__webglTexture;

			this.state.bindTexture( target, webglTexture );
			this.generateMipmap( target, texture, renderTarget.width, renderTarget.height );
			this.state.bindTexture( target, null );

		}

	}

	/**
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 */
	updateMultisampleRenderTarget( renderTarget ) {

		if ( renderTarget.isWebGLMultisampleRenderTarget ) {

			if ( this.isWebGL2 ) {

				const renderTargetProperties = this.properties.get( renderTarget );

				this._gl.bindFramebuffer( this._gl.READ_FRAMEBUFFER, renderTargetProperties.__webglMultisampledFramebuffer );
				this._gl.bindFramebuffer( this._gl.DRAW_FRAMEBUFFER, renderTargetProperties.__webglFramebuffer );

				const width = renderTarget.width;
				const height = renderTarget.height;
				let mask = this._gl.COLOR_BUFFER_BIT;

				if ( renderTarget.depthBuffer ) mask |= this._gl.DEPTH_BUFFER_BIT;
				if ( renderTarget.stencilBuffer ) mask |= this._gl.STENCIL_BUFFER_BIT;

				this._gl.blitFramebuffer( 0, 0, width, height, 0, 0, width, height, mask, this._gl.NEAREST );

				this._gl.bindFramebuffer( this._gl.FRAMEBUFFER, renderTargetProperties.__webglMultisampledFramebuffer ); // see #18905

			} else {

				console.warn( 'THREE.WebGLRenderer: WebGLMultisampleRenderTarget can only be used with WebGL2.' );

			}

		}

	}

	/**
	 * @param {WebGLRenderTargetInterface} renderTarget 
	 * @return {number}
	 */
	getRenderTargetSamples( renderTarget ) {

		return ( this.isWebGL2 && renderTarget.isWebGLMultisampleRenderTarget ) ?
			Math.min( this.maxSamples, renderTarget.samples ) : 0;

	}

	/**
	 * 
	 * @param {TextureInterface} texture 
	 * @param {number} slot 
	 */
    updateVideoTexture( texture ) {

		const frame = this.info.render.frame;

		// Check the last frame we updated the VideoTexture

		if ( this._videoTextures.get( texture ) !== frame ) {

			this._videoTextures.set( texture, frame );
			texture.update();

		}

	}

	// backwards compatibility
	/**
	 * 
	 * @param {WebGLRenderTargetInterface} texture 
	 * @param {number} slot 
	 */
	safeSetTexture2D( texture, slot ) {

		if ( texture && texture.isWebGLRenderTarget ) {

			if (this. warnedTexture2D === false ) {

				console.warn( 'THREE.WebGLTextures.safeSetTexture2D: don\'t use render targets as textures. Use their .texture property instead.' );
				this.warnedTexture2D = true;

			}

			texture = texture.texture;

		}

		this.setTexture2D( texture, slot );

	}

	/**
	 * 
	 * @param {WebGLRenderTargetInterface} texture 
	 * @param {number} slot 
	 */
	safeSetTextureCube( texture, slot ) {

		if ( texture && texture.isWebGLCubeRenderTarget ) {

			if ( this.warnedTextureCube === false ) {

				console.warn( 'THREE.WebGLTextures.safeSetTextureCube: don\'t use cube render targets as textures. Use their .texture property instead.' );
				this.warnedTextureCube = true;

			}

			texture = texture.texture;

		}


		this.setTextureCube( texture, slot );

	}


}

export { WebGLTextures };
