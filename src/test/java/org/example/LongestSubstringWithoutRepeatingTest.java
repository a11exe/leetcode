package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingTest {

    private final LongestSubstringWithoutRepeating lsubstr
            = new LongestSubstringWithoutRepeating();

    @Test
    void test1() {
        assertEquals(3, lsubstr.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void test2() {
        assertEquals(1, lsubstr.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void test3() {
        assertEquals(3, lsubstr.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void test4() {
        assertEquals(3, lsubstr.lengthOfLongestSubstring("pwwkew"));
    }

}