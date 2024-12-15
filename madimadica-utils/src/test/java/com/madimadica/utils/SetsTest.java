package com.madimadica.utils;

import com.madimadica.utils.internal.model.Animal;
import com.madimadica.utils.internal.model.Cat;
import com.madimadica.utils.internal.model.Dog;
import com.madimadica.utils.internal.model.GitHubRepo;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class SetsTest {

    private void assertImmutable(Collection<?> list) {
        assertThrows(UnsupportedOperationException.class, () -> list.add(null));
    }


    private void assertMutable(Collection<?> list) {
        assertDoesNotThrow(() -> list.add(null));
    }

    private <K> void assertImmutableMap(Map<K, ?> map, K key) {
        assertThrows(UnsupportedOperationException.class, () ->  map.put(key, null));
    }


    private <K> void assertMutableMap(Map<K, ?> map, K key) {
        assertDoesNotThrow(() -> map.put(key, null));
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


    @Test
    void testMap_a() {
        Set<Animal> animals = Set.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C"),
                new Cat(10, "D", 0.5)
        );
        Set<Integer> ages = Sets.map(animals, Animal::getAge);
        assertEquals(Set.of(7, 8, 9, 10), ages);
        assertImmutable(ages);
    }

    @Test
    void testMap_b() {
        Set<Dog> animals = Set.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C")
        );
        Set<Integer> ages = Sets.map(animals, Animal::getAge);
        assertEquals(Set.of(7, 8, 9), ages);
        assertImmutable(ages);
    }

    @Test
    void testMapMutable_a() {
        Set<Animal> animals = Set.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C"),
                new Cat(10, "D", 0.5)
        );
        Set<Integer> ages = Sets.mapMutable(animals, Animal::getAge);
        assertEquals(Set.of(7, 8, 9, 10), ages);
        assertMutable(ages);
    }

    @Test
    void testMapMutable_b() {
        Set<Dog> animals = Set.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C")
        );
        Set<Integer> ages = Sets.mapMutable(animals, Animal::getAge);
        assertEquals(Set.of(7, 8, 9), ages);
        assertMutable(ages);
    }

    @Test
    void testFilter() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> dogs = Set.of(a, b, c);

        Set<Dog> olderThan7 = Sets.filter(dogs, dog -> dog.getAge() > 7);
        assertEquals(Set.of(b, c), olderThan7);
        assertImmutable(olderThan7);
    }

    @Test
    void testFilterMutable() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> dogs = Set.of(a, b, c);

        Set<Dog> olderThan7 = Sets.filterMutable(dogs, dog -> dog.getAge() > 7);
        assertEquals(Set.of(b, c), olderThan7);
        assertMutable(olderThan7);
    }


    @Test
    void testSorted() {
        String a = "A";
        String b = "B";
        String c = "C";
        Set<String> list = Set.of(c, a, b);
        Set<String> sorted = Sets.sorted(list);
        assertEquals(Set.of(a, b, c), sorted);
        assertImmutable(sorted);
    }

    @Test
    void testSortedComparator() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> list = Set.of(c, a, b);
        Set<Dog> sorted = Sets.sorted(list, Comparator.comparingInt(Dog::getAge));
        assertEquals(Set.of(a, b, c), sorted);
        assertImmutable(sorted);
    }

    @Test
    void testSortedMutableComparator() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> list = Set.of(c, a, b);
        Set<Dog> sorted = Sets.sortedMutable(list, Comparator.comparingInt(Dog::getAge));
        assertEquals(Set.of(a, b, c), sorted);
        assertDoesNotThrow(() -> sorted.add(new Dog(12, "F")));
    }

    @Test
    void testMapToList() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(7, "C");
        Set<Dog> dogs = Set.of(a, b, c);
        List<Integer> ages = Sets.mapToList(dogs, Animal::getAge);
        assertEquals(3, ages.size());
        assertTrue(ages.contains(7));
        assertTrue(ages.contains(8));
        assertImmutable(ages);
    }

    @Test
    void testMapToMutableList() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(7, "C");
        Set<Dog> dogs = Set.of(a, b, c);
        List<Integer> ages = Sets.mapToMutableList(dogs, Animal::getAge);
        assertEquals(3, ages.size());
        assertTrue(ages.contains(7));
        assertTrue(ages.contains(8));
        assertMutable(ages);
    }

    @Test
    void testToMapK() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> list = Set.of(a, b, c);
        var ageMap = Sets.toMap(list, Dog::getAge);
        assertEquals(3, ageMap.size());
        assertEquals(a, ageMap.get(7));
        assertEquals(b, ageMap.get(8));
        assertEquals(c, ageMap.get(9));
        assertImmutableMap(ageMap, 10);
    }

    @Test
    void testToMapKV() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> list = Set.of(a, b, c);
        var ageNameMap = Sets.toMap(list, Dog::getAge, Dog::getName);
        assertEquals(3, ageNameMap.size());
        assertEquals("A", ageNameMap.get(7));
        assertEquals("B", ageNameMap.get(8));
        assertEquals("C", ageNameMap.get(9));
        assertImmutableMap(ageNameMap, 10);
    }

    @Test
    void testToMutableMapK() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> list = Set.of(a, b, c);
        var ageMap = Sets.toMutableMap(list, Dog::getAge);
        assertEquals(3, ageMap.size());
        assertEquals(a, ageMap.get(7));
        assertEquals(b, ageMap.get(8));
        assertEquals(c, ageMap.get(9));
        assertMutableMap(ageMap, 10);
    }

    @Test
    void testToMutableMapKV() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        Set<Dog> list = Set.of(a, b, c);
        var ageNameMap = Sets.toMutableMap(list, Dog::getAge, Dog::getName);
        assertEquals(3, ageNameMap.size());
        assertEquals("A", ageNameMap.get(7));
        assertEquals("B", ageNameMap.get(8));
        assertEquals("C", ageNameMap.get(9));
        assertMutableMap(ageNameMap, 10);
    }

    @Test
    void testOfIterable() {
        assertThrows(NullPointerException.class, () -> Sets.ofIterable(Lists.ofNullable(1, null, 2)));
        var set = Sets.ofIterable(Set.of(1, 2, 3));
        assertEquals(Set.of(1, 2, 3), set);
        assertImmutable(set);
    }

    @Test
    void testOfIterableNullable() {
        var set = Sets.ofIterableNullable(Lists.ofNullable(1, null, 2));
        assertEquals(Sets.ofNullable(1, null, 2), set);
        assertImmutable(set);
    }

    @Test
    void testOfIterableMutable() {
        var set = Sets.ofIterableMutable(Lists.ofNullable(1, null, 2));
        assertEquals(Sets.ofNullable(1, null, 2), set);
        assertMutable(set);
    }

    @Test
    void testGroupBy() {
        GitHubRepo repo1 = new GitHubRepo(1, 1, "foo");
        GitHubRepo repo2 = new GitHubRepo(2, 1, "bar");
        GitHubRepo repo3 = new GitHubRepo(3, 1, "baz");
        GitHubRepo repo4 = new GitHubRepo(4, 2, "fizz");
        GitHubRepo repo5 = new GitHubRepo(5, 2, "buzz");
        Set<GitHubRepo> allRepos = Set.of(repo1, repo2, repo3, repo4, repo5);
        Map<Long, Set<GitHubRepo>> orgRepos = Sets.groupBy(allRepos, GitHubRepo::getOrgId);
        assertEquals(2, orgRepos.size());
        var org1 = orgRepos.get(1L);
        var org2 = orgRepos.get(2L);
        assertEquals(Set.of(repo1, repo2, repo3), org1);
        assertEquals(Set.of(repo4, repo5), org2);
        assertMutableMap(orgRepos, 5L);
        assertMutable(org1);
    }

    @Test
    void testGroupBy_nullMapping() {
        GitHubRepo repo1 = new GitHubRepo(1, 1, "foo");
        GitHubRepo repo2 = new GitHubRepo(2, 1, "foo");
        GitHubRepo repo3 = new GitHubRepo(3, 1, "foo");
        GitHubRepo repo4 = new GitHubRepo(4, 2, null);
        GitHubRepo repo5 = new GitHubRepo(5, 2, null);
        Set<GitHubRepo> allRepos = Set.of(repo1, repo2, repo3, repo4, repo5);
        Map<String, Set<GitHubRepo>> orgRepos = Sets.groupBy(allRepos, GitHubRepo::getName);
        assertEquals(2, orgRepos.size());
        var org1 = orgRepos.get("foo");
        var org2 = orgRepos.get(null);
        assertEquals(Set.of(repo1, repo2, repo3), org1);
        assertEquals(Set.of(repo4, repo5), org2);
        assertMutableMap(orgRepos, "asdf");
        assertMutable(org1);
    }

    @Test
    void testGroupByAndMap() {
        GitHubRepo repo1 = new GitHubRepo(1, 1, "foo");
        GitHubRepo repo2 = new GitHubRepo(2, 1, "bar");
        GitHubRepo repo3 = new GitHubRepo(3, 1, "baz");
        GitHubRepo repo4 = new GitHubRepo(4, 2, "fizz");
        GitHubRepo repo5 = new GitHubRepo(5, 2, "buzz");
        Set<GitHubRepo> allRepos = Set.of(repo1, repo2, repo3, repo4, repo5);
        Map<Long, Set<String>> orgRepoNames = Sets.groupByAndMap(allRepos, GitHubRepo::getOrgId, GitHubRepo::getName);
        assertEquals(2, orgRepoNames.size());
        var org1 = orgRepoNames.get(1L);
        var org2 = orgRepoNames.get(2L);
        assertEquals(Set.of("foo", "bar", "baz"), org1);
        assertEquals(Set.of("fizz", "buzz"), org2);
        assertMutableMap(orgRepoNames, 5L);
        assertMutable(org1);
    }

    @Test
    void testGroupByAndMap_nullMapping() {
        GitHubRepo repo1 = new GitHubRepo(1, 1, "foo");
        GitHubRepo repo2 = new GitHubRepo(2, 1, "foo");
        GitHubRepo repo3 = new GitHubRepo(3, 1, "foo");
        GitHubRepo repo4 = new GitHubRepo(4, 2, null);
        GitHubRepo repo5 = new GitHubRepo(5, 2, null);
        Set<GitHubRepo> allRepos = Set.of(repo1, repo2, repo3, repo4, repo5);
        Map<String, Set<Long>> repoNamesToIds = Sets.groupByAndMap(allRepos, GitHubRepo::getName, GitHubRepo::getRepoId);
        assertEquals(2, repoNamesToIds.size());
        var fooIds = repoNamesToIds.get("foo");
        var nullIds = repoNamesToIds.get(null);
        assertEquals(Set.of(1L, 2L, 3L), fooIds);
        assertEquals(Set.of(4L, 5L), nullIds);
        assertMutableMap(repoNamesToIds, "asdf");
        assertMutable(fooIds);
    }


    @Test
    void testUnion() {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);
        Set<Integer> expected = Set.of(1, 2, 3, 4, 5);

        Set<Integer> result = Sets.union(set1, set2);
        assertEquals(expected, result, "Union should contain all elements from both sets");
    }

    @Test
    void testIntersection() {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);
        Set<Integer> expected = Set.of(3);

        Set<Integer> result = Sets.intersection(set1, set2);
        assertEquals(expected, result, "Intersection should contain only common elements");
    }

    @Test
    void testDifference() {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);
        Set<Integer> expected = Set.of(1, 2);

        Set<Integer> result = Sets.difference(set1, set2);
        assertEquals(expected, result, "Difference should contain elements in set1 but not in set2");
    }

    @Test
    void testSymmetricDifference() {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);
        Set<Integer> expected = Set.of(1, 2, 4, 5);

        Set<Integer> result = Sets.symmetricDifference(set1, set2);
        assertEquals(expected, result, "Symmetric difference should contain elements in either set but not both");
    }

    @Test
    void testEmptySets() {
        Set<Integer> set1 = Set.of();
        Set<Integer> set2 = Set.of();

        assertEquals(Set.of(), Sets.union(set1, set2), "Union of two empty sets should be empty");
        assertEquals(Set.of(), Sets.intersection(set1, set2), "Intersection of two empty sets should be empty");
        assertEquals(Set.of(), Sets.difference(set1, set2), "Difference of two empty sets should be empty");
        assertEquals(Set.of(), Sets.symmetricDifference(set1, set2), "Symmetric difference of two empty sets should be empty");
    }

    @Test
    void testSubset() {
        Set<Integer> set1 = Set.of(1, 2);
        Set<Integer> set2 = Set.of(1, 2, 3);

        assertEquals(set2, Sets.union(set1, set2), "Union should contain all elements from the superset");
        assertEquals(set1, Sets.intersection(set1, set2), "Intersection should contain all elements from the subset");
        assertEquals(Set.of(3), Sets.difference(set2, set1), "Difference should contain elements in superset but not in subset");
        assertEquals(Set.of(3), Sets.symmetricDifference(set1, set2), "Symmetric difference should contain elements in one set but not both");
    }

    @Test
    void testDisjointSets() {
        Set<Integer> set1 = Set.of(1, 2);
        Set<Integer> set2 = Set.of(3, 4);

        assertEquals(Set.of(1, 2, 3, 4), Sets.union(set1, set2), "Union should contain all elements from disjoint sets");
        assertEquals(Set.of(), Sets.intersection(set1, set2), "Intersection of disjoint sets should be empty");
        assertEquals(set1, Sets.difference(set1, set2), "Difference should contain all elements of set1");
        assertEquals(Set.of(1, 2, 3, 4), Sets.symmetricDifference(set1, set2), "Symmetric difference should contain all elements from disjoint sets");
    }

}