package No06;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author PatrickLin
 * @date 2018/7/24 23:40
 * @description
 *
 * 剑指 Offer - 06 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 **/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        // 1. 确定根节点
        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < pre.length; ++i) {
            if (pre[0] == in[i]) {
                // 2. 中序根节点的左边为左子树，进入递归构建子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + i), Arrays.copyOfRange(in, 0, i));
                // 3. 中序根节点的右边为右子树，进入递归构建子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }

        return root;

    }

    public static void main (String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        new Solution().reConstructBinaryTree(pre, in);
    }

}
