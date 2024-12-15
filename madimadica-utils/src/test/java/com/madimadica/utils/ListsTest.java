package com.madimadica.utils;

import com.madimadica.utils.internal.model.Animal;
import com.madimadica.utils.internal.model.Cat;
import com.madimadica.utils.internal.model.Dog;
import com.madimadica.utils.internal.model.GitHubRepo;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {

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
    void ofNullableNoArgs() {
        List<Integer> list = Lists.ofNullable();
        assertTrue(list.isEmpty());
        assertImmutable(list);
    }

    @Test
    void ofNullableNullArg() {
        assertThrows(NullPointerException.class, () -> Lists.ofNullable(null));
    }

    @Test
    void ofNullableNullCast() {
        var list = Lists.ofNullable((Integer) null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
        assertImmutable(list);
    }

    @Test
    void ofNullableNonNullSingleton() {
        var list = Lists.ofNullable(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
        assertImmutable(list);
    }

    @Test
    void ofNullableSize2() {
        var list = Lists.ofNullable(5, null);
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));
        assertNull(list.get(1));
        assertImmutable(list);

        list = Lists.ofNullable(null, 5);
        assertEquals(2, list.size());
        assertNull(list.get(0));
        assertEquals(5, list.get(1));
        assertImmutable(list);
    }

    @Test
    void ofMutableNoArgs() {
        List<Integer> list = Lists.ofMutable();
        assertTrue(list.isEmpty());
        assertMutable(list);
    }

    @Test
    void ofMutableNullArg() {
        assertThrows(NullPointerException.class, () -> Lists.ofMutable(null));
    }

    @Test
    void ofMutableNullCast() {
        var list = Lists.ofMutable((Integer) null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
        assertMutable(list);
    }

    @Test
    void ofMutableNonNullSingleton() {
        var list = Lists.ofMutable(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
        assertMutable(list);
    }

    @Test
    void ofMutableSize2() {
        var list = Lists.ofMutable(5, null);
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));
        assertNull(list.get(1));
        assertMutable(list);

        list = Lists.ofMutable(null, 5);
        assertEquals(2, list.size());
        assertNull(list.get(0));
        assertEquals(5, list.get(1));
        assertMutable(list);
    }

    @Test
    void copyOfNullableNullArg() {
        assertThrows(NullPointerException.class, () -> Lists.copyOfNullable(null));
    }

    @Test
    void copyOfNullableNullValues() {
        List<Integer> original = Lists.ofNullable(1, null, 3);
        List<Integer> copy = Lists.copyOfNullable(original);
        assertNotSame(original, copy);
        assertEquals(original, copy);
        assertImmutable(copy);
    }

    @Test
    void testMap_a() {
        List<Animal> animals = List.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C"),
                new Cat(10, "D", 0.5)
        );
        List<Integer> ages = Lists.map(animals, Animal::getAge);
        assertEquals(List.of(7, 8, 9, 10), ages);
        assertImmutable(ages);
    }

    @Test
    void testMap_b() {
        List<Dog> animals = List.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C")
        );
        List<Integer> ages = Lists.map(animals, Animal::getAge);
        assertEquals(List.of(7, 8, 9), ages);
        assertImmutable(ages);
    }

    @Test
    void testMapMutable_a() {
        List<Animal> animals = List.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C"),
                new Cat(10, "D", 0.5)
        );
        List<Integer> ages = Lists.mapMutable(animals, Animal::getAge);
        assertEquals(List.of(7, 8, 9, 10), ages);
        assertMutable(ages);
    }

    @Test
    void testMapMutable_b() {
        List<Dog> animals = List.of(
                new Dog(7, "A"),
                new Dog(8, "B"),
                new Dog(9, "C")
        );
        List<Integer> ages = Lists.mapMutable(animals, Animal::getAge);
        assertEquals(List.of(7, 8, 9), ages);
        assertMutable(ages);
    }

    @Test
    void testFilter() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> dogs = List.of(a, b, c);

        List<Dog> olderThan7 = Lists.filter(dogs, dog -> dog.getAge() > 7);
        assertEquals(List.of(b, c), olderThan7);
        assertImmutable(olderThan7);
    }

    @Test
    void testFilterMutable() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> dogs = List.of(a, b, c);

        List<Dog> olderThan7 = Lists.filterMutable(dogs, dog -> dog.getAge() > 7);
        assertEquals(List.of(b, c), olderThan7);
        assertMutable(olderThan7);
    }

    @Test
    void testSorted() {
        String a = "A";
        String b = "B";
        String c = "C";
        List<String> list = List.of(c, a, b);
        List<String> sorted = Lists.sorted(list);
        assertEquals(List.of(a, b, c), sorted);
        assertImmutable(sorted);
    }

    @Test
    void testSortedMutable() {
        String a = "A";
        String b = "B";
        String c = "C";
        List<String> list = List.of(c, a, b);
        List<String> sorted = Lists.sortedMutable(list);
        assertEquals(List.of(a, b, c), sorted);
        assertMutable(sorted);
    }

    @Test
    void testSortedComparator() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> list = List.of(c, a, b);
        List<Dog> sorted = Lists.sorted(list, Comparator.comparingInt(Dog::getAge));
        assertEquals(List.of(a, b, c), sorted);
        assertImmutable(sorted);
    }

    @Test
    void testSortedMutableComparator() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> list = List.of(c, a, b);
        List<Dog> sorted = Lists.sortedMutable(list, Comparator.comparingInt(Dog::getAge));
        assertEquals(List.of(a, b, c), sorted);
        assertMutable(sorted);
    }

    @Test
    void testReversed() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> list = List.of(a, b, c);
        List<Dog> reversed = Lists.reversed(list);
        assertEquals(List.of(c, b, a), reversed);
        assertImmutable(reversed);
    }

    @Test
    void testReversedMutable() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> list = List.of(a, b, c);
        List<Dog> reversed = Lists.reversedMutable(list);
        assertEquals(List.of(c, b, a), reversed);
        assertMutable(reversed);
    }

    @Test
    void testMapToSet() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(7, "C");
        List<Dog> dogs = List.of(a, b, c);
        Set<Integer> ages = Lists.mapToSet(dogs, Animal::getAge);
        assertEquals(2, ages.size());
        assertEquals(Set.of(7, 8), ages);
        assertImmutable(ages);
    }

    @Test
    void testMapToMutableSet() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(7, "C");
        List<Dog> dogs = List.of(a, b, c);
        Set<Integer> ages = Lists.mapToMutableSet(dogs, Animal::getAge);
        assertEquals(2, ages.size());
        assertEquals(Set.of(7, 8), ages);
        assertMutable(ages);
    }

    @Test
    void testToMapK() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        List<Dog> list = List.of(a, b, c);
        var ageMap = Lists.toMap(list, Dog::getAge);
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
        List<Dog> list = List.of(a, b, c);
        var ageNameMap = Lists.toMap(list, Dog::getAge, Dog::getName);
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
        List<Dog> list = List.of(a, b, c);
        var ageMap = Lists.toMutableMap(list, Dog::getAge);
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
        List<Dog> list = List.of(a, b, c);
        var ageNameMap = Lists.toMutableMap(list, Dog::getAge, Dog::getName);
        assertEquals(3, ageNameMap.size());
        assertEquals("A", ageNameMap.get(7));
        assertEquals("B", ageNameMap.get(8));
        assertEquals("C", ageNameMap.get(9));
        assertMutableMap(ageNameMap, 10);
    }


    @Test
    void testPartitionInto_EqualMany() {
        List<Integer> data = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        var partitions = Lists.partitionInto(data, 4);
        assertEquals(4, partitions.size());
        for (var partition : partitions) {
            assertEquals(25, partition.size());
            assertImmutable(partition);
        }
        assertImmutable(partitions);
    }

    @Test
    void testPartitionInto_AllOne() {
        List<Integer> data = IntStream.range(0, 25).boxed().collect(Collectors.toList());
        var partitions = Lists.partitionInto(data, 25);
        assertEquals(25, partitions.size());
        for (var partition : partitions) {
            assertEquals(1, partition.size());
            assertImmutable(partition);
        }
        assertImmutable(partitions);
    }

    @Test
    void testPartitionInto_SomeEmpty() {
        List<Integer> data = IntStream.range(0, 3).boxed().collect(Collectors.toList());
        var partitions = Lists.partitionInto(data, 5);
        assertEquals(5, partitions.size());
        assertImmutable(partitions);
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);
        var p3 = partitions.get(2);
        var p4 = partitions.get(3);
        var p5 = partitions.get(4);
        assertEquals(1, p1.size());
        assertEquals(0, p1.get(0));
        assertEquals(1, p2.size());
        assertEquals(1, p2.get(0));
        assertEquals(1, p3.size());
        assertEquals(2, p3.get(0));
        assertTrue(p4.isEmpty());
        assertTrue(p5.isEmpty());
        for (var partition : partitions) {
            assertImmutable(partition);
        }
    }

    @Test
    void testPartitionInto_AllEmpty() {
        List<Integer> empty = List.of();
        var empty1 = Lists.partitionInto(empty, 1);
        var empty2 = Lists.partitionInto(empty, 2);
        var empty3 = Lists.partitionInto(empty, 3);
        assertEquals(1, empty1.size());
        assertEquals(2, empty2.size());
        assertEquals(3, empty3.size());
        for (var wrapper : List.of(empty1, empty2, empty3)) {
            for (var partition : wrapper) {
                assertTrue(partition.isEmpty());
                assertImmutable(partition);
            }
            assertImmutable(wrapper);
        }
    }

    @Test
    void testPartitionInto_NonEqualMany() {
        List<Integer> data = IntStream.range(0, 98).boxed().collect(Collectors.toList());
        var partitions = Lists.partitionInto(data, 4);
        assertImmutable(partitions);
        for (var partition : partitions) {
            assertImmutable(partition);
        }
        assertEquals(4, partitions.size());
        assertEquals(25, partitions.get(0).size());
        assertEquals(25, partitions.get(1).size());
        assertEquals(25, partitions.get(2).size());
        assertEquals(23, partitions.get(3).size());
    }

    @Test
    void testPartitionInto_3x500() {
        var partitions = Lists.partitionInto(List.of(1, 2, 3), 500);
        assertEquals(500, partitions.size());
        for (int i = 0; i < 3; ++i) {
            assertEquals(List.of(i + 1), partitions.get(i));
        }
        for (int i = 3; i < 500; ++i) {
            assertEquals(List.of(), partitions.get(i));
        }
    }

    @Test
    void testPartitionBySize_3x500() {
        var partitions = Lists.partitionBySize(List.of(1, 2, 3), 500);
        assertEquals(1, partitions.size());
        assertEquals(List.of(1, 2, 3), partitions.get(0));
    }

    @Test
    void testPartitionBySize_empty() {
        for (int i = 1; i < 25; ++i) {
            var result = Lists.partitionBySize(List.of(), 1);
            assertEquals(1, result.size());
            assertTrue(result.get(0).isEmpty());
            assertImmutable(result);
            assertImmutable(result.get(0));
        }
    }

    @Test
    void testPartitionBySize_single() {
        for (int i = 1; i < 25; ++i) {
            for (int j = 1; j < 25; ++j) {
                var result = Lists.partitionBySize(List.of(55), j);
                assertEquals(1, result.size());
                var partition = result.get(0);
                assertEquals(List.of(55), partition);
                assertImmutable(result);
                assertImmutable(partition);
            }
        }
    }

    @Test
    void testPartitionBySize_2x1() {
        var partitions = Lists.partitionBySize(List.of(1, 2), 1);
        assertEquals(2, partitions.size());
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);

        assertEquals(List.of(1), p1);
        assertEquals(List.of(2), p2);

        assertImmutable(partitions);
        assertImmutable(p1);
        assertImmutable(p2);
    }

    @Test
    void testPartitionBySize_2x2() {
        var partitions = Lists.partitionBySize(List.of(1, 2), 2);
        assertEquals(1, partitions.size());
        var p1 = partitions.get(0);
        assertEquals(List.of(1, 2), p1);

        assertImmutable(partitions);
        assertImmutable(p1);
    }

    @Test
    void testPartitionBySize_3x2() {
        var partitions = Lists.partitionBySize(List.of(1, 2, 3), 2);
        assertEquals(2, partitions.size());
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);

        assertEquals(List.of(1, 2), p1);
        assertEquals(List.of(3), p2);

        assertImmutable(partitions);
        assertImmutable(p1);
        assertImmutable(p2);
    }

    @Test
    void testPartitionBySize_4x2() {
        var partitions = Lists.partitionBySize(List.of(1, 2, 3, 4), 2);
        assertEquals(2, partitions.size());
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);

        assertEquals(List.of(1, 2), p1);
        assertEquals(List.of(3, 4), p2);

        assertImmutable(partitions);
        assertImmutable(p1);
        assertImmutable(p2);
    }

    @Test
    void testPartitionBySize_5x2() {
        var partitions = Lists.partitionBySize(List.of(1, 2, 3, 4, 5), 2);
        assertEquals(3, partitions.size());
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);
        var p3 = partitions.get(2);

        assertEquals(List.of(1, 2), p1);
        assertEquals(List.of(3, 4), p2);
        assertEquals(List.of(5), p3);

        assertImmutable(partitions);
        assertImmutable(p1);
        assertImmutable(p2);
        assertImmutable(p3);
    }

    @Test
    void testPartitionBySize_5x3() {
        var partitions = Lists.partitionBySize(List.of(1, 2, 3, 4, 5), 3);
        assertEquals(2, partitions.size());
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);

        assertEquals(List.of(1, 2, 3), p1);
        assertEquals(List.of(4, 5), p2);

        assertImmutable(partitions);
        assertImmutable(p1);
        assertImmutable(p2);
    }

    @Test
    void testPartitionBySize_10x3() {
        var partitions = Lists.partitionBySize(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        assertEquals(4, partitions.size());
        var p1 = partitions.get(0);
        var p2 = partitions.get(1);
        var p3 = partitions.get(2);
        var p4 = partitions.get(3);

        assertEquals(List.of(1, 2, 3), p1);
        assertEquals(List.of(4, 5, 6), p2);
        assertEquals(List.of(7, 8, 9), p3);
        assertEquals(List.of(10), p4);

        assertImmutable(partitions);
        assertImmutable(p1);
        assertImmutable(p2);
        assertImmutable(p3);
        assertImmutable(p4);
    }

    @Test
    void testPartitionClamp_10x6x5() {
        var partitions = Lists.partitionClamp(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 6, 5);
        assertEquals(2, partitions.size());
        assertEquals(List.of(1, 2, 3, 4, 5), partitions.get(0));
        assertEquals(List.of(6, 7, 8, 9, 10), partitions.get(1));
    }

    @Test
    void testPartitionClamp_10x2x4() {
        var partitions = Lists.partitionClamp(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2, 4);
        assertEquals(2, partitions.size());
        assertEquals(List.of(1, 2, 3, 4, 5), partitions.get(0));
        assertEquals(List.of(6, 7, 8, 9, 10), partitions.get(1));
    }

    @Test
    void testPartitionClamp_10x2x100() {
        var partitions = Lists.partitionClamp(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2, 100);
        assertEquals(1, partitions.size());
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), partitions.get(0));
    }

    @Test
    void testPartitionClamp_10x100x2() {
        var partitions = Lists.partitionClamp(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 100, 2);
        assertEquals(5, partitions.size());
        assertEquals(List.of(1, 2), partitions.get(0));
        assertEquals(List.of(3, 4), partitions.get(1));
        assertEquals(List.of(5, 6), partitions.get(2));
        assertEquals(List.of(7, 8), partitions.get(3));
        assertEquals(List.of(9, 10), partitions.get(4));
    }

    @Test
    void testFlatMap() {
        var result = Lists.flatMap(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), result);
        assertImmutable(result);
    }

    @Test
    void testFlatMap_noArgs() {
        var result = Lists.flatMap();
        assertEquals(List.of(), result);
        assertImmutable(result);
    }

    @Test
    void testFlatMap_withNullElements() {
        assertThrows(NullPointerException.class, () -> Lists.flatMap(List.of(1, 2, 3), Lists.ofNullable(4, null, 6), List.of(7, 8, 9)));
        assertThrows(NullPointerException.class, () -> Lists.flatMap(List.of(1, 2, 3), null, List.of(7, 8, 9)));
        assertThrows(NullPointerException.class, () -> Lists.flatMap(null));
    }

    @Test
    void testOfIterable() {
        assertThrows(NullPointerException.class, () -> Lists.ofIterable(Lists.ofNullable(1, null, 2)));
        var list = Lists.ofIterable(List.of(1, 2, 3));
        assertEquals(List.of(1, 2, 3), list);
        assertImmutable(list);
    }

    @Test
    void testOfIterableNullable() {
        var list = Lists.ofIterableNullable(Lists.ofNullable(1, null, 2));
        assertEquals(Lists.ofNullable(1, null, 2), list);
        assertImmutable(list);
    }

    @Test
    void testOfIterableMutable() {
        var list = Lists.ofIterableMutable(Lists.ofNullable(1, null, 2));
        assertEquals(Lists.ofNullable(1, null, 2), list);
        assertMutable(list);
    }

    @Test
    void testSortCaseInsensitive() {
        Dog a = new Dog(7, "A");
        Dog b = new Dog(8, "B");
        Dog c = new Dog(9, "C");
        var dogs = Lists.ofMutable(b, c, a);
        Lists.sortCaseInsensitive(dogs, Dog::getName);
        assertEquals(List.of(a, b, c), dogs);
    }

    @Test
    void testFlatten() {
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"hello", "world"};
        double[][] double2D = {{1.0, 1.1}, {2.0, 2.1}};
        var result = Lists.flatten(ints, strings, "hi", double2D);
        assertEquals(
                List.of(1, 2, 3, 4, 5, "hello", "world", "hi", 1.0, 1.1, 2.0, 2.1),
                result
        );
        assertMutable(result);
    }

    @Test
    void testFlattenWithNull() {
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"hello", null};
        double[][] double2D = {{1.0, 1.1}, {2.0, 2.1}};
        var result = Lists.flatten(ints, strings, "hi", double2D, null);
        assertEquals(
                Lists.ofNullable(1, 2, 3, 4, 5, "hello", null, "hi", 1.0, 1.1, 2.0, 2.1, null),
                result
        );
        assertMutable(result);
    }

    @Test
    void testGroupBy() {
        GitHubRepo repo1 = new GitHubRepo(1, 1, "foo");
        GitHubRepo repo2 = new GitHubRepo(2, 1, "bar");
        GitHubRepo repo3 = new GitHubRepo(3, 1, "baz");
        GitHubRepo repo4 = new GitHubRepo(4, 2, "fizz");
        GitHubRepo repo5 = new GitHubRepo(5, 2, "buzz");
        List<GitHubRepo> allRepos = List.of(repo1, repo2, repo3, repo4, repo5);
        Map<Long, List<GitHubRepo>> orgRepos = Lists.groupBy(allRepos, GitHubRepo::getOrgId);
        assertEquals(2, orgRepos.size());
        var org1 = orgRepos.get(1L);
        var org2 = orgRepos.get(2L);
        assertEquals(List.of(repo1, repo2, repo3), org1);
        assertEquals(List.of(repo4, repo5), org2);
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
        List<GitHubRepo> allRepos = List.of(repo1, repo2, repo3, repo4, repo5);
        Map<String, List<GitHubRepo>> orgRepos = Lists.groupBy(allRepos, GitHubRepo::getName);
        assertEquals(2, orgRepos.size());
        var org1 = orgRepos.get("foo");
        var org2 = orgRepos.get(null);
        assertEquals(List.of(repo1, repo2, repo3), org1);
        assertEquals(List.of(repo4, repo5), org2);
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
        List<GitHubRepo> allRepos = List.of(repo1, repo2, repo3, repo4, repo5);
        Map<Long, List<String>> orgRepoNames = Lists.groupByAndMap(allRepos, GitHubRepo::getOrgId, GitHubRepo::getName);
        assertEquals(2, orgRepoNames.size());
        var org1 = orgRepoNames.get(1L);
        var org2 = orgRepoNames.get(2L);
        assertEquals(List.of("foo", "bar", "baz"), org1);
        assertEquals(List.of("fizz", "buzz"), org2);
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
        List<GitHubRepo> allRepos = List.of(repo1, repo2, repo3, repo4, repo5);
        Map<String, List<Long>> repoNamesToIds = Lists.groupByAndMap(allRepos, GitHubRepo::getName, GitHubRepo::getRepoId);
        assertEquals(2, repoNamesToIds.size());
        var fooIds = repoNamesToIds.get("foo");
        var nullIds = repoNamesToIds.get(null);
        assertEquals(List.of(1L, 2L, 3L), fooIds);
        assertEquals(List.of(4L, 5L), nullIds);
        assertMutableMap(repoNamesToIds, "asdf");
        assertMutable(fooIds);
    }
}