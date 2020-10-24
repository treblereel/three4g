import { Object3DInterface } from '../../closure/core/Object3DInterface.js';
import { BufferGeometry } from '../../core/BufferGeometry.js';
import { MaterialInterface } from '../../closure/material/MaterialInterface.js';
import { WebGLProgram } from './WebGLProgram.js';

/**
 * @param {Array<number>} a 
 * @param {Array<number>} b 
 * @return {number}
 */
function numericalSort( a, b ) {

	return a[ 0 ] - b[ 0 ];

}

/**
 * @param {Array<number>} a 
 * @param {Array<number>} b 
 * @return {number}
 */
function absNumericalSort( a, b ) {

	return Math.abs( b[ 1 ] ) - Math.abs( a[ 1 ] );

}


class WebGLMorphtargets {

	/**
	 *  @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 */
	constructor( gl ) {

		this.gl = gl;	

		this.influencesList = {};
		this.morphInfluences = new Float32Array( 8 );

		this.workInfluences = [];

		for ( let i = 0; i < 8; i ++ ) {

			this.workInfluences[ i ] = [ i, 0 ];

		}

	}

	/**
	 * 
	 * @param {Object3DInterface} object 
	 * @param {BufferGeometry} geometry 
	 * @param {MaterialInterface} material 
	 * @param {WebGLProgram} program 
	 */
	update( object, geometry, material, program ) {

		const objectInfluences = ( /** @type {{ morphTargetInfluences : Array<number>}} */ (object)).morphTargetInfluences;

		// When object doesn't have morph target influences defined, we treat it as a 0-length array
		// This is important to make sure we set up morphTargetBaseInfluence / morphTargetInfluences

		const length = objectInfluences === undefined ? 0 : objectInfluences.length;

		let influences = this.influencesList[ geometry.id ];

		if ( influences === undefined ) {

			// initialise list

			influences = [];

			for ( let i = 0; i < length; i ++ ) {

				influences[ i ] = [ i, 0 ];

			}

			this.influencesList[ geometry.id ] = influences;

		}

		// Collect influences

		for ( let i = 0; i < length; i ++ ) {

			const influence = influences[ i ];

			influence[ 0 ] = i;
			influence[ 1 ] = objectInfluences[ i ];

		}

		influences.sort( absNumericalSort );

		for ( let i = 0; i < 8; i ++ ) {

			if ( i < length && influences[ i ][ 1 ] ) {

				this.workInfluences[ i ][ 0 ] = influences[ i ][ 0 ];
				this.workInfluences[ i ][ 1 ] = influences[ i ][ 1 ];

			} else {

				this.workInfluences[ i ][ 0 ] = Number.MAX_SAFE_INTEGER;
				this.workInfluences[ i ][ 1 ] = 0;

			}

		}

		this.workInfluences.sort( numericalSort );

		const morphTargets = material.morphTargets && geometry.morphAttributes.position;
		const morphNormals = material.morphNormals && geometry.morphAttributes.normal;

		let morphInfluencesSum = 0;

		for ( let i = 0; i < 8; i ++ ) {

			const influence = this.workInfluences[ i ];
			const index = influence[ 0 ];
			const value = influence[ 1 ];

			if ( index !== Number.MAX_SAFE_INTEGER && value ) {

				if ( morphTargets && geometry.getAttribute( 'morphTarget' + i ) !== morphTargets[ index ] ) {

					geometry.setAttribute( 'morphTarget' + i, morphTargets[ index ] );

				}

				if ( morphNormals && geometry.getAttribute( 'morphNormal' + i ) !== morphNormals[ index ] ) {

					geometry.setAttribute( 'morphNormal' + i, morphNormals[ index ] );

				}

				this.morphInfluences[ i ] = value;
				morphInfluencesSum += value;

			} else {

				if ( morphTargets && geometry.hasAttribute( 'morphTarget' + i ) === true ) {

					geometry.deleteAttribute( 'morphTarget' + i );

				}

				if ( morphNormals && geometry.hasAttribute( 'morphNormal' + i ) === true ) {

					geometry.deleteAttribute( 'morphNormal' + i );

				}

				this.morphInfluences[ i ] = 0;

			}

		}

		// GLSL shader uses formula baseinfluence * base + sum(target * influence)
		// This allows us to switch between absolute morphs and relative morphs without changing shader code
		// When baseinfluence = 1 - sum(influence), the above is equivalent to sum((target - base) * influence)
		const morphBaseInfluence = geometry.morphTargetsRelative ? 1 : 1 - morphInfluencesSum;

		program.getUniforms().setValue( this.gl, 'morphTargetBaseInfluence', morphBaseInfluence );
		program.getUniforms().setValue( this.gl, 'morphTargetInfluences', this.morphInfluences );

	}

}


export { WebGLMorphtargets };
