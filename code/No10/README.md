## 10 - 跳台阶

### 题目描述


一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

### 思路

动态规划，当前台阶(n >= 3)的跳法为 `n - 1` 台阶的跳法加上 `n - 2` 台阶的跳法。

```
dp[0] = 0
dp[1] = 1
dp[2] = 2
dp[n] = dp[n - 1] + dp[n - 2], n >= 3
```

### 代码
[代码-JAVA](Solution.java)

```java
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
```