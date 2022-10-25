package org.example;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        char[] chars = new char[s.length()];
        char curlyBraceOpen = '{';
        char curlyBraceClose = '}';
        char squareBracesOpen = '[';
        char squareBracesClose = ']';
        char roundBracesOpen = '(';
        char roundBracesClose = ')';
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char actualChar = s.charAt(i);
            if (index == 0) {
                if (actualChar == curlyBraceClose
                        || actualChar == squareBracesClose
                        || actualChar == roundBracesClose) {
                    return false;
                } else {
                    chars[index] = actualChar;
                    index++;
                }
            } else {
                if (actualChar == curlyBraceClose) {
                    index--;
                    if (chars[index] != curlyBraceOpen) {
                        return false;
                    }
                } else if (actualChar == squareBracesClose) {
                    index--;
                    if (chars[index] != squareBracesOpen) {
                        return false;
                    }
                } else if (actualChar == roundBracesClose) {
                    index--;
                    if (chars[index] != roundBracesOpen) {
                        return false;
                    }
                } else {
                    chars[index] = actualChar;
                    index++;
                }
            }

        }

        if (index != 0) {
            return false;
        }

        return true;
    }
}
