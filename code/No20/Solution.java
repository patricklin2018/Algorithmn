package No20;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/31 18:33
 * @Description:
 *
 * 剑指 offer - 20 二叉树的镜像
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
