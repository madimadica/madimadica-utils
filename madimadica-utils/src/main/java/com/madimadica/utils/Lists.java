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

}
