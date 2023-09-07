package org.rise.learning.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>https://leetcode.cn/problems/fruit-into-baskets/description/</p>
 * 904. 水果成篮
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/6
 */
public class FruitIntoBaskets_904 {
    public int totalFruit(int[] fruits) {
        int maxTotalFruits = 0;
        int slow = 0;
        Map<Integer, Integer> appearCountByFruit = new HashMap<>(fruits.length);
        for (int fast = 0; fast < fruits.length; fast++) {
            appearCountByFruit.put(fruits[fast], appearCountByFruit.getOrDefault(fruits[fast], 0) + 1);
            while (appearCountByFruit.size() > 2) {
                int currentFruitAppearCount = appearCountByFruit.get(fruits[slow]) - 1;
                appearCountByFruit.put(fruits[slow], currentFruitAppearCount);
                if (currentFruitAppearCount == 0) {
                    appearCountByFruit.remove(fruits[slow]);
                }
                slow++;
            }
            maxTotalFruits = Math.max(maxTotalFruits, fast - slow + 1);
        }
        return maxTotalFruits;
    }

    public static void main(String[] args) {
        int minLength = Integer.MAX_VALUE;
        String s = "";
        int minLeft = 0;
        int minRight = 0;
        String s1 = minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight - 1);
        System.out.println(s1);
    }
}
