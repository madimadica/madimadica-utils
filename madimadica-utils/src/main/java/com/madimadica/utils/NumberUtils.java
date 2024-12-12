package com.madimadica.utils;


/**
 * Utilities for fast operations on primitive number types.
 */
public abstract class NumberUtils {

    /**
     * Constructor to allow extension.
     */
    public NumberUtils() {}

    /**
     * <p>
     * Computes the length of the base 10
     * {@link String} representation for a 32-bit {@code int}.
     * </p>
     * <p>
     * A negative sign contributes 1 additional length to the result.
     * Thus, <code>length(-10) == 3</code>.
     * </p>
     * @param x number to compute the length of.
     * @return length of the number.
     */
    public static int length(int x) {
        if (x < 0) {
            if (x > -10) {
                return 2;
            } else if (x > -100) {
                return 3;
            } else if (x > -1_000) {
                return 4;
            } else if (x > -10_000) {
                return 5;
            } else if (x > -100_000) {
                return 6;
            } else if (x > -1_000_000) {
                return 7;
            } else if (x > -10_000_000) {
                return 8;
            } else if (x > -100_000_000) {
                return 9;
            } else if (x > -1_000_000_000) {
                return 10;
            } else {
                return 11;
            }
        } else {
            if (x < 10) {
                return 1;
            } else if (x < 100) {
                return 2;
            } else if (x < 1_000) {
                return 3;
            } else if (x < 10_000) {
                return 4;
            } else if (x < 100_000) {
                return 5;
            } else if (x < 1_000_000) {
                return 6;
            } else if (x < 10_000_000) {
                return 7;
            } else if (x < 100_000_000) {
                return 8;
            } else if (x < 1_000_000_000) {
                return 9;
            } else {
                return 10;
            }
        }
    }

    /**
     * <p>
     * Computes the length of the base 10
     * {@link String} representation for a 64-bit {@code long}.
     * </p>
     * <p>
     * A negative sign contributes 1 additional length to the result.
     * Thus, <code>length(-10) == 3</code>.
     * </p>
     * @param x number to compute the length of.
     * @return length of the number.
     */
    public static int length(long x) {
        if (x < 0L) {
            if (x > -10L) {
                return 2;
            } else if (x > -100L) {
                return 3;
            } else if (x > -1_000L) {
                return 4;
            } else if (x > -10_000L) {
                return 5;
            } else if (x > -100_000L) {
                return 6;
            } else if (x > -1_000_000L) {
                return 7;
            } else if (x > -10_000_000L) {
                return 8;
            } else if (x > -100_000_000L) {
                return 9;
            } else if (x > -1_000_000_000L) {
                return 10;
            } else if (x > -10_000_000_000L) {
                return 11;
            } else if (x > -100_000_000_000L) {
                return 12;
            } else if (x > -1_000_000_000_000L) {
                return 13;
            } else if (x > -10_000_000_000_000L) {
                return 14;
            } else if (x > -100_000_000_000_000L) {
                return 15;
            } else if (x > -1_000_000_000_000_000L) {
                return 16;
            } else if (x > -10_000_000_000_000_000L) {
                return 17;
            } else if (x > -100_000_000_000_000_000L) {
                return 18;
            } else if (x > -1_000_000_000_000_000_000L) {
                return 19;
            } else {
                return 20;
            }
        } else {
            if (x < 10L) {
                return 1;
            } else if (x < 100L) {
                return 2;
            } else if (x < 1_000L) {
                return 3;
            } else if (x < 10_000L) {
                return 4;
            } else if (x < 100_000L) {
                return 5;
            } else if (x < 1_000_000L) {
                return 6;
            } else if (x < 10_000_000L) {
                return 7;
            } else if (x < 100_000_000L) {
                return 8;
            } else if (x < 1_000_000_000L) {
                return 9;
            } else if (x < 10_000_000_000L) {
                return 10;
            } else if (x < 100_000_000_000L) {
                return 11;
            } else if (x < 1_000_000_000_000L) {
                return 12;
            } else if (x < 10_000_000_000_000L) {
                return 13;
            } else if (x < 100_000_000_000_000L) {
                return 14;
            } else if (x < 1_000_000_000_000_000L) {
                return 15;
            } else if (x < 10_000_000_000_000_000L) {
                return 16;
            } else if (x < 100_000_000_000_000_000L) {
                return 17;
            } else if (x < 1_000_000_000_000_000_000L) {
                return 18;
            } else {
                return 19;
            }
        }
    }

    /**
     * <p>
     * Concatenate two positive 32-bit integers
     * into a single 64-bit long, as if they were strings.
     * </p>
     * <p>
     * For example <code>concat(12, 34) == 1234L</code>
     * </p>
     * <p>
     * Attempting to concatenate any negative numbers, or a concatenation
     * exceeding the 64-bit integer limit, is undefined behavior. Doing so, however,
     * will not crash, but the return value will be 'wrong'.
     * </p>
     * @param a number on the left
     * @param b number on the right
     * @return The concatenation of {@code a + b} as a {@code long}
     */
    public static long concat(int a, int b) {
        int exponent = length(b);
        long aLong = a;
        for (int i = 0; i < exponent; ++i) {
            aLong *= 10;
        }
        return aLong + b;
    }

    /**
     * <p>
     * Concatenate two positive 64-bit integers
     * into a single number, as if they were strings.
     * </p>
     * <p>
     * For example <code>concat(12, 34) == 1234L</code>
     * </p>
     * <p>
     * Attempting to concatenate any negative numbers, or a concatenation
     * exceeding the 64-bit integer limit, is undefined behavior. Doing so, however,
     * will not crash, but the return value will be 'wrong'.
     * </p>
     * @param a number on the left
     * @param b number on the right
     * @return The concatenation of {@code a + b} as a {@code long}
     */
    public static long concat(long a, long b) {
        int exponent = length(b);
        for (int i = 0; i < exponent; ++i) {
            a *= 10;
        }
        return a + b;
    }

}
