package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.AbstractLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * A loader for loading an .mtl resource, used internaly by OBJLoader. The Material Template Library
 * format (MTL) or .MTL File Format is a companion file format to .OBJ that describes surface
 * shading (material) properties of objects within one or more .OBJ files.
 *
 * @author Dmitrii Tikhomirov Created by treblereel on 10/9/18.
 */
@Three4gElement(paths = {"js/loaders/MTLLoader.js"})
@JsType(isNative = true, namespace = "THREE")
public class MTLLoader extends AbstractLoader<MTLLoader, MTLLoader.MaterialCreator> {

  /** The loadingManager the loader is using. Default is DefaultLoadingManager. */
  public LoadingManager manager;

  public MTLLoader() {}

  public MTLLoader(LoadingManager manager) {}

  /**
   * Set of options on how to construct the materials
   *
   * @param materialOptions — required
   *     <p>side: Which side to apply the material. THREE.FrontSide (default), THREE.BackSide,
   *     THREE.DoubleSide wrap: What type of wrapping to apply for textures. THREE.RepeatWrapping
   *     (default), THREE.ClampToEdgeWrapping, THREE.MirroredRepeatWrapping normalizeRGB: RGBs need
   *     to be normalized to 0-1 from 0-255. Default: false, assumed to be already normalized
   *     ignoreZeroRGBs: Ignore values of RGBs (Ka,Kd,Ks) that are all 0's. Default: false
   *     invertTrProperty: Use values 1 of Tr field for fully opaque. This option is useful for obj
   *     exported from 3ds MAX, vcglib or meshlab. Default: false
   * @return instance of MTLLoader
   */
  public native MTLLoader setMaterialOptions(MaterialOptions materialOptions);

  /**
   * Parse a mtl text structure and return a MTLLoaderMaterialCreator instance.
   *
   * @param textAndPath [param:String text, param:String path]
   * @return a MTLLoaderMaterialCreator instance
   */
  public native MaterialCreator parse(String[] textAndPath);

  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
  public static class MaterialOptions {

    public int side, wrap, normalizeRGB;
    public boolean ignoreZeroRGBs, invertTrProperty;
  }

  @Three4gElement(paths = {"js/loaders/MTLLoader.js"})
  @JsType(isNative = true, namespace = "THREE.MTLLoader")
  public static class MaterialCreator extends PropertyHolder {

    public Material[] materials;

    public MaterialCreator(String baseUrl, MaterialOptions materialOptions) {}

    public native void preload();
  }
}
