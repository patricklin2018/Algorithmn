package No10;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/27 22:47
 * @Description:
 *
 * 剑指 offer - 10 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 */
public class Solution {

    public int JumpFloor(int target) throws Exception {
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
