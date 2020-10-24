import { EventDispatcher } from '../core/EventDispatcher.js';
import {
	MirroredRepeatWrapping,
	ClampToEdgeWrapping,
	RepeatWrapping,
	LinearEncoding,
	UnsignedByteType,
	RGBAFormat,
	LinearMipmapLinearFilter,
	LinearFilter,
	UVMapping
} from '../constants.js';
import { MathUtils } from '../math/MathUtils.js';
import { Vector2 } from '../math/Vector2.js';
import { Matrix3 } from '../math/Matrix3.js';
import { ImageUtils } from '../extras/ImageUtils.js';

/** @type {number} */
let textureId = 0;

class Texture extends EventDispatcher {

	/**
	* @param {Image=} image
	* @param {number=} mapping
	* @param {number=} wrapS
	* @param {number=} wrapT
	* @param {number=} magFilter
	* @param {number=} minFilter
	* @param {number=} format
	* @param {number=} type
	* @param {number=} anisotropy
	* @param {number=} encoding
	*/
	constructor( image = Texture.DEFAULT_IMAGE, mapping = Texture.DEFAULT_MAPPING, wrapS = ClampToEdgeWrapping, wrapT = ClampToEdgeWrapping, magFilter = LinearFilter, minFilter = LinearMipmapLinearFilter, format = RGBAFormat, type = UnsignedByteType, anisotropy = 1, encoding = LinearEncoding ) {

		super();

		//Object.defineProperty( this, 'id', { value: textureId ++ } );
		/** @type {number} */
		this.id = textureId ++;

		/** @type {string} */
		this.uuid = MathUtils.generateUUID();

		this.name = '';

		/** @type {Image|HTMLImageElement|{width: number, height: number, depth: number}|undefined} */
		this.image = image;
		this.mipmaps = [];
		/** @type {number} */
		this.mapping = mapping;
		/** @type {number} */
		this.wrapS = wrapS;
		/** @type {number} */
		this.wrapT = wrapT;
		/** @type {number} */
		this.magFilter = magFilter;
		/** @type {number} */
		this.minFilter = minFilter;
		/** @type {number} */
		this.anisotropy = anisotropy;
		/** @type {number} */
		this.format = format;
		this.internalFormat = null;
		/** @type {number} */
		this.type = type;

		/** @type {Vector2} */
		this.offset = new Vector2( 0, 0 );
		/** @type {Vector2} */
		this.repeat = new Vector2( 1, 1 );
		/** @type {Vector2} */
		this.center = new Vector2( 0, 0 );
		/** @type {number} */
		this.rotation = 0;

		/** @type {boolean} */
		this.matrixAutoUpdate = true;
		/** @type {Matrix3} */
		this.matrix = new Matrix3();

		/** @type {boolean} */
		this.generateMipmaps = true;
		/** @type {boolean} */
		this.premultiplyAlpha = false;
		/** @type {boolean} */
		this.flipY = true;
		/** @type {number} */
		this.unpackAlignment = 4;	// valid values: 1, 2, 4, 8 (see http://www.khronos.org/opengles/sdk/docs/man/xhtml/glPixelStorei.xml)

		// Values of encoding !== THREE.LinearEncoding only supported on map, envMap and emissiveMap.
		//
		// Also changing the encoding after already used by a Material will not automatically make the Material
		// update. You need to explicitly call Material.needsUpdate to trigger it to recompile.
		/** @type {number} */
		this.encoding = encoding;
		/** @type {number} */
		this.version = 0;
		this.onUpdate = null;

	}

	updateMatrix() {

		this.matrix.setUvTransform( this.offset.x, this.offset.y, this.repeat.x, this.repeat.y, this.rotation, this.center.x, this.center.y );

	}

	/**
	 * @return {Texture}
	 */
	clone() {

		return new this.constructor().copy( this );

	}

	/**
	 * 
	 * @param {Texture} source 
	 * @return {Texture}
	 */
	copy( source ) {

		this.name = source.name;

		this.image = source.image;
		this.mipmaps = source.mipmaps.slice( 0 );

		this.mapping = source.mapping;

		this.wrapS = source.wrapS;
		this.wrapT = source.wrapT;

		this.magFilter = source.magFilter;
		this.minFilter = source.minFilter;

		this.anisotropy = source.anisotropy;

		this.format = source.format;
		this.internalFormat = source.internalFormat;
		this.type = source.type;

		this.offset.copy( source.offset );
		this.repeat.copy( source.repeat );
		this.center.copy( source.center );
		this.rotation = source.rotation;

		this.matrixAutoUpdate = source.matrixAutoUpdate;
		this.matrix.copy( source.matrix );

		this.generateMipmaps = source.generateMipmaps;
		this.premultiplyAlpha = source.premultiplyAlpha;
		this.flipY = source.flipY;
		this.unpackAlignment = source.unpackAlignment;
		this.encoding = source.encoding;

		return this;

	}

