package com.madimadica.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.Objects;

/**
 * Static utilities for Maps.
 */
public abstract class Maps {

    /**
     * Allow for user extension.
     */
    public Maps() {}

    /**
     * Creates an immutable map with 1 entry.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1) {
        if (k1 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(1);
        map.put(k1, v1);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 2 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2) {
        if (k1 == null || k2 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 3 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3) {
        if (k1 == null || k2 == null || k3 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(3);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 4 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        if (k1 == null || k2 == null || k3 == null || k4 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(4);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 5 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(5);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 6 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(6);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 7 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(7);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 8 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(8);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 9 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(9);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 10 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(10);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 11 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(11);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an immutable map with 12 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @param k12 key for entry 12
     * @param v12 value for entry 12
     * @return An unordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null || k12 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(12);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        map.put(k12, v12);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates a mutable map with 1 entry.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1) {
        if (k1 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(1);
        map.put(k1, v1);
        return map;
    }

    /**
     * Creates a mutable map with 2 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2) {
        if (k1 == null || k2 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    /**
     * Creates a mutable map with 3 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3) {
        if (k1 == null || k2 == null || k3 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(3);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    /**
     * Creates a mutable map with 4 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        if (k1 == null || k2 == null || k3 == null || k4 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(4);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    /**
     * Creates a mutable map with 5 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(5);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    /**
     * Creates a mutable map with 6 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(6);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return map;
    }

    /**
     * Creates a mutable map with 7 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(7);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return map;
    }

    /**
     * Creates a mutable map with 8 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(8);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return map;
    }

    /**
     * Creates a mutable map with 9 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(9);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return map;
    }

    /**
     * Creates a mutable map with 10 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(10);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return map;
    }

    /**
     * Creates a mutable map with 11 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(11);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        return map;
    }

    /**
     * Creates a mutable map with 12 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @param k12 key for entry 12
     * @param v12 value for entry 12
     * @return An unordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null || k12 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new HashMap<>(12);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        map.put(k12, v12);
        return map;
    }

    /**
     * Creates an ordered, immutable map with 1 entry.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1) {
        if (k1 == null || v1 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(1);
        map.put(k1, v1);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 2 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2) {
        if (k1 == null || v1 == null || k2 == null || v2 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 3 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(3);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 4 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(4);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 5 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(5);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 6 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(6);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 7 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null || k7 == null || v7 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(7);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 8 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null || k7 == null || v7 == null || k8 == null || v8 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(8);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 9 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null || k7 == null || v7 == null || k8 == null || v8 == null || k9 == null || v9 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(9);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 10 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null || k7 == null || v7 == null || k8 == null || v8 == null || k9 == null || v9 == null || k10 == null || v10 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(10);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 11 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null || k7 == null || v7 == null || k8 == null || v8 == null || k9 == null || v9 == null || k10 == null || v10 == null || k11 == null || v11 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(11);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 12 entries.
     * <br>
     * Neither the keys nor values may be {@code null}.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @param k12 key for entry 12
     * @param v12 value for entry 12
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any <em>key or value</em> is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrdered(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12) {
        if (k1 == null || v1 == null || k2 == null || v2 == null || k3 == null || v3 == null || k4 == null || v4 == null || k5 == null || v5 == null || k6 == null || v6 == null || k7 == null || v7 == null || k8 == null || v8 == null || k9 == null || v9 == null || k10 == null || v10 == null || k11 == null || v11 == null || k12 == null || v12 == null) {
            throw new NullPointerException("Map keys and values cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(12);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        map.put(k12, v12);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 1 entry.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1) {
        if (k1 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(1);
        map.put(k1, v1);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 2 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2) {
        if (k1 == null || k2 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 3 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3) {
        if (k1 == null || k2 == null || k3 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(3);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 4 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        if (k1 == null || k2 == null || k3 == null || k4 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(4);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 5 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(5);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 6 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(6);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 7 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(7);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 8 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(8);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 9 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(9);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 10 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(10);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 11 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(11);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, immutable map with 12 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @param k12 key for entry 12
     * @param v12 value for entry 12
     * @return An ordered immutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedNullable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null || k12 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(12);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        map.put(k12, v12);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered, mutable map with 1 entry.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1) {
        if (k1 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(1);
        map.put(k1, v1);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 2 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2) {
        if (k1 == null || k2 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 3 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3) {
        if (k1 == null || k2 == null || k3 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(3);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 4 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        if (k1 == null || k2 == null || k3 == null || k4 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(4);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 5 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(5);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 6 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(6);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 7 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(7);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 8 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(8);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 9 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(9);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 10 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(10);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 11 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(11);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        return map;
    }

    /**
     * Creates an ordered, mutable map with 12 entries.
     * <br>
     * The values can be {@code null}, but keys must be non-null.
     * @param k1 key for entry 1
     * @param v1 value for entry 1
     * @param k2 key for entry 2
     * @param v2 value for entry 2
     * @param k3 key for entry 3
     * @param v3 value for entry 3
     * @param k4 key for entry 4
     * @param v4 value for entry 4
     * @param k5 key for entry 5
     * @param v5 value for entry 5
     * @param k6 key for entry 6
     * @param v6 value for entry 6
     * @param k7 key for entry 7
     * @param v7 value for entry 7
     * @param k8 key for entry 8
     * @param v8 value for entry 8
     * @param k9 key for entry 9
     * @param v9 value for entry 9
     * @param k10 key for entry 10
     * @param v10 value for entry 10
     * @param k11 key for entry 11
     * @param v11 value for entry 11
     * @param k12 key for entry 12
     * @param v12 value for entry 12
     * @return An ordered mutable map with the given entries.
     * @param <K> key type
     * @param <V> key type
     * @throws NullPointerException if any key is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> ofOrderedMutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12) {
        if (k1 == null || k2 == null || k3 == null || k4 == null || k5 == null || k6 == null || k7 == null || k8 == null || k9 == null || k10 == null || k11 == null || k12 == null) {
            throw new NullPointerException("Map keys cannot be null");
        }
        Map<K, V> map = new LinkedHashMap<>(12);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        map.put(k12, v12);
        return map;
    }

    /**
     * <p>Returns a nullable map containing the keys and values from the given entries.</p>
     * <p>The keys may <strong>not</strong> be {@code null}.</p>
     * <p>The values may be {@code null}.</p>
     * @param <K> key type
     * @param <V> key type
     * @param entries {@code Map.Entry}s containing the key-value pairs to insert into the new map.
     * @return a nullable map containing the specified key-value pairs.
     * @throws IllegalArgumentException if there are any duplicate keys
     * @throws NullPointerException if the {@code entries} argument is {@code null} or any key is {@code null}
     * 
     * @see Map#entry
     * @see Maps#entry
     * @since 1.0
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofNullableEntries(Map.Entry<? extends K, ? extends V>... entries) {
        Objects.requireNonNull(entries);
        Map<K, V> map = new HashMap<>(entries.length);
        List<Map.Entry<? extends K, ? extends V>> entryList = List.of(entries);
        int prevSize = 0;
        for (Map.Entry<? extends K, ? extends V> entry : entryList) {
            K key = Objects.requireNonNull(entry.getKey());
            V value = entry.getValue();
            map.put(key, value);
            if (map.size() != ++prevSize) {
                throw new IllegalArgumentException("Duplicate key: \"" + key + "\" not allowed.");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * <p>Returns a mutable map containing the keys and values from the given entries.</p>
     * <p>The keys may <strong>not</strong> be {@code null}.</p>
     * <p>The values may be {@code null}.</p>
     * @param <K> key type
     * @param <V> key type
     * @param entries {@code Map.Entry}s containing the key-value pairs to insert into the new map.
     * @return a mutable map containing the specified key-value pairs.
     * @throws IllegalArgumentException if there are any duplicate keys
     * @throws NullPointerException if the {@code entries} argument is {@code null} or any key is {@code null}
     * 
     * @see Map#entry
     * @see Maps#entry
     * @since 1.0
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofMutableEntries(Map.Entry<? extends K, ? extends V>... entries) {
        Objects.requireNonNull(entries);
        Map<K, V> map = new HashMap<>(entries.length);
        List<Map.Entry<? extends K, ? extends V>> entryList = List.of(entries);
        int prevSize = 0;
        for (Map.Entry<? extends K, ? extends V> entry : entryList) {
            K key = Objects.requireNonNull(entry.getKey());
            V value = entry.getValue();
            map.put(key, value);
            if (map.size() != ++prevSize) {
                throw new IllegalArgumentException("Duplicate key: \"" + key + "\" not allowed.");
            }
        }
        return map;
    }

    /**
     * <p>Returns an ordered map containing the keys and values from the given entries.</p>
     * <p>The keys may <strong>not</strong> be {@code null}.</p>
     * <p>The values may <strong>not</strong> be {@code null}.</p>
     * @param <K> key type
     * @param <V> key type
     * @param entries {@code Map.Entry}s containing the key-value pairs to insert into the new map.
     * @return an ordered map containing the specified key-value pairs.
     * @throws IllegalArgumentException if there are any duplicate keys
     * @throws NullPointerException if the {@code entries} argument is {@code null}, if any key is {@code null}, or any value is {@code null}
     * 
     * @see Map#entry
     * @see Maps#entry
     * @since 1.0
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofOrderedEntries(Map.Entry<? extends K, ? extends V>... entries) {
        Objects.requireNonNull(entries);
        Map<K, V> map = new LinkedHashMap<>(entries.length);
        List<Map.Entry<? extends K, ? extends V>> entryList = List.of(entries);
        int prevSize = 0;
        for (Map.Entry<? extends K, ? extends V> entry : entryList) {
            K key = Objects.requireNonNull(entry.getKey());
            V value = Objects.requireNonNull(entry.getValue());
            map.put(key, value);
            if (map.size() != ++prevSize) {
                throw new IllegalArgumentException("Duplicate key: \"" + key + "\" not allowed.");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * <p>Returns an ordered, nullable map containing the keys and values from the given entries.</p>
     * <p>The keys may <strong>not</strong> be {@code null}.</p>
     * <p>The values may be {@code null}.</p>
     * @param <K> key type
     * @param <V> key type
     * @param entries {@code Map.Entry}s containing the key-value pairs to insert into the new map.
     * @return an ordered, nullable map containing the specified key-value pairs.
     * @throws IllegalArgumentException if there are any duplicate keys
     * @throws NullPointerException if the {@code entries} argument is {@code null} or any key is {@code null}
     * 
     * @see Map#entry
     * @see Maps#entry
     * @since 1.0
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofOrderedNullableEntries(Map.Entry<? extends K, ? extends V>... entries) {
        Objects.requireNonNull(entries);
        Map<K, V> map = new LinkedHashMap<>(entries.length);
        List<Map.Entry<? extends K, ? extends V>> entryList = List.of(entries);
        int prevSize = 0;
        for (Map.Entry<? extends K, ? extends V> entry : entryList) {
            K key = Objects.requireNonNull(entry.getKey());
            V value = entry.getValue();
            map.put(key, value);
            if (map.size() != ++prevSize) {
                throw new IllegalArgumentException("Duplicate key: \"" + key + "\" not allowed.");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * <p>Returns an ordered, mutable map containing the keys and values from the given entries.</p>
     * <p>The keys may <strong>not</strong> be {@code null}.</p>
     * <p>The values may be {@code null}.</p>
     * @param <K> key type
     * @param <V> key type
     * @param entries {@code Map.Entry}s containing the key-value pairs to insert into the new map.
     * @return an ordered, mutable map containing the specified key-value pairs.
     * @throws IllegalArgumentException if there are any duplicate keys
     * @throws NullPointerException if the {@code entries} argument is {@code null} or any key is {@code null}
     * 
     * @see Map#entry
     * @see Maps#entry
     * @since 1.0
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofOrderedMutableEntries(Map.Entry<? extends K, ? extends V>... entries) {
        Objects.requireNonNull(entries);
        Map<K, V> map = new LinkedHashMap<>(entries.length);
        List<Map.Entry<? extends K, ? extends V>> entryList = List.of(entries);
        int prevSize = 0;
        for (Map.Entry<? extends K, ? extends V> entry : entryList) {
            K key = Objects.requireNonNull(entry.getKey());
            V value = entry.getValue();
            map.put(key, value);
            if (map.size() != ++prevSize) {
                throw new IllegalArgumentException("Duplicate key: \"" + key + "\" not allowed.");
            }
        }
        return map;
    }

    /**
     * Creates an unordered immutable copy of the given map.
     * <br>
     * The keys must <strong>not</strong> be {@code null}.
     * <br>
     * The values may be {@code null}.
     * @param mapToCopy a non-null map to deep-copy the entries from.
     * @throws NullPointerException if any key is null.
     * @since 1.0
     */
    public static <K, V> Map<K, V> copyOfNullable(Map<? extends K, ? extends V> mapToCopy) {
        if (mapToCopy.containsKey(null)) {
           throw new NullPointerException("Map may not contain null keys");
        }
        Map<K, V> map = new HashMap<>(mapToCopy);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered immutable copy of the given map.
     * <br>
     * The keys must <strong>not</strong> be {@code null}.
     * <br>
     * The values may <strong>not</strong> be {@code null}.
     * @param mapToCopy a non-null map to deep-copy the entries from.
     * @throws NullPointerException if any key or value is null.
     * @since 1.0
     */
    public static <K, V> Map<K, V> copyOfOrdered(Map<? extends K, ? extends V> mapToCopy) {
        if (mapToCopy.containsKey(null)) {
           throw new NullPointerException("Map may not contain null keys");
        }
        if (mapToCopy.containsValue(null)) {
           throw new NullPointerException("Map may not contain null values");
        }
        Map<K, V> map = new LinkedHashMap<>(mapToCopy);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Creates an ordered immutable copy of the given map.
     * <br>
     * The keys must <strong>not</strong> be {@code null}.
     * <br>
     * The values may be {@code null}.
     * @param mapToCopy a non-null map to deep-copy the entries from.
     * @throws NullPointerException if any key is null.
     * @since 1.0
     */
    public static <K, V> Map<K, V> copyOfOrderedNullable(Map<? extends K, ? extends V> mapToCopy) {
        if (mapToCopy.containsKey(null)) {
           throw new NullPointerException("Map may not contain null keys");
        }
        Map<K, V> map = new LinkedHashMap<>(mapToCopy);
        return Collections.unmodifiableMap(map);
    }


    public static <K, V> Maps.Entry<K, V> entry(K key, V value) {
        return new Maps.Entry<>(key, value);
    }
    
    public static class Entry<K, V> implements Map.Entry<K, V> {
        
        private final K key;
        private final V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }
    }

}
