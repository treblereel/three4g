import { BackSide, DoubleSide, CubeUVRefractionMapping, CubeUVReflectionMapping, LinearEncoding, ObjectSpaceNormalMap, TangentSpaceNormalMap, NoToneMapping } from '../../constants.js';
import { WebGLProgram } from './WebGLProgram.js';
import { ShaderLib } from '../shaders/ShaderLib.js';
import { UniformsUtils } from '../shaders/UniformsUtils.js';

import { WebGLRenderer } from './../WebGLRenderer.js';
import { WebGLCapabilities } from './WebGLCapabilities.js';
import { WebGLCubeMaps } from './WebGLCubeMaps.js';
import { WebGLExtensions } from './WebGLExtensions.js';
import { WebGLClipping } from './WebGLClipping.js';
import { WebGLBindingStates } from './WebGLBindingStates.js';
import { Scene } from './../../scenes/Scene.js';
import { MaterialInterface } from '../../closure/material/MaterialInterface.js';
import { ShaderMaterialParameters } from '../../closure/material/ShaderMaterialParameters.js';
import { Object3DInterface } from '../../closure/core/Object3DInterface.js';

class WebGLPrograms {

	/**
	 * @param {WebGLRenderer} renderer 
	 * @param {WebGLCubeMaps} cubemaps 
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLCapabilities} capabilities 
	 * @param {WebGLBindingStates} bindingStates 
	 * @param {WebGLClipping} clipping 
	 */
	constructor( renderer, cubemaps, extensions, capabilities, bindingStates, clipping ) {

		/** @type {WebGLRenderer} */
		this.renderer = renderer;
		/** @type {WebGLCubeMaps} */
		this.cubemaps = cubemaps;
		/** @type {WebGLExtensions} */
		this.extensions = extensions;
		/** @type {WebGLCapabilities} */
		this.capabilities = capabilities;
		/** @type {WebGLBindingStates} */
		this.bindingStates = bindingStates;
		/** @type {WebGLClipping} */
		this.clipping = clipping;

		/** @const */
		this.programs = [];

		/** @const */
		this.isWebGL2 = capabilities.isWebGL2;

		/** @const */

		this.logarithmicDepthBuffer = capabilities.logarithmicDepthBuffer;

		/** @const */
		this.floatVertexTextures = capabilities.floatVertexTextures;

		/** @const */
		this.maxVertexUniforms = capabilities.maxVertexUniforms;

		/** @const */
		this.vertexTextures = capabilities.vertexTextures;


		this.precision = capabilities.precision;

		/**
		 *  @const
		 *  @type {Object<string,string>}
		 */
		this.shaderIDs = {
			'MeshDepthMaterial': 'depth',
			'MeshDistanceMaterial': 'distanceRGBA',
			'MeshNormalMaterial': 'normal',
			'MeshBasicMaterial': 'basic',
			'MeshLambertMaterial': 'lambert',
			'MeshPhongMaterial': 'phong',
			'MeshToonMaterial': 'toon',
			'MeshStandardMaterial': 'physical',
			'MeshPhysicalMaterial': 'physical',
			'MeshMatcapMaterial': 'matcap',
			'LineBasicMaterial': 'basic',
			'LineDashedMaterial': 'dashed',
			'PointsMaterial': 'points',
			'ShadowMaterial': 'shadow',
			'SpriteMaterial': 'sprite'
		};

		/** @const */
		this.parameterNames = [
			'precision', 'isWebGL2', 'supportsVertexTextures', 'outputEncoding', 'instancing', 'instancingColor',
			'map', 'mapEncoding', 'matcap', 'matcapEncoding', 'envMap', 'envMapMode', 'envMapEncoding', 'envMapCubeUV',
			'lightMap', 'lightMapEncoding', 'aoMap', 'emissiveMap', 'emissiveMapEncoding', 'bumpMap', 'normalMap', 'objectSpaceNormalMap', 'tangentSpaceNormalMap', 'clearcoatMap', 'clearcoatRoughnessMap', 'clearcoatNormalMap', 'displacementMap', 'specularMap',
			'roughnessMap', 'metalnessMap', 'gradientMap',
			'alphaMap', 'combine', 'vertexColors', 'vertexTangents', 'vertexUvs', 'uvsVertexOnly', 'fog', 'useFog', 'fogExp2',
			'flatShading', 'sizeAttenuation', 'logarithmicDepthBuffer', 'skinning',
			'maxBones', 'useVertexTexture', 'morphTargets', 'morphNormals',
			'maxMorphTargets', 'maxMorphNormals', 'premultipliedAlpha',
			'numDirLights', 'numPointLights', 'numSpotLights', 'numHemiLights', 'numRectAreaLights',
			'numDirLightShadows', 'numPointLightShadows', 'numSpotLightShadows',
			'shadowMapEnabled', 'shadowMapType', 'toneMapping', 'physicallyCorrectLights',
			'alphaTest', 'doubleSided', 'flipSided', 'numClippingPlanes', 'numClipIntersection', 'depthPacking', 'dithering',
			'sheen', 'transmissionMap'
		];

	}	

