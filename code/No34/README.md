## 34 - 把数组排成最小的数

### 题目描述

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组`{3，32，321}`，则打印出这三个数字能排成的最小数字为`321323`。

### 思路

思路就是对这些元素进行排序，排序的标准是：

假设 a = 3, b = 32，

那么将这两个数拼接， ab = 332，ba = 323， ba < ab，因此 b 排在前面，因为这样拼接起来得到的数更小。

如果 ab < ba，那么 a 排在前面；如果 ab == ba 则 a = b。

整理一下：

```
假设两个数 a b，那么排序标准是：
ab > ba， 那么 a > b
ab < ba， 那么 a < b
ab == ba， 那么 a = b
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int e : numbers) {
            list.add(e);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String ab = o1 + "" + o2;
                String ba = o2 + "" + o1;
                return ab.compareTo(ba);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer e : list) {
            sb.append(e.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        new Solution().PrintMinNumber(nums);
    }
}
```