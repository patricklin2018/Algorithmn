## 32 - 连续子数组的最大和

### 题目描述

HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:`{6,-3,-2,7,-15,1,2,2}`,连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

### 思路

动态规划，重点是用一个临时变量 `tmp = tmp < 0 ? array[i] : tmp + array[i];`：

该临时变量若低于零，那么就等于遍历到的变量，因为最大和的子序列必然不会从和为负数的子序列开始；

若临时变量不低于零，那么就加上当前遍历变量。

### 代码
[代码-JAVA](Solution.java)

```java
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
}
```