import { EventDispatcher } from '../core/EventDispatcher.js';
import { FrontSide, FlatShading, NormalBlending, LessEqualDepth, AddEquation, OneMinusSrcAlphaFactor, SrcAlphaFactor, AlwaysStencilFunc, KeepStencilOp } from '../constants.js';
import { MathUtils } from '../math/MathUtils.js';
import { Vector2 } from '../math/Vector2.js';

import { Color } from './../math/Color.js';
import { MaterialParameters } from '../closure/material/MaterialParameters.js';
import { MaterialInterface } from '../closure/material/MaterialInterface.js';

/** @type {number} */
let materialId = 0;

class Material extends EventDispatcher {

	constructor() {

		super();

	//Object.defineProperty( this, 'id', { value: materialId ++ } );

		/** @type {number} */
		this.id =  materialId ++;
		/** @type {string} */
		this.uuid = MathUtils.generateUUID();

		/** @type {string} */
		this.name = '';
		/** @type {string} */
		this.type = 'Material';

		/** @type {boolean} */
		this.fog = true;
		/** @type {number} */
		this.blending = NormalBlending;
		/** @type {number} */
		this.side = FrontSide;
		/** @type {boolean} */
		this.vertexColors = false;
		/** @type {number} */
		this.opacity = 1;
		/** @type {boolean} */
		this.transparent = false;
		/** @type {number} */
		this.blendSrc = SrcAlphaFactor;
		/** @type {number} */
		this.blendDst = OneMinusSrcAlphaFactor;
		/** @type {number} */
		this.blendEquation = AddEquation;
		/** @type {number|null} */
		this.blendSrcAlpha = null;
		/** @type {number|null} */
		this.blendDstAlpha = null;
		/** @type {number|null} */
		this.blendEquationAlpha = null;
		/** @type {number} */
		this.depthFunc = LessEqualDepth;
		/** @type {boolean} */
		this.depthTest = true;
		/** @type {boolean} */
		this.depthWrite = true;
		/** @type {number} */
		this.stencilWriteMask = 0xff;
		/** @type {number} */
		this.stencilFunc = AlwaysStencilFunc;
		/** @type {number} */
		this.stencilRef = 0;
		/** @type {number} */
		this.stencilFuncMask = 0xff;
		/** @type {number} */
		this.stencilFail = KeepStencilOp;
		/** @type {number} */
		this.stencilZFail = KeepStencilOp;
		/** @type {number} */
		this.stencilZPass = KeepStencilOp;
		/** @type {boolean} */
		this.stencilWrite = false;

		this.clippingPlanes = null;
		/** @type {boolean} */
		this.clipIntersection = false;
		/** @type {boolean} */
		this.clipShadows = false;

		this.shadowSide = null;
		/** @type {boolean} */
		this.colorWrite = true;

		this.precision = null; // override the renderer's default precision for this material
		/** @type {boolean} */
		this.polygonOffset = false;
		/** @type {number} */
		this.polygonOffsetFactor = 0;
		/** @type {number} */
		this.polygonOffsetUnits = 0;
		/** @type {boolean} */
		this.dithering = false;

		/** @type {number} */
		this.alphaTest = 0;
		/** @type {boolean} */
		this.premultipliedAlpha = false;
		/** @type {boolean} */
		this.visible = true;
		/** @type {boolean} */
		this.toneMapped = true;

		this.userData = {};

		/** @type {number} */
		this.version = 0;
		/** @type {boolean} */
		this.isMaterial = true;
		/** @type {boolean|undefined} */
		this.flatShading;

	}

	onBeforeCompile( /* shaderobject, renderer */ ) {}

	customProgramCacheKey() {

		return this.onBeforeCompile.toString();

	}

