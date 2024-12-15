package com.madimadica.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Static helper methods and factories for dealing with Lists.
 * <h2>Factory Properies</h2>
 * <p>
 *     A summary of the properties of the resulting list created by the static factory methods is
 *     described in this table. While not labeled in the table, this includes the equivalent {@code copyOf...} factories.
 * </p>
 * <table>
 *     <thead>
 *         <tr>
 *             <th>Name</th>
 *             <th>Nullable</th>
 *             <th>Mutable</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>java.util.List#of</td>
 *             <td>no</td>
 *             <td>no</td>
 *         </tr>
 *         <tr>
 *             <td>Lists#ofNullable</td>
 *             <td>yes</td>
 *             <td>no</td>
 *         </tr>
 *         <tr>
 *             <td>Lists#ofMutable</td>
 *             <td>yes</td>
 *             <td>yes</td>
 *         </tr>
 *     </tbody>
 * </table>
 * <p>
 *     There is no <code>Lists.copyOfMutable(collection)</code>,
 *     instead use <code>new ArrayList&lt;&gt;(collection)</code>
 *     to achieve the same functionality.
 * </p>
 * @see List
 * @since 1.0
 */
public abstract class Lists {

    /**
     * Allow for user extension.
     */
    public Lists() {}

    /**
     * <p>
     *     Returns an immutable list containing a variable number of elements.
     *     <br>
     *     The elements may contain {@code null} values, but the argument itself may not be {@code null}.
     * </p>

     * <p>
     *     To create an immutable list with a single {@code null} value,
     *     use {@code Lists.ofNullable((T) null)} where {@code T} is the resulting type.
     * </p>
     * @param <T> the {@code List}'s element type
     * @param elements the elements to be in the resulting list.
     * @return an immutable {@code List} containing the arguments in order.
     * @throws NullPointerException if {@code elements} is {@code null}.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> List<T> ofNullable(T... elements) {
        List<T> result = new ArrayList<>(elements.length);
        Collections.addAll(result, elements);
        return Collections.unmodifiableList(result);
    }

    /**
     * <p>
     *     Returns a mutable list containing a variable number of elements.
     *     <br>
     *     The elements may contain {@code null} values, but the argument itself may not be {@code null}.
     * </p>

     * <p>
     *     To create a mutable list with a single {@code null} value,
     *     use {@code Lists.ofMutable((T) null)} where {@code T} is the resulting type.
     * </p>
     * @param <T> the {@code List}'s element type
     * @param elements the elements to be in the resulting list.
     * @return a mutable {@code List} containing the arguments in order.
     * @throws NullPointerException if {@code elements} is {@code null}.
     * @since 1.0
     */
    @SafeVarargs
    public static <T> List<T> ofMutable(T... elements) {
        List<T> result= new ArrayList<>(elements.length);
        Collections.addAll(result, elements);
        return result;
    }

    /**
     * <p>
     *     Returns an immutable list containing all the elements
     *     in the {@code originalCollection} in their encounter order.
     * </p>
     * @param <T> type of collection elements
     * @param originalCollection collection to copy elements from.
     * @return an immutable {@code List} containing all the {@code Collection}'s elements.
     * @throws NullPointerException if {@code originalCollection} is {@code null}.
     * @since 1.0
     */
    public static <T> List<T> copyOfNullable(Collection<? extends T> originalCollection) {
        List<T> result = new ArrayList<>(originalCollection);
        return Collections.unmodifiableList(result);
    }

