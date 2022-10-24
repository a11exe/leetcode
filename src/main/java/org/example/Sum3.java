package org.example;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/submissions/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Set<String> found = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(nums[i], count);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        while (keys.size() > 0) {
            Integer key = keys.get(0);
            if (key >= 0) {
                break;
            }
            Integer count = map.get(key);
            if (count > 1) {
                Integer search = 0 - key - key;
                if (map.containsKey(search)) {
                    String combination = "" + key + key + search;
                    if (!found.contains(combination)) {
                        result.add(Arrays.asList(key, key, search));
                        found.add(combination);
                    }
                }
            }
            for (int i = 1; i < keys.size(); i++) {
                Integer nextKey = keys.get(i);
                Integer search = 0 - key - nextKey;
                if (map.containsKey(search)) {
                    if (search.equals(nextKey)) {
                        if (map.get(nextKey) < 2) {
                            continue;
                        }
                    }
                    if (search.equals(key)) {
                        if (map.get(key) < 2) {
                            continue;
                        }
                    }
                    int[] arr = {key, nextKey, search};
                    Arrays.sort(arr);
                    String combination = "" + arr[0] + arr[1] + arr[2];
                    if (!found.contains(combination)) {
                        result.add(Arrays.asList(key, nextKey, search));
                        found.add(combination);
                    }
                }
            }
            keys.remove(0);

        }
        Integer zeroCount= map.get(0);
        if (zeroCount != null && zeroCount > 2) {
            result.add(Arrays.asList(0 ,0, 0));
        }
        return result;
    }
}
