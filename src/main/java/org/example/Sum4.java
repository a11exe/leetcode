package org.example;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> uniq = new HashSet<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(nums[i], count);
        }
        List<Integer> keys = new ArrayList(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            Integer count = map.get(key);
            if (count >= 4) {
                int sum = count*4;
                if (sum == target) {
                    result.add(Arrays.asList(key, key, key ,key));
                    uniq.add(""+key+key+key+key);
                }
            }
            if (count >= 3) {
                int search = target - key*3;
                add(map, result, uniq, key, key, key, search);
            }
            if (count >= 2) {
                for (int j = i + 1; j < keys.size(); j++) {
                    int second = keys.get(j);
                    int search = target - key - key - second;
                    add(map, result, uniq, key, key, second, search);
                }
            }
            if (count >= 1) {
                for (int j = i + 1; j < keys.size(); j++) {
                    int second = keys.get(j);
                    for (int k = i + 2; k < keys.size(); k++) {
                        int third = keys.get(k);
                        int search = target - key - second - third;
                        add(map, result, uniq, key, second, third, search);
                    }
                }
            }
        }
        return result;
    }

    private void add(Map<Integer, Integer> map,
                     List<List<Integer>> result,
                     Set<String> uniq,
                     int first, int second, int third, Integer search) {
        if (map.containsKey(search)) {
            Integer[] arr = {first, second, third, search};
            Arrays.sort(arr);
            String str = "" + arr[0] + arr[1] + arr[2] + arr[3];
            if (!uniq.contains(str)) {
                result.add(Arrays.asList(arr));
                uniq.add(str);
            }
        }
    }
}
