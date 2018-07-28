package No15;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/28 21:33
 * @Description:
 *
 * 剑指 offer - 15 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        // 辅助数组 和 计数器
        int cOdd = 0, cEven = 0;
        int[] odd = new int[1000000];
        int[] even = new int[1000000];
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0) {
                even[cEven++] = array[i];
            }
            else {
                odd[cOdd++] = array[i];
            }
        }

        System.arraycopy(odd, 0, array, 0, cOdd);
        System.arraycopy(even, 0, array, cOdd, cEven);
    }

    public static void main(String[] args) {
        int[] ary = {1,2,3,4,5,6,7};
        new Solution().reOrderArray(ary);
    }
}