	/**
	 * @param {Object= } meta 
   	 * @suppress{checkTypes}
	 */
	toJSON( meta ) {

		const isRootObject = ( meta === undefined || typeof meta === 'string' );

		if ( ! isRootObject && meta.textures[ this.uuid ] !== undefined ) {
			return meta.textures[ this.uuid ];

		}

		const output = {

			metadata: {
				version: 4.5,
				type: 'Texture',
				generator: 'Texture.toJSON'
			},

			uuid: this.uuid,
			name: this.name,

			mapping: this.mapping,

			repeat: [ this.repeat.x, this.repeat.y ],
			offset: [ this.offset.x, this.offset.y ],
			center: [ this.center.x, this.center.y ],
			rotation: this.rotation,

			wrap: [ this.wrapS, this.wrapT ],

			format: this.format,
			type: this.type,
			encoding: this.encoding,

			minFilter: this.minFilter,
			magFilter: this.magFilter,
			anisotropy: this.anisotropy,

			flipY: this.flipY,

			premultiplyAlpha: this.premultiplyAlpha,
			unpackAlignment: this.unpackAlignment

		};

		if ( this.image !== undefined ) {

			// TODO: Move to THREE.Image

			const image = this.image;

			if ( image.uuid === undefined ) {

				image.uuid = MathUtils.generateUUID(); // UGH

			}

			if ( ! isRootObject && meta.images[ image.uuid ] === undefined ) {

				let url;

				if ( Array.isArray( image ) ) {

					// process array of images e.g. CubeTexture

					url = [];

					for ( let i = 0, l = image.length; i < l; i ++ ) {

						// check cube texture with data textures

						if ( image[ i ].isDataTexture ) {

							url.push( serializeImage( image[ i ].image ) );

						} else {

							url.push( serializeImage( image[ i ] ) );

						}

					}

				} else {

					// process single image

					url = serializeImage( image );

				}

				meta.images[ image.uuid ] = {
					uuid: image.uuid,
					url: url
				};

			}

			output.image = image.uuid;

		}

		if ( ! isRootObject ) {

			meta.textures[ this.uuid ] = output;

		}

		return output;

	}

	dispose() {

		this.dispatchEvent( { type: 'dispose' } );

	}

	/**
	 * 
	 * @param {Vector2} uv 
	 * @return {Vector2} 
	 */
	transformUv( uv ) {

		if ( this.mapping !== UVMapping ) return uv;

		uv.applyMatrix3( this.matrix );

		if ( uv.x < 0 || uv.x > 1 ) {

			switch ( this.wrapS ) {

				case RepeatWrapping:

					uv.x = uv.x - Math.floor( uv.x );
					break;

				case ClampToEdgeWrapping:

					uv.x = uv.x < 0 ? 0 : 1;
					break;

				case MirroredRepeatWrapping:

					if ( Math.abs( Math.floor( uv.x ) % 2 ) === 1 ) {

						uv.x = Math.ceil( uv.x ) - uv.x;

					} else {

						uv.x = uv.x - Math.floor( uv.x );

					}

					break;

			}

		}

		if ( uv.y < 0 || uv.y > 1 ) {

			switch ( this.wrapT ) {

				case RepeatWrapping:

					uv.y = uv.y - Math.floor( uv.y );
					break;

				case ClampToEdgeWrapping:

					uv.y = uv.y < 0 ? 0 : 1;
					break;

				case MirroredRepeatWrapping:

					if ( Math.abs( Math.floor( uv.y ) % 2 ) === 1 ) {

						uv.y = Math.ceil( uv.y ) - uv.y;

					} else {

						uv.y = uv.y - Math.floor( uv.y );

					}

					break;

			}

		}

		if ( this.flipY ) {

			uv.y = 1 - uv.y;

		}

		return uv;

	}

	set needsUpdate( value ) {

		if ( value === true ) this.version ++;

	}

}

Texture.DEFAULT_IMAGE = undefined;
Texture.DEFAULT_MAPPING = UVMapping;

Texture.prototype.isTexture = true;

/**
 * 
 * @param {HTMLImageElement|HTMLCanvasElement|ImageBitmap} image 
 * @return {string|{data :(*|undefined), width: (number|undefined), height : (number|undefined), type : (string|undefined)}}
 */
function serializeImage( image ) {

	if ( ( typeof HTMLImageElement !== 'undefined' && image instanceof HTMLImageElement ) ||
		( typeof HTMLCanvasElement !== 'undefined' && image instanceof HTMLCanvasElement ) ||
		( typeof ImageBitmap !== 'undefined' && image instanceof ImageBitmap ) ) {

		// default images

		return ImageUtils.getDataURL( image );

	} else {

		if ( image.data ) {

			// images of DataTexture

			return {
				data: Array.prototype.slice.call( image.data ),
				width: image.width,
				height: image.height,
				type: image.data.constructor.name
			};

		} else {

			console.warn( 'THREE.Texture: Unable to serialize Texture.' );
			return {};

		}

	}

}

export { Texture };
