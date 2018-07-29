## 17 - 反转链表

### 题目描述

输入一个链表，反转链表后，输出新链表的表头。

### 思路

以 `node1 -> node2 -> node3 -> null` 为例，反转过程如下所示：

```java
1. null <- node1 node2 -> node3 -> null
   head -> node2 lst -> node1
   
2. null <- node1 <- node2 node3 -> null
   head -> node3 lst -> node2
   
3. null <- node1 <- node2 <- node3 null
   head -> null lst -> node3
   
4. 返回 lst
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode lst = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = lst;
            lst = head;
            head = tmp;
        }
        return lst;
    }
}
```