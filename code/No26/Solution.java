package No26;

import java.util.ArrayList;

/**
 * @Author: patrick-mac
 * @Date: 2018/8/13 21:46
 * @Description:
 *
 * 剑指 offer - 26 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> p = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        int residue = target - root.val;
        p.add(root.val);

        if (residue > 0) {
            if (root.left != null) {
                FindPath(root.left, residue);
            }
            if (root.right != null) {
                FindPath(root.right, residue);
            }
        }
        else if (residue == 0 && root.left == null && root.right == null) {
            ArrayList<Integer> path = new ArrayList<>();
            int sz = p.size();
            for (int i = 0; i < sz; ++i) {
                path.add(p.get(i));
            }
            res.add(path);
        }
        p.remove(p.size() - 1);

        return res;
    }

    public static void main(String[] args) {
        // 10,5,12,4,7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        TreeNode left = root.left;
        left.left = new TreeNode(4);
        left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = new Solution().FindPath(root, 22);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
