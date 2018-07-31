package No19;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/30 12:43
 * @Description:
 *
 * 剑指 offer - 19 树的子结构
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            if (ValidSubtree(root1, root2)) {
                return true;
            }
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean ValidSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        else if (root1 == null) {
            return false;
        }
        else if (root1.val != root2.val) {
            return false;
        }
        return ValidSubtree(root1.left, root2.left) && ValidSubtree(root1.right, root2.right);
    }

    /**
     * 根据水平遍历序列建立二叉树
     */
    public TreeNode buildTree(char[] level) {
        if (level == null || level.length == 0 || level[0] == '#') {
            return null;
        }

        TreeNode root = new TreeNode(level[0] - '0');
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);

        for (int i  = 1; i < level.length; ++i) {
            TreeNode parent = list.poll();
            if (level[i] != '#') {
                parent.left = new TreeNode(level[i] - '0');
                list.add(parent.left);
            }
            if (++i < level.length && level[i] != '#') {
                parent.right = new TreeNode(level[i] - '0');
                list.add(parent.right);
            }
        }

        return root;
    }

    public static void main(String[] arggs) {

        Solution s = new Solution();

        char[] a = {'8','8','7','9','2','#','#','#','#','4','7'}, b = {'8','9','2'};

        TreeNode tree1 = s.buildTree(a);
        TreeNode tree2 = s.buildTree(b);

        boolean res = new Solution().HasSubtree(tree1, tree2);
    }
}
