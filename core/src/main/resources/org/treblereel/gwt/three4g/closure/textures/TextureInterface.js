import { Texture } from '../../textures/Texture.js';

class TextureInterface extends Texture {

}

/** @type {boolean} */
TextureInterface.prototype.isTexture;
/** @type {boolean} */
TextureInterface.prototype.isVideoTexture;
/** @type {boolean} */
TextureInterface.prototype.isDataTexture2DArray;
/** @type {boolean} */
TextureInterface.prototype.isDataTexture3D;
/** @type {boolean} */
TextureInterface.prototype.isDepthTexture;
/** @type {boolean} */
TextureInterface.prototype.isCompressedTexture;
/** @type {boolean} */
TextureInterface.prototype.isDataTexture;

export { TextureInterface };