import { FrontSide, BackSide, DoubleSide, RGBAFormat, NearestFilter, LinearFilter, PCFShadowMap, VSMShadowMap, RGBADepthPacking, NoBlending } from '../../constants.js';
import { WebGLRenderTarget } from '../WebGLRenderTarget.js';
import { MeshDepthMaterial } from '../../materials/MeshDepthMaterial.js';
import { MeshDistanceMaterial } from '../../materials/MeshDistanceMaterial.js';
import { ShaderMaterial } from '../../materials/ShaderMaterial.js';
import { BufferAttribute } from '../../core/BufferAttribute.js';
import { BufferGeometry } from '../../core/BufferGeometry.js';
import { Mesh } from '../../objects/Mesh.js';
import { Vector4 } from '../../math/Vector4.js';
import { Vector2 } from '../../math/Vector2.js';
import { Frustum } from '../../math/Frustum.js';

import vsm_frag from '../shaders/ShaderLib/vsm_frag.glsl.js';
import vsm_vert from '../shaders/ShaderLib/vsm_vert.glsl.js';

// closure compiler
import { Scene } from './../../scenes/Scene.js';
import { WebGLRenderer } from '../WebGLRenderer.js';
import { WebGLObjects } from './WebGLObjects.js';
import { LightInterface } from '../../closure/lights/LightInterface.js';
import { Object3DInterface } from '../../closure/core/Object3DInterface.js';
import { MaterialInterface } from '../../closure/material/MaterialInterface.js';
import { MeshDepthMaterialInterface } from '../../closure/material/MeshDepthMaterialInterface.js';
import { CameraInterface } from '../../closure/cameras/CameraInterface.js';

class WebGLShadowMap {

	/**
	 * 
	 * @param {WebGLRenderer} _renderer 
	 * @param {WebGLObjects} _objects 
	 * @param {number} maxTextureSize 
	 */
	constructor( _renderer, _objects, maxTextureSize ) {

		/** @type {WebGLRenderer} */
		this._renderer = _renderer;
		/** @type {WebGLObjects} */
		this._objects = _objects;
		/** @type {number} */
		this.maxTextureSize = maxTextureSize;
		/** @type {Frustum} */
		this._frustum = new Frustum();
		/** @type {Vector2} */
		this._shadowMapSize = new Vector2();
		/** @type {Vector2} */
		this._viewportSize = new Vector2();
		/** @type {Vector4} */
		this._viewport = new Vector4()

		this._depthMaterials = [];
		this._distanceMaterials = [];

		this._materialCache = {};

		this.shadowSide = { 0: BackSide, 1: FrontSide, 2: DoubleSide };
		/** @type {ShaderMaterial} */
		this.shadowMaterialVertical = new ShaderMaterial( {

			defines: {
				SAMPLE_RATE: 2.0 / 8.0,
				HALF_SAMPLE_RATE: 1.0 / 8.0
			},

			uniforms: {
				shadow_pass: { value: null },
				resolution: { value: new Vector2() },
				radius: { value: 4.0 }
			},

			vertexShader: vsm_vert,

			fragmentShader: vsm_frag

		} );

		/** @type {ShaderMaterial} */
		this.shadowMaterialHorizontal = /** @type {ShaderMaterial} */ (this.shadowMaterialVertical.clone());
		this.shadowMaterialHorizontal.defines.HORIZONTAL_PASS = 1;

		const fullScreenTri = new BufferGeometry();
		fullScreenTri.setAttribute(
			'position',
			new BufferAttribute(
				new Float32Array( [ - 1, - 1, 0.5, 3, - 1, 0.5, - 1, 3, 0.5 ] ),
				3
			)
		);

		this.fullScreenMesh = new Mesh( fullScreenTri, this.shadowMaterialVertical );

		this.enabled = false;

		this.autoUpdate = true;
		this.needsUpdate = false;

		this.type = PCFShadowMap;

	}

