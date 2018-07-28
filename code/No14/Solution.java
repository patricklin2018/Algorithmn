package No14;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/28 21:10
 * @Description:
 *
 * 剑指 offer - 14 数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {

    public double Power(double base, int exponent) {
        if (isEqual(base, 0)) {
            return 0.0;
        }
        else if (exponent == 0) {
            return 1.0;
        }

        if (exponent > 0) {
            return mypow(base, exponent);
        }
        else {
            return mypow(1 / base, -exponent);
        }
    }

    public double mypow(double base, int exp) {
        double res = 1;
        for (int i = 0; i < exp; ++i) {
            res = res * base;
        }
        return res;
    }

    public boolean isEqual(double a, double b) {
        if (-0.000001 < a - b && a - b < 0.000001) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        new Solution().Power(2, -3);
    }
}