	getMaxBones( object ) {

		const skeleton = object.skeleton;
		const bones = skeleton.bones;

		if ( this.floatVertexTextures ) {

			return 1024;

		} else {

			// default for when object is not specified
			// ( for example when prebuilding shader to be used with multiple objects )
			//
			//  - leave some extra space for other uniforms
			//  - limit here is ANGLE's 254 max uniform vectors
			//    (up to 54 should be safe)

			const nVertexUniforms = this.maxVertexUniforms;
			const nVertexMatrices = Math.floor( ( nVertexUniforms - 20 ) / 4 );

			const maxBones = Math.min( nVertexMatrices, bones.length );

			if ( maxBones < bones.length ) {

				console.warn( 'THREE.WebGLRenderer: Skeleton has ' + bones.length + ' bones. This GPU supports ' + maxBones + '.' );
				return 0;

			}

			return maxBones;

		}

	}

	/**
	 * 
	 * @param {*} map
	 * @return {number}
	 */
	getTextureEncodingFromMap( map ) {

		let encoding;

		if ( map && map.isTexture ) {

			encoding = map.encoding;

		} else if ( map && map.isWebGLRenderTarget ) {

			console.warn( 'THREE.WebGLPrograms.getTextureEncodingFromMap: don\'t use render targets as textures. Use their .texture property instead.' );
			encoding = map.texture.encoding;

		} else {

			encoding = LinearEncoding;

		}

		return encoding;

	}

