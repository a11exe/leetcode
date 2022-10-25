package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckTwoStringArraysEquivalentTest {

    private final CheckTwoStringArraysEquivalent checkTwoStringArraysEquivalent = new CheckTwoStringArraysEquivalent();

    @Test
    void test1() {
        assertEquals(true, checkTwoStringArraysEquivalent.arrayStringsAreEqual(
                new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }

}