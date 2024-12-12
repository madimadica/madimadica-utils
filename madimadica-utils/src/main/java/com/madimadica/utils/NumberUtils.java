package com.madimadica.utils;


import java.util.Optional;

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

    /**
     * Attempts to parse the string argument into a byte.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional<Byte>} represented by the string argument.
     * @see Byte#parseByte(String)
     */
    public static Optional<Byte> parseByte(String s) {
        try {
            return Optional.of(Byte.parseByte(s));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a byte.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @param radix the radix to be used while parsing
     * @return an {@link Optional<Byte>} represented by the string argument.
     * @see Byte#parseByte(String, int)
     */
    public static Optional<Byte> parseByte(String s, int radix) {
        try {
            return Optional.of(Byte.parseByte(s, radix));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a short.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional<Short>} represented by the string argument.
     * @see Short#parseShort(String)
     */
    public static Optional<Short> parseShort(String s) {
        try {
            return Optional.of(Short.parseShort(s));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a short.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @param radix the radix to be used while parsing
     * @return an {@link Optional<Short>} represented by the string argument.
     * @see Short#parseShort(String, int)
     */
    public static Optional<Short> parseShort(String s, int radix) {
        try {
            return Optional.of(Short.parseShort(s, radix));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into an integer.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional<Integer>} represented by the string argument.
     * @see Integer#parseInt(String)
     */
    public static Optional<Integer> parseInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into an integer.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @param radix the radix to be used while parsing
     * @return an {@link Optional<Integer>} represented by the string argument.
     * @see Integer#parseInt(String, int)
     */
    public static Optional<Integer> parseInt(String s, int radix) {
        try {
            return Optional.of(Integer.parseInt(s, radix));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a long.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional<Long>} represented by the string argument.
     * @see Long#parseLong(String)
     */
    public static Optional<Long> parseLong(String s) {
        try {
            return Optional.of(Long.parseLong(s));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a long.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @param radix the radix to be used while parsing
     * @return an {@link Optional<Long>} represented by the string argument.
     * @see Long#parseLong(String, int)
     */
    public static Optional<Long> parseLong(String s, int radix) {
        try {
            return Optional.of(Long.parseLong(s, radix));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a boolean.
     * Only the values {@code "true"} and {@code "false"} (case-insensitive) are mapped
     * to a {@link Boolean} value, otherwise the result is {@link Optional#empty()} (including for {@code null}).
     * <br>
     * This differs from {@link Boolean#parseBoolean(String)}
     * by separating a {@code false} return from an error ({@code Optional.empty()}).
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional} {@code boolean} represented by the string argument.
     */
    public static Optional<Boolean> parseBoolean(String s) {
        if (s == null) {
            return Optional.empty();
        }
        switch (s.toLowerCase()) {
            case "true":
                return Optional.of(Boolean.TRUE);
            case "false":
                return Optional.of(Boolean.FALSE);
            default:
                return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a boolean.
     * Only the values {@code "1"} and {@code "0"} are mapped
     * to {@code true} and {@code false} respectively.
     * Otherwise, the result is {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional} {@code boolean} represented by the string argument.
     */
    public static Optional<Boolean> parseBit(String s) {
        if (s == null) {
            return Optional.empty();
        }
        switch (s) {
            case "1":
                return Optional.of(Boolean.TRUE);
            case "0":
                return Optional.of(Boolean.FALSE);
            default:
                return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a boolean.
     * Only the values {@code "false"} (case-insensitive) and {@code "0"} are mapped to {@code false},
     * and the values {@code "true"} (case-insensitive) and {@code "1"} are mapped to {@code true},
     * everything else is {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional} {@code boolean} represented by the string argument.
     * @see NumberUtils#parseBoolean(String)
     * @see NumberUtils#parseBit(String)
     */
    public static Optional<Boolean> parseBooleanOrBit(String s) {
        if (s == null) {
            return Optional.empty();
        }
        switch (s.toLowerCase()) {
            case "1":
            case "true":
                return Optional.of(Boolean.TRUE);
            case "0":
            case "false":
                return Optional.of(Boolean.FALSE);
            default:
                return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a float.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional<Short>} represented by the string argument.
     * @see Float#parseFloat(String)
     */
    public static Optional<Float> parseFloat(String s) {
        try {
            return Optional.of(Float.parseFloat(s));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to parse the string argument into a double.
     * Any exceptional value will result in {@link Optional#empty()}.
     *
     * @param s the {@code String} to be parsed.
     * @return an {@link Optional<Double>} represented by the string argument.
     * @see Double#parseDouble(String)
     */
    public static Optional<Double> parseDouble(String s) {
        try {
            return Optional.of(Double.parseDouble(s));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }

}
