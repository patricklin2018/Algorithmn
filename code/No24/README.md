## 24 - 从上到下打印二叉树

### 题目描述

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

### 思路

借助队列，每次从队列中取出该 level 层的所有节点。而该层节点的数量等于当前该队列的大小。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode tmp = queue.pop();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                res.add(tmp.val);
            }
        }

        return res;
    }

}
```