	/**
	 * 
	 * @param {MaterialInterface} material 
	 * @param {*} lights 
	 * @param {Array} shadows 
	 * @param {Scene} scene 
	 * @param {Object3DInterface} object 
	 * @return {Object}
	 */
	getParameters( material, lights, shadows, scene, object ) {

		const fog = scene.fog;
		const environment = material.isMeshStandardMaterial ? scene.environment : null;

		const envMap = this.cubemaps.get( material.envMap || environment );

		const shaderID = this.shaderIDs[ material.type ];

		// heuristics to create shader parameters according to lights in the scene
		// (not to blow over maxLights budget)

		const maxBones = object.isSkinnedMesh ? this.getMaxBones( object ) : 0;

		if ( material.precision !== null ) {

			this.precision = this.capabilities.getMaxPrecision( material.precision );

			if ( this.precision !== material.precision ) {

				console.warn( 'THREE.WebGLProgram.getParameters:', material.precision, 'not supported, using', this.precision, 'instead.' );

			}

		}

		let vertexShader, fragmentShader;

		if ( shaderID ) {
			console.log('TODO ' + shaderID)
			const shader = ShaderLib.get(shaderID);

			vertexShader = shader.vertexShader;
			fragmentShader = shader.fragmentShader;

		} else {

			vertexShader = material.vertexShader;
			fragmentShader = material.fragmentShader;

		}

		const currentRenderTarget = this.renderer.getRenderTarget();

		const parameters = {

			isWebGL2: this.isWebGL2,

			shaderID: shaderID,
			shaderName: material.type,

			vertexShader: vertexShader,
			fragmentShader: fragmentShader,
			defines: material.defines,

			isRawShaderMaterial: material.isRawShaderMaterial === true,
			glslVersion: material.glslVersion,

			precision: this.precision,

			instancing: object.isInstancedMesh === true,
			instancingColor: object.isInstancedMesh === true && object.instanceColor !== null,

			supportsVertexTextures: this.vertexTextures,
			outputEncoding: ( currentRenderTarget !== null ) ? this.getTextureEncodingFromMap( currentRenderTarget.texture ) : this.renderer.outputEncoding,
			map: !! material.map,
			mapEncoding: this.getTextureEncodingFromMap( material.map ),
			matcap: !! material.matcap,
			matcapEncoding: this.getTextureEncodingFromMap( material.matcap ),
			envMap: !! envMap,
			envMapMode: envMap && envMap.mapping,
			envMapEncoding: this.getTextureEncodingFromMap( envMap ),
			envMapCubeUV: ( !! envMap ) && ( ( envMap.mapping === CubeUVReflectionMapping ) || ( envMap.mapping === CubeUVRefractionMapping ) ),
			lightMap: !! material.lightMap,
			lightMapEncoding: this.getTextureEncodingFromMap( material.lightMap ),
			aoMap: !! material.aoMap,
			emissiveMap: !! material.emissiveMap,
			emissiveMapEncoding: this.getTextureEncodingFromMap( material.emissiveMap ),
			bumpMap: !! material.bumpMap,
			normalMap: !! material.normalMap,
			objectSpaceNormalMap: material.normalMapType === ObjectSpaceNormalMap,
			tangentSpaceNormalMap: material.normalMapType === TangentSpaceNormalMap,
			clearcoatMap: !! material.clearcoatMap,
			clearcoatRoughnessMap: !! material.clearcoatRoughnessMap,
			clearcoatNormalMap: !! material.clearcoatNormalMap,
			displacementMap: !! material.displacementMap,
			roughnessMap: !! material.roughnessMap,
			metalnessMap: !! material.metalnessMap,
			specularMap: !! material.specularMap,
			alphaMap: !! material.alphaMap,

			gradientMap: !! material.gradientMap,

			sheen: !! material.sheen,

			transmissionMap: !! material.transmissionMap,

			combine: material.combine,

			vertexTangents: ( material.normalMap && material.vertexTangents ),
			vertexColors: material.vertexColors,
			vertexUvs: !! material.map || !! material.bumpMap || !! material.normalMap || !! material.specularMap || !! material.alphaMap || !! material.emissiveMap || !! material.roughnessMap || !! material.metalnessMap || !! material.clearcoatMap || !! material.clearcoatRoughnessMap || !! material.clearcoatNormalMap || !! material.displacementMap || !! material.transmissionMap,
			uvsVertexOnly: ! ( !! material.map || !! material.bumpMap || !! material.normalMap || !! material.specularMap || !! material.alphaMap || !! material.emissiveMap || !! material.roughnessMap || !! material.metalnessMap || !! material.clearcoatNormalMap || !! material.transmissionMap ) && !! material.displacementMap,

			fog: !! fog,
			useFog: material.fog,
			fogExp2: ( fog && fog.isFogExp2 ),

			flatShading: !! material.flatShading,

			sizeAttenuation: material.sizeAttenuation,
			logarithmicDepthBuffer: this.logarithmicDepthBuffer,

			skinning: material.skinning && maxBones > 0,
			maxBones: maxBones,
			useVertexTexture: this.floatVertexTextures,

			morphTargets: material.morphTargets,
			morphNormals: material.morphNormals,
			maxMorphTargets: this.renderer.maxMorphTargets,
			maxMorphNormals: this.renderer.maxMorphNormals,

			numDirLights: lights.directional.length,
			numPointLights: lights.point.length,
			numSpotLights: lights.spot.length,
			numRectAreaLights: lights.rectArea.length,
			numHemiLights: lights.hemi.length,

			numDirLightShadows: lights.directionalShadowMap.length,
			numPointLightShadows: lights.pointShadowMap.length,
			numSpotLightShadows: lights.spotShadowMap.length,

			numClippingPlanes: this.clipping.numPlanes,
			numClipIntersection: this.clipping.numIntersection,

			dithering: material.dithering,

			shadowMapEnabled: this.renderer.shadowMap.enabled && shadows.length > 0,
			shadowMapType: this.renderer.shadowMap.type,

			toneMapping: material.toneMapped ? this.renderer.toneMapping : NoToneMapping,
			physicallyCorrectLights: this.renderer.physicallyCorrectLights,

			premultipliedAlpha: material.premultipliedAlpha,

			alphaTest: material.alphaTest,
			doubleSided: material.side === DoubleSide,
			flipSided: material.side === BackSide,

			depthPacking: ( material.depthPacking !== undefined ) ? material.depthPacking : false,

			index0AttributeName: material.index0AttributeName,

			extensionDerivatives: material.extensions && material.extensions.derivatives,
			extensionFragDepth: material.extensions && material.extensions.fragDepth,
			extensionDrawBuffers: material.extensions && material.extensions.drawBuffers,
			extensionShaderTextureLOD: material.extensions && material.extensions.shaderTextureLOD,

			rendererExtensionFragDepth: this.isWebGL2 || this.extensions.has( 'EXT_frag_depth' ),
			rendererExtensionDrawBuffers: this.isWebGL2 || this.extensions.has( 'WEBGL_draw_buffers' ),
			rendererExtensionShaderTextureLod: this.isWebGL2 || this.extensions.has( 'EXT_shader_texture_lod' ),

			customProgramCacheKey: material.customProgramCacheKey()

		};

		return parameters;

	}

