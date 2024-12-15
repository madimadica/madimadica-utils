package com.madimadica.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Static helper methods and factories for dealing with Sets.
 *
 * <h2>Factory Properies</h2>
 * <p>
 *     A summary of the properties of the resulting set created by the static factory methods is
 *     described in this table. While not labeled in the table, this includes the equivalent {@code copyOf...} factories.
 * </p>
 * <table>
 *     <thead>
 *         <tr>
 *             <th>Name</th>
 *             <th>Nullable</th>
 *             <th>Mutable</th>
 *             <th>Ordered</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>java.util.Set#of</td>
 *             <td>no</td>
 *             <td>no</td>
 *             <td>no</td>
 *         </tr>
 *         <tr>
 *             <td>Sets#ofNullable</td>
 *             <td>yes</td>
 *             <td>no</td>
 *             <td>no</td>
 *         </tr>
 *         <tr>
 *             <td>Sets#ofMutable</td>
 *             <td>yes</td>
 *             <td>yes</td>
 *             <td>no</td>
 *         </tr>
 *         <tr>
 *             <td>Sets#ofOrdered</td>
 *             <td>no</td>
 *             <td>no</td>
 *             <td>yes</td>
 *         </tr>
 *         <tr>
 *             <td>Sets#ofOrderedNullable</td>
 *             <td>yes</td>
 *             <td>no</td>
 *             <td>yes</td>
 *         </tr>
 *         <tr>
 *             <td>Sets#ofOrderedMutable</td>
 *             <td>yes</td>
 *             <td>yes</td>
 *             <td>yes</td>
 *         </tr>
 *     </tbody>
 * </table>
 * <p>
 *     There is no <code>Lists.copyOfOrderedMutable(collection)</code>,
 *     instead use <code>new LinkedHashSet&lt;&gt;(collection)</code>
 *     to achieve the same functionality.
 * </p>
 * <p>
 *     There is no <code>Lists.copyOfMutable(collection)</code>,
 *     instead use <code>new HashSet&lt;&gt;(collection)</code>
 *     to achieve the same functionality.
 * </p>
 * @see Set
 * @since 1.0
 */
public abstract class Sets {

    /**
     * Allow for user extension.
     */
    public Sets() {}