	/**
	 * 
	 * @param {Array<LightInterface>} lights 
	 * @param {Scene} scene 
	 * @param {CameraInterface} camera 
	 */
	render( lights, scene, camera ) {

		if ( this.enabled === false ) return;
		if ( this.autoUpdate === false && this.needsUpdate === false ) return;

		if ( lights.length === 0 ) return;

		const currentRenderTarget = this._renderer.getRenderTarget();
		const activeCubeFace = this._renderer.getActiveCubeFace();
		const activeMipmapLevel = this._renderer.getActiveMipmapLevel();

		const _state = this._renderer.state;

		// Set GL state for depth map.
		_state.setBlending( NoBlending );
		_state.buffers.color.setClear( 1, 1, 1, 1 );
		_state.buffers.depth.setTest( true );
		_state.setScissorTest( false );

		// render depth map

		for ( let i = 0, il = lights.length; i < il; i ++ ) {

			/** @type {LightInterface} */
			const light = lights[ i ];
			const shadow = light.shadow;

			if ( shadow === undefined ) {

				console.warn( 'THREE.WebGLShadowMap:', light, 'has no shadow.' );
				continue;

			}

			if ( shadow.autoUpdate === false && shadow.needsUpdate === false ) continue;

			this._shadowMapSize.copy( shadow.mapSize );

			const shadowFrameExtents = shadow.getFrameExtents();

			this._shadowMapSize.multiply( shadowFrameExtents );

			this._viewportSize.copy( shadow.mapSize );

			if ( this._shadowMapSize.x > this.maxTextureSize || this._shadowMapSize.y > this.maxTextureSize ) {

				if ( this._shadowMapSize.x >this. maxTextureSize ) {

					this._viewportSize.x = Math.floor( this.maxTextureSize / shadowFrameExtents.x );
					this._shadowMapSize.x = this._viewportSize.x * shadowFrameExtents.x;
					shadow.mapSize.x = this._viewportSize.x;

				}

				if ( this._shadowMapSize.y > this.maxTextureSize ) {

					this._viewportSize.y = Math.floor( this.maxTextureSize / shadowFrameExtents.y );
					this._shadowMapSize.y = this._viewportSize.y * shadowFrameExtents.y;
					shadow.mapSize.y = this._viewportSize.y;

				}

			}

			if ( shadow.map === null && ! shadow.isPointLightShadow && this.type === VSMShadowMap ) {

				const pars = { minFilter: LinearFilter, magFilter: LinearFilter, format: RGBAFormat };

				shadow.map = new WebGLRenderTarget( this._shadowMapSize.x, this._shadowMapSize.y, pars );
				shadow.map.texture.name = light.name + '.shadowMap';

				shadow.mapPass = new WebGLRenderTarget( this._shadowMapSize.x, this._shadowMapSize.y, pars );

				shadow.camera.updateProjectionMatrix();

			}

			if ( shadow.map === null ) {

				const pars = { minFilter: NearestFilter, magFilter: NearestFilter, format: RGBAFormat };

				shadow.map = new WebGLRenderTarget(this._shadowMapSize.x, this._shadowMapSize.y, pars );
				shadow.map.texture.name = light.name + '.shadowMap';

				shadow.camera.updateProjectionMatrix();

			}

			this._renderer.setRenderTarget( shadow.map );
			this._renderer.clear();

			const viewportCount = shadow.getViewportCount();

			for ( let vp = 0; vp < viewportCount; vp ++ ) {

				const viewport = shadow.getViewport( vp );

				this._viewport.set(
					this._viewportSize.x * viewport.x,
					this._viewportSize.y * viewport.y,
					this._viewportSize.x * viewport.z,
					this._viewportSize.y * viewport.w
				);

				_state.viewport( this._viewport );

				shadow.updateMatrices( light, vp );

				this._frustum = shadow.getFrustum();

				this.renderObject( scene, camera, shadow.camera, light, this.type );

			}

			// do blur pass for VSM

			if ( ! shadow.isPointLightShadow && this.type === VSMShadowMap ) {

				this.VSMPass( shadow, camera );

			}

			shadow.needsUpdate = false;

		}

		this.needsUpdate = false;

		this._renderer.setRenderTarget( currentRenderTarget, activeCubeFace, activeMipmapLevel );

	}

