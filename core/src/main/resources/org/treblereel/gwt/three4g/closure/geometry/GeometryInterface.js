import { BufferGeometry } from '../../core/BufferGeometry.js';
/**
 * @extends {BufferGeometry}
*/
class GeometryInterface { };

/** @type {number} */
GeometryInterface.prototype.id;
/** @type {number} */
GeometryInterface.prototype.instanceCount;
/** @type {number} */
GeometryInterface.prototype._maxInstanceCount;

/** @type {boolean} */
GeometryInterface.prototype.isInstancedBufferGeometry;

export { GeometryInterface };