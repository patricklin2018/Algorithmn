## 05 - 从尾到头打印链表

### 题目描述

输入一个链表，按链表值从尾到头的顺序返回一个 `ArrayList`。

### 思路

方法1： 采用一个栈来记录链表取出的值，然后从栈顶一一取出存到 `ArrayList`。

方法2： 采用递归，代码如下所示。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        if (listNode == null) {
            return res;
        }

        printListFromTailToHead(listNode.next, res);
        res.add(listNode.val);

        return res;
    }

    public void printListFromTailToHead(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null) {
            return;
        }

        printListFromTailToHead(listNode.next, list);
        list.add(listNode.val);
    }
}
```