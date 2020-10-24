/**
 * @externs
 */

const ShaderChunk = {
    alphamap_fragment: {},
    alphamap_pars_fragment: {},
    alphatest_fragment: {},
    aomap_fragment: {},
    aomap_pars_fragment: {},
    begin_vertex: {},
    beginnormal_vertex: {},
    bsdfs: {},
    bumpmap_pars_fragment: {},
    clipping_planes_fragment: {},
    clipping_planes_pars_fragment: {},
    clipping_planes_pars_vertex: {},
    clipping_planes_vertex: {},
    color_fragment: {},
    color_pars_fragment: {},
    color_pars_vertex: {},
    color_vertex: {},
    common: {},
    cube_uv_reflection_fragment: {},
    defaultnormal_vertex: {},
    displacementmap_pars_vertex: {},
    displacementmap_vertex: {},
    emissivemap_fragment: {},
    emissivemap_pars_fragment: {},
    encodings_fragment: {},
    encodings_pars_fragment: {},
    envmap_fragment: {},
    envmap_common_pars_fragment: {},
    envmap_pars_fragment: {},
    envmap_pars_vertex: {},
    envmap_physical_pars_fragment: {},
    envmap_vertex: {},
    fog_vertex: {},
    fog_pars_vertex: {},
    fog_fragment: {},
    fog_pars_fragment: {},
    gradientmap_pars_fragment: {},
    lightmap_fragment: {},
    lightmap_pars_fragment: {},
    lights_lambert_vertex: {},
    lights_pars_begin: {},
    lights_toon_fragment: {},
    lights_toon_pars_fragment: {},
    lights_phong_fragment: {},
    lights_phong_pars_fragment: {},
    lights_physical_fragment: {},
    lights_physical_pars_fragment: {},
    lights_fragment_begin: {},
    lights_fragment_maps: {},
    lights_fragment_end: {},
    logdepthbuf_fragment: {},
    logdepthbuf_pars_fragment: {},
    logdepthbuf_pars_vertex: {},
    logdepthbuf_vertex: {},
    map_fragment: {},
    map_pars_fragment: {},
    map_particle_fragment: {},
    map_particle_pars_fragment: {},
    metalnessmap_fragment: {},
    metalnessmap_pars_fragment: {},
    morphnormal_vertex: {},
    morphtarget_pars_vertex: {},
    morphtarget_vertex: {},
    normal_fragment_begin: {},
    normal_fragment_maps: {},
    normalmap_pars_fragment: {},
    clearcoat_normal_fragment_begin: {},
    clearcoat_normal_fragment_maps: {},
    clearcoat_pars_fragment: {},
    packing: {},
    premultiplied_alpha_fragment: {},
    project_vertex: {},
    dithering_fragment: {},
    dithering_pars_fragment: {},
    roughnessmap_fragment: {},
    roughnessmap_pars_fragment: {},
    shadowmap_pars_fragment: {},
    shadowmap_pars_vertex: {},
    shadowmap_vertex: {},
    shadowmask_pars_fragment: {},
    skinbase_vertex: {},
    skinning_pars_vertex: {},
    skinning_vertex: {},
    skinnormal_vertex: {},
    specularmap_fragment: {},
    specularmap_pars_fragment: {},
    tonemapping_fragment: {},
    tonemapping_pars_fragment: {},
    transmissionmap_fragment: {},
    transmissionmap_pars_fragment: {},
    uv_pars_fragment: {},
    uv_pars_vertex: {},
    uv_vertex: {},
    uv2_pars_fragment: {},
    uv2_pars_vertex: {},
    uv2_vertex: {},
    worldpos_vertex: {},
    background_frag: {},
    background_vert: {},
    cube_frag: {},
    cube_vert: {},
    depth_frag: {},
    depth_vert: {},
    distanceRGBA_frag: {},
    distanceRGBA_vert: {},
    equirect_frag: {},
    equirect_vert: {},
    linedashed_frag: {},
    linedashed_vert: {},
    meshbasic_frag: {},
    meshbasic_vert: {},
    meshlambert_frag: {},
    meshlambert_vert: {},
    meshmatcap_frag: {},
    meshmatcap_vert: {},
    meshtoon_frag: {},
    meshtoon_vert: {},
    meshphong_frag: {},
    meshphong_vert: {},
    meshphysical_frag: {},
    meshphysical_vert: {},
    normal_frag: {},
    normal_vert: {},
    points_frag: {},
    points_vert: {},
    shadow_frag: {},
    shadow_vert: {},
    sprite_frag: {},
    sprite_vert: {}
}

