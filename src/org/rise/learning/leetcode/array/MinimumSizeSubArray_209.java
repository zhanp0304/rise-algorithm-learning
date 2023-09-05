package org.rise.learning.leetcode.array;

/**
 * <p>https://leetcode.cn/problems/minimum-size-subarray-sum/</p>
 * 209. 长度最小的子数组
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/5
 */
public class MinimumSizeSubArray_209 {

    public static int minSubArrayLenOptimize(int target, int[] nums) {
        int slow = 0;
        int sum = 0;
        int minimumLength = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];

            while (sum >= target) {
                int currentLength = fast - slow + 1;
                minimumLength = Math.min(currentLength, minimumLength);
                sum = sum - nums[slow++];
            }
        }

        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }

    public static int calcSum(int[] nums, int left, int right) {
        int sum = 0;
        while (left <= right) {
            sum += nums[left++];
        }
        return sum;
    }

    /**
     * 暴力破解（超时）
     *
     * @param target target
     * @param nums   nums
     * @return minSubArrayLen
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minestLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int j = i;
            while (sum < target && j < nums.length) {
                sum += nums[j++];
            }
            if (sum >= target) {
                int currentLength = j - i;
                minestLength = Math.min(minestLength, currentLength);
            }
        }
        return minestLength == Integer.MAX_VALUE ? 0 : minestLength;
    }

    public static void main(String[] args) {
        int[] ints = new int[6];
        ints[0] = 2;
        ints[1] = 3;
        ints[2] = 1;
        ints[3] = 2;
        ints[4] = 4;
        ints[5] = 3;
        int i = minSubArrayLenOptimize(7, ints);
        System.out.println(i);
    }
}