    /**
     * Map the given list into an immutable list by the given mapping function.
     * @param list list to map
     * @param mapper function to map each element by.
     * @return an immutable list of the mappings.
     * @param <X> type of input list elements
     * @param <Y> type of output list elements
     */
    public static <X, Y> List<Y> map(List<X> list, Function<? super X, ? extends Y> mapper) {
        return list.stream().map(mapper).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Map the given list into a mutable list by the given mapping function.
     * @param list list to apply mapping to
     * @param mapper function to map each element by.
     * @return a mutable list of the mappings.
     * @param <X> type of input list elements
     * @param <Y> type of output list elements
     */
    public static <X, Y> List<Y> mapMutable(List<X> list, Function<? super X, ? extends Y> mapper) {
        List<Y> output = new ArrayList<>(list.size());
        for (var e : list) {
            output.add(mapper.apply(e));
        }
        return output;
    }

    /**
     * Filter the given list into an immutable list by the given predicate.
     * @param list list to filter
     * @param predicate predicate to filter on
     * @return an immutable list of the matching elements.
     * @param <X> type of input and output list elements
     */
    public static <X> List<X> filter(List<X> list, Predicate<? super X> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Filter the given list into a mutable list by the given predicate.
     * @param list list to filter
     * @param predicate predicate to filter on
     * @return a mutable list of the matching elements.
     * @param <X> type of input and output list elements
     */
    public static <X> List<X> filterMutable(List<X> list, Predicate<? super X> predicate) {
        List<X> output = new ArrayList<>(list.size());
        for (var e : list) {
            if (predicate.test(e)) {
                output.add(e);
            }
        }
        return output;
    }

    /**
     * Return an immutable, sorted copy of the input list.
     * @param list list of elements to sort elements of
     * @return a sorted, immutable copy of the original list
     * @param <T> type of list elements
     */
    public static <T extends Comparable<? super T>> List<T> sorted(List<T> list) {
        return Collections.unmodifiableList(sortedMutable(list));
    }

    /**
     * Return a mutable, sorted copy of the input list.
     * @param list list of elements to sort elements of
     * @return a sorted, mutable copy of the original list
     * @param <T> type of list elements
     */
    public static <T extends Comparable<? super T>> List<T> sortedMutable(List<T> list) {
        List<T> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    /**
     * Return an immutable, sorted copy of the input list.
     * @param list list of elements to sort elements of
     * @param comparator sort order
     * @return a sorted, immutable copy of the original list
     * @param <T> type of list elements
     */
    public static <T> List<T> sorted(List<T> list, Comparator<? super T> comparator) {
        return Collections.unmodifiableList(sortedMutable(list, comparator));
    }

    /**
     * Return a mutable, sorted copy of the input list.
     * @param list list of elements to sort elements of
     * @param comparator sort order
     * @return a sorted, mutable copy of the original list
     * @param <T> type of list elements
     */
    public static <T> List<T> sortedMutable(List<T> list, Comparator<? super T> comparator) {
        List<T> copy = new ArrayList<>(list);
        copy.sort(comparator);
        return copy;
    }

    /**
     * Return an immutable copy of the given list in reverse order.
     * @param list list of original elements
     * @return an immutable copy of the original list, in reverse order.
     * @param <T> type of list elements
     */
    public static <T> List<T> reversed(List<T> list) {
        return Collections.unmodifiableList(reversedMutable(list));
    }

    /**
     * Return a mutable copy of the given list in reverse order.
     * @param list list of original elements
     * @return a mutable copy of the original list, in reverse order.
     * @param <T> type of list elements
     */
    public static <T> List<T> reversedMutable(List<T> list) {
        List<T> copy = new ArrayList<>(list);
        Collections.reverse(copy);
        return copy;
    }

    /**
     * Map a list to an immutable set by a given mapping function.
     * @param list list to map elements from
     * @param mapper function to map each element by
     * @return an immutable set of mapped elements
     * @param <X> type of input list elements
     * @param <Y> type of output set elements
     */
    public static <X, Y> Set<Y> mapToSet(List<X> list, Function<? super X, ? extends Y> mapper) {
        return list.stream().map(mapper).collect(Collectors.toUnmodifiableSet());
    }

    /**
     * Map a list to a mutable set by a given mapping function.
     * @param list list to map elements from
     * @param mapper function to map each element by
     * @return an mutable set of mapped elements
     * @param <X> type of input list elements
     * @param <Y> type of output set elements
     */
    public static <X, Y> Set<Y> mapToMutableSet(List<X> list, Function<? super X, ? extends Y> mapper) {
        Set<Y> set = new HashSet<>();
        list.forEach(x -> set.add(mapper.apply(x)));
        return set;
    }

    /**
     * Convert a list of elements to a mapping of those same elements by the given {@code keyMapper}.
     * The result is an immutable Map.
     * @param list Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @return An immutable map from the extracted keys to the original values
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values, also the type of the input list
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key is {@code null}, if the mapper is {@code null}, or if any list element is {@code null}.
     */
    public static <K, V> Map<K, V> toMap(List<V> list, Function<? super V, ? extends K> keyMapper) {
        return list.stream().collect(Collectors.toUnmodifiableMap(keyMapper, Function.identity()));
    }

    /**
     * Convert a list of elements to a mapping of those same elements by the given {@code keyMapper} and {@code valueMapper}.
     * The result is an immutable Map.
     * @param list Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @param valueMapper Function to determine the value of an element/entry. This cannot map to {@code null}.
     * @return An immutable map of the computed key-value pairs
     * @param <T> Type of the original list elements
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key or value is {@code null}, if either mapper is {@code null}, or if any list element is {@code null}.
     */
    public static <T, K, V> Map<K, V> toMap(List<T> list, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return list.stream().collect(Collectors.toUnmodifiableMap(keyMapper, valueMapper));
    }

    /**
     * Convert a list of elements to a mapping of those same elements by the given {@code keyMapper}.
     * The result is a mutable Map.
     * @param list Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @return A mutable map from the extracted keys to the original values
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values, also the type of the input list
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key is {@code null}, if the mapper is {@code null}, or if any list element is {@code null}.
     */
    public static <K, V> Map<K, V> toMutableMap(List<V> list, Function<? super V, ? extends K> keyMapper) {
        Map<K, V> output = new HashMap<>();
        for (V v : list) {
            K key = Objects.requireNonNull(keyMapper.apply(v));
            V val = Objects.requireNonNull(v);
            if (output.put(key, val) != null) {
                throw new IllegalStateException("Duplicate key mapping: " + key);
            }
        }
        return output;
    }

    /**
     * Convert a list of elements to a mapping of those same elements by the given {@code keyMapper} and {@code valueMapper}.
     * The result is a mutable Map.
     * @param list Elements to turn into a {@link Map}
     * @param keyMapper Function to determine the key of an element/entry. This mapping should return a unique value per element.
     * @param valueMapper Function to determine the value of an element/entry. This cannot map to {@code null}.
     * @return A mutable map of the computed key-value pairs
     * @param <T> Type of the original list elements
     * @param <K> Type of the resulting entry keys
     * @param <V> Type of the resulting entry values
     * @throws IllegalStateException If the extracted keys are not unique
     * @throws NullPointerException If any extracted key or value is {@code null}, if either mapper is {@code null}, or if any list element is {@code null}.
     */
    public static <T, K, V> Map<K, V> toMutableMap(List<T> list, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        Map<K, V> output = new HashMap<>();
        for (T t : list) {
            Objects.requireNonNull(t);
            K key = Objects.requireNonNull(keyMapper.apply(t));
            V val = Objects.requireNonNull(valueMapper.apply(t));
            if (output.put(key, val) != null) {
                throw new IllegalStateException("Duplicate key mapping: " + key);
            }
        }
        return output;
    }

}