	/**
	 * 
	 * @param {ShaderMaterialParameters} parameters
	 * @return {string} 
	 */
	getProgramCacheKey( parameters ) {

		const array = [];

		if ( parameters.shaderID ) {

			array.push( parameters.shaderID );

		} else {

			array.push( parameters.fragmentShader );
			array.push( parameters.vertexShader );

		}

		if ( parameters.defines !== undefined ) {

			for ( const name in parameters.defines ) {

				array.push( name );
				array.push( parameters.defines[ name ] );

			}

		}

		if ( parameters.isRawShaderMaterial === false ) {

			for ( let i = 0; i < this.parameterNames.length; i ++ ) {

				array.push( parameters[ this.parameterNames[ i ] ] );

			}

			array.push( this.renderer.outputEncoding );
			array.push( this.renderer.gammaFactor );

		}

		array.push( parameters.customProgramCacheKey );

		return array.join();

	}

	/**
	 * 
	 * @param {MaterialInterface} material 
	 * @return {Object}
	 */
	getUniforms( material ) {

		const shaderID = this.shaderIDs[ material.type ];
		let uniforms;

		if ( shaderID ) {
			console.log('GET ' + shaderID)
			const shader = ShaderLib.get(shaderID);
			uniforms = UniformsUtils.clone( shader.uniforms );

		} else {

			uniforms = material.uniforms;

		}

		return uniforms;

	}

	/**
	 * 
	 * @param {*} parameters 
	 * @param {string} cacheKey 
	 */
	acquireProgram( parameters, cacheKey ) {

		let program;

		// Check if code has been already compiled
		for ( let p = 0, pl = this.programs.length; p < pl; p ++ ) {

			const preexistingProgram = this.programs[ p ];

			if ( preexistingProgram.cacheKey === cacheKey ) {

				program = preexistingProgram;
				++ program.usedTimes;

				break;

			}

		}

		if ( program === undefined ) {

			program = new WebGLProgram( this.renderer, cacheKey, parameters, this.bindingStates );
			this.programs.push( program );

		}

		return program;

	}

	/**
	 * 
	 * @param {WebGLProgram} program 
	 */
	releaseProgram( program ) {

		if ( -- program.usedTimes === 0 ) {

			// Remove from unordered set
			const i = this.programs.indexOf( program );
			this.programs[ i ] = this.programs[ this.programs.length - 1 ];
			this.programs.pop();

			// Free WebGL resources
			program.destroy();

		}

	}

}


export { WebGLPrograms };