    /**
     * <p>
     *     Returns an immutable set containing the unique arguments.
     * </p>
     * <p>
     *     Does not allow duplicate arguments.
     * </p>
     * <p>
     *     Allows {@code null} arguments.
     * </p>
     * @param <T> the {@code Set}'s element type
     * @param elements the elements to be in the resulting set.
     * @return an immutable {@code Set} containing the arguments.
     * @throws NullPointerException if {@code elements} is {@code null}.
     * @throws IllegalArgumentException if {@code elements} contains duplicates.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> Set<T> ofNullable(T... elements) {
        Set<T> result = new HashSet<>(elements.length);
        Collections.addAll(result, elements);
        var out = Collections.unmodifiableSet(result);
        if (out.size() != elements.length) {
            throw new IllegalArgumentException("Arguments may not contain duplicates");
        }
        return out;
    }

    /**
     * <p>
     *     Returns a mutable set containing the unique arguments.
     * </p>
     * <p>
     *     Does not allow duplicate arguments.
     * </p>
     * <p>
     *     Allows {@code null} arguments.
     * </p>
     *
     * @param <T> the {@code Set}'s element type
     * @param elements the elements to be in the resulting set.
     * @return a mutable {@code Set} containing the arguments.
     * @throws NullPointerException if {@code elements} is {@code null}.
     * @throws IllegalArgumentException if {@code elements} contains duplicates.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> Set<T> ofMutable(T... elements) {
        Set<T> result = new HashSet<>(elements.length);
        Collections.addAll(result, elements);
        if (result.size() != elements.length) {
            throw new IllegalArgumentException("Arguments may not contain duplicates");
        }
        return result;
    }

    /**
     * <p>
     *     Returns an immutable, ordered set containing the unique arguments in their given order.
     * </p>
     * <p>
     *     This acts like {@link Set#of()}, except the result is ordered.
     * </p>
     * <p>
     *     Does not allow duplicate arguments.
     * </p>
     * <p>
     *     Does not allow {@code null} arguments.
     * </p>
     * @param <T> the {@code Set}'s element type
     * @param elements the elements to be in the resulting set.
     * @return an immutable, ordered {@code Set} containing the arguments.
     * @throws NullPointerException if {@code elements} is {@code null}, or if any element is {@code null}.
     * @throws IllegalArgumentException if {@code elements} contains duplicates.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> Set<T> ofOrdered(T... elements) {
        final int len = elements.length;
        Set<T> result = new LinkedHashSet<>(len);
        for (int i = 0; i < len; ++i) {
            if (elements[i] == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
            if (!result.add(elements[i])) {
                throw new IllegalArgumentException("Arguments may not contain duplicates");
            }
        }
        return Collections.unmodifiableSet(result);
    }

    /**
     * <p>
     *     Returns an immutable, ordered set containing the unique arguments in their given order.
     * </p>
     * <p>
     *     Does not allow duplicate arguments.
     * </p>
     * <p>
     *     Allows {@code null} arguments.
     * </p>
     * @param <T> the {@code Set}'s element type
     * @param elements the elements to be in the resulting set.
     * @return an immutable, ordered {@code Set} containing the arguments.
     * @throws NullPointerException if {@code elements} is {@code null}.
     * @throws IllegalArgumentException if {@code elements} contains duplicates.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> Set<T> ofOrderedNullable(T... elements) {
        Set<T> result = new LinkedHashSet<>(elements.length);
        Collections.addAll(result, elements);
        if (result.size() != elements.length) {
            throw new IllegalArgumentException("Arguments may not contain duplicates");
        }
        return Collections.unmodifiableSet(result);
    }

    /**
     * <p>
     *     Returns a mutable, ordered set containing the unique arguments in their given order.
     * </p>
     * <p>
     *     Does not allow duplicate arguments.
     * </p>
     * <p>
     *     Allows {@code null} arguments.
     * </p>
     * @param <T> the {@code Set}'s element type
     * @param elements the elements to be in the resulting set.
     * @return a mutable, ordered {@code Set} containing the arguments.
     * @throws NullPointerException if {@code elements} is {@code null}.
     * @throws IllegalArgumentException if {@code elements} contains duplicates.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> Set<T> ofOrderedMutable(T... elements) {
        Set<T> result = new LinkedHashSet<>(elements.length);
        Collections.addAll(result, elements);
        if (result.size() != elements.length) {
            throw new IllegalArgumentException("Arguments may not contain duplicates");
        }
        return result;
    }

    /**
     * <p>
     *     Returns an immutable set containing all the unique elements in {@code originalCollection}.
     * </p>
     * <p>
     *     Allows duplicate elements.
     * </p>
     * <p>
     *     Allows {@code null} elements.
     * </p>
     * @param <T> type of collection elements
     * @param originalCollection collection to copy elements from.
     * @return an immutable {@code Set} containing all the unique elements from the {@code Collection}.
     * @throws NullPointerException if {@code originalCollection} is {@code null}.
     * @since 1.0
     */
    public static <T> Set<T> copyOfNullable(Collection<? extends T> originalCollection) {
        Set<T> result = new HashSet<>(originalCollection);
        return Collections.unmodifiableSet(result);
    }

    /**
     * <p>
     *     Returns an immutable, ordered set containing all the unique elements in {@code originalCollection}.
     * </p>
     * <p>
     *     Allows duplicate elements.
     * </p>
     * <p>
     *     Does not allow {@code null} elements.
     * </p>
     * @param <T> type of collection elements
     * @param originalCollection collection to copy elements from.
     * @return an immutable, ordered {@code Set} containing all the unique elements from the {@code Collection}.
     * @throws NullPointerException if {@code originalCollection} is {@code null}, or any elements are {@code null}.
     * @since 1.0
     */
    public static <T> Set<T> copyOfOrdered(Collection<? extends T> originalCollection) {
        var set = new LinkedHashSet<>(originalCollection);
        if (set.contains(null)) {
            throw new NullPointerException("Collection to copy cannot contain nulls!");
        }
        return Collections.unmodifiableSet(set);
    }

    /**
     * <p>
     *     Returns an immutable, ordered set containing all the unique elements in {@code originalCollection}.
     * </p>
     * <p>
     *     Allows duplicate elements.
     * </p>
     * <p>
     *     Allows {@code null} elements.
     * </p>
     * @param <T> type of collection elements
     * @param originalCollection collection to copy elements from.
     * @return an immutable, ordered {@code Set} containing all the unique elements from the {@code Collection}.
     * @throws NullPointerException if {@code originalCollection} is {@code null}.
     * @since 1.0
     */
    public static <T> Set<T> copyOfOrderedNullable(Collection<? extends T> originalCollection) {
        var set = new LinkedHashSet<>(originalCollection);
        return Collections.unmodifiableSet(set);
    }

    /**
     * Map the given set into an immutable set by the given mapping function.
     * @param set set to map
     * @param mapper function to map each element by.
     * @return an immutable set of the mappings.
     * @param <X> type of input set elements
     * @param <Y> type of output set elements
     * @since 1.0
     */
    public static <X, Y> Set<Y> map(Set<X> set, Function<? super X, ? extends Y> mapper) {
        return set.stream().map(mapper).collect(Collectors.toUnmodifiableSet());
    }

