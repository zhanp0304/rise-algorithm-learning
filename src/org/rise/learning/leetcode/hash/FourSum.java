package org.rise.learning.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * <p>https://leetcode.cn/problems/4sum/description/</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/11/5
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j - 1 > i && nums[j - 1] == nums[j]) {
                    continue;
                }
                int low = j + 1;
                int high  = nums.length - 1;
                // pay attention to the numeric overflow
                long retainSum = (long)target - nums[i] - nums[j];
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == retainSum) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low + 1] == nums[low]) {
                            low++;
                        }
                        low++;
                        while (low < high && nums[high - 1] == nums[high]) {
                            high--;
                        }
                        high--;
                    } else if (sum < retainSum) {
                        // need bigger sum
                        low++;
                    } else {
                        // need smaller sum
                        high--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // 注意溢出问题，要用long
        long retainSum = (long)-294967296 - 1000000000 - 1000000000;
        System.out.println(retainSum);
    }
}
