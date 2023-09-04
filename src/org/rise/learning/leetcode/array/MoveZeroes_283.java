package org.rise.learning.leetcode.array;

/**
 * <p>https://leetcode.cn/problems/move-zeroes/</p>
 * 283. 移动零
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/4
 */
public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
