## 23 - 栈的压入、弹出顺序

### 题目描述

输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列`1,2,3,4,5`是某栈的压入顺序，序列`4,5,3,2,1`是该压栈序列对应的一个弹出序列，但`4,3,5,1,2`就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）

### 思路

按照压入顺序，将元素一一压入栈，每压一个元素，就进行一次与弹出序列对比，若符合顺序直接弹出，直到不符，继续压入下一个元素。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        // 指向 pop 序列当前检查到的位置
        int index = 0;

        for (int i = 0; i < pushA.length; ++i) {
            stack.push(pushA[i]);
            // 检查序列
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
```