package org.rise.learning.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/submissions/467800021/
 * <p>349. 两个数组的交集</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/19
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.putIfAbsent(nums1[i], true);
        }

        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] results = new int[resultSet.size()];
        int i = 0;
        for (Integer val : resultSet) {
            results[i++] = val;
        }
        return results;
    }
}
