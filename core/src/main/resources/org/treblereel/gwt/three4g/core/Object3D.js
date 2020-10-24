import { Quaternion } from '../math/Quaternion.js';
import { Vector3 } from '../math/Vector3.js';
import { Matrix4 } from '../math/Matrix4.js';
import { EventDispatcher } from './EventDispatcher.js';
import { Euler } from '../math/Euler.js';
import { Layers } from './Layers.js';
import { Matrix3 } from '../math/Matrix3.js';
import { MathUtils } from '../math/MathUtils.js';

import { Event } from './EventDispatcher.js';


let _object3DId = 0;

const _v1 = new Vector3();
const _q1 = new Quaternion();
const _m1 = new Matrix4();
const _target = new Vector3();

const _position = new Vector3();
const _scale = new Vector3();
const _quaternion = new Quaternion();

const _xAxis = new Vector3( 1, 0, 0 );
const _yAxis = new Vector3( 0, 1, 0 );
const _zAxis = new Vector3( 0, 0, 1 );

/** @type {Event} */
const _addedEvent = { type: 'added' };
/** @type {Event} */
const _removedEvent = { type: 'removed' };

class Object3D extends EventDispatcher {

	constructor() {

		super();

		/** @type {Vector3} */
		Object3D.DefaultUp = new Vector3( 0, 1, 0 );
		Object3D.DefaultMatrixAutoUpdate = true;

		//Object.defineProperty( this, 'id', { value: _object3DId ++ } );
		/** @type {number} */
		this.id = _object3DId ++;	

		/** @type {string} */
		this.uuid = MathUtils.generateUUID();
		/** @type {string} */
		this.name = '';
		/** @type {string} */
		this.type = 'Object3D';
		/** @type {Object3D|null} */
		this.parent = null;
		/** @type {Array<Object3D>} */
		this.children = [];

		this.up = Object3D.DefaultUp.clone();

		const position = new Vector3();
		const rotation = new Euler();
		const quaternion = new Quaternion();
		const scale = new Vector3( 1, 1, 1 );

		function onRotationChange() {

			quaternion.setFromEuler( rotation, false );

		}

		function onQuaternionChange() {

			rotation.setFromQuaternion( quaternion, undefined, false );

		}

		rotation._onChange( onRotationChange );
		quaternion._onChange( onQuaternionChange );

/* 		Object.defineProperties( this, {
			position: {
				configurable: true,
				enumerable: true,
				value: position
			},
			rotation: {
				configurable: true,
				enumerable: true,
				value: rotation
			},
			quaternion: {
				configurable: true,
				enumerable: true,
				value: quaternion
			},
			scale: {
				configurable: true,
				enumerable: true,
				value: scale
			},
			modelViewMatrix: {
				value: new Matrix4()
			},
			normalMatrix: {
				value: new Matrix3()
			}
		} ); */

		/** @type {Vector3} */
		this.position = position;
		/** @type {Euler} */
		this.rotation = rotation;
		/** @type {Quaternion} */
		this.quaternion = quaternion;
		/** @type {Vector3} */
		this.scale = scale;
		this.modelViewMatrix = new Matrix4();
		this.normalMatrix = new Matrix3();

		this.matrix = new Matrix4();
		this.matrixWorld = new Matrix4();

		this.matrixAutoUpdate = Object3D.DefaultMatrixAutoUpdate;
		this.matrixWorldNeedsUpdate = false;

		this.layers = new Layers();
		this.visible = true;

		this.castShadow = false;
		this.receiveShadow = false;

		this.frustumCulled = true;
		this.renderOrder = 0;

		this.animations = [];

		this.userData = {};

		this.isObject3D = true;
	}


	/**
	 * 
	 * @param {*=} render 
	 * @param {*=} scene 
	 * @param {*=} camera 
	 * @param {*=} geometry 
	 * @param {*=} material 
	 * @param {*=} group 
	 */
	onBeforeRender(render, scene, camera, geometry, material, group ) {}

