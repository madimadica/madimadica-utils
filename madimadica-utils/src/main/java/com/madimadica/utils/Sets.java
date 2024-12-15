package com.madimadica.utils;

import java.util.*;

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

}
