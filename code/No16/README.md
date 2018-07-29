## 16 - 链表中倒数第 k 个结点

### 题目描述

输入一个链表，输出该链表中倒数第k个结点。

### 思路

设置两个指针，一个正常移动，一个比前一个指针放慢 k 步移动。


### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }

        ListNode pre = head, aft = head;
        while (pre != null) {
            if (k > 0) {
                k--;
            }
            else {
                aft = aft.next;
            }
            pre = pre.next;
        }
        return k >= 1 ? null : aft;
    }
}
```