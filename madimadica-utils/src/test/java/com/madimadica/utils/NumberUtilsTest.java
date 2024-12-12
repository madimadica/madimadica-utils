package com.madimadica.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    /**
     * Test all possible <code>int</code> arguments
     * for {@link NumberUtils#length(int)}.
     */
    @Test
    void testLength32All() {
        for (int i = Integer.MIN_VALUE + 1; i < Integer.MAX_VALUE; ++i) {
            assertEquals(String.valueOf(i).length(), NumberUtils.length(i));
        }
        assertEquals(String.valueOf(Integer.MIN_VALUE).length(), NumberUtils.length(Integer.MIN_VALUE));
        assertEquals(String.valueOf(Integer.MAX_VALUE).length(), NumberUtils.length(Integer.MAX_VALUE));
    }

    /**
     * Test a few values around each order of magnitude
     * for {@link NumberUtils#length(int)}.
     */
    @Test
    void testLength32Some() {
        for (int i = 1; i > 0; i *= 10) {
            for (int offset = -10; offset < 10; ++offset) {
                assertEquals(String.valueOf(i + offset).length(), NumberUtils.length(i + offset));
                assertEquals(String.valueOf(-i + offset).length(), NumberUtils.length(-i + offset));
            }
        }
        assertEquals(String.valueOf(Integer.MIN_VALUE).length(), NumberUtils.length(Integer.MIN_VALUE));
        assertEquals(String.valueOf(Integer.MAX_VALUE).length(), NumberUtils.length(Integer.MAX_VALUE));
    }

    /**
     * Test a few values around each order of magnitude
     * for {@link NumberUtils#length(long)}.
     */
    @Test
    void testLength64Some() {
        // Cannot test every number without waiting forever (~3 billion minutes)
        // So just check that powers of 10 and surrounding numbers work
        for (long i = 1; i > 0; i *= 10) {
            for (int offset = -10; offset < 10; ++offset) {
                assertEquals(String.valueOf(i + offset).length(), NumberUtils.length(i + offset));
                assertEquals(String.valueOf(-i + offset).length(), NumberUtils.length(-i + offset));
            }
        }
        assertEquals(String.valueOf(Long.MIN_VALUE).length(), NumberUtils.length(Long.MIN_VALUE));
        assertEquals(String.valueOf(Long.MAX_VALUE).length(), NumberUtils.length(Long.MAX_VALUE));
    }

    /**
     * Test various positive values for concatenating 32-bit inputs
     */
    @Test
    void testConcat32() {
        assertEquals(0, NumberUtils.concat(0, 0));
        assertEquals(1, NumberUtils.concat(0, 1));
        assertEquals(10, NumberUtils.concat(1, 0));
        assertEquals(100, NumberUtils.concat(10, 0));
        assertEquals(1010, NumberUtils.concat(10, 10));
        assertEquals(1234, NumberUtils.concat(123, 4));
        assertEquals(123456, NumberUtils.concat(123, 456));
        assertEquals(123_456_789_987_654_321L, NumberUtils.concat(123_456_789, 987_654_321));
    }

    /**
     * Test various positive values for concatenating 64-bit inputs
     */
    @Test
    void testConcat64() {
        assertEquals(0, NumberUtils.concat(0L, 0L));
        assertEquals(1, NumberUtils.concat(0L, 1L));
        assertEquals(10, NumberUtils.concat(1L, 0L));
        assertEquals(100, NumberUtils.concat(10L, 0L));
        assertEquals(1010, NumberUtils.concat(10L, 10L));
        assertEquals(1234, NumberUtils.concat(123L, 4L));
        assertEquals(123456, NumberUtils.concat(123L, 456L));
        assertEquals(123_456_789_987_654_321L, NumberUtils.concat(123_456_789L, 987_654_321L));
    }

}
