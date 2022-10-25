package org.example;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 *
 */
public class LongestValidParentheses {
    private final char roundBracesOpen = '(';
    private final char roundBracesClose = ')';

    public int longestValidParentheses(String s) {
        int longestValid = 0;
        int checker = 0;
        char[] checkedArr = new char[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {

            char actualChar = s.charAt(i);
            if (actualChar == roundBracesOpen) {
                checker++;
            } else if (actualChar == roundBracesClose) {
                checker--;
            } else {
                return 0;
            }
            if (checker < 0) {
                checker = 0;
                int size = getLongestValid(checkedArr, index);
                if (longestValid < size) {
                    longestValid = size;
                }
                index = 0;
            } else {
                checkedArr[index] = actualChar;
                index++;
            }
        }

        int size = getLongestValid(checkedArr, index);
        if (longestValid < size) {
            longestValid = size;
        }

        return longestValid;
    }

    private int getLongestValid(char[] checkedArr, int index) {
        int maxValid = 0;
        int valid = 0;
        int check = 0;
        for (int i = index - 1; i >=0 ; i--) {
            char checkedChar = checkedArr[i];
            if (valid == 0 && checkedChar == roundBracesOpen) {
                continue;
            }
            if (checkedChar == roundBracesClose) {
                check++;
            } else {
                check--;
            }
            if (check < 0) {
                if (valid > maxValid) {
                    maxValid = valid;
                }
                valid = 0;
                check = 0;
                continue;
            }
            valid++;
        }
        if (valid > maxValid) {
            maxValid = valid;
        }
        return maxValid;
    }
}
