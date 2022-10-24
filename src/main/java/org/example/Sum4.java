package org.example;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) {
            return result;
        }

        Set<String> uniq = new HashSet<>();
        Map<Integer, Integer> map = createCountMap(nums);
        int search = 0;

        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            Integer count = map.get(key);
            int limit = Math.min(count, 4);
            if (limit == 4) {
                if (target == key * 4) {
                    addUniq(result, uniq, key, key, key, key);
                }
            }
            if (limit == 3) {
                search = target - key * 3;
                if (map.containsKey(search)) {
                    addUniq(result, uniq, key, key, key, search);
                }
            }
            if (limit == 2) {
                int rest = target - key * 2;
                for (int j = i + 1; j < keys.size(); j++) {
                    Integer nextKey = keys.get(j);
                    search = rest - nextKey;
                    if (search == nextKey) {
                        if (map.get(nextKey) > 1) {
                            addUniq(result, uniq, key, key, nextKey, nextKey);
                            break;
                        }
                    } else if (map.containsKey(search)) {
                        if (search != key) {
                            addUniq(result, uniq, key, key, nextKey, search);
                            break;
                        }
                    }
                }
            }
            if (limit == 1) {
                for (int j = i + 1; j < keys.size(); j++) {
                    Integer nextKey = keys.get(j);
                    int rest = target - key - nextKey;
                    if (rest == 2*nextKey && map.get(nextKey) > 2) {
                        addUniq(result, uniq, key, nextKey, nextKey, nextKey);
                        break;
                    }
                    if (map.get(nextKey) > 1) {
                        search = rest - nextKey - nextKey;
                        if (map.containsKey(search)) {
                                addUniq(result, uniq, key, nextKey, nextKey, search);
                                break;
                        }
                    }
                    for (int k = j + 1; k < keys.size(); k++) {
                        Integer nextNextKey = keys.get(k);
                        search = target - key - nextKey - nextNextKey;
                        if (search == nextNextKey) {
                            if (map.get(nextNextKey) > 1) {
                                addUniq(result, uniq, key, nextKey, nextNextKey, nextNextKey);
                                break;
                            }
                        } else if (map.containsKey(search)) {
                            if (search != key && search != nextKey) {
                                addUniq(result, uniq, key, nextKey, nextNextKey, search);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private Map<Integer, Integer> createCountMap(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(nums[i], count);
        }
        return map;
    }

    private void addUniq(List<List<Integer>> result,
                         Set<String> uniq,
                         int first,
                         int second,
                         int third,
                         int fourth) {
        Integer[] arr = {first, second, third, fourth};
        Arrays.sort(arr);
        String str = "" + arr[0] + arr[1] + arr[2] + arr[3];
        if (!uniq.contains(str)) {
            result.add(Arrays.asList(arr));
            uniq.add(str);
        }
    }
}
