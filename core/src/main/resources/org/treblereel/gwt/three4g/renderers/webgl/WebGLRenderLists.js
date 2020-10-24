//closure compiler
import { Object3DInterface } from '../../closure/core/Object3DInterface.js';
import { MaterialInterface } from './../../closure/material/MaterialInterface.js';
import { WebGLProgram } from './WebGLProgram.js';
import { Group } from './../../objects/Group.js';
import { Scene } from './../../scenes/Scene.js';
import { BufferGeometry } from '../../core/BufferGeometry.js';
import { WebGLProperties } from './WebGLProperties.js';


/**
 * @record
 */
var RenderItem  = function() {};
/** @type {number|null} */
RenderItem.prototype.id;
/** @type {Object3DInterface} */
RenderItem.prototype.object;
/** @type {BufferGeometry | null} */
RenderItem.prototype.geometry;
/** @type {MaterialInterface} */
RenderItem.prototype.material;
/** @type {WebGLProgram} */
RenderItem.prototype.program;
/** @type {number} */
RenderItem.prototype.groupOrder;
/** @type {number} */
RenderItem.prototype.renderOrder;
/** @type {number} */
RenderItem.prototype.z;
/** @type {Group|null} */
RenderItem.prototype.group;

/**
 * 
 * @param {RenderItem} a 
 * @param {RenderItem} b
 * @return {number} 
 */
function painterSortStable( a, b ) {

	if ( a.groupOrder !== b.groupOrder ) {

		return a.groupOrder - b.groupOrder;

	} else if ( a.renderOrder !== b.renderOrder ) {

		return a.renderOrder - b.renderOrder;

	} else if ( a.program !== b.program ) {

		return a.program.id - b.program.id;

	} else if ( a.material.id !== b.material.id ) {

		return a.material.id - b.material.id;

	} else if ( a.z !== b.z ) {

		return a.z - b.z;

	} else {

		return a.id - b.id;

	}

}

/**
 * 
 * @param {RenderItem} a 
 * @param {RenderItem} b
 * @return {number} 
 */
function reversePainterSortStable( a, b ) {

	if ( a.groupOrder !== b.groupOrder ) {

		return a.groupOrder - b.groupOrder;

	} else if ( a.renderOrder !== b.renderOrder ) {

		return a.renderOrder - b.renderOrder;

	} else if ( a.z !== b.z ) {

		return b.z - a.z;

	} else {

		return a.id - b.id;

	}

}


class WebGLRenderList {

	/**
	 * 
	 * @param {WebGLProperties} properties 
	 */
	constructor( properties ) {

		this.properties = properties;
		/** @type {Array<RenderItem>} */
		this.renderItems = [];
		this.renderItemsIndex = 0;

		/** @type {Array<RenderItem>} */
		this.opaque = [];
		/** @type {Array<RenderItem>} */
		this.transparent = [];

		this.defaultProgram = { id: - 1 };

	}

	init() {

		this.renderItemsIndex = 0;

		this.opaque.length = 0;
		this.transparent.length = 0;

	}

	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {BufferGeometry|null} geometry 
	 * @param {MaterialInterface} material 
	 * @param {number} groupOrder 
	 * @param {number} z 
	 * @param {Group|null} group 
	 * @return {RenderItem}
	 */
	getNextRenderItem( object, geometry, material, groupOrder, z, group ) {

		/** @type {RenderItem} */
		let renderItem = this.renderItems[ this.renderItemsIndex ];
		const materialProperties = this.properties.get( material );

		if ( renderItem === undefined ) {

			renderItem = {
				id: object.id,
				object: object,
				geometry: geometry,
				material: material,
				program: materialProperties.program || this.defaultProgram,
				groupOrder: groupOrder,
				renderOrder: object.renderOrder,
				z: z,
				group: group
			};

			this.renderItems[ this.renderItemsIndex ] = renderItem;

		} else {

			renderItem.id = object.id;
			renderItem.object = object;
			renderItem.geometry = geometry;
			renderItem.material = material;
			renderItem.program = materialProperties.program || this.defaultProgram;
			renderItem.groupOrder = groupOrder;
			renderItem.renderOrder = object.renderOrder;
			renderItem.z = z;
			renderItem.group = group;

		}

		this.renderItemsIndex ++;

		return renderItem;

	}

	/**
	 * @param {Object3DInterface} object 
	 * @param {BufferGeometry} geometry 
	 * @param {MaterialInterface} material 
	 * @param {number} groupOrder 
	 * @param {number} z 
	 * @param {Group|null} group 
	 */
	push( object, geometry, material, groupOrder, z, group ) {

		const renderItem = this.getNextRenderItem( object, geometry, material, groupOrder, z, group );

		( material.transparent === true ? this.transparent : this.opaque ).push( renderItem );

	}

	/**
	 * @param {Object3DInterface} object 
	 * @param {BufferGeometry} geometry 
	 * @param {MaterialInterface} material 
	 * @param {number} groupOrder 
	 * @param {number} z 
	 * @param {Group|null} group 
	 */
	unshift( object, geometry, material, groupOrder, z, group ) {

		const renderItem = this.getNextRenderItem( object, geometry, material, groupOrder, z, group );

		( material.transparent === true ? this.transparent : this.opaque ).unshift( renderItem );

	}

	/**
	 * 
	 * @param {function(RenderItem) : number} customOpaqueSort 
	 * @param {function(RenderItem) : number} customTransparentSort 
	 */
	sort( customOpaqueSort, customTransparentSort ) {

		if ( this.opaque.length > 1 ) this.opaque.sort( customOpaqueSort || painterSortStable );
		if ( this.transparent.length > 1 ) this.transparent.sort( customTransparentSort || reversePainterSortStable );

	}

	finish() {

		// Clear references from inactive renderItems in the list

		for ( let i = this.renderItemsIndex, il = this.renderItems.length; i < il; i ++ ) {

			/** @type {RenderItem} */
			const renderItem = this.renderItems[ i ];

			if ( renderItem.id === null ) break;

			renderItem.id = null;
			renderItem.object = null;
			renderItem.geometry = null;
			renderItem.material = null;
			renderItem.program = null;
			renderItem.group = null;

		}

	}

}

class WebGLRenderLists {

	/**
	 * 
	 * @param {WebGLProperties} properties 
	 */
	constructor( properties ) {
		this.properties = properties;
		/** @type {Map<Scene, Array<WebGLRenderList>>}*/
		this.lists = new WeakMap();
	}

	/**
	 * 
	 * @param {Scene} scene 
	 * @param {number} renderCallDepth 
	 * @return {WebGLRenderList}
	 */
	get( scene, renderCallDepth ) {

		/** @type {WebGLRenderList} */
		let list;

		if ( this.lists.has( scene ) === false ) {

			list = new WebGLRenderList( this.properties );
			this.lists.set( scene, [ list ] );

		} else {

			if ( renderCallDepth >= this.lists.get( scene ).length ) {

				list = new WebGLRenderList( this.properties );
				this.lists.get( scene ).push( list );

			} else {

				list = this.lists.get( scene )[ renderCallDepth ];

			}

		}

		return list;

	}

	dispose() {

		this.lists = new WeakMap();

	}

}


export { WebGLRenderLists, WebGLRenderList };
