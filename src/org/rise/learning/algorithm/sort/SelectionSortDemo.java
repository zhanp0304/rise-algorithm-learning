package org.rise.learning.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * SelectionSortDemo
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/3
 */
public class SelectionSortDemo {

    /**
     * 从大到小排序
     * <p>选择排序就是：我要做N轮计算，每一轮都找出剩余待排序的元素中的最大值/最小值，然后将这个值作为本轮的最大/最小值，
     * 通过交换元素的方式记录在本轮的起始位置上。然后继续推进到下一轮，对剩余待排序元素继续排序</p>
     *
     * <p>要注意：这个算法目前在原数组上直接排序，因为需要做元素交换，以剔除已寻找到的本轮最大/最小值，然后推进下一轮。时间复杂度是O(N^2)</p>
     *
     * @param arr arr
     */
    public static void descSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }

            // 确定这一轮的最大值的索引后，通过交换元素的方式将最大值填充到这一轮的起始位置上
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(10);
        }

        System.out.println(Arrays.toString(ints));

        descSort(ints);
        int[] copy = Arrays.copyOf(ints, ints.length);
        Integer[] copyArray = new Integer[copy.length];
        for (int i = 0; i < copy.length; i++) {
            copyArray[i] = copy[i];
        }
        Arrays.sort(copyArray, Collections.reverseOrder());
        System.out.println("answer: " + Arrays.toString(copy));
        System.out.println("my answer: " + Arrays.toString(ints));
    }
}
