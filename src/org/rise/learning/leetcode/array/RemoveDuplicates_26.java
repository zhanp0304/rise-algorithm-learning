package org.rise.learning.leetcode.array;

/**
 * <p>https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/</p>
 * 26. 删除有序数组中的重复项
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/4
 */
public class RemoveDuplicates_26 {
    /**
     * 双指针，fast for non-duplicate, slow for storing the final results
     *
     * @param nums nums
     * @return the length of new array
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
