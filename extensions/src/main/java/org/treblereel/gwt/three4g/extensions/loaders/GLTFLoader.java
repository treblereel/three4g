package org.treblereel.gwt.three4g.extensions.loaders;

import elemental2.core.ArrayBuffer;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.AbstractLoader;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for glTF 2.0 resources.
 *
 * <p>glTF (GL Transmission Format) is an open format specification for efficient delivery and
 * loading of 3D content. Assets may be provided either in JSON (.gltf) or binary (.glb) format.
 * External files store textures (.jpg, .png) and additional binary data (.bin). A glTF asset may
 * deliver one or more scenes, including meshes, materials, textures, skins, skeletons, morph
 * targets, animations, lights, and/or cameras.
 *
 * <p>Extensions GLTFLoader supports the following glTF 2.0 extensions:
 *
 * <p>KHR_draco_mesh_compression KHR_materials_pbrSpecularGlossiness KHR_materials_unlit KHR_lights
 * (experimental)
 *
 * <p>Browser compatibility GLTFLoader relies on ES6 Promises, which are not supported in IE11. To
 * use the loader in IE11, you must include a polyfill providing a Promise replacement.
 *
 * @author Dmitrii Tikhomirov Created by treblereel on 5/25/18.
 */
@Three4gElement(paths = "js/loaders/GLTFLoader.js")
@JsType(isNative = true, namespace = "THREE")
public class GLTFLoader<T extends PropertyHolder> extends AbstractLoader<GLTFLoader, T> {

  /**
   * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to
   * starting the load. Default is anonymous.
   */
  public String crossOrigin;

  public GLTFLoader() {}

  public GLTFLoader(LoadingManager manager) {}

  /**
   * Refer to this readme for the details of Draco and its decoder.
   *
   * @param dracoLoader — Instance of THREE.DRACOLoader, to be used for decoding assets compressed
   *     with the KHR_draco_mesh_compression extension.
   */
  public native void setDRACOLoader(DRACOLoader dracoLoader);

  /**
   * Parse a glTF-based ArrayBuffer or JSON String and fire onLoad callback when complete. The
   * argument to onLoad will be an object that contains loaded parts: .scene, .scenes, .cameras,
   * .animations, and .asset.
   *
   * @param data — glTF asset to parse, as an ArrayBuffer or JSON string.
   * @param path — The base path from which to find subsequent glTF resources such as textures and
   *     .bin data files.
   * @param onLoad — A function to be called when parse completes.
   */
  public native void parse(ArrayBuffer data, String path, OnLoadCallback onLoad);

  /**
   * Parse a glTF-based ArrayBuffer or JSON String and fire onLoad callback when complete. The
   * argument to onLoad will be an object that contains loaded parts: .scene, .scenes, .cameras,
   * .animations, and .asset.
   *
   * @param data — glTF asset to parse, as an ArrayBuffer or JSON string.
   * @param path — The base path from which to find subsequent glTF resources such as textures and
   *     .bin data files.
   * @param onLoad — A function to be called when parse completes.
   * @param onError — A function to be called if an error occurs during parsing. The function
   *     receives error as an argument.
   */
  public native void parse(
      ArrayBuffer data, String path, OnLoadCallback onLoad, OnErrorCallback onError);
}