    /**
     * Map the given set into a mutable set by the given mapping function.
     * @param set set to apply mapping to
     * @param mapper function to map each element by.
     * @return a mutable set of the mappings.
     * @param <X> type of input set elements
     * @param <Y> type of output set elements
     * @since 1.0
     */
    public static <X, Y> Set<Y> mapMutable(Set<X> set, Function<? super X, ? extends Y> mapper) {
        Set<Y> output = new HashSet<>(set.size());
        for (var e : set) {
            output.add(mapper.apply(e));
        }
        return output;
    }

    /**
     * Map the given set into an immutable list by the given mapping function.
     * @param set set to map
     * @param mapper function to map each element by.
     * @return an immutable list of the mappings.
     * @param <X> type of input set elements
     * @param <Y> type of output list elements
     * @since 1.0
     */
    public static <X, Y> List<Y> mapToList(Set<X> set, Function<? super X, ? extends Y> mapper) {
        return set.stream().map(mapper).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Map the given set into a mutable list by the given mapping function.
     * @param set set to apply mapping to
     * @param mapper function to map each element by.
     * @return a mutable list of the mappings.
     * @param <X> type of input set elements
     * @param <Y> type of output list elements
     * @since 1.0
     */
    public static <X, Y> List<Y> mapToMutableList(Set<X> set, Function<? super X, ? extends Y> mapper) {
        List<Y> output = new ArrayList<>(set.size());
        for (var e : set) {
            output.add(mapper.apply(e));
        }
        return output;
    }

    /**
     * Convert a set of elements to a mapping of those same elements by the given {@code keyMapper}.
     * The result is an immutable Map.
     * @param set Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @return An immutable map from the extracted keys to the original values
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values, also the type of the input list
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key is {@code null}, if the mapper is {@code null}, or if any set element is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> toMap(Set<V> set, Function<? super V, ? extends K> keyMapper) {
        return set.stream().collect(Collectors.toUnmodifiableMap(keyMapper, Function.identity()));
    }

    /**
     * Convert a set of elements to a mapping of those same elements by the given {@code keyMapper} and {@code valueMapper}.
     * The result is an immutable Map.
     * @param set Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @param valueMapper Function to determine the value of an element/entry. This cannot map to {@code null}.
     * @return An immutable map of the computed key-value pairs
     * @param <T> Type of the original set elements
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key or value is {@code null}, if either mapper is {@code null}, or if any set element is {@code null}.
     * @since 1.0
     */
    public static <T, K, V> Map<K, V> toMap(Set<T> set, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return set.stream().collect(Collectors.toUnmodifiableMap(keyMapper, valueMapper));
    }

    /**
     * Convert a set of elements to a mapping of those same elements by the given {@code keyMapper}.
     * The result is a mutable Map.
     * @param set Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @return A mutable map from the extracted keys to the original values
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values, also the type of the input set
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key is {@code null}, if the mapper is {@code null}, or if any set element is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, V> toMutableMap(Set<V> set, Function<? super V, ? extends K> keyMapper) {
        Map<K, V> output = new HashMap<>();
        for (V v : set) {
            K key = Objects.requireNonNull(keyMapper.apply(v));
            V val = Objects.requireNonNull(v);
            if (output.put(key, val) != null) {
                throw new IllegalStateException("Duplicate key mapping: " + key);
            }
        }
        return output;
    }

    /**
     * Convert a set of elements to a mapping of those same elements by the given {@code keyMapper} and {@code valueMapper}.
     * The result is a mutable Map.
     * @param set Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @param valueMapper Function to determine the value of an element/entry. This cannot map to {@code null}.
     * @return A mutable map of the computed key-value pairs
     * @param <T> Type of the original set elements
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key or value is {@code null}, if either mapper is {@code null}, or if any set element is {@code null}.
     * @since 1.0
     */
    public static <T, K, V> Map<K, V> toMutableMap(Set<T> set, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        Map<K, V> output = new HashMap<>();
        for (T t : set) {
            Objects.requireNonNull(t);
            K key = Objects.requireNonNull(keyMapper.apply(t));
            V val = Objects.requireNonNull(valueMapper.apply(t));
            if (output.put(key, val) != null) {
                throw new IllegalStateException("Duplicate key mapping: " + key);
            }
        }
        return output;
    }


    /**
     * Filter the given set into an immutable set by the given predicate.
     * @param set set to filter
     * @param predicate predicate to filter on
     * @return an immutable set of the matching elements.
     * @param <X> type of input and output set elements
     * @since 1.0
     */
    public static <X> Set<X> filter(Set<X> set, Predicate<? super X> predicate) {
        return set.stream().filter(predicate).collect(Collectors.toUnmodifiableSet());
    }

    /**
     * Filter the given set into a mutable set by the given predicate.
     * @param set set to filter
     * @param predicate predicate to filter on
     * @return a mutable set of the matching elements.
     * @param <X> type of input and output set elements
     * @since 1.0
     */
    public static <X> Set<X> filterMutable(Set<X> set, Predicate<? super X> predicate) {
        Set<X> output = new HashSet<>(set.size());
        for (var e : set) {
            if (predicate.test(e)) {
                output.add(e);
            }
        }
        return output;
    }

    /**
     * <p>
     *     Create an immutable, non-null set from the given iterable.
     * </p>
     * <p>
     *     Does not allow {@code null} elements.
     * </p>
     * @param iterable element source
     * @return Immutable set of elements
     * @param <T> Type of set elements
     * @throws NullPointerException if {@code iterable} or any element is {@code null}.
     * @since 1.0
     */
    public static <T> Set<T> ofIterable(Iterable<T> iterable) {
        Set<T> output = new HashSet<>();
        for (T t : iterable) {
            output.add(Objects.requireNonNull(t));
        }
        return Collections.unmodifiableSet(output);
    }

    /**
     * <p>
     *     Create an immutable, nullable set from the given iterable.
     * </p>
     * <p>
     *     Allows for {@code null} elements.
     * </p>
     * @param iterable element source
     * @return Immutable set of elements
     * @param <T> Type of set elements
     * @throws NullPointerException if {@code iterable} is {@code null}.
     * @since 1.0
     */
    public static <T> Set<T> ofIterableNullable(Iterable<T> iterable) {
        Set<T> output = new HashSet<>();
        for (T t : iterable) {
            output.add(t);
        }
        return Collections.unmodifiableSet(output);
    }

    /**
     * <p>
     *     Create a mutable, nullable set from the given iterable.
     * </p>
     * <p>
     *     Allows for {@code null} elements.
     * </p>
     * @param iterable element source
     * @return Mutable set of elements
     * @param <T> Type of set elements
     * @throws NullPointerException if {@code iterable} is {@code null}.
     * @since 1.0
     */
    public static <T> Set<T> ofIterableMutable(Iterable<T> iterable) {
        Set<T> output = new HashSet<>();
        for (T t : iterable) {
            output.add(t);
        }
        return output;
    }

    /**
     * Group elements by a key mapping function. All elements with the same mapped key are part of the same group.
     * <p>
     *     Returned {@link Map} and {@link Set}s are guaranteed mutable with {@link HashMap} and {@link HashSet} respectively.
     * </p>
     * <p>
     *     Mappings to {@code null} keys are allowed, which differs from {@link Collectors#groupingBy(Function)}
     * </p>
     * @param collection collection of data to cluster
     * @param classifier how to cluster the data (the key to group on)
     * @return A mutable Map of Mutable sets.
     * @param <K> Type of the key to group on
     * @param <V> Type of the elements being grouped
     * @throws NullPointerException if any element of {@code collection} is {@code null}.
     * @since 1.0
     */
    public static <K, V> Map<K, Set<V>> groupBy(Collection<V> collection, Function<? super V, ? extends K> classifier) {
        Map<K, Set<V>> map = new HashMap<>();
        for (V v : collection) {
            K key = classifier.apply(Objects.requireNonNull(v));
            Set<V> group = map.computeIfAbsent(key, k -> new HashSet<>());
            group.add(v);
        }
        return map;
    }

    /**
     * Group elements by a key mapping function. All elements with the same mapped key are part of the same group.
     * <p>
     *     Additionally, map the original element to a new value.
     * </p>
     * <p>
     *     Returned {@link Map} and {@link Set}s are guaranteed mutable with {@link HashMap} and {@link HashSet} respectively.
     * </p>
     * <p>
     *     Mappings to {@code null} keys are allowed, which differs from {@link Collectors#groupingBy(Function)}
     * </p>
     * @param collection collection of data to cluster
     * @param classifier how to cluster the data (the key to group on)
     * @param valueMapper how to remap the elements after grouping
     * @return A mutable Map of Mutable sets.
     * @param <K> Type of the key to group on
     * @param <V> Type of the elements being grouped
     * @throws NullPointerException if any element of {@code collection} is {@code null}.
     * @since 1.0
     */
    public static <K, V, Y> Map<K, Set<Y>> groupByAndMap(Collection<V> collection, Function<? super V, ? extends K> classifier, Function<? super V, ? extends Y> valueMapper) {
        Map<K, Set<Y>> map = new HashMap<>();
        for (V v : collection) {
            K key = classifier.apply(Objects.requireNonNull(v));
            Set<Y> group = map.computeIfAbsent(key, k -> new HashSet<>());
            group.add(valueMapper.apply(v));
        }
        return map;
    }
}
