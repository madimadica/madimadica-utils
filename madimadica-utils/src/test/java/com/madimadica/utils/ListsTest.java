package com.madimadica.utils;

import com.madimadica.utils.internal.model.Animal;
import com.madimadica.utils.internal.model.Cat;
import com.madimadica.utils.internal.model.Dog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {

    private void assertImmutable(List<Integer> list) {
        assertThrows(UnsupportedOperationException.class, () -> list.add(0));
    }

    private void assertMutable(List<Integer> list) {
        assertDoesNotThrow(() -> list.add(0));
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
}