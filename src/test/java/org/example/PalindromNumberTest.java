package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromNumberTest {

    private final PalindromNumber palindromNumber = new PalindromNumber();

    @Test
    void isPalindromeMinus1111() {
        assertTrue(palindromNumber.isPalindrome(1111));
    }

    @Test
    void isPalindrome121() {
        assertTrue(palindromNumber.isPalindrome(121));
    }

    @Test
    void isPalindrome1267621() {
        assertTrue(palindromNumber.isPalindrome(1267621));
    }

    @Test
    void isPalindrome1267622() {
        assertFalse(palindromNumber.isPalindrome(1267622));
    }

    @Test
    void isPalindromeMinus121() {
        assertFalse(palindromNumber.isPalindrome(-121));
    }

    @Test
    void isPalindromeMinus120() {
        assertFalse(palindromNumber.isPalindrome(120));
    }

    @Test
    void isPalindrome10() {
        assertFalse(palindromNumber.isPalindrome(10));
    }
}