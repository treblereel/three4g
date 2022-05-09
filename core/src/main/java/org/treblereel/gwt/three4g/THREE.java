package org.treblereel.gwt.three4g;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import elemental2.webgl.WebGLRenderingContext;
import elemental2.webgl.WebGLShader;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class THREE {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UniformsLibType {
    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface AomapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.AomapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getAoMap();

      @JsProperty
      JsObject getAoMapIntensity();

      @JsProperty
      void setAoMap(JsObject aoMap);

      @JsOverlay
      default void setAoMap(Object aoMap) {
        setAoMap(Js.<JsObject>uncheckedCast(aoMap));
      }

      @JsProperty
      void setAoMapIntensity(JsObject aoMapIntensity);

      @JsOverlay
      default void setAoMapIntensity(Object aoMapIntensity) {
        setAoMapIntensity(Js.<JsObject>uncheckedCast(aoMapIntensity));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface BumpmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.BumpmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getBumpMap();

      @JsProperty
      JsObject getBumpScale();

      @JsProperty
      void setBumpMap(JsObject bumpMap);

      @JsOverlay
      default void setBumpMap(Object bumpMap) {
        setBumpMap(Js.<JsObject>uncheckedCast(bumpMap));
      }

      @JsProperty
      void setBumpScale(JsObject bumpScale);

      @JsOverlay
      default void setBumpScale(Object bumpScale) {
        setBumpScale(Js.<JsObject>uncheckedCast(bumpScale));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface CommonFieldType {
      @JsOverlay
      static THREE.UniformsLibType.CommonFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getAlphaMap();

      @JsProperty
      JsObject getDiffuse();

      @JsProperty
      JsObject getMap();

      @JsProperty
      JsObject getOpacity();

      @JsProperty
      JsObject getUv2Transform();

      @JsProperty
      JsObject getUvTransform();

      @JsProperty
      void setAlphaMap(JsObject alphaMap);

      @JsOverlay
      default void setAlphaMap(Object alphaMap) {
        setAlphaMap(Js.<JsObject>uncheckedCast(alphaMap));
      }

      @JsProperty
      void setDiffuse(JsObject diffuse);

      @JsOverlay
      default void setDiffuse(Object diffuse) {
        setDiffuse(Js.<JsObject>uncheckedCast(diffuse));
      }

      @JsProperty
      void setMap(JsObject map);

      @JsOverlay
      default void setMap(Object map) {
        setMap(Js.<JsObject>uncheckedCast(map));
      }

      @JsProperty
      void setOpacity(JsObject opacity);

      @JsOverlay
      default void setOpacity(Object opacity) {
        setOpacity(Js.<JsObject>uncheckedCast(opacity));
      }

      @JsProperty
      void setUv2Transform(JsObject uv2Transform);

      @JsOverlay
      default void setUv2Transform(Object uv2Transform) {
        setUv2Transform(Js.<JsObject>uncheckedCast(uv2Transform));
      }

      @JsProperty
      void setUvTransform(JsObject uvTransform);

      @JsOverlay
      default void setUvTransform(Object uvTransform) {
        setUvTransform(Js.<JsObject>uncheckedCast(uvTransform));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface DisplacementmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.DisplacementmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getDisplacementBias();

      @JsProperty
      JsObject getDisplacementMap();

      @JsProperty
      JsObject getDisplacementScale();

      @JsProperty
      void setDisplacementBias(JsObject displacementBias);

      @JsOverlay
      default void setDisplacementBias(Object displacementBias) {
        setDisplacementBias(Js.<JsObject>uncheckedCast(displacementBias));
      }

      @JsProperty
      void setDisplacementMap(JsObject displacementMap);

      @JsOverlay
      default void setDisplacementMap(Object displacementMap) {
        setDisplacementMap(Js.<JsObject>uncheckedCast(displacementMap));
      }

      @JsProperty
      void setDisplacementScale(JsObject displacementScale);

      @JsOverlay
      default void setDisplacementScale(Object displacementScale) {
        setDisplacementScale(Js.<JsObject>uncheckedCast(displacementScale));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface EmissivemapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.EmissivemapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getEmissiveMap();

      @JsProperty
      void setEmissiveMap(JsObject emissiveMap);

      @JsOverlay
      default void setEmissiveMap(Object emissiveMap) {
        setEmissiveMap(Js.<JsObject>uncheckedCast(emissiveMap));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface EnvmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.EnvmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getEnvMap();

      @JsProperty
      JsObject getFlipEnvMap();

      @JsProperty
      JsObject getMaxMipLevel();

      @JsProperty
      JsObject getReflectivity();

      @JsProperty
      JsObject getRefractionRatio();

      @JsProperty
      void setEnvMap(JsObject envMap);

      @JsOverlay
      default void setEnvMap(Object envMap) {
        setEnvMap(Js.<JsObject>uncheckedCast(envMap));
      }

      @JsProperty
      void setFlipEnvMap(JsObject flipEnvMap);

      @JsOverlay
      default void setFlipEnvMap(Object flipEnvMap) {
        setFlipEnvMap(Js.<JsObject>uncheckedCast(flipEnvMap));
      }

      @JsProperty
      void setMaxMipLevel(JsObject maxMipLevel);

      @JsOverlay
      default void setMaxMipLevel(Object maxMipLevel) {
        setMaxMipLevel(Js.<JsObject>uncheckedCast(maxMipLevel));
      }

      @JsProperty
      void setReflectivity(JsObject reflectivity);

      @JsOverlay
      default void setReflectivity(Object reflectivity) {
        setReflectivity(Js.<JsObject>uncheckedCast(reflectivity));
      }

      @JsProperty
      void setRefractionRatio(JsObject refractionRatio);

      @JsOverlay
      default void setRefractionRatio(Object refractionRatio) {
        setRefractionRatio(Js.<JsObject>uncheckedCast(refractionRatio));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface FogFieldType {
      @JsOverlay
      static THREE.UniformsLibType.FogFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getFogColor();

      @JsProperty
      JsObject getFogDensity();

      @JsProperty
      JsObject getFogFar();

      @JsProperty
      JsObject getFogNear();

      @JsProperty
      void setFogColor(JsObject fogColor);

      @JsOverlay
      default void setFogColor(Object fogColor) {
        setFogColor(Js.<JsObject>uncheckedCast(fogColor));
      }

      @JsProperty
      void setFogDensity(JsObject fogDensity);

      @JsOverlay
      default void setFogDensity(Object fogDensity) {
        setFogDensity(Js.<JsObject>uncheckedCast(fogDensity));
      }

      @JsProperty
      void setFogFar(JsObject fogFar);

      @JsOverlay
      default void setFogFar(Object fogFar) {
        setFogFar(Js.<JsObject>uncheckedCast(fogFar));
      }

      @JsProperty
      void setFogNear(JsObject fogNear);

      @JsOverlay
      default void setFogNear(Object fogNear) {
        setFogNear(Js.<JsObject>uncheckedCast(fogNear));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface GradientmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.GradientmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getGradientMap();

      @JsProperty
      void setGradientMap(JsObject gradientMap);

      @JsOverlay
      default void setGradientMap(Object gradientMap) {
        setGradientMap(Js.<JsObject>uncheckedCast(gradientMap));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface LightmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.LightmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getLightMap();

      @JsProperty
      JsObject getLightMapIntensity();

      @JsProperty
      void setLightMap(JsObject lightMap);

      @JsOverlay
      default void setLightMap(Object lightMap) {
        setLightMap(Js.<JsObject>uncheckedCast(lightMap));
      }

      @JsProperty
      void setLightMapIntensity(JsObject lightMapIntensity);

      @JsOverlay
      default void setLightMapIntensity(Object lightMapIntensity) {
        setLightMapIntensity(Js.<JsObject>uncheckedCast(lightMapIntensity));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface LightsFieldType {
      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface DirectionalLightShadowsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.DirectionalLightShadowsFieldType
                  .PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getShadowBias();

          @JsProperty
          JsObject getShadowMapSize();

          @JsProperty
          JsObject getShadowNormalBias();

          @JsProperty
          JsObject getShadowRadius();

          @JsProperty
          void setShadowBias(JsObject shadowBias);

          @JsOverlay
          default void setShadowBias(Object shadowBias) {
            setShadowBias(Js.<JsObject>uncheckedCast(shadowBias));
          }

          @JsProperty
          void setShadowMapSize(JsObject shadowMapSize);

          @JsOverlay
          default void setShadowMapSize(Object shadowMapSize) {
            setShadowMapSize(Js.<JsObject>uncheckedCast(shadowMapSize));
          }

          @JsProperty
          void setShadowNormalBias(JsObject shadowNormalBias);

          @JsOverlay
          default void setShadowNormalBias(Object shadowNormalBias) {
            setShadowNormalBias(Js.<JsObject>uncheckedCast(shadowNormalBias));
          }

          @JsProperty
          void setShadowRadius(JsObject shadowRadius);

          @JsOverlay
          default void setShadowRadius(Object shadowRadius) {
            setShadowRadius(Js.<JsObject>uncheckedCast(shadowRadius));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.DirectionalLightShadowsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.DirectionalLightShadowsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.DirectionalLightShadowsFieldType
                    .PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface DirectionalLightsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.DirectionalLightsFieldType
                  .PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getColor();

          @JsProperty
          Object getDirection();

          @JsProperty
          void setColor(JsObject color);

          @JsOverlay
          default void setColor(Object color) {
            setColor(Js.<JsObject>uncheckedCast(color));
          }

          @JsProperty
          void setDirection(Object direction);
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.DirectionalLightsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.DirectionalLightsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.DirectionalLightsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface HemisphereLightsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.HemisphereLightsFieldType.PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getDirection();

          @JsProperty
          JsObject getGroundColor();

          @JsProperty
          JsObject getSkycolor();

          @JsProperty
          void setDirection(JsObject direction);

          @JsOverlay
          default void setDirection(Object direction) {
            setDirection(Js.<JsObject>uncheckedCast(direction));
          }

          @JsProperty
          void setGroundColor(JsObject groundColor);

          @JsOverlay
          default void setGroundColor(Object groundColor) {
            setGroundColor(Js.<JsObject>uncheckedCast(groundColor));
          }

          @JsProperty
          void setSkycolor(JsObject skycolor);

          @JsOverlay
          default void setSkycolor(Object skycolor) {
            setSkycolor(Js.<JsObject>uncheckedCast(skycolor));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.HemisphereLightsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.HemisphereLightsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.HemisphereLightsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface PointLightShadowsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.PointLightShadowsFieldType
                  .PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getShadowBias();

          @JsProperty
          JsObject getShadowMapSize();

          @JsProperty
          JsObject getShadowNormalBias();

          @JsProperty
          JsObject getShadowRadius();

          @JsProperty
          void setShadowBias(JsObject shadowBias);

          @JsOverlay
          default void setShadowBias(Object shadowBias) {
            setShadowBias(Js.<JsObject>uncheckedCast(shadowBias));
          }

          @JsProperty
          void setShadowMapSize(JsObject shadowMapSize);

          @JsOverlay
          default void setShadowMapSize(Object shadowMapSize) {
            setShadowMapSize(Js.<JsObject>uncheckedCast(shadowMapSize));
          }

          @JsProperty
          void setShadowNormalBias(JsObject shadowNormalBias);

          @JsOverlay
          default void setShadowNormalBias(Object shadowNormalBias) {
            setShadowNormalBias(Js.<JsObject>uncheckedCast(shadowNormalBias));
          }

          @JsProperty
          void setShadowRadius(JsObject shadowRadius);

          @JsOverlay
          default void setShadowRadius(Object shadowRadius) {
            setShadowRadius(Js.<JsObject>uncheckedCast(shadowRadius));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.PointLightShadowsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.PointLightShadowsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.PointLightShadowsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface PointLightsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.PointLightsFieldType.PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getColor();

          @JsProperty
          JsObject getDecay();

          @JsProperty
          JsObject getDistance();

          @JsProperty
          JsObject getPosition();

          @JsProperty
          void setColor(JsObject color);

          @JsOverlay
          default void setColor(Object color) {
            setColor(Js.<JsObject>uncheckedCast(color));
          }

          @JsProperty
          void setDecay(JsObject decay);

          @JsOverlay
          default void setDecay(Object decay) {
            setDecay(Js.<JsObject>uncheckedCast(decay));
          }

          @JsProperty
          void setDistance(JsObject distance);

          @JsOverlay
          default void setDistance(Object distance) {
            setDistance(Js.<JsObject>uncheckedCast(distance));
          }

          @JsProperty
          void setPosition(JsObject position);

          @JsOverlay
          default void setPosition(Object position) {
            setPosition(Js.<JsObject>uncheckedCast(position));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.PointLightsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.PointLightsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.PointLightsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface RectAreaLightsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.RectAreaLightsFieldType.PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getColor();

          @JsProperty
          JsObject getHeight();

          @JsProperty
          JsObject getPosition();

          @JsProperty
          JsObject getWidth();

          @JsProperty
          void setColor(JsObject color);

          @JsOverlay
          default void setColor(Object color) {
            setColor(Js.<JsObject>uncheckedCast(color));
          }

          @JsProperty
          void setHeight(JsObject height);

          @JsOverlay
          default void setHeight(Object height) {
            setHeight(Js.<JsObject>uncheckedCast(height));
          }

          @JsProperty
          void setPosition(JsObject position);

          @JsOverlay
          default void setPosition(Object position) {
            setPosition(Js.<JsObject>uncheckedCast(position));
          }

          @JsProperty
          void setWidth(JsObject width);

          @JsOverlay
          default void setWidth(Object width) {
            setWidth(Js.<JsObject>uncheckedCast(width));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.RectAreaLightsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.RectAreaLightsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.RectAreaLightsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface SpotLightShadowsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.SpotLightShadowsFieldType.PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getShadowBias();

          @JsProperty
          JsObject getShadowMapSize();

          @JsProperty
          JsObject getShadowNormalBias();

          @JsProperty
          JsObject getShadowRadius();

          @JsProperty
          void setShadowBias(JsObject shadowBias);

          @JsOverlay
          default void setShadowBias(Object shadowBias) {
            setShadowBias(Js.<JsObject>uncheckedCast(shadowBias));
          }

          @JsProperty
          void setShadowMapSize(JsObject shadowMapSize);

          @JsOverlay
          default void setShadowMapSize(Object shadowMapSize) {
            setShadowMapSize(Js.<JsObject>uncheckedCast(shadowMapSize));
          }

          @JsProperty
          void setShadowNormalBias(JsObject shadowNormalBias);

          @JsOverlay
          default void setShadowNormalBias(Object shadowNormalBias) {
            setShadowNormalBias(Js.<JsObject>uncheckedCast(shadowNormalBias));
          }

          @JsProperty
          void setShadowRadius(JsObject shadowRadius);

          @JsOverlay
          default void setShadowRadius(Object shadowRadius) {
            setShadowRadius(Js.<JsObject>uncheckedCast(shadowRadius));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.SpotLightShadowsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.SpotLightShadowsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.SpotLightShadowsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
      public interface SpotLightsFieldType {
        @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
        public interface PropertiesFieldType {
          @JsOverlay
          static THREE.UniformsLibType.LightsFieldType.SpotLightsFieldType.PropertiesFieldType
              create() {
            return Js.uncheckedCast(JsPropertyMap.of());
          }

          @JsProperty
          JsObject getColor();

          @JsProperty
          JsObject getConeCos();

          @JsProperty
          JsObject getDecay();

          @JsProperty
          JsObject getDirection();

          @JsProperty
          JsObject getDistance();

          @JsProperty
          JsObject getPenumbraCos();

          @JsProperty
          JsObject getPosition();

          @JsProperty
          void setColor(JsObject color);

          @JsOverlay
          default void setColor(Object color) {
            setColor(Js.<JsObject>uncheckedCast(color));
          }

          @JsProperty
          void setConeCos(JsObject coneCos);

          @JsOverlay
          default void setConeCos(Object coneCos) {
            setConeCos(Js.<JsObject>uncheckedCast(coneCos));
          }

          @JsProperty
          void setDecay(JsObject decay);

          @JsOverlay
          default void setDecay(Object decay) {
            setDecay(Js.<JsObject>uncheckedCast(decay));
          }

          @JsProperty
          void setDirection(JsObject direction);

          @JsOverlay
          default void setDirection(Object direction) {
            setDirection(Js.<JsObject>uncheckedCast(direction));
          }

          @JsProperty
          void setDistance(JsObject distance);

          @JsOverlay
          default void setDistance(Object distance) {
            setDistance(Js.<JsObject>uncheckedCast(distance));
          }

          @JsProperty
          void setPenumbraCos(JsObject penumbraCos);

          @JsOverlay
          default void setPenumbraCos(Object penumbraCos) {
            setPenumbraCos(Js.<JsObject>uncheckedCast(penumbraCos));
          }

          @JsProperty
          void setPosition(JsObject position);

          @JsOverlay
          default void setPosition(Object position) {
            setPosition(Js.<JsObject>uncheckedCast(position));
          }
        }

        @JsOverlay
        static THREE.UniformsLibType.LightsFieldType.SpotLightsFieldType create() {
          return Js.uncheckedCast(JsPropertyMap.of());
        }

        @JsProperty
        THREE.UniformsLibType.LightsFieldType.SpotLightsFieldType.PropertiesFieldType
            getProperties();

        @JsProperty
        JsArray<JsObject> getValue();

        @JsProperty
        void setProperties(
            THREE.UniformsLibType.LightsFieldType.SpotLightsFieldType.PropertiesFieldType
                properties);

        @JsProperty
        void setValue(JsArray<JsObject> value);

        @JsOverlay
        default void setValue(JsObject[] value) {
          setValue(Js.<JsArray<JsObject>>uncheckedCast(value));
        }
      }

      @JsOverlay
      static THREE.UniformsLibType.LightsFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getAmbientLightColor();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.DirectionalLightShadowsFieldType
          getDirectionalLightShadows();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.DirectionalLightsFieldType getDirectionalLights();

      @JsProperty
      JsObject getDirectionalShadowMap();

      @JsProperty
      JsObject getDirectionalShadowMatrix();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.HemisphereLightsFieldType getHemisphereLights();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.PointLightShadowsFieldType getPointLightShadows();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.PointLightsFieldType getPointLights();

      @JsProperty
      JsObject getPointShadowMap();

      @JsProperty
      JsObject getPointShadowMatrix();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.RectAreaLightsFieldType getRectAreaLights();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.SpotLightShadowsFieldType getSpotLightShadows();

      @JsProperty
      THREE.UniformsLibType.LightsFieldType.SpotLightsFieldType getSpotLights();

      @JsProperty
      JsObject getSpotShadowMap();

      @JsProperty
      JsObject getSpotShadowMatrix();

      @JsProperty
      void setAmbientLightColor(JsObject ambientLightColor);

      @JsOverlay
      default void setAmbientLightColor(Object ambientLightColor) {
        setAmbientLightColor(Js.<JsObject>uncheckedCast(ambientLightColor));
      }

      @JsProperty
      void setDirectionalLightShadows(
          THREE.UniformsLibType.LightsFieldType.DirectionalLightShadowsFieldType
              directionalLightShadows);

      @JsProperty
      void setDirectionalLights(
          THREE.UniformsLibType.LightsFieldType.DirectionalLightsFieldType directionalLights);

      @JsProperty
      void setDirectionalShadowMap(JsObject directionalShadowMap);

      @JsOverlay
      default void setDirectionalShadowMap(Object directionalShadowMap) {
        setDirectionalShadowMap(Js.<JsObject>uncheckedCast(directionalShadowMap));
      }

      @JsProperty
      void setDirectionalShadowMatrix(JsObject directionalShadowMatrix);

      @JsOverlay
      default void setDirectionalShadowMatrix(Object directionalShadowMatrix) {
        setDirectionalShadowMatrix(Js.<JsObject>uncheckedCast(directionalShadowMatrix));
      }

      @JsProperty
      void setHemisphereLights(
          THREE.UniformsLibType.LightsFieldType.HemisphereLightsFieldType hemisphereLights);

      @JsProperty
      void setPointLightShadows(
          THREE.UniformsLibType.LightsFieldType.PointLightShadowsFieldType pointLightShadows);

      @JsProperty
      void setPointLights(THREE.UniformsLibType.LightsFieldType.PointLightsFieldType pointLights);

      @JsProperty
      void setPointShadowMap(JsObject pointShadowMap);

      @JsOverlay
      default void setPointShadowMap(Object pointShadowMap) {
        setPointShadowMap(Js.<JsObject>uncheckedCast(pointShadowMap));
      }

      @JsProperty
      void setPointShadowMatrix(JsObject pointShadowMatrix);

      @JsOverlay
      default void setPointShadowMatrix(Object pointShadowMatrix) {
        setPointShadowMatrix(Js.<JsObject>uncheckedCast(pointShadowMatrix));
      }

      @JsProperty
      void setRectAreaLights(
          THREE.UniformsLibType.LightsFieldType.RectAreaLightsFieldType rectAreaLights);

      @JsProperty
      void setSpotLightShadows(
          THREE.UniformsLibType.LightsFieldType.SpotLightShadowsFieldType spotLightShadows);

      @JsProperty
      void setSpotLights(THREE.UniformsLibType.LightsFieldType.SpotLightsFieldType spotLights);

      @JsProperty
      void setSpotShadowMap(JsObject spotShadowMap);

      @JsOverlay
      default void setSpotShadowMap(Object spotShadowMap) {
        setSpotShadowMap(Js.<JsObject>uncheckedCast(spotShadowMap));
      }

      @JsProperty
      void setSpotShadowMatrix(JsObject spotShadowMatrix);

      @JsOverlay
      default void setSpotShadowMatrix(Object spotShadowMatrix) {
        setSpotShadowMatrix(Js.<JsObject>uncheckedCast(spotShadowMatrix));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface MetalnessmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.MetalnessmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getMetalnessMap();

      @JsProperty
      void setMetalnessMap(JsObject metalnessMap);

      @JsOverlay
      default void setMetalnessMap(Object metalnessMap) {
        setMetalnessMap(Js.<JsObject>uncheckedCast(metalnessMap));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface NormalmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.NormalmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getNormalMap();

      @JsProperty
      JsObject getNormalScale();

      @JsProperty
      void setNormalMap(JsObject normalMap);

      @JsOverlay
      default void setNormalMap(Object normalMap) {
        setNormalMap(Js.<JsObject>uncheckedCast(normalMap));
      }

      @JsProperty
      void setNormalScale(JsObject normalScale);

      @JsOverlay
      default void setNormalScale(Object normalScale) {
        setNormalScale(Js.<JsObject>uncheckedCast(normalScale));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface PointsFieldType {
      @JsOverlay
      static THREE.UniformsLibType.PointsFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getDiffuse();

      @JsProperty
      JsObject getMap();

      @JsProperty
      JsObject getOpacity();

      @JsProperty
      JsObject getScale();

      @JsProperty
      JsObject getSize();

      @JsProperty
      JsObject getUvTransform();

      @JsProperty
      void setDiffuse(JsObject diffuse);

      @JsOverlay
      default void setDiffuse(Object diffuse) {
        setDiffuse(Js.<JsObject>uncheckedCast(diffuse));
      }

      @JsProperty
      void setMap(JsObject map);

      @JsOverlay
      default void setMap(Object map) {
        setMap(Js.<JsObject>uncheckedCast(map));
      }

      @JsProperty
      void setOpacity(JsObject opacity);

      @JsOverlay
      default void setOpacity(Object opacity) {
        setOpacity(Js.<JsObject>uncheckedCast(opacity));
      }

      @JsProperty
      void setScale(JsObject scale);

      @JsOverlay
      default void setScale(Object scale) {
        setScale(Js.<JsObject>uncheckedCast(scale));
      }

      @JsProperty
      void setSize(JsObject size);

      @JsOverlay
      default void setSize(Object size) {
        setSize(Js.<JsObject>uncheckedCast(size));
      }

      @JsProperty
      void setUvTransform(JsObject uvTransform);

      @JsOverlay
      default void setUvTransform(Object uvTransform) {
        setUvTransform(Js.<JsObject>uncheckedCast(uvTransform));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface RoughnessmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.RoughnessmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getRoughnessMap();

      @JsProperty
      void setRoughnessMap(JsObject roughnessMap);

      @JsOverlay
      default void setRoughnessMap(Object roughnessMap) {
        setRoughnessMap(Js.<JsObject>uncheckedCast(roughnessMap));
      }
    }

    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface SpecularmapFieldType {
      @JsOverlay
      static THREE.UniformsLibType.SpecularmapFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      JsObject getSpecularMap();

      @JsProperty
      void setSpecularMap(JsObject specularMap);

      @JsOverlay
      default void setSpecularMap(Object specularMap) {
        setSpecularMap(Js.<JsObject>uncheckedCast(specularMap));
      }
    }

    @JsOverlay
    static THREE.UniformsLibType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    THREE.UniformsLibType.AomapFieldType getAomap();

    @JsProperty
    THREE.UniformsLibType.BumpmapFieldType getBumpmap();

    @JsProperty
    THREE.UniformsLibType.CommonFieldType getCommon();

    @JsProperty
    THREE.UniformsLibType.DisplacementmapFieldType getDisplacementmap();

    @JsProperty
    THREE.UniformsLibType.EmissivemapFieldType getEmissivemap();

    @JsProperty
    THREE.UniformsLibType.EnvmapFieldType getEnvmap();

    @JsProperty
    THREE.UniformsLibType.FogFieldType getFog();

    @JsProperty
    THREE.UniformsLibType.GradientmapFieldType getGradientmap();

    @JsProperty
    THREE.UniformsLibType.LightmapFieldType getLightmap();

    @JsProperty
    THREE.UniformsLibType.LightsFieldType getLights();

    @JsProperty
    THREE.UniformsLibType.MetalnessmapFieldType getMetalnessmap();

    @JsProperty
    THREE.UniformsLibType.NormalmapFieldType getNormalmap();

    @JsProperty
    THREE.UniformsLibType.PointsFieldType getPoints();

    @JsProperty
    THREE.UniformsLibType.RoughnessmapFieldType getRoughnessmap();

    @JsProperty
    THREE.UniformsLibType.SpecularmapFieldType getSpecularmap();

    @JsProperty
    void setAomap(THREE.UniformsLibType.AomapFieldType aomap);

    @JsProperty
    void setBumpmap(THREE.UniformsLibType.BumpmapFieldType bumpmap);

    @JsProperty
    void setCommon(THREE.UniformsLibType.CommonFieldType common);

    @JsProperty
    void setDisplacementmap(THREE.UniformsLibType.DisplacementmapFieldType displacementmap);

    @JsProperty
    void setEmissivemap(THREE.UniformsLibType.EmissivemapFieldType emissivemap);

    @JsProperty
    void setEnvmap(THREE.UniformsLibType.EnvmapFieldType envmap);

    @JsProperty
    void setFog(THREE.UniformsLibType.FogFieldType fog);

    @JsProperty
    void setGradientmap(THREE.UniformsLibType.GradientmapFieldType gradientmap);

    @JsProperty
    void setLightmap(THREE.UniformsLibType.LightmapFieldType lightmap);

    @JsProperty
    void setLights(THREE.UniformsLibType.LightsFieldType lights);

    @JsProperty
    void setMetalnessmap(THREE.UniformsLibType.MetalnessmapFieldType metalnessmap);

    @JsProperty
    void setNormalmap(THREE.UniformsLibType.NormalmapFieldType normalmap);

    @JsProperty
    void setPoints(THREE.UniformsLibType.PointsFieldType points);

    @JsProperty
    void setRoughnessmap(THREE.UniformsLibType.RoughnessmapFieldType roughnessmap);

    @JsProperty
    void setSpecularmap(THREE.UniformsLibType.SpecularmapFieldType specularmap);
  }

  public static double ACESFilmicToneMapping;
  public static double AddEquation;
  public static double AddOperation;
  public static double AdditiveAnimationBlendMode;
  public static double AdditiveBlending;
  public static double AlphaFormat;
  public static double AlwaysDepth;
  public static double AlwaysStencilFunc;
  public static double BackSide;
  public static double BasicDepthPacking;
  public static double BasicShadowMap;
  public static String BuiltinShaderAttributeName;
  public static double ByteType;
  public static double CineonToneMapping;
  public static double ClampToEdgeWrapping;
  public static double CubeReflectionMapping;
  public static double CubeRefractionMapping;
  public static double CubeUVReflectionMapping;
  public static double CubeUVRefractionMapping;
  public static double CullFaceBack;
  public static double CullFaceFront;
  public static double CullFaceFrontBack;
  public static double CullFaceNone;
  public static double CustomBlending;
  public static double DecrementStencilOp;
  public static double DecrementWrapStencilOp;
  public static double DepthFormat;
  public static double DepthStencilFormat;
  public static double DoubleSide;
  public static double DstAlphaFactor;
  public static double DstColorFactor;
  public static double DynamicCopyUsage;
  public static double DynamicDrawUsage;
  public static double DynamicReadUsage;
  public static double EqualDepth;
  public static double EqualStencilFunc;
  public static double EquirectangularReflectionMapping;
  public static double EquirectangularRefractionMapping;
  public static double FlatShading;
  public static double FloatType;
  public static double FrontSide;
  public static double GLSL1;
  public static double GLSL3;
  public static double GammaEncoding;
  public static double GreaterDepth;
  public static double GreaterEqualDepth;
  public static double GreaterEqualStencilFunc;
  public static double GreaterStencilFunc;
  public static double HalfFloatType;
  public static double IncrementStencilOp;
  public static double IncrementWrapStencilOp;
  public static double IntType;
  public static double InterpolateDiscrete;
  public static double InterpolateLinear;
  public static double InterpolateSmooth;
  public static double InvertStencilOp;
  public static double KeepStencilOp;
  public static double LessDepth;
  public static double LessEqualDepth;
  public static double LessEqualStencilFunc;
  public static double LessStencilFunc;
  public static double LinearEncoding;
  public static double LinearFilter;
  public static double LinearMipMapLinearFilter;
  public static double LinearMipMapNearestFilter;
  public static double LinearMipmapLinearFilter;
  public static double LinearMipmapNearestFilter;
  public static double LinearToneMapping;
  public static double LogLuvEncoding;
  public static double LoopOnce;
  public static double LoopPingPong;
  public static double LoopRepeat;
  public static double LuminanceAlphaFormat;
  public static double LuminanceFormat;
  public static JsArray<Double> Matrix3Tuple;
  public static JsArray<Double> Matrix4Tuple;
  public static double MaxEquation;
  public static double MinEquation;
  public static double MirroredRepeatWrapping;
  public static double MixOperation;
  public static double MultiplyBlending;
  public static double MultiplyOperation;
  public static double NearestFilter;
  public static double NearestMipMapLinearFilter;
  public static double NearestMipMapNearestFilter;
  public static double NearestMipmapLinearFilter;
  public static double NearestMipmapNearestFilter;
  public static double NeverDepth;
  public static double NeverStencilFunc;
  public static double NoBlending;
  public static double NoToneMapping;
  public static double NormalAnimationBlendMode;
  public static double NormalBlending;
  public static double NotEqualDepth;
  public static double NotEqualStencilFunc;
  public static double ObjectSpaceNormalMap;
  public static double OneFactor;
  public static double OneMinusDstAlphaFactor;
  public static double OneMinusDstColorFactor;
  public static double OneMinusSrcAlphaFactor;
  public static double OneMinusSrcColorFactor;
  public static double PCFShadowMap;
  public static double PCFSoftShadowMap;
  public static String PixelFormatGPU;
  public static String REVISION;
  public static double RGBADepthPacking;
  public static double RGBAFormat;
  public static double RGBAIntegerFormat;
  public static double RGBA_ASTC_10x10_Format;
  public static double RGBA_ASTC_10x5_Format;
  public static double RGBA_ASTC_10x6_Format;
  public static double RGBA_ASTC_10x8_Format;
  public static double RGBA_ASTC_12x10_Format;
  public static double RGBA_ASTC_12x12_Format;
  public static double RGBA_ASTC_4x4_Format;
  public static double RGBA_ASTC_5x4_Format;
  public static double RGBA_ASTC_5x5_Format;
  public static double RGBA_ASTC_6x5_Format;
  public static double RGBA_ASTC_6x6_Format;
  public static double RGBA_ASTC_8x5_Format;
  public static double RGBA_ASTC_8x6_Format;
  public static double RGBA_ASTC_8x8_Format;
  public static double RGBA_BPTC_Format;
  public static double RGBA_ETC2_EAC_Format;
  public static double RGBA_PVRTC_2BPPV1_Format;
  public static double RGBA_PVRTC_4BPPV1_Format;
  public static double RGBA_S3TC_DXT1_Format;
  public static double RGBA_S3TC_DXT3_Format;
  public static double RGBA_S3TC_DXT5_Format;
  public static double RGBDEncoding;
  public static double RGBEEncoding;
  public static double RGBEFormat;
  public static double RGBFormat;
  public static double RGBIntegerFormat;
  public static double RGBM16Encoding;
  public static double RGBM7Encoding;
  public static double RGB_ETC1_Format;
  public static double RGB_ETC2_Format;
  public static double RGB_PVRTC_2BPPV1_Format;
  public static double RGB_PVRTC_4BPPV1_Format;
  public static double RGB_S3TC_DXT1_Format;
  public static double RGFormat;
  public static double RGIntegerFormat;
  public static double RedFormat;
  public static double RedIntegerFormat;
  public static double ReinhardToneMapping;
  public static double RepeatWrapping;
  public static double ReplaceStencilOp;
  public static double ReverseSubtractEquation;
  public static double SRGB8_ALPHA8_ASTC_10x10_Format;
  public static double SRGB8_ALPHA8_ASTC_10x5_Format;
  public static double SRGB8_ALPHA8_ASTC_10x6_Format;
  public static double SRGB8_ALPHA8_ASTC_10x8_Format;
  public static double SRGB8_ALPHA8_ASTC_12x10_Format;
  public static double SRGB8_ALPHA8_ASTC_12x12_Format;
  public static double SRGB8_ALPHA8_ASTC_4x4_Format;
  public static double SRGB8_ALPHA8_ASTC_5x4_Format;
  public static double SRGB8_ALPHA8_ASTC_5x5_Format;
  public static double SRGB8_ALPHA8_ASTC_6x5_Format;
  public static double SRGB8_ALPHA8_ASTC_6x6_Format;
  public static double SRGB8_ALPHA8_ASTC_8x5_Format;
  public static double SRGB8_ALPHA8_ASTC_8x6_Format;
  public static double SRGB8_ALPHA8_ASTC_8x8_Format;
  public static double ShortType;
  public static double SmoothShading;
  public static double SrcAlphaFactor;
  public static double SrcAlphaSaturateFactor;
  public static double SrcColorFactor;
  public static double StaticCopyUsage;
  public static double StaticDrawUsage;
  public static double StaticReadUsage;
  public static double StreamCopyUsage;
  public static double StreamDrawUsage;
  public static double StreamReadUsage;
  public static double SubtractEquation;
  public static double SubtractiveBlending;
  public static double TangentSpaceNormalMap;
  public static double TriangleFanDrawMode;
  public static double TriangleStripDrawMode;
  public static double TrianglesDrawMode;
  public static double UVMapping;
  public static THREE.UniformsLibType UniformsLib;
  public static double UnsignedByteType;
  public static double UnsignedInt248Type;
  public static double UnsignedIntType;
  public static double UnsignedShort4444Type;
  public static double UnsignedShort5551Type;
  public static double UnsignedShort565Type;
  public static double UnsignedShortType;
  public static double VSMShadowMap;
  public static JsArray<JsObject> Vector2Tuple;
  public static JsArray<JsObject> Vector3Tuple;
  public static JsArray<JsObject> Vector4Tuple;
  public static double WrapAroundEnding;
  public static String XRControllerEventType;
  public static double ZeroCurvatureEnding;
  public static double ZeroFactor;
  public static double ZeroSlopeEnding;
  public static double ZeroStencilOp;
  public static double sRGBEncoding;

  public static native Object CatmullRomCurve3();

  public static native Object DataUtils();

  public static native Object ImageUtils();

  public static native WebGLShader WebGLShader(
      WebGLRenderingContext gl, String type, String string);
}
