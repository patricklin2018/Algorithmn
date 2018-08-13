## 26 - 二叉树中和为某一值的路径

### 题目描述

输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(**注意:** 在返回值的list中，数组长度大的数组靠前)

### 思路

利用 `ArrayList<ArrayList<Integer>> res = new ArrayList<>();` 存储结果，如果符合路径定义，则添加进 `res`。

利用 `ArrayList<Integer> p = new ArrayList<>();` 作为辅助数组，存储当前递归遍历的路径，递归处理过程如下：

```
辅助数组 p 记录的当前流经加入当前结点

1，和小于 target，
      若 left != null，则递归左子树
      若 right != null，则递归右子树
2，和等于 target，且 left == null && right == null，则 res.add (当前路径)

辅助数组 p 记录的当前路径退出当前结点
```

### 代码
[代码-JAVA](Solution.java)

```java
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
}
```