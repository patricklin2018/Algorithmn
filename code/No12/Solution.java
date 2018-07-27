package No12;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/28 00:27
 * @Description:
 *
 * 剑指 offer - 12 矩形覆盖
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 */
public class Solution {

    public int RectCover(int target) throws Exception {
        if (target < 0) {
            throw new Exception("target 数值有误");
        }

        int[] dp = new int[1000000];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= target; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];
    }

}
