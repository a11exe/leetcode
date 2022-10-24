package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class PalindromNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        List<Integer> digits = new ArrayList<>();
        int actual = x;
        int main = 0;
        int tail = 0;
        while (true) {
            if (actual < 10) {
                digits.add(actual);
                break;
            }
            main = actual / 10;
            tail = actual - main * 10;
            digits.add(tail);
            actual = main;
        }

        int size = digits.size();
        int middle = size / 2;
        for (int i = 0; i < middle; i++) {
            if (!digits.get(i).equals(digits.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
