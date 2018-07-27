## 12 - 矩形覆盖

### 题目描述

一我们可以用`2*1`的小矩形横着或者竖着去覆盖更大的矩形。

请问用`n`个`2*1`的小矩形无重叠地覆盖一个`2*n`的大矩形，总共有多少种方法？

### 思路

其本质上还是斐波那契数列。

```$xslt
dp[0] = 0;
dp[1] = 1;
dp[2] = 2;

dp[3] = 3;
dp[4] = 5;
dp[5] = 8;
...
dp[n] = dp[n - 1] + dp[n - 2]
```

### 代码
[代码-JAVA](Solution.java)

```java
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
```