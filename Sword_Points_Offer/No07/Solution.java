package No07;

import java.util.Stack;

/**
 * @author PatrickLin
 * @date 2018/7/26 18:20
 * @description
 *
 * 剑指 Offer - 07 用两个栈实现队列
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 **/
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("列表为空");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.push(4);
        s.pop();
        s.push(5);
        s.pop();
        s.pop();
    }
}
