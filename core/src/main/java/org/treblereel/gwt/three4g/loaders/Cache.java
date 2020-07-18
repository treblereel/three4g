package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * A simple caching system, used internally by FileLoader.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, name = "THREE.Cache", namespace = JsPackage.GLOBAL)
public class Cache {

    /**
     * Whether caching is enabled. Default is false.
     */
    public boolean enabled;

    /**
     * An object that holds cached files.
     */
    public Object files;

    /**
     * Adds a cache entry with a key to reference the file. If this key already holds a file, it is overwritten.
     *
     * @param key  — the key to reference the cached file by.
     * @param file — The file to be cached.
     */
    public native void add(String key, Object file);

    /**
     * Get the value of key. If the key does not exist undefined is returned.
     *
     * @param key — A string key
     */
    public native void get(String key);

    /**
     * Remove the cached file associated with the key.
     *
     * @param key — A string key that references a cached file.
     */
    public native void remove(String key);

    /**
     * Remove all values from the cache.
     */
    public native void clear();
}
