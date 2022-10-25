package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlipStringToMonotoneIncreasingTest {

    private final FlipStringToMonotoneIncreasing flipStringToMonotoneIncreasing = new FlipStringToMonotoneIncreasing();

    @Test
    void test1() {
        assertEquals(1, flipStringToMonotoneIncreasing.minFlipsMonoIncr("00110"));
    }

    @Test
    void test2() {
        assertEquals(2, flipStringToMonotoneIncreasing.minFlipsMonoIncr("010110"));
    }

    @Test
    void test3() {
        assertEquals(2, flipStringToMonotoneIncreasing.minFlipsMonoIncr("00011000"));
    }

    @Test
    void test4() {
        assertEquals(2, flipStringToMonotoneIncreasing.minFlipsMonoIncr("00011000"));
    }

}