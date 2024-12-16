package com.madimadica.utils;

public class MathUtils {

    /**
     * Find the minimum of the given elements
     * @param array arguments
     * @return the minimum
     * @throws IllegalArgumentException if length is 0
     */
    public static int min(int... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        int currentMin = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            int cur = array[i];
            if (cur < currentMin) {
                currentMin = cur;
            }
        }
        return currentMin;
    }

    /**
     * Find the minimum of the given elements
     * @param array arguments
     * @return the minimum
     * @throws IllegalArgumentException if length is 0
     */
    public static long min(long... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        long currentMin = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            long cur = array[i];
            if (cur < currentMin) {
                currentMin = cur;
            }
        }
        return currentMin;
    }

    /**
     * Find the minimum of the given elements
     * @param array arguments
     * @return the minimum
     * @throws IllegalArgumentException if length is 0
     */
    public static float min(float... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        float currentMin = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            float cur = array[i];
            if (cur < currentMin) {
                currentMin = cur;
            }
        }
        return currentMin;
    }

    /**
     * Find the minimum of the given elements
     * @param array arguments
     * @return the minimum
     * @throws IllegalArgumentException if length is 0
     */
    public static double min(double... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        double currentMin = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            double cur = array[i];
            if (cur < currentMin) {
                currentMin = cur;
            }
        }
        return currentMin;
    }

    /**
     * Find the maximum of the given elements
     * @param array arguments
     * @return the maximum
     * @throws IllegalArgumentException if length is 0
     */
    public static int max(int... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        int currentMax = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            int cur = array[i];
            if (cur > currentMax) {
                currentMax = cur;
            }
        }
        return currentMax;
    }

    /**
     * Find the maximum of the given elements
     * @param array arguments
     * @return the maximum
     * @throws IllegalArgumentException if length is 0
     */
    public static long max(long... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        long currentMax = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            long cur = array[i];
            if (cur > currentMax) {
                currentMax = cur;
            }
        }
        return currentMax;
    }

    /**
     * Find the maximum of the given elements
     * @param array arguments
     * @return the maximum
     * @throws IllegalArgumentException if length is 0
     */
    public static float max(float... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        float currentMax = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            float cur = array[i];
            if (cur > currentMax) {
                currentMax = cur;
            }
        }
        return currentMax;
    }

    /**
     * Find the maximum of the given elements
     * @param array arguments
     * @return the maximum
     * @throws IllegalArgumentException if length is 0
     */
    public static double max(double... array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        double currentMax = array[0];
        final int len = array.length;
        for (int i = 1; i < len; ++i) {
            double cur = array[i];
            if (cur > currentMax) {
                currentMax = cur;
            }
        }
        return currentMax;
    }

    /**
     * Find the sum of the given elements.
     * There is a miniscule chance of overflow/underflow.
     * @param args arguments
     * @return the sum of all elements
     */
    public static long sum(int... args) {
        long total = 0;
        for (int x : args) {
            total += x;
        }
        return total;
    }

    /**
     * Find the sum of the given elements.
     * There is a small chance of overflow/underflow.
     * @param args arguments
     * @return the sum of all elements
     */
    public static long sum(long... args) {
        long total = 0;
        for (long x : args) {
            total += x;
        }
        return total;
    }

    /**
     * Find the sum of the given elements.
     * @param args arguments
     * @return the sum of all elements
     */
    public static double sum(float... args) {
        double total = 0;
        for (float x : args) {
            total += x;
        }
        return total;
    }

    /**
     * Find the sum of the given elements.
     * @param args arguments
     * @return the sum of all elements
     */
    public static double sum(double... args) {
        double total = 0;
        for (double x : args) {
            total += x;
        }
        return total;
    }

    /**
     * Find the average of the given elements
     * @param args arguments
     * @return the average
     * @throws IllegalArgumentException if length is 0
     */
    public static double average(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        double total = 0;
        for (int x : args) {
            total += x;
        }
        return total / args.length;
    }

    /**
     * Find the average of the given elements
     * @param args arguments
     * @return the average
     * @throws IllegalArgumentException if length is 0
     */
    public static double average(long... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        double total = 0;
        for (long x : args) {
            total += x;
        }
        return total / args.length;
    }

    /**
     * Find the average of the given elements
     * @param args arguments
     * @return the average
     * @throws IllegalArgumentException if length is 0
     */
    public static double average(float... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        double total = 0;
        for (float x : args) {
            total += x;
        }
        return total / args.length;
    }

    /**
     * Find the average of the given elements
     * @param args arguments
     * @return the average
     * @throws IllegalArgumentException if length is 0
     */
    public static double average(double... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array arg must have at least 1 element");
        }
        double total = 0;
        for (double x : args) {
            total += x;
        }
        return total / args.length;
    }

    /**
     * Compute the greatest common divisor (GCD)
     * @param a integer a
     * @param b integer b
     * @return The GCD of {@code a} and {@code b}
     */
    public static int gcd(int a, int b) {
        if (a == b && b == 0) {
            return 0;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Compute the greatest common divisor (GCD)
     * @param a integer a
     * @param b integer b
     * @return The GCD of {@code a} and {@code b}
     */
    public static long gcd(long a, long b) {
        if (a == b && b == 0) {
            return 0;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Compute the least common multiple (LCM)
     * @param a integer a
     * @param b integer b
     * @return The LCM of {@code a} and {@code b}
     */
    public static int lcm(int a, int b) {
        if (a == b && b == 0) {
            return 0;
        }
        return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

    /**
     * Compute the least common multiple (LCM)
     * @param a integer a
     * @param b integer b
     * @return The LCM of {@code a} and {@code b}
     */
    public static long lcm(long a, long b) {
        if (a == b && b == 0) {
            return 0;
        }
        return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

}
