## 03 - 二维数组的查找

### 题目描述

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

### 思路

由于该数组的结构：右边比左边大，下边比上边大。

因此，如果从左上角（0, 0）开始遍历，就会造成不论向下调整还是向右调整都是变大的困境。

故而，可以从右上角（或左下角）开始遍历，大了向左，小了向下。

步骤如下：

```java
1. 以数组的右上角处作为初始点开始遍历。
2. 如果该值 == target 则返回 true
3. 否则，如果该值 > target，则向左调整
        如果该值 < target，则向下调整 
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public boolean Find(int target, int [][] array) {

        if (array == null) {
            return false;
        }

        int r = 0, c = array[0].length - 1;
        while (c >= 0 && r < array.length) {

            if (array[r][c] == target) {
                return true;
            }
            else if (array[r][c] > target) {
                // 大于目标时，向左调整
                c--;
            }
            else {
                // 小于目标时，向下调整
                r++;
            }
        }

        return false;
    }
}
```