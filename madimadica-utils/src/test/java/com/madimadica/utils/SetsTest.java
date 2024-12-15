package com.madimadica.utils;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class SetsTest {

    private void assertImmutable(Set<Integer> set) {
        assertThrows(UnsupportedOperationException.class, () -> set.add(0));
    }

    private void assertMutable(Set<Integer> set) {
        assertDoesNotThrow(() -> set.add(0));
    }

    @Test
    void copyOfNullable() {
        Set<Integer> original = Sets.ofNullable(1, null, 3);
        Set<Integer> copy = Sets.copyOfNullable(original);
        assertNotSame(original, copy);
        assertEquals(original, copy);
        assertImmutable(copy);
    }

    @Test
    void copyOfNullable_null() {
        assertThrows(NullPointerException.class, () -> Sets.copyOfNullable(null));
    }

    private static List<Integer> getRandomDistinctList() {
        // Create 100k random values, then shuffle
        Set<Integer> randomNumbers = new HashSet<>(100_000);
        while (randomNumbers.size() < 100_000) {
            randomNumbers.add(
                    ThreadLocalRandom.current().nextInt(1_000_000)
            );
        }
        var randomList = new ArrayList<>(randomNumbers);
        Collections.shuffle(randomList);
        return randomList;
    }

    /**
     * Given a factory, create a random array of distinct integers, as the varargs,
     * and verify the resulting set has the same order.
     * @param setFactory static factory method
     */
    void assertOrderedSet(Function<Integer[], Set<Integer>> setFactory) {
        var list = getRandomDistinctList();
        Set<Integer> result = setFactory.apply(list.toArray(new Integer[] {}));
        int index = 0;
        for (Integer x : result) {
            assertEquals(list.get(index), x);
            index++;
        }
    }


    @Test
    void orderedFactories() {
        assertOrderedSet(Sets::ofOrdered);
        assertOrderedSet(Sets::ofOrderedNullable);
        assertOrderedSet(Sets::ofOrderedMutable);
    }

    void assertNoDuplicates(Function<Integer[], Set<Integer>> setFactory) {
        var list = getRandomDistinctList();
        list.add(list.get(0)); // Add duplicate
        assertThrows(IllegalArgumentException.class, () -> setFactory.apply(list.toArray(new Integer[] {})));
        assertThrows(IllegalArgumentException.class, () -> setFactory.apply(new Integer[] {1, 1}));
        assertThrows(IllegalArgumentException.class, () -> setFactory.apply(new Integer[] {1, 2, 1}));
    }

    @Test
    void doesntAllowDuplicates() {
        assertNoDuplicates(Sets::ofNullable);
        assertNoDuplicates(Sets::ofMutable);
        assertNoDuplicates(Sets::ofOrdered);
        assertNoDuplicates(Sets::ofOrderedNullable);
        assertNoDuplicates(Sets::ofOrderedMutable);
    }

    void assertNoNullArg(Function<Integer[], Set<Integer>> setFactory) {
        assertThrows(NullPointerException.class, () -> setFactory.apply(null));
    }

    @Test
    void doesntAllowNullArg() {
        assertNoNullArg(Sets::ofNullable);
        assertNoNullArg(Sets::ofMutable);
        assertNoNullArg(Sets::ofOrdered);
        assertNoNullArg(Sets::ofOrderedNullable);
        assertNoNullArg(Sets::ofOrderedMutable);
    }

    void assertNullCastAllowed(boolean isAllowed, Function<Integer[], Set<Integer>> setFactory) {
        if (isAllowed) {
            assertDoesNotThrow(() -> setFactory.apply(new Integer[]{null}));
        } else {
            assertThrows(NullPointerException.class, () -> setFactory.apply(new Integer[]{null}));
        }
    }

    void runFriendlyTests(Function<Integer[], Set<Integer>> setFactory) {
        var test0 = setFactory.apply(new Integer[] {});
        assertTrue(test0.isEmpty());

        var test1 = setFactory.apply(new Integer[] {1});
        assertEquals(1, test1.size());
        assertEquals(1, test1.stream().findFirst().get());


        assertEquals(2, setFactory.apply(new Integer[] {1, 2}).size());
        assertEquals(3, setFactory.apply(new Integer[] {1, 2, 3}).size());
        assertEquals(4, setFactory.apply(new Integer[] {1, 2, 3, 4}).size());
    }

    @Test
    void testFriendlyInputs() {
        runFriendlyTests(Sets::ofNullable);
        runFriendlyTests(Sets::ofMutable);
        runFriendlyTests(Sets::ofOrdered);
        runFriendlyTests(Sets::ofOrderedNullable);
        runFriendlyTests(Sets::ofOrderedMutable);
    }

    @Test
    void checkNullCastedArg() {
        assertNullCastAllowed(true, Sets::ofNullable);
        assertNullCastAllowed(true, Sets::ofMutable);
        assertNullCastAllowed(false, Sets::ofOrdered);
        assertNullCastAllowed(true, Sets::ofOrderedNullable);
        assertNullCastAllowed(true, Sets::ofOrderedMutable);
    }

    @Test
    void checkMutability() {
        assertImmutable(Sets.ofNullable());
        assertMutable(Sets.ofMutable());
        assertImmutable(Sets.ofOrdered());
        assertImmutable(Sets.ofOrderedNullable());
        assertMutable(Sets.ofOrderedMutable());
    }

    /**
     * Given a copy factory, copy a set of random integers
     * and verify the resulting set has the same order.
     * @param setCopyFactory static factory method to copy elements.
     */
    void assertCopyOrderedSet(Function<List<Integer>, Set<Integer>> setCopyFactory) {
        var list = getRandomDistinctList();
        Set<Integer> result = setCopyFactory.apply(list);
        int index = 0;
        for (Integer x : result) {
            assertEquals(list.get(index), x);
            index++;
        }
    }

    @Test
    void orderedCopyFactories() {
        assertCopyOrderedSet(Sets::copyOfOrdered);
        assertCopyOrderedSet(Sets::copyOfOrderedNullable);
    }

    void runCopyOfImmutableSuite(Function<Collection<Integer>, Set<Integer>> setCopyFactory) {
        List<Integer> original = List.of(1, 2, 3, 2); // Contains dupe
        Set<Integer> copy = setCopyFactory.apply(original);
        Set<Integer> copyOfCopy = setCopyFactory.apply(copy);
        assertNotSame(copy, copyOfCopy);
        assertEquals(3, copy.size());

        assertThrows(NullPointerException.class, () -> setCopyFactory.apply(null));
        assertImmutable(copy);
    }

    @Test
    void copyOfNotSame() {
        runCopyOfImmutableSuite(Sets::copyOfNullable);
        runCopyOfImmutableSuite(Sets::copyOfOrdered);
        runCopyOfImmutableSuite(Sets::copyOfOrderedNullable);
    }

    @Test
    void copyOfNullability() {
        assertThrows(NullPointerException.class, () -> Sets.copyOfOrdered(Lists.ofNullable(1, null, 2)));
        assertDoesNotThrow(() -> Sets.copyOfOrderedNullable(Lists.ofNullable(1, null, 2)));
        assertDoesNotThrow(() -> Sets.copyOfNullable(Lists.ofNullable(1, null, 2)));
    }

}