package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    private final GenerateParentheses generateParentheses = new GenerateParentheses();

    @Test
    void test1() {
        assertArrayEquals(new String[]{"((()))","(()())","(())()","()(())","()()()"},
                generateParentheses.generateParenthesis(3).toArray());
    }

    @Test
    void test2() {
        assertArrayEquals(new String[]{"()"},
                generateParentheses.generateParenthesis(1).toArray());
    }

}