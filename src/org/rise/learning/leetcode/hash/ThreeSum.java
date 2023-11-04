package org.rise.learning.leetcode.hash;

import java.util.*;

/**
 * 15. 三数之和
 * <p>https://leetcode.cn/problems/3sum/description/</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/11/4
 */
public class ThreeSum {
    /**
     * 排序，然后用夹逼双指针寻找剩余满足条件的两数，遇到重复的就skip跳过
     *
     * @param nums nums
     * @return results
     */
    public List<List<Integer>> threeSumWithShrinkDoublePointer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        // double pointer
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // skip the duplicate element
                continue;
            }
            // define double pointer, use: low -> && <-high
            int low = i + 1;
            int high = nums.length - 1;

            int targetSum = -nums[i];
            // loop to find the remain two target num
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == targetSum) {
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low + 1] == nums[low]) {
                        // skip the duplicate element
                        low++;
                    }
                    while (high > low && nums[high - 1] == nums[high]) {
                        // skip the duplicate element
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < targetSum) {
                    // need higher sum
                    low++;
                } else {
                    // need lower sum
                    high--;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> threeSumForSortAndBinarySearch(int[] nums) {
        // sort the array for requiring a unique result
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        // double pointer
        int i = 0;
        int j;
        while (i < nums.length - 2) {
            j = i + 1;
            while (j < nums.length - 1) {
                int target = -(nums[i] + nums[j]);
                if (nums[j + 1] > target) {
                    // fail-fast
                    break;
                }
                if (binarySearch(nums, target, nums[j + 1], nums[nums.length - 1])) {
                    results.add(Arrays.asList(nums[i], nums[j], target));
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    ++j;
                }
                ++j;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                ++i;
            }
            ++i;
        }
        return results;
    }


    public List<List<Integer>> threeSumForSortAndHash(int[] nums) {
        // sort the array for requiring a unique result
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        Map<Integer, Integer> appearIndexByNum = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            appearIndexByNum.put(nums[i], i);
        }

        // double pointer
        int i = 0;
        int j;
        while (i < nums.length - 2) {
            j = i + 1;
            while (j < nums.length - 1) {
                int target = -(nums[i] + nums[j]);
                if (nums[j + 1] > target) {
                    // fail-fast
                    break;
                }
                Integer finalMatchedIndex = appearIndexByNum.get(target);
                if (finalMatchedIndex != null && finalMatchedIndex > j) {
                    results.add(Arrays.asList(nums[i], nums[j], target));
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    ++j;
                }
                ++j;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                ++i;
            }
            ++i;
        }
        return results;
    }

    private boolean binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
