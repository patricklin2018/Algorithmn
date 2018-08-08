package No23;

import java.util.Stack;

/**
 * @Author: patrick-mac
 * @Date: 2018/8/3 15:22
 * @Description:
 *
 * 剑指 offer - 23 栈的压入、弹出顺序
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
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
