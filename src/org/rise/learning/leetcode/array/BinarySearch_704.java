package org.rise.learning.leetcode.array;

/**
 * 704. 二分查找 https://leetcode.cn/problems/binary-search/
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/4
 */
public class BinarySearch_704 {

    public static int findTargetIndex(int[] ascSortedArr, int target) {
        int low = 0;
        int high = ascSortedArr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = ascSortedArr[mid];

            if (midValue < target) {
                low = mid + 1;
            } else if (midValue > target) {
                high = mid - 1;
            } else {
                // target found
                return mid;
            }
        }
        // target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = i * 10;
        }
        int targetIndex = findTargetIndex(ints, 10);
        System.out.println(targetIndex);
    }
}
