## 06 - 重建二叉树

### 题目描述

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列`{1,2,4,7,3,5,6,8}`和中序遍历序列`{4,7,2,1,5,3,8,6}`，则重建二叉树并返回。

### 思路

前序 + 中序 构建二叉树：

由于前序总是会先访问根节点再访问该根节点的左子树和右子树，而中序总是会先访问左子树，再访问根节点和右子树。
因此，结合两者，通过前序确认根节点，随后根据中序顺序，先于该根节点必为该节点的左子树，而后于该节点的必为该节点的右子树。如此循环，最终确定整科树。

以前序 `{1,2,4,7,3,5,6,8}` 和中序遍历序列 `{4,7,2,1,5,3,8,6}` 为例子。

```java
1，通过前序知根为 1，查找 1 在中序的位置
2，中序 1 的左边 {4, 7, 2} 为左子树部分，与对应数量的前序序列 {2, 4, 7} 进入递归，构建该子树
3，中序 1 的右边 {5, 3, 8, 6} 为右子树部分，与对应数量的前序序列 {3, 5, 6, 8} 进入递归，构建该子树
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
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
}
```