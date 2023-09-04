package org.rise.learning.leetcode.array;

/**
 * <p>https://leetcode.cn/problems/backspace-string-compare/</p>
 * 844. 比较含退格的字符串
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/4
 */
public class BackspaceCompare_844 {
    public boolean backspaceCompare(String s, String t) {
        s = calcFinalStr(s);
        t = calcFinalStr(t);
        return s.equals(t);
    }

    private String calcFinalStr(String s) {
        int slow = 0;
        char[] chars = s.toCharArray();
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != '#') {
                chars[slow++] = chars[fast];
            } else {
                slow = slow > 0 ? --slow : slow;
            }
        }
        return new String(chars, 0, slow);
    }
}
