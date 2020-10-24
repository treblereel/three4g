

/**
 * 
 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl
 * @param {number} type 
 * @param {string} string 
 */
function WebGLShader( gl, type, string ) {

	const shader = gl.createShader( type );

	gl.shaderSource( shader, string );
	gl.compileShader( shader );

	return shader;

}

export { WebGLShader };