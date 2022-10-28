package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    private final Sqrt sqrt = new Sqrt();

    @Test
    void test1() {
        assertEquals(2, sqrt.mySqrt(4));
    }

    @Test
    void test2() {
        assertEquals(2, sqrt.mySqrt(8));
    }

    @Test
    void test3() {
        assertEquals(46340, sqrt.mySqrt(2147483647));
    }


}