package org.rise.learning.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-anagram/submissions/467452675/
 * <p>242. 有效的字母异位词</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/18
 */
public class ValidAnagram {
    public boolean isAnagramWithHash(String s, String t) {
        Map<String, Integer> appearCountMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            appearCountMap.put(str, appearCountMap.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            String str = String.valueOf(t.charAt(i));
            Integer lastCount = appearCountMap.put(str, appearCountMap.getOrDefault(str, 0) - 1);
            if (lastCount == null || lastCount < 1) {
                // 说明当前字符出现次数多于s串，或者不存在于s串中
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] appearCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int asciiAtIndex = s.charAt(i) - 97;
            appearCounts[asciiAtIndex] += 1;
        }


        for (int i = 0; i < t.length(); i++) {
            int asciiAtIndex = t.charAt(i) - 97;
            appearCounts[asciiAtIndex] -= 1;
        }

        for (int i = 0; i < appearCounts.length; i++) {
            if (appearCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // ascii
        int i = 'b' - 'a';
        System.out.println(i);
    }
}
