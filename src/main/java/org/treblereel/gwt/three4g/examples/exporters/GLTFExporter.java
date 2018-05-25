package org.treblereel.gwt.three4g.examples.exporters;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * An exporter for glTF 2.0.
 * <p>
 * glTF (GL Transmission Format) is an open format specification for efficient delivery and loading of 3D content. Assets may be provided either in JSON (.gltf) or binary (.glb) format. External files store textures (.jpg, .png) and additional binary data (.bin). A glTF asset may deliver one or more scenes, including meshes, materials, textures, skins, skeletons, morph targets, animations, lights, and/or cameras.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class GLTFExporter {

    public GLTFExporter() {

    }

    /**
     * Generates a .gltf (JSON) or .glb (binary) output from the input (Scenes or Objects)
     *
     * @param input       — Scenes or objects to export. Valid options:
     *                    Export scenes
     *                    exporter.parse( scene1, ... )
     *                    exporter.parse( [ scene1, scene2 ], ... )
     *                    Export objects (It will create a new Scene to hold all the objects)
     *                    exporter.parse( object1, ... )
     *                    exporter.parse( [ object1, object2 ], ... )
     *                    Mix scenes and objects (It will export the scenes as usual but it will create a new scene to hold all the single objects).
     *                    exporter.parse( [ scene1, object1, object2, scene2 ], ... )
     * @param onCompleted — Will be called when the export completes. The argument will be the generated glTF JSON or binary ArrayBuffer.
     * @param options     — Export options
     *                    trs - bool. Export position, rotation and scale instead of matrix per node. Default is false
     *                    onlyVisible - bool. Export only visible objects. Default is true.
     *                    truncateDrawRange - bool. Export just the attributes within the drawRange, if defined, instead of exporting the whole array. Default is true.
     *                    binary - bool. Export in binary (.glb) format, returning an ArrayBuffer. Default is false.
     *                    embedImages - bool. Export with images embedded into the glTF asset. Default is true.
     *                    animations - AnimationClip[]. List of animations to be included in the export.
     *                    forceIndices - bool. Generate indices for non-index geometry and export with them. Default is false.
     *                    forcePowerOfTwoTextures - bool. Export with images resized to POT size. This option works only if embedImages is true. Default is false.
     */
    public native void parse(Object3D input, OnCompleted onCompleted, GLTFExporterOptions options);


    public native void parse(Object3D[] inputs, OnCompleted onCompleted, GLTFExporterOptions options);


}
