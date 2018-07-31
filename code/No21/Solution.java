package No21;

import java.util.ArrayList;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/31 22:39
 * @Description:
 *
 * 剑指 offer - 21 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null || matrix[0] == null) {
            return res;
        }

        int cycles = Math.min ((matrix.length + 1) / 2, (matrix[0].length + 1) / 2);
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        for (int i = 0; i < cycles; ++i) {
            printCycle(res, matrix, i, i, c - i, r - i);
        }

        return res;
    }

    public void printCycle(ArrayList<Integer> container, int[][] matrix, int left, int top, int right, int bottom) {
        // 向右
        for (int i = left; i <= right; ++i) {
            container.add(matrix[top][i]);
        }
        // 向下
        for (int i = top + 1; i <= bottom; ++i) {
            container.add(matrix[i][right]);
        }
        // 向左
        for (int i = right - 1; top != bottom && i >= left; --i) {
            container.add(matrix[bottom][i]);
        }
        // 向上
        for (int i = bottom - 1; left != right && i > top; --i) {
            container.add(matrix[i][left]);
        }
    }

    public static void main (String[] args) {
        int[][] a = {{1}, {2}, {3}, {4}, {5}};
        new Solution().printMatrix(a);
    }
}