		/**
	 * 
	 * @param {*=} render 
	 * @param {*=} scene 
	 * @param {*=} camera 
	 * @param {*=} geometry 
	 * @param {*=} material 
	 * @param {*=} group 
	 */
	onAfterRender(render, scene, camera, geometry, material, group ) {}

	/**
	 * @suppress {checkTypes} 
	 * @param {Matrix4} matrix 
	 */
	applyMatrix4( matrix ) {

		if ( this.matrixAutoUpdate ) this.updateMatrix();

		this.matrix.premultiply( matrix );

		this.matrix.decompose( this.position, this.quaternion, this.scale );

	}

	/**
	 * @param {Quaternion} q 
	 * @return {Object3D}
	 */
	applyQuaternion( q ) {

		this.quaternion.premultiply( q );

		return this;

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Vector3} axis 
	 * @param {number} angle
	 */
	setRotationFromAxisAngle( axis, angle ) {

		// assumes axis is normalized

		this.quaternion.setFromAxisAngle( axis, angle );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Euler} euler 
	 */
	setRotationFromEuler( euler ) {

		this.quaternion.setFromEuler( euler, true );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Matrix4} m 
	 */
	setRotationFromMatrix( m ) {

		// assumes the upper 3x3 of m is a pure rotation matrix (i.e, unscaled)

		this.quaternion.setFromRotationMatrix( m );

	}

	/**
	 * @param {Quaternion} q 
	 */
	setRotationFromQuaternion( q ) {

		// assumes q is normalized

		this.quaternion.copy( q );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Vector3} axis 
	 * @param {number} angle 
 	 * @return {Object3D}
	 */
	rotateOnAxis( axis, angle ) {

		// rotate object on axis in object space
		// axis is assumed to be normalized

		_q1.setFromAxisAngle( axis, angle );

		this.quaternion.multiply( _q1 );

		return this;

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Vector3} axis 
	 * @param {number} angle 
 	 * @return {Object3D}
	 */
	rotateOnWorldAxis( axis, angle ) {

		// rotate object on axis in world space
		// axis is assumed to be normalized
		// method assumes no rotated parent

		_q1.setFromAxisAngle( axis, angle );

		this.quaternion.premultiply( _q1 );

		return this;

	}

	/**
	 * @param {number} angle 
  	 * @return {Object3D}
	 */
	rotateX( angle ) {

		return this.rotateOnAxis( _xAxis, angle );

	}

	/**
	 * @param {number} angle 
  	 * @return {Object3D}
	 */
	rotateY( angle ) {

		return this.rotateOnAxis( _yAxis, angle );

	}

	/**
	 * @param {number} angle 
  	 * @return {Object3D}
	 */
	rotateZ( angle ) {

		return this.rotateOnAxis( _zAxis, angle );

	}

	/**
	 * @param {Vector3} axis 
	 * @param {number} distance 
   	 * @return {Object3D}
	 */
	translateOnAxis( axis, distance ) {

		// translate object by distance along axis in object space
		// axis is assumed to be normalized

		_v1.copy( axis ).applyQuaternion( this.quaternion );

		this.position.add( _v1.multiplyScalar( distance ) );

		return this;

	}

	/**
	 * @param {number} distance 
   	 * @return {Object3D}
	 */
	translateX( distance ) {

		return this.translateOnAxis( _xAxis, distance );

	}

	/**
	 * @param {number} distance 
   	 * @return {Object3D}
	 */
	translateY( distance ) {

		return this.translateOnAxis( _yAxis, distance );

	}

	/**
	 * @param {number} distance 
   	 * @return {Object3D}
	 */
	translateZ( distance ) {

		return this.translateOnAxis( _zAxis, distance );

	}

