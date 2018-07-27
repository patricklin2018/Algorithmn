## 08 - 旋转数组的最小数字

### 题目描述

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。

**例如**:

数组`{3,4,5,1,2}`为`{1,2,3,4,5}`的一个旋转，该数组的最小值为1。

**NOTE**：给出的所有元素都大于0，若数组大小为0，请返回0。

### 思路

采用二分搜索，`mid = (right - left) / 2 + left`，

对应的值如果大于 `right` 的值，那么左边区间必定有序，则最小值在右边区间。

反之，则右边区间必定有序，最小值在左边区间。

因此，步骤可以概括为：

```
1. 计算 mid
2.1 如果 ary[mid] > ary[right]，left = mid
2.2 否则 right = mid
3. 回到 1.
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public int minNumberInRotateArray(int [] array) throws Exception {
        if (array == null) {
            throw new Exception("数组为空");
        }

        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (array[mid] >= array[right]) {
                // 左边有序
                left = mid;
            }
            else {
                // 右边有序
                right = mid;
            }
        }

        return array[left] <= array[right] ? array[left] : array[right];
    }
}
```