	/**
	 * 
	 * @param {Object=} values 
	 */
	setValues( values ) {

		if ( values === undefined ) return;

		for ( const key in values ) {

			const /** @type {number} */ newValue = values[ key ];

			if ( newValue === undefined ) {

				console.warn( 'THREE.Material: \'' + key + '\' parameter is undefined.' );
				continue;

			}

			// for backward compatability if shading is set in the constructor
			if ( key === 'shading' ) {

				console.warn( 'THREE.' + this.type + ': .shading has been removed. Use the boolean .flatShading instead.' );
				this.flatShading = ( newValue === FlatShading ) ? true : false;
				continue;

			}

			/** @type {*} */
			const currentValue = this[ key ];

			if ( currentValue === undefined ) {

				console.warn( 'THREE.' + this.type + ': \'' + key + '\' is not a property of this material.' );
				continue;

			}

			if ( currentValue && currentValue.isColor ) {

				currentValue.set( newValue );

			} else if ( ( currentValue && currentValue.isVector3 ) && ( newValue && newValue.isVector3 ) ) {

				currentValue.copy( newValue );

			} else {

				this[ key ] = newValue;

			}

		}

	}

	/**
	 * //TODO
	* @param {Object=} meta
	* @suppress{checkTypes}
	*/
	toJSON( meta ) {

		const isRoot = ( meta === undefined || typeof meta === 'string' );

		if ( isRoot ) {

			meta = {
				textures: {},
				images: {}
			};

		}

		const data = {
			metadata: {
				version: 4.5,
				type: 'Material',
				generator: 'Material.toJSON'
			}
		};

		/** @type {MaterialInterface} */
		var that = this;

		// standard Material serialization
		data.uuid = that.uuid;
		data.type = that.type;

		if ( that.name !== '' ) data.name = that.name;

		if ( that.color && that.color.isColor ) data.color = that.color.getHex();

		if ( that.roughness !== undefined ) data.roughness = that.roughness;
		if ( that.metalness !== undefined ) data.metalness = that.metalness;

		if ( that.sheen && that.sheen.isColor ) data.sheen = that.sheen.getHex();
		if ( that.emissive && that.emissive.isColor ) data.emissive = that.emissive.getHex();
		if ( that.emissiveIntensity && that.emissiveIntensity !== 1 ) data.emissiveIntensity = that.emissiveIntensity;

		if ( that.specular && that.specular.isColor ) data.specular = that.specular.getHex();
		if ( that.shininess !== undefined ) data.shininess = that.shininess;
		if ( that.clearcoat !== undefined ) data.clearcoat = that.clearcoat;
		if ( that.clearcoatRoughness !== undefined ) data.clearcoatRoughness = that.clearcoatRoughness;

		if ( that.clearcoatMap && that.clearcoatMap.isTexture ) {

			data.clearcoatMap = that.clearcoatMap.toJSON( meta ).uuid;

		}

		if ( that.clearcoatRoughnessMap && that.clearcoatRoughnessMap.isTexture ) {

			data.clearcoatRoughnessMap = that.clearcoatRoughnessMap.toJSON( meta ).uuid;

		}

		if ( that.clearcoatNormalMap && that.clearcoatNormalMap.isTexture ) {

			data.clearcoatNormalMap = that.clearcoatNormalMap.toJSON( meta ).uuid;
			data.clearcoatNormalScale = that.clearcoatNormalScale.toArray();

		}

		if ( that.map && that.map.isTexture ) data.map = that.map.toJSON( meta ).uuid;
		if ( that.matcap && that.matcap.isTexture ) data.matcap = that.matcap.toJSON( meta ).uuid;
		if ( that.alphaMap && that.alphaMap.isTexture ) data.alphaMap = that.alphaMap.toJSON( meta ).uuid;

		if ( that.lightMap && that.lightMap.isTexture ) {

			data.lightMap = that.lightMap.toJSON( meta ).uuid;
			data.lightMapIntensity = that.lightMapIntensity;

		}

		if ( that.aoMap && that.aoMap.isTexture ) {

			data.aoMap = that.aoMap.toJSON( meta ).uuid;
			data.aoMapIntensity = that.aoMapIntensity;

		}

		if ( that.bumpMap && that.bumpMap.isTexture ) {

			data.bumpMap = that.bumpMap.toJSON( meta ).uuid;
			data.bumpScale = that.bumpScale;

		}

		if ( that.normalMap && that.normalMap.isTexture ) {

			data.normalMap = that.normalMap.toJSON( meta ).uuid;
			data.normalMapType = that.normalMapType;
			data.normalScale = that.normalScale.toArray();

		}

		if ( that.displacementMap && that.displacementMap.isTexture ) {

			data.displacementMap = that.displacementMap.toJSON( meta ).uuid;
			data.displacementScale = that.displacementScale;
			data.displacementBias = that.displacementBias;

		}

		if ( that.roughnessMap && that.roughnessMap.isTexture ) data.roughnessMap = that.roughnessMap.toJSON( meta ).uuid;
		if ( that.metalnessMap && that.metalnessMap.isTexture ) data.metalnessMap = that.metalnessMap.toJSON( meta ).uuid;

		if ( that.emissiveMap && that.emissiveMap.isTexture ) data.emissiveMap = that.emissiveMap.toJSON( meta ).uuid;
		if ( that.specularMap && that.specularMap.isTexture ) data.specularMap = that.specularMap.toJSON( meta ).uuid;

		if ( that.envMap && that.envMap.isTexture ) {

			data.envMap = that.envMap.toJSON( meta ).uuid;
			data.reflectivity = that.reflectivity; // Scale behind envMap
			data.refractionRatio = that.refractionRatio;

			if ( that.combine !== undefined ) data.combine = that.combine;
			if ( that.envMapIntensity !== undefined ) data.envMapIntensity = that.envMapIntensity;

		}

		if ( that.gradientMap && that.gradientMap.isTexture ) {

			data.gradientMap = that.gradientMap.toJSON( meta ).uuid;

		}

		if ( that.size !== undefined ) data.size = that.size;
		if ( that.sizeAttenuation !== undefined ) data.sizeAttenuation = that.sizeAttenuation;

		if ( that.blending !== NormalBlending ) data.blending = that.blending;
		if ( that.side !== FrontSide ) data.side = that.side;
		if ( that.vertexColors ) data.vertexColors = true;

		if ( that.opacity < 1 ) data.opacity = that.opacity;
		if ( that.transparent === true ) data.transparent = that.transparent;

		data.depthFunc = that.depthFunc;
		data.depthTest = that.depthTest;
		data.depthWrite = that.depthWrite;

		data.stencilWrite = that.stencilWrite;
		data.stencilWriteMask = that.stencilWriteMask;
		data.stencilFunc = that.stencilFunc;
		data.stencilRef = that.stencilRef;
		data.stencilFuncMask = that.stencilFuncMask;
		data.stencilFail = that.stencilFail;
		data.stencilZFail = that.stencilZFail;
		data.stencilZPass = that.stencilZPass;

		// rotation (SpriteMaterial)
		if ( that.rotation && that.rotation !== 0 ) data.rotation = that.rotation;

		if ( that.polygonOffset === true ) data.polygonOffset = true;
		if ( that.polygonOffsetFactor !== 0 ) data.polygonOffsetFactor = that.polygonOffsetFactor;
		if ( that.polygonOffsetUnits !== 0 ) data.polygonOffsetUnits = that.polygonOffsetUnits;

		if ( that.linewidth && that.linewidth !== 1 ) data.linewidth = that.linewidth;
		if ( that.dashSize !== undefined ) data.dashSize = that.dashSize;
		if ( that.gapSize !== undefined ) data.gapSize = that.gapSize;
		if ( that.scale !== undefined ) data.scale = that.scale;

		if ( that.dithering === true ) data.dithering = true;

		if ( that.alphaTest > 0 ) data.alphaTest = that.alphaTest;
		if ( that.premultipliedAlpha === true ) data.premultipliedAlpha = that.premultipliedAlpha;

		if ( that.wireframe === true ) data.wireframe = that.wireframe;
		if ( that.wireframeLinewidth > 1 ) data.wireframeLinewidth = that.wireframeLinewidth;
		if ( that.wireframeLinecap !== 'round' ) data.wireframeLinecap = that.wireframeLinecap;
		if ( that.wireframeLinejoin !== 'round' ) data.wireframeLinejoin = that.wireframeLinejoin;

		if ( that.morphTargets === true ) data.morphTargets = true;
		if ( that.morphNormals === true ) data.morphNormals = true;
		if ( that.skinning === true ) data.skinning = true;

		if ( that.flatShading === true ) data.flatShading = that.flatShading;

		if ( that.visible === false ) data.visible = false;

		if ( that.toneMapped === false ) data.toneMapped = false;

		if ( JSON.stringify( that.userData ) !== '{}' ) data.userData = that.userData;

		// TODO: Copied from Object3D.toJSON

		function extractFromCache( cache ) {

			const values = [];

			for ( const key in cache ) {

				const data = cache[ key ];
				delete data.metadata;
				values.push( data );

			}

			return values;

		}

		if ( isRoot ) {

			const textures = extractFromCache( meta.textures );
			const images = extractFromCache( meta.images );

			if ( textures.length > 0 ) data.textures = textures;
			if ( images.length > 0 ) data.images = images;

		}

		return data;

	}

