package org.rise.learning.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * <p>59. 螺旋矩阵 II</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/8
 */
public class SpiralMatrix_59 {
    public static int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        for (int i = 0; i < n; i++) {
            results[i] = new int[n];
        }
        int currentNum = 1;
        int neededRound = n / 2;
        for (int currentRound = 0; currentRound < neededRound; currentRound++) {
            int i = currentRound;
            int j = currentRound;
            for (; j < n - 1 - currentRound; j++) {
                results[i][j] = currentNum++;
            }

            for(; i < n - 1 - currentRound; i++) {
                results[i][j] = currentNum++;
            }

            for(; j > currentRound; j--) {
                results[i][j] = currentNum++;
            }

            for(; i > currentRound; i--) {
                results[i][j] = currentNum++;
            }
        }

        if (n % 2 != 0) {
            results[neededRound][neededRound] = n * n;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(1);
        System.out.println(Arrays.deepToString(ints));
    }
}
