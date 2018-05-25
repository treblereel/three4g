package org.treblereel.gwt.three4g.examples.exporters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.AnimationClip;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class GLTFExporterOptions {

    /**
     * Export position, rotation and scale instead of matrix per node. Default is false
     */
    public boolean trs;

    /**
     * Export only visible objects. Default is true.
     */
    public boolean onlyVisible;

    /**
     * Export just the attributes within the drawRange, if defined, instead of exporting the whole array. Default is true.
     */
    public boolean truncateDrawRange;

    /**
     * Export in binary (.glb) format, returning an ArrayBuffer. Default is false.
     */
    public boolean binary;

    /**
     * Export with images embedded into the glTF asset. Default is true.
     */
    public boolean embedImages;

    /**
     * List of animations to be included in the export.
     */
    public AnimationClip[] animations;

    /**
     * Generate indices for non-index geometry and export with them. Default is false.
     */
    public boolean forceIndices;

    /**
     * export with images resized to POT size. This option works only if embedImages is true. Default is false.
     */
    public boolean forcePowerOfTwoTextures;
}
