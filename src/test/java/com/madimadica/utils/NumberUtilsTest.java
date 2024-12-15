package com.madimadica.utils;

import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    void parseByte() {
        assertTrue(NumberUtils.parseByte(null).isEmpty());
        assertTrue(NumberUtils.parseByte("foo").isEmpty());
        assertTrue(NumberUtils.parseByte("1234567").isEmpty());

        Optional<Byte> testVal = NumberUtils.parseByte("123");
        assertTrue(testVal.isPresent());
        assertEquals((byte) 123, testVal.get());
    }

    @Test
    void parseByteRadix() {
        assertTrue(NumberUtils.parseByte(null, 16).isEmpty());
        assertTrue(NumberUtils.parseByte("foo", 16).isEmpty());
        assertTrue(NumberUtils.parseByte("FFF", 16).isEmpty());

        Optional<Byte> testVal = NumberUtils.parseByte("F", 16);
        assertTrue(testVal.isPresent());
        assertEquals((byte) 0xF, testVal.get());
    }

    @Test
    void parseShort() {
        assertTrue(NumberUtils.parseShort(null).isEmpty());
        assertTrue(NumberUtils.parseShort("foo").isEmpty());
        assertTrue(NumberUtils.parseShort("1234567").isEmpty());

        Optional<Short> testVal = NumberUtils.parseShort("123");
        assertTrue(testVal.isPresent());
        assertEquals((short) 123, testVal.get());
    }

    @Test
    void parseShortRadix() {
        assertTrue(NumberUtils.parseShort(null, 16).isEmpty());
        assertTrue(NumberUtils.parseShort("foo", 16).isEmpty());
        assertTrue(NumberUtils.parseShort("FFFFF", 16).isEmpty());

        Optional<Short> testVal = NumberUtils.parseShort("FF", 16);
        assertTrue(testVal.isPresent());
        assertEquals((short) 0xFF, testVal.get());
    }

    @Test
    void parseInt() {
        assertTrue(NumberUtils.parseInt(null).isEmpty());
        assertTrue(NumberUtils.parseInt("foo").isEmpty());
        assertTrue(NumberUtils.parseInt("123456789123456789").isEmpty());

        Optional<Integer> testVal = NumberUtils.parseInt("123456789");
        assertTrue(testVal.isPresent());
        assertEquals(123456789, testVal.get());
    }

    @Test
    void parseIntRadix() {
        assertTrue(NumberUtils.parseInt(null, 16).isEmpty());
        assertTrue(NumberUtils.parseInt("foo", 16).isEmpty());
        assertTrue(NumberUtils.parseInt("FFFFFFFFF", 16).isEmpty());

        Optional<Integer> testVal = NumberUtils.parseInt("FFFF", 16);
        assertTrue(testVal.isPresent());
        assertEquals(0xFFFF, testVal.get());
    }

    @Test
    void parseLong() {
        assertTrue(NumberUtils.parseLong(null).isEmpty());
        assertTrue(NumberUtils.parseLong("foo").isEmpty());
        assertTrue(NumberUtils.parseLong("123456789123456789123456789").isEmpty());

        Optional<Long> testVal = NumberUtils.parseLong("123456789123456789");
        assertTrue(testVal.isPresent());
        assertEquals(123456789123456789L, testVal.get());
    }

    @Test
    void parseLongRadix() {
        assertTrue(NumberUtils.parseLong(null, 16).isEmpty());
        assertTrue(NumberUtils.parseLong("foo", 16).isEmpty());
        assertTrue(NumberUtils.parseLong("FFFFFFFFFFFFFFFFF", 16).isEmpty());

        Optional<Long> testVal = NumberUtils.parseLong("FFFF0000FFFF", 16);
        assertTrue(testVal.isPresent());
        assertEquals(0xFFFF0000FFFFL, testVal.get());
    }

    @Test
    void parseBoolean() {
        assertTrue(NumberUtils.parseBoolean("TRUE").get());
        assertTrue(NumberUtils.parseBoolean("true").get());
        assertTrue(NumberUtils.parseBoolean("TrUE").get());
        assertTrue(NumberUtils.parseBoolean("TruE").get());

        assertFalse(NumberUtils.parseBoolean("false").get());
        assertFalse(NumberUtils.parseBoolean("falSE").get());
        assertFalse(NumberUtils.parseBoolean("FALSE").get());
        assertFalse(NumberUtils.parseBoolean("FaLsE").get());

        assertTrue(NumberUtils.parseBoolean(null).isEmpty());
        assertTrue(NumberUtils.parseBoolean("").isEmpty());
        assertTrue(NumberUtils.parseBoolean("foo").isEmpty());
        assertTrue(NumberUtils.parseBoolean("0").isEmpty());
        assertTrue(NumberUtils.parseBoolean("1").isEmpty());
    }

    @Test
    void parseBit() {
        assertFalse(NumberUtils.parseBit("0").get());
        assertTrue(NumberUtils.parseBit("1").get());

        assertTrue(NumberUtils.parseBit(null).isEmpty());
        assertTrue(NumberUtils.parseBit("false").isEmpty());
        assertTrue(NumberUtils.parseBit("-0").isEmpty());
        assertTrue(NumberUtils.parseBit("true").isEmpty());
        assertTrue(NumberUtils.parseBit("-1").isEmpty());
        assertTrue(NumberUtils.parseBit("").isEmpty());
        assertTrue(NumberUtils.parseBit("foo").isEmpty());
    }

    @Test
    void parseBooleanOrBit() {
        assertTrue(NumberUtils.parseBooleanOrBit("TRUE").get());
        assertTrue(NumberUtils.parseBooleanOrBit("true").get());
        assertTrue(NumberUtils.parseBooleanOrBit("TrUE").get());
        assertTrue(NumberUtils.parseBooleanOrBit("TruE").get());

        assertFalse(NumberUtils.parseBooleanOrBit("false").get());
        assertFalse(NumberUtils.parseBooleanOrBit("falSE").get());
        assertFalse(NumberUtils.parseBooleanOrBit("FALSE").get());
        assertFalse(NumberUtils.parseBooleanOrBit("FaLsE").get());

        assertFalse(NumberUtils.parseBooleanOrBit("0").get());
        assertTrue(NumberUtils.parseBooleanOrBit("1").get());

        assertTrue(NumberUtils.parseBooleanOrBit(null).isEmpty());
        assertTrue(NumberUtils.parseBooleanOrBit("-0").isEmpty());
        assertTrue(NumberUtils.parseBooleanOrBit("-1").isEmpty());
        assertTrue(NumberUtils.parseBooleanOrBit("").isEmpty());
        assertTrue(NumberUtils.parseBooleanOrBit("foo").isEmpty());
    }

    @Test
    void parseFloat() {
        assertTrue(NumberUtils.parseFloat(null).isEmpty());
        assertTrue(NumberUtils.parseFloat("foo").isEmpty());
        assertTrue(NumberUtils.parseFloat("").isEmpty());

        Optional<Float> testVal = NumberUtils.parseFloat("123.45");
        assertTrue(testVal.isPresent());
        assertEquals(123.45f, testVal.get());
    }

    @Test
    void parseDouble() {
        assertTrue(NumberUtils.parseDouble(null).isEmpty());
        assertTrue(NumberUtils.parseDouble("foo").isEmpty());
        assertTrue(NumberUtils.parseDouble("").isEmpty());

        Optional<Double> testVal = NumberUtils.parseDouble("123.45");
        assertTrue(testVal.isPresent());
        assertEquals(123.45, testVal.get());
    }

}
