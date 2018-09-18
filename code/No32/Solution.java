package No32;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 10:03
 * @Description:
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int dp = array[0];
        int tmp = array[0];
        for (int i = 1; i < array.length; ++i) {
            tmp = tmp < 0 ? array[i] : tmp + array[i];
            if (tmp > dp) {
                dp = tmp;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,3,10,-4,7,2,-5};
        new Solution().FindGreatestSumOfSubArray(nums);
    }
}
