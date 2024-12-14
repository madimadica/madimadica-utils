package com.madimadica.utils;

import java.util.*;

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
 *     There is no <code>List.copyOfMutable(collection)</code>,
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
     *     Return an unmodifiable list containing a variable number of elements.
     *     <br>
     *     The elements may contain {@code null} values, but the argument itself may not be {@code null}.
     * </p>

     * <p>
     *     To create an unmodifiable list with a single {@code null} value,
     *     use {@code Lists.ofNullable((T) null)} where {@code T} is the resulting type.
     * </p>
     * @param <T> the {@code List}'s element type
     * @param elements the elements to be in the resulting list.
     * @return an unmodifiable {@code List} containing the arguments in order.
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
     *     Return a mutable list containing a variable number of elements.
     *     <br>
     *     The elements may contain {@code null} values, but the argument itself may not be {@code null}.
     * </p>

     * <p>
     *     To create an unmodifiable list with a single {@code null} value,
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
     *     Return an unmodifiable list containing all the elements
     *     in the {@code originalCollection} in their encounter order.
     * </p>
     * @param <T> type of collection elements
     * @param originalCollection collection to copy elements from.
     * @return an unmodifiable {@code List} containing all the {@code Collection}'s elements.
     * @throws NullPointerException if {@code originalCollection} is {@code null}.
     * @since 1.0
     */
    public static <T> List<T> copyOfNullable(Collection<? extends T> originalCollection) {
        List<T> result = new ArrayList<>(originalCollection);
        return Collections.unmodifiableList(result);
    }

}
