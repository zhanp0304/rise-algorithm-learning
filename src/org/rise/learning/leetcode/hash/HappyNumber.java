package org.rise.learning.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/happy-number/description/
 * <p>202. 快乐数</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/21
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> appearSet = new HashSet<>();
        n = calcSum(n);
        while (n != 1 && !appearSet.contains(n)) {
            appearSet.add(n);
            n = calcSum(n);
        }
        return n == 1;
    }


    private int calcSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
