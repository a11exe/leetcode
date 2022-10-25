package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParenthesesTest {

    private final LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

    @Test
    public void testLongestValidParentheses1() {
        assertEquals(2, longestValidParentheses.longestValidParentheses("(()"));
    }

    @Test
    public void testLongestValidParentheses2() {
        assertEquals(4, longestValidParentheses.longestValidParentheses(")()())"));
    }

    @Test
    public void testLongestValidParentheses3() {
        assertEquals(0, longestValidParentheses.longestValidParentheses(""));
    }

    @Test
    public void testLongestValidParentheses4() {
        assertEquals(0, longestValidParentheses.longestValidParentheses("("));
    }

    @Test
    public void testLongestValidParentheses5() {
        assertEquals(0, longestValidParentheses.longestValidParentheses("(("));
    }

    @Test
    public void testLongestValidParentheses6() {
        assertEquals(4, longestValidParentheses.longestValidParentheses("()()"));
    }

    @Test
    public void testLongestValidParentheses7() {
        assertEquals(2, longestValidParentheses.longestValidParentheses("()(()"));
    }

    @Test
    public void testLongestValidParentheses8() {
        assertEquals(4, longestValidParentheses.longestValidParentheses("(())("));
    }

    @Test
    public void testLongestValidParentheses9() {
        assertEquals(6, longestValidParentheses.longestValidParentheses("(())()(()(("));
    }

}