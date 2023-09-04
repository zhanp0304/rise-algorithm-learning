package org.rise.learning.leetcode.array;

/**
 * <p>https://leetcode.cn/problems/remove-element/</p>
 * 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/4
 */
public class RemoveElement_27 {

    /**
     * 自己做的解法既移除了元素，又keep住原来的顺序（因为采用swap交换)；但实际上题目并不要求元素顺序，只需要移除，并将数组收窄即可
     * <p>第一种解法的内存占用较多，因为用swap的话，就需要中间变量，就会占用多一份内存</p>
     *
     * <p>怎样才可以不swap，也能移除元素呢？把slow指针做第一位，fast指针起始放最后一位，然后两个夹逼靠拢的时候，即可。是的，这样会破坏元素顺序，
     * 不过题目不要求元素顺序，所以完全可以这么做</p>
     *
     * <p>双指针既可以从0同步开始，也可从0和n-1靠拢</p>
     *
     * @param nums nums
     * @param val  val
     * @return length
     */
    public static int removeElementOptimize(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] == val) {
                while (nums[j] == val && j > i) {
                    j--;
                }
                if (j <= i) {
                    break;
                }
                nums[i] = nums[j];
                j--;
            }
            if (i + 1 <= j) {
                i++;
            }
        }

        // 最后一个元素的判断, 若match, 则length + 1
        if (i == j && nums[i] != val) {
            return i + 1;
        }

        // the last one not matched, so length + 1
        return i;
    }


    public static int removeElement(int[] arr, int target) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[i] != target) {
                i++;
                j++;
                continue;
            }

            if (i == j) {
                j++;
            }

            while (j < arr.length) {
                if (arr[j] != target) {
                    swap(arr, i, j);
                    i++;
                    j++;
                    break;
                }
                j++;
            }
        }
        // final i is the length of the array
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] ints = new int[8];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 2;
        ints[4] = 3;
        ints[5] = 0;
        ints[6] = 4;
        ints[7] = 2;

        int i = removeElementOptimize(ints, 2);
        System.out.println(i);
    }
}
