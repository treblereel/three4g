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

  public static int ACESFilmicToneMapping;
  public static int AddEquation;
  public static int AddOperation;
  public static int AdditiveAnimationBlendMode;
  public static int AdditiveBlending;
  public static int AlphaFormat;
  public static int AlwaysDepth;
  public static int AlwaysStencilFunc;
  public static int BackSide;
  public static int BasicDepthPacking;
  public static int BasicShadowMap;
  public static String BuiltinShaderAttributeName;
  public static int ByteType;
  public static int CineonToneMapping;
  public static int ClampToEdgeWrapping;
  public static int CubeReflectionMapping;
  public static int CubeRefractionMapping;
  public static int CubeUVReflectionMapping;
  public static int CubeUVRefractionMapping;
  public static int CullFaceBack;
  public static int CullFaceFront;
  public static int CullFaceFrontBack;
  public static int CullFaceNone;
  public static int CustomBlending;
  public static int DecrementStencilOp;
  public static int DecrementWrapStencilOp;
  public static int DepthFormat;
  public static int DepthStencilFormat;
  public static int DoubleSide;
  public static int DstAlphaFactor;
  public static int DstColorFactor;
  public static int DynamicCopyUsage;
  public static int DynamicDrawUsage;
  public static int DynamicReadUsage;
  public static int EqualDepth;
  public static int EqualStencilFunc;
  public static int EquirectangularReflectionMapping;
  public static int EquirectangularRefractionMapping;
  public static int FlatShading;
  public static int FloatType;
  public static int FrontSide;
  public static int GLSL1;
  public static int GLSL3;
  public static int GammaEncoding;
  public static int GreaterDepth;
  public static int GreaterEqualDepth;
  public static int GreaterEqualStencilFunc;
  public static int GreaterStencilFunc;
  public static int HalfFloatType;
  public static int IncrementStencilOp;
  public static int IncrementWrapStencilOp;
  public static int IntType;
  public static int InterpolateDiscrete;
  public static int InterpolateLinear;
  public static int InterpolateSmooth;
  public static int InvertStencilOp;
  public static int KeepStencilOp;
  public static int LessDepth;
  public static int LessEqualDepth;
  public static int LessEqualStencilFunc;
  public static int LessStencilFunc;
  public static int LinearEncoding;
  public static int LinearFilter;
  public static int LinearMipMapLinearFilter;
  public static int LinearMipMapNearestFilter;
  public static int LinearMipmapLinearFilter;
  public static int LinearMipmapNearestFilter;
  public static int LinearToneMapping;
  public static int LogLuvEncoding;
  public static int LoopOnce;
  public static int LoopPingPong;
  public static int LoopRepeat;
  public static int LuminanceAlphaFormat;
  public static int LuminanceFormat;
  public static JsArray<Double> Matrix3Tuple;
  public static JsArray<Double> Matrix4Tuple;
  public static int MaxEquation;
  public static int MinEquation;
  public static int MirroredRepeatWrapping;
  public static int MixOperation;
  public static int MultiplyBlending;
  public static int MultiplyOperation;
  public static int NearestFilter;
  public static int NearestMipMapLinearFilter;
  public static int NearestMipMapNearestFilter;
  public static int NearestMipmapLinearFilter;
  public static int NearestMipmapNearestFilter;
  public static int NeverDepth;
  public static int NeverStencilFunc;
  public static int NoBlending;
  public static int NoToneMapping;
  public static int NormalAnimationBlendMode;
  public static int NormalBlending;
  public static int NotEqualDepth;
  public static int NotEqualStencilFunc;
  public static int ObjectSpaceNormalMap;
  public static int OneFactor;
  public static int OneMinusDstAlphaFactor;
  public static int OneMinusDstColorFactor;
  public static int OneMinusSrcAlphaFactor;
  public static int OneMinusSrcColorFactor;
  public static int PCFShadowMap;
  public static int PCFSoftShadowMap;
  public static String PixelFormatGPU;
  public static String REVISION;
  public static int RGBADepthPacking;
  public static int RGBAFormat;
  public static int RGBAIntegerFormat;
  public static int RGBA_ASTC_10x10_Format;
  public static int RGBA_ASTC_10x5_Format;
  public static int RGBA_ASTC_10x6_Format;
  public static int RGBA_ASTC_10x8_Format;
  public static int RGBA_ASTC_12x10_Format;
  public static int RGBA_ASTC_12x12_Format;
  public static int RGBA_ASTC_4x4_Format;
  public static int RGBA_ASTC_5x4_Format;
  public static int RGBA_ASTC_5x5_Format;
  public static int RGBA_ASTC_6x5_Format;
  public static int RGBA_ASTC_6x6_Format;
  public static int RGBA_ASTC_8x5_Format;
  public static int RGBA_ASTC_8x6_Format;
  public static int RGBA_ASTC_8x8_Format;
  public static int RGBA_BPTC_Format;
  public static int RGBA_ETC2_EAC_Format;
  public static int RGBA_PVRTC_2BPPV1_Format;
  public static int RGBA_PVRTC_4BPPV1_Format;
  public static int RGBA_S3TC_DXT1_Format;
  public static int RGBA_S3TC_DXT3_Format;
  public static int RGBA_S3TC_DXT5_Format;
  public static int RGBDEncoding;
  public static int RGBEEncoding;
  public static int RGBEFormat;
  public static int RGBFormat;
  public static int RGBIntegerFormat;
  public static int RGBM16Encoding;
  public static int RGBM7Encoding;
  public static int RGB_ETC1_Format;
  public static int RGB_ETC2_Format;
  public static int RGB_PVRTC_2BPPV1_Format;
  public static int RGB_PVRTC_4BPPV1_Format;
  public static int RGB_S3TC_DXT1_Format;
  public static int RGFormat;
  public static int RGIntegerFormat;
  public static int RedFormat;
  public static int RedIntegerFormat;
  public static int ReinhardToneMapping;
  public static int RepeatWrapping;
  public static int ReplaceStencilOp;
  public static int ReverseSubtractEquation;
  public static int SRGB8_ALPHA8_ASTC_10x10_Format;
  public static int SRGB8_ALPHA8_ASTC_10x5_Format;
  public static int SRGB8_ALPHA8_ASTC_10x6_Format;
  public static int SRGB8_ALPHA8_ASTC_10x8_Format;
  public static int SRGB8_ALPHA8_ASTC_12x10_Format;
  public static int SRGB8_ALPHA8_ASTC_12x12_Format;
  public static int SRGB8_ALPHA8_ASTC_4x4_Format;
  public static int SRGB8_ALPHA8_ASTC_5x4_Format;
  public static int SRGB8_ALPHA8_ASTC_5x5_Format;
  public static int SRGB8_ALPHA8_ASTC_6x5_Format;
  public static int SRGB8_ALPHA8_ASTC_6x6_Format;
  public static int SRGB8_ALPHA8_ASTC_8x5_Format;
  public static int SRGB8_ALPHA8_ASTC_8x6_Format;
  public static int SRGB8_ALPHA8_ASTC_8x8_Format;
  public static int ShortType;
  public static int SmoothShading;
  public static int SrcAlphaFactor;
  public static int SrcAlphaSaturateFactor;
  public static int SrcColorFactor;
  public static int StaticCopyUsage;
  public static int StaticDrawUsage;
  public static int StaticReadUsage;
  public static int StreamCopyUsage;
  public static int StreamDrawUsage;
  public static int StreamReadUsage;
  public static int SubtractEquation;
  public static int SubtractiveBlending;
  public static int TangentSpaceNormalMap;
  public static int TriangleFanDrawMode;
  public static int TriangleStripDrawMode;
  public static int TrianglesDrawMode;
  public static int UVMapping;
  public static THREE.UniformsLibType UniformsLib;
  public static int UnsignedByteType;
  public static int UnsignedInt248Type;
  public static int UnsignedIntType;
  public static int UnsignedShort4444Type;
  public static int UnsignedShort5551Type;
  public static int UnsignedShort565Type;
  public static int UnsignedShortType;
  public static int VSMShadowMap;
  public static JsArray<JsObject> Vector2Tuple;
  public static JsArray<JsObject> Vector3Tuple;
  public static JsArray<JsObject> Vector4Tuple;
  public static int WrapAroundEnding;
  public static String XRControllerEventType;
  public static int ZeroCurvatureEnding;
  public static int ZeroFactor;
  public static int ZeroSlopeEnding;
  public static int ZeroStencilOp;
  public static int sRGBEncoding;

  public static native Object CatmullRomCurve3();

  public static native Object DataUtils();

  public static native Object ImageUtils();

  public static native WebGLShader WebGLShader(
      WebGLRenderingContext gl, String type, String string);


  // GL STATE CONSTANTS
  public static class CullFace {
    public static int CullFaceBack = THREE.CullFaceBack;
    public static int CullFaceFront = THREE.CullFaceFront;
    public static int CullFaceFrontBack = THREE.CullFaceFrontBack;
    public static int CullFaceNone = THREE.CullFaceNone;
  }

  // Shadowing Type
  public static class ShadowMapType {
    public static int BasicShadowMap = THREE.BasicShadowMap;
    public static int PCFShadowMap = THREE.PCFShadowMap;
    public static int PCFSoftShadowMap = THREE.PCFSoftShadowMap;
    public static int VSMShadowMap = THREE.VSMShadowMap;
  }

  // MATERIAL CONSTANTS

  // side
  public static class Side {
    public static int FrontSide = THREE.FrontSide;
    public static int BackSide = THREE.BackSide;
    public static int DoubleSide = THREE.DoubleSide;
  }

  // shading
  public static class Shading {
    public static int FlatShading = THREE.FlatShading;
    public static int SmoothShading = THREE.SmoothShading;
  }

  // blending modes
  public static class Blending {
    public static int NoBlending = THREE.NoBlending;
    public static int NormalBlending = THREE.NormalBlending;
    public static int AdditiveBlending = THREE.AdditiveBlending;
    public static int SubtractiveBlending = THREE.SubtractiveBlending;
    public static int MultiplyBlending = THREE.MultiplyBlending;
    public static int CustomBlending = THREE.CustomBlending;
  }

  // custom blending equations
  // (numbers start from 100 not to clash with other
  // mappings to OpenGL constants defined in Texture.js)
  public static class BlendingEquation {
    public static int AddEquation = THREE.AddEquation;
    public static int SubtractEquation = THREE.SubtractEquation;
    public static int ReverseSubtractEquation = THREE.ReverseSubtractEquation;
    public static int MinEquation = THREE.MinEquation;
    public static int MaxEquation = THREE.MaxEquation;
  }

  // custom blending destination factors
  public static class BlendingDstFactor {
    public static int ZeroFactor = THREE.ZeroFactor;
    public static int OneFactor = THREE.OneFactor;
    public static int SrcColorFactor = THREE.SrcColorFactor;
    public static int OneMinusSrcColorFactor = THREE.OneMinusSrcColorFactor;
    public static int SrcAlphaFactor = THREE.SrcAlphaFactor;
    public static int OneMinusSrcAlphaFactor = THREE.OneMinusSrcAlphaFactor;
    public static int DstAlphaFactor = THREE.DstAlphaFactor;
    public static int OneMinusDstAlphaFactor = THREE.OneMinusDstAlphaFactor;
    public static int DstColorFactor = THREE.DstColorFactor;
    public static int OneMinusDstColorFactor = THREE.OneMinusDstColorFactor;
  }

  // custom blending src factors
  public static class BlendingSrcFactor {
    public static int SrcAlphaSaturateFactor = THREE.SrcAlphaSaturateFactor;
  }

  // depth modes
  public static class DepthModes {
    public static int NeverDepth = THREE.NeverDepth;
    public static int AlwaysDepth = THREE.AlwaysDepth;
    public static int LessDepth = THREE.LessDepth;
    public static int LessEqualDepth = THREE.LessEqualDepth;
    public static int EqualDepth = THREE.EqualDepth;
    public static int GreaterEqualDepth = THREE.GreaterEqualDepth;
    public static int GreaterDepth = THREE.GreaterDepth;
    public static int NotEqualDepth = THREE.NotEqualDepth;
  }

  // TEXTURE CONSTANTS
  // Operations
  public static class Combine {
    public static int MultiplyOperation = THREE.MultiplyOperation;
    public static int MixOperation = THREE.MixOperation;
    public static int AddOperation = THREE.AddOperation;
  }

  // Tone Mapping modes
  public static class ToneMapping {
    public static int NoToneMapping = THREE.NoToneMapping;
    public static int LinearToneMapping = THREE.LinearToneMapping;
    public static int ReinhardToneMapping = THREE.ReinhardToneMapping;
    public static int CineonToneMapping = THREE.CineonToneMapping;
    public static int ACESFilmicToneMapping = THREE.ACESFilmicToneMapping;
    //public static int CustomToneMapping = THREE.CustomToneMapping;
  }

  // Mapping modes
  public static class Mapping {
    public static int UVMapping = THREE.UVMapping;
    public static int CubeReflectionMapping = THREE.CubeReflectionMapping;
    public static int CubeRefractionMapping = THREE.CubeRefractionMapping;
    public static int EquirectangularReflectionMapping = THREE.EquirectangularReflectionMapping;
    public static int EquirectangularRefractionMapping = THREE.EquirectangularRefractionMapping;
    public static int CubeUVReflectionMapping = THREE.CubeUVReflectionMapping;
  }

  // Wrapping modes
  public static class Wrapping {
    public static int RepeatWrapping = THREE.RepeatWrapping;
    public static int ClampToEdgeWrapping = THREE.ClampToEdgeWrapping;
    public static int MirroredRepeatWrapping = THREE.MirroredRepeatWrapping;
  }

  // Filters
  public static class TextureFilter {
    public static int NearestFilter = THREE.NearestFilter;
    public static int NearestMipmapNearestFilter = THREE.NearestMipmapNearestFilter;
    public static int NearestMipMapNearestFilter = THREE.NearestMipMapNearestFilter;
    public static int NearestMipmapLinearFilter = THREE.NearestMipmapLinearFilter;
    public static int NearestMipMapLinearFilter = THREE.NearestMipMapLinearFilter;
    public static int LinearFilter = THREE.LinearFilter;
    public static int LinearMipmapNearestFilter = THREE.LinearMipmapNearestFilter;
    public static int LinearMipMapNearestFilter = THREE.LinearMipMapNearestFilter;
    public static int LinearMipmapLinearFilter = THREE.LinearMipmapLinearFilter;
    public static int LinearMipMapLinearFilter = THREE.LinearMipMapLinearFilter;
  }

  // Data types
  public static class TextureDataType {
    public static int UnsignedByteType = THREE.UnsignedByteType;
    public static int ByteType = THREE.ByteType;
    public static int ShortType = THREE.ShortType;
    public static int UnsignedShortType = THREE.UnsignedShortType;
    public static int IntType = THREE.IntType;
    public static int UnsignedIntType = THREE.UnsignedIntType;
    public static int FloatType = THREE.FloatType;
    public static int HalfFloatType = THREE.HalfFloatType;
    public static int UnsignedShort4444Type = THREE.UnsignedShort4444Type;
    public static int UnsignedShort5551Type = THREE.UnsignedShort5551Type;
    public static int UnsignedInt248Type = THREE.UnsignedInt248Type;
  }

  // Pixel formats
  public static class PixelFormat {
    public static int AlphaFormat = THREE.AlphaFormat;
    public static int RGBFormat = THREE.RGBFormat;
    public static int RGBAFormat = THREE.RGBAFormat;
    public static int LuminanceFormat = THREE.LuminanceFormat;
    public static int LuminanceAlphaFormat = THREE.LuminanceAlphaFormat;
    public static int DepthFormat = THREE.DepthFormat;
    public static int DepthStencilFormat = THREE.DepthStencilFormat;
    public static int RedFormat = THREE.RedFormat;
    public static int RedIntegerFormat = THREE.RedIntegerFormat;
    public static int RGFormat = THREE.RGFormat;
    public static int RGIntegerFormat = THREE.RGIntegerFormat;
    public static int RGBAIntegerFormat = THREE.RGBAIntegerFormat;
    //public static int _SRGBFormat = THREE._SRGBFormat;
    //public static int _SRGBAFormat = THREE._SRGBAFormat;
  }

  // Loop styles for AnimationAction
  public static class AnimationActionLoopStyles {
    public static int LoopOnce = THREE.LoopOnce;
    public static int LoopRepeat = THREE.LoopRepeat;
    public static int LoopPingPong = THREE.LoopPingPong;
  }

  // Interpolation
  public static class InterpolationModes {
    public static int InterpolateDiscrete = THREE.InterpolateDiscrete;
    public static int InterpolateLinear = THREE.InterpolateLinear;
    public static int InterpolateSmooth = THREE.InterpolateSmooth;
  }

  // Interpolant ending modes
  public static class InterpolationEndingModes {
    public static int ZeroCurvatureEnding = THREE.ZeroCurvatureEnding;
    public static int ZeroSlopeEnding = THREE.ZeroSlopeEnding;
    public static int WrapAroundEnding = THREE.WrapAroundEnding;
  }

  // Animation blending modes
  public static class AnimationBlendMode {
    public static int NormalAnimationBlendMode = THREE.NormalAnimationBlendMode;
    public static int AdditiveAnimationBlendMode = THREE.AdditiveAnimationBlendMode;
  }

  // Triangle Draw modes
  public static class TrianglesDrawModes {
    public static int TrianglesDrawMode = THREE.TrianglesDrawMode;
    public static int TriangleStripDrawMode = THREE.TriangleStripDrawMode;
    public static int TriangleFanDrawMode = THREE.TriangleFanDrawMode;
  }

  // Texture Encodings
  public static class TextureEncoding {
    public static int LinearEncoding = THREE.LinearEncoding;
    public static int sRGBEncoding = THREE.sRGBEncoding;
  }

  // Depth packing strategies
  public static class DepthPackingStrategies {
    public static int BasicDepthPacking = THREE.BasicDepthPacking;
    public static int RGBADepthPacking = THREE.RGBADepthPacking;
  }

  // Normal Map types
  public static class NormalMapTypes {
    public static int TangentSpaceNormalMap = THREE.TangentSpaceNormalMap;
    public static int ObjectSpaceNormalMap = THREE.ObjectSpaceNormalMap;
  }

  // Stencil Op types
  public static class StencilOp {
    public static int ZeroStencilOp = THREE.ZeroStencilOp;
    public static int KeepStencilOp = THREE.KeepStencilOp;
    public static int ReplaceStencilOp = THREE.ReplaceStencilOp;
    public static int IncrementStencilOp = THREE.IncrementStencilOp;
    public static int DecrementStencilOp = THREE.DecrementStencilOp;
    public static int IncrementWrapStencilOp = THREE.IncrementWrapStencilOp;
    public static int DecrementWrapStencilOp = THREE.DecrementWrapStencilOp;
    public static int InvertStencilOp = THREE.InvertStencilOp;
  }

  // Stencil Func types
  public static class StencilFunc {
    public static int NeverStencilFunc = THREE.NeverStencilFunc;
    public static int LessStencilFunc = THREE.LessStencilFunc;
    public static int EqualStencilFunc = THREE.EqualStencilFunc;
    public static int LessEqualStencilFunc = THREE.LessEqualStencilFunc;
    public static int GreaterStencilFunc = THREE.GreaterStencilFunc;
    public static int NotEqualStencilFunc = THREE.NotEqualStencilFunc;
    public static int GreaterEqualStencilFunc = THREE.GreaterEqualStencilFunc;
    public static int AlwaysStencilFunc = THREE.AlwaysStencilFunc;
  }

  // usage types
  public static class Usage {
    public static int StaticDrawUsage = THREE.StaticDrawUsage;
    public static int DynamicDrawUsage = THREE.DynamicDrawUsage;
    public static int StreamDrawUsage = THREE.StreamDrawUsage;
    public static int StaticReadUsage = THREE.StaticReadUsage;
    public static int DynamicReadUsage = THREE.DynamicReadUsage;
    public static int StreamReadUsage = THREE.StreamReadUsage;
    public static int StaticCopyUsage = THREE.StaticCopyUsage;
    public static int DynamicCopyUsage = THREE.DynamicCopyUsage;
    public static int StreamCopyUsage = THREE.StreamCopyUsage;
  }

  // Compressed texture formats
  // DDS / ST3C Compressed texture formats
  public static class CompressedPixelFormat {
    public static int RGB_S3TC_DXT1_Format = THREE.RGB_S3TC_DXT1_Format;
    public static int RGBA_S3TC_DXT1_Format = THREE.RGBA_S3TC_DXT1_Format;
    public static int RGBA_S3TC_DXT3_Format = THREE.RGBA_S3TC_DXT3_Format;
    public static int RGBA_S3TC_DXT5_Format = THREE.RGBA_S3TC_DXT5_Format;

    public static int RGB_PVRTC_4BPPV1_Format = THREE.RGB_PVRTC_4BPPV1_Format;
    public static int RGB_PVRTC_2BPPV1_Format = THREE.RGB_PVRTC_2BPPV1_Format;
    public static int RGBA_PVRTC_4BPPV1_Format = THREE.RGBA_PVRTC_4BPPV1_Format;
    public static int RGBA_PVRTC_2BPPV1_Format = THREE.RGBA_PVRTC_2BPPV1_Format;

    public static int RGB_ETC1_Format = THREE.RGB_ETC1_Format;
    public static int RGB_ETC2_Format = THREE.RGB_ETC2_Format;
    public static int RGBA_ETC2_EAC_Format = THREE.RGBA_ETC2_EAC_Format;

    public static int RGBA_ASTC_4x4_Format = THREE.RGBA_ASTC_4x4_Format;
    public static int RGBA_ASTC_5x4_Format = THREE.RGBA_ASTC_5x4_Format;
    public static int RGBA_ASTC_5x5_Format = THREE.RGBA_ASTC_5x5_Format;
    public static int RGBA_ASTC_6x5_Format = THREE.RGBA_ASTC_6x5_Format;
    public static int RGBA_ASTC_6x6_Format = THREE.RGBA_ASTC_6x6_Format;
    public static int RGBA_ASTC_8x5_Format = THREE.RGBA_ASTC_8x5_Format;
    public static int RGBA_ASTC_8x6_Format = THREE.RGBA_ASTC_8x6_Format;
    public static int RGBA_ASTC_8x8_Format = THREE.RGBA_ASTC_8x8_Format;
    public static int RGBA_ASTC_10x5_Format = THREE.RGBA_ASTC_10x5_Format;
    public static int RGBA_ASTC_10x6_Format = THREE.RGBA_ASTC_10x6_Format;
    public static int RGBA_ASTC_10x8_Format = THREE.RGBA_ASTC_10x8_Format;
    public static int RGBA_ASTC_10x10_Format = THREE.RGBA_ASTC_10x10_Format;
    public static int RGBA_ASTC_12x10_Format = THREE.RGBA_ASTC_12x10_Format;
    public static int RGBA_ASTC_12x12_Format = THREE.RGBA_ASTC_12x12_Format;

    public static int RGBA_BPTC_Format = THREE.RGBA_BPTC_Format;
  }

  // Normal Map types
  public static class GLSLVersion {
    public static int GLSL1 = THREE.GLSL1;
    public static int GLSL3 = THREE.GLSL3;
  }
}
