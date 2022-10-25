package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    private RomanToInteger roman = new RomanToInteger();

    @Test
    public void testRomanToInt3() {
        int result = roman.romanToInt("III");
        assertEquals(3, result);
    }

    @Test
    public void testRomanToInt58() {
        int result = roman.romanToInt("LVIII");
        assertEquals(58, result);
    }

    @Test
    public void testRomanToInt1994() {
        int result = roman.romanToInt("MCMXCIV");
        assertEquals(1994, result);
    }

    @Test
    public void testRomanToIntWrongLiteral() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = roman.romanToInt("IIA");
        });
    }

    @Test
    public void testRomanToIntWrongOrder() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = roman.romanToInt("IL");
        });
    }

}