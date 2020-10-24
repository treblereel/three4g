import { NotEqualDepth, GreaterDepth, GreaterEqualDepth, EqualDepth, LessEqualDepth, LessDepth, AlwaysDepth, NeverDepth, CullFaceFront, CullFaceBack, CullFaceNone, DoubleSide, BackSide, CustomBlending, MultiplyBlending, SubtractiveBlending, AdditiveBlending, NoBlending, NormalBlending, AddEquation, SubtractEquation, ReverseSubtractEquation, MinEquation, MaxEquation, ZeroFactor, OneFactor, SrcColorFactor, SrcAlphaFactor, SrcAlphaSaturateFactor, DstColorFactor, DstAlphaFactor, OneMinusSrcColorFactor, OneMinusSrcAlphaFactor, OneMinusDstColorFactor, OneMinusDstAlphaFactor } from '../../constants.js';
import { Vector4 } from '../../math/Vector4.js';

import { WebGLExtensions } from './WebGLExtensions.js';
import { WebGLCapabilities } from './WebGLCapabilities.js';
import { MaterialInterface } from '../../closure/material/MaterialInterface.js';

class ColorBuffer {

	/** @param {WebGLState} state */
	constructor(state) {

		this.state = state;

		this.locked = false;
		this.color = new Vector4();
		this.currentColorMask = null;
		this.currentColorClear = new Vector4(0, 0, 0, 0);
	}

	/**
	 * @param {boolean} colorMask 
	 */
	setMask(colorMask) {

		if (this.currentColorMask !== colorMask && !this.locked) {

			this.state.gl.colorMask(colorMask, colorMask, colorMask, colorMask);
			this.currentColorMask = colorMask;

		}

	}

	/**
	 * 
	 * @param {boolean} lock 
	 */
	setLocked(lock) {

		this.locked = lock;

	}

	/**
	 * 
	 * @param {number} r 
	 * @param {number} g 
	 * @param {number} b 
	 * @param {number} a 
	 * @param {boolean=} premultipliedAlpha 
	 */
	setClear(r, g, b, a, premultipliedAlpha) {

		if (premultipliedAlpha === true) {

			r *= a; g *= a; b *= a;

		}

		this.color.set(r, g, b, a);

		if (this.currentColorClear.equals(this.color) === false) {

			this.state.gl.clearColor(r, g, b, a);
			this.currentColorClear.copy(this.color);

		}

	}

	reset() {

		this.locked = false;

		this.currentColorMask = null;
		this.currentColorClear.set(- 1, 0, 0, 0); // set to invalid state

	}

}

class DepthBuffer {

	/** @param {WebGLState} state */
	constructor(state) {

		/** @type {WebGLState} */
		this.state = state;

		/** @type {boolean} */
		this.locked = false;

		/** @type {boolean|null} */
		this.currentDepthMask = null;
		/** @type {number|null} */
		this.currentDepthFunc = null;
		/** @type {number|null} */
		this.currentDepthClear = null;
	}

	/**
	 * @param {boolean} depthTest 
	 */
	setTest(depthTest) {

		if (depthTest) {

			this.state.enable(this.state.gl.DEPTH_TEST);

		} else {

			this.state.disable(this.state.gl.DEPTH_TEST);

		}

	}

	/**
	 * @param {boolean} depthMask 
	 */
	setMask(depthMask) {

		if (this.currentDepthMask !== depthMask && !this.locked) {

			this.state.gl.depthMask(depthMask);
			this.currentDepthMask = depthMask;

		}

	}

	/**
	 * @param {number} depthFunc 
	 */
	setFunc(depthFunc) {

		if (this.currentDepthFunc !== depthFunc) {

			if (depthFunc) {

				switch (depthFunc) {

					case NeverDepth:

						this.state.gl.depthFunc(this.state.gl.NEVER);
						break;

					case AlwaysDepth:

						this.state.gl.depthFunc(this.state.gl.ALWAYS);
						break;

					case LessDepth:

						this.state.gl.depthFunc(this.state.gl.LESS);
						break;

					case LessEqualDepth:

						this.state.gl.depthFunc(this.state.gl.LEQUAL);
						break;

					case EqualDepth:

						this.state.gl.depthFunc(this.state.gl.EQUAL);
						break;

					case GreaterEqualDepth:

						this.state.gl.depthFunc(this.state.gl.GEQUAL);
						break;

					case GreaterDepth:

						this.state.gl.depthFunc(this.state.gl.GREATER);
						break;

					case NotEqualDepth:

						this.state.gl.depthFunc(this.state.gl.NOTEQUAL);
						break;

					default:

						this.state.gl.depthFunc(this.state.gl.LEQUAL);

				}

			} else {

				this.state.gl.depthFunc(this.state.gl.LEQUAL);

			}

			this.currentDepthFunc = depthFunc;

		}

	}

