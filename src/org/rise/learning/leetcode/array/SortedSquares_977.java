package org.rise.learning.leetcode.array;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 * <p>977. 有序数组的平方</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/4
 */
public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] results = new int[nums.length];
        int i = nums.length - 1;
        while (left < right) {
            if (abs(nums[right]) >= abs(nums[left])) {
                results[i--] = nums[right--];
            } else {
                results[i--] = nums[left++];
            }
        }

        results[0] = nums[left];

        pow2(results);
        return results;
    }

    private void pow2(int[] nums) {
        for(int i = 0; i< nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
    }

    private int abs(int num) {
        return Math.abs(num);
    }
}
