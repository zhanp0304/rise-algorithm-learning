package org.rise.learning.leetcode.hash;

/**
 * 383. 赎金信
 * <p>https://leetcode.cn/problems/ransom-note/</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/11/4
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] appearCountInMagazine = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            ++appearCountInMagazine[index];
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            int remainCount = appearCountInMagazine[index];
            if (remainCount <= 0) {
                return false;
            }
            --appearCountInMagazine[index];
        }

        return true;
    }
}
