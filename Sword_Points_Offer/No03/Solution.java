package No03.Find_Target_In_Two_Dimen_Ary;

import java.awt.print.Pageable;

/**
 * @author PatrickLin
 * @date 2018/7/24 19:14
 * @description
 *
 * 剑指 offer - 03 二维数组中的查找
 *
 * 题目描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 **/
public class Solution {
    public boolean Find(int target, int [][] array) {

        if (array == null) {
            return false;
        }

        int r = 0, c = array[0].length - 1;
        while (c >= 0 && r < array.length) {

            if (array[r][c] == target) {
                return true;
            }
            else if (array[r][c] > target) {
                // 大于目标时，向左调整
                c--;
            }
            else {
                // 小于目标时，向下调整
                r++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int target = 7;
        int[][] ary = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        new Solution().Find(target, ary);

    }
}
