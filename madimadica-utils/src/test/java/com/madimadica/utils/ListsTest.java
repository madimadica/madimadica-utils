package com.madimadica.utils;

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
}