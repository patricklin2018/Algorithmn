package No09;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/27 22:35
 * @Description:
 *
 * 剑指 offer - 09 斐波那契数列
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39。
 *
 */
public class Solution {

    public int Fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("输入的 n 有误");
        }
        else if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        int preTwo = 0, preOne = 1, res = 0;
        for (int i = 2; i <= n; ++i) {
            res = preOne + preTwo;
            preTwo = preOne;
            preOne = res;
        }

        return res;
    }
}
