package org.rise.learning.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/4sum-ii/description/
 * <p>454. 四数相加 II</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/24
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 分别进行两轮O(n^2)的操作，先对前两组进行操作，再在后两组操作的过程中进行匹配判断, 整体加起来是2 * O(n^2)
        Map<Long, Integer> pairCountBySum = new HashMap<>(nums1.length * nums2.length);
        long tmpSum;
        int totalPairCount = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // map.computeIfAbsent((long)i + j, sum -> new ArrayList()).add(Arrays.asList(i, j));
                tmpSum = (long) nums1[i] + nums2[j];
                pairCountBySum.put(tmpSum, pairCountBySum.getOrDefault(tmpSum, 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                tmpSum = 0 - (long) nums3[i] - nums4[j];
                int pairCount = pairCountBySum.getOrDefault(tmpSum, 0);
                if (pairCount != 0) {
                    totalPairCount += pairCount;
                }
            }
        }
        return totalPairCount;
    }
}
