package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    private final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    public void testLongestCommonPrefixAB() {
        String[] strs = new String[]{"ab", "a"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("a", prefix);
    }

    @Test
    public void testLongestCommonPrefixA() {
        String[] strs = new String[]{"a"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("a", prefix);
    }

    @Test
    public void testLongestCommonPrefixFl() {
        String[] strs = new String[]{"flower","flow","flight"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("fl", prefix);
    }

    @Test
    public void testLongestCommonPrefixEmpty() {
        String[] strs = new String[]{"dog","racecar","car"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", prefix);
    }

    @Test
    public void testLongestCommonPrefixFll() {
        String[] strs = new String[]{"fll","fll","fll"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("fll", prefix);
    }

}