	/**
	 * @return {Material} 
	 */
	clone() {

		return new this.constructor().copy( this );

	}

	/**
	 * @param {Material} source
	 * @return {Material} 
	 */
	copy( source ) {

		this.name = source.name;

		this.fog = source.fog;

		this.blending = source.blending;
		this.side = source.side;
		this.vertexColors = source.vertexColors;

		this.opacity = source.opacity;
		this.transparent = source.transparent;

		this.blendSrc = source.blendSrc;
		this.blendDst = source.blendDst;
		this.blendEquation = source.blendEquation;
		this.blendSrcAlpha = source.blendSrcAlpha;
		this.blendDstAlpha = source.blendDstAlpha;
		this.blendEquationAlpha = source.blendEquationAlpha;

		this.depthFunc = source.depthFunc;
		this.depthTest = source.depthTest;
		this.depthWrite = source.depthWrite;

		this.stencilWriteMask = source.stencilWriteMask;
		this.stencilFunc = source.stencilFunc;
		this.stencilRef = source.stencilRef;
		this.stencilFuncMask = source.stencilFuncMask;
		this.stencilFail = source.stencilFail;
		this.stencilZFail = source.stencilZFail;
		this.stencilZPass = source.stencilZPass;
		this.stencilWrite = source.stencilWrite;

		const srcPlanes = source.clippingPlanes;
		let dstPlanes = null;

		if ( srcPlanes !== null ) {

			const n = srcPlanes.length;
			dstPlanes = new Array( n );

			for ( let i = 0; i !== n; ++ i ) {

				dstPlanes[ i ] = srcPlanes[ i ].clone();

			}

		}

		this.clippingPlanes = dstPlanes;
		this.clipIntersection = source.clipIntersection;
		this.clipShadows = source.clipShadows;

		this.shadowSide = source.shadowSide;

		this.colorWrite = source.colorWrite;

		this.precision = source.precision;

		this.polygonOffset = source.polygonOffset;
		this.polygonOffsetFactor = source.polygonOffsetFactor;
		this.polygonOffsetUnits = source.polygonOffsetUnits;

		this.dithering = source.dithering;

		this.alphaTest = source.alphaTest;
		this.premultipliedAlpha = source.premultipliedAlpha;

		this.visible = source.visible;

		this.toneMapped = source.toneMapped;

		this.userData = JSON.parse( JSON.stringify( source.userData ) );

		return this;

	}

	dispose() {

		this.dispatchEvent( { type: 'dispose' } );

	}

}

Object.defineProperty( Material.prototype, 'needsUpdate', {

	set( value ) {

		if ( value === true ) this.version ++;

	}

} );

export { Material };
