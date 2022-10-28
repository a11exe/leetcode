package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 */
public class GenerateParentheses {

    private final String open = "(";
    private final String close = ")";

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int leftOpen = n;
        int leftClosed = n;
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < n; i++) {
            openCount = n - i;
            leftOpen = leftOpen - openCount;
            for (int j = i; j < n; j++) {
                openCount++;
                sb.append(open);
            }
            do {
                for (int j = 0; j < leftClosed; j++) {
                    leftClosed--;
                    closeCount++;
                    sb.append(close);
                }
            } while (leftClosed > 0);
            result.add(sb.toString());
            sb = new StringBuilder();
        }
        System.out.println(result);
        return result;
    }

    private String getParentheses() {
        return open+close;
    }
}