	/**
	 * 
	 * @param {boolean} lock 
	 */
	setLocked(lock) {

		this.locked = lock;

	}

	/**
	 * @param {number} depth 
	 */
	setClear(depth) {

		if (this.currentDepthClear !== depth) {

			this.state.gl.clearDepth(depth);
			this.currentDepthClear = depth;

		}

	}

	reset() {

		this.locked = false;

		this.currentDepthMask = null;
		this.currentDepthFunc = null;
		this.currentDepthClear = null;

	}

}

class StencilBuffer {

	/** @param {WebGLState} state */
	constructor(state) {

		/** @type {WebGLState} */
		this.state = state;

		/** @type {boolean} */
		this.locked = false;
		/** @type {number|null} */
		this.currentStencilMask = null;
		/** @type {number|null} */
		this.currentStencilFunc = null;
		/** @type {number|null} */
		this.currentStencilRef = null;
		/** @type {number|null} */
		this.currentStencilFuncMask = null;
		/** @type {number|null} */
		this.currentStencilFail = null;
		/** @type {number|null} */
		this.currentStencilZFail = null;
		/** @type {number|null} */
		this.currentStencilZPass = null;
		/** @type {number|null} */
		this.currentStencilClear = null;

	}

	/**
	 * @param {boolean} stencilTest 
	 */
	setTest(stencilTest) {

		if (!this.locked) {

			if (stencilTest) {

				this.state.enable(this.state.gl.STENCIL_TEST);

			} else {

				this.state.disable(this.state.gl.STENCIL_TEST);

			}

		}

	}

	/**
	 * @param {number} stencilMask 
	 */
	setMask(stencilMask) {

		if (this.currentStencilMask !== stencilMask && !this.locked) {

			this.state.gl.stencilMask(stencilMask);
			this.currentStencilMask = stencilMask;

		}

	}

	/**
	 * @param {number} stencilFunc 
	 * @param {number} stencilRef 
	 * @param {number} stencilMask 
	 */
	setFunc(stencilFunc, stencilRef, stencilMask) {

		if (this.currentStencilFunc !== stencilFunc ||
			this.currentStencilRef !== stencilRef ||
			this.currentStencilFuncMask !== stencilMask) {

			this.state.gl.stencilFunc(stencilFunc, stencilRef, stencilMask);

			this.currentStencilFunc = stencilFunc;
			this.currentStencilRef = stencilRef;
			this.currentStencilFuncMask = stencilMask;

		}

	}

	/**
	 * @param {number} stencilFail 
	 * @param {number} stencilZFail 
	 * @param {number} stencilZPass 
	 */
	setOp(stencilFail, stencilZFail, stencilZPass) {

		if (this.currentStencilFail !== stencilFail ||
			this.currentStencilZFail !== stencilZFail ||
			this.currentStencilZPass !== stencilZPass) {

			this.state.gl.stencilOp(stencilFail, stencilZFail, stencilZPass);

			this.currentStencilFail = stencilFail;
			this.currentStencilZFail = stencilZFail;
			this.currentStencilZPass = stencilZPass;

		}

	}

	/**
	 * @param {boolean} lock 
	 */
	setLocked(lock) {

		this.locked = lock;

	}

	/**
	 * @param {number} stencil 
	 */
	setClear(stencil) {

		if (this.currentStencilClear !== stencil) {

			this.state.gl.clearStencil(stencil);
			this.currentStencilClear = stencil;

		}

	}

	reset() {

		this.locked = false;

		this.currentStencilMask = null;
		this.currentStencilFunc = null;
		this.currentStencilRef = null;
		this.currentStencilFuncMask = null;
		this.currentStencilFail = null;
		this.currentStencilZFail = null;
		this.currentStencilZPass = null;
		this.currentStencilClear = null;

	}

}

