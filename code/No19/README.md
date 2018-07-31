## 19 - 树的子结构

### 题目描述

输入两棵二叉树`A`，`B`，判断 `B` 是不是 `A` 的子结构。（ps：我们约定空树不是任意一个树的子结构）

### 思路

流程主要分为部分，一部分主要负责二叉树的遍历，另一部分则验证两个二叉树是否相等。

遍历：

```java
1，如果 roo1.val == root2.val 则验证(root1, root2)
2，否则遍历子树， 验证 (root1.left, root2) || (root1.right, root2)
```
验证：

```java
1，如果 root2 == null，则返回 true
2，如果 root1 == null || root1.val ！= root2.val，则返回 false
1，否则，验证 (root1.left, root2.left) && (root1.right, root2.right)
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
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
}
```