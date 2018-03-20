package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/19/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SphereBufferGeometry extends SphereGeometry{

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     */
    @JsConstructor
    public SphereBufferGeometry() {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius) {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     * @param widthSegments  — number of horizontal segments. Minimum value is 3, and the default is 8.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius, int widthSegments) {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     * @param widthSegments  — number of horizontal segments. Minimum value is 3, and the default is 8.
     * @param heightSegments — number of vertical segments. Minimum value is 2, and the default is 6.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius, int widthSegments, int heightSegments) {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     * @param widthSegments  — number of horizontal segments. Minimum value is 3, and the default is 8.
     * @param heightSegments — number of vertical segments. Minimum value is 2, and the default is 6.
     * @param phiStart       — specify horizontal starting angle. Default is 0.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius, int widthSegments, int heightSegments, float phiStart) {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     * @param widthSegments  — number of horizontal segments. Minimum value is 3, and the default is 8.
     * @param heightSegments — number of vertical segments. Minimum value is 2, and the default is 6.
     * @param phiStart       — specify horizontal starting angle. Default is 0.
     * @param phiLength      — specify horizontal sweep angle size. Default is Math.PI * 2.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius, int widthSegments, int heightSegments, float phiStart, float phiLength) {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     * @param widthSegments  — number of horizontal segments. Minimum value is 3, and the default is 8.
     * @param heightSegments — number of vertical segments. Minimum value is 2, and the default is 6.
     * @param phiStart       — specify horizontal starting angle. Default is 0.
     * @param phiLength      — specify horizontal sweep angle size. Default is Math.PI * 2.
     * @param thetaStart     — specify vertical starting angle. Default is 0.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius, int widthSegments, int heightSegments, float phiStart, float phiLength, float thetaStart) {

    }

    /**
     * The geometry is created by sweeping and calculating vertexes around the Y axis (horizontal sweep) and the Z axis
     * (vertical sweep). Thus, incomplete spheres (akin to 'sphere slices') can be created through the use of different
     * values of phiStart, phiLength, thetaStart and thetaLength, in order to define the points in which we start (or end)
     * calculating those vertices.
     *
     * @param radius         — sphere radius. Default is 1.
     * @param widthSegments  — number of horizontal segments. Minimum value is 3, and the default is 8.
     * @param heightSegments — number of vertical segments. Minimum value is 2, and the default is 6.
     * @param phiStart       — specify horizontal starting angle. Default is 0.
     * @param phiLength      — specify horizontal sweep angle size. Default is Math.PI * 2.
     * @param thetaStart     — specify vertical starting angle. Default is 0.
     * @param thetaLength    — specify vertical sweep angle size. Default is Math.PI.
     */
    @JsConstructor
    public SphereBufferGeometry(float radius, int widthSegments, int heightSegments, float phiStart, float phiLength, float thetaStart, float thetaLength) {

    }
}
