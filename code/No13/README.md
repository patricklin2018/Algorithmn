## 13 - 二进制中 1 的个数

### 题目描述

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

### 思路

`n = (n - 1) & n` 如果个位为 1，那么 -1，如果不是，那么会取距离个位最近的 1。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public int NumberOf1(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n = (n - 1) & n;
        }

        return counter;
    }
}
```