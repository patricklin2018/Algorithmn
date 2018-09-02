## 17 - 反转链表

### 题目描述

输入一个链表，反转链表后，输出新链表的表头。

### 思路

设置一个临时指针，记住下下个节点，操作当前节点和下一个节点，如此往复。以 `node1 -> node2 -> node3 -> null` 为例，反转过程如下所示：

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

#### 1. 非递归方法

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

#### 2. 递归方法
```java
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        return ReverseList(head, null);  
    }
    
    public ListNode ReverseList(ListNode ptr, ListNode lst) {
        if (ptr.next == null) {
            ptr.next = lst;
            return ptr;
        }
        else {
            ListNode head = ReverseList(ptr.next, ptr);
            ptr.next = lst;
            return head;
        }
    }
}
```