	/**
	 * @param {Vector3} vector 
	 * @return {Vector3}
	 */
	localToWorld( vector ) {

		return vector.applyMatrix4( this.matrixWorld );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Vector3} vector 
	 * @return {Vector3}
	 */
	worldToLocal( vector ) {

		return vector.applyMatrix4( _m1.copy( this.matrixWorld ).invert() );

	}

	/**
	 * @param {Vector3 | number=} x
	 * @param {number=} y
	 * @param {number=} z
	 */
	lookAt( x, y, z ) {

		// This method does not support objects having non-uniformly-scaled parent(s)

		if ( x.isVector3 ) {

			_target.copy(/** @type {Vector3} */ (x) );

		} else {

			_target.set( /** @type {number} */ (x), /** @type {number} */ (y), /** @type {number} */ (z) );

		}

		const parent = this.parent;

		this.updateWorldMatrix( true, false );

		_position.setFromMatrixPosition( this.matrixWorld );

		if ( (/** @type { {isCamera:boolean} }*/ (this)).isCamera || (/** @type { {isLight:boolean} }*/ (this)).isLight ) {

			_m1.lookAt( _position, _target, this.up );

		} else {

			_m1.lookAt( _target, _position, this.up );

		}

		this.quaternion.setFromRotationMatrix( _m1 );

		if ( parent ) {

			_m1.extractRotation( parent.matrixWorld );
			_q1.setFromRotationMatrix( _m1 );
			this.quaternion.premultiply( _q1.invert() );

		}

	}

	/**
	 * 
	 * @param {...Object3D} object 
   	 * @return {Object3D}
	 */
	add( object ) {

		if ( arguments.length > 1 ) {

			for ( let i = 0; i < arguments.length; i ++ ) {

				this.add( arguments[ i ] );

			}

			return this;

		}

		if ( object === this ) {

			console.error( 'THREE.Object3D.add: object can\'t be added as a child of itself.', object );
			return this;

		}

		if ( object && (/** @type {Object3D} */(object)).isObject3D ) {

			if ( (/** @type {Object3D} */(object)).parent !== null ) {

				(/** @type {Object3D} */(object)).parent.remove( object );

			}

			(/** @type {Object3D} */(object)).parent = this;
			this.children.push( (/** @type {Object3D} */(object)) );

			(/** @type {Object3D} */(object)).dispatchEvent( _addedEvent );

		} else {

			console.error( 'THREE.Object3D.add: object not an instance of THREE.Object3D.', object );

		}

		return this;

	}

	/**
	 * 
	 * @param {...Object3D} object 
   	 * @return {Object3D}
	 */
	remove( object ) {

		if ( arguments.length > 1 ) {

			for ( let i = 0; i < arguments.length; i ++ ) {

				this.remove( arguments[ i ] );

			}

			return this;

		}

		const index = this.children.indexOf( object );

		if ( index !== - 1 ) {

			object.parent = null;
			this.children.splice( index, 1 );

			object.dispatchEvent( _removedEvent );

		}

		return this;

	}

	/**
   	 * @return {Object3D}
	 */
	clear() {

		for ( let i = 0; i < this.children.length; i ++ ) {

			const object = this.children[ i ];

			object.parent = null;

			object.dispatchEvent( _removedEvent );

		}

		this.children.length = 0;

		return this;


	}

	/**
	 * @param {Object3D} object 
   	 * @return {Object3D}
	 */
	attach( object ) {

		// adds object as a child of this, while maintaining the object's world transform

		this.updateWorldMatrix( true, false );

		_m1.copy( this.matrixWorld ).invert();

		if ( object.parent !== null ) {

			object.parent.updateWorldMatrix( true, false );

			_m1.multiply( object.parent.matrixWorld );

		}

		object.applyMatrix4( _m1 );

		this.add( object );

		object.updateWorldMatrix( false, true );

		return this;

	}

	/**
	 * @param {number} id 
	 * @return {Object3D|undefined}
	 */
	getObjectById( id ) {

		return this.getObjectByProperty( 'id', id );

	}

