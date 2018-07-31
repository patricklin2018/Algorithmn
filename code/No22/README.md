## 22 - 包含 min 函数的栈

### 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min函数（时间复杂度应为`O（1）`）。

### 思路

用两个栈，一个栈正常存储，另一个栈在存储压栈过程中每个当前最小值。

即，数据存储压栈时，如果为最小值，同时压进第二个栈。

出栈时，需要检查该值是否为最小值，如果是，第二个栈也要出栈。
### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {

    // 正常存储
    Stack<Integer> stack1 = new Stack<>();
    // 只压进当前最小值
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty() || stack2.peek() > node) {
            stack2.push(node);
        }
    }

    public void pop() {
        int node = stack1.pop();
        if (node == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
```