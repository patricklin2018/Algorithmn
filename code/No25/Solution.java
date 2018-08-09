package No25;

/**
 * @Author: patrick-mac
 * @Date: 2018/8/9 23:42
 * @Description:
 *
 * 剑指 offer - 25 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequece, int start, int end) {

        if (start >= end) {
            return true;
        }

        // 找到第一个大于最后一个值（即根节点）的数值
        int rightStart = start;
        for (int i = start; i < end && sequece[i] < sequece[end]; ++i) {
            rightStart++;
        }

        // 所有值均比根节点小
        if (rightStart == end) {
            return VerifySquenceOfBST(sequece, start, end - 1);
        }
        else {
            for (int i = rightStart; i < end; ++i) {
                if (sequece[i] < sequece[end]) {
                    return false;
                }
            }

            return VerifySquenceOfBST(sequece, start, rightStart - 1) &&
                    VerifySquenceOfBST(sequece, rightStart, end - 1);
        }
    }

    public static void main (String[] args) {
        int[] seq = {5,4,3,2,1};
        new Solution().VerifySquenceOfBST(seq);
    }
}