const ShaderLib = {
    basic: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            specularMap: {
                value: function () { }
            },
            envMap: {
                value: function () { }
            },
            flipEnvMap: {
                value: {}
            },
            reflectivity: {
                value: {}
            },
            refractionRatio: {
                value: {}
            },
            maxMipLevel: {
                value: {}
            },
            aoMap: {
                value: function () { }
            },
            aoMapIntensity: {
                value: {}
            },
            lightMap: {
                value: function () { }
            },
            lightMapIntensity: {
                value: {}
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    lambert: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            specularMap: {
                value: function () { }
            },
            envMap: {
                value: function () { }
            },
            flipEnvMap: {
                value: {}
            },
            reflectivity: {
                value: {}
            },
            refractionRatio: {
                value: {}
            },
            maxMipLevel: {
                value: {}
            },
            aoMap: {
                value: function () { }
            },
            aoMapIntensity: {
                value: {}
            },
            lightMap: {
                value: function () { }
            },
            lightMapIntensity: {
                value: {}
            },
            emissiveMap: {
                value: function () { }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            ambientLightColor: {
                value: function () { }
            },
            lightProbe: {
                value: function () { }
            },
            directionalLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    color: function () { }
                }
            },
            directionalLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            directionalShadowMap: {
                value: function () { }
            },
            directionalShadowMatrix: {
                value: function () { }
            },
            spotLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    direction: function () { },
                    distance: function () { },
                    coneCos: function () { },
                    penumbraCos: function () { },
                    decay: function () { }
                }
            },
            spotLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            spotShadowMap: {
                value: function () { }
            },
            spotShadowMatrix: {
                value: function () { }
            },
            pointLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    decay: function () { },
                    distance: function () { }
                }
            },
            pointLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { },
                    shadowCameraNear: function () { },
                    shadowCameraFar: function () { }
                }
            },
            pointShadowMap: {
                value: function () { }
            },
            pointShadowMatrix: {
                value: function () { }
            },
            hemisphereLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    skyColor: function () { },
                    groundColor: function () { }
                }
            },
            rectAreaLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    width: function () { },
                    height: function () { }
                }
            },
            ltc_1: {
                value: function () { }
            },
            ltc_2: {
                value: function () { }
            },
            emissive: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    phong: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            specularMap: {
                value: function () { }
            },
            envMap: {
                value: function () { }
            },
            flipEnvMap: {
                value: {}
            },
            reflectivity: {
                value: {}
            },
            refractionRatio: {
                value: {}
            },
            maxMipLevel: {
                value: {}
            },
            aoMap: {
                value: function () { }
            },
            aoMapIntensity: {
                value: {}
            },
            lightMap: {
                value: function () { }
            },
            lightMapIntensity: {
                value: {}
            },
            emissiveMap: {
                value: function () { }
            },
            bumpMap: {
                value: function () { }
            },
            bumpScale: {
                value: {}
            },
            normalMap: {
                value: function () { }
            },
            normalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            ambientLightColor: {
                value: function () { }
            },
            lightProbe: {
                value: function () { }
            },
            directionalLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    color: function () { }
                }
            },
            directionalLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            directionalShadowMap: {
                value: function () { }
            },
            directionalShadowMatrix: {
                value: function () { }
            },
            spotLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    direction: function () { },
                    distance: function () { },
                    coneCos: function () { },
                    penumbraCos: function () { },
                    decay: function () { }
                }
            },
            spotLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            spotShadowMap: {
                value: function () { }
            },
            spotShadowMatrix: {
                value: function () { }
            },
            pointLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    decay: function () { },
                    distance: function () { }
                }
            },
            pointLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { },
                    shadowCameraNear: function () { },
                    shadowCameraFar: function () { }
                }
            },
            pointShadowMap: {
                value: function () { }
            },
            pointShadowMatrix: {
                value: function () { }
            },
            hemisphereLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    skyColor: function () { },
                    groundColor: function () { }
                }
            },
            rectAreaLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    width: function () { },
                    height: function () { }
                }
            },
            ltc_1: {
                value: function () { }
            },
            ltc_2: {
                value: function () { }
            },
            emissive: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            specular: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            shininess: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    standard: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            envMap: {
                value: function () { }
            },
            flipEnvMap: {
                value: {}
            },
            reflectivity: {
                value: {}
            },
            refractionRatio: {
                value: {}
            },
            maxMipLevel: {
                value: {}
            },
            aoMap: {
                value: function () { }
            },
            aoMapIntensity: {
                value: {}
            },
            lightMap: {
                value: function () { }
            },
            lightMapIntensity: {
                value: {}
            },
            emissiveMap: {
                value: function () { }
            },
            bumpMap: {
                value: function () { }
            },
            bumpScale: {
                value: {}
            },
            normalMap: {
                value: function () { }
            },
            normalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            },
            roughnessMap: {
                value: function () { }
            },
            metalnessMap: {
                value: function () { }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            ambientLightColor: {
                value: function () { }
            },
            lightProbe: {
                value: function () { }
            },
            directionalLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    color: function () { }
                }
            },
            directionalLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            directionalShadowMap: {
                value: function () { }
            },
            directionalShadowMatrix: {
                value: function () { }
            },
            spotLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    direction: function () { },
                    distance: function () { },
                    coneCos: function () { },
                    penumbraCos: function () { },
                    decay: function () { }
                }
            },
            spotLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            spotShadowMap: {
                value: function () { }
            },
            spotShadowMatrix: {
                value: function () { }
            },
            pointLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    decay: function () { },
                    distance: function () { }
                }
            },
            pointLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { },
                    shadowCameraNear: function () { },
                    shadowCameraFar: function () { }
                }
            },
            pointShadowMap: {
                value: function () { }
            },
            pointShadowMatrix: {
                value: function () { }
            },
            hemisphereLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    skyColor: function () { },
                    groundColor: function () { }
                }
            },
            rectAreaLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    width: function () { },
                    height: function () { }
                }
            },
            ltc_1: {
                value: function () { }
            },
            ltc_2: {
                value: function () { }
            },
            emissive: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            roughness: {
                value: {}
            },
            metalness: {
                value: {}
            },
            envMapIntensity: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    toon: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            aoMap: {
                value: function () { }
            },
            aoMapIntensity: {
                value: {}
            },
            lightMap: {
                value: function () { }
            },
            lightMapIntensity: {
                value: {}
            },
            emissiveMap: {
                value: function () { }
            },
            bumpMap: {
                value: function () { }
            },
            bumpScale: {
                value: {}
            },
            normalMap: {
                value: function () { }
            },
            normalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            },
            gradientMap: {
                value: function () { }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            ambientLightColor: {
                value: function () { }
            },
            lightProbe: {
                value: function () { }
            },
            directionalLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    color: function () { }
                }
            },
            directionalLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            directionalShadowMap: {
                value: function () { }
            },
            directionalShadowMatrix: {
                value: function () { }
            },
            spotLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    direction: function () { },
                    distance: function () { },
                    coneCos: function () { },
                    penumbraCos: function () { },
                    decay: function () { }
                }
            },
            spotLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            spotShadowMap: {
                value: function () { }
            },
            spotShadowMatrix: {
                value: function () { }
            },
            pointLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    decay: function () { },
                    distance: function () { }
                }
            },
            pointLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { },
                    shadowCameraNear: function () { },
                    shadowCameraFar: function () { }
                }
            },
            pointShadowMap: {
                value: function () { }
            },
            pointShadowMatrix: {
                value: function () { }
            },
            hemisphereLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    skyColor: function () { },
                    groundColor: function () { }
                }
            },
            rectAreaLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    width: function () { },
                    height: function () { }
                }
            },
            ltc_1: {
                value: function () { }
            },
            ltc_2: {
                value: function () { }
            },
            emissive: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    matcap: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            bumpMap: {
                value: function () { }
            },
            bumpScale: {
                value: {}
            },
            normalMap: {
                value: function () { }
            },
            normalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            matcap: {
                value: function () { }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    points: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            size: {
                value: {}
            },
            scale: {
                value: {}
            },
            map: {
                value: function () { }
            },
            alphaMap: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    dashed: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            scale: {
                value: {}
            },
            dashSize: {
                value: {}
            },
            totalSize: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    depth: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    normal: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            bumpMap: {
                value: function () { }
            },
            bumpScale: {
                value: {}
            },
            normalMap: {
                value: function () { }
            },
            normalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    sprite: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            center: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            rotation: {
                value: {}
            },
            map: {
                value: function () { }
            },
            alphaMap: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    background: {
        uniforms: {
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            t2D: {
                value: function () { }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    cube: {
        uniforms: {
            envMap: {
                value: function () { }
            },
            flipEnvMap: {
                value: {}
            },
            reflectivity: {
                value: {}
            },
            refractionRatio: {
                value: {}
            },
            maxMipLevel: {
                value: {}
            },
            opacity: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    equirect: {
        uniforms: {
            tEquirect: {
                value: function () { }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    distanceRGBA: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            },
            referencePosition: {
                value: {
                    x: {},
                    y: {},
                    z: {},
                    isVector3: {},
                    setEulerFromRotationMatrix: function () { },
                    setEulerFromQuaternion: function () { },
                    getPositionFromMatrix: function () { },
                    getScaleFromMatrix: function () { },
                    getColumnFromMatrix: function () { },
                    applyProjection: function () { },
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            nearDistance: {
                value: {}
            },
            farDistance: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    shadow: {
        uniforms: {
            ambientLightColor: {
                value: function () { }
            },
            lightProbe: {
                value: function () { }
            },
            directionalLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    color: function () { }
                }
            },
            directionalLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            directionalShadowMap: {
                value: function () { }
            },
            directionalShadowMatrix: {
                value: function () { }
            },
            spotLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    direction: function () { },
                    distance: function () { },
                    coneCos: function () { },
                    penumbraCos: function () { },
                    decay: function () { }
                }
            },
            spotLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            spotShadowMap: {
                value: function () { }
            },
            spotShadowMatrix: {
                value: function () { }
            },
            pointLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    decay: function () { },
                    distance: function () { }
                }
            },
            pointLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { },
                    shadowCameraNear: function () { },
                    shadowCameraFar: function () { }
                }
            },
            pointShadowMap: {
                value: function () { }
            },
            pointShadowMatrix: {
                value: function () { }
            },
            hemisphereLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    skyColor: function () { },
                    groundColor: function () { }
                }
            },
            rectAreaLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    width: function () { },
                    height: function () { }
                }
            },
            ltc_1: {
                value: function () { }
            },
            ltc_2: {
                value: function () { }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            color: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            }
        },
        vertexShader: {},
        fragmentShader: {}
    },
    physical: {
        uniforms: {
            diffuse: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            opacity: {
                value: {}
            },
            map: {
                value: function () { }
            },
            uvTransform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            uv2Transform: {
                value: {
                    elements: {
                        "0": {},
                        "1": {},
                        "2": {},
                        "3": {},
                        "4": {},
                        "5": {},
                        "6": {},
                        "7": {},
                        "8": {}
                    },
                    isMatrix3: {},
                    flattenToArrayOffset: function () { },
                    multiplyVector3: function () { },
                    multiplyVector3Array: function () { },
                    applyToBufferAttribute: function () { },
                    applyToVector3Array: function () { },
                    getInverse: function () { }
                }
            },
            alphaMap: {
                value: function () { }
            },
            envMap: {
                value: function () { }
            },
            flipEnvMap: {
                value: {}
            },
            reflectivity: {
                value: {}
            },
            refractionRatio: {
                value: {}
            },
            maxMipLevel: {
                value: {}
            },
            aoMap: {
                value: function () { }
            },
            aoMapIntensity: {
                value: {}
            },
            lightMap: {
                value: function () { }
            },
            lightMapIntensity: {
                value: {}
            },
            emissiveMap: {
                value: function () { }
            },
            bumpMap: {
                value: function () { }
            },
            bumpScale: {
                value: {}
            },
            normalMap: {
                value: function () { }
            },
            normalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            displacementMap: {
                value: function () { }
            },
            displacementScale: {
                value: {}
            },
            displacementBias: {
                value: {}
            },
            roughnessMap: {
                value: function () { }
            },
            metalnessMap: {
                value: function () { }
            },
            fogDensity: {
                value: {}
            },
            fogNear: {
                value: {}
            },
            fogFar: {
                value: {}
            },
            fogColor: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            ambientLightColor: {
                value: function () { }
            },
            lightProbe: {
                value: function () { }
            },
            directionalLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    color: function () { }
                }
            },
            directionalLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            directionalShadowMap: {
                value: function () { }
            },
            directionalShadowMatrix: {
                value: function () { }
            },
            spotLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    direction: function () { },
                    distance: function () { },
                    coneCos: function () { },
                    penumbraCos: function () { },
                    decay: function () { }
                }
            },
            spotLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { }
                }
            },
            spotShadowMap: {
                value: function () { }
            },
            spotShadowMatrix: {
                value: function () { }
            },
            pointLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    decay: function () { },
                    distance: function () { }
                }
            },
            pointLightShadows: {
                value: function () { },
                properties: {
                    shadowBias: function () { },
                    shadowNormalBias: function () { },
                    shadowRadius: function () { },
                    shadowMapSize: function () { },
                    shadowCameraNear: function () { },
                    shadowCameraFar: function () { }
                }
            },
            pointShadowMap: {
                value: function () { }
            },
            pointShadowMatrix: {
                value: function () { }
            },
            hemisphereLights: {
                value: function () { },
                properties: {
                    direction: function () { },
                    skyColor: function () { },
                    groundColor: function () { }
                }
            },
            rectAreaLights: {
                value: function () { },
                properties: {
                    color: function () { },
                    position: function () { },
                    width: function () { },
                    height: function () { }
                }
            },
            ltc_1: {
                value: function () { }
            },
            ltc_2: {
                value: function () { }
            },
            emissive: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            roughness: {
                value: {}
            },
            metalness: {
                value: {}
            },
            envMapIntensity: {
                value: {}
            },
            clearcoat: {
                value: {}
            },
            clearcoatMap: {
                value: function () { }
            },
            clearcoatRoughness: {
                value: {}
            },
            clearcoatRoughnessMap: {
                value: function () { }
            },
            clearcoatNormalScale: {
                value: {
                    x: {},
                    y: {},
                    isVector2: {},
                    fromAttribute: function () { },
                    distanceToManhattan: function () { },
                    lengthManhattan: function () { }
                }
            },
            clearcoatNormalMap: {
                value: function () { }
            },
            sheen: {
                value: {
                    r: {},
                    g: {},
                    b: {},
                    isColor: {}
                }
            },
            transmission: {
                value: {}
            },
            transmissionMap: {
                value: function () { }
            }
        },
        vertexShader: {},
        fragmentShader: {}
    }
}

