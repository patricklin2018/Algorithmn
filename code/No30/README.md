## 30 - 数组中次数出现超过一半的数字

### 题目描述

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组`{1,2,3,2,2,2,5,4,2}`。
由于数字`2`在数组中出现了5次，超过数组长度的一半，因此输出`2`。如果不存在则输出`0`。

### 思路

可以采用 `HashMap` 记录出现次数；

也可通过设置一个记录器 `int counter = 1`，从第一个元素向后，若相同则 `+1`，若不相同则 `-1`，当 `counter == 0` 时，改变所记录的元素值。
当然，该遍历过程只能得到出现次数最多的元素，最后还需要验证该元素出现次数是否超过一半。

这里采用排序的方法，排序后，若存在出现次数超过一半的元素，那么该值必然处于中位数。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int res = array[array.length / 2];

        // 验证 res
        int counter = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == res) {
                counter++;
            }
        }

        if (counter > array.length / 2) {
            return res;
        }
        else {
            return 0;
        }
    }
}
```