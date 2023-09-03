package org.rise.learning.algorithm.binarysearch;

/**
 * 二分查找
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/3
 */
public class BinarySearchDemo {


    /**
     * binary search algorithm
     *
     * @param sortedElements sortedElements
     * @param targetNumber   targetNumber
     * @return -1 if the target not found, otherwise return the index of the target
     */
    public static int binarySearch(int[] sortedElements, int targetNumber) {
        if (sortedElements.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = sortedElements.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (sortedElements[mid] > targetNumber) {
                high = mid - 1;
            } else if (sortedElements[mid] < targetNumber) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i * 10;
        }
        int i = BinarySearchDemo.binarySearch(ints, 30);
        System.out.println(i);
    }
}
