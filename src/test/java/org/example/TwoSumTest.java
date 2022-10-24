package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    void twoSum4_9() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0,1}, result);
    }

    @Test
    void twoSum3_6() {
        int[] result = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1,2}, result);
    }

    @Test
    void twoSum2_3() {
        int[] result = twoSum.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0,1}, result);
    }


}