package org.example;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = x * -1;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String reversed = sb.reverse().toString();
        System.out.println(Integer.MAX_VALUE);
        // 2147483647
        if (reversed.length() > 10) {
            return 0;
        } else if (reversed.length() == 10) {
            int firstNum = Integer.parseInt("" + reversed.charAt(0));
            if (firstNum > 2) {
               return 0;
           }
           if (firstNum == 2) {
               if (Integer.parseInt(reversed.substring(1)) > 147483647) {
                   return 0;
               }
           }
        }
        x = Integer.parseInt(reversed);
        if (isNegative) {
            x = x * -1;
        }
        return x;
    }
}
