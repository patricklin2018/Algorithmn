## 31 - 最小的 k 个数

### 题目描述

输入`n`个整数，找出其中最小的`K`个数。例如输入`4,5,1,6,2,7,3,8`这`8`个数字，则最小的`4`个数字是`1,2,3,4`。

### 思路

通过 Heapify 将数组构建成最小堆，提取最小值。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k < 0 || k > input.length) {
            return res;
        }

        for (int i = (input.length - 2) / 2; i >= 0; --i) {
            // 通过 shiftDown 把该数组构建成最小堆
            shiftDown(input, i);
        }

        while (k-- > 0) {
            res.add(extractMin(input));
        }

        return res;
    }

    public void shiftDown(int[] ary, int i) {
        assert i >= 0 && i <= ary.length - 1;

        int tmp = ary[i];
        while (i * 2 + 1 < ary.length) {
            int j = i * 2 + 1;
            // 如果右子树的值更小
            if (j + 1 < ary.length && ary[j + 1] < ary[j]) {
                j++;
            }
            if (tmp < ary[j]) {
                break;
            }
            ary[i] = ary[j];
            i = j;
        }
        ary[i] = tmp;
    }

    public int extractMin(int[] ary) {
        int max = ary[0];
        ary[0] = Integer.MAX_VALUE;
        shiftDown(ary, 0);
        return max;
    }
}
```