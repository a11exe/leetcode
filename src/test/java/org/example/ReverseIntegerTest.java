package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    private final ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void test1() {
        assertEquals(321, reverseInteger.reverse(123));
    }

    @Test
    void test2() {
        assertEquals(0, reverseInteger.reverse(1534236469));
    }

}