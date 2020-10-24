class WebGLInfo {

	/**
	 *  @param {WebGLRenderingContext|WebGL2RenderingContext} gl
	 * 
	 */
	constructor( gl ) {

		this.gl = gl;

		const memory = {
			geometries: 0,
			textures: 0
		};

		const render = {
			frame: 0,
			calls: 0,
			triangles: 0,
			points: 0,
			lines: 0
		};

		this.memory = memory;
		this.render = render;

		this.programs = null;
		this.autoReset = true;

	}

	/**
	 * @param {number} count 
	 * @param {number} mode 
	 * @param {number} instanceCount 
	 */
	update( count, mode, instanceCount ) {

		this.render.calls ++;

		switch ( mode ) {

			case this.gl.TRIANGLES:
				this.render.triangles += instanceCount * ( count / 3 );
				break;

			case this.gl.LINES:
				this.render.lines += instanceCount * ( count / 2 );
				break;

			case this.gl.LINE_STRIP:
				this.render.lines += instanceCount * ( count - 1 );
				break;

			case this.gl.LINE_LOOP:
				this.render.lines += instanceCount * count;
				break;

			case this.gl.POINTS:
				this.render.points += instanceCount * count;
				break;

			default:
				console.error( 'THREE.WebGLInfo: Unknown draw mode:', mode );
				break;

		}

	}

	reset() {

		this.render.frame ++;
		this.render.calls = 0;
		this.render.triangles = 0;
		this.render.points = 0;
		this.render.lines = 0;

	}

}


export { WebGLInfo };
