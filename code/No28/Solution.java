package No28;

/**
 * @Author: patrick-mac
 * @Date: 2018/8/13 23:59
 * @Description:
 *
 * 剑指 offer - 28 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode lst = Convert(pRootOfTree, null);

        // 通过遍历找到头
        while (lst.left != null) {
            lst = lst.left;
        }

        return lst;
    }

    public TreeNode Convert(TreeNode root, TreeNode lst) {
        // 对左子树不为空，则进行转换，得到转换后最后一个结点
        if (root.left != null) {
            lst = Convert(root.left, lst);
        }
        // 链接双向链表的最后位置
        root.left = lst;
        if (lst != null) {
            lst.right = root;
        }

        lst = root;

        // 若右子树不为空，则进行转换，得到转换后最后一个结点
        if (root.right != null) {
            lst = Convert(root.right, lst);
        }

        return lst;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