const Uniform = function () { }

const UniformsLib = {
    common: {
        diffuse: {
            value: {
                r: {},
                g: {},
                b: {},
                isColor: {}
            }
        },
        opacity: {
            value: {}
        },
        map: {
            value: function () { }
        },
        uvTransform: {
            value: {
                elements: {
                    "0": {},
                    "1": {},
                    "2": {},
                    "3": {},
                    "4": {},
                    "5": {},
                    "6": {},
                    "7": {},
                    "8": {}
                },
                isMatrix3: {},
                flattenToArrayOffset: function () { },
                multiplyVector3: function () { },
                multiplyVector3Array: function () { },
                applyToBufferAttribute: function () { },
                applyToVector3Array: function () { },
                getInverse: function () { }
            }
        },
        uv2Transform: {
            value: {
                elements: {
                    "0": {},
                    "1": {},
                    "2": {},
                    "3": {},
                    "4": {},
                    "5": {},
                    "6": {},
                    "7": {},
                    "8": {}
                },
                isMatrix3: {},
                flattenToArrayOffset: function () { },
                multiplyVector3: function () { },
                multiplyVector3Array: function () { },
                applyToBufferAttribute: function () { },
                applyToVector3Array: function () { },
                getInverse: function () { }
            }
        },
        alphaMap: {
            value: function () { }
        }
    },
    specularmap: {
        specularMap: {
            value: function () { }
        }
    },
    envmap: {
        envMap: {
            value: function () { }
        },
        flipEnvMap: {
            value: {}
        },
        reflectivity: {
            value: {}
        },
        refractionRatio: {
            value: {}
        },
        maxMipLevel: {
            value: {}
        }
    },
    aomap: {
        aoMap: {
            value: function () { }
        },
        aoMapIntensity: {
            value: {}
        }
    },
    lightmap: {
        lightMap: {
            value: function () { }
        },
        lightMapIntensity: {
            value: {}
        }
    },
    emissivemap: {
        emissiveMap: {
            value: function () { }
        }
    },
    bumpmap: {
        bumpMap: {
            value: function () { }
        },
        bumpScale: {
            value: {}
        }
    },
    normalmap: {
        normalMap: {
            value: function () { }
        },
        normalScale: {
            value: {
                x: {},
                y: {},
                isVector2: {},
                fromAttribute: function () { },
                distanceToManhattan: function () { },
                lengthManhattan: function () { }
            }
        }
    },
    displacementmap: {
        displacementMap: {
            value: function () { }
        },
        displacementScale: {
            value: {}
        },
        displacementBias: {
            value: {}
        }
    },
    roughnessmap: {
        roughnessMap: {
            value: function () { }
        }
    },
    metalnessmap: {
        metalnessMap: {
            value: function () { }
        }
    },
    gradientmap: {
        gradientMap: {
            value: function () { }
        }
    },
    fog: {
        fogDensity: {
            value: {}
        },
        fogNear: {
            value: {}
        },
        fogFar: {
            value: {}
        },
        fogColor: {
            value: {
                r: {},
                g: {},
                b: {},
                isColor: {}
            }
        }
    },
    lights: {
        ambientLightColor: {
            value: function () { }
        },
        lightProbe: {
            value: function () { }
        },
        directionalLights: {
            value: function () { },
            properties: {
                direction: function () { },
                color: function () { }
            }
        },
        directionalLightShadows: {
            value: function () { },
            properties: {
                shadowBias: function () { },
                shadowNormalBias: function () { },
                shadowRadius: function () { },
                shadowMapSize: function () { }
            }
        },
        directionalShadowMap: {
            value: function () { }
        },
        directionalShadowMatrix: {
            value: function () { }
        },
        spotLights: {
            value: function () { },
            properties: {
                color: function () { },
                position: function () { },
                direction: function () { },
                distance: function () { },
                coneCos: function () { },
                penumbraCos: function () { },
                decay: function () { }
            }
        },
        spotLightShadows: {
            value: function () { },
            properties: {
                shadowBias: function () { },
                shadowNormalBias: function () { },
                shadowRadius: function () { },
                shadowMapSize: function () { }
            }
        },
        spotShadowMap: {
            value: function () { }
        },
        spotShadowMatrix: {
            value: function () { }
        },
        pointLights: {
            value: function () { },
            properties: {
                color: function () { },
                position: function () { },
                decay: function () { },
                distance: function () { }
            }
        },
        pointLightShadows: {
            value: function () { },
            properties: {
                shadowBias: function () { },
                shadowNormalBias: function () { },
                shadowRadius: function () { },
                shadowMapSize: function () { },
                shadowCameraNear: function () { },
                shadowCameraFar: function () { }
            }
        },
        pointShadowMap: {
            value: function () { }
        },
        pointShadowMatrix: {
            value: function () { }
        },
        hemisphereLights: {
            value: function () { },
            properties: {
                direction: function () { },
                skyColor: function () { },
                groundColor: function () { }
            }
        },
        rectAreaLights: {
            value: function () { },
            properties: {
                color: function () { },
                position: function () { },
                width: function () { },
                height: function () { }
            }
        },
        ltc_1: {
            value: function () { }
        },
        ltc_2: {
            value: function () { }
        }
    },
    points: {
        diffuse: {
            value: {
                r: {},
                g: {},
                b: {},
                isColor: {}
            }
        },
        opacity: {
            value: {}
        },
        size: {
            value: {}
        },
        scale: {
            value: {}
        },
        map: {
            value: function () { }
        },
        alphaMap: {
            value: function () { }
        },
        uvTransform: {
            value: {
                elements: {
                    "0": {},
                    "1": {},
                    "2": {},
                    "3": {},
                    "4": {},
                    "5": {},
                    "6": {},
                    "7": {},
                    "8": {}
                },
                isMatrix3: {},
                flattenToArrayOffset: function () { },
                multiplyVector3: function () { },
                multiplyVector3Array: function () { },
                applyToBufferAttribute: function () { },
                applyToVector3Array: function () { },
                getInverse: function () { }
            }
        }
    },
    sprite: {
        diffuse: {
            value: {
                r: {},
                g: {},
                b: {},
                isColor: {}
            }
        },
        opacity: {
            value: {}
        },
        center: {
            value: {
                x: {},
                y: {},
                isVector2: {},
                fromAttribute: function () { },
                distanceToManhattan: function () { },
                lengthManhattan: function () { }
            }
        },
        rotation: {
            value: {}
        },
        map: {
            value: function () { }
        },
        alphaMap: {
            value: function () { }
        },
        uvTransform: {
            value: {
                elements: {
                    "0": {},
                    "1": {},
                    "2": {},
                    "3": {},
                    "4": {},
                    "5": {},
                    "6": {},
                    "7": {},
                    "8": {}
                },
                isMatrix3: {},
                flattenToArrayOffset: function () { },
                multiplyVector3: function () { },
                multiplyVector3Array: function () { },
                applyToBufferAttribute: function () { },
                applyToVector3Array: function () { },
                getInverse: function () { }
            }
        }
    }
}
const UniformsUtils = {
    clone: function () { },
    merge: function () { }
}

/**
 * @constructor
 * @param {number} x
 * @param {number} y
 */
const Vector2 = function (x,y) {};

