package com.madimadica.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * <p>
     *     Partition (split) the given list into a total of {@code numberOfPartitions} sublists.
     * </p>
     * <p>
     *     For example, if the given list was size 200, and you {@code numberOfPartitions} was 4,
     *     then the result would be 4 lists, each with a size of 50. If instead the list was
     *     size 201, the first of the 4 lists would be size 51, and the other 3 would be size 50.
     * </p>
     * <p>
     *     The returned list and partitions are all immutable, and are deep copies of the original list.
     * </p>
     *
     * @param list List to partition
     * @param numberOfPartitions Total number of resulting partitions
     * @return An immutable list of immutable partitions of equal size (+/- 1)
     * @param <T> Type of list elements
     */
    public static <T> List<List<T>> partitionInto(List<T> list, int numberOfPartitions) {
        if (list.size() < numberOfPartitions) {
            // Handle the cases of empty partitions
            List<List<T>> output = new ArrayList<>();
            for (T t : list) {
                output.add(List.of(t));
            }
            while (output.size() < numberOfPartitions) {
                output.add(List.of());
            }
            return List.copyOf(output);
        }

        int maxPartitionSize = (int) Math.ceil(list.size() / (double) numberOfPartitions);
        return partitionBySize(list, maxPartitionSize);
    }

    /**
     * <p>
     *     Partition (split) the given list into sublists of a size {@code partitionSize}.
     * </p>
     * <p>
     *     For example, if the given list was size 200, and you {@code partitionSize} was 25,
     *     then the result would be 8 lists, each with a size of 25. If instead the list was
     *     size 201, there would be a 9th list of size 1. If it was size 200, there would be
     *     7 lists of size 25, and the 8th list would be size 15.
     * </p>
     * <p>
     *     Elements are not uniformly distributed, and the returned partitions are in non-increasing order.
     * </p>
     * <p>
     *     The returned list and partitions are all immutable, and are deep copies of the original list.
     * </p>
     *
     * @param list List to partition
     * @param partitionSize Maximum size of each resulting partition
     * @return An immutable list of immutable partitions of size up to and including {@code partitionSize}
     * @param <T> Type of list elements
     */
    public static <T> List<List<T>> partitionBySize(List<T> list, int partitionSize) {
        final int originalSize = list.size();
        if (originalSize < partitionSize) {
            // Single partition
            return List.of(Collections.unmodifiableList(list));
        }
        final int totalPartitions = (int) Math.ceil(originalSize / (double) partitionSize);
        List<List<T>> partitions = new ArrayList<>(totalPartitions);
        List<T> currentPartition = new ArrayList<>();
        for (T t : list) {
            currentPartition.add(t);
            if (currentPartition.size() == partitionSize) {
                // Partition is full, start a new one
                partitions.add(Collections.unmodifiableList(currentPartition));
                currentPartition = new ArrayList<>();
            }
        }
        if (!currentPartition.isEmpty()) {
            partitions.add(Collections.unmodifiableList(currentPartition));
        }
        return Collections.unmodifiableList(partitions);
    }

    /**
     * <p>
     * Partition the list into at most {@code maxPartitions} partitions, but use less when possible,
     * according to the {@code preferredPartitionSize}. If the {@code preferredPartitionSize} would
     * exceed {@code maxPartitions}, then {@code maxPartitions} is prioritized and each partition
     * will be of at least size {@code preferredPartitionSize}.
     * </p>
     * <p>
     *     For example, with a {@code list} of size 200, calling <code>partitionClamp(list, 5, 25)</code>
     *     will try to partition into size 25, but that would result in more than 5 partitions. Therefore,
     *     the partition size is actually 40. By instead calling <code>partitionClamp(list, 5, 100)</code>
     *     it will try to partition into size 100, which does not exceed the maximum of 5 partitions,
     *     and will instead result in 2 partitions, each with size 100.
     * </p>
     * <p>
     *     The returned list and partitions are all immutable, and are deep copies of the original list.
     * </p>
     *
     * @param list list to partition
     * @param maxPartitions the maximum number of partitions to return
     * @param preferredPartitionSize the preferred size of the partitions returned
     * @return An immutable list of immutable partitions
     * @param <T> Type of list elements
     * @see Lists#partitionInto(List, int)
     * @see Lists#partitionBySize(List, int)
     */
    public static <T> List<List<T>> partitionClamp(List<T> list, int maxPartitions, int preferredPartitionSize) {
        if (Math.ceil(list.size() / (double) preferredPartitionSize) > maxPartitions) {
            return partitionInto(list, maxPartitions);
        } else {
            return partitionBySize(list, preferredPartitionSize);
        }
    }

    /**
     * Flat-Map a variable number of collections into a single list (immutable).
     * @param collections varargs of collections to flatten
     * @return An immutable list of the combined collections
     * @param <T> Type of collection elements
     * @throws NullPointerException if any argument of element of an argument is {@code null}
     */
    @SafeVarargs
    public static <T> List<T> flatMap(Collection<T>... collections) {
        return Stream.of(collections).flatMap(Collection::stream).collect(Collectors.toUnmodifiableList());
    }

    /**
     * <p>
     *     Create an immutable, non-null List from the given iterable.
     * </p>
     * <p>
     *     Does not allow {@code null} elements.
     * </p>
     * @param iterable element source
     * @return Immutable list of elements
     * @param <T> Type of list elements
     * @throws NullPointerException if {@code iterable} or any element is {@code null}.
     */
    public static <T> List<T> ofIterable(Iterable<T> iterable) {
        List<T> output = new ArrayList<>();
        for (T t : iterable) {
            output.add(Objects.requireNonNull(t));
        }
        return Collections.unmodifiableList(output);
    }

    /**
     * <p>
     *     Create an immutable, nullable List from the given iterable.
     * </p>
     * <p>
     *     Allows for {@code null} elements.
     * </p>
     * @param iterable element source
     * @return Immutable list of elements
     * @param <T> Type of list elements
     * @throws NullPointerException if {@code iterable} is {@code null}.
     */
    public static <T> List<T> ofIterableNullable(Iterable<T> iterable) {
        List<T> output = new ArrayList<>();
        for (T t : iterable) {
            output.add(t);
        }
        return Collections.unmodifiableList(output);
    }

    /**
     * <p>
     *     Create a mutable, nullable List from the given iterable.
     * </p>
     * <p>
     *     Allows for {@code null} elements.
     * </p>
     * @param iterable element source
     * @return Mutable list of elements
     * @param <T> Type of list elements
     * @throws NullPointerException if {@code iterable} is {@code null}.
     */
    public static <T> List<T> ofIterableMutable(Iterable<T> iterable) {
        List<T> output = new ArrayList<>();
        for (T t : iterable) {
            output.add(t);
        }
        return output;
    }

    /**
     * In-place sort a list of type {@code T} using case-insensitive string comparisons of
     * the results from {@code stringMapper}
     * @param list List to inplace sort
     * @param stringMapper Function to map {@code T} to {@link String}
     * @param <T> Type of elements
     * @throws UnsupportedOperationException if list is immutable
     */
    public static <T> void sortCaseInsensitive(List<T> list, Function<? super T, String> stringMapper) {
        list.sort((a, b) -> String.CASE_INSENSITIVE_ORDER.compare(stringMapper.apply(a), stringMapper.apply(b)));
    }

    /**
     * Flatten all iterables and arrays down to a flat list of elements.
     * <p>
     *     Nested elements, such as a {@code List<List<T>>} get recursively flattened.
     * </p>
     * <p>
     *     The returned list is mutable.
     * </p>
     * @param args values to flatten
     * @return A mutable list of flattened values
     */
    public static List<?> flatten(Object... args) {
        List<Object> output = new ArrayList<>();
        for (Object arg : args) {
            // how does it work with T[]
            if (arg == null) {
                output.add(null);
            } else if (arg instanceof Iterable<?>) {
                for (Object o : (Iterable<?>) arg) {
                    output.addAll(flatten(o));
                }
            } else if (arg instanceof Object[]) {
                output.addAll(flatten((Object[]) arg));
            } else if (arg instanceof byte[]) {
                for (byte b : (byte[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof short[]) {
                for (short b : (short[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof int[]) {
                for (int b : (int[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof long[]) {
                for (long b : (long[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof float[]) {
                for (float b : (float[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof double[]) {
                for (double b : (double[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof boolean[]) {
                for (boolean b : (boolean[]) arg) {
                    output.add(b);
                }
            } else if (arg instanceof char[]) {
                for (char b : (char[]) arg) {
                    output.add(b);
                }
            } else {
                output.add(arg);
            }
        }
        return output;
    }

    /**
     * Group elements by a key mapping function. All elements with the same mapped key are part of the same group.
     * <p>
     *     Returned {@link Map} and {@link List}s are guaranteed mutable with {@link HashMap} and {@link ArrayList} respectively.
     * </p>
     * <p>
     *     Mappings to {@code null} keys are allowed, which differs from {@link Collectors#groupingBy(Function)}
     * </p>
     * @param collection collection of data to cluster
     * @param classifier how to cluster the data (the key to group on)
     * @return A mutable Map of Mutable Lists.
     * @param <K> Type of the key to group on
     * @param <V> Type of the elements being grouped
     * @throws NullPointerException if any element of {@code collection} is {@code null}.
     */
    public static <K, V> Map<K, List<V>> groupBy(Collection<V> collection, Function<? super V, ? extends K> classifier) {
        Map<K, List<V>> map = new HashMap<>();
        for (V v : collection) {
            K key = classifier.apply(Objects.requireNonNull(v));
            List<V> group = map.computeIfAbsent(key, k -> new ArrayList<>());
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
     *     Returned {@link Map} and {@link List}s are guaranteed mutable with {@link HashMap} and {@link ArrayList} respectively.
     * </p>
     * <p>
     *     Mappings to {@code null} keys are allowed, which differs from {@link Collectors#groupingBy(Function)}
     * </p>
     * @param collection collection of data to cluster
     * @param classifier how to cluster the data (the key to group on)
     * @param valueMapper how to remap the elements after grouping
     * @return A mutable Map of Mutable Lists.
     * @param <K> Type of the key to group on
     * @param <V> Type of the elements being grouped
     * @throws NullPointerException if any element of {@code collection} is {@code null}.
     */
    public static <K, V, Y> Map<K, List<Y>> groupByAndMap(Collection<V> collection, Function<? super V, ? extends K> classifier, Function<? super V, ? extends Y> valueMapper) {
        Map<K, List<Y>> map = new HashMap<>();
        for (V v : collection) {
            K key = classifier.apply(Objects.requireNonNull(v));
            List<Y> group = map.computeIfAbsent(key, k -> new ArrayList<>());
            group.add(valueMapper.apply(v));
        }
        return map;
    }

}
