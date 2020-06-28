package org.treblereel.gwt.three4g.demo.client.api;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.extras.objects.ImmediateRenderObject;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/5/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MarchingCubes extends ImmediateRenderObject {


    public MeshStandardMaterial material;

    public MarchingCubes(int i, Material material, boolean b) {

    }

    public native void reset();

    public native void addBall(float x, float y, float z, float strength, float subtract);

    public native BufferGeometry generateBufferGeometry();
}