	VSMPass( shadow, camera ) {

		const geometry = this._objects.update( this.fullScreenMesh );

		// vertical pass

		this.shadowMaterialVertical.uniforms.shadow_pass.value = shadow.map.texture;
		this.shadowMaterialVertical.uniforms.resolution.value = shadow.mapSize;
		this.shadowMaterialVertical.uniforms.radius.value = shadow.radius;
		this._renderer.setRenderTarget( shadow.mapPass );
		this._renderer.clear();
		this._renderer.renderBufferDirect( camera, null, geometry, this.shadowMaterialVertical, this.fullScreenMesh, null );

		// horizontal pass

		this.shadowMaterialHorizontal.uniforms.shadow_pass.value = shadow.mapPass.texture;
		this.shadowMaterialHorizontal.uniforms.resolution.value = shadow.mapSize;
		this.shadowMaterialHorizontal.uniforms.radius.value = shadow.radius;
		this._renderer.setRenderTarget( shadow.map );
		this._renderer.clear();
		this._renderer.renderBufferDirect( camera, null, geometry, this.shadowMaterialHorizontal, this.fullScreenMesh, null );

	}

	/**
	 * 
	 * @param {boolean} useMorphing 
	 * @param {boolean} useSkinning 
	 * @param {boolean} useInstancing 
	 * @return {MeshDepthMaterialInterface}
	 */
	getDepthMaterialVariant( useMorphing, useSkinning, useInstancing ) {

		const index = useMorphing << 0 | useSkinning << 1 | useInstancing << 2;

		/** @type {MeshDepthMaterial} */
		let material = this._depthMaterials[ index ];

		if ( material === undefined ) {

			material = new MeshDepthMaterial( {

				depthPacking: RGBADepthPacking,

				morphTargets: useMorphing,
				skinning: useSkinning

			} );

			this._depthMaterials[ index ] = material;

		}

		return material;

	}

