package org.example;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int maxLength = 0;
        char firstChar = Character.MIN_VALUE;
        // first loop
        for (int i = 0; i < strs.length; i++) {
            int actualLength = strs[i].length();
            if (actualLength == 0) {
                return "";
            }
            if (maxLength == 0) {
                maxLength = actualLength;
            } else {
                if (actualLength < maxLength) {
                    maxLength = actualLength;
                }
            }
            if (firstChar == Character.MIN_VALUE) {
                firstChar = strs[i].charAt(0);
            } else {
                // if first char different stop execution
                if (firstChar != strs[i].charAt(0)) {
                    return "";
                }
            }
        }
        // init max prefix and set first char that same for all
        char[] prefixArr = new char[maxLength];
        prefixArr[0] = firstChar;

        // start from second char
        int actualCharNum = 1;

        for (int j = actualCharNum; j < maxLength; j++) {
            char actualChar = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                // if actual char different stop execution
                if (actualChar != strs[i].charAt(j)) {
                    return getPrefix(prefixArr, j);
                }
            }
            prefixArr[j] = actualChar;
        }

        return getPrefix(prefixArr, prefixArr.length);
    }

    private String getPrefix(char[] prefixArr, int actualCharNum) {
        return new String(Arrays.copyOfRange(prefixArr, 0, actualCharNum));
    }

}
