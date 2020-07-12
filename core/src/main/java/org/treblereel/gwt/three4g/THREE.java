package org.treblereel.gwt.three4g;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Mouse;

/**
 * Material Constants
 * These constants define properties common to all material types, with the exception of Texture Combine Operations which
 * only apply to MeshBasicMaterial, MeshLambertMaterial and MeshPhongMaterial.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/5/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "THREE")
public class THREE {

    public static int REVISION;
    public static Mouse MOUSE;
    public static int CullFaceNone;
    public static int CullFaceBack;
    public static int CullFaceFront;
    public static int CullFaceFrontBack;
    public static int FrontFaceDirectionCW;
    public static int FrontFaceDirectionCCW;
    public static int BasicShadowMap;
    public static int PCFShadowMap;
    public static int PCFSoftShadowMap;
    public static int FrontSide;
    public static int BackSide;
    public static int DoubleSide;
    public static int FlatShading;
    public static int SmoothShading;
    public static int NoColors;
    public static int FaceColors;
    public static int VertexColors;
    public static int NoBlending;
    public static int NormalBlending;
    public static int AdditiveBlending;
    public static int SubtractiveBlending;
    public static int MultiplyBlending;
    public static int CustomBlending;
    public static int AddEquation;
    public static int SubtractEquation;
    public static int ReverseSubtractEquation;
    public static int MinEquation;
    public static int MaxEquation;
    public static int ZeroFactor;
    public static int OneFactor;
    public static int SrcColorFactor;
    public static int OneMinusSrcColorFactor;
    public static int SrcAlphaFactor;
    public static int OneMinusSrcAlphaFactor;
    public static int DstAlphaFactor;
    public static int OneMinusDstAlphaFactor;
    public static int DstColorFactor;
    public static int OneMinusDstColorFactor;
    public static int SrcAlphaSaturateFactor;
    public static int NeverDepth;
    public static int AlwaysDepth;
    public static int LessDepth;
    public static int LessEqualDepth;
    public static int EqualDepth;
    public static int GreaterEqualDepth;
    public static int GreaterDepth;
    public static int NotEqualDepth;
    public static int MultiplyOperation;
    public static int MixOperation;
    public static int AddOperation;
    public static int NoToneMapping;
    public static int LinearToneMapping;
    public static int ReinhardToneMapping;
    public static int Uncharted2ToneMapping;
    public static int CineonToneMapping;
    public static int ACESFilmicToneMapping;
    public static int UVMapping;
    public static int CubeReflectionMapping;
    public static int CubeRefractionMapping;
    public static int EquirectangularReflectionMapping;
    public static int EquirectangularRefractionMapping;
    public static int SphericalReflectionMapping;
    public static int CubeUVReflectionMapping;
    public static int CubeUVRefractionMapping;
    public static int RepeatWrapping;
    public static int ClampToEdgeWrapping;
    public static int MirroredRepeatWrapping;
    public static int NearestFilter;
    public static int NearestMipmapNearestFilter;
    public static int NearestMipmapLinearFilter;
    public static int LinearFilter;
    public static int LinearMipmapNearestFilter;
    public static int LinearMipmapLinearFilter;
    public static int UnsignedByteType;
    public static int ByteType;
    public static int ShortType;
    public static int UnsignedShortType;
    public static int IntType;
    public static int UnsignedIntType;
    public static int FloatType;
    public static int HalfFloatType;
    public static int UnsignedShort4444Type;
    public static int UnsignedShort5551Type;
    public static int UnsignedShort565Type;
    public static int UnsignedInt248Type;
    public static int AlphaFormat;
    public static int RGBFormat;
    public static int RGBAFormat;
    public static int LuminanceFormat;
    public static int LuminanceAlphaFormat;
    public static String RGBEFormat;
    public static int DepthFormat;
    public static int DepthStencilFormat;
    public static int RedFormat;
    public static int RGB_S3TC_DXT1_Format;
    public static int RGBA_S3TC_DXT1_Format;
    public static int RGBA_S3TC_DXT3_Format;
    public static int RGBA_S3TC_DXT5_Format;
    public static int RGB_PVRTC_4BPPV1_Format;
    public static int RGB_PVRTC_2BPPV1_Format;
    public static int RGBA_PVRTC_4BPPV1_Format;
    public static int RGBA_PVRTC_2BPPV1_Format;
    public static int RGB_ETC1_Format;
    public static int RGBA_ASTC_4x4_Format;
    public static int RGBA_ASTC_5x4_Format;
    public static int RGBA_ASTC_5x5_Format;
    public static int RGBA_ASTC_6x5_Format;
    public static int RGBA_ASTC_6x6_Format;
    public static int RGBA_ASTC_8x5_Format;
    public static int RGBA_ASTC_8x6_Format;
    public static int RGBA_ASTC_8x8_Format;
    public static int RGBA_ASTC_10x5_Format;
    public static int RGBA_ASTC_10x6_Format;
    public static int RGBA_ASTC_10x8_Format;
    public static int RGBA_ASTC_10x10_Format;
    public static int RGBA_ASTC_12x10_Format;
    public static int RGBA_ASTC_12x12_Format;
    public static int LoopOnce;
    public static int LoopRepeat;
    public static int LoopPingPong;
    public static int InterpolateDiscrete;
    public static int InterpolateLinear;
    public static int InterpolateSmooth;
    public static int ZeroCurvatureEnding;
    public static int ZeroSlopeEnding;
    public static int WrapAroundEnding;
    public static int TrianglesDrawMode;
    public static int TriangleStripDrawMode;
    public static int TriangleFanDrawMode;
    public static int LinearEncoding;
    public static int sRGBEncoding;
    public static int GammaEncoding;
    public static int RGBEEncoding;
    public static int LogLuvEncoding;
    public static int RGBM7Encoding;
    public static int RGBM16Encoding;
    public static int RGBDEncoding;
    public static int BasicDepthPacking;
    public static int RGBADepthPacking;
    public static int TangentSpaceNormalMap;
    public static int ObjectSpaceNormalMap;

    public static int NeverStencilFunc;
    public static int LessStencilFunc;
    public static int EqualStencilFunc;
    public static int LessEqualStencilFunc;
    public static int GreaterStencilFunc;
    public static int NotEqualStencilFunc;
    public static int GreaterEqualStencilFunc;
    public static int AlwaysStencilFunc;

    public static int ZeroStencilOp;
    public static int KeepStencilOp;
    public static int ReplaceStencilOp;
    public static int IncrementStencilOp;
    public static int DecrementStencilOp;
    public static int IncrementWrapStencilOp;
    public static int DecrementWrapStencilOp;
    public static int InvertStencilOp;



}