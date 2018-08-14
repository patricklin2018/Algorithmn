## 27 - 二叉搜索树与双向链表

### 题目描述

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

### 思路

递归处理左右子树，同时记录该双向链表的最后位置，递归所处理的结点的左结点链接向双向链表的最后位置。

### 代码
[代码-JAVA](Solution.java)

```java
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
}
```