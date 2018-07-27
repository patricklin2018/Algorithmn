## 09 - 斐波那契数列

### 题目描述

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39。

### 思路

斐波那契的数列总是由数列的前两个数字相加，因此数列为：1，1，2，3，5，8，...,

因此，只需要循环向后加就可以。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public int Fibonacci(int n)  throws Exception {
        if (n < 0) {
            throw new Exception("输入的 n 有误");
        }
        else if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        int preTwo = 0, preOne = 1, res = 0;
        for (int i = 2; i <= n; ++i) {
            res = preOne + preTwo;
            preTwo = preOne;
            preOne = res;
        }
        
        return res;
    }
}
```