	/**
	 * 
	 * @param {boolean} useMorphing 
	 * @param {boolean} useSkinning 
	 * @param {boolean} useInstancing 
 	 * @return {MeshDistanceMaterial}
	 */
	getDistanceMaterialVariant( useMorphing, useSkinning, useInstancing ) {

		const index = useMorphing << 0 | useSkinning << 1 | useInstancing << 2;

		/** @type {MeshDistanceMaterial} */
		let material = this._distanceMaterials[ index ];

		if ( material === undefined ) {

			material = new MeshDistanceMaterial( {

				morphTargets: useMorphing,
				skinning: useSkinning

			} );

			this._distanceMaterials[ index ] = material;

		}

		return material;

	}

	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {BufferGeometry} geometry 
	 * @param {MaterialInterface} material 
	 * @param {LightInterface } light 
	 * @param {number} shadowCameraNear 
	 * @param {number} shadowCameraFar 
	 * @param {number} type 
	 * @return {MaterialInterface}
	 */
	getDepthMaterial( object, geometry, material, light, shadowCameraNear, shadowCameraFar, type ) {

		/** @type {MaterialInterface|null} */
		let result = null;

		/**
		 * @returns {MaterialInterface}
		 */
		let getMaterialVariant = this.getDepthMaterialVariant;
		
		/** @type {MaterialInterface} */
		let customMaterial = object.customDepthMaterial;

		if ( light.isPointLight === true ) {

			getMaterialVariant = this.getDistanceMaterialVariant;
			customMaterial = object.customDistanceMaterial;

		}

		if ( customMaterial === undefined ) {

			let useMorphing = false;

			if ( material.morphTargets === true ) {

				useMorphing = geometry.morphAttributes && geometry.morphAttributes.position && geometry.morphAttributes.position.length > 0;

			}

			let useSkinning = false;

			if ( object.isSkinnedMesh === true ) {

				if ( material.skinning === true ) {

					useSkinning = true;

				} else {

					console.warn( 'THREE.WebGLShadowMap: THREE.SkinnedMesh with material.skinning set to false:', object );

				}

			}

			const useInstancing = object.isInstancedMesh === true;

			result = getMaterialVariant(useMorphing, useSkinning, useInstancing );

		} else {

			result = customMaterial;

		}

		if ( this._renderer.localClippingEnabled &&
				material.clipShadows === true &&
				material.clippingPlanes.length !== 0 ) {

			// in this case we need a unique material instance reflecting the
			// appropriate state

			const keyA = result.uuid, keyB = material.uuid;

			let materialsForVariant = this._materialCache[ keyA ];

			if ( materialsForVariant === undefined ) {

				materialsForVariant = {};
				this._materialCache[ keyA ] = materialsForVariant;

			}

			let cachedMaterial = materialsForVariant[ keyB ];

			if ( cachedMaterial === undefined ) {

				cachedMaterial = result.clone();
				materialsForVariant[ keyB ] = cachedMaterial;

			}
			result = cachedMaterial;

		}

		result.visible = material.visible;
		result.wireframe = material.wireframe;

		if ( type === VSMShadowMap ) {

			result.side = ( material.shadowSide !== null ) ? material.shadowSide : material.side;

		} else {

			result.side = ( material.shadowSide !== null ) ? material.shadowSide : this.shadowSide[ material.side ];

		}

		result.clipShadows = material.clipShadows;
		result.clippingPlanes = material.clippingPlanes;
		result.clipIntersection = material.clipIntersection;

		result.wireframeLinewidth = material.wireframeLinewidth;
		result.linewidth = material.linewidth;

		if ( light.isPointLight === true && result.isMeshDistanceMaterial === true ) {

			result.referencePosition.setFromMatrixPosition( light.matrixWorld );
			result.nearDistance = shadowCameraNear;
			result.farDistance = shadowCameraFar;

		}

		return result;

	}

	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {CameraInterface} camera 
	 * @param {CameraInterface} shadowCamera 
	 * @param {LightInterface } light 
	 * @param {number} type 
	 */
	renderObject( object, camera, shadowCamera, light, type ) {

		if ( object.visible === false ) return;

		const visible = object.layers.test( camera.layers );

		if ( visible && ( object.isMesh || object.isLine || object.isPoints ) ) {

			if ( ( object.castShadow || ( object.receiveShadow && type === VSMShadowMap ) ) && ( ! object.frustumCulled || this._frustum.intersectsObject( object ) ) ) {

				object.modelViewMatrix.multiplyMatrices( shadowCamera.matrixWorldInverse, object.matrixWorld );

				const geometry = this._objects.update( object );
				/** @type {MaterialInterface|Array} */
				const material = object.material;

				if ( Array.isArray( material ) ) {

					const groups = geometry.groups;

					for ( let k = 0, kl = groups.length; k < kl; k ++ ) {

						const group = groups[ k ];
						const groupMaterial = material[ group.materialIndex ];

						if ( groupMaterial && groupMaterial.visible ) {

							const depthMaterial = this.getDepthMaterial( object, geometry, groupMaterial, light, shadowCamera.near, shadowCamera.far, type );

							this._renderer.renderBufferDirect( shadowCamera, null, geometry, depthMaterial, object, group );

						}

					}

				} else if ( material.visible ) {

					const depthMaterial = this.getDepthMaterial( object, geometry, material, light, shadowCamera.near, shadowCamera.far, type );

					this._renderer.renderBufferDirect( shadowCamera, null, geometry, depthMaterial, object, null );

				}

			}

		}

		const children = object.children;

		for ( let i = 0, l = children.length; i < l; i ++ ) {

			this.renderObject( children[ i ], camera, shadowCamera, light, type );

		}

	}

}


export { WebGLShadowMap };
