package org.example;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * A string is called a palindrome string if the reverse of that string is the same as the original string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromic {
    public String longestPalindrome(String s) {
        for (int size = s.length(); size >=2 ; size--) {
            for (int i = 0; i < s.length(); i++) {
                if (i+size > s.length()) {
                    break;
                }
                String checked = s.substring(i, i + size);
                if (isPalindrom(checked)) {
                    return checked;
                }
            }
        }
        return s.substring(0, 1);
    }

    public boolean isPalindrom(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
