package No11;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/28 00:00
 * @Description:
 *
 * 剑指 offer - 11 变态跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */
public class Solution {
    public int JumpFloorII(int target) throws Exception {
        if (target < 0) {
            throw new Exception("target 数值有误");
        }

        int res = (int)Math.pow(2, target - 1);
        return res;
    }
}
