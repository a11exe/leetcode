package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Sum3Test {

    private final Sum3 sum3 = new Sum3();

    @Test
    void test1() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertEquals(expected, sum3.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    @Test
    void test2() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1));
        assertEquals(expected, sum3.threeSum(new int[]{-2,0,1,1,2}));
    }

}