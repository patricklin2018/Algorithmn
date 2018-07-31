## 21 - 顺时针打印矩阵

### 题目描述

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下`4 X 4`矩阵： 
```
1  2  3  4 
5  6  7  8 
9  10 11 12 
13 14 15 16 
```
则依次打印出数字 `1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10`.

### 思路

程序主要分为两个部分，
第一个部分负责计算出遍历圈数，以及每一圈的起始和停止位置(`left, top, right, bottom)`；
第二个部分则负责在给定起始和停止位置数据下，对矩阵中的该圈进行遍历。

其中，遍历圈数的计算为：

`int cycles = Math.min ((matrix.length + 1) / 2, (matrix[0].length + 1) / 2);`

其次，遍历的过程为：

```java
// 向右
for (int i = left; i <= right; ++i) {
    container.add(matrix[top][i]);
}
// 向下
for (int i = top + 1; i <= bottom; ++i) {
    container.add(matrix[i][right]);
}
// 向左
for (int i = right - 1; top != bottom && i >= left; --i) {
    container.add(matrix[bottom][i]);
}
// 向上
for (int i = bottom - 1; left != right && i > top; --i) {
    container.add(matrix[i][left]);
}
```

需要注意在向左和向上移动的过程分别添加 `top != bottom` 和 `left != right`，防止重复遍历打印问题。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null || matrix[0] == null) {
            return res;
        }

        int cycles = Math.min ((matrix.length + 1) / 2, (matrix[0].length + 1) / 2);
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        for (int i = 0; i < cycles; ++i) {
            printCycle(res, matrix, i, i, c - i, r - i);
        }

        return res;
    }

    public void printCycle(ArrayList<Integer> container, int[][] matrix, int left, int top, int right, int bottom) {
        // 向右
        for (int i = left; i <= right; ++i) {
            container.add(matrix[top][i]);
        }
        // 向下
        for (int i = top + 1; i <= bottom; ++i) {
            container.add(matrix[i][right]);
        }
        // 向左
        for (int i = right - 1; top != bottom && i >= left; --i) {
            container.add(matrix[bottom][i]);
        }
        // 向上
        for (int i = bottom - 1; left != right && i > top; --i) {
            container.add(matrix[i][left]);
        }
    }
}
```