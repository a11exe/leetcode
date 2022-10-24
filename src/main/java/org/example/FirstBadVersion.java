package org.example;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {

    private int badVersion = 4;

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int from = 1;
        int to = n;
        int middle = 0;
        boolean isPrevMiddleBadVersion = true;
        if ((to - from) == 1) {
            return isBadVersion(from) ? from : to;
        }
        while (Math.abs(from - to) != 1) {
            middle = getMiddle(from, to);
            boolean isMiddleBadVersion = isBadVersion(middle);
            if (isPrevMiddleBadVersion && isMiddleBadVersion) {
                to = middle;
            }
            if (!isPrevMiddleBadVersion && !isMiddleBadVersion) {
                from = middle;
            }
            if (isPrevMiddleBadVersion && !isMiddleBadVersion) {
                from = middle;
            }
            if (!isPrevMiddleBadVersion && isMiddleBadVersion) {
                to = middle;
            }
            isPrevMiddleBadVersion = isMiddleBadVersion;
        }
        return isPrevMiddleBadVersion ? middle : (middle + 1);
    }

    private int getMiddle(int from, int to) {
        int range = to - from + 1;
        int middle = range / 2;
        if (range % 2 != 0) {
            middle++;
        }
        middle = middle + from - 1;
        System.out.println("middle " + middle);
        return middle;
    }


    private boolean isBadVersion(int version) {
        // System.out.println("Is bad version " + version);
        return version >= badVersion;
    }

}