class WebGLState {

	/**
	 * @param {WebGLRenderingContext|WebGL2RenderingContext} gl 
	 * @param {WebGLExtensions} extensions 
	 * @param {WebGLCapabilities} capabilities 
	 */
	constructor(gl, extensions, capabilities) {

		/** @type {WebGLRenderingContext|WebGL2RenderingContext} */
		this.gl = gl;
		/** @type {WebGLExtensions} */
		this.extensions = extensions;
		/** @type {WebGLCapabilities} */
		this.capabilities = capabilities;

		/** @type {boolean} */
		this.isWebGL2 = capabilities.isWebGL2;

		//

		this.colorBuffer = new ColorBuffer(this);
		this.depthBuffer = new DepthBuffer(this);
		this.stencilBuffer = new StencilBuffer(this);

		this.enabledCapabilities = {};

		/** @type {WebGLProgram} */
		this.currentProgram = null;

		/** @type {boolean} */
		this.currentBlendingEnabled = false;
		/** @type {number|null|undefined} */
		this.currentBlending = undefined;
		/** @type {number|null|undefined} */
		this.currentBlendEquation = undefined;
		/** @type {number|null|undefined} */
		this.currentBlendSrc = undefined;
		/** @type {number|null|undefined} */
		this.currentBlendDst = undefined;
		/** @type {number|null|undefined} */
		this.currentBlendEquationAlpha = undefined;
		/** @type {number|null|undefined} */
		this.currentBlendSrcAlpha = undefined;
		/** @type {number|null|undefined} */
		this.currentBlendDstAlpha = undefined;
		/** @type {boolean|null|undefined} */
		this.currentPremultipledAlpha = false;
		/** @type {boolean|null|undefined} */
		this.currentFlipSided = undefined;
		/** @type {number|null|undefined} */
		this.currentCullFace = undefined;
		/** @type {number|null|undefined} */
		this.currentLineWidth = undefined;

		/** @type {number|null|undefined} */
		this.currentPolygonOffsetFactor = undefined;
		/** @type {number|null|undefined} */
		this.currentPolygonOffsetUnits = undefined;

			/** @type {number} */
		this.maxTextures = /** @type {number} */ (gl.getParameter(gl.MAX_COMBINED_TEXTURE_IMAGE_UNITS));

		this.lineWidthAvailable = false;
		/** @type {number} */
		this.version = 0;
		/** @type {string} */
		const glVersion = /** @type {string} */ (gl.getParameter(gl.VERSION));

		if (glVersion.indexOf('WebGL') !== - 1) {

			this.version = parseFloat(/^WebGL (\d)/.exec(glVersion)[1]);
			this.lineWidthAvailable = (this.version >= 1.0);

		} else if (glVersion.indexOf('OpenGL ES') !== - 1) {

			this.version = parseFloat(/^OpenGL ES (\d)/.exec(glVersion)[1]);
			this.lineWidthAvailable = (this.version >= 2.0);

		}
		/** @type {number|null} */
		this.currentTextureSlot = null;
		/** @type {Object<(number|null),{ type : (number|undefined), texture : (WebGLTexture|undefined)}> }*/
		this.currentBoundTextures = {};

		this.currentScissor = new Vector4();
		this.currentViewport = new Vector4();


		/**
		 * @param {number} type 
		 * @param {number} target 
		 * @param {number} count 
		 * @return {WebGLTexture}
		 */
		function createTexture(type, target, count) {

			const data = new Uint8Array(4); // 4 is required to match default unpack alignment of 4.
			const texture = gl.createTexture();

			gl.bindTexture(type, texture);
			gl.texParameteri(type, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
			gl.texParameteri(type, gl.TEXTURE_MAG_FILTER, gl.NEAREST);

			for (let i = 0; i < count; i++) {

				gl.texImage2D(target + i, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, data);

			}

			return texture;

		}

		const emptyTextures = {};
		emptyTextures[gl.TEXTURE_2D] = createTexture(gl.TEXTURE_2D, gl.TEXTURE_2D, 1);
		emptyTextures[gl.TEXTURE_CUBE_MAP] = createTexture(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_CUBE_MAP_POSITIVE_X, 6);

		this.emptyTextures = emptyTextures;

		// init

		this.colorBuffer.setClear(0, 0, 0, 1);
		this.depthBuffer.setClear(1);
		this.stencilBuffer.setClear(0);


		this.buffers = {
			color: this.colorBuffer,
			depth: this.depthBuffer,
			stencil: this.stencilBuffer
		}

		this.enable(gl.DEPTH_TEST);
		this.depthBuffer.setFunc(LessEqualDepth);

		this.setFlipSided(false);
		this.setCullFace(CullFaceBack);
		this.enable(this.gl.CULL_FACE);

		this.setBlending(NoBlending);

		//

		this.equationToGL = {
			[AddEquation]: gl.FUNC_ADD,
			[SubtractEquation]: gl.FUNC_SUBTRACT,
			[ReverseSubtractEquation]: gl.FUNC_REVERSE_SUBTRACT
		};

		if (this.isWebGL2) {

			this.equationToGL[MinEquation] = gl.MIN;
			this.equationToGL[MaxEquation] = gl.MAX;

		} else {

			const extension = this.extensions.get('EXT_blend_minmax');

			if (extension !== null) {

				this.equationToGL[MinEquation] = extension.MIN_EXT;
				this.equationToGL[MaxEquation] = extension.MAX_EXT;

			}

		}

		this.factorToGL = {
			[ZeroFactor]: gl.ZERO,
			[OneFactor]: gl.ONE,
			[SrcColorFactor]: gl.SRC_COLOR,
			[SrcAlphaFactor]: gl.SRC_ALPHA,
			[SrcAlphaSaturateFactor]: gl.SRC_ALPHA_SATURATE,
			[DstColorFactor]: gl.DST_COLOR,
			[DstAlphaFactor]: gl.DST_ALPHA,
			[OneMinusSrcColorFactor]: gl.ONE_MINUS_SRC_COLOR,
			[OneMinusSrcAlphaFactor]: gl.ONE_MINUS_SRC_ALPHA,
			[OneMinusDstColorFactor]: gl.ONE_MINUS_DST_COLOR,
			[OneMinusDstAlphaFactor]: gl.ONE_MINUS_DST_ALPHA
		};

	}

	/**
	 * @param {number} id 
	 */
	enable(id) {

		if (this.enabledCapabilities[id] !== true) {

			this.gl.enable(id);
			this.enabledCapabilities[id] = true;

		}

	}

	/**
	 * @param {number} id 
	 */
	disable(id) {

		if (this.enabledCapabilities[id] !== false) {

			this.gl.disable(id);
			this.enabledCapabilities[id] = false;

		}

	}

	/**
 	* @param {WebGLProgram} program
 	* @return {boolean}
 	*/
	useProgram(program) {

		if (this.currentProgram !== program) {

			this.gl.useProgram(program);

			this.currentProgram = program;

			return true;

		}

		return false;

	}

	/**
	 * 
	 * @param {number} blending 
	 * @param {number=} blendEquation 
	 * @param {number=} blendSrc 
	 * @param {number=} blendDst 
	 * @param {number=} blendEquationAlpha 
	 * @param {number=} blendSrcAlpha 
	 * @param {number=} blendDstAlpha 
	 * @param {boolean=} premultipliedAlpha 
	 */
	setBlending(blending, blendEquation, blendSrc, blendDst, blendEquationAlpha, blendSrcAlpha, blendDstAlpha, premultipliedAlpha) {

		if (blending === NoBlending) {

			if (this.currentBlendingEnabled === true) {

				this.disable(this.gl.BLEND);
				this.currentBlendingEnabled = false;

			}

			return;

		}

		if (this.currentBlendingEnabled === false) {

			this.enable(this.gl.BLEND);
			this.currentBlendingEnabled = true;

		}

		if (blending !== CustomBlending) {

			if (blending !== this.currentBlending || premultipliedAlpha !== this.currentPremultipledAlpha) {

				if (this.currentBlendEquation !== AddEquation || this.currentBlendEquationAlpha !== AddEquation) {

					this.gl.blendEquation(this.gl.FUNC_ADD);

					this.currentBlendEquation = AddEquation;
					this.currentBlendEquationAlpha = AddEquation;

				}

				if (premultipliedAlpha) {

					switch (blending) {

						case NormalBlending:
							this.gl.blendFuncSeparate(this.gl.ONE, this.gl.ONE_MINUS_SRC_ALPHA, this.gl.ONE, this.gl.ONE_MINUS_SRC_ALPHA);
							break;

						case AdditiveBlending:
							this.gl.blendFunc(this.gl.ONE, this.gl.ONE);
							break;

						case SubtractiveBlending:
							this.gl.blendFuncSeparate(this.gl.ZERO, this.gl.ZERO, this.gl.ONE_MINUS_SRC_COLOR, this.gl.ONE_MINUS_SRC_ALPHA);
							break;

						case MultiplyBlending:
							this.gl.blendFuncSeparate(this.gl.ZERO, this.gl.SRC_COLOR, this.gl.ZERO, this.gl.SRC_ALPHA);
							break;

						default:
							console.error('THREE.WebGLState: Invalid blending: ', blending);
							break;

					}

				} else {

					switch (blending) {

						case NormalBlending:
							this.gl.blendFuncSeparate(this.gl.SRC_ALPHA, this.gl.ONE_MINUS_SRC_ALPHA, this.gl.ONE, this.gl.ONE_MINUS_SRC_ALPHA);
							break;

						case AdditiveBlending:
							this.gl.blendFunc(this.gl.SRC_ALPHA, this.gl.ONE);
							break;

						case SubtractiveBlending:
							this.gl.blendFunc(this.gl.ZERO, this.gl.ONE_MINUS_SRC_COLOR);
							break;

						case MultiplyBlending:
							this.gl.blendFunc(this.gl.ZERO, this.gl.SRC_COLOR);
							break;

						default:
							console.error('THREE.WebGLState: Invalid blending: ', blending);
							break;

					}

				}

				this.currentBlendSrc = null;
				this.currentBlendDst = null;
				this.currentBlendSrcAlpha = null;
				this.currentBlendDstAlpha = null;

				this.currentBlending = blending;
				this.currentPremultipledAlpha = premultipliedAlpha;

			}

			return;

		}

		// custom blending

		blendEquationAlpha = blendEquationAlpha || blendEquation;
		blendSrcAlpha = blendSrcAlpha || blendSrc;
		blendDstAlpha = blendDstAlpha || blendDst;

		if (blendEquation !== this.currentBlendEquation || blendEquationAlpha !== this.currentBlendEquationAlpha) {

			this.gl.blendEquationSeparate(this.equationToGL[blendEquation], this.equationToGL[blendEquationAlpha]);

			this.currentBlendEquation = blendEquation;
			this.currentBlendEquationAlpha = blendEquationAlpha;

		}

		if (blendSrc !== this.currentBlendSrc || blendDst !== this.currentBlendDst || blendSrcAlpha !== this.currentBlendSrcAlpha || blendDstAlpha !== this.currentBlendDstAlpha) {

			this.gl.blendFuncSeparate(this.factorToGL[blendSrc], this.factorToGL[blendDst], this.factorToGL[blendSrcAlpha], this.factorToGL[blendDstAlpha]);

			this.currentBlendSrc = blendSrc;
			this.currentBlendDst = blendDst;
			this.currentBlendSrcAlpha = blendSrcAlpha;
			this.currentBlendDstAlpha = blendDstAlpha;

		}

		this.currentBlending = blending;
		this.currentPremultipledAlpha = null;

	}

	/**
	 * 
	 * @param {MaterialInterface} material
	 * @param {boolean=} frontFaceCW 
	 */
	setMaterial(material, frontFaceCW) {

		material.side === DoubleSide
			? this.disable(this.gl.CULL_FACE)
			: this.enable(this.gl.CULL_FACE);

		let flipSided = (material.side === BackSide);
		if (frontFaceCW) flipSided = !flipSided;

		this.setFlipSided(flipSided);

		(material.blending === NormalBlending && material.transparent === false)
			? this.setBlending(NoBlending)
			: this.setBlending(material.blending, material.blendEquation, material.blendSrc, material.blendDst, material.blendEquationAlpha, material.blendSrcAlpha, material.blendDstAlpha, material.premultipliedAlpha);

		this.depthBuffer.setFunc(material.depthFunc);
		this.depthBuffer.setTest(material.depthTest);
		this.depthBuffer.setMask(material.depthWrite);
		this.colorBuffer.setMask(material.colorWrite);

		const stencilWrite = material.stencilWrite;
		this.stencilBuffer.setTest(stencilWrite);
		if (stencilWrite) {

			this.stencilBuffer.setMask(material.stencilWriteMask);
			this.stencilBuffer.setFunc(material.stencilFunc, material.stencilRef, material.stencilFuncMask);
			this.stencilBuffer.setOp(material.stencilFail, material.stencilZFail, material.stencilZPass);

		}

		this.setPolygonOffset(material.polygonOffset, material.polygonOffsetFactor, material.polygonOffsetUnits);

	}

	//
	/**
	 * 
	 * @param {boolean} flipSided 
	 */
	setFlipSided(flipSided) {

		if (this.currentFlipSided !== flipSided) {

			if (flipSided) {

				this.gl.frontFace(this.gl.CW);

			} else {

				this.gl.frontFace(this.gl.CCW);

			}

			this.currentFlipSided = flipSided;

		}

	}

	/**
	 * 
	 * @param {number} cullFace 
	 */
	setCullFace(cullFace) {

		if (cullFace !== CullFaceNone) {

			this.enable(this.gl.CULL_FACE);

			if (cullFace !== this.currentCullFace) {

				if (cullFace === CullFaceBack) {

					this.gl.cullFace(this.gl.BACK);

				} else if (cullFace === CullFaceFront) {

					this.gl.cullFace(this.gl.FRONT);

				} else {

					this.gl.cullFace(this.gl.FRONT_AND_BACK);

				}

			}

		} else {

			this.disable(this.gl.CULL_FACE);

		}

		this.currentCullFace = cullFace;

	}

	/**
	 * 
	 * @param {number} width 
	 */
	setLineWidth(width) {

		if (width !== this.currentLineWidth) {

			if (this.lineWidthAvailable) this.gl.lineWidth(width);

			this.currentLineWidth = width;

		}

	}

	/**
	 * 
	 * @param {boolean} polygonOffset 
	 * @param {number=} factor 
	 * @param {number=} units 
	 */
	setPolygonOffset(polygonOffset, factor, units) {

		if (polygonOffset) {

			this.enable(this.gl.POLYGON_OFFSET_FILL);

			if (this.currentPolygonOffsetFactor !== factor || this.currentPolygonOffsetUnits !== units) {

				this.gl.polygonOffset(factor, units);

				this.currentPolygonOffsetFactor = factor;
				this.currentPolygonOffsetUnits = units;

			}

		} else {

			this.disable(this.gl.POLYGON_OFFSET_FILL);

		}

	}

	/**
	 * @param {boolean} scissorTest 
	 */
	setScissorTest(scissorTest) {

		if (scissorTest) {

			this.enable(this.gl.SCISSOR_TEST);

		} else {

			this.disable(this.gl.SCISSOR_TEST);

		}

	}

	// texture

	/**
	 * 
	 * @param {number=} webglSlot 
	 */
	activeTexture(webglSlot) {

		if (webglSlot === undefined) webglSlot = this.gl.TEXTURE0 + this.maxTextures - 1;

		if (this.currentTextureSlot !== webglSlot) {

			this.gl.activeTexture(webglSlot);
			this.currentTextureSlot = webglSlot;

		}

	}

	/**
	 * 
	 * @param {number} webglType 
	 * @param {WebGLTexture} webglTexture 
	 */
	bindTexture(webglType, webglTexture) {

		if (this.currentTextureSlot === null) {

			this.activeTexture();

		}
		/** @type { { type : (number|undefined), texture : (WebGLTexture|undefined)} }*/
		let boundTexture = this.currentBoundTextures[this.currentTextureSlot];

		if (boundTexture === undefined) {

			boundTexture = { type: undefined, texture: undefined };
			this.currentBoundTextures[this.currentTextureSlot] = boundTexture;

		}

		if (boundTexture.type !== webglType || boundTexture.texture !== webglTexture) {

			this.gl.bindTexture(webglType, webglTexture || this.emptyTextures[webglType]);

			boundTexture.type = webglType;
			boundTexture.texture = webglTexture;

		}

	}

	unbindTexture() {

		/** @type { { type : (number|undefined), texture : (WebGLTexture|undefined)} } */
		const boundTexture = this.currentBoundTextures[this.currentTextureSlot];

		if (boundTexture !== undefined && boundTexture.type !== undefined) {

			this.gl.bindTexture(boundTexture.type, null);

			boundTexture.type = undefined;
			boundTexture.texture = undefined;

		}

	}

	/**
	 * @suppress {checkTypes, reportUnknownTypes}
	 */
	compressedTexImage2D() {

		try {

			this.gl.compressedTexImage2D.apply(this.gl, arguments);

		} catch (error) {

			console.error('THREE.WebGLState:', error);

		}

	}

	/**
	 * @suppress {checkTypes, reportUnknownTypes}
	 */
	texImage2D() {

		try {

			this.gl.texImage2D.apply(this.gl, arguments);

		} catch (error) {

			console.error('THREE.WebGLState:', error);

		}

	}

	/**
	 * @suppress {checkTypes, reportUnknownTypes}
	 */
	texImage3D() {

		try {

			this.gl.texImage3D.apply(this.gl, arguments);

		} catch (error) {

			console.error('THREE.WebGLState:', error);

		}

	}

	//
	/**
	 * 
	 * @param {Vector4} scissor 
	 */
	scissor(scissor) {

		if (this.currentScissor.equals(scissor) === false) {

			this.gl.scissor(scissor.x, scissor.y, scissor.z, scissor.w);
			this.currentScissor.copy(scissor);

		}

	}

	/**
	 * 
	 * @param {Vector4} viewport 
	 */
	viewport(viewport) {

		if (this.currentViewport.equals(viewport) === false) {

			this.gl.viewport(viewport.x, viewport.y, viewport.z, viewport.w);
			this.currentViewport.copy(viewport);

		}

	}

	//

	reset() {

		// reset state

		this.gl.disable(this.gl.BLEND);
		this.gl.disable(this.gl.CULL_FACE);
		this.gl.disable(this.gl.DEPTH_TEST);
		this.gl.disable(this.gl.POLYGON_OFFSET_FILL);
		this.gl.disable(this.gl.SCISSOR_TEST);
		this.gl.disable(this.gl.STENCIL_TEST);

		this.gl.blendEquation(this.gl.FUNC_ADD);
		this.gl.blendFunc(this.gl.ONE, this.gl.ZERO);
		this.gl.blendFuncSeparate(this.gl.ONE, this.gl.ZERO, this.gl.ONE, this.gl.ZERO);

		this.gl.colorMask(true, true, true, true);
		this.gl.clearColor(0, 0, 0, 0);

		this.gl.depthMask(true);
		this.gl.depthFunc(this.gl.LESS);
		this.gl.clearDepth(1);

		this.gl.stencilMask(0xffffffff);
		this.gl.stencilFunc(this.gl.ALWAYS, 0, 0xffffffff);
		this.gl.stencilOp(this.gl.KEEP, this.gl.KEEP, this.gl.KEEP);
		this.gl.clearStencil(0);

		this.gl.cullFace(this.gl.BACK);
		this.gl.frontFace(this.gl.CCW);

		this.gl.polygonOffset(0, 0);

		this.gl.activeTexture(this.gl.TEXTURE0);

		this.gl.useProgram(null);

		this.gl.lineWidth(1);

		this.gl.scissor(0, 0, this.gl.canvas.width, this.gl.canvas.height);
		this.gl.viewport(0, 0, this.gl.canvas.width, this.gl.canvas.height);

		// reset internals

		this.enabledCapabilities = {};

		this.currentTextureSlot = null;
		this.currentBoundTextures = {};

		this.currentProgram = null;

		this.currentBlendingEnabled = false;
		this.currentBlending = null;
		this.currentBlendEquation = null;
		this.currentBlendSrc = null;
		this.currentBlendDst = null;
		this.currentBlendEquationAlpha = null;
		this.currentBlendSrcAlpha = null;
		this.currentBlendDstAlpha = null;
		this.currentPremultipledAlpha = false;

		this.currentFlipSided = null;
		this.currentCullFace = null;

		this.currentLineWidth = null;

		this.currentPolygonOffsetFactor = null;
		this.currentPolygonOffsetUnits = null;

		this.colorBuffer.reset();
		this.depthBuffer.reset();
		this.stencilBuffer.reset();

	}

}

export { WebGLState };
