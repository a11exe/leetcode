package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {

    private final ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void testIsValid1() {
        assertTrue(validParentheses.isValid("()"));
    }

    @Test
    public void testIsValid2() {
        assertTrue(validParentheses.isValid("()[]{}"));
    }

    @Test
    public void testIsValid3() {
        assertFalse(validParentheses.isValid("(]"));
    }

    @Test
    public void testIsValid4() {
        assertFalse(validParentheses.isValid("([)]"));
    }

    @Test
    public void testIsValid5() {
        assertFalse(validParentheses.isValid("("));
    }

    @Test
    public void testIsValid6() {
        assertFalse(validParentheses.isValid("(("));
    }


}