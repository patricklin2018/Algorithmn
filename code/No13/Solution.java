package No13;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/28 00:33
 * @Description:
 *
 * 剑指 offer - 13 二进制中 1 的个数
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */
public class Solution {
    public int NumberOf1(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n = (n - 1) & n;
        }

        return counter;
    }

    public static void main(String[] args) {
        new Solution().NumberOf1(-10);
    }
}
