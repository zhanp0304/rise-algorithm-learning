package org.rise.learning.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * <p>https://leetcode.cn/problems/two-sum/submissions/</p>
 * 1. 两数之和
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/23
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int remainNum;
        int[] results = new int[2];
        Map<Integer, Integer> indexByNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexByNum.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            remainNum = target - nums[i];
            Integer remainIndex = indexByNum.get(remainNum);
            if (remainIndex != null && remainIndex != i) {
                results[0] = i;
                results[1] = remainIndex;
                return results;
            }
        }

        return results;
    }
}
