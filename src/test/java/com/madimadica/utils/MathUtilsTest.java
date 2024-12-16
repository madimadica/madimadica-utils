package com.madimadica.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void min_throwsOnEmpty() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.min(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.min(new long[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.min(new float[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.min(new double[] {}));
    }

    @Test
    void max_throwsOnEmpty() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.max(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.max(new long[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.max(new float[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.max(new double[] {}));
    }

    @Test
    void average_throwsOnEmpty() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(new long[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(new float[] {}));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(new double[] {}));
    }

    @Test
    void min_throwsOnNull() {
        assertThrows(NullPointerException.class, () -> MathUtils.min((int[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.min((long[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.min((float[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.min((double[]) null));
    }

    @Test
    void max_throwsOnNull() {
        assertThrows(NullPointerException.class, () -> MathUtils.max((int[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.max((long[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.max((float[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.max((double[]) null));
    }

    @Test
    void sum_throwsOnNull() {
        assertThrows(NullPointerException.class, () -> MathUtils.sum((int[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.sum((long[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.sum((float[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.sum((double[]) null));
    }

    @Test
    void average_throwsOnNull() {
        assertThrows(NullPointerException.class, () -> MathUtils.average((int[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.average((long[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.average((float[]) null));
        assertThrows(NullPointerException.class, () -> MathUtils.average((double[]) null));
    }

    @Test
    void min_singleArgument() {
        for (int i = -10; i <= 10; ++i) {
            int minInt = MathUtils.min(i);
            long minLong = MathUtils.min((long) i);
            float minFloat = MathUtils.min((float) i);
            double minDouble = MathUtils.min((double) i);
            assertEquals(i, minInt);
            assertEquals(i, minLong);
            assertEquals(i, minFloat);
            assertEquals(i, minDouble);
        }
    }

    @Test
    void max_singleArgument() {
        for (int i = -10; i <= 10; ++i) {
            int maxInt = MathUtils.max(i);
            long maxLong = MathUtils.max((long) i);
            float maxFloat = MathUtils.max((float) i);
            double maxDouble = MathUtils.max((double) i);
            assertEquals(i, maxInt);
            assertEquals(i, maxLong);
            assertEquals(i, maxFloat);
            assertEquals(i, maxDouble);
        }
    }

    @Test
    void sum_singleArgument() {
        for (int i = -10; i <= 10; ++i) {
            long sumInt = MathUtils.sum(i);
            long sumLong = MathUtils.sum((long) i);
            double sumFloat = MathUtils.sum((float) i);
            double sumDouble = MathUtils.sum((double) i);
            assertEquals(i, sumInt);
            assertEquals(i, sumLong);
            assertEquals(i, sumFloat);
            assertEquals(i, sumDouble);
        }
    }

    @Test
    void average_singleArgument() {
        for (int i = -10; i <= 10; ++i) {
            double avgInt = MathUtils.average(i);
            double avgLong = MathUtils.average((long) i);
            double avgFloat = MathUtils.average((float) i);
            double avgDouble = MathUtils.average((double) i);
            assertEquals(i, avgInt);
            assertEquals(i, avgLong);
            assertEquals(i, avgFloat);
            assertEquals(i, avgDouble);
        }
    }

    @Test
    void min2() {
        assertEquals(1, MathUtils.min(1, 2));
        assertEquals(1, MathUtils.min(2, 1));

        assertEquals(1L, MathUtils.min(1L, 2L));
        assertEquals(1L, MathUtils.min(2L, 1L));

        assertEquals(1f, MathUtils.min(1f, 2f));
        assertEquals(1f, MathUtils.min(2f, 1f));

        assertEquals(1.0, MathUtils.min(1.0, 2.0));
        assertEquals(1.0, MathUtils.min(2.0, 1.0));
    }

    @Test
    void max2() {
        assertEquals(2, MathUtils.max(1, 2));
        assertEquals(2, MathUtils.max(2, 1));

        assertEquals(2L, MathUtils.max(1L, 2L));
        assertEquals(2L, MathUtils.max(2L, 1L));

        assertEquals(2f, MathUtils.max(1f, 2f));
        assertEquals(2f, MathUtils.max(2f, 1f));

        assertEquals(2.0, MathUtils.max(1.0, 2.0));
        assertEquals(2.0, MathUtils.max(2.0, 1.0));
    }

    @Test
    void sum2() {
        assertEquals(3, MathUtils.sum(1, 2));
        assertEquals(3, MathUtils.sum(2, 1));

        assertEquals(3L, MathUtils.sum(1L, 2L));
        assertEquals(3L, MathUtils.sum(2L, 1L));

        assertEquals(3f, MathUtils.sum(1f, 2f));
        assertEquals(3f, MathUtils.sum(2f, 1f));

        assertEquals(3.0, MathUtils.sum(1.0, 2.0));
        assertEquals(3.0, MathUtils.sum(2.0, 1.0));
    }

    @Test
    void avg2() {
        assertEquals(1.5, MathUtils.average(1, 2));
        assertEquals(1.5, MathUtils.average(2, 1));

        assertEquals(1.5, MathUtils.average(1L, 2L));
        assertEquals(1.5, MathUtils.average(2L, 1L));

        assertEquals(1.5, MathUtils.average(1f, 2f));
        assertEquals(1.5, MathUtils.average(2f, 1f));

        assertEquals(1.5, MathUtils.average(1.0, 2.0));
        assertEquals(1.5, MathUtils.average(2.0, 1.0));
    }
}