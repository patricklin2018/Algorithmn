## 11 - 变态跳台阶

### 题目描述

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

### 思路

寻找规律发现：
```$xslt
dp[0] = 0;
dp[1] = 1;
dp[2] = 2;
dp[3] = 4;
dp[4] = 8;
dp[5] = 16;
...
```

因此，`dp[n] = 2 ^ (n - 1)`。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public int JumpFloorII(int target) throws Exception {
        if (target < 0) {
            throw new Exception("target 数值有误");
        }

        int res = (int)Math.pow(2, target - 1);
        return res;
    }
}
```