	/**
	 * @param {string} name 
	 * @return {Object3D|undefined}
	 */
	getObjectByName( name ) {

		return this.getObjectByProperty( 'name', name );

	}

	/**
	 * @param {string} name 
	 * @param {string|number} value 
	 * @return {Object3D|undefined}
	 */
	getObjectByProperty( name, value ) {

		if ( this[ name ] === value ) return this;

		for ( let i = 0, l = this.children.length; i < l; i ++ ) {

			const child = this.children[ i ];
			const object = child.getObjectByProperty( name, value );

			if ( object !== undefined ) {

				return object;

			}

		}

		return undefined;

	}

	/**
	 * @param {Vector3} target
	 * @return {Vector3} 
	 */
	getWorldPosition( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Object3D: .getWorldPosition() target is now required' );
			target = new Vector3();

		}

		this.updateWorldMatrix( true, false );

		return target.setFromMatrixPosition( this.matrixWorld );

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Quaternion} target
	 * @return {Quaternion} 
	 */
	getWorldQuaternion( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Object3D: .getWorldQuaternion() target is now required' );
			target = new Quaternion();

		}

		this.updateWorldMatrix( true, false );

		this.matrixWorld.decompose( _position, target, _scale );

		return target;

	}

	/**
	 * @suppress {checkTypes} 
	 * @param {Vector3} target
	 * @return {Vector3} 
	 */
	getWorldScale( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Object3D: .getWorldScale() target is now required' );
			target = new Vector3();

		}

		this.updateWorldMatrix( true, false );

		this.matrixWorld.decompose( _position, _quaternion, target );

		return target;

	}

	/**
	 * @param {Vector3} target
	 * @return {Vector3} 
	 */
	getWorldDirection( target ) {

		if ( target === undefined ) {

			console.warn( 'THREE.Object3D: .getWorldDirection() target is now required' );
			target = new Vector3();

		}

		this.updateWorldMatrix( true, false );

		const e = this.matrixWorld.elements;

		return target.set( e[ 8 ], e[ 9 ], e[ 10 ] ).normalize();

	}

	raycast() {}

	/**
	 * @param {function(Object3D)} callback 
	 */
	traverse( callback ) {

		callback( this );

		const children = this.children;

		for ( let i = 0, l = children.length; i < l; i ++ ) {

			children[ i ].traverse( callback );

		}

	}

	/**
	 * @param {function(Object3D)} callback 
	 */
	traverseVisible( callback ) {

		if ( this.visible === false ) return;

		callback( this );

		const children = this.children;

		for ( let i = 0, l = children.length; i < l; i ++ ) {

			children[ i ].traverseVisible( callback );

		}

	}

	/**
	 * @param {function(Object3D)} callback 
	 */
	traverseAncestors( callback ) {

		const parent = this.parent;

		if ( parent !== null ) {

			callback( parent );

			parent.traverseAncestors( callback );

		}

	}

	/**
	 * @suppress {checkTypes} 
	 */
	updateMatrix() {

		this.matrix.compose( this.position, this.quaternion, this.scale );

		this.matrixWorldNeedsUpdate = true;

	}

	/**
	 * @param {boolean=} force
	 */
	updateMatrixWorld( force ) {

		if ( this.matrixAutoUpdate ) this.updateMatrix();

		if ( this.matrixWorldNeedsUpdate || force ) {

			if ( this.parent === null ) {

				this.matrixWorld.copy( this.matrix );

			} else {

				this.matrixWorld.multiplyMatrices( this.parent.matrixWorld, this.matrix );

			}

			this.matrixWorldNeedsUpdate = false;

			force = true;

		}

		// update children

		const children = this.children;

		for ( let i = 0, l = children.length; i < l; i ++ ) {

			children[ i ].updateMatrixWorld( force );

		}

	}

	/**
	 * 
	 * @param {boolean} updateParents 
	 * @param {boolean} updateChildren 
	 */
	updateWorldMatrix( updateParents, updateChildren ) {

		const parent = this.parent;

		if ( updateParents === true && parent !== null ) {

			parent.updateWorldMatrix( true, false );

		}

		if ( this.matrixAutoUpdate ) this.updateMatrix();

		if ( this.parent === null ) {

			this.matrixWorld.copy( this.matrix );

		} else {

			this.matrixWorld.multiplyMatrices( this.parent.matrixWorld, this.matrix );

		}

		// update children

		if ( updateChildren === true ) {

			const children = this.children;

			for ( let i = 0, l = children.length; i < l; i ++ ) {

				children[ i ].updateWorldMatrix( false, true );

			}

		}

	}

	/**
	 * @param {Object= } meta 
   	 * @suppress{checkTypes}
	 */
	toJSON( meta ) {

		// meta is a string when called from JSON.stringify
		const isRootObject = ( meta === undefined || typeof meta === 'string' );

		const output = {};

		// meta is a hash used to collect geometries, materials.
		// not providing it implies that this is the root object
		// being serialized.
		if ( isRootObject ) {

			// initialize meta obj
			meta = {
				geometries: {},
				materials: {},
				textures: {},
				images: {},
				shapes: {},
				skeletons: {},
				animations: {}
			};

			output.metadata = {
				version: 4.5,
				type: 'Object',
				generator: 'Object3D.toJSON'
			};

		}

		// standard Object3D serialization

		const object = {};

		object.uuid = this.uuid;
		object.type = this.type;

		if ( this.name !== '' ) object.name = this.name;
		if ( this.castShadow === true ) object.castShadow = true;
		if ( this.receiveShadow === true ) object.receiveShadow = true;
		if ( this.visible === false ) object.visible = false;
		if ( this.frustumCulled === false ) object.frustumCulled = false;
		if ( this.renderOrder !== 0 ) object.renderOrder = this.renderOrder;
		if ( JSON.stringify( this.userData ) !== '{}' ) object.userData = this.userData;

		object.layers = this.layers.mask;
		object.matrix = this.matrix.toArray();

		if ( this.matrixAutoUpdate === false ) object.matrixAutoUpdate = false;

		// object specific properties

		if ( (/** @type { {isInstancedMesh:boolean} }*/ (this)).isInstancedMesh ) {

			object.type = 'InstancedMesh';
			object.count = (/** @type { {count:number} }*/ (this)).count;
			object.instanceMatrix = ( /** @type {{ instanceMatrix : {toJSON : function() : Object}}} */ (this)).instanceMatrix.toJSON();
			//object.instanceMatrix = this.instanceMatrix.toJSON();

		}

		//

		function serialize( library, element ) {

			if ( library[ element.uuid ] === undefined ) {

				library[ element.uuid ] = element.toJSON( meta );

			}

			return element.uuid;

		}

		if ( (/** @type { {isMesh:boolean} }*/ (this)).isMesh || (/** @type { {isLine:boolean} }*/ (this)).isLine || (/** @type { {isPoints:boolean} }*/ (this)).isPoints ) {

			object.geometry = serialize( meta.geometries, ( /** @type {{ geometry : Object}} */ ( this)).geometry );

			const parameters = this.geometry.parameters;

			if ( parameters !== undefined && parameters.shapes !== undefined ) {
	
				const shapes = parameters.shapes;

				if ( Array.isArray( shapes ) ) {

					for ( let i = 0, l = shapes.length; i < l; i ++ ) {

						const shape = shapes[ i ];

						serialize( meta.shapes, shape );

					}

				} else {

					serialize( meta.shapes, shapes );

				}

			}

		}

		if ( (/** @type { {isSkinnedMesh:boolean} } */ (this)).isSkinnedMesh ) {

			object.bindMode = ( /** @type {{ bindMode: String }} */(this)).bindMode;
			object.bindMatrix = (/** @type {{ bindMatrix : Matrix4}} */(this)).bindMatrix.toArray();

			if ( ( /** @type {{ skeleton : Object}}*/ (this)).skeleton !== undefined ) {

				serialize( meta.skeletons, ( /** @type {{ skeleton : Object}} */ (this)).skeleton );

				object.skeleton = ( /** @type {{ skeleton : {uuid : String}}} */ (this)).skeleton.uuid;

			}

		}

		if ( ( /** @type {{ material : Object}} */ (this)).material !== undefined ) {
			if ( Array.isArray( ( /** @type {{ material : Object}} */ (this)).material ) ) {

				const uuids = [];

				for ( let i = 0, l = ( /** @type {{ material : Array}} */ (this)).material.length; i < l; i ++ ) {

					uuids.push( serialize( meta.materials, ( /** @type {{ material : Array}} */ (this)).material[ i ] ) );

				}

				object.material = uuids;

			} else {

				object.material = serialize( meta.materials, ( /** @type {{ material: Object }}*/(this)).material );

			}

		}

		//

		if ( this.children.length > 0 ) {

			object.children = [];

			for ( let i = 0; i < this.children.length; i ++ ) {

				object.children.push( this.children[ i ].toJSON( meta ).object );

			}

		}

		//

		if ( this.animations.length > 0 ) {

			object.animations = [];

			for ( let i = 0; i < this.animations.length; i ++ ) {

				const animation = this.animations[ i ];

				object.animations.push( serialize( meta.animations, animation ) );

			}

		}

		if ( isRootObject ) {

			const geometries = extractFromCache( meta.geometries );
			const materials = extractFromCache( meta.materials );
			const textures = extractFromCache( meta.textures );
			const images = extractFromCache( meta.images );
			const shapes = extractFromCache( meta.shapes );
			const skeletons = extractFromCache( meta.skeletons );
			const animations = extractFromCache( meta.animations );

			if ( geometries.length > 0 ) output.geometries = geometries;
			if ( materials.length > 0 ) output.materials = materials;
			if ( textures.length > 0 ) output.textures = textures;
			if ( images.length > 0 ) output.images = images;
			if ( shapes.length > 0 ) output.shapes = shapes;
			if ( skeletons.length > 0 ) output.skeletons = skeletons;
			if ( animations.length > 0 ) output.animations = animations;

		}

		output.object = object;

		return output;

		// extract data from the cache hash
		// remove metadata on each item
		// and return as array
		function extractFromCache( cache ) {

			const values = [];
			for ( const key in cache ) {

				const data = cache[ key ];
				delete data.metadata;
				values.push( data );

			}

			return values;

		}

	}

	/**
	 * @param {boolean=} recursive 
	 * @return {Object3D}
	 */
	clone( recursive ) {

		return new this.constructor().copy( this, recursive );

	}

	/**
	 * @param {Object3D=} source 
	 * @param {boolean=} recursive 
	 * @return {Object3D}
	 */
	copy( source, recursive = true ) {

		this.name = source.name;

		this.up.copy( source.up );

		this.position.copy( source.position );
		this.rotation.order = source.rotation.order;
		this.quaternion.copy( source.quaternion );
		this.scale.copy( source.scale );

		this.matrix.copy( source.matrix );
		this.matrixWorld.copy( source.matrixWorld );

		this.matrixAutoUpdate = source.matrixAutoUpdate;
		this.matrixWorldNeedsUpdate = source.matrixWorldNeedsUpdate;

		this.layers.mask = source.layers.mask;
		this.visible = source.visible;

		this.castShadow = source.castShadow;
		this.receiveShadow = source.receiveShadow;

		this.frustumCulled = source.frustumCulled;
		this.renderOrder = source.renderOrder;

		this.userData = JSON.parse( JSON.stringify( source.userData ) );

		if ( recursive === true ) {

			for ( let i = 0; i < source.children.length; i ++ ) {

				const child = source.children[ i ];
				this.add( child.clone() );

			}

		}

		return this;

	}

}


export { Object3D };
