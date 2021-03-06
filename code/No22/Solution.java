package No22;

import java.util.Stack;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/31 23:25
 * @Description:
 *
 * 剑指 offer - 22 包含 min 函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数（时间复杂度应为O（1））。
 *
 */
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
