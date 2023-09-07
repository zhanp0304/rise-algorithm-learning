package org.rise.learning.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>https://leetcode.cn/problems/minimum-window-substring/submissions/</p>
 * 76. 最小覆盖子串
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/7
 */
public class MinWindow_76 {
    public static String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        int slow = 0;
        int matchSize = 0;

        Map<String, Integer> appearCountByStr = new HashMap<>(16);

        for (int i = 0; i < t.length(); i++) {
            String targetStr = String.valueOf(t.charAt(i));
            appearCountByStr.put(targetStr, appearCountByStr.getOrDefault(targetStr, 0) + 1);
        }

        Map<String, Integer> resultCountByStr = new HashMap<>(16);

        int targetMatchSize = appearCountByStr.keySet().size();

        for (int fast = 0; fast < s.length(); fast++) {
            // calc matchSize
            String c = String.valueOf(s.charAt(fast));
            int targetAppearCount = appearCountByStr.getOrDefault(c, 0);

            if (targetAppearCount == 0) {
                continue;
            }

            int currentCount = resultCountByStr.getOrDefault(c, 0) + 1;
            resultCountByStr.put(c, currentCount);
            if (currentCount == targetAppearCount) {
                ++matchSize;
            }

            while (matchSize >= targetMatchSize) {
                int currentWindowLength = fast - slow + 1;
                if (currentWindowLength < minLength) {
                    minLength = currentWindowLength;
                    minLeft = slow;
                    minRight = fast;
                }

                String slowStr = String.valueOf(s.charAt(slow));

                int slowTargetCount = appearCountByStr.getOrDefault(slowStr, 0);
                if (slowTargetCount <= 0) {
                    ++slow;
                    continue;
                }

                int slowCurrentCount = resultCountByStr.getOrDefault(slowStr, 0) - 1;
                resultCountByStr.put(slowStr, slowCurrentCount);
                if (slowCurrentCount < slowTargetCount) {
                    --matchSize;
                }
                ++slow;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);

    }

    public static void main(String[] args) {
        String windowSize = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(windowSize);
    }
}
