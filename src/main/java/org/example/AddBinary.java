package org.example;

/**
 * https://leetcode.com/problems/add-binary/submissions/
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int max = Math.max(a.length(), b.length());
        boolean plusOne = false;
        for (int i = 0; i < max; i++) {
            int idxA = a.length() - 1 - i;
            char charA = idxA >= 0 ? a.charAt(idxA) : '0';
            int idxB = b.length() - 1 - i;
            char charB = idxB >= 0 ? b.charAt(idxB) : '0';
            if (plusOne) {
                if (charA == '0' && charB == '0') {
                    plusOne = false;
                    sb.append("1");
                } else if (charA == '1' && charB == '1') {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else {
                if (charA == '0' && charB == '0') {
                    sb.append("0");
                }
                if (charA == '1' && charB == '0') {
                    sb.append("1");
                }
                if (charA == '0' && charB == '1') {
                    sb.append("1");
                }
                if (charA == '1' && charB == '1') {
                    sb.append("0");
                    plusOne = true;
                }
            }
        }
        if (plusOne) {
            sb.append("1");
        }

        return sb.reverse().toString();

    }
}
