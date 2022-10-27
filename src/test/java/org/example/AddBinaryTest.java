package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    private final AddBinary addBinary = new AddBinary();

    @Test
    void test1() {
        assertEquals("100", addBinary.addBinary("11", "1"));
    }

    @Test
    void test2() {
        assertEquals("10101", addBinary.addBinary("1010", "1011"));
    }

    @Test
    void test3() {
        assertEquals("11110", addBinary.addBinary("1111", "1111"));
    }

}